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
package net.ibizsys.pscore.srv.sysdesign.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkshopServer;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWorkshopServerService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnSysWSGitBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnSysWSGitBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_GITPASSWORD = "GITPASSWORD";
    public static final String FIELD_GITPATH = "GITPATH";
    public static final String FIELD_GITUSERNAME = "GITUSERNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCWORKSHOPSERVERID = "PSDCWORKSHOPSERVERID";
    public static final String FIELD_PSDCWORKSHOPSERVERNAME = "PSDCWORKSHOPSERVERNAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_PSDEVSLNSYSWSGITID = "PSDEVSLNSYSWSGITID";
    public static final String FIELD_PSDEVSLNSYSWSGITNAME = "PSDEVSLNSYSWSGITNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_GITPASSWORD = 2;
    private static final int INDEX_GITPATH = 3;
    private static final int INDEX_GITUSERNAME = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSDCWORKSHOPSERVERID = 6;
    private static final int INDEX_PSDCWORKSHOPSERVERNAME = 7;
    private static final int INDEX_PSDEVSLNSYSID = 8;
    private static final int INDEX_PSDEVSLNSYSNAME = 9;
    private static final int INDEX_PSDEVSLNSYSWSGITID = 10;
    private static final int INDEX_PSDEVSLNSYSWSGITNAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnSysWSGitBase proxyPSDevSlnSysWSGitBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean gitpasswordDirtyFlag = false;
    private boolean gitpathDirtyFlag = false;
    private boolean gitusernameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcworkshopserveridDirtyFlag = false;
    private boolean psdcworkshopservernameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean psdevslnsyswsgitidDirtyFlag = false;
    private boolean psdevslnsyswsgitnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="gitpassword")
    private String gitpassword;
    @Column(name="gitpath")
    private String gitpath;
    @Column(name="gitusername")
    private String gitusername;
    @Column(name="memo")
    private String memo;
    @Column(name="psdcworkshopserverid")
    private String psdcworkshopserverid;
    @Column(name="psdcworkshopservername")
    private String psdcworkshopservername;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="psdevslnsyswsgitid")
    private String psdevslnsyswsgitid;
    @Column(name="psdevslnsyswsgitname")
    private String psdevslnsyswsgitname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDCWorkshopServerLock = new Integer(1);
    private PSDCWorkshopServer psdcworkshopserver = null;
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;

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

    public void setGITPassword(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGITPassword(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.gitpassword = string;
        this.gitpasswordDirtyFlag = true;
    }

    public String getGITPassword() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGITPassword();
        }
        return this.gitpassword;
    }

    public boolean isGITPasswordDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGITPasswordDirty();
        }
        return this.gitpasswordDirtyFlag;
    }

    public void resetGITPassword() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGITPassword();
            return;
        }
        this.gitpasswordDirtyFlag = false;
        this.gitpassword = null;
    }

    public void setGitPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGitPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.gitpath = string;
        this.gitpathDirtyFlag = true;
    }

    public String getGitPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGitPath();
        }
        return this.gitpath;
    }

    public boolean isGitPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGitPathDirty();
        }
        return this.gitpathDirtyFlag;
    }

    public void resetGitPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGitPath();
            return;
        }
        this.gitpathDirtyFlag = false;
        this.gitpath = null;
    }

    public void setGITUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGITUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.gitusername = string;
        this.gitusernameDirtyFlag = true;
    }

    public String getGITUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGITUserName();
        }
        return this.gitusername;
    }

    public boolean isGITUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGITUserNameDirty();
        }
        return this.gitusernameDirtyFlag;
    }

    public void resetGITUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGITUserName();
            return;
        }
        this.gitusernameDirtyFlag = false;
        this.gitusername = null;
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

    public void setPSDCWorkshopServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCWorkshopServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcworkshopserverid = string;
        this.psdcworkshopserveridDirtyFlag = true;
    }

    public String getPSDCWorkshopServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCWorkshopServerId();
        }
        return this.psdcworkshopserverid;
    }

    public boolean isPSDCWorkshopServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCWorkshopServerIdDirty();
        }
        return this.psdcworkshopserveridDirtyFlag;
    }

    public void resetPSDCWorkshopServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCWorkshopServerId();
            return;
        }
        this.psdcworkshopserveridDirtyFlag = false;
        this.psdcworkshopserverid = null;
    }

    public void setPSDCWorkshopServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCWorkshopServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcworkshopservername = string;
        this.psdcworkshopservernameDirtyFlag = true;
    }

    public String getPSDCWorkshopServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCWorkshopServerName();
        }
        return this.psdcworkshopservername;
    }

    public boolean isPSDCWorkshopServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCWorkshopServerNameDirty();
        }
        return this.psdcworkshopservernameDirtyFlag;
    }

    public void resetPSDCWorkshopServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCWorkshopServerName();
            return;
        }
        this.psdcworkshopservernameDirtyFlag = false;
        this.psdcworkshopservername = null;
    }

    public void setPSDevSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysid = string;
        this.psdevslnsysidDirtyFlag = true;
    }

    public String getPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysId();
        }
        return this.psdevslnsysid;
    }

    public boolean isPSDevSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysIdDirty();
        }
        return this.psdevslnsysidDirtyFlag;
    }

    public void resetPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysId();
            return;
        }
        this.psdevslnsysidDirtyFlag = false;
        this.psdevslnsysid = null;
    }

    public void setPSDevSlnSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysname = string;
        this.psdevslnsysnameDirtyFlag = true;
    }

    public String getPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysName();
        }
        return this.psdevslnsysname;
    }

    public boolean isPSDevSlnSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysNameDirty();
        }
        return this.psdevslnsysnameDirtyFlag;
    }

    public void resetPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysName();
            return;
        }
        this.psdevslnsysnameDirtyFlag = false;
        this.psdevslnsysname = null;
    }

    public void setPSDevSlnSysWSGitId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysWSGitId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsyswsgitid = string;
        this.psdevslnsyswsgitidDirtyFlag = true;
    }

    public String getPSDevSlnSysWSGitId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysWSGitId();
        }
        return this.psdevslnsyswsgitid;
    }

    public boolean isPSDevSlnSysWSGitIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysWSGitIdDirty();
        }
        return this.psdevslnsyswsgitidDirtyFlag;
    }

    public void resetPSDevSlnSysWSGitId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysWSGitId();
            return;
        }
        this.psdevslnsyswsgitidDirtyFlag = false;
        this.psdevslnsyswsgitid = null;
    }

    public void setPSDevSlnSysWSGitName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysWSGitName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsyswsgitname = string;
        this.psdevslnsyswsgitnameDirtyFlag = true;
    }

    public String getPSDevSlnSysWSGitName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysWSGitName();
        }
        return this.psdevslnsyswsgitname;
    }

    public boolean isPSDevSlnSysWSGitNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysWSGitNameDirty();
        }
        return this.psdevslnsyswsgitnameDirtyFlag;
    }

    public void resetPSDevSlnSysWSGitName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysWSGitName();
            return;
        }
        this.psdevslnsyswsgitnameDirtyFlag = false;
        this.psdevslnsyswsgitname = null;
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
        PSDevSlnSysWSGitBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnSysWSGitBase pSDevSlnSysWSGitBase) {
        pSDevSlnSysWSGitBase.resetCreateDate();
        pSDevSlnSysWSGitBase.resetCreateMan();
        pSDevSlnSysWSGitBase.resetGITPassword();
        pSDevSlnSysWSGitBase.resetGitPath();
        pSDevSlnSysWSGitBase.resetGITUserName();
        pSDevSlnSysWSGitBase.resetMemo();
        pSDevSlnSysWSGitBase.resetPSDCWorkshopServerId();
        pSDevSlnSysWSGitBase.resetPSDCWorkshopServerName();
        pSDevSlnSysWSGitBase.resetPSDevSlnSysId();
        pSDevSlnSysWSGitBase.resetPSDevSlnSysName();
        pSDevSlnSysWSGitBase.resetPSDevSlnSysWSGitId();
        pSDevSlnSysWSGitBase.resetPSDevSlnSysWSGitName();
        pSDevSlnSysWSGitBase.resetUpdateDate();
        pSDevSlnSysWSGitBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isGITPasswordDirty()) {
            hashMap.put(FIELD_GITPASSWORD, this.getGITPassword());
        }
        if (!bl || this.isGitPathDirty()) {
            hashMap.put(FIELD_GITPATH, this.getGitPath());
        }
        if (!bl || this.isGITUserNameDirty()) {
            hashMap.put(FIELD_GITUSERNAME, this.getGITUserName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDCWorkshopServerIdDirty()) {
            hashMap.put(FIELD_PSDCWORKSHOPSERVERID, this.getPSDCWorkshopServerId());
        }
        if (!bl || this.isPSDCWorkshopServerNameDirty()) {
            hashMap.put(FIELD_PSDCWORKSHOPSERVERNAME, this.getPSDCWorkshopServerName());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSNAME, this.getPSDevSlnSysName());
        }
        if (!bl || this.isPSDevSlnSysWSGitIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSWSGITID, this.getPSDevSlnSysWSGitId());
        }
        if (!bl || this.isPSDevSlnSysWSGitNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSWSGITNAME, this.getPSDevSlnSysWSGitName());
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
        return PSDevSlnSysWSGitBase.get(this, n);
    }

    private static Object get(PSDevSlnSysWSGitBase pSDevSlnSysWSGitBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysWSGitBase.getCreateDate();
            }
            case 1: {
                return pSDevSlnSysWSGitBase.getCreateMan();
            }
            case 2: {
                return pSDevSlnSysWSGitBase.getGITPassword();
            }
            case 3: {
                return pSDevSlnSysWSGitBase.getGitPath();
            }
            case 4: {
                return pSDevSlnSysWSGitBase.getGITUserName();
            }
            case 5: {
                return pSDevSlnSysWSGitBase.getMemo();
            }
            case 6: {
                return pSDevSlnSysWSGitBase.getPSDCWorkshopServerId();
            }
            case 7: {
                return pSDevSlnSysWSGitBase.getPSDCWorkshopServerName();
            }
            case 8: {
                return pSDevSlnSysWSGitBase.getPSDevSlnSysId();
            }
            case 9: {
                return pSDevSlnSysWSGitBase.getPSDevSlnSysName();
            }
            case 10: {
                return pSDevSlnSysWSGitBase.getPSDevSlnSysWSGitId();
            }
            case 11: {
                return pSDevSlnSysWSGitBase.getPSDevSlnSysWSGitName();
            }
            case 12: {
                return pSDevSlnSysWSGitBase.getUpdateDate();
            }
            case 13: {
                return pSDevSlnSysWSGitBase.getUpdateMan();
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
        PSDevSlnSysWSGitBase.set(this, n, object);
    }

    private static void set(PSDevSlnSysWSGitBase pSDevSlnSysWSGitBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysWSGitBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnSysWSGitBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnSysWSGitBase.setGITPassword(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnSysWSGitBase.setGitPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnSysWSGitBase.setGITUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnSysWSGitBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnSysWSGitBase.setPSDCWorkshopServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnSysWSGitBase.setPSDCWorkshopServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnSysWSGitBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnSysWSGitBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnSysWSGitBase.setPSDevSlnSysWSGitId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnSysWSGitBase.setPSDevSlnSysWSGitName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnSysWSGitBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSDevSlnSysWSGitBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDevSlnSysWSGitBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnSysWSGitBase pSDevSlnSysWSGitBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysWSGitBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevSlnSysWSGitBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevSlnSysWSGitBase.getGITPassword() == null;
            }
            case 3: {
                return pSDevSlnSysWSGitBase.getGitPath() == null;
            }
            case 4: {
                return pSDevSlnSysWSGitBase.getGITUserName() == null;
            }
            case 5: {
                return pSDevSlnSysWSGitBase.getMemo() == null;
            }
            case 6: {
                return pSDevSlnSysWSGitBase.getPSDCWorkshopServerId() == null;
            }
            case 7: {
                return pSDevSlnSysWSGitBase.getPSDCWorkshopServerName() == null;
            }
            case 8: {
                return pSDevSlnSysWSGitBase.getPSDevSlnSysId() == null;
            }
            case 9: {
                return pSDevSlnSysWSGitBase.getPSDevSlnSysName() == null;
            }
            case 10: {
                return pSDevSlnSysWSGitBase.getPSDevSlnSysWSGitId() == null;
            }
            case 11: {
                return pSDevSlnSysWSGitBase.getPSDevSlnSysWSGitName() == null;
            }
            case 12: {
                return pSDevSlnSysWSGitBase.getUpdateDate() == null;
            }
            case 13: {
                return pSDevSlnSysWSGitBase.getUpdateMan() == null;
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
        return PSDevSlnSysWSGitBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnSysWSGitBase pSDevSlnSysWSGitBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysWSGitBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevSlnSysWSGitBase.isCreateManDirty();
            }
            case 2: {
                return pSDevSlnSysWSGitBase.isGITPasswordDirty();
            }
            case 3: {
                return pSDevSlnSysWSGitBase.isGitPathDirty();
            }
            case 4: {
                return pSDevSlnSysWSGitBase.isGITUserNameDirty();
            }
            case 5: {
                return pSDevSlnSysWSGitBase.isMemoDirty();
            }
            case 6: {
                return pSDevSlnSysWSGitBase.isPSDCWorkshopServerIdDirty();
            }
            case 7: {
                return pSDevSlnSysWSGitBase.isPSDCWorkshopServerNameDirty();
            }
            case 8: {
                return pSDevSlnSysWSGitBase.isPSDevSlnSysIdDirty();
            }
            case 9: {
                return pSDevSlnSysWSGitBase.isPSDevSlnSysNameDirty();
            }
            case 10: {
                return pSDevSlnSysWSGitBase.isPSDevSlnSysWSGitIdDirty();
            }
            case 11: {
                return pSDevSlnSysWSGitBase.isPSDevSlnSysWSGitNameDirty();
            }
            case 12: {
                return pSDevSlnSysWSGitBase.isUpdateDateDirty();
            }
            case 13: {
                return pSDevSlnSysWSGitBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnSysWSGitBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnSysWSGitBase pSDevSlnSysWSGitBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnSysWSGitBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnSysWSGitBase.getJSONValue((Object)pSDevSlnSysWSGitBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysWSGitBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnSysWSGitBase.getJSONValue((Object)pSDevSlnSysWSGitBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnSysWSGitBase.getGITPassword() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gitpassword", (Object)PSDevSlnSysWSGitBase.getJSONValue((Object)pSDevSlnSysWSGitBase.getGITPassword()), (boolean)false);
        }
        if (bl || pSDevSlnSysWSGitBase.getGitPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gitpath", (Object)PSDevSlnSysWSGitBase.getJSONValue((Object)pSDevSlnSysWSGitBase.getGitPath()), (boolean)false);
        }
        if (bl || pSDevSlnSysWSGitBase.getGITUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gitusername", (Object)PSDevSlnSysWSGitBase.getJSONValue((Object)pSDevSlnSysWSGitBase.getGITUserName()), (boolean)false);
        }
        if (bl || pSDevSlnSysWSGitBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSlnSysWSGitBase.getJSONValue((Object)pSDevSlnSysWSGitBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSlnSysWSGitBase.getPSDCWorkshopServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcworkshopserverid", (Object)PSDevSlnSysWSGitBase.getJSONValue((Object)pSDevSlnSysWSGitBase.getPSDCWorkshopServerId()), (boolean)false);
        }
        if (bl || pSDevSlnSysWSGitBase.getPSDCWorkshopServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcworkshopservername", (Object)PSDevSlnSysWSGitBase.getJSONValue((Object)pSDevSlnSysWSGitBase.getPSDCWorkshopServerName()), (boolean)false);
        }
        if (bl || pSDevSlnSysWSGitBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDevSlnSysWSGitBase.getJSONValue((Object)pSDevSlnSysWSGitBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevSlnSysWSGitBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSDevSlnSysWSGitBase.getJSONValue((Object)pSDevSlnSysWSGitBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDevSlnSysWSGitBase.getPSDevSlnSysWSGitId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsyswsgitid", (Object)PSDevSlnSysWSGitBase.getJSONValue((Object)pSDevSlnSysWSGitBase.getPSDevSlnSysWSGitId()), (boolean)false);
        }
        if (bl || pSDevSlnSysWSGitBase.getPSDevSlnSysWSGitName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsyswsgitname", (Object)PSDevSlnSysWSGitBase.getJSONValue((Object)pSDevSlnSysWSGitBase.getPSDevSlnSysWSGitName()), (boolean)false);
        }
        if (bl || pSDevSlnSysWSGitBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnSysWSGitBase.getJSONValue((Object)pSDevSlnSysWSGitBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysWSGitBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnSysWSGitBase.getJSONValue((Object)pSDevSlnSysWSGitBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnSysWSGitBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnSysWSGitBase pSDevSlnSysWSGitBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnSysWSGitBase.getCreateDate() != null) {
            object = pSDevSlnSysWSGitBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysWSGitBase.getCreateMan() != null) {
            object = pSDevSlnSysWSGitBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysWSGitBase.getGITPassword() != null) {
            object = pSDevSlnSysWSGitBase.getGITPassword();
            xmlNode.setAttribute(FIELD_GITPASSWORD, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysWSGitBase.getGitPath() != null) {
            object = pSDevSlnSysWSGitBase.getGitPath();
            xmlNode.setAttribute(FIELD_GITPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysWSGitBase.getGITUserName() != null) {
            object = pSDevSlnSysWSGitBase.getGITUserName();
            xmlNode.setAttribute(FIELD_GITUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysWSGitBase.getMemo() != null) {
            object = pSDevSlnSysWSGitBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysWSGitBase.getPSDCWorkshopServerId() != null) {
            object = pSDevSlnSysWSGitBase.getPSDCWorkshopServerId();
            xmlNode.setAttribute(FIELD_PSDCWORKSHOPSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysWSGitBase.getPSDCWorkshopServerName() != null) {
            object = pSDevSlnSysWSGitBase.getPSDCWorkshopServerName();
            xmlNode.setAttribute(FIELD_PSDCWORKSHOPSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysWSGitBase.getPSDevSlnSysId() != null) {
            object = pSDevSlnSysWSGitBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysWSGitBase.getPSDevSlnSysName() != null) {
            object = pSDevSlnSysWSGitBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysWSGitBase.getPSDevSlnSysWSGitId() != null) {
            object = pSDevSlnSysWSGitBase.getPSDevSlnSysWSGitId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSWSGITID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysWSGitBase.getPSDevSlnSysWSGitName() != null) {
            object = pSDevSlnSysWSGitBase.getPSDevSlnSysWSGitName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSWSGITNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysWSGitBase.getUpdateDate() != null) {
            object = pSDevSlnSysWSGitBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysWSGitBase.getUpdateMan() != null) {
            object = pSDevSlnSysWSGitBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnSysWSGitBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnSysWSGitBase pSDevSlnSysWSGitBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnSysWSGitBase.isCreateDateDirty() && (bl || pSDevSlnSysWSGitBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnSysWSGitBase.getCreateDate());
        }
        if (pSDevSlnSysWSGitBase.isCreateManDirty() && (bl || pSDevSlnSysWSGitBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnSysWSGitBase.getCreateMan());
        }
        if (pSDevSlnSysWSGitBase.isGITPasswordDirty() && (bl || pSDevSlnSysWSGitBase.getGITPassword() != null)) {
            iDataObject.set(FIELD_GITPASSWORD, (Object)pSDevSlnSysWSGitBase.getGITPassword());
        }
        if (pSDevSlnSysWSGitBase.isGitPathDirty() && (bl || pSDevSlnSysWSGitBase.getGitPath() != null)) {
            iDataObject.set(FIELD_GITPATH, (Object)pSDevSlnSysWSGitBase.getGitPath());
        }
        if (pSDevSlnSysWSGitBase.isGITUserNameDirty() && (bl || pSDevSlnSysWSGitBase.getGITUserName() != null)) {
            iDataObject.set(FIELD_GITUSERNAME, (Object)pSDevSlnSysWSGitBase.getGITUserName());
        }
        if (pSDevSlnSysWSGitBase.isMemoDirty() && (bl || pSDevSlnSysWSGitBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSlnSysWSGitBase.getMemo());
        }
        if (pSDevSlnSysWSGitBase.isPSDCWorkshopServerIdDirty() && (bl || pSDevSlnSysWSGitBase.getPSDCWorkshopServerId() != null)) {
            iDataObject.set(FIELD_PSDCWORKSHOPSERVERID, (Object)pSDevSlnSysWSGitBase.getPSDCWorkshopServerId());
        }
        if (pSDevSlnSysWSGitBase.isPSDCWorkshopServerNameDirty() && (bl || pSDevSlnSysWSGitBase.getPSDCWorkshopServerName() != null)) {
            iDataObject.set(FIELD_PSDCWORKSHOPSERVERNAME, (Object)pSDevSlnSysWSGitBase.getPSDCWorkshopServerName());
        }
        if (pSDevSlnSysWSGitBase.isPSDevSlnSysIdDirty() && (bl || pSDevSlnSysWSGitBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDevSlnSysWSGitBase.getPSDevSlnSysId());
        }
        if (pSDevSlnSysWSGitBase.isPSDevSlnSysNameDirty() && (bl || pSDevSlnSysWSGitBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSDevSlnSysWSGitBase.getPSDevSlnSysName());
        }
        if (pSDevSlnSysWSGitBase.isPSDevSlnSysWSGitIdDirty() && (bl || pSDevSlnSysWSGitBase.getPSDevSlnSysWSGitId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSWSGITID, (Object)pSDevSlnSysWSGitBase.getPSDevSlnSysWSGitId());
        }
        if (pSDevSlnSysWSGitBase.isPSDevSlnSysWSGitNameDirty() && (bl || pSDevSlnSysWSGitBase.getPSDevSlnSysWSGitName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSWSGITNAME, (Object)pSDevSlnSysWSGitBase.getPSDevSlnSysWSGitName());
        }
        if (pSDevSlnSysWSGitBase.isUpdateDateDirty() && (bl || pSDevSlnSysWSGitBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnSysWSGitBase.getUpdateDate());
        }
        if (pSDevSlnSysWSGitBase.isUpdateManDirty() && (bl || pSDevSlnSysWSGitBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnSysWSGitBase.getUpdateMan());
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
        return PSDevSlnSysWSGitBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnSysWSGitBase pSDevSlnSysWSGitBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysWSGitBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevSlnSysWSGitBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevSlnSysWSGitBase.resetGITPassword();
                return true;
            }
            case 3: {
                pSDevSlnSysWSGitBase.resetGitPath();
                return true;
            }
            case 4: {
                pSDevSlnSysWSGitBase.resetGITUserName();
                return true;
            }
            case 5: {
                pSDevSlnSysWSGitBase.resetMemo();
                return true;
            }
            case 6: {
                pSDevSlnSysWSGitBase.resetPSDCWorkshopServerId();
                return true;
            }
            case 7: {
                pSDevSlnSysWSGitBase.resetPSDCWorkshopServerName();
                return true;
            }
            case 8: {
                pSDevSlnSysWSGitBase.resetPSDevSlnSysId();
                return true;
            }
            case 9: {
                pSDevSlnSysWSGitBase.resetPSDevSlnSysName();
                return true;
            }
            case 10: {
                pSDevSlnSysWSGitBase.resetPSDevSlnSysWSGitId();
                return true;
            }
            case 11: {
                pSDevSlnSysWSGitBase.resetPSDevSlnSysWSGitName();
                return true;
            }
            case 12: {
                pSDevSlnSysWSGitBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSDevSlnSysWSGitBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCWorkshopServer getPSDCWorkshopServer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCWorkshopServer();
        }
        if (this.getPSDCWorkshopServerId() == null) {
            return null;
        }
        Integer n = this.objPSDCWorkshopServerLock;
        synchronized (n) {
            if (this.psdcworkshopserver != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCWorkshopServerId(), (Object)this.psdcworkshopserver.getPSDCWorkshopServerId()) != 0L) {
                this.psdcworkshopserver = null;
            }
            if (this.psdcworkshopserver == null) {
                PSDCWorkshopServer pSDCWorkshopServer = new PSDCWorkshopServer();
                pSDCWorkshopServer.setPSDCWorkshopServerId(this.getPSDCWorkshopServerId());
                PSDCWorkshopServerService pSDCWorkshopServerService = (PSDCWorkshopServerService)ServiceGlobal.getService(PSDCWorkshopServerService.class, (SessionFactory)this.getSessionFactory());
                pSDCWorkshopServerService.autoGet(pSDCWorkshopServer);
                this.psdcworkshopserver = pSDCWorkshopServer;
            }
            return this.psdcworkshopserver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSys getPSDevSlnSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSys();
        }
        if (this.getPSDevSlnSysId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysLock;
        synchronized (n) {
            if (this.psdevslnsys != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysId(), (Object)this.psdevslnsys.getPSDevSlnSysId()) != 0L) {
                this.psdevslnsys = null;
            }
            if (this.psdevslnsys == null) {
                PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
                pSDevSlnSys.setPSDevSlnSysId(this.getPSDevSlnSysId());
                PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysService.autoGet(pSDevSlnSys);
                this.psdevslnsys = pSDevSlnSys;
            }
            return this.psdevslnsys;
        }
    }

    private PSDevSlnSysWSGitBase getProxyEntity() {
        return this.proxyPSDevSlnSysWSGitBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnSysWSGitBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnSysWSGitBase) {
            this.proxyPSDevSlnSysWSGitBase = (PSDevSlnSysWSGitBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysWSGitService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_GITPASSWORD, 2);
        fieldIndexMap.put(FIELD_GITPATH, 3);
        fieldIndexMap.put(FIELD_GITUSERNAME, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSDCWORKSHOPSERVERID, 6);
        fieldIndexMap.put(FIELD_PSDCWORKSHOPSERVERNAME, 7);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 8);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 9);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSWSGITID, 10);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSWSGITNAME, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
    }
}

