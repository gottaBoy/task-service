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
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnLinkBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnLinkBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LINK = "LINK";
    public static final String FIELD_LINKMDURL = "LINKMDURL";
    public static final String FIELD_LINKTYPE = "LINKTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNLINKID = "PSDEVSLNLINKID";
    public static final String FIELD_PSDEVSLNLINKNAME = "PSDEVSLNLINKNAME";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_PSDEVSLNTEMPLID = "PSDEVSLNTEMPLID";
    public static final String FIELD_PSDEVSLNTEMPLNAME = "PSDEVSLNTEMPLNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERDATA = "USERDATA";
    public static final String FIELD_USERDATA2 = "USERDATA2";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_LINK = 2;
    private static final int INDEX_LINKMDURL = 3;
    private static final int INDEX_LINKTYPE = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSDEVSLNID = 6;
    private static final int INDEX_PSDEVSLNLINKID = 7;
    private static final int INDEX_PSDEVSLNLINKNAME = 8;
    private static final int INDEX_PSDEVSLNNAME = 9;
    private static final int INDEX_PSDEVSLNSYSID = 10;
    private static final int INDEX_PSDEVSLNSYSNAME = 11;
    private static final int INDEX_PSDEVSLNTEMPLID = 12;
    private static final int INDEX_PSDEVSLNTEMPLNAME = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final int INDEX_USERDATA = 16;
    private static final int INDEX_USERDATA2 = 17;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnLinkBase proxyPSDevSlnLinkBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean linkDirtyFlag = false;
    private boolean linkmdurlDirtyFlag = false;
    private boolean linktypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnlinkidDirtyFlag = false;
    private boolean psdevslnlinknameDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean psdevslntemplidDirtyFlag = false;
    private boolean psdevslntemplnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userdataDirtyFlag = false;
    private boolean userdata2DirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="link")
    private String link;
    @Column(name="linkmdurl")
    private String linkmdurl;
    @Column(name="linktype")
    private String linktype;
    @Column(name="memo")
    private String memo;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnlinkid")
    private String psdevslnlinkid;
    @Column(name="psdevslnlinkname")
    private String psdevslnlinkname;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="psdevslntemplid")
    private String psdevslntemplid;
    @Column(name="psdevslntemplname")
    private String psdevslntemplname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userdata")
    private String userdata;
    @Column(name="userdata2")
    private String userdata2;
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;
    private Integer objPSDevSlnTemplLock = new Integer(1);
    private PSDevSlnTempl psdevslntempl = null;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;

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

    public void setLink(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLink(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.link = string;
        this.linkDirtyFlag = true;
    }

    public String getLink() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLink();
        }
        return this.link;
    }

    public boolean isLinkDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkDirty();
        }
        return this.linkDirtyFlag;
    }

    public void resetLink() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLink();
            return;
        }
        this.linkDirtyFlag = false;
        this.link = null;
    }

    public void setLinkMDUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkMDUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.linkmdurl = string;
        this.linkmdurlDirtyFlag = true;
    }

    public String getLinkMDUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkMDUrl();
        }
        return this.linkmdurl;
    }

    public boolean isLinkMDUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkMDUrlDirty();
        }
        return this.linkmdurlDirtyFlag;
    }

    public void resetLinkMDUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkMDUrl();
            return;
        }
        this.linkmdurlDirtyFlag = false;
        this.linkmdurl = null;
    }

    public void setLinkType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.linktype = string;
        this.linktypeDirtyFlag = true;
    }

    public String getLinkType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkType();
        }
        return this.linktype;
    }

    public boolean isLinkTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkTypeDirty();
        }
        return this.linktypeDirtyFlag;
    }

    public void resetLinkType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkType();
            return;
        }
        this.linktypeDirtyFlag = false;
        this.linktype = null;
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

    public void setPSDevSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnid = string;
        this.psdevslnidDirtyFlag = true;
    }

    public String getPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnId();
        }
        return this.psdevslnid;
    }

    public boolean isPSDevSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnIdDirty();
        }
        return this.psdevslnidDirtyFlag;
    }

    public void resetPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnId();
            return;
        }
        this.psdevslnidDirtyFlag = false;
        this.psdevslnid = null;
    }

    public void setPSDevSlnLinkId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnLinkId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnlinkid = string;
        this.psdevslnlinkidDirtyFlag = true;
    }

    public String getPSDevSlnLinkId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnLinkId();
        }
        return this.psdevslnlinkid;
    }

    public boolean isPSDevSlnLinkIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnLinkIdDirty();
        }
        return this.psdevslnlinkidDirtyFlag;
    }

    public void resetPSDevSlnLinkId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnLinkId();
            return;
        }
        this.psdevslnlinkidDirtyFlag = false;
        this.psdevslnlinkid = null;
    }

    public void setPSDevSlnLinkName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnLinkName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnlinkname = string;
        this.psdevslnlinknameDirtyFlag = true;
    }

    public String getPSDevSlnLinkName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnLinkName();
        }
        return this.psdevslnlinkname;
    }

    public boolean isPSDevSlnLinkNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnLinkNameDirty();
        }
        return this.psdevslnlinknameDirtyFlag;
    }

    public void resetPSDevSlnLinkName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnLinkName();
            return;
        }
        this.psdevslnlinknameDirtyFlag = false;
        this.psdevslnlinkname = null;
    }

    public void setPSDevSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnname = string;
        this.psdevslnnameDirtyFlag = true;
    }

    public String getPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnName();
        }
        return this.psdevslnname;
    }

    public boolean isPSDevSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnNameDirty();
        }
        return this.psdevslnnameDirtyFlag;
    }

    public void resetPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnName();
            return;
        }
        this.psdevslnnameDirtyFlag = false;
        this.psdevslnname = null;
    }

    public void setPSDevSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysid = string;
        this.psdevslnsysidDirtyFlag = true;
    }

    public String getPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysId();
        }
        return this.psdevslnsysid;
    }

    public boolean isPSDevSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysIdDirty();
        }
        return this.psdevslnsysidDirtyFlag;
    }

    public void resetPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysId();
            return;
        }
        this.psdevslnsysidDirtyFlag = false;
        this.psdevslnsysid = null;
    }

    public void setPSDevSlnSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysname = string;
        this.psdevslnsysnameDirtyFlag = true;
    }

    public String getPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysName();
        }
        return this.psdevslnsysname;
    }

    public boolean isPSDevSlnSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysNameDirty();
        }
        return this.psdevslnsysnameDirtyFlag;
    }

    public void resetPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysName();
            return;
        }
        this.psdevslnsysnameDirtyFlag = false;
        this.psdevslnsysname = null;
    }

    public void setPSDevSlnTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslntemplid = string;
        this.psdevslntemplidDirtyFlag = true;
    }

    public String getPSDevSlnTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnTemplId();
        }
        return this.psdevslntemplid;
    }

    public boolean isPSDevSlnTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnTemplIdDirty();
        }
        return this.psdevslntemplidDirtyFlag;
    }

    public void resetPSDevSlnTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnTemplId();
            return;
        }
        this.psdevslntemplidDirtyFlag = false;
        this.psdevslntemplid = null;
    }

    public void setPSDevSlnTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslntemplname = string;
        this.psdevslntemplnameDirtyFlag = true;
    }

    public String getPSDevSlnTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnTemplName();
        }
        return this.psdevslntemplname;
    }

    public boolean isPSDevSlnTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnTemplNameDirty();
        }
        return this.psdevslntemplnameDirtyFlag;
    }

    public void resetPSDevSlnTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnTemplName();
            return;
        }
        this.psdevslntemplnameDirtyFlag = false;
        this.psdevslntemplname = null;
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

    public void setUserData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userdata = string;
        this.userdataDirtyFlag = true;
    }

    public String getUserData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData();
        }
        return this.userdata;
    }

    public boolean isUserDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDataDirty();
        }
        return this.userdataDirtyFlag;
    }

    public void resetUserData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData();
            return;
        }
        this.userdataDirtyFlag = false;
        this.userdata = null;
    }

    public void setUserData2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userdata2 = string;
        this.userdata2DirtyFlag = true;
    }

    public String getUserData2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData2();
        }
        return this.userdata2;
    }

    public boolean isUserData2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserData2Dirty();
        }
        return this.userdata2DirtyFlag;
    }

    public void resetUserData2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData2();
            return;
        }
        this.userdata2DirtyFlag = false;
        this.userdata2 = null;
    }

    protected void onReset() {
        PSDevSlnLinkBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnLinkBase pSDevSlnLinkBase) {
        pSDevSlnLinkBase.resetCreateDate();
        pSDevSlnLinkBase.resetCreateMan();
        pSDevSlnLinkBase.resetLink();
        pSDevSlnLinkBase.resetLinkMDUrl();
        pSDevSlnLinkBase.resetLinkType();
        pSDevSlnLinkBase.resetMemo();
        pSDevSlnLinkBase.resetPSDevSlnId();
        pSDevSlnLinkBase.resetPSDevSlnLinkId();
        pSDevSlnLinkBase.resetPSDevSlnLinkName();
        pSDevSlnLinkBase.resetPSDevSlnName();
        pSDevSlnLinkBase.resetPSDevSlnSysId();
        pSDevSlnLinkBase.resetPSDevSlnSysName();
        pSDevSlnLinkBase.resetPSDevSlnTemplId();
        pSDevSlnLinkBase.resetPSDevSlnTemplName();
        pSDevSlnLinkBase.resetUpdateDate();
        pSDevSlnLinkBase.resetUpdateMan();
        pSDevSlnLinkBase.resetUserData();
        pSDevSlnLinkBase.resetUserData2();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isLinkDirty()) {
            hashMap.put(FIELD_LINK, this.getLink());
        }
        if (!bl || this.isLinkMDUrlDirty()) {
            hashMap.put(FIELD_LINKMDURL, this.getLinkMDUrl());
        }
        if (!bl || this.isLinkTypeDirty()) {
            hashMap.put(FIELD_LINKTYPE, this.getLinkType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnLinkIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNLINKID, this.getPSDevSlnLinkId());
        }
        if (!bl || this.isPSDevSlnLinkNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNLINKNAME, this.getPSDevSlnLinkName());
        }
        if (!bl || this.isPSDevSlnNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNNAME, this.getPSDevSlnName());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSNAME, this.getPSDevSlnSysName());
        }
        if (!bl || this.isPSDevSlnTemplIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNTEMPLID, this.getPSDevSlnTemplId());
        }
        if (!bl || this.isPSDevSlnTemplNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNTEMPLNAME, this.getPSDevSlnTemplName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserDataDirty()) {
            hashMap.put(FIELD_USERDATA, this.getUserData());
        }
        if (!bl || this.isUserData2Dirty()) {
            hashMap.put(FIELD_USERDATA2, this.getUserData2());
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
        return PSDevSlnLinkBase.get(this, n);
    }

    private static Object get(PSDevSlnLinkBase pSDevSlnLinkBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnLinkBase.getCreateDate();
            }
            case 1: {
                return pSDevSlnLinkBase.getCreateMan();
            }
            case 2: {
                return pSDevSlnLinkBase.getLink();
            }
            case 3: {
                return pSDevSlnLinkBase.getLinkMDUrl();
            }
            case 4: {
                return pSDevSlnLinkBase.getLinkType();
            }
            case 5: {
                return pSDevSlnLinkBase.getMemo();
            }
            case 6: {
                return pSDevSlnLinkBase.getPSDevSlnId();
            }
            case 7: {
                return pSDevSlnLinkBase.getPSDevSlnLinkId();
            }
            case 8: {
                return pSDevSlnLinkBase.getPSDevSlnLinkName();
            }
            case 9: {
                return pSDevSlnLinkBase.getPSDevSlnName();
            }
            case 10: {
                return pSDevSlnLinkBase.getPSDevSlnSysId();
            }
            case 11: {
                return pSDevSlnLinkBase.getPSDevSlnSysName();
            }
            case 12: {
                return pSDevSlnLinkBase.getPSDevSlnTemplId();
            }
            case 13: {
                return pSDevSlnLinkBase.getPSDevSlnTemplName();
            }
            case 14: {
                return pSDevSlnLinkBase.getUpdateDate();
            }
            case 15: {
                return pSDevSlnLinkBase.getUpdateMan();
            }
            case 16: {
                return pSDevSlnLinkBase.getUserData();
            }
            case 17: {
                return pSDevSlnLinkBase.getUserData2();
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
        PSDevSlnLinkBase.set(this, n, object);
    }

    private static void set(PSDevSlnLinkBase pSDevSlnLinkBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnLinkBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnLinkBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnLinkBase.setLink(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnLinkBase.setLinkMDUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnLinkBase.setLinkType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnLinkBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnLinkBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnLinkBase.setPSDevSlnLinkId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnLinkBase.setPSDevSlnLinkName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnLinkBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnLinkBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnLinkBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnLinkBase.setPSDevSlnTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevSlnLinkBase.setPSDevSlnTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevSlnLinkBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSDevSlnLinkBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevSlnLinkBase.setUserData(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDevSlnLinkBase.setUserData2(DataObject.getStringValue((Object)object));
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
        return PSDevSlnLinkBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnLinkBase pSDevSlnLinkBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnLinkBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevSlnLinkBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevSlnLinkBase.getLink() == null;
            }
            case 3: {
                return pSDevSlnLinkBase.getLinkMDUrl() == null;
            }
            case 4: {
                return pSDevSlnLinkBase.getLinkType() == null;
            }
            case 5: {
                return pSDevSlnLinkBase.getMemo() == null;
            }
            case 6: {
                return pSDevSlnLinkBase.getPSDevSlnId() == null;
            }
            case 7: {
                return pSDevSlnLinkBase.getPSDevSlnLinkId() == null;
            }
            case 8: {
                return pSDevSlnLinkBase.getPSDevSlnLinkName() == null;
            }
            case 9: {
                return pSDevSlnLinkBase.getPSDevSlnName() == null;
            }
            case 10: {
                return pSDevSlnLinkBase.getPSDevSlnSysId() == null;
            }
            case 11: {
                return pSDevSlnLinkBase.getPSDevSlnSysName() == null;
            }
            case 12: {
                return pSDevSlnLinkBase.getPSDevSlnTemplId() == null;
            }
            case 13: {
                return pSDevSlnLinkBase.getPSDevSlnTemplName() == null;
            }
            case 14: {
                return pSDevSlnLinkBase.getUpdateDate() == null;
            }
            case 15: {
                return pSDevSlnLinkBase.getUpdateMan() == null;
            }
            case 16: {
                return pSDevSlnLinkBase.getUserData() == null;
            }
            case 17: {
                return pSDevSlnLinkBase.getUserData2() == null;
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
        return PSDevSlnLinkBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnLinkBase pSDevSlnLinkBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnLinkBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevSlnLinkBase.isCreateManDirty();
            }
            case 2: {
                return pSDevSlnLinkBase.isLinkDirty();
            }
            case 3: {
                return pSDevSlnLinkBase.isLinkMDUrlDirty();
            }
            case 4: {
                return pSDevSlnLinkBase.isLinkTypeDirty();
            }
            case 5: {
                return pSDevSlnLinkBase.isMemoDirty();
            }
            case 6: {
                return pSDevSlnLinkBase.isPSDevSlnIdDirty();
            }
            case 7: {
                return pSDevSlnLinkBase.isPSDevSlnLinkIdDirty();
            }
            case 8: {
                return pSDevSlnLinkBase.isPSDevSlnLinkNameDirty();
            }
            case 9: {
                return pSDevSlnLinkBase.isPSDevSlnNameDirty();
            }
            case 10: {
                return pSDevSlnLinkBase.isPSDevSlnSysIdDirty();
            }
            case 11: {
                return pSDevSlnLinkBase.isPSDevSlnSysNameDirty();
            }
            case 12: {
                return pSDevSlnLinkBase.isPSDevSlnTemplIdDirty();
            }
            case 13: {
                return pSDevSlnLinkBase.isPSDevSlnTemplNameDirty();
            }
            case 14: {
                return pSDevSlnLinkBase.isUpdateDateDirty();
            }
            case 15: {
                return pSDevSlnLinkBase.isUpdateManDirty();
            }
            case 16: {
                return pSDevSlnLinkBase.isUserDataDirty();
            }
            case 17: {
                return pSDevSlnLinkBase.isUserData2Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnLinkBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnLinkBase pSDevSlnLinkBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnLinkBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnLinkBase.getJSONValue((Object)pSDevSlnLinkBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnLinkBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnLinkBase.getJSONValue((Object)pSDevSlnLinkBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnLinkBase.getLink() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"link", (Object)PSDevSlnLinkBase.getJSONValue((Object)pSDevSlnLinkBase.getLink()), (boolean)false);
        }
        if (bl || pSDevSlnLinkBase.getLinkMDUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkmdurl", (Object)PSDevSlnLinkBase.getJSONValue((Object)pSDevSlnLinkBase.getLinkMDUrl()), (boolean)false);
        }
        if (bl || pSDevSlnLinkBase.getLinkType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linktype", (Object)PSDevSlnLinkBase.getJSONValue((Object)pSDevSlnLinkBase.getLinkType()), (boolean)false);
        }
        if (bl || pSDevSlnLinkBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSlnLinkBase.getJSONValue((Object)pSDevSlnLinkBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSlnLinkBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDevSlnLinkBase.getJSONValue((Object)pSDevSlnLinkBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDevSlnLinkBase.getPSDevSlnLinkId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnlinkid", (Object)PSDevSlnLinkBase.getJSONValue((Object)pSDevSlnLinkBase.getPSDevSlnLinkId()), (boolean)false);
        }
        if (bl || pSDevSlnLinkBase.getPSDevSlnLinkName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnlinkname", (Object)PSDevSlnLinkBase.getJSONValue((Object)pSDevSlnLinkBase.getPSDevSlnLinkName()), (boolean)false);
        }
        if (bl || pSDevSlnLinkBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDevSlnLinkBase.getJSONValue((Object)pSDevSlnLinkBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDevSlnLinkBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDevSlnLinkBase.getJSONValue((Object)pSDevSlnLinkBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevSlnLinkBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSDevSlnLinkBase.getJSONValue((Object)pSDevSlnLinkBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDevSlnLinkBase.getPSDevSlnTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslntemplid", (Object)PSDevSlnLinkBase.getJSONValue((Object)pSDevSlnLinkBase.getPSDevSlnTemplId()), (boolean)false);
        }
        if (bl || pSDevSlnLinkBase.getPSDevSlnTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslntemplname", (Object)PSDevSlnLinkBase.getJSONValue((Object)pSDevSlnLinkBase.getPSDevSlnTemplName()), (boolean)false);
        }
        if (bl || pSDevSlnLinkBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnLinkBase.getJSONValue((Object)pSDevSlnLinkBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnLinkBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnLinkBase.getJSONValue((Object)pSDevSlnLinkBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevSlnLinkBase.getUserData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userdata", (Object)PSDevSlnLinkBase.getJSONValue((Object)pSDevSlnLinkBase.getUserData()), (boolean)false);
        }
        if (bl || pSDevSlnLinkBase.getUserData2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userdata2", (Object)PSDevSlnLinkBase.getJSONValue((Object)pSDevSlnLinkBase.getUserData2()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnLinkBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnLinkBase pSDevSlnLinkBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnLinkBase.getCreateDate() != null) {
            object = pSDevSlnLinkBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnLinkBase.getCreateMan() != null) {
            object = pSDevSlnLinkBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnLinkBase.getLink() != null) {
            object = pSDevSlnLinkBase.getLink();
            xmlNode.setAttribute(FIELD_LINK, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnLinkBase.getLinkMDUrl() != null) {
            object = pSDevSlnLinkBase.getLinkMDUrl();
            xmlNode.setAttribute(FIELD_LINKMDURL, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnLinkBase.getLinkType() != null) {
            object = pSDevSlnLinkBase.getLinkType();
            xmlNode.setAttribute(FIELD_LINKTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnLinkBase.getMemo() != null) {
            object = pSDevSlnLinkBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnLinkBase.getPSDevSlnId() != null) {
            object = pSDevSlnLinkBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnLinkBase.getPSDevSlnLinkId() != null) {
            object = pSDevSlnLinkBase.getPSDevSlnLinkId();
            xmlNode.setAttribute(FIELD_PSDEVSLNLINKID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnLinkBase.getPSDevSlnLinkName() != null) {
            object = pSDevSlnLinkBase.getPSDevSlnLinkName();
            xmlNode.setAttribute(FIELD_PSDEVSLNLINKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnLinkBase.getPSDevSlnName() != null) {
            object = pSDevSlnLinkBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnLinkBase.getPSDevSlnSysId() != null) {
            object = pSDevSlnLinkBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnLinkBase.getPSDevSlnSysName() != null) {
            object = pSDevSlnLinkBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnLinkBase.getPSDevSlnTemplId() != null) {
            object = pSDevSlnLinkBase.getPSDevSlnTemplId();
            xmlNode.setAttribute(FIELD_PSDEVSLNTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnLinkBase.getPSDevSlnTemplName() != null) {
            object = pSDevSlnLinkBase.getPSDevSlnTemplName();
            xmlNode.setAttribute(FIELD_PSDEVSLNTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnLinkBase.getUpdateDate() != null) {
            object = pSDevSlnLinkBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnLinkBase.getUpdateMan() != null) {
            object = pSDevSlnLinkBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnLinkBase.getUserData() != null) {
            object = pSDevSlnLinkBase.getUserData();
            xmlNode.setAttribute(FIELD_USERDATA, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnLinkBase.getUserData2() != null) {
            object = pSDevSlnLinkBase.getUserData2();
            xmlNode.setAttribute(FIELD_USERDATA2, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnLinkBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnLinkBase pSDevSlnLinkBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnLinkBase.isCreateDateDirty() && (bl || pSDevSlnLinkBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnLinkBase.getCreateDate());
        }
        if (pSDevSlnLinkBase.isCreateManDirty() && (bl || pSDevSlnLinkBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnLinkBase.getCreateMan());
        }
        if (pSDevSlnLinkBase.isLinkDirty() && (bl || pSDevSlnLinkBase.getLink() != null)) {
            iDataObject.set(FIELD_LINK, (Object)pSDevSlnLinkBase.getLink());
        }
        if (pSDevSlnLinkBase.isLinkMDUrlDirty() && (bl || pSDevSlnLinkBase.getLinkMDUrl() != null)) {
            iDataObject.set(FIELD_LINKMDURL, (Object)pSDevSlnLinkBase.getLinkMDUrl());
        }
        if (pSDevSlnLinkBase.isLinkTypeDirty() && (bl || pSDevSlnLinkBase.getLinkType() != null)) {
            iDataObject.set(FIELD_LINKTYPE, (Object)pSDevSlnLinkBase.getLinkType());
        }
        if (pSDevSlnLinkBase.isMemoDirty() && (bl || pSDevSlnLinkBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSlnLinkBase.getMemo());
        }
        if (pSDevSlnLinkBase.isPSDevSlnIdDirty() && (bl || pSDevSlnLinkBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDevSlnLinkBase.getPSDevSlnId());
        }
        if (pSDevSlnLinkBase.isPSDevSlnLinkIdDirty() && (bl || pSDevSlnLinkBase.getPSDevSlnLinkId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNLINKID, (Object)pSDevSlnLinkBase.getPSDevSlnLinkId());
        }
        if (pSDevSlnLinkBase.isPSDevSlnLinkNameDirty() && (bl || pSDevSlnLinkBase.getPSDevSlnLinkName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNLINKNAME, (Object)pSDevSlnLinkBase.getPSDevSlnLinkName());
        }
        if (pSDevSlnLinkBase.isPSDevSlnNameDirty() && (bl || pSDevSlnLinkBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDevSlnLinkBase.getPSDevSlnName());
        }
        if (pSDevSlnLinkBase.isPSDevSlnSysIdDirty() && (bl || pSDevSlnLinkBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDevSlnLinkBase.getPSDevSlnSysId());
        }
        if (pSDevSlnLinkBase.isPSDevSlnSysNameDirty() && (bl || pSDevSlnLinkBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSDevSlnLinkBase.getPSDevSlnSysName());
        }
        if (pSDevSlnLinkBase.isPSDevSlnTemplIdDirty() && (bl || pSDevSlnLinkBase.getPSDevSlnTemplId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNTEMPLID, (Object)pSDevSlnLinkBase.getPSDevSlnTemplId());
        }
        if (pSDevSlnLinkBase.isPSDevSlnTemplNameDirty() && (bl || pSDevSlnLinkBase.getPSDevSlnTemplName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNTEMPLNAME, (Object)pSDevSlnLinkBase.getPSDevSlnTemplName());
        }
        if (pSDevSlnLinkBase.isUpdateDateDirty() && (bl || pSDevSlnLinkBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnLinkBase.getUpdateDate());
        }
        if (pSDevSlnLinkBase.isUpdateManDirty() && (bl || pSDevSlnLinkBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnLinkBase.getUpdateMan());
        }
        if (pSDevSlnLinkBase.isUserDataDirty() && (bl || pSDevSlnLinkBase.getUserData() != null)) {
            iDataObject.set(FIELD_USERDATA, (Object)pSDevSlnLinkBase.getUserData());
        }
        if (pSDevSlnLinkBase.isUserData2Dirty() && (bl || pSDevSlnLinkBase.getUserData2() != null)) {
            iDataObject.set(FIELD_USERDATA2, (Object)pSDevSlnLinkBase.getUserData2());
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
        return PSDevSlnLinkBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnLinkBase pSDevSlnLinkBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnLinkBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevSlnLinkBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevSlnLinkBase.resetLink();
                return true;
            }
            case 3: {
                pSDevSlnLinkBase.resetLinkMDUrl();
                return true;
            }
            case 4: {
                pSDevSlnLinkBase.resetLinkType();
                return true;
            }
            case 5: {
                pSDevSlnLinkBase.resetMemo();
                return true;
            }
            case 6: {
                pSDevSlnLinkBase.resetPSDevSlnId();
                return true;
            }
            case 7: {
                pSDevSlnLinkBase.resetPSDevSlnLinkId();
                return true;
            }
            case 8: {
                pSDevSlnLinkBase.resetPSDevSlnLinkName();
                return true;
            }
            case 9: {
                pSDevSlnLinkBase.resetPSDevSlnName();
                return true;
            }
            case 10: {
                pSDevSlnLinkBase.resetPSDevSlnSysId();
                return true;
            }
            case 11: {
                pSDevSlnLinkBase.resetPSDevSlnSysName();
                return true;
            }
            case 12: {
                pSDevSlnLinkBase.resetPSDevSlnTemplId();
                return true;
            }
            case 13: {
                pSDevSlnLinkBase.resetPSDevSlnTemplName();
                return true;
            }
            case 14: {
                pSDevSlnLinkBase.resetUpdateDate();
                return true;
            }
            case 15: {
                pSDevSlnLinkBase.resetUpdateMan();
                return true;
            }
            case 16: {
                pSDevSlnLinkBase.resetUserData();
                return true;
            }
            case 17: {
                pSDevSlnLinkBase.resetUserData2();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSys getPSDevSlnSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSys();
        }
        if (this.getPSDevSlnSysId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysLock;
        synchronized (n) {
            if (this.psdevslnsys != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysId(), (Object)this.psdevslnsys.getPSDevSlnSysId()) != 0L) {
                this.psdevslnsys = null;
            }
            if (this.psdevslnsys == null) {
                PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
                pSDevSlnSys.setPSDevSlnSysId(this.getPSDevSlnSysId());
                PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysService.autoGet((IEntity)pSDevSlnSys);
                this.psdevslnsys = pSDevSlnSys;
            }
            return this.psdevslnsys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnTempl getPSDevSlnTempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnTempl();
        }
        if (this.getPSDevSlnTemplId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnTemplLock;
        synchronized (n) {
            if (this.psdevslntempl != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnTemplId(), (Object)this.psdevslntempl.getPSDevSlnTemplId()) != 0L) {
                this.psdevslntempl = null;
            }
            if (this.psdevslntempl == null) {
                PSDevSlnTempl pSDevSlnTempl = new PSDevSlnTempl();
                pSDevSlnTempl.setPSDevSlnTemplId(this.getPSDevSlnTemplId());
                PSDevSlnTemplService pSDevSlnTemplService = (PSDevSlnTemplService)ServiceGlobal.getService(PSDevSlnTemplService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnTemplService.autoGet((IEntity)pSDevSlnTempl);
                this.psdevslntempl = pSDevSlnTempl;
            }
            return this.psdevslntempl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSln getPSDevSln() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSln();
        }
        if (this.getPSDevSlnId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnLock;
        synchronized (n) {
            if (this.psdevsln != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnId(), (Object)this.psdevsln.getPSDevSlnId()) != 0L) {
                this.psdevsln = null;
            }
            if (this.psdevsln == null) {
                PSDevSln pSDevSln = new PSDevSln();
                pSDevSln.setPSDevSlnId(this.getPSDevSlnId());
                PSDevSlnService pSDevSlnService = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnService.autoGet((IEntity)pSDevSln);
                this.psdevsln = pSDevSln;
            }
            return this.psdevsln;
        }
    }

    private PSDevSlnLinkBase getProxyEntity() {
        return this.proxyPSDevSlnLinkBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnLinkBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnLinkBase) {
            this.proxyPSDevSlnLinkBase = (PSDevSlnLinkBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnLinkService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_LINK, 2);
        fieldIndexMap.put(FIELD_LINKMDURL, 3);
        fieldIndexMap.put(FIELD_LINKTYPE, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 6);
        fieldIndexMap.put(FIELD_PSDEVSLNLINKID, 7);
        fieldIndexMap.put(FIELD_PSDEVSLNLINKNAME, 8);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 9);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 10);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 11);
        fieldIndexMap.put(FIELD_PSDEVSLNTEMPLID, 12);
        fieldIndexMap.put(FIELD_PSDEVSLNTEMPLNAME, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
        fieldIndexMap.put(FIELD_USERDATA, 16);
        fieldIndexMap.put(FIELD_USERDATA2, 17);
    }
}

