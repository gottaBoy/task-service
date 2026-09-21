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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysModelFolder;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysModelFolderItem;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSSysModelFolderItemService;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSSysModelFolderService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysModelFolderBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysModelFolderBase.class);
    public static final String FIELD_ALLUSERFLAG = "ALLUSERFLAG";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FOLDERTYPE = "FOLDERTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PPSSYSMODELFOLDERID = "PPSSYSMODELFOLDERID";
    public static final String FIELD_PPSSYSMODELFOLDERNAME = "PPSSYSMODELFOLDERNAME";
    public static final String FIELD_PSOBJID = "PSOBJID";
    public static final String FIELD_PSOBJNAME = "PSOBJNAME";
    public static final String FIELD_PSOBJTYPE = "PSOBJTYPE";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSMODELFOLDERID = "PSSYSMODELFOLDERID";
    public static final String FIELD_PSSYSMODELFOLDERNAME = "PSSYSMODELFOLDERNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    private static final int INDEX_ALLUSERFLAG = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_FOLDERTYPE = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_ORDERVALUE = 5;
    private static final int INDEX_PPSSYSMODELFOLDERID = 6;
    private static final int INDEX_PPSSYSMODELFOLDERNAME = 7;
    private static final int INDEX_PSOBJID = 8;
    private static final int INDEX_PSOBJNAME = 9;
    private static final int INDEX_PSOBJTYPE = 10;
    private static final int INDEX_PSSYSAPPID = 11;
    private static final int INDEX_PSSYSMODELFOLDERID = 12;
    private static final int INDEX_PSSYSMODELFOLDERNAME = 13;
    private static final int INDEX_PSSYSTEMID = 14;
    private static final int INDEX_PSSYSTEMNAME = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final int INDEX_USERTAG = 18;
    private static final int INDEX_USERTAG2 = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysModelFolderBase proxyPSSysModelFolderBase = null;
    private boolean alluserflagDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean foldertypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean ppssysmodelfolderidDirtyFlag = false;
    private boolean ppssysmodelfoldernameDirtyFlag = false;
    private boolean psobjidDirtyFlag = false;
    private boolean psobjnameDirtyFlag = false;
    private boolean psobjtypeDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysmodelfolderidDirtyFlag = false;
    private boolean pssysmodelfoldernameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    @Column(name="alluserflag")
    private Integer alluserflag;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="foldertype")
    private String foldertype;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="ppssysmodelfolderid")
    private String ppssysmodelfolderid;
    @Column(name="ppssysmodelfoldername")
    private String ppssysmodelfoldername;
    @Column(name="psobjid")
    private String psobjid;
    @Column(name="psobjname")
    private String psobjname;
    @Column(name="psobjtype")
    private String psobjtype;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysmodelfolderid")
    private String pssysmodelfolderid;
    @Column(name="pssysmodelfoldername")
    private String pssysmodelfoldername;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    private Integer objPPSSysModelFolderLock = new Integer(1);
    private PSSysModelFolder ppssysmodelfolder = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysModelFolderItemsLock = new Integer(1);
    private ArrayList<PSSysModelFolderItem> pssysmodelfolderitems = null;

    public void setAllUserFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAllUserFlag(n);
            return;
        }
        this.alluserflag = n;
        this.alluserflagDirtyFlag = true;
    }

    public Integer getAllUserFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAllUserFlag();
        }
        return this.alluserflag;
    }

    public boolean isAllUserFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAllUserFlagDirty();
        }
        return this.alluserflagDirtyFlag;
    }

    public void resetAllUserFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAllUserFlag();
            return;
        }
        this.alluserflagDirtyFlag = false;
        this.alluserflag = null;
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

    public void setFolderType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFolderType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.foldertype = string;
        this.foldertypeDirtyFlag = true;
    }

    public String getFolderType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFolderType();
        }
        return this.foldertype;
    }

    public boolean isFolderTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFolderTypeDirty();
        }
        return this.foldertypeDirtyFlag;
    }

    public void resetFolderType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFolderType();
            return;
        }
        this.foldertypeDirtyFlag = false;
        this.foldertype = null;
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

    public void setOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValue(n);
            return;
        }
        this.ordervalue = n;
        this.ordervalueDirtyFlag = true;
    }

    public Integer getOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValue();
        }
        return this.ordervalue;
    }

    public boolean isOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValueDirty();
        }
        return this.ordervalueDirtyFlag;
    }

    public void resetOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValue();
            return;
        }
        this.ordervalueDirtyFlag = false;
        this.ordervalue = null;
    }

    public void setPPSSysModelFolderId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSysModelFolderId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssysmodelfolderid = string;
        this.ppssysmodelfolderidDirtyFlag = true;
    }

    public String getPPSSysModelFolderId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysModelFolderId();
        }
        return this.ppssysmodelfolderid;
    }

    public boolean isPPSSysModelFolderIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSysModelFolderIdDirty();
        }
        return this.ppssysmodelfolderidDirtyFlag;
    }

    public void resetPPSSysModelFolderId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSysModelFolderId();
            return;
        }
        this.ppssysmodelfolderidDirtyFlag = false;
        this.ppssysmodelfolderid = null;
    }

    public void setPPSSysModelFolderName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSysModelFolderName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssysmodelfoldername = string;
        this.ppssysmodelfoldernameDirtyFlag = true;
    }

    public String getPPSSysModelFolderName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysModelFolderName();
        }
        return this.ppssysmodelfoldername;
    }

    public boolean isPPSSysModelFolderNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSysModelFolderNameDirty();
        }
        return this.ppssysmodelfoldernameDirtyFlag;
    }

    public void resetPPSSysModelFolderName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSysModelFolderName();
            return;
        }
        this.ppssysmodelfoldernameDirtyFlag = false;
        this.ppssysmodelfoldername = null;
    }

    public void setPSObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjid = string;
        this.psobjidDirtyFlag = true;
    }

    public String getPSObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjId();
        }
        return this.psobjid;
    }

    public boolean isPSObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjIdDirty();
        }
        return this.psobjidDirtyFlag;
    }

    public void resetPSObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjId();
            return;
        }
        this.psobjidDirtyFlag = false;
        this.psobjid = null;
    }

    public void setPSObjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjname = string;
        this.psobjnameDirtyFlag = true;
    }

    public String getPSObjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjName();
        }
        return this.psobjname;
    }

    public boolean isPSObjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjNameDirty();
        }
        return this.psobjnameDirtyFlag;
    }

    public void resetPSObjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjName();
            return;
        }
        this.psobjnameDirtyFlag = false;
        this.psobjname = null;
    }

    public void setPSObjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjtype = string;
        this.psobjtypeDirtyFlag = true;
    }

    public String getPSObjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjType();
        }
        return this.psobjtype;
    }

    public boolean isPSObjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjTypeDirty();
        }
        return this.psobjtypeDirtyFlag;
    }

    public void resetPSObjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjType();
            return;
        }
        this.psobjtypeDirtyFlag = false;
        this.psobjtype = null;
    }

    public void setPSSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappid = string;
        this.pssysappidDirtyFlag = true;
    }

    public String getPSSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppId();
        }
        return this.pssysappid;
    }

    public boolean isPSSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppIdDirty();
        }
        return this.pssysappidDirtyFlag;
    }

    public void resetPSSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppId();
            return;
        }
        this.pssysappidDirtyFlag = false;
        this.pssysappid = null;
    }

    public void setPSSysModelFolderId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelFolderId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelfolderid = string;
        this.pssysmodelfolderidDirtyFlag = true;
    }

    public String getPSSysModelFolderId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelFolderId();
        }
        return this.pssysmodelfolderid;
    }

    public boolean isPSSysModelFolderIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelFolderIdDirty();
        }
        return this.pssysmodelfolderidDirtyFlag;
    }

    public void resetPSSysModelFolderId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelFolderId();
            return;
        }
        this.pssysmodelfolderidDirtyFlag = false;
        this.pssysmodelfolderid = null;
    }

    public void setPSSysModelFolderName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelFolderName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelfoldername = string;
        this.pssysmodelfoldernameDirtyFlag = true;
    }

    public String getPSSysModelFolderName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelFolderName();
        }
        return this.pssysmodelfoldername;
    }

    public boolean isPSSysModelFolderNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelFolderNameDirty();
        }
        return this.pssysmodelfoldernameDirtyFlag;
    }

    public void resetPSSysModelFolderName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelFolderName();
            return;
        }
        this.pssysmodelfoldernameDirtyFlag = false;
        this.pssysmodelfoldername = null;
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

    protected void onReset() {
        PSSysModelFolderBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysModelFolderBase pSSysModelFolderBase) {
        pSSysModelFolderBase.resetAllUserFlag();
        pSSysModelFolderBase.resetCreateDate();
        pSSysModelFolderBase.resetCreateMan();
        pSSysModelFolderBase.resetFolderType();
        pSSysModelFolderBase.resetMemo();
        pSSysModelFolderBase.resetOrderValue();
        pSSysModelFolderBase.resetPPSSysModelFolderId();
        pSSysModelFolderBase.resetPPSSysModelFolderName();
        pSSysModelFolderBase.resetPSObjId();
        pSSysModelFolderBase.resetPSObjName();
        pSSysModelFolderBase.resetPSObjType();
        pSSysModelFolderBase.resetPSSysAppId();
        pSSysModelFolderBase.resetPSSysModelFolderId();
        pSSysModelFolderBase.resetPSSysModelFolderName();
        pSSysModelFolderBase.resetPSSystemId();
        pSSysModelFolderBase.resetPSSystemName();
        pSSysModelFolderBase.resetUpdateDate();
        pSSysModelFolderBase.resetUpdateMan();
        pSSysModelFolderBase.resetUserTag();
        pSSysModelFolderBase.resetUserTag2();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAllUserFlagDirty()) {
            hashMap.put(FIELD_ALLUSERFLAG, this.getAllUserFlag());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isFolderTypeDirty()) {
            hashMap.put(FIELD_FOLDERTYPE, this.getFolderType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPPSSysModelFolderIdDirty()) {
            hashMap.put(FIELD_PPSSYSMODELFOLDERID, this.getPPSSysModelFolderId());
        }
        if (!bl || this.isPPSSysModelFolderNameDirty()) {
            hashMap.put(FIELD_PPSSYSMODELFOLDERNAME, this.getPPSSysModelFolderName());
        }
        if (!bl || this.isPSObjIdDirty()) {
            hashMap.put(FIELD_PSOBJID, this.getPSObjId());
        }
        if (!bl || this.isPSObjNameDirty()) {
            hashMap.put(FIELD_PSOBJNAME, this.getPSObjName());
        }
        if (!bl || this.isPSObjTypeDirty()) {
            hashMap.put(FIELD_PSOBJTYPE, this.getPSObjType());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysModelFolderIdDirty()) {
            hashMap.put(FIELD_PSSYSMODELFOLDERID, this.getPSSysModelFolderId());
        }
        if (!bl || this.isPSSysModelFolderNameDirty()) {
            hashMap.put(FIELD_PSSYSMODELFOLDERNAME, this.getPSSysModelFolderName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
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
        return PSSysModelFolderBase.get(this, n);
    }

    private static Object get(PSSysModelFolderBase pSSysModelFolderBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelFolderBase.getAllUserFlag();
            }
            case 1: {
                return pSSysModelFolderBase.getCreateDate();
            }
            case 2: {
                return pSSysModelFolderBase.getCreateMan();
            }
            case 3: {
                return pSSysModelFolderBase.getFolderType();
            }
            case 4: {
                return pSSysModelFolderBase.getMemo();
            }
            case 5: {
                return pSSysModelFolderBase.getOrderValue();
            }
            case 6: {
                return pSSysModelFolderBase.getPPSSysModelFolderId();
            }
            case 7: {
                return pSSysModelFolderBase.getPPSSysModelFolderName();
            }
            case 8: {
                return pSSysModelFolderBase.getPSObjId();
            }
            case 9: {
                return pSSysModelFolderBase.getPSObjName();
            }
            case 10: {
                return pSSysModelFolderBase.getPSObjType();
            }
            case 11: {
                return pSSysModelFolderBase.getPSSysAppId();
            }
            case 12: {
                return pSSysModelFolderBase.getPSSysModelFolderId();
            }
            case 13: {
                return pSSysModelFolderBase.getPSSysModelFolderName();
            }
            case 14: {
                return pSSysModelFolderBase.getPSSystemId();
            }
            case 15: {
                return pSSysModelFolderBase.getPSSystemName();
            }
            case 16: {
                return pSSysModelFolderBase.getUpdateDate();
            }
            case 17: {
                return pSSysModelFolderBase.getUpdateMan();
            }
            case 18: {
                return pSSysModelFolderBase.getUserTag();
            }
            case 19: {
                return pSSysModelFolderBase.getUserTag2();
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
        PSSysModelFolderBase.set(this, n, object);
    }

    private static void set(PSSysModelFolderBase pSSysModelFolderBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysModelFolderBase.setAllUserFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSSysModelFolderBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysModelFolderBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysModelFolderBase.setFolderType(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysModelFolderBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysModelFolderBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSSysModelFolderBase.setPPSSysModelFolderId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysModelFolderBase.setPPSSysModelFolderName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysModelFolderBase.setPSObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysModelFolderBase.setPSObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysModelFolderBase.setPSObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysModelFolderBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysModelFolderBase.setPSSysModelFolderId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysModelFolderBase.setPSSysModelFolderName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysModelFolderBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysModelFolderBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysModelFolderBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSSysModelFolderBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysModelFolderBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysModelFolderBase.setUserTag2(DataObject.getStringValue((Object)object));
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
        return PSSysModelFolderBase.isNull(this, n);
    }

    private static boolean isNull(PSSysModelFolderBase pSSysModelFolderBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelFolderBase.getAllUserFlag() == null;
            }
            case 1: {
                return pSSysModelFolderBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysModelFolderBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysModelFolderBase.getFolderType() == null;
            }
            case 4: {
                return pSSysModelFolderBase.getMemo() == null;
            }
            case 5: {
                return pSSysModelFolderBase.getOrderValue() == null;
            }
            case 6: {
                return pSSysModelFolderBase.getPPSSysModelFolderId() == null;
            }
            case 7: {
                return pSSysModelFolderBase.getPPSSysModelFolderName() == null;
            }
            case 8: {
                return pSSysModelFolderBase.getPSObjId() == null;
            }
            case 9: {
                return pSSysModelFolderBase.getPSObjName() == null;
            }
            case 10: {
                return pSSysModelFolderBase.getPSObjType() == null;
            }
            case 11: {
                return pSSysModelFolderBase.getPSSysAppId() == null;
            }
            case 12: {
                return pSSysModelFolderBase.getPSSysModelFolderId() == null;
            }
            case 13: {
                return pSSysModelFolderBase.getPSSysModelFolderName() == null;
            }
            case 14: {
                return pSSysModelFolderBase.getPSSystemId() == null;
            }
            case 15: {
                return pSSysModelFolderBase.getPSSystemName() == null;
            }
            case 16: {
                return pSSysModelFolderBase.getUpdateDate() == null;
            }
            case 17: {
                return pSSysModelFolderBase.getUpdateMan() == null;
            }
            case 18: {
                return pSSysModelFolderBase.getUserTag() == null;
            }
            case 19: {
                return pSSysModelFolderBase.getUserTag2() == null;
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
        return PSSysModelFolderBase.contains(this, n);
    }

    private static boolean contains(PSSysModelFolderBase pSSysModelFolderBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelFolderBase.isAllUserFlagDirty();
            }
            case 1: {
                return pSSysModelFolderBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysModelFolderBase.isCreateManDirty();
            }
            case 3: {
                return pSSysModelFolderBase.isFolderTypeDirty();
            }
            case 4: {
                return pSSysModelFolderBase.isMemoDirty();
            }
            case 5: {
                return pSSysModelFolderBase.isOrderValueDirty();
            }
            case 6: {
                return pSSysModelFolderBase.isPPSSysModelFolderIdDirty();
            }
            case 7: {
                return pSSysModelFolderBase.isPPSSysModelFolderNameDirty();
            }
            case 8: {
                return pSSysModelFolderBase.isPSObjIdDirty();
            }
            case 9: {
                return pSSysModelFolderBase.isPSObjNameDirty();
            }
            case 10: {
                return pSSysModelFolderBase.isPSObjTypeDirty();
            }
            case 11: {
                return pSSysModelFolderBase.isPSSysAppIdDirty();
            }
            case 12: {
                return pSSysModelFolderBase.isPSSysModelFolderIdDirty();
            }
            case 13: {
                return pSSysModelFolderBase.isPSSysModelFolderNameDirty();
            }
            case 14: {
                return pSSysModelFolderBase.isPSSystemIdDirty();
            }
            case 15: {
                return pSSysModelFolderBase.isPSSystemNameDirty();
            }
            case 16: {
                return pSSysModelFolderBase.isUpdateDateDirty();
            }
            case 17: {
                return pSSysModelFolderBase.isUpdateManDirty();
            }
            case 18: {
                return pSSysModelFolderBase.isUserTagDirty();
            }
            case 19: {
                return pSSysModelFolderBase.isUserTag2Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysModelFolderBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysModelFolderBase pSSysModelFolderBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysModelFolderBase.getAllUserFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"alluserflag", (Object)PSSysModelFolderBase.getJSONValue((Object)pSSysModelFolderBase.getAllUserFlag()), (boolean)false);
        }
        if (bl || pSSysModelFolderBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysModelFolderBase.getJSONValue((Object)pSSysModelFolderBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysModelFolderBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysModelFolderBase.getJSONValue((Object)pSSysModelFolderBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysModelFolderBase.getFolderType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"foldertype", (Object)PSSysModelFolderBase.getJSONValue((Object)pSSysModelFolderBase.getFolderType()), (boolean)false);
        }
        if (bl || pSSysModelFolderBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysModelFolderBase.getJSONValue((Object)pSSysModelFolderBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysModelFolderBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysModelFolderBase.getJSONValue((Object)pSSysModelFolderBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysModelFolderBase.getPPSSysModelFolderId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssysmodelfolderid", (Object)PSSysModelFolderBase.getJSONValue((Object)pSSysModelFolderBase.getPPSSysModelFolderId()), (boolean)false);
        }
        if (bl || pSSysModelFolderBase.getPPSSysModelFolderName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssysmodelfoldername", (Object)PSSysModelFolderBase.getJSONValue((Object)pSSysModelFolderBase.getPPSSysModelFolderName()), (boolean)false);
        }
        if (bl || pSSysModelFolderBase.getPSObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjid", (Object)PSSysModelFolderBase.getJSONValue((Object)pSSysModelFolderBase.getPSObjId()), (boolean)false);
        }
        if (bl || pSSysModelFolderBase.getPSObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjname", (Object)PSSysModelFolderBase.getJSONValue((Object)pSSysModelFolderBase.getPSObjName()), (boolean)false);
        }
        if (bl || pSSysModelFolderBase.getPSObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjtype", (Object)PSSysModelFolderBase.getJSONValue((Object)pSSysModelFolderBase.getPSObjType()), (boolean)false);
        }
        if (bl || pSSysModelFolderBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSSysModelFolderBase.getJSONValue((Object)pSSysModelFolderBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSSysModelFolderBase.getPSSysModelFolderId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelfolderid", (Object)PSSysModelFolderBase.getJSONValue((Object)pSSysModelFolderBase.getPSSysModelFolderId()), (boolean)false);
        }
        if (bl || pSSysModelFolderBase.getPSSysModelFolderName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelfoldername", (Object)PSSysModelFolderBase.getJSONValue((Object)pSSysModelFolderBase.getPSSysModelFolderName()), (boolean)false);
        }
        if (bl || pSSysModelFolderBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysModelFolderBase.getJSONValue((Object)pSSysModelFolderBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysModelFolderBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysModelFolderBase.getJSONValue((Object)pSSysModelFolderBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysModelFolderBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysModelFolderBase.getJSONValue((Object)pSSysModelFolderBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysModelFolderBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysModelFolderBase.getJSONValue((Object)pSSysModelFolderBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysModelFolderBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysModelFolderBase.getJSONValue((Object)pSSysModelFolderBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysModelFolderBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysModelFolderBase.getJSONValue((Object)pSSysModelFolderBase.getUserTag2()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysModelFolderBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysModelFolderBase pSSysModelFolderBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysModelFolderBase.getAllUserFlag() != null) {
            object = pSSysModelFolderBase.getAllUserFlag();
            xmlNode.setAttribute(FIELD_ALLUSERFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysModelFolderBase.getCreateDate() != null) {
            object = pSSysModelFolderBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysModelFolderBase.getCreateMan() != null) {
            object = pSSysModelFolderBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFolderBase.getFolderType() != null) {
            object = pSSysModelFolderBase.getFolderType();
            xmlNode.setAttribute(FIELD_FOLDERTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFolderBase.getMemo() != null) {
            object = pSSysModelFolderBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFolderBase.getOrderValue() != null) {
            object = pSSysModelFolderBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysModelFolderBase.getPPSSysModelFolderId() != null) {
            object = pSSysModelFolderBase.getPPSSysModelFolderId();
            xmlNode.setAttribute(FIELD_PPSSYSMODELFOLDERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFolderBase.getPPSSysModelFolderName() != null) {
            object = pSSysModelFolderBase.getPPSSysModelFolderName();
            xmlNode.setAttribute(FIELD_PPSSYSMODELFOLDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFolderBase.getPSObjId() != null) {
            object = pSSysModelFolderBase.getPSObjId();
            xmlNode.setAttribute(FIELD_PSOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFolderBase.getPSObjName() != null) {
            object = pSSysModelFolderBase.getPSObjName();
            xmlNode.setAttribute(FIELD_PSOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFolderBase.getPSObjType() != null) {
            object = pSSysModelFolderBase.getPSObjType();
            xmlNode.setAttribute(FIELD_PSOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFolderBase.getPSSysAppId() != null) {
            object = pSSysModelFolderBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFolderBase.getPSSysModelFolderId() != null) {
            object = pSSysModelFolderBase.getPSSysModelFolderId();
            xmlNode.setAttribute(FIELD_PSSYSMODELFOLDERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFolderBase.getPSSysModelFolderName() != null) {
            object = pSSysModelFolderBase.getPSSysModelFolderName();
            xmlNode.setAttribute(FIELD_PSSYSMODELFOLDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFolderBase.getPSSystemId() != null) {
            object = pSSysModelFolderBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFolderBase.getPSSystemName() != null) {
            object = pSSysModelFolderBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFolderBase.getUpdateDate() != null) {
            object = pSSysModelFolderBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysModelFolderBase.getUpdateMan() != null) {
            object = pSSysModelFolderBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFolderBase.getUserTag() != null) {
            object = pSSysModelFolderBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFolderBase.getUserTag2() != null) {
            object = pSSysModelFolderBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysModelFolderBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysModelFolderBase pSSysModelFolderBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysModelFolderBase.isAllUserFlagDirty() && (bl || pSSysModelFolderBase.getAllUserFlag() != null)) {
            iDataObject.set(FIELD_ALLUSERFLAG, (Object)pSSysModelFolderBase.getAllUserFlag());
        }
        if (pSSysModelFolderBase.isCreateDateDirty() && (bl || pSSysModelFolderBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysModelFolderBase.getCreateDate());
        }
        if (pSSysModelFolderBase.isCreateManDirty() && (bl || pSSysModelFolderBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysModelFolderBase.getCreateMan());
        }
        if (pSSysModelFolderBase.isFolderTypeDirty() && (bl || pSSysModelFolderBase.getFolderType() != null)) {
            iDataObject.set(FIELD_FOLDERTYPE, (Object)pSSysModelFolderBase.getFolderType());
        }
        if (pSSysModelFolderBase.isMemoDirty() && (bl || pSSysModelFolderBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysModelFolderBase.getMemo());
        }
        if (pSSysModelFolderBase.isOrderValueDirty() && (bl || pSSysModelFolderBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysModelFolderBase.getOrderValue());
        }
        if (pSSysModelFolderBase.isPPSSysModelFolderIdDirty() && (bl || pSSysModelFolderBase.getPPSSysModelFolderId() != null)) {
            iDataObject.set(FIELD_PPSSYSMODELFOLDERID, (Object)pSSysModelFolderBase.getPPSSysModelFolderId());
        }
        if (pSSysModelFolderBase.isPPSSysModelFolderNameDirty() && (bl || pSSysModelFolderBase.getPPSSysModelFolderName() != null)) {
            iDataObject.set(FIELD_PPSSYSMODELFOLDERNAME, (Object)pSSysModelFolderBase.getPPSSysModelFolderName());
        }
        if (pSSysModelFolderBase.isPSObjIdDirty() && (bl || pSSysModelFolderBase.getPSObjId() != null)) {
            iDataObject.set(FIELD_PSOBJID, (Object)pSSysModelFolderBase.getPSObjId());
        }
        if (pSSysModelFolderBase.isPSObjNameDirty() && (bl || pSSysModelFolderBase.getPSObjName() != null)) {
            iDataObject.set(FIELD_PSOBJNAME, (Object)pSSysModelFolderBase.getPSObjName());
        }
        if (pSSysModelFolderBase.isPSObjTypeDirty() && (bl || pSSysModelFolderBase.getPSObjType() != null)) {
            iDataObject.set(FIELD_PSOBJTYPE, (Object)pSSysModelFolderBase.getPSObjType());
        }
        if (pSSysModelFolderBase.isPSSysAppIdDirty() && (bl || pSSysModelFolderBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSSysModelFolderBase.getPSSysAppId());
        }
        if (pSSysModelFolderBase.isPSSysModelFolderIdDirty() && (bl || pSSysModelFolderBase.getPSSysModelFolderId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELFOLDERID, (Object)pSSysModelFolderBase.getPSSysModelFolderId());
        }
        if (pSSysModelFolderBase.isPSSysModelFolderNameDirty() && (bl || pSSysModelFolderBase.getPSSysModelFolderName() != null)) {
            iDataObject.set(FIELD_PSSYSMODELFOLDERNAME, (Object)pSSysModelFolderBase.getPSSysModelFolderName());
        }
        if (pSSysModelFolderBase.isPSSystemIdDirty() && (bl || pSSysModelFolderBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysModelFolderBase.getPSSystemId());
        }
        if (pSSysModelFolderBase.isPSSystemNameDirty() && (bl || pSSysModelFolderBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysModelFolderBase.getPSSystemName());
        }
        if (pSSysModelFolderBase.isUpdateDateDirty() && (bl || pSSysModelFolderBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysModelFolderBase.getUpdateDate());
        }
        if (pSSysModelFolderBase.isUpdateManDirty() && (bl || pSSysModelFolderBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysModelFolderBase.getUpdateMan());
        }
        if (pSSysModelFolderBase.isUserTagDirty() && (bl || pSSysModelFolderBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysModelFolderBase.getUserTag());
        }
        if (pSSysModelFolderBase.isUserTag2Dirty() && (bl || pSSysModelFolderBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysModelFolderBase.getUserTag2());
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
        return PSSysModelFolderBase.remove(this, n);
    }

    private static boolean remove(PSSysModelFolderBase pSSysModelFolderBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysModelFolderBase.resetAllUserFlag();
                return true;
            }
            case 1: {
                pSSysModelFolderBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysModelFolderBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysModelFolderBase.resetFolderType();
                return true;
            }
            case 4: {
                pSSysModelFolderBase.resetMemo();
                return true;
            }
            case 5: {
                pSSysModelFolderBase.resetOrderValue();
                return true;
            }
            case 6: {
                pSSysModelFolderBase.resetPPSSysModelFolderId();
                return true;
            }
            case 7: {
                pSSysModelFolderBase.resetPPSSysModelFolderName();
                return true;
            }
            case 8: {
                pSSysModelFolderBase.resetPSObjId();
                return true;
            }
            case 9: {
                pSSysModelFolderBase.resetPSObjName();
                return true;
            }
            case 10: {
                pSSysModelFolderBase.resetPSObjType();
                return true;
            }
            case 11: {
                pSSysModelFolderBase.resetPSSysAppId();
                return true;
            }
            case 12: {
                pSSysModelFolderBase.resetPSSysModelFolderId();
                return true;
            }
            case 13: {
                pSSysModelFolderBase.resetPSSysModelFolderName();
                return true;
            }
            case 14: {
                pSSysModelFolderBase.resetPSSystemId();
                return true;
            }
            case 15: {
                pSSysModelFolderBase.resetPSSystemName();
                return true;
            }
            case 16: {
                pSSysModelFolderBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSSysModelFolderBase.resetUpdateMan();
                return true;
            }
            case 18: {
                pSSysModelFolderBase.resetUserTag();
                return true;
            }
            case 19: {
                pSSysModelFolderBase.resetUserTag2();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysModelFolder getPPSSysModelFolder() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysModelFolder();
        }
        if (this.getPPSSysModelFolderId() == null) {
            return null;
        }
        Integer n = this.objPPSSysModelFolderLock;
        synchronized (n) {
            if (this.ppssysmodelfolder != null && DataTypeHelper.compare((int)25, (Object)this.getPPSSysModelFolderId(), (Object)this.ppssysmodelfolder.getPSSysModelFolderId()) != 0L) {
                this.ppssysmodelfolder = null;
            }
            if (this.ppssysmodelfolder == null) {
                PSSysModelFolder pSSysModelFolder = new PSSysModelFolder();
                pSSysModelFolder.setPSSysModelFolderId(this.getPPSSysModelFolderId());
                PSSysModelFolderService pSSysModelFolderService = (PSSysModelFolderService)ServiceGlobal.getService(PSSysModelFolderService.class, (SessionFactory)this.getSessionFactory());
                pSSysModelFolderService.autoGet((IEntity)pSSysModelFolder);
                this.ppssysmodelfolder = pSSysModelFolder;
            }
            return this.ppssysmodelfolder;
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysModelFolderItem> getPSSysModelFolderItems() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelFolderItems();
        }
        if (this.getPSSysModelFolderId() == null) {
            return null;
        }
        PSSysModelFolderItemService pSSysModelFolderItemService = (PSSysModelFolderItemService)ServiceGlobal.getService(PSSysModelFolderItemService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysModelFolderItemsLock;
        synchronized (n) {
            if (this.pssysmodelfolderitems == null) {
                this.pssysmodelfolderitems = pSSysModelFolderItemService.selectByPSSysModelFolder(this);
            }
            return this.pssysmodelfolderitems;
        }
    }

    private PSSysModelFolderBase getProxyEntity() {
        return this.proxyPSSysModelFolderBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysModelFolderBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysModelFolderBase) {
            this.proxyPSSysModelFolderBase = (PSSysModelFolderBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSSysModelFolderService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLUSERFLAG, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_FOLDERTYPE, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_ORDERVALUE, 5);
        fieldIndexMap.put(FIELD_PPSSYSMODELFOLDERID, 6);
        fieldIndexMap.put(FIELD_PPSSYSMODELFOLDERNAME, 7);
        fieldIndexMap.put(FIELD_PSOBJID, 8);
        fieldIndexMap.put(FIELD_PSOBJNAME, 9);
        fieldIndexMap.put(FIELD_PSOBJTYPE, 10);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 11);
        fieldIndexMap.put(FIELD_PSSYSMODELFOLDERID, 12);
        fieldIndexMap.put(FIELD_PSSYSMODELFOLDERNAME, 13);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 14);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
        fieldIndexMap.put(FIELD_USERTAG, 18);
        fieldIndexMap.put(FIELD_USERTAG2, 19);
    }
}

