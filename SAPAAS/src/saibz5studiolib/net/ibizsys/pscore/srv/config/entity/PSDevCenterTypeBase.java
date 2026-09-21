/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.config.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevCenterTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevCenterTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DCLEVEL = "DCLEVEL";
    public static final String FIELD_DCTYPE = "DCTYPE";
    public static final String FIELD_EXP = "EXP";
    public static final String FIELD_EXP2 = "EXP2";
    public static final String FIELD_LIMITS = "LIMITS";
    public static final String FIELD_MAXDBINSTCNT = "MAXDBINSTCNT";
    public static final String FIELD_MAXDEPINSTCNT = "MAXDEPINSTCNT";
    public static final String FIELD_MAXDEVOBJCNT = "MAXDEVOBJCNT";
    public static final String FIELD_MAXDEVSLNCNT = "MAXDEVSLNCNT";
    public static final String FIELD_MAXDEVSYSCNT = "MAXDEVSYSCNT";
    public static final String FIELD_MAXDEVTEMPLCNT = "MAXDEVTEMPLCNT";
    public static final String FIELD_MAXDYNAINSTCNT = "MAXDYNAINSTCNT";
    public static final String FIELD_MAXGITLABACCLEVEL = "MAXGITLABACCLEVEL";
    public static final String FIELD_MAXMSPCNT = "MAXMSPCNT";
    public static final String FIELD_MAXOBJ2CNT = "MAXOBJ2CNT";
    public static final String FIELD_MAXOBJ3CNT = "MAXOBJ3CNT";
    public static final String FIELD_MAXOBJ4CNT = "MAXOBJ4CNT";
    public static final String FIELD_MAXOBJCNT = "MAXOBJCNT";
    public static final String FIELD_MAXSYSBAKCNT = "MAXSYSBAKCNT";
    public static final String FIELD_MAXUSERCNT = "MAXUSERCNT";
    public static final String FIELD_MAXWORKSPACECNT = "MAXWORKSPACECNT";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVCENTERTYPEID = "PSDEVCENTERTYPEID";
    public static final String FIELD_PSDEVCENTERTYPENAME = "PSDEVCENTERTYPENAME";
    public static final String FIELD_TYPEPARAMS = "TYPEPARAMS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DCLEVEL = 2;
    private static final int INDEX_DCTYPE = 3;
    private static final int INDEX_EXP = 4;
    private static final int INDEX_EXP2 = 5;
    private static final int INDEX_LIMITS = 6;
    private static final int INDEX_MAXDBINSTCNT = 7;
    private static final int INDEX_MAXDEPINSTCNT = 8;
    private static final int INDEX_MAXDEVOBJCNT = 9;
    private static final int INDEX_MAXDEVSLNCNT = 10;
    private static final int INDEX_MAXDEVSYSCNT = 11;
    private static final int INDEX_MAXDEVTEMPLCNT = 12;
    private static final int INDEX_MAXDYNAINSTCNT = 13;
    private static final int INDEX_MAXGITLABACCLEVEL = 14;
    private static final int INDEX_MAXMSPCNT = 15;
    private static final int INDEX_MAXOBJ2CNT = 16;
    private static final int INDEX_MAXOBJ3CNT = 17;
    private static final int INDEX_MAXOBJ4CNT = 18;
    private static final int INDEX_MAXOBJCNT = 19;
    private static final int INDEX_MAXSYSBAKCNT = 20;
    private static final int INDEX_MAXUSERCNT = 21;
    private static final int INDEX_MAXWORKSPACECNT = 22;
    private static final int INDEX_MEMO = 23;
    private static final int INDEX_PSDEVCENTERTYPEID = 24;
    private static final int INDEX_PSDEVCENTERTYPENAME = 25;
    private static final int INDEX_TYPEPARAMS = 26;
    private static final int INDEX_UPDATEDATE = 27;
    private static final int INDEX_UPDATEMAN = 28;
    private static final int INDEX_USERTAG = 29;
    private static final int INDEX_USERTAG2 = 30;
    private static final int INDEX_VALIDFLAG = 31;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevCenterTypeBase proxyPSDevCenterTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dclevelDirtyFlag = false;
    private boolean dctypeDirtyFlag = false;
    private boolean expDirtyFlag = false;
    private boolean exp2DirtyFlag = false;
    private boolean limitsDirtyFlag = false;
    private boolean maxdbinstcntDirtyFlag = false;
    private boolean maxdepinstcntDirtyFlag = false;
    private boolean maxdevobjcntDirtyFlag = false;
    private boolean maxdevslncntDirtyFlag = false;
    private boolean maxdevsyscntDirtyFlag = false;
    private boolean maxdevtemplcntDirtyFlag = false;
    private boolean maxdynainstcntDirtyFlag = false;
    private boolean maxgitlabacclevelDirtyFlag = false;
    private boolean maxmspcntDirtyFlag = false;
    private boolean maxobj2cntDirtyFlag = false;
    private boolean maxobj3cntDirtyFlag = false;
    private boolean maxobj4cntDirtyFlag = false;
    private boolean maxobjcntDirtyFlag = false;
    private boolean maxsysbakcntDirtyFlag = false;
    private boolean maxusercntDirtyFlag = false;
    private boolean maxworkspacecntDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevcentertypeidDirtyFlag = false;
    private boolean psdevcentertypenameDirtyFlag = false;
    private boolean typeparamsDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dclevel")
    private Integer dclevel;
    @Column(name="dctype")
    private String dctype;
    @Column(name="exp")
    private Double exp;
    @Column(name="exp2")
    private Double exp2;
    @Column(name="limits")
    private String limits;
    @Column(name="maxdbinstcnt")
    private Integer maxdbinstcnt;
    @Column(name="maxdepinstcnt")
    private Integer maxdepinstcnt;
    @Column(name="maxdevobjcnt")
    private Integer maxdevobjcnt;
    @Column(name="maxdevslncnt")
    private Integer maxdevslncnt;
    @Column(name="maxdevsyscnt")
    private Integer maxdevsyscnt;
    @Column(name="maxdevtemplcnt")
    private Integer maxdevtemplcnt;
    @Column(name="maxdynainstcnt")
    private Integer maxdynainstcnt;
    @Column(name="maxgitlabacclevel")
    private Integer maxgitlabacclevel;
    @Column(name="maxmspcnt")
    private Integer maxmspcnt;
    @Column(name="maxobj2cnt")
    private Integer maxobj2cnt;
    @Column(name="maxobj3cnt")
    private Integer maxobj3cnt;
    @Column(name="maxobj4cnt")
    private Integer maxobj4cnt;
    @Column(name="maxobjcnt")
    private Integer maxobjcnt;
    @Column(name="maxsysbakcnt")
    private Integer maxsysbakcnt;
    @Column(name="maxusercnt")
    private Integer maxusercnt;
    @Column(name="maxworkspacecnt")
    private Integer maxworkspacecnt;
    @Column(name="memo")
    private String memo;
    @Column(name="psdevcentertypeid")
    private String psdevcentertypeid;
    @Column(name="psdevcentertypename")
    private String psdevcentertypename;
    @Column(name="typeparams")
    private String typeparams;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="validflag")
    private Integer validflag;

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

    public void setDCLevel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDCLevel(n);
            return;
        }
        this.dclevel = n;
        this.dclevelDirtyFlag = true;
    }

    public Integer getDCLevel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDCLevel();
        }
        return this.dclevel;
    }

    public boolean isDCLevelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDCLevelDirty();
        }
        return this.dclevelDirtyFlag;
    }

    public void resetDCLevel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDCLevel();
            return;
        }
        this.dclevelDirtyFlag = false;
        this.dclevel = null;
    }

    public void setDCType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDCType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dctype = string;
        this.dctypeDirtyFlag = true;
    }

    public String getDCType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDCType();
        }
        return this.dctype;
    }

    public boolean isDCTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDCTypeDirty();
        }
        return this.dctypeDirtyFlag;
    }

    public void resetDCType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDCType();
            return;
        }
        this.dctypeDirtyFlag = false;
        this.dctype = null;
    }

    public void setExp(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExp(d);
            return;
        }
        this.exp = d;
        this.expDirtyFlag = true;
    }

    public Double getExp() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExp();
        }
        return this.exp;
    }

    public boolean isExpDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExpDirty();
        }
        return this.expDirtyFlag;
    }

    public void resetExp() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExp();
            return;
        }
        this.expDirtyFlag = false;
        this.exp = null;
    }

    public void setExp2(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExp2(d);
            return;
        }
        this.exp2 = d;
        this.exp2DirtyFlag = true;
    }

    public Double getExp2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExp2();
        }
        return this.exp2;
    }

    public boolean isExp2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExp2Dirty();
        }
        return this.exp2DirtyFlag;
    }

    public void resetExp2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExp2();
            return;
        }
        this.exp2DirtyFlag = false;
        this.exp2 = null;
    }

    public void setLimits(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLimits(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.limits = string;
        this.limitsDirtyFlag = true;
    }

    public String getLimits() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLimits();
        }
        return this.limits;
    }

    public boolean isLimitsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLimitsDirty();
        }
        return this.limitsDirtyFlag;
    }

    public void resetLimits() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLimits();
            return;
        }
        this.limitsDirtyFlag = false;
        this.limits = null;
    }

    public void setMaxDBInstCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxDBInstCnt(n);
            return;
        }
        this.maxdbinstcnt = n;
        this.maxdbinstcntDirtyFlag = true;
    }

    public Integer getMaxDBInstCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxDBInstCnt();
        }
        return this.maxdbinstcnt;
    }

    public boolean isMaxDBInstCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxDBInstCntDirty();
        }
        return this.maxdbinstcntDirtyFlag;
    }

    public void resetMaxDBInstCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxDBInstCnt();
            return;
        }
        this.maxdbinstcntDirtyFlag = false;
        this.maxdbinstcnt = null;
    }

    public void setMaxDepInstCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxDepInstCnt(n);
            return;
        }
        this.maxdepinstcnt = n;
        this.maxdepinstcntDirtyFlag = true;
    }

    public Integer getMaxDepInstCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxDepInstCnt();
        }
        return this.maxdepinstcnt;
    }

    public boolean isMaxDepInstCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxDepInstCntDirty();
        }
        return this.maxdepinstcntDirtyFlag;
    }

    public void resetMaxDepInstCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxDepInstCnt();
            return;
        }
        this.maxdepinstcntDirtyFlag = false;
        this.maxdepinstcnt = null;
    }

    public void setMaxDevObjCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxDevObjCnt(n);
            return;
        }
        this.maxdevobjcnt = n;
        this.maxdevobjcntDirtyFlag = true;
    }

    public Integer getMaxDevObjCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxDevObjCnt();
        }
        return this.maxdevobjcnt;
    }

    public boolean isMaxDevObjCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxDevObjCntDirty();
        }
        return this.maxdevobjcntDirtyFlag;
    }

    public void resetMaxDevObjCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxDevObjCnt();
            return;
        }
        this.maxdevobjcntDirtyFlag = false;
        this.maxdevobjcnt = null;
    }

    public void setMaxDevSlnCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxDevSlnCnt(n);
            return;
        }
        this.maxdevslncnt = n;
        this.maxdevslncntDirtyFlag = true;
    }

    public Integer getMaxDevSlnCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxDevSlnCnt();
        }
        return this.maxdevslncnt;
    }

    public boolean isMaxDevSlnCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxDevSlnCntDirty();
        }
        return this.maxdevslncntDirtyFlag;
    }

    public void resetMaxDevSlnCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxDevSlnCnt();
            return;
        }
        this.maxdevslncntDirtyFlag = false;
        this.maxdevslncnt = null;
    }

    public void setMaxDevSysCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxDevSysCnt(n);
            return;
        }
        this.maxdevsyscnt = n;
        this.maxdevsyscntDirtyFlag = true;
    }

    public Integer getMaxDevSysCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxDevSysCnt();
        }
        return this.maxdevsyscnt;
    }

    public boolean isMaxDevSysCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxDevSysCntDirty();
        }
        return this.maxdevsyscntDirtyFlag;
    }

    public void resetMaxDevSysCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxDevSysCnt();
            return;
        }
        this.maxdevsyscntDirtyFlag = false;
        this.maxdevsyscnt = null;
    }

    public void setMaxDevTemplCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxDevTemplCnt(n);
            return;
        }
        this.maxdevtemplcnt = n;
        this.maxdevtemplcntDirtyFlag = true;
    }

    public Integer getMaxDevTemplCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxDevTemplCnt();
        }
        return this.maxdevtemplcnt;
    }

    public boolean isMaxDevTemplCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxDevTemplCntDirty();
        }
        return this.maxdevtemplcntDirtyFlag;
    }

    public void resetMaxDevTemplCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxDevTemplCnt();
            return;
        }
        this.maxdevtemplcntDirtyFlag = false;
        this.maxdevtemplcnt = null;
    }

    public void setMaxDynaInstCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxDynaInstCnt(n);
            return;
        }
        this.maxdynainstcnt = n;
        this.maxdynainstcntDirtyFlag = true;
    }

    public Integer getMaxDynaInstCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxDynaInstCnt();
        }
        return this.maxdynainstcnt;
    }

    public boolean isMaxDynaInstCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxDynaInstCntDirty();
        }
        return this.maxdynainstcntDirtyFlag;
    }

    public void resetMaxDynaInstCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxDynaInstCnt();
            return;
        }
        this.maxdynainstcntDirtyFlag = false;
        this.maxdynainstcnt = null;
    }

    public void setMaxGitLabAccLevel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxGitLabAccLevel(n);
            return;
        }
        this.maxgitlabacclevel = n;
        this.maxgitlabacclevelDirtyFlag = true;
    }

    public Integer getMaxGitLabAccLevel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxGitLabAccLevel();
        }
        return this.maxgitlabacclevel;
    }

    public boolean isMaxGitLabAccLevelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxGitLabAccLevelDirty();
        }
        return this.maxgitlabacclevelDirtyFlag;
    }

    public void resetMaxGitLabAccLevel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxGitLabAccLevel();
            return;
        }
        this.maxgitlabacclevelDirtyFlag = false;
        this.maxgitlabacclevel = null;
    }

    public void setMaxMSPCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxMSPCnt(n);
            return;
        }
        this.maxmspcnt = n;
        this.maxmspcntDirtyFlag = true;
    }

    public Integer getMaxMSPCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxMSPCnt();
        }
        return this.maxmspcnt;
    }

    public boolean isMaxMSPCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxMSPCntDirty();
        }
        return this.maxmspcntDirtyFlag;
    }

    public void resetMaxMSPCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxMSPCnt();
            return;
        }
        this.maxmspcntDirtyFlag = false;
        this.maxmspcnt = null;
    }

    public void setMaxObj2Cnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxObj2Cnt(n);
            return;
        }
        this.maxobj2cnt = n;
        this.maxobj2cntDirtyFlag = true;
    }

    public Integer getMaxObj2Cnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxObj2Cnt();
        }
        return this.maxobj2cnt;
    }

    public boolean isMaxObj2CntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxObj2CntDirty();
        }
        return this.maxobj2cntDirtyFlag;
    }

    public void resetMaxObj2Cnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxObj2Cnt();
            return;
        }
        this.maxobj2cntDirtyFlag = false;
        this.maxobj2cnt = null;
    }

    public void setMaxObj3Cnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxObj3Cnt(n);
            return;
        }
        this.maxobj3cnt = n;
        this.maxobj3cntDirtyFlag = true;
    }

    public Integer getMaxObj3Cnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxObj3Cnt();
        }
        return this.maxobj3cnt;
    }

    public boolean isMaxObj3CntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxObj3CntDirty();
        }
        return this.maxobj3cntDirtyFlag;
    }

    public void resetMaxObj3Cnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxObj3Cnt();
            return;
        }
        this.maxobj3cntDirtyFlag = false;
        this.maxobj3cnt = null;
    }

    public void setMaxObj4Cnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxObj4Cnt(n);
            return;
        }
        this.maxobj4cnt = n;
        this.maxobj4cntDirtyFlag = true;
    }

    public Integer getMaxObj4Cnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxObj4Cnt();
        }
        return this.maxobj4cnt;
    }

    public boolean isMaxObj4CntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxObj4CntDirty();
        }
        return this.maxobj4cntDirtyFlag;
    }

    public void resetMaxObj4Cnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxObj4Cnt();
            return;
        }
        this.maxobj4cntDirtyFlag = false;
        this.maxobj4cnt = null;
    }

    public void setMaxObjCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxObjCnt(n);
            return;
        }
        this.maxobjcnt = n;
        this.maxobjcntDirtyFlag = true;
    }

    public Integer getMaxObjCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxObjCnt();
        }
        return this.maxobjcnt;
    }

    public boolean isMaxObjCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxObjCntDirty();
        }
        return this.maxobjcntDirtyFlag;
    }

    public void resetMaxObjCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxObjCnt();
            return;
        }
        this.maxobjcntDirtyFlag = false;
        this.maxobjcnt = null;
    }

    public void setMaxSysBakCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxSysBakCnt(n);
            return;
        }
        this.maxsysbakcnt = n;
        this.maxsysbakcntDirtyFlag = true;
    }

    public Integer getMaxSysBakCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxSysBakCnt();
        }
        return this.maxsysbakcnt;
    }

    public boolean isMaxSysBakCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxSysBakCntDirty();
        }
        return this.maxsysbakcntDirtyFlag;
    }

    public void resetMaxSysBakCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxSysBakCnt();
            return;
        }
        this.maxsysbakcntDirtyFlag = false;
        this.maxsysbakcnt = null;
    }

    public void setMaxUserCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxUserCnt(n);
            return;
        }
        this.maxusercnt = n;
        this.maxusercntDirtyFlag = true;
    }

    public Integer getMaxUserCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxUserCnt();
        }
        return this.maxusercnt;
    }

    public boolean isMaxUserCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxUserCntDirty();
        }
        return this.maxusercntDirtyFlag;
    }

    public void resetMaxUserCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxUserCnt();
            return;
        }
        this.maxusercntDirtyFlag = false;
        this.maxusercnt = null;
    }

    public void setMaxWorkspaceCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxWorkspaceCnt(n);
            return;
        }
        this.maxworkspacecnt = n;
        this.maxworkspacecntDirtyFlag = true;
    }

    public Integer getMaxWorkspaceCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxWorkspaceCnt();
        }
        return this.maxworkspacecnt;
    }

    public boolean isMaxWorkspaceCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxWorkspaceCntDirty();
        }
        return this.maxworkspacecntDirtyFlag;
    }

    public void resetMaxWorkspaceCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxWorkspaceCnt();
            return;
        }
        this.maxworkspacecntDirtyFlag = false;
        this.maxworkspacecnt = null;
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

    public void setPSDevCenterTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentertypeid = string;
        this.psdevcentertypeidDirtyFlag = true;
    }

    public String getPSDevCenterTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterTypeId();
        }
        return this.psdevcentertypeid;
    }

    public boolean isPSDevCenterTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterTypeIdDirty();
        }
        return this.psdevcentertypeidDirtyFlag;
    }

    public void resetPSDevCenterTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterTypeId();
            return;
        }
        this.psdevcentertypeidDirtyFlag = false;
        this.psdevcentertypeid = null;
    }

    public void setPSDevCenterTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentertypename = string;
        this.psdevcentertypenameDirtyFlag = true;
    }

    public String getPSDevCenterTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterTypeName();
        }
        return this.psdevcentertypename;
    }

    public boolean isPSDevCenterTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterTypeNameDirty();
        }
        return this.psdevcentertypenameDirtyFlag;
    }

    public void resetPSDevCenterTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterTypeName();
            return;
        }
        this.psdevcentertypenameDirtyFlag = false;
        this.psdevcentertypename = null;
    }

    public void setTypeParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typeparams = string;
        this.typeparamsDirtyFlag = true;
    }

    public String getTypeParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeParams();
        }
        return this.typeparams;
    }

    public boolean isTypeParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeParamsDirty();
        }
        return this.typeparamsDirtyFlag;
    }

    public void resetTypeParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeParams();
            return;
        }
        this.typeparamsDirtyFlag = false;
        this.typeparams = null;
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
        PSDevCenterTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevCenterTypeBase pSDevCenterTypeBase) {
        pSDevCenterTypeBase.resetCreateDate();
        pSDevCenterTypeBase.resetCreateMan();
        pSDevCenterTypeBase.resetDCLevel();
        pSDevCenterTypeBase.resetDCType();
        pSDevCenterTypeBase.resetExp();
        pSDevCenterTypeBase.resetExp2();
        pSDevCenterTypeBase.resetLimits();
        pSDevCenterTypeBase.resetMaxDBInstCnt();
        pSDevCenterTypeBase.resetMaxDepInstCnt();
        pSDevCenterTypeBase.resetMaxDevObjCnt();
        pSDevCenterTypeBase.resetMaxDevSlnCnt();
        pSDevCenterTypeBase.resetMaxDevSysCnt();
        pSDevCenterTypeBase.resetMaxDevTemplCnt();
        pSDevCenterTypeBase.resetMaxDynaInstCnt();
        pSDevCenterTypeBase.resetMaxGitLabAccLevel();
        pSDevCenterTypeBase.resetMaxMSPCnt();
        pSDevCenterTypeBase.resetMaxObj2Cnt();
        pSDevCenterTypeBase.resetMaxObj3Cnt();
        pSDevCenterTypeBase.resetMaxObj4Cnt();
        pSDevCenterTypeBase.resetMaxObjCnt();
        pSDevCenterTypeBase.resetMaxSysBakCnt();
        pSDevCenterTypeBase.resetMaxUserCnt();
        pSDevCenterTypeBase.resetMaxWorkspaceCnt();
        pSDevCenterTypeBase.resetMemo();
        pSDevCenterTypeBase.resetPSDevCenterTypeId();
        pSDevCenterTypeBase.resetPSDevCenterTypeName();
        pSDevCenterTypeBase.resetTypeParams();
        pSDevCenterTypeBase.resetUpdateDate();
        pSDevCenterTypeBase.resetUpdateMan();
        pSDevCenterTypeBase.resetUserTag();
        pSDevCenterTypeBase.resetUserTag2();
        pSDevCenterTypeBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDCLevelDirty()) {
            hashMap.put(FIELD_DCLEVEL, this.getDCLevel());
        }
        if (!bl || this.isDCTypeDirty()) {
            hashMap.put(FIELD_DCTYPE, this.getDCType());
        }
        if (!bl || this.isExpDirty()) {
            hashMap.put(FIELD_EXP, this.getExp());
        }
        if (!bl || this.isExp2Dirty()) {
            hashMap.put(FIELD_EXP2, this.getExp2());
        }
        if (!bl || this.isLimitsDirty()) {
            hashMap.put(FIELD_LIMITS, this.getLimits());
        }
        if (!bl || this.isMaxDBInstCntDirty()) {
            hashMap.put(FIELD_MAXDBINSTCNT, this.getMaxDBInstCnt());
        }
        if (!bl || this.isMaxDepInstCntDirty()) {
            hashMap.put(FIELD_MAXDEPINSTCNT, this.getMaxDepInstCnt());
        }
        if (!bl || this.isMaxDevObjCntDirty()) {
            hashMap.put(FIELD_MAXDEVOBJCNT, this.getMaxDevObjCnt());
        }
        if (!bl || this.isMaxDevSlnCntDirty()) {
            hashMap.put(FIELD_MAXDEVSLNCNT, this.getMaxDevSlnCnt());
        }
        if (!bl || this.isMaxDevSysCntDirty()) {
            hashMap.put(FIELD_MAXDEVSYSCNT, this.getMaxDevSysCnt());
        }
        if (!bl || this.isMaxDevTemplCntDirty()) {
            hashMap.put(FIELD_MAXDEVTEMPLCNT, this.getMaxDevTemplCnt());
        }
        if (!bl || this.isMaxDynaInstCntDirty()) {
            hashMap.put(FIELD_MAXDYNAINSTCNT, this.getMaxDynaInstCnt());
        }
        if (!bl || this.isMaxGitLabAccLevelDirty()) {
            hashMap.put(FIELD_MAXGITLABACCLEVEL, this.getMaxGitLabAccLevel());
        }
        if (!bl || this.isMaxMSPCntDirty()) {
            hashMap.put(FIELD_MAXMSPCNT, this.getMaxMSPCnt());
        }
        if (!bl || this.isMaxObj2CntDirty()) {
            hashMap.put(FIELD_MAXOBJ2CNT, this.getMaxObj2Cnt());
        }
        if (!bl || this.isMaxObj3CntDirty()) {
            hashMap.put(FIELD_MAXOBJ3CNT, this.getMaxObj3Cnt());
        }
        if (!bl || this.isMaxObj4CntDirty()) {
            hashMap.put(FIELD_MAXOBJ4CNT, this.getMaxObj4Cnt());
        }
        if (!bl || this.isMaxObjCntDirty()) {
            hashMap.put(FIELD_MAXOBJCNT, this.getMaxObjCnt());
        }
        if (!bl || this.isMaxSysBakCntDirty()) {
            hashMap.put(FIELD_MAXSYSBAKCNT, this.getMaxSysBakCnt());
        }
        if (!bl || this.isMaxUserCntDirty()) {
            hashMap.put(FIELD_MAXUSERCNT, this.getMaxUserCnt());
        }
        if (!bl || this.isMaxWorkspaceCntDirty()) {
            hashMap.put(FIELD_MAXWORKSPACECNT, this.getMaxWorkspaceCnt());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDevCenterTypeIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERTYPEID, this.getPSDevCenterTypeId());
        }
        if (!bl || this.isPSDevCenterTypeNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERTYPENAME, this.getPSDevCenterTypeName());
        }
        if (!bl || this.isTypeParamsDirty()) {
            hashMap.put(FIELD_TYPEPARAMS, this.getTypeParams());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
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
        return PSDevCenterTypeBase.get(this, n);
    }

    private static Object get(PSDevCenterTypeBase pSDevCenterTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterTypeBase.getCreateDate();
            }
            case 1: {
                return pSDevCenterTypeBase.getCreateMan();
            }
            case 2: {
                return pSDevCenterTypeBase.getDCLevel();
            }
            case 3: {
                return pSDevCenterTypeBase.getDCType();
            }
            case 4: {
                return pSDevCenterTypeBase.getExp();
            }
            case 5: {
                return pSDevCenterTypeBase.getExp2();
            }
            case 6: {
                return pSDevCenterTypeBase.getLimits();
            }
            case 7: {
                return pSDevCenterTypeBase.getMaxDBInstCnt();
            }
            case 8: {
                return pSDevCenterTypeBase.getMaxDepInstCnt();
            }
            case 9: {
                return pSDevCenterTypeBase.getMaxDevObjCnt();
            }
            case 10: {
                return pSDevCenterTypeBase.getMaxDevSlnCnt();
            }
            case 11: {
                return pSDevCenterTypeBase.getMaxDevSysCnt();
            }
            case 12: {
                return pSDevCenterTypeBase.getMaxDevTemplCnt();
            }
            case 13: {
                return pSDevCenterTypeBase.getMaxDynaInstCnt();
            }
            case 14: {
                return pSDevCenterTypeBase.getMaxGitLabAccLevel();
            }
            case 15: {
                return pSDevCenterTypeBase.getMaxMSPCnt();
            }
            case 16: {
                return pSDevCenterTypeBase.getMaxObj2Cnt();
            }
            case 17: {
                return pSDevCenterTypeBase.getMaxObj3Cnt();
            }
            case 18: {
                return pSDevCenterTypeBase.getMaxObj4Cnt();
            }
            case 19: {
                return pSDevCenterTypeBase.getMaxObjCnt();
            }
            case 20: {
                return pSDevCenterTypeBase.getMaxSysBakCnt();
            }
            case 21: {
                return pSDevCenterTypeBase.getMaxUserCnt();
            }
            case 22: {
                return pSDevCenterTypeBase.getMaxWorkspaceCnt();
            }
            case 23: {
                return pSDevCenterTypeBase.getMemo();
            }
            case 24: {
                return pSDevCenterTypeBase.getPSDevCenterTypeId();
            }
            case 25: {
                return pSDevCenterTypeBase.getPSDevCenterTypeName();
            }
            case 26: {
                return pSDevCenterTypeBase.getTypeParams();
            }
            case 27: {
                return pSDevCenterTypeBase.getUpdateDate();
            }
            case 28: {
                return pSDevCenterTypeBase.getUpdateMan();
            }
            case 29: {
                return pSDevCenterTypeBase.getUserTag();
            }
            case 30: {
                return pSDevCenterTypeBase.getUserTag2();
            }
            case 31: {
                return pSDevCenterTypeBase.getValidFlag();
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
        PSDevCenterTypeBase.set(this, n, object);
    }

    private static void set(PSDevCenterTypeBase pSDevCenterTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevCenterTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevCenterTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevCenterTypeBase.setDCLevel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDevCenterTypeBase.setDCType(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevCenterTypeBase.setExp(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 5: {
                pSDevCenterTypeBase.setExp2(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 6: {
                pSDevCenterTypeBase.setLimits(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevCenterTypeBase.setMaxDBInstCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDevCenterTypeBase.setMaxDepInstCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDevCenterTypeBase.setMaxDevObjCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSDevCenterTypeBase.setMaxDevSlnCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSDevCenterTypeBase.setMaxDevSysCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDevCenterTypeBase.setMaxDevTemplCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDevCenterTypeBase.setMaxDynaInstCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSDevCenterTypeBase.setMaxGitLabAccLevel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSDevCenterTypeBase.setMaxMSPCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDevCenterTypeBase.setMaxObj2Cnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSDevCenterTypeBase.setMaxObj3Cnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSDevCenterTypeBase.setMaxObj4Cnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSDevCenterTypeBase.setMaxObjCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSDevCenterTypeBase.setMaxSysBakCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSDevCenterTypeBase.setMaxUserCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSDevCenterTypeBase.setMaxWorkspaceCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSDevCenterTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDevCenterTypeBase.setPSDevCenterTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDevCenterTypeBase.setPSDevCenterTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDevCenterTypeBase.setTypeParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDevCenterTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 28: {
                pSDevCenterTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDevCenterTypeBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDevCenterTypeBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDevCenterTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDevCenterTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSDevCenterTypeBase pSDevCenterTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevCenterTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevCenterTypeBase.getDCLevel() == null;
            }
            case 3: {
                return pSDevCenterTypeBase.getDCType() == null;
            }
            case 4: {
                return pSDevCenterTypeBase.getExp() == null;
            }
            case 5: {
                return pSDevCenterTypeBase.getExp2() == null;
            }
            case 6: {
                return pSDevCenterTypeBase.getLimits() == null;
            }
            case 7: {
                return pSDevCenterTypeBase.getMaxDBInstCnt() == null;
            }
            case 8: {
                return pSDevCenterTypeBase.getMaxDepInstCnt() == null;
            }
            case 9: {
                return pSDevCenterTypeBase.getMaxDevObjCnt() == null;
            }
            case 10: {
                return pSDevCenterTypeBase.getMaxDevSlnCnt() == null;
            }
            case 11: {
                return pSDevCenterTypeBase.getMaxDevSysCnt() == null;
            }
            case 12: {
                return pSDevCenterTypeBase.getMaxDevTemplCnt() == null;
            }
            case 13: {
                return pSDevCenterTypeBase.getMaxDynaInstCnt() == null;
            }
            case 14: {
                return pSDevCenterTypeBase.getMaxGitLabAccLevel() == null;
            }
            case 15: {
                return pSDevCenterTypeBase.getMaxMSPCnt() == null;
            }
            case 16: {
                return pSDevCenterTypeBase.getMaxObj2Cnt() == null;
            }
            case 17: {
                return pSDevCenterTypeBase.getMaxObj3Cnt() == null;
            }
            case 18: {
                return pSDevCenterTypeBase.getMaxObj4Cnt() == null;
            }
            case 19: {
                return pSDevCenterTypeBase.getMaxObjCnt() == null;
            }
            case 20: {
                return pSDevCenterTypeBase.getMaxSysBakCnt() == null;
            }
            case 21: {
                return pSDevCenterTypeBase.getMaxUserCnt() == null;
            }
            case 22: {
                return pSDevCenterTypeBase.getMaxWorkspaceCnt() == null;
            }
            case 23: {
                return pSDevCenterTypeBase.getMemo() == null;
            }
            case 24: {
                return pSDevCenterTypeBase.getPSDevCenterTypeId() == null;
            }
            case 25: {
                return pSDevCenterTypeBase.getPSDevCenterTypeName() == null;
            }
            case 26: {
                return pSDevCenterTypeBase.getTypeParams() == null;
            }
            case 27: {
                return pSDevCenterTypeBase.getUpdateDate() == null;
            }
            case 28: {
                return pSDevCenterTypeBase.getUpdateMan() == null;
            }
            case 29: {
                return pSDevCenterTypeBase.getUserTag() == null;
            }
            case 30: {
                return pSDevCenterTypeBase.getUserTag2() == null;
            }
            case 31: {
                return pSDevCenterTypeBase.getValidFlag() == null;
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
        return PSDevCenterTypeBase.contains(this, n);
    }

    private static boolean contains(PSDevCenterTypeBase pSDevCenterTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevCenterTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSDevCenterTypeBase.isDCLevelDirty();
            }
            case 3: {
                return pSDevCenterTypeBase.isDCTypeDirty();
            }
            case 4: {
                return pSDevCenterTypeBase.isExpDirty();
            }
            case 5: {
                return pSDevCenterTypeBase.isExp2Dirty();
            }
            case 6: {
                return pSDevCenterTypeBase.isLimitsDirty();
            }
            case 7: {
                return pSDevCenterTypeBase.isMaxDBInstCntDirty();
            }
            case 8: {
                return pSDevCenterTypeBase.isMaxDepInstCntDirty();
            }
            case 9: {
                return pSDevCenterTypeBase.isMaxDevObjCntDirty();
            }
            case 10: {
                return pSDevCenterTypeBase.isMaxDevSlnCntDirty();
            }
            case 11: {
                return pSDevCenterTypeBase.isMaxDevSysCntDirty();
            }
            case 12: {
                return pSDevCenterTypeBase.isMaxDevTemplCntDirty();
            }
            case 13: {
                return pSDevCenterTypeBase.isMaxDynaInstCntDirty();
            }
            case 14: {
                return pSDevCenterTypeBase.isMaxGitLabAccLevelDirty();
            }
            case 15: {
                return pSDevCenterTypeBase.isMaxMSPCntDirty();
            }
            case 16: {
                return pSDevCenterTypeBase.isMaxObj2CntDirty();
            }
            case 17: {
                return pSDevCenterTypeBase.isMaxObj3CntDirty();
            }
            case 18: {
                return pSDevCenterTypeBase.isMaxObj4CntDirty();
            }
            case 19: {
                return pSDevCenterTypeBase.isMaxObjCntDirty();
            }
            case 20: {
                return pSDevCenterTypeBase.isMaxSysBakCntDirty();
            }
            case 21: {
                return pSDevCenterTypeBase.isMaxUserCntDirty();
            }
            case 22: {
                return pSDevCenterTypeBase.isMaxWorkspaceCntDirty();
            }
            case 23: {
                return pSDevCenterTypeBase.isMemoDirty();
            }
            case 24: {
                return pSDevCenterTypeBase.isPSDevCenterTypeIdDirty();
            }
            case 25: {
                return pSDevCenterTypeBase.isPSDevCenterTypeNameDirty();
            }
            case 26: {
                return pSDevCenterTypeBase.isTypeParamsDirty();
            }
            case 27: {
                return pSDevCenterTypeBase.isUpdateDateDirty();
            }
            case 28: {
                return pSDevCenterTypeBase.isUpdateManDirty();
            }
            case 29: {
                return pSDevCenterTypeBase.isUserTagDirty();
            }
            case 30: {
                return pSDevCenterTypeBase.isUserTag2Dirty();
            }
            case 31: {
                return pSDevCenterTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevCenterTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevCenterTypeBase pSDevCenterTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevCenterTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevCenterTypeBase.getJSONValue((Object)pSDevCenterTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevCenterTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevCenterTypeBase.getJSONValue((Object)pSDevCenterTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevCenterTypeBase.getDCLevel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dclevel", (Object)PSDevCenterTypeBase.getJSONValue((Object)pSDevCenterTypeBase.getDCLevel()), (boolean)false);
        }
        if (bl || pSDevCenterTypeBase.getDCType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dctype", (Object)PSDevCenterTypeBase.getJSONValue((Object)pSDevCenterTypeBase.getDCType()), (boolean)false);
        }
        if (bl || pSDevCenterTypeBase.getExp() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exp", (Object)PSDevCenterTypeBase.getJSONValue((Object)pSDevCenterTypeBase.getExp()), (boolean)false);
        }
        if (bl || pSDevCenterTypeBase.getExp2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exp2", (Object)PSDevCenterTypeBase.getJSONValue((Object)pSDevCenterTypeBase.getExp2()), (boolean)false);
        }
        if (bl || pSDevCenterTypeBase.getLimits() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"limits", (Object)PSDevCenterTypeBase.getJSONValue((Object)pSDevCenterTypeBase.getLimits()), (boolean)false);
        }
        if (bl || pSDevCenterTypeBase.getMaxDBInstCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxdbinstcnt", (Object)PSDevCenterTypeBase.getJSONValue((Object)pSDevCenterTypeBase.getMaxDBInstCnt()), (boolean)false);
        }
        if (bl || pSDevCenterTypeBase.getMaxDepInstCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxdepinstcnt", (Object)PSDevCenterTypeBase.getJSONValue((Object)pSDevCenterTypeBase.getMaxDepInstCnt()), (boolean)false);
        }
        if (bl || pSDevCenterTypeBase.getMaxDevObjCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxdevobjcnt", (Object)PSDevCenterTypeBase.getJSONValue((Object)pSDevCenterTypeBase.getMaxDevObjCnt()), (boolean)false);
        }
        if (bl || pSDevCenterTypeBase.getMaxDevSlnCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxdevslncnt", (Object)PSDevCenterTypeBase.getJSONValue((Object)pSDevCenterTypeBase.getMaxDevSlnCnt()), (boolean)false);
        }
        if (bl || pSDevCenterTypeBase.getMaxDevSysCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxdevsyscnt", (Object)PSDevCenterTypeBase.getJSONValue((Object)pSDevCenterTypeBase.getMaxDevSysCnt()), (boolean)false);
        }
        if (bl || pSDevCenterTypeBase.getMaxDevTemplCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxdevtemplcnt", (Object)PSDevCenterTypeBase.getJSONValue((Object)pSDevCenterTypeBase.getMaxDevTemplCnt()), (boolean)false);
        }
        if (bl || pSDevCenterTypeBase.getMaxDynaInstCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxdynainstcnt", (Object)PSDevCenterTypeBase.getJSONValue((Object)pSDevCenterTypeBase.getMaxDynaInstCnt()), (boolean)false);
        }
        if (bl || pSDevCenterTypeBase.getMaxGitLabAccLevel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxgitlabacclevel", (Object)PSDevCenterTypeBase.getJSONValue((Object)pSDevCenterTypeBase.getMaxGitLabAccLevel()), (boolean)false);
        }
        if (bl || pSDevCenterTypeBase.getMaxMSPCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxmspcnt", (Object)PSDevCenterTypeBase.getJSONValue((Object)pSDevCenterTypeBase.getMaxMSPCnt()), (boolean)false);
        }
        if (bl || pSDevCenterTypeBase.getMaxObj2Cnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxobj2cnt", (Object)PSDevCenterTypeBase.getJSONValue((Object)pSDevCenterTypeBase.getMaxObj2Cnt()), (boolean)false);
        }
        if (bl || pSDevCenterTypeBase.getMaxObj3Cnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxobj3cnt", (Object)PSDevCenterTypeBase.getJSONValue((Object)pSDevCenterTypeBase.getMaxObj3Cnt()), (boolean)false);
        }
        if (bl || pSDevCenterTypeBase.getMaxObj4Cnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxobj4cnt", (Object)PSDevCenterTypeBase.getJSONValue((Object)pSDevCenterTypeBase.getMaxObj4Cnt()), (boolean)false);
        }
        if (bl || pSDevCenterTypeBase.getMaxObjCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxobjcnt", (Object)PSDevCenterTypeBase.getJSONValue((Object)pSDevCenterTypeBase.getMaxObjCnt()), (boolean)false);
        }
        if (bl || pSDevCenterTypeBase.getMaxSysBakCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxsysbakcnt", (Object)PSDevCenterTypeBase.getJSONValue((Object)pSDevCenterTypeBase.getMaxSysBakCnt()), (boolean)false);
        }
        if (bl || pSDevCenterTypeBase.getMaxUserCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxusercnt", (Object)PSDevCenterTypeBase.getJSONValue((Object)pSDevCenterTypeBase.getMaxUserCnt()), (boolean)false);
        }
        if (bl || pSDevCenterTypeBase.getMaxWorkspaceCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxworkspacecnt", (Object)PSDevCenterTypeBase.getJSONValue((Object)pSDevCenterTypeBase.getMaxWorkspaceCnt()), (boolean)false);
        }
        if (bl || pSDevCenterTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevCenterTypeBase.getJSONValue((Object)pSDevCenterTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevCenterTypeBase.getPSDevCenterTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentertypeid", (Object)PSDevCenterTypeBase.getJSONValue((Object)pSDevCenterTypeBase.getPSDevCenterTypeId()), (boolean)false);
        }
        if (bl || pSDevCenterTypeBase.getPSDevCenterTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentertypename", (Object)PSDevCenterTypeBase.getJSONValue((Object)pSDevCenterTypeBase.getPSDevCenterTypeName()), (boolean)false);
        }
        if (bl || pSDevCenterTypeBase.getTypeParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeparams", (Object)PSDevCenterTypeBase.getJSONValue((Object)pSDevCenterTypeBase.getTypeParams()), (boolean)false);
        }
        if (bl || pSDevCenterTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevCenterTypeBase.getJSONValue((Object)pSDevCenterTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevCenterTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevCenterTypeBase.getJSONValue((Object)pSDevCenterTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevCenterTypeBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDevCenterTypeBase.getJSONValue((Object)pSDevCenterTypeBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDevCenterTypeBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDevCenterTypeBase.getJSONValue((Object)pSDevCenterTypeBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDevCenterTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDevCenterTypeBase.getJSONValue((Object)pSDevCenterTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevCenterTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevCenterTypeBase pSDevCenterTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevCenterTypeBase.getCreateDate() != null) {
            object = pSDevCenterTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterTypeBase.getCreateMan() != null) {
            object = pSDevCenterTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterTypeBase.getDCLevel() != null) {
            object = pSDevCenterTypeBase.getDCLevel();
            xmlNode.setAttribute(FIELD_DCLEVEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterTypeBase.getDCType() != null) {
            object = pSDevCenterTypeBase.getDCType();
            xmlNode.setAttribute(FIELD_DCTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterTypeBase.getExp() != null) {
            object = pSDevCenterTypeBase.getExp();
            xmlNode.setAttribute(FIELD_EXP, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterTypeBase.getExp2() != null) {
            object = pSDevCenterTypeBase.getExp2();
            xmlNode.setAttribute(FIELD_EXP2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterTypeBase.getLimits() != null) {
            object = pSDevCenterTypeBase.getLimits();
            xmlNode.setAttribute(FIELD_LIMITS, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterTypeBase.getMaxDBInstCnt() != null) {
            object = pSDevCenterTypeBase.getMaxDBInstCnt();
            xmlNode.setAttribute(FIELD_MAXDBINSTCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterTypeBase.getMaxDepInstCnt() != null) {
            object = pSDevCenterTypeBase.getMaxDepInstCnt();
            xmlNode.setAttribute(FIELD_MAXDEPINSTCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterTypeBase.getMaxDevObjCnt() != null) {
            object = pSDevCenterTypeBase.getMaxDevObjCnt();
            xmlNode.setAttribute(FIELD_MAXDEVOBJCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterTypeBase.getMaxDevSlnCnt() != null) {
            object = pSDevCenterTypeBase.getMaxDevSlnCnt();
            xmlNode.setAttribute(FIELD_MAXDEVSLNCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterTypeBase.getMaxDevSysCnt() != null) {
            object = pSDevCenterTypeBase.getMaxDevSysCnt();
            xmlNode.setAttribute(FIELD_MAXDEVSYSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterTypeBase.getMaxDevTemplCnt() != null) {
            object = pSDevCenterTypeBase.getMaxDevTemplCnt();
            xmlNode.setAttribute(FIELD_MAXDEVTEMPLCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterTypeBase.getMaxDynaInstCnt() != null) {
            object = pSDevCenterTypeBase.getMaxDynaInstCnt();
            xmlNode.setAttribute(FIELD_MAXDYNAINSTCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterTypeBase.getMaxGitLabAccLevel() != null) {
            object = pSDevCenterTypeBase.getMaxGitLabAccLevel();
            xmlNode.setAttribute(FIELD_MAXGITLABACCLEVEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterTypeBase.getMaxMSPCnt() != null) {
            object = pSDevCenterTypeBase.getMaxMSPCnt();
            xmlNode.setAttribute(FIELD_MAXMSPCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterTypeBase.getMaxObj2Cnt() != null) {
            object = pSDevCenterTypeBase.getMaxObj2Cnt();
            xmlNode.setAttribute(FIELD_MAXOBJ2CNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterTypeBase.getMaxObj3Cnt() != null) {
            object = pSDevCenterTypeBase.getMaxObj3Cnt();
            xmlNode.setAttribute(FIELD_MAXOBJ3CNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterTypeBase.getMaxObj4Cnt() != null) {
            object = pSDevCenterTypeBase.getMaxObj4Cnt();
            xmlNode.setAttribute(FIELD_MAXOBJ4CNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterTypeBase.getMaxObjCnt() != null) {
            object = pSDevCenterTypeBase.getMaxObjCnt();
            xmlNode.setAttribute(FIELD_MAXOBJCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterTypeBase.getMaxSysBakCnt() != null) {
            object = pSDevCenterTypeBase.getMaxSysBakCnt();
            xmlNode.setAttribute(FIELD_MAXSYSBAKCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterTypeBase.getMaxUserCnt() != null) {
            object = pSDevCenterTypeBase.getMaxUserCnt();
            xmlNode.setAttribute(FIELD_MAXUSERCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterTypeBase.getMaxWorkspaceCnt() != null) {
            object = pSDevCenterTypeBase.getMaxWorkspaceCnt();
            xmlNode.setAttribute(FIELD_MAXWORKSPACECNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterTypeBase.getMemo() != null) {
            object = pSDevCenterTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterTypeBase.getPSDevCenterTypeId() != null) {
            object = pSDevCenterTypeBase.getPSDevCenterTypeId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterTypeBase.getPSDevCenterTypeName() != null) {
            object = pSDevCenterTypeBase.getPSDevCenterTypeName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterTypeBase.getTypeParams() != null) {
            object = pSDevCenterTypeBase.getTypeParams();
            xmlNode.setAttribute(FIELD_TYPEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterTypeBase.getUpdateDate() != null) {
            object = pSDevCenterTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterTypeBase.getUpdateMan() != null) {
            object = pSDevCenterTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterTypeBase.getUserTag() != null) {
            object = pSDevCenterTypeBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterTypeBase.getUserTag2() != null) {
            object = pSDevCenterTypeBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterTypeBase.getValidFlag() != null) {
            object = pSDevCenterTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevCenterTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevCenterTypeBase pSDevCenterTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevCenterTypeBase.isCreateDateDirty() && (bl || pSDevCenterTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevCenterTypeBase.getCreateDate());
        }
        if (pSDevCenterTypeBase.isCreateManDirty() && (bl || pSDevCenterTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevCenterTypeBase.getCreateMan());
        }
        if (pSDevCenterTypeBase.isDCLevelDirty() && (bl || pSDevCenterTypeBase.getDCLevel() != null)) {
            iDataObject.set(FIELD_DCLEVEL, (Object)pSDevCenterTypeBase.getDCLevel());
        }
        if (pSDevCenterTypeBase.isDCTypeDirty() && (bl || pSDevCenterTypeBase.getDCType() != null)) {
            iDataObject.set(FIELD_DCTYPE, (Object)pSDevCenterTypeBase.getDCType());
        }
        if (pSDevCenterTypeBase.isExpDirty() && (bl || pSDevCenterTypeBase.getExp() != null)) {
            iDataObject.set(FIELD_EXP, (Object)pSDevCenterTypeBase.getExp());
        }
        if (pSDevCenterTypeBase.isExp2Dirty() && (bl || pSDevCenterTypeBase.getExp2() != null)) {
            iDataObject.set(FIELD_EXP2, (Object)pSDevCenterTypeBase.getExp2());
        }
        if (pSDevCenterTypeBase.isLimitsDirty() && (bl || pSDevCenterTypeBase.getLimits() != null)) {
            iDataObject.set(FIELD_LIMITS, (Object)pSDevCenterTypeBase.getLimits());
        }
        if (pSDevCenterTypeBase.isMaxDBInstCntDirty() && (bl || pSDevCenterTypeBase.getMaxDBInstCnt() != null)) {
            iDataObject.set(FIELD_MAXDBINSTCNT, (Object)pSDevCenterTypeBase.getMaxDBInstCnt());
        }
        if (pSDevCenterTypeBase.isMaxDepInstCntDirty() && (bl || pSDevCenterTypeBase.getMaxDepInstCnt() != null)) {
            iDataObject.set(FIELD_MAXDEPINSTCNT, (Object)pSDevCenterTypeBase.getMaxDepInstCnt());
        }
        if (pSDevCenterTypeBase.isMaxDevObjCntDirty() && (bl || pSDevCenterTypeBase.getMaxDevObjCnt() != null)) {
            iDataObject.set(FIELD_MAXDEVOBJCNT, (Object)pSDevCenterTypeBase.getMaxDevObjCnt());
        }
        if (pSDevCenterTypeBase.isMaxDevSlnCntDirty() && (bl || pSDevCenterTypeBase.getMaxDevSlnCnt() != null)) {
            iDataObject.set(FIELD_MAXDEVSLNCNT, (Object)pSDevCenterTypeBase.getMaxDevSlnCnt());
        }
        if (pSDevCenterTypeBase.isMaxDevSysCntDirty() && (bl || pSDevCenterTypeBase.getMaxDevSysCnt() != null)) {
            iDataObject.set(FIELD_MAXDEVSYSCNT, (Object)pSDevCenterTypeBase.getMaxDevSysCnt());
        }
        if (pSDevCenterTypeBase.isMaxDevTemplCntDirty() && (bl || pSDevCenterTypeBase.getMaxDevTemplCnt() != null)) {
            iDataObject.set(FIELD_MAXDEVTEMPLCNT, (Object)pSDevCenterTypeBase.getMaxDevTemplCnt());
        }
        if (pSDevCenterTypeBase.isMaxDynaInstCntDirty() && (bl || pSDevCenterTypeBase.getMaxDynaInstCnt() != null)) {
            iDataObject.set(FIELD_MAXDYNAINSTCNT, (Object)pSDevCenterTypeBase.getMaxDynaInstCnt());
        }
        if (pSDevCenterTypeBase.isMaxGitLabAccLevelDirty() && (bl || pSDevCenterTypeBase.getMaxGitLabAccLevel() != null)) {
            iDataObject.set(FIELD_MAXGITLABACCLEVEL, (Object)pSDevCenterTypeBase.getMaxGitLabAccLevel());
        }
        if (pSDevCenterTypeBase.isMaxMSPCntDirty() && (bl || pSDevCenterTypeBase.getMaxMSPCnt() != null)) {
            iDataObject.set(FIELD_MAXMSPCNT, (Object)pSDevCenterTypeBase.getMaxMSPCnt());
        }
        if (pSDevCenterTypeBase.isMaxObj2CntDirty() && (bl || pSDevCenterTypeBase.getMaxObj2Cnt() != null)) {
            iDataObject.set(FIELD_MAXOBJ2CNT, (Object)pSDevCenterTypeBase.getMaxObj2Cnt());
        }
        if (pSDevCenterTypeBase.isMaxObj3CntDirty() && (bl || pSDevCenterTypeBase.getMaxObj3Cnt() != null)) {
            iDataObject.set(FIELD_MAXOBJ3CNT, (Object)pSDevCenterTypeBase.getMaxObj3Cnt());
        }
        if (pSDevCenterTypeBase.isMaxObj4CntDirty() && (bl || pSDevCenterTypeBase.getMaxObj4Cnt() != null)) {
            iDataObject.set(FIELD_MAXOBJ4CNT, (Object)pSDevCenterTypeBase.getMaxObj4Cnt());
        }
        if (pSDevCenterTypeBase.isMaxObjCntDirty() && (bl || pSDevCenterTypeBase.getMaxObjCnt() != null)) {
            iDataObject.set(FIELD_MAXOBJCNT, (Object)pSDevCenterTypeBase.getMaxObjCnt());
        }
        if (pSDevCenterTypeBase.isMaxSysBakCntDirty() && (bl || pSDevCenterTypeBase.getMaxSysBakCnt() != null)) {
            iDataObject.set(FIELD_MAXSYSBAKCNT, (Object)pSDevCenterTypeBase.getMaxSysBakCnt());
        }
        if (pSDevCenterTypeBase.isMaxUserCntDirty() && (bl || pSDevCenterTypeBase.getMaxUserCnt() != null)) {
            iDataObject.set(FIELD_MAXUSERCNT, (Object)pSDevCenterTypeBase.getMaxUserCnt());
        }
        if (pSDevCenterTypeBase.isMaxWorkspaceCntDirty() && (bl || pSDevCenterTypeBase.getMaxWorkspaceCnt() != null)) {
            iDataObject.set(FIELD_MAXWORKSPACECNT, (Object)pSDevCenterTypeBase.getMaxWorkspaceCnt());
        }
        if (pSDevCenterTypeBase.isMemoDirty() && (bl || pSDevCenterTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevCenterTypeBase.getMemo());
        }
        if (pSDevCenterTypeBase.isPSDevCenterTypeIdDirty() && (bl || pSDevCenterTypeBase.getPSDevCenterTypeId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERTYPEID, (Object)pSDevCenterTypeBase.getPSDevCenterTypeId());
        }
        if (pSDevCenterTypeBase.isPSDevCenterTypeNameDirty() && (bl || pSDevCenterTypeBase.getPSDevCenterTypeName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERTYPENAME, (Object)pSDevCenterTypeBase.getPSDevCenterTypeName());
        }
        if (pSDevCenterTypeBase.isTypeParamsDirty() && (bl || pSDevCenterTypeBase.getTypeParams() != null)) {
            iDataObject.set(FIELD_TYPEPARAMS, (Object)pSDevCenterTypeBase.getTypeParams());
        }
        if (pSDevCenterTypeBase.isUpdateDateDirty() && (bl || pSDevCenterTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevCenterTypeBase.getUpdateDate());
        }
        if (pSDevCenterTypeBase.isUpdateManDirty() && (bl || pSDevCenterTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevCenterTypeBase.getUpdateMan());
        }
        if (pSDevCenterTypeBase.isUserTagDirty() && (bl || pSDevCenterTypeBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDevCenterTypeBase.getUserTag());
        }
        if (pSDevCenterTypeBase.isUserTag2Dirty() && (bl || pSDevCenterTypeBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDevCenterTypeBase.getUserTag2());
        }
        if (pSDevCenterTypeBase.isValidFlagDirty() && (bl || pSDevCenterTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDevCenterTypeBase.getValidFlag());
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
        return PSDevCenterTypeBase.remove(this, n);
    }

    private static boolean remove(PSDevCenterTypeBase pSDevCenterTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevCenterTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevCenterTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevCenterTypeBase.resetDCLevel();
                return true;
            }
            case 3: {
                pSDevCenterTypeBase.resetDCType();
                return true;
            }
            case 4: {
                pSDevCenterTypeBase.resetExp();
                return true;
            }
            case 5: {
                pSDevCenterTypeBase.resetExp2();
                return true;
            }
            case 6: {
                pSDevCenterTypeBase.resetLimits();
                return true;
            }
            case 7: {
                pSDevCenterTypeBase.resetMaxDBInstCnt();
                return true;
            }
            case 8: {
                pSDevCenterTypeBase.resetMaxDepInstCnt();
                return true;
            }
            case 9: {
                pSDevCenterTypeBase.resetMaxDevObjCnt();
                return true;
            }
            case 10: {
                pSDevCenterTypeBase.resetMaxDevSlnCnt();
                return true;
            }
            case 11: {
                pSDevCenterTypeBase.resetMaxDevSysCnt();
                return true;
            }
            case 12: {
                pSDevCenterTypeBase.resetMaxDevTemplCnt();
                return true;
            }
            case 13: {
                pSDevCenterTypeBase.resetMaxDynaInstCnt();
                return true;
            }
            case 14: {
                pSDevCenterTypeBase.resetMaxGitLabAccLevel();
                return true;
            }
            case 15: {
                pSDevCenterTypeBase.resetMaxMSPCnt();
                return true;
            }
            case 16: {
                pSDevCenterTypeBase.resetMaxObj2Cnt();
                return true;
            }
            case 17: {
                pSDevCenterTypeBase.resetMaxObj3Cnt();
                return true;
            }
            case 18: {
                pSDevCenterTypeBase.resetMaxObj4Cnt();
                return true;
            }
            case 19: {
                pSDevCenterTypeBase.resetMaxObjCnt();
                return true;
            }
            case 20: {
                pSDevCenterTypeBase.resetMaxSysBakCnt();
                return true;
            }
            case 21: {
                pSDevCenterTypeBase.resetMaxUserCnt();
                return true;
            }
            case 22: {
                pSDevCenterTypeBase.resetMaxWorkspaceCnt();
                return true;
            }
            case 23: {
                pSDevCenterTypeBase.resetMemo();
                return true;
            }
            case 24: {
                pSDevCenterTypeBase.resetPSDevCenterTypeId();
                return true;
            }
            case 25: {
                pSDevCenterTypeBase.resetPSDevCenterTypeName();
                return true;
            }
            case 26: {
                pSDevCenterTypeBase.resetTypeParams();
                return true;
            }
            case 27: {
                pSDevCenterTypeBase.resetUpdateDate();
                return true;
            }
            case 28: {
                pSDevCenterTypeBase.resetUpdateMan();
                return true;
            }
            case 29: {
                pSDevCenterTypeBase.resetUserTag();
                return true;
            }
            case 30: {
                pSDevCenterTypeBase.resetUserTag2();
                return true;
            }
            case 31: {
                pSDevCenterTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDevCenterTypeBase getProxyEntity() {
        return this.proxyPSDevCenterTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevCenterTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevCenterTypeBase) {
            this.proxyPSDevCenterTypeBase = (PSDevCenterTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDevCenterTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DCLEVEL, 2);
        fieldIndexMap.put(FIELD_DCTYPE, 3);
        fieldIndexMap.put(FIELD_EXP, 4);
        fieldIndexMap.put(FIELD_EXP2, 5);
        fieldIndexMap.put(FIELD_LIMITS, 6);
        fieldIndexMap.put(FIELD_MAXDBINSTCNT, 7);
        fieldIndexMap.put(FIELD_MAXDEPINSTCNT, 8);
        fieldIndexMap.put(FIELD_MAXDEVOBJCNT, 9);
        fieldIndexMap.put(FIELD_MAXDEVSLNCNT, 10);
        fieldIndexMap.put(FIELD_MAXDEVSYSCNT, 11);
        fieldIndexMap.put(FIELD_MAXDEVTEMPLCNT, 12);
        fieldIndexMap.put(FIELD_MAXDYNAINSTCNT, 13);
        fieldIndexMap.put(FIELD_MAXGITLABACCLEVEL, 14);
        fieldIndexMap.put(FIELD_MAXMSPCNT, 15);
        fieldIndexMap.put(FIELD_MAXOBJ2CNT, 16);
        fieldIndexMap.put(FIELD_MAXOBJ3CNT, 17);
        fieldIndexMap.put(FIELD_MAXOBJ4CNT, 18);
        fieldIndexMap.put(FIELD_MAXOBJCNT, 19);
        fieldIndexMap.put(FIELD_MAXSYSBAKCNT, 20);
        fieldIndexMap.put(FIELD_MAXUSERCNT, 21);
        fieldIndexMap.put(FIELD_MAXWORKSPACECNT, 22);
        fieldIndexMap.put(FIELD_MEMO, 23);
        fieldIndexMap.put(FIELD_PSDEVCENTERTYPEID, 24);
        fieldIndexMap.put(FIELD_PSDEVCENTERTYPENAME, 25);
        fieldIndexMap.put(FIELD_TYPEPARAMS, 26);
        fieldIndexMap.put(FIELD_UPDATEDATE, 27);
        fieldIndexMap.put(FIELD_UPDATEMAN, 28);
        fieldIndexMap.put(FIELD_USERTAG, 29);
        fieldIndexMap.put(FIELD_USERTAG2, 30);
        fieldIndexMap.put(FIELD_VALIDFLAG, 31);
    }
}

