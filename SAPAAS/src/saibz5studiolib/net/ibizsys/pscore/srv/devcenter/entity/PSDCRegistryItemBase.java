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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryRepo;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryRepoService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDeploy;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDeployService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCRegistryItemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCRegistryItemBase.class);
    public static final String FIELD_CONNSTR = "CONNSTR";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DOCKERFILE = "DOCKERFILE";
    public static final String FIELD_ITEMPARAMS = "ITEMPARAMS";
    public static final String FIELD_ITEMTAG = "ITEMTAG";
    public static final String FIELD_ITEMTAG2 = "ITEMTAG2";
    public static final String FIELD_ITEMTAG3 = "ITEMTAG3";
    public static final String FIELD_ITEMTAG4 = "ITEMTAG4";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCREGISTRYITEMID = "PSDCREGISTRYITEMID";
    public static final String FIELD_PSDCREGISTRYITEMNAME = "PSDCREGISTRYITEMNAME";
    public static final String FIELD_PSDCREGISTRYREPOID = "PSDCREGISTRYREPOID";
    public static final String FIELD_PSDCREGISTRYREPONAME = "PSDCREGISTRYREPONAME";
    public static final String FIELD_PSDEVCENTERSVNID = "PSDEVCENTERSVNID";
    public static final String FIELD_PSDEVCENTERSVNNAME = "PSDEVCENTERSVNNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNMSDEPLOYID = "PSDEVSLNMSDEPLOYID";
    public static final String FIELD_PSDEVSLNMSDEPLOYNAME = "PSDEVSLNMSDEPLOYNAME";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_RESSTATE = "RESSTATE";
    public static final String FIELD_TAGS = "TAGS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CONNSTR = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DOCKERFILE = 3;
    private static final int INDEX_ITEMPARAMS = 4;
    private static final int INDEX_ITEMTAG = 5;
    private static final int INDEX_ITEMTAG2 = 6;
    private static final int INDEX_ITEMTAG3 = 7;
    private static final int INDEX_ITEMTAG4 = 8;
    private static final int INDEX_LOGICNAME = 9;
    private static final int INDEX_MEMO = 10;
    private static final int INDEX_PSDCREGISTRYITEMID = 11;
    private static final int INDEX_PSDCREGISTRYITEMNAME = 12;
    private static final int INDEX_PSDCREGISTRYREPOID = 13;
    private static final int INDEX_PSDCREGISTRYREPONAME = 14;
    private static final int INDEX_PSDEVCENTERSVNID = 15;
    private static final int INDEX_PSDEVCENTERSVNNAME = 16;
    private static final int INDEX_PSDEVSLNID = 17;
    private static final int INDEX_PSDEVSLNMSDEPLOYID = 18;
    private static final int INDEX_PSDEVSLNMSDEPLOYNAME = 19;
    private static final int INDEX_PSDEVSLNNAME = 20;
    private static final int INDEX_PSDEVSLNSYSID = 21;
    private static final int INDEX_PSDEVSLNSYSNAME = 22;
    private static final int INDEX_RESSTATE = 23;
    private static final int INDEX_TAGS = 24;
    private static final int INDEX_UPDATEDATE = 25;
    private static final int INDEX_UPDATEMAN = 26;
    private static final int INDEX_USERCAT = 27;
    private static final int INDEX_USERTAG = 28;
    private static final int INDEX_USERTAG2 = 29;
    private static final int INDEX_USERTAG3 = 30;
    private static final int INDEX_USERTAG4 = 31;
    private static final int INDEX_VALIDFLAG = 32;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCRegistryItemBase proxyPSDCRegistryItemBase = null;
    private boolean connstrDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dockerfileDirtyFlag = false;
    private boolean itemparamsDirtyFlag = false;
    private boolean itemtagDirtyFlag = false;
    private boolean itemtag2DirtyFlag = false;
    private boolean itemtag3DirtyFlag = false;
    private boolean itemtag4DirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcregistryitemidDirtyFlag = false;
    private boolean psdcregistryitemnameDirtyFlag = false;
    private boolean psdcregistryrepoidDirtyFlag = false;
    private boolean psdcregistryreponameDirtyFlag = false;
    private boolean psdevcentersvnidDirtyFlag = false;
    private boolean psdevcentersvnnameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnmsdeployidDirtyFlag = false;
    private boolean psdevslnmsdeploynameDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean resstateDirtyFlag = false;
    private boolean tagsDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="connstr")
    private String connstr;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dockerfile")
    private String dockerfile;
    @Column(name="itemparams")
    private String itemparams;
    @Column(name="itemtag")
    private String itemtag;
    @Column(name="itemtag2")
    private String itemtag2;
    @Column(name="itemtag3")
    private String itemtag3;
    @Column(name="itemtag4")
    private String itemtag4;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="psdcregistryitemid")
    private String psdcregistryitemid;
    @Column(name="psdcregistryitemname")
    private String psdcregistryitemname;
    @Column(name="psdcregistryrepoid")
    private String psdcregistryrepoid;
    @Column(name="psdcregistryreponame")
    private String psdcregistryreponame;
    @Column(name="psdevcentersvnid")
    private String psdevcentersvnid;
    @Column(name="psdevcentersvnname")
    private String psdevcentersvnname;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnmsdeployid")
    private String psdevslnmsdeployid;
    @Column(name="psdevslnmsdeployname")
    private String psdevslnmsdeployname;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="resstate")
    private Integer resstate;
    @Column(name="tags")
    private String tags;
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
    private Integer objPSDCRegistryRepoLock = new Integer(1);
    private PSDCRegistryRepo psdcregistryrepo = null;
    private Integer objPSDevCenterSVNLock = new Integer(1);
    private PSDevCenterSVN psdevcentersvn = null;
    private Integer objPSDevSlnMSDeployLock = new Integer(1);
    private PSDevSlnMSDeploy psdevslnmsdeploy = null;
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;

    public void setConnStr(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setConnStr(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.connstr = string;
        this.connstrDirtyFlag = true;
    }

    public String getConnStr() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getConnStr();
        }
        return this.connstr;
    }

    public boolean isConnStrDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isConnStrDirty();
        }
        return this.connstrDirtyFlag;
    }

    public void resetConnStr() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetConnStr();
            return;
        }
        this.connstrDirtyFlag = false;
        this.connstr = null;
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

    public void setDockerFile(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDockerFile(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dockerfile = string;
        this.dockerfileDirtyFlag = true;
    }

    public String getDockerFile() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDockerFile();
        }
        return this.dockerfile;
    }

    public boolean isDockerFileDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDockerFileDirty();
        }
        return this.dockerfileDirtyFlag;
    }

    public void resetDockerFile() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDockerFile();
            return;
        }
        this.dockerfileDirtyFlag = false;
        this.dockerfile = null;
    }

    public void setItemParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemparams = string;
        this.itemparamsDirtyFlag = true;
    }

    public String getItemParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemParams();
        }
        return this.itemparams;
    }

    public boolean isItemParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemParamsDirty();
        }
        return this.itemparamsDirtyFlag;
    }

    public void resetItemParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemParams();
            return;
        }
        this.itemparamsDirtyFlag = false;
        this.itemparams = null;
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

    public void setPSDCRegistryItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCRegistryItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcregistryitemid = string;
        this.psdcregistryitemidDirtyFlag = true;
    }

    public String getPSDCRegistryItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRegistryItemId();
        }
        return this.psdcregistryitemid;
    }

    public boolean isPSDCRegistryItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCRegistryItemIdDirty();
        }
        return this.psdcregistryitemidDirtyFlag;
    }

    public void resetPSDCRegistryItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCRegistryItemId();
            return;
        }
        this.psdcregistryitemidDirtyFlag = false;
        this.psdcregistryitemid = null;
    }

    public void setPSDCRegistryItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCRegistryItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcregistryitemname = string;
        this.psdcregistryitemnameDirtyFlag = true;
    }

    public String getPSDCRegistryItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRegistryItemName();
        }
        return this.psdcregistryitemname;
    }

    public boolean isPSDCRegistryItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCRegistryItemNameDirty();
        }
        return this.psdcregistryitemnameDirtyFlag;
    }

    public void resetPSDCRegistryItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCRegistryItemName();
            return;
        }
        this.psdcregistryitemnameDirtyFlag = false;
        this.psdcregistryitemname = null;
    }

    public void setPSDCRegistryRepoId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCRegistryRepoId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcregistryrepoid = string;
        this.psdcregistryrepoidDirtyFlag = true;
    }

    public String getPSDCRegistryRepoId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRegistryRepoId();
        }
        return this.psdcregistryrepoid;
    }

    public boolean isPSDCRegistryRepoIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCRegistryRepoIdDirty();
        }
        return this.psdcregistryrepoidDirtyFlag;
    }

    public void resetPSDCRegistryRepoId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCRegistryRepoId();
            return;
        }
        this.psdcregistryrepoidDirtyFlag = false;
        this.psdcregistryrepoid = null;
    }

    public void setPSDCRegistryRepoName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCRegistryRepoName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcregistryreponame = string;
        this.psdcregistryreponameDirtyFlag = true;
    }

    public String getPSDCRegistryRepoName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRegistryRepoName();
        }
        return this.psdcregistryreponame;
    }

    public boolean isPSDCRegistryRepoNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCRegistryRepoNameDirty();
        }
        return this.psdcregistryreponameDirtyFlag;
    }

    public void resetPSDCRegistryRepoName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCRegistryRepoName();
            return;
        }
        this.psdcregistryreponameDirtyFlag = false;
        this.psdcregistryreponame = null;
    }

    public void setPSDevCenterSVNId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterSVNId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentersvnid = string;
        this.psdevcentersvnidDirtyFlag = true;
    }

    public String getPSDevCenterSVNId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterSVNId();
        }
        return this.psdevcentersvnid;
    }

    public boolean isPSDevCenterSVNIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterSVNIdDirty();
        }
        return this.psdevcentersvnidDirtyFlag;
    }

    public void resetPSDevCenterSVNId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterSVNId();
            return;
        }
        this.psdevcentersvnidDirtyFlag = false;
        this.psdevcentersvnid = null;
    }

    public void setPSDevCenterSVNName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterSVNName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentersvnname = string;
        this.psdevcentersvnnameDirtyFlag = true;
    }

    public String getPSDevCenterSVNName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterSVNName();
        }
        return this.psdevcentersvnname;
    }

    public boolean isPSDevCenterSVNNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterSVNNameDirty();
        }
        return this.psdevcentersvnnameDirtyFlag;
    }

    public void resetPSDevCenterSVNName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterSVNName();
            return;
        }
        this.psdevcentersvnnameDirtyFlag = false;
        this.psdevcentersvnname = null;
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

    public void setPSDevSlnMSDeployId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnMSDeployId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnmsdeployid = string;
        this.psdevslnmsdeployidDirtyFlag = true;
    }

    public String getPSDevSlnMSDeployId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDeployId();
        }
        return this.psdevslnmsdeployid;
    }

    public boolean isPSDevSlnMSDeployIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnMSDeployIdDirty();
        }
        return this.psdevslnmsdeployidDirtyFlag;
    }

    public void resetPSDevSlnMSDeployId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnMSDeployId();
            return;
        }
        this.psdevslnmsdeployidDirtyFlag = false;
        this.psdevslnmsdeployid = null;
    }

    public void setPSDevSlnMSDeployName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnMSDeployName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnmsdeployname = string;
        this.psdevslnmsdeploynameDirtyFlag = true;
    }

    public String getPSDevSlnMSDeployName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDeployName();
        }
        return this.psdevslnmsdeployname;
    }

    public boolean isPSDevSlnMSDeployNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnMSDeployNameDirty();
        }
        return this.psdevslnmsdeploynameDirtyFlag;
    }

    public void resetPSDevSlnMSDeployName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnMSDeployName();
            return;
        }
        this.psdevslnmsdeploynameDirtyFlag = false;
        this.psdevslnmsdeployname = null;
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

    public void setResState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResState(n);
            return;
        }
        this.resstate = n;
        this.resstateDirtyFlag = true;
    }

    public Integer getResState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResState();
        }
        return this.resstate;
    }

    public boolean isResStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResStateDirty();
        }
        return this.resstateDirtyFlag;
    }

    public void resetResState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResState();
            return;
        }
        this.resstateDirtyFlag = false;
        this.resstate = null;
    }

    public void setTags(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTags(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tags = string;
        this.tagsDirtyFlag = true;
    }

    public String getTags() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTags();
        }
        return this.tags;
    }

    public boolean isTagsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTagsDirty();
        }
        return this.tagsDirtyFlag;
    }

    public void resetTags() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTags();
            return;
        }
        this.tagsDirtyFlag = false;
        this.tags = null;
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
        PSDCRegistryItemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCRegistryItemBase pSDCRegistryItemBase) {
        pSDCRegistryItemBase.resetConnStr();
        pSDCRegistryItemBase.resetCreateDate();
        pSDCRegistryItemBase.resetCreateMan();
        pSDCRegistryItemBase.resetDockerFile();
        pSDCRegistryItemBase.resetItemParams();
        pSDCRegistryItemBase.resetItemTag();
        pSDCRegistryItemBase.resetItemTag2();
        pSDCRegistryItemBase.resetItemTag3();
        pSDCRegistryItemBase.resetItemTag4();
        pSDCRegistryItemBase.resetLogicName();
        pSDCRegistryItemBase.resetMemo();
        pSDCRegistryItemBase.resetPSDCRegistryItemId();
        pSDCRegistryItemBase.resetPSDCRegistryItemName();
        pSDCRegistryItemBase.resetPSDCRegistryRepoId();
        pSDCRegistryItemBase.resetPSDCRegistryRepoName();
        pSDCRegistryItemBase.resetPSDevCenterSVNId();
        pSDCRegistryItemBase.resetPSDevCenterSVNName();
        pSDCRegistryItemBase.resetPSDevSlnId();
        pSDCRegistryItemBase.resetPSDevSlnMSDeployId();
        pSDCRegistryItemBase.resetPSDevSlnMSDeployName();
        pSDCRegistryItemBase.resetPSDevSlnName();
        pSDCRegistryItemBase.resetPSDevSlnSysId();
        pSDCRegistryItemBase.resetPSDevSlnSysName();
        pSDCRegistryItemBase.resetResState();
        pSDCRegistryItemBase.resetTags();
        pSDCRegistryItemBase.resetUpdateDate();
        pSDCRegistryItemBase.resetUpdateMan();
        pSDCRegistryItemBase.resetUserCat();
        pSDCRegistryItemBase.resetUserTag();
        pSDCRegistryItemBase.resetUserTag2();
        pSDCRegistryItemBase.resetUserTag3();
        pSDCRegistryItemBase.resetUserTag4();
        pSDCRegistryItemBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isConnStrDirty()) {
            hashMap.put(FIELD_CONNSTR, this.getConnStr());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDockerFileDirty()) {
            hashMap.put(FIELD_DOCKERFILE, this.getDockerFile());
        }
        if (!bl || this.isItemParamsDirty()) {
            hashMap.put(FIELD_ITEMPARAMS, this.getItemParams());
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
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDCRegistryItemIdDirty()) {
            hashMap.put(FIELD_PSDCREGISTRYITEMID, this.getPSDCRegistryItemId());
        }
        if (!bl || this.isPSDCRegistryItemNameDirty()) {
            hashMap.put(FIELD_PSDCREGISTRYITEMNAME, this.getPSDCRegistryItemName());
        }
        if (!bl || this.isPSDCRegistryRepoIdDirty()) {
            hashMap.put(FIELD_PSDCREGISTRYREPOID, this.getPSDCRegistryRepoId());
        }
        if (!bl || this.isPSDCRegistryRepoNameDirty()) {
            hashMap.put(FIELD_PSDCREGISTRYREPONAME, this.getPSDCRegistryRepoName());
        }
        if (!bl || this.isPSDevCenterSVNIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERSVNID, this.getPSDevCenterSVNId());
        }
        if (!bl || this.isPSDevCenterSVNNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERSVNNAME, this.getPSDevCenterSVNName());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnMSDeployIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNMSDEPLOYID, this.getPSDevSlnMSDeployId());
        }
        if (!bl || this.isPSDevSlnMSDeployNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNMSDEPLOYNAME, this.getPSDevSlnMSDeployName());
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
        if (!bl || this.isResStateDirty()) {
            hashMap.put(FIELD_RESSTATE, this.getResState());
        }
        if (!bl || this.isTagsDirty()) {
            hashMap.put(FIELD_TAGS, this.getTags());
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
        return PSDCRegistryItemBase.get(this, n);
    }

    private static Object get(PSDCRegistryItemBase pSDCRegistryItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCRegistryItemBase.getConnStr();
            }
            case 1: {
                return pSDCRegistryItemBase.getCreateDate();
            }
            case 2: {
                return pSDCRegistryItemBase.getCreateMan();
            }
            case 3: {
                return pSDCRegistryItemBase.getDockerFile();
            }
            case 4: {
                return pSDCRegistryItemBase.getItemParams();
            }
            case 5: {
                return pSDCRegistryItemBase.getItemTag();
            }
            case 6: {
                return pSDCRegistryItemBase.getItemTag2();
            }
            case 7: {
                return pSDCRegistryItemBase.getItemTag3();
            }
            case 8: {
                return pSDCRegistryItemBase.getItemTag4();
            }
            case 9: {
                return pSDCRegistryItemBase.getLogicName();
            }
            case 10: {
                return pSDCRegistryItemBase.getMemo();
            }
            case 11: {
                return pSDCRegistryItemBase.getPSDCRegistryItemId();
            }
            case 12: {
                return pSDCRegistryItemBase.getPSDCRegistryItemName();
            }
            case 13: {
                return pSDCRegistryItemBase.getPSDCRegistryRepoId();
            }
            case 14: {
                return pSDCRegistryItemBase.getPSDCRegistryRepoName();
            }
            case 15: {
                return pSDCRegistryItemBase.getPSDevCenterSVNId();
            }
            case 16: {
                return pSDCRegistryItemBase.getPSDevCenterSVNName();
            }
            case 17: {
                return pSDCRegistryItemBase.getPSDevSlnId();
            }
            case 18: {
                return pSDCRegistryItemBase.getPSDevSlnMSDeployId();
            }
            case 19: {
                return pSDCRegistryItemBase.getPSDevSlnMSDeployName();
            }
            case 20: {
                return pSDCRegistryItemBase.getPSDevSlnName();
            }
            case 21: {
                return pSDCRegistryItemBase.getPSDevSlnSysId();
            }
            case 22: {
                return pSDCRegistryItemBase.getPSDevSlnSysName();
            }
            case 23: {
                return pSDCRegistryItemBase.getResState();
            }
            case 24: {
                return pSDCRegistryItemBase.getTags();
            }
            case 25: {
                return pSDCRegistryItemBase.getUpdateDate();
            }
            case 26: {
                return pSDCRegistryItemBase.getUpdateMan();
            }
            case 27: {
                return pSDCRegistryItemBase.getUserCat();
            }
            case 28: {
                return pSDCRegistryItemBase.getUserTag();
            }
            case 29: {
                return pSDCRegistryItemBase.getUserTag2();
            }
            case 30: {
                return pSDCRegistryItemBase.getUserTag3();
            }
            case 31: {
                return pSDCRegistryItemBase.getUserTag4();
            }
            case 32: {
                return pSDCRegistryItemBase.getValidFlag();
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
        PSDCRegistryItemBase.set(this, n, object);
    }

    private static void set(PSDCRegistryItemBase pSDCRegistryItemBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCRegistryItemBase.setConnStr(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDCRegistryItemBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDCRegistryItemBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCRegistryItemBase.setDockerFile(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCRegistryItemBase.setItemParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCRegistryItemBase.setItemTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCRegistryItemBase.setItemTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCRegistryItemBase.setItemTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCRegistryItemBase.setItemTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCRegistryItemBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCRegistryItemBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCRegistryItemBase.setPSDCRegistryItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCRegistryItemBase.setPSDCRegistryItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCRegistryItemBase.setPSDCRegistryRepoId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCRegistryItemBase.setPSDCRegistryRepoName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDCRegistryItemBase.setPSDevCenterSVNId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDCRegistryItemBase.setPSDevCenterSVNName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDCRegistryItemBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDCRegistryItemBase.setPSDevSlnMSDeployId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDCRegistryItemBase.setPSDevSlnMSDeployName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDCRegistryItemBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDCRegistryItemBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDCRegistryItemBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDCRegistryItemBase.setResState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSDCRegistryItemBase.setTags(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDCRegistryItemBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 26: {
                pSDCRegistryItemBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDCRegistryItemBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDCRegistryItemBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDCRegistryItemBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDCRegistryItemBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDCRegistryItemBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDCRegistryItemBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDCRegistryItemBase.isNull(this, n);
    }

    private static boolean isNull(PSDCRegistryItemBase pSDCRegistryItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCRegistryItemBase.getConnStr() == null;
            }
            case 1: {
                return pSDCRegistryItemBase.getCreateDate() == null;
            }
            case 2: {
                return pSDCRegistryItemBase.getCreateMan() == null;
            }
            case 3: {
                return pSDCRegistryItemBase.getDockerFile() == null;
            }
            case 4: {
                return pSDCRegistryItemBase.getItemParams() == null;
            }
            case 5: {
                return pSDCRegistryItemBase.getItemTag() == null;
            }
            case 6: {
                return pSDCRegistryItemBase.getItemTag2() == null;
            }
            case 7: {
                return pSDCRegistryItemBase.getItemTag3() == null;
            }
            case 8: {
                return pSDCRegistryItemBase.getItemTag4() == null;
            }
            case 9: {
                return pSDCRegistryItemBase.getLogicName() == null;
            }
            case 10: {
                return pSDCRegistryItemBase.getMemo() == null;
            }
            case 11: {
                return pSDCRegistryItemBase.getPSDCRegistryItemId() == null;
            }
            case 12: {
                return pSDCRegistryItemBase.getPSDCRegistryItemName() == null;
            }
            case 13: {
                return pSDCRegistryItemBase.getPSDCRegistryRepoId() == null;
            }
            case 14: {
                return pSDCRegistryItemBase.getPSDCRegistryRepoName() == null;
            }
            case 15: {
                return pSDCRegistryItemBase.getPSDevCenterSVNId() == null;
            }
            case 16: {
                return pSDCRegistryItemBase.getPSDevCenterSVNName() == null;
            }
            case 17: {
                return pSDCRegistryItemBase.getPSDevSlnId() == null;
            }
            case 18: {
                return pSDCRegistryItemBase.getPSDevSlnMSDeployId() == null;
            }
            case 19: {
                return pSDCRegistryItemBase.getPSDevSlnMSDeployName() == null;
            }
            case 20: {
                return pSDCRegistryItemBase.getPSDevSlnName() == null;
            }
            case 21: {
                return pSDCRegistryItemBase.getPSDevSlnSysId() == null;
            }
            case 22: {
                return pSDCRegistryItemBase.getPSDevSlnSysName() == null;
            }
            case 23: {
                return pSDCRegistryItemBase.getResState() == null;
            }
            case 24: {
                return pSDCRegistryItemBase.getTags() == null;
            }
            case 25: {
                return pSDCRegistryItemBase.getUpdateDate() == null;
            }
            case 26: {
                return pSDCRegistryItemBase.getUpdateMan() == null;
            }
            case 27: {
                return pSDCRegistryItemBase.getUserCat() == null;
            }
            case 28: {
                return pSDCRegistryItemBase.getUserTag() == null;
            }
            case 29: {
                return pSDCRegistryItemBase.getUserTag2() == null;
            }
            case 30: {
                return pSDCRegistryItemBase.getUserTag3() == null;
            }
            case 31: {
                return pSDCRegistryItemBase.getUserTag4() == null;
            }
            case 32: {
                return pSDCRegistryItemBase.getValidFlag() == null;
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
        return PSDCRegistryItemBase.contains(this, n);
    }

    private static boolean contains(PSDCRegistryItemBase pSDCRegistryItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCRegistryItemBase.isConnStrDirty();
            }
            case 1: {
                return pSDCRegistryItemBase.isCreateDateDirty();
            }
            case 2: {
                return pSDCRegistryItemBase.isCreateManDirty();
            }
            case 3: {
                return pSDCRegistryItemBase.isDockerFileDirty();
            }
            case 4: {
                return pSDCRegistryItemBase.isItemParamsDirty();
            }
            case 5: {
                return pSDCRegistryItemBase.isItemTagDirty();
            }
            case 6: {
                return pSDCRegistryItemBase.isItemTag2Dirty();
            }
            case 7: {
                return pSDCRegistryItemBase.isItemTag3Dirty();
            }
            case 8: {
                return pSDCRegistryItemBase.isItemTag4Dirty();
            }
            case 9: {
                return pSDCRegistryItemBase.isLogicNameDirty();
            }
            case 10: {
                return pSDCRegistryItemBase.isMemoDirty();
            }
            case 11: {
                return pSDCRegistryItemBase.isPSDCRegistryItemIdDirty();
            }
            case 12: {
                return pSDCRegistryItemBase.isPSDCRegistryItemNameDirty();
            }
            case 13: {
                return pSDCRegistryItemBase.isPSDCRegistryRepoIdDirty();
            }
            case 14: {
                return pSDCRegistryItemBase.isPSDCRegistryRepoNameDirty();
            }
            case 15: {
                return pSDCRegistryItemBase.isPSDevCenterSVNIdDirty();
            }
            case 16: {
                return pSDCRegistryItemBase.isPSDevCenterSVNNameDirty();
            }
            case 17: {
                return pSDCRegistryItemBase.isPSDevSlnIdDirty();
            }
            case 18: {
                return pSDCRegistryItemBase.isPSDevSlnMSDeployIdDirty();
            }
            case 19: {
                return pSDCRegistryItemBase.isPSDevSlnMSDeployNameDirty();
            }
            case 20: {
                return pSDCRegistryItemBase.isPSDevSlnNameDirty();
            }
            case 21: {
                return pSDCRegistryItemBase.isPSDevSlnSysIdDirty();
            }
            case 22: {
                return pSDCRegistryItemBase.isPSDevSlnSysNameDirty();
            }
            case 23: {
                return pSDCRegistryItemBase.isResStateDirty();
            }
            case 24: {
                return pSDCRegistryItemBase.isTagsDirty();
            }
            case 25: {
                return pSDCRegistryItemBase.isUpdateDateDirty();
            }
            case 26: {
                return pSDCRegistryItemBase.isUpdateManDirty();
            }
            case 27: {
                return pSDCRegistryItemBase.isUserCatDirty();
            }
            case 28: {
                return pSDCRegistryItemBase.isUserTagDirty();
            }
            case 29: {
                return pSDCRegistryItemBase.isUserTag2Dirty();
            }
            case 30: {
                return pSDCRegistryItemBase.isUserTag3Dirty();
            }
            case 31: {
                return pSDCRegistryItemBase.isUserTag4Dirty();
            }
            case 32: {
                return pSDCRegistryItemBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCRegistryItemBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCRegistryItemBase pSDCRegistryItemBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCRegistryItemBase.getConnStr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"connstr", (Object)PSDCRegistryItemBase.getJSONValue((Object)pSDCRegistryItemBase.getConnStr()), (boolean)false);
        }
        if (bl || pSDCRegistryItemBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCRegistryItemBase.getJSONValue((Object)pSDCRegistryItemBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCRegistryItemBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCRegistryItemBase.getJSONValue((Object)pSDCRegistryItemBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCRegistryItemBase.getDockerFile() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dockerfile", (Object)PSDCRegistryItemBase.getJSONValue((Object)pSDCRegistryItemBase.getDockerFile()), (boolean)false);
        }
        if (bl || pSDCRegistryItemBase.getItemParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemparams", (Object)PSDCRegistryItemBase.getJSONValue((Object)pSDCRegistryItemBase.getItemParams()), (boolean)false);
        }
        if (bl || pSDCRegistryItemBase.getItemTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemtag", (Object)PSDCRegistryItemBase.getJSONValue((Object)pSDCRegistryItemBase.getItemTag()), (boolean)false);
        }
        if (bl || pSDCRegistryItemBase.getItemTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemtag2", (Object)PSDCRegistryItemBase.getJSONValue((Object)pSDCRegistryItemBase.getItemTag2()), (boolean)false);
        }
        if (bl || pSDCRegistryItemBase.getItemTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemtag3", (Object)PSDCRegistryItemBase.getJSONValue((Object)pSDCRegistryItemBase.getItemTag3()), (boolean)false);
        }
        if (bl || pSDCRegistryItemBase.getItemTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemtag4", (Object)PSDCRegistryItemBase.getJSONValue((Object)pSDCRegistryItemBase.getItemTag4()), (boolean)false);
        }
        if (bl || pSDCRegistryItemBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSDCRegistryItemBase.getJSONValue((Object)pSDCRegistryItemBase.getLogicName()), (boolean)false);
        }
        if (bl || pSDCRegistryItemBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCRegistryItemBase.getJSONValue((Object)pSDCRegistryItemBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCRegistryItemBase.getPSDCRegistryItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcregistryitemid", (Object)PSDCRegistryItemBase.getJSONValue((Object)pSDCRegistryItemBase.getPSDCRegistryItemId()), (boolean)false);
        }
        if (bl || pSDCRegistryItemBase.getPSDCRegistryItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcregistryitemname", (Object)PSDCRegistryItemBase.getJSONValue((Object)pSDCRegistryItemBase.getPSDCRegistryItemName()), (boolean)false);
        }
        if (bl || pSDCRegistryItemBase.getPSDCRegistryRepoId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcregistryrepoid", (Object)PSDCRegistryItemBase.getJSONValue((Object)pSDCRegistryItemBase.getPSDCRegistryRepoId()), (boolean)false);
        }
        if (bl || pSDCRegistryItemBase.getPSDCRegistryRepoName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcregistryreponame", (Object)PSDCRegistryItemBase.getJSONValue((Object)pSDCRegistryItemBase.getPSDCRegistryRepoName()), (boolean)false);
        }
        if (bl || pSDCRegistryItemBase.getPSDevCenterSVNId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentersvnid", (Object)PSDCRegistryItemBase.getJSONValue((Object)pSDCRegistryItemBase.getPSDevCenterSVNId()), (boolean)false);
        }
        if (bl || pSDCRegistryItemBase.getPSDevCenterSVNName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentersvnname", (Object)PSDCRegistryItemBase.getJSONValue((Object)pSDCRegistryItemBase.getPSDevCenterSVNName()), (boolean)false);
        }
        if (bl || pSDCRegistryItemBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDCRegistryItemBase.getJSONValue((Object)pSDCRegistryItemBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDCRegistryItemBase.getPSDevSlnMSDeployId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdeployid", (Object)PSDCRegistryItemBase.getJSONValue((Object)pSDCRegistryItemBase.getPSDevSlnMSDeployId()), (boolean)false);
        }
        if (bl || pSDCRegistryItemBase.getPSDevSlnMSDeployName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdeployname", (Object)PSDCRegistryItemBase.getJSONValue((Object)pSDCRegistryItemBase.getPSDevSlnMSDeployName()), (boolean)false);
        }
        if (bl || pSDCRegistryItemBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDCRegistryItemBase.getJSONValue((Object)pSDCRegistryItemBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDCRegistryItemBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDCRegistryItemBase.getJSONValue((Object)pSDCRegistryItemBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDCRegistryItemBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSDCRegistryItemBase.getJSONValue((Object)pSDCRegistryItemBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDCRegistryItemBase.getResState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resstate", (Object)PSDCRegistryItemBase.getJSONValue((Object)pSDCRegistryItemBase.getResState()), (boolean)false);
        }
        if (bl || pSDCRegistryItemBase.getTags() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tags", (Object)PSDCRegistryItemBase.getJSONValue((Object)pSDCRegistryItemBase.getTags()), (boolean)false);
        }
        if (bl || pSDCRegistryItemBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCRegistryItemBase.getJSONValue((Object)pSDCRegistryItemBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCRegistryItemBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCRegistryItemBase.getJSONValue((Object)pSDCRegistryItemBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCRegistryItemBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDCRegistryItemBase.getJSONValue((Object)pSDCRegistryItemBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDCRegistryItemBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDCRegistryItemBase.getJSONValue((Object)pSDCRegistryItemBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDCRegistryItemBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDCRegistryItemBase.getJSONValue((Object)pSDCRegistryItemBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDCRegistryItemBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDCRegistryItemBase.getJSONValue((Object)pSDCRegistryItemBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDCRegistryItemBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDCRegistryItemBase.getJSONValue((Object)pSDCRegistryItemBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDCRegistryItemBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDCRegistryItemBase.getJSONValue((Object)pSDCRegistryItemBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCRegistryItemBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCRegistryItemBase pSDCRegistryItemBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCRegistryItemBase.getConnStr() != null) {
            object = pSDCRegistryItemBase.getConnStr();
            xmlNode.setAttribute(FIELD_CONNSTR, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryItemBase.getCreateDate() != null) {
            object = pSDCRegistryItemBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCRegistryItemBase.getCreateMan() != null) {
            object = pSDCRegistryItemBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryItemBase.getDockerFile() != null) {
            object = pSDCRegistryItemBase.getDockerFile();
            xmlNode.setAttribute(FIELD_DOCKERFILE, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryItemBase.getItemParams() != null) {
            object = pSDCRegistryItemBase.getItemParams();
            xmlNode.setAttribute(FIELD_ITEMPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryItemBase.getItemTag() != null) {
            object = pSDCRegistryItemBase.getItemTag();
            xmlNode.setAttribute(FIELD_ITEMTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryItemBase.getItemTag2() != null) {
            object = pSDCRegistryItemBase.getItemTag2();
            xmlNode.setAttribute(FIELD_ITEMTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryItemBase.getItemTag3() != null) {
            object = pSDCRegistryItemBase.getItemTag3();
            xmlNode.setAttribute(FIELD_ITEMTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryItemBase.getItemTag4() != null) {
            object = pSDCRegistryItemBase.getItemTag4();
            xmlNode.setAttribute(FIELD_ITEMTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryItemBase.getLogicName() != null) {
            object = pSDCRegistryItemBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryItemBase.getMemo() != null) {
            object = pSDCRegistryItemBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryItemBase.getPSDCRegistryItemId() != null) {
            object = pSDCRegistryItemBase.getPSDCRegistryItemId();
            xmlNode.setAttribute(FIELD_PSDCREGISTRYITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryItemBase.getPSDCRegistryItemName() != null) {
            object = pSDCRegistryItemBase.getPSDCRegistryItemName();
            xmlNode.setAttribute(FIELD_PSDCREGISTRYITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryItemBase.getPSDCRegistryRepoId() != null) {
            object = pSDCRegistryItemBase.getPSDCRegistryRepoId();
            xmlNode.setAttribute(FIELD_PSDCREGISTRYREPOID, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryItemBase.getPSDCRegistryRepoName() != null) {
            object = pSDCRegistryItemBase.getPSDCRegistryRepoName();
            xmlNode.setAttribute(FIELD_PSDCREGISTRYREPONAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryItemBase.getPSDevCenterSVNId() != null) {
            object = pSDCRegistryItemBase.getPSDevCenterSVNId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERSVNID, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryItemBase.getPSDevCenterSVNName() != null) {
            object = pSDCRegistryItemBase.getPSDevCenterSVNName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERSVNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryItemBase.getPSDevSlnId() != null) {
            object = pSDCRegistryItemBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryItemBase.getPSDevSlnMSDeployId() != null) {
            object = pSDCRegistryItemBase.getPSDevSlnMSDeployId();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPLOYID, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryItemBase.getPSDevSlnMSDeployName() != null) {
            object = pSDCRegistryItemBase.getPSDevSlnMSDeployName();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPLOYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryItemBase.getPSDevSlnName() != null) {
            object = pSDCRegistryItemBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryItemBase.getPSDevSlnSysId() != null) {
            object = pSDCRegistryItemBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryItemBase.getPSDevSlnSysName() != null) {
            object = pSDCRegistryItemBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryItemBase.getResState() != null) {
            object = pSDCRegistryItemBase.getResState();
            xmlNode.setAttribute(FIELD_RESSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCRegistryItemBase.getTags() != null) {
            object = pSDCRegistryItemBase.getTags();
            xmlNode.setAttribute(FIELD_TAGS, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryItemBase.getUpdateDate() != null) {
            object = pSDCRegistryItemBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCRegistryItemBase.getUpdateMan() != null) {
            object = pSDCRegistryItemBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryItemBase.getUserCat() != null) {
            object = pSDCRegistryItemBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryItemBase.getUserTag() != null) {
            object = pSDCRegistryItemBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryItemBase.getUserTag2() != null) {
            object = pSDCRegistryItemBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryItemBase.getUserTag3() != null) {
            object = pSDCRegistryItemBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryItemBase.getUserTag4() != null) {
            object = pSDCRegistryItemBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryItemBase.getValidFlag() != null) {
            object = pSDCRegistryItemBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCRegistryItemBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCRegistryItemBase pSDCRegistryItemBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCRegistryItemBase.isConnStrDirty() && (bl || pSDCRegistryItemBase.getConnStr() != null)) {
            iDataObject.set(FIELD_CONNSTR, (Object)pSDCRegistryItemBase.getConnStr());
        }
        if (pSDCRegistryItemBase.isCreateDateDirty() && (bl || pSDCRegistryItemBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCRegistryItemBase.getCreateDate());
        }
        if (pSDCRegistryItemBase.isCreateManDirty() && (bl || pSDCRegistryItemBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCRegistryItemBase.getCreateMan());
        }
        if (pSDCRegistryItemBase.isDockerFileDirty() && (bl || pSDCRegistryItemBase.getDockerFile() != null)) {
            iDataObject.set(FIELD_DOCKERFILE, (Object)pSDCRegistryItemBase.getDockerFile());
        }
        if (pSDCRegistryItemBase.isItemParamsDirty() && (bl || pSDCRegistryItemBase.getItemParams() != null)) {
            iDataObject.set(FIELD_ITEMPARAMS, (Object)pSDCRegistryItemBase.getItemParams());
        }
        if (pSDCRegistryItemBase.isItemTagDirty() && (bl || pSDCRegistryItemBase.getItemTag() != null)) {
            iDataObject.set(FIELD_ITEMTAG, (Object)pSDCRegistryItemBase.getItemTag());
        }
        if (pSDCRegistryItemBase.isItemTag2Dirty() && (bl || pSDCRegistryItemBase.getItemTag2() != null)) {
            iDataObject.set(FIELD_ITEMTAG2, (Object)pSDCRegistryItemBase.getItemTag2());
        }
        if (pSDCRegistryItemBase.isItemTag3Dirty() && (bl || pSDCRegistryItemBase.getItemTag3() != null)) {
            iDataObject.set(FIELD_ITEMTAG3, (Object)pSDCRegistryItemBase.getItemTag3());
        }
        if (pSDCRegistryItemBase.isItemTag4Dirty() && (bl || pSDCRegistryItemBase.getItemTag4() != null)) {
            iDataObject.set(FIELD_ITEMTAG4, (Object)pSDCRegistryItemBase.getItemTag4());
        }
        if (pSDCRegistryItemBase.isLogicNameDirty() && (bl || pSDCRegistryItemBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSDCRegistryItemBase.getLogicName());
        }
        if (pSDCRegistryItemBase.isMemoDirty() && (bl || pSDCRegistryItemBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCRegistryItemBase.getMemo());
        }
        if (pSDCRegistryItemBase.isPSDCRegistryItemIdDirty() && (bl || pSDCRegistryItemBase.getPSDCRegistryItemId() != null)) {
            iDataObject.set(FIELD_PSDCREGISTRYITEMID, (Object)pSDCRegistryItemBase.getPSDCRegistryItemId());
        }
        if (pSDCRegistryItemBase.isPSDCRegistryItemNameDirty() && (bl || pSDCRegistryItemBase.getPSDCRegistryItemName() != null)) {
            iDataObject.set(FIELD_PSDCREGISTRYITEMNAME, (Object)pSDCRegistryItemBase.getPSDCRegistryItemName());
        }
        if (pSDCRegistryItemBase.isPSDCRegistryRepoIdDirty() && (bl || pSDCRegistryItemBase.getPSDCRegistryRepoId() != null)) {
            iDataObject.set(FIELD_PSDCREGISTRYREPOID, (Object)pSDCRegistryItemBase.getPSDCRegistryRepoId());
        }
        if (pSDCRegistryItemBase.isPSDCRegistryRepoNameDirty() && (bl || pSDCRegistryItemBase.getPSDCRegistryRepoName() != null)) {
            iDataObject.set(FIELD_PSDCREGISTRYREPONAME, (Object)pSDCRegistryItemBase.getPSDCRegistryRepoName());
        }
        if (pSDCRegistryItemBase.isPSDevCenterSVNIdDirty() && (bl || pSDCRegistryItemBase.getPSDevCenterSVNId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERSVNID, (Object)pSDCRegistryItemBase.getPSDevCenterSVNId());
        }
        if (pSDCRegistryItemBase.isPSDevCenterSVNNameDirty() && (bl || pSDCRegistryItemBase.getPSDevCenterSVNName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERSVNNAME, (Object)pSDCRegistryItemBase.getPSDevCenterSVNName());
        }
        if (pSDCRegistryItemBase.isPSDevSlnIdDirty() && (bl || pSDCRegistryItemBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDCRegistryItemBase.getPSDevSlnId());
        }
        if (pSDCRegistryItemBase.isPSDevSlnMSDeployIdDirty() && (bl || pSDCRegistryItemBase.getPSDevSlnMSDeployId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPLOYID, (Object)pSDCRegistryItemBase.getPSDevSlnMSDeployId());
        }
        if (pSDCRegistryItemBase.isPSDevSlnMSDeployNameDirty() && (bl || pSDCRegistryItemBase.getPSDevSlnMSDeployName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPLOYNAME, (Object)pSDCRegistryItemBase.getPSDevSlnMSDeployName());
        }
        if (pSDCRegistryItemBase.isPSDevSlnNameDirty() && (bl || pSDCRegistryItemBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDCRegistryItemBase.getPSDevSlnName());
        }
        if (pSDCRegistryItemBase.isPSDevSlnSysIdDirty() && (bl || pSDCRegistryItemBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDCRegistryItemBase.getPSDevSlnSysId());
        }
        if (pSDCRegistryItemBase.isPSDevSlnSysNameDirty() && (bl || pSDCRegistryItemBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSDCRegistryItemBase.getPSDevSlnSysName());
        }
        if (pSDCRegistryItemBase.isResStateDirty() && (bl || pSDCRegistryItemBase.getResState() != null)) {
            iDataObject.set(FIELD_RESSTATE, (Object)pSDCRegistryItemBase.getResState());
        }
        if (pSDCRegistryItemBase.isTagsDirty() && (bl || pSDCRegistryItemBase.getTags() != null)) {
            iDataObject.set(FIELD_TAGS, (Object)pSDCRegistryItemBase.getTags());
        }
        if (pSDCRegistryItemBase.isUpdateDateDirty() && (bl || pSDCRegistryItemBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCRegistryItemBase.getUpdateDate());
        }
        if (pSDCRegistryItemBase.isUpdateManDirty() && (bl || pSDCRegistryItemBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCRegistryItemBase.getUpdateMan());
        }
        if (pSDCRegistryItemBase.isUserCatDirty() && (bl || pSDCRegistryItemBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDCRegistryItemBase.getUserCat());
        }
        if (pSDCRegistryItemBase.isUserTagDirty() && (bl || pSDCRegistryItemBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDCRegistryItemBase.getUserTag());
        }
        if (pSDCRegistryItemBase.isUserTag2Dirty() && (bl || pSDCRegistryItemBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDCRegistryItemBase.getUserTag2());
        }
        if (pSDCRegistryItemBase.isUserTag3Dirty() && (bl || pSDCRegistryItemBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDCRegistryItemBase.getUserTag3());
        }
        if (pSDCRegistryItemBase.isUserTag4Dirty() && (bl || pSDCRegistryItemBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDCRegistryItemBase.getUserTag4());
        }
        if (pSDCRegistryItemBase.isValidFlagDirty() && (bl || pSDCRegistryItemBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDCRegistryItemBase.getValidFlag());
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
        return PSDCRegistryItemBase.remove(this, n);
    }

    private static boolean remove(PSDCRegistryItemBase pSDCRegistryItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCRegistryItemBase.resetConnStr();
                return true;
            }
            case 1: {
                pSDCRegistryItemBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDCRegistryItemBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDCRegistryItemBase.resetDockerFile();
                return true;
            }
            case 4: {
                pSDCRegistryItemBase.resetItemParams();
                return true;
            }
            case 5: {
                pSDCRegistryItemBase.resetItemTag();
                return true;
            }
            case 6: {
                pSDCRegistryItemBase.resetItemTag2();
                return true;
            }
            case 7: {
                pSDCRegistryItemBase.resetItemTag3();
                return true;
            }
            case 8: {
                pSDCRegistryItemBase.resetItemTag4();
                return true;
            }
            case 9: {
                pSDCRegistryItemBase.resetLogicName();
                return true;
            }
            case 10: {
                pSDCRegistryItemBase.resetMemo();
                return true;
            }
            case 11: {
                pSDCRegistryItemBase.resetPSDCRegistryItemId();
                return true;
            }
            case 12: {
                pSDCRegistryItemBase.resetPSDCRegistryItemName();
                return true;
            }
            case 13: {
                pSDCRegistryItemBase.resetPSDCRegistryRepoId();
                return true;
            }
            case 14: {
                pSDCRegistryItemBase.resetPSDCRegistryRepoName();
                return true;
            }
            case 15: {
                pSDCRegistryItemBase.resetPSDevCenterSVNId();
                return true;
            }
            case 16: {
                pSDCRegistryItemBase.resetPSDevCenterSVNName();
                return true;
            }
            case 17: {
                pSDCRegistryItemBase.resetPSDevSlnId();
                return true;
            }
            case 18: {
                pSDCRegistryItemBase.resetPSDevSlnMSDeployId();
                return true;
            }
            case 19: {
                pSDCRegistryItemBase.resetPSDevSlnMSDeployName();
                return true;
            }
            case 20: {
                pSDCRegistryItemBase.resetPSDevSlnName();
                return true;
            }
            case 21: {
                pSDCRegistryItemBase.resetPSDevSlnSysId();
                return true;
            }
            case 22: {
                pSDCRegistryItemBase.resetPSDevSlnSysName();
                return true;
            }
            case 23: {
                pSDCRegistryItemBase.resetResState();
                return true;
            }
            case 24: {
                pSDCRegistryItemBase.resetTags();
                return true;
            }
            case 25: {
                pSDCRegistryItemBase.resetUpdateDate();
                return true;
            }
            case 26: {
                pSDCRegistryItemBase.resetUpdateMan();
                return true;
            }
            case 27: {
                pSDCRegistryItemBase.resetUserCat();
                return true;
            }
            case 28: {
                pSDCRegistryItemBase.resetUserTag();
                return true;
            }
            case 29: {
                pSDCRegistryItemBase.resetUserTag2();
                return true;
            }
            case 30: {
                pSDCRegistryItemBase.resetUserTag3();
                return true;
            }
            case 31: {
                pSDCRegistryItemBase.resetUserTag4();
                return true;
            }
            case 32: {
                pSDCRegistryItemBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCRegistryRepo getPSDCRegistryRepo() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRegistryRepo();
        }
        if (this.getPSDCRegistryRepoId() == null) {
            return null;
        }
        Integer n = this.objPSDCRegistryRepoLock;
        synchronized (n) {
            if (this.psdcregistryrepo != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCRegistryRepoId(), (Object)this.psdcregistryrepo.getPSDCRegistryRepoId()) != 0L) {
                this.psdcregistryrepo = null;
            }
            if (this.psdcregistryrepo == null) {
                PSDCRegistryRepo pSDCRegistryRepo = new PSDCRegistryRepo();
                pSDCRegistryRepo.setPSDCRegistryRepoId(this.getPSDCRegistryRepoId());
                PSDCRegistryRepoService pSDCRegistryRepoService = (PSDCRegistryRepoService)ServiceGlobal.getService(PSDCRegistryRepoService.class, (SessionFactory)this.getSessionFactory());
                pSDCRegistryRepoService.autoGet(pSDCRegistryRepo);
                this.psdcregistryrepo = pSDCRegistryRepo;
            }
            return this.psdcregistryrepo;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterSVN getPSDevCenterSVN() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterSVN();
        }
        if (this.getPSDevCenterSVNId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterSVNLock;
        synchronized (n) {
            if (this.psdevcentersvn != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterSVNId(), (Object)this.psdevcentersvn.getPSDevCenterSVNId()) != 0L) {
                this.psdevcentersvn = null;
            }
            if (this.psdevcentersvn == null) {
                PSDevCenterSVN pSDevCenterSVN = new PSDevCenterSVN();
                pSDevCenterSVN.setPSDevCenterSVNId(this.getPSDevCenterSVNId());
                PSDevCenterSVNService pSDevCenterSVNService = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterSVNService.autoGet(pSDevCenterSVN);
                this.psdevcentersvn = pSDevCenterSVN;
            }
            return this.psdevcentersvn;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnMSDeploy getPSDevSlnMSDeploy() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDeploy();
        }
        if (this.getPSDevSlnMSDeployId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnMSDeployLock;
        synchronized (n) {
            if (this.psdevslnmsdeploy != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnMSDeployId(), (Object)this.psdevslnmsdeploy.getPSDevSlnMSDeployId()) != 0L) {
                this.psdevslnmsdeploy = null;
            }
            if (this.psdevslnmsdeploy == null) {
                PSDevSlnMSDeploy pSDevSlnMSDeploy = new PSDevSlnMSDeploy();
                pSDevSlnMSDeploy.setPSDevSlnMSDeployId(this.getPSDevSlnMSDeployId());
                PSDevSlnMSDeployService pSDevSlnMSDeployService = (PSDevSlnMSDeployService)ServiceGlobal.getService(PSDevSlnMSDeployService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnMSDeployService.autoGet(pSDevSlnMSDeploy);
                this.psdevslnmsdeploy = pSDevSlnMSDeploy;
            }
            return this.psdevslnmsdeploy;
        }
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
                pSDevSlnSysService.autoGet(pSDevSlnSys);
                this.psdevslnsys = pSDevSlnSys;
            }
            return this.psdevslnsys;
        }
    }

    private PSDCRegistryItemBase getProxyEntity() {
        return this.proxyPSDCRegistryItemBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCRegistryItemBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCRegistryItemBase) {
            this.proxyPSDCRegistryItemBase = (PSDCRegistryItemBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryItemService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONNSTR, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DOCKERFILE, 3);
        fieldIndexMap.put(FIELD_ITEMPARAMS, 4);
        fieldIndexMap.put(FIELD_ITEMTAG, 5);
        fieldIndexMap.put(FIELD_ITEMTAG2, 6);
        fieldIndexMap.put(FIELD_ITEMTAG3, 7);
        fieldIndexMap.put(FIELD_ITEMTAG4, 8);
        fieldIndexMap.put(FIELD_LOGICNAME, 9);
        fieldIndexMap.put(FIELD_MEMO, 10);
        fieldIndexMap.put(FIELD_PSDCREGISTRYITEMID, 11);
        fieldIndexMap.put(FIELD_PSDCREGISTRYITEMNAME, 12);
        fieldIndexMap.put(FIELD_PSDCREGISTRYREPOID, 13);
        fieldIndexMap.put(FIELD_PSDCREGISTRYREPONAME, 14);
        fieldIndexMap.put(FIELD_PSDEVCENTERSVNID, 15);
        fieldIndexMap.put(FIELD_PSDEVCENTERSVNNAME, 16);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 17);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPLOYID, 18);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPLOYNAME, 19);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 20);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 21);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 22);
        fieldIndexMap.put(FIELD_RESSTATE, 23);
        fieldIndexMap.put(FIELD_TAGS, 24);
        fieldIndexMap.put(FIELD_UPDATEDATE, 25);
        fieldIndexMap.put(FIELD_UPDATEMAN, 26);
        fieldIndexMap.put(FIELD_USERCAT, 27);
        fieldIndexMap.put(FIELD_USERTAG, 28);
        fieldIndexMap.put(FIELD_USERTAG2, 29);
        fieldIndexMap.put(FIELD_USERTAG3, 30);
        fieldIndexMap.put(FIELD_USERTAG4, 31);
        fieldIndexMap.put(FIELD_VALIDFLAG, 32);
    }
}

