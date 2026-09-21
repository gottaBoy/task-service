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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFResourceBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPFResourceBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFNAME = "PSPFNAME";
    public static final String FIELD_PSPFRESOURCEID = "PSPFRESOURCEID";
    public static final String FIELD_PSPFRESOURCENAME = "PSPFRESOURCENAME";
    public static final String FIELD_REFRESHVER = "REFRESHVER";
    public static final String FIELD_TEMPLINFO = "TEMPLINFO";
    public static final String FIELD_TEMPLSTATE = "TEMPLSTATE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_V2FOLDER = "V2FOLDER";
    public static final String FIELD_V2GITPATH = "V2GITPATH";
    public static final String FIELD_VERSTR = "VERSTR";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDEVCENTERID = 3;
    private static final int INDEX_PSDEVCENTERNAME = 4;
    private static final int INDEX_PSPFID = 5;
    private static final int INDEX_PSPFNAME = 6;
    private static final int INDEX_PSPFRESOURCEID = 7;
    private static final int INDEX_PSPFRESOURCENAME = 8;
    private static final int INDEX_REFRESHVER = 9;
    private static final int INDEX_TEMPLINFO = 10;
    private static final int INDEX_TEMPLSTATE = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final int INDEX_V2FOLDER = 14;
    private static final int INDEX_V2GITPATH = 15;
    private static final int INDEX_VERSTR = 16;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPFResourceBase proxyPSPFResourceBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfnameDirtyFlag = false;
    private boolean pspfresourceidDirtyFlag = false;
    private boolean pspfresourcenameDirtyFlag = false;
    private boolean refreshverDirtyFlag = false;
    private boolean templinfoDirtyFlag = false;
    private boolean templstateDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean v2folderDirtyFlag = false;
    private boolean v2gitpathDirtyFlag = false;
    private boolean verstrDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="pspfid")
    private String pspfid;
    @Column(name="pspfname")
    private String pspfname;
    @Column(name="pspfresourceid")
    private String pspfresourceid;
    @Column(name="pspfresourcename")
    private String pspfresourcename;
    @Column(name="refreshver")
    private Integer refreshver;
    @Column(name="templinfo")
    private String templinfo;
    @Column(name="templstate")
    private Integer templstate;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="v2folder")
    private String v2folder;
    @Column(name="v2gitpath")
    private String v2gitpath;
    @Column(name="verstr")
    private String verstr;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
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

    public void setPSDevCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterid = string;
        this.psdevcenteridDirtyFlag = true;
    }

    public String getPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterId();
        }
        return this.psdevcenterid;
    }

    public boolean isPSDevCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterIdDirty();
        }
        return this.psdevcenteridDirtyFlag;
    }

    public void resetPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterId();
            return;
        }
        this.psdevcenteridDirtyFlag = false;
        this.psdevcenterid = null;
    }

    public void setPSDevCenterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentername = string;
        this.psdevcenternameDirtyFlag = true;
    }

    public String getPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterName();
        }
        return this.psdevcentername;
    }

    public boolean isPSDevCenterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterNameDirty();
        }
        return this.psdevcenternameDirtyFlag;
    }

    public void resetPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterName();
            return;
        }
        this.psdevcenternameDirtyFlag = false;
        this.psdevcentername = null;
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

    public void setPSPFResourceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFResourceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfresourceid = string;
        this.pspfresourceidDirtyFlag = true;
    }

    public String getPSPFResourceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFResourceId();
        }
        return this.pspfresourceid;
    }

    public boolean isPSPFResourceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFResourceIdDirty();
        }
        return this.pspfresourceidDirtyFlag;
    }

    public void resetPSPFResourceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFResourceId();
            return;
        }
        this.pspfresourceidDirtyFlag = false;
        this.pspfresourceid = null;
    }

    public void setPSPFResourceName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFResourceName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfresourcename = string;
        this.pspfresourcenameDirtyFlag = true;
    }

    public String getPSPFResourceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFResourceName();
        }
        return this.pspfresourcename;
    }

    public boolean isPSPFResourceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFResourceNameDirty();
        }
        return this.pspfresourcenameDirtyFlag;
    }

    public void resetPSPFResourceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFResourceName();
            return;
        }
        this.pspfresourcenameDirtyFlag = false;
        this.pspfresourcename = null;
    }

    public void setRefreshVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefreshVer(n);
            return;
        }
        this.refreshver = n;
        this.refreshverDirtyFlag = true;
    }

    public Integer getRefreshVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefreshVer();
        }
        return this.refreshver;
    }

    public boolean isRefreshVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefreshVerDirty();
        }
        return this.refreshverDirtyFlag;
    }

    public void resetRefreshVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefreshVer();
            return;
        }
        this.refreshverDirtyFlag = false;
        this.refreshver = null;
    }

    public void setTemplInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templinfo = string;
        this.templinfoDirtyFlag = true;
    }

    public String getTemplInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplInfo();
        }
        return this.templinfo;
    }

    public boolean isTemplInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplInfoDirty();
        }
        return this.templinfoDirtyFlag;
    }

    public void resetTemplInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplInfo();
            return;
        }
        this.templinfoDirtyFlag = false;
        this.templinfo = null;
    }

    public void setTemplState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplState(n);
            return;
        }
        this.templstate = n;
        this.templstateDirtyFlag = true;
    }

    public Integer getTemplState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplState();
        }
        return this.templstate;
    }

    public boolean isTemplStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplStateDirty();
        }
        return this.templstateDirtyFlag;
    }

    public void resetTemplState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplState();
            return;
        }
        this.templstateDirtyFlag = false;
        this.templstate = null;
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

    public void setV2Folder(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setV2Folder(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.v2folder = string;
        this.v2folderDirtyFlag = true;
    }

    public String getV2Folder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getV2Folder();
        }
        return this.v2folder;
    }

    public boolean isV2FolderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isV2FolderDirty();
        }
        return this.v2folderDirtyFlag;
    }

    public void resetV2Folder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetV2Folder();
            return;
        }
        this.v2folderDirtyFlag = false;
        this.v2folder = null;
    }

    public void setV2GitPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setV2GitPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.v2gitpath = string;
        this.v2gitpathDirtyFlag = true;
    }

    public String getV2GitPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getV2GitPath();
        }
        return this.v2gitpath;
    }

    public boolean isV2GitPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isV2GitPathDirty();
        }
        return this.v2gitpathDirtyFlag;
    }

    public void resetV2GitPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetV2GitPath();
            return;
        }
        this.v2gitpathDirtyFlag = false;
        this.v2gitpath = null;
    }

    public void setVerStr(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVerStr(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.verstr = string;
        this.verstrDirtyFlag = true;
    }

    public String getVerStr() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVerStr();
        }
        return this.verstr;
    }

    public boolean isVerStrDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVerStrDirty();
        }
        return this.verstrDirtyFlag;
    }

    public void resetVerStr() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVerStr();
            return;
        }
        this.verstrDirtyFlag = false;
        this.verstr = null;
    }

    protected void onReset() {
        PSPFResourceBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPFResourceBase pSPFResourceBase) {
        pSPFResourceBase.resetCreateDate();
        pSPFResourceBase.resetCreateMan();
        pSPFResourceBase.resetMemo();
        pSPFResourceBase.resetPSDevCenterId();
        pSPFResourceBase.resetPSDevCenterName();
        pSPFResourceBase.resetPSPFId();
        pSPFResourceBase.resetPSPFName();
        pSPFResourceBase.resetPSPFResourceId();
        pSPFResourceBase.resetPSPFResourceName();
        pSPFResourceBase.resetRefreshVer();
        pSPFResourceBase.resetTemplInfo();
        pSPFResourceBase.resetTemplState();
        pSPFResourceBase.resetUpdateDate();
        pSPFResourceBase.resetUpdateMan();
        pSPFResourceBase.resetV2Folder();
        pSPFResourceBase.resetV2GitPath();
        pSPFResourceBase.resetVerStr();
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
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSPFIdDirty()) {
            hashMap.put(FIELD_PSPFID, this.getPSPFId());
        }
        if (!bl || this.isPSPFNameDirty()) {
            hashMap.put(FIELD_PSPFNAME, this.getPSPFName());
        }
        if (!bl || this.isPSPFResourceIdDirty()) {
            hashMap.put(FIELD_PSPFRESOURCEID, this.getPSPFResourceId());
        }
        if (!bl || this.isPSPFResourceNameDirty()) {
            hashMap.put(FIELD_PSPFRESOURCENAME, this.getPSPFResourceName());
        }
        if (!bl || this.isRefreshVerDirty()) {
            hashMap.put(FIELD_REFRESHVER, this.getRefreshVer());
        }
        if (!bl || this.isTemplInfoDirty()) {
            hashMap.put(FIELD_TEMPLINFO, this.getTemplInfo());
        }
        if (!bl || this.isTemplStateDirty()) {
            hashMap.put(FIELD_TEMPLSTATE, this.getTemplState());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isV2FolderDirty()) {
            hashMap.put(FIELD_V2FOLDER, this.getV2Folder());
        }
        if (!bl || this.isV2GitPathDirty()) {
            hashMap.put(FIELD_V2GITPATH, this.getV2GitPath());
        }
        if (!bl || this.isVerStrDirty()) {
            hashMap.put(FIELD_VERSTR, this.getVerStr());
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
        return PSPFResourceBase.get(this, n);
    }

    private static Object get(PSPFResourceBase pSPFResourceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFResourceBase.getCreateDate();
            }
            case 1: {
                return pSPFResourceBase.getCreateMan();
            }
            case 2: {
                return pSPFResourceBase.getMemo();
            }
            case 3: {
                return pSPFResourceBase.getPSDevCenterId();
            }
            case 4: {
                return pSPFResourceBase.getPSDevCenterName();
            }
            case 5: {
                return pSPFResourceBase.getPSPFId();
            }
            case 6: {
                return pSPFResourceBase.getPSPFName();
            }
            case 7: {
                return pSPFResourceBase.getPSPFResourceId();
            }
            case 8: {
                return pSPFResourceBase.getPSPFResourceName();
            }
            case 9: {
                return pSPFResourceBase.getRefreshVer();
            }
            case 10: {
                return pSPFResourceBase.getTemplInfo();
            }
            case 11: {
                return pSPFResourceBase.getTemplState();
            }
            case 12: {
                return pSPFResourceBase.getUpdateDate();
            }
            case 13: {
                return pSPFResourceBase.getUpdateMan();
            }
            case 14: {
                return pSPFResourceBase.getV2Folder();
            }
            case 15: {
                return pSPFResourceBase.getV2GitPath();
            }
            case 16: {
                return pSPFResourceBase.getVerStr();
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
        PSPFResourceBase.set(this, n, object);
    }

    private static void set(PSPFResourceBase pSPFResourceBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPFResourceBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSPFResourceBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSPFResourceBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPFResourceBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPFResourceBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPFResourceBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPFResourceBase.setPSPFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPFResourceBase.setPSPFResourceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPFResourceBase.setPSPFResourceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSPFResourceBase.setRefreshVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSPFResourceBase.setTemplInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSPFResourceBase.setTemplState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSPFResourceBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSPFResourceBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSPFResourceBase.setV2Folder(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSPFResourceBase.setV2GitPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSPFResourceBase.setVerStr(DataObject.getStringValue((Object)object));
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
        return PSPFResourceBase.isNull(this, n);
    }

    private static boolean isNull(PSPFResourceBase pSPFResourceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFResourceBase.getCreateDate() == null;
            }
            case 1: {
                return pSPFResourceBase.getCreateMan() == null;
            }
            case 2: {
                return pSPFResourceBase.getMemo() == null;
            }
            case 3: {
                return pSPFResourceBase.getPSDevCenterId() == null;
            }
            case 4: {
                return pSPFResourceBase.getPSDevCenterName() == null;
            }
            case 5: {
                return pSPFResourceBase.getPSPFId() == null;
            }
            case 6: {
                return pSPFResourceBase.getPSPFName() == null;
            }
            case 7: {
                return pSPFResourceBase.getPSPFResourceId() == null;
            }
            case 8: {
                return pSPFResourceBase.getPSPFResourceName() == null;
            }
            case 9: {
                return pSPFResourceBase.getRefreshVer() == null;
            }
            case 10: {
                return pSPFResourceBase.getTemplInfo() == null;
            }
            case 11: {
                return pSPFResourceBase.getTemplState() == null;
            }
            case 12: {
                return pSPFResourceBase.getUpdateDate() == null;
            }
            case 13: {
                return pSPFResourceBase.getUpdateMan() == null;
            }
            case 14: {
                return pSPFResourceBase.getV2Folder() == null;
            }
            case 15: {
                return pSPFResourceBase.getV2GitPath() == null;
            }
            case 16: {
                return pSPFResourceBase.getVerStr() == null;
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
        return PSPFResourceBase.contains(this, n);
    }

    private static boolean contains(PSPFResourceBase pSPFResourceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFResourceBase.isCreateDateDirty();
            }
            case 1: {
                return pSPFResourceBase.isCreateManDirty();
            }
            case 2: {
                return pSPFResourceBase.isMemoDirty();
            }
            case 3: {
                return pSPFResourceBase.isPSDevCenterIdDirty();
            }
            case 4: {
                return pSPFResourceBase.isPSDevCenterNameDirty();
            }
            case 5: {
                return pSPFResourceBase.isPSPFIdDirty();
            }
            case 6: {
                return pSPFResourceBase.isPSPFNameDirty();
            }
            case 7: {
                return pSPFResourceBase.isPSPFResourceIdDirty();
            }
            case 8: {
                return pSPFResourceBase.isPSPFResourceNameDirty();
            }
            case 9: {
                return pSPFResourceBase.isRefreshVerDirty();
            }
            case 10: {
                return pSPFResourceBase.isTemplInfoDirty();
            }
            case 11: {
                return pSPFResourceBase.isTemplStateDirty();
            }
            case 12: {
                return pSPFResourceBase.isUpdateDateDirty();
            }
            case 13: {
                return pSPFResourceBase.isUpdateManDirty();
            }
            case 14: {
                return pSPFResourceBase.isV2FolderDirty();
            }
            case 15: {
                return pSPFResourceBase.isV2GitPathDirty();
            }
            case 16: {
                return pSPFResourceBase.isVerStrDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPFResourceBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPFResourceBase pSPFResourceBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPFResourceBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPFResourceBase.getJSONValue((Object)pSPFResourceBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPFResourceBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPFResourceBase.getJSONValue((Object)pSPFResourceBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPFResourceBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPFResourceBase.getJSONValue((Object)pSPFResourceBase.getMemo()), (boolean)false);
        }
        if (bl || pSPFResourceBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSPFResourceBase.getJSONValue((Object)pSPFResourceBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSPFResourceBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSPFResourceBase.getJSONValue((Object)pSPFResourceBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSPFResourceBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSPFResourceBase.getJSONValue((Object)pSPFResourceBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSPFResourceBase.getPSPFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfname", (Object)PSPFResourceBase.getJSONValue((Object)pSPFResourceBase.getPSPFName()), (boolean)false);
        }
        if (bl || pSPFResourceBase.getPSPFResourceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfresourceid", (Object)PSPFResourceBase.getJSONValue((Object)pSPFResourceBase.getPSPFResourceId()), (boolean)false);
        }
        if (bl || pSPFResourceBase.getPSPFResourceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfresourcename", (Object)PSPFResourceBase.getJSONValue((Object)pSPFResourceBase.getPSPFResourceName()), (boolean)false);
        }
        if (bl || pSPFResourceBase.getRefreshVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refreshver", (Object)PSPFResourceBase.getJSONValue((Object)pSPFResourceBase.getRefreshVer()), (boolean)false);
        }
        if (bl || pSPFResourceBase.getTemplInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templinfo", (Object)PSPFResourceBase.getJSONValue((Object)pSPFResourceBase.getTemplInfo()), (boolean)false);
        }
        if (bl || pSPFResourceBase.getTemplState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templstate", (Object)PSPFResourceBase.getJSONValue((Object)pSPFResourceBase.getTemplState()), (boolean)false);
        }
        if (bl || pSPFResourceBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPFResourceBase.getJSONValue((Object)pSPFResourceBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPFResourceBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPFResourceBase.getJSONValue((Object)pSPFResourceBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSPFResourceBase.getV2Folder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"v2folder", (Object)PSPFResourceBase.getJSONValue((Object)pSPFResourceBase.getV2Folder()), (boolean)false);
        }
        if (bl || pSPFResourceBase.getV2GitPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"v2gitpath", (Object)PSPFResourceBase.getJSONValue((Object)pSPFResourceBase.getV2GitPath()), (boolean)false);
        }
        if (bl || pSPFResourceBase.getVerStr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"verstr", (Object)PSPFResourceBase.getJSONValue((Object)pSPFResourceBase.getVerStr()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPFResourceBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPFResourceBase pSPFResourceBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPFResourceBase.getCreateDate() != null) {
            object = pSPFResourceBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFResourceBase.getCreateMan() != null) {
            object = pSPFResourceBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFResourceBase.getMemo() != null) {
            object = pSPFResourceBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPFResourceBase.getPSDevCenterId() != null) {
            object = pSPFResourceBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSPFResourceBase.getPSDevCenterName() != null) {
            object = pSPFResourceBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFResourceBase.getPSPFId() != null) {
            object = pSPFResourceBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSPFResourceBase.getPSPFName() != null) {
            object = pSPFResourceBase.getPSPFName();
            xmlNode.setAttribute(FIELD_PSPFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFResourceBase.getPSPFResourceId() != null) {
            object = pSPFResourceBase.getPSPFResourceId();
            xmlNode.setAttribute(FIELD_PSPFRESOURCEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFResourceBase.getPSPFResourceName() != null) {
            object = pSPFResourceBase.getPSPFResourceName();
            xmlNode.setAttribute(FIELD_PSPFRESOURCENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFResourceBase.getRefreshVer() != null) {
            object = pSPFResourceBase.getRefreshVer();
            xmlNode.setAttribute(FIELD_REFRESHVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPFResourceBase.getTemplInfo() != null) {
            object = pSPFResourceBase.getTemplInfo();
            xmlNode.setAttribute(FIELD_TEMPLINFO, object == null ? "" : (String)object);
        }
        if (bl || pSPFResourceBase.getTemplState() != null) {
            object = pSPFResourceBase.getTemplState();
            xmlNode.setAttribute(FIELD_TEMPLSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPFResourceBase.getUpdateDate() != null) {
            object = pSPFResourceBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFResourceBase.getUpdateMan() != null) {
            object = pSPFResourceBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFResourceBase.getV2Folder() != null) {
            object = pSPFResourceBase.getV2Folder();
            xmlNode.setAttribute(FIELD_V2FOLDER, object == null ? "" : (String)object);
        }
        if (bl || pSPFResourceBase.getV2GitPath() != null) {
            object = pSPFResourceBase.getV2GitPath();
            xmlNode.setAttribute(FIELD_V2GITPATH, object == null ? "" : (String)object);
        }
        if (bl || pSPFResourceBase.getVerStr() != null) {
            object = pSPFResourceBase.getVerStr();
            xmlNode.setAttribute(FIELD_VERSTR, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPFResourceBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPFResourceBase pSPFResourceBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPFResourceBase.isCreateDateDirty() && (bl || pSPFResourceBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPFResourceBase.getCreateDate());
        }
        if (pSPFResourceBase.isCreateManDirty() && (bl || pSPFResourceBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPFResourceBase.getCreateMan());
        }
        if (pSPFResourceBase.isMemoDirty() && (bl || pSPFResourceBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPFResourceBase.getMemo());
        }
        if (pSPFResourceBase.isPSDevCenterIdDirty() && (bl || pSPFResourceBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSPFResourceBase.getPSDevCenterId());
        }
        if (pSPFResourceBase.isPSDevCenterNameDirty() && (bl || pSPFResourceBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSPFResourceBase.getPSDevCenterName());
        }
        if (pSPFResourceBase.isPSPFIdDirty() && (bl || pSPFResourceBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSPFResourceBase.getPSPFId());
        }
        if (pSPFResourceBase.isPSPFNameDirty() && (bl || pSPFResourceBase.getPSPFName() != null)) {
            iDataObject.set(FIELD_PSPFNAME, (Object)pSPFResourceBase.getPSPFName());
        }
        if (pSPFResourceBase.isPSPFResourceIdDirty() && (bl || pSPFResourceBase.getPSPFResourceId() != null)) {
            iDataObject.set(FIELD_PSPFRESOURCEID, (Object)pSPFResourceBase.getPSPFResourceId());
        }
        if (pSPFResourceBase.isPSPFResourceNameDirty() && (bl || pSPFResourceBase.getPSPFResourceName() != null)) {
            iDataObject.set(FIELD_PSPFRESOURCENAME, (Object)pSPFResourceBase.getPSPFResourceName());
        }
        if (pSPFResourceBase.isRefreshVerDirty() && (bl || pSPFResourceBase.getRefreshVer() != null)) {
            iDataObject.set(FIELD_REFRESHVER, (Object)pSPFResourceBase.getRefreshVer());
        }
        if (pSPFResourceBase.isTemplInfoDirty() && (bl || pSPFResourceBase.getTemplInfo() != null)) {
            iDataObject.set(FIELD_TEMPLINFO, (Object)pSPFResourceBase.getTemplInfo());
        }
        if (pSPFResourceBase.isTemplStateDirty() && (bl || pSPFResourceBase.getTemplState() != null)) {
            iDataObject.set(FIELD_TEMPLSTATE, (Object)pSPFResourceBase.getTemplState());
        }
        if (pSPFResourceBase.isUpdateDateDirty() && (bl || pSPFResourceBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPFResourceBase.getUpdateDate());
        }
        if (pSPFResourceBase.isUpdateManDirty() && (bl || pSPFResourceBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPFResourceBase.getUpdateMan());
        }
        if (pSPFResourceBase.isV2FolderDirty() && (bl || pSPFResourceBase.getV2Folder() != null)) {
            iDataObject.set(FIELD_V2FOLDER, (Object)pSPFResourceBase.getV2Folder());
        }
        if (pSPFResourceBase.isV2GitPathDirty() && (bl || pSPFResourceBase.getV2GitPath() != null)) {
            iDataObject.set(FIELD_V2GITPATH, (Object)pSPFResourceBase.getV2GitPath());
        }
        if (pSPFResourceBase.isVerStrDirty() && (bl || pSPFResourceBase.getVerStr() != null)) {
            iDataObject.set(FIELD_VERSTR, (Object)pSPFResourceBase.getVerStr());
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
        return PSPFResourceBase.remove(this, n);
    }

    private static boolean remove(PSPFResourceBase pSPFResourceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPFResourceBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSPFResourceBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSPFResourceBase.resetMemo();
                return true;
            }
            case 3: {
                pSPFResourceBase.resetPSDevCenterId();
                return true;
            }
            case 4: {
                pSPFResourceBase.resetPSDevCenterName();
                return true;
            }
            case 5: {
                pSPFResourceBase.resetPSPFId();
                return true;
            }
            case 6: {
                pSPFResourceBase.resetPSPFName();
                return true;
            }
            case 7: {
                pSPFResourceBase.resetPSPFResourceId();
                return true;
            }
            case 8: {
                pSPFResourceBase.resetPSPFResourceName();
                return true;
            }
            case 9: {
                pSPFResourceBase.resetRefreshVer();
                return true;
            }
            case 10: {
                pSPFResourceBase.resetTemplInfo();
                return true;
            }
            case 11: {
                pSPFResourceBase.resetTemplState();
                return true;
            }
            case 12: {
                pSPFResourceBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSPFResourceBase.resetUpdateMan();
                return true;
            }
            case 14: {
                pSPFResourceBase.resetV2Folder();
                return true;
            }
            case 15: {
                pSPFResourceBase.resetV2GitPath();
                return true;
            }
            case 16: {
                pSPFResourceBase.resetVerStr();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getPSDevCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenter();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterLock;
        synchronized (n) {
            if (this.psdevcenter != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterId(), (Object)this.psdevcenter.getPSDevCenterId()) != 0L) {
                this.psdevcenter = null;
            }
            if (this.psdevcenter == null) {
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(this.getPSDevCenterId());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
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

    private PSPFResourceBase getProxyEntity() {
        return this.proxyPSPFResourceBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPFResourceBase = null;
        if (iDataObject != null && iDataObject instanceof PSPFResourceBase) {
            this.proxyPSPFResourceBase = (PSPFResourceBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFResourceService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 3);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 4);
        fieldIndexMap.put(FIELD_PSPFID, 5);
        fieldIndexMap.put(FIELD_PSPFNAME, 6);
        fieldIndexMap.put(FIELD_PSPFRESOURCEID, 7);
        fieldIndexMap.put(FIELD_PSPFRESOURCENAME, 8);
        fieldIndexMap.put(FIELD_REFRESHVER, 9);
        fieldIndexMap.put(FIELD_TEMPLINFO, 10);
        fieldIndexMap.put(FIELD_TEMPLSTATE, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
        fieldIndexMap.put(FIELD_V2FOLDER, 14);
        fieldIndexMap.put(FIELD_V2GITPATH, 15);
        fieldIndexMap.put(FIELD_VERSTR, 16);
    }
}

