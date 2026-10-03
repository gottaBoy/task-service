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
import net.ibizsys.pscore.srv.config.entity.PSDCASGroup;
import net.ibizsys.pscore.srv.config.service.PSDCASGroupService;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSln;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnHost;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnHostService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnASGroupBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDepSlnASGroupBase.class);
    public static final String FIELD_ASTYPE = "ASTYPE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENABLELOCALMODE = "ENABLELOCALMODE";
    public static final String FIELD_ENABLEREMOTEMODE = "ENABLEREMOTEMODE";
    public static final String FIELD_GROUPMODE = "GROUPMODE";
    public static final String FIELD_HTTPPORT = "HTTPPORT";
    public static final String FIELD_HTTPSPORT = "HTTPSPORT";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCASGROUPID = "PSDCASGROUPID";
    public static final String FIELD_PSDCASGROUPNAME = "PSDCASGROUPNAME";
    public static final String FIELD_PSDEPSLNASGROUPID = "PSDEPSLNASGRPID";
    public static final String FIELD_PSDEPSLNASGROUPNAME = "PSDEPSLNASGRPNAME";
    public static final String FIELD_PSDEPSLNHOSTID = "PSDEPSLNHOSTID";
    public static final String FIELD_PSDEPSLNHOSTNAME = "PSDEPSLNHOSTNAME";
    public static final String FIELD_PSDEPSLNID = "PSDEPSLNID";
    public static final String FIELD_PSDEPSLNNAME = "PSDEPSLNNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_ASTYPE = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_ENABLELOCALMODE = 3;
    private static final int INDEX_ENABLEREMOTEMODE = 4;
    private static final int INDEX_GROUPMODE = 5;
    private static final int INDEX_HTTPPORT = 6;
    private static final int INDEX_HTTPSPORT = 7;
    private static final int INDEX_MEMO = 8;
    private static final int INDEX_PSDCASGROUPID = 9;
    private static final int INDEX_PSDCASGROUPNAME = 10;
    private static final int INDEX_PSDEPSLNASGROUPID = 11;
    private static final int INDEX_PSDEPSLNASGROUPNAME = 12;
    private static final int INDEX_PSDEPSLNHOSTID = 13;
    private static final int INDEX_PSDEPSLNHOSTNAME = 14;
    private static final int INDEX_PSDEPSLNID = 15;
    private static final int INDEX_PSDEPSLNNAME = 16;
    private static final int INDEX_UPDATEDATE = 17;
    private static final int INDEX_UPDATEMAN = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDepSlnASGroupBase proxyPSDepSlnASGroupBase = null;
    private boolean astypeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean enablelocalmodeDirtyFlag = false;
    private boolean enableremotemodeDirtyFlag = false;
    private boolean groupmodeDirtyFlag = false;
    private boolean httpportDirtyFlag = false;
    private boolean httpsportDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcasgroupidDirtyFlag = false;
    private boolean psdcasgroupnameDirtyFlag = false;
    private boolean psdepslnasgroupidDirtyFlag = false;
    private boolean psdepslnasgroupnameDirtyFlag = false;
    private boolean psdepslnhostidDirtyFlag = false;
    private boolean psdepslnhostnameDirtyFlag = false;
    private boolean psdepslnidDirtyFlag = false;
    private boolean psdepslnnameDirtyFlag = false;
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
    @Column(name="groupmode")
    private String groupmode;
    @Column(name="httpport")
    private Integer httpport;
    @Column(name="httpsport")
    private Integer httpsport;
    @Column(name="memo")
    private String memo;
    @Column(name="psdcasgroupid")
    private String psdcasgroupid;
    @Column(name="psdcasgroupname")
    private String psdcasgroupname;
    @Column(name="psdepslnasgroupid")
    private String psdepslnasgroupid;
    @Column(name="psdepslnasgroupname")
    private String psdepslnasgroupname;
    @Column(name="psdepslnhostid")
    private String psdepslnhostid;
    @Column(name="psdepslnhostname")
    private String psdepslnhostname;
    @Column(name="psdepslnid")
    private String psdepslnid;
    @Column(name="psdepslnname")
    private String psdepslnname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDCASGroupLock = new Integer(1);
    private PSDCASGroup psdcasgroup = null;
    private Integer objPSDepSlnHostLock = new Integer(1);
    private PSDepSlnHost psdepslnhost = null;
    private Integer objPSDepSlnLock = new Integer(1);
    private PSDepSln psdepsln = null;

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

    public void setGroupMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.groupmode = string;
        this.groupmodeDirtyFlag = true;
    }

    public String getGroupMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupMode();
        }
        return this.groupmode;
    }

    public boolean isGroupModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupModeDirty();
        }
        return this.groupmodeDirtyFlag;
    }

    public void resetGroupMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupMode();
            return;
        }
        this.groupmodeDirtyFlag = false;
        this.groupmode = null;
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

    public void setHttpsPort(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHttpsPort(n);
            return;
        }
        this.httpsport = n;
        this.httpsportDirtyFlag = true;
    }

    public Integer getHttpsPort() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHttpsPort();
        }
        return this.httpsport;
    }

    public boolean isHttpsPortDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHttpsPortDirty();
        }
        return this.httpsportDirtyFlag;
    }

    public void resetHttpsPort() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHttpsPort();
            return;
        }
        this.httpsportDirtyFlag = false;
        this.httpsport = null;
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

    public void setPSDCASGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCASGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcasgroupid = string;
        this.psdcasgroupidDirtyFlag = true;
    }

    public String getPSDCASGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCASGroupId();
        }
        return this.psdcasgroupid;
    }

    public boolean isPSDCASGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCASGroupIdDirty();
        }
        return this.psdcasgroupidDirtyFlag;
    }

    public void resetPSDCASGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCASGroupId();
            return;
        }
        this.psdcasgroupidDirtyFlag = false;
        this.psdcasgroupid = null;
    }

    public void setPSDCASGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCASGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcasgroupname = string;
        this.psdcasgroupnameDirtyFlag = true;
    }

    public String getPSDCASGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCASGroupName();
        }
        return this.psdcasgroupname;
    }

    public boolean isPSDCASGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCASGroupNameDirty();
        }
        return this.psdcasgroupnameDirtyFlag;
    }

    public void resetPSDCASGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCASGroupName();
            return;
        }
        this.psdcasgroupnameDirtyFlag = false;
        this.psdcasgroupname = null;
    }

    public void setPSDepSlnASGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnASGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnasgroupid = string;
        this.psdepslnasgroupidDirtyFlag = true;
    }

    public String getPSDepSlnASGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnASGroupId();
        }
        return this.psdepslnasgroupid;
    }

    public boolean isPSDepSlnASGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnASGroupIdDirty();
        }
        return this.psdepslnasgroupidDirtyFlag;
    }

    public void resetPSDepSlnASGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnASGroupId();
            return;
        }
        this.psdepslnasgroupidDirtyFlag = false;
        this.psdepslnasgroupid = null;
    }

    public void setPSDepSlnASGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnASGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnasgroupname = string;
        this.psdepslnasgroupnameDirtyFlag = true;
    }

    public String getPSDepSlnASGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnASGroupName();
        }
        return this.psdepslnasgroupname;
    }

    public boolean isPSDepSlnASGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnASGroupNameDirty();
        }
        return this.psdepslnasgroupnameDirtyFlag;
    }

    public void resetPSDepSlnASGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnASGroupName();
            return;
        }
        this.psdepslnasgroupnameDirtyFlag = false;
        this.psdepslnasgroupname = null;
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
        PSDepSlnASGroupBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDepSlnASGroupBase pSDepSlnASGroupBase) {
        pSDepSlnASGroupBase.resetASType();
        pSDepSlnASGroupBase.resetCreateDate();
        pSDepSlnASGroupBase.resetCreateMan();
        pSDepSlnASGroupBase.resetEnableLocalMode();
        pSDepSlnASGroupBase.resetEnableRemoteMode();
        pSDepSlnASGroupBase.resetGroupMode();
        pSDepSlnASGroupBase.resetHttpPort();
        pSDepSlnASGroupBase.resetHttpsPort();
        pSDepSlnASGroupBase.resetMemo();
        pSDepSlnASGroupBase.resetPSDCASGroupId();
        pSDepSlnASGroupBase.resetPSDCASGroupName();
        pSDepSlnASGroupBase.resetPSDepSlnASGroupId();
        pSDepSlnASGroupBase.resetPSDepSlnASGroupName();
        pSDepSlnASGroupBase.resetPSDepSlnHostId();
        pSDepSlnASGroupBase.resetPSDepSlnHostName();
        pSDepSlnASGroupBase.resetPSDepSlnId();
        pSDepSlnASGroupBase.resetPSDepSlnName();
        pSDepSlnASGroupBase.resetUpdateDate();
        pSDepSlnASGroupBase.resetUpdateMan();
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
        if (!bl || this.isGroupModeDirty()) {
            hashMap.put(FIELD_GROUPMODE, this.getGroupMode());
        }
        if (!bl || this.isHttpPortDirty()) {
            hashMap.put(FIELD_HTTPPORT, this.getHttpPort());
        }
        if (!bl || this.isHttpsPortDirty()) {
            hashMap.put(FIELD_HTTPSPORT, this.getHttpsPort());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDCASGroupIdDirty()) {
            hashMap.put(FIELD_PSDCASGROUPID, this.getPSDCASGroupId());
        }
        if (!bl || this.isPSDCASGroupNameDirty()) {
            hashMap.put(FIELD_PSDCASGROUPNAME, this.getPSDCASGroupName());
        }
        if (!bl || this.isPSDepSlnASGroupIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNASGROUPID, this.getPSDepSlnASGroupId());
        }
        if (!bl || this.isPSDepSlnASGroupNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNASGROUPNAME, this.getPSDepSlnASGroupName());
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
        return PSDepSlnASGroupBase.get(this, n);
    }

    private static Object get(PSDepSlnASGroupBase pSDepSlnASGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnASGroupBase.getASType();
            }
            case 1: {
                return pSDepSlnASGroupBase.getCreateDate();
            }
            case 2: {
                return pSDepSlnASGroupBase.getCreateMan();
            }
            case 3: {
                return pSDepSlnASGroupBase.getEnableLocalMode();
            }
            case 4: {
                return pSDepSlnASGroupBase.getEnableRemoteMode();
            }
            case 5: {
                return pSDepSlnASGroupBase.getGroupMode();
            }
            case 6: {
                return pSDepSlnASGroupBase.getHttpPort();
            }
            case 7: {
                return pSDepSlnASGroupBase.getHttpsPort();
            }
            case 8: {
                return pSDepSlnASGroupBase.getMemo();
            }
            case 9: {
                return pSDepSlnASGroupBase.getPSDCASGroupId();
            }
            case 10: {
                return pSDepSlnASGroupBase.getPSDCASGroupName();
            }
            case 11: {
                return pSDepSlnASGroupBase.getPSDepSlnASGroupId();
            }
            case 12: {
                return pSDepSlnASGroupBase.getPSDepSlnASGroupName();
            }
            case 13: {
                return pSDepSlnASGroupBase.getPSDepSlnHostId();
            }
            case 14: {
                return pSDepSlnASGroupBase.getPSDepSlnHostName();
            }
            case 15: {
                return pSDepSlnASGroupBase.getPSDepSlnId();
            }
            case 16: {
                return pSDepSlnASGroupBase.getPSDepSlnName();
            }
            case 17: {
                return pSDepSlnASGroupBase.getUpdateDate();
            }
            case 18: {
                return pSDepSlnASGroupBase.getUpdateMan();
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
        PSDepSlnASGroupBase.set(this, n, object);
    }

    private static void set(PSDepSlnASGroupBase pSDepSlnASGroupBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnASGroupBase.setASType(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDepSlnASGroupBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDepSlnASGroupBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDepSlnASGroupBase.setEnableLocalMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDepSlnASGroupBase.setEnableRemoteMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDepSlnASGroupBase.setGroupMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDepSlnASGroupBase.setHttpPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDepSlnASGroupBase.setHttpsPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDepSlnASGroupBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDepSlnASGroupBase.setPSDCASGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDepSlnASGroupBase.setPSDCASGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDepSlnASGroupBase.setPSDepSlnASGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDepSlnASGroupBase.setPSDepSlnASGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDepSlnASGroupBase.setPSDepSlnHostId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDepSlnASGroupBase.setPSDepSlnHostName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDepSlnASGroupBase.setPSDepSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDepSlnASGroupBase.setPSDepSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDepSlnASGroupBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 18: {
                pSDepSlnASGroupBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDepSlnASGroupBase.isNull(this, n);
    }

    private static boolean isNull(PSDepSlnASGroupBase pSDepSlnASGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnASGroupBase.getASType() == null;
            }
            case 1: {
                return pSDepSlnASGroupBase.getCreateDate() == null;
            }
            case 2: {
                return pSDepSlnASGroupBase.getCreateMan() == null;
            }
            case 3: {
                return pSDepSlnASGroupBase.getEnableLocalMode() == null;
            }
            case 4: {
                return pSDepSlnASGroupBase.getEnableRemoteMode() == null;
            }
            case 5: {
                return pSDepSlnASGroupBase.getGroupMode() == null;
            }
            case 6: {
                return pSDepSlnASGroupBase.getHttpPort() == null;
            }
            case 7: {
                return pSDepSlnASGroupBase.getHttpsPort() == null;
            }
            case 8: {
                return pSDepSlnASGroupBase.getMemo() == null;
            }
            case 9: {
                return pSDepSlnASGroupBase.getPSDCASGroupId() == null;
            }
            case 10: {
                return pSDepSlnASGroupBase.getPSDCASGroupName() == null;
            }
            case 11: {
                return pSDepSlnASGroupBase.getPSDepSlnASGroupId() == null;
            }
            case 12: {
                return pSDepSlnASGroupBase.getPSDepSlnASGroupName() == null;
            }
            case 13: {
                return pSDepSlnASGroupBase.getPSDepSlnHostId() == null;
            }
            case 14: {
                return pSDepSlnASGroupBase.getPSDepSlnHostName() == null;
            }
            case 15: {
                return pSDepSlnASGroupBase.getPSDepSlnId() == null;
            }
            case 16: {
                return pSDepSlnASGroupBase.getPSDepSlnName() == null;
            }
            case 17: {
                return pSDepSlnASGroupBase.getUpdateDate() == null;
            }
            case 18: {
                return pSDepSlnASGroupBase.getUpdateMan() == null;
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
        return PSDepSlnASGroupBase.contains(this, n);
    }

    private static boolean contains(PSDepSlnASGroupBase pSDepSlnASGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnASGroupBase.isASTypeDirty();
            }
            case 1: {
                return pSDepSlnASGroupBase.isCreateDateDirty();
            }
            case 2: {
                return pSDepSlnASGroupBase.isCreateManDirty();
            }
            case 3: {
                return pSDepSlnASGroupBase.isEnableLocalModeDirty();
            }
            case 4: {
                return pSDepSlnASGroupBase.isEnableRemoteModeDirty();
            }
            case 5: {
                return pSDepSlnASGroupBase.isGroupModeDirty();
            }
            case 6: {
                return pSDepSlnASGroupBase.isHttpPortDirty();
            }
            case 7: {
                return pSDepSlnASGroupBase.isHttpsPortDirty();
            }
            case 8: {
                return pSDepSlnASGroupBase.isMemoDirty();
            }
            case 9: {
                return pSDepSlnASGroupBase.isPSDCASGroupIdDirty();
            }
            case 10: {
                return pSDepSlnASGroupBase.isPSDCASGroupNameDirty();
            }
            case 11: {
                return pSDepSlnASGroupBase.isPSDepSlnASGroupIdDirty();
            }
            case 12: {
                return pSDepSlnASGroupBase.isPSDepSlnASGroupNameDirty();
            }
            case 13: {
                return pSDepSlnASGroupBase.isPSDepSlnHostIdDirty();
            }
            case 14: {
                return pSDepSlnASGroupBase.isPSDepSlnHostNameDirty();
            }
            case 15: {
                return pSDepSlnASGroupBase.isPSDepSlnIdDirty();
            }
            case 16: {
                return pSDepSlnASGroupBase.isPSDepSlnNameDirty();
            }
            case 17: {
                return pSDepSlnASGroupBase.isUpdateDateDirty();
            }
            case 18: {
                return pSDepSlnASGroupBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDepSlnASGroupBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDepSlnASGroupBase pSDepSlnASGroupBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDepSlnASGroupBase.getASType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"astype", (Object)PSDepSlnASGroupBase.getJSONValue((Object)pSDepSlnASGroupBase.getASType()), (boolean)false);
        }
        if (bl || pSDepSlnASGroupBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDepSlnASGroupBase.getJSONValue((Object)pSDepSlnASGroupBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDepSlnASGroupBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDepSlnASGroupBase.getJSONValue((Object)pSDepSlnASGroupBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDepSlnASGroupBase.getEnableLocalMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablelocalmode", (Object)PSDepSlnASGroupBase.getJSONValue((Object)pSDepSlnASGroupBase.getEnableLocalMode()), (boolean)false);
        }
        if (bl || pSDepSlnASGroupBase.getEnableRemoteMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableremotemode", (Object)PSDepSlnASGroupBase.getJSONValue((Object)pSDepSlnASGroupBase.getEnableRemoteMode()), (boolean)false);
        }
        if (bl || pSDepSlnASGroupBase.getGroupMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupmode", (Object)PSDepSlnASGroupBase.getJSONValue((Object)pSDepSlnASGroupBase.getGroupMode()), (boolean)false);
        }
        if (bl || pSDepSlnASGroupBase.getHttpPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"httpport", (Object)PSDepSlnASGroupBase.getJSONValue((Object)pSDepSlnASGroupBase.getHttpPort()), (boolean)false);
        }
        if (bl || pSDepSlnASGroupBase.getHttpsPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"httpsport", (Object)PSDepSlnASGroupBase.getJSONValue((Object)pSDepSlnASGroupBase.getHttpsPort()), (boolean)false);
        }
        if (bl || pSDepSlnASGroupBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDepSlnASGroupBase.getJSONValue((Object)pSDepSlnASGroupBase.getMemo()), (boolean)false);
        }
        if (bl || pSDepSlnASGroupBase.getPSDCASGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcasgroupid", (Object)PSDepSlnASGroupBase.getJSONValue((Object)pSDepSlnASGroupBase.getPSDCASGroupId()), (boolean)false);
        }
        if (bl || pSDepSlnASGroupBase.getPSDCASGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcasgroupname", (Object)PSDepSlnASGroupBase.getJSONValue((Object)pSDepSlnASGroupBase.getPSDCASGroupName()), (boolean)false);
        }
        if (bl || pSDepSlnASGroupBase.getPSDepSlnASGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnasgrpid", (Object)PSDepSlnASGroupBase.getJSONValue((Object)pSDepSlnASGroupBase.getPSDepSlnASGroupId()), (boolean)false);
        }
        if (bl || pSDepSlnASGroupBase.getPSDepSlnASGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnasgrpname", (Object)PSDepSlnASGroupBase.getJSONValue((Object)pSDepSlnASGroupBase.getPSDepSlnASGroupName()), (boolean)false);
        }
        if (bl || pSDepSlnASGroupBase.getPSDepSlnHostId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnhostid", (Object)PSDepSlnASGroupBase.getJSONValue((Object)pSDepSlnASGroupBase.getPSDepSlnHostId()), (boolean)false);
        }
        if (bl || pSDepSlnASGroupBase.getPSDepSlnHostName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnhostname", (Object)PSDepSlnASGroupBase.getJSONValue((Object)pSDepSlnASGroupBase.getPSDepSlnHostName()), (boolean)false);
        }
        if (bl || pSDepSlnASGroupBase.getPSDepSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnid", (Object)PSDepSlnASGroupBase.getJSONValue((Object)pSDepSlnASGroupBase.getPSDepSlnId()), (boolean)false);
        }
        if (bl || pSDepSlnASGroupBase.getPSDepSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnname", (Object)PSDepSlnASGroupBase.getJSONValue((Object)pSDepSlnASGroupBase.getPSDepSlnName()), (boolean)false);
        }
        if (bl || pSDepSlnASGroupBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDepSlnASGroupBase.getJSONValue((Object)pSDepSlnASGroupBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDepSlnASGroupBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDepSlnASGroupBase.getJSONValue((Object)pSDepSlnASGroupBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDepSlnASGroupBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDepSlnASGroupBase pSDepSlnASGroupBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDepSlnASGroupBase.getASType() != null) {
            object = pSDepSlnASGroupBase.getASType();
            xmlNode.setAttribute(FIELD_ASTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnASGroupBase.getCreateDate() != null) {
            object = pSDepSlnASGroupBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnASGroupBase.getCreateMan() != null) {
            object = pSDepSlnASGroupBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnASGroupBase.getEnableLocalMode() != null) {
            object = pSDepSlnASGroupBase.getEnableLocalMode();
            xmlNode.setAttribute(FIELD_ENABLELOCALMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDepSlnASGroupBase.getEnableRemoteMode() != null) {
            object = pSDepSlnASGroupBase.getEnableRemoteMode();
            xmlNode.setAttribute(FIELD_ENABLEREMOTEMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDepSlnASGroupBase.getGroupMode() != null) {
            object = pSDepSlnASGroupBase.getGroupMode();
            xmlNode.setAttribute(FIELD_GROUPMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnASGroupBase.getHttpPort() != null) {
            object = pSDepSlnASGroupBase.getHttpPort();
            xmlNode.setAttribute(FIELD_HTTPPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDepSlnASGroupBase.getHttpsPort() != null) {
            object = pSDepSlnASGroupBase.getHttpsPort();
            xmlNode.setAttribute(FIELD_HTTPSPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDepSlnASGroupBase.getMemo() != null) {
            object = pSDepSlnASGroupBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnASGroupBase.getPSDCASGroupId() != null) {
            object = pSDepSlnASGroupBase.getPSDCASGroupId();
            xmlNode.setAttribute(FIELD_PSDCASGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnASGroupBase.getPSDCASGroupName() != null) {
            object = pSDepSlnASGroupBase.getPSDCASGroupName();
            xmlNode.setAttribute(FIELD_PSDCASGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnASGroupBase.getPSDepSlnASGroupId() != null) {
            object = pSDepSlnASGroupBase.getPSDepSlnASGroupId();
            xmlNode.setAttribute("PSDEPSLNASGROUPID", object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnASGroupBase.getPSDepSlnASGroupName() != null) {
            object = pSDepSlnASGroupBase.getPSDepSlnASGroupName();
            xmlNode.setAttribute("PSDEPSLNASGROUPNAME", object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnASGroupBase.getPSDepSlnHostId() != null) {
            object = pSDepSlnASGroupBase.getPSDepSlnHostId();
            xmlNode.setAttribute(FIELD_PSDEPSLNHOSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnASGroupBase.getPSDepSlnHostName() != null) {
            object = pSDepSlnASGroupBase.getPSDepSlnHostName();
            xmlNode.setAttribute(FIELD_PSDEPSLNHOSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnASGroupBase.getPSDepSlnId() != null) {
            object = pSDepSlnASGroupBase.getPSDepSlnId();
            xmlNode.setAttribute(FIELD_PSDEPSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnASGroupBase.getPSDepSlnName() != null) {
            object = pSDepSlnASGroupBase.getPSDepSlnName();
            xmlNode.setAttribute(FIELD_PSDEPSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnASGroupBase.getUpdateDate() != null) {
            object = pSDepSlnASGroupBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnASGroupBase.getUpdateMan() != null) {
            object = pSDepSlnASGroupBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDepSlnASGroupBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDepSlnASGroupBase pSDepSlnASGroupBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDepSlnASGroupBase.isASTypeDirty() && (bl || pSDepSlnASGroupBase.getASType() != null)) {
            iDataObject.set(FIELD_ASTYPE, (Object)pSDepSlnASGroupBase.getASType());
        }
        if (pSDepSlnASGroupBase.isCreateDateDirty() && (bl || pSDepSlnASGroupBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDepSlnASGroupBase.getCreateDate());
        }
        if (pSDepSlnASGroupBase.isCreateManDirty() && (bl || pSDepSlnASGroupBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDepSlnASGroupBase.getCreateMan());
        }
        if (pSDepSlnASGroupBase.isEnableLocalModeDirty() && (bl || pSDepSlnASGroupBase.getEnableLocalMode() != null)) {
            iDataObject.set(FIELD_ENABLELOCALMODE, (Object)pSDepSlnASGroupBase.getEnableLocalMode());
        }
        if (pSDepSlnASGroupBase.isEnableRemoteModeDirty() && (bl || pSDepSlnASGroupBase.getEnableRemoteMode() != null)) {
            iDataObject.set(FIELD_ENABLEREMOTEMODE, (Object)pSDepSlnASGroupBase.getEnableRemoteMode());
        }
        if (pSDepSlnASGroupBase.isGroupModeDirty() && (bl || pSDepSlnASGroupBase.getGroupMode() != null)) {
            iDataObject.set(FIELD_GROUPMODE, (Object)pSDepSlnASGroupBase.getGroupMode());
        }
        if (pSDepSlnASGroupBase.isHttpPortDirty() && (bl || pSDepSlnASGroupBase.getHttpPort() != null)) {
            iDataObject.set(FIELD_HTTPPORT, (Object)pSDepSlnASGroupBase.getHttpPort());
        }
        if (pSDepSlnASGroupBase.isHttpsPortDirty() && (bl || pSDepSlnASGroupBase.getHttpsPort() != null)) {
            iDataObject.set(FIELD_HTTPSPORT, (Object)pSDepSlnASGroupBase.getHttpsPort());
        }
        if (pSDepSlnASGroupBase.isMemoDirty() && (bl || pSDepSlnASGroupBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDepSlnASGroupBase.getMemo());
        }
        if (pSDepSlnASGroupBase.isPSDCASGroupIdDirty() && (bl || pSDepSlnASGroupBase.getPSDCASGroupId() != null)) {
            iDataObject.set(FIELD_PSDCASGROUPID, (Object)pSDepSlnASGroupBase.getPSDCASGroupId());
        }
        if (pSDepSlnASGroupBase.isPSDCASGroupNameDirty() && (bl || pSDepSlnASGroupBase.getPSDCASGroupName() != null)) {
            iDataObject.set(FIELD_PSDCASGROUPNAME, (Object)pSDepSlnASGroupBase.getPSDCASGroupName());
        }
        if (pSDepSlnASGroupBase.isPSDepSlnASGroupIdDirty() && (bl || pSDepSlnASGroupBase.getPSDepSlnASGroupId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNASGROUPID, (Object)pSDepSlnASGroupBase.getPSDepSlnASGroupId());
        }
        if (pSDepSlnASGroupBase.isPSDepSlnASGroupNameDirty() && (bl || pSDepSlnASGroupBase.getPSDepSlnASGroupName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNASGROUPNAME, (Object)pSDepSlnASGroupBase.getPSDepSlnASGroupName());
        }
        if (pSDepSlnASGroupBase.isPSDepSlnHostIdDirty() && (bl || pSDepSlnASGroupBase.getPSDepSlnHostId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNHOSTID, (Object)pSDepSlnASGroupBase.getPSDepSlnHostId());
        }
        if (pSDepSlnASGroupBase.isPSDepSlnHostNameDirty() && (bl || pSDepSlnASGroupBase.getPSDepSlnHostName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNHOSTNAME, (Object)pSDepSlnASGroupBase.getPSDepSlnHostName());
        }
        if (pSDepSlnASGroupBase.isPSDepSlnIdDirty() && (bl || pSDepSlnASGroupBase.getPSDepSlnId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNID, (Object)pSDepSlnASGroupBase.getPSDepSlnId());
        }
        if (pSDepSlnASGroupBase.isPSDepSlnNameDirty() && (bl || pSDepSlnASGroupBase.getPSDepSlnName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNNAME, (Object)pSDepSlnASGroupBase.getPSDepSlnName());
        }
        if (pSDepSlnASGroupBase.isUpdateDateDirty() && (bl || pSDepSlnASGroupBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDepSlnASGroupBase.getUpdateDate());
        }
        if (pSDepSlnASGroupBase.isUpdateManDirty() && (bl || pSDepSlnASGroupBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDepSlnASGroupBase.getUpdateMan());
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
        return PSDepSlnASGroupBase.remove(this, n);
    }

    private static boolean remove(PSDepSlnASGroupBase pSDepSlnASGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnASGroupBase.resetASType();
                return true;
            }
            case 1: {
                pSDepSlnASGroupBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDepSlnASGroupBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDepSlnASGroupBase.resetEnableLocalMode();
                return true;
            }
            case 4: {
                pSDepSlnASGroupBase.resetEnableRemoteMode();
                return true;
            }
            case 5: {
                pSDepSlnASGroupBase.resetGroupMode();
                return true;
            }
            case 6: {
                pSDepSlnASGroupBase.resetHttpPort();
                return true;
            }
            case 7: {
                pSDepSlnASGroupBase.resetHttpsPort();
                return true;
            }
            case 8: {
                pSDepSlnASGroupBase.resetMemo();
                return true;
            }
            case 9: {
                pSDepSlnASGroupBase.resetPSDCASGroupId();
                return true;
            }
            case 10: {
                pSDepSlnASGroupBase.resetPSDCASGroupName();
                return true;
            }
            case 11: {
                pSDepSlnASGroupBase.resetPSDepSlnASGroupId();
                return true;
            }
            case 12: {
                pSDepSlnASGroupBase.resetPSDepSlnASGroupName();
                return true;
            }
            case 13: {
                pSDepSlnASGroupBase.resetPSDepSlnHostId();
                return true;
            }
            case 14: {
                pSDepSlnASGroupBase.resetPSDepSlnHostName();
                return true;
            }
            case 15: {
                pSDepSlnASGroupBase.resetPSDepSlnId();
                return true;
            }
            case 16: {
                pSDepSlnASGroupBase.resetPSDepSlnName();
                return true;
            }
            case 17: {
                pSDepSlnASGroupBase.resetUpdateDate();
                return true;
            }
            case 18: {
                pSDepSlnASGroupBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCASGroup getPSDCASGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCASGroup();
        }
        if (this.getPSDCASGroupId() == null) {
            return null;
        }
        Integer n = this.objPSDCASGroupLock;
        synchronized (n) {
            if (this.psdcasgroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCASGroupId(), (Object)this.psdcasgroup.getPSDCASGroupId()) != 0L) {
                this.psdcasgroup = null;
            }
            if (this.psdcasgroup == null) {
                PSDCASGroup pSDCASGroup = new PSDCASGroup();
                pSDCASGroup.setPSDCASGroupId(this.getPSDCASGroupId());
                PSDCASGroupService pSDCASGroupService = (PSDCASGroupService)ServiceGlobal.getService(PSDCASGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDCASGroupService.autoGet(pSDCASGroup);
                this.psdcasgroup = pSDCASGroup;
            }
            return this.psdcasgroup;
        }
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

    private PSDepSlnASGroupBase getProxyEntity() {
        return this.proxyPSDepSlnASGroupBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDepSlnASGroupBase = null;
        if (iDataObject != null && iDataObject instanceof PSDepSlnASGroupBase) {
            this.proxyPSDepSlnASGroupBase = (PSDepSlnASGroupBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnASGroupService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ASTYPE, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_ENABLELOCALMODE, 3);
        fieldIndexMap.put(FIELD_ENABLEREMOTEMODE, 4);
        fieldIndexMap.put(FIELD_GROUPMODE, 5);
        fieldIndexMap.put(FIELD_HTTPPORT, 6);
        fieldIndexMap.put(FIELD_HTTPSPORT, 7);
        fieldIndexMap.put(FIELD_MEMO, 8);
        fieldIndexMap.put(FIELD_PSDCASGROUPID, 9);
        fieldIndexMap.put(FIELD_PSDCASGROUPNAME, 10);
        fieldIndexMap.put(FIELD_PSDEPSLNASGROUPID, 11);
        fieldIndexMap.put(FIELD_PSDEPSLNASGROUPNAME, 12);
        fieldIndexMap.put(FIELD_PSDEPSLNHOSTID, 13);
        fieldIndexMap.put(FIELD_PSDEPSLNHOSTNAME, 14);
        fieldIndexMap.put(FIELD_PSDEPSLNID, 15);
        fieldIndexMap.put(FIELD_PSDEPSLNNAME, 16);
        fieldIndexMap.put(FIELD_UPDATEDATE, 17);
        fieldIndexMap.put(FIELD_UPDATEMAN, 18);
    }
}

