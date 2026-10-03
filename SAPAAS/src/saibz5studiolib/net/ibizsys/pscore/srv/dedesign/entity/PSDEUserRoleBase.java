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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPrivRole;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivRoleService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserDR;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUserDRService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEUserRoleBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEUserRoleBase.class);
    public static final String FIELD_ALLDATAFLAG = "ALLDATAFLAG";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCOND = "CUSTOMCOND";
    public static final String FIELD_CUSTOMTYPE = "CUSTOMTYPE";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_ENABLEORGDR = "ENABLEORGDR";
    public static final String FIELD_ENABLESECBC = "ENABLESECBC";
    public static final String FIELD_ENABLESECDR = "ENABLESECDR";
    public static final String FIELD_ENABLEUSERDR = "ENABLEUSERDR";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORGDR = "ORGDR";
    public static final String FIELD_PSDEDSID = "PSDEDSID";
    public static final String FIELD_PSDEDSNAME = "PSDEDSNAME";
    public static final String FIELD_PSDEFGROUPID = "PSDEFGROUPID";
    public static final String FIELD_PSDEFGROUPNAME = "PSDEFGROUPNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDEUSERROLEID = "PSDEUSERROLEID";
    public static final String FIELD_PSDEUSERROLENAME = "PSDEUSERROLENAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSUSERDRID = "PSSYSUSERDRID";
    public static final String FIELD_PSSYSUSERDRID2 = "PSSYSUSERDRID2";
    public static final String FIELD_PSSYSUSERDRNAME = "PSSYSUSERDRNAME";
    public static final String FIELD_PSSYSUSERDRNAME2 = "PSSYSUSERDRNAME2";
    public static final String FIELD_SECBC = "SECBC";
    public static final String FIELD_SECDR = "SECDR";
    public static final String FIELD_SYSTEMFLAG = "SYSTEMFLAG";
    public static final String FIELD_SYSUSERDR2PARAM = "SYSUSERDR2PARAM";
    public static final String FIELD_SYSUSERDRPARAM = "SYSUSERDRPARAM";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERROLETAG = "USERROLETAG";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ALLDATAFLAG = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_CUSTOMCOND = 3;
    private static final int INDEX_CUSTOMTYPE = 4;
    private static final int INDEX_DEFAULTFLAG = 5;
    private static final int INDEX_ENABLEORGDR = 6;
    private static final int INDEX_ENABLESECBC = 7;
    private static final int INDEX_ENABLESECDR = 8;
    private static final int INDEX_ENABLEUSERDR = 9;
    private static final int INDEX_LOCKFLAG = 10;
    private static final int INDEX_MEMO = 11;
    private static final int INDEX_ORGDR = 12;
    private static final int INDEX_PSDEDSID = 13;
    private static final int INDEX_PSDEDSNAME = 14;
    private static final int INDEX_PSDEFGROUPID = 15;
    private static final int INDEX_PSDEFGROUPNAME = 16;
    private static final int INDEX_PSDEID = 17;
    private static final int INDEX_PSDENAME = 18;
    private static final int INDEX_PSDEUSERROLEID = 19;
    private static final int INDEX_PSDEUSERROLENAME = 20;
    private static final int INDEX_PSSYSSFPLUGINID = 21;
    private static final int INDEX_PSSYSSFPLUGINNAME = 22;
    private static final int INDEX_PSSYSUSERDRID = 23;
    private static final int INDEX_PSSYSUSERDRID2 = 24;
    private static final int INDEX_PSSYSUSERDRNAME = 25;
    private static final int INDEX_PSSYSUSERDRNAME2 = 26;
    private static final int INDEX_SECBC = 27;
    private static final int INDEX_SECDR = 28;
    private static final int INDEX_SYSTEMFLAG = 29;
    private static final int INDEX_SYSUSERDR2PARAM = 30;
    private static final int INDEX_SYSUSERDRPARAM = 31;
    private static final int INDEX_UPDATEDATE = 32;
    private static final int INDEX_UPDATEMAN = 33;
    private static final int INDEX_USERCAT = 34;
    private static final int INDEX_USERROLETAG = 35;
    private static final int INDEX_USERTAG = 36;
    private static final int INDEX_USERTAG2 = 37;
    private static final int INDEX_USERTAG3 = 38;
    private static final int INDEX_USERTAG4 = 39;
    private static final int INDEX_VALIDFLAG = 40;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEUserRoleBase proxyPSDEUserRoleBase = null;
    private boolean alldataflagDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcondDirtyFlag = false;
    private boolean customtypeDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean enableorgdrDirtyFlag = false;
    private boolean enablesecbcDirtyFlag = false;
    private boolean enablesecdrDirtyFlag = false;
    private boolean enableuserdrDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean orgdrDirtyFlag = false;
    private boolean psdedsidDirtyFlag = false;
    private boolean psdedsnameDirtyFlag = false;
    private boolean psdefgroupidDirtyFlag = false;
    private boolean psdefgroupnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdeuserroleidDirtyFlag = false;
    private boolean psdeuserrolenameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssysuserdridDirtyFlag = false;
    private boolean pssysuserdrid2DirtyFlag = false;
    private boolean pssysuserdrnameDirtyFlag = false;
    private boolean pssysuserdrname2DirtyFlag = false;
    private boolean secbcDirtyFlag = false;
    private boolean secdrDirtyFlag = false;
    private boolean systemflagDirtyFlag = false;
    private boolean sysuserdr2paramDirtyFlag = false;
    private boolean sysuserdrparamDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userroletagDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="alldataflag")
    private Integer alldataflag;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcond")
    private String customcond;
    @Column(name="customtype")
    private String customtype;
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="enableorgdr")
    private Integer enableorgdr;
    @Column(name="enablesecbc")
    private Integer enablesecbc;
    @Column(name="enablesecdr")
    private Integer enablesecdr;
    @Column(name="enableuserdr")
    private Integer enableuserdr;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="orgdr")
    private Integer orgdr;
    @Column(name="psdedsid")
    private String psdedsid;
    @Column(name="psdedsname")
    private String psdedsname;
    @Column(name="psdefgroupid")
    private String psdefgroupid;
    @Column(name="psdefgroupname")
    private String psdefgroupname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdeuserroleid")
    private String psdeuserroleid;
    @Column(name="psdeuserrolename")
    private String psdeuserrolename;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssysuserdrid")
    private String pssysuserdrid;
    @Column(name="pssysuserdrid2")
    private String pssysuserdrid2;
    @Column(name="pssysuserdrname")
    private String pssysuserdrname;
    @Column(name="pssysuserdrname2")
    private String pssysuserdrname2;
    @Column(name="secbc")
    private String secbc;
    @Column(name="secdr")
    private Integer secdr;
    @Column(name="systemflag")
    private Integer systemflag;
    @Column(name="sysuserdr2param")
    private String sysuserdr2param;
    @Column(name="sysuserdrparam")
    private String sysuserdrparam;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="userroletag")
    private String userroletag;
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
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEDSLock = new Integer(1);
    private PSDEDataSet psdeds = null;
    private Integer objPSDEFGroupLock = new Integer(1);
    private PSDEFGroup psdefgroup = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSysUserDRLock = new Integer(1);
    private PSSysUserDR pssysuserdr = null;
    private Integer objPSSysUserDR2Lock = new Integer(1);
    private PSSysUserDR pssysuserdr2 = null;
    private Integer objPSDEOPPrivRolesLock = new Integer(1);
    private ArrayList<PSDEOPPrivRole> psdeopprivroles = null;

    public void setAllDataFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAllDataFlag(n);
            return;
        }
        this.alldataflag = n;
        this.alldataflagDirtyFlag = true;
    }

    public Integer getAllDataFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAllDataFlag();
        }
        return this.alldataflag;
    }

    public boolean isAllDataFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAllDataFlagDirty();
        }
        return this.alldataflagDirtyFlag;
    }

    public void resetAllDataFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAllDataFlag();
            return;
        }
        this.alldataflagDirtyFlag = false;
        this.alldataflag = null;
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

    public void setCustomCond(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomCond(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customcond = string;
        this.customcondDirtyFlag = true;
    }

    public String getCustomCond() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomCond();
        }
        return this.customcond;
    }

    public boolean isCustomCondDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomCondDirty();
        }
        return this.customcondDirtyFlag;
    }

    public void resetCustomCond() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomCond();
            return;
        }
        this.customcondDirtyFlag = false;
        this.customcond = null;
    }

    public void setCustomType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customtype = string;
        this.customtypeDirtyFlag = true;
    }

    public String getCustomType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomType();
        }
        return this.customtype;
    }

    public boolean isCustomTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomTypeDirty();
        }
        return this.customtypeDirtyFlag;
    }

    public void resetCustomType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomType();
            return;
        }
        this.customtypeDirtyFlag = false;
        this.customtype = null;
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

    public void setEnableOrgDR(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableOrgDR(n);
            return;
        }
        this.enableorgdr = n;
        this.enableorgdrDirtyFlag = true;
    }

    public Integer getEnableOrgDR() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableOrgDR();
        }
        return this.enableorgdr;
    }

    public boolean isEnableOrgDRDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableOrgDRDirty();
        }
        return this.enableorgdrDirtyFlag;
    }

    public void resetEnableOrgDR() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableOrgDR();
            return;
        }
        this.enableorgdrDirtyFlag = false;
        this.enableorgdr = null;
    }

    public void setEnableSecBC(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableSecBC(n);
            return;
        }
        this.enablesecbc = n;
        this.enablesecbcDirtyFlag = true;
    }

    public Integer getEnableSecBC() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableSecBC();
        }
        return this.enablesecbc;
    }

    public boolean isEnableSecBCDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableSecBCDirty();
        }
        return this.enablesecbcDirtyFlag;
    }

    public void resetEnableSecBC() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableSecBC();
            return;
        }
        this.enablesecbcDirtyFlag = false;
        this.enablesecbc = null;
    }

    public void setEnableSecDR(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableSecDR(n);
            return;
        }
        this.enablesecdr = n;
        this.enablesecdrDirtyFlag = true;
    }

    public Integer getEnableSecDR() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableSecDR();
        }
        return this.enablesecdr;
    }

    public boolean isEnableSecDRDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableSecDRDirty();
        }
        return this.enablesecdrDirtyFlag;
    }

    public void resetEnableSecDR() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableSecDR();
            return;
        }
        this.enablesecdrDirtyFlag = false;
        this.enablesecdr = null;
    }

    public void setEnableUserDR(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableUserDR(n);
            return;
        }
        this.enableuserdr = n;
        this.enableuserdrDirtyFlag = true;
    }

    public Integer getEnableUserDR() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableUserDR();
        }
        return this.enableuserdr;
    }

    public boolean isEnableUserDRDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableUserDRDirty();
        }
        return this.enableuserdrDirtyFlag;
    }

    public void resetEnableUserDR() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableUserDR();
            return;
        }
        this.enableuserdrDirtyFlag = false;
        this.enableuserdr = null;
    }

    public void setLockFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLockFlag(n);
            return;
        }
        this.lockflag = n;
        this.lockflagDirtyFlag = true;
    }

    public Integer getLockFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLockFlag();
        }
        return this.lockflag;
    }

    public boolean isLockFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLockFlagDirty();
        }
        return this.lockflagDirtyFlag;
    }

    public void resetLockFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLockFlag();
            return;
        }
        this.lockflagDirtyFlag = false;
        this.lockflag = null;
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

    public void setOrgDR(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrgDR(n);
            return;
        }
        this.orgdr = n;
        this.orgdrDirtyFlag = true;
    }

    public Integer getOrgDR() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrgDR();
        }
        return this.orgdr;
    }

    public boolean isOrgDRDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrgDRDirty();
        }
        return this.orgdrDirtyFlag;
    }

    public void resetOrgDR() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrgDR();
            return;
        }
        this.orgdrDirtyFlag = false;
        this.orgdr = null;
    }

    public void setPSDEDSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedsid = string;
        this.psdedsidDirtyFlag = true;
    }

    public String getPSDEDSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSId();
        }
        return this.psdedsid;
    }

    public boolean isPSDEDSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDSIdDirty();
        }
        return this.psdedsidDirtyFlag;
    }

    public void resetPSDEDSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDSId();
            return;
        }
        this.psdedsidDirtyFlag = false;
        this.psdedsid = null;
    }

    public void setPSDEDSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedsname = string;
        this.psdedsnameDirtyFlag = true;
    }

    public String getPSDEDSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSName();
        }
        return this.psdedsname;
    }

    public boolean isPSDEDSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDSNameDirty();
        }
        return this.psdedsnameDirtyFlag;
    }

    public void resetPSDEDSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDSName();
            return;
        }
        this.psdedsnameDirtyFlag = false;
        this.psdedsname = null;
    }

    public void setPSDEFGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefgroupid = string;
        this.psdefgroupidDirtyFlag = true;
    }

    public String getPSDEFGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFGroupId();
        }
        return this.psdefgroupid;
    }

    public boolean isPSDEFGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFGroupIdDirty();
        }
        return this.psdefgroupidDirtyFlag;
    }

    public void resetPSDEFGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFGroupId();
            return;
        }
        this.psdefgroupidDirtyFlag = false;
        this.psdefgroupid = null;
    }

    public void setPSDEFGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefgroupname = string;
        this.psdefgroupnameDirtyFlag = true;
    }

    public String getPSDEFGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFGroupName();
        }
        return this.psdefgroupname;
    }

    public boolean isPSDEFGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFGroupNameDirty();
        }
        return this.psdefgroupnameDirtyFlag;
    }

    public void resetPSDEFGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFGroupName();
            return;
        }
        this.psdefgroupnameDirtyFlag = false;
        this.psdefgroupname = null;
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

    public void setPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdename = string;
        this.psdenameDirtyFlag = true;
    }

    public String getPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEName();
        }
        return this.psdename;
    }

    public boolean isPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDENameDirty();
        }
        return this.psdenameDirtyFlag;
    }

    public void resetPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEName();
            return;
        }
        this.psdenameDirtyFlag = false;
        this.psdename = null;
    }

    public void setPSDEUserRoleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUserRoleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuserroleid = string;
        this.psdeuserroleidDirtyFlag = true;
    }

    public String getPSDEUserRoleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUserRoleId();
        }
        return this.psdeuserroleid;
    }

    public boolean isPSDEUserRoleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUserRoleIdDirty();
        }
        return this.psdeuserroleidDirtyFlag;
    }

    public void resetPSDEUserRoleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUserRoleId();
            return;
        }
        this.psdeuserroleidDirtyFlag = false;
        this.psdeuserroleid = null;
    }

    public void setPSDEUserRoleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUserRoleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuserrolename = string;
        this.psdeuserrolenameDirtyFlag = true;
    }

    public String getPSDEUserRoleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUserRoleName();
        }
        return this.psdeuserrolename;
    }

    public boolean isPSDEUserRoleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUserRoleNameDirty();
        }
        return this.psdeuserrolenameDirtyFlag;
    }

    public void resetPSDEUserRoleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUserRoleName();
            return;
        }
        this.psdeuserrolenameDirtyFlag = false;
        this.psdeuserrolename = null;
    }

    public void setPSSysSFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginid = string;
        this.pssyssfpluginidDirtyFlag = true;
    }

    public String getPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginId();
        }
        return this.pssyssfpluginid;
    }

    public boolean isPSSysSFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginIdDirty();
        }
        return this.pssyssfpluginidDirtyFlag;
    }

    public void resetPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginId();
            return;
        }
        this.pssyssfpluginidDirtyFlag = false;
        this.pssyssfpluginid = null;
    }

    public void setPSSysSFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginname = string;
        this.pssyssfpluginnameDirtyFlag = true;
    }

    public String getPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginName();
        }
        return this.pssyssfpluginname;
    }

    public boolean isPSSysSFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginNameDirty();
        }
        return this.pssyssfpluginnameDirtyFlag;
    }

    public void resetPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginName();
            return;
        }
        this.pssyssfpluginnameDirtyFlag = false;
        this.pssyssfpluginname = null;
    }

    public void setPSSysUserDRId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUserDRId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysuserdrid = string;
        this.pssysuserdridDirtyFlag = true;
    }

    public String getPSSysUserDRId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserDRId();
        }
        return this.pssysuserdrid;
    }

    public boolean isPSSysUserDRIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUserDRIdDirty();
        }
        return this.pssysuserdridDirtyFlag;
    }

    public void resetPSSysUserDRId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUserDRId();
            return;
        }
        this.pssysuserdridDirtyFlag = false;
        this.pssysuserdrid = null;
    }

    public void setPSSysUserDRId2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUserDRId2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysuserdrid2 = string;
        this.pssysuserdrid2DirtyFlag = true;
    }

    public String getPSSysUserDRId2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserDRId2();
        }
        return this.pssysuserdrid2;
    }

    public boolean isPSSysUserDRId2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUserDRId2Dirty();
        }
        return this.pssysuserdrid2DirtyFlag;
    }

    public void resetPSSysUserDRId2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUserDRId2();
            return;
        }
        this.pssysuserdrid2DirtyFlag = false;
        this.pssysuserdrid2 = null;
    }

    public void setPSSysUserDRName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUserDRName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysuserdrname = string;
        this.pssysuserdrnameDirtyFlag = true;
    }

    public String getPSSysUserDRName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserDRName();
        }
        return this.pssysuserdrname;
    }

    public boolean isPSSysUserDRNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUserDRNameDirty();
        }
        return this.pssysuserdrnameDirtyFlag;
    }

    public void resetPSSysUserDRName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUserDRName();
            return;
        }
        this.pssysuserdrnameDirtyFlag = false;
        this.pssysuserdrname = null;
    }

    public void setPSSysUserDRName2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUserDRName2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysuserdrname2 = string;
        this.pssysuserdrname2DirtyFlag = true;
    }

    public String getPSSysUserDRName2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserDRName2();
        }
        return this.pssysuserdrname2;
    }

    public boolean isPSSysUserDRName2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUserDRName2Dirty();
        }
        return this.pssysuserdrname2DirtyFlag;
    }

    public void resetPSSysUserDRName2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUserDRName2();
            return;
        }
        this.pssysuserdrname2DirtyFlag = false;
        this.pssysuserdrname2 = null;
    }

    public void setSecBC(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSecBC(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.secbc = string;
        this.secbcDirtyFlag = true;
    }

    public String getSecBC() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSecBC();
        }
        return this.secbc;
    }

    public boolean isSecBCDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSecBCDirty();
        }
        return this.secbcDirtyFlag;
    }

    public void resetSecBC() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSecBC();
            return;
        }
        this.secbcDirtyFlag = false;
        this.secbc = null;
    }

    public void setSecDR(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSecDR(n);
            return;
        }
        this.secdr = n;
        this.secdrDirtyFlag = true;
    }

    public Integer getSecDR() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSecDR();
        }
        return this.secdr;
    }

    public boolean isSecDRDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSecDRDirty();
        }
        return this.secdrDirtyFlag;
    }

    public void resetSecDR() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSecDR();
            return;
        }
        this.secdrDirtyFlag = false;
        this.secdr = null;
    }

    public void setSystemFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSystemFlag(n);
            return;
        }
        this.systemflag = n;
        this.systemflagDirtyFlag = true;
    }

    public Integer getSystemFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSystemFlag();
        }
        return this.systemflag;
    }

    public boolean isSystemFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSystemFlagDirty();
        }
        return this.systemflagDirtyFlag;
    }

    public void resetSystemFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSystemFlag();
            return;
        }
        this.systemflagDirtyFlag = false;
        this.systemflag = null;
    }

    public void setSysUserDR2Param(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysUserDR2Param(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sysuserdr2param = string;
        this.sysuserdr2paramDirtyFlag = true;
    }

    public String getSysUserDR2Param() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysUserDR2Param();
        }
        return this.sysuserdr2param;
    }

    public boolean isSysUserDR2ParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysUserDR2ParamDirty();
        }
        return this.sysuserdr2paramDirtyFlag;
    }

    public void resetSysUserDR2Param() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysUserDR2Param();
            return;
        }
        this.sysuserdr2paramDirtyFlag = false;
        this.sysuserdr2param = null;
    }

    public void setSysUserDRParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysUserDRParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sysuserdrparam = string;
        this.sysuserdrparamDirtyFlag = true;
    }

    public String getSysUserDRParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysUserDRParam();
        }
        return this.sysuserdrparam;
    }

    public boolean isSysUserDRParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysUserDRParamDirty();
        }
        return this.sysuserdrparamDirtyFlag;
    }

    public void resetSysUserDRParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysUserDRParam();
            return;
        }
        this.sysuserdrparamDirtyFlag = false;
        this.sysuserdrparam = null;
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

    public void setUserRoleTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserRoleTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userroletag = string;
        this.userroletagDirtyFlag = true;
    }

    public String getUserRoleTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserRoleTag();
        }
        return this.userroletag;
    }

    public boolean isUserRoleTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserRoleTagDirty();
        }
        return this.userroletagDirtyFlag;
    }

    public void resetUserRoleTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserRoleTag();
            return;
        }
        this.userroletagDirtyFlag = false;
        this.userroletag = null;
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
        PSDEUserRoleBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEUserRoleBase pSDEUserRoleBase) {
        pSDEUserRoleBase.resetAllDataFlag();
        pSDEUserRoleBase.resetCreateDate();
        pSDEUserRoleBase.resetCreateMan();
        pSDEUserRoleBase.resetCustomCond();
        pSDEUserRoleBase.resetCustomType();
        pSDEUserRoleBase.resetDefaultFlag();
        pSDEUserRoleBase.resetEnableOrgDR();
        pSDEUserRoleBase.resetEnableSecBC();
        pSDEUserRoleBase.resetEnableSecDR();
        pSDEUserRoleBase.resetEnableUserDR();
        pSDEUserRoleBase.resetLockFlag();
        pSDEUserRoleBase.resetMemo();
        pSDEUserRoleBase.resetOrgDR();
        pSDEUserRoleBase.resetPSDEDSId();
        pSDEUserRoleBase.resetPSDEDSName();
        pSDEUserRoleBase.resetPSDEFGroupId();
        pSDEUserRoleBase.resetPSDEFGroupName();
        pSDEUserRoleBase.resetPSDEId();
        pSDEUserRoleBase.resetPSDEName();
        pSDEUserRoleBase.resetPSDEUserRoleId();
        pSDEUserRoleBase.resetPSDEUserRoleName();
        pSDEUserRoleBase.resetPSSysSFPluginId();
        pSDEUserRoleBase.resetPSSysSFPluginName();
        pSDEUserRoleBase.resetPSSysUserDRId();
        pSDEUserRoleBase.resetPSSysUserDRId2();
        pSDEUserRoleBase.resetPSSysUserDRName();
        pSDEUserRoleBase.resetPSSysUserDRName2();
        pSDEUserRoleBase.resetSecBC();
        pSDEUserRoleBase.resetSecDR();
        pSDEUserRoleBase.resetSystemFlag();
        pSDEUserRoleBase.resetSysUserDR2Param();
        pSDEUserRoleBase.resetSysUserDRParam();
        pSDEUserRoleBase.resetUpdateDate();
        pSDEUserRoleBase.resetUpdateMan();
        pSDEUserRoleBase.resetUserCat();
        pSDEUserRoleBase.resetUserRoleTag();
        pSDEUserRoleBase.resetUserTag();
        pSDEUserRoleBase.resetUserTag2();
        pSDEUserRoleBase.resetUserTag3();
        pSDEUserRoleBase.resetUserTag4();
        pSDEUserRoleBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAllDataFlagDirty()) {
            hashMap.put(FIELD_ALLDATAFLAG, this.getAllDataFlag());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCustomCondDirty()) {
            hashMap.put(FIELD_CUSTOMCOND, this.getCustomCond());
        }
        if (!bl || this.isCustomTypeDirty()) {
            hashMap.put(FIELD_CUSTOMTYPE, this.getCustomType());
        }
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
        }
        if (!bl || this.isEnableOrgDRDirty()) {
            hashMap.put(FIELD_ENABLEORGDR, this.getEnableOrgDR());
        }
        if (!bl || this.isEnableSecBCDirty()) {
            hashMap.put(FIELD_ENABLESECBC, this.getEnableSecBC());
        }
        if (!bl || this.isEnableSecDRDirty()) {
            hashMap.put(FIELD_ENABLESECDR, this.getEnableSecDR());
        }
        if (!bl || this.isEnableUserDRDirty()) {
            hashMap.put(FIELD_ENABLEUSERDR, this.getEnableUserDR());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrgDRDirty()) {
            hashMap.put(FIELD_ORGDR, this.getOrgDR());
        }
        if (!bl || this.isPSDEDSIdDirty()) {
            hashMap.put(FIELD_PSDEDSID, this.getPSDEDSId());
        }
        if (!bl || this.isPSDEDSNameDirty()) {
            hashMap.put(FIELD_PSDEDSNAME, this.getPSDEDSName());
        }
        if (!bl || this.isPSDEFGroupIdDirty()) {
            hashMap.put(FIELD_PSDEFGROUPID, this.getPSDEFGroupId());
        }
        if (!bl || this.isPSDEFGroupNameDirty()) {
            hashMap.put(FIELD_PSDEFGROUPNAME, this.getPSDEFGroupName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDEUserRoleIdDirty()) {
            hashMap.put(FIELD_PSDEUSERROLEID, this.getPSDEUserRoleId());
        }
        if (!bl || this.isPSDEUserRoleNameDirty()) {
            hashMap.put(FIELD_PSDEUSERROLENAME, this.getPSDEUserRoleName());
        }
        if (!bl || this.isPSSysSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINID, this.getPSSysSFPluginId());
        }
        if (!bl || this.isPSSysSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINNAME, this.getPSSysSFPluginName());
        }
        if (!bl || this.isPSSysUserDRIdDirty()) {
            hashMap.put(FIELD_PSSYSUSERDRID, this.getPSSysUserDRId());
        }
        if (!bl || this.isPSSysUserDRId2Dirty()) {
            hashMap.put(FIELD_PSSYSUSERDRID2, this.getPSSysUserDRId2());
        }
        if (!bl || this.isPSSysUserDRNameDirty()) {
            hashMap.put(FIELD_PSSYSUSERDRNAME, this.getPSSysUserDRName());
        }
        if (!bl || this.isPSSysUserDRName2Dirty()) {
            hashMap.put(FIELD_PSSYSUSERDRNAME2, this.getPSSysUserDRName2());
        }
        if (!bl || this.isSecBCDirty()) {
            hashMap.put(FIELD_SECBC, this.getSecBC());
        }
        if (!bl || this.isSecDRDirty()) {
            hashMap.put(FIELD_SECDR, this.getSecDR());
        }
        if (!bl || this.isSystemFlagDirty()) {
            hashMap.put(FIELD_SYSTEMFLAG, this.getSystemFlag());
        }
        if (!bl || this.isSysUserDR2ParamDirty()) {
            hashMap.put(FIELD_SYSUSERDR2PARAM, this.getSysUserDR2Param());
        }
        if (!bl || this.isSysUserDRParamDirty()) {
            hashMap.put(FIELD_SYSUSERDRPARAM, this.getSysUserDRParam());
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
        if (!bl || this.isUserRoleTagDirty()) {
            hashMap.put(FIELD_USERROLETAG, this.getUserRoleTag());
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
        return PSDEUserRoleBase.get(this, n);
    }

    private static Object get(PSDEUserRoleBase pSDEUserRoleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEUserRoleBase.getAllDataFlag();
            }
            case 1: {
                return pSDEUserRoleBase.getCreateDate();
            }
            case 2: {
                return pSDEUserRoleBase.getCreateMan();
            }
            case 3: {
                return pSDEUserRoleBase.getCustomCond();
            }
            case 4: {
                return pSDEUserRoleBase.getCustomType();
            }
            case 5: {
                return pSDEUserRoleBase.getDefaultFlag();
            }
            case 6: {
                return pSDEUserRoleBase.getEnableOrgDR();
            }
            case 7: {
                return pSDEUserRoleBase.getEnableSecBC();
            }
            case 8: {
                return pSDEUserRoleBase.getEnableSecDR();
            }
            case 9: {
                return pSDEUserRoleBase.getEnableUserDR();
            }
            case 10: {
                return pSDEUserRoleBase.getLockFlag();
            }
            case 11: {
                return pSDEUserRoleBase.getMemo();
            }
            case 12: {
                return pSDEUserRoleBase.getOrgDR();
            }
            case 13: {
                return pSDEUserRoleBase.getPSDEDSId();
            }
            case 14: {
                return pSDEUserRoleBase.getPSDEDSName();
            }
            case 15: {
                return pSDEUserRoleBase.getPSDEFGroupId();
            }
            case 16: {
                return pSDEUserRoleBase.getPSDEFGroupName();
            }
            case 17: {
                return pSDEUserRoleBase.getPSDEId();
            }
            case 18: {
                return pSDEUserRoleBase.getPSDEName();
            }
            case 19: {
                return pSDEUserRoleBase.getPSDEUserRoleId();
            }
            case 20: {
                return pSDEUserRoleBase.getPSDEUserRoleName();
            }
            case 21: {
                return pSDEUserRoleBase.getPSSysSFPluginId();
            }
            case 22: {
                return pSDEUserRoleBase.getPSSysSFPluginName();
            }
            case 23: {
                return pSDEUserRoleBase.getPSSysUserDRId();
            }
            case 24: {
                return pSDEUserRoleBase.getPSSysUserDRId2();
            }
            case 25: {
                return pSDEUserRoleBase.getPSSysUserDRName();
            }
            case 26: {
                return pSDEUserRoleBase.getPSSysUserDRName2();
            }
            case 27: {
                return pSDEUserRoleBase.getSecBC();
            }
            case 28: {
                return pSDEUserRoleBase.getSecDR();
            }
            case 29: {
                return pSDEUserRoleBase.getSystemFlag();
            }
            case 30: {
                return pSDEUserRoleBase.getSysUserDR2Param();
            }
            case 31: {
                return pSDEUserRoleBase.getSysUserDRParam();
            }
            case 32: {
                return pSDEUserRoleBase.getUpdateDate();
            }
            case 33: {
                return pSDEUserRoleBase.getUpdateMan();
            }
            case 34: {
                return pSDEUserRoleBase.getUserCat();
            }
            case 35: {
                return pSDEUserRoleBase.getUserRoleTag();
            }
            case 36: {
                return pSDEUserRoleBase.getUserTag();
            }
            case 37: {
                return pSDEUserRoleBase.getUserTag2();
            }
            case 38: {
                return pSDEUserRoleBase.getUserTag3();
            }
            case 39: {
                return pSDEUserRoleBase.getUserTag4();
            }
            case 40: {
                return pSDEUserRoleBase.getValidFlag();
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
        PSDEUserRoleBase.set(this, n, object);
    }

    private static void set(PSDEUserRoleBase pSDEUserRoleBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEUserRoleBase.setAllDataFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDEUserRoleBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDEUserRoleBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEUserRoleBase.setCustomCond(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEUserRoleBase.setCustomType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEUserRoleBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDEUserRoleBase.setEnableOrgDR(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDEUserRoleBase.setEnableSecBC(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDEUserRoleBase.setEnableSecDR(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDEUserRoleBase.setEnableUserDR(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSDEUserRoleBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSDEUserRoleBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEUserRoleBase.setOrgDR(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDEUserRoleBase.setPSDEDSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEUserRoleBase.setPSDEDSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEUserRoleBase.setPSDEFGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEUserRoleBase.setPSDEFGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEUserRoleBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEUserRoleBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEUserRoleBase.setPSDEUserRoleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEUserRoleBase.setPSDEUserRoleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEUserRoleBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEUserRoleBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEUserRoleBase.setPSSysUserDRId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEUserRoleBase.setPSSysUserDRId2(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEUserRoleBase.setPSSysUserDRName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEUserRoleBase.setPSSysUserDRName2(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEUserRoleBase.setSecBC(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEUserRoleBase.setSecDR(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 29: {
                pSDEUserRoleBase.setSystemFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 30: {
                pSDEUserRoleBase.setSysUserDR2Param(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEUserRoleBase.setSysUserDRParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEUserRoleBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 33: {
                pSDEUserRoleBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEUserRoleBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEUserRoleBase.setUserRoleTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEUserRoleBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEUserRoleBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEUserRoleBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDEUserRoleBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDEUserRoleBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEUserRoleBase.isNull(this, n);
    }

    private static boolean isNull(PSDEUserRoleBase pSDEUserRoleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEUserRoleBase.getAllDataFlag() == null;
            }
            case 1: {
                return pSDEUserRoleBase.getCreateDate() == null;
            }
            case 2: {
                return pSDEUserRoleBase.getCreateMan() == null;
            }
            case 3: {
                return pSDEUserRoleBase.getCustomCond() == null;
            }
            case 4: {
                return pSDEUserRoleBase.getCustomType() == null;
            }
            case 5: {
                return pSDEUserRoleBase.getDefaultFlag() == null;
            }
            case 6: {
                return pSDEUserRoleBase.getEnableOrgDR() == null;
            }
            case 7: {
                return pSDEUserRoleBase.getEnableSecBC() == null;
            }
            case 8: {
                return pSDEUserRoleBase.getEnableSecDR() == null;
            }
            case 9: {
                return pSDEUserRoleBase.getEnableUserDR() == null;
            }
            case 10: {
                return pSDEUserRoleBase.getLockFlag() == null;
            }
            case 11: {
                return pSDEUserRoleBase.getMemo() == null;
            }
            case 12: {
                return pSDEUserRoleBase.getOrgDR() == null;
            }
            case 13: {
                return pSDEUserRoleBase.getPSDEDSId() == null;
            }
            case 14: {
                return pSDEUserRoleBase.getPSDEDSName() == null;
            }
            case 15: {
                return pSDEUserRoleBase.getPSDEFGroupId() == null;
            }
            case 16: {
                return pSDEUserRoleBase.getPSDEFGroupName() == null;
            }
            case 17: {
                return pSDEUserRoleBase.getPSDEId() == null;
            }
            case 18: {
                return pSDEUserRoleBase.getPSDEName() == null;
            }
            case 19: {
                return pSDEUserRoleBase.getPSDEUserRoleId() == null;
            }
            case 20: {
                return pSDEUserRoleBase.getPSDEUserRoleName() == null;
            }
            case 21: {
                return pSDEUserRoleBase.getPSSysSFPluginId() == null;
            }
            case 22: {
                return pSDEUserRoleBase.getPSSysSFPluginName() == null;
            }
            case 23: {
                return pSDEUserRoleBase.getPSSysUserDRId() == null;
            }
            case 24: {
                return pSDEUserRoleBase.getPSSysUserDRId2() == null;
            }
            case 25: {
                return pSDEUserRoleBase.getPSSysUserDRName() == null;
            }
            case 26: {
                return pSDEUserRoleBase.getPSSysUserDRName2() == null;
            }
            case 27: {
                return pSDEUserRoleBase.getSecBC() == null;
            }
            case 28: {
                return pSDEUserRoleBase.getSecDR() == null;
            }
            case 29: {
                return pSDEUserRoleBase.getSystemFlag() == null;
            }
            case 30: {
                return pSDEUserRoleBase.getSysUserDR2Param() == null;
            }
            case 31: {
                return pSDEUserRoleBase.getSysUserDRParam() == null;
            }
            case 32: {
                return pSDEUserRoleBase.getUpdateDate() == null;
            }
            case 33: {
                return pSDEUserRoleBase.getUpdateMan() == null;
            }
            case 34: {
                return pSDEUserRoleBase.getUserCat() == null;
            }
            case 35: {
                return pSDEUserRoleBase.getUserRoleTag() == null;
            }
            case 36: {
                return pSDEUserRoleBase.getUserTag() == null;
            }
            case 37: {
                return pSDEUserRoleBase.getUserTag2() == null;
            }
            case 38: {
                return pSDEUserRoleBase.getUserTag3() == null;
            }
            case 39: {
                return pSDEUserRoleBase.getUserTag4() == null;
            }
            case 40: {
                return pSDEUserRoleBase.getValidFlag() == null;
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
        return PSDEUserRoleBase.contains(this, n);
    }

    private static boolean contains(PSDEUserRoleBase pSDEUserRoleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEUserRoleBase.isAllDataFlagDirty();
            }
            case 1: {
                return pSDEUserRoleBase.isCreateDateDirty();
            }
            case 2: {
                return pSDEUserRoleBase.isCreateManDirty();
            }
            case 3: {
                return pSDEUserRoleBase.isCustomCondDirty();
            }
            case 4: {
                return pSDEUserRoleBase.isCustomTypeDirty();
            }
            case 5: {
                return pSDEUserRoleBase.isDefaultFlagDirty();
            }
            case 6: {
                return pSDEUserRoleBase.isEnableOrgDRDirty();
            }
            case 7: {
                return pSDEUserRoleBase.isEnableSecBCDirty();
            }
            case 8: {
                return pSDEUserRoleBase.isEnableSecDRDirty();
            }
            case 9: {
                return pSDEUserRoleBase.isEnableUserDRDirty();
            }
            case 10: {
                return pSDEUserRoleBase.isLockFlagDirty();
            }
            case 11: {
                return pSDEUserRoleBase.isMemoDirty();
            }
            case 12: {
                return pSDEUserRoleBase.isOrgDRDirty();
            }
            case 13: {
                return pSDEUserRoleBase.isPSDEDSIdDirty();
            }
            case 14: {
                return pSDEUserRoleBase.isPSDEDSNameDirty();
            }
            case 15: {
                return pSDEUserRoleBase.isPSDEFGroupIdDirty();
            }
            case 16: {
                return pSDEUserRoleBase.isPSDEFGroupNameDirty();
            }
            case 17: {
                return pSDEUserRoleBase.isPSDEIdDirty();
            }
            case 18: {
                return pSDEUserRoleBase.isPSDENameDirty();
            }
            case 19: {
                return pSDEUserRoleBase.isPSDEUserRoleIdDirty();
            }
            case 20: {
                return pSDEUserRoleBase.isPSDEUserRoleNameDirty();
            }
            case 21: {
                return pSDEUserRoleBase.isPSSysSFPluginIdDirty();
            }
            case 22: {
                return pSDEUserRoleBase.isPSSysSFPluginNameDirty();
            }
            case 23: {
                return pSDEUserRoleBase.isPSSysUserDRIdDirty();
            }
            case 24: {
                return pSDEUserRoleBase.isPSSysUserDRId2Dirty();
            }
            case 25: {
                return pSDEUserRoleBase.isPSSysUserDRNameDirty();
            }
            case 26: {
                return pSDEUserRoleBase.isPSSysUserDRName2Dirty();
            }
            case 27: {
                return pSDEUserRoleBase.isSecBCDirty();
            }
            case 28: {
                return pSDEUserRoleBase.isSecDRDirty();
            }
            case 29: {
                return pSDEUserRoleBase.isSystemFlagDirty();
            }
            case 30: {
                return pSDEUserRoleBase.isSysUserDR2ParamDirty();
            }
            case 31: {
                return pSDEUserRoleBase.isSysUserDRParamDirty();
            }
            case 32: {
                return pSDEUserRoleBase.isUpdateDateDirty();
            }
            case 33: {
                return pSDEUserRoleBase.isUpdateManDirty();
            }
            case 34: {
                return pSDEUserRoleBase.isUserCatDirty();
            }
            case 35: {
                return pSDEUserRoleBase.isUserRoleTagDirty();
            }
            case 36: {
                return pSDEUserRoleBase.isUserTagDirty();
            }
            case 37: {
                return pSDEUserRoleBase.isUserTag2Dirty();
            }
            case 38: {
                return pSDEUserRoleBase.isUserTag3Dirty();
            }
            case 39: {
                return pSDEUserRoleBase.isUserTag4Dirty();
            }
            case 40: {
                return pSDEUserRoleBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEUserRoleBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEUserRoleBase pSDEUserRoleBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEUserRoleBase.getAllDataFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"alldataflag", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getAllDataFlag()), (boolean)false);
        }
        if (bl || pSDEUserRoleBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEUserRoleBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEUserRoleBase.getCustomCond() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcond", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getCustomCond()), (boolean)false);
        }
        if (bl || pSDEUserRoleBase.getCustomType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customtype", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getCustomType()), (boolean)false);
        }
        if (bl || pSDEUserRoleBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSDEUserRoleBase.getEnableOrgDR() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableorgdr", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getEnableOrgDR()), (boolean)false);
        }
        if (bl || pSDEUserRoleBase.getEnableSecBC() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablesecbc", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getEnableSecBC()), (boolean)false);
        }
        if (bl || pSDEUserRoleBase.getEnableSecDR() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablesecdr", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getEnableSecDR()), (boolean)false);
        }
        if (bl || pSDEUserRoleBase.getEnableUserDR() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableuserdr", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getEnableUserDR()), (boolean)false);
        }
        if (bl || pSDEUserRoleBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDEUserRoleBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEUserRoleBase.getOrgDR() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"orgdr", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getOrgDR()), (boolean)false);
        }
        if (bl || pSDEUserRoleBase.getPSDEDSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsid", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getPSDEDSId()), (boolean)false);
        }
        if (bl || pSDEUserRoleBase.getPSDEDSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsname", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getPSDEDSName()), (boolean)false);
        }
        if (bl || pSDEUserRoleBase.getPSDEFGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefgroupid", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getPSDEFGroupId()), (boolean)false);
        }
        if (bl || pSDEUserRoleBase.getPSDEFGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefgroupname", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getPSDEFGroupName()), (boolean)false);
        }
        if (bl || pSDEUserRoleBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEUserRoleBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEUserRoleBase.getPSDEUserRoleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuserroleid", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getPSDEUserRoleId()), (boolean)false);
        }
        if (bl || pSDEUserRoleBase.getPSDEUserRoleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuserrolename", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getPSDEUserRoleName()), (boolean)false);
        }
        if (bl || pSDEUserRoleBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSDEUserRoleBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSDEUserRoleBase.getPSSysUserDRId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuserdrid", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getPSSysUserDRId()), (boolean)false);
        }
        if (bl || pSDEUserRoleBase.getPSSysUserDRId2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuserdrid2", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getPSSysUserDRId2()), (boolean)false);
        }
        if (bl || pSDEUserRoleBase.getPSSysUserDRName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuserdrname", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getPSSysUserDRName()), (boolean)false);
        }
        if (bl || pSDEUserRoleBase.getPSSysUserDRName2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuserdrname2", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getPSSysUserDRName2()), (boolean)false);
        }
        if (bl || pSDEUserRoleBase.getSecBC() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"secbc", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getSecBC()), (boolean)false);
        }
        if (bl || pSDEUserRoleBase.getSecDR() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"secdr", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getSecDR()), (boolean)false);
        }
        if (bl || pSDEUserRoleBase.getSystemFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"systemflag", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getSystemFlag()), (boolean)false);
        }
        if (bl || pSDEUserRoleBase.getSysUserDR2Param() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysuserdr2param", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getSysUserDR2Param()), (boolean)false);
        }
        if (bl || pSDEUserRoleBase.getSysUserDRParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysuserdrparam", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getSysUserDRParam()), (boolean)false);
        }
        if (bl || pSDEUserRoleBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEUserRoleBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEUserRoleBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEUserRoleBase.getUserRoleTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userroletag", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getUserRoleTag()), (boolean)false);
        }
        if (bl || pSDEUserRoleBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEUserRoleBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEUserRoleBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEUserRoleBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEUserRoleBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEUserRoleBase.getJSONValue((Object)pSDEUserRoleBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEUserRoleBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEUserRoleBase pSDEUserRoleBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEUserRoleBase.getAllDataFlag() != null) {
            object = pSDEUserRoleBase.getAllDataFlag();
            xmlNode.setAttribute(FIELD_ALLDATAFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUserRoleBase.getCreateDate() != null) {
            object = pSDEUserRoleBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEUserRoleBase.getCreateMan() != null) {
            object = pSDEUserRoleBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEUserRoleBase.getCustomCond() != null) {
            object = pSDEUserRoleBase.getCustomCond();
            xmlNode.setAttribute(FIELD_CUSTOMCOND, object == null ? "" : (String)object);
        }
        if (bl || pSDEUserRoleBase.getCustomType() != null) {
            object = pSDEUserRoleBase.getCustomType();
            xmlNode.setAttribute(FIELD_CUSTOMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEUserRoleBase.getDefaultFlag() != null) {
            object = pSDEUserRoleBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUserRoleBase.getEnableOrgDR() != null) {
            object = pSDEUserRoleBase.getEnableOrgDR();
            xmlNode.setAttribute(FIELD_ENABLEORGDR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUserRoleBase.getEnableSecBC() != null) {
            object = pSDEUserRoleBase.getEnableSecBC();
            xmlNode.setAttribute(FIELD_ENABLESECBC, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUserRoleBase.getEnableSecDR() != null) {
            object = pSDEUserRoleBase.getEnableSecDR();
            xmlNode.setAttribute(FIELD_ENABLESECDR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUserRoleBase.getEnableUserDR() != null) {
            object = pSDEUserRoleBase.getEnableUserDR();
            xmlNode.setAttribute(FIELD_ENABLEUSERDR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUserRoleBase.getLockFlag() != null) {
            object = pSDEUserRoleBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUserRoleBase.getMemo() != null) {
            object = pSDEUserRoleBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEUserRoleBase.getOrgDR() != null) {
            object = pSDEUserRoleBase.getOrgDR();
            xmlNode.setAttribute(FIELD_ORGDR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUserRoleBase.getPSDEDSId() != null) {
            object = pSDEUserRoleBase.getPSDEDSId();
            xmlNode.setAttribute(FIELD_PSDEDSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUserRoleBase.getPSDEDSName() != null) {
            object = pSDEUserRoleBase.getPSDEDSName();
            xmlNode.setAttribute(FIELD_PSDEDSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUserRoleBase.getPSDEFGroupId() != null) {
            object = pSDEUserRoleBase.getPSDEFGroupId();
            xmlNode.setAttribute(FIELD_PSDEFGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUserRoleBase.getPSDEFGroupName() != null) {
            object = pSDEUserRoleBase.getPSDEFGroupName();
            xmlNode.setAttribute(FIELD_PSDEFGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUserRoleBase.getPSDEId() != null) {
            object = pSDEUserRoleBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUserRoleBase.getPSDEName() != null) {
            object = pSDEUserRoleBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUserRoleBase.getPSDEUserRoleId() != null) {
            object = pSDEUserRoleBase.getPSDEUserRoleId();
            xmlNode.setAttribute(FIELD_PSDEUSERROLEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUserRoleBase.getPSDEUserRoleName() != null) {
            object = pSDEUserRoleBase.getPSDEUserRoleName();
            xmlNode.setAttribute(FIELD_PSDEUSERROLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUserRoleBase.getPSSysSFPluginId() != null) {
            object = pSDEUserRoleBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUserRoleBase.getPSSysSFPluginName() != null) {
            object = pSDEUserRoleBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUserRoleBase.getPSSysUserDRId() != null) {
            object = pSDEUserRoleBase.getPSSysUserDRId();
            xmlNode.setAttribute(FIELD_PSSYSUSERDRID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUserRoleBase.getPSSysUserDRId2() != null) {
            object = pSDEUserRoleBase.getPSSysUserDRId2();
            xmlNode.setAttribute(FIELD_PSSYSUSERDRID2, object == null ? "" : (String)object);
        }
        if (bl || pSDEUserRoleBase.getPSSysUserDRName() != null) {
            object = pSDEUserRoleBase.getPSSysUserDRName();
            xmlNode.setAttribute(FIELD_PSSYSUSERDRNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUserRoleBase.getPSSysUserDRName2() != null) {
            object = pSDEUserRoleBase.getPSSysUserDRName2();
            xmlNode.setAttribute(FIELD_PSSYSUSERDRNAME2, object == null ? "" : (String)object);
        }
        if (bl || pSDEUserRoleBase.getSecBC() != null) {
            object = pSDEUserRoleBase.getSecBC();
            xmlNode.setAttribute(FIELD_SECBC, object == null ? "" : (String)object);
        }
        if (bl || pSDEUserRoleBase.getSecDR() != null) {
            object = pSDEUserRoleBase.getSecDR();
            xmlNode.setAttribute(FIELD_SECDR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUserRoleBase.getSystemFlag() != null) {
            object = pSDEUserRoleBase.getSystemFlag();
            xmlNode.setAttribute(FIELD_SYSTEMFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUserRoleBase.getSysUserDR2Param() != null) {
            object = pSDEUserRoleBase.getSysUserDR2Param();
            xmlNode.setAttribute(FIELD_SYSUSERDR2PARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDEUserRoleBase.getSysUserDRParam() != null) {
            object = pSDEUserRoleBase.getSysUserDRParam();
            xmlNode.setAttribute(FIELD_SYSUSERDRPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDEUserRoleBase.getUpdateDate() != null) {
            object = pSDEUserRoleBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEUserRoleBase.getUpdateMan() != null) {
            object = pSDEUserRoleBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEUserRoleBase.getUserCat() != null) {
            object = pSDEUserRoleBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEUserRoleBase.getUserRoleTag() != null) {
            object = pSDEUserRoleBase.getUserRoleTag();
            xmlNode.setAttribute(FIELD_USERROLETAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEUserRoleBase.getUserTag() != null) {
            object = pSDEUserRoleBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEUserRoleBase.getUserTag2() != null) {
            object = pSDEUserRoleBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEUserRoleBase.getUserTag3() != null) {
            object = pSDEUserRoleBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEUserRoleBase.getUserTag4() != null) {
            object = pSDEUserRoleBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEUserRoleBase.getValidFlag() != null) {
            object = pSDEUserRoleBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEUserRoleBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEUserRoleBase pSDEUserRoleBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEUserRoleBase.isAllDataFlagDirty() && (bl || pSDEUserRoleBase.getAllDataFlag() != null)) {
            iDataObject.set(FIELD_ALLDATAFLAG, (Object)pSDEUserRoleBase.getAllDataFlag());
        }
        if (pSDEUserRoleBase.isCreateDateDirty() && (bl || pSDEUserRoleBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEUserRoleBase.getCreateDate());
        }
        if (pSDEUserRoleBase.isCreateManDirty() && (bl || pSDEUserRoleBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEUserRoleBase.getCreateMan());
        }
        if (pSDEUserRoleBase.isCustomCondDirty() && (bl || pSDEUserRoleBase.getCustomCond() != null)) {
            iDataObject.set(FIELD_CUSTOMCOND, (Object)pSDEUserRoleBase.getCustomCond());
        }
        if (pSDEUserRoleBase.isCustomTypeDirty() && (bl || pSDEUserRoleBase.getCustomType() != null)) {
            iDataObject.set(FIELD_CUSTOMTYPE, (Object)pSDEUserRoleBase.getCustomType());
        }
        if (pSDEUserRoleBase.isDefaultFlagDirty() && (bl || pSDEUserRoleBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSDEUserRoleBase.getDefaultFlag());
        }
        if (pSDEUserRoleBase.isEnableOrgDRDirty() && (bl || pSDEUserRoleBase.getEnableOrgDR() != null)) {
            iDataObject.set(FIELD_ENABLEORGDR, (Object)pSDEUserRoleBase.getEnableOrgDR());
        }
        if (pSDEUserRoleBase.isEnableSecBCDirty() && (bl || pSDEUserRoleBase.getEnableSecBC() != null)) {
            iDataObject.set(FIELD_ENABLESECBC, (Object)pSDEUserRoleBase.getEnableSecBC());
        }
        if (pSDEUserRoleBase.isEnableSecDRDirty() && (bl || pSDEUserRoleBase.getEnableSecDR() != null)) {
            iDataObject.set(FIELD_ENABLESECDR, (Object)pSDEUserRoleBase.getEnableSecDR());
        }
        if (pSDEUserRoleBase.isEnableUserDRDirty() && (bl || pSDEUserRoleBase.getEnableUserDR() != null)) {
            iDataObject.set(FIELD_ENABLEUSERDR, (Object)pSDEUserRoleBase.getEnableUserDR());
        }
        if (pSDEUserRoleBase.isLockFlagDirty() && (bl || pSDEUserRoleBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDEUserRoleBase.getLockFlag());
        }
        if (pSDEUserRoleBase.isMemoDirty() && (bl || pSDEUserRoleBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEUserRoleBase.getMemo());
        }
        if (pSDEUserRoleBase.isOrgDRDirty() && (bl || pSDEUserRoleBase.getOrgDR() != null)) {
            iDataObject.set(FIELD_ORGDR, (Object)pSDEUserRoleBase.getOrgDR());
        }
        if (pSDEUserRoleBase.isPSDEDSIdDirty() && (bl || pSDEUserRoleBase.getPSDEDSId() != null)) {
            iDataObject.set(FIELD_PSDEDSID, (Object)pSDEUserRoleBase.getPSDEDSId());
        }
        if (pSDEUserRoleBase.isPSDEDSNameDirty() && (bl || pSDEUserRoleBase.getPSDEDSName() != null)) {
            iDataObject.set(FIELD_PSDEDSNAME, (Object)pSDEUserRoleBase.getPSDEDSName());
        }
        if (pSDEUserRoleBase.isPSDEFGroupIdDirty() && (bl || pSDEUserRoleBase.getPSDEFGroupId() != null)) {
            iDataObject.set(FIELD_PSDEFGROUPID, (Object)pSDEUserRoleBase.getPSDEFGroupId());
        }
        if (pSDEUserRoleBase.isPSDEFGroupNameDirty() && (bl || pSDEUserRoleBase.getPSDEFGroupName() != null)) {
            iDataObject.set(FIELD_PSDEFGROUPNAME, (Object)pSDEUserRoleBase.getPSDEFGroupName());
        }
        if (pSDEUserRoleBase.isPSDEIdDirty() && (bl || pSDEUserRoleBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEUserRoleBase.getPSDEId());
        }
        if (pSDEUserRoleBase.isPSDENameDirty() && (bl || pSDEUserRoleBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEUserRoleBase.getPSDEName());
        }
        if (pSDEUserRoleBase.isPSDEUserRoleIdDirty() && (bl || pSDEUserRoleBase.getPSDEUserRoleId() != null)) {
            iDataObject.set(FIELD_PSDEUSERROLEID, (Object)pSDEUserRoleBase.getPSDEUserRoleId());
        }
        if (pSDEUserRoleBase.isPSDEUserRoleNameDirty() && (bl || pSDEUserRoleBase.getPSDEUserRoleName() != null)) {
            iDataObject.set(FIELD_PSDEUSERROLENAME, (Object)pSDEUserRoleBase.getPSDEUserRoleName());
        }
        if (pSDEUserRoleBase.isPSSysSFPluginIdDirty() && (bl || pSDEUserRoleBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSDEUserRoleBase.getPSSysSFPluginId());
        }
        if (pSDEUserRoleBase.isPSSysSFPluginNameDirty() && (bl || pSDEUserRoleBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSDEUserRoleBase.getPSSysSFPluginName());
        }
        if (pSDEUserRoleBase.isPSSysUserDRIdDirty() && (bl || pSDEUserRoleBase.getPSSysUserDRId() != null)) {
            iDataObject.set(FIELD_PSSYSUSERDRID, (Object)pSDEUserRoleBase.getPSSysUserDRId());
        }
        if (pSDEUserRoleBase.isPSSysUserDRId2Dirty() && (bl || pSDEUserRoleBase.getPSSysUserDRId2() != null)) {
            iDataObject.set(FIELD_PSSYSUSERDRID2, (Object)pSDEUserRoleBase.getPSSysUserDRId2());
        }
        if (pSDEUserRoleBase.isPSSysUserDRNameDirty() && (bl || pSDEUserRoleBase.getPSSysUserDRName() != null)) {
            iDataObject.set(FIELD_PSSYSUSERDRNAME, (Object)pSDEUserRoleBase.getPSSysUserDRName());
        }
        if (pSDEUserRoleBase.isPSSysUserDRName2Dirty() && (bl || pSDEUserRoleBase.getPSSysUserDRName2() != null)) {
            iDataObject.set(FIELD_PSSYSUSERDRNAME2, (Object)pSDEUserRoleBase.getPSSysUserDRName2());
        }
        if (pSDEUserRoleBase.isSecBCDirty() && (bl || pSDEUserRoleBase.getSecBC() != null)) {
            iDataObject.set(FIELD_SECBC, (Object)pSDEUserRoleBase.getSecBC());
        }
        if (pSDEUserRoleBase.isSecDRDirty() && (bl || pSDEUserRoleBase.getSecDR() != null)) {
            iDataObject.set(FIELD_SECDR, (Object)pSDEUserRoleBase.getSecDR());
        }
        if (pSDEUserRoleBase.isSystemFlagDirty() && (bl || pSDEUserRoleBase.getSystemFlag() != null)) {
            iDataObject.set(FIELD_SYSTEMFLAG, (Object)pSDEUserRoleBase.getSystemFlag());
        }
        if (pSDEUserRoleBase.isSysUserDR2ParamDirty() && (bl || pSDEUserRoleBase.getSysUserDR2Param() != null)) {
            iDataObject.set(FIELD_SYSUSERDR2PARAM, (Object)pSDEUserRoleBase.getSysUserDR2Param());
        }
        if (pSDEUserRoleBase.isSysUserDRParamDirty() && (bl || pSDEUserRoleBase.getSysUserDRParam() != null)) {
            iDataObject.set(FIELD_SYSUSERDRPARAM, (Object)pSDEUserRoleBase.getSysUserDRParam());
        }
        if (pSDEUserRoleBase.isUpdateDateDirty() && (bl || pSDEUserRoleBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEUserRoleBase.getUpdateDate());
        }
        if (pSDEUserRoleBase.isUpdateManDirty() && (bl || pSDEUserRoleBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEUserRoleBase.getUpdateMan());
        }
        if (pSDEUserRoleBase.isUserCatDirty() && (bl || pSDEUserRoleBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEUserRoleBase.getUserCat());
        }
        if (pSDEUserRoleBase.isUserRoleTagDirty() && (bl || pSDEUserRoleBase.getUserRoleTag() != null)) {
            iDataObject.set(FIELD_USERROLETAG, (Object)pSDEUserRoleBase.getUserRoleTag());
        }
        if (pSDEUserRoleBase.isUserTagDirty() && (bl || pSDEUserRoleBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEUserRoleBase.getUserTag());
        }
        if (pSDEUserRoleBase.isUserTag2Dirty() && (bl || pSDEUserRoleBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEUserRoleBase.getUserTag2());
        }
        if (pSDEUserRoleBase.isUserTag3Dirty() && (bl || pSDEUserRoleBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEUserRoleBase.getUserTag3());
        }
        if (pSDEUserRoleBase.isUserTag4Dirty() && (bl || pSDEUserRoleBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEUserRoleBase.getUserTag4());
        }
        if (pSDEUserRoleBase.isValidFlagDirty() && (bl || pSDEUserRoleBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEUserRoleBase.getValidFlag());
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
        return PSDEUserRoleBase.remove(this, n);
    }

    private static boolean remove(PSDEUserRoleBase pSDEUserRoleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEUserRoleBase.resetAllDataFlag();
                return true;
            }
            case 1: {
                pSDEUserRoleBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDEUserRoleBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDEUserRoleBase.resetCustomCond();
                return true;
            }
            case 4: {
                pSDEUserRoleBase.resetCustomType();
                return true;
            }
            case 5: {
                pSDEUserRoleBase.resetDefaultFlag();
                return true;
            }
            case 6: {
                pSDEUserRoleBase.resetEnableOrgDR();
                return true;
            }
            case 7: {
                pSDEUserRoleBase.resetEnableSecBC();
                return true;
            }
            case 8: {
                pSDEUserRoleBase.resetEnableSecDR();
                return true;
            }
            case 9: {
                pSDEUserRoleBase.resetEnableUserDR();
                return true;
            }
            case 10: {
                pSDEUserRoleBase.resetLockFlag();
                return true;
            }
            case 11: {
                pSDEUserRoleBase.resetMemo();
                return true;
            }
            case 12: {
                pSDEUserRoleBase.resetOrgDR();
                return true;
            }
            case 13: {
                pSDEUserRoleBase.resetPSDEDSId();
                return true;
            }
            case 14: {
                pSDEUserRoleBase.resetPSDEDSName();
                return true;
            }
            case 15: {
                pSDEUserRoleBase.resetPSDEFGroupId();
                return true;
            }
            case 16: {
                pSDEUserRoleBase.resetPSDEFGroupName();
                return true;
            }
            case 17: {
                pSDEUserRoleBase.resetPSDEId();
                return true;
            }
            case 18: {
                pSDEUserRoleBase.resetPSDEName();
                return true;
            }
            case 19: {
                pSDEUserRoleBase.resetPSDEUserRoleId();
                return true;
            }
            case 20: {
                pSDEUserRoleBase.resetPSDEUserRoleName();
                return true;
            }
            case 21: {
                pSDEUserRoleBase.resetPSSysSFPluginId();
                return true;
            }
            case 22: {
                pSDEUserRoleBase.resetPSSysSFPluginName();
                return true;
            }
            case 23: {
                pSDEUserRoleBase.resetPSSysUserDRId();
                return true;
            }
            case 24: {
                pSDEUserRoleBase.resetPSSysUserDRId2();
                return true;
            }
            case 25: {
                pSDEUserRoleBase.resetPSSysUserDRName();
                return true;
            }
            case 26: {
                pSDEUserRoleBase.resetPSSysUserDRName2();
                return true;
            }
            case 27: {
                pSDEUserRoleBase.resetSecBC();
                return true;
            }
            case 28: {
                pSDEUserRoleBase.resetSecDR();
                return true;
            }
            case 29: {
                pSDEUserRoleBase.resetSystemFlag();
                return true;
            }
            case 30: {
                pSDEUserRoleBase.resetSysUserDR2Param();
                return true;
            }
            case 31: {
                pSDEUserRoleBase.resetSysUserDRParam();
                return true;
            }
            case 32: {
                pSDEUserRoleBase.resetUpdateDate();
                return true;
            }
            case 33: {
                pSDEUserRoleBase.resetUpdateMan();
                return true;
            }
            case 34: {
                pSDEUserRoleBase.resetUserCat();
                return true;
            }
            case 35: {
                pSDEUserRoleBase.resetUserRoleTag();
                return true;
            }
            case 36: {
                pSDEUserRoleBase.resetUserTag();
                return true;
            }
            case 37: {
                pSDEUserRoleBase.resetUserTag2();
                return true;
            }
            case 38: {
                pSDEUserRoleBase.resetUserTag3();
                return true;
            }
            case 39: {
                pSDEUserRoleBase.resetUserTag4();
                return true;
            }
            case 40: {
                pSDEUserRoleBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDE();
        }
        if (this.getPSDEId() == null) {
            return null;
        }
        Integer n = this.objPSDELock;
        synchronized (n) {
            if (this.psde != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEId(), (Object)this.psde.getPSDataEntityId()) != 0L) {
                this.psde = null;
            }
            if (this.psde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getPSDEDS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDS();
        }
        if (this.getPSDEDSId() == null) {
            return null;
        }
        Integer n = this.objPSDEDSLock;
        synchronized (n) {
            if (this.psdeds != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDSId(), (Object)this.psdeds.getPSDEDataSetId()) != 0L) {
                this.psdeds = null;
            }
            if (this.psdeds == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getPSDEDSId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet(pSDEDataSet);
                this.psdeds = pSDEDataSet;
            }
            return this.psdeds;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFGroup getPSDEFGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFGroup();
        }
        if (this.getPSDEFGroupId() == null) {
            return null;
        }
        Integer n = this.objPSDEFGroupLock;
        synchronized (n) {
            if (this.psdefgroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFGroupId(), (Object)this.psdefgroup.getPSDEFGroupId()) != 0L) {
                this.psdefgroup = null;
            }
            if (this.psdefgroup == null) {
                PSDEFGroup pSDEFGroup = new PSDEFGroup();
                pSDEFGroup.setPSDEFGroupId(this.getPSDEFGroupId());
                PSDEFGroupService pSDEFGroupService = (PSDEFGroupService)ServiceGlobal.getService(PSDEFGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEFGroupService.autoGet(pSDEFGroup);
                this.psdefgroup = pSDEFGroup;
            }
            return this.psdefgroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSFPlugin getPSSysSFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPlugin();
        }
        if (this.getPSSysSFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysSFPluginLock;
        synchronized (n) {
            if (this.pssyssfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSFPluginId(), (Object)this.pssyssfplugin.getPSSysSFPluginId()) != 0L) {
                this.pssyssfplugin = null;
            }
            if (this.pssyssfplugin == null) {
                PSSysSFPlugin pSSysSFPlugin = new PSSysSFPlugin();
                pSSysSFPlugin.setPSSysSFPluginId(this.getPSSysSFPluginId());
                PSSysSFPluginService pSSysSFPluginService = (PSSysSFPluginService)ServiceGlobal.getService(PSSysSFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysSFPluginService.autoGet(pSSysSFPlugin);
                this.pssyssfplugin = pSSysSFPlugin;
            }
            return this.pssyssfplugin;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysUserDR getPSSysUserDR() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserDR();
        }
        if (this.getPSSysUserDRId() == null) {
            return null;
        }
        Integer n = this.objPSSysUserDRLock;
        synchronized (n) {
            if (this.pssysuserdr != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysUserDRId(), (Object)this.pssysuserdr.getPSSysUserDRId()) != 0L) {
                this.pssysuserdr = null;
            }
            if (this.pssysuserdr == null) {
                PSSysUserDR pSSysUserDR = new PSSysUserDR();
                pSSysUserDR.setPSSysUserDRId(this.getPSSysUserDRId());
                PSSysUserDRService pSSysUserDRService = (PSSysUserDRService)ServiceGlobal.getService(PSSysUserDRService.class, (SessionFactory)this.getSessionFactory());
                pSSysUserDRService.autoGet(pSSysUserDR);
                this.pssysuserdr = pSSysUserDR;
            }
            return this.pssysuserdr;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysUserDR getPSSysUserDR2() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserDR2();
        }
        if (this.getPSSysUserDRId2() == null) {
            return null;
        }
        Integer n = this.objPSSysUserDR2Lock;
        synchronized (n) {
            if (this.pssysuserdr2 != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysUserDRId2(), (Object)this.pssysuserdr2.getPSSysUserDRId()) != 0L) {
                this.pssysuserdr2 = null;
            }
            if (this.pssysuserdr2 == null) {
                PSSysUserDR pSSysUserDR = new PSSysUserDR();
                pSSysUserDR.setPSSysUserDRId(this.getPSSysUserDRId2());
                PSSysUserDRService pSSysUserDRService = (PSSysUserDRService)ServiceGlobal.getService(PSSysUserDRService.class, (SessionFactory)this.getSessionFactory());
                pSSysUserDRService.autoGet(pSSysUserDR);
                this.pssysuserdr2 = pSSysUserDR;
            }
            return this.pssysuserdr2;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEOPPrivRole> getPSDEOPPrivRoles() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEOPPrivRoles();
        }
        if (this.getPSDEUserRoleId() == null) {
            return null;
        }
        PSDEOPPrivRoleService pSDEOPPrivRoleService = (PSDEOPPrivRoleService)ServiceGlobal.getService(PSDEOPPrivRoleService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEOPPrivRolesLock;
        synchronized (n) {
            if (this.psdeopprivroles == null) {
                this.psdeopprivroles = pSDEOPPrivRoleService.selectByPSDEUserRole(this);
            }
            return this.psdeopprivroles;
        }
    }

    private PSDEUserRoleBase getProxyEntity() {
        return this.proxyPSDEUserRoleBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEUserRoleBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEUserRoleBase) {
            this.proxyPSDEUserRoleBase = (PSDEUserRoleBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUserRoleService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLDATAFLAG, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_CUSTOMCOND, 3);
        fieldIndexMap.put(FIELD_CUSTOMTYPE, 4);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 5);
        fieldIndexMap.put(FIELD_ENABLEORGDR, 6);
        fieldIndexMap.put(FIELD_ENABLESECBC, 7);
        fieldIndexMap.put(FIELD_ENABLESECDR, 8);
        fieldIndexMap.put(FIELD_ENABLEUSERDR, 9);
        fieldIndexMap.put(FIELD_LOCKFLAG, 10);
        fieldIndexMap.put(FIELD_MEMO, 11);
        fieldIndexMap.put(FIELD_ORGDR, 12);
        fieldIndexMap.put(FIELD_PSDEDSID, 13);
        fieldIndexMap.put(FIELD_PSDEDSNAME, 14);
        fieldIndexMap.put(FIELD_PSDEFGROUPID, 15);
        fieldIndexMap.put(FIELD_PSDEFGROUPNAME, 16);
        fieldIndexMap.put(FIELD_PSDEID, 17);
        fieldIndexMap.put(FIELD_PSDENAME, 18);
        fieldIndexMap.put(FIELD_PSDEUSERROLEID, 19);
        fieldIndexMap.put(FIELD_PSDEUSERROLENAME, 20);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 21);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 22);
        fieldIndexMap.put(FIELD_PSSYSUSERDRID, 23);
        fieldIndexMap.put(FIELD_PSSYSUSERDRID2, 24);
        fieldIndexMap.put(FIELD_PSSYSUSERDRNAME, 25);
        fieldIndexMap.put(FIELD_PSSYSUSERDRNAME2, 26);
        fieldIndexMap.put(FIELD_SECBC, 27);
        fieldIndexMap.put(FIELD_SECDR, 28);
        fieldIndexMap.put(FIELD_SYSTEMFLAG, 29);
        fieldIndexMap.put(FIELD_SYSUSERDR2PARAM, 30);
        fieldIndexMap.put(FIELD_SYSUSERDRPARAM, 31);
        fieldIndexMap.put(FIELD_UPDATEDATE, 32);
        fieldIndexMap.put(FIELD_UPDATEMAN, 33);
        fieldIndexMap.put(FIELD_USERCAT, 34);
        fieldIndexMap.put(FIELD_USERROLETAG, 35);
        fieldIndexMap.put(FIELD_USERTAG, 36);
        fieldIndexMap.put(FIELD_USERTAG2, 37);
        fieldIndexMap.put(FIELD_USERTAG3, 38);
        fieldIndexMap.put(FIELD_USERTAG4, 39);
        fieldIndexMap.put(FIELD_VALIDFLAG, 40);
    }
}

