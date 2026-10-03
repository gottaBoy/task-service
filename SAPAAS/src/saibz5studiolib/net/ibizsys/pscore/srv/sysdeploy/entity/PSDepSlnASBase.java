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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterAS;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASService;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSln;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnHost;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnHostService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnASBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDepSlnASBase.class);
    public static final String FIELD_ASTYPE = "ASTYPE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENABLELOCALMODE = "ENABLELOCALMODE";
    public static final String FIELD_ENABLEREMOTEMODE = "ENABLEREMOTEMODE";
    public static final String FIELD_HTTPPORT = "HTTPPORT";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEPSLNASID = "PSDEPSLNASID";
    public static final String FIELD_PSDEPSLNASNAME = "PSDEPSLNASNAME";
    public static final String FIELD_PSDEPSLNHOSTID = "PSDEPSLNHOSTID";
    public static final String FIELD_PSDEPSLNHOSTNAME = "PSDEPSLNHOSTNAME";
    public static final String FIELD_PSDEPSLNID = "PSDEPSLNID";
    public static final String FIELD_PSDEPSLNNAME = "PSDEPSLNNAME";
    public static final String FIELD_PSDEVCENTERASID = "PSDEVCENTERASID";
    public static final String FIELD_PSDEVCENTERASNAME = "PSDEVCENTERASNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_ASTYPE = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_ENABLELOCALMODE = 3;
    private static final int INDEX_ENABLEREMOTEMODE = 4;
    private static final int INDEX_HTTPPORT = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_PSDEPSLNASID = 7;
    private static final int INDEX_PSDEPSLNASNAME = 8;
    private static final int INDEX_PSDEPSLNHOSTID = 9;
    private static final int INDEX_PSDEPSLNHOSTNAME = 10;
    private static final int INDEX_PSDEPSLNID = 11;
    private static final int INDEX_PSDEPSLNNAME = 12;
    private static final int INDEX_PSDEVCENTERASID = 13;
    private static final int INDEX_PSDEVCENTERASNAME = 14;
    private static final int INDEX_UPDATEDATE = 15;
    private static final int INDEX_UPDATEMAN = 16;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDepSlnASBase proxyPSDepSlnASBase = null;
    private boolean astypeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean enablelocalmodeDirtyFlag = false;
    private boolean enableremotemodeDirtyFlag = false;
    private boolean httpportDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdepslnasidDirtyFlag = false;
    private boolean psdepslnasnameDirtyFlag = false;
    private boolean psdepslnhostidDirtyFlag = false;
    private boolean psdepslnhostnameDirtyFlag = false;
    private boolean psdepslnidDirtyFlag = false;
    private boolean psdepslnnameDirtyFlag = false;
    private boolean psdevcenterasidDirtyFlag = false;
    private boolean psdevcenterasnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="astype")
    private String astype;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="enablelocalmode")
    private Integer enablelocalmode;
    @Column(name="enableremotemode")
    private Integer enableremotemode;
    @Column(name="httpport")
    private Integer httpport;
    @Column(name="memo")
    private String memo;
    @Column(name="psdepslnasid")
    private String psdepslnasid;
    @Column(name="psdepslnasname")
    private String psdepslnasname;
    @Column(name="psdepslnhostid")
    private String psdepslnhostid;
    @Column(name="psdepslnhostname")
    private String psdepslnhostname;
    @Column(name="psdepslnid")
    private String psdepslnid;
    @Column(name="psdepslnname")
    private String psdepslnname;
    @Column(name="psdevcenterasid")
    private String psdevcenterasid;
    @Column(name="psdevcenterasname")
    private String psdevcenterasname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDepSlnHostLock = new Integer(1);
    private PSDepSlnHost psdepslnhost = null;
    private Integer objPSDepSlnLock = new Integer(1);
    private PSDepSln psdepsln = null;
    private Integer objPSDevcenterASLock = new Integer(1);
    private PSDevCenterAS psdevcenteras = null;

    public void setASType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setASType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.astype = string;
        this.astypeDirtyFlag = true;
    }

    public String getASType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getASType();
        }
        return this.astype;
    }

    public boolean isASTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isASTypeDirty();
        }
        return this.astypeDirtyFlag;
    }

    public void resetASType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetASType();
            return;
        }
        this.astypeDirtyFlag = false;
        this.astype = null;
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

    public void setEnableLocalMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableLocalMode(n);
            return;
        }
        this.enablelocalmode = n;
        this.enablelocalmodeDirtyFlag = true;
    }

    public Integer getEnableLocalMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableLocalMode();
        }
        return this.enablelocalmode;
    }

    public boolean isEnableLocalModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableLocalModeDirty();
        }
        return this.enablelocalmodeDirtyFlag;
    }

    public void resetEnableLocalMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableLocalMode();
            return;
        }
        this.enablelocalmodeDirtyFlag = false;
        this.enablelocalmode = null;
    }

    public void setEnableRemoteMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableRemoteMode(n);
            return;
        }
        this.enableremotemode = n;
        this.enableremotemodeDirtyFlag = true;
    }

    public Integer getEnableRemoteMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableRemoteMode();
        }
        return this.enableremotemode;
    }

    public boolean isEnableRemoteModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableRemoteModeDirty();
        }
        return this.enableremotemodeDirtyFlag;
    }

    public void resetEnableRemoteMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableRemoteMode();
            return;
        }
        this.enableremotemodeDirtyFlag = false;
        this.enableremotemode = null;
    }

    public void setHttpPort(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHttpPort(n);
            return;
        }
        this.httpport = n;
        this.httpportDirtyFlag = true;
    }

    public Integer getHttpPort() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHttpPort();
        }
        return this.httpport;
    }

    public boolean isHttpPortDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHttpPortDirty();
        }
        return this.httpportDirtyFlag;
    }

    public void resetHttpPort() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHttpPort();
            return;
        }
        this.httpportDirtyFlag = false;
        this.httpport = null;
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

    public void setPSDepSlnASId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnASId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnasid = string;
        this.psdepslnasidDirtyFlag = true;
    }

    public String getPSDepSlnASId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnASId();
        }
        return this.psdepslnasid;
    }

    public boolean isPSDepSlnASIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnASIdDirty();
        }
        return this.psdepslnasidDirtyFlag;
    }

    public void resetPSDepSlnASId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnASId();
            return;
        }
        this.psdepslnasidDirtyFlag = false;
        this.psdepslnasid = null;
    }

    public void setPSDepSlnASName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnASName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnasname = string;
        this.psdepslnasnameDirtyFlag = true;
    }

    public String getPSDepSlnASName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnASName();
        }
        return this.psdepslnasname;
    }

    public boolean isPSDepSlnASNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnASNameDirty();
        }
        return this.psdepslnasnameDirtyFlag;
    }

    public void resetPSDepSlnASName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnASName();
            return;
        }
        this.psdepslnasnameDirtyFlag = false;
        this.psdepslnasname = null;
    }

    public void setPSDepSlnHostId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnHostId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnhostid = string;
        this.psdepslnhostidDirtyFlag = true;
    }

    public String getPSDepSlnHostId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnHostId();
        }
        return this.psdepslnhostid;
    }

    public boolean isPSDepSlnHostIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnHostIdDirty();
        }
        return this.psdepslnhostidDirtyFlag;
    }

    public void resetPSDepSlnHostId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnHostId();
            return;
        }
        this.psdepslnhostidDirtyFlag = false;
        this.psdepslnhostid = null;
    }

    public void setPSDepSlnHostName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnHostName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnhostname = string;
        this.psdepslnhostnameDirtyFlag = true;
    }

    public String getPSDepSlnHostName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnHostName();
        }
        return this.psdepslnhostname;
    }

    public boolean isPSDepSlnHostNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnHostNameDirty();
        }
        return this.psdepslnhostnameDirtyFlag;
    }

    public void resetPSDepSlnHostName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnHostName();
            return;
        }
        this.psdepslnhostnameDirtyFlag = false;
        this.psdepslnhostname = null;
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

    public void setPSDevCenterASId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterASId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterasid = string;
        this.psdevcenterasidDirtyFlag = true;
    }

    public String getPSDevCenterASId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterASId();
        }
        return this.psdevcenterasid;
    }

    public boolean isPSDevCenterASIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterASIdDirty();
        }
        return this.psdevcenterasidDirtyFlag;
    }

    public void resetPSDevCenterASId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterASId();
            return;
        }
        this.psdevcenterasidDirtyFlag = false;
        this.psdevcenterasid = null;
    }

    public void setPSDevCenterASName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterASName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterasname = string;
        this.psdevcenterasnameDirtyFlag = true;
    }

    public String getPSDevCenterASName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterASName();
        }
        return this.psdevcenterasname;
    }

    public boolean isPSDevCenterASNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterASNameDirty();
        }
        return this.psdevcenterasnameDirtyFlag;
    }

    public void resetPSDevCenterASName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterASName();
            return;
        }
        this.psdevcenterasnameDirtyFlag = false;
        this.psdevcenterasname = null;
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
        PSDepSlnASBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDepSlnASBase pSDepSlnASBase) {
        pSDepSlnASBase.resetASType();
        pSDepSlnASBase.resetCreateDate();
        pSDepSlnASBase.resetCreateMan();
        pSDepSlnASBase.resetEnableLocalMode();
        pSDepSlnASBase.resetEnableRemoteMode();
        pSDepSlnASBase.resetHttpPort();
        pSDepSlnASBase.resetMemo();
        pSDepSlnASBase.resetPSDepSlnASId();
        pSDepSlnASBase.resetPSDepSlnASName();
        pSDepSlnASBase.resetPSDepSlnHostId();
        pSDepSlnASBase.resetPSDepSlnHostName();
        pSDepSlnASBase.resetPSDepSlnId();
        pSDepSlnASBase.resetPSDepSlnName();
        pSDepSlnASBase.resetPSDevCenterASId();
        pSDepSlnASBase.resetPSDevCenterASName();
        pSDepSlnASBase.resetUpdateDate();
        pSDepSlnASBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isASTypeDirty()) {
            hashMap.put(FIELD_ASTYPE, this.getASType());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEnableLocalModeDirty()) {
            hashMap.put(FIELD_ENABLELOCALMODE, this.getEnableLocalMode());
        }
        if (!bl || this.isEnableRemoteModeDirty()) {
            hashMap.put(FIELD_ENABLEREMOTEMODE, this.getEnableRemoteMode());
        }
        if (!bl || this.isHttpPortDirty()) {
            hashMap.put(FIELD_HTTPPORT, this.getHttpPort());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDepSlnASIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNASID, this.getPSDepSlnASId());
        }
        if (!bl || this.isPSDepSlnASNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNASNAME, this.getPSDepSlnASName());
        }
        if (!bl || this.isPSDepSlnHostIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNHOSTID, this.getPSDepSlnHostId());
        }
        if (!bl || this.isPSDepSlnHostNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNHOSTNAME, this.getPSDepSlnHostName());
        }
        if (!bl || this.isPSDepSlnIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNID, this.getPSDepSlnId());
        }
        if (!bl || this.isPSDepSlnNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNNAME, this.getPSDepSlnName());
        }
        if (!bl || this.isPSDevCenterASIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERASID, this.getPSDevCenterASId());
        }
        if (!bl || this.isPSDevCenterASNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERASNAME, this.getPSDevCenterASName());
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
        return PSDepSlnASBase.get(this, n);
    }

    private static Object get(PSDepSlnASBase pSDepSlnASBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnASBase.getASType();
            }
            case 1: {
                return pSDepSlnASBase.getCreateDate();
            }
            case 2: {
                return pSDepSlnASBase.getCreateMan();
            }
            case 3: {
                return pSDepSlnASBase.getEnableLocalMode();
            }
            case 4: {
                return pSDepSlnASBase.getEnableRemoteMode();
            }
            case 5: {
                return pSDepSlnASBase.getHttpPort();
            }
            case 6: {
                return pSDepSlnASBase.getMemo();
            }
            case 7: {
                return pSDepSlnASBase.getPSDepSlnASId();
            }
            case 8: {
                return pSDepSlnASBase.getPSDepSlnASName();
            }
            case 9: {
                return pSDepSlnASBase.getPSDepSlnHostId();
            }
            case 10: {
                return pSDepSlnASBase.getPSDepSlnHostName();
            }
            case 11: {
                return pSDepSlnASBase.getPSDepSlnId();
            }
            case 12: {
                return pSDepSlnASBase.getPSDepSlnName();
            }
            case 13: {
                return pSDepSlnASBase.getPSDevCenterASId();
            }
            case 14: {
                return pSDepSlnASBase.getPSDevCenterASName();
            }
            case 15: {
                return pSDepSlnASBase.getUpdateDate();
            }
            case 16: {
                return pSDepSlnASBase.getUpdateMan();
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
        PSDepSlnASBase.set(this, n, object);
    }

    private static void set(PSDepSlnASBase pSDepSlnASBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnASBase.setASType(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDepSlnASBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDepSlnASBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDepSlnASBase.setEnableLocalMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDepSlnASBase.setEnableRemoteMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDepSlnASBase.setHttpPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDepSlnASBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDepSlnASBase.setPSDepSlnASId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDepSlnASBase.setPSDepSlnASName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDepSlnASBase.setPSDepSlnHostId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDepSlnASBase.setPSDepSlnHostName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDepSlnASBase.setPSDepSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDepSlnASBase.setPSDepSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDepSlnASBase.setPSDevCenterASId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDepSlnASBase.setPSDevCenterASName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDepSlnASBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 16: {
                pSDepSlnASBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDepSlnASBase.isNull(this, n);
    }

    private static boolean isNull(PSDepSlnASBase pSDepSlnASBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnASBase.getASType() == null;
            }
            case 1: {
                return pSDepSlnASBase.getCreateDate() == null;
            }
            case 2: {
                return pSDepSlnASBase.getCreateMan() == null;
            }
            case 3: {
                return pSDepSlnASBase.getEnableLocalMode() == null;
            }
            case 4: {
                return pSDepSlnASBase.getEnableRemoteMode() == null;
            }
            case 5: {
                return pSDepSlnASBase.getHttpPort() == null;
            }
            case 6: {
                return pSDepSlnASBase.getMemo() == null;
            }
            case 7: {
                return pSDepSlnASBase.getPSDepSlnASId() == null;
            }
            case 8: {
                return pSDepSlnASBase.getPSDepSlnASName() == null;
            }
            case 9: {
                return pSDepSlnASBase.getPSDepSlnHostId() == null;
            }
            case 10: {
                return pSDepSlnASBase.getPSDepSlnHostName() == null;
            }
            case 11: {
                return pSDepSlnASBase.getPSDepSlnId() == null;
            }
            case 12: {
                return pSDepSlnASBase.getPSDepSlnName() == null;
            }
            case 13: {
                return pSDepSlnASBase.getPSDevCenterASId() == null;
            }
            case 14: {
                return pSDepSlnASBase.getPSDevCenterASName() == null;
            }
            case 15: {
                return pSDepSlnASBase.getUpdateDate() == null;
            }
            case 16: {
                return pSDepSlnASBase.getUpdateMan() == null;
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
        return PSDepSlnASBase.contains(this, n);
    }

    private static boolean contains(PSDepSlnASBase pSDepSlnASBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnASBase.isASTypeDirty();
            }
            case 1: {
                return pSDepSlnASBase.isCreateDateDirty();
            }
            case 2: {
                return pSDepSlnASBase.isCreateManDirty();
            }
            case 3: {
                return pSDepSlnASBase.isEnableLocalModeDirty();
            }
            case 4: {
                return pSDepSlnASBase.isEnableRemoteModeDirty();
            }
            case 5: {
                return pSDepSlnASBase.isHttpPortDirty();
            }
            case 6: {
                return pSDepSlnASBase.isMemoDirty();
            }
            case 7: {
                return pSDepSlnASBase.isPSDepSlnASIdDirty();
            }
            case 8: {
                return pSDepSlnASBase.isPSDepSlnASNameDirty();
            }
            case 9: {
                return pSDepSlnASBase.isPSDepSlnHostIdDirty();
            }
            case 10: {
                return pSDepSlnASBase.isPSDepSlnHostNameDirty();
            }
            case 11: {
                return pSDepSlnASBase.isPSDepSlnIdDirty();
            }
            case 12: {
                return pSDepSlnASBase.isPSDepSlnNameDirty();
            }
            case 13: {
                return pSDepSlnASBase.isPSDevCenterASIdDirty();
            }
            case 14: {
                return pSDepSlnASBase.isPSDevCenterASNameDirty();
            }
            case 15: {
                return pSDepSlnASBase.isUpdateDateDirty();
            }
            case 16: {
                return pSDepSlnASBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDepSlnASBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDepSlnASBase pSDepSlnASBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDepSlnASBase.getASType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"astype", (Object)PSDepSlnASBase.getJSONValue((Object)pSDepSlnASBase.getASType()), (boolean)false);
        }
        if (bl || pSDepSlnASBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDepSlnASBase.getJSONValue((Object)pSDepSlnASBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDepSlnASBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDepSlnASBase.getJSONValue((Object)pSDepSlnASBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDepSlnASBase.getEnableLocalMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablelocalmode", (Object)PSDepSlnASBase.getJSONValue((Object)pSDepSlnASBase.getEnableLocalMode()), (boolean)false);
        }
        if (bl || pSDepSlnASBase.getEnableRemoteMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableremotemode", (Object)PSDepSlnASBase.getJSONValue((Object)pSDepSlnASBase.getEnableRemoteMode()), (boolean)false);
        }
        if (bl || pSDepSlnASBase.getHttpPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"httpport", (Object)PSDepSlnASBase.getJSONValue((Object)pSDepSlnASBase.getHttpPort()), (boolean)false);
        }
        if (bl || pSDepSlnASBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDepSlnASBase.getJSONValue((Object)pSDepSlnASBase.getMemo()), (boolean)false);
        }
        if (bl || pSDepSlnASBase.getPSDepSlnASId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnasid", (Object)PSDepSlnASBase.getJSONValue((Object)pSDepSlnASBase.getPSDepSlnASId()), (boolean)false);
        }
        if (bl || pSDepSlnASBase.getPSDepSlnASName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnasname", (Object)PSDepSlnASBase.getJSONValue((Object)pSDepSlnASBase.getPSDepSlnASName()), (boolean)false);
        }
        if (bl || pSDepSlnASBase.getPSDepSlnHostId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnhostid", (Object)PSDepSlnASBase.getJSONValue((Object)pSDepSlnASBase.getPSDepSlnHostId()), (boolean)false);
        }
        if (bl || pSDepSlnASBase.getPSDepSlnHostName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnhostname", (Object)PSDepSlnASBase.getJSONValue((Object)pSDepSlnASBase.getPSDepSlnHostName()), (boolean)false);
        }
        if (bl || pSDepSlnASBase.getPSDepSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnid", (Object)PSDepSlnASBase.getJSONValue((Object)pSDepSlnASBase.getPSDepSlnId()), (boolean)false);
        }
        if (bl || pSDepSlnASBase.getPSDepSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnname", (Object)PSDepSlnASBase.getJSONValue((Object)pSDepSlnASBase.getPSDepSlnName()), (boolean)false);
        }
        if (bl || pSDepSlnASBase.getPSDevCenterASId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterasid", (Object)PSDepSlnASBase.getJSONValue((Object)pSDepSlnASBase.getPSDevCenterASId()), (boolean)false);
        }
        if (bl || pSDepSlnASBase.getPSDevCenterASName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterasname", (Object)PSDepSlnASBase.getJSONValue((Object)pSDepSlnASBase.getPSDevCenterASName()), (boolean)false);
        }
        if (bl || pSDepSlnASBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDepSlnASBase.getJSONValue((Object)pSDepSlnASBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDepSlnASBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDepSlnASBase.getJSONValue((Object)pSDepSlnASBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDepSlnASBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDepSlnASBase pSDepSlnASBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDepSlnASBase.getASType() != null) {
            object = pSDepSlnASBase.getASType();
            xmlNode.setAttribute(FIELD_ASTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnASBase.getCreateDate() != null) {
            object = pSDepSlnASBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnASBase.getCreateMan() != null) {
            object = pSDepSlnASBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnASBase.getEnableLocalMode() != null) {
            object = pSDepSlnASBase.getEnableLocalMode();
            xmlNode.setAttribute(FIELD_ENABLELOCALMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDepSlnASBase.getEnableRemoteMode() != null) {
            object = pSDepSlnASBase.getEnableRemoteMode();
            xmlNode.setAttribute(FIELD_ENABLEREMOTEMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDepSlnASBase.getHttpPort() != null) {
            object = pSDepSlnASBase.getHttpPort();
            xmlNode.setAttribute(FIELD_HTTPPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDepSlnASBase.getMemo() != null) {
            object = pSDepSlnASBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnASBase.getPSDepSlnASId() != null) {
            object = pSDepSlnASBase.getPSDepSlnASId();
            xmlNode.setAttribute(FIELD_PSDEPSLNASID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnASBase.getPSDepSlnASName() != null) {
            object = pSDepSlnASBase.getPSDepSlnASName();
            xmlNode.setAttribute(FIELD_PSDEPSLNASNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnASBase.getPSDepSlnHostId() != null) {
            object = pSDepSlnASBase.getPSDepSlnHostId();
            xmlNode.setAttribute(FIELD_PSDEPSLNHOSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnASBase.getPSDepSlnHostName() != null) {
            object = pSDepSlnASBase.getPSDepSlnHostName();
            xmlNode.setAttribute(FIELD_PSDEPSLNHOSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnASBase.getPSDepSlnId() != null) {
            object = pSDepSlnASBase.getPSDepSlnId();
            xmlNode.setAttribute(FIELD_PSDEPSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnASBase.getPSDepSlnName() != null) {
            object = pSDepSlnASBase.getPSDepSlnName();
            xmlNode.setAttribute(FIELD_PSDEPSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnASBase.getPSDevCenterASId() != null) {
            object = pSDepSlnASBase.getPSDevCenterASId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERASID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnASBase.getPSDevCenterASName() != null) {
            object = pSDepSlnASBase.getPSDevCenterASName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERASNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnASBase.getUpdateDate() != null) {
            object = pSDepSlnASBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnASBase.getUpdateMan() != null) {
            object = pSDepSlnASBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDepSlnASBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDepSlnASBase pSDepSlnASBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDepSlnASBase.isASTypeDirty() && (bl || pSDepSlnASBase.getASType() != null)) {
            iDataObject.set(FIELD_ASTYPE, (Object)pSDepSlnASBase.getASType());
        }
        if (pSDepSlnASBase.isCreateDateDirty() && (bl || pSDepSlnASBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDepSlnASBase.getCreateDate());
        }
        if (pSDepSlnASBase.isCreateManDirty() && (bl || pSDepSlnASBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDepSlnASBase.getCreateMan());
        }
        if (pSDepSlnASBase.isEnableLocalModeDirty() && (bl || pSDepSlnASBase.getEnableLocalMode() != null)) {
            iDataObject.set(FIELD_ENABLELOCALMODE, (Object)pSDepSlnASBase.getEnableLocalMode());
        }
        if (pSDepSlnASBase.isEnableRemoteModeDirty() && (bl || pSDepSlnASBase.getEnableRemoteMode() != null)) {
            iDataObject.set(FIELD_ENABLEREMOTEMODE, (Object)pSDepSlnASBase.getEnableRemoteMode());
        }
        if (pSDepSlnASBase.isHttpPortDirty() && (bl || pSDepSlnASBase.getHttpPort() != null)) {
            iDataObject.set(FIELD_HTTPPORT, (Object)pSDepSlnASBase.getHttpPort());
        }
        if (pSDepSlnASBase.isMemoDirty() && (bl || pSDepSlnASBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDepSlnASBase.getMemo());
        }
        if (pSDepSlnASBase.isPSDepSlnASIdDirty() && (bl || pSDepSlnASBase.getPSDepSlnASId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNASID, (Object)pSDepSlnASBase.getPSDepSlnASId());
        }
        if (pSDepSlnASBase.isPSDepSlnASNameDirty() && (bl || pSDepSlnASBase.getPSDepSlnASName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNASNAME, (Object)pSDepSlnASBase.getPSDepSlnASName());
        }
        if (pSDepSlnASBase.isPSDepSlnHostIdDirty() && (bl || pSDepSlnASBase.getPSDepSlnHostId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNHOSTID, (Object)pSDepSlnASBase.getPSDepSlnHostId());
        }
        if (pSDepSlnASBase.isPSDepSlnHostNameDirty() && (bl || pSDepSlnASBase.getPSDepSlnHostName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNHOSTNAME, (Object)pSDepSlnASBase.getPSDepSlnHostName());
        }
        if (pSDepSlnASBase.isPSDepSlnIdDirty() && (bl || pSDepSlnASBase.getPSDepSlnId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNID, (Object)pSDepSlnASBase.getPSDepSlnId());
        }
        if (pSDepSlnASBase.isPSDepSlnNameDirty() && (bl || pSDepSlnASBase.getPSDepSlnName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNNAME, (Object)pSDepSlnASBase.getPSDepSlnName());
        }
        if (pSDepSlnASBase.isPSDevCenterASIdDirty() && (bl || pSDepSlnASBase.getPSDevCenterASId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERASID, (Object)pSDepSlnASBase.getPSDevCenterASId());
        }
        if (pSDepSlnASBase.isPSDevCenterASNameDirty() && (bl || pSDepSlnASBase.getPSDevCenterASName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERASNAME, (Object)pSDepSlnASBase.getPSDevCenterASName());
        }
        if (pSDepSlnASBase.isUpdateDateDirty() && (bl || pSDepSlnASBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDepSlnASBase.getUpdateDate());
        }
        if (pSDepSlnASBase.isUpdateManDirty() && (bl || pSDepSlnASBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDepSlnASBase.getUpdateMan());
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
        return PSDepSlnASBase.remove(this, n);
    }

    private static boolean remove(PSDepSlnASBase pSDepSlnASBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnASBase.resetASType();
                return true;
            }
            case 1: {
                pSDepSlnASBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDepSlnASBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDepSlnASBase.resetEnableLocalMode();
                return true;
            }
            case 4: {
                pSDepSlnASBase.resetEnableRemoteMode();
                return true;
            }
            case 5: {
                pSDepSlnASBase.resetHttpPort();
                return true;
            }
            case 6: {
                pSDepSlnASBase.resetMemo();
                return true;
            }
            case 7: {
                pSDepSlnASBase.resetPSDepSlnASId();
                return true;
            }
            case 8: {
                pSDepSlnASBase.resetPSDepSlnASName();
                return true;
            }
            case 9: {
                pSDepSlnASBase.resetPSDepSlnHostId();
                return true;
            }
            case 10: {
                pSDepSlnASBase.resetPSDepSlnHostName();
                return true;
            }
            case 11: {
                pSDepSlnASBase.resetPSDepSlnId();
                return true;
            }
            case 12: {
                pSDepSlnASBase.resetPSDepSlnName();
                return true;
            }
            case 13: {
                pSDepSlnASBase.resetPSDevCenterASId();
                return true;
            }
            case 14: {
                pSDepSlnASBase.resetPSDevCenterASName();
                return true;
            }
            case 15: {
                pSDepSlnASBase.resetUpdateDate();
                return true;
            }
            case 16: {
                pSDepSlnASBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSlnHost getPSDepSlnHost() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnHost();
        }
        if (this.getPSDepSlnHostId() == null) {
            return null;
        }
        Integer n = this.objPSDepSlnHostLock;
        synchronized (n) {
            if (this.psdepslnhost != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSlnHostId(), (Object)this.psdepslnhost.getPSDepSlnHostId()) != 0L) {
                this.psdepslnhost = null;
            }
            if (this.psdepslnhost == null) {
                PSDepSlnHost pSDepSlnHost = new PSDepSlnHost();
                pSDepSlnHost.setPSDepSlnHostId(this.getPSDepSlnHostId());
                PSDepSlnHostService pSDepSlnHostService = (PSDepSlnHostService)ServiceGlobal.getService(PSDepSlnHostService.class, (SessionFactory)this.getSessionFactory());
                pSDepSlnHostService.autoGet(pSDepSlnHost);
                this.psdepslnhost = pSDepSlnHost;
            }
            return this.psdepslnhost;
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
                pSDepSlnService.autoGet(pSDepSln);
                this.psdepsln = pSDepSln;
            }
            return this.psdepsln;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterAS getPSDevcenterAS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevcenterAS();
        }
        if (this.getPSDevCenterASId() == null) {
            return null;
        }
        Integer n = this.objPSDevcenterASLock;
        synchronized (n) {
            if (this.psdevcenteras != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterASId(), (Object)this.psdevcenteras.getPSDevCenterASId()) != 0L) {
                this.psdevcenteras = null;
            }
            if (this.psdevcenteras == null) {
                PSDevCenterAS pSDevCenterAS = new PSDevCenterAS();
                pSDevCenterAS.setPSDevCenterASId(this.getPSDevCenterASId());
                PSDevCenterASService pSDevCenterASService = (PSDevCenterASService)ServiceGlobal.getService(PSDevCenterASService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterASService.autoGet(pSDevCenterAS);
                this.psdevcenteras = pSDevCenterAS;
            }
            return this.psdevcenteras;
        }
    }

    private PSDepSlnASBase getProxyEntity() {
        return this.proxyPSDepSlnASBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDepSlnASBase = null;
        if (iDataObject != null && iDataObject instanceof PSDepSlnASBase) {
            this.proxyPSDepSlnASBase = (PSDepSlnASBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnASService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ASTYPE, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_ENABLELOCALMODE, 3);
        fieldIndexMap.put(FIELD_ENABLEREMOTEMODE, 4);
        fieldIndexMap.put(FIELD_HTTPPORT, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_PSDEPSLNASID, 7);
        fieldIndexMap.put(FIELD_PSDEPSLNASNAME, 8);
        fieldIndexMap.put(FIELD_PSDEPSLNHOSTID, 9);
        fieldIndexMap.put(FIELD_PSDEPSLNHOSTNAME, 10);
        fieldIndexMap.put(FIELD_PSDEPSLNID, 11);
        fieldIndexMap.put(FIELD_PSDEPSLNNAME, 12);
        fieldIndexMap.put(FIELD_PSDEVCENTERASID, 13);
        fieldIndexMap.put(FIELD_PSDEVCENTERASNAME, 14);
        fieldIndexMap.put(FIELD_UPDATEDATE, 15);
        fieldIndexMap.put(FIELD_UPDATEMAN, 16);
    }
}

