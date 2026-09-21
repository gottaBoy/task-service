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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSystemASBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSystemASBase.class);
    public static final String FIELD_ASID = "ASID";
    public static final String FIELD_ASTYPE = "ASTYPE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENABLEWEBTOOL = "ENABLEWEBTOOL";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSAPPSERVERID = "PSAPPSERVERID";
    public static final String FIELD_PSDEVCENTERASID = "PSDEVCENTERASID";
    public static final String FIELD_PSDEVCENTERASNAME = "PSDEVCENTERASNAME";
    public static final String FIELD_PSSYSTEMASID = "PSSYSTEMASID";
    public static final String FIELD_PSSYSTEMASNAME = "PSSYSTEMASNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_RESINFO = "RESINFO";
    public static final String FIELD_RESREADYTIME = "RESREADYTIME";
    public static final String FIELD_RESSTATE = "RESSTATE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_ASID = 0;
    private static final int INDEX_ASTYPE = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_ENABLEWEBTOOL = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSAPPSERVERID = 6;
    private static final int INDEX_PSDEVCENTERASID = 7;
    private static final int INDEX_PSDEVCENTERASNAME = 8;
    private static final int INDEX_PSSYSTEMASID = 9;
    private static final int INDEX_PSSYSTEMASNAME = 10;
    private static final int INDEX_PSSYSTEMID = 11;
    private static final int INDEX_PSSYSTEMNAME = 12;
    private static final int INDEX_RESINFO = 13;
    private static final int INDEX_RESREADYTIME = 14;
    private static final int INDEX_RESSTATE = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSystemASBase proxyPSSystemASBase = null;
    private boolean asidDirtyFlag = false;
    private boolean astypeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean enablewebtoolDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psappserveridDirtyFlag = false;
    private boolean psdevcenterasidDirtyFlag = false;
    private boolean psdevcenterasnameDirtyFlag = false;
    private boolean pssystemasidDirtyFlag = false;
    private boolean pssystemasnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean resinfoDirtyFlag = false;
    private boolean resreadytimeDirtyFlag = false;
    private boolean resstateDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="asid")
    private String asid;
    @Column(name="astype")
    private String astype;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="enablewebtool")
    private Integer enablewebtool;
    @Column(name="memo")
    private String memo;
    @Column(name="psappserverid")
    private String psappserverid;
    @Column(name="psdevcenterasid")
    private String psdevcenterasid;
    @Column(name="psdevcenterasname")
    private String psdevcenterasname;
    @Column(name="pssystemasid")
    private String pssystemasid;
    @Column(name="pssystemasname")
    private String pssystemasname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="resinfo")
    private String resinfo;
    @Column(name="resreadytime")
    private Timestamp resreadytime;
    @Column(name="resstate")
    private Integer resstate;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevCenterASLock = new Integer(1);
    private PSDevCenterAS psdevcenteras = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

    public void setASId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setASId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.asid = string;
        this.asidDirtyFlag = true;
    }

    public String getASId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getASId();
        }
        return this.asid;
    }

    public boolean isASIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isASIdDirty();
        }
        return this.asidDirtyFlag;
    }

    public void resetASId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetASId();
            return;
        }
        this.asidDirtyFlag = false;
        this.asid = null;
    }

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

    public void setEnableWebTool(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableWebTool(n);
            return;
        }
        this.enablewebtool = n;
        this.enablewebtoolDirtyFlag = true;
    }

    public Integer getEnableWebTool() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableWebTool();
        }
        return this.enablewebtool;
    }

    public boolean isEnableWebToolDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableWebToolDirty();
        }
        return this.enablewebtoolDirtyFlag;
    }

    public void resetEnableWebTool() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableWebTool();
            return;
        }
        this.enablewebtoolDirtyFlag = false;
        this.enablewebtool = null;
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

    public void setPSAppServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappserverid = string;
        this.psappserveridDirtyFlag = true;
    }

    public String getPSAppServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppServerId();
        }
        return this.psappserverid;
    }

    public boolean isPSAppServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppServerIdDirty();
        }
        return this.psappserveridDirtyFlag;
    }

    public void resetPSAppServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppServerId();
            return;
        }
        this.psappserveridDirtyFlag = false;
        this.psappserverid = null;
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

    public void setPSSystemASId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemASId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemasid = string;
        this.pssystemasidDirtyFlag = true;
    }

    public String getPSSystemASId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemASId();
        }
        return this.pssystemasid;
    }

    public boolean isPSSystemASIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemASIdDirty();
        }
        return this.pssystemasidDirtyFlag;
    }

    public void resetPSSystemASId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemASId();
            return;
        }
        this.pssystemasidDirtyFlag = false;
        this.pssystemasid = null;
    }

    public void setPSSystemASName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemASName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemasname = string;
        this.pssystemasnameDirtyFlag = true;
    }

    public String getPSSystemASName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemASName();
        }
        return this.pssystemasname;
    }

    public boolean isPSSystemASNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemASNameDirty();
        }
        return this.pssystemasnameDirtyFlag;
    }

    public void resetPSSystemASName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemASName();
            return;
        }
        this.pssystemasnameDirtyFlag = false;
        this.pssystemasname = null;
    }

    public void setPSSystemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemid = string;
        this.pssystemidDirtyFlag = true;
    }

    public String getPSSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemId();
        }
        return this.pssystemid;
    }

    public boolean isPSSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemIdDirty();
        }
        return this.pssystemidDirtyFlag;
    }

    public void resetPSSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemId();
            return;
        }
        this.pssystemidDirtyFlag = false;
        this.pssystemid = null;
    }

    public void setPSSystemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemname = string;
        this.pssystemnameDirtyFlag = true;
    }

    public String getPSSystemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemName();
        }
        return this.pssystemname;
    }

    public boolean isPSSystemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemNameDirty();
        }
        return this.pssystemnameDirtyFlag;
    }

    public void resetPSSystemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemName();
            return;
        }
        this.pssystemnameDirtyFlag = false;
        this.pssystemname = null;
    }

    public void setResInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.resinfo = string;
        this.resinfoDirtyFlag = true;
    }

    public String getResInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResInfo();
        }
        return this.resinfo;
    }

    public boolean isResInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResInfoDirty();
        }
        return this.resinfoDirtyFlag;
    }

    public void resetResInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResInfo();
            return;
        }
        this.resinfoDirtyFlag = false;
        this.resinfo = null;
    }

    public void setResReadyTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResReadyTime(timestamp);
            return;
        }
        this.resreadytime = timestamp;
        this.resreadytimeDirtyFlag = true;
    }

    public Timestamp getResReadyTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResReadyTime();
        }
        return this.resreadytime;
    }

    public boolean isResReadyTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResReadyTimeDirty();
        }
        return this.resreadytimeDirtyFlag;
    }

    public void resetResReadyTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResReadyTime();
            return;
        }
        this.resreadytimeDirtyFlag = false;
        this.resreadytime = null;
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
        PSSystemASBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSystemASBase pSSystemASBase) {
        pSSystemASBase.resetASId();
        pSSystemASBase.resetASType();
        pSSystemASBase.resetCreateDate();
        pSSystemASBase.resetCreateMan();
        pSSystemASBase.resetEnableWebTool();
        pSSystemASBase.resetMemo();
        pSSystemASBase.resetPSAppServerId();
        pSSystemASBase.resetPSDevCenterASId();
        pSSystemASBase.resetPSDevCenterASName();
        pSSystemASBase.resetPSSystemASId();
        pSSystemASBase.resetPSSystemASName();
        pSSystemASBase.resetPSSystemId();
        pSSystemASBase.resetPSSystemName();
        pSSystemASBase.resetResInfo();
        pSSystemASBase.resetResReadyTime();
        pSSystemASBase.resetResState();
        pSSystemASBase.resetUpdateDate();
        pSSystemASBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isASIdDirty()) {
            hashMap.put(FIELD_ASID, this.getASId());
        }
        if (!bl || this.isASTypeDirty()) {
            hashMap.put(FIELD_ASTYPE, this.getASType());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEnableWebToolDirty()) {
            hashMap.put(FIELD_ENABLEWEBTOOL, this.getEnableWebTool());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSAppServerIdDirty()) {
            hashMap.put(FIELD_PSAPPSERVERID, this.getPSAppServerId());
        }
        if (!bl || this.isPSDevCenterASIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERASID, this.getPSDevCenterASId());
        }
        if (!bl || this.isPSDevCenterASNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERASNAME, this.getPSDevCenterASName());
        }
        if (!bl || this.isPSSystemASIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMASID, this.getPSSystemASId());
        }
        if (!bl || this.isPSSystemASNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMASNAME, this.getPSSystemASName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isResInfoDirty()) {
            hashMap.put(FIELD_RESINFO, this.getResInfo());
        }
        if (!bl || this.isResReadyTimeDirty()) {
            hashMap.put(FIELD_RESREADYTIME, this.getResReadyTime());
        }
        if (!bl || this.isResStateDirty()) {
            hashMap.put(FIELD_RESSTATE, this.getResState());
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
        return PSSystemASBase.get(this, n);
    }

    private static Object get(PSSystemASBase pSSystemASBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSystemASBase.getASId();
            }
            case 1: {
                return pSSystemASBase.getASType();
            }
            case 2: {
                return pSSystemASBase.getCreateDate();
            }
            case 3: {
                return pSSystemASBase.getCreateMan();
            }
            case 4: {
                return pSSystemASBase.getEnableWebTool();
            }
            case 5: {
                return pSSystemASBase.getMemo();
            }
            case 6: {
                return pSSystemASBase.getPSAppServerId();
            }
            case 7: {
                return pSSystemASBase.getPSDevCenterASId();
            }
            case 8: {
                return pSSystemASBase.getPSDevCenterASName();
            }
            case 9: {
                return pSSystemASBase.getPSSystemASId();
            }
            case 10: {
                return pSSystemASBase.getPSSystemASName();
            }
            case 11: {
                return pSSystemASBase.getPSSystemId();
            }
            case 12: {
                return pSSystemASBase.getPSSystemName();
            }
            case 13: {
                return pSSystemASBase.getResInfo();
            }
            case 14: {
                return pSSystemASBase.getResReadyTime();
            }
            case 15: {
                return pSSystemASBase.getResState();
            }
            case 16: {
                return pSSystemASBase.getUpdateDate();
            }
            case 17: {
                return pSSystemASBase.getUpdateMan();
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
        PSSystemASBase.set(this, n, object);
    }

    private static void set(PSSystemASBase pSSystemASBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSystemASBase.setASId(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSystemASBase.setASType(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSystemASBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSSystemASBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSystemASBase.setEnableWebTool(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSSystemASBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSystemASBase.setPSAppServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSystemASBase.setPSDevCenterASId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSystemASBase.setPSDevCenterASName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSystemASBase.setPSSystemASId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSystemASBase.setPSSystemASName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSystemASBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSystemASBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSystemASBase.setResInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSystemASBase.setResReadyTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSSystemASBase.setResState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSSystemASBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSSystemASBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSystemASBase.isNull(this, n);
    }

    private static boolean isNull(PSSystemASBase pSSystemASBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSystemASBase.getASId() == null;
            }
            case 1: {
                return pSSystemASBase.getASType() == null;
            }
            case 2: {
                return pSSystemASBase.getCreateDate() == null;
            }
            case 3: {
                return pSSystemASBase.getCreateMan() == null;
            }
            case 4: {
                return pSSystemASBase.getEnableWebTool() == null;
            }
            case 5: {
                return pSSystemASBase.getMemo() == null;
            }
            case 6: {
                return pSSystemASBase.getPSAppServerId() == null;
            }
            case 7: {
                return pSSystemASBase.getPSDevCenterASId() == null;
            }
            case 8: {
                return pSSystemASBase.getPSDevCenterASName() == null;
            }
            case 9: {
                return pSSystemASBase.getPSSystemASId() == null;
            }
            case 10: {
                return pSSystemASBase.getPSSystemASName() == null;
            }
            case 11: {
                return pSSystemASBase.getPSSystemId() == null;
            }
            case 12: {
                return pSSystemASBase.getPSSystemName() == null;
            }
            case 13: {
                return pSSystemASBase.getResInfo() == null;
            }
            case 14: {
                return pSSystemASBase.getResReadyTime() == null;
            }
            case 15: {
                return pSSystemASBase.getResState() == null;
            }
            case 16: {
                return pSSystemASBase.getUpdateDate() == null;
            }
            case 17: {
                return pSSystemASBase.getUpdateMan() == null;
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
        return PSSystemASBase.contains(this, n);
    }

    private static boolean contains(PSSystemASBase pSSystemASBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSystemASBase.isASIdDirty();
            }
            case 1: {
                return pSSystemASBase.isASTypeDirty();
            }
            case 2: {
                return pSSystemASBase.isCreateDateDirty();
            }
            case 3: {
                return pSSystemASBase.isCreateManDirty();
            }
            case 4: {
                return pSSystemASBase.isEnableWebToolDirty();
            }
            case 5: {
                return pSSystemASBase.isMemoDirty();
            }
            case 6: {
                return pSSystemASBase.isPSAppServerIdDirty();
            }
            case 7: {
                return pSSystemASBase.isPSDevCenterASIdDirty();
            }
            case 8: {
                return pSSystemASBase.isPSDevCenterASNameDirty();
            }
            case 9: {
                return pSSystemASBase.isPSSystemASIdDirty();
            }
            case 10: {
                return pSSystemASBase.isPSSystemASNameDirty();
            }
            case 11: {
                return pSSystemASBase.isPSSystemIdDirty();
            }
            case 12: {
                return pSSystemASBase.isPSSystemNameDirty();
            }
            case 13: {
                return pSSystemASBase.isResInfoDirty();
            }
            case 14: {
                return pSSystemASBase.isResReadyTimeDirty();
            }
            case 15: {
                return pSSystemASBase.isResStateDirty();
            }
            case 16: {
                return pSSystemASBase.isUpdateDateDirty();
            }
            case 17: {
                return pSSystemASBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSystemASBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSystemASBase pSSystemASBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSystemASBase.getASId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"asid", (Object)PSSystemASBase.getJSONValue((Object)pSSystemASBase.getASId()), (boolean)false);
        }
        if (bl || pSSystemASBase.getASType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"astype", (Object)PSSystemASBase.getJSONValue((Object)pSSystemASBase.getASType()), (boolean)false);
        }
        if (bl || pSSystemASBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSystemASBase.getJSONValue((Object)pSSystemASBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSystemASBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSystemASBase.getJSONValue((Object)pSSystemASBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSystemASBase.getEnableWebTool() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablewebtool", (Object)PSSystemASBase.getJSONValue((Object)pSSystemASBase.getEnableWebTool()), (boolean)false);
        }
        if (bl || pSSystemASBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSystemASBase.getJSONValue((Object)pSSystemASBase.getMemo()), (boolean)false);
        }
        if (bl || pSSystemASBase.getPSAppServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappserverid", (Object)PSSystemASBase.getJSONValue((Object)pSSystemASBase.getPSAppServerId()), (boolean)false);
        }
        if (bl || pSSystemASBase.getPSDevCenterASId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterasid", (Object)PSSystemASBase.getJSONValue((Object)pSSystemASBase.getPSDevCenterASId()), (boolean)false);
        }
        if (bl || pSSystemASBase.getPSDevCenterASName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterasname", (Object)PSSystemASBase.getJSONValue((Object)pSSystemASBase.getPSDevCenterASName()), (boolean)false);
        }
        if (bl || pSSystemASBase.getPSSystemASId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemasid", (Object)PSSystemASBase.getJSONValue((Object)pSSystemASBase.getPSSystemASId()), (boolean)false);
        }
        if (bl || pSSystemASBase.getPSSystemASName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemasname", (Object)PSSystemASBase.getJSONValue((Object)pSSystemASBase.getPSSystemASName()), (boolean)false);
        }
        if (bl || pSSystemASBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSystemASBase.getJSONValue((Object)pSSystemASBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSystemASBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSystemASBase.getJSONValue((Object)pSSystemASBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSystemASBase.getResInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resinfo", (Object)PSSystemASBase.getJSONValue((Object)pSSystemASBase.getResInfo()), (boolean)false);
        }
        if (bl || pSSystemASBase.getResReadyTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resreadytime", (Object)PSSystemASBase.getJSONValue((Object)pSSystemASBase.getResReadyTime()), (boolean)false);
        }
        if (bl || pSSystemASBase.getResState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resstate", (Object)PSSystemASBase.getJSONValue((Object)pSSystemASBase.getResState()), (boolean)false);
        }
        if (bl || pSSystemASBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSystemASBase.getJSONValue((Object)pSSystemASBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSystemASBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSystemASBase.getJSONValue((Object)pSSystemASBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSystemASBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSystemASBase pSSystemASBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSystemASBase.getASId() != null) {
            object = pSSystemASBase.getASId();
            xmlNode.setAttribute(FIELD_ASID, (String)(object == null ? "" : object));
        }
        if (bl || pSSystemASBase.getASType() != null) {
            object = pSSystemASBase.getASType();
            xmlNode.setAttribute(FIELD_ASTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSystemASBase.getCreateDate() != null) {
            object = pSSystemASBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSystemASBase.getCreateMan() != null) {
            object = pSSystemASBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSystemASBase.getEnableWebTool() != null) {
            object = pSSystemASBase.getEnableWebTool();
            xmlNode.setAttribute(FIELD_ENABLEWEBTOOL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemASBase.getMemo() != null) {
            object = pSSystemASBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSystemASBase.getPSAppServerId() != null) {
            object = pSSystemASBase.getPSAppServerId();
            xmlNode.setAttribute(FIELD_PSAPPSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSSystemASBase.getPSDevCenterASId() != null) {
            object = pSSystemASBase.getPSDevCenterASId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERASID, object == null ? "" : (String)object);
        }
        if (bl || pSSystemASBase.getPSDevCenterASName() != null) {
            object = pSSystemASBase.getPSDevCenterASName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERASNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSystemASBase.getPSSystemASId() != null) {
            object = pSSystemASBase.getPSSystemASId();
            xmlNode.setAttribute(FIELD_PSSYSTEMASID, object == null ? "" : (String)object);
        }
        if (bl || pSSystemASBase.getPSSystemASName() != null) {
            object = pSSystemASBase.getPSSystemASName();
            xmlNode.setAttribute(FIELD_PSSYSTEMASNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSystemASBase.getPSSystemId() != null) {
            object = pSSystemASBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSystemASBase.getPSSystemName() != null) {
            object = pSSystemASBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSystemASBase.getResInfo() != null) {
            object = pSSystemASBase.getResInfo();
            xmlNode.setAttribute(FIELD_RESINFO, object == null ? "" : (String)object);
        }
        if (bl || pSSystemASBase.getResReadyTime() != null) {
            object = pSSystemASBase.getResReadyTime();
            xmlNode.setAttribute(FIELD_RESREADYTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSystemASBase.getResState() != null) {
            object = pSSystemASBase.getResState();
            xmlNode.setAttribute(FIELD_RESSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemASBase.getUpdateDate() != null) {
            object = pSSystemASBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSystemASBase.getUpdateMan() != null) {
            object = pSSystemASBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSystemASBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSystemASBase pSSystemASBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSystemASBase.isASIdDirty() && (bl || pSSystemASBase.getASId() != null)) {
            iDataObject.set(FIELD_ASID, (Object)pSSystemASBase.getASId());
        }
        if (pSSystemASBase.isASTypeDirty() && (bl || pSSystemASBase.getASType() != null)) {
            iDataObject.set(FIELD_ASTYPE, (Object)pSSystemASBase.getASType());
        }
        if (pSSystemASBase.isCreateDateDirty() && (bl || pSSystemASBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSystemASBase.getCreateDate());
        }
        if (pSSystemASBase.isCreateManDirty() && (bl || pSSystemASBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSystemASBase.getCreateMan());
        }
        if (pSSystemASBase.isEnableWebToolDirty() && (bl || pSSystemASBase.getEnableWebTool() != null)) {
            iDataObject.set(FIELD_ENABLEWEBTOOL, (Object)pSSystemASBase.getEnableWebTool());
        }
        if (pSSystemASBase.isMemoDirty() && (bl || pSSystemASBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSystemASBase.getMemo());
        }
        if (pSSystemASBase.isPSAppServerIdDirty() && (bl || pSSystemASBase.getPSAppServerId() != null)) {
            iDataObject.set(FIELD_PSAPPSERVERID, (Object)pSSystemASBase.getPSAppServerId());
        }
        if (pSSystemASBase.isPSDevCenterASIdDirty() && (bl || pSSystemASBase.getPSDevCenterASId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERASID, (Object)pSSystemASBase.getPSDevCenterASId());
        }
        if (pSSystemASBase.isPSDevCenterASNameDirty() && (bl || pSSystemASBase.getPSDevCenterASName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERASNAME, (Object)pSSystemASBase.getPSDevCenterASName());
        }
        if (pSSystemASBase.isPSSystemASIdDirty() && (bl || pSSystemASBase.getPSSystemASId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMASID, (Object)pSSystemASBase.getPSSystemASId());
        }
        if (pSSystemASBase.isPSSystemASNameDirty() && (bl || pSSystemASBase.getPSSystemASName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMASNAME, (Object)pSSystemASBase.getPSSystemASName());
        }
        if (pSSystemASBase.isPSSystemIdDirty() && (bl || pSSystemASBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSystemASBase.getPSSystemId());
        }
        if (pSSystemASBase.isPSSystemNameDirty() && (bl || pSSystemASBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSystemASBase.getPSSystemName());
        }
        if (pSSystemASBase.isResInfoDirty() && (bl || pSSystemASBase.getResInfo() != null)) {
            iDataObject.set(FIELD_RESINFO, (Object)pSSystemASBase.getResInfo());
        }
        if (pSSystemASBase.isResReadyTimeDirty() && (bl || pSSystemASBase.getResReadyTime() != null)) {
            iDataObject.set(FIELD_RESREADYTIME, (Object)pSSystemASBase.getResReadyTime());
        }
        if (pSSystemASBase.isResStateDirty() && (bl || pSSystemASBase.getResState() != null)) {
            iDataObject.set(FIELD_RESSTATE, (Object)pSSystemASBase.getResState());
        }
        if (pSSystemASBase.isUpdateDateDirty() && (bl || pSSystemASBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSystemASBase.getUpdateDate());
        }
        if (pSSystemASBase.isUpdateManDirty() && (bl || pSSystemASBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSystemASBase.getUpdateMan());
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
        return PSSystemASBase.remove(this, n);
    }

    private static boolean remove(PSSystemASBase pSSystemASBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSystemASBase.resetASId();
                return true;
            }
            case 1: {
                pSSystemASBase.resetASType();
                return true;
            }
            case 2: {
                pSSystemASBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSSystemASBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSSystemASBase.resetEnableWebTool();
                return true;
            }
            case 5: {
                pSSystemASBase.resetMemo();
                return true;
            }
            case 6: {
                pSSystemASBase.resetPSAppServerId();
                return true;
            }
            case 7: {
                pSSystemASBase.resetPSDevCenterASId();
                return true;
            }
            case 8: {
                pSSystemASBase.resetPSDevCenterASName();
                return true;
            }
            case 9: {
                pSSystemASBase.resetPSSystemASId();
                return true;
            }
            case 10: {
                pSSystemASBase.resetPSSystemASName();
                return true;
            }
            case 11: {
                pSSystemASBase.resetPSSystemId();
                return true;
            }
            case 12: {
                pSSystemASBase.resetPSSystemName();
                return true;
            }
            case 13: {
                pSSystemASBase.resetResInfo();
                return true;
            }
            case 14: {
                pSSystemASBase.resetResReadyTime();
                return true;
            }
            case 15: {
                pSSystemASBase.resetResState();
                return true;
            }
            case 16: {
                pSSystemASBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSSystemASBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterAS getPSDevCenterAS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterAS();
        }
        if (this.getPSDevCenterASId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterASLock;
        synchronized (n) {
            if (this.psdevcenteras != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterASId(), (Object)this.psdevcenteras.getPSDevCenterASId()) != 0L) {
                this.psdevcenteras = null;
            }
            if (this.psdevcenteras == null) {
                PSDevCenterAS pSDevCenterAS = new PSDevCenterAS();
                pSDevCenterAS.setPSDevCenterASId(this.getPSDevCenterASId());
                PSDevCenterASService pSDevCenterASService = (PSDevCenterASService)ServiceGlobal.getService(PSDevCenterASService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterASService.autoGet((IEntity)pSDevCenterAS);
                this.psdevcenteras = pSDevCenterAS;
            }
            return this.psdevcenteras;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystem getPSSystem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystem();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        Integer n = this.objPSSystemLock;
        synchronized (n) {
            if (this.pssystem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemId(), (Object)this.pssystem.getPSSystemId()) != 0L) {
                this.pssystem = null;
            }
            if (this.pssystem == null) {
                PSSystem pSSystem = new PSSystem();
                pSSystem.setPSSystemId(this.getPSSystemId());
                PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
                pSSystemService.autoGet((IEntity)pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    private PSSystemASBase getProxyEntity() {
        return this.proxyPSSystemASBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSystemASBase = null;
        if (iDataObject != null && iDataObject instanceof PSSystemASBase) {
            this.proxyPSSystemASBase = (PSSystemASBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemASService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ASID, 0);
        fieldIndexMap.put(FIELD_ASTYPE, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_ENABLEWEBTOOL, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSAPPSERVERID, 6);
        fieldIndexMap.put(FIELD_PSDEVCENTERASID, 7);
        fieldIndexMap.put(FIELD_PSDEVCENTERASNAME, 8);
        fieldIndexMap.put(FIELD_PSSYSTEMASID, 9);
        fieldIndexMap.put(FIELD_PSSYSTEMASNAME, 10);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 11);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 12);
        fieldIndexMap.put(FIELD_RESINFO, 13);
        fieldIndexMap.put(FIELD_RESREADYTIME, 14);
        fieldIndexMap.put(FIELD_RESSTATE, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
    }
}

