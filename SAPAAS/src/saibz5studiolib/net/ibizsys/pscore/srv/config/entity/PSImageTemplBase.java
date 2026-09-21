/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
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
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSImageTemplBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSImageTemplBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CSSCLASS = "CSSCLASS";
    public static final String FIELD_GLYPH = "GLYPH";
    public static final String FIELD_HEIGHT = "HEIGHT";
    public static final String FIELD_IMAGEPATH = "IMAGEPATH";
    public static final String FIELD_IMAGESRC = "IMAGESRC";
    public static final String FIELD_IMAGETYPE = "IMAGETYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSIMAGETEMPLID = "PSIMAGETEMPLID";
    public static final String FIELD_PSIMAGETEMPLNAME = "PSIMAGETEMPLNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_WIDTH = "WIDTH";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_CSSCLASS = 2;
    private static final int INDEX_GLYPH = 3;
    private static final int INDEX_HEIGHT = 4;
    private static final int INDEX_IMAGEPATH = 5;
    private static final int INDEX_IMAGESRC = 6;
    private static final int INDEX_IMAGETYPE = 7;
    private static final int INDEX_MEMO = 8;
    private static final int INDEX_PSIMAGETEMPLID = 9;
    private static final int INDEX_PSIMAGETEMPLNAME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_WIDTH = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSImageTemplBase proxyPSImageTemplBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean cssclassDirtyFlag = false;
    private boolean glyphDirtyFlag = false;
    private boolean heightDirtyFlag = false;
    private boolean imagepathDirtyFlag = false;
    private boolean imagesrcDirtyFlag = false;
    private boolean imagetypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psimagetemplidDirtyFlag = false;
    private boolean psimagetemplnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean widthDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="cssclass")
    private String cssclass;
    @Column(name="glyph")
    private String glyph;
    @Column(name="height")
    private Integer height;
    @Column(name="imagepath")
    private String imagepath;
    @Column(name="imagesrc")
    private String imagesrc;
    @Column(name="imagetype")
    private String imagetype;
    @Column(name="memo")
    private String memo;
    @Column(name="psimagetemplid")
    private String psimagetemplid;
    @Column(name="psimagetemplname")
    private String psimagetemplname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="width")
    private Integer width;

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
        PSImageTemplBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSImageTemplBase pSImageTemplBase) {
        pSImageTemplBase.resetCreateDate();
        pSImageTemplBase.resetCreateMan();
        pSImageTemplBase.resetCssClass();
        pSImageTemplBase.resetGlyph();
        pSImageTemplBase.resetHeight();
        pSImageTemplBase.resetImagePath();
        pSImageTemplBase.resetImageSrc();
        pSImageTemplBase.resetImageType();
        pSImageTemplBase.resetMemo();
        pSImageTemplBase.resetPSImageTemplId();
        pSImageTemplBase.resetPSImageTemplName();
        pSImageTemplBase.resetUpdateDate();
        pSImageTemplBase.resetUpdateMan();
        pSImageTemplBase.resetWidth();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCssClassDirty()) {
            hashMap.put(FIELD_CSSCLASS, this.getCssClass());
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
        if (!bl || this.isImageSrcDirty()) {
            hashMap.put(FIELD_IMAGESRC, this.getImageSrc());
        }
        if (!bl || this.isImageTypeDirty()) {
            hashMap.put(FIELD_IMAGETYPE, this.getImageType());
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
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSImageTemplBase.get(this, n);
    }

    private static Object get(PSImageTemplBase pSImageTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSImageTemplBase.getCreateDate();
            }
            case 1: {
                return pSImageTemplBase.getCreateMan();
            }
            case 2: {
                return pSImageTemplBase.getCssClass();
            }
            case 3: {
                return pSImageTemplBase.getGlyph();
            }
            case 4: {
                return pSImageTemplBase.getHeight();
            }
            case 5: {
                return pSImageTemplBase.getImagePath();
            }
            case 6: {
                return pSImageTemplBase.getImageSrc();
            }
            case 7: {
                return pSImageTemplBase.getImageType();
            }
            case 8: {
                return pSImageTemplBase.getMemo();
            }
            case 9: {
                return pSImageTemplBase.getPSImageTemplId();
            }
            case 10: {
                return pSImageTemplBase.getPSImageTemplName();
            }
            case 11: {
                return pSImageTemplBase.getUpdateDate();
            }
            case 12: {
                return pSImageTemplBase.getUpdateMan();
            }
            case 13: {
                return pSImageTemplBase.getWidth();
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
        PSImageTemplBase.set(this, n, object);
    }

    private static void set(PSImageTemplBase pSImageTemplBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSImageTemplBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSImageTemplBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSImageTemplBase.setCssClass(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSImageTemplBase.setGlyph(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSImageTemplBase.setHeight(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSImageTemplBase.setImagePath(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSImageTemplBase.setImageSrc(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSImageTemplBase.setImageType(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSImageTemplBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSImageTemplBase.setPSImageTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSImageTemplBase.setPSImageTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSImageTemplBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSImageTemplBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSImageTemplBase.setWidth(DataObject.getIntegerValue((Object)object));
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
        return PSImageTemplBase.isNull(this, n);
    }

    private static boolean isNull(PSImageTemplBase pSImageTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSImageTemplBase.getCreateDate() == null;
            }
            case 1: {
                return pSImageTemplBase.getCreateMan() == null;
            }
            case 2: {
                return pSImageTemplBase.getCssClass() == null;
            }
            case 3: {
                return pSImageTemplBase.getGlyph() == null;
            }
            case 4: {
                return pSImageTemplBase.getHeight() == null;
            }
            case 5: {
                return pSImageTemplBase.getImagePath() == null;
            }
            case 6: {
                return pSImageTemplBase.getImageSrc() == null;
            }
            case 7: {
                return pSImageTemplBase.getImageType() == null;
            }
            case 8: {
                return pSImageTemplBase.getMemo() == null;
            }
            case 9: {
                return pSImageTemplBase.getPSImageTemplId() == null;
            }
            case 10: {
                return pSImageTemplBase.getPSImageTemplName() == null;
            }
            case 11: {
                return pSImageTemplBase.getUpdateDate() == null;
            }
            case 12: {
                return pSImageTemplBase.getUpdateMan() == null;
            }
            case 13: {
                return pSImageTemplBase.getWidth() == null;
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
        return PSImageTemplBase.contains(this, n);
    }

    private static boolean contains(PSImageTemplBase pSImageTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSImageTemplBase.isCreateDateDirty();
            }
            case 1: {
                return pSImageTemplBase.isCreateManDirty();
            }
            case 2: {
                return pSImageTemplBase.isCssClassDirty();
            }
            case 3: {
                return pSImageTemplBase.isGlyphDirty();
            }
            case 4: {
                return pSImageTemplBase.isHeightDirty();
            }
            case 5: {
                return pSImageTemplBase.isImagePathDirty();
            }
            case 6: {
                return pSImageTemplBase.isImageSrcDirty();
            }
            case 7: {
                return pSImageTemplBase.isImageTypeDirty();
            }
            case 8: {
                return pSImageTemplBase.isMemoDirty();
            }
            case 9: {
                return pSImageTemplBase.isPSImageTemplIdDirty();
            }
            case 10: {
                return pSImageTemplBase.isPSImageTemplNameDirty();
            }
            case 11: {
                return pSImageTemplBase.isUpdateDateDirty();
            }
            case 12: {
                return pSImageTemplBase.isUpdateManDirty();
            }
            case 13: {
                return pSImageTemplBase.isWidthDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSImageTemplBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSImageTemplBase pSImageTemplBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSImageTemplBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSImageTemplBase.getJSONValue((Object)pSImageTemplBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSImageTemplBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSImageTemplBase.getJSONValue((Object)pSImageTemplBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSImageTemplBase.getCssClass() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cssclass", (Object)PSImageTemplBase.getJSONValue((Object)pSImageTemplBase.getCssClass()), (boolean)false);
        }
        if (bl || pSImageTemplBase.getGlyph() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"glyph", (Object)PSImageTemplBase.getJSONValue((Object)pSImageTemplBase.getGlyph()), (boolean)false);
        }
        if (bl || pSImageTemplBase.getHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"height", (Object)PSImageTemplBase.getJSONValue((Object)pSImageTemplBase.getHeight()), (boolean)false);
        }
        if (bl || pSImageTemplBase.getImagePath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"imagepath", (Object)PSImageTemplBase.getJSONValue((Object)pSImageTemplBase.getImagePath()), (boolean)false);
        }
        if (bl || pSImageTemplBase.getImageSrc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"imagesrc", (Object)PSImageTemplBase.getJSONValue((Object)pSImageTemplBase.getImageSrc()), (boolean)false);
        }
        if (bl || pSImageTemplBase.getImageType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"imagetype", (Object)PSImageTemplBase.getJSONValue((Object)pSImageTemplBase.getImageType()), (boolean)false);
        }
        if (bl || pSImageTemplBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSImageTemplBase.getJSONValue((Object)pSImageTemplBase.getMemo()), (boolean)false);
        }
        if (bl || pSImageTemplBase.getPSImageTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psimagetemplid", (Object)PSImageTemplBase.getJSONValue((Object)pSImageTemplBase.getPSImageTemplId()), (boolean)false);
        }
        if (bl || pSImageTemplBase.getPSImageTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psimagetemplname", (Object)PSImageTemplBase.getJSONValue((Object)pSImageTemplBase.getPSImageTemplName()), (boolean)false);
        }
        if (bl || pSImageTemplBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSImageTemplBase.getJSONValue((Object)pSImageTemplBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSImageTemplBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSImageTemplBase.getJSONValue((Object)pSImageTemplBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSImageTemplBase.getWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"width", (Object)PSImageTemplBase.getJSONValue((Object)pSImageTemplBase.getWidth()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSImageTemplBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSImageTemplBase pSImageTemplBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSImageTemplBase.getCreateDate() != null) {
            object = pSImageTemplBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSImageTemplBase.getCreateMan() != null) {
            object = pSImageTemplBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSImageTemplBase.getCssClass() != null) {
            object = pSImageTemplBase.getCssClass();
            xmlNode.setAttribute(FIELD_CSSCLASS, object == null ? "" : (String)object);
        }
        if (bl || pSImageTemplBase.getGlyph() != null) {
            object = pSImageTemplBase.getGlyph();
            xmlNode.setAttribute(FIELD_GLYPH, object == null ? "" : (String)object);
        }
        if (bl || pSImageTemplBase.getHeight() != null) {
            object = pSImageTemplBase.getHeight();
            xmlNode.setAttribute(FIELD_HEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSImageTemplBase.getImagePath() != null) {
            object = pSImageTemplBase.getImagePath();
            xmlNode.setAttribute(FIELD_IMAGEPATH, object == null ? "" : (String)object);
        }
        if (bl || pSImageTemplBase.getImageSrc() != null) {
            object = pSImageTemplBase.getImageSrc();
            xmlNode.setAttribute(FIELD_IMAGESRC, object == null ? "" : (String)object);
        }
        if (bl || pSImageTemplBase.getImageType() != null) {
            object = pSImageTemplBase.getImageType();
            xmlNode.setAttribute(FIELD_IMAGETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSImageTemplBase.getMemo() != null) {
            object = pSImageTemplBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSImageTemplBase.getPSImageTemplId() != null) {
            object = pSImageTemplBase.getPSImageTemplId();
            xmlNode.setAttribute(FIELD_PSIMAGETEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSImageTemplBase.getPSImageTemplName() != null) {
            object = pSImageTemplBase.getPSImageTemplName();
            xmlNode.setAttribute(FIELD_PSIMAGETEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSImageTemplBase.getUpdateDate() != null) {
            object = pSImageTemplBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSImageTemplBase.getUpdateMan() != null) {
            object = pSImageTemplBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSImageTemplBase.getWidth() != null) {
            object = pSImageTemplBase.getWidth();
            xmlNode.setAttribute(FIELD_WIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSImageTemplBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSImageTemplBase pSImageTemplBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSImageTemplBase.isCreateDateDirty() && (bl || pSImageTemplBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSImageTemplBase.getCreateDate());
        }
        if (pSImageTemplBase.isCreateManDirty() && (bl || pSImageTemplBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSImageTemplBase.getCreateMan());
        }
        if (pSImageTemplBase.isCssClassDirty() && (bl || pSImageTemplBase.getCssClass() != null)) {
            iDataObject.set(FIELD_CSSCLASS, (Object)pSImageTemplBase.getCssClass());
        }
        if (pSImageTemplBase.isGlyphDirty() && (bl || pSImageTemplBase.getGlyph() != null)) {
            iDataObject.set(FIELD_GLYPH, (Object)pSImageTemplBase.getGlyph());
        }
        if (pSImageTemplBase.isHeightDirty() && (bl || pSImageTemplBase.getHeight() != null)) {
            iDataObject.set(FIELD_HEIGHT, (Object)pSImageTemplBase.getHeight());
        }
        if (pSImageTemplBase.isImagePathDirty() && (bl || pSImageTemplBase.getImagePath() != null)) {
            iDataObject.set(FIELD_IMAGEPATH, (Object)pSImageTemplBase.getImagePath());
        }
        if (pSImageTemplBase.isImageSrcDirty() && (bl || pSImageTemplBase.getImageSrc() != null)) {
            iDataObject.set(FIELD_IMAGESRC, (Object)pSImageTemplBase.getImageSrc());
        }
        if (pSImageTemplBase.isImageTypeDirty() && (bl || pSImageTemplBase.getImageType() != null)) {
            iDataObject.set(FIELD_IMAGETYPE, (Object)pSImageTemplBase.getImageType());
        }
        if (pSImageTemplBase.isMemoDirty() && (bl || pSImageTemplBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSImageTemplBase.getMemo());
        }
        if (pSImageTemplBase.isPSImageTemplIdDirty() && (bl || pSImageTemplBase.getPSImageTemplId() != null)) {
            iDataObject.set(FIELD_PSIMAGETEMPLID, (Object)pSImageTemplBase.getPSImageTemplId());
        }
        if (pSImageTemplBase.isPSImageTemplNameDirty() && (bl || pSImageTemplBase.getPSImageTemplName() != null)) {
            iDataObject.set(FIELD_PSIMAGETEMPLNAME, (Object)pSImageTemplBase.getPSImageTemplName());
        }
        if (pSImageTemplBase.isUpdateDateDirty() && (bl || pSImageTemplBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSImageTemplBase.getUpdateDate());
        }
        if (pSImageTemplBase.isUpdateManDirty() && (bl || pSImageTemplBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSImageTemplBase.getUpdateMan());
        }
        if (pSImageTemplBase.isWidthDirty() && (bl || pSImageTemplBase.getWidth() != null)) {
            iDataObject.set(FIELD_WIDTH, (Object)pSImageTemplBase.getWidth());
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
        return PSImageTemplBase.remove(this, n);
    }

    private static boolean remove(PSImageTemplBase pSImageTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSImageTemplBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSImageTemplBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSImageTemplBase.resetCssClass();
                return true;
            }
            case 3: {
                pSImageTemplBase.resetGlyph();
                return true;
            }
            case 4: {
                pSImageTemplBase.resetHeight();
                return true;
            }
            case 5: {
                pSImageTemplBase.resetImagePath();
                return true;
            }
            case 6: {
                pSImageTemplBase.resetImageSrc();
                return true;
            }
            case 7: {
                pSImageTemplBase.resetImageType();
                return true;
            }
            case 8: {
                pSImageTemplBase.resetMemo();
                return true;
            }
            case 9: {
                pSImageTemplBase.resetPSImageTemplId();
                return true;
            }
            case 10: {
                pSImageTemplBase.resetPSImageTemplName();
                return true;
            }
            case 11: {
                pSImageTemplBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSImageTemplBase.resetUpdateMan();
                return true;
            }
            case 13: {
                pSImageTemplBase.resetWidth();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSImageTemplBase getProxyEntity() {
        return this.proxyPSImageTemplBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSImageTemplBase = null;
        if (iDataObject != null && iDataObject instanceof PSImageTemplBase) {
            this.proxyPSImageTemplBase = (PSImageTemplBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSImageTemplService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_CSSCLASS, 2);
        fieldIndexMap.put(FIELD_GLYPH, 3);
        fieldIndexMap.put(FIELD_HEIGHT, 4);
        fieldIndexMap.put(FIELD_IMAGEPATH, 5);
        fieldIndexMap.put(FIELD_IMAGESRC, 6);
        fieldIndexMap.put(FIELD_IMAGETYPE, 7);
        fieldIndexMap.put(FIELD_MEMO, 8);
        fieldIndexMap.put(FIELD_PSIMAGETEMPLID, 9);
        fieldIndexMap.put(FIELD_PSIMAGETEMPLNAME, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
        fieldIndexMap.put(FIELD_WIDTH, 13);
    }
}

