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
package net.ibizsys.pscore.srv.devcenter.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCCodeSnippetRef;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDCCodeSnippetRefService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipeline;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCCodeSnippetBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCCodeSnippetBase.class);
    public static final String FIELD_ALLDCFLAG = "ALLDCFLAG";
    public static final String FIELD_CODECAT = "CODECAT";
    public static final String FIELD_CODETARGET = "CODETARGET";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_KEYWORDS = "KEYWORDS";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCCODESNIPPETID = "PSDCCODESNIPPETID";
    public static final String FIELD_PSDCCODESNIPPETNAME = "PSDCCODESNIPPETNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_REFMODE = "REFMODE";
    public static final String FIELD_TEMPLCODE = "TEMPLCODE";
    public static final String FIELD_TEMPLCODE2 = "TEMPLCODE2";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_ALLDCFLAG = 0;
    private static final int INDEX_CODECAT = 1;
    private static final int INDEX_CODETARGET = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_KEYWORDS = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_PSDCCODESNIPPETID = 7;
    private static final int INDEX_PSDCCODESNIPPETNAME = 8;
    private static final int INDEX_PSDEVCENTERID = 9;
    private static final int INDEX_PSDEVCENTERNAME = 10;
    private static final int INDEX_PSDEVSLNID = 11;
    private static final int INDEX_PSDEVSLNNAME = 12;
    private static final int INDEX_REFMODE = 13;
    private static final int INDEX_TEMPLCODE = 14;
    private static final int INDEX_TEMPLCODE2 = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCCodeSnippetBase proxyPSDCCodeSnippetBase = null;
    private boolean alldcflagDirtyFlag = false;
    private boolean codecatDirtyFlag = false;
    private boolean codetargetDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean keywordsDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdccodesnippetidDirtyFlag = false;
    private boolean psdccodesnippetnameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean refmodeDirtyFlag = false;
    private boolean templcodeDirtyFlag = false;
    private boolean templcode2DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="alldcflag")
    private Integer alldcflag;
    @Column(name="codecat")
    private String codecat;
    @Column(name="codetarget")
    private String codetarget;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="keywords")
    private String keywords;
    @Column(name="memo")
    private String memo;
    @Column(name="psdccodesnippetid")
    private String psdccodesnippetid;
    @Column(name="psdccodesnippetname")
    private String psdccodesnippetname;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="refmode")
    private String refmode;
    @Column(name="templcode")
    private String templcode;
    @Column(name="templcode2")
    private String templcode2;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;
    private Integer objPSDCCodeSnippetRefLock = new Integer(1);
    private ArrayList<PSDCCodeSnippetRef> psdccodesnippetref = null;
    private Integer objPSDevSlnPipelinesLock = new Integer(1);
    private ArrayList<PSDevSlnPipeline> psdevslnpipelines = null;

    public void setAllDCFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAllDCFlag(n);
            return;
        }
        this.alldcflag = n;
        this.alldcflagDirtyFlag = true;
    }

    public Integer getAllDCFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAllDCFlag();
        }
        return this.alldcflag;
    }

    public boolean isAllDCFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAllDCFlagDirty();
        }
        return this.alldcflagDirtyFlag;
    }

    public void resetAllDCFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAllDCFlag();
            return;
        }
        this.alldcflagDirtyFlag = false;
        this.alldcflag = null;
    }

    public void setCodeCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codecat = string;
        this.codecatDirtyFlag = true;
    }

    public String getCodeCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeCat();
        }
        return this.codecat;
    }

    public boolean isCodeCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeCatDirty();
        }
        return this.codecatDirtyFlag;
    }

    public void resetCodeCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeCat();
            return;
        }
        this.codecatDirtyFlag = false;
        this.codecat = null;
    }

    public void setCodeTarget(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeTarget(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codetarget = string;
        this.codetargetDirtyFlag = true;
    }

    public String getCodeTarget() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeTarget();
        }
        return this.codetarget;
    }

    public boolean isCodeTargetDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeTargetDirty();
        }
        return this.codetargetDirtyFlag;
    }

    public void resetCodeTarget() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeTarget();
            return;
        }
        this.codetargetDirtyFlag = false;
        this.codetarget = null;
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

    public void setKeywords(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKeywords(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.keywords = string;
        this.keywordsDirtyFlag = true;
    }

    public String getKeywords() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKeywords();
        }
        return this.keywords;
    }

    public boolean isKeywordsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKeywordsDirty();
        }
        return this.keywordsDirtyFlag;
    }

    public void resetKeywords() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKeywords();
            return;
        }
        this.keywordsDirtyFlag = false;
        this.keywords = null;
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

    public void setPSDCCodeSnippetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCCodeSnippetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdccodesnippetid = string;
        this.psdccodesnippetidDirtyFlag = true;
    }

    public String getPSDCCodeSnippetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCCodeSnippetId();
        }
        return this.psdccodesnippetid;
    }

    public boolean isPSDCCodeSnippetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCCodeSnippetIdDirty();
        }
        return this.psdccodesnippetidDirtyFlag;
    }

    public void resetPSDCCodeSnippetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCCodeSnippetId();
            return;
        }
        this.psdccodesnippetidDirtyFlag = false;
        this.psdccodesnippetid = null;
    }

    public void setPSDCCodeSnippetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCCodeSnippetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdccodesnippetname = string;
        this.psdccodesnippetnameDirtyFlag = true;
    }

    public String getPSDCCodeSnippetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCCodeSnippetName();
        }
        return this.psdccodesnippetname;
    }

    public boolean isPSDCCodeSnippetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCCodeSnippetNameDirty();
        }
        return this.psdccodesnippetnameDirtyFlag;
    }

    public void resetPSDCCodeSnippetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCCodeSnippetName();
            return;
        }
        this.psdccodesnippetnameDirtyFlag = false;
        this.psdccodesnippetname = null;
    }

    public void setPSDevCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterid = string;
        this.psdevcenteridDirtyFlag = true;
    }

    public String getPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterId();
        }
        return this.psdevcenterid;
    }

    public boolean isPSDevCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterIdDirty();
        }
        return this.psdevcenteridDirtyFlag;
    }

    public void resetPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterId();
            return;
        }
        this.psdevcenteridDirtyFlag = false;
        this.psdevcenterid = null;
    }

    public void setPSDevCenterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentername = string;
        this.psdevcenternameDirtyFlag = true;
    }

    public String getPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterName();
        }
        return this.psdevcentername;
    }

    public boolean isPSDevCenterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterNameDirty();
        }
        return this.psdevcenternameDirtyFlag;
    }

    public void resetPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterName();
            return;
        }
        this.psdevcenternameDirtyFlag = false;
        this.psdevcentername = null;
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

    public void setRefMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refmode = string;
        this.refmodeDirtyFlag = true;
    }

    public String getRefMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefMode();
        }
        return this.refmode;
    }

    public boolean isRefModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefModeDirty();
        }
        return this.refmodeDirtyFlag;
    }

    public void resetRefMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefMode();
            return;
        }
        this.refmodeDirtyFlag = false;
        this.refmode = null;
    }

    public void setTemplCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templcode = string;
        this.templcodeDirtyFlag = true;
    }

    public String getTemplCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCode();
        }
        return this.templcode;
    }

    public boolean isTemplCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCodeDirty();
        }
        return this.templcodeDirtyFlag;
    }

    public void resetTemplCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCode();
            return;
        }
        this.templcodeDirtyFlag = false;
        this.templcode = null;
    }

    public void setTemplCode2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCode2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templcode2 = string;
        this.templcode2DirtyFlag = true;
    }

    public String getTemplCode2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCode2();
        }
        return this.templcode2;
    }

    public boolean isTemplCode2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCode2Dirty();
        }
        return this.templcode2DirtyFlag;
    }

    public void resetTemplCode2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCode2();
            return;
        }
        this.templcode2DirtyFlag = false;
        this.templcode2 = null;
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

    protected void onReset() {
        PSDCCodeSnippetBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCCodeSnippetBase pSDCCodeSnippetBase) {
        pSDCCodeSnippetBase.resetAllDCFlag();
        pSDCCodeSnippetBase.resetCodeCat();
        pSDCCodeSnippetBase.resetCodeTarget();
        pSDCCodeSnippetBase.resetCreateDate();
        pSDCCodeSnippetBase.resetCreateMan();
        pSDCCodeSnippetBase.resetKeywords();
        pSDCCodeSnippetBase.resetMemo();
        pSDCCodeSnippetBase.resetPSDCCodeSnippetId();
        pSDCCodeSnippetBase.resetPSDCCodeSnippetName();
        pSDCCodeSnippetBase.resetPSDevCenterId();
        pSDCCodeSnippetBase.resetPSDevCenterName();
        pSDCCodeSnippetBase.resetPSDevSlnId();
        pSDCCodeSnippetBase.resetPSDevSlnName();
        pSDCCodeSnippetBase.resetRefMode();
        pSDCCodeSnippetBase.resetTemplCode();
        pSDCCodeSnippetBase.resetTemplCode2();
        pSDCCodeSnippetBase.resetUpdateDate();
        pSDCCodeSnippetBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAllDCFlagDirty()) {
            hashMap.put(FIELD_ALLDCFLAG, this.getAllDCFlag());
        }
        if (!bl || this.isCodeCatDirty()) {
            hashMap.put(FIELD_CODECAT, this.getCodeCat());
        }
        if (!bl || this.isCodeTargetDirty()) {
            hashMap.put(FIELD_CODETARGET, this.getCodeTarget());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isKeywordsDirty()) {
            hashMap.put(FIELD_KEYWORDS, this.getKeywords());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDCCodeSnippetIdDirty()) {
            hashMap.put(FIELD_PSDCCODESNIPPETID, this.getPSDCCodeSnippetId());
        }
        if (!bl || this.isPSDCCodeSnippetNameDirty()) {
            hashMap.put(FIELD_PSDCCODESNIPPETNAME, this.getPSDCCodeSnippetName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNNAME, this.getPSDevSlnName());
        }
        if (!bl || this.isRefModeDirty()) {
            hashMap.put(FIELD_REFMODE, this.getRefMode());
        }
        if (!bl || this.isTemplCodeDirty()) {
            hashMap.put(FIELD_TEMPLCODE, this.getTemplCode());
        }
        if (!bl || this.isTemplCode2Dirty()) {
            hashMap.put(FIELD_TEMPLCODE2, this.getTemplCode2());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSDCCodeSnippetBase.get(this, n);
    }

    private static Object get(PSDCCodeSnippetBase pSDCCodeSnippetBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCCodeSnippetBase.getAllDCFlag();
            }
            case 1: {
                return pSDCCodeSnippetBase.getCodeCat();
            }
            case 2: {
                return pSDCCodeSnippetBase.getCodeTarget();
            }
            case 3: {
                return pSDCCodeSnippetBase.getCreateDate();
            }
            case 4: {
                return pSDCCodeSnippetBase.getCreateMan();
            }
            case 5: {
                return pSDCCodeSnippetBase.getKeywords();
            }
            case 6: {
                return pSDCCodeSnippetBase.getMemo();
            }
            case 7: {
                return pSDCCodeSnippetBase.getPSDCCodeSnippetId();
            }
            case 8: {
                return pSDCCodeSnippetBase.getPSDCCodeSnippetName();
            }
            case 9: {
                return pSDCCodeSnippetBase.getPSDevCenterId();
            }
            case 10: {
                return pSDCCodeSnippetBase.getPSDevCenterName();
            }
            case 11: {
                return pSDCCodeSnippetBase.getPSDevSlnId();
            }
            case 12: {
                return pSDCCodeSnippetBase.getPSDevSlnName();
            }
            case 13: {
                return pSDCCodeSnippetBase.getRefMode();
            }
            case 14: {
                return pSDCCodeSnippetBase.getTemplCode();
            }
            case 15: {
                return pSDCCodeSnippetBase.getTemplCode2();
            }
            case 16: {
                return pSDCCodeSnippetBase.getUpdateDate();
            }
            case 17: {
                return pSDCCodeSnippetBase.getUpdateMan();
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
        PSDCCodeSnippetBase.set(this, n, object);
    }

    private static void set(PSDCCodeSnippetBase pSDCCodeSnippetBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCCodeSnippetBase.setAllDCFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDCCodeSnippetBase.setCodeCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCCodeSnippetBase.setCodeTarget(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCCodeSnippetBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSDCCodeSnippetBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCCodeSnippetBase.setKeywords(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCCodeSnippetBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCCodeSnippetBase.setPSDCCodeSnippetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCCodeSnippetBase.setPSDCCodeSnippetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCCodeSnippetBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCCodeSnippetBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCCodeSnippetBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCCodeSnippetBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCCodeSnippetBase.setRefMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCCodeSnippetBase.setTemplCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDCCodeSnippetBase.setTemplCode2(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDCCodeSnippetBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSDCCodeSnippetBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDCCodeSnippetBase.isNull(this, n);
    }

    private static boolean isNull(PSDCCodeSnippetBase pSDCCodeSnippetBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCCodeSnippetBase.getAllDCFlag() == null;
            }
            case 1: {
                return pSDCCodeSnippetBase.getCodeCat() == null;
            }
            case 2: {
                return pSDCCodeSnippetBase.getCodeTarget() == null;
            }
            case 3: {
                return pSDCCodeSnippetBase.getCreateDate() == null;
            }
            case 4: {
                return pSDCCodeSnippetBase.getCreateMan() == null;
            }
            case 5: {
                return pSDCCodeSnippetBase.getKeywords() == null;
            }
            case 6: {
                return pSDCCodeSnippetBase.getMemo() == null;
            }
            case 7: {
                return pSDCCodeSnippetBase.getPSDCCodeSnippetId() == null;
            }
            case 8: {
                return pSDCCodeSnippetBase.getPSDCCodeSnippetName() == null;
            }
            case 9: {
                return pSDCCodeSnippetBase.getPSDevCenterId() == null;
            }
            case 10: {
                return pSDCCodeSnippetBase.getPSDevCenterName() == null;
            }
            case 11: {
                return pSDCCodeSnippetBase.getPSDevSlnId() == null;
            }
            case 12: {
                return pSDCCodeSnippetBase.getPSDevSlnName() == null;
            }
            case 13: {
                return pSDCCodeSnippetBase.getRefMode() == null;
            }
            case 14: {
                return pSDCCodeSnippetBase.getTemplCode() == null;
            }
            case 15: {
                return pSDCCodeSnippetBase.getTemplCode2() == null;
            }
            case 16: {
                return pSDCCodeSnippetBase.getUpdateDate() == null;
            }
            case 17: {
                return pSDCCodeSnippetBase.getUpdateMan() == null;
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
        return PSDCCodeSnippetBase.contains(this, n);
    }

    private static boolean contains(PSDCCodeSnippetBase pSDCCodeSnippetBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCCodeSnippetBase.isAllDCFlagDirty();
            }
            case 1: {
                return pSDCCodeSnippetBase.isCodeCatDirty();
            }
            case 2: {
                return pSDCCodeSnippetBase.isCodeTargetDirty();
            }
            case 3: {
                return pSDCCodeSnippetBase.isCreateDateDirty();
            }
            case 4: {
                return pSDCCodeSnippetBase.isCreateManDirty();
            }
            case 5: {
                return pSDCCodeSnippetBase.isKeywordsDirty();
            }
            case 6: {
                return pSDCCodeSnippetBase.isMemoDirty();
            }
            case 7: {
                return pSDCCodeSnippetBase.isPSDCCodeSnippetIdDirty();
            }
            case 8: {
                return pSDCCodeSnippetBase.isPSDCCodeSnippetNameDirty();
            }
            case 9: {
                return pSDCCodeSnippetBase.isPSDevCenterIdDirty();
            }
            case 10: {
                return pSDCCodeSnippetBase.isPSDevCenterNameDirty();
            }
            case 11: {
                return pSDCCodeSnippetBase.isPSDevSlnIdDirty();
            }
            case 12: {
                return pSDCCodeSnippetBase.isPSDevSlnNameDirty();
            }
            case 13: {
                return pSDCCodeSnippetBase.isRefModeDirty();
            }
            case 14: {
                return pSDCCodeSnippetBase.isTemplCodeDirty();
            }
            case 15: {
                return pSDCCodeSnippetBase.isTemplCode2Dirty();
            }
            case 16: {
                return pSDCCodeSnippetBase.isUpdateDateDirty();
            }
            case 17: {
                return pSDCCodeSnippetBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCCodeSnippetBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCCodeSnippetBase pSDCCodeSnippetBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCCodeSnippetBase.getAllDCFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"alldcflag", (Object)PSDCCodeSnippetBase.getJSONValue((Object)pSDCCodeSnippetBase.getAllDCFlag()), (boolean)false);
        }
        if (bl || pSDCCodeSnippetBase.getCodeCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codecat", (Object)PSDCCodeSnippetBase.getJSONValue((Object)pSDCCodeSnippetBase.getCodeCat()), (boolean)false);
        }
        if (bl || pSDCCodeSnippetBase.getCodeTarget() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codetarget", (Object)PSDCCodeSnippetBase.getJSONValue((Object)pSDCCodeSnippetBase.getCodeTarget()), (boolean)false);
        }
        if (bl || pSDCCodeSnippetBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCCodeSnippetBase.getJSONValue((Object)pSDCCodeSnippetBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCCodeSnippetBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCCodeSnippetBase.getJSONValue((Object)pSDCCodeSnippetBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCCodeSnippetBase.getKeywords() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"keywords", (Object)PSDCCodeSnippetBase.getJSONValue((Object)pSDCCodeSnippetBase.getKeywords()), (boolean)false);
        }
        if (bl || pSDCCodeSnippetBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCCodeSnippetBase.getJSONValue((Object)pSDCCodeSnippetBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCCodeSnippetBase.getPSDCCodeSnippetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccodesnippetid", (Object)PSDCCodeSnippetBase.getJSONValue((Object)pSDCCodeSnippetBase.getPSDCCodeSnippetId()), (boolean)false);
        }
        if (bl || pSDCCodeSnippetBase.getPSDCCodeSnippetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccodesnippetname", (Object)PSDCCodeSnippetBase.getJSONValue((Object)pSDCCodeSnippetBase.getPSDCCodeSnippetName()), (boolean)false);
        }
        if (bl || pSDCCodeSnippetBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCCodeSnippetBase.getJSONValue((Object)pSDCCodeSnippetBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCCodeSnippetBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCCodeSnippetBase.getJSONValue((Object)pSDCCodeSnippetBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCCodeSnippetBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDCCodeSnippetBase.getJSONValue((Object)pSDCCodeSnippetBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDCCodeSnippetBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDCCodeSnippetBase.getJSONValue((Object)pSDCCodeSnippetBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDCCodeSnippetBase.getRefMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refmode", (Object)PSDCCodeSnippetBase.getJSONValue((Object)pSDCCodeSnippetBase.getRefMode()), (boolean)false);
        }
        if (bl || pSDCCodeSnippetBase.getTemplCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode", (Object)PSDCCodeSnippetBase.getJSONValue((Object)pSDCCodeSnippetBase.getTemplCode()), (boolean)false);
        }
        if (bl || pSDCCodeSnippetBase.getTemplCode2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode2", (Object)PSDCCodeSnippetBase.getJSONValue((Object)pSDCCodeSnippetBase.getTemplCode2()), (boolean)false);
        }
        if (bl || pSDCCodeSnippetBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCCodeSnippetBase.getJSONValue((Object)pSDCCodeSnippetBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCCodeSnippetBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCCodeSnippetBase.getJSONValue((Object)pSDCCodeSnippetBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCCodeSnippetBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCCodeSnippetBase pSDCCodeSnippetBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCCodeSnippetBase.getAllDCFlag() != null) {
            object = pSDCCodeSnippetBase.getAllDCFlag();
            xmlNode.setAttribute(FIELD_ALLDCFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCCodeSnippetBase.getCodeCat() != null) {
            object = pSDCCodeSnippetBase.getCodeCat();
            xmlNode.setAttribute(FIELD_CODECAT, object == null ? "" : (String)object);
        }
        if (bl || pSDCCodeSnippetBase.getCodeTarget() != null) {
            object = pSDCCodeSnippetBase.getCodeTarget();
            xmlNode.setAttribute(FIELD_CODETARGET, object == null ? "" : (String)object);
        }
        if (bl || pSDCCodeSnippetBase.getCreateDate() != null) {
            object = pSDCCodeSnippetBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCCodeSnippetBase.getCreateMan() != null) {
            object = pSDCCodeSnippetBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCCodeSnippetBase.getKeywords() != null) {
            object = pSDCCodeSnippetBase.getKeywords();
            xmlNode.setAttribute(FIELD_KEYWORDS, object == null ? "" : (String)object);
        }
        if (bl || pSDCCodeSnippetBase.getMemo() != null) {
            object = pSDCCodeSnippetBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCCodeSnippetBase.getPSDCCodeSnippetId() != null) {
            object = pSDCCodeSnippetBase.getPSDCCodeSnippetId();
            xmlNode.setAttribute(FIELD_PSDCCODESNIPPETID, object == null ? "" : (String)object);
        }
        if (bl || pSDCCodeSnippetBase.getPSDCCodeSnippetName() != null) {
            object = pSDCCodeSnippetBase.getPSDCCodeSnippetName();
            xmlNode.setAttribute(FIELD_PSDCCODESNIPPETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCCodeSnippetBase.getPSDevCenterId() != null) {
            object = pSDCCodeSnippetBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCCodeSnippetBase.getPSDevCenterName() != null) {
            object = pSDCCodeSnippetBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCCodeSnippetBase.getPSDevSlnId() != null) {
            object = pSDCCodeSnippetBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDCCodeSnippetBase.getPSDevSlnName() != null) {
            object = pSDCCodeSnippetBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCCodeSnippetBase.getRefMode() != null) {
            object = pSDCCodeSnippetBase.getRefMode();
            xmlNode.setAttribute(FIELD_REFMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDCCodeSnippetBase.getTemplCode() != null) {
            object = pSDCCodeSnippetBase.getTemplCode();
            xmlNode.setAttribute(FIELD_TEMPLCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDCCodeSnippetBase.getTemplCode2() != null) {
            object = pSDCCodeSnippetBase.getTemplCode2();
            xmlNode.setAttribute(FIELD_TEMPLCODE2, object == null ? "" : (String)object);
        }
        if (bl || pSDCCodeSnippetBase.getUpdateDate() != null) {
            object = pSDCCodeSnippetBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCCodeSnippetBase.getUpdateMan() != null) {
            object = pSDCCodeSnippetBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCCodeSnippetBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCCodeSnippetBase pSDCCodeSnippetBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCCodeSnippetBase.isAllDCFlagDirty() && (bl || pSDCCodeSnippetBase.getAllDCFlag() != null)) {
            iDataObject.set(FIELD_ALLDCFLAG, (Object)pSDCCodeSnippetBase.getAllDCFlag());
        }
        if (pSDCCodeSnippetBase.isCodeCatDirty() && (bl || pSDCCodeSnippetBase.getCodeCat() != null)) {
            iDataObject.set(FIELD_CODECAT, (Object)pSDCCodeSnippetBase.getCodeCat());
        }
        if (pSDCCodeSnippetBase.isCodeTargetDirty() && (bl || pSDCCodeSnippetBase.getCodeTarget() != null)) {
            iDataObject.set(FIELD_CODETARGET, (Object)pSDCCodeSnippetBase.getCodeTarget());
        }
        if (pSDCCodeSnippetBase.isCreateDateDirty() && (bl || pSDCCodeSnippetBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCCodeSnippetBase.getCreateDate());
        }
        if (pSDCCodeSnippetBase.isCreateManDirty() && (bl || pSDCCodeSnippetBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCCodeSnippetBase.getCreateMan());
        }
        if (pSDCCodeSnippetBase.isKeywordsDirty() && (bl || pSDCCodeSnippetBase.getKeywords() != null)) {
            iDataObject.set(FIELD_KEYWORDS, (Object)pSDCCodeSnippetBase.getKeywords());
        }
        if (pSDCCodeSnippetBase.isMemoDirty() && (bl || pSDCCodeSnippetBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCCodeSnippetBase.getMemo());
        }
        if (pSDCCodeSnippetBase.isPSDCCodeSnippetIdDirty() && (bl || pSDCCodeSnippetBase.getPSDCCodeSnippetId() != null)) {
            iDataObject.set(FIELD_PSDCCODESNIPPETID, (Object)pSDCCodeSnippetBase.getPSDCCodeSnippetId());
        }
        if (pSDCCodeSnippetBase.isPSDCCodeSnippetNameDirty() && (bl || pSDCCodeSnippetBase.getPSDCCodeSnippetName() != null)) {
            iDataObject.set(FIELD_PSDCCODESNIPPETNAME, (Object)pSDCCodeSnippetBase.getPSDCCodeSnippetName());
        }
        if (pSDCCodeSnippetBase.isPSDevCenterIdDirty() && (bl || pSDCCodeSnippetBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCCodeSnippetBase.getPSDevCenterId());
        }
        if (pSDCCodeSnippetBase.isPSDevCenterNameDirty() && (bl || pSDCCodeSnippetBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCCodeSnippetBase.getPSDevCenterName());
        }
        if (pSDCCodeSnippetBase.isPSDevSlnIdDirty() && (bl || pSDCCodeSnippetBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDCCodeSnippetBase.getPSDevSlnId());
        }
        if (pSDCCodeSnippetBase.isPSDevSlnNameDirty() && (bl || pSDCCodeSnippetBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDCCodeSnippetBase.getPSDevSlnName());
        }
        if (pSDCCodeSnippetBase.isRefModeDirty() && (bl || pSDCCodeSnippetBase.getRefMode() != null)) {
            iDataObject.set(FIELD_REFMODE, (Object)pSDCCodeSnippetBase.getRefMode());
        }
        if (pSDCCodeSnippetBase.isTemplCodeDirty() && (bl || pSDCCodeSnippetBase.getTemplCode() != null)) {
            iDataObject.set(FIELD_TEMPLCODE, (Object)pSDCCodeSnippetBase.getTemplCode());
        }
        if (pSDCCodeSnippetBase.isTemplCode2Dirty() && (bl || pSDCCodeSnippetBase.getTemplCode2() != null)) {
            iDataObject.set(FIELD_TEMPLCODE2, (Object)pSDCCodeSnippetBase.getTemplCode2());
        }
        if (pSDCCodeSnippetBase.isUpdateDateDirty() && (bl || pSDCCodeSnippetBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCCodeSnippetBase.getUpdateDate());
        }
        if (pSDCCodeSnippetBase.isUpdateManDirty() && (bl || pSDCCodeSnippetBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCCodeSnippetBase.getUpdateMan());
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
        return PSDCCodeSnippetBase.remove(this, n);
    }

    private static boolean remove(PSDCCodeSnippetBase pSDCCodeSnippetBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCCodeSnippetBase.resetAllDCFlag();
                return true;
            }
            case 1: {
                pSDCCodeSnippetBase.resetCodeCat();
                return true;
            }
            case 2: {
                pSDCCodeSnippetBase.resetCodeTarget();
                return true;
            }
            case 3: {
                pSDCCodeSnippetBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSDCCodeSnippetBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSDCCodeSnippetBase.resetKeywords();
                return true;
            }
            case 6: {
                pSDCCodeSnippetBase.resetMemo();
                return true;
            }
            case 7: {
                pSDCCodeSnippetBase.resetPSDCCodeSnippetId();
                return true;
            }
            case 8: {
                pSDCCodeSnippetBase.resetPSDCCodeSnippetName();
                return true;
            }
            case 9: {
                pSDCCodeSnippetBase.resetPSDevCenterId();
                return true;
            }
            case 10: {
                pSDCCodeSnippetBase.resetPSDevCenterName();
                return true;
            }
            case 11: {
                pSDCCodeSnippetBase.resetPSDevSlnId();
                return true;
            }
            case 12: {
                pSDCCodeSnippetBase.resetPSDevSlnName();
                return true;
            }
            case 13: {
                pSDCCodeSnippetBase.resetRefMode();
                return true;
            }
            case 14: {
                pSDCCodeSnippetBase.resetTemplCode();
                return true;
            }
            case 15: {
                pSDCCodeSnippetBase.resetTemplCode2();
                return true;
            }
            case 16: {
                pSDCCodeSnippetBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSDCCodeSnippetBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getPSDevCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenter();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterLock;
        synchronized (n) {
            if (this.psdevcenter != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterId(), (Object)this.psdevcenter.getPSDevCenterId()) != 0L) {
                this.psdevcenter = null;
            }
            if (this.psdevcenter == null) {
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(this.getPSDevCenterId());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterService.autoGet(pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
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
                pSDevSlnService.autoGet(pSDevSln);
                this.psdevsln = pSDevSln;
            }
            return this.psdevsln;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDCCodeSnippetRef> getPSDCCodeSnippetRef() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCCodeSnippetRef();
        }
        if (this.getPSDCCodeSnippetId() == null) {
            return null;
        }
        PSDCCodeSnippetRefService pSDCCodeSnippetRefService = (PSDCCodeSnippetRefService)ServiceGlobal.getService(PSDCCodeSnippetRefService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDCCodeSnippetRefLock;
        synchronized (n) {
            if (this.psdccodesnippetref == null) {
                this.psdccodesnippetref = pSDCCodeSnippetRefService.selectByPSDCCodeSnippet(this);
            }
            return this.psdccodesnippetref;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnPipeline> getPSDevSlnPipelines() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipelines();
        }
        if (this.getPSDCCodeSnippetId() == null) {
            return null;
        }
        PSDevSlnPipelineService pSDevSlnPipelineService = (PSDevSlnPipelineService)ServiceGlobal.getService(PSDevSlnPipelineService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnPipelinesLock;
        synchronized (n) {
            if (this.psdevslnpipelines == null) {
                this.psdevslnpipelines = pSDevSlnPipelineService.selectByPSDCCodeSnippet(this);
            }
            return this.psdevslnpipelines;
        }
    }

    private PSDCCodeSnippetBase getProxyEntity() {
        return this.proxyPSDCCodeSnippetBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCCodeSnippetBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCCodeSnippetBase) {
            this.proxyPSDCCodeSnippetBase = (PSDCCodeSnippetBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCCodeSnippetService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLDCFLAG, 0);
        fieldIndexMap.put(FIELD_CODECAT, 1);
        fieldIndexMap.put(FIELD_CODETARGET, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_KEYWORDS, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_PSDCCODESNIPPETID, 7);
        fieldIndexMap.put(FIELD_PSDCCODESNIPPETNAME, 8);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 9);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 10);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 11);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 12);
        fieldIndexMap.put(FIELD_REFMODE, 13);
        fieldIndexMap.put(FIELD_TEMPLCODE, 14);
        fieldIndexMap.put(FIELD_TEMPLCODE2, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
    }
}

