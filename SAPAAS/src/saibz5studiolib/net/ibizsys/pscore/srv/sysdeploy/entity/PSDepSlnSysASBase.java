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
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSln;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnAS;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnASGroup;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSys;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSysApp;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnASGroupService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnASService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysAppService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnSysASBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDepSlnSysASBase.class);
    public static final String FIELD_CONTAINERTYPE = "CONTAINERTYPE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_NO2PSDEPSYSAPPID = "NO2PSDEPSYSAPPID";
    public static final String FIELD_NO2PSDEPSYSAPPNAME = "NO2PSDEPSYSAPPNAME";
    public static final String FIELD_PSDEPSLNASGROUPID = "PSDEPSLNASGRPID";
    public static final String FIELD_PSDEPSLNASGROUPNAME = "PSDEPSLNASGRPNAME";
    public static final String FIELD_PSDEPSLNASID = "PSDEPSLNASID";
    public static final String FIELD_PSDEPSLNASNAME = "PSDEPSLNASNAME";
    public static final String FIELD_PSDEPSLNID = "PSDEPSLNID";
    public static final String FIELD_PSDEPSLNNAME = "PSDEPSLNNAME";
    public static final String FIELD_PSDEPSLNSYSASID = "PSDEPSLNSYSASID";
    public static final String FIELD_PSDEPSLNSYSASNAME = "PSDEPSLNSYSASNAME";
    public static final String FIELD_PSDEPSLNSYSID = "PSDEPSLNSYSID";
    public static final String FIELD_PSDEPSLNSYSNAME = "PSDEPSLNSYSNAME";
    public static final String FIELD_PSDEPSYSAPPID = "PSDEPSYSAPPID";
    public static final String FIELD_PSDEPSYSAPPNAME = "PSDEPSYSAPPNAME";
    public static final String FIELD_SERVICECONTAINER = "SERVICECONTAINER";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CONTAINERTYPE = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_NO2PSDEPSYSAPPID = 4;
    private static final int INDEX_NO2PSDEPSYSAPPNAME = 5;
    private static final int INDEX_PSDEPSLNASGROUPID = 6;
    private static final int INDEX_PSDEPSLNASGROUPNAME = 7;
    private static final int INDEX_PSDEPSLNASID = 8;
    private static final int INDEX_PSDEPSLNASNAME = 9;
    private static final int INDEX_PSDEPSLNID = 10;
    private static final int INDEX_PSDEPSLNNAME = 11;
    private static final int INDEX_PSDEPSLNSYSASID = 12;
    private static final int INDEX_PSDEPSLNSYSASNAME = 13;
    private static final int INDEX_PSDEPSLNSYSID = 14;
    private static final int INDEX_PSDEPSLNSYSNAME = 15;
    private static final int INDEX_PSDEPSYSAPPID = 16;
    private static final int INDEX_PSDEPSYSAPPNAME = 17;
    private static final int INDEX_SERVICECONTAINER = 18;
    private static final int INDEX_UPDATEDATE = 19;
    private static final int INDEX_UPDATEMAN = 20;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDepSlnSysASBase proxyPSDepSlnSysASBase = null;
    private boolean containertypeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean no2psdepsysappidDirtyFlag = false;
    private boolean no2psdepsysappnameDirtyFlag = false;
    private boolean psdepslnasgroupidDirtyFlag = false;
    private boolean psdepslnasgroupnameDirtyFlag = false;
    private boolean psdepslnasidDirtyFlag = false;
    private boolean psdepslnasnameDirtyFlag = false;
    private boolean psdepslnidDirtyFlag = false;
    private boolean psdepslnnameDirtyFlag = false;
    private boolean psdepslnsysasidDirtyFlag = false;
    private boolean psdepslnsysasnameDirtyFlag = false;
    private boolean psdepslnsysidDirtyFlag = false;
    private boolean psdepslnsysnameDirtyFlag = false;
    private boolean psdepsysappidDirtyFlag = false;
    private boolean psdepsysappnameDirtyFlag = false;
    private boolean servicecontainerDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="containertype")
    private String containertype;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="no2psdepsysappid")
    private String no2psdepsysappid;
    @Column(name="no2psdepsysappname")
    private String no2psdepsysappname;
    @Column(name="psdepslnasgroupid")
    private String psdepslnasgroupid;
    @Column(name="psdepslnasgroupname")
    private String psdepslnasgroupname;
    @Column(name="psdepslnasid")
    private String psdepslnasid;
    @Column(name="psdepslnasname")
    private String psdepslnasname;
    @Column(name="psdepslnid")
    private String psdepslnid;
    @Column(name="psdepslnname")
    private String psdepslnname;
    @Column(name="psdepslnsysasid")
    private String psdepslnsysasid;
    @Column(name="psdepslnsysasname")
    private String psdepslnsysasname;
    @Column(name="psdepslnsysid")
    private String psdepslnsysid;
    @Column(name="psdepslnsysname")
    private String psdepslnsysname;
    @Column(name="psdepsysappid")
    private String psdepsysappid;
    @Column(name="psdepsysappname")
    private String psdepsysappname;
    @Column(name="servicecontainer")
    private String servicecontainer;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDepSlnASGrpLock = new Integer(1);
    private PSDepSlnASGroup psdepslnasgrp = null;
    private Integer objPSDepSlnASLock = new Integer(1);
    private PSDepSlnAS psdepslnas = null;
    private Integer objPSDepSlnSysLock = new Integer(1);
    private PSDepSlnSys psdepslnsys = null;
    private Integer objPSDepSlnLock = new Integer(1);
    private PSDepSln psdepsln = null;
    private Integer objNo2PSDepSysAppLock = new Integer(1);
    private PSDepSysApp no2psdepsysapp = null;
    private Integer objPSDepSysAppLock = new Integer(1);
    private PSDepSysApp psdepsysapp = null;

    public void setContainerType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContainerType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.containertype = string;
        this.containertypeDirtyFlag = true;
    }

    public String getContainerType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContainerType();
        }
        return this.containertype;
    }

    public boolean isContainerTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContainerTypeDirty();
        }
        return this.containertypeDirtyFlag;
    }

    public void resetContainerType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContainerType();
            return;
        }
        this.containertypeDirtyFlag = false;
        this.containertype = null;
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

    public void setNo2PSDepSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo2PSDepSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no2psdepsysappid = string;
        this.no2psdepsysappidDirtyFlag = true;
    }

    public String getNo2PSDepSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PSDepSysAppId();
        }
        return this.no2psdepsysappid;
    }

    public boolean isNo2PSDepSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo2PSDepSysAppIdDirty();
        }
        return this.no2psdepsysappidDirtyFlag;
    }

    public void resetNo2PSDepSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo2PSDepSysAppId();
            return;
        }
        this.no2psdepsysappidDirtyFlag = false;
        this.no2psdepsysappid = null;
    }

    public void setNo2PSDepSysAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo2PSDepSysAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no2psdepsysappname = string;
        this.no2psdepsysappnameDirtyFlag = true;
    }

    public String getNo2PSDepSysAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PSDepSysAppName();
        }
        return this.no2psdepsysappname;
    }

    public boolean isNo2PSDepSysAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo2PSDepSysAppNameDirty();
        }
        return this.no2psdepsysappnameDirtyFlag;
    }

    public void resetNo2PSDepSysAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo2PSDepSysAppName();
            return;
        }
        this.no2psdepsysappnameDirtyFlag = false;
        this.no2psdepsysappname = null;
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

    public void setPSDepSlnSysASId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnSysASId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnsysasid = string;
        this.psdepslnsysasidDirtyFlag = true;
    }

    public String getPSDepSlnSysASId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysASId();
        }
        return this.psdepslnsysasid;
    }

    public boolean isPSDepSlnSysASIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnSysASIdDirty();
        }
        return this.psdepslnsysasidDirtyFlag;
    }

    public void resetPSDepSlnSysASId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnSysASId();
            return;
        }
        this.psdepslnsysasidDirtyFlag = false;
        this.psdepslnsysasid = null;
    }

    public void setPSDepSlnSysASName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnSysASName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnsysasname = string;
        this.psdepslnsysasnameDirtyFlag = true;
    }

    public String getPSDepSlnSysASName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysASName();
        }
        return this.psdepslnsysasname;
    }

    public boolean isPSDepSlnSysASNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnSysASNameDirty();
        }
        return this.psdepslnsysasnameDirtyFlag;
    }

    public void resetPSDepSlnSysASName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnSysASName();
            return;
        }
        this.psdepslnsysasnameDirtyFlag = false;
        this.psdepslnsysasname = null;
    }

    public void setPSDepSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnsysid = string;
        this.psdepslnsysidDirtyFlag = true;
    }

    public String getPSDepSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysId();
        }
        return this.psdepslnsysid;
    }

    public boolean isPSDepSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnSysIdDirty();
        }
        return this.psdepslnsysidDirtyFlag;
    }

    public void resetPSDepSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnSysId();
            return;
        }
        this.psdepslnsysidDirtyFlag = false;
        this.psdepslnsysid = null;
    }

    public void setPSDepSlnSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnsysname = string;
        this.psdepslnsysnameDirtyFlag = true;
    }

    public String getPSDepSlnSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysName();
        }
        return this.psdepslnsysname;
    }

    public boolean isPSDepSlnSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnSysNameDirty();
        }
        return this.psdepslnsysnameDirtyFlag;
    }

    public void resetPSDepSlnSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnSysName();
            return;
        }
        this.psdepslnsysnameDirtyFlag = false;
        this.psdepslnsysname = null;
    }

    public void setPSDepSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepsysappid = string;
        this.psdepsysappidDirtyFlag = true;
    }

    public String getPSDepSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSysAppId();
        }
        return this.psdepsysappid;
    }

    public boolean isPSDepSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSysAppIdDirty();
        }
        return this.psdepsysappidDirtyFlag;
    }

    public void resetPSDepSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSysAppId();
            return;
        }
        this.psdepsysappidDirtyFlag = false;
        this.psdepsysappid = null;
    }

    public void setPSDepSysAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSysAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepsysappname = string;
        this.psdepsysappnameDirtyFlag = true;
    }

    public String getPSDepSysAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSysAppName();
        }
        return this.psdepsysappname;
    }

    public boolean isPSDepSysAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSysAppNameDirty();
        }
        return this.psdepsysappnameDirtyFlag;
    }

    public void resetPSDepSysAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSysAppName();
            return;
        }
        this.psdepsysappnameDirtyFlag = false;
        this.psdepsysappname = null;
    }

    public void setServiceContainer(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceContainer(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.servicecontainer = string;
        this.servicecontainerDirtyFlag = true;
    }

    public String getServiceContainer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceContainer();
        }
        return this.servicecontainer;
    }

    public boolean isServiceContainerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceContainerDirty();
        }
        return this.servicecontainerDirtyFlag;
    }

    public void resetServiceContainer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceContainer();
            return;
        }
        this.servicecontainerDirtyFlag = false;
        this.servicecontainer = null;
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
        PSDepSlnSysASBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDepSlnSysASBase pSDepSlnSysASBase) {
        pSDepSlnSysASBase.resetContainerType();
        pSDepSlnSysASBase.resetCreateDate();
        pSDepSlnSysASBase.resetCreateMan();
        pSDepSlnSysASBase.resetMemo();
        pSDepSlnSysASBase.resetNo2PSDepSysAppId();
        pSDepSlnSysASBase.resetNo2PSDepSysAppName();
        pSDepSlnSysASBase.resetPSDepSlnASGroupId();
        pSDepSlnSysASBase.resetPSDepSlnASGroupName();
        pSDepSlnSysASBase.resetPSDepSlnASId();
        pSDepSlnSysASBase.resetPSDepSlnASName();
        pSDepSlnSysASBase.resetPSDepSlnId();
        pSDepSlnSysASBase.resetPSDepSlnName();
        pSDepSlnSysASBase.resetPSDepSlnSysASId();
        pSDepSlnSysASBase.resetPSDepSlnSysASName();
        pSDepSlnSysASBase.resetPSDepSlnSysId();
        pSDepSlnSysASBase.resetPSDepSlnSysName();
        pSDepSlnSysASBase.resetPSDepSysAppId();
        pSDepSlnSysASBase.resetPSDepSysAppName();
        pSDepSlnSysASBase.resetServiceContainer();
        pSDepSlnSysASBase.resetUpdateDate();
        pSDepSlnSysASBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isContainerTypeDirty()) {
            hashMap.put(FIELD_CONTAINERTYPE, this.getContainerType());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isNo2PSDepSysAppIdDirty()) {
            hashMap.put(FIELD_NO2PSDEPSYSAPPID, this.getNo2PSDepSysAppId());
        }
        if (!bl || this.isNo2PSDepSysAppNameDirty()) {
            hashMap.put(FIELD_NO2PSDEPSYSAPPNAME, this.getNo2PSDepSysAppName());
        }
        if (!bl || this.isPSDepSlnASGroupIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNASGROUPID, this.getPSDepSlnASGroupId());
        }
        if (!bl || this.isPSDepSlnASGroupNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNASGROUPNAME, this.getPSDepSlnASGroupName());
        }
        if (!bl || this.isPSDepSlnASIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNASID, this.getPSDepSlnASId());
        }
        if (!bl || this.isPSDepSlnASNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNASNAME, this.getPSDepSlnASName());
        }
        if (!bl || this.isPSDepSlnIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNID, this.getPSDepSlnId());
        }
        if (!bl || this.isPSDepSlnNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNNAME, this.getPSDepSlnName());
        }
        if (!bl || this.isPSDepSlnSysASIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSASID, this.getPSDepSlnSysASId());
        }
        if (!bl || this.isPSDepSlnSysASNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSASNAME, this.getPSDepSlnSysASName());
        }
        if (!bl || this.isPSDepSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSID, this.getPSDepSlnSysId());
        }
        if (!bl || this.isPSDepSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSNAME, this.getPSDepSlnSysName());
        }
        if (!bl || this.isPSDepSysAppIdDirty()) {
            hashMap.put(FIELD_PSDEPSYSAPPID, this.getPSDepSysAppId());
        }
        if (!bl || this.isPSDepSysAppNameDirty()) {
            hashMap.put(FIELD_PSDEPSYSAPPNAME, this.getPSDepSysAppName());
        }
        if (!bl || this.isServiceContainerDirty()) {
            hashMap.put(FIELD_SERVICECONTAINER, this.getServiceContainer());
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
        return PSDepSlnSysASBase.get(this, n);
    }

    private static Object get(PSDepSlnSysASBase pSDepSlnSysASBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnSysASBase.getContainerType();
            }
            case 1: {
                return pSDepSlnSysASBase.getCreateDate();
            }
            case 2: {
                return pSDepSlnSysASBase.getCreateMan();
            }
            case 3: {
                return pSDepSlnSysASBase.getMemo();
            }
            case 4: {
                return pSDepSlnSysASBase.getNo2PSDepSysAppId();
            }
            case 5: {
                return pSDepSlnSysASBase.getNo2PSDepSysAppName();
            }
            case 6: {
                return pSDepSlnSysASBase.getPSDepSlnASGroupId();
            }
            case 7: {
                return pSDepSlnSysASBase.getPSDepSlnASGroupName();
            }
            case 8: {
                return pSDepSlnSysASBase.getPSDepSlnASId();
            }
            case 9: {
                return pSDepSlnSysASBase.getPSDepSlnASName();
            }
            case 10: {
                return pSDepSlnSysASBase.getPSDepSlnId();
            }
            case 11: {
                return pSDepSlnSysASBase.getPSDepSlnName();
            }
            case 12: {
                return pSDepSlnSysASBase.getPSDepSlnSysASId();
            }
            case 13: {
                return pSDepSlnSysASBase.getPSDepSlnSysASName();
            }
            case 14: {
                return pSDepSlnSysASBase.getPSDepSlnSysId();
            }
            case 15: {
                return pSDepSlnSysASBase.getPSDepSlnSysName();
            }
            case 16: {
                return pSDepSlnSysASBase.getPSDepSysAppId();
            }
            case 17: {
                return pSDepSlnSysASBase.getPSDepSysAppName();
            }
            case 18: {
                return pSDepSlnSysASBase.getServiceContainer();
            }
            case 19: {
                return pSDepSlnSysASBase.getUpdateDate();
            }
            case 20: {
                return pSDepSlnSysASBase.getUpdateMan();
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
        PSDepSlnSysASBase.set(this, n, object);
    }

    private static void set(PSDepSlnSysASBase pSDepSlnSysASBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnSysASBase.setContainerType(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDepSlnSysASBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDepSlnSysASBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDepSlnSysASBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDepSlnSysASBase.setNo2PSDepSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDepSlnSysASBase.setNo2PSDepSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDepSlnSysASBase.setPSDepSlnASGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDepSlnSysASBase.setPSDepSlnASGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDepSlnSysASBase.setPSDepSlnASId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDepSlnSysASBase.setPSDepSlnASName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDepSlnSysASBase.setPSDepSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDepSlnSysASBase.setPSDepSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDepSlnSysASBase.setPSDepSlnSysASId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDepSlnSysASBase.setPSDepSlnSysASName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDepSlnSysASBase.setPSDepSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDepSlnSysASBase.setPSDepSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDepSlnSysASBase.setPSDepSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDepSlnSysASBase.setPSDepSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDepSlnSysASBase.setServiceContainer(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDepSlnSysASBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSDepSlnSysASBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDepSlnSysASBase.isNull(this, n);
    }

    private static boolean isNull(PSDepSlnSysASBase pSDepSlnSysASBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnSysASBase.getContainerType() == null;
            }
            case 1: {
                return pSDepSlnSysASBase.getCreateDate() == null;
            }
            case 2: {
                return pSDepSlnSysASBase.getCreateMan() == null;
            }
            case 3: {
                return pSDepSlnSysASBase.getMemo() == null;
            }
            case 4: {
                return pSDepSlnSysASBase.getNo2PSDepSysAppId() == null;
            }
            case 5: {
                return pSDepSlnSysASBase.getNo2PSDepSysAppName() == null;
            }
            case 6: {
                return pSDepSlnSysASBase.getPSDepSlnASGroupId() == null;
            }
            case 7: {
                return pSDepSlnSysASBase.getPSDepSlnASGroupName() == null;
            }
            case 8: {
                return pSDepSlnSysASBase.getPSDepSlnASId() == null;
            }
            case 9: {
                return pSDepSlnSysASBase.getPSDepSlnASName() == null;
            }
            case 10: {
                return pSDepSlnSysASBase.getPSDepSlnId() == null;
            }
            case 11: {
                return pSDepSlnSysASBase.getPSDepSlnName() == null;
            }
            case 12: {
                return pSDepSlnSysASBase.getPSDepSlnSysASId() == null;
            }
            case 13: {
                return pSDepSlnSysASBase.getPSDepSlnSysASName() == null;
            }
            case 14: {
                return pSDepSlnSysASBase.getPSDepSlnSysId() == null;
            }
            case 15: {
                return pSDepSlnSysASBase.getPSDepSlnSysName() == null;
            }
            case 16: {
                return pSDepSlnSysASBase.getPSDepSysAppId() == null;
            }
            case 17: {
                return pSDepSlnSysASBase.getPSDepSysAppName() == null;
            }
            case 18: {
                return pSDepSlnSysASBase.getServiceContainer() == null;
            }
            case 19: {
                return pSDepSlnSysASBase.getUpdateDate() == null;
            }
            case 20: {
                return pSDepSlnSysASBase.getUpdateMan() == null;
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
        return PSDepSlnSysASBase.contains(this, n);
    }

    private static boolean contains(PSDepSlnSysASBase pSDepSlnSysASBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnSysASBase.isContainerTypeDirty();
            }
            case 1: {
                return pSDepSlnSysASBase.isCreateDateDirty();
            }
            case 2: {
                return pSDepSlnSysASBase.isCreateManDirty();
            }
            case 3: {
                return pSDepSlnSysASBase.isMemoDirty();
            }
            case 4: {
                return pSDepSlnSysASBase.isNo2PSDepSysAppIdDirty();
            }
            case 5: {
                return pSDepSlnSysASBase.isNo2PSDepSysAppNameDirty();
            }
            case 6: {
                return pSDepSlnSysASBase.isPSDepSlnASGroupIdDirty();
            }
            case 7: {
                return pSDepSlnSysASBase.isPSDepSlnASGroupNameDirty();
            }
            case 8: {
                return pSDepSlnSysASBase.isPSDepSlnASIdDirty();
            }
            case 9: {
                return pSDepSlnSysASBase.isPSDepSlnASNameDirty();
            }
            case 10: {
                return pSDepSlnSysASBase.isPSDepSlnIdDirty();
            }
            case 11: {
                return pSDepSlnSysASBase.isPSDepSlnNameDirty();
            }
            case 12: {
                return pSDepSlnSysASBase.isPSDepSlnSysASIdDirty();
            }
            case 13: {
                return pSDepSlnSysASBase.isPSDepSlnSysASNameDirty();
            }
            case 14: {
                return pSDepSlnSysASBase.isPSDepSlnSysIdDirty();
            }
            case 15: {
                return pSDepSlnSysASBase.isPSDepSlnSysNameDirty();
            }
            case 16: {
                return pSDepSlnSysASBase.isPSDepSysAppIdDirty();
            }
            case 17: {
                return pSDepSlnSysASBase.isPSDepSysAppNameDirty();
            }
            case 18: {
                return pSDepSlnSysASBase.isServiceContainerDirty();
            }
            case 19: {
                return pSDepSlnSysASBase.isUpdateDateDirty();
            }
            case 20: {
                return pSDepSlnSysASBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDepSlnSysASBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDepSlnSysASBase pSDepSlnSysASBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDepSlnSysASBase.getContainerType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"containertype", (Object)PSDepSlnSysASBase.getJSONValue((Object)pSDepSlnSysASBase.getContainerType()), (boolean)false);
        }
        if (bl || pSDepSlnSysASBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDepSlnSysASBase.getJSONValue((Object)pSDepSlnSysASBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDepSlnSysASBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDepSlnSysASBase.getJSONValue((Object)pSDepSlnSysASBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDepSlnSysASBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDepSlnSysASBase.getJSONValue((Object)pSDepSlnSysASBase.getMemo()), (boolean)false);
        }
        if (bl || pSDepSlnSysASBase.getNo2PSDepSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2psdepsysappid", (Object)PSDepSlnSysASBase.getJSONValue((Object)pSDepSlnSysASBase.getNo2PSDepSysAppId()), (boolean)false);
        }
        if (bl || pSDepSlnSysASBase.getNo2PSDepSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2psdepsysappname", (Object)PSDepSlnSysASBase.getJSONValue((Object)pSDepSlnSysASBase.getNo2PSDepSysAppName()), (boolean)false);
        }
        if (bl || pSDepSlnSysASBase.getPSDepSlnASGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnasgrpid", (Object)PSDepSlnSysASBase.getJSONValue((Object)pSDepSlnSysASBase.getPSDepSlnASGroupId()), (boolean)false);
        }
        if (bl || pSDepSlnSysASBase.getPSDepSlnASGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnasgrpname", (Object)PSDepSlnSysASBase.getJSONValue((Object)pSDepSlnSysASBase.getPSDepSlnASGroupName()), (boolean)false);
        }
        if (bl || pSDepSlnSysASBase.getPSDepSlnASId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnasid", (Object)PSDepSlnSysASBase.getJSONValue((Object)pSDepSlnSysASBase.getPSDepSlnASId()), (boolean)false);
        }
        if (bl || pSDepSlnSysASBase.getPSDepSlnASName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnasname", (Object)PSDepSlnSysASBase.getJSONValue((Object)pSDepSlnSysASBase.getPSDepSlnASName()), (boolean)false);
        }
        if (bl || pSDepSlnSysASBase.getPSDepSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnid", (Object)PSDepSlnSysASBase.getJSONValue((Object)pSDepSlnSysASBase.getPSDepSlnId()), (boolean)false);
        }
        if (bl || pSDepSlnSysASBase.getPSDepSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnname", (Object)PSDepSlnSysASBase.getJSONValue((Object)pSDepSlnSysASBase.getPSDepSlnName()), (boolean)false);
        }
        if (bl || pSDepSlnSysASBase.getPSDepSlnSysASId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysasid", (Object)PSDepSlnSysASBase.getJSONValue((Object)pSDepSlnSysASBase.getPSDepSlnSysASId()), (boolean)false);
        }
        if (bl || pSDepSlnSysASBase.getPSDepSlnSysASName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysasname", (Object)PSDepSlnSysASBase.getJSONValue((Object)pSDepSlnSysASBase.getPSDepSlnSysASName()), (boolean)false);
        }
        if (bl || pSDepSlnSysASBase.getPSDepSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysid", (Object)PSDepSlnSysASBase.getJSONValue((Object)pSDepSlnSysASBase.getPSDepSlnSysId()), (boolean)false);
        }
        if (bl || pSDepSlnSysASBase.getPSDepSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysname", (Object)PSDepSlnSysASBase.getJSONValue((Object)pSDepSlnSysASBase.getPSDepSlnSysName()), (boolean)false);
        }
        if (bl || pSDepSlnSysASBase.getPSDepSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepsysappid", (Object)PSDepSlnSysASBase.getJSONValue((Object)pSDepSlnSysASBase.getPSDepSysAppId()), (boolean)false);
        }
        if (bl || pSDepSlnSysASBase.getPSDepSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepsysappname", (Object)PSDepSlnSysASBase.getJSONValue((Object)pSDepSlnSysASBase.getPSDepSysAppName()), (boolean)false);
        }
        if (bl || pSDepSlnSysASBase.getServiceContainer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"servicecontainer", (Object)PSDepSlnSysASBase.getJSONValue((Object)pSDepSlnSysASBase.getServiceContainer()), (boolean)false);
        }
        if (bl || pSDepSlnSysASBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDepSlnSysASBase.getJSONValue((Object)pSDepSlnSysASBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDepSlnSysASBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDepSlnSysASBase.getJSONValue((Object)pSDepSlnSysASBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDepSlnSysASBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDepSlnSysASBase pSDepSlnSysASBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDepSlnSysASBase.getContainerType() != null) {
            object = pSDepSlnSysASBase.getContainerType();
            xmlNode.setAttribute(FIELD_CONTAINERTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysASBase.getCreateDate() != null) {
            object = pSDepSlnSysASBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnSysASBase.getCreateMan() != null) {
            object = pSDepSlnSysASBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysASBase.getMemo() != null) {
            object = pSDepSlnSysASBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysASBase.getNo2PSDepSysAppId() != null) {
            object = pSDepSlnSysASBase.getNo2PSDepSysAppId();
            xmlNode.setAttribute(FIELD_NO2PSDEPSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysASBase.getNo2PSDepSysAppName() != null) {
            object = pSDepSlnSysASBase.getNo2PSDepSysAppName();
            xmlNode.setAttribute(FIELD_NO2PSDEPSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysASBase.getPSDepSlnASGroupId() != null) {
            object = pSDepSlnSysASBase.getPSDepSlnASGroupId();
            xmlNode.setAttribute("PSDEPSLNASGROUPID", object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysASBase.getPSDepSlnASGroupName() != null) {
            object = pSDepSlnSysASBase.getPSDepSlnASGroupName();
            xmlNode.setAttribute("PSDEPSLNASGROUPNAME", object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysASBase.getPSDepSlnASId() != null) {
            object = pSDepSlnSysASBase.getPSDepSlnASId();
            xmlNode.setAttribute(FIELD_PSDEPSLNASID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysASBase.getPSDepSlnASName() != null) {
            object = pSDepSlnSysASBase.getPSDepSlnASName();
            xmlNode.setAttribute(FIELD_PSDEPSLNASNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysASBase.getPSDepSlnId() != null) {
            object = pSDepSlnSysASBase.getPSDepSlnId();
            xmlNode.setAttribute(FIELD_PSDEPSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysASBase.getPSDepSlnName() != null) {
            object = pSDepSlnSysASBase.getPSDepSlnName();
            xmlNode.setAttribute(FIELD_PSDEPSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysASBase.getPSDepSlnSysASId() != null) {
            object = pSDepSlnSysASBase.getPSDepSlnSysASId();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSASID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysASBase.getPSDepSlnSysASName() != null) {
            object = pSDepSlnSysASBase.getPSDepSlnSysASName();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSASNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysASBase.getPSDepSlnSysId() != null) {
            object = pSDepSlnSysASBase.getPSDepSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysASBase.getPSDepSlnSysName() != null) {
            object = pSDepSlnSysASBase.getPSDepSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysASBase.getPSDepSysAppId() != null) {
            object = pSDepSlnSysASBase.getPSDepSysAppId();
            xmlNode.setAttribute(FIELD_PSDEPSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysASBase.getPSDepSysAppName() != null) {
            object = pSDepSlnSysASBase.getPSDepSysAppName();
            xmlNode.setAttribute(FIELD_PSDEPSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysASBase.getServiceContainer() != null) {
            object = pSDepSlnSysASBase.getServiceContainer();
            xmlNode.setAttribute(FIELD_SERVICECONTAINER, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysASBase.getUpdateDate() != null) {
            object = pSDepSlnSysASBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnSysASBase.getUpdateMan() != null) {
            object = pSDepSlnSysASBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDepSlnSysASBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDepSlnSysASBase pSDepSlnSysASBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDepSlnSysASBase.isContainerTypeDirty() && (bl || pSDepSlnSysASBase.getContainerType() != null)) {
            iDataObject.set(FIELD_CONTAINERTYPE, (Object)pSDepSlnSysASBase.getContainerType());
        }
        if (pSDepSlnSysASBase.isCreateDateDirty() && (bl || pSDepSlnSysASBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDepSlnSysASBase.getCreateDate());
        }
        if (pSDepSlnSysASBase.isCreateManDirty() && (bl || pSDepSlnSysASBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDepSlnSysASBase.getCreateMan());
        }
        if (pSDepSlnSysASBase.isMemoDirty() && (bl || pSDepSlnSysASBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDepSlnSysASBase.getMemo());
        }
        if (pSDepSlnSysASBase.isNo2PSDepSysAppIdDirty() && (bl || pSDepSlnSysASBase.getNo2PSDepSysAppId() != null)) {
            iDataObject.set(FIELD_NO2PSDEPSYSAPPID, (Object)pSDepSlnSysASBase.getNo2PSDepSysAppId());
        }
        if (pSDepSlnSysASBase.isNo2PSDepSysAppNameDirty() && (bl || pSDepSlnSysASBase.getNo2PSDepSysAppName() != null)) {
            iDataObject.set(FIELD_NO2PSDEPSYSAPPNAME, (Object)pSDepSlnSysASBase.getNo2PSDepSysAppName());
        }
        if (pSDepSlnSysASBase.isPSDepSlnASGroupIdDirty() && (bl || pSDepSlnSysASBase.getPSDepSlnASGroupId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNASGROUPID, (Object)pSDepSlnSysASBase.getPSDepSlnASGroupId());
        }
        if (pSDepSlnSysASBase.isPSDepSlnASGroupNameDirty() && (bl || pSDepSlnSysASBase.getPSDepSlnASGroupName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNASGROUPNAME, (Object)pSDepSlnSysASBase.getPSDepSlnASGroupName());
        }
        if (pSDepSlnSysASBase.isPSDepSlnASIdDirty() && (bl || pSDepSlnSysASBase.getPSDepSlnASId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNASID, (Object)pSDepSlnSysASBase.getPSDepSlnASId());
        }
        if (pSDepSlnSysASBase.isPSDepSlnASNameDirty() && (bl || pSDepSlnSysASBase.getPSDepSlnASName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNASNAME, (Object)pSDepSlnSysASBase.getPSDepSlnASName());
        }
        if (pSDepSlnSysASBase.isPSDepSlnIdDirty() && (bl || pSDepSlnSysASBase.getPSDepSlnId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNID, (Object)pSDepSlnSysASBase.getPSDepSlnId());
        }
        if (pSDepSlnSysASBase.isPSDepSlnNameDirty() && (bl || pSDepSlnSysASBase.getPSDepSlnName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNNAME, (Object)pSDepSlnSysASBase.getPSDepSlnName());
        }
        if (pSDepSlnSysASBase.isPSDepSlnSysASIdDirty() && (bl || pSDepSlnSysASBase.getPSDepSlnSysASId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSASID, (Object)pSDepSlnSysASBase.getPSDepSlnSysASId());
        }
        if (pSDepSlnSysASBase.isPSDepSlnSysASNameDirty() && (bl || pSDepSlnSysASBase.getPSDepSlnSysASName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSASNAME, (Object)pSDepSlnSysASBase.getPSDepSlnSysASName());
        }
        if (pSDepSlnSysASBase.isPSDepSlnSysIdDirty() && (bl || pSDepSlnSysASBase.getPSDepSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSID, (Object)pSDepSlnSysASBase.getPSDepSlnSysId());
        }
        if (pSDepSlnSysASBase.isPSDepSlnSysNameDirty() && (bl || pSDepSlnSysASBase.getPSDepSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSNAME, (Object)pSDepSlnSysASBase.getPSDepSlnSysName());
        }
        if (pSDepSlnSysASBase.isPSDepSysAppIdDirty() && (bl || pSDepSlnSysASBase.getPSDepSysAppId() != null)) {
            iDataObject.set(FIELD_PSDEPSYSAPPID, (Object)pSDepSlnSysASBase.getPSDepSysAppId());
        }
        if (pSDepSlnSysASBase.isPSDepSysAppNameDirty() && (bl || pSDepSlnSysASBase.getPSDepSysAppName() != null)) {
            iDataObject.set(FIELD_PSDEPSYSAPPNAME, (Object)pSDepSlnSysASBase.getPSDepSysAppName());
        }
        if (pSDepSlnSysASBase.isServiceContainerDirty() && (bl || pSDepSlnSysASBase.getServiceContainer() != null)) {
            iDataObject.set(FIELD_SERVICECONTAINER, (Object)pSDepSlnSysASBase.getServiceContainer());
        }
        if (pSDepSlnSysASBase.isUpdateDateDirty() && (bl || pSDepSlnSysASBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDepSlnSysASBase.getUpdateDate());
        }
        if (pSDepSlnSysASBase.isUpdateManDirty() && (bl || pSDepSlnSysASBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDepSlnSysASBase.getUpdateMan());
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
        return PSDepSlnSysASBase.remove(this, n);
    }

    private static boolean remove(PSDepSlnSysASBase pSDepSlnSysASBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnSysASBase.resetContainerType();
                return true;
            }
            case 1: {
                pSDepSlnSysASBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDepSlnSysASBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDepSlnSysASBase.resetMemo();
                return true;
            }
            case 4: {
                pSDepSlnSysASBase.resetNo2PSDepSysAppId();
                return true;
            }
            case 5: {
                pSDepSlnSysASBase.resetNo2PSDepSysAppName();
                return true;
            }
            case 6: {
                pSDepSlnSysASBase.resetPSDepSlnASGroupId();
                return true;
            }
            case 7: {
                pSDepSlnSysASBase.resetPSDepSlnASGroupName();
                return true;
            }
            case 8: {
                pSDepSlnSysASBase.resetPSDepSlnASId();
                return true;
            }
            case 9: {
                pSDepSlnSysASBase.resetPSDepSlnASName();
                return true;
            }
            case 10: {
                pSDepSlnSysASBase.resetPSDepSlnId();
                return true;
            }
            case 11: {
                pSDepSlnSysASBase.resetPSDepSlnName();
                return true;
            }
            case 12: {
                pSDepSlnSysASBase.resetPSDepSlnSysASId();
                return true;
            }
            case 13: {
                pSDepSlnSysASBase.resetPSDepSlnSysASName();
                return true;
            }
            case 14: {
                pSDepSlnSysASBase.resetPSDepSlnSysId();
                return true;
            }
            case 15: {
                pSDepSlnSysASBase.resetPSDepSlnSysName();
                return true;
            }
            case 16: {
                pSDepSlnSysASBase.resetPSDepSysAppId();
                return true;
            }
            case 17: {
                pSDepSlnSysASBase.resetPSDepSysAppName();
                return true;
            }
            case 18: {
                pSDepSlnSysASBase.resetServiceContainer();
                return true;
            }
            case 19: {
                pSDepSlnSysASBase.resetUpdateDate();
                return true;
            }
            case 20: {
                pSDepSlnSysASBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSlnASGroup getPSDepSlnASGrp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnASGrp();
        }
        if (this.getPSDepSlnASGroupId() == null) {
            return null;
        }
        Integer n = this.objPSDepSlnASGrpLock;
        synchronized (n) {
            if (this.psdepslnasgrp != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSlnASGroupId(), (Object)this.psdepslnasgrp.getPSDepSlnASGroupId()) != 0L) {
                this.psdepslnasgrp = null;
            }
            if (this.psdepslnasgrp == null) {
                PSDepSlnASGroup pSDepSlnASGroup = new PSDepSlnASGroup();
                pSDepSlnASGroup.setPSDepSlnASGroupId(this.getPSDepSlnASGroupId());
                PSDepSlnASGroupService pSDepSlnASGroupService = (PSDepSlnASGroupService)ServiceGlobal.getService(PSDepSlnASGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDepSlnASGroupService.autoGet((IEntity)pSDepSlnASGroup);
                this.psdepslnasgrp = pSDepSlnASGroup;
            }
            return this.psdepslnasgrp;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSlnAS getPSDepSlnAS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnAS();
        }
        if (this.getPSDepSlnASId() == null) {
            return null;
        }
        Integer n = this.objPSDepSlnASLock;
        synchronized (n) {
            if (this.psdepslnas != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSlnASId(), (Object)this.psdepslnas.getPSDepSlnASId()) != 0L) {
                this.psdepslnas = null;
            }
            if (this.psdepslnas == null) {
                PSDepSlnAS pSDepSlnAS = new PSDepSlnAS();
                pSDepSlnAS.setPSDepSlnASId(this.getPSDepSlnASId());
                PSDepSlnASService pSDepSlnASService = (PSDepSlnASService)ServiceGlobal.getService(PSDepSlnASService.class, (SessionFactory)this.getSessionFactory());
                pSDepSlnASService.autoGet((IEntity)pSDepSlnAS);
                this.psdepslnas = pSDepSlnAS;
            }
            return this.psdepslnas;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSlnSys getPSDepSlnSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSys();
        }
        if (this.getPSDepSlnSysId() == null) {
            return null;
        }
        Integer n = this.objPSDepSlnSysLock;
        synchronized (n) {
            if (this.psdepslnsys != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSlnSysId(), (Object)this.psdepslnsys.getPSDepSlnSysId()) != 0L) {
                this.psdepslnsys = null;
            }
            if (this.psdepslnsys == null) {
                PSDepSlnSys pSDepSlnSys = new PSDepSlnSys();
                pSDepSlnSys.setPSDepSlnSysId(this.getPSDepSlnSysId());
                PSDepSlnSysService pSDepSlnSysService = (PSDepSlnSysService)ServiceGlobal.getService(PSDepSlnSysService.class, (SessionFactory)this.getSessionFactory());
                pSDepSlnSysService.autoGet((IEntity)pSDepSlnSys);
                this.psdepslnsys = pSDepSlnSys;
            }
            return this.psdepslnsys;
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
    public PSDepSysApp getNo2PSDepSysApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PSDepSysApp();
        }
        if (this.getNo2PSDepSysAppId() == null) {
            return null;
        }
        Integer n = this.objNo2PSDepSysAppLock;
        synchronized (n) {
            if (this.no2psdepsysapp != null && DataTypeHelper.compare((int)25, (Object)this.getNo2PSDepSysAppId(), (Object)this.no2psdepsysapp.getPSDepSysAppId()) != 0L) {
                this.no2psdepsysapp = null;
            }
            if (this.no2psdepsysapp == null) {
                PSDepSysApp pSDepSysApp = new PSDepSysApp();
                pSDepSysApp.setPSDepSysAppId(this.getNo2PSDepSysAppId());
                PSDepSysAppService pSDepSysAppService = (PSDepSysAppService)ServiceGlobal.getService(PSDepSysAppService.class, (SessionFactory)this.getSessionFactory());
                pSDepSysAppService.autoGet((IEntity)pSDepSysApp);
                this.no2psdepsysapp = pSDepSysApp;
            }
            return this.no2psdepsysapp;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSysApp getPSDepSysApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSysApp();
        }
        if (this.getPSDepSysAppId() == null) {
            return null;
        }
        Integer n = this.objPSDepSysAppLock;
        synchronized (n) {
            if (this.psdepsysapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSysAppId(), (Object)this.psdepsysapp.getPSDepSysAppId()) != 0L) {
                this.psdepsysapp = null;
            }
            if (this.psdepsysapp == null) {
                PSDepSysApp pSDepSysApp = new PSDepSysApp();
                pSDepSysApp.setPSDepSysAppId(this.getPSDepSysAppId());
                PSDepSysAppService pSDepSysAppService = (PSDepSysAppService)ServiceGlobal.getService(PSDepSysAppService.class, (SessionFactory)this.getSessionFactory());
                pSDepSysAppService.autoGet((IEntity)pSDepSysApp);
                this.psdepsysapp = pSDepSysApp;
            }
            return this.psdepsysapp;
        }
    }

    private PSDepSlnSysASBase getProxyEntity() {
        return this.proxyPSDepSlnSysASBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDepSlnSysASBase = null;
        if (iDataObject != null && iDataObject instanceof PSDepSlnSysASBase) {
            this.proxyPSDepSlnSysASBase = (PSDepSlnSysASBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysASService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONTAINERTYPE, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_NO2PSDEPSYSAPPID, 4);
        fieldIndexMap.put(FIELD_NO2PSDEPSYSAPPNAME, 5);
        fieldIndexMap.put(FIELD_PSDEPSLNASGROUPID, 6);
        fieldIndexMap.put(FIELD_PSDEPSLNASGROUPNAME, 7);
        fieldIndexMap.put(FIELD_PSDEPSLNASID, 8);
        fieldIndexMap.put(FIELD_PSDEPSLNASNAME, 9);
        fieldIndexMap.put(FIELD_PSDEPSLNID, 10);
        fieldIndexMap.put(FIELD_PSDEPSLNNAME, 11);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSASID, 12);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSASNAME, 13);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSID, 14);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSNAME, 15);
        fieldIndexMap.put(FIELD_PSDEPSYSAPPID, 16);
        fieldIndexMap.put(FIELD_PSDEPSYSAPPNAME, 17);
        fieldIndexMap.put(FIELD_SERVICECONTAINER, 18);
        fieldIndexMap.put(FIELD_UPDATEDATE, 19);
        fieldIndexMap.put(FIELD_UPDATEMAN, 20);
    }
}

