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
import net.ibizsys.pscore.srv.config.entity.PSImageTempl;
import net.ibizsys.pscore.srv.config.service.PSImageTemplService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysImageBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysImageBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CSSCLASS = "CSSCLASS";
    public static final String FIELD_CSSCLASSX = "CSSCLASSX";
    public static final String FIELD_GLYPH = "GLYPH";
    public static final String FIELD_HEIGHT = "HEIGHT";
    public static final String FIELD_IMAGEPATH = "IMAGEPATH";
    public static final String FIELD_IMAGEPATHX = "IMAGEPATHX";
    public static final String FIELD_IMAGESRC = "IMAGESRC";
    public static final String FIELD_IMAGETYPE = "IMAGETYPE";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSIMAGETEMPLID = "PSIMAGETEMPLID";
    public static final String FIELD_PSIMAGETEMPLNAME = "PSIMAGETEMPLNAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSFILEID = "PSSYSFILEID";
    public static final String FIELD_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String FIELD_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_RAWCONTENT = "RAWCONTENT";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_WIDTH = "WIDTH";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_CSSCLASS = 3;
    private static final int INDEX_CSSCLASSX = 4;
    private static final int INDEX_GLYPH = 5;
    private static final int INDEX_HEIGHT = 6;
    private static final int INDEX_IMAGEPATH = 7;
    private static final int INDEX_IMAGEPATHX = 8;
    private static final int INDEX_IMAGESRC = 9;
    private static final int INDEX_IMAGETYPE = 10;
    private static final int INDEX_LOCKFLAG = 11;
    private static final int INDEX_MEMO = 12;
    private static final int INDEX_PSIMAGETEMPLID = 13;
    private static final int INDEX_PSIMAGETEMPLNAME = 14;
    private static final int INDEX_PSMODULEID = 15;
    private static final int INDEX_PSMODULENAME = 16;
    private static final int INDEX_PSSYSFILEID = 17;
    private static final int INDEX_PSSYSIMAGEID = 18;
    private static final int INDEX_PSSYSIMAGENAME = 19;
    private static final int INDEX_PSSYSTEMID = 20;
    private static final int INDEX_PSSYSTEMNAME = 21;
    private static final int INDEX_RAWCONTENT = 22;
    private static final int INDEX_UPDATEDATE = 23;
    private static final int INDEX_UPDATEMAN = 24;
    private static final int INDEX_USERCAT = 25;
    private static final int INDEX_USERTAG = 26;
    private static final int INDEX_USERTAG2 = 27;
    private static final int INDEX_USERTAG3 = 28;
    private static final int INDEX_USERTAG4 = 29;
    private static final int INDEX_WIDTH = 30;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysImageBase proxyPSSysImageBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean cssclassDirtyFlag = false;
    private boolean cssclassxDirtyFlag = false;
    private boolean glyphDirtyFlag = false;
    private boolean heightDirtyFlag = false;
    private boolean imagepathDirtyFlag = false;
    private boolean imagepathxDirtyFlag = false;
    private boolean imagesrcDirtyFlag = false;
    private boolean imagetypeDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psimagetemplidDirtyFlag = false;
    private boolean psimagetemplnameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysfileidDirtyFlag = false;
    private boolean pssysimageidDirtyFlag = false;
    private boolean pssysimagenameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean rawcontentDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean widthDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="cssclass")
    private String cssclass;
    @Column(name="cssclassx")
    private String cssclassx;
    @Column(name="glyph")
    private String glyph;
    @Column(name="height")
    private Integer height;
    @Column(name="imagepath")
    private String imagepath;
    @Column(name="imagepathx")
    private String imagepathx;
    @Column(name="imagesrc")
    private String imagesrc;
    @Column(name="imagetype")
    private String imagetype;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="psimagetemplid")
    private String psimagetemplid;
    @Column(name="psimagetemplname")
    private String psimagetemplname;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssysfileid")
    private String pssysfileid;
    @Column(name="pssysimageid")
    private String pssysimageid;
    @Column(name="pssysimagename")
    private String pssysimagename;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="rawcontent")
    private String rawcontent;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    @Column(name="width")
    private Integer width;
    private Integer objPSImageTemplLock = new Integer(1);
    private PSImageTempl psimagetempl = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

    public void setCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename = string;
        this.codenameDirtyFlag = true;
    }

    public String getCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName();
        }
        return this.codename;
    }

    public boolean isCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeNameDirty();
        }
        return this.codenameDirtyFlag;
    }

    public void resetCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName();
            return;
        }
        this.codenameDirtyFlag = false;
        this.codename = null;
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

    public void setCssClass(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCssClass(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cssclass = string;
        this.cssclassDirtyFlag = true;
    }

    public String getCssClass() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCssClass();
        }
        return this.cssclass;
    }

    public boolean isCssClassDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCssClassDirty();
        }
        return this.cssclassDirtyFlag;
    }

    public void resetCssClass() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCssClass();
            return;
        }
        this.cssclassDirtyFlag = false;
        this.cssclass = null;
    }

    public void setCssClassX(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCssClassX(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cssclassx = string;
        this.cssclassxDirtyFlag = true;
    }

    public String getCssClassX() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCssClassX();
        }
        return this.cssclassx;
    }

    public boolean isCssClassXDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCssClassXDirty();
        }
        return this.cssclassxDirtyFlag;
    }

    public void resetCssClassX() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCssClassX();
            return;
        }
        this.cssclassxDirtyFlag = false;
        this.cssclassx = null;
    }

    public void setGlyph(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGlyph(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.glyph = string;
        this.glyphDirtyFlag = true;
    }

    public String getGlyph() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGlyph();
        }
        return this.glyph;
    }

    public boolean isGlyphDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGlyphDirty();
        }
        return this.glyphDirtyFlag;
    }

    public void resetGlyph() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGlyph();
            return;
        }
        this.glyphDirtyFlag = false;
        this.glyph = null;
    }

    public void setHeight(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHeight(n);
            return;
        }
        this.height = n;
        this.heightDirtyFlag = true;
    }

    public Integer getHeight() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHeight();
        }
        return this.height;
    }

    public boolean isHeightDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHeightDirty();
        }
        return this.heightDirtyFlag;
    }

    public void resetHeight() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHeight();
            return;
        }
        this.heightDirtyFlag = false;
        this.height = null;
    }

    public void setImagePath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setImagePath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.imagepath = string;
        this.imagepathDirtyFlag = true;
    }

    public String getImagePath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getImagePath();
        }
        return this.imagepath;
    }

    public boolean isImagePathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isImagePathDirty();
        }
        return this.imagepathDirtyFlag;
    }

    public void resetImagePath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetImagePath();
            return;
        }
        this.imagepathDirtyFlag = false;
        this.imagepath = null;
    }

    public void setImagePathX(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setImagePathX(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.imagepathx = string;
        this.imagepathxDirtyFlag = true;
    }

    public String getImagePathX() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getImagePathX();
        }
        return this.imagepathx;
    }

    public boolean isImagePathXDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isImagePathXDirty();
        }
        return this.imagepathxDirtyFlag;
    }

    public void resetImagePathX() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetImagePathX();
            return;
        }
        this.imagepathxDirtyFlag = false;
        this.imagepathx = null;
    }

    public void setImageSrc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setImageSrc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.imagesrc = string;
        this.imagesrcDirtyFlag = true;
    }

    public String getImageSrc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getImageSrc();
        }
        return this.imagesrc;
    }

    public boolean isImageSrcDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isImageSrcDirty();
        }
        return this.imagesrcDirtyFlag;
    }

    public void resetImageSrc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetImageSrc();
            return;
        }
        this.imagesrcDirtyFlag = false;
        this.imagesrc = null;
    }

    public void setImageType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setImageType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.imagetype = string;
        this.imagetypeDirtyFlag = true;
    }

    public String getImageType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getImageType();
        }
        return this.imagetype;
    }

    public boolean isImageTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isImageTypeDirty();
        }
        return this.imagetypeDirtyFlag;
    }

    public void resetImageType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetImageType();
            return;
        }
        this.imagetypeDirtyFlag = false;
        this.imagetype = null;
    }

    public void setLockFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLockFlag(n);
            return;
        }
        this.lockflag = n;
        this.lockflagDirtyFlag = true;
    }

    public Integer getLockFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLockFlag();
        }
        return this.lockflag;
    }

    public boolean isLockFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLockFlagDirty();
        }
        return this.lockflagDirtyFlag;
    }

    public void resetLockFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLockFlag();
            return;
        }
        this.lockflagDirtyFlag = false;
        this.lockflag = null;
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

    public void setPSImageTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSImageTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psimagetemplid = string;
        this.psimagetemplidDirtyFlag = true;
    }

    public String getPSImageTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSImageTemplId();
        }
        return this.psimagetemplid;
    }

    public boolean isPSImageTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSImageTemplIdDirty();
        }
        return this.psimagetemplidDirtyFlag;
    }

    public void resetPSImageTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSImageTemplId();
            return;
        }
        this.psimagetemplidDirtyFlag = false;
        this.psimagetemplid = null;
    }

    public void setPSImageTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSImageTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psimagetemplname = string;
        this.psimagetemplnameDirtyFlag = true;
    }

    public String getPSImageTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSImageTemplName();
        }
        return this.psimagetemplname;
    }

    public boolean isPSImageTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSImageTemplNameDirty();
        }
        return this.psimagetemplnameDirtyFlag;
    }

    public void resetPSImageTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSImageTemplName();
            return;
        }
        this.psimagetemplnameDirtyFlag = false;
        this.psimagetemplname = null;
    }

    public void setPSModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmoduleid = string;
        this.psmoduleidDirtyFlag = true;
    }

    public String getPSModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleId();
        }
        return this.psmoduleid;
    }

    public boolean isPSModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleIdDirty();
        }
        return this.psmoduleidDirtyFlag;
    }

    public void resetPSModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleId();
            return;
        }
        this.psmoduleidDirtyFlag = false;
        this.psmoduleid = null;
    }

    public void setPSModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodulename = string;
        this.psmodulenameDirtyFlag = true;
    }

    public String getPSModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleName();
        }
        return this.psmodulename;
    }

    public boolean isPSModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleNameDirty();
        }
        return this.psmodulenameDirtyFlag;
    }

    public void resetPSModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleName();
            return;
        }
        this.psmodulenameDirtyFlag = false;
        this.psmodulename = null;
    }

    public void setPSSysFileId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysFileId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysfileid = string;
        this.pssysfileidDirtyFlag = true;
    }

    public String getPSSysFileId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysFileId();
        }
        return this.pssysfileid;
    }

    public boolean isPSSysFileIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysFileIdDirty();
        }
        return this.pssysfileidDirtyFlag;
    }

    public void resetPSSysFileId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysFileId();
            return;
        }
        this.pssysfileidDirtyFlag = false;
        this.pssysfileid = null;
    }

    public void setPSSysImageId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysImageId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysimageid = string;
        this.pssysimageidDirtyFlag = true;
    }

    public String getPSSysImageId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysImageId();
        }
        return this.pssysimageid;
    }

    public boolean isPSSysImageIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysImageIdDirty();
        }
        return this.pssysimageidDirtyFlag;
    }

    public void resetPSSysImageId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysImageId();
            return;
        }
        this.pssysimageidDirtyFlag = false;
        this.pssysimageid = null;
    }

    public void setPSSysImageName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysImageName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysimagename = string;
        this.pssysimagenameDirtyFlag = true;
    }

    public String getPSSysImageName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysImageName();
        }
        return this.pssysimagename;
    }

    public boolean isPSSysImageNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysImageNameDirty();
        }
        return this.pssysimagenameDirtyFlag;
    }

    public void resetPSSysImageName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysImageName();
            return;
        }
        this.pssysimagenameDirtyFlag = false;
        this.pssysimagename = null;
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

    public void setRawContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRawContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rawcontent = string;
        this.rawcontentDirtyFlag = true;
    }

    public String getRawContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRawContent();
        }
        return this.rawcontent;
    }

    public boolean isRawContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRawContentDirty();
        }
        return this.rawcontentDirtyFlag;
    }

    public void resetRawContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRawContent();
            return;
        }
        this.rawcontentDirtyFlag = false;
        this.rawcontent = null;
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

    public void setUserCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usercat = string;
        this.usercatDirtyFlag = true;
    }

    public String getUserCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserCat();
        }
        return this.usercat;
    }

    public boolean isUserCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserCatDirty();
        }
        return this.usercatDirtyFlag;
    }

    public void resetUserCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserCat();
            return;
        }
        this.usercatDirtyFlag = false;
        this.usercat = null;
    }

    public void setUserTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag = string;
        this.usertagDirtyFlag = true;
    }

    public String getUserTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag();
        }
        return this.usertag;
    }

    public boolean isUserTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTagDirty();
        }
        return this.usertagDirtyFlag;
    }

    public void resetUserTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag();
            return;
        }
        this.usertagDirtyFlag = false;
        this.usertag = null;
    }

    public void setUserTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag2 = string;
        this.usertag2DirtyFlag = true;
    }

    public String getUserTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag2();
        }
        return this.usertag2;
    }

    public boolean isUserTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag2Dirty();
        }
        return this.usertag2DirtyFlag;
    }

    public void resetUserTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag2();
            return;
        }
        this.usertag2DirtyFlag = false;
        this.usertag2 = null;
    }

    public void setUserTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag3 = string;
        this.usertag3DirtyFlag = true;
    }

    public String getUserTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag3();
        }
        return this.usertag3;
    }

    public boolean isUserTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag3Dirty();
        }
        return this.usertag3DirtyFlag;
    }

    public void resetUserTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag3();
            return;
        }
        this.usertag3DirtyFlag = false;
        this.usertag3 = null;
    }

    public void setUserTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag4 = string;
        this.usertag4DirtyFlag = true;
    }

    public String getUserTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag4();
        }
        return this.usertag4;
    }

    public boolean isUserTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag4Dirty();
        }
        return this.usertag4DirtyFlag;
    }

    public void resetUserTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag4();
            return;
        }
        this.usertag4DirtyFlag = false;
        this.usertag4 = null;
    }

    public void setWidth(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWidth(n);
            return;
        }
        this.width = n;
        this.widthDirtyFlag = true;
    }

    public Integer getWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWidth();
        }
        return this.width;
    }

    public boolean isWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWidthDirty();
        }
        return this.widthDirtyFlag;
    }

    public void resetWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWidth();
            return;
        }
        this.widthDirtyFlag = false;
        this.width = null;
    }

    protected void onReset() {
        PSSysImageBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysImageBase pSSysImageBase) {
        pSSysImageBase.resetCodeName();
        pSSysImageBase.resetCreateDate();
        pSSysImageBase.resetCreateMan();
        pSSysImageBase.resetCssClass();
        pSSysImageBase.resetCssClassX();
        pSSysImageBase.resetGlyph();
        pSSysImageBase.resetHeight();
        pSSysImageBase.resetImagePath();
        pSSysImageBase.resetImagePathX();
        pSSysImageBase.resetImageSrc();
        pSSysImageBase.resetImageType();
        pSSysImageBase.resetLockFlag();
        pSSysImageBase.resetMemo();
        pSSysImageBase.resetPSImageTemplId();
        pSSysImageBase.resetPSImageTemplName();
        pSSysImageBase.resetPSModuleId();
        pSSysImageBase.resetPSModuleName();
        pSSysImageBase.resetPSSysFileId();
        pSSysImageBase.resetPSSysImageId();
        pSSysImageBase.resetPSSysImageName();
        pSSysImageBase.resetPSSystemId();
        pSSysImageBase.resetPSSystemName();
        pSSysImageBase.resetRawContent();
        pSSysImageBase.resetUpdateDate();
        pSSysImageBase.resetUpdateMan();
        pSSysImageBase.resetUserCat();
        pSSysImageBase.resetUserTag();
        pSSysImageBase.resetUserTag2();
        pSSysImageBase.resetUserTag3();
        pSSysImageBase.resetUserTag4();
        pSSysImageBase.resetWidth();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCssClassDirty()) {
            hashMap.put(FIELD_CSSCLASS, this.getCssClass());
        }
        if (!bl || this.isCssClassXDirty()) {
            hashMap.put(FIELD_CSSCLASSX, this.getCssClassX());
        }
        if (!bl || this.isGlyphDirty()) {
            hashMap.put(FIELD_GLYPH, this.getGlyph());
        }
        if (!bl || this.isHeightDirty()) {
            hashMap.put(FIELD_HEIGHT, this.getHeight());
        }
        if (!bl || this.isImagePathDirty()) {
            hashMap.put(FIELD_IMAGEPATH, this.getImagePath());
        }
        if (!bl || this.isImagePathXDirty()) {
            hashMap.put(FIELD_IMAGEPATHX, this.getImagePathX());
        }
        if (!bl || this.isImageSrcDirty()) {
            hashMap.put(FIELD_IMAGESRC, this.getImageSrc());
        }
        if (!bl || this.isImageTypeDirty()) {
            hashMap.put(FIELD_IMAGETYPE, this.getImageType());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSImageTemplIdDirty()) {
            hashMap.put(FIELD_PSIMAGETEMPLID, this.getPSImageTemplId());
        }
        if (!bl || this.isPSImageTemplNameDirty()) {
            hashMap.put(FIELD_PSIMAGETEMPLNAME, this.getPSImageTemplName());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSysFileIdDirty()) {
            hashMap.put(FIELD_PSSYSFILEID, this.getPSSysFileId());
        }
        if (!bl || this.isPSSysImageIdDirty()) {
            hashMap.put(FIELD_PSSYSIMAGEID, this.getPSSysImageId());
        }
        if (!bl || this.isPSSysImageNameDirty()) {
            hashMap.put(FIELD_PSSYSIMAGENAME, this.getPSSysImageName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isRawContentDirty()) {
            hashMap.put(FIELD_RAWCONTENT, this.getRawContent());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserCatDirty()) {
            hashMap.put(FIELD_USERCAT, this.getUserCat());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
        }
        if (!bl || this.isUserTag3Dirty()) {
            hashMap.put(FIELD_USERTAG3, this.getUserTag3());
        }
        if (!bl || this.isUserTag4Dirty()) {
            hashMap.put(FIELD_USERTAG4, this.getUserTag4());
        }
        if (!bl || this.isWidthDirty()) {
            hashMap.put(FIELD_WIDTH, this.getWidth());
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
        return PSSysImageBase.get(this, n);
    }

    private static Object get(PSSysImageBase pSSysImageBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysImageBase.getCodeName();
            }
            case 1: {
                return pSSysImageBase.getCreateDate();
            }
            case 2: {
                return pSSysImageBase.getCreateMan();
            }
            case 3: {
                return pSSysImageBase.getCssClass();
            }
            case 4: {
                return pSSysImageBase.getCssClassX();
            }
            case 5: {
                return pSSysImageBase.getGlyph();
            }
            case 6: {
                return pSSysImageBase.getHeight();
            }
            case 7: {
                return pSSysImageBase.getImagePath();
            }
            case 8: {
                return pSSysImageBase.getImagePathX();
            }
            case 9: {
                return pSSysImageBase.getImageSrc();
            }
            case 10: {
                return pSSysImageBase.getImageType();
            }
            case 11: {
                return pSSysImageBase.getLockFlag();
            }
            case 12: {
                return pSSysImageBase.getMemo();
            }
            case 13: {
                return pSSysImageBase.getPSImageTemplId();
            }
            case 14: {
                return pSSysImageBase.getPSImageTemplName();
            }
            case 15: {
                return pSSysImageBase.getPSModuleId();
            }
            case 16: {
                return pSSysImageBase.getPSModuleName();
            }
            case 17: {
                return pSSysImageBase.getPSSysFileId();
            }
            case 18: {
                return pSSysImageBase.getPSSysImageId();
            }
            case 19: {
                return pSSysImageBase.getPSSysImageName();
            }
            case 20: {
                return pSSysImageBase.getPSSystemId();
            }
            case 21: {
                return pSSysImageBase.getPSSystemName();
            }
            case 22: {
                return pSSysImageBase.getRawContent();
            }
            case 23: {
                return pSSysImageBase.getUpdateDate();
            }
            case 24: {
                return pSSysImageBase.getUpdateMan();
            }
            case 25: {
                return pSSysImageBase.getUserCat();
            }
            case 26: {
                return pSSysImageBase.getUserTag();
            }
            case 27: {
                return pSSysImageBase.getUserTag2();
            }
            case 28: {
                return pSSysImageBase.getUserTag3();
            }
            case 29: {
                return pSSysImageBase.getUserTag4();
            }
            case 30: {
                return pSSysImageBase.getWidth();
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
        PSSysImageBase.set(this, n, object);
    }

    private static void set(PSSysImageBase pSSysImageBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysImageBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysImageBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysImageBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysImageBase.setCssClass(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysImageBase.setCssClassX(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysImageBase.setGlyph(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysImageBase.setHeight(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSSysImageBase.setImagePath(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysImageBase.setImagePathX(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysImageBase.setImageSrc(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysImageBase.setImageType(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysImageBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSSysImageBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysImageBase.setPSImageTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysImageBase.setPSImageTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysImageBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysImageBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysImageBase.setPSSysFileId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysImageBase.setPSSysImageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysImageBase.setPSSysImageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysImageBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysImageBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysImageBase.setRawContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysImageBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 24: {
                pSSysImageBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysImageBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysImageBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysImageBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysImageBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysImageBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysImageBase.setWidth(DataObject.getIntegerValue((Object)object));
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
        return PSSysImageBase.isNull(this, n);
    }

    private static boolean isNull(PSSysImageBase pSSysImageBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysImageBase.getCodeName() == null;
            }
            case 1: {
                return pSSysImageBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysImageBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysImageBase.getCssClass() == null;
            }
            case 4: {
                return pSSysImageBase.getCssClassX() == null;
            }
            case 5: {
                return pSSysImageBase.getGlyph() == null;
            }
            case 6: {
                return pSSysImageBase.getHeight() == null;
            }
            case 7: {
                return pSSysImageBase.getImagePath() == null;
            }
            case 8: {
                return pSSysImageBase.getImagePathX() == null;
            }
            case 9: {
                return pSSysImageBase.getImageSrc() == null;
            }
            case 10: {
                return pSSysImageBase.getImageType() == null;
            }
            case 11: {
                return pSSysImageBase.getLockFlag() == null;
            }
            case 12: {
                return pSSysImageBase.getMemo() == null;
            }
            case 13: {
                return pSSysImageBase.getPSImageTemplId() == null;
            }
            case 14: {
                return pSSysImageBase.getPSImageTemplName() == null;
            }
            case 15: {
                return pSSysImageBase.getPSModuleId() == null;
            }
            case 16: {
                return pSSysImageBase.getPSModuleName() == null;
            }
            case 17: {
                return pSSysImageBase.getPSSysFileId() == null;
            }
            case 18: {
                return pSSysImageBase.getPSSysImageId() == null;
            }
            case 19: {
                return pSSysImageBase.getPSSysImageName() == null;
            }
            case 20: {
                return pSSysImageBase.getPSSystemId() == null;
            }
            case 21: {
                return pSSysImageBase.getPSSystemName() == null;
            }
            case 22: {
                return pSSysImageBase.getRawContent() == null;
            }
            case 23: {
                return pSSysImageBase.getUpdateDate() == null;
            }
            case 24: {
                return pSSysImageBase.getUpdateMan() == null;
            }
            case 25: {
                return pSSysImageBase.getUserCat() == null;
            }
            case 26: {
                return pSSysImageBase.getUserTag() == null;
            }
            case 27: {
                return pSSysImageBase.getUserTag2() == null;
            }
            case 28: {
                return pSSysImageBase.getUserTag3() == null;
            }
            case 29: {
                return pSSysImageBase.getUserTag4() == null;
            }
            case 30: {
                return pSSysImageBase.getWidth() == null;
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
        return PSSysImageBase.contains(this, n);
    }

    private static boolean contains(PSSysImageBase pSSysImageBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysImageBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysImageBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysImageBase.isCreateManDirty();
            }
            case 3: {
                return pSSysImageBase.isCssClassDirty();
            }
            case 4: {
                return pSSysImageBase.isCssClassXDirty();
            }
            case 5: {
                return pSSysImageBase.isGlyphDirty();
            }
            case 6: {
                return pSSysImageBase.isHeightDirty();
            }
            case 7: {
                return pSSysImageBase.isImagePathDirty();
            }
            case 8: {
                return pSSysImageBase.isImagePathXDirty();
            }
            case 9: {
                return pSSysImageBase.isImageSrcDirty();
            }
            case 10: {
                return pSSysImageBase.isImageTypeDirty();
            }
            case 11: {
                return pSSysImageBase.isLockFlagDirty();
            }
            case 12: {
                return pSSysImageBase.isMemoDirty();
            }
            case 13: {
                return pSSysImageBase.isPSImageTemplIdDirty();
            }
            case 14: {
                return pSSysImageBase.isPSImageTemplNameDirty();
            }
            case 15: {
                return pSSysImageBase.isPSModuleIdDirty();
            }
            case 16: {
                return pSSysImageBase.isPSModuleNameDirty();
            }
            case 17: {
                return pSSysImageBase.isPSSysFileIdDirty();
            }
            case 18: {
                return pSSysImageBase.isPSSysImageIdDirty();
            }
            case 19: {
                return pSSysImageBase.isPSSysImageNameDirty();
            }
            case 20: {
                return pSSysImageBase.isPSSystemIdDirty();
            }
            case 21: {
                return pSSysImageBase.isPSSystemNameDirty();
            }
            case 22: {
                return pSSysImageBase.isRawContentDirty();
            }
            case 23: {
                return pSSysImageBase.isUpdateDateDirty();
            }
            case 24: {
                return pSSysImageBase.isUpdateManDirty();
            }
            case 25: {
                return pSSysImageBase.isUserCatDirty();
            }
            case 26: {
                return pSSysImageBase.isUserTagDirty();
            }
            case 27: {
                return pSSysImageBase.isUserTag2Dirty();
            }
            case 28: {
                return pSSysImageBase.isUserTag3Dirty();
            }
            case 29: {
                return pSSysImageBase.isUserTag4Dirty();
            }
            case 30: {
                return pSSysImageBase.isWidthDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysImageBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysImageBase pSSysImageBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysImageBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysImageBase.getJSONValue((Object)pSSysImageBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysImageBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysImageBase.getJSONValue((Object)pSSysImageBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysImageBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysImageBase.getJSONValue((Object)pSSysImageBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysImageBase.getCssClass() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cssclass", (Object)PSSysImageBase.getJSONValue((Object)pSSysImageBase.getCssClass()), (boolean)false);
        }
        if (bl || pSSysImageBase.getCssClassX() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cssclassx", (Object)PSSysImageBase.getJSONValue((Object)pSSysImageBase.getCssClassX()), (boolean)false);
        }
        if (bl || pSSysImageBase.getGlyph() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"glyph", (Object)PSSysImageBase.getJSONValue((Object)pSSysImageBase.getGlyph()), (boolean)false);
        }
        if (bl || pSSysImageBase.getHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"height", (Object)PSSysImageBase.getJSONValue((Object)pSSysImageBase.getHeight()), (boolean)false);
        }
        if (bl || pSSysImageBase.getImagePath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"imagepath", (Object)PSSysImageBase.getJSONValue((Object)pSSysImageBase.getImagePath()), (boolean)false);
        }
        if (bl || pSSysImageBase.getImagePathX() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"imagepathx", (Object)PSSysImageBase.getJSONValue((Object)pSSysImageBase.getImagePathX()), (boolean)false);
        }
        if (bl || pSSysImageBase.getImageSrc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"imagesrc", (Object)PSSysImageBase.getJSONValue((Object)pSSysImageBase.getImageSrc()), (boolean)false);
        }
        if (bl || pSSysImageBase.getImageType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"imagetype", (Object)PSSysImageBase.getJSONValue((Object)pSSysImageBase.getImageType()), (boolean)false);
        }
        if (bl || pSSysImageBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSSysImageBase.getJSONValue((Object)pSSysImageBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSSysImageBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysImageBase.getJSONValue((Object)pSSysImageBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysImageBase.getPSImageTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psimagetemplid", (Object)PSSysImageBase.getJSONValue((Object)pSSysImageBase.getPSImageTemplId()), (boolean)false);
        }
        if (bl || pSSysImageBase.getPSImageTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psimagetemplname", (Object)PSSysImageBase.getJSONValue((Object)pSSysImageBase.getPSImageTemplName()), (boolean)false);
        }
        if (bl || pSSysImageBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysImageBase.getJSONValue((Object)pSSysImageBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysImageBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysImageBase.getJSONValue((Object)pSSysImageBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysImageBase.getPSSysFileId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysfileid", (Object)PSSysImageBase.getJSONValue((Object)pSSysImageBase.getPSSysFileId()), (boolean)false);
        }
        if (bl || pSSysImageBase.getPSSysImageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimageid", (Object)PSSysImageBase.getJSONValue((Object)pSSysImageBase.getPSSysImageId()), (boolean)false);
        }
        if (bl || pSSysImageBase.getPSSysImageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimagename", (Object)PSSysImageBase.getJSONValue((Object)pSSysImageBase.getPSSysImageName()), (boolean)false);
        }
        if (bl || pSSysImageBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysImageBase.getJSONValue((Object)pSSysImageBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysImageBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysImageBase.getJSONValue((Object)pSSysImageBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysImageBase.getRawContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rawcontent", (Object)PSSysImageBase.getJSONValue((Object)pSSysImageBase.getRawContent()), (boolean)false);
        }
        if (bl || pSSysImageBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysImageBase.getJSONValue((Object)pSSysImageBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysImageBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysImageBase.getJSONValue((Object)pSSysImageBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysImageBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysImageBase.getJSONValue((Object)pSSysImageBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysImageBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysImageBase.getJSONValue((Object)pSSysImageBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysImageBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysImageBase.getJSONValue((Object)pSSysImageBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysImageBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysImageBase.getJSONValue((Object)pSSysImageBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysImageBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysImageBase.getJSONValue((Object)pSSysImageBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysImageBase.getWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"width", (Object)PSSysImageBase.getJSONValue((Object)pSSysImageBase.getWidth()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysImageBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysImageBase pSSysImageBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysImageBase.getCodeName() != null) {
            object = pSSysImageBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysImageBase.getCreateDate() != null) {
            object = pSSysImageBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysImageBase.getCreateMan() != null) {
            object = pSSysImageBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysImageBase.getCssClass() != null) {
            object = pSSysImageBase.getCssClass();
            xmlNode.setAttribute(FIELD_CSSCLASS, object == null ? "" : (String)object);
        }
        if (bl || pSSysImageBase.getCssClassX() != null) {
            object = pSSysImageBase.getCssClassX();
            xmlNode.setAttribute(FIELD_CSSCLASSX, object == null ? "" : (String)object);
        }
        if (bl || pSSysImageBase.getGlyph() != null) {
            object = pSSysImageBase.getGlyph();
            xmlNode.setAttribute(FIELD_GLYPH, object == null ? "" : (String)object);
        }
        if (bl || pSSysImageBase.getHeight() != null) {
            object = pSSysImageBase.getHeight();
            xmlNode.setAttribute(FIELD_HEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysImageBase.getImagePath() != null) {
            object = pSSysImageBase.getImagePath();
            xmlNode.setAttribute(FIELD_IMAGEPATH, object == null ? "" : (String)object);
        }
        if (bl || pSSysImageBase.getImagePathX() != null) {
            object = pSSysImageBase.getImagePathX();
            xmlNode.setAttribute(FIELD_IMAGEPATHX, object == null ? "" : (String)object);
        }
        if (bl || pSSysImageBase.getImageSrc() != null) {
            object = pSSysImageBase.getImageSrc();
            xmlNode.setAttribute(FIELD_IMAGESRC, object == null ? "" : (String)object);
        }
        if (bl || pSSysImageBase.getImageType() != null) {
            object = pSSysImageBase.getImageType();
            xmlNode.setAttribute(FIELD_IMAGETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysImageBase.getLockFlag() != null) {
            object = pSSysImageBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysImageBase.getMemo() != null) {
            object = pSSysImageBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysImageBase.getPSImageTemplId() != null) {
            object = pSSysImageBase.getPSImageTemplId();
            xmlNode.setAttribute(FIELD_PSIMAGETEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSSysImageBase.getPSImageTemplName() != null) {
            object = pSSysImageBase.getPSImageTemplName();
            xmlNode.setAttribute(FIELD_PSIMAGETEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysImageBase.getPSModuleId() != null) {
            object = pSSysImageBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysImageBase.getPSModuleName() != null) {
            object = pSSysImageBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysImageBase.getPSSysFileId() != null) {
            object = pSSysImageBase.getPSSysFileId();
            xmlNode.setAttribute(FIELD_PSSYSFILEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysImageBase.getPSSysImageId() != null) {
            object = pSSysImageBase.getPSSysImageId();
            xmlNode.setAttribute(FIELD_PSSYSIMAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysImageBase.getPSSysImageName() != null) {
            object = pSSysImageBase.getPSSysImageName();
            xmlNode.setAttribute(FIELD_PSSYSIMAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysImageBase.getPSSystemId() != null) {
            object = pSSysImageBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysImageBase.getPSSystemName() != null) {
            object = pSSysImageBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysImageBase.getRawContent() != null) {
            object = pSSysImageBase.getRawContent();
            xmlNode.setAttribute(FIELD_RAWCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSSysImageBase.getUpdateDate() != null) {
            object = pSSysImageBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysImageBase.getUpdateMan() != null) {
            object = pSSysImageBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysImageBase.getUserCat() != null) {
            object = pSSysImageBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysImageBase.getUserTag() != null) {
            object = pSSysImageBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysImageBase.getUserTag2() != null) {
            object = pSSysImageBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysImageBase.getUserTag3() != null) {
            object = pSSysImageBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysImageBase.getUserTag4() != null) {
            object = pSSysImageBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysImageBase.getWidth() != null) {
            object = pSSysImageBase.getWidth();
            xmlNode.setAttribute(FIELD_WIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysImageBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysImageBase pSSysImageBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysImageBase.isCodeNameDirty() && (bl || pSSysImageBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysImageBase.getCodeName());
        }
        if (pSSysImageBase.isCreateDateDirty() && (bl || pSSysImageBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysImageBase.getCreateDate());
        }
        if (pSSysImageBase.isCreateManDirty() && (bl || pSSysImageBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysImageBase.getCreateMan());
        }
        if (pSSysImageBase.isCssClassDirty() && (bl || pSSysImageBase.getCssClass() != null)) {
            iDataObject.set(FIELD_CSSCLASS, (Object)pSSysImageBase.getCssClass());
        }
        if (pSSysImageBase.isCssClassXDirty() && (bl || pSSysImageBase.getCssClassX() != null)) {
            iDataObject.set(FIELD_CSSCLASSX, (Object)pSSysImageBase.getCssClassX());
        }
        if (pSSysImageBase.isGlyphDirty() && (bl || pSSysImageBase.getGlyph() != null)) {
            iDataObject.set(FIELD_GLYPH, (Object)pSSysImageBase.getGlyph());
        }
        if (pSSysImageBase.isHeightDirty() && (bl || pSSysImageBase.getHeight() != null)) {
            iDataObject.set(FIELD_HEIGHT, (Object)pSSysImageBase.getHeight());
        }
        if (pSSysImageBase.isImagePathDirty() && (bl || pSSysImageBase.getImagePath() != null)) {
            iDataObject.set(FIELD_IMAGEPATH, (Object)pSSysImageBase.getImagePath());
        }
        if (pSSysImageBase.isImagePathXDirty() && (bl || pSSysImageBase.getImagePathX() != null)) {
            iDataObject.set(FIELD_IMAGEPATHX, (Object)pSSysImageBase.getImagePathX());
        }
        if (pSSysImageBase.isImageSrcDirty() && (bl || pSSysImageBase.getImageSrc() != null)) {
            iDataObject.set(FIELD_IMAGESRC, (Object)pSSysImageBase.getImageSrc());
        }
        if (pSSysImageBase.isImageTypeDirty() && (bl || pSSysImageBase.getImageType() != null)) {
            iDataObject.set(FIELD_IMAGETYPE, (Object)pSSysImageBase.getImageType());
        }
        if (pSSysImageBase.isLockFlagDirty() && (bl || pSSysImageBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSSysImageBase.getLockFlag());
        }
        if (pSSysImageBase.isMemoDirty() && (bl || pSSysImageBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysImageBase.getMemo());
        }
        if (pSSysImageBase.isPSImageTemplIdDirty() && (bl || pSSysImageBase.getPSImageTemplId() != null)) {
            iDataObject.set(FIELD_PSIMAGETEMPLID, (Object)pSSysImageBase.getPSImageTemplId());
        }
        if (pSSysImageBase.isPSImageTemplNameDirty() && (bl || pSSysImageBase.getPSImageTemplName() != null)) {
            iDataObject.set(FIELD_PSIMAGETEMPLNAME, (Object)pSSysImageBase.getPSImageTemplName());
        }
        if (pSSysImageBase.isPSModuleIdDirty() && (bl || pSSysImageBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysImageBase.getPSModuleId());
        }
        if (pSSysImageBase.isPSModuleNameDirty() && (bl || pSSysImageBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysImageBase.getPSModuleName());
        }
        if (pSSysImageBase.isPSSysFileIdDirty() && (bl || pSSysImageBase.getPSSysFileId() != null)) {
            iDataObject.set(FIELD_PSSYSFILEID, (Object)pSSysImageBase.getPSSysFileId());
        }
        if (pSSysImageBase.isPSSysImageIdDirty() && (bl || pSSysImageBase.getPSSysImageId() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGEID, (Object)pSSysImageBase.getPSSysImageId());
        }
        if (pSSysImageBase.isPSSysImageNameDirty() && (bl || pSSysImageBase.getPSSysImageName() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGENAME, (Object)pSSysImageBase.getPSSysImageName());
        }
        if (pSSysImageBase.isPSSystemIdDirty() && (bl || pSSysImageBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysImageBase.getPSSystemId());
        }
        if (pSSysImageBase.isPSSystemNameDirty() && (bl || pSSysImageBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysImageBase.getPSSystemName());
        }
        if (pSSysImageBase.isRawContentDirty() && (bl || pSSysImageBase.getRawContent() != null)) {
            iDataObject.set(FIELD_RAWCONTENT, (Object)pSSysImageBase.getRawContent());
        }
        if (pSSysImageBase.isUpdateDateDirty() && (bl || pSSysImageBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysImageBase.getUpdateDate());
        }
        if (pSSysImageBase.isUpdateManDirty() && (bl || pSSysImageBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysImageBase.getUpdateMan());
        }
        if (pSSysImageBase.isUserCatDirty() && (bl || pSSysImageBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysImageBase.getUserCat());
        }
        if (pSSysImageBase.isUserTagDirty() && (bl || pSSysImageBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysImageBase.getUserTag());
        }
        if (pSSysImageBase.isUserTag2Dirty() && (bl || pSSysImageBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysImageBase.getUserTag2());
        }
        if (pSSysImageBase.isUserTag3Dirty() && (bl || pSSysImageBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysImageBase.getUserTag3());
        }
        if (pSSysImageBase.isUserTag4Dirty() && (bl || pSSysImageBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysImageBase.getUserTag4());
        }
        if (pSSysImageBase.isWidthDirty() && (bl || pSSysImageBase.getWidth() != null)) {
            iDataObject.set(FIELD_WIDTH, (Object)pSSysImageBase.getWidth());
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
        return PSSysImageBase.remove(this, n);
    }

    private static boolean remove(PSSysImageBase pSSysImageBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysImageBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysImageBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysImageBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysImageBase.resetCssClass();
                return true;
            }
            case 4: {
                pSSysImageBase.resetCssClassX();
                return true;
            }
            case 5: {
                pSSysImageBase.resetGlyph();
                return true;
            }
            case 6: {
                pSSysImageBase.resetHeight();
                return true;
            }
            case 7: {
                pSSysImageBase.resetImagePath();
                return true;
            }
            case 8: {
                pSSysImageBase.resetImagePathX();
                return true;
            }
            case 9: {
                pSSysImageBase.resetImageSrc();
                return true;
            }
            case 10: {
                pSSysImageBase.resetImageType();
                return true;
            }
            case 11: {
                pSSysImageBase.resetLockFlag();
                return true;
            }
            case 12: {
                pSSysImageBase.resetMemo();
                return true;
            }
            case 13: {
                pSSysImageBase.resetPSImageTemplId();
                return true;
            }
            case 14: {
                pSSysImageBase.resetPSImageTemplName();
                return true;
            }
            case 15: {
                pSSysImageBase.resetPSModuleId();
                return true;
            }
            case 16: {
                pSSysImageBase.resetPSModuleName();
                return true;
            }
            case 17: {
                pSSysImageBase.resetPSSysFileId();
                return true;
            }
            case 18: {
                pSSysImageBase.resetPSSysImageId();
                return true;
            }
            case 19: {
                pSSysImageBase.resetPSSysImageName();
                return true;
            }
            case 20: {
                pSSysImageBase.resetPSSystemId();
                return true;
            }
            case 21: {
                pSSysImageBase.resetPSSystemName();
                return true;
            }
            case 22: {
                pSSysImageBase.resetRawContent();
                return true;
            }
            case 23: {
                pSSysImageBase.resetUpdateDate();
                return true;
            }
            case 24: {
                pSSysImageBase.resetUpdateMan();
                return true;
            }
            case 25: {
                pSSysImageBase.resetUserCat();
                return true;
            }
            case 26: {
                pSSysImageBase.resetUserTag();
                return true;
            }
            case 27: {
                pSSysImageBase.resetUserTag2();
                return true;
            }
            case 28: {
                pSSysImageBase.resetUserTag3();
                return true;
            }
            case 29: {
                pSSysImageBase.resetUserTag4();
                return true;
            }
            case 30: {
                pSSysImageBase.resetWidth();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSImageTempl getPSImageTempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSImageTempl();
        }
        if (this.getPSImageTemplId() == null) {
            return null;
        }
        Integer n = this.objPSImageTemplLock;
        synchronized (n) {
            if (this.psimagetempl != null && DataTypeHelper.compare((int)25, (Object)this.getPSImageTemplId(), (Object)this.psimagetempl.getPSImageTemplId()) != 0L) {
                this.psimagetempl = null;
            }
            if (this.psimagetempl == null) {
                PSImageTempl pSImageTempl = new PSImageTempl();
                pSImageTempl.setPSImageTemplId(this.getPSImageTemplId());
                PSImageTemplService pSImageTemplService = (PSImageTemplService)ServiceGlobal.getService(PSImageTemplService.class, (SessionFactory)this.getSessionFactory());
                pSImageTemplService.autoGet((IEntity)pSImageTempl);
                this.psimagetempl = pSImageTempl;
            }
            return this.psimagetempl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModule getPSModule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModule();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        Integer n = this.objPSModuleLock;
        synchronized (n) {
            if (this.psmodule != null && DataTypeHelper.compare((int)25, (Object)this.getPSModuleId(), (Object)this.psmodule.getPSModuleId()) != 0L) {
                this.psmodule = null;
            }
            if (this.psmodule == null) {
                PSModule pSModule = new PSModule();
                pSModule.setPSModuleId(this.getPSModuleId());
                PSModuleService pSModuleService = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.getSessionFactory());
                pSModuleService.autoGet((IEntity)pSModule);
                this.psmodule = pSModule;
            }
            return this.psmodule;
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

    private PSSysImageBase getProxyEntity() {
        return this.proxyPSSysImageBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysImageBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysImageBase) {
            this.proxyPSSysImageBase = (PSSysImageBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_CSSCLASS, 3);
        fieldIndexMap.put(FIELD_CSSCLASSX, 4);
        fieldIndexMap.put(FIELD_GLYPH, 5);
        fieldIndexMap.put(FIELD_HEIGHT, 6);
        fieldIndexMap.put(FIELD_IMAGEPATH, 7);
        fieldIndexMap.put(FIELD_IMAGEPATHX, 8);
        fieldIndexMap.put(FIELD_IMAGESRC, 9);
        fieldIndexMap.put(FIELD_IMAGETYPE, 10);
        fieldIndexMap.put(FIELD_LOCKFLAG, 11);
        fieldIndexMap.put(FIELD_MEMO, 12);
        fieldIndexMap.put(FIELD_PSIMAGETEMPLID, 13);
        fieldIndexMap.put(FIELD_PSIMAGETEMPLNAME, 14);
        fieldIndexMap.put(FIELD_PSMODULEID, 15);
        fieldIndexMap.put(FIELD_PSMODULENAME, 16);
        fieldIndexMap.put(FIELD_PSSYSFILEID, 17);
        fieldIndexMap.put(FIELD_PSSYSIMAGEID, 18);
        fieldIndexMap.put(FIELD_PSSYSIMAGENAME, 19);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 20);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 21);
        fieldIndexMap.put(FIELD_RAWCONTENT, 22);
        fieldIndexMap.put(FIELD_UPDATEDATE, 23);
        fieldIndexMap.put(FIELD_UPDATEMAN, 24);
        fieldIndexMap.put(FIELD_USERCAT, 25);
        fieldIndexMap.put(FIELD_USERTAG, 26);
        fieldIndexMap.put(FIELD_USERTAG2, 27);
        fieldIndexMap.put(FIELD_USERTAG3, 28);
        fieldIndexMap.put(FIELD_USERTAG4, 29);
        fieldIndexMap.put(FIELD_WIDTH, 30);
    }
}

