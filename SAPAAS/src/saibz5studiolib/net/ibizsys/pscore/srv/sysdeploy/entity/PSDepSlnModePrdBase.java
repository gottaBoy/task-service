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
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnASGroup;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnMode;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnPrd;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnASGroupService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnModeService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnPrdService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnModePrdBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDepSlnModePrdBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEPSLNASGROUPID = "PSDEPSLNASGRPID";
    public static final String FIELD_PSDEPSLNASGROUPNAME = "PSDEPSLNASGRPNAME";
    public static final String FIELD_PSDEPSLNMODEID = "PSDEPSLNMODEID";
    public static final String FIELD_PSDEPSLNMODENAME = "PSDEPSLNMODENAME";
    public static final String FIELD_PSDEPSLNMODEPRDID = "PSDEPSLNMODEPRDID";
    public static final String FIELD_PSDEPSLNMODEPRDNAME = "PSDEPSLNMODEPRDNAME";
    public static final String FIELD_PSDEPSLNPRDID = "PSDEPSLNPRDID";
    public static final String FIELD_PSDEPSLNPRDNAME = "PSDEPSLNPRDNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDEPSLNASGROUPID = 3;
    private static final int INDEX_PSDEPSLNASGROUPNAME = 4;
    private static final int INDEX_PSDEPSLNMODEID = 5;
    private static final int INDEX_PSDEPSLNMODENAME = 6;
    private static final int INDEX_PSDEPSLNMODEPRDID = 7;
    private static final int INDEX_PSDEPSLNMODEPRDNAME = 8;
    private static final int INDEX_PSDEPSLNPRDID = 9;
    private static final int INDEX_PSDEPSLNPRDNAME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDepSlnModePrdBase proxyPSDepSlnModePrdBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdepslnasgroupidDirtyFlag = false;
    private boolean psdepslnasgroupnameDirtyFlag = false;
    private boolean psdepslnmodeidDirtyFlag = false;
    private boolean psdepslnmodenameDirtyFlag = false;
    private boolean psdepslnmodeprdidDirtyFlag = false;
    private boolean psdepslnmodeprdnameDirtyFlag = false;
    private boolean psdepslnprdidDirtyFlag = false;
    private boolean psdepslnprdnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdepslnasgroupid")
    private String psdepslnasgroupid;
    @Column(name="psdepslnasgroupname")
    private String psdepslnasgroupname;
    @Column(name="psdepslnmodeid")
    private String psdepslnmodeid;
    @Column(name="psdepslnmodename")
    private String psdepslnmodename;
    @Column(name="psdepslnmodeprdid")
    private String psdepslnmodeprdid;
    @Column(name="psdepslnmodeprdname")
    private String psdepslnmodeprdname;
    @Column(name="psdepslnprdid")
    private String psdepslnprdid;
    @Column(name="psdepslnprdname")
    private String psdepslnprdname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDepSlnASGroupLock = new Integer(1);
    private PSDepSlnASGroup psdepslnasgroup = null;
    private Integer objPSDepSlnModeLock = new Integer(1);
    private PSDepSlnMode psdepslnmode = null;
    private Integer objPSDepSlnPrdLock = new Integer(1);
    private PSDepSlnPrd psdepslnprd = null;

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

    public void setPSDepSlnASGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnASGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnasgroupid = string;
        this.psdepslnasgroupidDirtyFlag = true;
    }

    public String getPSDepSlnASGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnASGroupId();
        }
        return this.psdepslnasgroupid;
    }

    public boolean isPSDepSlnASGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnASGroupIdDirty();
        }
        return this.psdepslnasgroupidDirtyFlag;
    }

    public void resetPSDepSlnASGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnASGroupId();
            return;
        }
        this.psdepslnasgroupidDirtyFlag = false;
        this.psdepslnasgroupid = null;
    }

    public void setPSDepSlnASGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnASGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnasgroupname = string;
        this.psdepslnasgroupnameDirtyFlag = true;
    }

    public String getPSDepSlnASGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnASGroupName();
        }
        return this.psdepslnasgroupname;
    }

    public boolean isPSDepSlnASGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnASGroupNameDirty();
        }
        return this.psdepslnasgroupnameDirtyFlag;
    }

    public void resetPSDepSlnASGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnASGroupName();
            return;
        }
        this.psdepslnasgroupnameDirtyFlag = false;
        this.psdepslnasgroupname = null;
    }

    public void setPSDepSlnModeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnModeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnmodeid = string;
        this.psdepslnmodeidDirtyFlag = true;
    }

    public String getPSDepSlnModeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnModeId();
        }
        return this.psdepslnmodeid;
    }

    public boolean isPSDepSlnModeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnModeIdDirty();
        }
        return this.psdepslnmodeidDirtyFlag;
    }

    public void resetPSDepSlnModeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnModeId();
            return;
        }
        this.psdepslnmodeidDirtyFlag = false;
        this.psdepslnmodeid = null;
    }

    public void setPSDepSlnModeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnModeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnmodename = string;
        this.psdepslnmodenameDirtyFlag = true;
    }

    public String getPSDepSlnModeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnModeName();
        }
        return this.psdepslnmodename;
    }

    public boolean isPSDepSlnModeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnModeNameDirty();
        }
        return this.psdepslnmodenameDirtyFlag;
    }

    public void resetPSDepSlnModeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnModeName();
            return;
        }
        this.psdepslnmodenameDirtyFlag = false;
        this.psdepslnmodename = null;
    }

    public void setPSDepSlnModePrdId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnModePrdId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnmodeprdid = string;
        this.psdepslnmodeprdidDirtyFlag = true;
    }

    public String getPSDepSlnModePrdId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnModePrdId();
        }
        return this.psdepslnmodeprdid;
    }

    public boolean isPSDepSlnModePrdIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnModePrdIdDirty();
        }
        return this.psdepslnmodeprdidDirtyFlag;
    }

    public void resetPSDepSlnModePrdId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnModePrdId();
            return;
        }
        this.psdepslnmodeprdidDirtyFlag = false;
        this.psdepslnmodeprdid = null;
    }

    public void setPSDepSlnModePrdName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnModePrdName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnmodeprdname = string;
        this.psdepslnmodeprdnameDirtyFlag = true;
    }

    public String getPSDepSlnModePrdName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnModePrdName();
        }
        return this.psdepslnmodeprdname;
    }

    public boolean isPSDepSlnModePrdNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnModePrdNameDirty();
        }
        return this.psdepslnmodeprdnameDirtyFlag;
    }

    public void resetPSDepSlnModePrdName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnModePrdName();
            return;
        }
        this.psdepslnmodeprdnameDirtyFlag = false;
        this.psdepslnmodeprdname = null;
    }

    public void setPSDepSlnPrdId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnPrdId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnprdid = string;
        this.psdepslnprdidDirtyFlag = true;
    }

    public String getPSDepSlnPrdId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnPrdId();
        }
        return this.psdepslnprdid;
    }

    public boolean isPSDepSlnPrdIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnPrdIdDirty();
        }
        return this.psdepslnprdidDirtyFlag;
    }

    public void resetPSDepSlnPrdId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnPrdId();
            return;
        }
        this.psdepslnprdidDirtyFlag = false;
        this.psdepslnprdid = null;
    }

    public void setPSDepSlnPrdName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnPrdName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnprdname = string;
        this.psdepslnprdnameDirtyFlag = true;
    }

    public String getPSDepSlnPrdName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnPrdName();
        }
        return this.psdepslnprdname;
    }

    public boolean isPSDepSlnPrdNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnPrdNameDirty();
        }
        return this.psdepslnprdnameDirtyFlag;
    }

    public void resetPSDepSlnPrdName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnPrdName();
            return;
        }
        this.psdepslnprdnameDirtyFlag = false;
        this.psdepslnprdname = null;
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
        PSDepSlnModePrdBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDepSlnModePrdBase pSDepSlnModePrdBase) {
        pSDepSlnModePrdBase.resetCreateDate();
        pSDepSlnModePrdBase.resetCreateMan();
        pSDepSlnModePrdBase.resetMemo();
        pSDepSlnModePrdBase.resetPSDepSlnASGroupId();
        pSDepSlnModePrdBase.resetPSDepSlnASGroupName();
        pSDepSlnModePrdBase.resetPSDepSlnModeId();
        pSDepSlnModePrdBase.resetPSDepSlnModeName();
        pSDepSlnModePrdBase.resetPSDepSlnModePrdId();
        pSDepSlnModePrdBase.resetPSDepSlnModePrdName();
        pSDepSlnModePrdBase.resetPSDepSlnPrdId();
        pSDepSlnModePrdBase.resetPSDepSlnPrdName();
        pSDepSlnModePrdBase.resetUpdateDate();
        pSDepSlnModePrdBase.resetUpdateMan();
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
        if (!bl || this.isPSDepSlnASGroupIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNASGROUPID, this.getPSDepSlnASGroupId());
        }
        if (!bl || this.isPSDepSlnASGroupNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNASGROUPNAME, this.getPSDepSlnASGroupName());
        }
        if (!bl || this.isPSDepSlnModeIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNMODEID, this.getPSDepSlnModeId());
        }
        if (!bl || this.isPSDepSlnModeNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNMODENAME, this.getPSDepSlnModeName());
        }
        if (!bl || this.isPSDepSlnModePrdIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNMODEPRDID, this.getPSDepSlnModePrdId());
        }
        if (!bl || this.isPSDepSlnModePrdNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNMODEPRDNAME, this.getPSDepSlnModePrdName());
        }
        if (!bl || this.isPSDepSlnPrdIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNPRDID, this.getPSDepSlnPrdId());
        }
        if (!bl || this.isPSDepSlnPrdNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNPRDNAME, this.getPSDepSlnPrdName());
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
        return PSDepSlnModePrdBase.get(this, n);
    }

    private static Object get(PSDepSlnModePrdBase pSDepSlnModePrdBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnModePrdBase.getCreateDate();
            }
            case 1: {
                return pSDepSlnModePrdBase.getCreateMan();
            }
            case 2: {
                return pSDepSlnModePrdBase.getMemo();
            }
            case 3: {
                return pSDepSlnModePrdBase.getPSDepSlnASGroupId();
            }
            case 4: {
                return pSDepSlnModePrdBase.getPSDepSlnASGroupName();
            }
            case 5: {
                return pSDepSlnModePrdBase.getPSDepSlnModeId();
            }
            case 6: {
                return pSDepSlnModePrdBase.getPSDepSlnModeName();
            }
            case 7: {
                return pSDepSlnModePrdBase.getPSDepSlnModePrdId();
            }
            case 8: {
                return pSDepSlnModePrdBase.getPSDepSlnModePrdName();
            }
            case 9: {
                return pSDepSlnModePrdBase.getPSDepSlnPrdId();
            }
            case 10: {
                return pSDepSlnModePrdBase.getPSDepSlnPrdName();
            }
            case 11: {
                return pSDepSlnModePrdBase.getUpdateDate();
            }
            case 12: {
                return pSDepSlnModePrdBase.getUpdateMan();
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
        PSDepSlnModePrdBase.set(this, n, object);
    }

    private static void set(PSDepSlnModePrdBase pSDepSlnModePrdBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnModePrdBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDepSlnModePrdBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDepSlnModePrdBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDepSlnModePrdBase.setPSDepSlnASGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDepSlnModePrdBase.setPSDepSlnASGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDepSlnModePrdBase.setPSDepSlnModeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDepSlnModePrdBase.setPSDepSlnModeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDepSlnModePrdBase.setPSDepSlnModePrdId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDepSlnModePrdBase.setPSDepSlnModePrdName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDepSlnModePrdBase.setPSDepSlnPrdId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDepSlnModePrdBase.setPSDepSlnPrdName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDepSlnModePrdBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSDepSlnModePrdBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDepSlnModePrdBase.isNull(this, n);
    }

    private static boolean isNull(PSDepSlnModePrdBase pSDepSlnModePrdBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnModePrdBase.getCreateDate() == null;
            }
            case 1: {
                return pSDepSlnModePrdBase.getCreateMan() == null;
            }
            case 2: {
                return pSDepSlnModePrdBase.getMemo() == null;
            }
            case 3: {
                return pSDepSlnModePrdBase.getPSDepSlnASGroupId() == null;
            }
            case 4: {
                return pSDepSlnModePrdBase.getPSDepSlnASGroupName() == null;
            }
            case 5: {
                return pSDepSlnModePrdBase.getPSDepSlnModeId() == null;
            }
            case 6: {
                return pSDepSlnModePrdBase.getPSDepSlnModeName() == null;
            }
            case 7: {
                return pSDepSlnModePrdBase.getPSDepSlnModePrdId() == null;
            }
            case 8: {
                return pSDepSlnModePrdBase.getPSDepSlnModePrdName() == null;
            }
            case 9: {
                return pSDepSlnModePrdBase.getPSDepSlnPrdId() == null;
            }
            case 10: {
                return pSDepSlnModePrdBase.getPSDepSlnPrdName() == null;
            }
            case 11: {
                return pSDepSlnModePrdBase.getUpdateDate() == null;
            }
            case 12: {
                return pSDepSlnModePrdBase.getUpdateMan() == null;
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
        return PSDepSlnModePrdBase.contains(this, n);
    }

    private static boolean contains(PSDepSlnModePrdBase pSDepSlnModePrdBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnModePrdBase.isCreateDateDirty();
            }
            case 1: {
                return pSDepSlnModePrdBase.isCreateManDirty();
            }
            case 2: {
                return pSDepSlnModePrdBase.isMemoDirty();
            }
            case 3: {
                return pSDepSlnModePrdBase.isPSDepSlnASGroupIdDirty();
            }
            case 4: {
                return pSDepSlnModePrdBase.isPSDepSlnASGroupNameDirty();
            }
            case 5: {
                return pSDepSlnModePrdBase.isPSDepSlnModeIdDirty();
            }
            case 6: {
                return pSDepSlnModePrdBase.isPSDepSlnModeNameDirty();
            }
            case 7: {
                return pSDepSlnModePrdBase.isPSDepSlnModePrdIdDirty();
            }
            case 8: {
                return pSDepSlnModePrdBase.isPSDepSlnModePrdNameDirty();
            }
            case 9: {
                return pSDepSlnModePrdBase.isPSDepSlnPrdIdDirty();
            }
            case 10: {
                return pSDepSlnModePrdBase.isPSDepSlnPrdNameDirty();
            }
            case 11: {
                return pSDepSlnModePrdBase.isUpdateDateDirty();
            }
            case 12: {
                return pSDepSlnModePrdBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDepSlnModePrdBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDepSlnModePrdBase pSDepSlnModePrdBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDepSlnModePrdBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDepSlnModePrdBase.getJSONValue((Object)pSDepSlnModePrdBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDepSlnModePrdBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDepSlnModePrdBase.getJSONValue((Object)pSDepSlnModePrdBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDepSlnModePrdBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDepSlnModePrdBase.getJSONValue((Object)pSDepSlnModePrdBase.getMemo()), (boolean)false);
        }
        if (bl || pSDepSlnModePrdBase.getPSDepSlnASGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnasgrpid", (Object)PSDepSlnModePrdBase.getJSONValue((Object)pSDepSlnModePrdBase.getPSDepSlnASGroupId()), (boolean)false);
        }
        if (bl || pSDepSlnModePrdBase.getPSDepSlnASGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnasgrpname", (Object)PSDepSlnModePrdBase.getJSONValue((Object)pSDepSlnModePrdBase.getPSDepSlnASGroupName()), (boolean)false);
        }
        if (bl || pSDepSlnModePrdBase.getPSDepSlnModeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnmodeid", (Object)PSDepSlnModePrdBase.getJSONValue((Object)pSDepSlnModePrdBase.getPSDepSlnModeId()), (boolean)false);
        }
        if (bl || pSDepSlnModePrdBase.getPSDepSlnModeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnmodename", (Object)PSDepSlnModePrdBase.getJSONValue((Object)pSDepSlnModePrdBase.getPSDepSlnModeName()), (boolean)false);
        }
        if (bl || pSDepSlnModePrdBase.getPSDepSlnModePrdId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnmodeprdid", (Object)PSDepSlnModePrdBase.getJSONValue((Object)pSDepSlnModePrdBase.getPSDepSlnModePrdId()), (boolean)false);
        }
        if (bl || pSDepSlnModePrdBase.getPSDepSlnModePrdName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnmodeprdname", (Object)PSDepSlnModePrdBase.getJSONValue((Object)pSDepSlnModePrdBase.getPSDepSlnModePrdName()), (boolean)false);
        }
        if (bl || pSDepSlnModePrdBase.getPSDepSlnPrdId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnprdid", (Object)PSDepSlnModePrdBase.getJSONValue((Object)pSDepSlnModePrdBase.getPSDepSlnPrdId()), (boolean)false);
        }
        if (bl || pSDepSlnModePrdBase.getPSDepSlnPrdName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnprdname", (Object)PSDepSlnModePrdBase.getJSONValue((Object)pSDepSlnModePrdBase.getPSDepSlnPrdName()), (boolean)false);
        }
        if (bl || pSDepSlnModePrdBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDepSlnModePrdBase.getJSONValue((Object)pSDepSlnModePrdBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDepSlnModePrdBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDepSlnModePrdBase.getJSONValue((Object)pSDepSlnModePrdBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDepSlnModePrdBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDepSlnModePrdBase pSDepSlnModePrdBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDepSlnModePrdBase.getCreateDate() != null) {
            object = pSDepSlnModePrdBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnModePrdBase.getCreateMan() != null) {
            object = pSDepSlnModePrdBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnModePrdBase.getMemo() != null) {
            object = pSDepSlnModePrdBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnModePrdBase.getPSDepSlnASGroupId() != null) {
            object = pSDepSlnModePrdBase.getPSDepSlnASGroupId();
            xmlNode.setAttribute("PSDEPSLNASGROUPID", object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnModePrdBase.getPSDepSlnASGroupName() != null) {
            object = pSDepSlnModePrdBase.getPSDepSlnASGroupName();
            xmlNode.setAttribute("PSDEPSLNASGROUPNAME", object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnModePrdBase.getPSDepSlnModeId() != null) {
            object = pSDepSlnModePrdBase.getPSDepSlnModeId();
            xmlNode.setAttribute(FIELD_PSDEPSLNMODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnModePrdBase.getPSDepSlnModeName() != null) {
            object = pSDepSlnModePrdBase.getPSDepSlnModeName();
            xmlNode.setAttribute(FIELD_PSDEPSLNMODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnModePrdBase.getPSDepSlnModePrdId() != null) {
            object = pSDepSlnModePrdBase.getPSDepSlnModePrdId();
            xmlNode.setAttribute(FIELD_PSDEPSLNMODEPRDID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnModePrdBase.getPSDepSlnModePrdName() != null) {
            object = pSDepSlnModePrdBase.getPSDepSlnModePrdName();
            xmlNode.setAttribute(FIELD_PSDEPSLNMODEPRDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnModePrdBase.getPSDepSlnPrdId() != null) {
            object = pSDepSlnModePrdBase.getPSDepSlnPrdId();
            xmlNode.setAttribute(FIELD_PSDEPSLNPRDID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnModePrdBase.getPSDepSlnPrdName() != null) {
            object = pSDepSlnModePrdBase.getPSDepSlnPrdName();
            xmlNode.setAttribute(FIELD_PSDEPSLNPRDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnModePrdBase.getUpdateDate() != null) {
            object = pSDepSlnModePrdBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnModePrdBase.getUpdateMan() != null) {
            object = pSDepSlnModePrdBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDepSlnModePrdBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDepSlnModePrdBase pSDepSlnModePrdBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDepSlnModePrdBase.isCreateDateDirty() && (bl || pSDepSlnModePrdBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDepSlnModePrdBase.getCreateDate());
        }
        if (pSDepSlnModePrdBase.isCreateManDirty() && (bl || pSDepSlnModePrdBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDepSlnModePrdBase.getCreateMan());
        }
        if (pSDepSlnModePrdBase.isMemoDirty() && (bl || pSDepSlnModePrdBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDepSlnModePrdBase.getMemo());
        }
        if (pSDepSlnModePrdBase.isPSDepSlnASGroupIdDirty() && (bl || pSDepSlnModePrdBase.getPSDepSlnASGroupId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNASGROUPID, (Object)pSDepSlnModePrdBase.getPSDepSlnASGroupId());
        }
        if (pSDepSlnModePrdBase.isPSDepSlnASGroupNameDirty() && (bl || pSDepSlnModePrdBase.getPSDepSlnASGroupName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNASGROUPNAME, (Object)pSDepSlnModePrdBase.getPSDepSlnASGroupName());
        }
        if (pSDepSlnModePrdBase.isPSDepSlnModeIdDirty() && (bl || pSDepSlnModePrdBase.getPSDepSlnModeId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNMODEID, (Object)pSDepSlnModePrdBase.getPSDepSlnModeId());
        }
        if (pSDepSlnModePrdBase.isPSDepSlnModeNameDirty() && (bl || pSDepSlnModePrdBase.getPSDepSlnModeName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNMODENAME, (Object)pSDepSlnModePrdBase.getPSDepSlnModeName());
        }
        if (pSDepSlnModePrdBase.isPSDepSlnModePrdIdDirty() && (bl || pSDepSlnModePrdBase.getPSDepSlnModePrdId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNMODEPRDID, (Object)pSDepSlnModePrdBase.getPSDepSlnModePrdId());
        }
        if (pSDepSlnModePrdBase.isPSDepSlnModePrdNameDirty() && (bl || pSDepSlnModePrdBase.getPSDepSlnModePrdName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNMODEPRDNAME, (Object)pSDepSlnModePrdBase.getPSDepSlnModePrdName());
        }
        if (pSDepSlnModePrdBase.isPSDepSlnPrdIdDirty() && (bl || pSDepSlnModePrdBase.getPSDepSlnPrdId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNPRDID, (Object)pSDepSlnModePrdBase.getPSDepSlnPrdId());
        }
        if (pSDepSlnModePrdBase.isPSDepSlnPrdNameDirty() && (bl || pSDepSlnModePrdBase.getPSDepSlnPrdName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNPRDNAME, (Object)pSDepSlnModePrdBase.getPSDepSlnPrdName());
        }
        if (pSDepSlnModePrdBase.isUpdateDateDirty() && (bl || pSDepSlnModePrdBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDepSlnModePrdBase.getUpdateDate());
        }
        if (pSDepSlnModePrdBase.isUpdateManDirty() && (bl || pSDepSlnModePrdBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDepSlnModePrdBase.getUpdateMan());
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
        return PSDepSlnModePrdBase.remove(this, n);
    }

    private static boolean remove(PSDepSlnModePrdBase pSDepSlnModePrdBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnModePrdBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDepSlnModePrdBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDepSlnModePrdBase.resetMemo();
                return true;
            }
            case 3: {
                pSDepSlnModePrdBase.resetPSDepSlnASGroupId();
                return true;
            }
            case 4: {
                pSDepSlnModePrdBase.resetPSDepSlnASGroupName();
                return true;
            }
            case 5: {
                pSDepSlnModePrdBase.resetPSDepSlnModeId();
                return true;
            }
            case 6: {
                pSDepSlnModePrdBase.resetPSDepSlnModeName();
                return true;
            }
            case 7: {
                pSDepSlnModePrdBase.resetPSDepSlnModePrdId();
                return true;
            }
            case 8: {
                pSDepSlnModePrdBase.resetPSDepSlnModePrdName();
                return true;
            }
            case 9: {
                pSDepSlnModePrdBase.resetPSDepSlnPrdId();
                return true;
            }
            case 10: {
                pSDepSlnModePrdBase.resetPSDepSlnPrdName();
                return true;
            }
            case 11: {
                pSDepSlnModePrdBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSDepSlnModePrdBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSlnASGroup getPSDepSlnASGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnASGroup();
        }
        if (this.getPSDepSlnASGroupId() == null) {
            return null;
        }
        Integer n = this.objPSDepSlnASGroupLock;
        synchronized (n) {
            if (this.psdepslnasgroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSlnASGroupId(), (Object)this.psdepslnasgroup.getPSDepSlnASGroupId()) != 0L) {
                this.psdepslnasgroup = null;
            }
            if (this.psdepslnasgroup == null) {
                PSDepSlnASGroup pSDepSlnASGroup = new PSDepSlnASGroup();
                pSDepSlnASGroup.setPSDepSlnASGroupId(this.getPSDepSlnASGroupId());
                PSDepSlnASGroupService pSDepSlnASGroupService = (PSDepSlnASGroupService)ServiceGlobal.getService(PSDepSlnASGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDepSlnASGroupService.autoGet(pSDepSlnASGroup);
                this.psdepslnasgroup = pSDepSlnASGroup;
            }
            return this.psdepslnasgroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSlnMode getPSDepSlnMode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnMode();
        }
        if (this.getPSDepSlnModeId() == null) {
            return null;
        }
        Integer n = this.objPSDepSlnModeLock;
        synchronized (n) {
            if (this.psdepslnmode != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSlnModeId(), (Object)this.psdepslnmode.getPSDepSlnModeId()) != 0L) {
                this.psdepslnmode = null;
            }
            if (this.psdepslnmode == null) {
                PSDepSlnMode pSDepSlnMode = new PSDepSlnMode();
                pSDepSlnMode.setPSDepSlnModeId(this.getPSDepSlnModeId());
                PSDepSlnModeService pSDepSlnModeService = (PSDepSlnModeService)ServiceGlobal.getService(PSDepSlnModeService.class, (SessionFactory)this.getSessionFactory());
                pSDepSlnModeService.autoGet(pSDepSlnMode);
                this.psdepslnmode = pSDepSlnMode;
            }
            return this.psdepslnmode;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSlnPrd getPSDepSlnPrd() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnPrd();
        }
        if (this.getPSDepSlnPrdId() == null) {
            return null;
        }
        Integer n = this.objPSDepSlnPrdLock;
        synchronized (n) {
            if (this.psdepslnprd != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSlnPrdId(), (Object)this.psdepslnprd.getPSDepSlnPrdId()) != 0L) {
                this.psdepslnprd = null;
            }
            if (this.psdepslnprd == null) {
                PSDepSlnPrd pSDepSlnPrd = new PSDepSlnPrd();
                pSDepSlnPrd.setPSDepSlnPrdId(this.getPSDepSlnPrdId());
                PSDepSlnPrdService pSDepSlnPrdService = (PSDepSlnPrdService)ServiceGlobal.getService(PSDepSlnPrdService.class, (SessionFactory)this.getSessionFactory());
                pSDepSlnPrdService.autoGet(pSDepSlnPrd);
                this.psdepslnprd = pSDepSlnPrd;
            }
            return this.psdepslnprd;
        }
    }

    private PSDepSlnModePrdBase getProxyEntity() {
        return this.proxyPSDepSlnModePrdBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDepSlnModePrdBase = null;
        if (iDataObject != null && iDataObject instanceof PSDepSlnModePrdBase) {
            this.proxyPSDepSlnModePrdBase = (PSDepSlnModePrdBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnModePrdService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDEPSLNASGROUPID, 3);
        fieldIndexMap.put(FIELD_PSDEPSLNASGROUPNAME, 4);
        fieldIndexMap.put(FIELD_PSDEPSLNMODEID, 5);
        fieldIndexMap.put(FIELD_PSDEPSLNMODENAME, 6);
        fieldIndexMap.put(FIELD_PSDEPSLNMODEPRDID, 7);
        fieldIndexMap.put(FIELD_PSDEPSLNMODEPRDNAME, 8);
        fieldIndexMap.put(FIELD_PSDEPSLNPRDID, 9);
        fieldIndexMap.put(FIELD_PSDEPSLNPRDNAME, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
    }
}

