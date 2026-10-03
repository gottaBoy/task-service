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
package net.ibizsys.pscore.srv.wxdesign.entity;

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
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXMenu;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXMenuFunc;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXMenuItem;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXMenuFuncService;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXMenuItemService;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXMenuService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWXMenuItemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWXMenuItemBase.class);
    public static final String FIELD_CAPTION = "CAPTION";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PPSWXMENUITEMID = "PPSWXMENUITEMID";
    public static final String FIELD_PPSWXMENUITEMNAME = "PPSWXMENUITEMNAME";
    public static final String FIELD_PSWXMENUFUNCID = "PSWXMENUFUNCID";
    public static final String FIELD_PSWXMENUFUNCNAME = "PSWXMENUFUNCNAME";
    public static final String FIELD_PSWXMENUID = "PSWXMENUID";
    public static final String FIELD_PSWXMENUITEMID = "PSWXMENUITEMID";
    public static final String FIELD_PSWXMENUITEMNAME = "PSWXMENUITEMNAME";
    public static final String FIELD_PSWXMENUNAME = "PSWXMENUNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CAPTION = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_ORDERVALUE = 4;
    private static final int INDEX_PPSWXMENUITEMID = 5;
    private static final int INDEX_PPSWXMENUITEMNAME = 6;
    private static final int INDEX_PSWXMENUFUNCID = 7;
    private static final int INDEX_PSWXMENUFUNCNAME = 8;
    private static final int INDEX_PSWXMENUID = 9;
    private static final int INDEX_PSWXMENUITEMID = 10;
    private static final int INDEX_PSWXMENUITEMNAME = 11;
    private static final int INDEX_PSWXMENUNAME = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final int INDEX_USERCAT = 15;
    private static final int INDEX_USERTAG = 16;
    private static final int INDEX_USERTAG2 = 17;
    private static final int INDEX_USERTAG3 = 18;
    private static final int INDEX_USERTAG4 = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWXMenuItemBase proxyPSWXMenuItemBase = null;
    private boolean captionDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean ppswxmenuitemidDirtyFlag = false;
    private boolean ppswxmenuitemnameDirtyFlag = false;
    private boolean pswxmenufuncidDirtyFlag = false;
    private boolean pswxmenufuncnameDirtyFlag = false;
    private boolean pswxmenuidDirtyFlag = false;
    private boolean pswxmenuitemidDirtyFlag = false;
    private boolean pswxmenuitemnameDirtyFlag = false;
    private boolean pswxmenunameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="caption")
    private String caption;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="ppswxmenuitemid")
    private String ppswxmenuitemid;
    @Column(name="ppswxmenuitemname")
    private String ppswxmenuitemname;
    @Column(name="pswxmenufuncid")
    private String pswxmenufuncid;
    @Column(name="pswxmenufuncname")
    private String pswxmenufuncname;
    @Column(name="pswxmenuid")
    private String pswxmenuid;
    @Column(name="pswxmenuitemid")
    private String pswxmenuitemid;
    @Column(name="pswxmenuitemname")
    private String pswxmenuitemname;
    @Column(name="pswxmenuname")
    private String pswxmenuname;
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
    private Integer objPSWXMenuFuncLock = new Integer(1);
    private PSWXMenuFunc pswxmenufunc = null;
    private Integer objPPSWXMenuItemLock = new Integer(1);
    private PSWXMenuItem ppswxmenuitem = null;
    private Integer objPSWXMenuLock = new Integer(1);
    private PSWXMenu pswxmenu = null;

    public void setCaption(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCaption(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.caption = string;
        this.captionDirtyFlag = true;
    }

    public String getCaption() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCaption();
        }
        return this.caption;
    }

    public boolean isCaptionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCaptionDirty();
        }
        return this.captionDirtyFlag;
    }

    public void resetCaption() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCaption();
            return;
        }
        this.captionDirtyFlag = false;
        this.caption = null;
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

    public void setPPSWXMenuItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSWXMenuItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppswxmenuitemid = string;
        this.ppswxmenuitemidDirtyFlag = true;
    }

    public String getPPSWXMenuItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSWXMenuItemId();
        }
        return this.ppswxmenuitemid;
    }

    public boolean isPPSWXMenuItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSWXMenuItemIdDirty();
        }
        return this.ppswxmenuitemidDirtyFlag;
    }

    public void resetPPSWXMenuItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSWXMenuItemId();
            return;
        }
        this.ppswxmenuitemidDirtyFlag = false;
        this.ppswxmenuitemid = null;
    }

    public void setPPSWXMenuItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSWXMenuItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppswxmenuitemname = string;
        this.ppswxmenuitemnameDirtyFlag = true;
    }

    public String getPPSWXMenuItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSWXMenuItemName();
        }
        return this.ppswxmenuitemname;
    }

    public boolean isPPSWXMenuItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSWXMenuItemNameDirty();
        }
        return this.ppswxmenuitemnameDirtyFlag;
    }

    public void resetPPSWXMenuItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSWXMenuItemName();
            return;
        }
        this.ppswxmenuitemnameDirtyFlag = false;
        this.ppswxmenuitemname = null;
    }

    public void setPSWXMenuFuncId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWXMenuFuncId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswxmenufuncid = string;
        this.pswxmenufuncidDirtyFlag = true;
    }

    public String getPSWXMenuFuncId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXMenuFuncId();
        }
        return this.pswxmenufuncid;
    }

    public boolean isPSWXMenuFuncIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWXMenuFuncIdDirty();
        }
        return this.pswxmenufuncidDirtyFlag;
    }

    public void resetPSWXMenuFuncId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWXMenuFuncId();
            return;
        }
        this.pswxmenufuncidDirtyFlag = false;
        this.pswxmenufuncid = null;
    }

    public void setPSWXMenuFuncName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWXMenuFuncName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswxmenufuncname = string;
        this.pswxmenufuncnameDirtyFlag = true;
    }

    public String getPSWXMenuFuncName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXMenuFuncName();
        }
        return this.pswxmenufuncname;
    }

    public boolean isPSWXMenuFuncNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWXMenuFuncNameDirty();
        }
        return this.pswxmenufuncnameDirtyFlag;
    }

    public void resetPSWXMenuFuncName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWXMenuFuncName();
            return;
        }
        this.pswxmenufuncnameDirtyFlag = false;
        this.pswxmenufuncname = null;
    }

    public void setPSWXMenuId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWXMenuId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswxmenuid = string;
        this.pswxmenuidDirtyFlag = true;
    }

    public String getPSWXMenuId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXMenuId();
        }
        return this.pswxmenuid;
    }

    public boolean isPSWXMenuIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWXMenuIdDirty();
        }
        return this.pswxmenuidDirtyFlag;
    }

    public void resetPSWXMenuId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWXMenuId();
            return;
        }
        this.pswxmenuidDirtyFlag = false;
        this.pswxmenuid = null;
    }

    public void setPSWXMenuItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWXMenuItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswxmenuitemid = string;
        this.pswxmenuitemidDirtyFlag = true;
    }

    public String getPSWXMenuItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXMenuItemId();
        }
        return this.pswxmenuitemid;
    }

    public boolean isPSWXMenuItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWXMenuItemIdDirty();
        }
        return this.pswxmenuitemidDirtyFlag;
    }

    public void resetPSWXMenuItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWXMenuItemId();
            return;
        }
        this.pswxmenuitemidDirtyFlag = false;
        this.pswxmenuitemid = null;
    }

    public void setPSWXMenuItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWXMenuItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswxmenuitemname = string;
        this.pswxmenuitemnameDirtyFlag = true;
    }

    public String getPSWXMenuItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXMenuItemName();
        }
        return this.pswxmenuitemname;
    }

    public boolean isPSWXMenuItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWXMenuItemNameDirty();
        }
        return this.pswxmenuitemnameDirtyFlag;
    }

    public void resetPSWXMenuItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWXMenuItemName();
            return;
        }
        this.pswxmenuitemnameDirtyFlag = false;
        this.pswxmenuitemname = null;
    }

    public void setPSWXMenuName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWXMenuName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswxmenuname = string;
        this.pswxmenunameDirtyFlag = true;
    }

    public String getPSWXMenuName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXMenuName();
        }
        return this.pswxmenuname;
    }

    public boolean isPSWXMenuNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWXMenuNameDirty();
        }
        return this.pswxmenunameDirtyFlag;
    }

    public void resetPSWXMenuName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWXMenuName();
            return;
        }
        this.pswxmenunameDirtyFlag = false;
        this.pswxmenuname = null;
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
        PSWXMenuItemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWXMenuItemBase pSWXMenuItemBase) {
        pSWXMenuItemBase.resetCaption();
        pSWXMenuItemBase.resetCreateDate();
        pSWXMenuItemBase.resetCreateMan();
        pSWXMenuItemBase.resetMemo();
        pSWXMenuItemBase.resetOrderValue();
        pSWXMenuItemBase.resetPPSWXMenuItemId();
        pSWXMenuItemBase.resetPPSWXMenuItemName();
        pSWXMenuItemBase.resetPSWXMenuFuncId();
        pSWXMenuItemBase.resetPSWXMenuFuncName();
        pSWXMenuItemBase.resetPSWXMenuId();
        pSWXMenuItemBase.resetPSWXMenuItemId();
        pSWXMenuItemBase.resetPSWXMenuItemName();
        pSWXMenuItemBase.resetPSWXMenuName();
        pSWXMenuItemBase.resetUpdateDate();
        pSWXMenuItemBase.resetUpdateMan();
        pSWXMenuItemBase.resetUserCat();
        pSWXMenuItemBase.resetUserTag();
        pSWXMenuItemBase.resetUserTag2();
        pSWXMenuItemBase.resetUserTag3();
        pSWXMenuItemBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCaptionDirty()) {
            hashMap.put(FIELD_CAPTION, this.getCaption());
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
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPPSWXMenuItemIdDirty()) {
            hashMap.put(FIELD_PPSWXMENUITEMID, this.getPPSWXMenuItemId());
        }
        if (!bl || this.isPPSWXMenuItemNameDirty()) {
            hashMap.put(FIELD_PPSWXMENUITEMNAME, this.getPPSWXMenuItemName());
        }
        if (!bl || this.isPSWXMenuFuncIdDirty()) {
            hashMap.put(FIELD_PSWXMENUFUNCID, this.getPSWXMenuFuncId());
        }
        if (!bl || this.isPSWXMenuFuncNameDirty()) {
            hashMap.put(FIELD_PSWXMENUFUNCNAME, this.getPSWXMenuFuncName());
        }
        if (!bl || this.isPSWXMenuIdDirty()) {
            hashMap.put(FIELD_PSWXMENUID, this.getPSWXMenuId());
        }
        if (!bl || this.isPSWXMenuItemIdDirty()) {
            hashMap.put(FIELD_PSWXMENUITEMID, this.getPSWXMenuItemId());
        }
        if (!bl || this.isPSWXMenuItemNameDirty()) {
            hashMap.put(FIELD_PSWXMENUITEMNAME, this.getPSWXMenuItemName());
        }
        if (!bl || this.isPSWXMenuNameDirty()) {
            hashMap.put(FIELD_PSWXMENUNAME, this.getPSWXMenuName());
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
        return PSWXMenuItemBase.get(this, n);
    }

    private static Object get(PSWXMenuItemBase pSWXMenuItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWXMenuItemBase.getCaption();
            }
            case 1: {
                return pSWXMenuItemBase.getCreateDate();
            }
            case 2: {
                return pSWXMenuItemBase.getCreateMan();
            }
            case 3: {
                return pSWXMenuItemBase.getMemo();
            }
            case 4: {
                return pSWXMenuItemBase.getOrderValue();
            }
            case 5: {
                return pSWXMenuItemBase.getPPSWXMenuItemId();
            }
            case 6: {
                return pSWXMenuItemBase.getPPSWXMenuItemName();
            }
            case 7: {
                return pSWXMenuItemBase.getPSWXMenuFuncId();
            }
            case 8: {
                return pSWXMenuItemBase.getPSWXMenuFuncName();
            }
            case 9: {
                return pSWXMenuItemBase.getPSWXMenuId();
            }
            case 10: {
                return pSWXMenuItemBase.getPSWXMenuItemId();
            }
            case 11: {
                return pSWXMenuItemBase.getPSWXMenuItemName();
            }
            case 12: {
                return pSWXMenuItemBase.getPSWXMenuName();
            }
            case 13: {
                return pSWXMenuItemBase.getUpdateDate();
            }
            case 14: {
                return pSWXMenuItemBase.getUpdateMan();
            }
            case 15: {
                return pSWXMenuItemBase.getUserCat();
            }
            case 16: {
                return pSWXMenuItemBase.getUserTag();
            }
            case 17: {
                return pSWXMenuItemBase.getUserTag2();
            }
            case 18: {
                return pSWXMenuItemBase.getUserTag3();
            }
            case 19: {
                return pSWXMenuItemBase.getUserTag4();
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
        PSWXMenuItemBase.set(this, n, object);
    }

    private static void set(PSWXMenuItemBase pSWXMenuItemBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWXMenuItemBase.setCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSWXMenuItemBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSWXMenuItemBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSWXMenuItemBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSWXMenuItemBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSWXMenuItemBase.setPPSWXMenuItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSWXMenuItemBase.setPPSWXMenuItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSWXMenuItemBase.setPSWXMenuFuncId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSWXMenuItemBase.setPSWXMenuFuncName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSWXMenuItemBase.setPSWXMenuId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSWXMenuItemBase.setPSWXMenuItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSWXMenuItemBase.setPSWXMenuItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSWXMenuItemBase.setPSWXMenuName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSWXMenuItemBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSWXMenuItemBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSWXMenuItemBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSWXMenuItemBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSWXMenuItemBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSWXMenuItemBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSWXMenuItemBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSWXMenuItemBase.isNull(this, n);
    }

    private static boolean isNull(PSWXMenuItemBase pSWXMenuItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWXMenuItemBase.getCaption() == null;
            }
            case 1: {
                return pSWXMenuItemBase.getCreateDate() == null;
            }
            case 2: {
                return pSWXMenuItemBase.getCreateMan() == null;
            }
            case 3: {
                return pSWXMenuItemBase.getMemo() == null;
            }
            case 4: {
                return pSWXMenuItemBase.getOrderValue() == null;
            }
            case 5: {
                return pSWXMenuItemBase.getPPSWXMenuItemId() == null;
            }
            case 6: {
                return pSWXMenuItemBase.getPPSWXMenuItemName() == null;
            }
            case 7: {
                return pSWXMenuItemBase.getPSWXMenuFuncId() == null;
            }
            case 8: {
                return pSWXMenuItemBase.getPSWXMenuFuncName() == null;
            }
            case 9: {
                return pSWXMenuItemBase.getPSWXMenuId() == null;
            }
            case 10: {
                return pSWXMenuItemBase.getPSWXMenuItemId() == null;
            }
            case 11: {
                return pSWXMenuItemBase.getPSWXMenuItemName() == null;
            }
            case 12: {
                return pSWXMenuItemBase.getPSWXMenuName() == null;
            }
            case 13: {
                return pSWXMenuItemBase.getUpdateDate() == null;
            }
            case 14: {
                return pSWXMenuItemBase.getUpdateMan() == null;
            }
            case 15: {
                return pSWXMenuItemBase.getUserCat() == null;
            }
            case 16: {
                return pSWXMenuItemBase.getUserTag() == null;
            }
            case 17: {
                return pSWXMenuItemBase.getUserTag2() == null;
            }
            case 18: {
                return pSWXMenuItemBase.getUserTag3() == null;
            }
            case 19: {
                return pSWXMenuItemBase.getUserTag4() == null;
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
        return PSWXMenuItemBase.contains(this, n);
    }

    private static boolean contains(PSWXMenuItemBase pSWXMenuItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWXMenuItemBase.isCaptionDirty();
            }
            case 1: {
                return pSWXMenuItemBase.isCreateDateDirty();
            }
            case 2: {
                return pSWXMenuItemBase.isCreateManDirty();
            }
            case 3: {
                return pSWXMenuItemBase.isMemoDirty();
            }
            case 4: {
                return pSWXMenuItemBase.isOrderValueDirty();
            }
            case 5: {
                return pSWXMenuItemBase.isPPSWXMenuItemIdDirty();
            }
            case 6: {
                return pSWXMenuItemBase.isPPSWXMenuItemNameDirty();
            }
            case 7: {
                return pSWXMenuItemBase.isPSWXMenuFuncIdDirty();
            }
            case 8: {
                return pSWXMenuItemBase.isPSWXMenuFuncNameDirty();
            }
            case 9: {
                return pSWXMenuItemBase.isPSWXMenuIdDirty();
            }
            case 10: {
                return pSWXMenuItemBase.isPSWXMenuItemIdDirty();
            }
            case 11: {
                return pSWXMenuItemBase.isPSWXMenuItemNameDirty();
            }
            case 12: {
                return pSWXMenuItemBase.isPSWXMenuNameDirty();
            }
            case 13: {
                return pSWXMenuItemBase.isUpdateDateDirty();
            }
            case 14: {
                return pSWXMenuItemBase.isUpdateManDirty();
            }
            case 15: {
                return pSWXMenuItemBase.isUserCatDirty();
            }
            case 16: {
                return pSWXMenuItemBase.isUserTagDirty();
            }
            case 17: {
                return pSWXMenuItemBase.isUserTag2Dirty();
            }
            case 18: {
                return pSWXMenuItemBase.isUserTag3Dirty();
            }
            case 19: {
                return pSWXMenuItemBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWXMenuItemBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWXMenuItemBase pSWXMenuItemBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWXMenuItemBase.getCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"caption", (Object)PSWXMenuItemBase.getJSONValue((Object)pSWXMenuItemBase.getCaption()), (boolean)false);
        }
        if (bl || pSWXMenuItemBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWXMenuItemBase.getJSONValue((Object)pSWXMenuItemBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWXMenuItemBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWXMenuItemBase.getJSONValue((Object)pSWXMenuItemBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWXMenuItemBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSWXMenuItemBase.getJSONValue((Object)pSWXMenuItemBase.getMemo()), (boolean)false);
        }
        if (bl || pSWXMenuItemBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSWXMenuItemBase.getJSONValue((Object)pSWXMenuItemBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSWXMenuItemBase.getPPSWXMenuItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppswxmenuitemid", (Object)PSWXMenuItemBase.getJSONValue((Object)pSWXMenuItemBase.getPPSWXMenuItemId()), (boolean)false);
        }
        if (bl || pSWXMenuItemBase.getPPSWXMenuItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppswxmenuitemname", (Object)PSWXMenuItemBase.getJSONValue((Object)pSWXMenuItemBase.getPPSWXMenuItemName()), (boolean)false);
        }
        if (bl || pSWXMenuItemBase.getPSWXMenuFuncId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxmenufuncid", (Object)PSWXMenuItemBase.getJSONValue((Object)pSWXMenuItemBase.getPSWXMenuFuncId()), (boolean)false);
        }
        if (bl || pSWXMenuItemBase.getPSWXMenuFuncName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxmenufuncname", (Object)PSWXMenuItemBase.getJSONValue((Object)pSWXMenuItemBase.getPSWXMenuFuncName()), (boolean)false);
        }
        if (bl || pSWXMenuItemBase.getPSWXMenuId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxmenuid", (Object)PSWXMenuItemBase.getJSONValue((Object)pSWXMenuItemBase.getPSWXMenuId()), (boolean)false);
        }
        if (bl || pSWXMenuItemBase.getPSWXMenuItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxmenuitemid", (Object)PSWXMenuItemBase.getJSONValue((Object)pSWXMenuItemBase.getPSWXMenuItemId()), (boolean)false);
        }
        if (bl || pSWXMenuItemBase.getPSWXMenuItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxmenuitemname", (Object)PSWXMenuItemBase.getJSONValue((Object)pSWXMenuItemBase.getPSWXMenuItemName()), (boolean)false);
        }
        if (bl || pSWXMenuItemBase.getPSWXMenuName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxmenuname", (Object)PSWXMenuItemBase.getJSONValue((Object)pSWXMenuItemBase.getPSWXMenuName()), (boolean)false);
        }
        if (bl || pSWXMenuItemBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWXMenuItemBase.getJSONValue((Object)pSWXMenuItemBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWXMenuItemBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWXMenuItemBase.getJSONValue((Object)pSWXMenuItemBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSWXMenuItemBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSWXMenuItemBase.getJSONValue((Object)pSWXMenuItemBase.getUserCat()), (boolean)false);
        }
        if (bl || pSWXMenuItemBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSWXMenuItemBase.getJSONValue((Object)pSWXMenuItemBase.getUserTag()), (boolean)false);
        }
        if (bl || pSWXMenuItemBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSWXMenuItemBase.getJSONValue((Object)pSWXMenuItemBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSWXMenuItemBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSWXMenuItemBase.getJSONValue((Object)pSWXMenuItemBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSWXMenuItemBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSWXMenuItemBase.getJSONValue((Object)pSWXMenuItemBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWXMenuItemBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWXMenuItemBase pSWXMenuItemBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWXMenuItemBase.getCaption() != null) {
            object = pSWXMenuItemBase.getCaption();
            xmlNode.setAttribute(FIELD_CAPTION, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuItemBase.getCreateDate() != null) {
            object = pSWXMenuItemBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWXMenuItemBase.getCreateMan() != null) {
            object = pSWXMenuItemBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuItemBase.getMemo() != null) {
            object = pSWXMenuItemBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuItemBase.getOrderValue() != null) {
            object = pSWXMenuItemBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWXMenuItemBase.getPPSWXMenuItemId() != null) {
            object = pSWXMenuItemBase.getPPSWXMenuItemId();
            xmlNode.setAttribute(FIELD_PPSWXMENUITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuItemBase.getPPSWXMenuItemName() != null) {
            object = pSWXMenuItemBase.getPPSWXMenuItemName();
            xmlNode.setAttribute(FIELD_PPSWXMENUITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuItemBase.getPSWXMenuFuncId() != null) {
            object = pSWXMenuItemBase.getPSWXMenuFuncId();
            xmlNode.setAttribute(FIELD_PSWXMENUFUNCID, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuItemBase.getPSWXMenuFuncName() != null) {
            object = pSWXMenuItemBase.getPSWXMenuFuncName();
            xmlNode.setAttribute(FIELD_PSWXMENUFUNCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuItemBase.getPSWXMenuId() != null) {
            object = pSWXMenuItemBase.getPSWXMenuId();
            xmlNode.setAttribute(FIELD_PSWXMENUID, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuItemBase.getPSWXMenuItemId() != null) {
            object = pSWXMenuItemBase.getPSWXMenuItemId();
            xmlNode.setAttribute(FIELD_PSWXMENUITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuItemBase.getPSWXMenuItemName() != null) {
            object = pSWXMenuItemBase.getPSWXMenuItemName();
            xmlNode.setAttribute(FIELD_PSWXMENUITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuItemBase.getPSWXMenuName() != null) {
            object = pSWXMenuItemBase.getPSWXMenuName();
            xmlNode.setAttribute(FIELD_PSWXMENUNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuItemBase.getUpdateDate() != null) {
            object = pSWXMenuItemBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWXMenuItemBase.getUpdateMan() != null) {
            object = pSWXMenuItemBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuItemBase.getUserCat() != null) {
            object = pSWXMenuItemBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuItemBase.getUserTag() != null) {
            object = pSWXMenuItemBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuItemBase.getUserTag2() != null) {
            object = pSWXMenuItemBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuItemBase.getUserTag3() != null) {
            object = pSWXMenuItemBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuItemBase.getUserTag4() != null) {
            object = pSWXMenuItemBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWXMenuItemBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWXMenuItemBase pSWXMenuItemBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWXMenuItemBase.isCaptionDirty() && (bl || pSWXMenuItemBase.getCaption() != null)) {
            iDataObject.set(FIELD_CAPTION, (Object)pSWXMenuItemBase.getCaption());
        }
        if (pSWXMenuItemBase.isCreateDateDirty() && (bl || pSWXMenuItemBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWXMenuItemBase.getCreateDate());
        }
        if (pSWXMenuItemBase.isCreateManDirty() && (bl || pSWXMenuItemBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWXMenuItemBase.getCreateMan());
        }
        if (pSWXMenuItemBase.isMemoDirty() && (bl || pSWXMenuItemBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSWXMenuItemBase.getMemo());
        }
        if (pSWXMenuItemBase.isOrderValueDirty() && (bl || pSWXMenuItemBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSWXMenuItemBase.getOrderValue());
        }
        if (pSWXMenuItemBase.isPPSWXMenuItemIdDirty() && (bl || pSWXMenuItemBase.getPPSWXMenuItemId() != null)) {
            iDataObject.set(FIELD_PPSWXMENUITEMID, (Object)pSWXMenuItemBase.getPPSWXMenuItemId());
        }
        if (pSWXMenuItemBase.isPPSWXMenuItemNameDirty() && (bl || pSWXMenuItemBase.getPPSWXMenuItemName() != null)) {
            iDataObject.set(FIELD_PPSWXMENUITEMNAME, (Object)pSWXMenuItemBase.getPPSWXMenuItemName());
        }
        if (pSWXMenuItemBase.isPSWXMenuFuncIdDirty() && (bl || pSWXMenuItemBase.getPSWXMenuFuncId() != null)) {
            iDataObject.set(FIELD_PSWXMENUFUNCID, (Object)pSWXMenuItemBase.getPSWXMenuFuncId());
        }
        if (pSWXMenuItemBase.isPSWXMenuFuncNameDirty() && (bl || pSWXMenuItemBase.getPSWXMenuFuncName() != null)) {
            iDataObject.set(FIELD_PSWXMENUFUNCNAME, (Object)pSWXMenuItemBase.getPSWXMenuFuncName());
        }
        if (pSWXMenuItemBase.isPSWXMenuIdDirty() && (bl || pSWXMenuItemBase.getPSWXMenuId() != null)) {
            iDataObject.set(FIELD_PSWXMENUID, (Object)pSWXMenuItemBase.getPSWXMenuId());
        }
        if (pSWXMenuItemBase.isPSWXMenuItemIdDirty() && (bl || pSWXMenuItemBase.getPSWXMenuItemId() != null)) {
            iDataObject.set(FIELD_PSWXMENUITEMID, (Object)pSWXMenuItemBase.getPSWXMenuItemId());
        }
        if (pSWXMenuItemBase.isPSWXMenuItemNameDirty() && (bl || pSWXMenuItemBase.getPSWXMenuItemName() != null)) {
            iDataObject.set(FIELD_PSWXMENUITEMNAME, (Object)pSWXMenuItemBase.getPSWXMenuItemName());
        }
        if (pSWXMenuItemBase.isPSWXMenuNameDirty() && (bl || pSWXMenuItemBase.getPSWXMenuName() != null)) {
            iDataObject.set(FIELD_PSWXMENUNAME, (Object)pSWXMenuItemBase.getPSWXMenuName());
        }
        if (pSWXMenuItemBase.isUpdateDateDirty() && (bl || pSWXMenuItemBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWXMenuItemBase.getUpdateDate());
        }
        if (pSWXMenuItemBase.isUpdateManDirty() && (bl || pSWXMenuItemBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWXMenuItemBase.getUpdateMan());
        }
        if (pSWXMenuItemBase.isUserCatDirty() && (bl || pSWXMenuItemBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSWXMenuItemBase.getUserCat());
        }
        if (pSWXMenuItemBase.isUserTagDirty() && (bl || pSWXMenuItemBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSWXMenuItemBase.getUserTag());
        }
        if (pSWXMenuItemBase.isUserTag2Dirty() && (bl || pSWXMenuItemBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSWXMenuItemBase.getUserTag2());
        }
        if (pSWXMenuItemBase.isUserTag3Dirty() && (bl || pSWXMenuItemBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSWXMenuItemBase.getUserTag3());
        }
        if (pSWXMenuItemBase.isUserTag4Dirty() && (bl || pSWXMenuItemBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSWXMenuItemBase.getUserTag4());
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
        return PSWXMenuItemBase.remove(this, n);
    }

    private static boolean remove(PSWXMenuItemBase pSWXMenuItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWXMenuItemBase.resetCaption();
                return true;
            }
            case 1: {
                pSWXMenuItemBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSWXMenuItemBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSWXMenuItemBase.resetMemo();
                return true;
            }
            case 4: {
                pSWXMenuItemBase.resetOrderValue();
                return true;
            }
            case 5: {
                pSWXMenuItemBase.resetPPSWXMenuItemId();
                return true;
            }
            case 6: {
                pSWXMenuItemBase.resetPPSWXMenuItemName();
                return true;
            }
            case 7: {
                pSWXMenuItemBase.resetPSWXMenuFuncId();
                return true;
            }
            case 8: {
                pSWXMenuItemBase.resetPSWXMenuFuncName();
                return true;
            }
            case 9: {
                pSWXMenuItemBase.resetPSWXMenuId();
                return true;
            }
            case 10: {
                pSWXMenuItemBase.resetPSWXMenuItemId();
                return true;
            }
            case 11: {
                pSWXMenuItemBase.resetPSWXMenuItemName();
                return true;
            }
            case 12: {
                pSWXMenuItemBase.resetPSWXMenuName();
                return true;
            }
            case 13: {
                pSWXMenuItemBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSWXMenuItemBase.resetUpdateMan();
                return true;
            }
            case 15: {
                pSWXMenuItemBase.resetUserCat();
                return true;
            }
            case 16: {
                pSWXMenuItemBase.resetUserTag();
                return true;
            }
            case 17: {
                pSWXMenuItemBase.resetUserTag2();
                return true;
            }
            case 18: {
                pSWXMenuItemBase.resetUserTag3();
                return true;
            }
            case 19: {
                pSWXMenuItemBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWXMenuFunc getPSWXMenuFunc() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXMenuFunc();
        }
        if (this.getPSWXMenuFuncId() == null) {
            return null;
        }
        Integer n = this.objPSWXMenuFuncLock;
        synchronized (n) {
            if (this.pswxmenufunc != null && DataTypeHelper.compare((int)25, (Object)this.getPSWXMenuFuncId(), (Object)this.pswxmenufunc.getPSWXMenuFuncId()) != 0L) {
                this.pswxmenufunc = null;
            }
            if (this.pswxmenufunc == null) {
                PSWXMenuFunc pSWXMenuFunc = new PSWXMenuFunc();
                pSWXMenuFunc.setPSWXMenuFuncId(this.getPSWXMenuFuncId());
                PSWXMenuFuncService pSWXMenuFuncService = (PSWXMenuFuncService)ServiceGlobal.getService(PSWXMenuFuncService.class, (SessionFactory)this.getSessionFactory());
                pSWXMenuFuncService.autoGet(pSWXMenuFunc);
                this.pswxmenufunc = pSWXMenuFunc;
            }
            return this.pswxmenufunc;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWXMenuItem getPPSWXMenuItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSWXMenuItem();
        }
        if (this.getPPSWXMenuItemId() == null) {
            return null;
        }
        Integer n = this.objPPSWXMenuItemLock;
        synchronized (n) {
            if (this.ppswxmenuitem != null && DataTypeHelper.compare((int)25, (Object)this.getPPSWXMenuItemId(), (Object)this.ppswxmenuitem.getPSWXMenuItemId()) != 0L) {
                this.ppswxmenuitem = null;
            }
            if (this.ppswxmenuitem == null) {
                PSWXMenuItem pSWXMenuItem = new PSWXMenuItem();
                pSWXMenuItem.setPSWXMenuItemId(this.getPPSWXMenuItemId());
                PSWXMenuItemService pSWXMenuItemService = (PSWXMenuItemService)ServiceGlobal.getService(PSWXMenuItemService.class, (SessionFactory)this.getSessionFactory());
                pSWXMenuItemService.autoGet(pSWXMenuItem);
                this.ppswxmenuitem = pSWXMenuItem;
            }
            return this.ppswxmenuitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWXMenu getPSWXMenu() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXMenu();
        }
        if (this.getPSWXMenuId() == null) {
            return null;
        }
        Integer n = this.objPSWXMenuLock;
        synchronized (n) {
            if (this.pswxmenu != null && DataTypeHelper.compare((int)25, (Object)this.getPSWXMenuId(), (Object)this.pswxmenu.getPSWXMenuId()) != 0L) {
                this.pswxmenu = null;
            }
            if (this.pswxmenu == null) {
                PSWXMenu pSWXMenu = new PSWXMenu();
                pSWXMenu.setPSWXMenuId(this.getPSWXMenuId());
                PSWXMenuService pSWXMenuService = (PSWXMenuService)ServiceGlobal.getService(PSWXMenuService.class, (SessionFactory)this.getSessionFactory());
                pSWXMenuService.autoGet(pSWXMenu);
                this.pswxmenu = pSWXMenu;
            }
            return this.pswxmenu;
        }
    }

    private PSWXMenuItemBase getProxyEntity() {
        return this.proxyPSWXMenuItemBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWXMenuItemBase = null;
        if (iDataObject != null && iDataObject instanceof PSWXMenuItemBase) {
            this.proxyPSWXMenuItemBase = (PSWXMenuItemBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wxdesign.service.PSWXMenuItemService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CAPTION, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_ORDERVALUE, 4);
        fieldIndexMap.put(FIELD_PPSWXMENUITEMID, 5);
        fieldIndexMap.put(FIELD_PPSWXMENUITEMNAME, 6);
        fieldIndexMap.put(FIELD_PSWXMENUFUNCID, 7);
        fieldIndexMap.put(FIELD_PSWXMENUFUNCNAME, 8);
        fieldIndexMap.put(FIELD_PSWXMENUID, 9);
        fieldIndexMap.put(FIELD_PSWXMENUITEMID, 10);
        fieldIndexMap.put(FIELD_PSWXMENUITEMNAME, 11);
        fieldIndexMap.put(FIELD_PSWXMENUNAME, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
        fieldIndexMap.put(FIELD_USERCAT, 15);
        fieldIndexMap.put(FIELD_USERTAG, 16);
        fieldIndexMap.put(FIELD_USERTAG2, 17);
        fieldIndexMap.put(FIELD_USERTAG3, 18);
        fieldIndexMap.put(FIELD_USERTAG4, 19);
    }
}

