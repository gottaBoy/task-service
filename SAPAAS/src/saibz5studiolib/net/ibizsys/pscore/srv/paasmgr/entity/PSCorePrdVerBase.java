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
package net.ibizsys.pscore.srv.paasmgr.entity;

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
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrd;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdFunc;
import net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdFuncService;
import net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCorePrdVerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSCorePrdVerBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PLANPUBDATE = "PLANPUBDATE";
    public static final String FIELD_PSCOREPRDFUNCID = "PSCOREPRDFUNCID";
    public static final String FIELD_PSCOREPRDFUNCNAME = "PSCOREPRDFUNCNAME";
    public static final String FIELD_PSCOREPRDID = "PSCOREPRDID";
    public static final String FIELD_PSCOREPRDNAME = "PSCOREPRDNAME";
    public static final String FIELD_PSCOREPRDVERID = "PSCOREPRDVERID";
    public static final String FIELD_PSCOREPRDVERNAME = "PSCOREPRDVERNAME";
    public static final String FIELD_PUBDATE = "PUBDATE";
    public static final String FIELD_PUBSTATE = "PUBSTATE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VERSN = "VERSN";
    public static final String FIELD_VERTAG = "VERTAG";
    public static final String FIELD_VERTAG2 = "VERTAG2";
    public static final String FIELD_VERTYPE = "VERTYPE";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DEFAULTFLAG = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PLANPUBDATE = 4;
    private static final int INDEX_PSCOREPRDFUNCID = 5;
    private static final int INDEX_PSCOREPRDFUNCNAME = 6;
    private static final int INDEX_PSCOREPRDID = 7;
    private static final int INDEX_PSCOREPRDNAME = 8;
    private static final int INDEX_PSCOREPRDVERID = 9;
    private static final int INDEX_PSCOREPRDVERNAME = 10;
    private static final int INDEX_PUBDATE = 11;
    private static final int INDEX_PUBSTATE = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final int INDEX_VERSN = 15;
    private static final int INDEX_VERTAG = 16;
    private static final int INDEX_VERTAG2 = 17;
    private static final int INDEX_VERTYPE = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSCorePrdVerBase proxyPSCorePrdVerBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean planpubdateDirtyFlag = false;
    private boolean pscoreprdfuncidDirtyFlag = false;
    private boolean pscoreprdfuncnameDirtyFlag = false;
    private boolean pscoreprdidDirtyFlag = false;
    private boolean pscoreprdnameDirtyFlag = false;
    private boolean pscoreprdveridDirtyFlag = false;
    private boolean pscoreprdvernameDirtyFlag = false;
    private boolean pubdateDirtyFlag = false;
    private boolean pubstateDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean versnDirtyFlag = false;
    private boolean vertagDirtyFlag = false;
    private boolean vertag2DirtyFlag = false;
    private boolean vertypeDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="memo")
    private String memo;
    @Column(name="planpubdate")
    private Timestamp planpubdate;
    @Column(name="pscoreprdfuncid")
    private String pscoreprdfuncid;
    @Column(name="pscoreprdfuncname")
    private String pscoreprdfuncname;
    @Column(name="pscoreprdid")
    private String pscoreprdid;
    @Column(name="pscoreprdname")
    private String pscoreprdname;
    @Column(name="pscoreprdverid")
    private String pscoreprdverid;
    @Column(name="pscoreprdvername")
    private String pscoreprdvername;
    @Column(name="pubdate")
    private Timestamp pubdate;
    @Column(name="pubstate")
    private Integer pubstate;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="versn")
    private Integer versn;
    @Column(name="vertag")
    private String vertag;
    @Column(name="vertag2")
    private String vertag2;
    @Column(name="vertype")
    private String vertype;
    private Integer objPSCorePrdFuncLock = new Integer(1);
    private PSCorePrdFunc pscoreprdfunc = null;
    private Integer objPSCorePrdLock = new Integer(1);
    private PSCorePrd pscoreprd = null;

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

    public void setDefaultFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultFlag(n);
            return;
        }
        this.defaultflag = n;
        this.defaultflagDirtyFlag = true;
    }

    public Integer getDefaultFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultFlag();
        }
        return this.defaultflag;
    }

    public boolean isDefaultFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultFlagDirty();
        }
        return this.defaultflagDirtyFlag;
    }

    public void resetDefaultFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultFlag();
            return;
        }
        this.defaultflagDirtyFlag = false;
        this.defaultflag = null;
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

    public void setPlanPubDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPlanPubDate(timestamp);
            return;
        }
        this.planpubdate = timestamp;
        this.planpubdateDirtyFlag = true;
    }

    public Timestamp getPlanPubDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPlanPubDate();
        }
        return this.planpubdate;
    }

    public boolean isPlanPubDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPlanPubDateDirty();
        }
        return this.planpubdateDirtyFlag;
    }

    public void resetPlanPubDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPlanPubDate();
            return;
        }
        this.planpubdateDirtyFlag = false;
        this.planpubdate = null;
    }

    public void setPSCorePrdFuncId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdFuncId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdfuncid = string;
        this.pscoreprdfuncidDirtyFlag = true;
    }

    public String getPSCorePrdFuncId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdFuncId();
        }
        return this.pscoreprdfuncid;
    }

    public boolean isPSCorePrdFuncIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdFuncIdDirty();
        }
        return this.pscoreprdfuncidDirtyFlag;
    }

    public void resetPSCorePrdFuncId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdFuncId();
            return;
        }
        this.pscoreprdfuncidDirtyFlag = false;
        this.pscoreprdfuncid = null;
    }

    public void setPSCorePrdFuncName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdFuncName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdfuncname = string;
        this.pscoreprdfuncnameDirtyFlag = true;
    }

    public String getPSCorePrdFuncName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdFuncName();
        }
        return this.pscoreprdfuncname;
    }

    public boolean isPSCorePrdFuncNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdFuncNameDirty();
        }
        return this.pscoreprdfuncnameDirtyFlag;
    }

    public void resetPSCorePrdFuncName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdFuncName();
            return;
        }
        this.pscoreprdfuncnameDirtyFlag = false;
        this.pscoreprdfuncname = null;
    }

    public void setPSCorePrdId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdid = string;
        this.pscoreprdidDirtyFlag = true;
    }

    public String getPSCorePrdId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdId();
        }
        return this.pscoreprdid;
    }

    public boolean isPSCorePrdIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdIdDirty();
        }
        return this.pscoreprdidDirtyFlag;
    }

    public void resetPSCorePrdId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdId();
            return;
        }
        this.pscoreprdidDirtyFlag = false;
        this.pscoreprdid = null;
    }

    public void setPSCorePrdName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdname = string;
        this.pscoreprdnameDirtyFlag = true;
    }

    public String getPSCorePrdName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdName();
        }
        return this.pscoreprdname;
    }

    public boolean isPSCorePrdNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdNameDirty();
        }
        return this.pscoreprdnameDirtyFlag;
    }

    public void resetPSCorePrdName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdName();
            return;
        }
        this.pscoreprdnameDirtyFlag = false;
        this.pscoreprdname = null;
    }

    public void setPSCorePrdVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdverid = string;
        this.pscoreprdveridDirtyFlag = true;
    }

    public String getPSCorePrdVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdVerId();
        }
        return this.pscoreprdverid;
    }

    public boolean isPSCorePrdVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdVerIdDirty();
        }
        return this.pscoreprdveridDirtyFlag;
    }

    public void resetPSCorePrdVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdVerId();
            return;
        }
        this.pscoreprdveridDirtyFlag = false;
        this.pscoreprdverid = null;
    }

    public void setPSCorePrdVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdvername = string;
        this.pscoreprdvernameDirtyFlag = true;
    }

    public String getPSCorePrdVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdVerName();
        }
        return this.pscoreprdvername;
    }

    public boolean isPSCorePrdVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdVerNameDirty();
        }
        return this.pscoreprdvernameDirtyFlag;
    }

    public void resetPSCorePrdVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdVerName();
            return;
        }
        this.pscoreprdvernameDirtyFlag = false;
        this.pscoreprdvername = null;
    }

    public void setPubDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubDate(timestamp);
            return;
        }
        this.pubdate = timestamp;
        this.pubdateDirtyFlag = true;
    }

    public Timestamp getPubDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubDate();
        }
        return this.pubdate;
    }

    public boolean isPubDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubDateDirty();
        }
        return this.pubdateDirtyFlag;
    }

    public void resetPubDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubDate();
            return;
        }
        this.pubdateDirtyFlag = false;
        this.pubdate = null;
    }

    public void setPubState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubState(n);
            return;
        }
        this.pubstate = n;
        this.pubstateDirtyFlag = true;
    }

    public Integer getPubState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubState();
        }
        return this.pubstate;
    }

    public boolean isPubStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubStateDirty();
        }
        return this.pubstateDirtyFlag;
    }

    public void resetPubState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubState();
            return;
        }
        this.pubstateDirtyFlag = false;
        this.pubstate = null;
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

    public void setVerSN(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVerSN(n);
            return;
        }
        this.versn = n;
        this.versnDirtyFlag = true;
    }

    public Integer getVerSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVerSN();
        }
        return this.versn;
    }

    public boolean isVerSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVerSNDirty();
        }
        return this.versnDirtyFlag;
    }

    public void resetVerSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVerSN();
            return;
        }
        this.versnDirtyFlag = false;
        this.versn = null;
    }

    public void setVerTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVerTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.vertag = string;
        this.vertagDirtyFlag = true;
    }

    public String getVerTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVerTag();
        }
        return this.vertag;
    }

    public boolean isVerTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVerTagDirty();
        }
        return this.vertagDirtyFlag;
    }

    public void resetVerTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVerTag();
            return;
        }
        this.vertagDirtyFlag = false;
        this.vertag = null;
    }

    public void setVerTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVerTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.vertag2 = string;
        this.vertag2DirtyFlag = true;
    }

    public String getVerTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVerTag2();
        }
        return this.vertag2;
    }

    public boolean isVerTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVerTag2Dirty();
        }
        return this.vertag2DirtyFlag;
    }

    public void resetVerTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVerTag2();
            return;
        }
        this.vertag2DirtyFlag = false;
        this.vertag2 = null;
    }

    public void setVerType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVerType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.vertype = string;
        this.vertypeDirtyFlag = true;
    }

    public String getVerType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVerType();
        }
        return this.vertype;
    }

    public boolean isVerTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVerTypeDirty();
        }
        return this.vertypeDirtyFlag;
    }

    public void resetVerType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVerType();
            return;
        }
        this.vertypeDirtyFlag = false;
        this.vertype = null;
    }

    protected void onReset() {
        PSCorePrdVerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSCorePrdVerBase pSCorePrdVerBase) {
        pSCorePrdVerBase.resetCreateDate();
        pSCorePrdVerBase.resetCreateMan();
        pSCorePrdVerBase.resetDefaultFlag();
        pSCorePrdVerBase.resetMemo();
        pSCorePrdVerBase.resetPlanPubDate();
        pSCorePrdVerBase.resetPSCorePrdFuncId();
        pSCorePrdVerBase.resetPSCorePrdFuncName();
        pSCorePrdVerBase.resetPSCorePrdId();
        pSCorePrdVerBase.resetPSCorePrdName();
        pSCorePrdVerBase.resetPSCorePrdVerId();
        pSCorePrdVerBase.resetPSCorePrdVerName();
        pSCorePrdVerBase.resetPubDate();
        pSCorePrdVerBase.resetPubState();
        pSCorePrdVerBase.resetUpdateDate();
        pSCorePrdVerBase.resetUpdateMan();
        pSCorePrdVerBase.resetVerSN();
        pSCorePrdVerBase.resetVerTag();
        pSCorePrdVerBase.resetVerTag2();
        pSCorePrdVerBase.resetVerType();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPlanPubDateDirty()) {
            hashMap.put(FIELD_PLANPUBDATE, this.getPlanPubDate());
        }
        if (!bl || this.isPSCorePrdFuncIdDirty()) {
            hashMap.put(FIELD_PSCOREPRDFUNCID, this.getPSCorePrdFuncId());
        }
        if (!bl || this.isPSCorePrdFuncNameDirty()) {
            hashMap.put(FIELD_PSCOREPRDFUNCNAME, this.getPSCorePrdFuncName());
        }
        if (!bl || this.isPSCorePrdIdDirty()) {
            hashMap.put(FIELD_PSCOREPRDID, this.getPSCorePrdId());
        }
        if (!bl || this.isPSCorePrdNameDirty()) {
            hashMap.put(FIELD_PSCOREPRDNAME, this.getPSCorePrdName());
        }
        if (!bl || this.isPSCorePrdVerIdDirty()) {
            hashMap.put(FIELD_PSCOREPRDVERID, this.getPSCorePrdVerId());
        }
        if (!bl || this.isPSCorePrdVerNameDirty()) {
            hashMap.put(FIELD_PSCOREPRDVERNAME, this.getPSCorePrdVerName());
        }
        if (!bl || this.isPubDateDirty()) {
            hashMap.put(FIELD_PUBDATE, this.getPubDate());
        }
        if (!bl || this.isPubStateDirty()) {
            hashMap.put(FIELD_PUBSTATE, this.getPubState());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isVerSNDirty()) {
            hashMap.put(FIELD_VERSN, this.getVerSN());
        }
        if (!bl || this.isVerTagDirty()) {
            hashMap.put(FIELD_VERTAG, this.getVerTag());
        }
        if (!bl || this.isVerTag2Dirty()) {
            hashMap.put(FIELD_VERTAG2, this.getVerTag2());
        }
        if (!bl || this.isVerTypeDirty()) {
            hashMap.put(FIELD_VERTYPE, this.getVerType());
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
        return PSCorePrdVerBase.get(this, n);
    }

    private static Object get(PSCorePrdVerBase pSCorePrdVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCorePrdVerBase.getCreateDate();
            }
            case 1: {
                return pSCorePrdVerBase.getCreateMan();
            }
            case 2: {
                return pSCorePrdVerBase.getDefaultFlag();
            }
            case 3: {
                return pSCorePrdVerBase.getMemo();
            }
            case 4: {
                return pSCorePrdVerBase.getPlanPubDate();
            }
            case 5: {
                return pSCorePrdVerBase.getPSCorePrdFuncId();
            }
            case 6: {
                return pSCorePrdVerBase.getPSCorePrdFuncName();
            }
            case 7: {
                return pSCorePrdVerBase.getPSCorePrdId();
            }
            case 8: {
                return pSCorePrdVerBase.getPSCorePrdName();
            }
            case 9: {
                return pSCorePrdVerBase.getPSCorePrdVerId();
            }
            case 10: {
                return pSCorePrdVerBase.getPSCorePrdVerName();
            }
            case 11: {
                return pSCorePrdVerBase.getPubDate();
            }
            case 12: {
                return pSCorePrdVerBase.getPubState();
            }
            case 13: {
                return pSCorePrdVerBase.getUpdateDate();
            }
            case 14: {
                return pSCorePrdVerBase.getUpdateMan();
            }
            case 15: {
                return pSCorePrdVerBase.getVerSN();
            }
            case 16: {
                return pSCorePrdVerBase.getVerTag();
            }
            case 17: {
                return pSCorePrdVerBase.getVerTag2();
            }
            case 18: {
                return pSCorePrdVerBase.getVerType();
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
        PSCorePrdVerBase.set(this, n, object);
    }

    private static void set(PSCorePrdVerBase pSCorePrdVerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSCorePrdVerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSCorePrdVerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSCorePrdVerBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSCorePrdVerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSCorePrdVerBase.setPlanPubDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSCorePrdVerBase.setPSCorePrdFuncId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSCorePrdVerBase.setPSCorePrdFuncName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSCorePrdVerBase.setPSCorePrdId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSCorePrdVerBase.setPSCorePrdName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSCorePrdVerBase.setPSCorePrdVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSCorePrdVerBase.setPSCorePrdVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSCorePrdVerBase.setPubDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSCorePrdVerBase.setPubState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSCorePrdVerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSCorePrdVerBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSCorePrdVerBase.setVerSN(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSCorePrdVerBase.setVerTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSCorePrdVerBase.setVerTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSCorePrdVerBase.setVerType(DataObject.getStringValue((Object)object));
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
        return PSCorePrdVerBase.isNull(this, n);
    }

    private static boolean isNull(PSCorePrdVerBase pSCorePrdVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCorePrdVerBase.getCreateDate() == null;
            }
            case 1: {
                return pSCorePrdVerBase.getCreateMan() == null;
            }
            case 2: {
                return pSCorePrdVerBase.getDefaultFlag() == null;
            }
            case 3: {
                return pSCorePrdVerBase.getMemo() == null;
            }
            case 4: {
                return pSCorePrdVerBase.getPlanPubDate() == null;
            }
            case 5: {
                return pSCorePrdVerBase.getPSCorePrdFuncId() == null;
            }
            case 6: {
                return pSCorePrdVerBase.getPSCorePrdFuncName() == null;
            }
            case 7: {
                return pSCorePrdVerBase.getPSCorePrdId() == null;
            }
            case 8: {
                return pSCorePrdVerBase.getPSCorePrdName() == null;
            }
            case 9: {
                return pSCorePrdVerBase.getPSCorePrdVerId() == null;
            }
            case 10: {
                return pSCorePrdVerBase.getPSCorePrdVerName() == null;
            }
            case 11: {
                return pSCorePrdVerBase.getPubDate() == null;
            }
            case 12: {
                return pSCorePrdVerBase.getPubState() == null;
            }
            case 13: {
                return pSCorePrdVerBase.getUpdateDate() == null;
            }
            case 14: {
                return pSCorePrdVerBase.getUpdateMan() == null;
            }
            case 15: {
                return pSCorePrdVerBase.getVerSN() == null;
            }
            case 16: {
                return pSCorePrdVerBase.getVerTag() == null;
            }
            case 17: {
                return pSCorePrdVerBase.getVerTag2() == null;
            }
            case 18: {
                return pSCorePrdVerBase.getVerType() == null;
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
        return PSCorePrdVerBase.contains(this, n);
    }

    private static boolean contains(PSCorePrdVerBase pSCorePrdVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCorePrdVerBase.isCreateDateDirty();
            }
            case 1: {
                return pSCorePrdVerBase.isCreateManDirty();
            }
            case 2: {
                return pSCorePrdVerBase.isDefaultFlagDirty();
            }
            case 3: {
                return pSCorePrdVerBase.isMemoDirty();
            }
            case 4: {
                return pSCorePrdVerBase.isPlanPubDateDirty();
            }
            case 5: {
                return pSCorePrdVerBase.isPSCorePrdFuncIdDirty();
            }
            case 6: {
                return pSCorePrdVerBase.isPSCorePrdFuncNameDirty();
            }
            case 7: {
                return pSCorePrdVerBase.isPSCorePrdIdDirty();
            }
            case 8: {
                return pSCorePrdVerBase.isPSCorePrdNameDirty();
            }
            case 9: {
                return pSCorePrdVerBase.isPSCorePrdVerIdDirty();
            }
            case 10: {
                return pSCorePrdVerBase.isPSCorePrdVerNameDirty();
            }
            case 11: {
                return pSCorePrdVerBase.isPubDateDirty();
            }
            case 12: {
                return pSCorePrdVerBase.isPubStateDirty();
            }
            case 13: {
                return pSCorePrdVerBase.isUpdateDateDirty();
            }
            case 14: {
                return pSCorePrdVerBase.isUpdateManDirty();
            }
            case 15: {
                return pSCorePrdVerBase.isVerSNDirty();
            }
            case 16: {
                return pSCorePrdVerBase.isVerTagDirty();
            }
            case 17: {
                return pSCorePrdVerBase.isVerTag2Dirty();
            }
            case 18: {
                return pSCorePrdVerBase.isVerTypeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSCorePrdVerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSCorePrdVerBase pSCorePrdVerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSCorePrdVerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSCorePrdVerBase.getJSONValue((Object)pSCorePrdVerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSCorePrdVerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSCorePrdVerBase.getJSONValue((Object)pSCorePrdVerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSCorePrdVerBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSCorePrdVerBase.getJSONValue((Object)pSCorePrdVerBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSCorePrdVerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSCorePrdVerBase.getJSONValue((Object)pSCorePrdVerBase.getMemo()), (boolean)false);
        }
        if (bl || pSCorePrdVerBase.getPlanPubDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"planpubdate", (Object)PSCorePrdVerBase.getJSONValue((Object)pSCorePrdVerBase.getPlanPubDate()), (boolean)false);
        }
        if (bl || pSCorePrdVerBase.getPSCorePrdFuncId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdfuncid", (Object)PSCorePrdVerBase.getJSONValue((Object)pSCorePrdVerBase.getPSCorePrdFuncId()), (boolean)false);
        }
        if (bl || pSCorePrdVerBase.getPSCorePrdFuncName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdfuncname", (Object)PSCorePrdVerBase.getJSONValue((Object)pSCorePrdVerBase.getPSCorePrdFuncName()), (boolean)false);
        }
        if (bl || pSCorePrdVerBase.getPSCorePrdId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdid", (Object)PSCorePrdVerBase.getJSONValue((Object)pSCorePrdVerBase.getPSCorePrdId()), (boolean)false);
        }
        if (bl || pSCorePrdVerBase.getPSCorePrdName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdname", (Object)PSCorePrdVerBase.getJSONValue((Object)pSCorePrdVerBase.getPSCorePrdName()), (boolean)false);
        }
        if (bl || pSCorePrdVerBase.getPSCorePrdVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdverid", (Object)PSCorePrdVerBase.getJSONValue((Object)pSCorePrdVerBase.getPSCorePrdVerId()), (boolean)false);
        }
        if (bl || pSCorePrdVerBase.getPSCorePrdVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdvername", (Object)PSCorePrdVerBase.getJSONValue((Object)pSCorePrdVerBase.getPSCorePrdVerName()), (boolean)false);
        }
        if (bl || pSCorePrdVerBase.getPubDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubdate", (Object)PSCorePrdVerBase.getJSONValue((Object)pSCorePrdVerBase.getPubDate()), (boolean)false);
        }
        if (bl || pSCorePrdVerBase.getPubState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubstate", (Object)PSCorePrdVerBase.getJSONValue((Object)pSCorePrdVerBase.getPubState()), (boolean)false);
        }
        if (bl || pSCorePrdVerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSCorePrdVerBase.getJSONValue((Object)pSCorePrdVerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSCorePrdVerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSCorePrdVerBase.getJSONValue((Object)pSCorePrdVerBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSCorePrdVerBase.getVerSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"versn", (Object)PSCorePrdVerBase.getJSONValue((Object)pSCorePrdVerBase.getVerSN()), (boolean)false);
        }
        if (bl || pSCorePrdVerBase.getVerTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"vertag", (Object)PSCorePrdVerBase.getJSONValue((Object)pSCorePrdVerBase.getVerTag()), (boolean)false);
        }
        if (bl || pSCorePrdVerBase.getVerTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"vertag2", (Object)PSCorePrdVerBase.getJSONValue((Object)pSCorePrdVerBase.getVerTag2()), (boolean)false);
        }
        if (bl || pSCorePrdVerBase.getVerType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"vertype", (Object)PSCorePrdVerBase.getJSONValue((Object)pSCorePrdVerBase.getVerType()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSCorePrdVerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSCorePrdVerBase pSCorePrdVerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSCorePrdVerBase.getCreateDate() != null) {
            object = pSCorePrdVerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCorePrdVerBase.getCreateMan() != null) {
            object = pSCorePrdVerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdVerBase.getDefaultFlag() != null) {
            object = pSCorePrdVerBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCorePrdVerBase.getMemo() != null) {
            object = pSCorePrdVerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdVerBase.getPlanPubDate() != null) {
            object = pSCorePrdVerBase.getPlanPubDate();
            xmlNode.setAttribute(FIELD_PLANPUBDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCorePrdVerBase.getPSCorePrdFuncId() != null) {
            object = pSCorePrdVerBase.getPSCorePrdFuncId();
            xmlNode.setAttribute(FIELD_PSCOREPRDFUNCID, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdVerBase.getPSCorePrdFuncName() != null) {
            object = pSCorePrdVerBase.getPSCorePrdFuncName();
            xmlNode.setAttribute(FIELD_PSCOREPRDFUNCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdVerBase.getPSCorePrdId() != null) {
            object = pSCorePrdVerBase.getPSCorePrdId();
            xmlNode.setAttribute(FIELD_PSCOREPRDID, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdVerBase.getPSCorePrdName() != null) {
            object = pSCorePrdVerBase.getPSCorePrdName();
            xmlNode.setAttribute(FIELD_PSCOREPRDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdVerBase.getPSCorePrdVerId() != null) {
            object = pSCorePrdVerBase.getPSCorePrdVerId();
            xmlNode.setAttribute(FIELD_PSCOREPRDVERID, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdVerBase.getPSCorePrdVerName() != null) {
            object = pSCorePrdVerBase.getPSCorePrdVerName();
            xmlNode.setAttribute(FIELD_PSCOREPRDVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdVerBase.getPubDate() != null) {
            object = pSCorePrdVerBase.getPubDate();
            xmlNode.setAttribute(FIELD_PUBDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCorePrdVerBase.getPubState() != null) {
            object = pSCorePrdVerBase.getPubState();
            xmlNode.setAttribute(FIELD_PUBSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCorePrdVerBase.getUpdateDate() != null) {
            object = pSCorePrdVerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCorePrdVerBase.getUpdateMan() != null) {
            object = pSCorePrdVerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdVerBase.getVerSN() != null) {
            object = pSCorePrdVerBase.getVerSN();
            xmlNode.setAttribute(FIELD_VERSN, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCorePrdVerBase.getVerTag() != null) {
            object = pSCorePrdVerBase.getVerTag();
            xmlNode.setAttribute(FIELD_VERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdVerBase.getVerTag2() != null) {
            object = pSCorePrdVerBase.getVerTag2();
            xmlNode.setAttribute(FIELD_VERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdVerBase.getVerType() != null) {
            object = pSCorePrdVerBase.getVerType();
            xmlNode.setAttribute(FIELD_VERTYPE, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSCorePrdVerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSCorePrdVerBase pSCorePrdVerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSCorePrdVerBase.isCreateDateDirty() && (bl || pSCorePrdVerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSCorePrdVerBase.getCreateDate());
        }
        if (pSCorePrdVerBase.isCreateManDirty() && (bl || pSCorePrdVerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSCorePrdVerBase.getCreateMan());
        }
        if (pSCorePrdVerBase.isDefaultFlagDirty() && (bl || pSCorePrdVerBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSCorePrdVerBase.getDefaultFlag());
        }
        if (pSCorePrdVerBase.isMemoDirty() && (bl || pSCorePrdVerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSCorePrdVerBase.getMemo());
        }
        if (pSCorePrdVerBase.isPlanPubDateDirty() && (bl || pSCorePrdVerBase.getPlanPubDate() != null)) {
            iDataObject.set(FIELD_PLANPUBDATE, (Object)pSCorePrdVerBase.getPlanPubDate());
        }
        if (pSCorePrdVerBase.isPSCorePrdFuncIdDirty() && (bl || pSCorePrdVerBase.getPSCorePrdFuncId() != null)) {
            iDataObject.set(FIELD_PSCOREPRDFUNCID, (Object)pSCorePrdVerBase.getPSCorePrdFuncId());
        }
        if (pSCorePrdVerBase.isPSCorePrdFuncNameDirty() && (bl || pSCorePrdVerBase.getPSCorePrdFuncName() != null)) {
            iDataObject.set(FIELD_PSCOREPRDFUNCNAME, (Object)pSCorePrdVerBase.getPSCorePrdFuncName());
        }
        if (pSCorePrdVerBase.isPSCorePrdIdDirty() && (bl || pSCorePrdVerBase.getPSCorePrdId() != null)) {
            iDataObject.set(FIELD_PSCOREPRDID, (Object)pSCorePrdVerBase.getPSCorePrdId());
        }
        if (pSCorePrdVerBase.isPSCorePrdNameDirty() && (bl || pSCorePrdVerBase.getPSCorePrdName() != null)) {
            iDataObject.set(FIELD_PSCOREPRDNAME, (Object)pSCorePrdVerBase.getPSCorePrdName());
        }
        if (pSCorePrdVerBase.isPSCorePrdVerIdDirty() && (bl || pSCorePrdVerBase.getPSCorePrdVerId() != null)) {
            iDataObject.set(FIELD_PSCOREPRDVERID, (Object)pSCorePrdVerBase.getPSCorePrdVerId());
        }
        if (pSCorePrdVerBase.isPSCorePrdVerNameDirty() && (bl || pSCorePrdVerBase.getPSCorePrdVerName() != null)) {
            iDataObject.set(FIELD_PSCOREPRDVERNAME, (Object)pSCorePrdVerBase.getPSCorePrdVerName());
        }
        if (pSCorePrdVerBase.isPubDateDirty() && (bl || pSCorePrdVerBase.getPubDate() != null)) {
            iDataObject.set(FIELD_PUBDATE, (Object)pSCorePrdVerBase.getPubDate());
        }
        if (pSCorePrdVerBase.isPubStateDirty() && (bl || pSCorePrdVerBase.getPubState() != null)) {
            iDataObject.set(FIELD_PUBSTATE, (Object)pSCorePrdVerBase.getPubState());
        }
        if (pSCorePrdVerBase.isUpdateDateDirty() && (bl || pSCorePrdVerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSCorePrdVerBase.getUpdateDate());
        }
        if (pSCorePrdVerBase.isUpdateManDirty() && (bl || pSCorePrdVerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSCorePrdVerBase.getUpdateMan());
        }
        if (pSCorePrdVerBase.isVerSNDirty() && (bl || pSCorePrdVerBase.getVerSN() != null)) {
            iDataObject.set(FIELD_VERSN, (Object)pSCorePrdVerBase.getVerSN());
        }
        if (pSCorePrdVerBase.isVerTagDirty() && (bl || pSCorePrdVerBase.getVerTag() != null)) {
            iDataObject.set(FIELD_VERTAG, (Object)pSCorePrdVerBase.getVerTag());
        }
        if (pSCorePrdVerBase.isVerTag2Dirty() && (bl || pSCorePrdVerBase.getVerTag2() != null)) {
            iDataObject.set(FIELD_VERTAG2, (Object)pSCorePrdVerBase.getVerTag2());
        }
        if (pSCorePrdVerBase.isVerTypeDirty() && (bl || pSCorePrdVerBase.getVerType() != null)) {
            iDataObject.set(FIELD_VERTYPE, (Object)pSCorePrdVerBase.getVerType());
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
        return PSCorePrdVerBase.remove(this, n);
    }

    private static boolean remove(PSCorePrdVerBase pSCorePrdVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSCorePrdVerBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSCorePrdVerBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSCorePrdVerBase.resetDefaultFlag();
                return true;
            }
            case 3: {
                pSCorePrdVerBase.resetMemo();
                return true;
            }
            case 4: {
                pSCorePrdVerBase.resetPlanPubDate();
                return true;
            }
            case 5: {
                pSCorePrdVerBase.resetPSCorePrdFuncId();
                return true;
            }
            case 6: {
                pSCorePrdVerBase.resetPSCorePrdFuncName();
                return true;
            }
            case 7: {
                pSCorePrdVerBase.resetPSCorePrdId();
                return true;
            }
            case 8: {
                pSCorePrdVerBase.resetPSCorePrdName();
                return true;
            }
            case 9: {
                pSCorePrdVerBase.resetPSCorePrdVerId();
                return true;
            }
            case 10: {
                pSCorePrdVerBase.resetPSCorePrdVerName();
                return true;
            }
            case 11: {
                pSCorePrdVerBase.resetPubDate();
                return true;
            }
            case 12: {
                pSCorePrdVerBase.resetPubState();
                return true;
            }
            case 13: {
                pSCorePrdVerBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSCorePrdVerBase.resetUpdateMan();
                return true;
            }
            case 15: {
                pSCorePrdVerBase.resetVerSN();
                return true;
            }
            case 16: {
                pSCorePrdVerBase.resetVerTag();
                return true;
            }
            case 17: {
                pSCorePrdVerBase.resetVerTag2();
                return true;
            }
            case 18: {
                pSCorePrdVerBase.resetVerType();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCorePrdFunc getPSCorePrdFunc() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdFunc();
        }
        if (this.getPSCorePrdFuncId() == null) {
            return null;
        }
        Integer n = this.objPSCorePrdFuncLock;
        synchronized (n) {
            if (this.pscoreprdfunc != null && DataTypeHelper.compare((int)25, (Object)this.getPSCorePrdFuncId(), (Object)this.pscoreprdfunc.getPSCorePrdFuncId()) != 0L) {
                this.pscoreprdfunc = null;
            }
            if (this.pscoreprdfunc == null) {
                PSCorePrdFunc pSCorePrdFunc = new PSCorePrdFunc();
                pSCorePrdFunc.setPSCorePrdFuncId(this.getPSCorePrdFuncId());
                PSCorePrdFuncService pSCorePrdFuncService = (PSCorePrdFuncService)ServiceGlobal.getService(PSCorePrdFuncService.class, (SessionFactory)this.getSessionFactory());
                pSCorePrdFuncService.autoGet((IEntity)pSCorePrdFunc);
                this.pscoreprdfunc = pSCorePrdFunc;
            }
            return this.pscoreprdfunc;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCorePrd getPSCorePrd() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrd();
        }
        if (this.getPSCorePrdId() == null) {
            return null;
        }
        Integer n = this.objPSCorePrdLock;
        synchronized (n) {
            if (this.pscoreprd != null && DataTypeHelper.compare((int)25, (Object)this.getPSCorePrdId(), (Object)this.pscoreprd.getPSCorePrdId()) != 0L) {
                this.pscoreprd = null;
            }
            if (this.pscoreprd == null) {
                PSCorePrd pSCorePrd = new PSCorePrd();
                pSCorePrd.setPSCorePrdId(this.getPSCorePrdId());
                PSCorePrdService pSCorePrdService = (PSCorePrdService)ServiceGlobal.getService(PSCorePrdService.class, (SessionFactory)this.getSessionFactory());
                pSCorePrdService.autoGet((IEntity)pSCorePrd);
                this.pscoreprd = pSCorePrd;
            }
            return this.pscoreprd;
        }
    }

    private PSCorePrdVerBase getProxyEntity() {
        return this.proxyPSCorePrdVerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSCorePrdVerBase = null;
        if (iDataObject != null && iDataObject instanceof PSCorePrdVerBase) {
            this.proxyPSCorePrdVerBase = (PSCorePrdVerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdVerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PLANPUBDATE, 4);
        fieldIndexMap.put(FIELD_PSCOREPRDFUNCID, 5);
        fieldIndexMap.put(FIELD_PSCOREPRDFUNCNAME, 6);
        fieldIndexMap.put(FIELD_PSCOREPRDID, 7);
        fieldIndexMap.put(FIELD_PSCOREPRDNAME, 8);
        fieldIndexMap.put(FIELD_PSCOREPRDVERID, 9);
        fieldIndexMap.put(FIELD_PSCOREPRDVERNAME, 10);
        fieldIndexMap.put(FIELD_PUBDATE, 11);
        fieldIndexMap.put(FIELD_PUBSTATE, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
        fieldIndexMap.put(FIELD_VERSN, 15);
        fieldIndexMap.put(FIELD_VERTAG, 16);
        fieldIndexMap.put(FIELD_VERTAG2, 17);
        fieldIndexMap.put(FIELD_VERTYPE, 18);
    }
}

