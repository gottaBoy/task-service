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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMainState;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEMSOPPrivBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEMSOPPrivBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDEMAINSTATEID = "PSDEMAINSTATEID";
    public static final String FIELD_PSDEMAINSTATENAME = "PSDEMAINSTATENAME";
    public static final String FIELD_PSDEMSOPPRIVID = "PSDEMSOPPRIVID";
    public static final String FIELD_PSDEMSOPPRIVNAME = "PSDEMSOPPRIVNAME";
    public static final String FIELD_PSDEOPPRIVID = "PSDEOPPRIVID";
    public static final String FIELD_PSDEOPPRIVNAME = "PSDEOPPRIVNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDEID = 3;
    private static final int INDEX_PSDEMAINSTATEID = 4;
    private static final int INDEX_PSDEMAINSTATENAME = 5;
    private static final int INDEX_PSDEMSOPPRIVID = 6;
    private static final int INDEX_PSDEMSOPPRIVNAME = 7;
    private static final int INDEX_PSDEOPPRIVID = 8;
    private static final int INDEX_PSDEOPPRIVNAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_USERCAT = 12;
    private static final int INDEX_USERTAG = 13;
    private static final int INDEX_USERTAG2 = 14;
    private static final int INDEX_USERTAG3 = 15;
    private static final int INDEX_USERTAG4 = 16;
    private static final int INDEX_VALIDFLAG = 17;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEMSOPPrivBase proxyPSDEMSOPPrivBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdemainstateidDirtyFlag = false;
    private boolean psdemainstatenameDirtyFlag = false;
    private boolean psdemsopprividDirtyFlag = false;
    private boolean psdemsopprivnameDirtyFlag = false;
    private boolean psdeopprividDirtyFlag = false;
    private boolean psdeopprivnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdemainstateid")
    private String psdemainstateid;
    @Column(name="psdemainstatename")
    private String psdemainstatename;
    @Column(name="psdemsopprivid")
    private String psdemsopprivid;
    @Column(name="psdemsopprivname")
    private String psdemsopprivname;
    @Column(name="psdeopprivid")
    private String psdeopprivid;
    @Column(name="psdeopprivname")
    private String psdeopprivname;
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
    private Integer objPSDEMainStateLock = new Integer(1);
    private PSDEMainState psdemainstate = null;
    private Integer objPSDEOPPrivLock = new Integer(1);
    private PSDEOPPriv psdeoppriv = null;

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

    public void setPSDEMainStateId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMainStateId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemainstateid = string;
        this.psdemainstateidDirtyFlag = true;
    }

    public String getPSDEMainStateId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMainStateId();
        }
        return this.psdemainstateid;
    }

    public boolean isPSDEMainStateIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMainStateIdDirty();
        }
        return this.psdemainstateidDirtyFlag;
    }

    public void resetPSDEMainStateId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMainStateId();
            return;
        }
        this.psdemainstateidDirtyFlag = false;
        this.psdemainstateid = null;
    }

    public void setPSDEMainStateName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMainStateName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemainstatename = string;
        this.psdemainstatenameDirtyFlag = true;
    }

    public String getPSDEMainStateName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMainStateName();
        }
        return this.psdemainstatename;
    }

    public boolean isPSDEMainStateNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMainStateNameDirty();
        }
        return this.psdemainstatenameDirtyFlag;
    }

    public void resetPSDEMainStateName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMainStateName();
            return;
        }
        this.psdemainstatenameDirtyFlag = false;
        this.psdemainstatename = null;
    }

    public void setPSDEMSOPPrivId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMSOPPrivId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemsopprivid = string;
        this.psdemsopprividDirtyFlag = true;
    }

    public String getPSDEMSOPPrivId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMSOPPrivId();
        }
        return this.psdemsopprivid;
    }

    public boolean isPSDEMSOPPrivIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMSOPPrivIdDirty();
        }
        return this.psdemsopprividDirtyFlag;
    }

    public void resetPSDEMSOPPrivId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMSOPPrivId();
            return;
        }
        this.psdemsopprividDirtyFlag = false;
        this.psdemsopprivid = null;
    }

    public void setPSDEMSOPPrivName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMSOPPrivName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemsopprivname = string;
        this.psdemsopprivnameDirtyFlag = true;
    }

    public String getPSDEMSOPPrivName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMSOPPrivName();
        }
        return this.psdemsopprivname;
    }

    public boolean isPSDEMSOPPrivNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMSOPPrivNameDirty();
        }
        return this.psdemsopprivnameDirtyFlag;
    }

    public void resetPSDEMSOPPrivName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMSOPPrivName();
            return;
        }
        this.psdemsopprivnameDirtyFlag = false;
        this.psdemsopprivname = null;
    }

    public void setPSDEOPPrivId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEOPPrivId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeopprivid = string;
        this.psdeopprividDirtyFlag = true;
    }

    public String getPSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEOPPrivId();
        }
        return this.psdeopprivid;
    }

    public boolean isPSDEOPPrivIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEOPPrivIdDirty();
        }
        return this.psdeopprividDirtyFlag;
    }

    public void resetPSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEOPPrivId();
            return;
        }
        this.psdeopprividDirtyFlag = false;
        this.psdeopprivid = null;
    }

    public void setPSDEOPPrivName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEOPPrivName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeopprivname = string;
        this.psdeopprivnameDirtyFlag = true;
    }

    public String getPSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEOPPrivName();
        }
        return this.psdeopprivname;
    }

    public boolean isPSDEOPPrivNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEOPPrivNameDirty();
        }
        return this.psdeopprivnameDirtyFlag;
    }

    public void resetPSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEOPPrivName();
            return;
        }
        this.psdeopprivnameDirtyFlag = false;
        this.psdeopprivname = null;
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
        PSDEMSOPPrivBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEMSOPPrivBase pSDEMSOPPrivBase) {
        pSDEMSOPPrivBase.resetCreateDate();
        pSDEMSOPPrivBase.resetCreateMan();
        pSDEMSOPPrivBase.resetMemo();
        pSDEMSOPPrivBase.resetPSDEId();
        pSDEMSOPPrivBase.resetPSDEMainStateId();
        pSDEMSOPPrivBase.resetPSDEMainStateName();
        pSDEMSOPPrivBase.resetPSDEMSOPPrivId();
        pSDEMSOPPrivBase.resetPSDEMSOPPrivName();
        pSDEMSOPPrivBase.resetPSDEOPPrivId();
        pSDEMSOPPrivBase.resetPSDEOPPrivName();
        pSDEMSOPPrivBase.resetUpdateDate();
        pSDEMSOPPrivBase.resetUpdateMan();
        pSDEMSOPPrivBase.resetUserCat();
        pSDEMSOPPrivBase.resetUserTag();
        pSDEMSOPPrivBase.resetUserTag2();
        pSDEMSOPPrivBase.resetUserTag3();
        pSDEMSOPPrivBase.resetUserTag4();
        pSDEMSOPPrivBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
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
        if (!bl || this.isPSDEMainStateIdDirty()) {
            hashMap.put(FIELD_PSDEMAINSTATEID, this.getPSDEMainStateId());
        }
        if (!bl || this.isPSDEMainStateNameDirty()) {
            hashMap.put(FIELD_PSDEMAINSTATENAME, this.getPSDEMainStateName());
        }
        if (!bl || this.isPSDEMSOPPrivIdDirty()) {
            hashMap.put(FIELD_PSDEMSOPPRIVID, this.getPSDEMSOPPrivId());
        }
        if (!bl || this.isPSDEMSOPPrivNameDirty()) {
            hashMap.put(FIELD_PSDEMSOPPRIVNAME, this.getPSDEMSOPPrivName());
        }
        if (!bl || this.isPSDEOPPrivIdDirty()) {
            hashMap.put(FIELD_PSDEOPPRIVID, this.getPSDEOPPrivId());
        }
        if (!bl || this.isPSDEOPPrivNameDirty()) {
            hashMap.put(FIELD_PSDEOPPRIVNAME, this.getPSDEOPPrivName());
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
        return PSDEMSOPPrivBase.get(this, n);
    }

    private static Object get(PSDEMSOPPrivBase pSDEMSOPPrivBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEMSOPPrivBase.getCreateDate();
            }
            case 1: {
                return pSDEMSOPPrivBase.getCreateMan();
            }
            case 2: {
                return pSDEMSOPPrivBase.getMemo();
            }
            case 3: {
                return pSDEMSOPPrivBase.getPSDEId();
            }
            case 4: {
                return pSDEMSOPPrivBase.getPSDEMainStateId();
            }
            case 5: {
                return pSDEMSOPPrivBase.getPSDEMainStateName();
            }
            case 6: {
                return pSDEMSOPPrivBase.getPSDEMSOPPrivId();
            }
            case 7: {
                return pSDEMSOPPrivBase.getPSDEMSOPPrivName();
            }
            case 8: {
                return pSDEMSOPPrivBase.getPSDEOPPrivId();
            }
            case 9: {
                return pSDEMSOPPrivBase.getPSDEOPPrivName();
            }
            case 10: {
                return pSDEMSOPPrivBase.getUpdateDate();
            }
            case 11: {
                return pSDEMSOPPrivBase.getUpdateMan();
            }
            case 12: {
                return pSDEMSOPPrivBase.getUserCat();
            }
            case 13: {
                return pSDEMSOPPrivBase.getUserTag();
            }
            case 14: {
                return pSDEMSOPPrivBase.getUserTag2();
            }
            case 15: {
                return pSDEMSOPPrivBase.getUserTag3();
            }
            case 16: {
                return pSDEMSOPPrivBase.getUserTag4();
            }
            case 17: {
                return pSDEMSOPPrivBase.getValidFlag();
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
        PSDEMSOPPrivBase.set(this, n, object);
    }

    private static void set(PSDEMSOPPrivBase pSDEMSOPPrivBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEMSOPPrivBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEMSOPPrivBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEMSOPPrivBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEMSOPPrivBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEMSOPPrivBase.setPSDEMainStateId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEMSOPPrivBase.setPSDEMainStateName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEMSOPPrivBase.setPSDEMSOPPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEMSOPPrivBase.setPSDEMSOPPrivName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEMSOPPrivBase.setPSDEOPPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEMSOPPrivBase.setPSDEOPPrivName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEMSOPPrivBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSDEMSOPPrivBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEMSOPPrivBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEMSOPPrivBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEMSOPPrivBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEMSOPPrivBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEMSOPPrivBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEMSOPPrivBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEMSOPPrivBase.isNull(this, n);
    }

    private static boolean isNull(PSDEMSOPPrivBase pSDEMSOPPrivBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEMSOPPrivBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEMSOPPrivBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEMSOPPrivBase.getMemo() == null;
            }
            case 3: {
                return pSDEMSOPPrivBase.getPSDEId() == null;
            }
            case 4: {
                return pSDEMSOPPrivBase.getPSDEMainStateId() == null;
            }
            case 5: {
                return pSDEMSOPPrivBase.getPSDEMainStateName() == null;
            }
            case 6: {
                return pSDEMSOPPrivBase.getPSDEMSOPPrivId() == null;
            }
            case 7: {
                return pSDEMSOPPrivBase.getPSDEMSOPPrivName() == null;
            }
            case 8: {
                return pSDEMSOPPrivBase.getPSDEOPPrivId() == null;
            }
            case 9: {
                return pSDEMSOPPrivBase.getPSDEOPPrivName() == null;
            }
            case 10: {
                return pSDEMSOPPrivBase.getUpdateDate() == null;
            }
            case 11: {
                return pSDEMSOPPrivBase.getUpdateMan() == null;
            }
            case 12: {
                return pSDEMSOPPrivBase.getUserCat() == null;
            }
            case 13: {
                return pSDEMSOPPrivBase.getUserTag() == null;
            }
            case 14: {
                return pSDEMSOPPrivBase.getUserTag2() == null;
            }
            case 15: {
                return pSDEMSOPPrivBase.getUserTag3() == null;
            }
            case 16: {
                return pSDEMSOPPrivBase.getUserTag4() == null;
            }
            case 17: {
                return pSDEMSOPPrivBase.getValidFlag() == null;
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
        return PSDEMSOPPrivBase.contains(this, n);
    }

    private static boolean contains(PSDEMSOPPrivBase pSDEMSOPPrivBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEMSOPPrivBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEMSOPPrivBase.isCreateManDirty();
            }
            case 2: {
                return pSDEMSOPPrivBase.isMemoDirty();
            }
            case 3: {
                return pSDEMSOPPrivBase.isPSDEIdDirty();
            }
            case 4: {
                return pSDEMSOPPrivBase.isPSDEMainStateIdDirty();
            }
            case 5: {
                return pSDEMSOPPrivBase.isPSDEMainStateNameDirty();
            }
            case 6: {
                return pSDEMSOPPrivBase.isPSDEMSOPPrivIdDirty();
            }
            case 7: {
                return pSDEMSOPPrivBase.isPSDEMSOPPrivNameDirty();
            }
            case 8: {
                return pSDEMSOPPrivBase.isPSDEOPPrivIdDirty();
            }
            case 9: {
                return pSDEMSOPPrivBase.isPSDEOPPrivNameDirty();
            }
            case 10: {
                return pSDEMSOPPrivBase.isUpdateDateDirty();
            }
            case 11: {
                return pSDEMSOPPrivBase.isUpdateManDirty();
            }
            case 12: {
                return pSDEMSOPPrivBase.isUserCatDirty();
            }
            case 13: {
                return pSDEMSOPPrivBase.isUserTagDirty();
            }
            case 14: {
                return pSDEMSOPPrivBase.isUserTag2Dirty();
            }
            case 15: {
                return pSDEMSOPPrivBase.isUserTag3Dirty();
            }
            case 16: {
                return pSDEMSOPPrivBase.isUserTag4Dirty();
            }
            case 17: {
                return pSDEMSOPPrivBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEMSOPPrivBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEMSOPPrivBase pSDEMSOPPrivBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEMSOPPrivBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEMSOPPrivBase.getJSONValue((Object)pSDEMSOPPrivBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEMSOPPrivBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEMSOPPrivBase.getJSONValue((Object)pSDEMSOPPrivBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEMSOPPrivBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEMSOPPrivBase.getJSONValue((Object)pSDEMSOPPrivBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEMSOPPrivBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEMSOPPrivBase.getJSONValue((Object)pSDEMSOPPrivBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEMSOPPrivBase.getPSDEMainStateId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemainstateid", (Object)PSDEMSOPPrivBase.getJSONValue((Object)pSDEMSOPPrivBase.getPSDEMainStateId()), (boolean)false);
        }
        if (bl || pSDEMSOPPrivBase.getPSDEMainStateName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemainstatename", (Object)PSDEMSOPPrivBase.getJSONValue((Object)pSDEMSOPPrivBase.getPSDEMainStateName()), (boolean)false);
        }
        if (bl || pSDEMSOPPrivBase.getPSDEMSOPPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemsopprivid", (Object)PSDEMSOPPrivBase.getJSONValue((Object)pSDEMSOPPrivBase.getPSDEMSOPPrivId()), (boolean)false);
        }
        if (bl || pSDEMSOPPrivBase.getPSDEMSOPPrivName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemsopprivname", (Object)PSDEMSOPPrivBase.getJSONValue((Object)pSDEMSOPPrivBase.getPSDEMSOPPrivName()), (boolean)false);
        }
        if (bl || pSDEMSOPPrivBase.getPSDEOPPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeopprivid", (Object)PSDEMSOPPrivBase.getJSONValue((Object)pSDEMSOPPrivBase.getPSDEOPPrivId()), (boolean)false);
        }
        if (bl || pSDEMSOPPrivBase.getPSDEOPPrivName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeopprivname", (Object)PSDEMSOPPrivBase.getJSONValue((Object)pSDEMSOPPrivBase.getPSDEOPPrivName()), (boolean)false);
        }
        if (bl || pSDEMSOPPrivBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEMSOPPrivBase.getJSONValue((Object)pSDEMSOPPrivBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEMSOPPrivBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEMSOPPrivBase.getJSONValue((Object)pSDEMSOPPrivBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEMSOPPrivBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEMSOPPrivBase.getJSONValue((Object)pSDEMSOPPrivBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEMSOPPrivBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEMSOPPrivBase.getJSONValue((Object)pSDEMSOPPrivBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEMSOPPrivBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEMSOPPrivBase.getJSONValue((Object)pSDEMSOPPrivBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEMSOPPrivBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEMSOPPrivBase.getJSONValue((Object)pSDEMSOPPrivBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEMSOPPrivBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEMSOPPrivBase.getJSONValue((Object)pSDEMSOPPrivBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEMSOPPrivBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEMSOPPrivBase.getJSONValue((Object)pSDEMSOPPrivBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEMSOPPrivBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEMSOPPrivBase pSDEMSOPPrivBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEMSOPPrivBase.getCreateDate() != null) {
            object = pSDEMSOPPrivBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEMSOPPrivBase.getCreateMan() != null) {
            object = pSDEMSOPPrivBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSOPPrivBase.getMemo() != null) {
            object = pSDEMSOPPrivBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSOPPrivBase.getPSDEId() != null) {
            object = pSDEMSOPPrivBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSOPPrivBase.getPSDEMainStateId() != null) {
            object = pSDEMSOPPrivBase.getPSDEMainStateId();
            xmlNode.setAttribute(FIELD_PSDEMAINSTATEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSOPPrivBase.getPSDEMainStateName() != null) {
            object = pSDEMSOPPrivBase.getPSDEMainStateName();
            xmlNode.setAttribute(FIELD_PSDEMAINSTATENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSOPPrivBase.getPSDEMSOPPrivId() != null) {
            object = pSDEMSOPPrivBase.getPSDEMSOPPrivId();
            xmlNode.setAttribute(FIELD_PSDEMSOPPRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSOPPrivBase.getPSDEMSOPPrivName() != null) {
            object = pSDEMSOPPrivBase.getPSDEMSOPPrivName();
            xmlNode.setAttribute(FIELD_PSDEMSOPPRIVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSOPPrivBase.getPSDEOPPrivId() != null) {
            object = pSDEMSOPPrivBase.getPSDEOPPrivId();
            xmlNode.setAttribute(FIELD_PSDEOPPRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSOPPrivBase.getPSDEOPPrivName() != null) {
            object = pSDEMSOPPrivBase.getPSDEOPPrivName();
            xmlNode.setAttribute(FIELD_PSDEOPPRIVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSOPPrivBase.getUpdateDate() != null) {
            object = pSDEMSOPPrivBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEMSOPPrivBase.getUpdateMan() != null) {
            object = pSDEMSOPPrivBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSOPPrivBase.getUserCat() != null) {
            object = pSDEMSOPPrivBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSOPPrivBase.getUserTag() != null) {
            object = pSDEMSOPPrivBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSOPPrivBase.getUserTag2() != null) {
            object = pSDEMSOPPrivBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSOPPrivBase.getUserTag3() != null) {
            object = pSDEMSOPPrivBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSOPPrivBase.getUserTag4() != null) {
            object = pSDEMSOPPrivBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEMSOPPrivBase.getValidFlag() != null) {
            object = pSDEMSOPPrivBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEMSOPPrivBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEMSOPPrivBase pSDEMSOPPrivBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEMSOPPrivBase.isCreateDateDirty() && (bl || pSDEMSOPPrivBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEMSOPPrivBase.getCreateDate());
        }
        if (pSDEMSOPPrivBase.isCreateManDirty() && (bl || pSDEMSOPPrivBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEMSOPPrivBase.getCreateMan());
        }
        if (pSDEMSOPPrivBase.isMemoDirty() && (bl || pSDEMSOPPrivBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEMSOPPrivBase.getMemo());
        }
        if (pSDEMSOPPrivBase.isPSDEIdDirty() && (bl || pSDEMSOPPrivBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEMSOPPrivBase.getPSDEId());
        }
        if (pSDEMSOPPrivBase.isPSDEMainStateIdDirty() && (bl || pSDEMSOPPrivBase.getPSDEMainStateId() != null)) {
            iDataObject.set(FIELD_PSDEMAINSTATEID, (Object)pSDEMSOPPrivBase.getPSDEMainStateId());
        }
        if (pSDEMSOPPrivBase.isPSDEMainStateNameDirty() && (bl || pSDEMSOPPrivBase.getPSDEMainStateName() != null)) {
            iDataObject.set(FIELD_PSDEMAINSTATENAME, (Object)pSDEMSOPPrivBase.getPSDEMainStateName());
        }
        if (pSDEMSOPPrivBase.isPSDEMSOPPrivIdDirty() && (bl || pSDEMSOPPrivBase.getPSDEMSOPPrivId() != null)) {
            iDataObject.set(FIELD_PSDEMSOPPRIVID, (Object)pSDEMSOPPrivBase.getPSDEMSOPPrivId());
        }
        if (pSDEMSOPPrivBase.isPSDEMSOPPrivNameDirty() && (bl || pSDEMSOPPrivBase.getPSDEMSOPPrivName() != null)) {
            iDataObject.set(FIELD_PSDEMSOPPRIVNAME, (Object)pSDEMSOPPrivBase.getPSDEMSOPPrivName());
        }
        if (pSDEMSOPPrivBase.isPSDEOPPrivIdDirty() && (bl || pSDEMSOPPrivBase.getPSDEOPPrivId() != null)) {
            iDataObject.set(FIELD_PSDEOPPRIVID, (Object)pSDEMSOPPrivBase.getPSDEOPPrivId());
        }
        if (pSDEMSOPPrivBase.isPSDEOPPrivNameDirty() && (bl || pSDEMSOPPrivBase.getPSDEOPPrivName() != null)) {
            iDataObject.set(FIELD_PSDEOPPRIVNAME, (Object)pSDEMSOPPrivBase.getPSDEOPPrivName());
        }
        if (pSDEMSOPPrivBase.isUpdateDateDirty() && (bl || pSDEMSOPPrivBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEMSOPPrivBase.getUpdateDate());
        }
        if (pSDEMSOPPrivBase.isUpdateManDirty() && (bl || pSDEMSOPPrivBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEMSOPPrivBase.getUpdateMan());
        }
        if (pSDEMSOPPrivBase.isUserCatDirty() && (bl || pSDEMSOPPrivBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEMSOPPrivBase.getUserCat());
        }
        if (pSDEMSOPPrivBase.isUserTagDirty() && (bl || pSDEMSOPPrivBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEMSOPPrivBase.getUserTag());
        }
        if (pSDEMSOPPrivBase.isUserTag2Dirty() && (bl || pSDEMSOPPrivBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEMSOPPrivBase.getUserTag2());
        }
        if (pSDEMSOPPrivBase.isUserTag3Dirty() && (bl || pSDEMSOPPrivBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEMSOPPrivBase.getUserTag3());
        }
        if (pSDEMSOPPrivBase.isUserTag4Dirty() && (bl || pSDEMSOPPrivBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEMSOPPrivBase.getUserTag4());
        }
        if (pSDEMSOPPrivBase.isValidFlagDirty() && (bl || pSDEMSOPPrivBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEMSOPPrivBase.getValidFlag());
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
        return PSDEMSOPPrivBase.remove(this, n);
    }

    private static boolean remove(PSDEMSOPPrivBase pSDEMSOPPrivBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEMSOPPrivBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEMSOPPrivBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEMSOPPrivBase.resetMemo();
                return true;
            }
            case 3: {
                pSDEMSOPPrivBase.resetPSDEId();
                return true;
            }
            case 4: {
                pSDEMSOPPrivBase.resetPSDEMainStateId();
                return true;
            }
            case 5: {
                pSDEMSOPPrivBase.resetPSDEMainStateName();
                return true;
            }
            case 6: {
                pSDEMSOPPrivBase.resetPSDEMSOPPrivId();
                return true;
            }
            case 7: {
                pSDEMSOPPrivBase.resetPSDEMSOPPrivName();
                return true;
            }
            case 8: {
                pSDEMSOPPrivBase.resetPSDEOPPrivId();
                return true;
            }
            case 9: {
                pSDEMSOPPrivBase.resetPSDEOPPrivName();
                return true;
            }
            case 10: {
                pSDEMSOPPrivBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSDEMSOPPrivBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSDEMSOPPrivBase.resetUserCat();
                return true;
            }
            case 13: {
                pSDEMSOPPrivBase.resetUserTag();
                return true;
            }
            case 14: {
                pSDEMSOPPrivBase.resetUserTag2();
                return true;
            }
            case 15: {
                pSDEMSOPPrivBase.resetUserTag3();
                return true;
            }
            case 16: {
                pSDEMSOPPrivBase.resetUserTag4();
                return true;
            }
            case 17: {
                pSDEMSOPPrivBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEMainState getPSDEMainState() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMainState();
        }
        if (this.getPSDEMainStateId() == null) {
            return null;
        }
        Integer n = this.objPSDEMainStateLock;
        synchronized (n) {
            if (this.psdemainstate != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEMainStateId(), (Object)this.psdemainstate.getPSDEMainStateId()) != 0L) {
                this.psdemainstate = null;
            }
            if (this.psdemainstate == null) {
                PSDEMainState pSDEMainState = new PSDEMainState();
                pSDEMainState.setPSDEMainStateId(this.getPSDEMainStateId());
                PSDEMainStateService pSDEMainStateService = (PSDEMainStateService)ServiceGlobal.getService(PSDEMainStateService.class, (SessionFactory)this.getSessionFactory());
                pSDEMainStateService.autoGet((IEntity)pSDEMainState);
                this.psdemainstate = pSDEMainState;
            }
            return this.psdemainstate;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEOPPriv getPSDEOPPriv() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEOPPriv();
        }
        if (this.getPSDEOPPrivId() == null) {
            return null;
        }
        Integer n = this.objPSDEOPPrivLock;
        synchronized (n) {
            if (this.psdeoppriv != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEOPPrivId(), (Object)this.psdeoppriv.getPSDEOPPrivId()) != 0L) {
                this.psdeoppriv = null;
            }
            if (this.psdeoppriv == null) {
                PSDEOPPriv pSDEOPPriv = new PSDEOPPriv();
                pSDEOPPriv.setPSDEOPPrivId(this.getPSDEOPPrivId());
                PSDEOPPrivService pSDEOPPrivService = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
                pSDEOPPrivService.autoGet((IEntity)pSDEOPPriv);
                this.psdeoppriv = pSDEOPPriv;
            }
            return this.psdeoppriv;
        }
    }

    private PSDEMSOPPrivBase getProxyEntity() {
        return this.proxyPSDEMSOPPrivBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEMSOPPrivBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEMSOPPrivBase) {
            this.proxyPSDEMSOPPrivBase = (PSDEMSOPPrivBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEMSOPPrivService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDEID, 3);
        fieldIndexMap.put(FIELD_PSDEMAINSTATEID, 4);
        fieldIndexMap.put(FIELD_PSDEMAINSTATENAME, 5);
        fieldIndexMap.put(FIELD_PSDEMSOPPRIVID, 6);
        fieldIndexMap.put(FIELD_PSDEMSOPPRIVNAME, 7);
        fieldIndexMap.put(FIELD_PSDEOPPRIVID, 8);
        fieldIndexMap.put(FIELD_PSDEOPPRIVNAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_USERCAT, 12);
        fieldIndexMap.put(FIELD_USERTAG, 13);
        fieldIndexMap.put(FIELD_USERTAG2, 14);
        fieldIndexMap.put(FIELD_USERTAG3, 15);
        fieldIndexMap.put(FIELD_USERTAG4, 16);
        fieldIndexMap.put(FIELD_VALIDFLAG, 17);
    }
}

