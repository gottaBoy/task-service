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
package net.ibizsys.pscore.srv.sysdevstudio.entity;

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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSMOSFileService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSMOSFileBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSMOSFileBase.class);
    public static final String FIELD_COLOR = "COLOR";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CSS = "CSS";
    public static final String FIELD_DATA = "DATA";
    public static final String FIELD_FILEATTR = "FILEATTR";
    public static final String FIELD_FILECAT = "FILECAT";
    public static final String FIELD_FILECNT = "FILECNT";
    public static final String FIELD_FILETAG = "FILETAG";
    public static final String FIELD_FILETAG2 = "FILETAG2";
    public static final String FIELD_FILETAG3 = "FILETAG3";
    public static final String FIELD_FILETAG4 = "FILETAG4";
    public static final String FIELD_FOLDERFLAG = "FOLDERFLAG";
    public static final String FIELD_FULLPATH = "FULLPATH";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODELV2TAG = "MODELV2TAG";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PPSMOSFILEID = "PPSMOSFILEID";
    public static final String FIELD_PPSMOSFILENAME = "PPSMOSFILENAME";
    public static final String FIELD_PSMODELID = "PSMODELID";
    public static final String FIELD_PSMODELSUBTYPE = "PSMODELSUBTYPE";
    public static final String FIELD_PSMODELTYPE = "PSMODELTYPE";
    public static final String FIELD_PSMOSFILEID = "PSMOSFILEID";
    public static final String FIELD_PSMOSFILENAME = "PSMOSFILENAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_TAGS = "TAGS";
    public static final String FIELD_UIACTIONPARAMS = "UIACTIONPARAMS";
    public static final String FIELD_UIACTIONS = "UIACTIONS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERFLAG = "USERFLAG";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_COLOR = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_CSS = 3;
    private static final int INDEX_DATA = 4;
    private static final int INDEX_FILEATTR = 5;
    private static final int INDEX_FILECAT = 6;
    private static final int INDEX_FILECNT = 7;
    private static final int INDEX_FILETAG = 8;
    private static final int INDEX_FILETAG2 = 9;
    private static final int INDEX_FILETAG3 = 10;
    private static final int INDEX_FILETAG4 = 11;
    private static final int INDEX_FOLDERFLAG = 12;
    private static final int INDEX_FULLPATH = 13;
    private static final int INDEX_MEMO = 14;
    private static final int INDEX_MODELV2TAG = 15;
    private static final int INDEX_ORDERVALUE = 16;
    private static final int INDEX_PPSMOSFILEID = 17;
    private static final int INDEX_PPSMOSFILENAME = 18;
    private static final int INDEX_PSMODELID = 19;
    private static final int INDEX_PSMODELSUBTYPE = 20;
    private static final int INDEX_PSMODELTYPE = 21;
    private static final int INDEX_PSMOSFILEID = 22;
    private static final int INDEX_PSMOSFILENAME = 23;
    private static final int INDEX_PSSYSTEMID = 24;
    private static final int INDEX_PSSYSTEMNAME = 25;
    private static final int INDEX_TAGS = 26;
    private static final int INDEX_UIACTIONPARAMS = 27;
    private static final int INDEX_UIACTIONS = 28;
    private static final int INDEX_UPDATEDATE = 29;
    private static final int INDEX_UPDATEMAN = 30;
    private static final int INDEX_USERFLAG = 31;
    private static final int INDEX_VALIDFLAG = 32;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSMOSFileBase proxyPSMOSFileBase = null;
    private boolean colorDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean cssDirtyFlag = false;
    private boolean dataDirtyFlag = false;
    private boolean fileattrDirtyFlag = false;
    private boolean filecatDirtyFlag = false;
    private boolean filecntDirtyFlag = false;
    private boolean filetagDirtyFlag = false;
    private boolean filetag2DirtyFlag = false;
    private boolean filetag3DirtyFlag = false;
    private boolean filetag4DirtyFlag = false;
    private boolean folderflagDirtyFlag = false;
    private boolean fullpathDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modelv2tagDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean ppsmosfileidDirtyFlag = false;
    private boolean ppsmosfilenameDirtyFlag = false;
    private boolean psmodelidDirtyFlag = false;
    private boolean psmodelsubtypeDirtyFlag = false;
    private boolean psmodeltypeDirtyFlag = false;
    private boolean psmosfileidDirtyFlag = false;
    private boolean psmosfilenameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean tagsDirtyFlag = false;
    private boolean uiactionparamsDirtyFlag = false;
    private boolean uiactionsDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userflagDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="color")
    private String color;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="css")
    private String css;
    @Column(name="data")
    private String data;
    @Column(name="fileattr")
    private Integer fileattr;
    @Column(name="filecat")
    private String filecat;
    @Column(name="filecnt")
    private Integer filecnt;
    @Column(name="filetag")
    private String filetag;
    @Column(name="filetag2")
    private String filetag2;
    @Column(name="filetag3")
    private String filetag3;
    @Column(name="filetag4")
    private String filetag4;
    @Column(name="folderflag")
    private Integer folderflag;
    @Column(name="fullpath")
    private String fullpath;
    @Column(name="memo")
    private String memo;
    @Column(name="modelv2tag")
    private String modelv2tag;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="ppsmosfileid")
    private String ppsmosfileid;
    @Column(name="ppsmosfilename")
    private String ppsmosfilename;
    @Column(name="psmodelid")
    private String psmodelid;
    @Column(name="psmodelsubtype")
    private String psmodelsubtype;
    @Column(name="psmodeltype")
    private String psmodeltype;
    @Column(name="psmosfileid")
    private String psmosfileid;
    @Column(name="psmosfilename")
    private String psmosfilename;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="tags")
    private String tags;
    @Column(name="uiactionparams")
    private String uiactionparams;
    @Column(name="uiactions")
    private String uiactions;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userflag")
    private Integer userflag;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPPSMOSFileLock = new Integer(1);
    private PSMOSFile ppsmosfile = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSMOSFilesLock = new Integer(1);
    private ArrayList<PSMOSFile> psmosfiles = null;

    public void setColor(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setColor(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.color = string;
        this.colorDirtyFlag = true;
    }

    public String getColor() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getColor();
        }
        return this.color;
    }

    public boolean isColorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isColorDirty();
        }
        return this.colorDirtyFlag;
    }

    public void resetColor() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetColor();
            return;
        }
        this.colorDirtyFlag = false;
        this.color = null;
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

    public void setCss(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCss(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.css = string;
        this.cssDirtyFlag = true;
    }

    public String getCss() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCss();
        }
        return this.css;
    }

    public boolean isCssDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCssDirty();
        }
        return this.cssDirtyFlag;
    }

    public void resetCss() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCss();
            return;
        }
        this.cssDirtyFlag = false;
        this.css = null;
    }

    public void setData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.data = string;
        this.dataDirtyFlag = true;
    }

    public String getData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getData();
        }
        return this.data;
    }

    public boolean isDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataDirty();
        }
        return this.dataDirtyFlag;
    }

    public void resetData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetData();
            return;
        }
        this.dataDirtyFlag = false;
        this.data = null;
    }

    public void setFileAttr(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFileAttr(n);
            return;
        }
        this.fileattr = n;
        this.fileattrDirtyFlag = true;
    }

    public Integer getFileAttr() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFileAttr();
        }
        return this.fileattr;
    }

    public boolean isFileAttrDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFileAttrDirty();
        }
        return this.fileattrDirtyFlag;
    }

    public void resetFileAttr() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFileAttr();
            return;
        }
        this.fileattrDirtyFlag = false;
        this.fileattr = null;
    }

    public void setFileCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFileCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.filecat = string;
        this.filecatDirtyFlag = true;
    }

    public String getFileCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFileCat();
        }
        return this.filecat;
    }

    public boolean isFileCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFileCatDirty();
        }
        return this.filecatDirtyFlag;
    }

    public void resetFileCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFileCat();
            return;
        }
        this.filecatDirtyFlag = false;
        this.filecat = null;
    }

    public void setFileCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFileCnt(n);
            return;
        }
        this.filecnt = n;
        this.filecntDirtyFlag = true;
    }

    public Integer getFileCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFileCnt();
        }
        return this.filecnt;
    }

    public boolean isFileCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFileCntDirty();
        }
        return this.filecntDirtyFlag;
    }

    public void resetFileCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFileCnt();
            return;
        }
        this.filecntDirtyFlag = false;
        this.filecnt = null;
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

    public void setFileTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFileTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.filetag3 = string;
        this.filetag3DirtyFlag = true;
    }

    public String getFileTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFileTag3();
        }
        return this.filetag3;
    }

    public boolean isFileTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFileTag3Dirty();
        }
        return this.filetag3DirtyFlag;
    }

    public void resetFileTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFileTag3();
            return;
        }
        this.filetag3DirtyFlag = false;
        this.filetag3 = null;
    }

    public void setFileTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFileTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.filetag4 = string;
        this.filetag4DirtyFlag = true;
    }

    public String getFileTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFileTag4();
        }
        return this.filetag4;
    }

    public boolean isFileTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFileTag4Dirty();
        }
        return this.filetag4DirtyFlag;
    }

    public void resetFileTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFileTag4();
            return;
        }
        this.filetag4DirtyFlag = false;
        this.filetag4 = null;
    }

    public void setFolderFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFolderFlag(n);
            return;
        }
        this.folderflag = n;
        this.folderflagDirtyFlag = true;
    }

    public Integer getFolderFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFolderFlag();
        }
        return this.folderflag;
    }

    public boolean isFolderFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFolderFlagDirty();
        }
        return this.folderflagDirtyFlag;
    }

    public void resetFolderFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFolderFlag();
            return;
        }
        this.folderflagDirtyFlag = false;
        this.folderflag = null;
    }

    public void setFullPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFullPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fullpath = string;
        this.fullpathDirtyFlag = true;
    }

    public String getFullPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFullPath();
        }
        return this.fullpath;
    }

    public boolean isFullPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFullPathDirty();
        }
        return this.fullpathDirtyFlag;
    }

    public void resetFullPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFullPath();
            return;
        }
        this.fullpathDirtyFlag = false;
        this.fullpath = null;
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

    public void setModelV2Tag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelV2Tag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modelv2tag = string;
        this.modelv2tagDirtyFlag = true;
    }

    public String getModelV2Tag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelV2Tag();
        }
        return this.modelv2tag;
    }

    public boolean isModelV2TagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelV2TagDirty();
        }
        return this.modelv2tagDirtyFlag;
    }

    public void resetModelV2Tag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelV2Tag();
            return;
        }
        this.modelv2tagDirtyFlag = false;
        this.modelv2tag = null;
    }

    public void setOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValue(n);
            return;
        }
        this.ordervalue = n;
        this.ordervalueDirtyFlag = true;
    }

    public Integer getOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValue();
        }
        return this.ordervalue;
    }

    public boolean isOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValueDirty();
        }
        return this.ordervalueDirtyFlag;
    }

    public void resetOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValue();
            return;
        }
        this.ordervalueDirtyFlag = false;
        this.ordervalue = null;
    }

    public void setPPSMOSFileId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSMOSFileId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsmosfileid = string;
        this.ppsmosfileidDirtyFlag = true;
    }

    public String getPPSMOSFileId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSMOSFileId();
        }
        return this.ppsmosfileid;
    }

    public boolean isPPSMOSFileIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSMOSFileIdDirty();
        }
        return this.ppsmosfileidDirtyFlag;
    }

    public void resetPPSMOSFileId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSMOSFileId();
            return;
        }
        this.ppsmosfileidDirtyFlag = false;
        this.ppsmosfileid = null;
    }

    public void setPPSMOSFileName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSMOSFileName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsmosfilename = string;
        this.ppsmosfilenameDirtyFlag = true;
    }

    public String getPPSMOSFileName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSMOSFileName();
        }
        return this.ppsmosfilename;
    }

    public boolean isPPSMOSFileNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSMOSFileNameDirty();
        }
        return this.ppsmosfilenameDirtyFlag;
    }

    public void resetPPSMOSFileName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSMOSFileName();
            return;
        }
        this.ppsmosfilenameDirtyFlag = false;
        this.ppsmosfilename = null;
    }

    public void setPSModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelid = string;
        this.psmodelidDirtyFlag = true;
    }

    public String getPSModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelId();
        }
        return this.psmodelid;
    }

    public boolean isPSModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelIdDirty();
        }
        return this.psmodelidDirtyFlag;
    }

    public void resetPSModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelId();
            return;
        }
        this.psmodelidDirtyFlag = false;
        this.psmodelid = null;
    }

    public void setPSModelSubType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelSubType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelsubtype = string;
        this.psmodelsubtypeDirtyFlag = true;
    }

    public String getPSModelSubType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelSubType();
        }
        return this.psmodelsubtype;
    }

    public boolean isPSModelSubTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelSubTypeDirty();
        }
        return this.psmodelsubtypeDirtyFlag;
    }

    public void resetPSModelSubType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelSubType();
            return;
        }
        this.psmodelsubtypeDirtyFlag = false;
        this.psmodelsubtype = null;
    }

    public void setPSModelType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodeltype = string;
        this.psmodeltypeDirtyFlag = true;
    }

    public String getPSModelType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelType();
        }
        return this.psmodeltype;
    }

    public boolean isPSModelTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelTypeDirty();
        }
        return this.psmodeltypeDirtyFlag;
    }

    public void resetPSModelType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelType();
            return;
        }
        this.psmodeltypeDirtyFlag = false;
        this.psmodeltype = null;
    }

    public void setPSMOSFileId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMOSFileId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmosfileid = string;
        this.psmosfileidDirtyFlag = true;
    }

    public String getPSMOSFileId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMOSFileId();
        }
        return this.psmosfileid;
    }

    public boolean isPSMOSFileIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMOSFileIdDirty();
        }
        return this.psmosfileidDirtyFlag;
    }

    public void resetPSMOSFileId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMOSFileId();
            return;
        }
        this.psmosfileidDirtyFlag = false;
        this.psmosfileid = null;
    }

    public void setPSMOSFileName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMOSFileName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmosfilename = string;
        this.psmosfilenameDirtyFlag = true;
    }

    public String getPSMOSFileName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMOSFileName();
        }
        return this.psmosfilename;
    }

    public boolean isPSMOSFileNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMOSFileNameDirty();
        }
        return this.psmosfilenameDirtyFlag;
    }

    public void resetPSMOSFileName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMOSFileName();
            return;
        }
        this.psmosfilenameDirtyFlag = false;
        this.psmosfilename = null;
    }

    public void setPSSystemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemid = string;
        this.pssystemidDirtyFlag = true;
    }

    public String getPSSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemId();
        }
        return this.pssystemid;
    }

    public boolean isPSSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemIdDirty();
        }
        return this.pssystemidDirtyFlag;
    }

    public void resetPSSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemId();
            return;
        }
        this.pssystemidDirtyFlag = false;
        this.pssystemid = null;
    }

    public void setPSSystemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemname = string;
        this.pssystemnameDirtyFlag = true;
    }

    public String getPSSystemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemName();
        }
        return this.pssystemname;
    }

    public boolean isPSSystemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemNameDirty();
        }
        return this.pssystemnameDirtyFlag;
    }

    public void resetPSSystemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemName();
            return;
        }
        this.pssystemnameDirtyFlag = false;
        this.pssystemname = null;
    }

    public void setTags(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTags(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tags = string;
        this.tagsDirtyFlag = true;
    }

    public String getTags() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTags();
        }
        return this.tags;
    }

    public boolean isTagsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTagsDirty();
        }
        return this.tagsDirtyFlag;
    }

    public void resetTags() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTags();
            return;
        }
        this.tagsDirtyFlag = false;
        this.tags = null;
    }

    public void setUIActionParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUIActionParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uiactionparams = string;
        this.uiactionparamsDirtyFlag = true;
    }

    public String getUIActionParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUIActionParams();
        }
        return this.uiactionparams;
    }

    public boolean isUIActionParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUIActionParamsDirty();
        }
        return this.uiactionparamsDirtyFlag;
    }

    public void resetUIActionParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUIActionParams();
            return;
        }
        this.uiactionparamsDirtyFlag = false;
        this.uiactionparams = null;
    }

    public void setUIActions(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUIActions(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uiactions = string;
        this.uiactionsDirtyFlag = true;
    }

    public String getUIActions() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUIActions();
        }
        return this.uiactions;
    }

    public boolean isUIActionsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUIActionsDirty();
        }
        return this.uiactionsDirtyFlag;
    }

    public void resetUIActions() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUIActions();
            return;
        }
        this.uiactionsDirtyFlag = false;
        this.uiactions = null;
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

    public void setUserFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserFlag(n);
            return;
        }
        this.userflag = n;
        this.userflagDirtyFlag = true;
    }

    public Integer getUserFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserFlag();
        }
        return this.userflag;
    }

    public boolean isUserFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserFlagDirty();
        }
        return this.userflagDirtyFlag;
    }

    public void resetUserFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserFlag();
            return;
        }
        this.userflagDirtyFlag = false;
        this.userflag = null;
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
        PSMOSFileBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSMOSFileBase pSMOSFileBase) {
        pSMOSFileBase.resetColor();
        pSMOSFileBase.resetCreateDate();
        pSMOSFileBase.resetCreateMan();
        pSMOSFileBase.resetCss();
        pSMOSFileBase.resetData();
        pSMOSFileBase.resetFileAttr();
        pSMOSFileBase.resetFileCat();
        pSMOSFileBase.resetFileCnt();
        pSMOSFileBase.resetFileTag();
        pSMOSFileBase.resetFileTag2();
        pSMOSFileBase.resetFileTag3();
        pSMOSFileBase.resetFileTag4();
        pSMOSFileBase.resetFolderFlag();
        pSMOSFileBase.resetFullPath();
        pSMOSFileBase.resetMemo();
        pSMOSFileBase.resetModelV2Tag();
        pSMOSFileBase.resetOrderValue();
        pSMOSFileBase.resetPPSMOSFileId();
        pSMOSFileBase.resetPPSMOSFileName();
        pSMOSFileBase.resetPSModelId();
        pSMOSFileBase.resetPSModelSubType();
        pSMOSFileBase.resetPSModelType();
        pSMOSFileBase.resetPSMOSFileId();
        pSMOSFileBase.resetPSMOSFileName();
        pSMOSFileBase.resetPSSystemId();
        pSMOSFileBase.resetPSSystemName();
        pSMOSFileBase.resetTags();
        pSMOSFileBase.resetUIActionParams();
        pSMOSFileBase.resetUIActions();
        pSMOSFileBase.resetUpdateDate();
        pSMOSFileBase.resetUpdateMan();
        pSMOSFileBase.resetUserFlag();
        pSMOSFileBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isColorDirty()) {
            hashMap.put(FIELD_COLOR, this.getColor());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCssDirty()) {
            hashMap.put(FIELD_CSS, this.getCss());
        }
        if (!bl || this.isDataDirty()) {
            hashMap.put(FIELD_DATA, this.getData());
        }
        if (!bl || this.isFileAttrDirty()) {
            hashMap.put(FIELD_FILEATTR, this.getFileAttr());
        }
        if (!bl || this.isFileCatDirty()) {
            hashMap.put(FIELD_FILECAT, this.getFileCat());
        }
        if (!bl || this.isFileCntDirty()) {
            hashMap.put(FIELD_FILECNT, this.getFileCnt());
        }
        if (!bl || this.isFileTagDirty()) {
            hashMap.put(FIELD_FILETAG, this.getFileTag());
        }
        if (!bl || this.isFileTag2Dirty()) {
            hashMap.put(FIELD_FILETAG2, this.getFileTag2());
        }
        if (!bl || this.isFileTag3Dirty()) {
            hashMap.put(FIELD_FILETAG3, this.getFileTag3());
        }
        if (!bl || this.isFileTag4Dirty()) {
            hashMap.put(FIELD_FILETAG4, this.getFileTag4());
        }
        if (!bl || this.isFolderFlagDirty()) {
            hashMap.put(FIELD_FOLDERFLAG, this.getFolderFlag());
        }
        if (!bl || this.isFullPathDirty()) {
            hashMap.put(FIELD_FULLPATH, this.getFullPath());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isModelV2TagDirty()) {
            hashMap.put(FIELD_MODELV2TAG, this.getModelV2Tag());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPPSMOSFileIdDirty()) {
            hashMap.put(FIELD_PPSMOSFILEID, this.getPPSMOSFileId());
        }
        if (!bl || this.isPPSMOSFileNameDirty()) {
            hashMap.put(FIELD_PPSMOSFILENAME, this.getPPSMOSFileName());
        }
        if (!bl || this.isPSModelIdDirty()) {
            hashMap.put(FIELD_PSMODELID, this.getPSModelId());
        }
        if (!bl || this.isPSModelSubTypeDirty()) {
            hashMap.put(FIELD_PSMODELSUBTYPE, this.getPSModelSubType());
        }
        if (!bl || this.isPSModelTypeDirty()) {
            hashMap.put(FIELD_PSMODELTYPE, this.getPSModelType());
        }
        if (!bl || this.isPSMOSFileIdDirty()) {
            hashMap.put(FIELD_PSMOSFILEID, this.getPSMOSFileId());
        }
        if (!bl || this.isPSMOSFileNameDirty()) {
            hashMap.put(FIELD_PSMOSFILENAME, this.getPSMOSFileName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isTagsDirty()) {
            hashMap.put(FIELD_TAGS, this.getTags());
        }
        if (!bl || this.isUIActionParamsDirty()) {
            hashMap.put(FIELD_UIACTIONPARAMS, this.getUIActionParams());
        }
        if (!bl || this.isUIActionsDirty()) {
            hashMap.put(FIELD_UIACTIONS, this.getUIActions());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserFlagDirty()) {
            hashMap.put(FIELD_USERFLAG, this.getUserFlag());
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
        return PSMOSFileBase.get(this, n);
    }

    private static Object get(PSMOSFileBase pSMOSFileBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMOSFileBase.getColor();
            }
            case 1: {
                return pSMOSFileBase.getCreateDate();
            }
            case 2: {
                return pSMOSFileBase.getCreateMan();
            }
            case 3: {
                return pSMOSFileBase.getCss();
            }
            case 4: {
                return pSMOSFileBase.getData();
            }
            case 5: {
                return pSMOSFileBase.getFileAttr();
            }
            case 6: {
                return pSMOSFileBase.getFileCat();
            }
            case 7: {
                return pSMOSFileBase.getFileCnt();
            }
            case 8: {
                return pSMOSFileBase.getFileTag();
            }
            case 9: {
                return pSMOSFileBase.getFileTag2();
            }
            case 10: {
                return pSMOSFileBase.getFileTag3();
            }
            case 11: {
                return pSMOSFileBase.getFileTag4();
            }
            case 12: {
                return pSMOSFileBase.getFolderFlag();
            }
            case 13: {
                return pSMOSFileBase.getFullPath();
            }
            case 14: {
                return pSMOSFileBase.getMemo();
            }
            case 15: {
                return pSMOSFileBase.getModelV2Tag();
            }
            case 16: {
                return pSMOSFileBase.getOrderValue();
            }
            case 17: {
                return pSMOSFileBase.getPPSMOSFileId();
            }
            case 18: {
                return pSMOSFileBase.getPPSMOSFileName();
            }
            case 19: {
                return pSMOSFileBase.getPSModelId();
            }
            case 20: {
                return pSMOSFileBase.getPSModelSubType();
            }
            case 21: {
                return pSMOSFileBase.getPSModelType();
            }
            case 22: {
                return pSMOSFileBase.getPSMOSFileId();
            }
            case 23: {
                return pSMOSFileBase.getPSMOSFileName();
            }
            case 24: {
                return pSMOSFileBase.getPSSystemId();
            }
            case 25: {
                return pSMOSFileBase.getPSSystemName();
            }
            case 26: {
                return pSMOSFileBase.getTags();
            }
            case 27: {
                return pSMOSFileBase.getUIActionParams();
            }
            case 28: {
                return pSMOSFileBase.getUIActions();
            }
            case 29: {
                return pSMOSFileBase.getUpdateDate();
            }
            case 30: {
                return pSMOSFileBase.getUpdateMan();
            }
            case 31: {
                return pSMOSFileBase.getUserFlag();
            }
            case 32: {
                return pSMOSFileBase.getValidFlag();
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
        PSMOSFileBase.set(this, n, object);
    }

    private static void set(PSMOSFileBase pSMOSFileBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSMOSFileBase.setColor(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSMOSFileBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSMOSFileBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSMOSFileBase.setCss(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSMOSFileBase.setData(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSMOSFileBase.setFileAttr(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSMOSFileBase.setFileCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSMOSFileBase.setFileCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSMOSFileBase.setFileTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSMOSFileBase.setFileTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSMOSFileBase.setFileTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSMOSFileBase.setFileTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSMOSFileBase.setFolderFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSMOSFileBase.setFullPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSMOSFileBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSMOSFileBase.setModelV2Tag(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSMOSFileBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSMOSFileBase.setPPSMOSFileId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSMOSFileBase.setPPSMOSFileName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSMOSFileBase.setPSModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSMOSFileBase.setPSModelSubType(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSMOSFileBase.setPSModelType(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSMOSFileBase.setPSMOSFileId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSMOSFileBase.setPSMOSFileName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSMOSFileBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSMOSFileBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSMOSFileBase.setTags(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSMOSFileBase.setUIActionParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSMOSFileBase.setUIActions(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSMOSFileBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 30: {
                pSMOSFileBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSMOSFileBase.setUserFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 32: {
                pSMOSFileBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSMOSFileBase.isNull(this, n);
    }

    private static boolean isNull(PSMOSFileBase pSMOSFileBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMOSFileBase.getColor() == null;
            }
            case 1: {
                return pSMOSFileBase.getCreateDate() == null;
            }
            case 2: {
                return pSMOSFileBase.getCreateMan() == null;
            }
            case 3: {
                return pSMOSFileBase.getCss() == null;
            }
            case 4: {
                return pSMOSFileBase.getData() == null;
            }
            case 5: {
                return pSMOSFileBase.getFileAttr() == null;
            }
            case 6: {
                return pSMOSFileBase.getFileCat() == null;
            }
            case 7: {
                return pSMOSFileBase.getFileCnt() == null;
            }
            case 8: {
                return pSMOSFileBase.getFileTag() == null;
            }
            case 9: {
                return pSMOSFileBase.getFileTag2() == null;
            }
            case 10: {
                return pSMOSFileBase.getFileTag3() == null;
            }
            case 11: {
                return pSMOSFileBase.getFileTag4() == null;
            }
            case 12: {
                return pSMOSFileBase.getFolderFlag() == null;
            }
            case 13: {
                return pSMOSFileBase.getFullPath() == null;
            }
            case 14: {
                return pSMOSFileBase.getMemo() == null;
            }
            case 15: {
                return pSMOSFileBase.getModelV2Tag() == null;
            }
            case 16: {
                return pSMOSFileBase.getOrderValue() == null;
            }
            case 17: {
                return pSMOSFileBase.getPPSMOSFileId() == null;
            }
            case 18: {
                return pSMOSFileBase.getPPSMOSFileName() == null;
            }
            case 19: {
                return pSMOSFileBase.getPSModelId() == null;
            }
            case 20: {
                return pSMOSFileBase.getPSModelSubType() == null;
            }
            case 21: {
                return pSMOSFileBase.getPSModelType() == null;
            }
            case 22: {
                return pSMOSFileBase.getPSMOSFileId() == null;
            }
            case 23: {
                return pSMOSFileBase.getPSMOSFileName() == null;
            }
            case 24: {
                return pSMOSFileBase.getPSSystemId() == null;
            }
            case 25: {
                return pSMOSFileBase.getPSSystemName() == null;
            }
            case 26: {
                return pSMOSFileBase.getTags() == null;
            }
            case 27: {
                return pSMOSFileBase.getUIActionParams() == null;
            }
            case 28: {
                return pSMOSFileBase.getUIActions() == null;
            }
            case 29: {
                return pSMOSFileBase.getUpdateDate() == null;
            }
            case 30: {
                return pSMOSFileBase.getUpdateMan() == null;
            }
            case 31: {
                return pSMOSFileBase.getUserFlag() == null;
            }
            case 32: {
                return pSMOSFileBase.getValidFlag() == null;
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
        return PSMOSFileBase.contains(this, n);
    }

    private static boolean contains(PSMOSFileBase pSMOSFileBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMOSFileBase.isColorDirty();
            }
            case 1: {
                return pSMOSFileBase.isCreateDateDirty();
            }
            case 2: {
                return pSMOSFileBase.isCreateManDirty();
            }
            case 3: {
                return pSMOSFileBase.isCssDirty();
            }
            case 4: {
                return pSMOSFileBase.isDataDirty();
            }
            case 5: {
                return pSMOSFileBase.isFileAttrDirty();
            }
            case 6: {
                return pSMOSFileBase.isFileCatDirty();
            }
            case 7: {
                return pSMOSFileBase.isFileCntDirty();
            }
            case 8: {
                return pSMOSFileBase.isFileTagDirty();
            }
            case 9: {
                return pSMOSFileBase.isFileTag2Dirty();
            }
            case 10: {
                return pSMOSFileBase.isFileTag3Dirty();
            }
            case 11: {
                return pSMOSFileBase.isFileTag4Dirty();
            }
            case 12: {
                return pSMOSFileBase.isFolderFlagDirty();
            }
            case 13: {
                return pSMOSFileBase.isFullPathDirty();
            }
            case 14: {
                return pSMOSFileBase.isMemoDirty();
            }
            case 15: {
                return pSMOSFileBase.isModelV2TagDirty();
            }
            case 16: {
                return pSMOSFileBase.isOrderValueDirty();
            }
            case 17: {
                return pSMOSFileBase.isPPSMOSFileIdDirty();
            }
            case 18: {
                return pSMOSFileBase.isPPSMOSFileNameDirty();
            }
            case 19: {
                return pSMOSFileBase.isPSModelIdDirty();
            }
            case 20: {
                return pSMOSFileBase.isPSModelSubTypeDirty();
            }
            case 21: {
                return pSMOSFileBase.isPSModelTypeDirty();
            }
            case 22: {
                return pSMOSFileBase.isPSMOSFileIdDirty();
            }
            case 23: {
                return pSMOSFileBase.isPSMOSFileNameDirty();
            }
            case 24: {
                return pSMOSFileBase.isPSSystemIdDirty();
            }
            case 25: {
                return pSMOSFileBase.isPSSystemNameDirty();
            }
            case 26: {
                return pSMOSFileBase.isTagsDirty();
            }
            case 27: {
                return pSMOSFileBase.isUIActionParamsDirty();
            }
            case 28: {
                return pSMOSFileBase.isUIActionsDirty();
            }
            case 29: {
                return pSMOSFileBase.isUpdateDateDirty();
            }
            case 30: {
                return pSMOSFileBase.isUpdateManDirty();
            }
            case 31: {
                return pSMOSFileBase.isUserFlagDirty();
            }
            case 32: {
                return pSMOSFileBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSMOSFileBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSMOSFileBase pSMOSFileBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSMOSFileBase.getColor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"color", (Object)PSMOSFileBase.getJSONValue((Object)pSMOSFileBase.getColor()), (boolean)false);
        }
        if (bl || pSMOSFileBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSMOSFileBase.getJSONValue((Object)pSMOSFileBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSMOSFileBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSMOSFileBase.getJSONValue((Object)pSMOSFileBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSMOSFileBase.getCss() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"css", (Object)PSMOSFileBase.getJSONValue((Object)pSMOSFileBase.getCss()), (boolean)false);
        }
        if (bl || pSMOSFileBase.getData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"data", (Object)PSMOSFileBase.getJSONValue((Object)pSMOSFileBase.getData()), (boolean)false);
        }
        if (bl || pSMOSFileBase.getFileAttr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fileattr", (Object)PSMOSFileBase.getJSONValue((Object)pSMOSFileBase.getFileAttr()), (boolean)false);
        }
        if (bl || pSMOSFileBase.getFileCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"filecat", (Object)PSMOSFileBase.getJSONValue((Object)pSMOSFileBase.getFileCat()), (boolean)false);
        }
        if (bl || pSMOSFileBase.getFileCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"filecnt", (Object)PSMOSFileBase.getJSONValue((Object)pSMOSFileBase.getFileCnt()), (boolean)false);
        }
        if (bl || pSMOSFileBase.getFileTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"filetag", (Object)PSMOSFileBase.getJSONValue((Object)pSMOSFileBase.getFileTag()), (boolean)false);
        }
        if (bl || pSMOSFileBase.getFileTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"filetag2", (Object)PSMOSFileBase.getJSONValue((Object)pSMOSFileBase.getFileTag2()), (boolean)false);
        }
        if (bl || pSMOSFileBase.getFileTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"filetag3", (Object)PSMOSFileBase.getJSONValue((Object)pSMOSFileBase.getFileTag3()), (boolean)false);
        }
        if (bl || pSMOSFileBase.getFileTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"filetag4", (Object)PSMOSFileBase.getJSONValue((Object)pSMOSFileBase.getFileTag4()), (boolean)false);
        }
        if (bl || pSMOSFileBase.getFolderFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"folderflag", (Object)PSMOSFileBase.getJSONValue((Object)pSMOSFileBase.getFolderFlag()), (boolean)false);
        }
        if (bl || pSMOSFileBase.getFullPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fullpath", (Object)PSMOSFileBase.getJSONValue((Object)pSMOSFileBase.getFullPath()), (boolean)false);
        }
        if (bl || pSMOSFileBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSMOSFileBase.getJSONValue((Object)pSMOSFileBase.getMemo()), (boolean)false);
        }
        if (bl || pSMOSFileBase.getModelV2Tag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelv2tag", (Object)PSMOSFileBase.getJSONValue((Object)pSMOSFileBase.getModelV2Tag()), (boolean)false);
        }
        if (bl || pSMOSFileBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSMOSFileBase.getJSONValue((Object)pSMOSFileBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSMOSFileBase.getPPSMOSFileId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsmosfileid", (Object)PSMOSFileBase.getJSONValue((Object)pSMOSFileBase.getPPSMOSFileId()), (boolean)false);
        }
        if (bl || pSMOSFileBase.getPPSMOSFileName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsmosfilename", (Object)PSMOSFileBase.getJSONValue((Object)pSMOSFileBase.getPPSMOSFileName()), (boolean)false);
        }
        if (bl || pSMOSFileBase.getPSModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelid", (Object)PSMOSFileBase.getJSONValue((Object)pSMOSFileBase.getPSModelId()), (boolean)false);
        }
        if (bl || pSMOSFileBase.getPSModelSubType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelsubtype", (Object)PSMOSFileBase.getJSONValue((Object)pSMOSFileBase.getPSModelSubType()), (boolean)false);
        }
        if (bl || pSMOSFileBase.getPSModelType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodeltype", (Object)PSMOSFileBase.getJSONValue((Object)pSMOSFileBase.getPSModelType()), (boolean)false);
        }
        if (bl || pSMOSFileBase.getPSMOSFileId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmosfileid", (Object)PSMOSFileBase.getJSONValue((Object)pSMOSFileBase.getPSMOSFileId()), (boolean)false);
        }
        if (bl || pSMOSFileBase.getPSMOSFileName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmosfilename", (Object)PSMOSFileBase.getJSONValue((Object)pSMOSFileBase.getPSMOSFileName()), (boolean)false);
        }
        if (bl || pSMOSFileBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSMOSFileBase.getJSONValue((Object)pSMOSFileBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSMOSFileBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSMOSFileBase.getJSONValue((Object)pSMOSFileBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSMOSFileBase.getTags() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tags", (Object)PSMOSFileBase.getJSONValue((Object)pSMOSFileBase.getTags()), (boolean)false);
        }
        if (bl || pSMOSFileBase.getUIActionParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uiactionparams", (Object)PSMOSFileBase.getJSONValue((Object)pSMOSFileBase.getUIActionParams()), (boolean)false);
        }
        if (bl || pSMOSFileBase.getUIActions() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uiactions", (Object)PSMOSFileBase.getJSONValue((Object)pSMOSFileBase.getUIActions()), (boolean)false);
        }
        if (bl || pSMOSFileBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSMOSFileBase.getJSONValue((Object)pSMOSFileBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSMOSFileBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSMOSFileBase.getJSONValue((Object)pSMOSFileBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSMOSFileBase.getUserFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userflag", (Object)PSMOSFileBase.getJSONValue((Object)pSMOSFileBase.getUserFlag()), (boolean)false);
        }
        if (bl || pSMOSFileBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSMOSFileBase.getJSONValue((Object)pSMOSFileBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSMOSFileBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSMOSFileBase pSMOSFileBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSMOSFileBase.getColor() != null) {
            object = pSMOSFileBase.getColor();
            xmlNode.setAttribute(FIELD_COLOR, object == null ? "" : (String)object);
        }
        if (bl || pSMOSFileBase.getCreateDate() != null) {
            object = pSMOSFileBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSMOSFileBase.getCreateMan() != null) {
            object = pSMOSFileBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSMOSFileBase.getCss() != null) {
            object = pSMOSFileBase.getCss();
            xmlNode.setAttribute(FIELD_CSS, object == null ? "" : (String)object);
        }
        if (bl || pSMOSFileBase.getData() != null) {
            object = pSMOSFileBase.getData();
            xmlNode.setAttribute(FIELD_DATA, object == null ? "" : (String)object);
        }
        if (bl || pSMOSFileBase.getFileAttr() != null) {
            object = pSMOSFileBase.getFileAttr();
            xmlNode.setAttribute(FIELD_FILEATTR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMOSFileBase.getFileCat() != null) {
            object = pSMOSFileBase.getFileCat();
            xmlNode.setAttribute(FIELD_FILECAT, object == null ? "" : (String)object);
        }
        if (bl || pSMOSFileBase.getFileCnt() != null) {
            object = pSMOSFileBase.getFileCnt();
            xmlNode.setAttribute(FIELD_FILECNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMOSFileBase.getFileTag() != null) {
            object = pSMOSFileBase.getFileTag();
            xmlNode.setAttribute(FIELD_FILETAG, object == null ? "" : (String)object);
        }
        if (bl || pSMOSFileBase.getFileTag2() != null) {
            object = pSMOSFileBase.getFileTag2();
            xmlNode.setAttribute(FIELD_FILETAG2, object == null ? "" : (String)object);
        }
        if (bl || pSMOSFileBase.getFileTag3() != null) {
            object = pSMOSFileBase.getFileTag3();
            xmlNode.setAttribute(FIELD_FILETAG3, object == null ? "" : (String)object);
        }
        if (bl || pSMOSFileBase.getFileTag4() != null) {
            object = pSMOSFileBase.getFileTag4();
            xmlNode.setAttribute(FIELD_FILETAG4, object == null ? "" : (String)object);
        }
        if (bl || pSMOSFileBase.getFolderFlag() != null) {
            object = pSMOSFileBase.getFolderFlag();
            xmlNode.setAttribute(FIELD_FOLDERFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMOSFileBase.getFullPath() != null) {
            object = pSMOSFileBase.getFullPath();
            xmlNode.setAttribute(FIELD_FULLPATH, object == null ? "" : (String)object);
        }
        if (bl || pSMOSFileBase.getMemo() != null) {
            object = pSMOSFileBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSMOSFileBase.getModelV2Tag() != null) {
            object = pSMOSFileBase.getModelV2Tag();
            xmlNode.setAttribute(FIELD_MODELV2TAG, object == null ? "" : (String)object);
        }
        if (bl || pSMOSFileBase.getOrderValue() != null) {
            object = pSMOSFileBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMOSFileBase.getPPSMOSFileId() != null) {
            object = pSMOSFileBase.getPPSMOSFileId();
            xmlNode.setAttribute(FIELD_PPSMOSFILEID, object == null ? "" : (String)object);
        }
        if (bl || pSMOSFileBase.getPPSMOSFileName() != null) {
            object = pSMOSFileBase.getPPSMOSFileName();
            xmlNode.setAttribute(FIELD_PPSMOSFILENAME, object == null ? "" : (String)object);
        }
        if (bl || pSMOSFileBase.getPSModelId() != null) {
            object = pSMOSFileBase.getPSModelId();
            xmlNode.setAttribute(FIELD_PSMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSMOSFileBase.getPSModelSubType() != null) {
            object = pSMOSFileBase.getPSModelSubType();
            xmlNode.setAttribute(FIELD_PSMODELSUBTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSMOSFileBase.getPSModelType() != null) {
            object = pSMOSFileBase.getPSModelType();
            xmlNode.setAttribute(FIELD_PSMODELTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSMOSFileBase.getPSMOSFileId() != null) {
            object = pSMOSFileBase.getPSMOSFileId();
            xmlNode.setAttribute(FIELD_PSMOSFILEID, object == null ? "" : (String)object);
        }
        if (bl || pSMOSFileBase.getPSMOSFileName() != null) {
            object = pSMOSFileBase.getPSMOSFileName();
            xmlNode.setAttribute(FIELD_PSMOSFILENAME, object == null ? "" : (String)object);
        }
        if (bl || pSMOSFileBase.getPSSystemId() != null) {
            object = pSMOSFileBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSMOSFileBase.getPSSystemName() != null) {
            object = pSMOSFileBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMOSFileBase.getTags() != null) {
            object = pSMOSFileBase.getTags();
            xmlNode.setAttribute(FIELD_TAGS, object == null ? "" : (String)object);
        }
        if (bl || pSMOSFileBase.getUIActionParams() != null) {
            object = pSMOSFileBase.getUIActionParams();
            xmlNode.setAttribute(FIELD_UIACTIONPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSMOSFileBase.getUIActions() != null) {
            object = pSMOSFileBase.getUIActions();
            xmlNode.setAttribute(FIELD_UIACTIONS, object == null ? "" : (String)object);
        }
        if (bl || pSMOSFileBase.getUpdateDate() != null) {
            object = pSMOSFileBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSMOSFileBase.getUpdateMan() != null) {
            object = pSMOSFileBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSMOSFileBase.getUserFlag() != null) {
            object = pSMOSFileBase.getUserFlag();
            xmlNode.setAttribute(FIELD_USERFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSMOSFileBase.getValidFlag() != null) {
            object = pSMOSFileBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSMOSFileBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSMOSFileBase pSMOSFileBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSMOSFileBase.isColorDirty() && (bl || pSMOSFileBase.getColor() != null)) {
            iDataObject.set(FIELD_COLOR, (Object)pSMOSFileBase.getColor());
        }
        if (pSMOSFileBase.isCreateDateDirty() && (bl || pSMOSFileBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSMOSFileBase.getCreateDate());
        }
        if (pSMOSFileBase.isCreateManDirty() && (bl || pSMOSFileBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSMOSFileBase.getCreateMan());
        }
        if (pSMOSFileBase.isCssDirty() && (bl || pSMOSFileBase.getCss() != null)) {
            iDataObject.set(FIELD_CSS, (Object)pSMOSFileBase.getCss());
        }
        if (pSMOSFileBase.isDataDirty() && (bl || pSMOSFileBase.getData() != null)) {
            iDataObject.set(FIELD_DATA, (Object)pSMOSFileBase.getData());
        }
        if (pSMOSFileBase.isFileAttrDirty() && (bl || pSMOSFileBase.getFileAttr() != null)) {
            iDataObject.set(FIELD_FILEATTR, (Object)pSMOSFileBase.getFileAttr());
        }
        if (pSMOSFileBase.isFileCatDirty() && (bl || pSMOSFileBase.getFileCat() != null)) {
            iDataObject.set(FIELD_FILECAT, (Object)pSMOSFileBase.getFileCat());
        }
        if (pSMOSFileBase.isFileCntDirty() && (bl || pSMOSFileBase.getFileCnt() != null)) {
            iDataObject.set(FIELD_FILECNT, (Object)pSMOSFileBase.getFileCnt());
        }
        if (pSMOSFileBase.isFileTagDirty() && (bl || pSMOSFileBase.getFileTag() != null)) {
            iDataObject.set(FIELD_FILETAG, (Object)pSMOSFileBase.getFileTag());
        }
        if (pSMOSFileBase.isFileTag2Dirty() && (bl || pSMOSFileBase.getFileTag2() != null)) {
            iDataObject.set(FIELD_FILETAG2, (Object)pSMOSFileBase.getFileTag2());
        }
        if (pSMOSFileBase.isFileTag3Dirty() && (bl || pSMOSFileBase.getFileTag3() != null)) {
            iDataObject.set(FIELD_FILETAG3, (Object)pSMOSFileBase.getFileTag3());
        }
        if (pSMOSFileBase.isFileTag4Dirty() && (bl || pSMOSFileBase.getFileTag4() != null)) {
            iDataObject.set(FIELD_FILETAG4, (Object)pSMOSFileBase.getFileTag4());
        }
        if (pSMOSFileBase.isFolderFlagDirty() && (bl || pSMOSFileBase.getFolderFlag() != null)) {
            iDataObject.set(FIELD_FOLDERFLAG, (Object)pSMOSFileBase.getFolderFlag());
        }
        if (pSMOSFileBase.isFullPathDirty() && (bl || pSMOSFileBase.getFullPath() != null)) {
            iDataObject.set(FIELD_FULLPATH, (Object)pSMOSFileBase.getFullPath());
        }
        if (pSMOSFileBase.isMemoDirty() && (bl || pSMOSFileBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSMOSFileBase.getMemo());
        }
        if (pSMOSFileBase.isModelV2TagDirty() && (bl || pSMOSFileBase.getModelV2Tag() != null)) {
            iDataObject.set(FIELD_MODELV2TAG, (Object)pSMOSFileBase.getModelV2Tag());
        }
        if (pSMOSFileBase.isOrderValueDirty() && (bl || pSMOSFileBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSMOSFileBase.getOrderValue());
        }
        if (pSMOSFileBase.isPPSMOSFileIdDirty() && (bl || pSMOSFileBase.getPPSMOSFileId() != null)) {
            iDataObject.set(FIELD_PPSMOSFILEID, (Object)pSMOSFileBase.getPPSMOSFileId());
        }
        if (pSMOSFileBase.isPPSMOSFileNameDirty() && (bl || pSMOSFileBase.getPPSMOSFileName() != null)) {
            iDataObject.set(FIELD_PPSMOSFILENAME, (Object)pSMOSFileBase.getPPSMOSFileName());
        }
        if (pSMOSFileBase.isPSModelIdDirty() && (bl || pSMOSFileBase.getPSModelId() != null)) {
            iDataObject.set(FIELD_PSMODELID, (Object)pSMOSFileBase.getPSModelId());
        }
        if (pSMOSFileBase.isPSModelSubTypeDirty() && (bl || pSMOSFileBase.getPSModelSubType() != null)) {
            iDataObject.set(FIELD_PSMODELSUBTYPE, (Object)pSMOSFileBase.getPSModelSubType());
        }
        if (pSMOSFileBase.isPSModelTypeDirty() && (bl || pSMOSFileBase.getPSModelType() != null)) {
            iDataObject.set(FIELD_PSMODELTYPE, (Object)pSMOSFileBase.getPSModelType());
        }
        if (pSMOSFileBase.isPSMOSFileIdDirty() && (bl || pSMOSFileBase.getPSMOSFileId() != null)) {
            iDataObject.set(FIELD_PSMOSFILEID, (Object)pSMOSFileBase.getPSMOSFileId());
        }
        if (pSMOSFileBase.isPSMOSFileNameDirty() && (bl || pSMOSFileBase.getPSMOSFileName() != null)) {
            iDataObject.set(FIELD_PSMOSFILENAME, (Object)pSMOSFileBase.getPSMOSFileName());
        }
        if (pSMOSFileBase.isPSSystemIdDirty() && (bl || pSMOSFileBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSMOSFileBase.getPSSystemId());
        }
        if (pSMOSFileBase.isPSSystemNameDirty() && (bl || pSMOSFileBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSMOSFileBase.getPSSystemName());
        }
        if (pSMOSFileBase.isTagsDirty() && (bl || pSMOSFileBase.getTags() != null)) {
            iDataObject.set(FIELD_TAGS, (Object)pSMOSFileBase.getTags());
        }
        if (pSMOSFileBase.isUIActionParamsDirty() && (bl || pSMOSFileBase.getUIActionParams() != null)) {
            iDataObject.set(FIELD_UIACTIONPARAMS, (Object)pSMOSFileBase.getUIActionParams());
        }
        if (pSMOSFileBase.isUIActionsDirty() && (bl || pSMOSFileBase.getUIActions() != null)) {
            iDataObject.set(FIELD_UIACTIONS, (Object)pSMOSFileBase.getUIActions());
        }
        if (pSMOSFileBase.isUpdateDateDirty() && (bl || pSMOSFileBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSMOSFileBase.getUpdateDate());
        }
        if (pSMOSFileBase.isUpdateManDirty() && (bl || pSMOSFileBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSMOSFileBase.getUpdateMan());
        }
        if (pSMOSFileBase.isUserFlagDirty() && (bl || pSMOSFileBase.getUserFlag() != null)) {
            iDataObject.set(FIELD_USERFLAG, (Object)pSMOSFileBase.getUserFlag());
        }
        if (pSMOSFileBase.isValidFlagDirty() && (bl || pSMOSFileBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSMOSFileBase.getValidFlag());
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
        return PSMOSFileBase.remove(this, n);
    }

    private static boolean remove(PSMOSFileBase pSMOSFileBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSMOSFileBase.resetColor();
                return true;
            }
            case 1: {
                pSMOSFileBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSMOSFileBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSMOSFileBase.resetCss();
                return true;
            }
            case 4: {
                pSMOSFileBase.resetData();
                return true;
            }
            case 5: {
                pSMOSFileBase.resetFileAttr();
                return true;
            }
            case 6: {
                pSMOSFileBase.resetFileCat();
                return true;
            }
            case 7: {
                pSMOSFileBase.resetFileCnt();
                return true;
            }
            case 8: {
                pSMOSFileBase.resetFileTag();
                return true;
            }
            case 9: {
                pSMOSFileBase.resetFileTag2();
                return true;
            }
            case 10: {
                pSMOSFileBase.resetFileTag3();
                return true;
            }
            case 11: {
                pSMOSFileBase.resetFileTag4();
                return true;
            }
            case 12: {
                pSMOSFileBase.resetFolderFlag();
                return true;
            }
            case 13: {
                pSMOSFileBase.resetFullPath();
                return true;
            }
            case 14: {
                pSMOSFileBase.resetMemo();
                return true;
            }
            case 15: {
                pSMOSFileBase.resetModelV2Tag();
                return true;
            }
            case 16: {
                pSMOSFileBase.resetOrderValue();
                return true;
            }
            case 17: {
                pSMOSFileBase.resetPPSMOSFileId();
                return true;
            }
            case 18: {
                pSMOSFileBase.resetPPSMOSFileName();
                return true;
            }
            case 19: {
                pSMOSFileBase.resetPSModelId();
                return true;
            }
            case 20: {
                pSMOSFileBase.resetPSModelSubType();
                return true;
            }
            case 21: {
                pSMOSFileBase.resetPSModelType();
                return true;
            }
            case 22: {
                pSMOSFileBase.resetPSMOSFileId();
                return true;
            }
            case 23: {
                pSMOSFileBase.resetPSMOSFileName();
                return true;
            }
            case 24: {
                pSMOSFileBase.resetPSSystemId();
                return true;
            }
            case 25: {
                pSMOSFileBase.resetPSSystemName();
                return true;
            }
            case 26: {
                pSMOSFileBase.resetTags();
                return true;
            }
            case 27: {
                pSMOSFileBase.resetUIActionParams();
                return true;
            }
            case 28: {
                pSMOSFileBase.resetUIActions();
                return true;
            }
            case 29: {
                pSMOSFileBase.resetUpdateDate();
                return true;
            }
            case 30: {
                pSMOSFileBase.resetUpdateMan();
                return true;
            }
            case 31: {
                pSMOSFileBase.resetUserFlag();
                return true;
            }
            case 32: {
                pSMOSFileBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSMOSFile getPPSMOSFile() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSMOSFile();
        }
        if (this.getPPSMOSFileId() == null) {
            return null;
        }
        Integer n = this.objPPSMOSFileLock;
        synchronized (n) {
            if (this.ppsmosfile != null && DataTypeHelper.compare((int)25, (Object)this.getPPSMOSFileId(), (Object)this.ppsmosfile.getPSMOSFileId()) != 0L) {
                this.ppsmosfile = null;
            }
            if (this.ppsmosfile == null) {
                PSMOSFile pSMOSFile = new PSMOSFile();
                pSMOSFile.setPSMOSFileId(this.getPPSMOSFileId());
                PSMOSFileService pSMOSFileService = (PSMOSFileService)ServiceGlobal.getService(PSMOSFileService.class, (SessionFactory)this.getSessionFactory());
                pSMOSFileService.autoGet((IEntity)pSMOSFile);
                this.ppsmosfile = pSMOSFile;
            }
            return this.ppsmosfile;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystem getPSSystem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystem();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        Integer n = this.objPSSystemLock;
        synchronized (n) {
            if (this.pssystem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemId(), (Object)this.pssystem.getPSSystemId()) != 0L) {
                this.pssystem = null;
            }
            if (this.pssystem == null) {
                PSSystem pSSystem = new PSSystem();
                pSSystem.setPSSystemId(this.getPSSystemId());
                PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
                pSSystemService.autoGet((IEntity)pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSMOSFile> getPSMOSFiles() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMOSFiles();
        }
        if (this.getPSMOSFileId() == null) {
            return null;
        }
        PSMOSFileService pSMOSFileService = (PSMOSFileService)ServiceGlobal.getService(PSMOSFileService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSMOSFilesLock;
        synchronized (n) {
            if (this.psmosfiles == null) {
                this.psmosfiles = pSMOSFileService.selectByPPSMOSFile(this);
            }
            return this.psmosfiles;
        }
    }

    private PSMOSFileBase getProxyEntity() {
        return this.proxyPSMOSFileBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSMOSFileBase = null;
        if (iDataObject != null && iDataObject instanceof PSMOSFileBase) {
            this.proxyPSMOSFileBase = (PSMOSFileBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSMOSFileService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_COLOR, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_CSS, 3);
        fieldIndexMap.put(FIELD_DATA, 4);
        fieldIndexMap.put(FIELD_FILEATTR, 5);
        fieldIndexMap.put(FIELD_FILECAT, 6);
        fieldIndexMap.put(FIELD_FILECNT, 7);
        fieldIndexMap.put(FIELD_FILETAG, 8);
        fieldIndexMap.put(FIELD_FILETAG2, 9);
        fieldIndexMap.put(FIELD_FILETAG3, 10);
        fieldIndexMap.put(FIELD_FILETAG4, 11);
        fieldIndexMap.put(FIELD_FOLDERFLAG, 12);
        fieldIndexMap.put(FIELD_FULLPATH, 13);
        fieldIndexMap.put(FIELD_MEMO, 14);
        fieldIndexMap.put(FIELD_MODELV2TAG, 15);
        fieldIndexMap.put(FIELD_ORDERVALUE, 16);
        fieldIndexMap.put(FIELD_PPSMOSFILEID, 17);
        fieldIndexMap.put(FIELD_PPSMOSFILENAME, 18);
        fieldIndexMap.put(FIELD_PSMODELID, 19);
        fieldIndexMap.put(FIELD_PSMODELSUBTYPE, 20);
        fieldIndexMap.put(FIELD_PSMODELTYPE, 21);
        fieldIndexMap.put(FIELD_PSMOSFILEID, 22);
        fieldIndexMap.put(FIELD_PSMOSFILENAME, 23);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 24);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 25);
        fieldIndexMap.put(FIELD_TAGS, 26);
        fieldIndexMap.put(FIELD_UIACTIONPARAMS, 27);
        fieldIndexMap.put(FIELD_UIACTIONS, 28);
        fieldIndexMap.put(FIELD_UPDATEDATE, 29);
        fieldIndexMap.put(FIELD_UPDATEMAN, 30);
        fieldIndexMap.put(FIELD_USERFLAG, 31);
        fieldIndexMap.put(FIELD_VALIDFLAG, 32);
    }
}

