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
package net.ibizsys.pscore.srv.helpdesign.entity;

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
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSHelpArticleCatBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSHelpArticleCatBase.class);
    public static final String FIELD_ARTICLETYPE = "ARTICLETYPE";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSHELPARTICLECATID = "PSHELPARTICLECATID";
    public static final String FIELD_PSHELPARTICLECATNAME = "PSHELPARTICLECATNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_ARTICLETYPE = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSDEID = 5;
    private static final int INDEX_PSDENAME = 6;
    private static final int INDEX_PSHELPARTICLECATID = 7;
    private static final int INDEX_PSHELPARTICLECATNAME = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final int INDEX_USERCAT = 11;
    private static final int INDEX_USERTAG = 12;
    private static final int INDEX_USERTAG2 = 13;
    private static final int INDEX_USERTAG3 = 14;
    private static final int INDEX_USERTAG4 = 15;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSHelpArticleCatBase proxyPSHelpArticleCatBase = null;
    private boolean articletypeDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean pshelparticlecatidDirtyFlag = false;
    private boolean pshelparticlecatnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="articletype")
    private String articletype;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="pshelparticlecatid")
    private String pshelparticlecatid;
    @Column(name="pshelparticlecatname")
    private String pshelparticlecatname;
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
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;

    public void setArticleType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setArticleType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.articletype = string;
        this.articletypeDirtyFlag = true;
    }

    public String getArticleType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getArticleType();
        }
        return this.articletype;
    }

    public boolean isArticleTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isArticleTypeDirty();
        }
        return this.articletypeDirtyFlag;
    }

    public void resetArticleType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetArticleType();
            return;
        }
        this.articletypeDirtyFlag = false;
        this.articletype = null;
    }

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

    public void setPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeid = string;
        this.psdeidDirtyFlag = true;
    }

    public String getPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEId();
        }
        return this.psdeid;
    }

    public boolean isPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEIdDirty();
        }
        return this.psdeidDirtyFlag;
    }

    public void resetPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEId();
            return;
        }
        this.psdeidDirtyFlag = false;
        this.psdeid = null;
    }

    public void setPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdename = string;
        this.psdenameDirtyFlag = true;
    }

    public String getPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEName();
        }
        return this.psdename;
    }

    public boolean isPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDENameDirty();
        }
        return this.psdenameDirtyFlag;
    }

    public void resetPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEName();
            return;
        }
        this.psdenameDirtyFlag = false;
        this.psdename = null;
    }

    public void setPSHelpArticleCatId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpArticleCatId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelparticlecatid = string;
        this.pshelparticlecatidDirtyFlag = true;
    }

    public String getPSHelpArticleCatId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpArticleCatId();
        }
        return this.pshelparticlecatid;
    }

    public boolean isPSHelpArticleCatIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpArticleCatIdDirty();
        }
        return this.pshelparticlecatidDirtyFlag;
    }

    public void resetPSHelpArticleCatId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpArticleCatId();
            return;
        }
        this.pshelparticlecatidDirtyFlag = false;
        this.pshelparticlecatid = null;
    }

    public void setPSHelpArticleCatName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpArticleCatName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelparticlecatname = string;
        this.pshelparticlecatnameDirtyFlag = true;
    }

    public String getPSHelpArticleCatName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpArticleCatName();
        }
        return this.pshelparticlecatname;
    }

    public boolean isPSHelpArticleCatNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpArticleCatNameDirty();
        }
        return this.pshelparticlecatnameDirtyFlag;
    }

    public void resetPSHelpArticleCatName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpArticleCatName();
            return;
        }
        this.pshelparticlecatnameDirtyFlag = false;
        this.pshelparticlecatname = null;
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

    protected void onReset() {
        PSHelpArticleCatBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSHelpArticleCatBase pSHelpArticleCatBase) {
        pSHelpArticleCatBase.resetArticleType();
        pSHelpArticleCatBase.resetCodeName();
        pSHelpArticleCatBase.resetCreateDate();
        pSHelpArticleCatBase.resetCreateMan();
        pSHelpArticleCatBase.resetMemo();
        pSHelpArticleCatBase.resetPSDEId();
        pSHelpArticleCatBase.resetPSDEName();
        pSHelpArticleCatBase.resetPSHelpArticleCatId();
        pSHelpArticleCatBase.resetPSHelpArticleCatName();
        pSHelpArticleCatBase.resetUpdateDate();
        pSHelpArticleCatBase.resetUpdateMan();
        pSHelpArticleCatBase.resetUserCat();
        pSHelpArticleCatBase.resetUserTag();
        pSHelpArticleCatBase.resetUserTag2();
        pSHelpArticleCatBase.resetUserTag3();
        pSHelpArticleCatBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isArticleTypeDirty()) {
            hashMap.put(FIELD_ARTICLETYPE, this.getArticleType());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSHelpArticleCatIdDirty()) {
            hashMap.put(FIELD_PSHELPARTICLECATID, this.getPSHelpArticleCatId());
        }
        if (!bl || this.isPSHelpArticleCatNameDirty()) {
            hashMap.put(FIELD_PSHELPARTICLECATNAME, this.getPSHelpArticleCatName());
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
        return PSHelpArticleCatBase.get(this, n);
    }

    private static Object get(PSHelpArticleCatBase pSHelpArticleCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSHelpArticleCatBase.getArticleType();
            }
            case 1: {
                return pSHelpArticleCatBase.getCodeName();
            }
            case 2: {
                return pSHelpArticleCatBase.getCreateDate();
            }
            case 3: {
                return pSHelpArticleCatBase.getCreateMan();
            }
            case 4: {
                return pSHelpArticleCatBase.getMemo();
            }
            case 5: {
                return pSHelpArticleCatBase.getPSDEId();
            }
            case 6: {
                return pSHelpArticleCatBase.getPSDEName();
            }
            case 7: {
                return pSHelpArticleCatBase.getPSHelpArticleCatId();
            }
            case 8: {
                return pSHelpArticleCatBase.getPSHelpArticleCatName();
            }
            case 9: {
                return pSHelpArticleCatBase.getUpdateDate();
            }
            case 10: {
                return pSHelpArticleCatBase.getUpdateMan();
            }
            case 11: {
                return pSHelpArticleCatBase.getUserCat();
            }
            case 12: {
                return pSHelpArticleCatBase.getUserTag();
            }
            case 13: {
                return pSHelpArticleCatBase.getUserTag2();
            }
            case 14: {
                return pSHelpArticleCatBase.getUserTag3();
            }
            case 15: {
                return pSHelpArticleCatBase.getUserTag4();
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
        PSHelpArticleCatBase.set(this, n, object);
    }

    private static void set(PSHelpArticleCatBase pSHelpArticleCatBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSHelpArticleCatBase.setArticleType(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSHelpArticleCatBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSHelpArticleCatBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSHelpArticleCatBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSHelpArticleCatBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSHelpArticleCatBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSHelpArticleCatBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSHelpArticleCatBase.setPSHelpArticleCatId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSHelpArticleCatBase.setPSHelpArticleCatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSHelpArticleCatBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSHelpArticleCatBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSHelpArticleCatBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSHelpArticleCatBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSHelpArticleCatBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSHelpArticleCatBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSHelpArticleCatBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSHelpArticleCatBase.isNull(this, n);
    }

    private static boolean isNull(PSHelpArticleCatBase pSHelpArticleCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSHelpArticleCatBase.getArticleType() == null;
            }
            case 1: {
                return pSHelpArticleCatBase.getCodeName() == null;
            }
            case 2: {
                return pSHelpArticleCatBase.getCreateDate() == null;
            }
            case 3: {
                return pSHelpArticleCatBase.getCreateMan() == null;
            }
            case 4: {
                return pSHelpArticleCatBase.getMemo() == null;
            }
            case 5: {
                return pSHelpArticleCatBase.getPSDEId() == null;
            }
            case 6: {
                return pSHelpArticleCatBase.getPSDEName() == null;
            }
            case 7: {
                return pSHelpArticleCatBase.getPSHelpArticleCatId() == null;
            }
            case 8: {
                return pSHelpArticleCatBase.getPSHelpArticleCatName() == null;
            }
            case 9: {
                return pSHelpArticleCatBase.getUpdateDate() == null;
            }
            case 10: {
                return pSHelpArticleCatBase.getUpdateMan() == null;
            }
            case 11: {
                return pSHelpArticleCatBase.getUserCat() == null;
            }
            case 12: {
                return pSHelpArticleCatBase.getUserTag() == null;
            }
            case 13: {
                return pSHelpArticleCatBase.getUserTag2() == null;
            }
            case 14: {
                return pSHelpArticleCatBase.getUserTag3() == null;
            }
            case 15: {
                return pSHelpArticleCatBase.getUserTag4() == null;
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
        return PSHelpArticleCatBase.contains(this, n);
    }

    private static boolean contains(PSHelpArticleCatBase pSHelpArticleCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSHelpArticleCatBase.isArticleTypeDirty();
            }
            case 1: {
                return pSHelpArticleCatBase.isCodeNameDirty();
            }
            case 2: {
                return pSHelpArticleCatBase.isCreateDateDirty();
            }
            case 3: {
                return pSHelpArticleCatBase.isCreateManDirty();
            }
            case 4: {
                return pSHelpArticleCatBase.isMemoDirty();
            }
            case 5: {
                return pSHelpArticleCatBase.isPSDEIdDirty();
            }
            case 6: {
                return pSHelpArticleCatBase.isPSDENameDirty();
            }
            case 7: {
                return pSHelpArticleCatBase.isPSHelpArticleCatIdDirty();
            }
            case 8: {
                return pSHelpArticleCatBase.isPSHelpArticleCatNameDirty();
            }
            case 9: {
                return pSHelpArticleCatBase.isUpdateDateDirty();
            }
            case 10: {
                return pSHelpArticleCatBase.isUpdateManDirty();
            }
            case 11: {
                return pSHelpArticleCatBase.isUserCatDirty();
            }
            case 12: {
                return pSHelpArticleCatBase.isUserTagDirty();
            }
            case 13: {
                return pSHelpArticleCatBase.isUserTag2Dirty();
            }
            case 14: {
                return pSHelpArticleCatBase.isUserTag3Dirty();
            }
            case 15: {
                return pSHelpArticleCatBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSHelpArticleCatBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSHelpArticleCatBase pSHelpArticleCatBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSHelpArticleCatBase.getArticleType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"articletype", (Object)PSHelpArticleCatBase.getJSONValue((Object)pSHelpArticleCatBase.getArticleType()), (boolean)false);
        }
        if (bl || pSHelpArticleCatBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSHelpArticleCatBase.getJSONValue((Object)pSHelpArticleCatBase.getCodeName()), (boolean)false);
        }
        if (bl || pSHelpArticleCatBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSHelpArticleCatBase.getJSONValue((Object)pSHelpArticleCatBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSHelpArticleCatBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSHelpArticleCatBase.getJSONValue((Object)pSHelpArticleCatBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSHelpArticleCatBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSHelpArticleCatBase.getJSONValue((Object)pSHelpArticleCatBase.getMemo()), (boolean)false);
        }
        if (bl || pSHelpArticleCatBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSHelpArticleCatBase.getJSONValue((Object)pSHelpArticleCatBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSHelpArticleCatBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSHelpArticleCatBase.getJSONValue((Object)pSHelpArticleCatBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSHelpArticleCatBase.getPSHelpArticleCatId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelparticlecatid", (Object)PSHelpArticleCatBase.getJSONValue((Object)pSHelpArticleCatBase.getPSHelpArticleCatId()), (boolean)false);
        }
        if (bl || pSHelpArticleCatBase.getPSHelpArticleCatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelparticlecatname", (Object)PSHelpArticleCatBase.getJSONValue((Object)pSHelpArticleCatBase.getPSHelpArticleCatName()), (boolean)false);
        }
        if (bl || pSHelpArticleCatBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSHelpArticleCatBase.getJSONValue((Object)pSHelpArticleCatBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSHelpArticleCatBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSHelpArticleCatBase.getJSONValue((Object)pSHelpArticleCatBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSHelpArticleCatBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSHelpArticleCatBase.getJSONValue((Object)pSHelpArticleCatBase.getUserCat()), (boolean)false);
        }
        if (bl || pSHelpArticleCatBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSHelpArticleCatBase.getJSONValue((Object)pSHelpArticleCatBase.getUserTag()), (boolean)false);
        }
        if (bl || pSHelpArticleCatBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSHelpArticleCatBase.getJSONValue((Object)pSHelpArticleCatBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSHelpArticleCatBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSHelpArticleCatBase.getJSONValue((Object)pSHelpArticleCatBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSHelpArticleCatBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSHelpArticleCatBase.getJSONValue((Object)pSHelpArticleCatBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSHelpArticleCatBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSHelpArticleCatBase pSHelpArticleCatBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSHelpArticleCatBase.getArticleType() != null) {
            object = pSHelpArticleCatBase.getArticleType();
            xmlNode.setAttribute(FIELD_ARTICLETYPE, (String)(object == null ? "" : object));
        }
        if (bl || pSHelpArticleCatBase.getCodeName() != null) {
            object = pSHelpArticleCatBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleCatBase.getCreateDate() != null) {
            object = pSHelpArticleCatBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSHelpArticleCatBase.getCreateMan() != null) {
            object = pSHelpArticleCatBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleCatBase.getMemo() != null) {
            object = pSHelpArticleCatBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleCatBase.getPSDEId() != null) {
            object = pSHelpArticleCatBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleCatBase.getPSDEName() != null) {
            object = pSHelpArticleCatBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleCatBase.getPSHelpArticleCatId() != null) {
            object = pSHelpArticleCatBase.getPSHelpArticleCatId();
            xmlNode.setAttribute(FIELD_PSHELPARTICLECATID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleCatBase.getPSHelpArticleCatName() != null) {
            object = pSHelpArticleCatBase.getPSHelpArticleCatName();
            xmlNode.setAttribute(FIELD_PSHELPARTICLECATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleCatBase.getUpdateDate() != null) {
            object = pSHelpArticleCatBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSHelpArticleCatBase.getUpdateMan() != null) {
            object = pSHelpArticleCatBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleCatBase.getUserCat() != null) {
            object = pSHelpArticleCatBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleCatBase.getUserTag() != null) {
            object = pSHelpArticleCatBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleCatBase.getUserTag2() != null) {
            object = pSHelpArticleCatBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleCatBase.getUserTag3() != null) {
            object = pSHelpArticleCatBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleCatBase.getUserTag4() != null) {
            object = pSHelpArticleCatBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSHelpArticleCatBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSHelpArticleCatBase pSHelpArticleCatBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSHelpArticleCatBase.isArticleTypeDirty() && (bl || pSHelpArticleCatBase.getArticleType() != null)) {
            iDataObject.set(FIELD_ARTICLETYPE, (Object)pSHelpArticleCatBase.getArticleType());
        }
        if (pSHelpArticleCatBase.isCodeNameDirty() && (bl || pSHelpArticleCatBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSHelpArticleCatBase.getCodeName());
        }
        if (pSHelpArticleCatBase.isCreateDateDirty() && (bl || pSHelpArticleCatBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSHelpArticleCatBase.getCreateDate());
        }
        if (pSHelpArticleCatBase.isCreateManDirty() && (bl || pSHelpArticleCatBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSHelpArticleCatBase.getCreateMan());
        }
        if (pSHelpArticleCatBase.isMemoDirty() && (bl || pSHelpArticleCatBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSHelpArticleCatBase.getMemo());
        }
        if (pSHelpArticleCatBase.isPSDEIdDirty() && (bl || pSHelpArticleCatBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSHelpArticleCatBase.getPSDEId());
        }
        if (pSHelpArticleCatBase.isPSDENameDirty() && (bl || pSHelpArticleCatBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSHelpArticleCatBase.getPSDEName());
        }
        if (pSHelpArticleCatBase.isPSHelpArticleCatIdDirty() && (bl || pSHelpArticleCatBase.getPSHelpArticleCatId() != null)) {
            iDataObject.set(FIELD_PSHELPARTICLECATID, (Object)pSHelpArticleCatBase.getPSHelpArticleCatId());
        }
        if (pSHelpArticleCatBase.isPSHelpArticleCatNameDirty() && (bl || pSHelpArticleCatBase.getPSHelpArticleCatName() != null)) {
            iDataObject.set(FIELD_PSHELPARTICLECATNAME, (Object)pSHelpArticleCatBase.getPSHelpArticleCatName());
        }
        if (pSHelpArticleCatBase.isUpdateDateDirty() && (bl || pSHelpArticleCatBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSHelpArticleCatBase.getUpdateDate());
        }
        if (pSHelpArticleCatBase.isUpdateManDirty() && (bl || pSHelpArticleCatBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSHelpArticleCatBase.getUpdateMan());
        }
        if (pSHelpArticleCatBase.isUserCatDirty() && (bl || pSHelpArticleCatBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSHelpArticleCatBase.getUserCat());
        }
        if (pSHelpArticleCatBase.isUserTagDirty() && (bl || pSHelpArticleCatBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSHelpArticleCatBase.getUserTag());
        }
        if (pSHelpArticleCatBase.isUserTag2Dirty() && (bl || pSHelpArticleCatBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSHelpArticleCatBase.getUserTag2());
        }
        if (pSHelpArticleCatBase.isUserTag3Dirty() && (bl || pSHelpArticleCatBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSHelpArticleCatBase.getUserTag3());
        }
        if (pSHelpArticleCatBase.isUserTag4Dirty() && (bl || pSHelpArticleCatBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSHelpArticleCatBase.getUserTag4());
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
        return PSHelpArticleCatBase.remove(this, n);
    }

    private static boolean remove(PSHelpArticleCatBase pSHelpArticleCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSHelpArticleCatBase.resetArticleType();
                return true;
            }
            case 1: {
                pSHelpArticleCatBase.resetCodeName();
                return true;
            }
            case 2: {
                pSHelpArticleCatBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSHelpArticleCatBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSHelpArticleCatBase.resetMemo();
                return true;
            }
            case 5: {
                pSHelpArticleCatBase.resetPSDEId();
                return true;
            }
            case 6: {
                pSHelpArticleCatBase.resetPSDEName();
                return true;
            }
            case 7: {
                pSHelpArticleCatBase.resetPSHelpArticleCatId();
                return true;
            }
            case 8: {
                pSHelpArticleCatBase.resetPSHelpArticleCatName();
                return true;
            }
            case 9: {
                pSHelpArticleCatBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSHelpArticleCatBase.resetUpdateMan();
                return true;
            }
            case 11: {
                pSHelpArticleCatBase.resetUserCat();
                return true;
            }
            case 12: {
                pSHelpArticleCatBase.resetUserTag();
                return true;
            }
            case 13: {
                pSHelpArticleCatBase.resetUserTag2();
                return true;
            }
            case 14: {
                pSHelpArticleCatBase.resetUserTag3();
                return true;
            }
            case 15: {
                pSHelpArticleCatBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDE();
        }
        if (this.getPSDEId() == null) {
            return null;
        }
        Integer n = this.objPSDELock;
        synchronized (n) {
            if (this.psde != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEId(), (Object)this.psde.getPSDataEntityId()) != 0L) {
                this.psde = null;
            }
            if (this.psde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    private PSHelpArticleCatBase getProxyEntity() {
        return this.proxyPSHelpArticleCatBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSHelpArticleCatBase = null;
        if (iDataObject != null && iDataObject instanceof PSHelpArticleCatBase) {
            this.proxyPSHelpArticleCatBase = (PSHelpArticleCatBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.helpdesign.service.PSHelpArticleCatService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ARTICLETYPE, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSDEID, 5);
        fieldIndexMap.put(FIELD_PSDENAME, 6);
        fieldIndexMap.put(FIELD_PSHELPARTICLECATID, 7);
        fieldIndexMap.put(FIELD_PSHELPARTICLECATNAME, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
        fieldIndexMap.put(FIELD_USERCAT, 11);
        fieldIndexMap.put(FIELD_USERTAG, 12);
        fieldIndexMap.put(FIELD_USERTAG2, 13);
        fieldIndexMap.put(FIELD_USERTAG3, 14);
        fieldIndexMap.put(FIELD_USERTAG4, 15);
    }
}

