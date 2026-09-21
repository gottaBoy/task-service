/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.common.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class FileBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(FileBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DIGESTCODE = "DIGESTCODE";
    public static final String FIELD_ENABLE = "ENABLE";
    public static final String FIELD_FILENAME2 = "FILENAME2";
    public static final String FIELD_FILESIZE = "FILESIZE";
    public static final String FIELD_FILEID = "FILE_ID";
    public static final String FIELD_FILENAME = "FILE_NAME";
    public static final String FIELD_FOLDER = "FOLDER";
    public static final String FIELD_LOCALPATH = "LOCALPATH";
    public static final String FIELD_LOCALPATH2 = "LOCALPATH2";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_OWNERID = "OWNERID";
    public static final String FIELD_OWNERTYPE = "OWNERTYPE";
    public static final String FIELD_PICHEIGHT = "PICHEIGHT";
    public static final String FIELD_PICWIDTH = "PICWIDTH";
    public static final String FIELD_RESERVER = "RESERVER";
    public static final String FIELD_RESERVER2 = "RESERVER2";
    public static final String FIELD_RESERVER3 = "RESERVER3";
    public static final String FIELD_RESERVER4 = "RESERVER4";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DIGESTCODE = 2;
    private static final int INDEX_ENABLE = 3;
    private static final int INDEX_FILENAME2 = 4;
    private static final int INDEX_FILESIZE = 5;
    private static final int INDEX_FILEID = 6;
    private static final int INDEX_FILENAME = 7;
    private static final int INDEX_FOLDER = 8;
    private static final int INDEX_LOCALPATH = 9;
    private static final int INDEX_LOCALPATH2 = 10;
    private static final int INDEX_MEMO = 11;
    private static final int INDEX_OWNERID = 12;
    private static final int INDEX_OWNERTYPE = 13;
    private static final int INDEX_PICHEIGHT = 14;
    private static final int INDEX_PICWIDTH = 15;
    private static final int INDEX_RESERVER = 16;
    private static final int INDEX_RESERVER2 = 17;
    private static final int INDEX_RESERVER3 = 18;
    private static final int INDEX_RESERVER4 = 19;
    private static final int INDEX_UPDATEDATE = 20;
    private static final int INDEX_UPDATEMAN = 21;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private FileBase proxyFileBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean digestcodeDirtyFlag = false;
    private boolean enableDirtyFlag = false;
    private boolean filename2DirtyFlag = false;
    private boolean filesizeDirtyFlag = false;
    private boolean fileidDirtyFlag = false;
    private boolean filenameDirtyFlag = false;
    private boolean folderDirtyFlag = false;
    private boolean localpathDirtyFlag = false;
    private boolean localpath2DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean owneridDirtyFlag = false;
    private boolean ownertypeDirtyFlag = false;
    private boolean picheightDirtyFlag = false;
    private boolean picwidthDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean reserver3DirtyFlag = false;
    private boolean reserver4DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="digestcode")
    private String digestcode;
    @Column(name="enable")
    private Integer enable;
    @Column(name="filename2")
    private String filename2;
    @Column(name="filesize")
    private Integer filesize;
    @Column(name="fileid")
    private String fileid;
    @Column(name="filename")
    private String filename;
    @Column(name="folder")
    private String folder;
    @Column(name="localpath")
    private String localpath;
    @Column(name="localpath2")
    private String localpath2;
    @Column(name="memo")
    private String memo;
    @Column(name="ownerid")
    private String ownerid;
    @Column(name="ownertype")
    private String ownertype;
    @Column(name="picheight")
    private Integer picheight;
    @Column(name="picwidth")
    private Integer picwidth;
    @Column(name="reserver")
    private String reserver;
    @Column(name="reserver2")
    private String reserver2;
    @Column(name="reserver3")
    private String reserver3;
    @Column(name="reserver4")
    private String reserver4;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DIGESTCODE, 2);
        fieldIndexMap.put(FIELD_ENABLE, 3);
        fieldIndexMap.put(FIELD_FILENAME2, 4);
        fieldIndexMap.put(FIELD_FILESIZE, 5);
        fieldIndexMap.put(FIELD_FILEID, 6);
        fieldIndexMap.put(FIELD_FILENAME, 7);
        fieldIndexMap.put(FIELD_FOLDER, 8);
        fieldIndexMap.put(FIELD_LOCALPATH, 9);
        fieldIndexMap.put(FIELD_LOCALPATH2, 10);
        fieldIndexMap.put(FIELD_MEMO, 11);
        fieldIndexMap.put(FIELD_OWNERID, 12);
        fieldIndexMap.put(FIELD_OWNERTYPE, 13);
        fieldIndexMap.put(FIELD_PICHEIGHT, 14);
        fieldIndexMap.put(FIELD_PICWIDTH, 15);
        fieldIndexMap.put(FIELD_RESERVER, 16);
        fieldIndexMap.put(FIELD_RESERVER2, 17);
        fieldIndexMap.put(FIELD_RESERVER3, 18);
        fieldIndexMap.put(FIELD_RESERVER4, 19);
        fieldIndexMap.put(FIELD_UPDATEDATE, 20);
        fieldIndexMap.put(FIELD_UPDATEMAN, 21);
    }

    public void setCreateDate(Timestamp createdate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDate(createdate);
            return;
        }
        this.createdate = createdate;
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

    public void setCreateMan(String createman) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateMan(createman);
            return;
        }
        if (createman != null && (createman = StringHelper.trimRight(createman)).length() == 0) {
            createman = null;
        }
        this.createman = createman;
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

    public void setDigestCode(String digestcode) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDigestCode(digestcode);
            return;
        }
        if (digestcode != null && (digestcode = StringHelper.trimRight(digestcode)).length() == 0) {
            digestcode = null;
        }
        this.digestcode = digestcode;
        this.digestcodeDirtyFlag = true;
    }

    public String getDigestCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDigestCode();
        }
        return this.digestcode;
    }

    public boolean isDigestCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDigestCodeDirty();
        }
        return this.digestcodeDirtyFlag;
    }

    public void resetDigestCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDigestCode();
            return;
        }
        this.digestcodeDirtyFlag = false;
        this.digestcode = null;
    }

    public void setEnable(Integer enable) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnable(enable);
            return;
        }
        this.enable = enable;
        this.enableDirtyFlag = true;
    }

    public Integer getEnable() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnable();
        }
        return this.enable;
    }

    public boolean isEnableDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDirty();
        }
        return this.enableDirtyFlag;
    }

    public void resetEnable() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnable();
            return;
        }
        this.enableDirtyFlag = false;
        this.enable = null;
    }

    public void setFileName2(String filename2) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFileName2(filename2);
            return;
        }
        if (filename2 != null && (filename2 = StringHelper.trimRight(filename2)).length() == 0) {
            filename2 = null;
        }
        this.filename2 = filename2;
        this.filename2DirtyFlag = true;
    }

    public String getFileName2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFileName2();
        }
        return this.filename2;
    }

    public boolean isFileName2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFileName2Dirty();
        }
        return this.filename2DirtyFlag;
    }

    public void resetFileName2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFileName2();
            return;
        }
        this.filename2DirtyFlag = false;
        this.filename2 = null;
    }

    public void setFileSize(Integer filesize) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFileSize(filesize);
            return;
        }
        this.filesize = filesize;
        this.filesizeDirtyFlag = true;
    }

    public Integer getFileSize() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFileSize();
        }
        return this.filesize;
    }

    public boolean isFileSizeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFileSizeDirty();
        }
        return this.filesizeDirtyFlag;
    }

    public void resetFileSize() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFileSize();
            return;
        }
        this.filesizeDirtyFlag = false;
        this.filesize = null;
    }

    public void setFileId(String fileid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFileId(fileid);
            return;
        }
        if (fileid != null && (fileid = StringHelper.trimRight(fileid)).length() == 0) {
            fileid = null;
        }
        this.fileid = fileid;
        this.fileidDirtyFlag = true;
    }

    public String getFileId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFileId();
        }
        return this.fileid;
    }

    public boolean isFileIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFileIdDirty();
        }
        return this.fileidDirtyFlag;
    }

    public void resetFileId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFileId();
            return;
        }
        this.fileidDirtyFlag = false;
        this.fileid = null;
    }

    public void setFileName(String filename) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFileName(filename);
            return;
        }
        if (filename != null && (filename = StringHelper.trimRight(filename)).length() == 0) {
            filename = null;
        }
        this.filename = filename;
        this.filenameDirtyFlag = true;
    }

    public String getFileName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFileName();
        }
        return this.filename;
    }

    public boolean isFileNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFileNameDirty();
        }
        return this.filenameDirtyFlag;
    }

    public void resetFileName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFileName();
            return;
        }
        this.filenameDirtyFlag = false;
        this.filename = null;
    }

    public void setFolder(String folder) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFolder(folder);
            return;
        }
        if (folder != null && (folder = StringHelper.trimRight(folder)).length() == 0) {
            folder = null;
        }
        this.folder = folder;
        this.folderDirtyFlag = true;
    }

    public String getFolder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFolder();
        }
        return this.folder;
    }

    public boolean isFolderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFolderDirty();
        }
        return this.folderDirtyFlag;
    }

    public void resetFolder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFolder();
            return;
        }
        this.folderDirtyFlag = false;
        this.folder = null;
    }

    public void setLocalPath(String localpath) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLocalPath(localpath);
            return;
        }
        if (localpath != null && (localpath = StringHelper.trimRight(localpath)).length() == 0) {
            localpath = null;
        }
        this.localpath = localpath;
        this.localpathDirtyFlag = true;
    }

    public String getLocalPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLocalPath();
        }
        return this.localpath;
    }

    public boolean isLocalPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLocalPathDirty();
        }
        return this.localpathDirtyFlag;
    }

    public void resetLocalPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLocalPath();
            return;
        }
        this.localpathDirtyFlag = false;
        this.localpath = null;
    }

    public void setLocalPath2(String localpath2) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLocalPath2(localpath2);
            return;
        }
        if (localpath2 != null && (localpath2 = StringHelper.trimRight(localpath2)).length() == 0) {
            localpath2 = null;
        }
        this.localpath2 = localpath2;
        this.localpath2DirtyFlag = true;
    }

    public String getLocalPath2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLocalPath2();
        }
        return this.localpath2;
    }

    public boolean isLocalPath2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLocalPath2Dirty();
        }
        return this.localpath2DirtyFlag;
    }

    public void resetLocalPath2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLocalPath2();
            return;
        }
        this.localpath2DirtyFlag = false;
        this.localpath2 = null;
    }

    public void setMemo(String memo) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMemo(memo);
            return;
        }
        if (memo != null && (memo = StringHelper.trimRight(memo)).length() == 0) {
            memo = null;
        }
        this.memo = memo;
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

    public void setOwnerId(String ownerid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOwnerId(ownerid);
            return;
        }
        if (ownerid != null && (ownerid = StringHelper.trimRight(ownerid)).length() == 0) {
            ownerid = null;
        }
        this.ownerid = ownerid;
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

    public void setOwnerType(String ownertype) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOwnerType(ownertype);
            return;
        }
        if (ownertype != null && (ownertype = StringHelper.trimRight(ownertype)).length() == 0) {
            ownertype = null;
        }
        this.ownertype = ownertype;
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

    public void setPicHeight(Integer picheight) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPicHeight(picheight);
            return;
        }
        this.picheight = picheight;
        this.picheightDirtyFlag = true;
    }

    public Integer getPicHeight() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPicHeight();
        }
        return this.picheight;
    }

    public boolean isPicHeightDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPicHeightDirty();
        }
        return this.picheightDirtyFlag;
    }

    public void resetPicHeight() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPicHeight();
            return;
        }
        this.picheightDirtyFlag = false;
        this.picheight = null;
    }

    public void setPicWidth(Integer picwidth) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPicWidth(picwidth);
            return;
        }
        this.picwidth = picwidth;
        this.picwidthDirtyFlag = true;
    }

    public Integer getPicWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPicWidth();
        }
        return this.picwidth;
    }

    public boolean isPicWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPicWidthDirty();
        }
        return this.picwidthDirtyFlag;
    }

    public void resetPicWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPicWidth();
            return;
        }
        this.picwidthDirtyFlag = false;
        this.picwidth = null;
    }

    public void setReserver(String reserver) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver(reserver);
            return;
        }
        if (reserver != null && (reserver = StringHelper.trimRight(reserver)).length() == 0) {
            reserver = null;
        }
        this.reserver = reserver;
        this.reserverDirtyFlag = true;
    }

    public String getReserver() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver();
        }
        return this.reserver;
    }

    public boolean isReserverDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserverDirty();
        }
        return this.reserverDirtyFlag;
    }

    public void resetReserver() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver();
            return;
        }
        this.reserverDirtyFlag = false;
        this.reserver = null;
    }

    public void setReserver2(String reserver2) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver2(reserver2);
            return;
        }
        if (reserver2 != null && (reserver2 = StringHelper.trimRight(reserver2)).length() == 0) {
            reserver2 = null;
        }
        this.reserver2 = reserver2;
        this.reserver2DirtyFlag = true;
    }

    public String getReserver2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver2();
        }
        return this.reserver2;
    }

    public boolean isReserver2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver2Dirty();
        }
        return this.reserver2DirtyFlag;
    }

    public void resetReserver2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver2();
            return;
        }
        this.reserver2DirtyFlag = false;
        this.reserver2 = null;
    }

    public void setReserver3(String reserver3) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver3(reserver3);
            return;
        }
        if (reserver3 != null && (reserver3 = StringHelper.trimRight(reserver3)).length() == 0) {
            reserver3 = null;
        }
        this.reserver3 = reserver3;
        this.reserver3DirtyFlag = true;
    }

    public String getReserver3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver3();
        }
        return this.reserver3;
    }

    public boolean isReserver3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver3Dirty();
        }
        return this.reserver3DirtyFlag;
    }

    public void resetReserver3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver3();
            return;
        }
        this.reserver3DirtyFlag = false;
        this.reserver3 = null;
    }

    public void setReserver4(String reserver4) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver4(reserver4);
            return;
        }
        if (reserver4 != null && (reserver4 = StringHelper.trimRight(reserver4)).length() == 0) {
            reserver4 = null;
        }
        this.reserver4 = reserver4;
        this.reserver4DirtyFlag = true;
    }

    public String getReserver4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver4();
        }
        return this.reserver4;
    }

    public boolean isReserver4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver4Dirty();
        }
        return this.reserver4DirtyFlag;
    }

    public void resetReserver4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver4();
            return;
        }
        this.reserver4DirtyFlag = false;
        this.reserver4 = null;
    }

    public void setUpdateDate(Timestamp updatedate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDate(updatedate);
            return;
        }
        this.updatedate = updatedate;
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

    public void setUpdateMan(String updateman) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateMan(updateman);
            return;
        }
        if (updateman != null && (updateman = StringHelper.trimRight(updateman)).length() == 0) {
            updateman = null;
        }
        this.updateman = updateman;
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

    @Override
    protected void onReset() {
        FileBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(FileBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetDigestCode();
        et.resetEnable();
        et.resetFileName2();
        et.resetFileSize();
        et.resetFileId();
        et.resetFileName();
        et.resetFolder();
        et.resetLocalPath();
        et.resetLocalPath2();
        et.resetMemo();
        et.resetOwnerId();
        et.resetOwnerType();
        et.resetPicHeight();
        et.resetPicWidth();
        et.resetReserver();
        et.resetReserver2();
        et.resetReserver3();
        et.resetReserver4();
        et.resetUpdateDate();
        et.resetUpdateMan();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isDigestCodeDirty()) {
            params.put(FIELD_DIGESTCODE, this.getDigestCode());
        }
        if (!bDirtyOnly || this.isEnableDirty()) {
            params.put(FIELD_ENABLE, this.getEnable());
        }
        if (!bDirtyOnly || this.isFileName2Dirty()) {
            params.put(FIELD_FILENAME2, this.getFileName2());
        }
        if (!bDirtyOnly || this.isFileSizeDirty()) {
            params.put(FIELD_FILESIZE, this.getFileSize());
        }
        if (!bDirtyOnly || this.isFileIdDirty()) {
            params.put(FIELD_FILEID, this.getFileId());
        }
        if (!bDirtyOnly || this.isFileNameDirty()) {
            params.put(FIELD_FILENAME, this.getFileName());
        }
        if (!bDirtyOnly || this.isFolderDirty()) {
            params.put(FIELD_FOLDER, this.getFolder());
        }
        if (!bDirtyOnly || this.isLocalPathDirty()) {
            params.put(FIELD_LOCALPATH, this.getLocalPath());
        }
        if (!bDirtyOnly || this.isLocalPath2Dirty()) {
            params.put(FIELD_LOCALPATH2, this.getLocalPath2());
        }
        if (!bDirtyOnly || this.isMemoDirty()) {
            params.put(FIELD_MEMO, this.getMemo());
        }
        if (!bDirtyOnly || this.isOwnerIdDirty()) {
            params.put(FIELD_OWNERID, this.getOwnerId());
        }
        if (!bDirtyOnly || this.isOwnerTypeDirty()) {
            params.put(FIELD_OWNERTYPE, this.getOwnerType());
        }
        if (!bDirtyOnly || this.isPicHeightDirty()) {
            params.put(FIELD_PICHEIGHT, this.getPicHeight());
        }
        if (!bDirtyOnly || this.isPicWidthDirty()) {
            params.put(FIELD_PICWIDTH, this.getPicWidth());
        }
        if (!bDirtyOnly || this.isReserverDirty()) {
            params.put(FIELD_RESERVER, this.getReserver());
        }
        if (!bDirtyOnly || this.isReserver2Dirty()) {
            params.put(FIELD_RESERVER2, this.getReserver2());
        }
        if (!bDirtyOnly || this.isReserver3Dirty()) {
            params.put(FIELD_RESERVER3, this.getReserver3());
        }
        if (!bDirtyOnly || this.isReserver4Dirty()) {
            params.put(FIELD_RESERVER4, this.getReserver4());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        super.onFillMap(params, bDirtyOnly);
    }

    @Override
    public Object get(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().get(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.get(strParamName);
        }
        return FileBase.get(this, index);
    }

    private static Object get(FileBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate();
            }
            case 1: {
                return et.getCreateMan();
            }
            case 2: {
                return et.getDigestCode();
            }
            case 3: {
                return et.getEnable();
            }
            case 4: {
                return et.getFileName2();
            }
            case 5: {
                return et.getFileSize();
            }
            case 6: {
                return et.getFileId();
            }
            case 7: {
                return et.getFileName();
            }
            case 8: {
                return et.getFolder();
            }
            case 9: {
                return et.getLocalPath();
            }
            case 10: {
                return et.getLocalPath2();
            }
            case 11: {
                return et.getMemo();
            }
            case 12: {
                return et.getOwnerId();
            }
            case 13: {
                return et.getOwnerType();
            }
            case 14: {
                return et.getPicHeight();
            }
            case 15: {
                return et.getPicWidth();
            }
            case 16: {
                return et.getReserver();
            }
            case 17: {
                return et.getReserver2();
            }
            case 18: {
                return et.getReserver3();
            }
            case 19: {
                return et.getReserver4();
            }
            case 20: {
                return et.getUpdateDate();
            }
            case 21: {
                return et.getUpdateMan();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public void set(String strParamName, Object objValue) throws Exception {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().set(strParamName, objValue);
            return;
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            super.set(strParamName, objValue);
            return;
        }
        FileBase.set(this, index, objValue);
    }

    private static void set(FileBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 1: {
                et.setCreateMan(DataObject.getStringValue(obj));
                return;
            }
            case 2: {
                et.setDigestCode(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setEnable(DataObject.getIntegerValue(obj));
                return;
            }
            case 4: {
                et.setFileName2(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setFileSize(DataObject.getIntegerValue(obj));
                return;
            }
            case 6: {
                et.setFileId(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setFileName(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setFolder(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setLocalPath(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setLocalPath2(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setMemo(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setOwnerId(DataObject.getStringValue(obj));
                return;
            }
            case 13: {
                et.setOwnerType(DataObject.getStringValue(obj));
                return;
            }
            case 14: {
                et.setPicHeight(DataObject.getIntegerValue(obj));
                return;
            }
            case 15: {
                et.setPicWidth(DataObject.getIntegerValue(obj));
                return;
            }
            case 16: {
                et.setReserver(DataObject.getStringValue(obj));
                return;
            }
            case 17: {
                et.setReserver2(DataObject.getStringValue(obj));
                return;
            }
            case 18: {
                et.setReserver3(DataObject.getStringValue(obj));
                return;
            }
            case 19: {
                et.setReserver4(DataObject.getStringValue(obj));
                return;
            }
            case 20: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 21: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean isNull(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNull(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.isNull(strParamName);
        }
        return FileBase.isNull(this, index);
    }

    private static boolean isNull(FileBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate() == null;
            }
            case 1: {
                return et.getCreateMan() == null;
            }
            case 2: {
                return et.getDigestCode() == null;
            }
            case 3: {
                return et.getEnable() == null;
            }
            case 4: {
                return et.getFileName2() == null;
            }
            case 5: {
                return et.getFileSize() == null;
            }
            case 6: {
                return et.getFileId() == null;
            }
            case 7: {
                return et.getFileName() == null;
            }
            case 8: {
                return et.getFolder() == null;
            }
            case 9: {
                return et.getLocalPath() == null;
            }
            case 10: {
                return et.getLocalPath2() == null;
            }
            case 11: {
                return et.getMemo() == null;
            }
            case 12: {
                return et.getOwnerId() == null;
            }
            case 13: {
                return et.getOwnerType() == null;
            }
            case 14: {
                return et.getPicHeight() == null;
            }
            case 15: {
                return et.getPicWidth() == null;
            }
            case 16: {
                return et.getReserver() == null;
            }
            case 17: {
                return et.getReserver2() == null;
            }
            case 18: {
                return et.getReserver3() == null;
            }
            case 19: {
                return et.getReserver4() == null;
            }
            case 20: {
                return et.getUpdateDate() == null;
            }
            case 21: {
                return et.getUpdateMan() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean contains(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().contains(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.contains(strParamName);
        }
        return FileBase.contains(this, index);
    }

    private static boolean contains(FileBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCreateDateDirty();
            }
            case 1: {
                return et.isCreateManDirty();
            }
            case 2: {
                return et.isDigestCodeDirty();
            }
            case 3: {
                return et.isEnableDirty();
            }
            case 4: {
                return et.isFileName2Dirty();
            }
            case 5: {
                return et.isFileSizeDirty();
            }
            case 6: {
                return et.isFileIdDirty();
            }
            case 7: {
                return et.isFileNameDirty();
            }
            case 8: {
                return et.isFolderDirty();
            }
            case 9: {
                return et.isLocalPathDirty();
            }
            case 10: {
                return et.isLocalPath2Dirty();
            }
            case 11: {
                return et.isMemoDirty();
            }
            case 12: {
                return et.isOwnerIdDirty();
            }
            case 13: {
                return et.isOwnerTypeDirty();
            }
            case 14: {
                return et.isPicHeightDirty();
            }
            case 15: {
                return et.isPicWidthDirty();
            }
            case 16: {
                return et.isReserverDirty();
            }
            case 17: {
                return et.isReserver2Dirty();
            }
            case 18: {
                return et.isReserver3Dirty();
            }
            case 19: {
                return et.isReserver4Dirty();
            }
            case 20: {
                return et.isUpdateDateDirty();
            }
            case 21: {
                return et.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        FileBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(FileBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", FileBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", FileBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getDigestCode() != null) {
            JSONObjectHelper.put(json, "digestcode", FileBase.getJSONValue(et.getDigestCode()), false);
        }
        if (bIncEmpty || et.getEnable() != null) {
            JSONObjectHelper.put(json, "enable", FileBase.getJSONValue(et.getEnable()), false);
        }
        if (bIncEmpty || et.getFileName2() != null) {
            JSONObjectHelper.put(json, "filename2", FileBase.getJSONValue(et.getFileName2()), false);
        }
        if (bIncEmpty || et.getFileSize() != null) {
            JSONObjectHelper.put(json, "filesize", FileBase.getJSONValue(et.getFileSize()), false);
        }
        if (bIncEmpty || et.getFileId() != null) {
            JSONObjectHelper.put(json, "file_id", FileBase.getJSONValue(et.getFileId()), false);
        }
        if (bIncEmpty || et.getFileName() != null) {
            JSONObjectHelper.put(json, "file_name", FileBase.getJSONValue(et.getFileName()), false);
        }
        if (bIncEmpty || et.getFolder() != null) {
            JSONObjectHelper.put(json, "folder", FileBase.getJSONValue(et.getFolder()), false);
        }
        if (bIncEmpty || et.getLocalPath() != null) {
            JSONObjectHelper.put(json, "localpath", FileBase.getJSONValue(et.getLocalPath()), false);
        }
        if (bIncEmpty || et.getLocalPath2() != null) {
            JSONObjectHelper.put(json, "localpath2", FileBase.getJSONValue(et.getLocalPath2()), false);
        }
        if (bIncEmpty || et.getMemo() != null) {
            JSONObjectHelper.put(json, "memo", FileBase.getJSONValue(et.getMemo()), false);
        }
        if (bIncEmpty || et.getOwnerId() != null) {
            JSONObjectHelper.put(json, "ownerid", FileBase.getJSONValue(et.getOwnerId()), false);
        }
        if (bIncEmpty || et.getOwnerType() != null) {
            JSONObjectHelper.put(json, "ownertype", FileBase.getJSONValue(et.getOwnerType()), false);
        }
        if (bIncEmpty || et.getPicHeight() != null) {
            JSONObjectHelper.put(json, "picheight", FileBase.getJSONValue(et.getPicHeight()), false);
        }
        if (bIncEmpty || et.getPicWidth() != null) {
            JSONObjectHelper.put(json, "picwidth", FileBase.getJSONValue(et.getPicWidth()), false);
        }
        if (bIncEmpty || et.getReserver() != null) {
            JSONObjectHelper.put(json, "reserver", FileBase.getJSONValue(et.getReserver()), false);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            JSONObjectHelper.put(json, "reserver2", FileBase.getJSONValue(et.getReserver2()), false);
        }
        if (bIncEmpty || et.getReserver3() != null) {
            JSONObjectHelper.put(json, "reserver3", FileBase.getJSONValue(et.getReserver3()), false);
        }
        if (bIncEmpty || et.getReserver4() != null) {
            JSONObjectHelper.put(json, "reserver4", FileBase.getJSONValue(et.getReserver4()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", FileBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", FileBase.getJSONValue(et.getUpdateMan()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        FileBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(FileBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDigestCode() != null) {
            obj = et.getDigestCode();
            node.setAttribute(FIELD_DIGESTCODE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getEnable() != null) {
            obj = et.getEnable();
            node.setAttribute(FIELD_ENABLE, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getFileName2() != null) {
            obj = et.getFileName2();
            node.setAttribute(FIELD_FILENAME2, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getFileSize() != null) {
            obj = et.getFileSize();
            node.setAttribute(FIELD_FILESIZE, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getFileId() != null) {
            obj = et.getFileId();
            node.setAttribute("FILEID", obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getFileName() != null) {
            obj = et.getFileName();
            node.setAttribute("FILENAME", obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getFolder() != null) {
            obj = et.getFolder();
            node.setAttribute(FIELD_FOLDER, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getLocalPath() != null) {
            obj = et.getLocalPath();
            node.setAttribute(FIELD_LOCALPATH, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getLocalPath2() != null) {
            obj = et.getLocalPath2();
            node.setAttribute(FIELD_LOCALPATH2, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMemo() != null) {
            obj = et.getMemo();
            node.setAttribute(FIELD_MEMO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getOwnerId() != null) {
            obj = et.getOwnerId();
            node.setAttribute(FIELD_OWNERID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getOwnerType() != null) {
            obj = et.getOwnerType();
            node.setAttribute(FIELD_OWNERTYPE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getPicHeight() != null) {
            obj = et.getPicHeight();
            node.setAttribute(FIELD_PICHEIGHT, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getPicWidth() != null) {
            obj = et.getPicWidth();
            node.setAttribute(FIELD_PICWIDTH, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getReserver() != null) {
            obj = et.getReserver();
            node.setAttribute(FIELD_RESERVER, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            obj = et.getReserver2();
            node.setAttribute(FIELD_RESERVER2, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver3() != null) {
            obj = et.getReserver3();
            node.setAttribute(FIELD_RESERVER3, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver4() != null) {
            obj = et.getReserver4();
            node.setAttribute(FIELD_RESERVER4, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        FileBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(FileBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isDigestCodeDirty() && (bIncEmpty || et.getDigestCode() != null)) {
            dst.set(FIELD_DIGESTCODE, et.getDigestCode());
        }
        if (et.isEnableDirty() && (bIncEmpty || et.getEnable() != null)) {
            dst.set(FIELD_ENABLE, et.getEnable());
        }
        if (et.isFileName2Dirty() && (bIncEmpty || et.getFileName2() != null)) {
            dst.set(FIELD_FILENAME2, et.getFileName2());
        }
        if (et.isFileSizeDirty() && (bIncEmpty || et.getFileSize() != null)) {
            dst.set(FIELD_FILESIZE, et.getFileSize());
        }
        if (et.isFileIdDirty() && (bIncEmpty || et.getFileId() != null)) {
            dst.set(FIELD_FILEID, et.getFileId());
        }
        if (et.isFileNameDirty() && (bIncEmpty || et.getFileName() != null)) {
            dst.set(FIELD_FILENAME, et.getFileName());
        }
        if (et.isFolderDirty() && (bIncEmpty || et.getFolder() != null)) {
            dst.set(FIELD_FOLDER, et.getFolder());
        }
        if (et.isLocalPathDirty() && (bIncEmpty || et.getLocalPath() != null)) {
            dst.set(FIELD_LOCALPATH, et.getLocalPath());
        }
        if (et.isLocalPath2Dirty() && (bIncEmpty || et.getLocalPath2() != null)) {
            dst.set(FIELD_LOCALPATH2, et.getLocalPath2());
        }
        if (et.isMemoDirty() && (bIncEmpty || et.getMemo() != null)) {
            dst.set(FIELD_MEMO, et.getMemo());
        }
        if (et.isOwnerIdDirty() && (bIncEmpty || et.getOwnerId() != null)) {
            dst.set(FIELD_OWNERID, et.getOwnerId());
        }
        if (et.isOwnerTypeDirty() && (bIncEmpty || et.getOwnerType() != null)) {
            dst.set(FIELD_OWNERTYPE, et.getOwnerType());
        }
        if (et.isPicHeightDirty() && (bIncEmpty || et.getPicHeight() != null)) {
            dst.set(FIELD_PICHEIGHT, et.getPicHeight());
        }
        if (et.isPicWidthDirty() && (bIncEmpty || et.getPicWidth() != null)) {
            dst.set(FIELD_PICWIDTH, et.getPicWidth());
        }
        if (et.isReserverDirty() && (bIncEmpty || et.getReserver() != null)) {
            dst.set(FIELD_RESERVER, et.getReserver());
        }
        if (et.isReserver2Dirty() && (bIncEmpty || et.getReserver2() != null)) {
            dst.set(FIELD_RESERVER2, et.getReserver2());
        }
        if (et.isReserver3Dirty() && (bIncEmpty || et.getReserver3() != null)) {
            dst.set(FIELD_RESERVER3, et.getReserver3());
        }
        if (et.isReserver4Dirty() && (bIncEmpty || et.getReserver4() != null)) {
            dst.set(FIELD_RESERVER4, et.getReserver4());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
    }

    @Override
    public boolean remove(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().remove(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.remove(strParamName);
        }
        return FileBase.remove(this, index);
    }

    private static boolean remove(FileBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetCreateDate();
                return true;
            }
            case 1: {
                et.resetCreateMan();
                return true;
            }
            case 2: {
                et.resetDigestCode();
                return true;
            }
            case 3: {
                et.resetEnable();
                return true;
            }
            case 4: {
                et.resetFileName2();
                return true;
            }
            case 5: {
                et.resetFileSize();
                return true;
            }
            case 6: {
                et.resetFileId();
                return true;
            }
            case 7: {
                et.resetFileName();
                return true;
            }
            case 8: {
                et.resetFolder();
                return true;
            }
            case 9: {
                et.resetLocalPath();
                return true;
            }
            case 10: {
                et.resetLocalPath2();
                return true;
            }
            case 11: {
                et.resetMemo();
                return true;
            }
            case 12: {
                et.resetOwnerId();
                return true;
            }
            case 13: {
                et.resetOwnerType();
                return true;
            }
            case 14: {
                et.resetPicHeight();
                return true;
            }
            case 15: {
                et.resetPicWidth();
                return true;
            }
            case 16: {
                et.resetReserver();
                return true;
            }
            case 17: {
                et.resetReserver2();
                return true;
            }
            case 18: {
                et.resetReserver3();
                return true;
            }
            case 19: {
                et.resetReserver4();
                return true;
            }
            case 20: {
                et.resetUpdateDate();
                return true;
            }
            case 21: {
                et.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private FileBase getProxyEntity() {
        return this.proxyFileBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyFileBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof FileBase) {
            this.proxyFileBase = (FileBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.FileService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

