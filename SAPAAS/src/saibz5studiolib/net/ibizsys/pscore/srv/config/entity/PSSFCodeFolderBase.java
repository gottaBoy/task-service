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
import java.util.ArrayList;
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
import net.ibizsys.pscore.srv.config.entity.PSSFCodeType;
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.entity.PSSFStylePrj;
import net.ibizsys.pscore.srv.config.service.PSSFCodeTypeService;
import net.ibizsys.pscore.srv.config.service.PSSFStylePrjService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFCodeFolderBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSFCodeFolderBase.class);
    public static final String FIELD_BOTTOMCODE = "BOTTOMCODE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FOLDERNAME = "FOLDERNAME";
    public static final String FIELD_HEADERCODE = "HEADERCODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODELLEVEL = "MODELLEVEL";
    public static final String FIELD_PRJFOLDER = "PRJFOLDER";
    public static final String FIELD_PSSFCODEFOLDERID = "PSSFCODEFOLDERID";
    public static final String FIELD_PSSFCODEFOLDERNAME = "PSSFCODEFOLDERNAME";
    public static final String FIELD_PSSFSTYLEID = "PSSFSTYLEID";
    public static final String FIELD_PSSFSTYLENAME = "PSSFSTYLENAME";
    public static final String FIELD_PSSFSTYLEPRJID = "PSSFSTYLEPRJID";
    public static final String FIELD_PSSFSTYLEPRJNAME = "PSSFSTYLEPRJNAME";
    public static final String FIELD_PUBFLAG = "PUBFLAG";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_BOTTOMCODE = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_FOLDERNAME = 3;
    private static final int INDEX_HEADERCODE = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_MODELLEVEL = 6;
    private static final int INDEX_PRJFOLDER = 7;
    private static final int INDEX_PSSFCODEFOLDERID = 8;
    private static final int INDEX_PSSFCODEFOLDERNAME = 9;
    private static final int INDEX_PSSFSTYLEID = 10;
    private static final int INDEX_PSSFSTYLENAME = 11;
    private static final int INDEX_PSSFSTYLEPRJID = 12;
    private static final int INDEX_PSSFSTYLEPRJNAME = 13;
    private static final int INDEX_PUBFLAG = 14;
    private static final int INDEX_UPDATEDATE = 15;
    private static final int INDEX_UPDATEMAN = 16;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSFCodeFolderBase proxyPSSFCodeFolderBase = null;
    private boolean bottomcodeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean foldernameDirtyFlag = false;
    private boolean headercodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modellevelDirtyFlag = false;
    private boolean prjfolderDirtyFlag = false;
    private boolean pssfcodefolderidDirtyFlag = false;
    private boolean pssfcodefoldernameDirtyFlag = false;
    private boolean pssfstyleidDirtyFlag = false;
    private boolean pssfstylenameDirtyFlag = false;
    private boolean pssfstyleprjidDirtyFlag = false;
    private boolean pssfstyleprjnameDirtyFlag = false;
    private boolean pubflagDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="bottomcode")
    private String bottomcode;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="foldername")
    private String foldername;
    @Column(name="headercode")
    private String headercode;
    @Column(name="memo")
    private String memo;
    @Column(name="modellevel")
    private Integer modellevel;
    @Column(name="prjfolder")
    private String prjfolder;
    @Column(name="pssfcodefolderid")
    private String pssfcodefolderid;
    @Column(name="pssfcodefoldername")
    private String pssfcodefoldername;
    @Column(name="pssfstyleid")
    private String pssfstyleid;
    @Column(name="pssfstylename")
    private String pssfstylename;
    @Column(name="pssfstyleprjid")
    private String pssfstyleprjid;
    @Column(name="pssfstyleprjname")
    private String pssfstyleprjname;
    @Column(name="pubflag")
    private Integer pubflag;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSSFStylePrjLock = new Integer(1);
    private PSSFStylePrj pssfstyleprj = null;
    private Integer objPSSFStyleLock = new Integer(1);
    private PSSFStyle pssfstyle = null;
    private Integer objPSSFCodeTypesLock = new Integer(1);
    private ArrayList<PSSFCodeType> pssfcodetypes = null;

    public void setBottomCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBottomCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bottomcode = string;
        this.bottomcodeDirtyFlag = true;
    }

    public String getBottomCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBottomCode();
        }
        return this.bottomcode;
    }

    public boolean isBottomCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBottomCodeDirty();
        }
        return this.bottomcodeDirtyFlag;
    }

    public void resetBottomCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBottomCode();
            return;
        }
        this.bottomcodeDirtyFlag = false;
        this.bottomcode = null;
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

    public void setFolderName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFolderName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.foldername = string;
        this.foldernameDirtyFlag = true;
    }

    public String getFolderName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFolderName();
        }
        return this.foldername;
    }

    public boolean isFolderNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFolderNameDirty();
        }
        return this.foldernameDirtyFlag;
    }

    public void resetFolderName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFolderName();
            return;
        }
        this.foldernameDirtyFlag = false;
        this.foldername = null;
    }

    public void setHeaderCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHeaderCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.headercode = string;
        this.headercodeDirtyFlag = true;
    }

    public String getHeaderCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHeaderCode();
        }
        return this.headercode;
    }

    public boolean isHeaderCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHeaderCodeDirty();
        }
        return this.headercodeDirtyFlag;
    }

    public void resetHeaderCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHeaderCode();
            return;
        }
        this.headercodeDirtyFlag = false;
        this.headercode = null;
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

    public void setModelLevel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelLevel(n);
            return;
        }
        this.modellevel = n;
        this.modellevelDirtyFlag = true;
    }

    public Integer getModelLevel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelLevel();
        }
        return this.modellevel;
    }

    public boolean isModelLevelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelLevelDirty();
        }
        return this.modellevelDirtyFlag;
    }

    public void resetModelLevel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelLevel();
            return;
        }
        this.modellevelDirtyFlag = false;
        this.modellevel = null;
    }

    public void setPrjFolder(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrjFolder(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.prjfolder = string;
        this.prjfolderDirtyFlag = true;
    }

    public String getPrjFolder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrjFolder();
        }
        return this.prjfolder;
    }

    public boolean isPrjFolderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrjFolderDirty();
        }
        return this.prjfolderDirtyFlag;
    }

    public void resetPrjFolder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrjFolder();
            return;
        }
        this.prjfolderDirtyFlag = false;
        this.prjfolder = null;
    }

    public void setPSSFCodeFolderId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFCodeFolderId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfcodefolderid = string;
        this.pssfcodefolderidDirtyFlag = true;
    }

    public String getPSSFCodeFolderId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFCodeFolderId();
        }
        return this.pssfcodefolderid;
    }

    public boolean isPSSFCodeFolderIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFCodeFolderIdDirty();
        }
        return this.pssfcodefolderidDirtyFlag;
    }

    public void resetPSSFCodeFolderId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFCodeFolderId();
            return;
        }
        this.pssfcodefolderidDirtyFlag = false;
        this.pssfcodefolderid = null;
    }

    public void setPSSFCodeFolderName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFCodeFolderName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfcodefoldername = string;
        this.pssfcodefoldernameDirtyFlag = true;
    }

    public String getPSSFCodeFolderName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFCodeFolderName();
        }
        return this.pssfcodefoldername;
    }

    public boolean isPSSFCodeFolderNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFCodeFolderNameDirty();
        }
        return this.pssfcodefoldernameDirtyFlag;
    }

    public void resetPSSFCodeFolderName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFCodeFolderName();
            return;
        }
        this.pssfcodefoldernameDirtyFlag = false;
        this.pssfcodefoldername = null;
    }

    public void setPSSFStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstyleid = string;
        this.pssfstyleidDirtyFlag = true;
    }

    public String getPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleId();
        }
        return this.pssfstyleid;
    }

    public boolean isPSSFStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleIdDirty();
        }
        return this.pssfstyleidDirtyFlag;
    }

    public void resetPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleId();
            return;
        }
        this.pssfstyleidDirtyFlag = false;
        this.pssfstyleid = null;
    }

    public void setPSSFStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstylename = string;
        this.pssfstylenameDirtyFlag = true;
    }

    public String getPSSFStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleName();
        }
        return this.pssfstylename;
    }

    public boolean isPSSFStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleNameDirty();
        }
        return this.pssfstylenameDirtyFlag;
    }

    public void resetPSSFStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleName();
            return;
        }
        this.pssfstylenameDirtyFlag = false;
        this.pssfstylename = null;
    }

    public void setPSSFStylePrjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStylePrjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstyleprjid = string;
        this.pssfstyleprjidDirtyFlag = true;
    }

    public String getPSSFStylePrjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStylePrjId();
        }
        return this.pssfstyleprjid;
    }

    public boolean isPSSFStylePrjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStylePrjIdDirty();
        }
        return this.pssfstyleprjidDirtyFlag;
    }

    public void resetPSSFStylePrjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStylePrjId();
            return;
        }
        this.pssfstyleprjidDirtyFlag = false;
        this.pssfstyleprjid = null;
    }

    public void setPSSFStylePrjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStylePrjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstyleprjname = string;
        this.pssfstyleprjnameDirtyFlag = true;
    }

    public String getPSSFStylePrjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStylePrjName();
        }
        return this.pssfstyleprjname;
    }

    public boolean isPSSFStylePrjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStylePrjNameDirty();
        }
        return this.pssfstyleprjnameDirtyFlag;
    }

    public void resetPSSFStylePrjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStylePrjName();
            return;
        }
        this.pssfstyleprjnameDirtyFlag = false;
        this.pssfstyleprjname = null;
    }

    public void setPubFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubFlag(n);
            return;
        }
        this.pubflag = n;
        this.pubflagDirtyFlag = true;
    }

    public Integer getPubFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubFlag();
        }
        return this.pubflag;
    }

    public boolean isPubFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubFlagDirty();
        }
        return this.pubflagDirtyFlag;
    }

    public void resetPubFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubFlag();
            return;
        }
        this.pubflagDirtyFlag = false;
        this.pubflag = null;
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
        PSSFCodeFolderBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSFCodeFolderBase pSSFCodeFolderBase) {
        pSSFCodeFolderBase.resetBottomCode();
        pSSFCodeFolderBase.resetCreateDate();
        pSSFCodeFolderBase.resetCreateMan();
        pSSFCodeFolderBase.resetFolderName();
        pSSFCodeFolderBase.resetHeaderCode();
        pSSFCodeFolderBase.resetMemo();
        pSSFCodeFolderBase.resetModelLevel();
        pSSFCodeFolderBase.resetPrjFolder();
        pSSFCodeFolderBase.resetPSSFCodeFolderId();
        pSSFCodeFolderBase.resetPSSFCodeFolderName();
        pSSFCodeFolderBase.resetPSSFStyleId();
        pSSFCodeFolderBase.resetPSSFStyleName();
        pSSFCodeFolderBase.resetPSSFStylePrjId();
        pSSFCodeFolderBase.resetPSSFStylePrjName();
        pSSFCodeFolderBase.resetPubFlag();
        pSSFCodeFolderBase.resetUpdateDate();
        pSSFCodeFolderBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBottomCodeDirty()) {
            hashMap.put(FIELD_BOTTOMCODE, this.getBottomCode());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isFolderNameDirty()) {
            hashMap.put(FIELD_FOLDERNAME, this.getFolderName());
        }
        if (!bl || this.isHeaderCodeDirty()) {
            hashMap.put(FIELD_HEADERCODE, this.getHeaderCode());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isModelLevelDirty()) {
            hashMap.put(FIELD_MODELLEVEL, this.getModelLevel());
        }
        if (!bl || this.isPrjFolderDirty()) {
            hashMap.put(FIELD_PRJFOLDER, this.getPrjFolder());
        }
        if (!bl || this.isPSSFCodeFolderIdDirty()) {
            hashMap.put(FIELD_PSSFCODEFOLDERID, this.getPSSFCodeFolderId());
        }
        if (!bl || this.isPSSFCodeFolderNameDirty()) {
            hashMap.put(FIELD_PSSFCODEFOLDERNAME, this.getPSSFCodeFolderName());
        }
        if (!bl || this.isPSSFStyleIdDirty()) {
            hashMap.put(FIELD_PSSFSTYLEID, this.getPSSFStyleId());
        }
        if (!bl || this.isPSSFStyleNameDirty()) {
            hashMap.put(FIELD_PSSFSTYLENAME, this.getPSSFStyleName());
        }
        if (!bl || this.isPSSFStylePrjIdDirty()) {
            hashMap.put(FIELD_PSSFSTYLEPRJID, this.getPSSFStylePrjId());
        }
        if (!bl || this.isPSSFStylePrjNameDirty()) {
            hashMap.put(FIELD_PSSFSTYLEPRJNAME, this.getPSSFStylePrjName());
        }
        if (!bl || this.isPubFlagDirty()) {
            hashMap.put(FIELD_PUBFLAG, this.getPubFlag());
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
        return PSSFCodeFolderBase.get(this, n);
    }

    private static Object get(PSSFCodeFolderBase pSSFCodeFolderBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFCodeFolderBase.getBottomCode();
            }
            case 1: {
                return pSSFCodeFolderBase.getCreateDate();
            }
            case 2: {
                return pSSFCodeFolderBase.getCreateMan();
            }
            case 3: {
                return pSSFCodeFolderBase.getFolderName();
            }
            case 4: {
                return pSSFCodeFolderBase.getHeaderCode();
            }
            case 5: {
                return pSSFCodeFolderBase.getMemo();
            }
            case 6: {
                return pSSFCodeFolderBase.getModelLevel();
            }
            case 7: {
                return pSSFCodeFolderBase.getPrjFolder();
            }
            case 8: {
                return pSSFCodeFolderBase.getPSSFCodeFolderId();
            }
            case 9: {
                return pSSFCodeFolderBase.getPSSFCodeFolderName();
            }
            case 10: {
                return pSSFCodeFolderBase.getPSSFStyleId();
            }
            case 11: {
                return pSSFCodeFolderBase.getPSSFStyleName();
            }
            case 12: {
                return pSSFCodeFolderBase.getPSSFStylePrjId();
            }
            case 13: {
                return pSSFCodeFolderBase.getPSSFStylePrjName();
            }
            case 14: {
                return pSSFCodeFolderBase.getPubFlag();
            }
            case 15: {
                return pSSFCodeFolderBase.getUpdateDate();
            }
            case 16: {
                return pSSFCodeFolderBase.getUpdateMan();
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
        PSSFCodeFolderBase.set(this, n, object);
    }

    private static void set(PSSFCodeFolderBase pSSFCodeFolderBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSFCodeFolderBase.setBottomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSFCodeFolderBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSFCodeFolderBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSFCodeFolderBase.setFolderName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSFCodeFolderBase.setHeaderCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSFCodeFolderBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSFCodeFolderBase.setModelLevel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSSFCodeFolderBase.setPrjFolder(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSFCodeFolderBase.setPSSFCodeFolderId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSFCodeFolderBase.setPSSFCodeFolderName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSFCodeFolderBase.setPSSFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSFCodeFolderBase.setPSSFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSFCodeFolderBase.setPSSFStylePrjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSFCodeFolderBase.setPSSFStylePrjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSFCodeFolderBase.setPubFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSSFCodeFolderBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 16: {
                pSSFCodeFolderBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSFCodeFolderBase.isNull(this, n);
    }

    private static boolean isNull(PSSFCodeFolderBase pSSFCodeFolderBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFCodeFolderBase.getBottomCode() == null;
            }
            case 1: {
                return pSSFCodeFolderBase.getCreateDate() == null;
            }
            case 2: {
                return pSSFCodeFolderBase.getCreateMan() == null;
            }
            case 3: {
                return pSSFCodeFolderBase.getFolderName() == null;
            }
            case 4: {
                return pSSFCodeFolderBase.getHeaderCode() == null;
            }
            case 5: {
                return pSSFCodeFolderBase.getMemo() == null;
            }
            case 6: {
                return pSSFCodeFolderBase.getModelLevel() == null;
            }
            case 7: {
                return pSSFCodeFolderBase.getPrjFolder() == null;
            }
            case 8: {
                return pSSFCodeFolderBase.getPSSFCodeFolderId() == null;
            }
            case 9: {
                return pSSFCodeFolderBase.getPSSFCodeFolderName() == null;
            }
            case 10: {
                return pSSFCodeFolderBase.getPSSFStyleId() == null;
            }
            case 11: {
                return pSSFCodeFolderBase.getPSSFStyleName() == null;
            }
            case 12: {
                return pSSFCodeFolderBase.getPSSFStylePrjId() == null;
            }
            case 13: {
                return pSSFCodeFolderBase.getPSSFStylePrjName() == null;
            }
            case 14: {
                return pSSFCodeFolderBase.getPubFlag() == null;
            }
            case 15: {
                return pSSFCodeFolderBase.getUpdateDate() == null;
            }
            case 16: {
                return pSSFCodeFolderBase.getUpdateMan() == null;
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
        return PSSFCodeFolderBase.contains(this, n);
    }

    private static boolean contains(PSSFCodeFolderBase pSSFCodeFolderBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFCodeFolderBase.isBottomCodeDirty();
            }
            case 1: {
                return pSSFCodeFolderBase.isCreateDateDirty();
            }
            case 2: {
                return pSSFCodeFolderBase.isCreateManDirty();
            }
            case 3: {
                return pSSFCodeFolderBase.isFolderNameDirty();
            }
            case 4: {
                return pSSFCodeFolderBase.isHeaderCodeDirty();
            }
            case 5: {
                return pSSFCodeFolderBase.isMemoDirty();
            }
            case 6: {
                return pSSFCodeFolderBase.isModelLevelDirty();
            }
            case 7: {
                return pSSFCodeFolderBase.isPrjFolderDirty();
            }
            case 8: {
                return pSSFCodeFolderBase.isPSSFCodeFolderIdDirty();
            }
            case 9: {
                return pSSFCodeFolderBase.isPSSFCodeFolderNameDirty();
            }
            case 10: {
                return pSSFCodeFolderBase.isPSSFStyleIdDirty();
            }
            case 11: {
                return pSSFCodeFolderBase.isPSSFStyleNameDirty();
            }
            case 12: {
                return pSSFCodeFolderBase.isPSSFStylePrjIdDirty();
            }
            case 13: {
                return pSSFCodeFolderBase.isPSSFStylePrjNameDirty();
            }
            case 14: {
                return pSSFCodeFolderBase.isPubFlagDirty();
            }
            case 15: {
                return pSSFCodeFolderBase.isUpdateDateDirty();
            }
            case 16: {
                return pSSFCodeFolderBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSFCodeFolderBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSFCodeFolderBase pSSFCodeFolderBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSFCodeFolderBase.getBottomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bottomcode", (Object)PSSFCodeFolderBase.getJSONValue((Object)pSSFCodeFolderBase.getBottomCode()), (boolean)false);
        }
        if (bl || pSSFCodeFolderBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSFCodeFolderBase.getJSONValue((Object)pSSFCodeFolderBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSFCodeFolderBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSFCodeFolderBase.getJSONValue((Object)pSSFCodeFolderBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSFCodeFolderBase.getFolderName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"foldername", (Object)PSSFCodeFolderBase.getJSONValue((Object)pSSFCodeFolderBase.getFolderName()), (boolean)false);
        }
        if (bl || pSSFCodeFolderBase.getHeaderCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"headercode", (Object)PSSFCodeFolderBase.getJSONValue((Object)pSSFCodeFolderBase.getHeaderCode()), (boolean)false);
        }
        if (bl || pSSFCodeFolderBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSFCodeFolderBase.getJSONValue((Object)pSSFCodeFolderBase.getMemo()), (boolean)false);
        }
        if (bl || pSSFCodeFolderBase.getModelLevel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modellevel", (Object)PSSFCodeFolderBase.getJSONValue((Object)pSSFCodeFolderBase.getModelLevel()), (boolean)false);
        }
        if (bl || pSSFCodeFolderBase.getPrjFolder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"prjfolder", (Object)PSSFCodeFolderBase.getJSONValue((Object)pSSFCodeFolderBase.getPrjFolder()), (boolean)false);
        }
        if (bl || pSSFCodeFolderBase.getPSSFCodeFolderId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfcodefolderid", (Object)PSSFCodeFolderBase.getJSONValue((Object)pSSFCodeFolderBase.getPSSFCodeFolderId()), (boolean)false);
        }
        if (bl || pSSFCodeFolderBase.getPSSFCodeFolderName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfcodefoldername", (Object)PSSFCodeFolderBase.getJSONValue((Object)pSSFCodeFolderBase.getPSSFCodeFolderName()), (boolean)false);
        }
        if (bl || pSSFCodeFolderBase.getPSSFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstyleid", (Object)PSSFCodeFolderBase.getJSONValue((Object)pSSFCodeFolderBase.getPSSFStyleId()), (boolean)false);
        }
        if (bl || pSSFCodeFolderBase.getPSSFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstylename", (Object)PSSFCodeFolderBase.getJSONValue((Object)pSSFCodeFolderBase.getPSSFStyleName()), (boolean)false);
        }
        if (bl || pSSFCodeFolderBase.getPSSFStylePrjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstyleprjid", (Object)PSSFCodeFolderBase.getJSONValue((Object)pSSFCodeFolderBase.getPSSFStylePrjId()), (boolean)false);
        }
        if (bl || pSSFCodeFolderBase.getPSSFStylePrjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstyleprjname", (Object)PSSFCodeFolderBase.getJSONValue((Object)pSSFCodeFolderBase.getPSSFStylePrjName()), (boolean)false);
        }
        if (bl || pSSFCodeFolderBase.getPubFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubflag", (Object)PSSFCodeFolderBase.getJSONValue((Object)pSSFCodeFolderBase.getPubFlag()), (boolean)false);
        }
        if (bl || pSSFCodeFolderBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSFCodeFolderBase.getJSONValue((Object)pSSFCodeFolderBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSFCodeFolderBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSFCodeFolderBase.getJSONValue((Object)pSSFCodeFolderBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSFCodeFolderBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSFCodeFolderBase pSSFCodeFolderBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSFCodeFolderBase.getBottomCode() != null) {
            object = pSSFCodeFolderBase.getBottomCode();
            xmlNode.setAttribute(FIELD_BOTTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeFolderBase.getCreateDate() != null) {
            object = pSSFCodeFolderBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFCodeFolderBase.getCreateMan() != null) {
            object = pSSFCodeFolderBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeFolderBase.getFolderName() != null) {
            object = pSSFCodeFolderBase.getFolderName();
            xmlNode.setAttribute(FIELD_FOLDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeFolderBase.getHeaderCode() != null) {
            object = pSSFCodeFolderBase.getHeaderCode();
            xmlNode.setAttribute(FIELD_HEADERCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeFolderBase.getMemo() != null) {
            object = pSSFCodeFolderBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeFolderBase.getModelLevel() != null) {
            object = pSSFCodeFolderBase.getModelLevel();
            xmlNode.setAttribute(FIELD_MODELLEVEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFCodeFolderBase.getPrjFolder() != null) {
            object = pSSFCodeFolderBase.getPrjFolder();
            xmlNode.setAttribute(FIELD_PRJFOLDER, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeFolderBase.getPSSFCodeFolderId() != null) {
            object = pSSFCodeFolderBase.getPSSFCodeFolderId();
            xmlNode.setAttribute(FIELD_PSSFCODEFOLDERID, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeFolderBase.getPSSFCodeFolderName() != null) {
            object = pSSFCodeFolderBase.getPSSFCodeFolderName();
            xmlNode.setAttribute(FIELD_PSSFCODEFOLDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeFolderBase.getPSSFStyleId() != null) {
            object = pSSFCodeFolderBase.getPSSFStyleId();
            xmlNode.setAttribute(FIELD_PSSFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeFolderBase.getPSSFStyleName() != null) {
            object = pSSFCodeFolderBase.getPSSFStyleName();
            xmlNode.setAttribute(FIELD_PSSFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeFolderBase.getPSSFStylePrjId() != null) {
            object = pSSFCodeFolderBase.getPSSFStylePrjId();
            xmlNode.setAttribute(FIELD_PSSFSTYLEPRJID, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeFolderBase.getPSSFStylePrjName() != null) {
            object = pSSFCodeFolderBase.getPSSFStylePrjName();
            xmlNode.setAttribute(FIELD_PSSFSTYLEPRJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeFolderBase.getPubFlag() != null) {
            object = pSSFCodeFolderBase.getPubFlag();
            xmlNode.setAttribute(FIELD_PUBFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFCodeFolderBase.getUpdateDate() != null) {
            object = pSSFCodeFolderBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFCodeFolderBase.getUpdateMan() != null) {
            object = pSSFCodeFolderBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSFCodeFolderBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSFCodeFolderBase pSSFCodeFolderBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSFCodeFolderBase.isBottomCodeDirty() && (bl || pSSFCodeFolderBase.getBottomCode() != null)) {
            iDataObject.set(FIELD_BOTTOMCODE, (Object)pSSFCodeFolderBase.getBottomCode());
        }
        if (pSSFCodeFolderBase.isCreateDateDirty() && (bl || pSSFCodeFolderBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSFCodeFolderBase.getCreateDate());
        }
        if (pSSFCodeFolderBase.isCreateManDirty() && (bl || pSSFCodeFolderBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSFCodeFolderBase.getCreateMan());
        }
        if (pSSFCodeFolderBase.isFolderNameDirty() && (bl || pSSFCodeFolderBase.getFolderName() != null)) {
            iDataObject.set(FIELD_FOLDERNAME, (Object)pSSFCodeFolderBase.getFolderName());
        }
        if (pSSFCodeFolderBase.isHeaderCodeDirty() && (bl || pSSFCodeFolderBase.getHeaderCode() != null)) {
            iDataObject.set(FIELD_HEADERCODE, (Object)pSSFCodeFolderBase.getHeaderCode());
        }
        if (pSSFCodeFolderBase.isMemoDirty() && (bl || pSSFCodeFolderBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSFCodeFolderBase.getMemo());
        }
        if (pSSFCodeFolderBase.isModelLevelDirty() && (bl || pSSFCodeFolderBase.getModelLevel() != null)) {
            iDataObject.set(FIELD_MODELLEVEL, (Object)pSSFCodeFolderBase.getModelLevel());
        }
        if (pSSFCodeFolderBase.isPrjFolderDirty() && (bl || pSSFCodeFolderBase.getPrjFolder() != null)) {
            iDataObject.set(FIELD_PRJFOLDER, (Object)pSSFCodeFolderBase.getPrjFolder());
        }
        if (pSSFCodeFolderBase.isPSSFCodeFolderIdDirty() && (bl || pSSFCodeFolderBase.getPSSFCodeFolderId() != null)) {
            iDataObject.set(FIELD_PSSFCODEFOLDERID, (Object)pSSFCodeFolderBase.getPSSFCodeFolderId());
        }
        if (pSSFCodeFolderBase.isPSSFCodeFolderNameDirty() && (bl || pSSFCodeFolderBase.getPSSFCodeFolderName() != null)) {
            iDataObject.set(FIELD_PSSFCODEFOLDERNAME, (Object)pSSFCodeFolderBase.getPSSFCodeFolderName());
        }
        if (pSSFCodeFolderBase.isPSSFStyleIdDirty() && (bl || pSSFCodeFolderBase.getPSSFStyleId() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEID, (Object)pSSFCodeFolderBase.getPSSFStyleId());
        }
        if (pSSFCodeFolderBase.isPSSFStyleNameDirty() && (bl || pSSFCodeFolderBase.getPSSFStyleName() != null)) {
            iDataObject.set(FIELD_PSSFSTYLENAME, (Object)pSSFCodeFolderBase.getPSSFStyleName());
        }
        if (pSSFCodeFolderBase.isPSSFStylePrjIdDirty() && (bl || pSSFCodeFolderBase.getPSSFStylePrjId() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEPRJID, (Object)pSSFCodeFolderBase.getPSSFStylePrjId());
        }
        if (pSSFCodeFolderBase.isPSSFStylePrjNameDirty() && (bl || pSSFCodeFolderBase.getPSSFStylePrjName() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEPRJNAME, (Object)pSSFCodeFolderBase.getPSSFStylePrjName());
        }
        if (pSSFCodeFolderBase.isPubFlagDirty() && (bl || pSSFCodeFolderBase.getPubFlag() != null)) {
            iDataObject.set(FIELD_PUBFLAG, (Object)pSSFCodeFolderBase.getPubFlag());
        }
        if (pSSFCodeFolderBase.isUpdateDateDirty() && (bl || pSSFCodeFolderBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSFCodeFolderBase.getUpdateDate());
        }
        if (pSSFCodeFolderBase.isUpdateManDirty() && (bl || pSSFCodeFolderBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSFCodeFolderBase.getUpdateMan());
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
        return PSSFCodeFolderBase.remove(this, n);
    }

    private static boolean remove(PSSFCodeFolderBase pSSFCodeFolderBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSFCodeFolderBase.resetBottomCode();
                return true;
            }
            case 1: {
                pSSFCodeFolderBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSFCodeFolderBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSFCodeFolderBase.resetFolderName();
                return true;
            }
            case 4: {
                pSSFCodeFolderBase.resetHeaderCode();
                return true;
            }
            case 5: {
                pSSFCodeFolderBase.resetMemo();
                return true;
            }
            case 6: {
                pSSFCodeFolderBase.resetModelLevel();
                return true;
            }
            case 7: {
                pSSFCodeFolderBase.resetPrjFolder();
                return true;
            }
            case 8: {
                pSSFCodeFolderBase.resetPSSFCodeFolderId();
                return true;
            }
            case 9: {
                pSSFCodeFolderBase.resetPSSFCodeFolderName();
                return true;
            }
            case 10: {
                pSSFCodeFolderBase.resetPSSFStyleId();
                return true;
            }
            case 11: {
                pSSFCodeFolderBase.resetPSSFStyleName();
                return true;
            }
            case 12: {
                pSSFCodeFolderBase.resetPSSFStylePrjId();
                return true;
            }
            case 13: {
                pSSFCodeFolderBase.resetPSSFStylePrjName();
                return true;
            }
            case 14: {
                pSSFCodeFolderBase.resetPubFlag();
                return true;
            }
            case 15: {
                pSSFCodeFolderBase.resetUpdateDate();
                return true;
            }
            case 16: {
                pSSFCodeFolderBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSFStylePrj getPSSFStylePrj() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStylePrj();
        }
        if (this.getPSSFStylePrjId() == null) {
            return null;
        }
        Integer n = this.objPSSFStylePrjLock;
        synchronized (n) {
            if (this.pssfstyleprj != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFStylePrjId(), (Object)this.pssfstyleprj.getPSSFStylePrjId()) != 0L) {
                this.pssfstyleprj = null;
            }
            if (this.pssfstyleprj == null) {
                PSSFStylePrj pSSFStylePrj = new PSSFStylePrj();
                pSSFStylePrj.setPSSFStylePrjId(this.getPSSFStylePrjId());
                PSSFStylePrjService pSSFStylePrjService = (PSSFStylePrjService)ServiceGlobal.getService(PSSFStylePrjService.class, (SessionFactory)this.getSessionFactory());
                pSSFStylePrjService.autoGet(pSSFStylePrj);
                this.pssfstyleprj = pSSFStylePrj;
            }
            return this.pssfstyleprj;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSFStyle getPSSFStyle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyle();
        }
        if (this.getPSSFStyleId() == null) {
            return null;
        }
        Integer n = this.objPSSFStyleLock;
        synchronized (n) {
            if (this.pssfstyle != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFStyleId(), (Object)this.pssfstyle.getPSSFStyleId()) != 0L) {
                this.pssfstyle = null;
            }
            if (this.pssfstyle == null) {
                PSSFStyle pSSFStyle = new PSSFStyle();
                pSSFStyle.setPSSFStyleId(this.getPSSFStyleId());
                PSSFStyleService pSSFStyleService = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)this.getSessionFactory());
                pSSFStyleService.autoGet(pSSFStyle);
                this.pssfstyle = pSSFStyle;
            }
            return this.pssfstyle;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSFCodeType> getPSSFCodeTypes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFCodeTypes();
        }
        if (this.getPSSFCodeFolderId() == null) {
            return null;
        }
        PSSFCodeTypeService pSSFCodeTypeService = (PSSFCodeTypeService)ServiceGlobal.getService(PSSFCodeTypeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSFCodeTypesLock;
        synchronized (n) {
            if (this.pssfcodetypes == null) {
                this.pssfcodetypes = pSSFCodeTypeService.selectByPSSFCodeFolder(this);
            }
            return this.pssfcodetypes;
        }
    }

    private PSSFCodeFolderBase getProxyEntity() {
        return this.proxyPSSFCodeFolderBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSFCodeFolderBase = null;
        if (iDataObject != null && iDataObject instanceof PSSFCodeFolderBase) {
            this.proxyPSSFCodeFolderBase = (PSSFCodeFolderBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFCodeFolderService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BOTTOMCODE, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_FOLDERNAME, 3);
        fieldIndexMap.put(FIELD_HEADERCODE, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_MODELLEVEL, 6);
        fieldIndexMap.put(FIELD_PRJFOLDER, 7);
        fieldIndexMap.put(FIELD_PSSFCODEFOLDERID, 8);
        fieldIndexMap.put(FIELD_PSSFCODEFOLDERNAME, 9);
        fieldIndexMap.put(FIELD_PSSFSTYLEID, 10);
        fieldIndexMap.put(FIELD_PSSFSTYLENAME, 11);
        fieldIndexMap.put(FIELD_PSSFSTYLEPRJID, 12);
        fieldIndexMap.put(FIELD_PSSFSTYLEPRJNAME, 13);
        fieldIndexMap.put(FIELD_PUBFLAG, 14);
        fieldIndexMap.put(FIELD_UPDATEDATE, 15);
        fieldIndexMap.put(FIELD_UPDATEMAN, 16);
    }
}

