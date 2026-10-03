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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysReqItemHisBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysReqItemHisBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ITEMTAG = "ITEMTAG";
    public static final String FIELD_ITEMTAG2 = "ITEMTAG2";
    public static final String FIELD_PSSYSREQITEMHISID = "PSSYSREQITEMHISID";
    public static final String FIELD_PSSYSREQITEMHISNAME = "PSSYSREQITEMHISNAME";
    public static final String FIELD_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String FIELD_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String FIELD_REQCONTENT = "REQCONTENT";
    public static final String FIELD_TAGS = "TAGS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VER = "VER";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ITEMTAG = 2;
    private static final int INDEX_ITEMTAG2 = 3;
    private static final int INDEX_PSSYSREQITEMHISID = 4;
    private static final int INDEX_PSSYSREQITEMHISNAME = 5;
    private static final int INDEX_PSSYSREQITEMID = 6;
    private static final int INDEX_PSSYSREQITEMNAME = 7;
    private static final int INDEX_REQCONTENT = 8;
    private static final int INDEX_TAGS = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_USERCAT = 12;
    private static final int INDEX_USERTAG = 13;
    private static final int INDEX_USERTAG2 = 14;
    private static final int INDEX_USERTAG3 = 15;
    private static final int INDEX_USERTAG4 = 16;
    private static final int INDEX_VER = 17;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysReqItemHisBase proxyPSSysReqItemHisBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean itemtagDirtyFlag = false;
    private boolean itemtag2DirtyFlag = false;
    private boolean pssysreqitemhisidDirtyFlag = false;
    private boolean pssysreqitemhisnameDirtyFlag = false;
    private boolean pssysreqitemidDirtyFlag = false;
    private boolean pssysreqitemnameDirtyFlag = false;
    private boolean reqcontentDirtyFlag = false;
    private boolean tagsDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean verDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="itemtag")
    private String itemtag;
    @Column(name="itemtag2")
    private String itemtag2;
    @Column(name="pssysreqitemhisid")
    private String pssysreqitemhisid;
    @Column(name="pssysreqitemhisname")
    private String pssysreqitemhisname;
    @Column(name="pssysreqitemid")
    private String pssysreqitemid;
    @Column(name="pssysreqitemname")
    private String pssysreqitemname;
    @Column(name="reqcontent")
    private String reqcontent;
    @Column(name="tags")
    private String tags;
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
    @Column(name="ver")
    private Integer ver;
    private Integer objPSSysReqItemLock = new Integer(1);
    private PSSysReqItem pssysreqitem = null;

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

    public void setItemTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemtag = string;
        this.itemtagDirtyFlag = true;
    }

    public String getItemTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemTag();
        }
        return this.itemtag;
    }

    public boolean isItemTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemTagDirty();
        }
        return this.itemtagDirtyFlag;
    }

    public void resetItemTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemTag();
            return;
        }
        this.itemtagDirtyFlag = false;
        this.itemtag = null;
    }

    public void setItemTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemtag2 = string;
        this.itemtag2DirtyFlag = true;
    }

    public String getItemTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemTag2();
        }
        return this.itemtag2;
    }

    public boolean isItemTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemTag2Dirty();
        }
        return this.itemtag2DirtyFlag;
    }

    public void resetItemTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemTag2();
            return;
        }
        this.itemtag2DirtyFlag = false;
        this.itemtag2 = null;
    }

    public void setPSSysReqItemHisId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemHisId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqitemhisid = string;
        this.pssysreqitemhisidDirtyFlag = true;
    }

    public String getPSSysReqItemHisId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemHisId();
        }
        return this.pssysreqitemhisid;
    }

    public boolean isPSSysReqItemHisIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemHisIdDirty();
        }
        return this.pssysreqitemhisidDirtyFlag;
    }

    public void resetPSSysReqItemHisId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemHisId();
            return;
        }
        this.pssysreqitemhisidDirtyFlag = false;
        this.pssysreqitemhisid = null;
    }

    public void setPSSysReqItemHisName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemHisName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqitemhisname = string;
        this.pssysreqitemhisnameDirtyFlag = true;
    }

    public String getPSSysReqItemHisName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemHisName();
        }
        return this.pssysreqitemhisname;
    }

    public boolean isPSSysReqItemHisNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemHisNameDirty();
        }
        return this.pssysreqitemhisnameDirtyFlag;
    }

    public void resetPSSysReqItemHisName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemHisName();
            return;
        }
        this.pssysreqitemhisnameDirtyFlag = false;
        this.pssysreqitemhisname = null;
    }

    public void setPSSysReqItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqitemid = string;
        this.pssysreqitemidDirtyFlag = true;
    }

    public String getPSSysReqItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemId();
        }
        return this.pssysreqitemid;
    }

    public boolean isPSSysReqItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemIdDirty();
        }
        return this.pssysreqitemidDirtyFlag;
    }

    public void resetPSSysReqItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemId();
            return;
        }
        this.pssysreqitemidDirtyFlag = false;
        this.pssysreqitemid = null;
    }

    public void setPSSysReqItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqitemname = string;
        this.pssysreqitemnameDirtyFlag = true;
    }

    public String getPSSysReqItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemName();
        }
        return this.pssysreqitemname;
    }

    public boolean isPSSysReqItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemNameDirty();
        }
        return this.pssysreqitemnameDirtyFlag;
    }

    public void resetPSSysReqItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemName();
            return;
        }
        this.pssysreqitemnameDirtyFlag = false;
        this.pssysreqitemname = null;
    }

    public void setReqContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReqContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.reqcontent = string;
        this.reqcontentDirtyFlag = true;
    }

    public String getReqContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReqContent();
        }
        return this.reqcontent;
    }

    public boolean isReqContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReqContentDirty();
        }
        return this.reqcontentDirtyFlag;
    }

    public void resetReqContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReqContent();
            return;
        }
        this.reqcontentDirtyFlag = false;
        this.reqcontent = null;
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

    public void setVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVer(n);
            return;
        }
        this.ver = n;
        this.verDirtyFlag = true;
    }

    public Integer getVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVer();
        }
        return this.ver;
    }

    public boolean isVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVerDirty();
        }
        return this.verDirtyFlag;
    }

    public void resetVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVer();
            return;
        }
        this.verDirtyFlag = false;
        this.ver = null;
    }

    protected void onReset() {
        PSSysReqItemHisBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysReqItemHisBase pSSysReqItemHisBase) {
        pSSysReqItemHisBase.resetCreateDate();
        pSSysReqItemHisBase.resetCreateMan();
        pSSysReqItemHisBase.resetItemTag();
        pSSysReqItemHisBase.resetItemTag2();
        pSSysReqItemHisBase.resetPSSysReqItemHisId();
        pSSysReqItemHisBase.resetPSSysReqItemHisName();
        pSSysReqItemHisBase.resetPSSysReqItemId();
        pSSysReqItemHisBase.resetPSSysReqItemName();
        pSSysReqItemHisBase.resetReqContent();
        pSSysReqItemHisBase.resetTags();
        pSSysReqItemHisBase.resetUpdateDate();
        pSSysReqItemHisBase.resetUpdateMan();
        pSSysReqItemHisBase.resetUserCat();
        pSSysReqItemHisBase.resetUserTag();
        pSSysReqItemHisBase.resetUserTag2();
        pSSysReqItemHisBase.resetUserTag3();
        pSSysReqItemHisBase.resetUserTag4();
        pSSysReqItemHisBase.resetVer();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isItemTagDirty()) {
            hashMap.put(FIELD_ITEMTAG, this.getItemTag());
        }
        if (!bl || this.isItemTag2Dirty()) {
            hashMap.put(FIELD_ITEMTAG2, this.getItemTag2());
        }
        if (!bl || this.isPSSysReqItemHisIdDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMHISID, this.getPSSysReqItemHisId());
        }
        if (!bl || this.isPSSysReqItemHisNameDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMHISNAME, this.getPSSysReqItemHisName());
        }
        if (!bl || this.isPSSysReqItemIdDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMID, this.getPSSysReqItemId());
        }
        if (!bl || this.isPSSysReqItemNameDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMNAME, this.getPSSysReqItemName());
        }
        if (!bl || this.isReqContentDirty()) {
            hashMap.put(FIELD_REQCONTENT, this.getReqContent());
        }
        if (!bl || this.isTagsDirty()) {
            hashMap.put(FIELD_TAGS, this.getTags());
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
        if (!bl || this.isVerDirty()) {
            hashMap.put(FIELD_VER, this.getVer());
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
        return PSSysReqItemHisBase.get(this, n);
    }

    private static Object get(PSSysReqItemHisBase pSSysReqItemHisBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysReqItemHisBase.getCreateDate();
            }
            case 1: {
                return pSSysReqItemHisBase.getCreateMan();
            }
            case 2: {
                return pSSysReqItemHisBase.getItemTag();
            }
            case 3: {
                return pSSysReqItemHisBase.getItemTag2();
            }
            case 4: {
                return pSSysReqItemHisBase.getPSSysReqItemHisId();
            }
            case 5: {
                return pSSysReqItemHisBase.getPSSysReqItemHisName();
            }
            case 6: {
                return pSSysReqItemHisBase.getPSSysReqItemId();
            }
            case 7: {
                return pSSysReqItemHisBase.getPSSysReqItemName();
            }
            case 8: {
                return pSSysReqItemHisBase.getReqContent();
            }
            case 9: {
                return pSSysReqItemHisBase.getTags();
            }
            case 10: {
                return pSSysReqItemHisBase.getUpdateDate();
            }
            case 11: {
                return pSSysReqItemHisBase.getUpdateMan();
            }
            case 12: {
                return pSSysReqItemHisBase.getUserCat();
            }
            case 13: {
                return pSSysReqItemHisBase.getUserTag();
            }
            case 14: {
                return pSSysReqItemHisBase.getUserTag2();
            }
            case 15: {
                return pSSysReqItemHisBase.getUserTag3();
            }
            case 16: {
                return pSSysReqItemHisBase.getUserTag4();
            }
            case 17: {
                return pSSysReqItemHisBase.getVer();
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
        PSSysReqItemHisBase.set(this, n, object);
    }

    private static void set(PSSysReqItemHisBase pSSysReqItemHisBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysReqItemHisBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysReqItemHisBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysReqItemHisBase.setItemTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysReqItemHisBase.setItemTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysReqItemHisBase.setPSSysReqItemHisId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysReqItemHisBase.setPSSysReqItemHisName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysReqItemHisBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysReqItemHisBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysReqItemHisBase.setReqContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysReqItemHisBase.setTags(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysReqItemHisBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSSysReqItemHisBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysReqItemHisBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysReqItemHisBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysReqItemHisBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysReqItemHisBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysReqItemHisBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysReqItemHisBase.setVer(DataObject.getIntegerValue((Object)object));
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
        return PSSysReqItemHisBase.isNull(this, n);
    }

    private static boolean isNull(PSSysReqItemHisBase pSSysReqItemHisBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysReqItemHisBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysReqItemHisBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysReqItemHisBase.getItemTag() == null;
            }
            case 3: {
                return pSSysReqItemHisBase.getItemTag2() == null;
            }
            case 4: {
                return pSSysReqItemHisBase.getPSSysReqItemHisId() == null;
            }
            case 5: {
                return pSSysReqItemHisBase.getPSSysReqItemHisName() == null;
            }
            case 6: {
                return pSSysReqItemHisBase.getPSSysReqItemId() == null;
            }
            case 7: {
                return pSSysReqItemHisBase.getPSSysReqItemName() == null;
            }
            case 8: {
                return pSSysReqItemHisBase.getReqContent() == null;
            }
            case 9: {
                return pSSysReqItemHisBase.getTags() == null;
            }
            case 10: {
                return pSSysReqItemHisBase.getUpdateDate() == null;
            }
            case 11: {
                return pSSysReqItemHisBase.getUpdateMan() == null;
            }
            case 12: {
                return pSSysReqItemHisBase.getUserCat() == null;
            }
            case 13: {
                return pSSysReqItemHisBase.getUserTag() == null;
            }
            case 14: {
                return pSSysReqItemHisBase.getUserTag2() == null;
            }
            case 15: {
                return pSSysReqItemHisBase.getUserTag3() == null;
            }
            case 16: {
                return pSSysReqItemHisBase.getUserTag4() == null;
            }
            case 17: {
                return pSSysReqItemHisBase.getVer() == null;
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
        return PSSysReqItemHisBase.contains(this, n);
    }

    private static boolean contains(PSSysReqItemHisBase pSSysReqItemHisBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysReqItemHisBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysReqItemHisBase.isCreateManDirty();
            }
            case 2: {
                return pSSysReqItemHisBase.isItemTagDirty();
            }
            case 3: {
                return pSSysReqItemHisBase.isItemTag2Dirty();
            }
            case 4: {
                return pSSysReqItemHisBase.isPSSysReqItemHisIdDirty();
            }
            case 5: {
                return pSSysReqItemHisBase.isPSSysReqItemHisNameDirty();
            }
            case 6: {
                return pSSysReqItemHisBase.isPSSysReqItemIdDirty();
            }
            case 7: {
                return pSSysReqItemHisBase.isPSSysReqItemNameDirty();
            }
            case 8: {
                return pSSysReqItemHisBase.isReqContentDirty();
            }
            case 9: {
                return pSSysReqItemHisBase.isTagsDirty();
            }
            case 10: {
                return pSSysReqItemHisBase.isUpdateDateDirty();
            }
            case 11: {
                return pSSysReqItemHisBase.isUpdateManDirty();
            }
            case 12: {
                return pSSysReqItemHisBase.isUserCatDirty();
            }
            case 13: {
                return pSSysReqItemHisBase.isUserTagDirty();
            }
            case 14: {
                return pSSysReqItemHisBase.isUserTag2Dirty();
            }
            case 15: {
                return pSSysReqItemHisBase.isUserTag3Dirty();
            }
            case 16: {
                return pSSysReqItemHisBase.isUserTag4Dirty();
            }
            case 17: {
                return pSSysReqItemHisBase.isVerDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysReqItemHisBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysReqItemHisBase pSSysReqItemHisBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysReqItemHisBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysReqItemHisBase.getJSONValue((Object)pSSysReqItemHisBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysReqItemHisBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysReqItemHisBase.getJSONValue((Object)pSSysReqItemHisBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysReqItemHisBase.getItemTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemtag", (Object)PSSysReqItemHisBase.getJSONValue((Object)pSSysReqItemHisBase.getItemTag()), (boolean)false);
        }
        if (bl || pSSysReqItemHisBase.getItemTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemtag2", (Object)PSSysReqItemHisBase.getJSONValue((Object)pSSysReqItemHisBase.getItemTag2()), (boolean)false);
        }
        if (bl || pSSysReqItemHisBase.getPSSysReqItemHisId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemhisid", (Object)PSSysReqItemHisBase.getJSONValue((Object)pSSysReqItemHisBase.getPSSysReqItemHisId()), (boolean)false);
        }
        if (bl || pSSysReqItemHisBase.getPSSysReqItemHisName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemhisname", (Object)PSSysReqItemHisBase.getJSONValue((Object)pSSysReqItemHisBase.getPSSysReqItemHisName()), (boolean)false);
        }
        if (bl || pSSysReqItemHisBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSSysReqItemHisBase.getJSONValue((Object)pSSysReqItemHisBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSSysReqItemHisBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSSysReqItemHisBase.getJSONValue((Object)pSSysReqItemHisBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSSysReqItemHisBase.getReqContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reqcontent", (Object)PSSysReqItemHisBase.getJSONValue((Object)pSSysReqItemHisBase.getReqContent()), (boolean)false);
        }
        if (bl || pSSysReqItemHisBase.getTags() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tags", (Object)PSSysReqItemHisBase.getJSONValue((Object)pSSysReqItemHisBase.getTags()), (boolean)false);
        }
        if (bl || pSSysReqItemHisBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysReqItemHisBase.getJSONValue((Object)pSSysReqItemHisBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysReqItemHisBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysReqItemHisBase.getJSONValue((Object)pSSysReqItemHisBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysReqItemHisBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysReqItemHisBase.getJSONValue((Object)pSSysReqItemHisBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysReqItemHisBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysReqItemHisBase.getJSONValue((Object)pSSysReqItemHisBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysReqItemHisBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysReqItemHisBase.getJSONValue((Object)pSSysReqItemHisBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysReqItemHisBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysReqItemHisBase.getJSONValue((Object)pSSysReqItemHisBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysReqItemHisBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysReqItemHisBase.getJSONValue((Object)pSSysReqItemHisBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysReqItemHisBase.getVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ver", (Object)PSSysReqItemHisBase.getJSONValue((Object)pSSysReqItemHisBase.getVer()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysReqItemHisBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysReqItemHisBase pSSysReqItemHisBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysReqItemHisBase.getCreateDate() != null) {
            object = pSSysReqItemHisBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysReqItemHisBase.getCreateMan() != null) {
            object = pSSysReqItemHisBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemHisBase.getItemTag() != null) {
            object = pSSysReqItemHisBase.getItemTag();
            xmlNode.setAttribute(FIELD_ITEMTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemHisBase.getItemTag2() != null) {
            object = pSSysReqItemHisBase.getItemTag2();
            xmlNode.setAttribute(FIELD_ITEMTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemHisBase.getPSSysReqItemHisId() != null) {
            object = pSSysReqItemHisBase.getPSSysReqItemHisId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMHISID, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemHisBase.getPSSysReqItemHisName() != null) {
            object = pSSysReqItemHisBase.getPSSysReqItemHisName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMHISNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemHisBase.getPSSysReqItemId() != null) {
            object = pSSysReqItemHisBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemHisBase.getPSSysReqItemName() != null) {
            object = pSSysReqItemHisBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemHisBase.getReqContent() != null) {
            object = pSSysReqItemHisBase.getReqContent();
            xmlNode.setAttribute(FIELD_REQCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemHisBase.getTags() != null) {
            object = pSSysReqItemHisBase.getTags();
            xmlNode.setAttribute(FIELD_TAGS, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemHisBase.getUpdateDate() != null) {
            object = pSSysReqItemHisBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysReqItemHisBase.getUpdateMan() != null) {
            object = pSSysReqItemHisBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemHisBase.getUserCat() != null) {
            object = pSSysReqItemHisBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemHisBase.getUserTag() != null) {
            object = pSSysReqItemHisBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemHisBase.getUserTag2() != null) {
            object = pSSysReqItemHisBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemHisBase.getUserTag3() != null) {
            object = pSSysReqItemHisBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemHisBase.getUserTag4() != null) {
            object = pSSysReqItemHisBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemHisBase.getVer() != null) {
            object = pSSysReqItemHisBase.getVer();
            xmlNode.setAttribute(FIELD_VER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysReqItemHisBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysReqItemHisBase pSSysReqItemHisBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysReqItemHisBase.isCreateDateDirty() && (bl || pSSysReqItemHisBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysReqItemHisBase.getCreateDate());
        }
        if (pSSysReqItemHisBase.isCreateManDirty() && (bl || pSSysReqItemHisBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysReqItemHisBase.getCreateMan());
        }
        if (pSSysReqItemHisBase.isItemTagDirty() && (bl || pSSysReqItemHisBase.getItemTag() != null)) {
            iDataObject.set(FIELD_ITEMTAG, (Object)pSSysReqItemHisBase.getItemTag());
        }
        if (pSSysReqItemHisBase.isItemTag2Dirty() && (bl || pSSysReqItemHisBase.getItemTag2() != null)) {
            iDataObject.set(FIELD_ITEMTAG2, (Object)pSSysReqItemHisBase.getItemTag2());
        }
        if (pSSysReqItemHisBase.isPSSysReqItemHisIdDirty() && (bl || pSSysReqItemHisBase.getPSSysReqItemHisId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMHISID, (Object)pSSysReqItemHisBase.getPSSysReqItemHisId());
        }
        if (pSSysReqItemHisBase.isPSSysReqItemHisNameDirty() && (bl || pSSysReqItemHisBase.getPSSysReqItemHisName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMHISNAME, (Object)pSSysReqItemHisBase.getPSSysReqItemHisName());
        }
        if (pSSysReqItemHisBase.isPSSysReqItemIdDirty() && (bl || pSSysReqItemHisBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSSysReqItemHisBase.getPSSysReqItemId());
        }
        if (pSSysReqItemHisBase.isPSSysReqItemNameDirty() && (bl || pSSysReqItemHisBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSSysReqItemHisBase.getPSSysReqItemName());
        }
        if (pSSysReqItemHisBase.isReqContentDirty() && (bl || pSSysReqItemHisBase.getReqContent() != null)) {
            iDataObject.set(FIELD_REQCONTENT, (Object)pSSysReqItemHisBase.getReqContent());
        }
        if (pSSysReqItemHisBase.isTagsDirty() && (bl || pSSysReqItemHisBase.getTags() != null)) {
            iDataObject.set(FIELD_TAGS, (Object)pSSysReqItemHisBase.getTags());
        }
        if (pSSysReqItemHisBase.isUpdateDateDirty() && (bl || pSSysReqItemHisBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysReqItemHisBase.getUpdateDate());
        }
        if (pSSysReqItemHisBase.isUpdateManDirty() && (bl || pSSysReqItemHisBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysReqItemHisBase.getUpdateMan());
        }
        if (pSSysReqItemHisBase.isUserCatDirty() && (bl || pSSysReqItemHisBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysReqItemHisBase.getUserCat());
        }
        if (pSSysReqItemHisBase.isUserTagDirty() && (bl || pSSysReqItemHisBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysReqItemHisBase.getUserTag());
        }
        if (pSSysReqItemHisBase.isUserTag2Dirty() && (bl || pSSysReqItemHisBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysReqItemHisBase.getUserTag2());
        }
        if (pSSysReqItemHisBase.isUserTag3Dirty() && (bl || pSSysReqItemHisBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysReqItemHisBase.getUserTag3());
        }
        if (pSSysReqItemHisBase.isUserTag4Dirty() && (bl || pSSysReqItemHisBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysReqItemHisBase.getUserTag4());
        }
        if (pSSysReqItemHisBase.isVerDirty() && (bl || pSSysReqItemHisBase.getVer() != null)) {
            iDataObject.set(FIELD_VER, (Object)pSSysReqItemHisBase.getVer());
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
        return PSSysReqItemHisBase.remove(this, n);
    }

    private static boolean remove(PSSysReqItemHisBase pSSysReqItemHisBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysReqItemHisBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysReqItemHisBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysReqItemHisBase.resetItemTag();
                return true;
            }
            case 3: {
                pSSysReqItemHisBase.resetItemTag2();
                return true;
            }
            case 4: {
                pSSysReqItemHisBase.resetPSSysReqItemHisId();
                return true;
            }
            case 5: {
                pSSysReqItemHisBase.resetPSSysReqItemHisName();
                return true;
            }
            case 6: {
                pSSysReqItemHisBase.resetPSSysReqItemId();
                return true;
            }
            case 7: {
                pSSysReqItemHisBase.resetPSSysReqItemName();
                return true;
            }
            case 8: {
                pSSysReqItemHisBase.resetReqContent();
                return true;
            }
            case 9: {
                pSSysReqItemHisBase.resetTags();
                return true;
            }
            case 10: {
                pSSysReqItemHisBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSSysReqItemHisBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSSysReqItemHisBase.resetUserCat();
                return true;
            }
            case 13: {
                pSSysReqItemHisBase.resetUserTag();
                return true;
            }
            case 14: {
                pSSysReqItemHisBase.resetUserTag2();
                return true;
            }
            case 15: {
                pSSysReqItemHisBase.resetUserTag3();
                return true;
            }
            case 16: {
                pSSysReqItemHisBase.resetUserTag4();
                return true;
            }
            case 17: {
                pSSysReqItemHisBase.resetVer();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysReqItem getPSSysReqItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItem();
        }
        if (this.getPSSysReqItemId() == null) {
            return null;
        }
        Integer n = this.objPSSysReqItemLock;
        synchronized (n) {
            if (this.pssysreqitem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysReqItemId(), (Object)this.pssysreqitem.getPSSysReqItemId()) != 0L) {
                this.pssysreqitem = null;
            }
            if (this.pssysreqitem == null) {
                PSSysReqItem pSSysReqItem = new PSSysReqItem();
                pSSysReqItem.setPSSysReqItemId(this.getPSSysReqItemId());
                PSSysReqItemService pSSysReqItemService = (PSSysReqItemService)ServiceGlobal.getService(PSSysReqItemService.class, (SessionFactory)this.getSessionFactory());
                pSSysReqItemService.autoGet(pSSysReqItem);
                this.pssysreqitem = pSSysReqItem;
            }
            return this.pssysreqitem;
        }
    }

    private PSSysReqItemHisBase getProxyEntity() {
        return this.proxyPSSysReqItemHisBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysReqItemHisBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysReqItemHisBase) {
            this.proxyPSSysReqItemHisBase = (PSSysReqItemHisBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemHisService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ITEMTAG, 2);
        fieldIndexMap.put(FIELD_ITEMTAG2, 3);
        fieldIndexMap.put(FIELD_PSSYSREQITEMHISID, 4);
        fieldIndexMap.put(FIELD_PSSYSREQITEMHISNAME, 5);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 6);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 7);
        fieldIndexMap.put(FIELD_REQCONTENT, 8);
        fieldIndexMap.put(FIELD_TAGS, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_USERCAT, 12);
        fieldIndexMap.put(FIELD_USERTAG, 13);
        fieldIndexMap.put(FIELD_USERTAG2, 14);
        fieldIndexMap.put(FIELD_USERTAG3, 15);
        fieldIndexMap.put(FIELD_USERTAG4, 16);
        fieldIndexMap.put(FIELD_VER, 17);
    }
}

