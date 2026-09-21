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
package net.ibizsys.pscore.srv.appdesign.entity;

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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppStoryBoard;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppStoryBoardService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserCase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUserCaseService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppSBItemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppSBItemBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ITEMTAG = "ITEMTAG";
    public static final String FIELD_ITEMTAG2 = "ITEMTAG2";
    public static final String FIELD_ITEMTAG3 = "ITEMTAG3";
    public static final String FIELD_ITEMTAG4 = "ITEMTAG4";
    public static final String FIELD_ITEMTYPE = "ITEMTYPE";
    public static final String FIELD_LEFTPOS = "LEFTPOS";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSAPPSBITEMID = "PSAPPSBITEMID";
    public static final String FIELD_PSAPPSBITEMNAME = "PSAPPSBITEMNAME";
    public static final String FIELD_PSAPPSTORYBOARDID = "PSAPPSTORYBOARDID";
    public static final String FIELD_PSAPPSTORYBOARDNAME = "PSAPPSTORYBOARDNAME";
    public static final String FIELD_PSAPPVIEWID = "PSAPPVIEWID";
    public static final String FIELD_PSAPPVIEWNAME = "PSAPPVIEWNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String FIELD_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String FIELD_PSSYSUSERCASEID = "PSSYSUSERCASEID";
    public static final String FIELD_PSSYSUSERCASENAME = "PSSYSUSERCASENAME";
    public static final String FIELD_ROOTITEM = "ROOTITEM";
    public static final String FIELD_TOPPOS = "TOPPOS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERFLAG = "USERFLAG";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_ITEMTAG = 3;
    private static final int INDEX_ITEMTAG2 = 4;
    private static final int INDEX_ITEMTAG3 = 5;
    private static final int INDEX_ITEMTAG4 = 6;
    private static final int INDEX_ITEMTYPE = 7;
    private static final int INDEX_LEFTPOS = 8;
    private static final int INDEX_MEMO = 9;
    private static final int INDEX_PSAPPSBITEMID = 10;
    private static final int INDEX_PSAPPSBITEMNAME = 11;
    private static final int INDEX_PSAPPSTORYBOARDID = 12;
    private static final int INDEX_PSAPPSTORYBOARDNAME = 13;
    private static final int INDEX_PSAPPVIEWID = 14;
    private static final int INDEX_PSAPPVIEWNAME = 15;
    private static final int INDEX_PSDYNAINSTID = 16;
    private static final int INDEX_PSSYSAPPID = 17;
    private static final int INDEX_PSSYSREQITEMID = 18;
    private static final int INDEX_PSSYSREQITEMNAME = 19;
    private static final int INDEX_PSSYSUSERCASEID = 20;
    private static final int INDEX_PSSYSUSERCASENAME = 21;
    private static final int INDEX_ROOTITEM = 22;
    private static final int INDEX_TOPPOS = 23;
    private static final int INDEX_UPDATEDATE = 24;
    private static final int INDEX_UPDATEMAN = 25;
    private static final int INDEX_USERCAT = 26;
    private static final int INDEX_USERFLAG = 27;
    private static final int INDEX_USERTAG = 28;
    private static final int INDEX_USERTAG2 = 29;
    private static final int INDEX_USERTAG3 = 30;
    private static final int INDEX_USERTAG4 = 31;
    private static final int INDEX_VALIDFLAG = 32;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppSBItemBase proxyPSAppSBItemBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean itemtagDirtyFlag = false;
    private boolean itemtag2DirtyFlag = false;
    private boolean itemtag3DirtyFlag = false;
    private boolean itemtag4DirtyFlag = false;
    private boolean itemtypeDirtyFlag = false;
    private boolean leftposDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psappsbitemidDirtyFlag = false;
    private boolean psappsbitemnameDirtyFlag = false;
    private boolean psappstoryboardidDirtyFlag = false;
    private boolean psappstoryboardnameDirtyFlag = false;
    private boolean psappviewidDirtyFlag = false;
    private boolean psappviewnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysreqitemidDirtyFlag = false;
    private boolean pssysreqitemnameDirtyFlag = false;
    private boolean pssysusercaseidDirtyFlag = false;
    private boolean pssysusercasenameDirtyFlag = false;
    private boolean rootitemDirtyFlag = false;
    private boolean topposDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userflagDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="itemtag")
    private String itemtag;
    @Column(name="itemtag2")
    private String itemtag2;
    @Column(name="itemtag3")
    private String itemtag3;
    @Column(name="itemtag4")
    private String itemtag4;
    @Column(name="itemtype")
    private String itemtype;
    @Column(name="leftpos")
    private Integer leftpos;
    @Column(name="memo")
    private String memo;
    @Column(name="psappsbitemid")
    private String psappsbitemid;
    @Column(name="psappsbitemname")
    private String psappsbitemname;
    @Column(name="psappstoryboardid")
    private String psappstoryboardid;
    @Column(name="psappstoryboardname")
    private String psappstoryboardname;
    @Column(name="psappviewid")
    private String psappviewid;
    @Column(name="psappviewname")
    private String psappviewname;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysreqitemid")
    private String pssysreqitemid;
    @Column(name="pssysreqitemname")
    private String pssysreqitemname;
    @Column(name="pssysusercaseid")
    private String pssysusercaseid;
    @Column(name="pssysusercasename")
    private String pssysusercasename;
    @Column(name="rootitem")
    private Integer rootitem;
    @Column(name="toppos")
    private Integer toppos;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="userflag")
    private Integer userflag;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSAppStoryBoardLock = new Integer(1);
    private PSAppStoryBoard psappstoryboard = null;
    private Integer objPSAppViewLock = new Integer(1);
    private PSAppView psappview = null;
    private Integer objPSSysReqItemLock = new Integer(1);
    private PSSysReqItem pssysreqitem = null;
    private Integer objPSSysUserCaseLock = new Integer(1);
    private PSSysUserCase pssysusercase = null;

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

    public void setItemTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemtag3 = string;
        this.itemtag3DirtyFlag = true;
    }

    public String getItemTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemTag3();
        }
        return this.itemtag3;
    }

    public boolean isItemTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemTag3Dirty();
        }
        return this.itemtag3DirtyFlag;
    }

    public void resetItemTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemTag3();
            return;
        }
        this.itemtag3DirtyFlag = false;
        this.itemtag3 = null;
    }

    public void setItemTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemtag4 = string;
        this.itemtag4DirtyFlag = true;
    }

    public String getItemTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemTag4();
        }
        return this.itemtag4;
    }

    public boolean isItemTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemTag4Dirty();
        }
        return this.itemtag4DirtyFlag;
    }

    public void resetItemTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemTag4();
            return;
        }
        this.itemtag4DirtyFlag = false;
        this.itemtag4 = null;
    }

    public void setItemType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemtype = string;
        this.itemtypeDirtyFlag = true;
    }

    public String getItemType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemType();
        }
        return this.itemtype;
    }

    public boolean isItemTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemTypeDirty();
        }
        return this.itemtypeDirtyFlag;
    }

    public void resetItemType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemType();
            return;
        }
        this.itemtypeDirtyFlag = false;
        this.itemtype = null;
    }

    public void setLeftPos(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLeftPos(n);
            return;
        }
        this.leftpos = n;
        this.leftposDirtyFlag = true;
    }

    public Integer getLeftPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLeftPos();
        }
        return this.leftpos;
    }

    public boolean isLeftPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLeftPosDirty();
        }
        return this.leftposDirtyFlag;
    }

    public void resetLeftPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLeftPos();
            return;
        }
        this.leftposDirtyFlag = false;
        this.leftpos = null;
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

    public void setPSAppSBItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppSBItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappsbitemid = string;
        this.psappsbitemidDirtyFlag = true;
    }

    public String getPSAppSBItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppSBItemId();
        }
        return this.psappsbitemid;
    }

    public boolean isPSAppSBItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppSBItemIdDirty();
        }
        return this.psappsbitemidDirtyFlag;
    }

    public void resetPSAppSBItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppSBItemId();
            return;
        }
        this.psappsbitemidDirtyFlag = false;
        this.psappsbitemid = null;
    }

    public void setPSAppSBItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppSBItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappsbitemname = string;
        this.psappsbitemnameDirtyFlag = true;
    }

    public String getPSAppSBItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppSBItemName();
        }
        return this.psappsbitemname;
    }

    public boolean isPSAppSBItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppSBItemNameDirty();
        }
        return this.psappsbitemnameDirtyFlag;
    }

    public void resetPSAppSBItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppSBItemName();
            return;
        }
        this.psappsbitemnameDirtyFlag = false;
        this.psappsbitemname = null;
    }

    public void setPSAppStoryBoardId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppStoryBoardId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappstoryboardid = string;
        this.psappstoryboardidDirtyFlag = true;
    }

    public String getPSAppStoryBoardId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppStoryBoardId();
        }
        return this.psappstoryboardid;
    }

    public boolean isPSAppStoryBoardIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppStoryBoardIdDirty();
        }
        return this.psappstoryboardidDirtyFlag;
    }

    public void resetPSAppStoryBoardId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppStoryBoardId();
            return;
        }
        this.psappstoryboardidDirtyFlag = false;
        this.psappstoryboardid = null;
    }

    public void setPSAppStoryBoardName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppStoryBoardName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappstoryboardname = string;
        this.psappstoryboardnameDirtyFlag = true;
    }

    public String getPSAppStoryBoardName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppStoryBoardName();
        }
        return this.psappstoryboardname;
    }

    public boolean isPSAppStoryBoardNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppStoryBoardNameDirty();
        }
        return this.psappstoryboardnameDirtyFlag;
    }

    public void resetPSAppStoryBoardName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppStoryBoardName();
            return;
        }
        this.psappstoryboardnameDirtyFlag = false;
        this.psappstoryboardname = null;
    }

    public void setPSAppViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewid = string;
        this.psappviewidDirtyFlag = true;
    }

    public String getPSAppViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewId();
        }
        return this.psappviewid;
    }

    public boolean isPSAppViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewIdDirty();
        }
        return this.psappviewidDirtyFlag;
    }

    public void resetPSAppViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewId();
            return;
        }
        this.psappviewidDirtyFlag = false;
        this.psappviewid = null;
    }

    public void setPSAppViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewname = string;
        this.psappviewnameDirtyFlag = true;
    }

    public String getPSAppViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewName();
        }
        return this.psappviewname;
    }

    public boolean isPSAppViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewNameDirty();
        }
        return this.psappviewnameDirtyFlag;
    }

    public void resetPSAppViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewName();
            return;
        }
        this.psappviewnameDirtyFlag = false;
        this.psappviewname = null;
    }

    public void setPSDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstid = string;
        this.psdynainstidDirtyFlag = true;
    }

    public String getPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstId();
        }
        return this.psdynainstid;
    }

    public boolean isPSDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstIdDirty();
        }
        return this.psdynainstidDirtyFlag;
    }

    public void resetPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstId();
            return;
        }
        this.psdynainstidDirtyFlag = false;
        this.psdynainstid = null;
    }

    public void setPSSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappid = string;
        this.pssysappidDirtyFlag = true;
    }

    public String getPSSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppId();
        }
        return this.pssysappid;
    }

    public boolean isPSSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppIdDirty();
        }
        return this.pssysappidDirtyFlag;
    }

    public void resetPSSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppId();
            return;
        }
        this.pssysappidDirtyFlag = false;
        this.pssysappid = null;
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

    public void setPSSysUserCaseId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUserCaseId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysusercaseid = string;
        this.pssysusercaseidDirtyFlag = true;
    }

    public String getPSSysUserCaseId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserCaseId();
        }
        return this.pssysusercaseid;
    }

    public boolean isPSSysUserCaseIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUserCaseIdDirty();
        }
        return this.pssysusercaseidDirtyFlag;
    }

    public void resetPSSysUserCaseId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUserCaseId();
            return;
        }
        this.pssysusercaseidDirtyFlag = false;
        this.pssysusercaseid = null;
    }

    public void setPSSysUserCaseName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUserCaseName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysusercasename = string;
        this.pssysusercasenameDirtyFlag = true;
    }

    public String getPSSysUserCaseName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserCaseName();
        }
        return this.pssysusercasename;
    }

    public boolean isPSSysUserCaseNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUserCaseNameDirty();
        }
        return this.pssysusercasenameDirtyFlag;
    }

    public void resetPSSysUserCaseName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUserCaseName();
            return;
        }
        this.pssysusercasenameDirtyFlag = false;
        this.pssysusercasename = null;
    }

    public void setRootItem(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRootItem(n);
            return;
        }
        this.rootitem = n;
        this.rootitemDirtyFlag = true;
    }

    public Integer getRootItem() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRootItem();
        }
        return this.rootitem;
    }

    public boolean isRootItemDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRootItemDirty();
        }
        return this.rootitemDirtyFlag;
    }

    public void resetRootItem() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRootItem();
            return;
        }
        this.rootitemDirtyFlag = false;
        this.rootitem = null;
    }

    public void setTopPos(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTopPos(n);
            return;
        }
        this.toppos = n;
        this.topposDirtyFlag = true;
    }

    public Integer getTopPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTopPos();
        }
        return this.toppos;
    }

    public boolean isTopPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTopPosDirty();
        }
        return this.topposDirtyFlag;
    }

    public void resetTopPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTopPos();
            return;
        }
        this.topposDirtyFlag = false;
        this.toppos = null;
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
        PSAppSBItemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppSBItemBase pSAppSBItemBase) {
        pSAppSBItemBase.resetCodeName();
        pSAppSBItemBase.resetCreateDate();
        pSAppSBItemBase.resetCreateMan();
        pSAppSBItemBase.resetItemTag();
        pSAppSBItemBase.resetItemTag2();
        pSAppSBItemBase.resetItemTag3();
        pSAppSBItemBase.resetItemTag4();
        pSAppSBItemBase.resetItemType();
        pSAppSBItemBase.resetLeftPos();
        pSAppSBItemBase.resetMemo();
        pSAppSBItemBase.resetPSAppSBItemId();
        pSAppSBItemBase.resetPSAppSBItemName();
        pSAppSBItemBase.resetPSAppStoryBoardId();
        pSAppSBItemBase.resetPSAppStoryBoardName();
        pSAppSBItemBase.resetPSAppViewId();
        pSAppSBItemBase.resetPSAppViewName();
        pSAppSBItemBase.resetPSDynaInstId();
        pSAppSBItemBase.resetPSSysAppId();
        pSAppSBItemBase.resetPSSysReqItemId();
        pSAppSBItemBase.resetPSSysReqItemName();
        pSAppSBItemBase.resetPSSysUserCaseId();
        pSAppSBItemBase.resetPSSysUserCaseName();
        pSAppSBItemBase.resetRootItem();
        pSAppSBItemBase.resetTopPos();
        pSAppSBItemBase.resetUpdateDate();
        pSAppSBItemBase.resetUpdateMan();
        pSAppSBItemBase.resetUserCat();
        pSAppSBItemBase.resetUserFlag();
        pSAppSBItemBase.resetUserTag();
        pSAppSBItemBase.resetUserTag2();
        pSAppSBItemBase.resetUserTag3();
        pSAppSBItemBase.resetUserTag4();
        pSAppSBItemBase.resetValidFlag();
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
        if (!bl || this.isItemTagDirty()) {
            hashMap.put(FIELD_ITEMTAG, this.getItemTag());
        }
        if (!bl || this.isItemTag2Dirty()) {
            hashMap.put(FIELD_ITEMTAG2, this.getItemTag2());
        }
        if (!bl || this.isItemTag3Dirty()) {
            hashMap.put(FIELD_ITEMTAG3, this.getItemTag3());
        }
        if (!bl || this.isItemTag4Dirty()) {
            hashMap.put(FIELD_ITEMTAG4, this.getItemTag4());
        }
        if (!bl || this.isItemTypeDirty()) {
            hashMap.put(FIELD_ITEMTYPE, this.getItemType());
        }
        if (!bl || this.isLeftPosDirty()) {
            hashMap.put(FIELD_LEFTPOS, this.getLeftPos());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSAppSBItemIdDirty()) {
            hashMap.put(FIELD_PSAPPSBITEMID, this.getPSAppSBItemId());
        }
        if (!bl || this.isPSAppSBItemNameDirty()) {
            hashMap.put(FIELD_PSAPPSBITEMNAME, this.getPSAppSBItemName());
        }
        if (!bl || this.isPSAppStoryBoardIdDirty()) {
            hashMap.put(FIELD_PSAPPSTORYBOARDID, this.getPSAppStoryBoardId());
        }
        if (!bl || this.isPSAppStoryBoardNameDirty()) {
            hashMap.put(FIELD_PSAPPSTORYBOARDNAME, this.getPSAppStoryBoardName());
        }
        if (!bl || this.isPSAppViewIdDirty()) {
            hashMap.put(FIELD_PSAPPVIEWID, this.getPSAppViewId());
        }
        if (!bl || this.isPSAppViewNameDirty()) {
            hashMap.put(FIELD_PSAPPVIEWNAME, this.getPSAppViewName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysReqItemIdDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMID, this.getPSSysReqItemId());
        }
        if (!bl || this.isPSSysReqItemNameDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMNAME, this.getPSSysReqItemName());
        }
        if (!bl || this.isPSSysUserCaseIdDirty()) {
            hashMap.put(FIELD_PSSYSUSERCASEID, this.getPSSysUserCaseId());
        }
        if (!bl || this.isPSSysUserCaseNameDirty()) {
            hashMap.put(FIELD_PSSYSUSERCASENAME, this.getPSSysUserCaseName());
        }
        if (!bl || this.isRootItemDirty()) {
            hashMap.put(FIELD_ROOTITEM, this.getRootItem());
        }
        if (!bl || this.isTopPosDirty()) {
            hashMap.put(FIELD_TOPPOS, this.getTopPos());
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
        if (!bl || this.isUserFlagDirty()) {
            hashMap.put(FIELD_USERFLAG, this.getUserFlag());
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
        return PSAppSBItemBase.get(this, n);
    }

    private static Object get(PSAppSBItemBase pSAppSBItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppSBItemBase.getCodeName();
            }
            case 1: {
                return pSAppSBItemBase.getCreateDate();
            }
            case 2: {
                return pSAppSBItemBase.getCreateMan();
            }
            case 3: {
                return pSAppSBItemBase.getItemTag();
            }
            case 4: {
                return pSAppSBItemBase.getItemTag2();
            }
            case 5: {
                return pSAppSBItemBase.getItemTag3();
            }
            case 6: {
                return pSAppSBItemBase.getItemTag4();
            }
            case 7: {
                return pSAppSBItemBase.getItemType();
            }
            case 8: {
                return pSAppSBItemBase.getLeftPos();
            }
            case 9: {
                return pSAppSBItemBase.getMemo();
            }
            case 10: {
                return pSAppSBItemBase.getPSAppSBItemId();
            }
            case 11: {
                return pSAppSBItemBase.getPSAppSBItemName();
            }
            case 12: {
                return pSAppSBItemBase.getPSAppStoryBoardId();
            }
            case 13: {
                return pSAppSBItemBase.getPSAppStoryBoardName();
            }
            case 14: {
                return pSAppSBItemBase.getPSAppViewId();
            }
            case 15: {
                return pSAppSBItemBase.getPSAppViewName();
            }
            case 16: {
                return pSAppSBItemBase.getPSDynaInstId();
            }
            case 17: {
                return pSAppSBItemBase.getPSSysAppId();
            }
            case 18: {
                return pSAppSBItemBase.getPSSysReqItemId();
            }
            case 19: {
                return pSAppSBItemBase.getPSSysReqItemName();
            }
            case 20: {
                return pSAppSBItemBase.getPSSysUserCaseId();
            }
            case 21: {
                return pSAppSBItemBase.getPSSysUserCaseName();
            }
            case 22: {
                return pSAppSBItemBase.getRootItem();
            }
            case 23: {
                return pSAppSBItemBase.getTopPos();
            }
            case 24: {
                return pSAppSBItemBase.getUpdateDate();
            }
            case 25: {
                return pSAppSBItemBase.getUpdateMan();
            }
            case 26: {
                return pSAppSBItemBase.getUserCat();
            }
            case 27: {
                return pSAppSBItemBase.getUserFlag();
            }
            case 28: {
                return pSAppSBItemBase.getUserTag();
            }
            case 29: {
                return pSAppSBItemBase.getUserTag2();
            }
            case 30: {
                return pSAppSBItemBase.getUserTag3();
            }
            case 31: {
                return pSAppSBItemBase.getUserTag4();
            }
            case 32: {
                return pSAppSBItemBase.getValidFlag();
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
        PSAppSBItemBase.set(this, n, object);
    }

    private static void set(PSAppSBItemBase pSAppSBItemBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppSBItemBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSAppSBItemBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSAppSBItemBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSAppSBItemBase.setItemTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSAppSBItemBase.setItemTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSAppSBItemBase.setItemTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSAppSBItemBase.setItemTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSAppSBItemBase.setItemType(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSAppSBItemBase.setLeftPos(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSAppSBItemBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSAppSBItemBase.setPSAppSBItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSAppSBItemBase.setPSAppSBItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSAppSBItemBase.setPSAppStoryBoardId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSAppSBItemBase.setPSAppStoryBoardName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSAppSBItemBase.setPSAppViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSAppSBItemBase.setPSAppViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSAppSBItemBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSAppSBItemBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSAppSBItemBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSAppSBItemBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSAppSBItemBase.setPSSysUserCaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSAppSBItemBase.setPSSysUserCaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSAppSBItemBase.setRootItem(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSAppSBItemBase.setTopPos(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSAppSBItemBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 25: {
                pSAppSBItemBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSAppSBItemBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSAppSBItemBase.setUserFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 28: {
                pSAppSBItemBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSAppSBItemBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSAppSBItemBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSAppSBItemBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSAppSBItemBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSAppSBItemBase.isNull(this, n);
    }

    private static boolean isNull(PSAppSBItemBase pSAppSBItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppSBItemBase.getCodeName() == null;
            }
            case 1: {
                return pSAppSBItemBase.getCreateDate() == null;
            }
            case 2: {
                return pSAppSBItemBase.getCreateMan() == null;
            }
            case 3: {
                return pSAppSBItemBase.getItemTag() == null;
            }
            case 4: {
                return pSAppSBItemBase.getItemTag2() == null;
            }
            case 5: {
                return pSAppSBItemBase.getItemTag3() == null;
            }
            case 6: {
                return pSAppSBItemBase.getItemTag4() == null;
            }
            case 7: {
                return pSAppSBItemBase.getItemType() == null;
            }
            case 8: {
                return pSAppSBItemBase.getLeftPos() == null;
            }
            case 9: {
                return pSAppSBItemBase.getMemo() == null;
            }
            case 10: {
                return pSAppSBItemBase.getPSAppSBItemId() == null;
            }
            case 11: {
                return pSAppSBItemBase.getPSAppSBItemName() == null;
            }
            case 12: {
                return pSAppSBItemBase.getPSAppStoryBoardId() == null;
            }
            case 13: {
                return pSAppSBItemBase.getPSAppStoryBoardName() == null;
            }
            case 14: {
                return pSAppSBItemBase.getPSAppViewId() == null;
            }
            case 15: {
                return pSAppSBItemBase.getPSAppViewName() == null;
            }
            case 16: {
                return pSAppSBItemBase.getPSDynaInstId() == null;
            }
            case 17: {
                return pSAppSBItemBase.getPSSysAppId() == null;
            }
            case 18: {
                return pSAppSBItemBase.getPSSysReqItemId() == null;
            }
            case 19: {
                return pSAppSBItemBase.getPSSysReqItemName() == null;
            }
            case 20: {
                return pSAppSBItemBase.getPSSysUserCaseId() == null;
            }
            case 21: {
                return pSAppSBItemBase.getPSSysUserCaseName() == null;
            }
            case 22: {
                return pSAppSBItemBase.getRootItem() == null;
            }
            case 23: {
                return pSAppSBItemBase.getTopPos() == null;
            }
            case 24: {
                return pSAppSBItemBase.getUpdateDate() == null;
            }
            case 25: {
                return pSAppSBItemBase.getUpdateMan() == null;
            }
            case 26: {
                return pSAppSBItemBase.getUserCat() == null;
            }
            case 27: {
                return pSAppSBItemBase.getUserFlag() == null;
            }
            case 28: {
                return pSAppSBItemBase.getUserTag() == null;
            }
            case 29: {
                return pSAppSBItemBase.getUserTag2() == null;
            }
            case 30: {
                return pSAppSBItemBase.getUserTag3() == null;
            }
            case 31: {
                return pSAppSBItemBase.getUserTag4() == null;
            }
            case 32: {
                return pSAppSBItemBase.getValidFlag() == null;
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
        return PSAppSBItemBase.contains(this, n);
    }

    private static boolean contains(PSAppSBItemBase pSAppSBItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppSBItemBase.isCodeNameDirty();
            }
            case 1: {
                return pSAppSBItemBase.isCreateDateDirty();
            }
            case 2: {
                return pSAppSBItemBase.isCreateManDirty();
            }
            case 3: {
                return pSAppSBItemBase.isItemTagDirty();
            }
            case 4: {
                return pSAppSBItemBase.isItemTag2Dirty();
            }
            case 5: {
                return pSAppSBItemBase.isItemTag3Dirty();
            }
            case 6: {
                return pSAppSBItemBase.isItemTag4Dirty();
            }
            case 7: {
                return pSAppSBItemBase.isItemTypeDirty();
            }
            case 8: {
                return pSAppSBItemBase.isLeftPosDirty();
            }
            case 9: {
                return pSAppSBItemBase.isMemoDirty();
            }
            case 10: {
                return pSAppSBItemBase.isPSAppSBItemIdDirty();
            }
            case 11: {
                return pSAppSBItemBase.isPSAppSBItemNameDirty();
            }
            case 12: {
                return pSAppSBItemBase.isPSAppStoryBoardIdDirty();
            }
            case 13: {
                return pSAppSBItemBase.isPSAppStoryBoardNameDirty();
            }
            case 14: {
                return pSAppSBItemBase.isPSAppViewIdDirty();
            }
            case 15: {
                return pSAppSBItemBase.isPSAppViewNameDirty();
            }
            case 16: {
                return pSAppSBItemBase.isPSDynaInstIdDirty();
            }
            case 17: {
                return pSAppSBItemBase.isPSSysAppIdDirty();
            }
            case 18: {
                return pSAppSBItemBase.isPSSysReqItemIdDirty();
            }
            case 19: {
                return pSAppSBItemBase.isPSSysReqItemNameDirty();
            }
            case 20: {
                return pSAppSBItemBase.isPSSysUserCaseIdDirty();
            }
            case 21: {
                return pSAppSBItemBase.isPSSysUserCaseNameDirty();
            }
            case 22: {
                return pSAppSBItemBase.isRootItemDirty();
            }
            case 23: {
                return pSAppSBItemBase.isTopPosDirty();
            }
            case 24: {
                return pSAppSBItemBase.isUpdateDateDirty();
            }
            case 25: {
                return pSAppSBItemBase.isUpdateManDirty();
            }
            case 26: {
                return pSAppSBItemBase.isUserCatDirty();
            }
            case 27: {
                return pSAppSBItemBase.isUserFlagDirty();
            }
            case 28: {
                return pSAppSBItemBase.isUserTagDirty();
            }
            case 29: {
                return pSAppSBItemBase.isUserTag2Dirty();
            }
            case 30: {
                return pSAppSBItemBase.isUserTag3Dirty();
            }
            case 31: {
                return pSAppSBItemBase.isUserTag4Dirty();
            }
            case 32: {
                return pSAppSBItemBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppSBItemBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppSBItemBase pSAppSBItemBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppSBItemBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSAppSBItemBase.getJSONValue((Object)pSAppSBItemBase.getCodeName()), (boolean)false);
        }
        if (bl || pSAppSBItemBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppSBItemBase.getJSONValue((Object)pSAppSBItemBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppSBItemBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppSBItemBase.getJSONValue((Object)pSAppSBItemBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppSBItemBase.getItemTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemtag", (Object)PSAppSBItemBase.getJSONValue((Object)pSAppSBItemBase.getItemTag()), (boolean)false);
        }
        if (bl || pSAppSBItemBase.getItemTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemtag2", (Object)PSAppSBItemBase.getJSONValue((Object)pSAppSBItemBase.getItemTag2()), (boolean)false);
        }
        if (bl || pSAppSBItemBase.getItemTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemtag3", (Object)PSAppSBItemBase.getJSONValue((Object)pSAppSBItemBase.getItemTag3()), (boolean)false);
        }
        if (bl || pSAppSBItemBase.getItemTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemtag4", (Object)PSAppSBItemBase.getJSONValue((Object)pSAppSBItemBase.getItemTag4()), (boolean)false);
        }
        if (bl || pSAppSBItemBase.getItemType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemtype", (Object)PSAppSBItemBase.getJSONValue((Object)pSAppSBItemBase.getItemType()), (boolean)false);
        }
        if (bl || pSAppSBItemBase.getLeftPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"leftpos", (Object)PSAppSBItemBase.getJSONValue((Object)pSAppSBItemBase.getLeftPos()), (boolean)false);
        }
        if (bl || pSAppSBItemBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAppSBItemBase.getJSONValue((Object)pSAppSBItemBase.getMemo()), (boolean)false);
        }
        if (bl || pSAppSBItemBase.getPSAppSBItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappsbitemid", (Object)PSAppSBItemBase.getJSONValue((Object)pSAppSBItemBase.getPSAppSBItemId()), (boolean)false);
        }
        if (bl || pSAppSBItemBase.getPSAppSBItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappsbitemname", (Object)PSAppSBItemBase.getJSONValue((Object)pSAppSBItemBase.getPSAppSBItemName()), (boolean)false);
        }
        if (bl || pSAppSBItemBase.getPSAppStoryBoardId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappstoryboardid", (Object)PSAppSBItemBase.getJSONValue((Object)pSAppSBItemBase.getPSAppStoryBoardId()), (boolean)false);
        }
        if (bl || pSAppSBItemBase.getPSAppStoryBoardName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappstoryboardname", (Object)PSAppSBItemBase.getJSONValue((Object)pSAppSBItemBase.getPSAppStoryBoardName()), (boolean)false);
        }
        if (bl || pSAppSBItemBase.getPSAppViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewid", (Object)PSAppSBItemBase.getJSONValue((Object)pSAppSBItemBase.getPSAppViewId()), (boolean)false);
        }
        if (bl || pSAppSBItemBase.getPSAppViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewname", (Object)PSAppSBItemBase.getJSONValue((Object)pSAppSBItemBase.getPSAppViewName()), (boolean)false);
        }
        if (bl || pSAppSBItemBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSAppSBItemBase.getJSONValue((Object)pSAppSBItemBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSAppSBItemBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSAppSBItemBase.getJSONValue((Object)pSAppSBItemBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSAppSBItemBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSAppSBItemBase.getJSONValue((Object)pSAppSBItemBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSAppSBItemBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSAppSBItemBase.getJSONValue((Object)pSAppSBItemBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSAppSBItemBase.getPSSysUserCaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysusercaseid", (Object)PSAppSBItemBase.getJSONValue((Object)pSAppSBItemBase.getPSSysUserCaseId()), (boolean)false);
        }
        if (bl || pSAppSBItemBase.getPSSysUserCaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysusercasename", (Object)PSAppSBItemBase.getJSONValue((Object)pSAppSBItemBase.getPSSysUserCaseName()), (boolean)false);
        }
        if (bl || pSAppSBItemBase.getRootItem() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rootitem", (Object)PSAppSBItemBase.getJSONValue((Object)pSAppSBItemBase.getRootItem()), (boolean)false);
        }
        if (bl || pSAppSBItemBase.getTopPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"toppos", (Object)PSAppSBItemBase.getJSONValue((Object)pSAppSBItemBase.getTopPos()), (boolean)false);
        }
        if (bl || pSAppSBItemBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppSBItemBase.getJSONValue((Object)pSAppSBItemBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppSBItemBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppSBItemBase.getJSONValue((Object)pSAppSBItemBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSAppSBItemBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSAppSBItemBase.getJSONValue((Object)pSAppSBItemBase.getUserCat()), (boolean)false);
        }
        if (bl || pSAppSBItemBase.getUserFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userflag", (Object)PSAppSBItemBase.getJSONValue((Object)pSAppSBItemBase.getUserFlag()), (boolean)false);
        }
        if (bl || pSAppSBItemBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSAppSBItemBase.getJSONValue((Object)pSAppSBItemBase.getUserTag()), (boolean)false);
        }
        if (bl || pSAppSBItemBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSAppSBItemBase.getJSONValue((Object)pSAppSBItemBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSAppSBItemBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSAppSBItemBase.getJSONValue((Object)pSAppSBItemBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSAppSBItemBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSAppSBItemBase.getJSONValue((Object)pSAppSBItemBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSAppSBItemBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSAppSBItemBase.getJSONValue((Object)pSAppSBItemBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppSBItemBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppSBItemBase pSAppSBItemBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppSBItemBase.getCodeName() != null) {
            object = pSAppSBItemBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemBase.getCreateDate() != null) {
            object = pSAppSBItemBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppSBItemBase.getCreateMan() != null) {
            object = pSAppSBItemBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemBase.getItemTag() != null) {
            object = pSAppSBItemBase.getItemTag();
            xmlNode.setAttribute(FIELD_ITEMTAG, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemBase.getItemTag2() != null) {
            object = pSAppSBItemBase.getItemTag2();
            xmlNode.setAttribute(FIELD_ITEMTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemBase.getItemTag3() != null) {
            object = pSAppSBItemBase.getItemTag3();
            xmlNode.setAttribute(FIELD_ITEMTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemBase.getItemTag4() != null) {
            object = pSAppSBItemBase.getItemTag4();
            xmlNode.setAttribute(FIELD_ITEMTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemBase.getItemType() != null) {
            object = pSAppSBItemBase.getItemType();
            xmlNode.setAttribute(FIELD_ITEMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemBase.getLeftPos() != null) {
            object = pSAppSBItemBase.getLeftPos();
            xmlNode.setAttribute(FIELD_LEFTPOS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppSBItemBase.getMemo() != null) {
            object = pSAppSBItemBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemBase.getPSAppSBItemId() != null) {
            object = pSAppSBItemBase.getPSAppSBItemId();
            xmlNode.setAttribute(FIELD_PSAPPSBITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemBase.getPSAppSBItemName() != null) {
            object = pSAppSBItemBase.getPSAppSBItemName();
            xmlNode.setAttribute(FIELD_PSAPPSBITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemBase.getPSAppStoryBoardId() != null) {
            object = pSAppSBItemBase.getPSAppStoryBoardId();
            xmlNode.setAttribute(FIELD_PSAPPSTORYBOARDID, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemBase.getPSAppStoryBoardName() != null) {
            object = pSAppSBItemBase.getPSAppStoryBoardName();
            xmlNode.setAttribute(FIELD_PSAPPSTORYBOARDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemBase.getPSAppViewId() != null) {
            object = pSAppSBItemBase.getPSAppViewId();
            xmlNode.setAttribute(FIELD_PSAPPVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemBase.getPSAppViewName() != null) {
            object = pSAppSBItemBase.getPSAppViewName();
            xmlNode.setAttribute(FIELD_PSAPPVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemBase.getPSDynaInstId() != null) {
            object = pSAppSBItemBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemBase.getPSSysAppId() != null) {
            object = pSAppSBItemBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemBase.getPSSysReqItemId() != null) {
            object = pSAppSBItemBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemBase.getPSSysReqItemName() != null) {
            object = pSAppSBItemBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemBase.getPSSysUserCaseId() != null) {
            object = pSAppSBItemBase.getPSSysUserCaseId();
            xmlNode.setAttribute(FIELD_PSSYSUSERCASEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemBase.getPSSysUserCaseName() != null) {
            object = pSAppSBItemBase.getPSSysUserCaseName();
            xmlNode.setAttribute(FIELD_PSSYSUSERCASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemBase.getRootItem() != null) {
            object = pSAppSBItemBase.getRootItem();
            xmlNode.setAttribute(FIELD_ROOTITEM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppSBItemBase.getTopPos() != null) {
            object = pSAppSBItemBase.getTopPos();
            xmlNode.setAttribute(FIELD_TOPPOS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppSBItemBase.getUpdateDate() != null) {
            object = pSAppSBItemBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppSBItemBase.getUpdateMan() != null) {
            object = pSAppSBItemBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemBase.getUserCat() != null) {
            object = pSAppSBItemBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemBase.getUserFlag() != null) {
            object = pSAppSBItemBase.getUserFlag();
            xmlNode.setAttribute(FIELD_USERFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppSBItemBase.getUserTag() != null) {
            object = pSAppSBItemBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemBase.getUserTag2() != null) {
            object = pSAppSBItemBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemBase.getUserTag3() != null) {
            object = pSAppSBItemBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemBase.getUserTag4() != null) {
            object = pSAppSBItemBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSAppSBItemBase.getValidFlag() != null) {
            object = pSAppSBItemBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppSBItemBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppSBItemBase pSAppSBItemBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppSBItemBase.isCodeNameDirty() && (bl || pSAppSBItemBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSAppSBItemBase.getCodeName());
        }
        if (pSAppSBItemBase.isCreateDateDirty() && (bl || pSAppSBItemBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppSBItemBase.getCreateDate());
        }
        if (pSAppSBItemBase.isCreateManDirty() && (bl || pSAppSBItemBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppSBItemBase.getCreateMan());
        }
        if (pSAppSBItemBase.isItemTagDirty() && (bl || pSAppSBItemBase.getItemTag() != null)) {
            iDataObject.set(FIELD_ITEMTAG, (Object)pSAppSBItemBase.getItemTag());
        }
        if (pSAppSBItemBase.isItemTag2Dirty() && (bl || pSAppSBItemBase.getItemTag2() != null)) {
            iDataObject.set(FIELD_ITEMTAG2, (Object)pSAppSBItemBase.getItemTag2());
        }
        if (pSAppSBItemBase.isItemTag3Dirty() && (bl || pSAppSBItemBase.getItemTag3() != null)) {
            iDataObject.set(FIELD_ITEMTAG3, (Object)pSAppSBItemBase.getItemTag3());
        }
        if (pSAppSBItemBase.isItemTag4Dirty() && (bl || pSAppSBItemBase.getItemTag4() != null)) {
            iDataObject.set(FIELD_ITEMTAG4, (Object)pSAppSBItemBase.getItemTag4());
        }
        if (pSAppSBItemBase.isItemTypeDirty() && (bl || pSAppSBItemBase.getItemType() != null)) {
            iDataObject.set(FIELD_ITEMTYPE, (Object)pSAppSBItemBase.getItemType());
        }
        if (pSAppSBItemBase.isLeftPosDirty() && (bl || pSAppSBItemBase.getLeftPos() != null)) {
            iDataObject.set(FIELD_LEFTPOS, (Object)pSAppSBItemBase.getLeftPos());
        }
        if (pSAppSBItemBase.isMemoDirty() && (bl || pSAppSBItemBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAppSBItemBase.getMemo());
        }
        if (pSAppSBItemBase.isPSAppSBItemIdDirty() && (bl || pSAppSBItemBase.getPSAppSBItemId() != null)) {
            iDataObject.set(FIELD_PSAPPSBITEMID, (Object)pSAppSBItemBase.getPSAppSBItemId());
        }
        if (pSAppSBItemBase.isPSAppSBItemNameDirty() && (bl || pSAppSBItemBase.getPSAppSBItemName() != null)) {
            iDataObject.set(FIELD_PSAPPSBITEMNAME, (Object)pSAppSBItemBase.getPSAppSBItemName());
        }
        if (pSAppSBItemBase.isPSAppStoryBoardIdDirty() && (bl || pSAppSBItemBase.getPSAppStoryBoardId() != null)) {
            iDataObject.set(FIELD_PSAPPSTORYBOARDID, (Object)pSAppSBItemBase.getPSAppStoryBoardId());
        }
        if (pSAppSBItemBase.isPSAppStoryBoardNameDirty() && (bl || pSAppSBItemBase.getPSAppStoryBoardName() != null)) {
            iDataObject.set(FIELD_PSAPPSTORYBOARDNAME, (Object)pSAppSBItemBase.getPSAppStoryBoardName());
        }
        if (pSAppSBItemBase.isPSAppViewIdDirty() && (bl || pSAppSBItemBase.getPSAppViewId() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWID, (Object)pSAppSBItemBase.getPSAppViewId());
        }
        if (pSAppSBItemBase.isPSAppViewNameDirty() && (bl || pSAppSBItemBase.getPSAppViewName() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWNAME, (Object)pSAppSBItemBase.getPSAppViewName());
        }
        if (pSAppSBItemBase.isPSDynaInstIdDirty() && (bl || pSAppSBItemBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSAppSBItemBase.getPSDynaInstId());
        }
        if (pSAppSBItemBase.isPSSysAppIdDirty() && (bl || pSAppSBItemBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSAppSBItemBase.getPSSysAppId());
        }
        if (pSAppSBItemBase.isPSSysReqItemIdDirty() && (bl || pSAppSBItemBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSAppSBItemBase.getPSSysReqItemId());
        }
        if (pSAppSBItemBase.isPSSysReqItemNameDirty() && (bl || pSAppSBItemBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSAppSBItemBase.getPSSysReqItemName());
        }
        if (pSAppSBItemBase.isPSSysUserCaseIdDirty() && (bl || pSAppSBItemBase.getPSSysUserCaseId() != null)) {
            iDataObject.set(FIELD_PSSYSUSERCASEID, (Object)pSAppSBItemBase.getPSSysUserCaseId());
        }
        if (pSAppSBItemBase.isPSSysUserCaseNameDirty() && (bl || pSAppSBItemBase.getPSSysUserCaseName() != null)) {
            iDataObject.set(FIELD_PSSYSUSERCASENAME, (Object)pSAppSBItemBase.getPSSysUserCaseName());
        }
        if (pSAppSBItemBase.isRootItemDirty() && (bl || pSAppSBItemBase.getRootItem() != null)) {
            iDataObject.set(FIELD_ROOTITEM, (Object)pSAppSBItemBase.getRootItem());
        }
        if (pSAppSBItemBase.isTopPosDirty() && (bl || pSAppSBItemBase.getTopPos() != null)) {
            iDataObject.set(FIELD_TOPPOS, (Object)pSAppSBItemBase.getTopPos());
        }
        if (pSAppSBItemBase.isUpdateDateDirty() && (bl || pSAppSBItemBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppSBItemBase.getUpdateDate());
        }
        if (pSAppSBItemBase.isUpdateManDirty() && (bl || pSAppSBItemBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppSBItemBase.getUpdateMan());
        }
        if (pSAppSBItemBase.isUserCatDirty() && (bl || pSAppSBItemBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSAppSBItemBase.getUserCat());
        }
        if (pSAppSBItemBase.isUserFlagDirty() && (bl || pSAppSBItemBase.getUserFlag() != null)) {
            iDataObject.set(FIELD_USERFLAG, (Object)pSAppSBItemBase.getUserFlag());
        }
        if (pSAppSBItemBase.isUserTagDirty() && (bl || pSAppSBItemBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSAppSBItemBase.getUserTag());
        }
        if (pSAppSBItemBase.isUserTag2Dirty() && (bl || pSAppSBItemBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSAppSBItemBase.getUserTag2());
        }
        if (pSAppSBItemBase.isUserTag3Dirty() && (bl || pSAppSBItemBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSAppSBItemBase.getUserTag3());
        }
        if (pSAppSBItemBase.isUserTag4Dirty() && (bl || pSAppSBItemBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSAppSBItemBase.getUserTag4());
        }
        if (pSAppSBItemBase.isValidFlagDirty() && (bl || pSAppSBItemBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSAppSBItemBase.getValidFlag());
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
        return PSAppSBItemBase.remove(this, n);
    }

    private static boolean remove(PSAppSBItemBase pSAppSBItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppSBItemBase.resetCodeName();
                return true;
            }
            case 1: {
                pSAppSBItemBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSAppSBItemBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSAppSBItemBase.resetItemTag();
                return true;
            }
            case 4: {
                pSAppSBItemBase.resetItemTag2();
                return true;
            }
            case 5: {
                pSAppSBItemBase.resetItemTag3();
                return true;
            }
            case 6: {
                pSAppSBItemBase.resetItemTag4();
                return true;
            }
            case 7: {
                pSAppSBItemBase.resetItemType();
                return true;
            }
            case 8: {
                pSAppSBItemBase.resetLeftPos();
                return true;
            }
            case 9: {
                pSAppSBItemBase.resetMemo();
                return true;
            }
            case 10: {
                pSAppSBItemBase.resetPSAppSBItemId();
                return true;
            }
            case 11: {
                pSAppSBItemBase.resetPSAppSBItemName();
                return true;
            }
            case 12: {
                pSAppSBItemBase.resetPSAppStoryBoardId();
                return true;
            }
            case 13: {
                pSAppSBItemBase.resetPSAppStoryBoardName();
                return true;
            }
            case 14: {
                pSAppSBItemBase.resetPSAppViewId();
                return true;
            }
            case 15: {
                pSAppSBItemBase.resetPSAppViewName();
                return true;
            }
            case 16: {
                pSAppSBItemBase.resetPSDynaInstId();
                return true;
            }
            case 17: {
                pSAppSBItemBase.resetPSSysAppId();
                return true;
            }
            case 18: {
                pSAppSBItemBase.resetPSSysReqItemId();
                return true;
            }
            case 19: {
                pSAppSBItemBase.resetPSSysReqItemName();
                return true;
            }
            case 20: {
                pSAppSBItemBase.resetPSSysUserCaseId();
                return true;
            }
            case 21: {
                pSAppSBItemBase.resetPSSysUserCaseName();
                return true;
            }
            case 22: {
                pSAppSBItemBase.resetRootItem();
                return true;
            }
            case 23: {
                pSAppSBItemBase.resetTopPos();
                return true;
            }
            case 24: {
                pSAppSBItemBase.resetUpdateDate();
                return true;
            }
            case 25: {
                pSAppSBItemBase.resetUpdateMan();
                return true;
            }
            case 26: {
                pSAppSBItemBase.resetUserCat();
                return true;
            }
            case 27: {
                pSAppSBItemBase.resetUserFlag();
                return true;
            }
            case 28: {
                pSAppSBItemBase.resetUserTag();
                return true;
            }
            case 29: {
                pSAppSBItemBase.resetUserTag2();
                return true;
            }
            case 30: {
                pSAppSBItemBase.resetUserTag3();
                return true;
            }
            case 31: {
                pSAppSBItemBase.resetUserTag4();
                return true;
            }
            case 32: {
                pSAppSBItemBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppStoryBoard getPSAppStoryBoard() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppStoryBoard();
        }
        if (this.getPSAppStoryBoardId() == null) {
            return null;
        }
        Integer n = this.objPSAppStoryBoardLock;
        synchronized (n) {
            if (this.psappstoryboard != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppStoryBoardId(), (Object)this.psappstoryboard.getPSAppStoryBoardId()) != 0L) {
                this.psappstoryboard = null;
            }
            if (this.psappstoryboard == null) {
                PSAppStoryBoard pSAppStoryBoard = new PSAppStoryBoard();
                pSAppStoryBoard.setPSAppStoryBoardId(this.getPSAppStoryBoardId());
                PSAppStoryBoardService pSAppStoryBoardService = (PSAppStoryBoardService)ServiceGlobal.getService(PSAppStoryBoardService.class, (SessionFactory)this.getSessionFactory());
                pSAppStoryBoardService.autoGet((IEntity)pSAppStoryBoard);
                this.psappstoryboard = pSAppStoryBoard;
            }
            return this.psappstoryboard;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppView getPSAppView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppView();
        }
        if (this.getPSAppViewId() == null) {
            return null;
        }
        Integer n = this.objPSAppViewLock;
        synchronized (n) {
            if (this.psappview != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppViewId(), (Object)this.psappview.getPSAppViewId()) != 0L) {
                this.psappview = null;
            }
            if (this.psappview == null) {
                PSAppView pSAppView = new PSAppView();
                pSAppView.setPSAppViewId(this.getPSAppViewId());
                PSAppViewService pSAppViewService = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
                pSAppViewService.autoGet((IEntity)pSAppView);
                this.psappview = pSAppView;
            }
            return this.psappview;
        }
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
                pSSysReqItemService.autoGet((IEntity)pSSysReqItem);
                this.pssysreqitem = pSSysReqItem;
            }
            return this.pssysreqitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysUserCase getPSSysUserCase() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserCase();
        }
        if (this.getPSSysUserCaseId() == null) {
            return null;
        }
        Integer n = this.objPSSysUserCaseLock;
        synchronized (n) {
            if (this.pssysusercase != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysUserCaseId(), (Object)this.pssysusercase.getPSSysUserCaseId()) != 0L) {
                this.pssysusercase = null;
            }
            if (this.pssysusercase == null) {
                PSSysUserCase pSSysUserCase = new PSSysUserCase();
                pSSysUserCase.setPSSysUserCaseId(this.getPSSysUserCaseId());
                PSSysUserCaseService pSSysUserCaseService = (PSSysUserCaseService)ServiceGlobal.getService(PSSysUserCaseService.class, (SessionFactory)this.getSessionFactory());
                pSSysUserCaseService.autoGet((IEntity)pSSysUserCase);
                this.pssysusercase = pSSysUserCase;
            }
            return this.pssysusercase;
        }
    }

    private PSAppSBItemBase getProxyEntity() {
        return this.proxyPSAppSBItemBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppSBItemBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppSBItemBase) {
            this.proxyPSAppSBItemBase = (PSAppSBItemBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppSBItemService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_ITEMTAG, 3);
        fieldIndexMap.put(FIELD_ITEMTAG2, 4);
        fieldIndexMap.put(FIELD_ITEMTAG3, 5);
        fieldIndexMap.put(FIELD_ITEMTAG4, 6);
        fieldIndexMap.put(FIELD_ITEMTYPE, 7);
        fieldIndexMap.put(FIELD_LEFTPOS, 8);
        fieldIndexMap.put(FIELD_MEMO, 9);
        fieldIndexMap.put(FIELD_PSAPPSBITEMID, 10);
        fieldIndexMap.put(FIELD_PSAPPSBITEMNAME, 11);
        fieldIndexMap.put(FIELD_PSAPPSTORYBOARDID, 12);
        fieldIndexMap.put(FIELD_PSAPPSTORYBOARDNAME, 13);
        fieldIndexMap.put(FIELD_PSAPPVIEWID, 14);
        fieldIndexMap.put(FIELD_PSAPPVIEWNAME, 15);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 16);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 17);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 18);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 19);
        fieldIndexMap.put(FIELD_PSSYSUSERCASEID, 20);
        fieldIndexMap.put(FIELD_PSSYSUSERCASENAME, 21);
        fieldIndexMap.put(FIELD_ROOTITEM, 22);
        fieldIndexMap.put(FIELD_TOPPOS, 23);
        fieldIndexMap.put(FIELD_UPDATEDATE, 24);
        fieldIndexMap.put(FIELD_UPDATEMAN, 25);
        fieldIndexMap.put(FIELD_USERCAT, 26);
        fieldIndexMap.put(FIELD_USERFLAG, 27);
        fieldIndexMap.put(FIELD_USERTAG, 28);
        fieldIndexMap.put(FIELD_USERTAG2, 29);
        fieldIndexMap.put(FIELD_USERTAG3, 30);
        fieldIndexMap.put(FIELD_USERTAG4, 31);
        fieldIndexMap.put(FIELD_VALIDFLAG, 32);
    }
}

