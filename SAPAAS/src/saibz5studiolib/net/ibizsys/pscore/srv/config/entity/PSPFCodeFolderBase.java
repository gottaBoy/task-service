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
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFCodeFolderBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPFCodeFolderBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FOLDERNAME = "FOLDERNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PRJFOLDER = "PRJFOLDER";
    public static final String FIELD_PRJTYPE = "PRJTYPE";
    public static final String FIELD_PSPFCODEFOLDERID = "PSPFCODEFOLDERID";
    public static final String FIELD_PSPFCODEFOLDERNAME = "PSPFCODEFOLDERNAME";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFNAME = "PSPFNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_FOLDERNAME = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PRJFOLDER = 4;
    private static final int INDEX_PRJTYPE = 5;
    private static final int INDEX_PSPFCODEFOLDERID = 6;
    private static final int INDEX_PSPFCODEFOLDERNAME = 7;
    private static final int INDEX_PSPFID = 8;
    private static final int INDEX_PSPFNAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_VALIDFLAG = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPFCodeFolderBase proxyPSPFCodeFolderBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean foldernameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean prjfolderDirtyFlag = false;
    private boolean prjtypeDirtyFlag = false;
    private boolean pspfcodefolderidDirtyFlag = false;
    private boolean pspfcodefoldernameDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="foldername")
    private String foldername;
    @Column(name="memo")
    private String memo;
    @Column(name="prjfolder")
    private String prjfolder;
    @Column(name="prjtype")
    private String prjtype;
    @Column(name="pspfcodefolderid")
    private String pspfcodefolderid;
    @Column(name="pspfcodefoldername")
    private String pspfcodefoldername;
    @Column(name="pspfid")
    private String pspfid;
    @Column(name="pspfname")
    private String pspfname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSSFLock = new Integer(1);
    private PSPF pssf = null;

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

    public void setPrjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.prjtype = string;
        this.prjtypeDirtyFlag = true;
    }

    public String getPrjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrjType();
        }
        return this.prjtype;
    }

    public boolean isPrjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrjTypeDirty();
        }
        return this.prjtypeDirtyFlag;
    }

    public void resetPrjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrjType();
            return;
        }
        this.prjtypeDirtyFlag = false;
        this.prjtype = null;
    }

    public void setPSPFCodeFolderId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFCodeFolderId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfcodefolderid = string;
        this.pspfcodefolderidDirtyFlag = true;
    }

    public String getPSPFCodeFolderId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFCodeFolderId();
        }
        return this.pspfcodefolderid;
    }

    public boolean isPSPFCodeFolderIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFCodeFolderIdDirty();
        }
        return this.pspfcodefolderidDirtyFlag;
    }

    public void resetPSPFCodeFolderId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFCodeFolderId();
            return;
        }
        this.pspfcodefolderidDirtyFlag = false;
        this.pspfcodefolderid = null;
    }

    public void setPSPFCodeFolderName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFCodeFolderName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfcodefoldername = string;
        this.pspfcodefoldernameDirtyFlag = true;
    }

    public String getPSPFCodeFolderName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFCodeFolderName();
        }
        return this.pspfcodefoldername;
    }

    public boolean isPSPFCodeFolderNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFCodeFolderNameDirty();
        }
        return this.pspfcodefoldernameDirtyFlag;
    }

    public void resetPSPFCodeFolderName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFCodeFolderName();
            return;
        }
        this.pspfcodefoldernameDirtyFlag = false;
        this.pspfcodefoldername = null;
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
        PSPFCodeFolderBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPFCodeFolderBase pSPFCodeFolderBase) {
        pSPFCodeFolderBase.resetCreateDate();
        pSPFCodeFolderBase.resetCreateMan();
        pSPFCodeFolderBase.resetFolderName();
        pSPFCodeFolderBase.resetMemo();
        pSPFCodeFolderBase.resetPrjFolder();
        pSPFCodeFolderBase.resetPrjType();
        pSPFCodeFolderBase.resetPSPFCodeFolderId();
        pSPFCodeFolderBase.resetPSPFCodeFolderName();
        pSPFCodeFolderBase.resetPSPFId();
        pSPFCodeFolderBase.resetPSPFName();
        pSPFCodeFolderBase.resetUpdateDate();
        pSPFCodeFolderBase.resetUpdateMan();
        pSPFCodeFolderBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isFolderNameDirty()) {
            hashMap.put(FIELD_FOLDERNAME, this.getFolderName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPrjFolderDirty()) {
            hashMap.put(FIELD_PRJFOLDER, this.getPrjFolder());
        }
        if (!bl || this.isPrjTypeDirty()) {
            hashMap.put(FIELD_PRJTYPE, this.getPrjType());
        }
        if (!bl || this.isPSPFCodeFolderIdDirty()) {
            hashMap.put(FIELD_PSPFCODEFOLDERID, this.getPSPFCodeFolderId());
        }
        if (!bl || this.isPSPFCodeFolderNameDirty()) {
            hashMap.put(FIELD_PSPFCODEFOLDERNAME, this.getPSPFCodeFolderName());
        }
        if (!bl || this.isPSPFIdDirty()) {
            hashMap.put(FIELD_PSPFID, this.getPSPFId());
        }
        if (!bl || this.isPSPFNameDirty()) {
            hashMap.put(FIELD_PSPFNAME, this.getPSPFName());
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
        return PSPFCodeFolderBase.get(this, n);
    }

    private static Object get(PSPFCodeFolderBase pSPFCodeFolderBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFCodeFolderBase.getCreateDate();
            }
            case 1: {
                return pSPFCodeFolderBase.getCreateMan();
            }
            case 2: {
                return pSPFCodeFolderBase.getFolderName();
            }
            case 3: {
                return pSPFCodeFolderBase.getMemo();
            }
            case 4: {
                return pSPFCodeFolderBase.getPrjFolder();
            }
            case 5: {
                return pSPFCodeFolderBase.getPrjType();
            }
            case 6: {
                return pSPFCodeFolderBase.getPSPFCodeFolderId();
            }
            case 7: {
                return pSPFCodeFolderBase.getPSPFCodeFolderName();
            }
            case 8: {
                return pSPFCodeFolderBase.getPSPFId();
            }
            case 9: {
                return pSPFCodeFolderBase.getPSPFName();
            }
            case 10: {
                return pSPFCodeFolderBase.getUpdateDate();
            }
            case 11: {
                return pSPFCodeFolderBase.getUpdateMan();
            }
            case 12: {
                return pSPFCodeFolderBase.getValidFlag();
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
        PSPFCodeFolderBase.set(this, n, object);
    }

    private static void set(PSPFCodeFolderBase pSPFCodeFolderBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPFCodeFolderBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSPFCodeFolderBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSPFCodeFolderBase.setFolderName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPFCodeFolderBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPFCodeFolderBase.setPrjFolder(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPFCodeFolderBase.setPrjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPFCodeFolderBase.setPSPFCodeFolderId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPFCodeFolderBase.setPSPFCodeFolderName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPFCodeFolderBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSPFCodeFolderBase.setPSPFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSPFCodeFolderBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSPFCodeFolderBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSPFCodeFolderBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSPFCodeFolderBase.isNull(this, n);
    }

    private static boolean isNull(PSPFCodeFolderBase pSPFCodeFolderBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFCodeFolderBase.getCreateDate() == null;
            }
            case 1: {
                return pSPFCodeFolderBase.getCreateMan() == null;
            }
            case 2: {
                return pSPFCodeFolderBase.getFolderName() == null;
            }
            case 3: {
                return pSPFCodeFolderBase.getMemo() == null;
            }
            case 4: {
                return pSPFCodeFolderBase.getPrjFolder() == null;
            }
            case 5: {
                return pSPFCodeFolderBase.getPrjType() == null;
            }
            case 6: {
                return pSPFCodeFolderBase.getPSPFCodeFolderId() == null;
            }
            case 7: {
                return pSPFCodeFolderBase.getPSPFCodeFolderName() == null;
            }
            case 8: {
                return pSPFCodeFolderBase.getPSPFId() == null;
            }
            case 9: {
                return pSPFCodeFolderBase.getPSPFName() == null;
            }
            case 10: {
                return pSPFCodeFolderBase.getUpdateDate() == null;
            }
            case 11: {
                return pSPFCodeFolderBase.getUpdateMan() == null;
            }
            case 12: {
                return pSPFCodeFolderBase.getValidFlag() == null;
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
        return PSPFCodeFolderBase.contains(this, n);
    }

    private static boolean contains(PSPFCodeFolderBase pSPFCodeFolderBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFCodeFolderBase.isCreateDateDirty();
            }
            case 1: {
                return pSPFCodeFolderBase.isCreateManDirty();
            }
            case 2: {
                return pSPFCodeFolderBase.isFolderNameDirty();
            }
            case 3: {
                return pSPFCodeFolderBase.isMemoDirty();
            }
            case 4: {
                return pSPFCodeFolderBase.isPrjFolderDirty();
            }
            case 5: {
                return pSPFCodeFolderBase.isPrjTypeDirty();
            }
            case 6: {
                return pSPFCodeFolderBase.isPSPFCodeFolderIdDirty();
            }
            case 7: {
                return pSPFCodeFolderBase.isPSPFCodeFolderNameDirty();
            }
            case 8: {
                return pSPFCodeFolderBase.isPSPFIdDirty();
            }
            case 9: {
                return pSPFCodeFolderBase.isPSPFNameDirty();
            }
            case 10: {
                return pSPFCodeFolderBase.isUpdateDateDirty();
            }
            case 11: {
                return pSPFCodeFolderBase.isUpdateManDirty();
            }
            case 12: {
                return pSPFCodeFolderBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPFCodeFolderBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPFCodeFolderBase pSPFCodeFolderBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPFCodeFolderBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPFCodeFolderBase.getJSONValue((Object)pSPFCodeFolderBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPFCodeFolderBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPFCodeFolderBase.getJSONValue((Object)pSPFCodeFolderBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPFCodeFolderBase.getFolderName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"foldername", (Object)PSPFCodeFolderBase.getJSONValue((Object)pSPFCodeFolderBase.getFolderName()), (boolean)false);
        }
        if (bl || pSPFCodeFolderBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPFCodeFolderBase.getJSONValue((Object)pSPFCodeFolderBase.getMemo()), (boolean)false);
        }
        if (bl || pSPFCodeFolderBase.getPrjFolder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"prjfolder", (Object)PSPFCodeFolderBase.getJSONValue((Object)pSPFCodeFolderBase.getPrjFolder()), (boolean)false);
        }
        if (bl || pSPFCodeFolderBase.getPrjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"prjtype", (Object)PSPFCodeFolderBase.getJSONValue((Object)pSPFCodeFolderBase.getPrjType()), (boolean)false);
        }
        if (bl || pSPFCodeFolderBase.getPSPFCodeFolderId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfcodefolderid", (Object)PSPFCodeFolderBase.getJSONValue((Object)pSPFCodeFolderBase.getPSPFCodeFolderId()), (boolean)false);
        }
        if (bl || pSPFCodeFolderBase.getPSPFCodeFolderName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfcodefoldername", (Object)PSPFCodeFolderBase.getJSONValue((Object)pSPFCodeFolderBase.getPSPFCodeFolderName()), (boolean)false);
        }
        if (bl || pSPFCodeFolderBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSPFCodeFolderBase.getJSONValue((Object)pSPFCodeFolderBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSPFCodeFolderBase.getPSPFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfname", (Object)PSPFCodeFolderBase.getJSONValue((Object)pSPFCodeFolderBase.getPSPFName()), (boolean)false);
        }
        if (bl || pSPFCodeFolderBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPFCodeFolderBase.getJSONValue((Object)pSPFCodeFolderBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPFCodeFolderBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPFCodeFolderBase.getJSONValue((Object)pSPFCodeFolderBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSPFCodeFolderBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSPFCodeFolderBase.getJSONValue((Object)pSPFCodeFolderBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPFCodeFolderBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPFCodeFolderBase pSPFCodeFolderBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPFCodeFolderBase.getCreateDate() != null) {
            object = pSPFCodeFolderBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFCodeFolderBase.getCreateMan() != null) {
            object = pSPFCodeFolderBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFCodeFolderBase.getFolderName() != null) {
            object = pSPFCodeFolderBase.getFolderName();
            xmlNode.setAttribute(FIELD_FOLDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFCodeFolderBase.getMemo() != null) {
            object = pSPFCodeFolderBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPFCodeFolderBase.getPrjFolder() != null) {
            object = pSPFCodeFolderBase.getPrjFolder();
            xmlNode.setAttribute(FIELD_PRJFOLDER, object == null ? "" : (String)object);
        }
        if (bl || pSPFCodeFolderBase.getPrjType() != null) {
            object = pSPFCodeFolderBase.getPrjType();
            xmlNode.setAttribute(FIELD_PRJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSPFCodeFolderBase.getPSPFCodeFolderId() != null) {
            object = pSPFCodeFolderBase.getPSPFCodeFolderId();
            xmlNode.setAttribute(FIELD_PSPFCODEFOLDERID, object == null ? "" : (String)object);
        }
        if (bl || pSPFCodeFolderBase.getPSPFCodeFolderName() != null) {
            object = pSPFCodeFolderBase.getPSPFCodeFolderName();
            xmlNode.setAttribute(FIELD_PSPFCODEFOLDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFCodeFolderBase.getPSPFId() != null) {
            object = pSPFCodeFolderBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSPFCodeFolderBase.getPSPFName() != null) {
            object = pSPFCodeFolderBase.getPSPFName();
            xmlNode.setAttribute(FIELD_PSPFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFCodeFolderBase.getUpdateDate() != null) {
            object = pSPFCodeFolderBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFCodeFolderBase.getUpdateMan() != null) {
            object = pSPFCodeFolderBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFCodeFolderBase.getValidFlag() != null) {
            object = pSPFCodeFolderBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPFCodeFolderBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPFCodeFolderBase pSPFCodeFolderBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPFCodeFolderBase.isCreateDateDirty() && (bl || pSPFCodeFolderBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPFCodeFolderBase.getCreateDate());
        }
        if (pSPFCodeFolderBase.isCreateManDirty() && (bl || pSPFCodeFolderBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPFCodeFolderBase.getCreateMan());
        }
        if (pSPFCodeFolderBase.isFolderNameDirty() && (bl || pSPFCodeFolderBase.getFolderName() != null)) {
            iDataObject.set(FIELD_FOLDERNAME, (Object)pSPFCodeFolderBase.getFolderName());
        }
        if (pSPFCodeFolderBase.isMemoDirty() && (bl || pSPFCodeFolderBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPFCodeFolderBase.getMemo());
        }
        if (pSPFCodeFolderBase.isPrjFolderDirty() && (bl || pSPFCodeFolderBase.getPrjFolder() != null)) {
            iDataObject.set(FIELD_PRJFOLDER, (Object)pSPFCodeFolderBase.getPrjFolder());
        }
        if (pSPFCodeFolderBase.isPrjTypeDirty() && (bl || pSPFCodeFolderBase.getPrjType() != null)) {
            iDataObject.set(FIELD_PRJTYPE, (Object)pSPFCodeFolderBase.getPrjType());
        }
        if (pSPFCodeFolderBase.isPSPFCodeFolderIdDirty() && (bl || pSPFCodeFolderBase.getPSPFCodeFolderId() != null)) {
            iDataObject.set(FIELD_PSPFCODEFOLDERID, (Object)pSPFCodeFolderBase.getPSPFCodeFolderId());
        }
        if (pSPFCodeFolderBase.isPSPFCodeFolderNameDirty() && (bl || pSPFCodeFolderBase.getPSPFCodeFolderName() != null)) {
            iDataObject.set(FIELD_PSPFCODEFOLDERNAME, (Object)pSPFCodeFolderBase.getPSPFCodeFolderName());
        }
        if (pSPFCodeFolderBase.isPSPFIdDirty() && (bl || pSPFCodeFolderBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSPFCodeFolderBase.getPSPFId());
        }
        if (pSPFCodeFolderBase.isPSPFNameDirty() && (bl || pSPFCodeFolderBase.getPSPFName() != null)) {
            iDataObject.set(FIELD_PSPFNAME, (Object)pSPFCodeFolderBase.getPSPFName());
        }
        if (pSPFCodeFolderBase.isUpdateDateDirty() && (bl || pSPFCodeFolderBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPFCodeFolderBase.getUpdateDate());
        }
        if (pSPFCodeFolderBase.isUpdateManDirty() && (bl || pSPFCodeFolderBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPFCodeFolderBase.getUpdateMan());
        }
        if (pSPFCodeFolderBase.isValidFlagDirty() && (bl || pSPFCodeFolderBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSPFCodeFolderBase.getValidFlag());
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
        return PSPFCodeFolderBase.remove(this, n);
    }

    private static boolean remove(PSPFCodeFolderBase pSPFCodeFolderBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPFCodeFolderBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSPFCodeFolderBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSPFCodeFolderBase.resetFolderName();
                return true;
            }
            case 3: {
                pSPFCodeFolderBase.resetMemo();
                return true;
            }
            case 4: {
                pSPFCodeFolderBase.resetPrjFolder();
                return true;
            }
            case 5: {
                pSPFCodeFolderBase.resetPrjType();
                return true;
            }
            case 6: {
                pSPFCodeFolderBase.resetPSPFCodeFolderId();
                return true;
            }
            case 7: {
                pSPFCodeFolderBase.resetPSPFCodeFolderName();
                return true;
            }
            case 8: {
                pSPFCodeFolderBase.resetPSPFId();
                return true;
            }
            case 9: {
                pSPFCodeFolderBase.resetPSPFName();
                return true;
            }
            case 10: {
                pSPFCodeFolderBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSPFCodeFolderBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSPFCodeFolderBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPF getPSSF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSF();
        }
        if (this.getPSPFId() == null) {
            return null;
        }
        Integer n = this.objPSSFLock;
        synchronized (n) {
            if (this.pssf != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFId(), (Object)this.pssf.getPSPFId()) != 0L) {
                this.pssf = null;
            }
            if (this.pssf == null) {
                PSPF pSPF = new PSPF();
                pSPF.setPSPFId(this.getPSPFId());
                PSPFService pSPFService = (PSPFService)ServiceGlobal.getService(PSPFService.class, (SessionFactory)this.getSessionFactory());
                pSPFService.autoGet((IEntity)pSPF);
                this.pssf = pSPF;
            }
            return this.pssf;
        }
    }

    private PSPFCodeFolderBase getProxyEntity() {
        return this.proxyPSPFCodeFolderBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPFCodeFolderBase = null;
        if (iDataObject != null && iDataObject instanceof PSPFCodeFolderBase) {
            this.proxyPSPFCodeFolderBase = (PSPFCodeFolderBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFCodeFolderService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_FOLDERNAME, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PRJFOLDER, 4);
        fieldIndexMap.put(FIELD_PRJTYPE, 5);
        fieldIndexMap.put(FIELD_PSPFCODEFOLDERID, 6);
        fieldIndexMap.put(FIELD_PSPFCODEFOLDERNAME, 7);
        fieldIndexMap.put(FIELD_PSPFID, 8);
        fieldIndexMap.put(FIELD_PSPFNAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_VALIDFLAG, 12);
    }
}

