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
package net.ibizsys.pscore.srv.dedesign.entity;

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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMainState;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEMSActionBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEMSActionBase.class);
    public static final String FIELD_ALLOWMODE = "ALLOWMODE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEACTIONID = "PSDEACTIONID";
    public static final String FIELD_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDEMSACTIONID = "PSDEMSACTIONID";
    public static final String FIELD_PSDEMSACTIONNAME = "PSDEMSACTIONNAME";
    public static final String FIELD_PSDEMSID = "PSDEMSID";
    public static final String FIELD_PSDEMSNAME = "PSDEMSNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ALLOWMODE = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSDEACTIONID = 4;
    private static final int INDEX_PSDEACTIONNAME = 5;
    private static final int INDEX_PSDEID = 6;
    private static final int INDEX_PSDEMSACTIONID = 7;
    private static final int INDEX_PSDEMSACTIONNAME = 8;
    private static final int INDEX_PSDEMSID = 9;
    private static final int INDEX_PSDEMSNAME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_USERCAT = 13;
    private static final int INDEX_USERTAG = 14;
    private static final int INDEX_USERTAG2 = 15;
    private static final int INDEX_USERTAG3 = 16;
    private static final int INDEX_USERTAG4 = 17;
    private static final int INDEX_VALIDFLAG = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEMSActionBase proxyPSDEMSActionBase = null;
    private boolean allowmodeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeactionidDirtyFlag = false;
    private boolean psdeactionnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdemsactionidDirtyFlag = false;
    private boolean psdemsactionnameDirtyFlag = false;
    private boolean psdemsidDirtyFlag = false;
    private boolean psdemsnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="allowmode")
    private String allowmode;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdeactionid")
    private String psdeactionid;
    @Column(name="psdeactionname")
    private String psdeactionname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdemsactionid")
    private String psdemsactionid;
    @Column(name="psdemsactionname")
    private String psdemsactionname;
    @Column(name="psdemsid")
    private String psdemsid;
    @Column(name="psdemsname")
    private String psdemsname;
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
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDEActionLock = new Integer(1);
    private PSDEAction psdeaction = null;
    private Integer objPSDEMSLock = new Integer(1);
    private PSDEMainState psdems = null;

    public void setAllowMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAllowMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.allowmode = string;
        this.allowmodeDirtyFlag = true;
    }

    public String getAllowMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAllowMode();
        }
        return this.allowmode;
    }

    public boolean isAllowModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAllowModeDirty();
        }
        return this.allowmodeDirtyFlag;
    }

    public void resetAllowMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAllowMode();
            return;
        }
        this.allowmodeDirtyFlag = false;
        this.allowmode = null;
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

    public void setPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactionid = string;
        this.psdeactionidDirtyFlag = true;
    }

    public String getPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionId();
        }
        return this.psdeactionid;
    }

    public boolean isPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionIdDirty();
        }
        return this.psdeactionidDirtyFlag;
    }

    public void resetPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionId();
            return;
        }
        this.psdeactionidDirtyFlag = false;
        this.psdeactionid = null;
    }

    public void setPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactionname = string;
        this.psdeactionnameDirtyFlag = true;
    }

    public String getPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionName();
        }
        return this.psdeactionname;
    }

    public boolean isPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionNameDirty();
        }
        return this.psdeactionnameDirtyFlag;
    }

    public void resetPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionName();
            return;
        }
        this.psdeactionnameDirtyFlag = false;
        this.psdeactionname = null;
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

    public void setPSDEMSActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMSActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemsactionid = string;
        this.psdemsactionidDirtyFlag = true;
    }

    public String getPSDEMSActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMSActionId();
        }
        return this.psdemsactionid;
    }

    public boolean isPSDEMSActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMSActionIdDirty();
        }
        return this.psdemsactionidDirtyFlag;
    }

    public void resetPSDEMSActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMSActionId();
            return;
        }
        this.psdemsactionidDirtyFlag = false;
        this.psdemsactionid = null;
    }

    public void setPSDEMSActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMSActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemsactionname = string;
        this.psdemsactionnameDirtyFlag = true;
    }

    public String getPSDEMSActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMSActionName();
        }
        return this.psdemsactionname;
    }

    public boolean isPSDEMSActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMSActionNameDirty();
        }
        return this.psdemsactionnameDirtyFlag;
    }

    public void resetPSDEMSActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMSActionName();
            return;
        }
        this.psdemsactionnameDirtyFlag = false;
        this.psdemsactionname = null;
    }

    public void setPSDEMSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemsid = string;
        this.psdemsidDirtyFlag = true;
    }

    public String getPSDEMSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMSId();
        }
        return this.psdemsid;
    }

    public boolean isPSDEMSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMSIdDirty();
        }
        return this.psdemsidDirtyFlag;
    }

    public void resetPSDEMSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMSId();
            return;
        }
        this.psdemsidDirtyFlag = false;
        this.psdemsid = null;
    }

    public void setPSDEMSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemsname = string;
        this.psdemsnameDirtyFlag = true;
    }

    public String getPSDEMSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMSName();
        }
        return this.psdemsname;
    }

    public boolean isPSDEMSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMSNameDirty();
        }
        return this.psdemsnameDirtyFlag;
    }

    public void resetPSDEMSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMSName();
            return;
        }
        this.psdemsnameDirtyFlag = false;
        this.psdemsname = null;
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
        PSDEMSActionBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEMSActionBase pSDEMSActionBase) {
        pSDEMSActionBase.resetAllowMode();
        pSDEMSActionBase.resetCreateDate();
        pSDEMSActionBase.resetCreateMan();
        pSDEMSActionBase.resetMemo();
        pSDEMSActionBase.resetPSDEActionId();
        pSDEMSActionBase.resetPSDEActionName();
        pSDEMSActionBase.resetPSDEId();
        pSDEMSActionBase.resetPSDEMSActionId();
        pSDEMSActionBase.resetPSDEMSActionName();
        pSDEMSActionBase.resetPSDEMSId();
        pSDEMSActionBase.resetPSDEMSName();
        pSDEMSActionBase.resetUpdateDate();
        pSDEMSActionBase.resetUpdateMan();
        pSDEMSActionBase.resetUserCat();
        pSDEMSActionBase.resetUserTag();
        pSDEMSActionBase.resetUserTag2();
        pSDEMSActionBase.resetUserTag3();
        pSDEMSActionBase.resetUserTag4();
        pSDEMSActionBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAllowModeDirty()) {
            hashMap.put(FIELD_ALLOWMODE, this.getAllowMode());
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
        if (!bl || this.isPSDEActionIdDirty()) {
            hashMap.put(FIELD_PSDEACTIONID, this.getPSDEActionId());
        }
        if (!bl || this.isPSDEActionNameDirty()) {
            hashMap.put(FIELD_PSDEACTIONNAME, this.getPSDEActionName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDEMSActionIdDirty()) {
            hashMap.put(FIELD_PSDEMSACTIONID, this.getPSDEMSActionId());
        }
        if (!bl || this.isPSDEMSActionNameDirty()) {
            hashMap.put(FIELD_PSDEMSACTIONNAME, this.getPSDEMSActionName());
        }
        if (!bl || this.isPSDEMSIdDirty()) {
            hashMap.put(FIELD_PSDEMSID, this.getPSDEMSId());
        }
        if (!bl || this.isPSDEMSNameDirty()) {
            hashMap.put(FIELD_PSDEMSNAME, this.getPSDEMSName());
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
        return PSDEMSActionBase.get(this, n);
    }

    private static Object get(PSDEMSActionBase pSDEMSActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEMSActionBase.getAllowMode();
            }
            case 1: {
                return pSDEMSActionBase.getCreateDate();
            }
            case 2: {
                return pSDEMSActionBase.getCreateMan();
            }
            case 3: {
                return pSDEMSActionBase.getMemo();
            }
            case 4: {
                return pSDEMSActionBase.getPSDEActionId();
            }
            case 5: {
                return pSDEMSActionBase.getPSDEActionName();
            }
            case 6: {
                return pSDEMSActionBase.getPSDEId();
            }
            case 7: {
                return pSDEMSActionBase.getPSDEMSActionId();
            }
            case 8: {
                return pSDEMSActionBase.getPSDEMSActionName();
            }
            case 9: {
                return pSDEMSActionBase.getPSDEMSId();
            }
            case 10: {
                return pSDEMSActionBase.getPSDEMSName();
            }
            case 11: {
                return pSDEMSActionBase.getUpdateDate();
            }
            case 12: {
                return pSDEMSActionBase.getUpdateMan();
            }
            case 13: {
                return pSDEMSActionBase.getUserCat();
            }
            case 14: {
                return pSDEMSActionBase.getUserTag();
            }
            case 15: {
                return pSDEMSActionBase.getUserTag2();
            }
            case 16: {
                return pSDEMSActionBase.getUserTag3();
            }
            case 17: {
                return pSDEMSActionBase.getUserTag4();
            }
            case 18: {
                return pSDEMSActionBase.getValidFlag();
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
        PSDEMSActionBase.set(this, n, object);
    }

    private static void set(PSDEMSActionBase pSDEMSActionBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEMSActionBase.setAllowMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEMSActionBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDEMSActionBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEMSActionBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEMSActionBase.setPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEMSActionBase.setPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEMSActionBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEMSActionBase.setPSDEMSActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEMSActionBase.setPSDEMSActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEMSActionBase.setPSDEMSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEMSActionBase.setPSDEMSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEMSActionBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSDEMSActionBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEMSActionBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEMSActionBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEMSActionBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEMSActionBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEMSActionBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEMSActionBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEMSActionBase.isNull(this, n);
    }

    private static boolean isNull(PSDEMSActionBase pSDEMSActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEMSActionBase.getAllowMode() == null;
            }
            case 1: {
                return pSDEMSActionBase.getCreateDate() == null;
            }
            case 2: {
                return pSDEMSActionBase.getCreateMan() == null;
            }
            case 3: {
                return pSDEMSActionBase.getMemo() == null;
            }
            case 4: {
                return pSDEMSActionBase.getPSDEActionId() == null;
            }
            case 5: {
                return pSDEMSActionBase.getPSDEActionName() == null;
            }
            case 6: {
                return pSDEMSActionBase.getPSDEId() == null;
            }
            case 7: {
                return pSDEMSActionBase.getPSDEMSActionId() == null;
            }
            case 8: {
                return pSDEMSActionBase.getPSDEMSActionName() == null;
            }
            case 9: {
                return pSDEMSActionBase.getPSDEMSId() == null;
            }
            case 10: {
                return pSDEMSActionBase.getPSDEMSName() == null;
            }
            case 11: {
                return pSDEMSActionBase.getUpdateDate() == null;
            }
            case 12: {
                return pSDEMSActionBase.getUpdateMan() == null;
            }
            case 13: {
                return pSDEMSActionBase.getUserCat() == null;
            }
            case 14: {
                return pSDEMSActionBase.getUserTag() == null;
            }
            case 15: {
                return pSDEMSActionBase.getUserTag2() == null;
            }
            case 16: {
                return pSDEMSActionBase.getUserTag3() == null;
            }
            case 17: {
                return pSDEMSActionBase.getUserTag4() == null;
            }
            case 18: {
                return pSDEMSActionBase.getValidFlag() == null;
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
        return PSDEMSActionBase.contains(this, n);
    }

    private static boolean contains(PSDEMSActionBase pSDEMSActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEMSActionBase.isAllowModeDirty();
            }
            case 1: {
                return pSDEMSActionBase.isCreateDateDirty();
            }
            case 2: {
                return pSDEMSActionBase.isCreateManDirty();
            }
            case 3: {
                return pSDEMSActionBase.isMemoDirty();
            }
            case 4: {
                return pSDEMSActionBase.isPSDEActionIdDirty();
            }
            case 5: {
                return pSDEMSActionBase.isPSDEActionNameDirty();
            }
            case 6: {
                return pSDEMSActionBase.isPSDEIdDirty();
            }
            case 7: {
                return pSDEMSActionBase.isPSDEMSActionIdDirty();
            }
            case 8: {
                return pSDEMSActionBase.isPSDEMSActionNameDirty();
            }
            case 9: {
                return pSDEMSActionBase.isPSDEMSIdDirty();
            }
            case 10: {
                return pSDEMSActionBase.isPSDEMSNameDirty();
            }
            case 11: {
                return pSDEMSActionBase.isUpdateDateDirty();
            }
            case 12: {
                return pSDEMSActionBase.isUpdateManDirty();
            }
            case 13: {
                return pSDEMSActionBase.isUserCatDirty();
            }
            case 14: {
                return pSDEMSActionBase.isUserTagDirty();
            }
            case 15: {
                return pSDEMSActionBase.isUserTag2Dirty();
            }
            case 16: {
                return pSDEMSActionBase.isUserTag3Dirty();
            }
            case 17: {
                return pSDEMSActionBase.isUserTag4Dirty();
            }
            case 18: {
                return pSDEMSActionBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEMSActionBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEMSActionBase pSDEMSActionBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEMSActionBase.getAllowMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"allowmode", (Object)PSDEMSActionBase.getJSONValue((Object)pSDEMSActionBase.getAllowMode()), (boolean)false);
        }
        if (bl || pSDEMSActionBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEMSActionBase.getJSONValue((Object)pSDEMSActionBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEMSActionBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEMSActionBase.getJSONValue((Object)pSDEMSActionBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEMSActionBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEMSActionBase.getJSONValue((Object)pSDEMSActionBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEMSActionBase.getPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionid", (Object)PSDEMSActionBase.getJSONValue((Object)pSDEMSActionBase.getPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEMSActionBase.getPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionname", (Object)PSDEMSActionBase.getJSONValue((Object)pSDEMSActionBase.getPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEMSActionBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEMSActionBase.getJSONValue((Object)pSDEMSActionBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEMSActionBase.getPSDEMSActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemsactionid", (Object)PSDEMSActionBase.getJSONValue((Object)pSDEMSActionBase.getPSDEMSActionId()), (boolean)false);
        }
        if (bl || pSDEMSActionBase.getPSDEMSActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemsactionname", (Object)PSDEMSActionBase.getJSONValue((Object)pSDEMSActionBase.getPSDEMSActionName()), (boolean)false);
        }
        if (bl || pSDEMSActionBase.getPSDEMSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemsid", (Object)PSDEMSActionBase.getJSONValue((Object)pSDEMSActionBase.getPSDEMSId()), (boolean)false);
        }
        if (bl || pSDEMSActionBase.getPSDEMSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemsname", (Object)PSDEMSActionBase.getJSONValue((Object)pSDEMSActionBase.getPSDEMSName()), (boolean)false);
        }
        if (bl || pSDEMSActionBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEMSActionBase.getJSONValue((Object)pSDEMSActionBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEMSActionBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEMSActionBase.getJSONValue((Object)pSDEMSActionBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEMSActionBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEMSActionBase.getJSONValue((Object)pSDEMSActionBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEMSActionBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEMSActionBase.getJSONValue((Object)pSDEMSActionBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEMSActionBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEMSActionBase.getJSONValue((Object)pSDEMSActionBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEMSActionBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEMSActionBase.getJSONValue((Object)pSDEMSActionBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEMSActionBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEMSActionBase.getJSONValue((Object)pSDEMSActionBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEMSActionBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEMSActionBase.getJSONValue((Object)pSDEMSActionBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEMSActionBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEMSActionBase pSDEMSActionBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEMSActionBase.getAllowMode() != null) {
            object = pSDEMSActionBase.getAllowMode();
            xmlNode.setAttribute(FIELD_ALLOWMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSActionBase.getCreateDate() != null) {
            object = pSDEMSActionBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEMSActionBase.getCreateMan() != null) {
            object = pSDEMSActionBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSActionBase.getMemo() != null) {
            object = pSDEMSActionBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSActionBase.getPSDEActionId() != null) {
            object = pSDEMSActionBase.getPSDEActionId();
            xmlNode.setAttribute(FIELD_PSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSActionBase.getPSDEActionName() != null) {
            object = pSDEMSActionBase.getPSDEActionName();
            xmlNode.setAttribute(FIELD_PSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSActionBase.getPSDEId() != null) {
            object = pSDEMSActionBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSActionBase.getPSDEMSActionId() != null) {
            object = pSDEMSActionBase.getPSDEMSActionId();
            xmlNode.setAttribute(FIELD_PSDEMSACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSActionBase.getPSDEMSActionName() != null) {
            object = pSDEMSActionBase.getPSDEMSActionName();
            xmlNode.setAttribute(FIELD_PSDEMSACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSActionBase.getPSDEMSId() != null) {
            object = pSDEMSActionBase.getPSDEMSId();
            xmlNode.setAttribute(FIELD_PSDEMSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSActionBase.getPSDEMSName() != null) {
            object = pSDEMSActionBase.getPSDEMSName();
            xmlNode.setAttribute(FIELD_PSDEMSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSActionBase.getUpdateDate() != null) {
            object = pSDEMSActionBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEMSActionBase.getUpdateMan() != null) {
            object = pSDEMSActionBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSActionBase.getUserCat() != null) {
            object = pSDEMSActionBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSActionBase.getUserTag() != null) {
            object = pSDEMSActionBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSActionBase.getUserTag2() != null) {
            object = pSDEMSActionBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSActionBase.getUserTag3() != null) {
            object = pSDEMSActionBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSActionBase.getUserTag4() != null) {
            object = pSDEMSActionBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSActionBase.getValidFlag() != null) {
            object = pSDEMSActionBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEMSActionBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEMSActionBase pSDEMSActionBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEMSActionBase.isAllowModeDirty() && (bl || pSDEMSActionBase.getAllowMode() != null)) {
            iDataObject.set(FIELD_ALLOWMODE, (Object)pSDEMSActionBase.getAllowMode());
        }
        if (pSDEMSActionBase.isCreateDateDirty() && (bl || pSDEMSActionBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEMSActionBase.getCreateDate());
        }
        if (pSDEMSActionBase.isCreateManDirty() && (bl || pSDEMSActionBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEMSActionBase.getCreateMan());
        }
        if (pSDEMSActionBase.isMemoDirty() && (bl || pSDEMSActionBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEMSActionBase.getMemo());
        }
        if (pSDEMSActionBase.isPSDEActionIdDirty() && (bl || pSDEMSActionBase.getPSDEActionId() != null)) {
            iDataObject.set(FIELD_PSDEACTIONID, (Object)pSDEMSActionBase.getPSDEActionId());
        }
        if (pSDEMSActionBase.isPSDEActionNameDirty() && (bl || pSDEMSActionBase.getPSDEActionName() != null)) {
            iDataObject.set(FIELD_PSDEACTIONNAME, (Object)pSDEMSActionBase.getPSDEActionName());
        }
        if (pSDEMSActionBase.isPSDEIdDirty() && (bl || pSDEMSActionBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEMSActionBase.getPSDEId());
        }
        if (pSDEMSActionBase.isPSDEMSActionIdDirty() && (bl || pSDEMSActionBase.getPSDEMSActionId() != null)) {
            iDataObject.set(FIELD_PSDEMSACTIONID, (Object)pSDEMSActionBase.getPSDEMSActionId());
        }
        if (pSDEMSActionBase.isPSDEMSActionNameDirty() && (bl || pSDEMSActionBase.getPSDEMSActionName() != null)) {
            iDataObject.set(FIELD_PSDEMSACTIONNAME, (Object)pSDEMSActionBase.getPSDEMSActionName());
        }
        if (pSDEMSActionBase.isPSDEMSIdDirty() && (bl || pSDEMSActionBase.getPSDEMSId() != null)) {
            iDataObject.set(FIELD_PSDEMSID, (Object)pSDEMSActionBase.getPSDEMSId());
        }
        if (pSDEMSActionBase.isPSDEMSNameDirty() && (bl || pSDEMSActionBase.getPSDEMSName() != null)) {
            iDataObject.set(FIELD_PSDEMSNAME, (Object)pSDEMSActionBase.getPSDEMSName());
        }
        if (pSDEMSActionBase.isUpdateDateDirty() && (bl || pSDEMSActionBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEMSActionBase.getUpdateDate());
        }
        if (pSDEMSActionBase.isUpdateManDirty() && (bl || pSDEMSActionBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEMSActionBase.getUpdateMan());
        }
        if (pSDEMSActionBase.isUserCatDirty() && (bl || pSDEMSActionBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEMSActionBase.getUserCat());
        }
        if (pSDEMSActionBase.isUserTagDirty() && (bl || pSDEMSActionBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEMSActionBase.getUserTag());
        }
        if (pSDEMSActionBase.isUserTag2Dirty() && (bl || pSDEMSActionBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEMSActionBase.getUserTag2());
        }
        if (pSDEMSActionBase.isUserTag3Dirty() && (bl || pSDEMSActionBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEMSActionBase.getUserTag3());
        }
        if (pSDEMSActionBase.isUserTag4Dirty() && (bl || pSDEMSActionBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEMSActionBase.getUserTag4());
        }
        if (pSDEMSActionBase.isValidFlagDirty() && (bl || pSDEMSActionBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEMSActionBase.getValidFlag());
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
        return PSDEMSActionBase.remove(this, n);
    }

    private static boolean remove(PSDEMSActionBase pSDEMSActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEMSActionBase.resetAllowMode();
                return true;
            }
            case 1: {
                pSDEMSActionBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDEMSActionBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDEMSActionBase.resetMemo();
                return true;
            }
            case 4: {
                pSDEMSActionBase.resetPSDEActionId();
                return true;
            }
            case 5: {
                pSDEMSActionBase.resetPSDEActionName();
                return true;
            }
            case 6: {
                pSDEMSActionBase.resetPSDEId();
                return true;
            }
            case 7: {
                pSDEMSActionBase.resetPSDEMSActionId();
                return true;
            }
            case 8: {
                pSDEMSActionBase.resetPSDEMSActionName();
                return true;
            }
            case 9: {
                pSDEMSActionBase.resetPSDEMSId();
                return true;
            }
            case 10: {
                pSDEMSActionBase.resetPSDEMSName();
                return true;
            }
            case 11: {
                pSDEMSActionBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSDEMSActionBase.resetUpdateMan();
                return true;
            }
            case 13: {
                pSDEMSActionBase.resetUserCat();
                return true;
            }
            case 14: {
                pSDEMSActionBase.resetUserTag();
                return true;
            }
            case 15: {
                pSDEMSActionBase.resetUserTag2();
                return true;
            }
            case 16: {
                pSDEMSActionBase.resetUserTag3();
                return true;
            }
            case 17: {
                pSDEMSActionBase.resetUserTag4();
                return true;
            }
            case 18: {
                pSDEMSActionBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEAction();
        }
        if (this.getPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objPSDEActionLock;
        synchronized (n) {
            if (this.psdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEActionId(), (Object)this.psdeaction.getPSDEActionId()) != 0L) {
                this.psdeaction = null;
            }
            if (this.psdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet(pSDEAction);
                this.psdeaction = pSDEAction;
            }
            return this.psdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEMainState getPSDEMS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMS();
        }
        if (this.getPSDEMSId() == null) {
            return null;
        }
        Integer n = this.objPSDEMSLock;
        synchronized (n) {
            if (this.psdems != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEMSId(), (Object)this.psdems.getPSDEMainStateId()) != 0L) {
                this.psdems = null;
            }
            if (this.psdems == null) {
                PSDEMainState pSDEMainState = new PSDEMainState();
                pSDEMainState.setPSDEMainStateId(this.getPSDEMSId());
                PSDEMainStateService pSDEMainStateService = (PSDEMainStateService)ServiceGlobal.getService(PSDEMainStateService.class, (SessionFactory)this.getSessionFactory());
                pSDEMainStateService.autoGet(pSDEMainState);
                this.psdems = pSDEMainState;
            }
            return this.psdems;
        }
    }

    private PSDEMSActionBase getProxyEntity() {
        return this.proxyPSDEMSActionBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEMSActionBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEMSActionBase) {
            this.proxyPSDEMSActionBase = (PSDEMSActionBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEMSActionService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLOWMODE, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSDEACTIONID, 4);
        fieldIndexMap.put(FIELD_PSDEACTIONNAME, 5);
        fieldIndexMap.put(FIELD_PSDEID, 6);
        fieldIndexMap.put(FIELD_PSDEMSACTIONID, 7);
        fieldIndexMap.put(FIELD_PSDEMSACTIONNAME, 8);
        fieldIndexMap.put(FIELD_PSDEMSID, 9);
        fieldIndexMap.put(FIELD_PSDEMSNAME, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
        fieldIndexMap.put(FIELD_USERCAT, 13);
        fieldIndexMap.put(FIELD_USERTAG, 14);
        fieldIndexMap.put(FIELD_USERTAG2, 15);
        fieldIndexMap.put(FIELD_USERTAG3, 16);
        fieldIndexMap.put(FIELD_USERTAG4, 17);
        fieldIndexMap.put(FIELD_VALIDFLAG, 18);
    }
}

