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
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysModelFolder;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSSysModelFolderService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysModelFolderItemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysModelFolderItemBase.class);
    public static final String FIELD_ALLUSERFLAG = "ALLUSERFLAG";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DATA = "DATA";
    public static final String FIELD_ICONCLS = "ICONCLS";
    public static final String FIELD_ITEMPARAM = "ITEMPARAM";
    public static final String FIELD_ITEMPARAM2 = "ITEMPARAM2";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSOBJID = "PSOBJID";
    public static final String FIELD_PSOBJNAME = "PSOBJNAME";
    public static final String FIELD_PSOBJTYPE = "PSOBJTYPE";
    public static final String FIELD_PSOBJTYPENAME = "PSOBJTYPENAME";
    public static final String FIELD_PSSYSMODELFOLDERID = "PSSYSMODELFOLDERID";
    public static final String FIELD_PSSYSMODELFOLDERITEMID = "PSSYSMODELFOLDERITEMID";
    public static final String FIELD_PSSYSMODELFOLDERITEMNAME = "PSSYSMODELFOLDERITEMNAME";
    public static final String FIELD_PSSYSMODELFOLDERNAME = "PSSYSMODELFOLDERNAME";
    public static final String FIELD_STUDIOTAG = "STUDIOTAG";
    public static final String FIELD_STUDIOTAG2 = "STUDIOTAG2";
    public static final String FIELD_STUDIOTYPE = "STUDIOTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    private static final int INDEX_ALLUSERFLAG = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DATA = 3;
    private static final int INDEX_ICONCLS = 4;
    private static final int INDEX_ITEMPARAM = 5;
    private static final int INDEX_ITEMPARAM2 = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_ORDERVALUE = 8;
    private static final int INDEX_PSOBJID = 9;
    private static final int INDEX_PSOBJNAME = 10;
    private static final int INDEX_PSOBJTYPE = 11;
    private static final int INDEX_PSOBJTYPENAME = 12;
    private static final int INDEX_PSSYSMODELFOLDERID = 13;
    private static final int INDEX_PSSYSMODELFOLDERITEMID = 14;
    private static final int INDEX_PSSYSMODELFOLDERITEMNAME = 15;
    private static final int INDEX_PSSYSMODELFOLDERNAME = 16;
    private static final int INDEX_STUDIOTAG = 17;
    private static final int INDEX_STUDIOTAG2 = 18;
    private static final int INDEX_STUDIOTYPE = 19;
    private static final int INDEX_UPDATEDATE = 20;
    private static final int INDEX_UPDATEMAN = 21;
    private static final int INDEX_USERTAG = 22;
    private static final int INDEX_USERTAG2 = 23;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysModelFolderItemBase proxyPSSysModelFolderItemBase = null;
    private boolean alluserflagDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dataDirtyFlag = false;
    private boolean iconclsDirtyFlag = false;
    private boolean itemparamDirtyFlag = false;
    private boolean itemparam2DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psobjidDirtyFlag = false;
    private boolean psobjnameDirtyFlag = false;
    private boolean psobjtypeDirtyFlag = false;
    private boolean psobjtypenameDirtyFlag = false;
    private boolean pssysmodelfolderidDirtyFlag = false;
    private boolean pssysmodelfolderitemidDirtyFlag = false;
    private boolean pssysmodelfolderitemnameDirtyFlag = false;
    private boolean pssysmodelfoldernameDirtyFlag = false;
    private boolean studiotagDirtyFlag = false;
    private boolean studiotag2DirtyFlag = false;
    private boolean studiotypeDirtyFlag = false;
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
    @Column(name="data")
    private String data;
    @Column(name="iconcls")
    private String iconcls;
    @Column(name="itemparam")
    private String itemparam;
    @Column(name="itemparam2")
    private String itemparam2;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psobjid")
    private String psobjid;
    @Column(name="psobjname")
    private String psobjname;
    @Column(name="psobjtype")
    private String psobjtype;
    @Column(name="psobjtypename")
    private String psobjtypename;
    @Column(name="pssysmodelfolderid")
    private String pssysmodelfolderid;
    @Column(name="pssysmodelfolderitemid")
    private String pssysmodelfolderitemid;
    @Column(name="pssysmodelfolderitemname")
    private String pssysmodelfolderitemname;
    @Column(name="pssysmodelfoldername")
    private String pssysmodelfoldername;
    @Column(name="studiotag")
    private String studiotag;
    @Column(name="studiotag2")
    private String studiotag2;
    @Column(name="studiotype")
    private String studiotype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    private Integer objPSSysModelFolderLock = new Integer(1);
    private PSSysModelFolder pssysmodelfolder = null;

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

    public void setData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.data = string;
        this.dataDirtyFlag = true;
    }

    public String getData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getData();
        }
        return this.data;
    }

    public boolean isDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataDirty();
        }
        return this.dataDirtyFlag;
    }

    public void resetData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetData();
            return;
        }
        this.dataDirtyFlag = false;
        this.data = null;
    }

    public void setIconCls(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIconCls(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.iconcls = string;
        this.iconclsDirtyFlag = true;
    }

    public String getIconCls() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIconCls();
        }
        return this.iconcls;
    }

    public boolean isIconClsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIconClsDirty();
        }
        return this.iconclsDirtyFlag;
    }

    public void resetIconCls() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIconCls();
            return;
        }
        this.iconclsDirtyFlag = false;
        this.iconcls = null;
    }

    public void setItemParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemparam = string;
        this.itemparamDirtyFlag = true;
    }

    public String getItemParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemParam();
        }
        return this.itemparam;
    }

    public boolean isItemParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemParamDirty();
        }
        return this.itemparamDirtyFlag;
    }

    public void resetItemParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemParam();
            return;
        }
        this.itemparamDirtyFlag = false;
        this.itemparam = null;
    }

    public void setItemParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemparam2 = string;
        this.itemparam2DirtyFlag = true;
    }

    public String getItemParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemParam2();
        }
        return this.itemparam2;
    }

    public boolean isItemParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemParam2Dirty();
        }
        return this.itemparam2DirtyFlag;
    }

    public void resetItemParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemParam2();
            return;
        }
        this.itemparam2DirtyFlag = false;
        this.itemparam2 = null;
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

    public void setPSObjTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjtypename = string;
        this.psobjtypenameDirtyFlag = true;
    }

    public String getPSObjTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjTypeName();
        }
        return this.psobjtypename;
    }

    public boolean isPSObjTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjTypeNameDirty();
        }
        return this.psobjtypenameDirtyFlag;
    }

    public void resetPSObjTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjTypeName();
            return;
        }
        this.psobjtypenameDirtyFlag = false;
        this.psobjtypename = null;
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

    public void setPSSysModelFolderItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelFolderItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelfolderitemid = string;
        this.pssysmodelfolderitemidDirtyFlag = true;
    }

    public String getPSSysModelFolderItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelFolderItemId();
        }
        return this.pssysmodelfolderitemid;
    }

    public boolean isPSSysModelFolderItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelFolderItemIdDirty();
        }
        return this.pssysmodelfolderitemidDirtyFlag;
    }

    public void resetPSSysModelFolderItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelFolderItemId();
            return;
        }
        this.pssysmodelfolderitemidDirtyFlag = false;
        this.pssysmodelfolderitemid = null;
    }

    public void setPSSysModelFolderItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelFolderItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelfolderitemname = string;
        this.pssysmodelfolderitemnameDirtyFlag = true;
    }

    public String getPSSysModelFolderItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelFolderItemName();
        }
        return this.pssysmodelfolderitemname;
    }

    public boolean isPSSysModelFolderItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelFolderItemNameDirty();
        }
        return this.pssysmodelfolderitemnameDirtyFlag;
    }

    public void resetPSSysModelFolderItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelFolderItemName();
            return;
        }
        this.pssysmodelfolderitemnameDirtyFlag = false;
        this.pssysmodelfolderitemname = null;
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

    public void setStudioTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStudioTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.studiotag = string;
        this.studiotagDirtyFlag = true;
    }

    public String getStudioTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStudioTag();
        }
        return this.studiotag;
    }

    public boolean isStudioTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStudioTagDirty();
        }
        return this.studiotagDirtyFlag;
    }

    public void resetStudioTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStudioTag();
            return;
        }
        this.studiotagDirtyFlag = false;
        this.studiotag = null;
    }

    public void setStudioTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStudioTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.studiotag2 = string;
        this.studiotag2DirtyFlag = true;
    }

    public String getStudioTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStudioTag2();
        }
        return this.studiotag2;
    }

    public boolean isStudioTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStudioTag2Dirty();
        }
        return this.studiotag2DirtyFlag;
    }

    public void resetStudioTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStudioTag2();
            return;
        }
        this.studiotag2DirtyFlag = false;
        this.studiotag2 = null;
    }

    public void setStudioType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStudioType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.studiotype = string;
        this.studiotypeDirtyFlag = true;
    }

    public String getStudioType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStudioType();
        }
        return this.studiotype;
    }

    public boolean isStudioTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStudioTypeDirty();
        }
        return this.studiotypeDirtyFlag;
    }

    public void resetStudioType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStudioType();
            return;
        }
        this.studiotypeDirtyFlag = false;
        this.studiotype = null;
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
        PSSysModelFolderItemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysModelFolderItemBase pSSysModelFolderItemBase) {
        pSSysModelFolderItemBase.resetAllUserFlag();
        pSSysModelFolderItemBase.resetCreateDate();
        pSSysModelFolderItemBase.resetCreateMan();
        pSSysModelFolderItemBase.resetData();
        pSSysModelFolderItemBase.resetIconCls();
        pSSysModelFolderItemBase.resetItemParam();
        pSSysModelFolderItemBase.resetItemParam2();
        pSSysModelFolderItemBase.resetMemo();
        pSSysModelFolderItemBase.resetOrderValue();
        pSSysModelFolderItemBase.resetPSObjId();
        pSSysModelFolderItemBase.resetPSObjName();
        pSSysModelFolderItemBase.resetPSObjType();
        pSSysModelFolderItemBase.resetPSObjTypeName();
        pSSysModelFolderItemBase.resetPSSysModelFolderId();
        pSSysModelFolderItemBase.resetPSSysModelFolderItemId();
        pSSysModelFolderItemBase.resetPSSysModelFolderItemName();
        pSSysModelFolderItemBase.resetPSSysModelFolderName();
        pSSysModelFolderItemBase.resetStudioTag();
        pSSysModelFolderItemBase.resetStudioTag2();
        pSSysModelFolderItemBase.resetStudioType();
        pSSysModelFolderItemBase.resetUpdateDate();
        pSSysModelFolderItemBase.resetUpdateMan();
        pSSysModelFolderItemBase.resetUserTag();
        pSSysModelFolderItemBase.resetUserTag2();
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
        if (!bl || this.isDataDirty()) {
            hashMap.put(FIELD_DATA, this.getData());
        }
        if (!bl || this.isIconClsDirty()) {
            hashMap.put(FIELD_ICONCLS, this.getIconCls());
        }
        if (!bl || this.isItemParamDirty()) {
            hashMap.put(FIELD_ITEMPARAM, this.getItemParam());
        }
        if (!bl || this.isItemParam2Dirty()) {
            hashMap.put(FIELD_ITEMPARAM2, this.getItemParam2());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
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
        if (!bl || this.isPSObjTypeNameDirty()) {
            hashMap.put(FIELD_PSOBJTYPENAME, this.getPSObjTypeName());
        }
        if (!bl || this.isPSSysModelFolderIdDirty()) {
            hashMap.put(FIELD_PSSYSMODELFOLDERID, this.getPSSysModelFolderId());
        }
        if (!bl || this.isPSSysModelFolderItemIdDirty()) {
            hashMap.put(FIELD_PSSYSMODELFOLDERITEMID, this.getPSSysModelFolderItemId());
        }
        if (!bl || this.isPSSysModelFolderItemNameDirty()) {
            hashMap.put(FIELD_PSSYSMODELFOLDERITEMNAME, this.getPSSysModelFolderItemName());
        }
        if (!bl || this.isPSSysModelFolderNameDirty()) {
            hashMap.put(FIELD_PSSYSMODELFOLDERNAME, this.getPSSysModelFolderName());
        }
        if (!bl || this.isStudioTagDirty()) {
            hashMap.put(FIELD_STUDIOTAG, this.getStudioTag());
        }
        if (!bl || this.isStudioTag2Dirty()) {
            hashMap.put(FIELD_STUDIOTAG2, this.getStudioTag2());
        }
        if (!bl || this.isStudioTypeDirty()) {
            hashMap.put(FIELD_STUDIOTYPE, this.getStudioType());
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
        return PSSysModelFolderItemBase.get(this, n);
    }

    private static Object get(PSSysModelFolderItemBase pSSysModelFolderItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelFolderItemBase.getAllUserFlag();
            }
            case 1: {
                return pSSysModelFolderItemBase.getCreateDate();
            }
            case 2: {
                return pSSysModelFolderItemBase.getCreateMan();
            }
            case 3: {
                return pSSysModelFolderItemBase.getData();
            }
            case 4: {
                return pSSysModelFolderItemBase.getIconCls();
            }
            case 5: {
                return pSSysModelFolderItemBase.getItemParam();
            }
            case 6: {
                return pSSysModelFolderItemBase.getItemParam2();
            }
            case 7: {
                return pSSysModelFolderItemBase.getMemo();
            }
            case 8: {
                return pSSysModelFolderItemBase.getOrderValue();
            }
            case 9: {
                return pSSysModelFolderItemBase.getPSObjId();
            }
            case 10: {
                return pSSysModelFolderItemBase.getPSObjName();
            }
            case 11: {
                return pSSysModelFolderItemBase.getPSObjType();
            }
            case 12: {
                return pSSysModelFolderItemBase.getPSObjTypeName();
            }
            case 13: {
                return pSSysModelFolderItemBase.getPSSysModelFolderId();
            }
            case 14: {
                return pSSysModelFolderItemBase.getPSSysModelFolderItemId();
            }
            case 15: {
                return pSSysModelFolderItemBase.getPSSysModelFolderItemName();
            }
            case 16: {
                return pSSysModelFolderItemBase.getPSSysModelFolderName();
            }
            case 17: {
                return pSSysModelFolderItemBase.getStudioTag();
            }
            case 18: {
                return pSSysModelFolderItemBase.getStudioTag2();
            }
            case 19: {
                return pSSysModelFolderItemBase.getStudioType();
            }
            case 20: {
                return pSSysModelFolderItemBase.getUpdateDate();
            }
            case 21: {
                return pSSysModelFolderItemBase.getUpdateMan();
            }
            case 22: {
                return pSSysModelFolderItemBase.getUserTag();
            }
            case 23: {
                return pSSysModelFolderItemBase.getUserTag2();
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
        PSSysModelFolderItemBase.set(this, n, object);
    }

    private static void set(PSSysModelFolderItemBase pSSysModelFolderItemBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysModelFolderItemBase.setAllUserFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSSysModelFolderItemBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysModelFolderItemBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysModelFolderItemBase.setData(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysModelFolderItemBase.setIconCls(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysModelFolderItemBase.setItemParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysModelFolderItemBase.setItemParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysModelFolderItemBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysModelFolderItemBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSSysModelFolderItemBase.setPSObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysModelFolderItemBase.setPSObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysModelFolderItemBase.setPSObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysModelFolderItemBase.setPSObjTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysModelFolderItemBase.setPSSysModelFolderId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysModelFolderItemBase.setPSSysModelFolderItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysModelFolderItemBase.setPSSysModelFolderItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysModelFolderItemBase.setPSSysModelFolderName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysModelFolderItemBase.setStudioTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysModelFolderItemBase.setStudioTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysModelFolderItemBase.setStudioType(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysModelFolderItemBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 21: {
                pSSysModelFolderItemBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysModelFolderItemBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysModelFolderItemBase.setUserTag2(DataObject.getStringValue((Object)object));
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
        return PSSysModelFolderItemBase.isNull(this, n);
    }

    private static boolean isNull(PSSysModelFolderItemBase pSSysModelFolderItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelFolderItemBase.getAllUserFlag() == null;
            }
            case 1: {
                return pSSysModelFolderItemBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysModelFolderItemBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysModelFolderItemBase.getData() == null;
            }
            case 4: {
                return pSSysModelFolderItemBase.getIconCls() == null;
            }
            case 5: {
                return pSSysModelFolderItemBase.getItemParam() == null;
            }
            case 6: {
                return pSSysModelFolderItemBase.getItemParam2() == null;
            }
            case 7: {
                return pSSysModelFolderItemBase.getMemo() == null;
            }
            case 8: {
                return pSSysModelFolderItemBase.getOrderValue() == null;
            }
            case 9: {
                return pSSysModelFolderItemBase.getPSObjId() == null;
            }
            case 10: {
                return pSSysModelFolderItemBase.getPSObjName() == null;
            }
            case 11: {
                return pSSysModelFolderItemBase.getPSObjType() == null;
            }
            case 12: {
                return pSSysModelFolderItemBase.getPSObjTypeName() == null;
            }
            case 13: {
                return pSSysModelFolderItemBase.getPSSysModelFolderId() == null;
            }
            case 14: {
                return pSSysModelFolderItemBase.getPSSysModelFolderItemId() == null;
            }
            case 15: {
                return pSSysModelFolderItemBase.getPSSysModelFolderItemName() == null;
            }
            case 16: {
                return pSSysModelFolderItemBase.getPSSysModelFolderName() == null;
            }
            case 17: {
                return pSSysModelFolderItemBase.getStudioTag() == null;
            }
            case 18: {
                return pSSysModelFolderItemBase.getStudioTag2() == null;
            }
            case 19: {
                return pSSysModelFolderItemBase.getStudioType() == null;
            }
            case 20: {
                return pSSysModelFolderItemBase.getUpdateDate() == null;
            }
            case 21: {
                return pSSysModelFolderItemBase.getUpdateMan() == null;
            }
            case 22: {
                return pSSysModelFolderItemBase.getUserTag() == null;
            }
            case 23: {
                return pSSysModelFolderItemBase.getUserTag2() == null;
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
        return PSSysModelFolderItemBase.contains(this, n);
    }

    private static boolean contains(PSSysModelFolderItemBase pSSysModelFolderItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelFolderItemBase.isAllUserFlagDirty();
            }
            case 1: {
                return pSSysModelFolderItemBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysModelFolderItemBase.isCreateManDirty();
            }
            case 3: {
                return pSSysModelFolderItemBase.isDataDirty();
            }
            case 4: {
                return pSSysModelFolderItemBase.isIconClsDirty();
            }
            case 5: {
                return pSSysModelFolderItemBase.isItemParamDirty();
            }
            case 6: {
                return pSSysModelFolderItemBase.isItemParam2Dirty();
            }
            case 7: {
                return pSSysModelFolderItemBase.isMemoDirty();
            }
            case 8: {
                return pSSysModelFolderItemBase.isOrderValueDirty();
            }
            case 9: {
                return pSSysModelFolderItemBase.isPSObjIdDirty();
            }
            case 10: {
                return pSSysModelFolderItemBase.isPSObjNameDirty();
            }
            case 11: {
                return pSSysModelFolderItemBase.isPSObjTypeDirty();
            }
            case 12: {
                return pSSysModelFolderItemBase.isPSObjTypeNameDirty();
            }
            case 13: {
                return pSSysModelFolderItemBase.isPSSysModelFolderIdDirty();
            }
            case 14: {
                return pSSysModelFolderItemBase.isPSSysModelFolderItemIdDirty();
            }
            case 15: {
                return pSSysModelFolderItemBase.isPSSysModelFolderItemNameDirty();
            }
            case 16: {
                return pSSysModelFolderItemBase.isPSSysModelFolderNameDirty();
            }
            case 17: {
                return pSSysModelFolderItemBase.isStudioTagDirty();
            }
            case 18: {
                return pSSysModelFolderItemBase.isStudioTag2Dirty();
            }
            case 19: {
                return pSSysModelFolderItemBase.isStudioTypeDirty();
            }
            case 20: {
                return pSSysModelFolderItemBase.isUpdateDateDirty();
            }
            case 21: {
                return pSSysModelFolderItemBase.isUpdateManDirty();
            }
            case 22: {
                return pSSysModelFolderItemBase.isUserTagDirty();
            }
            case 23: {
                return pSSysModelFolderItemBase.isUserTag2Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysModelFolderItemBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysModelFolderItemBase pSSysModelFolderItemBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysModelFolderItemBase.getAllUserFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"alluserflag", (Object)PSSysModelFolderItemBase.getJSONValue((Object)pSSysModelFolderItemBase.getAllUserFlag()), (boolean)false);
        }
        if (bl || pSSysModelFolderItemBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysModelFolderItemBase.getJSONValue((Object)pSSysModelFolderItemBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysModelFolderItemBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysModelFolderItemBase.getJSONValue((Object)pSSysModelFolderItemBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysModelFolderItemBase.getData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"data", (Object)PSSysModelFolderItemBase.getJSONValue((Object)pSSysModelFolderItemBase.getData()), (boolean)false);
        }
        if (bl || pSSysModelFolderItemBase.getIconCls() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconcls", (Object)PSSysModelFolderItemBase.getJSONValue((Object)pSSysModelFolderItemBase.getIconCls()), (boolean)false);
        }
        if (bl || pSSysModelFolderItemBase.getItemParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemparam", (Object)PSSysModelFolderItemBase.getJSONValue((Object)pSSysModelFolderItemBase.getItemParam()), (boolean)false);
        }
        if (bl || pSSysModelFolderItemBase.getItemParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemparam2", (Object)PSSysModelFolderItemBase.getJSONValue((Object)pSSysModelFolderItemBase.getItemParam2()), (boolean)false);
        }
        if (bl || pSSysModelFolderItemBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysModelFolderItemBase.getJSONValue((Object)pSSysModelFolderItemBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysModelFolderItemBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysModelFolderItemBase.getJSONValue((Object)pSSysModelFolderItemBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysModelFolderItemBase.getPSObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjid", (Object)PSSysModelFolderItemBase.getJSONValue((Object)pSSysModelFolderItemBase.getPSObjId()), (boolean)false);
        }
        if (bl || pSSysModelFolderItemBase.getPSObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjname", (Object)PSSysModelFolderItemBase.getJSONValue((Object)pSSysModelFolderItemBase.getPSObjName()), (boolean)false);
        }
        if (bl || pSSysModelFolderItemBase.getPSObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjtype", (Object)PSSysModelFolderItemBase.getJSONValue((Object)pSSysModelFolderItemBase.getPSObjType()), (boolean)false);
        }
        if (bl || pSSysModelFolderItemBase.getPSObjTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjtypename", (Object)PSSysModelFolderItemBase.getJSONValue((Object)pSSysModelFolderItemBase.getPSObjTypeName()), (boolean)false);
        }
        if (bl || pSSysModelFolderItemBase.getPSSysModelFolderId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelfolderid", (Object)PSSysModelFolderItemBase.getJSONValue((Object)pSSysModelFolderItemBase.getPSSysModelFolderId()), (boolean)false);
        }
        if (bl || pSSysModelFolderItemBase.getPSSysModelFolderItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelfolderitemid", (Object)PSSysModelFolderItemBase.getJSONValue((Object)pSSysModelFolderItemBase.getPSSysModelFolderItemId()), (boolean)false);
        }
        if (bl || pSSysModelFolderItemBase.getPSSysModelFolderItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelfolderitemname", (Object)PSSysModelFolderItemBase.getJSONValue((Object)pSSysModelFolderItemBase.getPSSysModelFolderItemName()), (boolean)false);
        }
        if (bl || pSSysModelFolderItemBase.getPSSysModelFolderName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelfoldername", (Object)PSSysModelFolderItemBase.getJSONValue((Object)pSSysModelFolderItemBase.getPSSysModelFolderName()), (boolean)false);
        }
        if (bl || pSSysModelFolderItemBase.getStudioTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"studiotag", (Object)PSSysModelFolderItemBase.getJSONValue((Object)pSSysModelFolderItemBase.getStudioTag()), (boolean)false);
        }
        if (bl || pSSysModelFolderItemBase.getStudioTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"studiotag2", (Object)PSSysModelFolderItemBase.getJSONValue((Object)pSSysModelFolderItemBase.getStudioTag2()), (boolean)false);
        }
        if (bl || pSSysModelFolderItemBase.getStudioType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"studiotype", (Object)PSSysModelFolderItemBase.getJSONValue((Object)pSSysModelFolderItemBase.getStudioType()), (boolean)false);
        }
        if (bl || pSSysModelFolderItemBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysModelFolderItemBase.getJSONValue((Object)pSSysModelFolderItemBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysModelFolderItemBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysModelFolderItemBase.getJSONValue((Object)pSSysModelFolderItemBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysModelFolderItemBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysModelFolderItemBase.getJSONValue((Object)pSSysModelFolderItemBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysModelFolderItemBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysModelFolderItemBase.getJSONValue((Object)pSSysModelFolderItemBase.getUserTag2()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysModelFolderItemBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysModelFolderItemBase pSSysModelFolderItemBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysModelFolderItemBase.getAllUserFlag() != null) {
            object = pSSysModelFolderItemBase.getAllUserFlag();
            xmlNode.setAttribute(FIELD_ALLUSERFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysModelFolderItemBase.getCreateDate() != null) {
            object = pSSysModelFolderItemBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysModelFolderItemBase.getCreateMan() != null) {
            object = pSSysModelFolderItemBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFolderItemBase.getData() != null) {
            object = pSSysModelFolderItemBase.getData();
            xmlNode.setAttribute(FIELD_DATA, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFolderItemBase.getIconCls() != null) {
            object = pSSysModelFolderItemBase.getIconCls();
            xmlNode.setAttribute(FIELD_ICONCLS, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFolderItemBase.getItemParam() != null) {
            object = pSSysModelFolderItemBase.getItemParam();
            xmlNode.setAttribute(FIELD_ITEMPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFolderItemBase.getItemParam2() != null) {
            object = pSSysModelFolderItemBase.getItemParam2();
            xmlNode.setAttribute(FIELD_ITEMPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFolderItemBase.getMemo() != null) {
            object = pSSysModelFolderItemBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFolderItemBase.getOrderValue() != null) {
            object = pSSysModelFolderItemBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysModelFolderItemBase.getPSObjId() != null) {
            object = pSSysModelFolderItemBase.getPSObjId();
            xmlNode.setAttribute(FIELD_PSOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFolderItemBase.getPSObjName() != null) {
            object = pSSysModelFolderItemBase.getPSObjName();
            xmlNode.setAttribute(FIELD_PSOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFolderItemBase.getPSObjType() != null) {
            object = pSSysModelFolderItemBase.getPSObjType();
            xmlNode.setAttribute(FIELD_PSOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFolderItemBase.getPSObjTypeName() != null) {
            object = pSSysModelFolderItemBase.getPSObjTypeName();
            xmlNode.setAttribute(FIELD_PSOBJTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFolderItemBase.getPSSysModelFolderId() != null) {
            object = pSSysModelFolderItemBase.getPSSysModelFolderId();
            xmlNode.setAttribute(FIELD_PSSYSMODELFOLDERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFolderItemBase.getPSSysModelFolderItemId() != null) {
            object = pSSysModelFolderItemBase.getPSSysModelFolderItemId();
            xmlNode.setAttribute(FIELD_PSSYSMODELFOLDERITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFolderItemBase.getPSSysModelFolderItemName() != null) {
            object = pSSysModelFolderItemBase.getPSSysModelFolderItemName();
            xmlNode.setAttribute(FIELD_PSSYSMODELFOLDERITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFolderItemBase.getPSSysModelFolderName() != null) {
            object = pSSysModelFolderItemBase.getPSSysModelFolderName();
            xmlNode.setAttribute(FIELD_PSSYSMODELFOLDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFolderItemBase.getStudioTag() != null) {
            object = pSSysModelFolderItemBase.getStudioTag();
            xmlNode.setAttribute(FIELD_STUDIOTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFolderItemBase.getStudioTag2() != null) {
            object = pSSysModelFolderItemBase.getStudioTag2();
            xmlNode.setAttribute(FIELD_STUDIOTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFolderItemBase.getStudioType() != null) {
            object = pSSysModelFolderItemBase.getStudioType();
            xmlNode.setAttribute(FIELD_STUDIOTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFolderItemBase.getUpdateDate() != null) {
            object = pSSysModelFolderItemBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysModelFolderItemBase.getUpdateMan() != null) {
            object = pSSysModelFolderItemBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFolderItemBase.getUserTag() != null) {
            object = pSSysModelFolderItemBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFolderItemBase.getUserTag2() != null) {
            object = pSSysModelFolderItemBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysModelFolderItemBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysModelFolderItemBase pSSysModelFolderItemBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysModelFolderItemBase.isAllUserFlagDirty() && (bl || pSSysModelFolderItemBase.getAllUserFlag() != null)) {
            iDataObject.set(FIELD_ALLUSERFLAG, (Object)pSSysModelFolderItemBase.getAllUserFlag());
        }
        if (pSSysModelFolderItemBase.isCreateDateDirty() && (bl || pSSysModelFolderItemBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysModelFolderItemBase.getCreateDate());
        }
        if (pSSysModelFolderItemBase.isCreateManDirty() && (bl || pSSysModelFolderItemBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysModelFolderItemBase.getCreateMan());
        }
        if (pSSysModelFolderItemBase.isDataDirty() && (bl || pSSysModelFolderItemBase.getData() != null)) {
            iDataObject.set(FIELD_DATA, (Object)pSSysModelFolderItemBase.getData());
        }
        if (pSSysModelFolderItemBase.isIconClsDirty() && (bl || pSSysModelFolderItemBase.getIconCls() != null)) {
            iDataObject.set(FIELD_ICONCLS, (Object)pSSysModelFolderItemBase.getIconCls());
        }
        if (pSSysModelFolderItemBase.isItemParamDirty() && (bl || pSSysModelFolderItemBase.getItemParam() != null)) {
            iDataObject.set(FIELD_ITEMPARAM, (Object)pSSysModelFolderItemBase.getItemParam());
        }
        if (pSSysModelFolderItemBase.isItemParam2Dirty() && (bl || pSSysModelFolderItemBase.getItemParam2() != null)) {
            iDataObject.set(FIELD_ITEMPARAM2, (Object)pSSysModelFolderItemBase.getItemParam2());
        }
        if (pSSysModelFolderItemBase.isMemoDirty() && (bl || pSSysModelFolderItemBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysModelFolderItemBase.getMemo());
        }
        if (pSSysModelFolderItemBase.isOrderValueDirty() && (bl || pSSysModelFolderItemBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysModelFolderItemBase.getOrderValue());
        }
        if (pSSysModelFolderItemBase.isPSObjIdDirty() && (bl || pSSysModelFolderItemBase.getPSObjId() != null)) {
            iDataObject.set(FIELD_PSOBJID, (Object)pSSysModelFolderItemBase.getPSObjId());
        }
        if (pSSysModelFolderItemBase.isPSObjNameDirty() && (bl || pSSysModelFolderItemBase.getPSObjName() != null)) {
            iDataObject.set(FIELD_PSOBJNAME, (Object)pSSysModelFolderItemBase.getPSObjName());
        }
        if (pSSysModelFolderItemBase.isPSObjTypeDirty() && (bl || pSSysModelFolderItemBase.getPSObjType() != null)) {
            iDataObject.set(FIELD_PSOBJTYPE, (Object)pSSysModelFolderItemBase.getPSObjType());
        }
        if (pSSysModelFolderItemBase.isPSObjTypeNameDirty() && (bl || pSSysModelFolderItemBase.getPSObjTypeName() != null)) {
            iDataObject.set(FIELD_PSOBJTYPENAME, (Object)pSSysModelFolderItemBase.getPSObjTypeName());
        }
        if (pSSysModelFolderItemBase.isPSSysModelFolderIdDirty() && (bl || pSSysModelFolderItemBase.getPSSysModelFolderId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELFOLDERID, (Object)pSSysModelFolderItemBase.getPSSysModelFolderId());
        }
        if (pSSysModelFolderItemBase.isPSSysModelFolderItemIdDirty() && (bl || pSSysModelFolderItemBase.getPSSysModelFolderItemId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELFOLDERITEMID, (Object)pSSysModelFolderItemBase.getPSSysModelFolderItemId());
        }
        if (pSSysModelFolderItemBase.isPSSysModelFolderItemNameDirty() && (bl || pSSysModelFolderItemBase.getPSSysModelFolderItemName() != null)) {
            iDataObject.set(FIELD_PSSYSMODELFOLDERITEMNAME, (Object)pSSysModelFolderItemBase.getPSSysModelFolderItemName());
        }
        if (pSSysModelFolderItemBase.isPSSysModelFolderNameDirty() && (bl || pSSysModelFolderItemBase.getPSSysModelFolderName() != null)) {
            iDataObject.set(FIELD_PSSYSMODELFOLDERNAME, (Object)pSSysModelFolderItemBase.getPSSysModelFolderName());
        }
        if (pSSysModelFolderItemBase.isStudioTagDirty() && (bl || pSSysModelFolderItemBase.getStudioTag() != null)) {
            iDataObject.set(FIELD_STUDIOTAG, (Object)pSSysModelFolderItemBase.getStudioTag());
        }
        if (pSSysModelFolderItemBase.isStudioTag2Dirty() && (bl || pSSysModelFolderItemBase.getStudioTag2() != null)) {
            iDataObject.set(FIELD_STUDIOTAG2, (Object)pSSysModelFolderItemBase.getStudioTag2());
        }
        if (pSSysModelFolderItemBase.isStudioTypeDirty() && (bl || pSSysModelFolderItemBase.getStudioType() != null)) {
            iDataObject.set(FIELD_STUDIOTYPE, (Object)pSSysModelFolderItemBase.getStudioType());
        }
        if (pSSysModelFolderItemBase.isUpdateDateDirty() && (bl || pSSysModelFolderItemBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysModelFolderItemBase.getUpdateDate());
        }
        if (pSSysModelFolderItemBase.isUpdateManDirty() && (bl || pSSysModelFolderItemBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysModelFolderItemBase.getUpdateMan());
        }
        if (pSSysModelFolderItemBase.isUserTagDirty() && (bl || pSSysModelFolderItemBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysModelFolderItemBase.getUserTag());
        }
        if (pSSysModelFolderItemBase.isUserTag2Dirty() && (bl || pSSysModelFolderItemBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysModelFolderItemBase.getUserTag2());
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
        return PSSysModelFolderItemBase.remove(this, n);
    }

    private static boolean remove(PSSysModelFolderItemBase pSSysModelFolderItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysModelFolderItemBase.resetAllUserFlag();
                return true;
            }
            case 1: {
                pSSysModelFolderItemBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysModelFolderItemBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysModelFolderItemBase.resetData();
                return true;
            }
            case 4: {
                pSSysModelFolderItemBase.resetIconCls();
                return true;
            }
            case 5: {
                pSSysModelFolderItemBase.resetItemParam();
                return true;
            }
            case 6: {
                pSSysModelFolderItemBase.resetItemParam2();
                return true;
            }
            case 7: {
                pSSysModelFolderItemBase.resetMemo();
                return true;
            }
            case 8: {
                pSSysModelFolderItemBase.resetOrderValue();
                return true;
            }
            case 9: {
                pSSysModelFolderItemBase.resetPSObjId();
                return true;
            }
            case 10: {
                pSSysModelFolderItemBase.resetPSObjName();
                return true;
            }
            case 11: {
                pSSysModelFolderItemBase.resetPSObjType();
                return true;
            }
            case 12: {
                pSSysModelFolderItemBase.resetPSObjTypeName();
                return true;
            }
            case 13: {
                pSSysModelFolderItemBase.resetPSSysModelFolderId();
                return true;
            }
            case 14: {
                pSSysModelFolderItemBase.resetPSSysModelFolderItemId();
                return true;
            }
            case 15: {
                pSSysModelFolderItemBase.resetPSSysModelFolderItemName();
                return true;
            }
            case 16: {
                pSSysModelFolderItemBase.resetPSSysModelFolderName();
                return true;
            }
            case 17: {
                pSSysModelFolderItemBase.resetStudioTag();
                return true;
            }
            case 18: {
                pSSysModelFolderItemBase.resetStudioTag2();
                return true;
            }
            case 19: {
                pSSysModelFolderItemBase.resetStudioType();
                return true;
            }
            case 20: {
                pSSysModelFolderItemBase.resetUpdateDate();
                return true;
            }
            case 21: {
                pSSysModelFolderItemBase.resetUpdateMan();
                return true;
            }
            case 22: {
                pSSysModelFolderItemBase.resetUserTag();
                return true;
            }
            case 23: {
                pSSysModelFolderItemBase.resetUserTag2();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysModelFolder getPSSysModelFolder() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelFolder();
        }
        if (this.getPSSysModelFolderId() == null) {
            return null;
        }
        Integer n = this.objPSSysModelFolderLock;
        synchronized (n) {
            if (this.pssysmodelfolder != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysModelFolderId(), (Object)this.pssysmodelfolder.getPSSysModelFolderId()) != 0L) {
                this.pssysmodelfolder = null;
            }
            if (this.pssysmodelfolder == null) {
                PSSysModelFolder pSSysModelFolder = new PSSysModelFolder();
                pSSysModelFolder.setPSSysModelFolderId(this.getPSSysModelFolderId());
                PSSysModelFolderService pSSysModelFolderService = (PSSysModelFolderService)ServiceGlobal.getService(PSSysModelFolderService.class, (SessionFactory)this.getSessionFactory());
                pSSysModelFolderService.autoGet((IEntity)pSSysModelFolder);
                this.pssysmodelfolder = pSSysModelFolder;
            }
            return this.pssysmodelfolder;
        }
    }

    private PSSysModelFolderItemBase getProxyEntity() {
        return this.proxyPSSysModelFolderItemBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysModelFolderItemBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysModelFolderItemBase) {
            this.proxyPSSysModelFolderItemBase = (PSSysModelFolderItemBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSSysModelFolderItemService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLUSERFLAG, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DATA, 3);
        fieldIndexMap.put(FIELD_ICONCLS, 4);
        fieldIndexMap.put(FIELD_ITEMPARAM, 5);
        fieldIndexMap.put(FIELD_ITEMPARAM2, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_ORDERVALUE, 8);
        fieldIndexMap.put(FIELD_PSOBJID, 9);
        fieldIndexMap.put(FIELD_PSOBJNAME, 10);
        fieldIndexMap.put(FIELD_PSOBJTYPE, 11);
        fieldIndexMap.put(FIELD_PSOBJTYPENAME, 12);
        fieldIndexMap.put(FIELD_PSSYSMODELFOLDERID, 13);
        fieldIndexMap.put(FIELD_PSSYSMODELFOLDERITEMID, 14);
        fieldIndexMap.put(FIELD_PSSYSMODELFOLDERITEMNAME, 15);
        fieldIndexMap.put(FIELD_PSSYSMODELFOLDERNAME, 16);
        fieldIndexMap.put(FIELD_STUDIOTAG, 17);
        fieldIndexMap.put(FIELD_STUDIOTAG2, 18);
        fieldIndexMap.put(FIELD_STUDIOTYPE, 19);
        fieldIndexMap.put(FIELD_UPDATEDATE, 20);
        fieldIndexMap.put(FIELD_UPDATEMAN, 21);
        fieldIndexMap.put(FIELD_USERTAG, 22);
        fieldIndexMap.put(FIELD_USERTAG2, 23);
    }
}

