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
package net.ibizsys.pscore.srv.sysdeploy.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSysRes;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSysResService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSln;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysVer;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysVerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnPrdBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDepSlnPrdBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENADYNAMICMODE = "ENADYNAMICMODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PRDTYPE = "PRDTYPE";
    public static final String FIELD_PSDCSYSRESID = "PSDCSYSRESID";
    public static final String FIELD_PSDCSYSRESNAME = "PSDCSYSRESNAME";
    public static final String FIELD_PSDEPSLNID = "PSDEPSLNID";
    public static final String FIELD_PSDEPSLNNAME = "PSDEPSLNNAME";
    public static final String FIELD_PSDEPSLNPRDID = "PSDEPSLNPRDID";
    public static final String FIELD_PSDEPSLNPRDNAME = "PSDEPSLNPRDNAME";
    public static final String FIELD_PSDEVSLNSYSVERID = "PSDEVSLNSYSVERID";
    public static final String FIELD_PSDEVSLNSYSVERNAME = "PSDEVSLNSYSVERNAME";
    public static final String FIELD_PSSYSMODELINSTID = "PSSYSMODELINSTID";
    public static final String FIELD_PSSYSMODELINSTNAME = "PSSYSMODELINSTNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ENADYNAMICMODE = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PRDTYPE = 4;
    private static final int INDEX_PSDCSYSRESID = 5;
    private static final int INDEX_PSDCSYSRESNAME = 6;
    private static final int INDEX_PSDEPSLNID = 7;
    private static final int INDEX_PSDEPSLNNAME = 8;
    private static final int INDEX_PSDEPSLNPRDID = 9;
    private static final int INDEX_PSDEPSLNPRDNAME = 10;
    private static final int INDEX_PSDEVSLNSYSVERID = 11;
    private static final int INDEX_PSDEVSLNSYSVERNAME = 12;
    private static final int INDEX_PSSYSMODELINSTID = 13;
    private static final int INDEX_PSSYSMODELINSTNAME = 14;
    private static final int INDEX_UPDATEDATE = 15;
    private static final int INDEX_UPDATEMAN = 16;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDepSlnPrdBase proxyPSDepSlnPrdBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean enadynamicmodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean prdtypeDirtyFlag = false;
    private boolean psdcsysresidDirtyFlag = false;
    private boolean psdcsysresnameDirtyFlag = false;
    private boolean psdepslnidDirtyFlag = false;
    private boolean psdepslnnameDirtyFlag = false;
    private boolean psdepslnprdidDirtyFlag = false;
    private boolean psdepslnprdnameDirtyFlag = false;
    private boolean psdevslnsysveridDirtyFlag = false;
    private boolean psdevslnsysvernameDirtyFlag = false;
    private boolean pssysmodelinstidDirtyFlag = false;
    private boolean pssysmodelinstnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="enadynamicmode")
    private Integer enadynamicmode;
    @Column(name="memo")
    private String memo;
    @Column(name="prdtype")
    private String prdtype;
    @Column(name="psdcsysresid")
    private String psdcsysresid;
    @Column(name="psdcsysresname")
    private String psdcsysresname;
    @Column(name="psdepslnid")
    private String psdepslnid;
    @Column(name="psdepslnname")
    private String psdepslnname;
    @Column(name="psdepslnprdid")
    private String psdepslnprdid;
    @Column(name="psdepslnprdname")
    private String psdepslnprdname;
    @Column(name="psdevslnsysverid")
    private String psdevslnsysverid;
    @Column(name="psdevslnsysvername")
    private String psdevslnsysvername;
    @Column(name="pssysmodelinstid")
    private String pssysmodelinstid;
    @Column(name="pssysmodelinstname")
    private String pssysmodelinstname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDCSysResLock = new Integer(1);
    private PSDCSysRes psdcsysres = null;
    private Integer objPSDepSlnLock = new Integer(1);
    private PSDepSln psdepsln = null;
    private Integer objPSDevSlnSysVerLock = new Integer(1);
    private PSDevSlnSysVer psdevslnsysver = null;
    private Integer objPSSysModelInstLock = new Integer(1);
    private PSSysModelInst pssysmodelinst = null;

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

    public void setEnaDynamicMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnaDynamicMode(n);
            return;
        }
        this.enadynamicmode = n;
        this.enadynamicmodeDirtyFlag = true;
    }

    public Integer getEnaDynamicMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnaDynamicMode();
        }
        return this.enadynamicmode;
    }

    public boolean isEnaDynamicModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnaDynamicModeDirty();
        }
        return this.enadynamicmodeDirtyFlag;
    }

    public void resetEnaDynamicMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnaDynamicMode();
            return;
        }
        this.enadynamicmodeDirtyFlag = false;
        this.enadynamicmode = null;
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

    public void setPrdType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrdType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.prdtype = string;
        this.prdtypeDirtyFlag = true;
    }

    public String getPrdType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrdType();
        }
        return this.prdtype;
    }

    public boolean isPrdTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrdTypeDirty();
        }
        return this.prdtypeDirtyFlag;
    }

    public void resetPrdType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrdType();
            return;
        }
        this.prdtypeDirtyFlag = false;
        this.prdtype = null;
    }

    public void setPSDCSysResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCSysResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcsysresid = string;
        this.psdcsysresidDirtyFlag = true;
    }

    public String getPSDCSysResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSysResId();
        }
        return this.psdcsysresid;
    }

    public boolean isPSDCSysResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCSysResIdDirty();
        }
        return this.psdcsysresidDirtyFlag;
    }

    public void resetPSDCSysResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCSysResId();
            return;
        }
        this.psdcsysresidDirtyFlag = false;
        this.psdcsysresid = null;
    }

    public void setPSDCSysResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCSysResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcsysresname = string;
        this.psdcsysresnameDirtyFlag = true;
    }

    public String getPSDCSysResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSysResName();
        }
        return this.psdcsysresname;
    }

    public boolean isPSDCSysResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCSysResNameDirty();
        }
        return this.psdcsysresnameDirtyFlag;
    }

    public void resetPSDCSysResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCSysResName();
            return;
        }
        this.psdcsysresnameDirtyFlag = false;
        this.psdcsysresname = null;
    }

    public void setPSDepSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnid = string;
        this.psdepslnidDirtyFlag = true;
    }

    public String getPSDepSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnId();
        }
        return this.psdepslnid;
    }

    public boolean isPSDepSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnIdDirty();
        }
        return this.psdepslnidDirtyFlag;
    }

    public void resetPSDepSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnId();
            return;
        }
        this.psdepslnidDirtyFlag = false;
        this.psdepslnid = null;
    }

    public void setPSDepSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnname = string;
        this.psdepslnnameDirtyFlag = true;
    }

    public String getPSDepSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnName();
        }
        return this.psdepslnname;
    }

    public boolean isPSDepSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnNameDirty();
        }
        return this.psdepslnnameDirtyFlag;
    }

    public void resetPSDepSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnName();
            return;
        }
        this.psdepslnnameDirtyFlag = false;
        this.psdepslnname = null;
    }

    public void setPSDepSlnPrdId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnPrdId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnprdid = string;
        this.psdepslnprdidDirtyFlag = true;
    }

    public String getPSDepSlnPrdId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnPrdId();
        }
        return this.psdepslnprdid;
    }

    public boolean isPSDepSlnPrdIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnPrdIdDirty();
        }
        return this.psdepslnprdidDirtyFlag;
    }

    public void resetPSDepSlnPrdId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnPrdId();
            return;
        }
        this.psdepslnprdidDirtyFlag = false;
        this.psdepslnprdid = null;
    }

    public void setPSDepSlnPrdName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnPrdName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnprdname = string;
        this.psdepslnprdnameDirtyFlag = true;
    }

    public String getPSDepSlnPrdName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnPrdName();
        }
        return this.psdepslnprdname;
    }

    public boolean isPSDepSlnPrdNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnPrdNameDirty();
        }
        return this.psdepslnprdnameDirtyFlag;
    }

    public void resetPSDepSlnPrdName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnPrdName();
            return;
        }
        this.psdepslnprdnameDirtyFlag = false;
        this.psdepslnprdname = null;
    }

    public void setPSDevSlnSysVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysverid = string;
        this.psdevslnsysveridDirtyFlag = true;
    }

    public String getPSDevSlnSysVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysVerId();
        }
        return this.psdevslnsysverid;
    }

    public boolean isPSDevSlnSysVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysVerIdDirty();
        }
        return this.psdevslnsysveridDirtyFlag;
    }

    public void resetPSDevSlnSysVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysVerId();
            return;
        }
        this.psdevslnsysveridDirtyFlag = false;
        this.psdevslnsysverid = null;
    }

    public void setPSDevSlnSysVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysvername = string;
        this.psdevslnsysvernameDirtyFlag = true;
    }

    public String getPSDevSlnSysVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysVerName();
        }
        return this.psdevslnsysvername;
    }

    public boolean isPSDevSlnSysVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysVerNameDirty();
        }
        return this.psdevslnsysvernameDirtyFlag;
    }

    public void resetPSDevSlnSysVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysVerName();
            return;
        }
        this.psdevslnsysvernameDirtyFlag = false;
        this.psdevslnsysvername = null;
    }

    public void setPSSysModelInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelinstid = string;
        this.pssysmodelinstidDirtyFlag = true;
    }

    public String getPSSysModelInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelInstId();
        }
        return this.pssysmodelinstid;
    }

    public boolean isPSSysModelInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelInstIdDirty();
        }
        return this.pssysmodelinstidDirtyFlag;
    }

    public void resetPSSysModelInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelInstId();
            return;
        }
        this.pssysmodelinstidDirtyFlag = false;
        this.pssysmodelinstid = null;
    }

    public void setPSSysModelInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelinstname = string;
        this.pssysmodelinstnameDirtyFlag = true;
    }

    public String getPSSysModelInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelInstName();
        }
        return this.pssysmodelinstname;
    }

    public boolean isPSSysModelInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelInstNameDirty();
        }
        return this.pssysmodelinstnameDirtyFlag;
    }

    public void resetPSSysModelInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelInstName();
            return;
        }
        this.pssysmodelinstnameDirtyFlag = false;
        this.pssysmodelinstname = null;
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
        PSDepSlnPrdBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDepSlnPrdBase pSDepSlnPrdBase) {
        pSDepSlnPrdBase.resetCreateDate();
        pSDepSlnPrdBase.resetCreateMan();
        pSDepSlnPrdBase.resetEnaDynamicMode();
        pSDepSlnPrdBase.resetMemo();
        pSDepSlnPrdBase.resetPrdType();
        pSDepSlnPrdBase.resetPSDCSysResId();
        pSDepSlnPrdBase.resetPSDCSysResName();
        pSDepSlnPrdBase.resetPSDepSlnId();
        pSDepSlnPrdBase.resetPSDepSlnName();
        pSDepSlnPrdBase.resetPSDepSlnPrdId();
        pSDepSlnPrdBase.resetPSDepSlnPrdName();
        pSDepSlnPrdBase.resetPSDevSlnSysVerId();
        pSDepSlnPrdBase.resetPSDevSlnSysVerName();
        pSDepSlnPrdBase.resetPSSysModelInstId();
        pSDepSlnPrdBase.resetPSSysModelInstName();
        pSDepSlnPrdBase.resetUpdateDate();
        pSDepSlnPrdBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEnaDynamicModeDirty()) {
            hashMap.put(FIELD_ENADYNAMICMODE, this.getEnaDynamicMode());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPrdTypeDirty()) {
            hashMap.put(FIELD_PRDTYPE, this.getPrdType());
        }
        if (!bl || this.isPSDCSysResIdDirty()) {
            hashMap.put(FIELD_PSDCSYSRESID, this.getPSDCSysResId());
        }
        if (!bl || this.isPSDCSysResNameDirty()) {
            hashMap.put(FIELD_PSDCSYSRESNAME, this.getPSDCSysResName());
        }
        if (!bl || this.isPSDepSlnIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNID, this.getPSDepSlnId());
        }
        if (!bl || this.isPSDepSlnNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNNAME, this.getPSDepSlnName());
        }
        if (!bl || this.isPSDepSlnPrdIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNPRDID, this.getPSDepSlnPrdId());
        }
        if (!bl || this.isPSDepSlnPrdNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNPRDNAME, this.getPSDepSlnPrdName());
        }
        if (!bl || this.isPSDevSlnSysVerIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSVERID, this.getPSDevSlnSysVerId());
        }
        if (!bl || this.isPSDevSlnSysVerNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSVERNAME, this.getPSDevSlnSysVerName());
        }
        if (!bl || this.isPSSysModelInstIdDirty()) {
            hashMap.put(FIELD_PSSYSMODELINSTID, this.getPSSysModelInstId());
        }
        if (!bl || this.isPSSysModelInstNameDirty()) {
            hashMap.put(FIELD_PSSYSMODELINSTNAME, this.getPSSysModelInstName());
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
        return PSDepSlnPrdBase.get(this, n);
    }

    private static Object get(PSDepSlnPrdBase pSDepSlnPrdBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnPrdBase.getCreateDate();
            }
            case 1: {
                return pSDepSlnPrdBase.getCreateMan();
            }
            case 2: {
                return pSDepSlnPrdBase.getEnaDynamicMode();
            }
            case 3: {
                return pSDepSlnPrdBase.getMemo();
            }
            case 4: {
                return pSDepSlnPrdBase.getPrdType();
            }
            case 5: {
                return pSDepSlnPrdBase.getPSDCSysResId();
            }
            case 6: {
                return pSDepSlnPrdBase.getPSDCSysResName();
            }
            case 7: {
                return pSDepSlnPrdBase.getPSDepSlnId();
            }
            case 8: {
                return pSDepSlnPrdBase.getPSDepSlnName();
            }
            case 9: {
                return pSDepSlnPrdBase.getPSDepSlnPrdId();
            }
            case 10: {
                return pSDepSlnPrdBase.getPSDepSlnPrdName();
            }
            case 11: {
                return pSDepSlnPrdBase.getPSDevSlnSysVerId();
            }
            case 12: {
                return pSDepSlnPrdBase.getPSDevSlnSysVerName();
            }
            case 13: {
                return pSDepSlnPrdBase.getPSSysModelInstId();
            }
            case 14: {
                return pSDepSlnPrdBase.getPSSysModelInstName();
            }
            case 15: {
                return pSDepSlnPrdBase.getUpdateDate();
            }
            case 16: {
                return pSDepSlnPrdBase.getUpdateMan();
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
        PSDepSlnPrdBase.set(this, n, object);
    }

    private static void set(PSDepSlnPrdBase pSDepSlnPrdBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnPrdBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDepSlnPrdBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDepSlnPrdBase.setEnaDynamicMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDepSlnPrdBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDepSlnPrdBase.setPrdType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDepSlnPrdBase.setPSDCSysResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDepSlnPrdBase.setPSDCSysResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDepSlnPrdBase.setPSDepSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDepSlnPrdBase.setPSDepSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDepSlnPrdBase.setPSDepSlnPrdId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDepSlnPrdBase.setPSDepSlnPrdName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDepSlnPrdBase.setPSDevSlnSysVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDepSlnPrdBase.setPSDevSlnSysVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDepSlnPrdBase.setPSSysModelInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDepSlnPrdBase.setPSSysModelInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDepSlnPrdBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 16: {
                pSDepSlnPrdBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDepSlnPrdBase.isNull(this, n);
    }

    private static boolean isNull(PSDepSlnPrdBase pSDepSlnPrdBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnPrdBase.getCreateDate() == null;
            }
            case 1: {
                return pSDepSlnPrdBase.getCreateMan() == null;
            }
            case 2: {
                return pSDepSlnPrdBase.getEnaDynamicMode() == null;
            }
            case 3: {
                return pSDepSlnPrdBase.getMemo() == null;
            }
            case 4: {
                return pSDepSlnPrdBase.getPrdType() == null;
            }
            case 5: {
                return pSDepSlnPrdBase.getPSDCSysResId() == null;
            }
            case 6: {
                return pSDepSlnPrdBase.getPSDCSysResName() == null;
            }
            case 7: {
                return pSDepSlnPrdBase.getPSDepSlnId() == null;
            }
            case 8: {
                return pSDepSlnPrdBase.getPSDepSlnName() == null;
            }
            case 9: {
                return pSDepSlnPrdBase.getPSDepSlnPrdId() == null;
            }
            case 10: {
                return pSDepSlnPrdBase.getPSDepSlnPrdName() == null;
            }
            case 11: {
                return pSDepSlnPrdBase.getPSDevSlnSysVerId() == null;
            }
            case 12: {
                return pSDepSlnPrdBase.getPSDevSlnSysVerName() == null;
            }
            case 13: {
                return pSDepSlnPrdBase.getPSSysModelInstId() == null;
            }
            case 14: {
                return pSDepSlnPrdBase.getPSSysModelInstName() == null;
            }
            case 15: {
                return pSDepSlnPrdBase.getUpdateDate() == null;
            }
            case 16: {
                return pSDepSlnPrdBase.getUpdateMan() == null;
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
        return PSDepSlnPrdBase.contains(this, n);
    }

    private static boolean contains(PSDepSlnPrdBase pSDepSlnPrdBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnPrdBase.isCreateDateDirty();
            }
            case 1: {
                return pSDepSlnPrdBase.isCreateManDirty();
            }
            case 2: {
                return pSDepSlnPrdBase.isEnaDynamicModeDirty();
            }
            case 3: {
                return pSDepSlnPrdBase.isMemoDirty();
            }
            case 4: {
                return pSDepSlnPrdBase.isPrdTypeDirty();
            }
            case 5: {
                return pSDepSlnPrdBase.isPSDCSysResIdDirty();
            }
            case 6: {
                return pSDepSlnPrdBase.isPSDCSysResNameDirty();
            }
            case 7: {
                return pSDepSlnPrdBase.isPSDepSlnIdDirty();
            }
            case 8: {
                return pSDepSlnPrdBase.isPSDepSlnNameDirty();
            }
            case 9: {
                return pSDepSlnPrdBase.isPSDepSlnPrdIdDirty();
            }
            case 10: {
                return pSDepSlnPrdBase.isPSDepSlnPrdNameDirty();
            }
            case 11: {
                return pSDepSlnPrdBase.isPSDevSlnSysVerIdDirty();
            }
            case 12: {
                return pSDepSlnPrdBase.isPSDevSlnSysVerNameDirty();
            }
            case 13: {
                return pSDepSlnPrdBase.isPSSysModelInstIdDirty();
            }
            case 14: {
                return pSDepSlnPrdBase.isPSSysModelInstNameDirty();
            }
            case 15: {
                return pSDepSlnPrdBase.isUpdateDateDirty();
            }
            case 16: {
                return pSDepSlnPrdBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDepSlnPrdBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDepSlnPrdBase pSDepSlnPrdBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDepSlnPrdBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDepSlnPrdBase.getJSONValue((Object)pSDepSlnPrdBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDepSlnPrdBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDepSlnPrdBase.getJSONValue((Object)pSDepSlnPrdBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDepSlnPrdBase.getEnaDynamicMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enadynamicmode", (Object)PSDepSlnPrdBase.getJSONValue((Object)pSDepSlnPrdBase.getEnaDynamicMode()), (boolean)false);
        }
        if (bl || pSDepSlnPrdBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDepSlnPrdBase.getJSONValue((Object)pSDepSlnPrdBase.getMemo()), (boolean)false);
        }
        if (bl || pSDepSlnPrdBase.getPrdType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"prdtype", (Object)PSDepSlnPrdBase.getJSONValue((Object)pSDepSlnPrdBase.getPrdType()), (boolean)false);
        }
        if (bl || pSDepSlnPrdBase.getPSDCSysResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcsysresid", (Object)PSDepSlnPrdBase.getJSONValue((Object)pSDepSlnPrdBase.getPSDCSysResId()), (boolean)false);
        }
        if (bl || pSDepSlnPrdBase.getPSDCSysResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcsysresname", (Object)PSDepSlnPrdBase.getJSONValue((Object)pSDepSlnPrdBase.getPSDCSysResName()), (boolean)false);
        }
        if (bl || pSDepSlnPrdBase.getPSDepSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnid", (Object)PSDepSlnPrdBase.getJSONValue((Object)pSDepSlnPrdBase.getPSDepSlnId()), (boolean)false);
        }
        if (bl || pSDepSlnPrdBase.getPSDepSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnname", (Object)PSDepSlnPrdBase.getJSONValue((Object)pSDepSlnPrdBase.getPSDepSlnName()), (boolean)false);
        }
        if (bl || pSDepSlnPrdBase.getPSDepSlnPrdId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnprdid", (Object)PSDepSlnPrdBase.getJSONValue((Object)pSDepSlnPrdBase.getPSDepSlnPrdId()), (boolean)false);
        }
        if (bl || pSDepSlnPrdBase.getPSDepSlnPrdName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnprdname", (Object)PSDepSlnPrdBase.getJSONValue((Object)pSDepSlnPrdBase.getPSDepSlnPrdName()), (boolean)false);
        }
        if (bl || pSDepSlnPrdBase.getPSDevSlnSysVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysverid", (Object)PSDepSlnPrdBase.getJSONValue((Object)pSDepSlnPrdBase.getPSDevSlnSysVerId()), (boolean)false);
        }
        if (bl || pSDepSlnPrdBase.getPSDevSlnSysVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysvername", (Object)PSDepSlnPrdBase.getJSONValue((Object)pSDepSlnPrdBase.getPSDevSlnSysVerName()), (boolean)false);
        }
        if (bl || pSDepSlnPrdBase.getPSSysModelInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelinstid", (Object)PSDepSlnPrdBase.getJSONValue((Object)pSDepSlnPrdBase.getPSSysModelInstId()), (boolean)false);
        }
        if (bl || pSDepSlnPrdBase.getPSSysModelInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelinstname", (Object)PSDepSlnPrdBase.getJSONValue((Object)pSDepSlnPrdBase.getPSSysModelInstName()), (boolean)false);
        }
        if (bl || pSDepSlnPrdBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDepSlnPrdBase.getJSONValue((Object)pSDepSlnPrdBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDepSlnPrdBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDepSlnPrdBase.getJSONValue((Object)pSDepSlnPrdBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDepSlnPrdBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDepSlnPrdBase pSDepSlnPrdBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDepSlnPrdBase.getCreateDate() != null) {
            object = pSDepSlnPrdBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnPrdBase.getCreateMan() != null) {
            object = pSDepSlnPrdBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnPrdBase.getEnaDynamicMode() != null) {
            object = pSDepSlnPrdBase.getEnaDynamicMode();
            xmlNode.setAttribute(FIELD_ENADYNAMICMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDepSlnPrdBase.getMemo() != null) {
            object = pSDepSlnPrdBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnPrdBase.getPrdType() != null) {
            object = pSDepSlnPrdBase.getPrdType();
            xmlNode.setAttribute(FIELD_PRDTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnPrdBase.getPSDCSysResId() != null) {
            object = pSDepSlnPrdBase.getPSDCSysResId();
            xmlNode.setAttribute(FIELD_PSDCSYSRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnPrdBase.getPSDCSysResName() != null) {
            object = pSDepSlnPrdBase.getPSDCSysResName();
            xmlNode.setAttribute(FIELD_PSDCSYSRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnPrdBase.getPSDepSlnId() != null) {
            object = pSDepSlnPrdBase.getPSDepSlnId();
            xmlNode.setAttribute(FIELD_PSDEPSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnPrdBase.getPSDepSlnName() != null) {
            object = pSDepSlnPrdBase.getPSDepSlnName();
            xmlNode.setAttribute(FIELD_PSDEPSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnPrdBase.getPSDepSlnPrdId() != null) {
            object = pSDepSlnPrdBase.getPSDepSlnPrdId();
            xmlNode.setAttribute(FIELD_PSDEPSLNPRDID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnPrdBase.getPSDepSlnPrdName() != null) {
            object = pSDepSlnPrdBase.getPSDepSlnPrdName();
            xmlNode.setAttribute(FIELD_PSDEPSLNPRDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnPrdBase.getPSDevSlnSysVerId() != null) {
            object = pSDepSlnPrdBase.getPSDevSlnSysVerId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnPrdBase.getPSDevSlnSysVerName() != null) {
            object = pSDepSlnPrdBase.getPSDevSlnSysVerName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnPrdBase.getPSSysModelInstId() != null) {
            object = pSDepSlnPrdBase.getPSSysModelInstId();
            xmlNode.setAttribute(FIELD_PSSYSMODELINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnPrdBase.getPSSysModelInstName() != null) {
            object = pSDepSlnPrdBase.getPSSysModelInstName();
            xmlNode.setAttribute(FIELD_PSSYSMODELINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnPrdBase.getUpdateDate() != null) {
            object = pSDepSlnPrdBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnPrdBase.getUpdateMan() != null) {
            object = pSDepSlnPrdBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDepSlnPrdBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDepSlnPrdBase pSDepSlnPrdBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDepSlnPrdBase.isCreateDateDirty() && (bl || pSDepSlnPrdBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDepSlnPrdBase.getCreateDate());
        }
        if (pSDepSlnPrdBase.isCreateManDirty() && (bl || pSDepSlnPrdBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDepSlnPrdBase.getCreateMan());
        }
        if (pSDepSlnPrdBase.isEnaDynamicModeDirty() && (bl || pSDepSlnPrdBase.getEnaDynamicMode() != null)) {
            iDataObject.set(FIELD_ENADYNAMICMODE, (Object)pSDepSlnPrdBase.getEnaDynamicMode());
        }
        if (pSDepSlnPrdBase.isMemoDirty() && (bl || pSDepSlnPrdBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDepSlnPrdBase.getMemo());
        }
        if (pSDepSlnPrdBase.isPrdTypeDirty() && (bl || pSDepSlnPrdBase.getPrdType() != null)) {
            iDataObject.set(FIELD_PRDTYPE, (Object)pSDepSlnPrdBase.getPrdType());
        }
        if (pSDepSlnPrdBase.isPSDCSysResIdDirty() && (bl || pSDepSlnPrdBase.getPSDCSysResId() != null)) {
            iDataObject.set(FIELD_PSDCSYSRESID, (Object)pSDepSlnPrdBase.getPSDCSysResId());
        }
        if (pSDepSlnPrdBase.isPSDCSysResNameDirty() && (bl || pSDepSlnPrdBase.getPSDCSysResName() != null)) {
            iDataObject.set(FIELD_PSDCSYSRESNAME, (Object)pSDepSlnPrdBase.getPSDCSysResName());
        }
        if (pSDepSlnPrdBase.isPSDepSlnIdDirty() && (bl || pSDepSlnPrdBase.getPSDepSlnId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNID, (Object)pSDepSlnPrdBase.getPSDepSlnId());
        }
        if (pSDepSlnPrdBase.isPSDepSlnNameDirty() && (bl || pSDepSlnPrdBase.getPSDepSlnName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNNAME, (Object)pSDepSlnPrdBase.getPSDepSlnName());
        }
        if (pSDepSlnPrdBase.isPSDepSlnPrdIdDirty() && (bl || pSDepSlnPrdBase.getPSDepSlnPrdId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNPRDID, (Object)pSDepSlnPrdBase.getPSDepSlnPrdId());
        }
        if (pSDepSlnPrdBase.isPSDepSlnPrdNameDirty() && (bl || pSDepSlnPrdBase.getPSDepSlnPrdName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNPRDNAME, (Object)pSDepSlnPrdBase.getPSDepSlnPrdName());
        }
        if (pSDepSlnPrdBase.isPSDevSlnSysVerIdDirty() && (bl || pSDepSlnPrdBase.getPSDevSlnSysVerId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSVERID, (Object)pSDepSlnPrdBase.getPSDevSlnSysVerId());
        }
        if (pSDepSlnPrdBase.isPSDevSlnSysVerNameDirty() && (bl || pSDepSlnPrdBase.getPSDevSlnSysVerName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSVERNAME, (Object)pSDepSlnPrdBase.getPSDevSlnSysVerName());
        }
        if (pSDepSlnPrdBase.isPSSysModelInstIdDirty() && (bl || pSDepSlnPrdBase.getPSSysModelInstId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELINSTID, (Object)pSDepSlnPrdBase.getPSSysModelInstId());
        }
        if (pSDepSlnPrdBase.isPSSysModelInstNameDirty() && (bl || pSDepSlnPrdBase.getPSSysModelInstName() != null)) {
            iDataObject.set(FIELD_PSSYSMODELINSTNAME, (Object)pSDepSlnPrdBase.getPSSysModelInstName());
        }
        if (pSDepSlnPrdBase.isUpdateDateDirty() && (bl || pSDepSlnPrdBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDepSlnPrdBase.getUpdateDate());
        }
        if (pSDepSlnPrdBase.isUpdateManDirty() && (bl || pSDepSlnPrdBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDepSlnPrdBase.getUpdateMan());
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
        return PSDepSlnPrdBase.remove(this, n);
    }

    private static boolean remove(PSDepSlnPrdBase pSDepSlnPrdBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnPrdBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDepSlnPrdBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDepSlnPrdBase.resetEnaDynamicMode();
                return true;
            }
            case 3: {
                pSDepSlnPrdBase.resetMemo();
                return true;
            }
            case 4: {
                pSDepSlnPrdBase.resetPrdType();
                return true;
            }
            case 5: {
                pSDepSlnPrdBase.resetPSDCSysResId();
                return true;
            }
            case 6: {
                pSDepSlnPrdBase.resetPSDCSysResName();
                return true;
            }
            case 7: {
                pSDepSlnPrdBase.resetPSDepSlnId();
                return true;
            }
            case 8: {
                pSDepSlnPrdBase.resetPSDepSlnName();
                return true;
            }
            case 9: {
                pSDepSlnPrdBase.resetPSDepSlnPrdId();
                return true;
            }
            case 10: {
                pSDepSlnPrdBase.resetPSDepSlnPrdName();
                return true;
            }
            case 11: {
                pSDepSlnPrdBase.resetPSDevSlnSysVerId();
                return true;
            }
            case 12: {
                pSDepSlnPrdBase.resetPSDevSlnSysVerName();
                return true;
            }
            case 13: {
                pSDepSlnPrdBase.resetPSSysModelInstId();
                return true;
            }
            case 14: {
                pSDepSlnPrdBase.resetPSSysModelInstName();
                return true;
            }
            case 15: {
                pSDepSlnPrdBase.resetUpdateDate();
                return true;
            }
            case 16: {
                pSDepSlnPrdBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCSysRes getPSDCSysRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSysRes();
        }
        if (this.getPSDCSysResId() == null) {
            return null;
        }
        Integer n = this.objPSDCSysResLock;
        synchronized (n) {
            if (this.psdcsysres != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCSysResId(), (Object)this.psdcsysres.getPSDCSysResId()) != 0L) {
                this.psdcsysres = null;
            }
            if (this.psdcsysres == null) {
                PSDCSysRes pSDCSysRes = new PSDCSysRes();
                pSDCSysRes.setPSDCSysResId(this.getPSDCSysResId());
                PSDCSysResService pSDCSysResService = (PSDCSysResService)ServiceGlobal.getService(PSDCSysResService.class, (SessionFactory)this.getSessionFactory());
                pSDCSysResService.autoGet((IEntity)pSDCSysRes);
                this.psdcsysres = pSDCSysRes;
            }
            return this.psdcsysres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSln getPSDepSln() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSln();
        }
        if (this.getPSDepSlnId() == null) {
            return null;
        }
        Integer n = this.objPSDepSlnLock;
        synchronized (n) {
            if (this.psdepsln != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSlnId(), (Object)this.psdepsln.getPSDepSlnId()) != 0L) {
                this.psdepsln = null;
            }
            if (this.psdepsln == null) {
                PSDepSln pSDepSln = new PSDepSln();
                pSDepSln.setPSDepSlnId(this.getPSDepSlnId());
                PSDepSlnService pSDepSlnService = (PSDepSlnService)ServiceGlobal.getService(PSDepSlnService.class, (SessionFactory)this.getSessionFactory());
                pSDepSlnService.autoGet((IEntity)pSDepSln);
                this.psdepsln = pSDepSln;
            }
            return this.psdepsln;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSysVer getPSDevSlnSysVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysVer();
        }
        if (this.getPSDevSlnSysVerId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysVerLock;
        synchronized (n) {
            if (this.psdevslnsysver != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysVerId(), (Object)this.psdevslnsysver.getPSDevSlnSysVerId()) != 0L) {
                this.psdevslnsysver = null;
            }
            if (this.psdevslnsysver == null) {
                PSDevSlnSysVer pSDevSlnSysVer = new PSDevSlnSysVer();
                pSDevSlnSysVer.setPSDevSlnSysVerId(this.getPSDevSlnSysVerId());
                PSDevSlnSysVerService pSDevSlnSysVerService = (PSDevSlnSysVerService)ServiceGlobal.getService(PSDevSlnSysVerService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysVerService.autoGet((IEntity)pSDevSlnSysVer);
                this.psdevslnsysver = pSDevSlnSysVer;
            }
            return this.psdevslnsysver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysModelInst getPSSysModelInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelInst();
        }
        if (this.getPSSysModelInstId() == null) {
            return null;
        }
        Integer n = this.objPSSysModelInstLock;
        synchronized (n) {
            if (this.pssysmodelinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysModelInstId(), (Object)this.pssysmodelinst.getPSSysModelInstId()) != 0L) {
                this.pssysmodelinst = null;
            }
            if (this.pssysmodelinst == null) {
                PSSysModelInst pSSysModelInst = new PSSysModelInst();
                pSSysModelInst.setPSSysModelInstId(this.getPSSysModelInstId());
                PSSysModelInstService pSSysModelInstService = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, (SessionFactory)this.getSessionFactory());
                pSSysModelInstService.autoGet((IEntity)pSSysModelInst);
                this.pssysmodelinst = pSSysModelInst;
            }
            return this.pssysmodelinst;
        }
    }

    private PSDepSlnPrdBase getProxyEntity() {
        return this.proxyPSDepSlnPrdBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDepSlnPrdBase = null;
        if (iDataObject != null && iDataObject instanceof PSDepSlnPrdBase) {
            this.proxyPSDepSlnPrdBase = (PSDepSlnPrdBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnPrdService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ENADYNAMICMODE, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PRDTYPE, 4);
        fieldIndexMap.put(FIELD_PSDCSYSRESID, 5);
        fieldIndexMap.put(FIELD_PSDCSYSRESNAME, 6);
        fieldIndexMap.put(FIELD_PSDEPSLNID, 7);
        fieldIndexMap.put(FIELD_PSDEPSLNNAME, 8);
        fieldIndexMap.put(FIELD_PSDEPSLNPRDID, 9);
        fieldIndexMap.put(FIELD_PSDEPSLNPRDNAME, 10);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSVERID, 11);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSVERNAME, 12);
        fieldIndexMap.put(FIELD_PSSYSMODELINSTID, 13);
        fieldIndexMap.put(FIELD_PSSYSMODELINSTNAME, 14);
        fieldIndexMap.put(FIELD_UPDATEDATE, 15);
        fieldIndexMap.put(FIELD_UPDATEMAN, 16);
    }
}

