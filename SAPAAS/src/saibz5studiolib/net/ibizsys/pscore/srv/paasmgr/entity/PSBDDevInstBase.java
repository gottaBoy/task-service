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
import net.ibizsys.pscore.srv.paasmgr.entity.PSBDServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.service.PSBDServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSBDDevInstBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSBDDevInstBase.class);
    public static final String FIELD_BDTYPE = "BDTYPE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_INSTSTATE = "INSTSTATE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PARAM = "PARAM";
    public static final String FIELD_PARAM2 = "PARAM2";
    public static final String FIELD_PARAM3 = "PARAM3";
    public static final String FIELD_PARAM4 = "PARAM4";
    public static final String FIELD_PARAM5 = "PARAM5";
    public static final String FIELD_PARAM6 = "PARAM6";
    public static final String FIELD_PARAM7 = "PARAM7";
    public static final String FIELD_PARAM8 = "PARAM8";
    public static final String FIELD_PSBDDEVINSTID = "PSBDDEVINSTID";
    public static final String FIELD_PSBDDEVINSTNAME = "PSBDDEVINSTNAME";
    public static final String FIELD_PSBDSERVERID = "PSBDSERVERID";
    public static final String FIELD_PSBDSERVERNAME = "PSBDSERVERNAME";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_BDTYPE = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_INSTSTATE = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PARAM = 5;
    private static final int INDEX_PARAM2 = 6;
    private static final int INDEX_PARAM3 = 7;
    private static final int INDEX_PARAM4 = 8;
    private static final int INDEX_PARAM5 = 9;
    private static final int INDEX_PARAM6 = 10;
    private static final int INDEX_PARAM7 = 11;
    private static final int INDEX_PARAM8 = 12;
    private static final int INDEX_PSBDDEVINSTID = 13;
    private static final int INDEX_PSBDDEVINSTNAME = 14;
    private static final int INDEX_PSBDSERVERID = 15;
    private static final int INDEX_PSBDSERVERNAME = 16;
    private static final int INDEX_PSSVRDOMAINID = 17;
    private static final int INDEX_PSSVRDOMAINNAME = 18;
    private static final int INDEX_UPDATEDATE = 19;
    private static final int INDEX_UPDATEMAN = 20;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSBDDevInstBase proxyPSBDDevInstBase = null;
    private boolean bdtypeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean inststateDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean paramDirtyFlag = false;
    private boolean param2DirtyFlag = false;
    private boolean param3DirtyFlag = false;
    private boolean param4DirtyFlag = false;
    private boolean param5DirtyFlag = false;
    private boolean param6DirtyFlag = false;
    private boolean param7DirtyFlag = false;
    private boolean param8DirtyFlag = false;
    private boolean psbddevinstidDirtyFlag = false;
    private boolean psbddevinstnameDirtyFlag = false;
    private boolean psbdserveridDirtyFlag = false;
    private boolean psbdservernameDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="bdtype")
    private String bdtype;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="inststate")
    private Integer inststate;
    @Column(name="memo")
    private String memo;
    @Column(name="param")
    private String param;
    @Column(name="param2")
    private String param2;
    @Column(name="param3")
    private String param3;
    @Column(name="param4")
    private String param4;
    @Column(name="param5")
    private Integer param5;
    @Column(name="param6")
    private Integer param6;
    @Column(name="param7")
    private Integer param7;
    @Column(name="param8")
    private Integer param8;
    @Column(name="psbddevinstid")
    private String psbddevinstid;
    @Column(name="psbddevinstname")
    private String psbddevinstname;
    @Column(name="psbdserverid")
    private String psbdserverid;
    @Column(name="psbdservername")
    private String psbdservername;
    @Column(name="pssvrdomainid")
    private String pssvrdomainid;
    @Column(name="pssvrdomainname")
    private String pssvrdomainname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSBDServerLock = new Integer(1);
    private PSBDServer psbdserver = null;
    private Integer objPSSvrDomainLock = new Integer(1);
    private PSSvrDomain pssvrdomain = null;

    public void setBDType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBDType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bdtype = string;
        this.bdtypeDirtyFlag = true;
    }

    public String getBDType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBDType();
        }
        return this.bdtype;
    }

    public boolean isBDTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBDTypeDirty();
        }
        return this.bdtypeDirtyFlag;
    }

    public void resetBDType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBDType();
            return;
        }
        this.bdtypeDirtyFlag = false;
        this.bdtype = null;
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

    public void setInstState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstState(n);
            return;
        }
        this.inststate = n;
        this.inststateDirtyFlag = true;
    }

    public Integer getInstState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInstState();
        }
        return this.inststate;
    }

    public boolean isInstStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInstStateDirty();
        }
        return this.inststateDirtyFlag;
    }

    public void resetInstState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInstState();
            return;
        }
        this.inststateDirtyFlag = false;
        this.inststate = null;
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

    public void setParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param = string;
        this.paramDirtyFlag = true;
    }

    public String getParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam();
        }
        return this.param;
    }

    public boolean isParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamDirty();
        }
        return this.paramDirtyFlag;
    }

    public void resetParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam();
            return;
        }
        this.paramDirtyFlag = false;
        this.param = null;
    }

    public void setParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param2 = string;
        this.param2DirtyFlag = true;
    }

    public String getParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam2();
        }
        return this.param2;
    }

    public boolean isParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam2Dirty();
        }
        return this.param2DirtyFlag;
    }

    public void resetParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam2();
            return;
        }
        this.param2DirtyFlag = false;
        this.param2 = null;
    }

    public void setParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param3 = string;
        this.param3DirtyFlag = true;
    }

    public String getParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam3();
        }
        return this.param3;
    }

    public boolean isParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam3Dirty();
        }
        return this.param3DirtyFlag;
    }

    public void resetParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam3();
            return;
        }
        this.param3DirtyFlag = false;
        this.param3 = null;
    }

    public void setParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param4 = string;
        this.param4DirtyFlag = true;
    }

    public String getParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam4();
        }
        return this.param4;
    }

    public boolean isParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam4Dirty();
        }
        return this.param4DirtyFlag;
    }

    public void resetParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam4();
            return;
        }
        this.param4DirtyFlag = false;
        this.param4 = null;
    }

    public void setParam5(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam5(n);
            return;
        }
        this.param5 = n;
        this.param5DirtyFlag = true;
    }

    public Integer getParam5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam5();
        }
        return this.param5;
    }

    public boolean isParam5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam5Dirty();
        }
        return this.param5DirtyFlag;
    }

    public void resetParam5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam5();
            return;
        }
        this.param5DirtyFlag = false;
        this.param5 = null;
    }

    public void setParam6(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam6(n);
            return;
        }
        this.param6 = n;
        this.param6DirtyFlag = true;
    }

    public Integer getParam6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam6();
        }
        return this.param6;
    }

    public boolean isParam6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam6Dirty();
        }
        return this.param6DirtyFlag;
    }

    public void resetParam6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam6();
            return;
        }
        this.param6DirtyFlag = false;
        this.param6 = null;
    }

    public void setParam7(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam7(n);
            return;
        }
        this.param7 = n;
        this.param7DirtyFlag = true;
    }

    public Integer getParam7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam7();
        }
        return this.param7;
    }

    public boolean isParam7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam7Dirty();
        }
        return this.param7DirtyFlag;
    }

    public void resetParam7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam7();
            return;
        }
        this.param7DirtyFlag = false;
        this.param7 = null;
    }

    public void setParam8(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam8(n);
            return;
        }
        this.param8 = n;
        this.param8DirtyFlag = true;
    }

    public Integer getParam8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam8();
        }
        return this.param8;
    }

    public boolean isParam8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam8Dirty();
        }
        return this.param8DirtyFlag;
    }

    public void resetParam8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam8();
            return;
        }
        this.param8DirtyFlag = false;
        this.param8 = null;
    }

    public void setPSBDDevInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSBDDevInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psbddevinstid = string;
        this.psbddevinstidDirtyFlag = true;
    }

    public String getPSBDDevInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSBDDevInstId();
        }
        return this.psbddevinstid;
    }

    public boolean isPSBDDevInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSBDDevInstIdDirty();
        }
        return this.psbddevinstidDirtyFlag;
    }

    public void resetPSBDDevInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSBDDevInstId();
            return;
        }
        this.psbddevinstidDirtyFlag = false;
        this.psbddevinstid = null;
    }

    public void setPSBDDevInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSBDDevInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psbddevinstname = string;
        this.psbddevinstnameDirtyFlag = true;
    }

    public String getPSBDDevInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSBDDevInstName();
        }
        return this.psbddevinstname;
    }

    public boolean isPSBDDevInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSBDDevInstNameDirty();
        }
        return this.psbddevinstnameDirtyFlag;
    }

    public void resetPSBDDevInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSBDDevInstName();
            return;
        }
        this.psbddevinstnameDirtyFlag = false;
        this.psbddevinstname = null;
    }

    public void setPSBDServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSBDServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psbdserverid = string;
        this.psbdserveridDirtyFlag = true;
    }

    public String getPSBDServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSBDServerId();
        }
        return this.psbdserverid;
    }

    public boolean isPSBDServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSBDServerIdDirty();
        }
        return this.psbdserveridDirtyFlag;
    }

    public void resetPSBDServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSBDServerId();
            return;
        }
        this.psbdserveridDirtyFlag = false;
        this.psbdserverid = null;
    }

    public void setPSBDServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSBDServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psbdservername = string;
        this.psbdservernameDirtyFlag = true;
    }

    public String getPSBDServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSBDServerName();
        }
        return this.psbdservername;
    }

    public boolean isPSBDServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSBDServerNameDirty();
        }
        return this.psbdservernameDirtyFlag;
    }

    public void resetPSBDServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSBDServerName();
            return;
        }
        this.psbdservernameDirtyFlag = false;
        this.psbdservername = null;
    }

    public void setPSSvrDomainId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSvrDomainId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssvrdomainid = string;
        this.pssvrdomainidDirtyFlag = true;
    }

    public String getPSSvrDomainId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrDomainId();
        }
        return this.pssvrdomainid;
    }

    public boolean isPSSvrDomainIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSvrDomainIdDirty();
        }
        return this.pssvrdomainidDirtyFlag;
    }

    public void resetPSSvrDomainId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSvrDomainId();
            return;
        }
        this.pssvrdomainidDirtyFlag = false;
        this.pssvrdomainid = null;
    }

    public void setPSSvrDomainName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSvrDomainName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssvrdomainname = string;
        this.pssvrdomainnameDirtyFlag = true;
    }

    public String getPSSvrDomainName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrDomainName();
        }
        return this.pssvrdomainname;
    }

    public boolean isPSSvrDomainNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSvrDomainNameDirty();
        }
        return this.pssvrdomainnameDirtyFlag;
    }

    public void resetPSSvrDomainName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSvrDomainName();
            return;
        }
        this.pssvrdomainnameDirtyFlag = false;
        this.pssvrdomainname = null;
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
        PSBDDevInstBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSBDDevInstBase pSBDDevInstBase) {
        pSBDDevInstBase.resetBDType();
        pSBDDevInstBase.resetCreateDate();
        pSBDDevInstBase.resetCreateMan();
        pSBDDevInstBase.resetInstState();
        pSBDDevInstBase.resetMemo();
        pSBDDevInstBase.resetParam();
        pSBDDevInstBase.resetParam2();
        pSBDDevInstBase.resetParam3();
        pSBDDevInstBase.resetParam4();
        pSBDDevInstBase.resetParam5();
        pSBDDevInstBase.resetParam6();
        pSBDDevInstBase.resetParam7();
        pSBDDevInstBase.resetParam8();
        pSBDDevInstBase.resetPSBDDevInstId();
        pSBDDevInstBase.resetPSBDDevInstName();
        pSBDDevInstBase.resetPSBDServerId();
        pSBDDevInstBase.resetPSBDServerName();
        pSBDDevInstBase.resetPSSvrDomainId();
        pSBDDevInstBase.resetPSSvrDomainName();
        pSBDDevInstBase.resetUpdateDate();
        pSBDDevInstBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBDTypeDirty()) {
            hashMap.put(FIELD_BDTYPE, this.getBDType());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isInstStateDirty()) {
            hashMap.put(FIELD_INSTSTATE, this.getInstState());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isParamDirty()) {
            hashMap.put(FIELD_PARAM, this.getParam());
        }
        if (!bl || this.isParam2Dirty()) {
            hashMap.put(FIELD_PARAM2, this.getParam2());
        }
        if (!bl || this.isParam3Dirty()) {
            hashMap.put(FIELD_PARAM3, this.getParam3());
        }
        if (!bl || this.isParam4Dirty()) {
            hashMap.put(FIELD_PARAM4, this.getParam4());
        }
        if (!bl || this.isParam5Dirty()) {
            hashMap.put(FIELD_PARAM5, this.getParam5());
        }
        if (!bl || this.isParam6Dirty()) {
            hashMap.put(FIELD_PARAM6, this.getParam6());
        }
        if (!bl || this.isParam7Dirty()) {
            hashMap.put(FIELD_PARAM7, this.getParam7());
        }
        if (!bl || this.isParam8Dirty()) {
            hashMap.put(FIELD_PARAM8, this.getParam8());
        }
        if (!bl || this.isPSBDDevInstIdDirty()) {
            hashMap.put(FIELD_PSBDDEVINSTID, this.getPSBDDevInstId());
        }
        if (!bl || this.isPSBDDevInstNameDirty()) {
            hashMap.put(FIELD_PSBDDEVINSTNAME, this.getPSBDDevInstName());
        }
        if (!bl || this.isPSBDServerIdDirty()) {
            hashMap.put(FIELD_PSBDSERVERID, this.getPSBDServerId());
        }
        if (!bl || this.isPSBDServerNameDirty()) {
            hashMap.put(FIELD_PSBDSERVERNAME, this.getPSBDServerName());
        }
        if (!bl || this.isPSSvrDomainIdDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINID, this.getPSSvrDomainId());
        }
        if (!bl || this.isPSSvrDomainNameDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINNAME, this.getPSSvrDomainName());
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
        return PSBDDevInstBase.get(this, n);
    }

    private static Object get(PSBDDevInstBase pSBDDevInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSBDDevInstBase.getBDType();
            }
            case 1: {
                return pSBDDevInstBase.getCreateDate();
            }
            case 2: {
                return pSBDDevInstBase.getCreateMan();
            }
            case 3: {
                return pSBDDevInstBase.getInstState();
            }
            case 4: {
                return pSBDDevInstBase.getMemo();
            }
            case 5: {
                return pSBDDevInstBase.getParam();
            }
            case 6: {
                return pSBDDevInstBase.getParam2();
            }
            case 7: {
                return pSBDDevInstBase.getParam3();
            }
            case 8: {
                return pSBDDevInstBase.getParam4();
            }
            case 9: {
                return pSBDDevInstBase.getParam5();
            }
            case 10: {
                return pSBDDevInstBase.getParam6();
            }
            case 11: {
                return pSBDDevInstBase.getParam7();
            }
            case 12: {
                return pSBDDevInstBase.getParam8();
            }
            case 13: {
                return pSBDDevInstBase.getPSBDDevInstId();
            }
            case 14: {
                return pSBDDevInstBase.getPSBDDevInstName();
            }
            case 15: {
                return pSBDDevInstBase.getPSBDServerId();
            }
            case 16: {
                return pSBDDevInstBase.getPSBDServerName();
            }
            case 17: {
                return pSBDDevInstBase.getPSSvrDomainId();
            }
            case 18: {
                return pSBDDevInstBase.getPSSvrDomainName();
            }
            case 19: {
                return pSBDDevInstBase.getUpdateDate();
            }
            case 20: {
                return pSBDDevInstBase.getUpdateMan();
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
        PSBDDevInstBase.set(this, n, object);
    }

    private static void set(PSBDDevInstBase pSBDDevInstBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSBDDevInstBase.setBDType(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSBDDevInstBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSBDDevInstBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSBDDevInstBase.setInstState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSBDDevInstBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSBDDevInstBase.setParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSBDDevInstBase.setParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSBDDevInstBase.setParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSBDDevInstBase.setParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSBDDevInstBase.setParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSBDDevInstBase.setParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSBDDevInstBase.setParam7(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSBDDevInstBase.setParam8(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSBDDevInstBase.setPSBDDevInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSBDDevInstBase.setPSBDDevInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSBDDevInstBase.setPSBDServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSBDDevInstBase.setPSBDServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSBDDevInstBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSBDDevInstBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSBDDevInstBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSBDDevInstBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSBDDevInstBase.isNull(this, n);
    }

    private static boolean isNull(PSBDDevInstBase pSBDDevInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSBDDevInstBase.getBDType() == null;
            }
            case 1: {
                return pSBDDevInstBase.getCreateDate() == null;
            }
            case 2: {
                return pSBDDevInstBase.getCreateMan() == null;
            }
            case 3: {
                return pSBDDevInstBase.getInstState() == null;
            }
            case 4: {
                return pSBDDevInstBase.getMemo() == null;
            }
            case 5: {
                return pSBDDevInstBase.getParam() == null;
            }
            case 6: {
                return pSBDDevInstBase.getParam2() == null;
            }
            case 7: {
                return pSBDDevInstBase.getParam3() == null;
            }
            case 8: {
                return pSBDDevInstBase.getParam4() == null;
            }
            case 9: {
                return pSBDDevInstBase.getParam5() == null;
            }
            case 10: {
                return pSBDDevInstBase.getParam6() == null;
            }
            case 11: {
                return pSBDDevInstBase.getParam7() == null;
            }
            case 12: {
                return pSBDDevInstBase.getParam8() == null;
            }
            case 13: {
                return pSBDDevInstBase.getPSBDDevInstId() == null;
            }
            case 14: {
                return pSBDDevInstBase.getPSBDDevInstName() == null;
            }
            case 15: {
                return pSBDDevInstBase.getPSBDServerId() == null;
            }
            case 16: {
                return pSBDDevInstBase.getPSBDServerName() == null;
            }
            case 17: {
                return pSBDDevInstBase.getPSSvrDomainId() == null;
            }
            case 18: {
                return pSBDDevInstBase.getPSSvrDomainName() == null;
            }
            case 19: {
                return pSBDDevInstBase.getUpdateDate() == null;
            }
            case 20: {
                return pSBDDevInstBase.getUpdateMan() == null;
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
        return PSBDDevInstBase.contains(this, n);
    }

    private static boolean contains(PSBDDevInstBase pSBDDevInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSBDDevInstBase.isBDTypeDirty();
            }
            case 1: {
                return pSBDDevInstBase.isCreateDateDirty();
            }
            case 2: {
                return pSBDDevInstBase.isCreateManDirty();
            }
            case 3: {
                return pSBDDevInstBase.isInstStateDirty();
            }
            case 4: {
                return pSBDDevInstBase.isMemoDirty();
            }
            case 5: {
                return pSBDDevInstBase.isParamDirty();
            }
            case 6: {
                return pSBDDevInstBase.isParam2Dirty();
            }
            case 7: {
                return pSBDDevInstBase.isParam3Dirty();
            }
            case 8: {
                return pSBDDevInstBase.isParam4Dirty();
            }
            case 9: {
                return pSBDDevInstBase.isParam5Dirty();
            }
            case 10: {
                return pSBDDevInstBase.isParam6Dirty();
            }
            case 11: {
                return pSBDDevInstBase.isParam7Dirty();
            }
            case 12: {
                return pSBDDevInstBase.isParam8Dirty();
            }
            case 13: {
                return pSBDDevInstBase.isPSBDDevInstIdDirty();
            }
            case 14: {
                return pSBDDevInstBase.isPSBDDevInstNameDirty();
            }
            case 15: {
                return pSBDDevInstBase.isPSBDServerIdDirty();
            }
            case 16: {
                return pSBDDevInstBase.isPSBDServerNameDirty();
            }
            case 17: {
                return pSBDDevInstBase.isPSSvrDomainIdDirty();
            }
            case 18: {
                return pSBDDevInstBase.isPSSvrDomainNameDirty();
            }
            case 19: {
                return pSBDDevInstBase.isUpdateDateDirty();
            }
            case 20: {
                return pSBDDevInstBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSBDDevInstBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSBDDevInstBase pSBDDevInstBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSBDDevInstBase.getBDType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bdtype", (Object)PSBDDevInstBase.getJSONValue((Object)pSBDDevInstBase.getBDType()), (boolean)false);
        }
        if (bl || pSBDDevInstBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSBDDevInstBase.getJSONValue((Object)pSBDDevInstBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSBDDevInstBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSBDDevInstBase.getJSONValue((Object)pSBDDevInstBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSBDDevInstBase.getInstState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inststate", (Object)PSBDDevInstBase.getJSONValue((Object)pSBDDevInstBase.getInstState()), (boolean)false);
        }
        if (bl || pSBDDevInstBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSBDDevInstBase.getJSONValue((Object)pSBDDevInstBase.getMemo()), (boolean)false);
        }
        if (bl || pSBDDevInstBase.getParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param", (Object)PSBDDevInstBase.getJSONValue((Object)pSBDDevInstBase.getParam()), (boolean)false);
        }
        if (bl || pSBDDevInstBase.getParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param2", (Object)PSBDDevInstBase.getJSONValue((Object)pSBDDevInstBase.getParam2()), (boolean)false);
        }
        if (bl || pSBDDevInstBase.getParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param3", (Object)PSBDDevInstBase.getJSONValue((Object)pSBDDevInstBase.getParam3()), (boolean)false);
        }
        if (bl || pSBDDevInstBase.getParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param4", (Object)PSBDDevInstBase.getJSONValue((Object)pSBDDevInstBase.getParam4()), (boolean)false);
        }
        if (bl || pSBDDevInstBase.getParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param5", (Object)PSBDDevInstBase.getJSONValue((Object)pSBDDevInstBase.getParam5()), (boolean)false);
        }
        if (bl || pSBDDevInstBase.getParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param6", (Object)PSBDDevInstBase.getJSONValue((Object)pSBDDevInstBase.getParam6()), (boolean)false);
        }
        if (bl || pSBDDevInstBase.getParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param7", (Object)PSBDDevInstBase.getJSONValue((Object)pSBDDevInstBase.getParam7()), (boolean)false);
        }
        if (bl || pSBDDevInstBase.getParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param8", (Object)PSBDDevInstBase.getJSONValue((Object)pSBDDevInstBase.getParam8()), (boolean)false);
        }
        if (bl || pSBDDevInstBase.getPSBDDevInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psbddevinstid", (Object)PSBDDevInstBase.getJSONValue((Object)pSBDDevInstBase.getPSBDDevInstId()), (boolean)false);
        }
        if (bl || pSBDDevInstBase.getPSBDDevInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psbddevinstname", (Object)PSBDDevInstBase.getJSONValue((Object)pSBDDevInstBase.getPSBDDevInstName()), (boolean)false);
        }
        if (bl || pSBDDevInstBase.getPSBDServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psbdserverid", (Object)PSBDDevInstBase.getJSONValue((Object)pSBDDevInstBase.getPSBDServerId()), (boolean)false);
        }
        if (bl || pSBDDevInstBase.getPSBDServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psbdservername", (Object)PSBDDevInstBase.getJSONValue((Object)pSBDDevInstBase.getPSBDServerName()), (boolean)false);
        }
        if (bl || pSBDDevInstBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSBDDevInstBase.getJSONValue((Object)pSBDDevInstBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSBDDevInstBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSBDDevInstBase.getJSONValue((Object)pSBDDevInstBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSBDDevInstBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSBDDevInstBase.getJSONValue((Object)pSBDDevInstBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSBDDevInstBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSBDDevInstBase.getJSONValue((Object)pSBDDevInstBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSBDDevInstBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSBDDevInstBase pSBDDevInstBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSBDDevInstBase.getBDType() != null) {
            object = pSBDDevInstBase.getBDType();
            xmlNode.setAttribute(FIELD_BDTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSBDDevInstBase.getCreateDate() != null) {
            object = pSBDDevInstBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSBDDevInstBase.getCreateMan() != null) {
            object = pSBDDevInstBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSBDDevInstBase.getInstState() != null) {
            object = pSBDDevInstBase.getInstState();
            xmlNode.setAttribute(FIELD_INSTSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSBDDevInstBase.getMemo() != null) {
            object = pSBDDevInstBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSBDDevInstBase.getParam() != null) {
            object = pSBDDevInstBase.getParam();
            xmlNode.setAttribute(FIELD_PARAM, object == null ? "" : (String)object);
        }
        if (bl || pSBDDevInstBase.getParam2() != null) {
            object = pSBDDevInstBase.getParam2();
            xmlNode.setAttribute(FIELD_PARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSBDDevInstBase.getParam3() != null) {
            object = pSBDDevInstBase.getParam3();
            xmlNode.setAttribute(FIELD_PARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSBDDevInstBase.getParam4() != null) {
            object = pSBDDevInstBase.getParam4();
            xmlNode.setAttribute(FIELD_PARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSBDDevInstBase.getParam5() != null) {
            object = pSBDDevInstBase.getParam5();
            xmlNode.setAttribute(FIELD_PARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSBDDevInstBase.getParam6() != null) {
            object = pSBDDevInstBase.getParam6();
            xmlNode.setAttribute(FIELD_PARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSBDDevInstBase.getParam7() != null) {
            object = pSBDDevInstBase.getParam7();
            xmlNode.setAttribute(FIELD_PARAM7, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSBDDevInstBase.getParam8() != null) {
            object = pSBDDevInstBase.getParam8();
            xmlNode.setAttribute(FIELD_PARAM8, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSBDDevInstBase.getPSBDDevInstId() != null) {
            object = pSBDDevInstBase.getPSBDDevInstId();
            xmlNode.setAttribute(FIELD_PSBDDEVINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSBDDevInstBase.getPSBDDevInstName() != null) {
            object = pSBDDevInstBase.getPSBDDevInstName();
            xmlNode.setAttribute(FIELD_PSBDDEVINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSBDDevInstBase.getPSBDServerId() != null) {
            object = pSBDDevInstBase.getPSBDServerId();
            xmlNode.setAttribute(FIELD_PSBDSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSBDDevInstBase.getPSBDServerName() != null) {
            object = pSBDDevInstBase.getPSBDServerName();
            xmlNode.setAttribute(FIELD_PSBDSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSBDDevInstBase.getPSSvrDomainId() != null) {
            object = pSBDDevInstBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSBDDevInstBase.getPSSvrDomainName() != null) {
            object = pSBDDevInstBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSBDDevInstBase.getUpdateDate() != null) {
            object = pSBDDevInstBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSBDDevInstBase.getUpdateMan() != null) {
            object = pSBDDevInstBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSBDDevInstBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSBDDevInstBase pSBDDevInstBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSBDDevInstBase.isBDTypeDirty() && (bl || pSBDDevInstBase.getBDType() != null)) {
            iDataObject.set(FIELD_BDTYPE, (Object)pSBDDevInstBase.getBDType());
        }
        if (pSBDDevInstBase.isCreateDateDirty() && (bl || pSBDDevInstBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSBDDevInstBase.getCreateDate());
        }
        if (pSBDDevInstBase.isCreateManDirty() && (bl || pSBDDevInstBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSBDDevInstBase.getCreateMan());
        }
        if (pSBDDevInstBase.isInstStateDirty() && (bl || pSBDDevInstBase.getInstState() != null)) {
            iDataObject.set(FIELD_INSTSTATE, (Object)pSBDDevInstBase.getInstState());
        }
        if (pSBDDevInstBase.isMemoDirty() && (bl || pSBDDevInstBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSBDDevInstBase.getMemo());
        }
        if (pSBDDevInstBase.isParamDirty() && (bl || pSBDDevInstBase.getParam() != null)) {
            iDataObject.set(FIELD_PARAM, (Object)pSBDDevInstBase.getParam());
        }
        if (pSBDDevInstBase.isParam2Dirty() && (bl || pSBDDevInstBase.getParam2() != null)) {
            iDataObject.set(FIELD_PARAM2, (Object)pSBDDevInstBase.getParam2());
        }
        if (pSBDDevInstBase.isParam3Dirty() && (bl || pSBDDevInstBase.getParam3() != null)) {
            iDataObject.set(FIELD_PARAM3, (Object)pSBDDevInstBase.getParam3());
        }
        if (pSBDDevInstBase.isParam4Dirty() && (bl || pSBDDevInstBase.getParam4() != null)) {
            iDataObject.set(FIELD_PARAM4, (Object)pSBDDevInstBase.getParam4());
        }
        if (pSBDDevInstBase.isParam5Dirty() && (bl || pSBDDevInstBase.getParam5() != null)) {
            iDataObject.set(FIELD_PARAM5, (Object)pSBDDevInstBase.getParam5());
        }
        if (pSBDDevInstBase.isParam6Dirty() && (bl || pSBDDevInstBase.getParam6() != null)) {
            iDataObject.set(FIELD_PARAM6, (Object)pSBDDevInstBase.getParam6());
        }
        if (pSBDDevInstBase.isParam7Dirty() && (bl || pSBDDevInstBase.getParam7() != null)) {
            iDataObject.set(FIELD_PARAM7, (Object)pSBDDevInstBase.getParam7());
        }
        if (pSBDDevInstBase.isParam8Dirty() && (bl || pSBDDevInstBase.getParam8() != null)) {
            iDataObject.set(FIELD_PARAM8, (Object)pSBDDevInstBase.getParam8());
        }
        if (pSBDDevInstBase.isPSBDDevInstIdDirty() && (bl || pSBDDevInstBase.getPSBDDevInstId() != null)) {
            iDataObject.set(FIELD_PSBDDEVINSTID, (Object)pSBDDevInstBase.getPSBDDevInstId());
        }
        if (pSBDDevInstBase.isPSBDDevInstNameDirty() && (bl || pSBDDevInstBase.getPSBDDevInstName() != null)) {
            iDataObject.set(FIELD_PSBDDEVINSTNAME, (Object)pSBDDevInstBase.getPSBDDevInstName());
        }
        if (pSBDDevInstBase.isPSBDServerIdDirty() && (bl || pSBDDevInstBase.getPSBDServerId() != null)) {
            iDataObject.set(FIELD_PSBDSERVERID, (Object)pSBDDevInstBase.getPSBDServerId());
        }
        if (pSBDDevInstBase.isPSBDServerNameDirty() && (bl || pSBDDevInstBase.getPSBDServerName() != null)) {
            iDataObject.set(FIELD_PSBDSERVERNAME, (Object)pSBDDevInstBase.getPSBDServerName());
        }
        if (pSBDDevInstBase.isPSSvrDomainIdDirty() && (bl || pSBDDevInstBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSBDDevInstBase.getPSSvrDomainId());
        }
        if (pSBDDevInstBase.isPSSvrDomainNameDirty() && (bl || pSBDDevInstBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSBDDevInstBase.getPSSvrDomainName());
        }
        if (pSBDDevInstBase.isUpdateDateDirty() && (bl || pSBDDevInstBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSBDDevInstBase.getUpdateDate());
        }
        if (pSBDDevInstBase.isUpdateManDirty() && (bl || pSBDDevInstBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSBDDevInstBase.getUpdateMan());
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
        return PSBDDevInstBase.remove(this, n);
    }

    private static boolean remove(PSBDDevInstBase pSBDDevInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSBDDevInstBase.resetBDType();
                return true;
            }
            case 1: {
                pSBDDevInstBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSBDDevInstBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSBDDevInstBase.resetInstState();
                return true;
            }
            case 4: {
                pSBDDevInstBase.resetMemo();
                return true;
            }
            case 5: {
                pSBDDevInstBase.resetParam();
                return true;
            }
            case 6: {
                pSBDDevInstBase.resetParam2();
                return true;
            }
            case 7: {
                pSBDDevInstBase.resetParam3();
                return true;
            }
            case 8: {
                pSBDDevInstBase.resetParam4();
                return true;
            }
            case 9: {
                pSBDDevInstBase.resetParam5();
                return true;
            }
            case 10: {
                pSBDDevInstBase.resetParam6();
                return true;
            }
            case 11: {
                pSBDDevInstBase.resetParam7();
                return true;
            }
            case 12: {
                pSBDDevInstBase.resetParam8();
                return true;
            }
            case 13: {
                pSBDDevInstBase.resetPSBDDevInstId();
                return true;
            }
            case 14: {
                pSBDDevInstBase.resetPSBDDevInstName();
                return true;
            }
            case 15: {
                pSBDDevInstBase.resetPSBDServerId();
                return true;
            }
            case 16: {
                pSBDDevInstBase.resetPSBDServerName();
                return true;
            }
            case 17: {
                pSBDDevInstBase.resetPSSvrDomainId();
                return true;
            }
            case 18: {
                pSBDDevInstBase.resetPSSvrDomainName();
                return true;
            }
            case 19: {
                pSBDDevInstBase.resetUpdateDate();
                return true;
            }
            case 20: {
                pSBDDevInstBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSBDServer getPSBDServer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSBDServer();
        }
        if (this.getPSBDServerId() == null) {
            return null;
        }
        Integer n = this.objPSBDServerLock;
        synchronized (n) {
            if (this.psbdserver != null && DataTypeHelper.compare((int)25, (Object)this.getPSBDServerId(), (Object)this.psbdserver.getPSBDServerId()) != 0L) {
                this.psbdserver = null;
            }
            if (this.psbdserver == null) {
                PSBDServer pSBDServer = new PSBDServer();
                pSBDServer.setPSBDServerId(this.getPSBDServerId());
                PSBDServerService pSBDServerService = (PSBDServerService)ServiceGlobal.getService(PSBDServerService.class, (SessionFactory)this.getSessionFactory());
                pSBDServerService.autoGet((IEntity)pSBDServer);
                this.psbdserver = pSBDServer;
            }
            return this.psbdserver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSvrDomain getPSSvrDomain() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrDomain();
        }
        if (this.getPSSvrDomainId() == null) {
            return null;
        }
        Integer n = this.objPSSvrDomainLock;
        synchronized (n) {
            if (this.pssvrdomain != null && DataTypeHelper.compare((int)25, (Object)this.getPSSvrDomainId(), (Object)this.pssvrdomain.getPSSvrDomainId()) != 0L) {
                this.pssvrdomain = null;
            }
            if (this.pssvrdomain == null) {
                PSSvrDomain pSSvrDomain = new PSSvrDomain();
                pSSvrDomain.setPSSvrDomainId(this.getPSSvrDomainId());
                PSSvrDomainService pSSvrDomainService = (PSSvrDomainService)ServiceGlobal.getService(PSSvrDomainService.class, (SessionFactory)this.getSessionFactory());
                pSSvrDomainService.autoGet((IEntity)pSSvrDomain);
                this.pssvrdomain = pSSvrDomain;
            }
            return this.pssvrdomain;
        }
    }

    private PSBDDevInstBase getProxyEntity() {
        return this.proxyPSBDDevInstBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSBDDevInstBase = null;
        if (iDataObject != null && iDataObject instanceof PSBDDevInstBase) {
            this.proxyPSBDDevInstBase = (PSBDDevInstBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSBDDevInstService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BDTYPE, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_INSTSTATE, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PARAM, 5);
        fieldIndexMap.put(FIELD_PARAM2, 6);
        fieldIndexMap.put(FIELD_PARAM3, 7);
        fieldIndexMap.put(FIELD_PARAM4, 8);
        fieldIndexMap.put(FIELD_PARAM5, 9);
        fieldIndexMap.put(FIELD_PARAM6, 10);
        fieldIndexMap.put(FIELD_PARAM7, 11);
        fieldIndexMap.put(FIELD_PARAM8, 12);
        fieldIndexMap.put(FIELD_PSBDDEVINSTID, 13);
        fieldIndexMap.put(FIELD_PSBDDEVINSTNAME, 14);
        fieldIndexMap.put(FIELD_PSBDSERVERID, 15);
        fieldIndexMap.put(FIELD_PSBDSERVERNAME, 16);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 17);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 18);
        fieldIndexMap.put(FIELD_UPDATEDATE, 19);
        fieldIndexMap.put(FIELD_UPDATEMAN, 20);
    }
}

