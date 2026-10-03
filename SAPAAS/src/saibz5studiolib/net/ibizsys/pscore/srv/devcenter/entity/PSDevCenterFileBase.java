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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterFile;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterFileService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSNDFile;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSNDFileService;
import net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevCenterFileBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevCenterFileBase.class);
    public static final String FIELD_BIZTAG = "BIZTAG";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FILEOBJSIZE = "FILEOBJSIZE";
    public static final String FIELD_FILEPATH = "FILEPATH";
    public static final String FIELD_FILETAG = "FILETAG";
    public static final String FIELD_FILETAG2 = "FILETAG2";
    public static final String FIELD_FILETYPE = "FILETYPE";
    public static final String FIELD_LASTCALCTIME = "LASTCALCTIME";
    public static final String FIELD_MAXFILESIZE = "MAXFILESIZE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_OWNERID = "OWNERID";
    public static final String FIELD_OWNERNAME = "OWNERNAME";
    public static final String FIELD_OWNERTYPE = "OWNERTYPE";
    public static final String FIELD_OWNERTYPENAME = "OWNERTYPENAME";
    public static final String FIELD_PPSDEVCENTERFILEID = "PPSDEVCENTERFILEID";
    public static final String FIELD_PPSDEVCENTERFILENAME = "PPSDEVCENTERFILENAME";
    public static final String FIELD_PSDEVCENTERFILEID = "PSDEVCENTERFILEID";
    public static final String FIELD_PSDEVCENTERFILENAME = "PSDEVCENTERFILENAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSNDFILEID = "PSNDFILEID";
    public static final String FIELD_PSNDFILENAME = "PSNDFILENAME";
    public static final String FIELD_PSTASKSERVERID = "PSTASKSERVERID";
    public static final String FIELD_PSTASKSERVERNAME = "PSTASKSERVERNAME";
    public static final String FIELD_ROOTPSDEVCENTERFILEID = "ROOTPSDEVCENTERFILEID";
    public static final String FIELD_ROOTPSDEVCENTERFILENAME = "ROOTPSDEVCENTERFILENAME";
    public static final String FIELD_TOTALFILESIZE = "TOTALFILESIZE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_BIZTAG = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_FILEOBJSIZE = 3;
    private static final int INDEX_FILEPATH = 4;
    private static final int INDEX_FILETAG = 5;
    private static final int INDEX_FILETAG2 = 6;
    private static final int INDEX_FILETYPE = 7;
    private static final int INDEX_LASTCALCTIME = 8;
    private static final int INDEX_MAXFILESIZE = 9;
    private static final int INDEX_MEMO = 10;
    private static final int INDEX_OWNERID = 11;
    private static final int INDEX_OWNERNAME = 12;
    private static final int INDEX_OWNERTYPE = 13;
    private static final int INDEX_OWNERTYPENAME = 14;
    private static final int INDEX_PPSDEVCENTERFILEID = 15;
    private static final int INDEX_PPSDEVCENTERFILENAME = 16;
    private static final int INDEX_PSDEVCENTERFILEID = 17;
    private static final int INDEX_PSDEVCENTERFILENAME = 18;
    private static final int INDEX_PSDEVCENTERID = 19;
    private static final int INDEX_PSDEVCENTERNAME = 20;
    private static final int INDEX_PSNDFILEID = 21;
    private static final int INDEX_PSNDFILENAME = 22;
    private static final int INDEX_PSTASKSERVERID = 23;
    private static final int INDEX_PSTASKSERVERNAME = 24;
    private static final int INDEX_ROOTPSDEVCENTERFILEID = 25;
    private static final int INDEX_ROOTPSDEVCENTERFILENAME = 26;
    private static final int INDEX_TOTALFILESIZE = 27;
    private static final int INDEX_UPDATEDATE = 28;
    private static final int INDEX_UPDATEMAN = 29;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevCenterFileBase proxyPSDevCenterFileBase = null;
    private boolean biztagDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean fileobjsizeDirtyFlag = false;
    private boolean filepathDirtyFlag = false;
    private boolean filetagDirtyFlag = false;
    private boolean filetag2DirtyFlag = false;
    private boolean filetypeDirtyFlag = false;
    private boolean lastcalctimeDirtyFlag = false;
    private boolean maxfilesizeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean owneridDirtyFlag = false;
    private boolean ownernameDirtyFlag = false;
    private boolean ownertypeDirtyFlag = false;
    private boolean ownertypenameDirtyFlag = false;
    private boolean ppsdevcenterfileidDirtyFlag = false;
    private boolean ppsdevcenterfilenameDirtyFlag = false;
    private boolean psdevcenterfileidDirtyFlag = false;
    private boolean psdevcenterfilenameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psndfileidDirtyFlag = false;
    private boolean psndfilenameDirtyFlag = false;
    private boolean pstaskserveridDirtyFlag = false;
    private boolean pstaskservernameDirtyFlag = false;
    private boolean rootpsdevcenterfileidDirtyFlag = false;
    private boolean rootpsdevcenterfilenameDirtyFlag = false;
    private boolean totalfilesizeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="biztag")
    private String biztag;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="fileobjsize")
    private Double fileobjsize;
    @Column(name="filepath")
    private String filepath;
    @Column(name="filetag")
    private String filetag;
    @Column(name="filetag2")
    private String filetag2;
    @Column(name="filetype")
    private Integer filetype;
    @Column(name="lastcalctime")
    private Timestamp lastcalctime;
    @Column(name="maxfilesize")
    private Double maxfilesize;
    @Column(name="memo")
    private String memo;
    @Column(name="ownerid")
    private String ownerid;
    @Column(name="ownername")
    private String ownername;
    @Column(name="ownertype")
    private String ownertype;
    @Column(name="ownertypename")
    private String ownertypename;
    @Column(name="ppsdevcenterfileid")
    private String ppsdevcenterfileid;
    @Column(name="ppsdevcenterfilename")
    private String ppsdevcenterfilename;
    @Column(name="psdevcenterfileid")
    private String psdevcenterfileid;
    @Column(name="psdevcenterfilename")
    private String psdevcenterfilename;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psndfileid")
    private String psndfileid;
    @Column(name="psndfilename")
    private String psndfilename;
    @Column(name="pstaskserverid")
    private String pstaskserverid;
    @Column(name="pstaskservername")
    private String pstaskservername;
    @Column(name="rootpsdevcenterfileid")
    private String rootpsdevcenterfileid;
    @Column(name="rootpsdevcenterfilename")
    private String rootpsdevcenterfilename;
    @Column(name="totalfilesize")
    private Double totalfilesize;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPPSDevCenterFileLock = new Integer(1);
    private PSDevCenterFile ppsdevcenterfile = null;
    private Integer objRootPSDevCenterFileLock = new Integer(1);
    private PSDevCenterFile rootpsdevcenterfile = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSNDFileLock = new Integer(1);
    private PSNDFile psndfile = null;
    private Integer objPSTaskServerLock = new Integer(1);
    private PSTaskServer pstaskserver = null;

    public void setBizTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBizTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.biztag = string;
        this.biztagDirtyFlag = true;
    }

    public String getBizTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBizTag();
        }
        return this.biztag;
    }

    public boolean isBizTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBizTagDirty();
        }
        return this.biztagDirtyFlag;
    }

    public void resetBizTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBizTag();
            return;
        }
        this.biztagDirtyFlag = false;
        this.biztag = null;
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

    public void setFileObjSize(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFileObjSize(d);
            return;
        }
        this.fileobjsize = d;
        this.fileobjsizeDirtyFlag = true;
    }

    public Double getFileObjSize() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFileObjSize();
        }
        return this.fileobjsize;
    }

    public boolean isFileObjSizeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFileObjSizeDirty();
        }
        return this.fileobjsizeDirtyFlag;
    }

    public void resetFileObjSize() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFileObjSize();
            return;
        }
        this.fileobjsizeDirtyFlag = false;
        this.fileobjsize = null;
    }

    public void setFilePath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFilePath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.filepath = string;
        this.filepathDirtyFlag = true;
    }

    public String getFilePath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFilePath();
        }
        return this.filepath;
    }

    public boolean isFilePathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFilePathDirty();
        }
        return this.filepathDirtyFlag;
    }

    public void resetFilePath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFilePath();
            return;
        }
        this.filepathDirtyFlag = false;
        this.filepath = null;
    }

    public void setFileTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFileTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.filetag = string;
        this.filetagDirtyFlag = true;
    }

    public String getFileTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFileTag();
        }
        return this.filetag;
    }

    public boolean isFileTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFileTagDirty();
        }
        return this.filetagDirtyFlag;
    }

    public void resetFileTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFileTag();
            return;
        }
        this.filetagDirtyFlag = false;
        this.filetag = null;
    }

    public void setFileTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFileTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.filetag2 = string;
        this.filetag2DirtyFlag = true;
    }

    public String getFileTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFileTag2();
        }
        return this.filetag2;
    }

    public boolean isFileTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFileTag2Dirty();
        }
        return this.filetag2DirtyFlag;
    }

    public void resetFileTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFileTag2();
            return;
        }
        this.filetag2DirtyFlag = false;
        this.filetag2 = null;
    }

    public void setFileType(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFileType(n);
            return;
        }
        this.filetype = n;
        this.filetypeDirtyFlag = true;
    }

    public Integer getFileType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFileType();
        }
        return this.filetype;
    }

    public boolean isFileTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFileTypeDirty();
        }
        return this.filetypeDirtyFlag;
    }

    public void resetFileType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFileType();
            return;
        }
        this.filetypeDirtyFlag = false;
        this.filetype = null;
    }

    public void setLastCalcTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLastCalcTime(timestamp);
            return;
        }
        this.lastcalctime = timestamp;
        this.lastcalctimeDirtyFlag = true;
    }

    public Timestamp getLastCalcTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLastCalcTime();
        }
        return this.lastcalctime;
    }

    public boolean isLastCalcTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLastCalcTimeDirty();
        }
        return this.lastcalctimeDirtyFlag;
    }

    public void resetLastCalcTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLastCalcTime();
            return;
        }
        this.lastcalctimeDirtyFlag = false;
        this.lastcalctime = null;
    }

    public void setMaxFileSize(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxFileSize(d);
            return;
        }
        this.maxfilesize = d;
        this.maxfilesizeDirtyFlag = true;
    }

    public Double getMaxFileSize() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxFileSize();
        }
        return this.maxfilesize;
    }

    public boolean isMaxFileSizeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxFileSizeDirty();
        }
        return this.maxfilesizeDirtyFlag;
    }

    public void resetMaxFileSize() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxFileSize();
            return;
        }
        this.maxfilesizeDirtyFlag = false;
        this.maxfilesize = null;
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

    public void setOwnerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOwnerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ownerid = string;
        this.owneridDirtyFlag = true;
    }

    public String getOwnerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOwnerId();
        }
        return this.ownerid;
    }

    public boolean isOwnerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOwnerIdDirty();
        }
        return this.owneridDirtyFlag;
    }

    public void resetOwnerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOwnerId();
            return;
        }
        this.owneridDirtyFlag = false;
        this.ownerid = null;
    }

    public void setOwnerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOwnerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ownername = string;
        this.ownernameDirtyFlag = true;
    }

    public String getOwnerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOwnerName();
        }
        return this.ownername;
    }

    public boolean isOwnerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOwnerNameDirty();
        }
        return this.ownernameDirtyFlag;
    }

    public void resetOwnerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOwnerName();
            return;
        }
        this.ownernameDirtyFlag = false;
        this.ownername = null;
    }

    public void setOwnerType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOwnerType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ownertype = string;
        this.ownertypeDirtyFlag = true;
    }

    public String getOwnerType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOwnerType();
        }
        return this.ownertype;
    }

    public boolean isOwnerTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOwnerTypeDirty();
        }
        return this.ownertypeDirtyFlag;
    }

    public void resetOwnerType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOwnerType();
            return;
        }
        this.ownertypeDirtyFlag = false;
        this.ownertype = null;
    }

    public void setOwnerTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOwnerTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ownertypename = string;
        this.ownertypenameDirtyFlag = true;
    }

    public String getOwnerTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOwnerTypeName();
        }
        return this.ownertypename;
    }

    public boolean isOwnerTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOwnerTypeNameDirty();
        }
        return this.ownertypenameDirtyFlag;
    }

    public void resetOwnerTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOwnerTypeName();
            return;
        }
        this.ownertypenameDirtyFlag = false;
        this.ownertypename = null;
    }

    public void setPPSDevCenterFileId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDevCenterFileId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdevcenterfileid = string;
        this.ppsdevcenterfileidDirtyFlag = true;
    }

    public String getPPSDevCenterFileId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDevCenterFileId();
        }
        return this.ppsdevcenterfileid;
    }

    public boolean isPPSDevCenterFileIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDevCenterFileIdDirty();
        }
        return this.ppsdevcenterfileidDirtyFlag;
    }

    public void resetPPSDevCenterFileId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDevCenterFileId();
            return;
        }
        this.ppsdevcenterfileidDirtyFlag = false;
        this.ppsdevcenterfileid = null;
    }

    public void setPPSDevCenterFileName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDevCenterFileName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdevcenterfilename = string;
        this.ppsdevcenterfilenameDirtyFlag = true;
    }

    public String getPPSDevCenterFileName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDevCenterFileName();
        }
        return this.ppsdevcenterfilename;
    }

    public boolean isPPSDevCenterFileNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDevCenterFileNameDirty();
        }
        return this.ppsdevcenterfilenameDirtyFlag;
    }

    public void resetPPSDevCenterFileName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDevCenterFileName();
            return;
        }
        this.ppsdevcenterfilenameDirtyFlag = false;
        this.ppsdevcenterfilename = null;
    }

    public void setPSDevCenterFileId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterFileId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterfileid = string;
        this.psdevcenterfileidDirtyFlag = true;
    }

    public String getPSDevCenterFileId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterFileId();
        }
        return this.psdevcenterfileid;
    }

    public boolean isPSDevCenterFileIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterFileIdDirty();
        }
        return this.psdevcenterfileidDirtyFlag;
    }

    public void resetPSDevCenterFileId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterFileId();
            return;
        }
        this.psdevcenterfileidDirtyFlag = false;
        this.psdevcenterfileid = null;
    }

    public void setPSDevCenterFileName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterFileName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterfilename = string;
        this.psdevcenterfilenameDirtyFlag = true;
    }

    public String getPSDevCenterFileName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterFileName();
        }
        return this.psdevcenterfilename;
    }

    public boolean isPSDevCenterFileNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterFileNameDirty();
        }
        return this.psdevcenterfilenameDirtyFlag;
    }

    public void resetPSDevCenterFileName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterFileName();
            return;
        }
        this.psdevcenterfilenameDirtyFlag = false;
        this.psdevcenterfilename = null;
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

    public void setPSNDFileId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSNDFileId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psndfileid = string;
        this.psndfileidDirtyFlag = true;
    }

    public String getPSNDFileId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSNDFileId();
        }
        return this.psndfileid;
    }

    public boolean isPSNDFileIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSNDFileIdDirty();
        }
        return this.psndfileidDirtyFlag;
    }

    public void resetPSNDFileId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSNDFileId();
            return;
        }
        this.psndfileidDirtyFlag = false;
        this.psndfileid = null;
    }

    public void setPSNDFileName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSNDFileName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psndfilename = string;
        this.psndfilenameDirtyFlag = true;
    }

    public String getPSNDFileName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSNDFileName();
        }
        return this.psndfilename;
    }

    public boolean isPSNDFileNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSNDFileNameDirty();
        }
        return this.psndfilenameDirtyFlag;
    }

    public void resetPSNDFileName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSNDFileName();
            return;
        }
        this.psndfilenameDirtyFlag = false;
        this.psndfilename = null;
    }

    public void setPSTaskServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSTaskServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pstaskserverid = string;
        this.pstaskserveridDirtyFlag = true;
    }

    public String getPSTaskServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSTaskServerId();
        }
        return this.pstaskserverid;
    }

    public boolean isPSTaskServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSTaskServerIdDirty();
        }
        return this.pstaskserveridDirtyFlag;
    }

    public void resetPSTaskServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSTaskServerId();
            return;
        }
        this.pstaskserveridDirtyFlag = false;
        this.pstaskserverid = null;
    }

    public void setPSTaskServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSTaskServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pstaskservername = string;
        this.pstaskservernameDirtyFlag = true;
    }

    public String getPSTaskServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSTaskServerName();
        }
        return this.pstaskservername;
    }

    public boolean isPSTaskServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSTaskServerNameDirty();
        }
        return this.pstaskservernameDirtyFlag;
    }

    public void resetPSTaskServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSTaskServerName();
            return;
        }
        this.pstaskservernameDirtyFlag = false;
        this.pstaskservername = null;
    }

    public void setRootPSDevCenterFileId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRootPSDevCenterFileId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rootpsdevcenterfileid = string;
        this.rootpsdevcenterfileidDirtyFlag = true;
    }

    public String getRootPSDevCenterFileId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRootPSDevCenterFileId();
        }
        return this.rootpsdevcenterfileid;
    }

    public boolean isRootPSDevCenterFileIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRootPSDevCenterFileIdDirty();
        }
        return this.rootpsdevcenterfileidDirtyFlag;
    }

    public void resetRootPSDevCenterFileId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRootPSDevCenterFileId();
            return;
        }
        this.rootpsdevcenterfileidDirtyFlag = false;
        this.rootpsdevcenterfileid = null;
    }

    public void setRootPSDevCenterFileName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRootPSDevCenterFileName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rootpsdevcenterfilename = string;
        this.rootpsdevcenterfilenameDirtyFlag = true;
    }

    public String getRootPSDevCenterFileName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRootPSDevCenterFileName();
        }
        return this.rootpsdevcenterfilename;
    }

    public boolean isRootPSDevCenterFileNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRootPSDevCenterFileNameDirty();
        }
        return this.rootpsdevcenterfilenameDirtyFlag;
    }

    public void resetRootPSDevCenterFileName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRootPSDevCenterFileName();
            return;
        }
        this.rootpsdevcenterfilenameDirtyFlag = false;
        this.rootpsdevcenterfilename = null;
    }

    public void setTotalFileSize(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTotalFileSize(d);
            return;
        }
        this.totalfilesize = d;
        this.totalfilesizeDirtyFlag = true;
    }

    public Double getTotalFileSize() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTotalFileSize();
        }
        return this.totalfilesize;
    }

    public boolean isTotalFileSizeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTotalFileSizeDirty();
        }
        return this.totalfilesizeDirtyFlag;
    }

    public void resetTotalFileSize() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTotalFileSize();
            return;
        }
        this.totalfilesizeDirtyFlag = false;
        this.totalfilesize = null;
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
        PSDevCenterFileBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevCenterFileBase pSDevCenterFileBase) {
        pSDevCenterFileBase.resetBizTag();
        pSDevCenterFileBase.resetCreateDate();
        pSDevCenterFileBase.resetCreateMan();
        pSDevCenterFileBase.resetFileObjSize();
        pSDevCenterFileBase.resetFilePath();
        pSDevCenterFileBase.resetFileTag();
        pSDevCenterFileBase.resetFileTag2();
        pSDevCenterFileBase.resetFileType();
        pSDevCenterFileBase.resetLastCalcTime();
        pSDevCenterFileBase.resetMaxFileSize();
        pSDevCenterFileBase.resetMemo();
        pSDevCenterFileBase.resetOwnerId();
        pSDevCenterFileBase.resetOwnerName();
        pSDevCenterFileBase.resetOwnerType();
        pSDevCenterFileBase.resetOwnerTypeName();
        pSDevCenterFileBase.resetPPSDevCenterFileId();
        pSDevCenterFileBase.resetPPSDevCenterFileName();
        pSDevCenterFileBase.resetPSDevCenterFileId();
        pSDevCenterFileBase.resetPSDevCenterFileName();
        pSDevCenterFileBase.resetPSDevCenterId();
        pSDevCenterFileBase.resetPSDevCenterName();
        pSDevCenterFileBase.resetPSNDFileId();
        pSDevCenterFileBase.resetPSNDFileName();
        pSDevCenterFileBase.resetPSTaskServerId();
        pSDevCenterFileBase.resetPSTaskServerName();
        pSDevCenterFileBase.resetRootPSDevCenterFileId();
        pSDevCenterFileBase.resetRootPSDevCenterFileName();
        pSDevCenterFileBase.resetTotalFileSize();
        pSDevCenterFileBase.resetUpdateDate();
        pSDevCenterFileBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBizTagDirty()) {
            hashMap.put(FIELD_BIZTAG, this.getBizTag());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isFileObjSizeDirty()) {
            hashMap.put(FIELD_FILEOBJSIZE, this.getFileObjSize());
        }
        if (!bl || this.isFilePathDirty()) {
            hashMap.put(FIELD_FILEPATH, this.getFilePath());
        }
        if (!bl || this.isFileTagDirty()) {
            hashMap.put(FIELD_FILETAG, this.getFileTag());
        }
        if (!bl || this.isFileTag2Dirty()) {
            hashMap.put(FIELD_FILETAG2, this.getFileTag2());
        }
        if (!bl || this.isFileTypeDirty()) {
            hashMap.put(FIELD_FILETYPE, this.getFileType());
        }
        if (!bl || this.isLastCalcTimeDirty()) {
            hashMap.put(FIELD_LASTCALCTIME, this.getLastCalcTime());
        }
        if (!bl || this.isMaxFileSizeDirty()) {
            hashMap.put(FIELD_MAXFILESIZE, this.getMaxFileSize());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOwnerIdDirty()) {
            hashMap.put(FIELD_OWNERID, this.getOwnerId());
        }
        if (!bl || this.isOwnerNameDirty()) {
            hashMap.put(FIELD_OWNERNAME, this.getOwnerName());
        }
        if (!bl || this.isOwnerTypeDirty()) {
            hashMap.put(FIELD_OWNERTYPE, this.getOwnerType());
        }
        if (!bl || this.isOwnerTypeNameDirty()) {
            hashMap.put(FIELD_OWNERTYPENAME, this.getOwnerTypeName());
        }
        if (!bl || this.isPPSDevCenterFileIdDirty()) {
            hashMap.put(FIELD_PPSDEVCENTERFILEID, this.getPPSDevCenterFileId());
        }
        if (!bl || this.isPPSDevCenterFileNameDirty()) {
            hashMap.put(FIELD_PPSDEVCENTERFILENAME, this.getPPSDevCenterFileName());
        }
        if (!bl || this.isPSDevCenterFileIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERFILEID, this.getPSDevCenterFileId());
        }
        if (!bl || this.isPSDevCenterFileNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERFILENAME, this.getPSDevCenterFileName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSNDFileIdDirty()) {
            hashMap.put(FIELD_PSNDFILEID, this.getPSNDFileId());
        }
        if (!bl || this.isPSNDFileNameDirty()) {
            hashMap.put(FIELD_PSNDFILENAME, this.getPSNDFileName());
        }
        if (!bl || this.isPSTaskServerIdDirty()) {
            hashMap.put(FIELD_PSTASKSERVERID, this.getPSTaskServerId());
        }
        if (!bl || this.isPSTaskServerNameDirty()) {
            hashMap.put(FIELD_PSTASKSERVERNAME, this.getPSTaskServerName());
        }
        if (!bl || this.isRootPSDevCenterFileIdDirty()) {
            hashMap.put(FIELD_ROOTPSDEVCENTERFILEID, this.getRootPSDevCenterFileId());
        }
        if (!bl || this.isRootPSDevCenterFileNameDirty()) {
            hashMap.put(FIELD_ROOTPSDEVCENTERFILENAME, this.getRootPSDevCenterFileName());
        }
        if (!bl || this.isTotalFileSizeDirty()) {
            hashMap.put(FIELD_TOTALFILESIZE, this.getTotalFileSize());
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
        return PSDevCenterFileBase.get(this, n);
    }

    private static Object get(PSDevCenterFileBase pSDevCenterFileBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterFileBase.getBizTag();
            }
            case 1: {
                return pSDevCenterFileBase.getCreateDate();
            }
            case 2: {
                return pSDevCenterFileBase.getCreateMan();
            }
            case 3: {
                return pSDevCenterFileBase.getFileObjSize();
            }
            case 4: {
                return pSDevCenterFileBase.getFilePath();
            }
            case 5: {
                return pSDevCenterFileBase.getFileTag();
            }
            case 6: {
                return pSDevCenterFileBase.getFileTag2();
            }
            case 7: {
                return pSDevCenterFileBase.getFileType();
            }
            case 8: {
                return pSDevCenterFileBase.getLastCalcTime();
            }
            case 9: {
                return pSDevCenterFileBase.getMaxFileSize();
            }
            case 10: {
                return pSDevCenterFileBase.getMemo();
            }
            case 11: {
                return pSDevCenterFileBase.getOwnerId();
            }
            case 12: {
                return pSDevCenterFileBase.getOwnerName();
            }
            case 13: {
                return pSDevCenterFileBase.getOwnerType();
            }
            case 14: {
                return pSDevCenterFileBase.getOwnerTypeName();
            }
            case 15: {
                return pSDevCenterFileBase.getPPSDevCenterFileId();
            }
            case 16: {
                return pSDevCenterFileBase.getPPSDevCenterFileName();
            }
            case 17: {
                return pSDevCenterFileBase.getPSDevCenterFileId();
            }
            case 18: {
                return pSDevCenterFileBase.getPSDevCenterFileName();
            }
            case 19: {
                return pSDevCenterFileBase.getPSDevCenterId();
            }
            case 20: {
                return pSDevCenterFileBase.getPSDevCenterName();
            }
            case 21: {
                return pSDevCenterFileBase.getPSNDFileId();
            }
            case 22: {
                return pSDevCenterFileBase.getPSNDFileName();
            }
            case 23: {
                return pSDevCenterFileBase.getPSTaskServerId();
            }
            case 24: {
                return pSDevCenterFileBase.getPSTaskServerName();
            }
            case 25: {
                return pSDevCenterFileBase.getRootPSDevCenterFileId();
            }
            case 26: {
                return pSDevCenterFileBase.getRootPSDevCenterFileName();
            }
            case 27: {
                return pSDevCenterFileBase.getTotalFileSize();
            }
            case 28: {
                return pSDevCenterFileBase.getUpdateDate();
            }
            case 29: {
                return pSDevCenterFileBase.getUpdateMan();
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
        PSDevCenterFileBase.set(this, n, object);
    }

    private static void set(PSDevCenterFileBase pSDevCenterFileBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevCenterFileBase.setBizTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDevCenterFileBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDevCenterFileBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevCenterFileBase.setFileObjSize(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 4: {
                pSDevCenterFileBase.setFilePath(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevCenterFileBase.setFileTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevCenterFileBase.setFileTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevCenterFileBase.setFileType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDevCenterFileBase.setLastCalcTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSDevCenterFileBase.setMaxFileSize(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 10: {
                pSDevCenterFileBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevCenterFileBase.setOwnerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevCenterFileBase.setOwnerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevCenterFileBase.setOwnerType(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevCenterFileBase.setOwnerTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevCenterFileBase.setPPSDevCenterFileId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevCenterFileBase.setPPSDevCenterFileName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDevCenterFileBase.setPSDevCenterFileId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDevCenterFileBase.setPSDevCenterFileName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDevCenterFileBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDevCenterFileBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDevCenterFileBase.setPSNDFileId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDevCenterFileBase.setPSNDFileName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDevCenterFileBase.setPSTaskServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDevCenterFileBase.setPSTaskServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDevCenterFileBase.setRootPSDevCenterFileId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDevCenterFileBase.setRootPSDevCenterFileName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDevCenterFileBase.setTotalFileSize(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 28: {
                pSDevCenterFileBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 29: {
                pSDevCenterFileBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDevCenterFileBase.isNull(this, n);
    }

    private static boolean isNull(PSDevCenterFileBase pSDevCenterFileBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterFileBase.getBizTag() == null;
            }
            case 1: {
                return pSDevCenterFileBase.getCreateDate() == null;
            }
            case 2: {
                return pSDevCenterFileBase.getCreateMan() == null;
            }
            case 3: {
                return pSDevCenterFileBase.getFileObjSize() == null;
            }
            case 4: {
                return pSDevCenterFileBase.getFilePath() == null;
            }
            case 5: {
                return pSDevCenterFileBase.getFileTag() == null;
            }
            case 6: {
                return pSDevCenterFileBase.getFileTag2() == null;
            }
            case 7: {
                return pSDevCenterFileBase.getFileType() == null;
            }
            case 8: {
                return pSDevCenterFileBase.getLastCalcTime() == null;
            }
            case 9: {
                return pSDevCenterFileBase.getMaxFileSize() == null;
            }
            case 10: {
                return pSDevCenterFileBase.getMemo() == null;
            }
            case 11: {
                return pSDevCenterFileBase.getOwnerId() == null;
            }
            case 12: {
                return pSDevCenterFileBase.getOwnerName() == null;
            }
            case 13: {
                return pSDevCenterFileBase.getOwnerType() == null;
            }
            case 14: {
                return pSDevCenterFileBase.getOwnerTypeName() == null;
            }
            case 15: {
                return pSDevCenterFileBase.getPPSDevCenterFileId() == null;
            }
            case 16: {
                return pSDevCenterFileBase.getPPSDevCenterFileName() == null;
            }
            case 17: {
                return pSDevCenterFileBase.getPSDevCenterFileId() == null;
            }
            case 18: {
                return pSDevCenterFileBase.getPSDevCenterFileName() == null;
            }
            case 19: {
                return pSDevCenterFileBase.getPSDevCenterId() == null;
            }
            case 20: {
                return pSDevCenterFileBase.getPSDevCenterName() == null;
            }
            case 21: {
                return pSDevCenterFileBase.getPSNDFileId() == null;
            }
            case 22: {
                return pSDevCenterFileBase.getPSNDFileName() == null;
            }
            case 23: {
                return pSDevCenterFileBase.getPSTaskServerId() == null;
            }
            case 24: {
                return pSDevCenterFileBase.getPSTaskServerName() == null;
            }
            case 25: {
                return pSDevCenterFileBase.getRootPSDevCenterFileId() == null;
            }
            case 26: {
                return pSDevCenterFileBase.getRootPSDevCenterFileName() == null;
            }
            case 27: {
                return pSDevCenterFileBase.getTotalFileSize() == null;
            }
            case 28: {
                return pSDevCenterFileBase.getUpdateDate() == null;
            }
            case 29: {
                return pSDevCenterFileBase.getUpdateMan() == null;
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
        return PSDevCenterFileBase.contains(this, n);
    }

    private static boolean contains(PSDevCenterFileBase pSDevCenterFileBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterFileBase.isBizTagDirty();
            }
            case 1: {
                return pSDevCenterFileBase.isCreateDateDirty();
            }
            case 2: {
                return pSDevCenterFileBase.isCreateManDirty();
            }
            case 3: {
                return pSDevCenterFileBase.isFileObjSizeDirty();
            }
            case 4: {
                return pSDevCenterFileBase.isFilePathDirty();
            }
            case 5: {
                return pSDevCenterFileBase.isFileTagDirty();
            }
            case 6: {
                return pSDevCenterFileBase.isFileTag2Dirty();
            }
            case 7: {
                return pSDevCenterFileBase.isFileTypeDirty();
            }
            case 8: {
                return pSDevCenterFileBase.isLastCalcTimeDirty();
            }
            case 9: {
                return pSDevCenterFileBase.isMaxFileSizeDirty();
            }
            case 10: {
                return pSDevCenterFileBase.isMemoDirty();
            }
            case 11: {
                return pSDevCenterFileBase.isOwnerIdDirty();
            }
            case 12: {
                return pSDevCenterFileBase.isOwnerNameDirty();
            }
            case 13: {
                return pSDevCenterFileBase.isOwnerTypeDirty();
            }
            case 14: {
                return pSDevCenterFileBase.isOwnerTypeNameDirty();
            }
            case 15: {
                return pSDevCenterFileBase.isPPSDevCenterFileIdDirty();
            }
            case 16: {
                return pSDevCenterFileBase.isPPSDevCenterFileNameDirty();
            }
            case 17: {
                return pSDevCenterFileBase.isPSDevCenterFileIdDirty();
            }
            case 18: {
                return pSDevCenterFileBase.isPSDevCenterFileNameDirty();
            }
            case 19: {
                return pSDevCenterFileBase.isPSDevCenterIdDirty();
            }
            case 20: {
                return pSDevCenterFileBase.isPSDevCenterNameDirty();
            }
            case 21: {
                return pSDevCenterFileBase.isPSNDFileIdDirty();
            }
            case 22: {
                return pSDevCenterFileBase.isPSNDFileNameDirty();
            }
            case 23: {
                return pSDevCenterFileBase.isPSTaskServerIdDirty();
            }
            case 24: {
                return pSDevCenterFileBase.isPSTaskServerNameDirty();
            }
            case 25: {
                return pSDevCenterFileBase.isRootPSDevCenterFileIdDirty();
            }
            case 26: {
                return pSDevCenterFileBase.isRootPSDevCenterFileNameDirty();
            }
            case 27: {
                return pSDevCenterFileBase.isTotalFileSizeDirty();
            }
            case 28: {
                return pSDevCenterFileBase.isUpdateDateDirty();
            }
            case 29: {
                return pSDevCenterFileBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevCenterFileBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevCenterFileBase pSDevCenterFileBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevCenterFileBase.getBizTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"biztag", (Object)PSDevCenterFileBase.getJSONValue((Object)pSDevCenterFileBase.getBizTag()), (boolean)false);
        }
        if (bl || pSDevCenterFileBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevCenterFileBase.getJSONValue((Object)pSDevCenterFileBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevCenterFileBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevCenterFileBase.getJSONValue((Object)pSDevCenterFileBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevCenterFileBase.getFileObjSize() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fileobjsize", (Object)PSDevCenterFileBase.getJSONValue((Object)pSDevCenterFileBase.getFileObjSize()), (boolean)false);
        }
        if (bl || pSDevCenterFileBase.getFilePath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"filepath", (Object)PSDevCenterFileBase.getJSONValue((Object)pSDevCenterFileBase.getFilePath()), (boolean)false);
        }
        if (bl || pSDevCenterFileBase.getFileTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"filetag", (Object)PSDevCenterFileBase.getJSONValue((Object)pSDevCenterFileBase.getFileTag()), (boolean)false);
        }
        if (bl || pSDevCenterFileBase.getFileTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"filetag2", (Object)PSDevCenterFileBase.getJSONValue((Object)pSDevCenterFileBase.getFileTag2()), (boolean)false);
        }
        if (bl || pSDevCenterFileBase.getFileType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"filetype", (Object)PSDevCenterFileBase.getJSONValue((Object)pSDevCenterFileBase.getFileType()), (boolean)false);
        }
        if (bl || pSDevCenterFileBase.getLastCalcTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lastcalctime", (Object)PSDevCenterFileBase.getJSONValue((Object)pSDevCenterFileBase.getLastCalcTime()), (boolean)false);
        }
        if (bl || pSDevCenterFileBase.getMaxFileSize() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxfilesize", (Object)PSDevCenterFileBase.getJSONValue((Object)pSDevCenterFileBase.getMaxFileSize()), (boolean)false);
        }
        if (bl || pSDevCenterFileBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevCenterFileBase.getJSONValue((Object)pSDevCenterFileBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevCenterFileBase.getOwnerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ownerid", (Object)PSDevCenterFileBase.getJSONValue((Object)pSDevCenterFileBase.getOwnerId()), (boolean)false);
        }
        if (bl || pSDevCenterFileBase.getOwnerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ownername", (Object)PSDevCenterFileBase.getJSONValue((Object)pSDevCenterFileBase.getOwnerName()), (boolean)false);
        }
        if (bl || pSDevCenterFileBase.getOwnerType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ownertype", (Object)PSDevCenterFileBase.getJSONValue((Object)pSDevCenterFileBase.getOwnerType()), (boolean)false);
        }
        if (bl || pSDevCenterFileBase.getOwnerTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ownertypename", (Object)PSDevCenterFileBase.getJSONValue((Object)pSDevCenterFileBase.getOwnerTypeName()), (boolean)false);
        }
        if (bl || pSDevCenterFileBase.getPPSDevCenterFileId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdevcenterfileid", (Object)PSDevCenterFileBase.getJSONValue((Object)pSDevCenterFileBase.getPPSDevCenterFileId()), (boolean)false);
        }
        if (bl || pSDevCenterFileBase.getPPSDevCenterFileName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdevcenterfilename", (Object)PSDevCenterFileBase.getJSONValue((Object)pSDevCenterFileBase.getPPSDevCenterFileName()), (boolean)false);
        }
        if (bl || pSDevCenterFileBase.getPSDevCenterFileId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterfileid", (Object)PSDevCenterFileBase.getJSONValue((Object)pSDevCenterFileBase.getPSDevCenterFileId()), (boolean)false);
        }
        if (bl || pSDevCenterFileBase.getPSDevCenterFileName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterfilename", (Object)PSDevCenterFileBase.getJSONValue((Object)pSDevCenterFileBase.getPSDevCenterFileName()), (boolean)false);
        }
        if (bl || pSDevCenterFileBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDevCenterFileBase.getJSONValue((Object)pSDevCenterFileBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDevCenterFileBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDevCenterFileBase.getJSONValue((Object)pSDevCenterFileBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDevCenterFileBase.getPSNDFileId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psndfileid", (Object)PSDevCenterFileBase.getJSONValue((Object)pSDevCenterFileBase.getPSNDFileId()), (boolean)false);
        }
        if (bl || pSDevCenterFileBase.getPSNDFileName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psndfilename", (Object)PSDevCenterFileBase.getJSONValue((Object)pSDevCenterFileBase.getPSNDFileName()), (boolean)false);
        }
        if (bl || pSDevCenterFileBase.getPSTaskServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskserverid", (Object)PSDevCenterFileBase.getJSONValue((Object)pSDevCenterFileBase.getPSTaskServerId()), (boolean)false);
        }
        if (bl || pSDevCenterFileBase.getPSTaskServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskservername", (Object)PSDevCenterFileBase.getJSONValue((Object)pSDevCenterFileBase.getPSTaskServerName()), (boolean)false);
        }
        if (bl || pSDevCenterFileBase.getRootPSDevCenterFileId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rootpsdevcenterfileid", (Object)PSDevCenterFileBase.getJSONValue((Object)pSDevCenterFileBase.getRootPSDevCenterFileId()), (boolean)false);
        }
        if (bl || pSDevCenterFileBase.getRootPSDevCenterFileName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rootpsdevcenterfilename", (Object)PSDevCenterFileBase.getJSONValue((Object)pSDevCenterFileBase.getRootPSDevCenterFileName()), (boolean)false);
        }
        if (bl || pSDevCenterFileBase.getTotalFileSize() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"totalfilesize", (Object)PSDevCenterFileBase.getJSONValue((Object)pSDevCenterFileBase.getTotalFileSize()), (boolean)false);
        }
        if (bl || pSDevCenterFileBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevCenterFileBase.getJSONValue((Object)pSDevCenterFileBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevCenterFileBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevCenterFileBase.getJSONValue((Object)pSDevCenterFileBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevCenterFileBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevCenterFileBase pSDevCenterFileBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevCenterFileBase.getBizTag() != null) {
            object = pSDevCenterFileBase.getBizTag();
            xmlNode.setAttribute(FIELD_BIZTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterFileBase.getCreateDate() != null) {
            object = pSDevCenterFileBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterFileBase.getCreateMan() != null) {
            object = pSDevCenterFileBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterFileBase.getFileObjSize() != null) {
            object = pSDevCenterFileBase.getFileObjSize();
            xmlNode.setAttribute(FIELD_FILEOBJSIZE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterFileBase.getFilePath() != null) {
            object = pSDevCenterFileBase.getFilePath();
            xmlNode.setAttribute(FIELD_FILEPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterFileBase.getFileTag() != null) {
            object = pSDevCenterFileBase.getFileTag();
            xmlNode.setAttribute(FIELD_FILETAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterFileBase.getFileTag2() != null) {
            object = pSDevCenterFileBase.getFileTag2();
            xmlNode.setAttribute(FIELD_FILETAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterFileBase.getFileType() != null) {
            object = pSDevCenterFileBase.getFileType();
            xmlNode.setAttribute(FIELD_FILETYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterFileBase.getLastCalcTime() != null) {
            object = pSDevCenterFileBase.getLastCalcTime();
            xmlNode.setAttribute(FIELD_LASTCALCTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterFileBase.getMaxFileSize() != null) {
            object = pSDevCenterFileBase.getMaxFileSize();
            xmlNode.setAttribute(FIELD_MAXFILESIZE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterFileBase.getMemo() != null) {
            object = pSDevCenterFileBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterFileBase.getOwnerId() != null) {
            object = pSDevCenterFileBase.getOwnerId();
            xmlNode.setAttribute(FIELD_OWNERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterFileBase.getOwnerName() != null) {
            object = pSDevCenterFileBase.getOwnerName();
            xmlNode.setAttribute(FIELD_OWNERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterFileBase.getOwnerType() != null) {
            object = pSDevCenterFileBase.getOwnerType();
            xmlNode.setAttribute(FIELD_OWNERTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterFileBase.getOwnerTypeName() != null) {
            object = pSDevCenterFileBase.getOwnerTypeName();
            xmlNode.setAttribute(FIELD_OWNERTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterFileBase.getPPSDevCenterFileId() != null) {
            object = pSDevCenterFileBase.getPPSDevCenterFileId();
            xmlNode.setAttribute(FIELD_PPSDEVCENTERFILEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterFileBase.getPPSDevCenterFileName() != null) {
            object = pSDevCenterFileBase.getPPSDevCenterFileName();
            xmlNode.setAttribute(FIELD_PPSDEVCENTERFILENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterFileBase.getPSDevCenterFileId() != null) {
            object = pSDevCenterFileBase.getPSDevCenterFileId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERFILEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterFileBase.getPSDevCenterFileName() != null) {
            object = pSDevCenterFileBase.getPSDevCenterFileName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERFILENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterFileBase.getPSDevCenterId() != null) {
            object = pSDevCenterFileBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterFileBase.getPSDevCenterName() != null) {
            object = pSDevCenterFileBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterFileBase.getPSNDFileId() != null) {
            object = pSDevCenterFileBase.getPSNDFileId();
            xmlNode.setAttribute(FIELD_PSNDFILEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterFileBase.getPSNDFileName() != null) {
            object = pSDevCenterFileBase.getPSNDFileName();
            xmlNode.setAttribute(FIELD_PSNDFILENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterFileBase.getPSTaskServerId() != null) {
            object = pSDevCenterFileBase.getPSTaskServerId();
            xmlNode.setAttribute(FIELD_PSTASKSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterFileBase.getPSTaskServerName() != null) {
            object = pSDevCenterFileBase.getPSTaskServerName();
            xmlNode.setAttribute(FIELD_PSTASKSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterFileBase.getRootPSDevCenterFileId() != null) {
            object = pSDevCenterFileBase.getRootPSDevCenterFileId();
            xmlNode.setAttribute(FIELD_ROOTPSDEVCENTERFILEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterFileBase.getRootPSDevCenterFileName() != null) {
            object = pSDevCenterFileBase.getRootPSDevCenterFileName();
            xmlNode.setAttribute(FIELD_ROOTPSDEVCENTERFILENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterFileBase.getTotalFileSize() != null) {
            object = pSDevCenterFileBase.getTotalFileSize();
            xmlNode.setAttribute(FIELD_TOTALFILESIZE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterFileBase.getUpdateDate() != null) {
            object = pSDevCenterFileBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterFileBase.getUpdateMan() != null) {
            object = pSDevCenterFileBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevCenterFileBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevCenterFileBase pSDevCenterFileBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevCenterFileBase.isBizTagDirty() && (bl || pSDevCenterFileBase.getBizTag() != null)) {
            iDataObject.set(FIELD_BIZTAG, (Object)pSDevCenterFileBase.getBizTag());
        }
        if (pSDevCenterFileBase.isCreateDateDirty() && (bl || pSDevCenterFileBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevCenterFileBase.getCreateDate());
        }
        if (pSDevCenterFileBase.isCreateManDirty() && (bl || pSDevCenterFileBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevCenterFileBase.getCreateMan());
        }
        if (pSDevCenterFileBase.isFileObjSizeDirty() && (bl || pSDevCenterFileBase.getFileObjSize() != null)) {
            iDataObject.set(FIELD_FILEOBJSIZE, (Object)pSDevCenterFileBase.getFileObjSize());
        }
        if (pSDevCenterFileBase.isFilePathDirty() && (bl || pSDevCenterFileBase.getFilePath() != null)) {
            iDataObject.set(FIELD_FILEPATH, (Object)pSDevCenterFileBase.getFilePath());
        }
        if (pSDevCenterFileBase.isFileTagDirty() && (bl || pSDevCenterFileBase.getFileTag() != null)) {
            iDataObject.set(FIELD_FILETAG, (Object)pSDevCenterFileBase.getFileTag());
        }
        if (pSDevCenterFileBase.isFileTag2Dirty() && (bl || pSDevCenterFileBase.getFileTag2() != null)) {
            iDataObject.set(FIELD_FILETAG2, (Object)pSDevCenterFileBase.getFileTag2());
        }
        if (pSDevCenterFileBase.isFileTypeDirty() && (bl || pSDevCenterFileBase.getFileType() != null)) {
            iDataObject.set(FIELD_FILETYPE, (Object)pSDevCenterFileBase.getFileType());
        }
        if (pSDevCenterFileBase.isLastCalcTimeDirty() && (bl || pSDevCenterFileBase.getLastCalcTime() != null)) {
            iDataObject.set(FIELD_LASTCALCTIME, (Object)pSDevCenterFileBase.getLastCalcTime());
        }
        if (pSDevCenterFileBase.isMaxFileSizeDirty() && (bl || pSDevCenterFileBase.getMaxFileSize() != null)) {
            iDataObject.set(FIELD_MAXFILESIZE, (Object)pSDevCenterFileBase.getMaxFileSize());
        }
        if (pSDevCenterFileBase.isMemoDirty() && (bl || pSDevCenterFileBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevCenterFileBase.getMemo());
        }
        if (pSDevCenterFileBase.isOwnerIdDirty() && (bl || pSDevCenterFileBase.getOwnerId() != null)) {
            iDataObject.set(FIELD_OWNERID, (Object)pSDevCenterFileBase.getOwnerId());
        }
        if (pSDevCenterFileBase.isOwnerNameDirty() && (bl || pSDevCenterFileBase.getOwnerName() != null)) {
            iDataObject.set(FIELD_OWNERNAME, (Object)pSDevCenterFileBase.getOwnerName());
        }
        if (pSDevCenterFileBase.isOwnerTypeDirty() && (bl || pSDevCenterFileBase.getOwnerType() != null)) {
            iDataObject.set(FIELD_OWNERTYPE, (Object)pSDevCenterFileBase.getOwnerType());
        }
        if (pSDevCenterFileBase.isOwnerTypeNameDirty() && (bl || pSDevCenterFileBase.getOwnerTypeName() != null)) {
            iDataObject.set(FIELD_OWNERTYPENAME, (Object)pSDevCenterFileBase.getOwnerTypeName());
        }
        if (pSDevCenterFileBase.isPPSDevCenterFileIdDirty() && (bl || pSDevCenterFileBase.getPPSDevCenterFileId() != null)) {
            iDataObject.set(FIELD_PPSDEVCENTERFILEID, (Object)pSDevCenterFileBase.getPPSDevCenterFileId());
        }
        if (pSDevCenterFileBase.isPPSDevCenterFileNameDirty() && (bl || pSDevCenterFileBase.getPPSDevCenterFileName() != null)) {
            iDataObject.set(FIELD_PPSDEVCENTERFILENAME, (Object)pSDevCenterFileBase.getPPSDevCenterFileName());
        }
        if (pSDevCenterFileBase.isPSDevCenterFileIdDirty() && (bl || pSDevCenterFileBase.getPSDevCenterFileId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERFILEID, (Object)pSDevCenterFileBase.getPSDevCenterFileId());
        }
        if (pSDevCenterFileBase.isPSDevCenterFileNameDirty() && (bl || pSDevCenterFileBase.getPSDevCenterFileName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERFILENAME, (Object)pSDevCenterFileBase.getPSDevCenterFileName());
        }
        if (pSDevCenterFileBase.isPSDevCenterIdDirty() && (bl || pSDevCenterFileBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDevCenterFileBase.getPSDevCenterId());
        }
        if (pSDevCenterFileBase.isPSDevCenterNameDirty() && (bl || pSDevCenterFileBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDevCenterFileBase.getPSDevCenterName());
        }
        if (pSDevCenterFileBase.isPSNDFileIdDirty() && (bl || pSDevCenterFileBase.getPSNDFileId() != null)) {
            iDataObject.set(FIELD_PSNDFILEID, (Object)pSDevCenterFileBase.getPSNDFileId());
        }
        if (pSDevCenterFileBase.isPSNDFileNameDirty() && (bl || pSDevCenterFileBase.getPSNDFileName() != null)) {
            iDataObject.set(FIELD_PSNDFILENAME, (Object)pSDevCenterFileBase.getPSNDFileName());
        }
        if (pSDevCenterFileBase.isPSTaskServerIdDirty() && (bl || pSDevCenterFileBase.getPSTaskServerId() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERID, (Object)pSDevCenterFileBase.getPSTaskServerId());
        }
        if (pSDevCenterFileBase.isPSTaskServerNameDirty() && (bl || pSDevCenterFileBase.getPSTaskServerName() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERNAME, (Object)pSDevCenterFileBase.getPSTaskServerName());
        }
        if (pSDevCenterFileBase.isRootPSDevCenterFileIdDirty() && (bl || pSDevCenterFileBase.getRootPSDevCenterFileId() != null)) {
            iDataObject.set(FIELD_ROOTPSDEVCENTERFILEID, (Object)pSDevCenterFileBase.getRootPSDevCenterFileId());
        }
        if (pSDevCenterFileBase.isRootPSDevCenterFileNameDirty() && (bl || pSDevCenterFileBase.getRootPSDevCenterFileName() != null)) {
            iDataObject.set(FIELD_ROOTPSDEVCENTERFILENAME, (Object)pSDevCenterFileBase.getRootPSDevCenterFileName());
        }
        if (pSDevCenterFileBase.isTotalFileSizeDirty() && (bl || pSDevCenterFileBase.getTotalFileSize() != null)) {
            iDataObject.set(FIELD_TOTALFILESIZE, (Object)pSDevCenterFileBase.getTotalFileSize());
        }
        if (pSDevCenterFileBase.isUpdateDateDirty() && (bl || pSDevCenterFileBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevCenterFileBase.getUpdateDate());
        }
        if (pSDevCenterFileBase.isUpdateManDirty() && (bl || pSDevCenterFileBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevCenterFileBase.getUpdateMan());
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
        return PSDevCenterFileBase.remove(this, n);
    }

    private static boolean remove(PSDevCenterFileBase pSDevCenterFileBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevCenterFileBase.resetBizTag();
                return true;
            }
            case 1: {
                pSDevCenterFileBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDevCenterFileBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDevCenterFileBase.resetFileObjSize();
                return true;
            }
            case 4: {
                pSDevCenterFileBase.resetFilePath();
                return true;
            }
            case 5: {
                pSDevCenterFileBase.resetFileTag();
                return true;
            }
            case 6: {
                pSDevCenterFileBase.resetFileTag2();
                return true;
            }
            case 7: {
                pSDevCenterFileBase.resetFileType();
                return true;
            }
            case 8: {
                pSDevCenterFileBase.resetLastCalcTime();
                return true;
            }
            case 9: {
                pSDevCenterFileBase.resetMaxFileSize();
                return true;
            }
            case 10: {
                pSDevCenterFileBase.resetMemo();
                return true;
            }
            case 11: {
                pSDevCenterFileBase.resetOwnerId();
                return true;
            }
            case 12: {
                pSDevCenterFileBase.resetOwnerName();
                return true;
            }
            case 13: {
                pSDevCenterFileBase.resetOwnerType();
                return true;
            }
            case 14: {
                pSDevCenterFileBase.resetOwnerTypeName();
                return true;
            }
            case 15: {
                pSDevCenterFileBase.resetPPSDevCenterFileId();
                return true;
            }
            case 16: {
                pSDevCenterFileBase.resetPPSDevCenterFileName();
                return true;
            }
            case 17: {
                pSDevCenterFileBase.resetPSDevCenterFileId();
                return true;
            }
            case 18: {
                pSDevCenterFileBase.resetPSDevCenterFileName();
                return true;
            }
            case 19: {
                pSDevCenterFileBase.resetPSDevCenterId();
                return true;
            }
            case 20: {
                pSDevCenterFileBase.resetPSDevCenterName();
                return true;
            }
            case 21: {
                pSDevCenterFileBase.resetPSNDFileId();
                return true;
            }
            case 22: {
                pSDevCenterFileBase.resetPSNDFileName();
                return true;
            }
            case 23: {
                pSDevCenterFileBase.resetPSTaskServerId();
                return true;
            }
            case 24: {
                pSDevCenterFileBase.resetPSTaskServerName();
                return true;
            }
            case 25: {
                pSDevCenterFileBase.resetRootPSDevCenterFileId();
                return true;
            }
            case 26: {
                pSDevCenterFileBase.resetRootPSDevCenterFileName();
                return true;
            }
            case 27: {
                pSDevCenterFileBase.resetTotalFileSize();
                return true;
            }
            case 28: {
                pSDevCenterFileBase.resetUpdateDate();
                return true;
            }
            case 29: {
                pSDevCenterFileBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterFile getPPSDevCenterFile() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDevCenterFile();
        }
        if (this.getPPSDevCenterFileId() == null) {
            return null;
        }
        Integer n = this.objPPSDevCenterFileLock;
        synchronized (n) {
            if (this.ppsdevcenterfile != null && DataTypeHelper.compare((int)25, (Object)this.getPPSDevCenterFileId(), (Object)this.ppsdevcenterfile.getPSDevCenterFileId()) != 0L) {
                this.ppsdevcenterfile = null;
            }
            if (this.ppsdevcenterfile == null) {
                PSDevCenterFile pSDevCenterFile = new PSDevCenterFile();
                pSDevCenterFile.setPSDevCenterFileId(this.getPPSDevCenterFileId());
                PSDevCenterFileService pSDevCenterFileService = (PSDevCenterFileService)ServiceGlobal.getService(PSDevCenterFileService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterFileService.autoGet(pSDevCenterFile);
                this.ppsdevcenterfile = pSDevCenterFile;
            }
            return this.ppsdevcenterfile;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterFile getRootPSDevCenterFile() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRootPSDevCenterFile();
        }
        if (this.getRootPSDevCenterFileId() == null) {
            return null;
        }
        Integer n = this.objRootPSDevCenterFileLock;
        synchronized (n) {
            if (this.rootpsdevcenterfile != null && DataTypeHelper.compare((int)25, (Object)this.getRootPSDevCenterFileId(), (Object)this.rootpsdevcenterfile.getPSDevCenterFileId()) != 0L) {
                this.rootpsdevcenterfile = null;
            }
            if (this.rootpsdevcenterfile == null) {
                PSDevCenterFile pSDevCenterFile = new PSDevCenterFile();
                pSDevCenterFile.setPSDevCenterFileId(this.getRootPSDevCenterFileId());
                PSDevCenterFileService pSDevCenterFileService = (PSDevCenterFileService)ServiceGlobal.getService(PSDevCenterFileService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterFileService.autoGet(pSDevCenterFile);
                this.rootpsdevcenterfile = pSDevCenterFile;
            }
            return this.rootpsdevcenterfile;
        }
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
                pSDevCenterService.autoGet(pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSNDFile getPSNDFile() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSNDFile();
        }
        if (this.getPSNDFileId() == null) {
            return null;
        }
        Integer n = this.objPSNDFileLock;
        synchronized (n) {
            if (this.psndfile != null && DataTypeHelper.compare((int)25, (Object)this.getPSNDFileId(), (Object)this.psndfile.getPSNDFileId()) != 0L) {
                this.psndfile = null;
            }
            if (this.psndfile == null) {
                PSNDFile pSNDFile = new PSNDFile();
                pSNDFile.setPSNDFileId(this.getPSNDFileId());
                PSNDFileService pSNDFileService = (PSNDFileService)ServiceGlobal.getService(PSNDFileService.class, (SessionFactory)this.getSessionFactory());
                pSNDFileService.autoGet(pSNDFile);
                this.psndfile = pSNDFile;
            }
            return this.psndfile;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSTaskServer getPSTaskServer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSTaskServer();
        }
        if (this.getPSTaskServerId() == null) {
            return null;
        }
        Integer n = this.objPSTaskServerLock;
        synchronized (n) {
            if (this.pstaskserver != null && DataTypeHelper.compare((int)25, (Object)this.getPSTaskServerId(), (Object)this.pstaskserver.getPSTaskServerId()) != 0L) {
                this.pstaskserver = null;
            }
            if (this.pstaskserver == null) {
                PSTaskServer pSTaskServer = new PSTaskServer();
                pSTaskServer.setPSTaskServerId(this.getPSTaskServerId());
                PSTaskServerService pSTaskServerService = (PSTaskServerService)ServiceGlobal.getService(PSTaskServerService.class, (SessionFactory)this.getSessionFactory());
                pSTaskServerService.autoGet(pSTaskServer);
                this.pstaskserver = pSTaskServer;
            }
            return this.pstaskserver;
        }
    }

    private PSDevCenterFileBase getProxyEntity() {
        return this.proxyPSDevCenterFileBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevCenterFileBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevCenterFileBase) {
            this.proxyPSDevCenterFileBase = (PSDevCenterFileBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterFileService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BIZTAG, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_FILEOBJSIZE, 3);
        fieldIndexMap.put(FIELD_FILEPATH, 4);
        fieldIndexMap.put(FIELD_FILETAG, 5);
        fieldIndexMap.put(FIELD_FILETAG2, 6);
        fieldIndexMap.put(FIELD_FILETYPE, 7);
        fieldIndexMap.put(FIELD_LASTCALCTIME, 8);
        fieldIndexMap.put(FIELD_MAXFILESIZE, 9);
        fieldIndexMap.put(FIELD_MEMO, 10);
        fieldIndexMap.put(FIELD_OWNERID, 11);
        fieldIndexMap.put(FIELD_OWNERNAME, 12);
        fieldIndexMap.put(FIELD_OWNERTYPE, 13);
        fieldIndexMap.put(FIELD_OWNERTYPENAME, 14);
        fieldIndexMap.put(FIELD_PPSDEVCENTERFILEID, 15);
        fieldIndexMap.put(FIELD_PPSDEVCENTERFILENAME, 16);
        fieldIndexMap.put(FIELD_PSDEVCENTERFILEID, 17);
        fieldIndexMap.put(FIELD_PSDEVCENTERFILENAME, 18);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 19);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 20);
        fieldIndexMap.put(FIELD_PSNDFILEID, 21);
        fieldIndexMap.put(FIELD_PSNDFILENAME, 22);
        fieldIndexMap.put(FIELD_PSTASKSERVERID, 23);
        fieldIndexMap.put(FIELD_PSTASKSERVERNAME, 24);
        fieldIndexMap.put(FIELD_ROOTPSDEVCENTERFILEID, 25);
        fieldIndexMap.put(FIELD_ROOTPSDEVCENTERFILENAME, 26);
        fieldIndexMap.put(FIELD_TOTALFILESIZE, 27);
        fieldIndexMap.put(FIELD_UPDATEDATE, 28);
        fieldIndexMap.put(FIELD_UPDATEMAN, 29);
    }
}

