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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBProcParam;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBScheme;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBProcParamService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBSchemeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDBProcBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysDBProcBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CODENAME2 = "CODENAME2";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PROCDESC = "PROCDESC";
    public static final String FIELD_PSSYSDBPROCID = "PSSYSDBPROCID";
    public static final String FIELD_PSSYSDBPROCNAME = "PSSYSDBPROCNAME";
    public static final String FIELD_PSSYSDBSCHEMEID = "PSSYSDBSCHEMEID";
    public static final String FIELD_PSSYSDBSCHEMENAME = "PSSYSDBSCHEMENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CODENAME2 = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_LOGICNAME = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PROCDESC = 6;
    private static final int INDEX_PSSYSDBPROCID = 7;
    private static final int INDEX_PSSYSDBPROCNAME = 8;
    private static final int INDEX_PSSYSDBSCHEMEID = 9;
    private static final int INDEX_PSSYSDBSCHEMENAME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_USERCAT = 13;
    private static final int INDEX_USERTAG = 14;
    private static final int INDEX_USERTAG2 = 15;
    private static final int INDEX_USERTAG3 = 16;
    private static final int INDEX_USERTAG4 = 17;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysDBProcBase proxyPSSysDBProcBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean codename2DirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean procdescDirtyFlag = false;
    private boolean pssysdbprocidDirtyFlag = false;
    private boolean pssysdbprocnameDirtyFlag = false;
    private boolean pssysdbschemeidDirtyFlag = false;
    private boolean pssysdbschemenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="codename2")
    private String codename2;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="procdesc")
    private String procdesc;
    @Column(name="pssysdbprocid")
    private String pssysdbprocid;
    @Column(name="pssysdbprocname")
    private String pssysdbprocname;
    @Column(name="pssysdbschemeid")
    private String pssysdbschemeid;
    @Column(name="pssysdbschemename")
    private String pssysdbschemename;
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
    private Integer objPSSysDBSchemeLock = new Integer(1);
    private PSSysDBScheme pssysdbscheme = null;
    private Integer objPSSysDBProcParamsLock = new Integer(1);
    private ArrayList<PSSysDBProcParam> pssysdbprocparams = null;

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

    public void setCodeName2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename2 = string;
        this.codename2DirtyFlag = true;
    }

    public String getCodeName2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName2();
        }
        return this.codename2;
    }

    public boolean isCodeName2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeName2Dirty();
        }
        return this.codename2DirtyFlag;
    }

    public void resetCodeName2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName2();
            return;
        }
        this.codename2DirtyFlag = false;
        this.codename2 = null;
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

    public void setLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicname = string;
        this.logicnameDirtyFlag = true;
    }

    public String getLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicName();
        }
        return this.logicname;
    }

    public boolean isLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicNameDirty();
        }
        return this.logicnameDirtyFlag;
    }

    public void resetLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicName();
            return;
        }
        this.logicnameDirtyFlag = false;
        this.logicname = null;
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

    public void setProcDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setProcDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.procdesc = string;
        this.procdescDirtyFlag = true;
    }

    public String getProcDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getProcDesc();
        }
        return this.procdesc;
    }

    public boolean isProcDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isProcDescDirty();
        }
        return this.procdescDirtyFlag;
    }

    public void resetProcDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetProcDesc();
            return;
        }
        this.procdescDirtyFlag = false;
        this.procdesc = null;
    }

    public void setPSSysDBProcId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBProcId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbprocid = string;
        this.pssysdbprocidDirtyFlag = true;
    }

    public String getPSSysDBProcId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBProcId();
        }
        return this.pssysdbprocid;
    }

    public boolean isPSSysDBProcIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBProcIdDirty();
        }
        return this.pssysdbprocidDirtyFlag;
    }

    public void resetPSSysDBProcId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBProcId();
            return;
        }
        this.pssysdbprocidDirtyFlag = false;
        this.pssysdbprocid = null;
    }

    public void setPSSysDBProcName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBProcName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbprocname = string;
        this.pssysdbprocnameDirtyFlag = true;
    }

    public String getPSSysDBProcName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBProcName();
        }
        return this.pssysdbprocname;
    }

    public boolean isPSSysDBProcNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBProcNameDirty();
        }
        return this.pssysdbprocnameDirtyFlag;
    }

    public void resetPSSysDBProcName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBProcName();
            return;
        }
        this.pssysdbprocnameDirtyFlag = false;
        this.pssysdbprocname = null;
    }

    public void setPSSysDBSchemeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBSchemeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbschemeid = string;
        this.pssysdbschemeidDirtyFlag = true;
    }

    public String getPSSysDBSchemeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBSchemeId();
        }
        return this.pssysdbschemeid;
    }

    public boolean isPSSysDBSchemeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBSchemeIdDirty();
        }
        return this.pssysdbschemeidDirtyFlag;
    }

    public void resetPSSysDBSchemeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBSchemeId();
            return;
        }
        this.pssysdbschemeidDirtyFlag = false;
        this.pssysdbschemeid = null;
    }

    public void setPSSysDBSchemeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBSchemeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbschemename = string;
        this.pssysdbschemenameDirtyFlag = true;
    }

    public String getPSSysDBSchemeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBSchemeName();
        }
        return this.pssysdbschemename;
    }

    public boolean isPSSysDBSchemeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBSchemeNameDirty();
        }
        return this.pssysdbschemenameDirtyFlag;
    }

    public void resetPSSysDBSchemeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBSchemeName();
            return;
        }
        this.pssysdbschemenameDirtyFlag = false;
        this.pssysdbschemename = null;
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
        PSSysDBProcBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysDBProcBase pSSysDBProcBase) {
        pSSysDBProcBase.resetCodeName();
        pSSysDBProcBase.resetCodeName2();
        pSSysDBProcBase.resetCreateDate();
        pSSysDBProcBase.resetCreateMan();
        pSSysDBProcBase.resetLogicName();
        pSSysDBProcBase.resetMemo();
        pSSysDBProcBase.resetProcDesc();
        pSSysDBProcBase.resetPSSysDBProcId();
        pSSysDBProcBase.resetPSSysDBProcName();
        pSSysDBProcBase.resetPSSysDBSchemeId();
        pSSysDBProcBase.resetPSSysDBSchemeName();
        pSSysDBProcBase.resetUpdateDate();
        pSSysDBProcBase.resetUpdateMan();
        pSSysDBProcBase.resetUserCat();
        pSSysDBProcBase.resetUserTag();
        pSSysDBProcBase.resetUserTag2();
        pSSysDBProcBase.resetUserTag3();
        pSSysDBProcBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCodeName2Dirty()) {
            hashMap.put(FIELD_CODENAME2, this.getCodeName2());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isProcDescDirty()) {
            hashMap.put(FIELD_PROCDESC, this.getProcDesc());
        }
        if (!bl || this.isPSSysDBProcIdDirty()) {
            hashMap.put(FIELD_PSSYSDBPROCID, this.getPSSysDBProcId());
        }
        if (!bl || this.isPSSysDBProcNameDirty()) {
            hashMap.put(FIELD_PSSYSDBPROCNAME, this.getPSSysDBProcName());
        }
        if (!bl || this.isPSSysDBSchemeIdDirty()) {
            hashMap.put(FIELD_PSSYSDBSCHEMEID, this.getPSSysDBSchemeId());
        }
        if (!bl || this.isPSSysDBSchemeNameDirty()) {
            hashMap.put(FIELD_PSSYSDBSCHEMENAME, this.getPSSysDBSchemeName());
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
        return PSSysDBProcBase.get(this, n);
    }

    private static Object get(PSSysDBProcBase pSSysDBProcBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDBProcBase.getCodeName();
            }
            case 1: {
                return pSSysDBProcBase.getCodeName2();
            }
            case 2: {
                return pSSysDBProcBase.getCreateDate();
            }
            case 3: {
                return pSSysDBProcBase.getCreateMan();
            }
            case 4: {
                return pSSysDBProcBase.getLogicName();
            }
            case 5: {
                return pSSysDBProcBase.getMemo();
            }
            case 6: {
                return pSSysDBProcBase.getProcDesc();
            }
            case 7: {
                return pSSysDBProcBase.getPSSysDBProcId();
            }
            case 8: {
                return pSSysDBProcBase.getPSSysDBProcName();
            }
            case 9: {
                return pSSysDBProcBase.getPSSysDBSchemeId();
            }
            case 10: {
                return pSSysDBProcBase.getPSSysDBSchemeName();
            }
            case 11: {
                return pSSysDBProcBase.getUpdateDate();
            }
            case 12: {
                return pSSysDBProcBase.getUpdateMan();
            }
            case 13: {
                return pSSysDBProcBase.getUserCat();
            }
            case 14: {
                return pSSysDBProcBase.getUserTag();
            }
            case 15: {
                return pSSysDBProcBase.getUserTag2();
            }
            case 16: {
                return pSSysDBProcBase.getUserTag3();
            }
            case 17: {
                return pSSysDBProcBase.getUserTag4();
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
        PSSysDBProcBase.set(this, n, object);
    }

    private static void set(PSSysDBProcBase pSSysDBProcBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysDBProcBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysDBProcBase.setCodeName2(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysDBProcBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSSysDBProcBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysDBProcBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysDBProcBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysDBProcBase.setProcDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysDBProcBase.setPSSysDBProcId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysDBProcBase.setPSSysDBProcName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysDBProcBase.setPSSysDBSchemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysDBProcBase.setPSSysDBSchemeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysDBProcBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSSysDBProcBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysDBProcBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysDBProcBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysDBProcBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysDBProcBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysDBProcBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysDBProcBase.isNull(this, n);
    }

    private static boolean isNull(PSSysDBProcBase pSSysDBProcBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDBProcBase.getCodeName() == null;
            }
            case 1: {
                return pSSysDBProcBase.getCodeName2() == null;
            }
            case 2: {
                return pSSysDBProcBase.getCreateDate() == null;
            }
            case 3: {
                return pSSysDBProcBase.getCreateMan() == null;
            }
            case 4: {
                return pSSysDBProcBase.getLogicName() == null;
            }
            case 5: {
                return pSSysDBProcBase.getMemo() == null;
            }
            case 6: {
                return pSSysDBProcBase.getProcDesc() == null;
            }
            case 7: {
                return pSSysDBProcBase.getPSSysDBProcId() == null;
            }
            case 8: {
                return pSSysDBProcBase.getPSSysDBProcName() == null;
            }
            case 9: {
                return pSSysDBProcBase.getPSSysDBSchemeId() == null;
            }
            case 10: {
                return pSSysDBProcBase.getPSSysDBSchemeName() == null;
            }
            case 11: {
                return pSSysDBProcBase.getUpdateDate() == null;
            }
            case 12: {
                return pSSysDBProcBase.getUpdateMan() == null;
            }
            case 13: {
                return pSSysDBProcBase.getUserCat() == null;
            }
            case 14: {
                return pSSysDBProcBase.getUserTag() == null;
            }
            case 15: {
                return pSSysDBProcBase.getUserTag2() == null;
            }
            case 16: {
                return pSSysDBProcBase.getUserTag3() == null;
            }
            case 17: {
                return pSSysDBProcBase.getUserTag4() == null;
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
        return PSSysDBProcBase.contains(this, n);
    }

    private static boolean contains(PSSysDBProcBase pSSysDBProcBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDBProcBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysDBProcBase.isCodeName2Dirty();
            }
            case 2: {
                return pSSysDBProcBase.isCreateDateDirty();
            }
            case 3: {
                return pSSysDBProcBase.isCreateManDirty();
            }
            case 4: {
                return pSSysDBProcBase.isLogicNameDirty();
            }
            case 5: {
                return pSSysDBProcBase.isMemoDirty();
            }
            case 6: {
                return pSSysDBProcBase.isProcDescDirty();
            }
            case 7: {
                return pSSysDBProcBase.isPSSysDBProcIdDirty();
            }
            case 8: {
                return pSSysDBProcBase.isPSSysDBProcNameDirty();
            }
            case 9: {
                return pSSysDBProcBase.isPSSysDBSchemeIdDirty();
            }
            case 10: {
                return pSSysDBProcBase.isPSSysDBSchemeNameDirty();
            }
            case 11: {
                return pSSysDBProcBase.isUpdateDateDirty();
            }
            case 12: {
                return pSSysDBProcBase.isUpdateManDirty();
            }
            case 13: {
                return pSSysDBProcBase.isUserCatDirty();
            }
            case 14: {
                return pSSysDBProcBase.isUserTagDirty();
            }
            case 15: {
                return pSSysDBProcBase.isUserTag2Dirty();
            }
            case 16: {
                return pSSysDBProcBase.isUserTag3Dirty();
            }
            case 17: {
                return pSSysDBProcBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysDBProcBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysDBProcBase pSSysDBProcBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysDBProcBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysDBProcBase.getJSONValue((Object)pSSysDBProcBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysDBProcBase.getCodeName2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename2", (Object)PSSysDBProcBase.getJSONValue((Object)pSSysDBProcBase.getCodeName2()), (boolean)false);
        }
        if (bl || pSSysDBProcBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysDBProcBase.getJSONValue((Object)pSSysDBProcBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysDBProcBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysDBProcBase.getJSONValue((Object)pSSysDBProcBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysDBProcBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSSysDBProcBase.getJSONValue((Object)pSSysDBProcBase.getLogicName()), (boolean)false);
        }
        if (bl || pSSysDBProcBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysDBProcBase.getJSONValue((Object)pSSysDBProcBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysDBProcBase.getProcDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"procdesc", (Object)PSSysDBProcBase.getJSONValue((Object)pSSysDBProcBase.getProcDesc()), (boolean)false);
        }
        if (bl || pSSysDBProcBase.getPSSysDBProcId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbprocid", (Object)PSSysDBProcBase.getJSONValue((Object)pSSysDBProcBase.getPSSysDBProcId()), (boolean)false);
        }
        if (bl || pSSysDBProcBase.getPSSysDBProcName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbprocname", (Object)PSSysDBProcBase.getJSONValue((Object)pSSysDBProcBase.getPSSysDBProcName()), (boolean)false);
        }
        if (bl || pSSysDBProcBase.getPSSysDBSchemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbschemeid", (Object)PSSysDBProcBase.getJSONValue((Object)pSSysDBProcBase.getPSSysDBSchemeId()), (boolean)false);
        }
        if (bl || pSSysDBProcBase.getPSSysDBSchemeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbschemename", (Object)PSSysDBProcBase.getJSONValue((Object)pSSysDBProcBase.getPSSysDBSchemeName()), (boolean)false);
        }
        if (bl || pSSysDBProcBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysDBProcBase.getJSONValue((Object)pSSysDBProcBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysDBProcBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysDBProcBase.getJSONValue((Object)pSSysDBProcBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysDBProcBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysDBProcBase.getJSONValue((Object)pSSysDBProcBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysDBProcBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysDBProcBase.getJSONValue((Object)pSSysDBProcBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysDBProcBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysDBProcBase.getJSONValue((Object)pSSysDBProcBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysDBProcBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysDBProcBase.getJSONValue((Object)pSSysDBProcBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysDBProcBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysDBProcBase.getJSONValue((Object)pSSysDBProcBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysDBProcBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysDBProcBase pSSysDBProcBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysDBProcBase.getCodeName() != null) {
            object = pSSysDBProcBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSSysDBProcBase.getCodeName2() != null) {
            object = pSSysDBProcBase.getCodeName2();
            xmlNode.setAttribute(FIELD_CODENAME2, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBProcBase.getCreateDate() != null) {
            object = pSSysDBProcBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDBProcBase.getCreateMan() != null) {
            object = pSSysDBProcBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBProcBase.getLogicName() != null) {
            object = pSSysDBProcBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBProcBase.getMemo() != null) {
            object = pSSysDBProcBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBProcBase.getProcDesc() != null) {
            object = pSSysDBProcBase.getProcDesc();
            xmlNode.setAttribute(FIELD_PROCDESC, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBProcBase.getPSSysDBProcId() != null) {
            object = pSSysDBProcBase.getPSSysDBProcId();
            xmlNode.setAttribute(FIELD_PSSYSDBPROCID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBProcBase.getPSSysDBProcName() != null) {
            object = pSSysDBProcBase.getPSSysDBProcName();
            xmlNode.setAttribute(FIELD_PSSYSDBPROCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBProcBase.getPSSysDBSchemeId() != null) {
            object = pSSysDBProcBase.getPSSysDBSchemeId();
            xmlNode.setAttribute(FIELD_PSSYSDBSCHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBProcBase.getPSSysDBSchemeName() != null) {
            object = pSSysDBProcBase.getPSSysDBSchemeName();
            xmlNode.setAttribute(FIELD_PSSYSDBSCHEMENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBProcBase.getUpdateDate() != null) {
            object = pSSysDBProcBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDBProcBase.getUpdateMan() != null) {
            object = pSSysDBProcBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBProcBase.getUserCat() != null) {
            object = pSSysDBProcBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBProcBase.getUserTag() != null) {
            object = pSSysDBProcBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBProcBase.getUserTag2() != null) {
            object = pSSysDBProcBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBProcBase.getUserTag3() != null) {
            object = pSSysDBProcBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBProcBase.getUserTag4() != null) {
            object = pSSysDBProcBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysDBProcBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysDBProcBase pSSysDBProcBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysDBProcBase.isCodeNameDirty() && (bl || pSSysDBProcBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysDBProcBase.getCodeName());
        }
        if (pSSysDBProcBase.isCodeName2Dirty() && (bl || pSSysDBProcBase.getCodeName2() != null)) {
            iDataObject.set(FIELD_CODENAME2, (Object)pSSysDBProcBase.getCodeName2());
        }
        if (pSSysDBProcBase.isCreateDateDirty() && (bl || pSSysDBProcBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysDBProcBase.getCreateDate());
        }
        if (pSSysDBProcBase.isCreateManDirty() && (bl || pSSysDBProcBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysDBProcBase.getCreateMan());
        }
        if (pSSysDBProcBase.isLogicNameDirty() && (bl || pSSysDBProcBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSSysDBProcBase.getLogicName());
        }
        if (pSSysDBProcBase.isMemoDirty() && (bl || pSSysDBProcBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysDBProcBase.getMemo());
        }
        if (pSSysDBProcBase.isProcDescDirty() && (bl || pSSysDBProcBase.getProcDesc() != null)) {
            iDataObject.set(FIELD_PROCDESC, (Object)pSSysDBProcBase.getProcDesc());
        }
        if (pSSysDBProcBase.isPSSysDBProcIdDirty() && (bl || pSSysDBProcBase.getPSSysDBProcId() != null)) {
            iDataObject.set(FIELD_PSSYSDBPROCID, (Object)pSSysDBProcBase.getPSSysDBProcId());
        }
        if (pSSysDBProcBase.isPSSysDBProcNameDirty() && (bl || pSSysDBProcBase.getPSSysDBProcName() != null)) {
            iDataObject.set(FIELD_PSSYSDBPROCNAME, (Object)pSSysDBProcBase.getPSSysDBProcName());
        }
        if (pSSysDBProcBase.isPSSysDBSchemeIdDirty() && (bl || pSSysDBProcBase.getPSSysDBSchemeId() != null)) {
            iDataObject.set(FIELD_PSSYSDBSCHEMEID, (Object)pSSysDBProcBase.getPSSysDBSchemeId());
        }
        if (pSSysDBProcBase.isPSSysDBSchemeNameDirty() && (bl || pSSysDBProcBase.getPSSysDBSchemeName() != null)) {
            iDataObject.set(FIELD_PSSYSDBSCHEMENAME, (Object)pSSysDBProcBase.getPSSysDBSchemeName());
        }
        if (pSSysDBProcBase.isUpdateDateDirty() && (bl || pSSysDBProcBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysDBProcBase.getUpdateDate());
        }
        if (pSSysDBProcBase.isUpdateManDirty() && (bl || pSSysDBProcBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysDBProcBase.getUpdateMan());
        }
        if (pSSysDBProcBase.isUserCatDirty() && (bl || pSSysDBProcBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysDBProcBase.getUserCat());
        }
        if (pSSysDBProcBase.isUserTagDirty() && (bl || pSSysDBProcBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysDBProcBase.getUserTag());
        }
        if (pSSysDBProcBase.isUserTag2Dirty() && (bl || pSSysDBProcBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysDBProcBase.getUserTag2());
        }
        if (pSSysDBProcBase.isUserTag3Dirty() && (bl || pSSysDBProcBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysDBProcBase.getUserTag3());
        }
        if (pSSysDBProcBase.isUserTag4Dirty() && (bl || pSSysDBProcBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysDBProcBase.getUserTag4());
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
        return PSSysDBProcBase.remove(this, n);
    }

    private static boolean remove(PSSysDBProcBase pSSysDBProcBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysDBProcBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysDBProcBase.resetCodeName2();
                return true;
            }
            case 2: {
                pSSysDBProcBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSSysDBProcBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSSysDBProcBase.resetLogicName();
                return true;
            }
            case 5: {
                pSSysDBProcBase.resetMemo();
                return true;
            }
            case 6: {
                pSSysDBProcBase.resetProcDesc();
                return true;
            }
            case 7: {
                pSSysDBProcBase.resetPSSysDBProcId();
                return true;
            }
            case 8: {
                pSSysDBProcBase.resetPSSysDBProcName();
                return true;
            }
            case 9: {
                pSSysDBProcBase.resetPSSysDBSchemeId();
                return true;
            }
            case 10: {
                pSSysDBProcBase.resetPSSysDBSchemeName();
                return true;
            }
            case 11: {
                pSSysDBProcBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSSysDBProcBase.resetUpdateMan();
                return true;
            }
            case 13: {
                pSSysDBProcBase.resetUserCat();
                return true;
            }
            case 14: {
                pSSysDBProcBase.resetUserTag();
                return true;
            }
            case 15: {
                pSSysDBProcBase.resetUserTag2();
                return true;
            }
            case 16: {
                pSSysDBProcBase.resetUserTag3();
                return true;
            }
            case 17: {
                pSSysDBProcBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDBScheme getPSSysDBScheme() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBScheme();
        }
        if (this.getPSSysDBSchemeId() == null) {
            return null;
        }
        Integer n = this.objPSSysDBSchemeLock;
        synchronized (n) {
            if (this.pssysdbscheme != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDBSchemeId(), (Object)this.pssysdbscheme.getPSSysDBSchemeId()) != 0L) {
                this.pssysdbscheme = null;
            }
            if (this.pssysdbscheme == null) {
                PSSysDBScheme pSSysDBScheme = new PSSysDBScheme();
                pSSysDBScheme.setPSSysDBSchemeId(this.getPSSysDBSchemeId());
                PSSysDBSchemeService pSSysDBSchemeService = (PSSysDBSchemeService)ServiceGlobal.getService(PSSysDBSchemeService.class, (SessionFactory)this.getSessionFactory());
                pSSysDBSchemeService.autoGet((IEntity)pSSysDBScheme);
                this.pssysdbscheme = pSSysDBScheme;
            }
            return this.pssysdbscheme;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysDBProcParam> getPSSysDBProcParams() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBProcParams();
        }
        if (this.getPSSysDBProcId() == null) {
            return null;
        }
        PSSysDBProcParamService pSSysDBProcParamService = (PSSysDBProcParamService)ServiceGlobal.getService(PSSysDBProcParamService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysDBProcParamsLock;
        synchronized (n) {
            if (this.pssysdbprocparams == null) {
                this.pssysdbprocparams = pSSysDBProcParamService.selectByPSSysDBProc(this);
            }
            return this.pssysdbprocparams;
        }
    }

    private PSSysDBProcBase getProxyEntity() {
        return this.proxyPSSysDBProcBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysDBProcBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysDBProcBase) {
            this.proxyPSSysDBProcBase = (PSSysDBProcBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDBProcService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CODENAME2, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_LOGICNAME, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PROCDESC, 6);
        fieldIndexMap.put(FIELD_PSSYSDBPROCID, 7);
        fieldIndexMap.put(FIELD_PSSYSDBPROCNAME, 8);
        fieldIndexMap.put(FIELD_PSSYSDBSCHEMEID, 9);
        fieldIndexMap.put(FIELD_PSSYSDBSCHEMENAME, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
        fieldIndexMap.put(FIELD_USERCAT, 13);
        fieldIndexMap.put(FIELD_USERTAG, 14);
        fieldIndexMap.put(FIELD_USERTAG2, 15);
        fieldIndexMap.put(FIELD_USERTAG3, 16);
        fieldIndexMap.put(FIELD_USERTAG4, 17);
    }
}

