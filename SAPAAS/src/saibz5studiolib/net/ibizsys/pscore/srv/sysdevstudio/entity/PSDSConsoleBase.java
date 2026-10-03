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
package net.ibizsys.pscore.srv.sysdevstudio.entity;

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
import net.ibizsys.pscore.srv.paasmgr.entity.PSConsoleServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSConsoleServerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDSConsoleBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDSConsoleBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DSTAG = "DSTAG";
    public static final String FIELD_DSTAG2 = "DSTAG2";
    public static final String FIELD_DSTAG3 = "DSTAG3";
    public static final String FIELD_DSTAG4 = "DSTAG4";
    public static final String FIELD_HTTPADDRESS = "HTTPADDRESS";
    public static final String FIELD_HTTPPORT = "HTTPPORT";
    public static final String FIELD_PSCONSOLESERVERID = "PSCONSOLESERVERID";
    public static final String FIELD_PSCONSOLESERVERNAME = "PSCONSOLESERVERNAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVUSERID = "PSDEVUSERID";
    public static final String FIELD_PSDSCONSOLEID = "PSDSCONSOLEID";
    public static final String FIELD_PSDSCONSOLENAME = "PSDSCONSOLENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DSTAG = 2;
    private static final int INDEX_DSTAG2 = 3;
    private static final int INDEX_DSTAG3 = 4;
    private static final int INDEX_DSTAG4 = 5;
    private static final int INDEX_HTTPADDRESS = 6;
    private static final int INDEX_HTTPPORT = 7;
    private static final int INDEX_PSCONSOLESERVERID = 8;
    private static final int INDEX_PSCONSOLESERVERNAME = 9;
    private static final int INDEX_PSDEVSLNSYSID = 10;
    private static final int INDEX_PSDEVUSERID = 11;
    private static final int INDEX_PSDSCONSOLEID = 12;
    private static final int INDEX_PSDSCONSOLENAME = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDSConsoleBase proxyPSDSConsoleBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dstagDirtyFlag = false;
    private boolean dstag2DirtyFlag = false;
    private boolean dstag3DirtyFlag = false;
    private boolean dstag4DirtyFlag = false;
    private boolean httpaddressDirtyFlag = false;
    private boolean httpportDirtyFlag = false;
    private boolean psconsoleserveridDirtyFlag = false;
    private boolean psconsoleservernameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevuseridDirtyFlag = false;
    private boolean psdsconsoleidDirtyFlag = false;
    private boolean psdsconsolenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dstag")
    private String dstag;
    @Column(name="dstag2")
    private String dstag2;
    @Column(name="dstag3")
    private String dstag3;
    @Column(name="dstag4")
    private String dstag4;
    @Column(name="httpaddress")
    private String httpaddress;
    @Column(name="httpport")
    private Integer httpport;
    @Column(name="psconsoleserverid")
    private String psconsoleserverid;
    @Column(name="psconsoleservername")
    private String psconsoleservername;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevuserid")
    private String psdevuserid;
    @Column(name="psdsconsoleid")
    private String psdsconsoleid;
    @Column(name="psdsconsolename")
    private String psdsconsolename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSConsoleServerLock = new Integer(1);
    private PSConsoleServer psconsoleserver = null;

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

    public void setDSTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDSTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstag = string;
        this.dstagDirtyFlag = true;
    }

    public String getDSTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDSTag();
        }
        return this.dstag;
    }

    public boolean isDSTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDSTagDirty();
        }
        return this.dstagDirtyFlag;
    }

    public void resetDSTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDSTag();
            return;
        }
        this.dstagDirtyFlag = false;
        this.dstag = null;
    }

    public void setDSTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDSTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstag2 = string;
        this.dstag2DirtyFlag = true;
    }

    public String getDSTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDSTag2();
        }
        return this.dstag2;
    }

    public boolean isDSTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDSTag2Dirty();
        }
        return this.dstag2DirtyFlag;
    }

    public void resetDSTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDSTag2();
            return;
        }
        this.dstag2DirtyFlag = false;
        this.dstag2 = null;
    }

    public void setDSTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDSTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstag3 = string;
        this.dstag3DirtyFlag = true;
    }

    public String getDSTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDSTag3();
        }
        return this.dstag3;
    }

    public boolean isDSTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDSTag3Dirty();
        }
        return this.dstag3DirtyFlag;
    }

    public void resetDSTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDSTag3();
            return;
        }
        this.dstag3DirtyFlag = false;
        this.dstag3 = null;
    }

    public void setDSTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDSTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstag4 = string;
        this.dstag4DirtyFlag = true;
    }

    public String getDSTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDSTag4();
        }
        return this.dstag4;
    }

    public boolean isDSTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDSTag4Dirty();
        }
        return this.dstag4DirtyFlag;
    }

    public void resetDSTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDSTag4();
            return;
        }
        this.dstag4DirtyFlag = false;
        this.dstag4 = null;
    }

    public void setHttpAddress(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHttpAddress(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.httpaddress = string;
        this.httpaddressDirtyFlag = true;
    }

    public String getHttpAddress() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHttpAddress();
        }
        return this.httpaddress;
    }

    public boolean isHttpAddressDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHttpAddressDirty();
        }
        return this.httpaddressDirtyFlag;
    }

    public void resetHttpAddress() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHttpAddress();
            return;
        }
        this.httpaddressDirtyFlag = false;
        this.httpaddress = null;
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

    public void setPSConsoleServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSConsoleServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psconsoleserverid = string;
        this.psconsoleserveridDirtyFlag = true;
    }

    public String getPSConsoleServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSConsoleServerId();
        }
        return this.psconsoleserverid;
    }

    public boolean isPSConsoleServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSConsoleServerIdDirty();
        }
        return this.psconsoleserveridDirtyFlag;
    }

    public void resetPSConsoleServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSConsoleServerId();
            return;
        }
        this.psconsoleserveridDirtyFlag = false;
        this.psconsoleserverid = null;
    }

    public void setPSConsoleServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSConsoleServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psconsoleservername = string;
        this.psconsoleservernameDirtyFlag = true;
    }

    public String getPSConsoleServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSConsoleServerName();
        }
        return this.psconsoleservername;
    }

    public boolean isPSConsoleServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSConsoleServerNameDirty();
        }
        return this.psconsoleservernameDirtyFlag;
    }

    public void resetPSConsoleServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSConsoleServerName();
            return;
        }
        this.psconsoleservernameDirtyFlag = false;
        this.psconsoleservername = null;
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

    public void setPSDevUserId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevUserId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevuserid = string;
        this.psdevuseridDirtyFlag = true;
    }

    public String getPSDevUserId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUserId();
        }
        return this.psdevuserid;
    }

    public boolean isPSDevUserIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevUserIdDirty();
        }
        return this.psdevuseridDirtyFlag;
    }

    public void resetPSDevUserId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevUserId();
            return;
        }
        this.psdevuseridDirtyFlag = false;
        this.psdevuserid = null;
    }

    public void setPSDSConsoleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDSConsoleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdsconsoleid = string;
        this.psdsconsoleidDirtyFlag = true;
    }

    public String getPSDSConsoleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDSConsoleId();
        }
        return this.psdsconsoleid;
    }

    public boolean isPSDSConsoleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDSConsoleIdDirty();
        }
        return this.psdsconsoleidDirtyFlag;
    }

    public void resetPSDSConsoleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDSConsoleId();
            return;
        }
        this.psdsconsoleidDirtyFlag = false;
        this.psdsconsoleid = null;
    }

    public void setPSDSConsoleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDSConsoleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdsconsolename = string;
        this.psdsconsolenameDirtyFlag = true;
    }

    public String getPSDSConsoleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDSConsoleName();
        }
        return this.psdsconsolename;
    }

    public boolean isPSDSConsoleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDSConsoleNameDirty();
        }
        return this.psdsconsolenameDirtyFlag;
    }

    public void resetPSDSConsoleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDSConsoleName();
            return;
        }
        this.psdsconsolenameDirtyFlag = false;
        this.psdsconsolename = null;
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
        PSDSConsoleBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDSConsoleBase pSDSConsoleBase) {
        pSDSConsoleBase.resetCreateDate();
        pSDSConsoleBase.resetCreateMan();
        pSDSConsoleBase.resetDSTag();
        pSDSConsoleBase.resetDSTag2();
        pSDSConsoleBase.resetDSTag3();
        pSDSConsoleBase.resetDSTag4();
        pSDSConsoleBase.resetHttpAddress();
        pSDSConsoleBase.resetHttpPort();
        pSDSConsoleBase.resetPSConsoleServerId();
        pSDSConsoleBase.resetPSConsoleServerName();
        pSDSConsoleBase.resetPSDevSlnSysId();
        pSDSConsoleBase.resetPSDevUserId();
        pSDSConsoleBase.resetPSDSConsoleId();
        pSDSConsoleBase.resetPSDSConsoleName();
        pSDSConsoleBase.resetUpdateDate();
        pSDSConsoleBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDSTagDirty()) {
            hashMap.put(FIELD_DSTAG, this.getDSTag());
        }
        if (!bl || this.isDSTag2Dirty()) {
            hashMap.put(FIELD_DSTAG2, this.getDSTag2());
        }
        if (!bl || this.isDSTag3Dirty()) {
            hashMap.put(FIELD_DSTAG3, this.getDSTag3());
        }
        if (!bl || this.isDSTag4Dirty()) {
            hashMap.put(FIELD_DSTAG4, this.getDSTag4());
        }
        if (!bl || this.isHttpAddressDirty()) {
            hashMap.put(FIELD_HTTPADDRESS, this.getHttpAddress());
        }
        if (!bl || this.isHttpPortDirty()) {
            hashMap.put(FIELD_HTTPPORT, this.getHttpPort());
        }
        if (!bl || this.isPSConsoleServerIdDirty()) {
            hashMap.put(FIELD_PSCONSOLESERVERID, this.getPSConsoleServerId());
        }
        if (!bl || this.isPSConsoleServerNameDirty()) {
            hashMap.put(FIELD_PSCONSOLESERVERNAME, this.getPSConsoleServerName());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDevUserIdDirty()) {
            hashMap.put(FIELD_PSDEVUSERID, this.getPSDevUserId());
        }
        if (!bl || this.isPSDSConsoleIdDirty()) {
            hashMap.put(FIELD_PSDSCONSOLEID, this.getPSDSConsoleId());
        }
        if (!bl || this.isPSDSConsoleNameDirty()) {
            hashMap.put(FIELD_PSDSCONSOLENAME, this.getPSDSConsoleName());
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
        return PSDSConsoleBase.get(this, n);
    }

    private static Object get(PSDSConsoleBase pSDSConsoleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDSConsoleBase.getCreateDate();
            }
            case 1: {
                return pSDSConsoleBase.getCreateMan();
            }
            case 2: {
                return pSDSConsoleBase.getDSTag();
            }
            case 3: {
                return pSDSConsoleBase.getDSTag2();
            }
            case 4: {
                return pSDSConsoleBase.getDSTag3();
            }
            case 5: {
                return pSDSConsoleBase.getDSTag4();
            }
            case 6: {
                return pSDSConsoleBase.getHttpAddress();
            }
            case 7: {
                return pSDSConsoleBase.getHttpPort();
            }
            case 8: {
                return pSDSConsoleBase.getPSConsoleServerId();
            }
            case 9: {
                return pSDSConsoleBase.getPSConsoleServerName();
            }
            case 10: {
                return pSDSConsoleBase.getPSDevSlnSysId();
            }
            case 11: {
                return pSDSConsoleBase.getPSDevUserId();
            }
            case 12: {
                return pSDSConsoleBase.getPSDSConsoleId();
            }
            case 13: {
                return pSDSConsoleBase.getPSDSConsoleName();
            }
            case 14: {
                return pSDSConsoleBase.getUpdateDate();
            }
            case 15: {
                return pSDSConsoleBase.getUpdateMan();
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
        PSDSConsoleBase.set(this, n, object);
    }

    private static void set(PSDSConsoleBase pSDSConsoleBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDSConsoleBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDSConsoleBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDSConsoleBase.setDSTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDSConsoleBase.setDSTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDSConsoleBase.setDSTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDSConsoleBase.setDSTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDSConsoleBase.setHttpAddress(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDSConsoleBase.setHttpPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDSConsoleBase.setPSConsoleServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDSConsoleBase.setPSConsoleServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDSConsoleBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDSConsoleBase.setPSDevUserId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDSConsoleBase.setPSDSConsoleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDSConsoleBase.setPSDSConsoleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDSConsoleBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSDSConsoleBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDSConsoleBase.isNull(this, n);
    }

    private static boolean isNull(PSDSConsoleBase pSDSConsoleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDSConsoleBase.getCreateDate() == null;
            }
            case 1: {
                return pSDSConsoleBase.getCreateMan() == null;
            }
            case 2: {
                return pSDSConsoleBase.getDSTag() == null;
            }
            case 3: {
                return pSDSConsoleBase.getDSTag2() == null;
            }
            case 4: {
                return pSDSConsoleBase.getDSTag3() == null;
            }
            case 5: {
                return pSDSConsoleBase.getDSTag4() == null;
            }
            case 6: {
                return pSDSConsoleBase.getHttpAddress() == null;
            }
            case 7: {
                return pSDSConsoleBase.getHttpPort() == null;
            }
            case 8: {
                return pSDSConsoleBase.getPSConsoleServerId() == null;
            }
            case 9: {
                return pSDSConsoleBase.getPSConsoleServerName() == null;
            }
            case 10: {
                return pSDSConsoleBase.getPSDevSlnSysId() == null;
            }
            case 11: {
                return pSDSConsoleBase.getPSDevUserId() == null;
            }
            case 12: {
                return pSDSConsoleBase.getPSDSConsoleId() == null;
            }
            case 13: {
                return pSDSConsoleBase.getPSDSConsoleName() == null;
            }
            case 14: {
                return pSDSConsoleBase.getUpdateDate() == null;
            }
            case 15: {
                return pSDSConsoleBase.getUpdateMan() == null;
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
        return PSDSConsoleBase.contains(this, n);
    }

    private static boolean contains(PSDSConsoleBase pSDSConsoleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDSConsoleBase.isCreateDateDirty();
            }
            case 1: {
                return pSDSConsoleBase.isCreateManDirty();
            }
            case 2: {
                return pSDSConsoleBase.isDSTagDirty();
            }
            case 3: {
                return pSDSConsoleBase.isDSTag2Dirty();
            }
            case 4: {
                return pSDSConsoleBase.isDSTag3Dirty();
            }
            case 5: {
                return pSDSConsoleBase.isDSTag4Dirty();
            }
            case 6: {
                return pSDSConsoleBase.isHttpAddressDirty();
            }
            case 7: {
                return pSDSConsoleBase.isHttpPortDirty();
            }
            case 8: {
                return pSDSConsoleBase.isPSConsoleServerIdDirty();
            }
            case 9: {
                return pSDSConsoleBase.isPSConsoleServerNameDirty();
            }
            case 10: {
                return pSDSConsoleBase.isPSDevSlnSysIdDirty();
            }
            case 11: {
                return pSDSConsoleBase.isPSDevUserIdDirty();
            }
            case 12: {
                return pSDSConsoleBase.isPSDSConsoleIdDirty();
            }
            case 13: {
                return pSDSConsoleBase.isPSDSConsoleNameDirty();
            }
            case 14: {
                return pSDSConsoleBase.isUpdateDateDirty();
            }
            case 15: {
                return pSDSConsoleBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDSConsoleBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDSConsoleBase pSDSConsoleBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDSConsoleBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDSConsoleBase.getJSONValue((Object)pSDSConsoleBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDSConsoleBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDSConsoleBase.getJSONValue((Object)pSDSConsoleBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDSConsoleBase.getDSTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstag", (Object)PSDSConsoleBase.getJSONValue((Object)pSDSConsoleBase.getDSTag()), (boolean)false);
        }
        if (bl || pSDSConsoleBase.getDSTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstag2", (Object)PSDSConsoleBase.getJSONValue((Object)pSDSConsoleBase.getDSTag2()), (boolean)false);
        }
        if (bl || pSDSConsoleBase.getDSTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstag3", (Object)PSDSConsoleBase.getJSONValue((Object)pSDSConsoleBase.getDSTag3()), (boolean)false);
        }
        if (bl || pSDSConsoleBase.getDSTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstag4", (Object)PSDSConsoleBase.getJSONValue((Object)pSDSConsoleBase.getDSTag4()), (boolean)false);
        }
        if (bl || pSDSConsoleBase.getHttpAddress() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"httpaddress", (Object)PSDSConsoleBase.getJSONValue((Object)pSDSConsoleBase.getHttpAddress()), (boolean)false);
        }
        if (bl || pSDSConsoleBase.getHttpPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"httpport", (Object)PSDSConsoleBase.getJSONValue((Object)pSDSConsoleBase.getHttpPort()), (boolean)false);
        }
        if (bl || pSDSConsoleBase.getPSConsoleServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psconsoleserverid", (Object)PSDSConsoleBase.getJSONValue((Object)pSDSConsoleBase.getPSConsoleServerId()), (boolean)false);
        }
        if (bl || pSDSConsoleBase.getPSConsoleServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psconsoleservername", (Object)PSDSConsoleBase.getJSONValue((Object)pSDSConsoleBase.getPSConsoleServerName()), (boolean)false);
        }
        if (bl || pSDSConsoleBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDSConsoleBase.getJSONValue((Object)pSDSConsoleBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDSConsoleBase.getPSDevUserId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevuserid", (Object)PSDSConsoleBase.getJSONValue((Object)pSDSConsoleBase.getPSDevUserId()), (boolean)false);
        }
        if (bl || pSDSConsoleBase.getPSDSConsoleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdsconsoleid", (Object)PSDSConsoleBase.getJSONValue((Object)pSDSConsoleBase.getPSDSConsoleId()), (boolean)false);
        }
        if (bl || pSDSConsoleBase.getPSDSConsoleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdsconsolename", (Object)PSDSConsoleBase.getJSONValue((Object)pSDSConsoleBase.getPSDSConsoleName()), (boolean)false);
        }
        if (bl || pSDSConsoleBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDSConsoleBase.getJSONValue((Object)pSDSConsoleBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDSConsoleBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDSConsoleBase.getJSONValue((Object)pSDSConsoleBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDSConsoleBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDSConsoleBase pSDSConsoleBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDSConsoleBase.getCreateDate() != null) {
            object = pSDSConsoleBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDSConsoleBase.getCreateMan() != null) {
            object = pSDSConsoleBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDSConsoleBase.getDSTag() != null) {
            object = pSDSConsoleBase.getDSTag();
            xmlNode.setAttribute(FIELD_DSTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDSConsoleBase.getDSTag2() != null) {
            object = pSDSConsoleBase.getDSTag2();
            xmlNode.setAttribute(FIELD_DSTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDSConsoleBase.getDSTag3() != null) {
            object = pSDSConsoleBase.getDSTag3();
            xmlNode.setAttribute(FIELD_DSTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDSConsoleBase.getDSTag4() != null) {
            object = pSDSConsoleBase.getDSTag4();
            xmlNode.setAttribute(FIELD_DSTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDSConsoleBase.getHttpAddress() != null) {
            object = pSDSConsoleBase.getHttpAddress();
            xmlNode.setAttribute(FIELD_HTTPADDRESS, object == null ? "" : (String)object);
        }
        if (bl || pSDSConsoleBase.getHttpPort() != null) {
            object = pSDSConsoleBase.getHttpPort();
            xmlNode.setAttribute(FIELD_HTTPPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDSConsoleBase.getPSConsoleServerId() != null) {
            object = pSDSConsoleBase.getPSConsoleServerId();
            xmlNode.setAttribute(FIELD_PSCONSOLESERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDSConsoleBase.getPSConsoleServerName() != null) {
            object = pSDSConsoleBase.getPSConsoleServerName();
            xmlNode.setAttribute(FIELD_PSCONSOLESERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDSConsoleBase.getPSDevSlnSysId() != null) {
            object = pSDSConsoleBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDSConsoleBase.getPSDevUserId() != null) {
            object = pSDSConsoleBase.getPSDevUserId();
            xmlNode.setAttribute(FIELD_PSDEVUSERID, object == null ? "" : (String)object);
        }
        if (bl || pSDSConsoleBase.getPSDSConsoleId() != null) {
            object = pSDSConsoleBase.getPSDSConsoleId();
            xmlNode.setAttribute(FIELD_PSDSCONSOLEID, object == null ? "" : (String)object);
        }
        if (bl || pSDSConsoleBase.getPSDSConsoleName() != null) {
            object = pSDSConsoleBase.getPSDSConsoleName();
            xmlNode.setAttribute(FIELD_PSDSCONSOLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDSConsoleBase.getUpdateDate() != null) {
            object = pSDSConsoleBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDSConsoleBase.getUpdateMan() != null) {
            object = pSDSConsoleBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDSConsoleBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDSConsoleBase pSDSConsoleBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDSConsoleBase.isCreateDateDirty() && (bl || pSDSConsoleBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDSConsoleBase.getCreateDate());
        }
        if (pSDSConsoleBase.isCreateManDirty() && (bl || pSDSConsoleBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDSConsoleBase.getCreateMan());
        }
        if (pSDSConsoleBase.isDSTagDirty() && (bl || pSDSConsoleBase.getDSTag() != null)) {
            iDataObject.set(FIELD_DSTAG, (Object)pSDSConsoleBase.getDSTag());
        }
        if (pSDSConsoleBase.isDSTag2Dirty() && (bl || pSDSConsoleBase.getDSTag2() != null)) {
            iDataObject.set(FIELD_DSTAG2, (Object)pSDSConsoleBase.getDSTag2());
        }
        if (pSDSConsoleBase.isDSTag3Dirty() && (bl || pSDSConsoleBase.getDSTag3() != null)) {
            iDataObject.set(FIELD_DSTAG3, (Object)pSDSConsoleBase.getDSTag3());
        }
        if (pSDSConsoleBase.isDSTag4Dirty() && (bl || pSDSConsoleBase.getDSTag4() != null)) {
            iDataObject.set(FIELD_DSTAG4, (Object)pSDSConsoleBase.getDSTag4());
        }
        if (pSDSConsoleBase.isHttpAddressDirty() && (bl || pSDSConsoleBase.getHttpAddress() != null)) {
            iDataObject.set(FIELD_HTTPADDRESS, (Object)pSDSConsoleBase.getHttpAddress());
        }
        if (pSDSConsoleBase.isHttpPortDirty() && (bl || pSDSConsoleBase.getHttpPort() != null)) {
            iDataObject.set(FIELD_HTTPPORT, (Object)pSDSConsoleBase.getHttpPort());
        }
        if (pSDSConsoleBase.isPSConsoleServerIdDirty() && (bl || pSDSConsoleBase.getPSConsoleServerId() != null)) {
            iDataObject.set(FIELD_PSCONSOLESERVERID, (Object)pSDSConsoleBase.getPSConsoleServerId());
        }
        if (pSDSConsoleBase.isPSConsoleServerNameDirty() && (bl || pSDSConsoleBase.getPSConsoleServerName() != null)) {
            iDataObject.set(FIELD_PSCONSOLESERVERNAME, (Object)pSDSConsoleBase.getPSConsoleServerName());
        }
        if (pSDSConsoleBase.isPSDevSlnSysIdDirty() && (bl || pSDSConsoleBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDSConsoleBase.getPSDevSlnSysId());
        }
        if (pSDSConsoleBase.isPSDevUserIdDirty() && (bl || pSDSConsoleBase.getPSDevUserId() != null)) {
            iDataObject.set(FIELD_PSDEVUSERID, (Object)pSDSConsoleBase.getPSDevUserId());
        }
        if (pSDSConsoleBase.isPSDSConsoleIdDirty() && (bl || pSDSConsoleBase.getPSDSConsoleId() != null)) {
            iDataObject.set(FIELD_PSDSCONSOLEID, (Object)pSDSConsoleBase.getPSDSConsoleId());
        }
        if (pSDSConsoleBase.isPSDSConsoleNameDirty() && (bl || pSDSConsoleBase.getPSDSConsoleName() != null)) {
            iDataObject.set(FIELD_PSDSCONSOLENAME, (Object)pSDSConsoleBase.getPSDSConsoleName());
        }
        if (pSDSConsoleBase.isUpdateDateDirty() && (bl || pSDSConsoleBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDSConsoleBase.getUpdateDate());
        }
        if (pSDSConsoleBase.isUpdateManDirty() && (bl || pSDSConsoleBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDSConsoleBase.getUpdateMan());
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
        return PSDSConsoleBase.remove(this, n);
    }

    private static boolean remove(PSDSConsoleBase pSDSConsoleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDSConsoleBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDSConsoleBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDSConsoleBase.resetDSTag();
                return true;
            }
            case 3: {
                pSDSConsoleBase.resetDSTag2();
                return true;
            }
            case 4: {
                pSDSConsoleBase.resetDSTag3();
                return true;
            }
            case 5: {
                pSDSConsoleBase.resetDSTag4();
                return true;
            }
            case 6: {
                pSDSConsoleBase.resetHttpAddress();
                return true;
            }
            case 7: {
                pSDSConsoleBase.resetHttpPort();
                return true;
            }
            case 8: {
                pSDSConsoleBase.resetPSConsoleServerId();
                return true;
            }
            case 9: {
                pSDSConsoleBase.resetPSConsoleServerName();
                return true;
            }
            case 10: {
                pSDSConsoleBase.resetPSDevSlnSysId();
                return true;
            }
            case 11: {
                pSDSConsoleBase.resetPSDevUserId();
                return true;
            }
            case 12: {
                pSDSConsoleBase.resetPSDSConsoleId();
                return true;
            }
            case 13: {
                pSDSConsoleBase.resetPSDSConsoleName();
                return true;
            }
            case 14: {
                pSDSConsoleBase.resetUpdateDate();
                return true;
            }
            case 15: {
                pSDSConsoleBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSConsoleServer getPSConsoleServer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSConsoleServer();
        }
        if (this.getPSConsoleServerId() == null) {
            return null;
        }
        Integer n = this.objPSConsoleServerLock;
        synchronized (n) {
            if (this.psconsoleserver != null && DataTypeHelper.compare((int)25, (Object)this.getPSConsoleServerId(), (Object)this.psconsoleserver.getPSConsoleServerId()) != 0L) {
                this.psconsoleserver = null;
            }
            if (this.psconsoleserver == null) {
                PSConsoleServer pSConsoleServer = new PSConsoleServer();
                pSConsoleServer.setPSConsoleServerId(this.getPSConsoleServerId());
                PSConsoleServerService pSConsoleServerService = (PSConsoleServerService)ServiceGlobal.getService(PSConsoleServerService.class, (SessionFactory)this.getSessionFactory());
                pSConsoleServerService.autoGet(pSConsoleServer);
                this.psconsoleserver = pSConsoleServer;
            }
            return this.psconsoleserver;
        }
    }

    private PSDSConsoleBase getProxyEntity() {
        return this.proxyPSDSConsoleBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDSConsoleBase = null;
        if (iDataObject != null && iDataObject instanceof PSDSConsoleBase) {
            this.proxyPSDSConsoleBase = (PSDSConsoleBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSDSConsoleService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DSTAG, 2);
        fieldIndexMap.put(FIELD_DSTAG2, 3);
        fieldIndexMap.put(FIELD_DSTAG3, 4);
        fieldIndexMap.put(FIELD_DSTAG4, 5);
        fieldIndexMap.put(FIELD_HTTPADDRESS, 6);
        fieldIndexMap.put(FIELD_HTTPPORT, 7);
        fieldIndexMap.put(FIELD_PSCONSOLESERVERID, 8);
        fieldIndexMap.put(FIELD_PSCONSOLESERVERNAME, 9);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 10);
        fieldIndexMap.put(FIELD_PSDEVUSERID, 11);
        fieldIndexMap.put(FIELD_PSDSCONSOLEID, 12);
        fieldIndexMap.put(FIELD_PSDSCONSOLENAME, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
    }
}

