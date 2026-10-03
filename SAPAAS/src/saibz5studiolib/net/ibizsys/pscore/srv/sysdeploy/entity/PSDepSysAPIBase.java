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
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSysAPI;
import net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysAPIService;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSysVer;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysVerService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysAPI;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAPIService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSysAPIBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDepSysAPIBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEPSYSAPIID = "PSDEPSYSAPIID";
    public static final String FIELD_PSDEPSYSAPINAME = "PSDEPSYSAPINAME";
    public static final String FIELD_PSDEPSYSAPITYPE = "PSDEPSYSAPITYPE";
    public static final String FIELD_PSDEPSYSVERID = "PSDEPSYSVERID";
    public static final String FIELD_PSDEPSYSVERNAME = "PSDEPSYSVERNAME";
    public static final String FIELD_PSDEVSLNSYSAPIID = "PSDEVSLNSYSAPIID";
    public static final String FIELD_PSDEVSLNSYSAPINAME = "PSDEVSLNSYSAPINAME";
    public static final String FIELD_PSSAASSYSAPIID = "PSSAASSYSAPIID";
    public static final String FIELD_PSSAASSYSAPINAME = "PSSAASSYSAPINAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDEPSYSAPIID = 3;
    private static final int INDEX_PSDEPSYSAPINAME = 4;
    private static final int INDEX_PSDEPSYSAPITYPE = 5;
    private static final int INDEX_PSDEPSYSVERID = 6;
    private static final int INDEX_PSDEPSYSVERNAME = 7;
    private static final int INDEX_PSDEVSLNSYSAPIID = 8;
    private static final int INDEX_PSDEVSLNSYSAPINAME = 9;
    private static final int INDEX_PSSAASSYSAPIID = 10;
    private static final int INDEX_PSSAASSYSAPINAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final int INDEX_USERCAT = 14;
    private static final int INDEX_USERTAG = 15;
    private static final int INDEX_USERTAG2 = 16;
    private static final int INDEX_USERTAG3 = 17;
    private static final int INDEX_USERTAG4 = 18;
    private static final int INDEX_VALIDFLAG = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDepSysAPIBase proxyPSDepSysAPIBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdepsysapiidDirtyFlag = false;
    private boolean psdepsysapinameDirtyFlag = false;
    private boolean psdepsysapitypeDirtyFlag = false;
    private boolean psdepsysveridDirtyFlag = false;
    private boolean psdepsysvernameDirtyFlag = false;
    private boolean psdevslnsysapiidDirtyFlag = false;
    private boolean psdevslnsysapinameDirtyFlag = false;
    private boolean pssaassysapiidDirtyFlag = false;
    private boolean pssaassysapinameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdepsysapiid")
    private String psdepsysapiid;
    @Column(name="psdepsysapiname")
    private String psdepsysapiname;
    @Column(name="psdepsysapitype")
    private String psdepsysapitype;
    @Column(name="psdepsysverid")
    private String psdepsysverid;
    @Column(name="psdepsysvername")
    private String psdepsysvername;
    @Column(name="psdevslnsysapiid")
    private String psdevslnsysapiid;
    @Column(name="psdevslnsysapiname")
    private String psdevslnsysapiname;
    @Column(name="pssaassysapiid")
    private String pssaassysapiid;
    @Column(name="pssaassysapiname")
    private String pssaassysapiname;
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
    private Integer objPSDepSysVerLock = new Integer(1);
    private PSDepSysVer psdepsysver = null;
    private Integer objPSDevSlnSysAPILock = new Integer(1);
    private PSDevSlnSysAPI psdevslnsysapi = null;
    private Integer objPSSaaSSysAPILock = new Integer(1);
    private PSSaaSSysAPI pssaassysapi = null;

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

    public void setPSDepSysAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSysAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepsysapiid = string;
        this.psdepsysapiidDirtyFlag = true;
    }

    public String getPSDepSysAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSysAPIId();
        }
        return this.psdepsysapiid;
    }

    public boolean isPSDepSysAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSysAPIIdDirty();
        }
        return this.psdepsysapiidDirtyFlag;
    }

    public void resetPSDepSysAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSysAPIId();
            return;
        }
        this.psdepsysapiidDirtyFlag = false;
        this.psdepsysapiid = null;
    }

    public void setPSDepSysAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSysAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepsysapiname = string;
        this.psdepsysapinameDirtyFlag = true;
    }

    public String getPSDepSysAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSysAPIName();
        }
        return this.psdepsysapiname;
    }

    public boolean isPSDepSysAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSysAPINameDirty();
        }
        return this.psdepsysapinameDirtyFlag;
    }

    public void resetPSDepSysAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSysAPIName();
            return;
        }
        this.psdepsysapinameDirtyFlag = false;
        this.psdepsysapiname = null;
    }

    public void setPSDepSysAPIType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSysAPIType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepsysapitype = string;
        this.psdepsysapitypeDirtyFlag = true;
    }

    public String getPSDepSysAPIType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSysAPIType();
        }
        return this.psdepsysapitype;
    }

    public boolean isPSDepSysAPITypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSysAPITypeDirty();
        }
        return this.psdepsysapitypeDirtyFlag;
    }

    public void resetPSDepSysAPIType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSysAPIType();
            return;
        }
        this.psdepsysapitypeDirtyFlag = false;
        this.psdepsysapitype = null;
    }

    public void setPSDepSysVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSysVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepsysverid = string;
        this.psdepsysveridDirtyFlag = true;
    }

    public String getPSDepSysVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSysVerId();
        }
        return this.psdepsysverid;
    }

    public boolean isPSDepSysVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSysVerIdDirty();
        }
        return this.psdepsysveridDirtyFlag;
    }

    public void resetPSDepSysVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSysVerId();
            return;
        }
        this.psdepsysveridDirtyFlag = false;
        this.psdepsysverid = null;
    }

    public void setPSDepSysVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSysVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepsysvername = string;
        this.psdepsysvernameDirtyFlag = true;
    }

    public String getPSDepSysVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSysVerName();
        }
        return this.psdepsysvername;
    }

    public boolean isPSDepSysVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSysVerNameDirty();
        }
        return this.psdepsysvernameDirtyFlag;
    }

    public void resetPSDepSysVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSysVerName();
            return;
        }
        this.psdepsysvernameDirtyFlag = false;
        this.psdepsysvername = null;
    }

    public void setPSDevSlnSysAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysapiid = string;
        this.psdevslnsysapiidDirtyFlag = true;
    }

    public String getPSDevSlnSysAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysAPIId();
        }
        return this.psdevslnsysapiid;
    }

    public boolean isPSDevSlnSysAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysAPIIdDirty();
        }
        return this.psdevslnsysapiidDirtyFlag;
    }

    public void resetPSDevSlnSysAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysAPIId();
            return;
        }
        this.psdevslnsysapiidDirtyFlag = false;
        this.psdevslnsysapiid = null;
    }

    public void setPSDevSlnSysAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysapiname = string;
        this.psdevslnsysapinameDirtyFlag = true;
    }

    public String getPSDevSlnSysAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysAPIName();
        }
        return this.psdevslnsysapiname;
    }

    public boolean isPSDevSlnSysAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysAPINameDirty();
        }
        return this.psdevslnsysapinameDirtyFlag;
    }

    public void resetPSDevSlnSysAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysAPIName();
            return;
        }
        this.psdevslnsysapinameDirtyFlag = false;
        this.psdevslnsysapiname = null;
    }

    public void setPSSaaSSysAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSaaSSysAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssaassysapiid = string;
        this.pssaassysapiidDirtyFlag = true;
    }

    public String getPSSaaSSysAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSysAPIId();
        }
        return this.pssaassysapiid;
    }

    public boolean isPSSaaSSysAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSaaSSysAPIIdDirty();
        }
        return this.pssaassysapiidDirtyFlag;
    }

    public void resetPSSaaSSysAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSaaSSysAPIId();
            return;
        }
        this.pssaassysapiidDirtyFlag = false;
        this.pssaassysapiid = null;
    }

    public void setPSSaaSSysAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSaaSSysAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssaassysapiname = string;
        this.pssaassysapinameDirtyFlag = true;
    }

    public String getPSSaaSSysAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSysAPIName();
        }
        return this.pssaassysapiname;
    }

    public boolean isPSSaaSSysAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSaaSSysAPINameDirty();
        }
        return this.pssaassysapinameDirtyFlag;
    }

    public void resetPSSaaSSysAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSaaSSysAPIName();
            return;
        }
        this.pssaassysapinameDirtyFlag = false;
        this.pssaassysapiname = null;
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
        PSDepSysAPIBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDepSysAPIBase pSDepSysAPIBase) {
        pSDepSysAPIBase.resetCreateDate();
        pSDepSysAPIBase.resetCreateMan();
        pSDepSysAPIBase.resetMemo();
        pSDepSysAPIBase.resetPSDepSysAPIId();
        pSDepSysAPIBase.resetPSDepSysAPIName();
        pSDepSysAPIBase.resetPSDepSysAPIType();
        pSDepSysAPIBase.resetPSDepSysVerId();
        pSDepSysAPIBase.resetPSDepSysVerName();
        pSDepSysAPIBase.resetPSDevSlnSysAPIId();
        pSDepSysAPIBase.resetPSDevSlnSysAPIName();
        pSDepSysAPIBase.resetPSSaaSSysAPIId();
        pSDepSysAPIBase.resetPSSaaSSysAPIName();
        pSDepSysAPIBase.resetUpdateDate();
        pSDepSysAPIBase.resetUpdateMan();
        pSDepSysAPIBase.resetUserCat();
        pSDepSysAPIBase.resetUserTag();
        pSDepSysAPIBase.resetUserTag2();
        pSDepSysAPIBase.resetUserTag3();
        pSDepSysAPIBase.resetUserTag4();
        pSDepSysAPIBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDepSysAPIIdDirty()) {
            hashMap.put(FIELD_PSDEPSYSAPIID, this.getPSDepSysAPIId());
        }
        if (!bl || this.isPSDepSysAPINameDirty()) {
            hashMap.put(FIELD_PSDEPSYSAPINAME, this.getPSDepSysAPIName());
        }
        if (!bl || this.isPSDepSysAPITypeDirty()) {
            hashMap.put(FIELD_PSDEPSYSAPITYPE, this.getPSDepSysAPIType());
        }
        if (!bl || this.isPSDepSysVerIdDirty()) {
            hashMap.put(FIELD_PSDEPSYSVERID, this.getPSDepSysVerId());
        }
        if (!bl || this.isPSDepSysVerNameDirty()) {
            hashMap.put(FIELD_PSDEPSYSVERNAME, this.getPSDepSysVerName());
        }
        if (!bl || this.isPSDevSlnSysAPIIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSAPIID, this.getPSDevSlnSysAPIId());
        }
        if (!bl || this.isPSDevSlnSysAPINameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSAPINAME, this.getPSDevSlnSysAPIName());
        }
        if (!bl || this.isPSSaaSSysAPIIdDirty()) {
            hashMap.put(FIELD_PSSAASSYSAPIID, this.getPSSaaSSysAPIId());
        }
        if (!bl || this.isPSSaaSSysAPINameDirty()) {
            hashMap.put(FIELD_PSSAASSYSAPINAME, this.getPSSaaSSysAPIName());
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
        return PSDepSysAPIBase.get(this, n);
    }

    private static Object get(PSDepSysAPIBase pSDepSysAPIBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSysAPIBase.getCreateDate();
            }
            case 1: {
                return pSDepSysAPIBase.getCreateMan();
            }
            case 2: {
                return pSDepSysAPIBase.getMemo();
            }
            case 3: {
                return pSDepSysAPIBase.getPSDepSysAPIId();
            }
            case 4: {
                return pSDepSysAPIBase.getPSDepSysAPIName();
            }
            case 5: {
                return pSDepSysAPIBase.getPSDepSysAPIType();
            }
            case 6: {
                return pSDepSysAPIBase.getPSDepSysVerId();
            }
            case 7: {
                return pSDepSysAPIBase.getPSDepSysVerName();
            }
            case 8: {
                return pSDepSysAPIBase.getPSDevSlnSysAPIId();
            }
            case 9: {
                return pSDepSysAPIBase.getPSDevSlnSysAPIName();
            }
            case 10: {
                return pSDepSysAPIBase.getPSSaaSSysAPIId();
            }
            case 11: {
                return pSDepSysAPIBase.getPSSaaSSysAPIName();
            }
            case 12: {
                return pSDepSysAPIBase.getUpdateDate();
            }
            case 13: {
                return pSDepSysAPIBase.getUpdateMan();
            }
            case 14: {
                return pSDepSysAPIBase.getUserCat();
            }
            case 15: {
                return pSDepSysAPIBase.getUserTag();
            }
            case 16: {
                return pSDepSysAPIBase.getUserTag2();
            }
            case 17: {
                return pSDepSysAPIBase.getUserTag3();
            }
            case 18: {
                return pSDepSysAPIBase.getUserTag4();
            }
            case 19: {
                return pSDepSysAPIBase.getValidFlag();
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
        PSDepSysAPIBase.set(this, n, object);
    }

    private static void set(PSDepSysAPIBase pSDepSysAPIBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDepSysAPIBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDepSysAPIBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDepSysAPIBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDepSysAPIBase.setPSDepSysAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDepSysAPIBase.setPSDepSysAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDepSysAPIBase.setPSDepSysAPIType(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDepSysAPIBase.setPSDepSysVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDepSysAPIBase.setPSDepSysVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDepSysAPIBase.setPSDevSlnSysAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDepSysAPIBase.setPSDevSlnSysAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDepSysAPIBase.setPSSaaSSysAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDepSysAPIBase.setPSSaaSSysAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDepSysAPIBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSDepSysAPIBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDepSysAPIBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDepSysAPIBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDepSysAPIBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDepSysAPIBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDepSysAPIBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDepSysAPIBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDepSysAPIBase.isNull(this, n);
    }

    private static boolean isNull(PSDepSysAPIBase pSDepSysAPIBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSysAPIBase.getCreateDate() == null;
            }
            case 1: {
                return pSDepSysAPIBase.getCreateMan() == null;
            }
            case 2: {
                return pSDepSysAPIBase.getMemo() == null;
            }
            case 3: {
                return pSDepSysAPIBase.getPSDepSysAPIId() == null;
            }
            case 4: {
                return pSDepSysAPIBase.getPSDepSysAPIName() == null;
            }
            case 5: {
                return pSDepSysAPIBase.getPSDepSysAPIType() == null;
            }
            case 6: {
                return pSDepSysAPIBase.getPSDepSysVerId() == null;
            }
            case 7: {
                return pSDepSysAPIBase.getPSDepSysVerName() == null;
            }
            case 8: {
                return pSDepSysAPIBase.getPSDevSlnSysAPIId() == null;
            }
            case 9: {
                return pSDepSysAPIBase.getPSDevSlnSysAPIName() == null;
            }
            case 10: {
                return pSDepSysAPIBase.getPSSaaSSysAPIId() == null;
            }
            case 11: {
                return pSDepSysAPIBase.getPSSaaSSysAPIName() == null;
            }
            case 12: {
                return pSDepSysAPIBase.getUpdateDate() == null;
            }
            case 13: {
                return pSDepSysAPIBase.getUpdateMan() == null;
            }
            case 14: {
                return pSDepSysAPIBase.getUserCat() == null;
            }
            case 15: {
                return pSDepSysAPIBase.getUserTag() == null;
            }
            case 16: {
                return pSDepSysAPIBase.getUserTag2() == null;
            }
            case 17: {
                return pSDepSysAPIBase.getUserTag3() == null;
            }
            case 18: {
                return pSDepSysAPIBase.getUserTag4() == null;
            }
            case 19: {
                return pSDepSysAPIBase.getValidFlag() == null;
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
        return PSDepSysAPIBase.contains(this, n);
    }

    private static boolean contains(PSDepSysAPIBase pSDepSysAPIBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSysAPIBase.isCreateDateDirty();
            }
            case 1: {
                return pSDepSysAPIBase.isCreateManDirty();
            }
            case 2: {
                return pSDepSysAPIBase.isMemoDirty();
            }
            case 3: {
                return pSDepSysAPIBase.isPSDepSysAPIIdDirty();
            }
            case 4: {
                return pSDepSysAPIBase.isPSDepSysAPINameDirty();
            }
            case 5: {
                return pSDepSysAPIBase.isPSDepSysAPITypeDirty();
            }
            case 6: {
                return pSDepSysAPIBase.isPSDepSysVerIdDirty();
            }
            case 7: {
                return pSDepSysAPIBase.isPSDepSysVerNameDirty();
            }
            case 8: {
                return pSDepSysAPIBase.isPSDevSlnSysAPIIdDirty();
            }
            case 9: {
                return pSDepSysAPIBase.isPSDevSlnSysAPINameDirty();
            }
            case 10: {
                return pSDepSysAPIBase.isPSSaaSSysAPIIdDirty();
            }
            case 11: {
                return pSDepSysAPIBase.isPSSaaSSysAPINameDirty();
            }
            case 12: {
                return pSDepSysAPIBase.isUpdateDateDirty();
            }
            case 13: {
                return pSDepSysAPIBase.isUpdateManDirty();
            }
            case 14: {
                return pSDepSysAPIBase.isUserCatDirty();
            }
            case 15: {
                return pSDepSysAPIBase.isUserTagDirty();
            }
            case 16: {
                return pSDepSysAPIBase.isUserTag2Dirty();
            }
            case 17: {
                return pSDepSysAPIBase.isUserTag3Dirty();
            }
            case 18: {
                return pSDepSysAPIBase.isUserTag4Dirty();
            }
            case 19: {
                return pSDepSysAPIBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDepSysAPIBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDepSysAPIBase pSDepSysAPIBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDepSysAPIBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDepSysAPIBase.getJSONValue((Object)pSDepSysAPIBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDepSysAPIBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDepSysAPIBase.getJSONValue((Object)pSDepSysAPIBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDepSysAPIBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDepSysAPIBase.getJSONValue((Object)pSDepSysAPIBase.getMemo()), (boolean)false);
        }
        if (bl || pSDepSysAPIBase.getPSDepSysAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepsysapiid", (Object)PSDepSysAPIBase.getJSONValue((Object)pSDepSysAPIBase.getPSDepSysAPIId()), (boolean)false);
        }
        if (bl || pSDepSysAPIBase.getPSDepSysAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepsysapiname", (Object)PSDepSysAPIBase.getJSONValue((Object)pSDepSysAPIBase.getPSDepSysAPIName()), (boolean)false);
        }
        if (bl || pSDepSysAPIBase.getPSDepSysAPIType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepsysapitype", (Object)PSDepSysAPIBase.getJSONValue((Object)pSDepSysAPIBase.getPSDepSysAPIType()), (boolean)false);
        }
        if (bl || pSDepSysAPIBase.getPSDepSysVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepsysverid", (Object)PSDepSysAPIBase.getJSONValue((Object)pSDepSysAPIBase.getPSDepSysVerId()), (boolean)false);
        }
        if (bl || pSDepSysAPIBase.getPSDepSysVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepsysvername", (Object)PSDepSysAPIBase.getJSONValue((Object)pSDepSysAPIBase.getPSDepSysVerName()), (boolean)false);
        }
        if (bl || pSDepSysAPIBase.getPSDevSlnSysAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysapiid", (Object)PSDepSysAPIBase.getJSONValue((Object)pSDepSysAPIBase.getPSDevSlnSysAPIId()), (boolean)false);
        }
        if (bl || pSDepSysAPIBase.getPSDevSlnSysAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysapiname", (Object)PSDepSysAPIBase.getJSONValue((Object)pSDepSysAPIBase.getPSDevSlnSysAPIName()), (boolean)false);
        }
        if (bl || pSDepSysAPIBase.getPSSaaSSysAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssaassysapiid", (Object)PSDepSysAPIBase.getJSONValue((Object)pSDepSysAPIBase.getPSSaaSSysAPIId()), (boolean)false);
        }
        if (bl || pSDepSysAPIBase.getPSSaaSSysAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssaassysapiname", (Object)PSDepSysAPIBase.getJSONValue((Object)pSDepSysAPIBase.getPSSaaSSysAPIName()), (boolean)false);
        }
        if (bl || pSDepSysAPIBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDepSysAPIBase.getJSONValue((Object)pSDepSysAPIBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDepSysAPIBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDepSysAPIBase.getJSONValue((Object)pSDepSysAPIBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDepSysAPIBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDepSysAPIBase.getJSONValue((Object)pSDepSysAPIBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDepSysAPIBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDepSysAPIBase.getJSONValue((Object)pSDepSysAPIBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDepSysAPIBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDepSysAPIBase.getJSONValue((Object)pSDepSysAPIBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDepSysAPIBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDepSysAPIBase.getJSONValue((Object)pSDepSysAPIBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDepSysAPIBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDepSysAPIBase.getJSONValue((Object)pSDepSysAPIBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDepSysAPIBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDepSysAPIBase.getJSONValue((Object)pSDepSysAPIBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDepSysAPIBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDepSysAPIBase pSDepSysAPIBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDepSysAPIBase.getCreateDate() != null) {
            object = pSDepSysAPIBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSysAPIBase.getCreateMan() != null) {
            object = pSDepSysAPIBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysAPIBase.getMemo() != null) {
            object = pSDepSysAPIBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysAPIBase.getPSDepSysAPIId() != null) {
            object = pSDepSysAPIBase.getPSDepSysAPIId();
            xmlNode.setAttribute(FIELD_PSDEPSYSAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysAPIBase.getPSDepSysAPIName() != null) {
            object = pSDepSysAPIBase.getPSDepSysAPIName();
            xmlNode.setAttribute(FIELD_PSDEPSYSAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysAPIBase.getPSDepSysAPIType() != null) {
            object = pSDepSysAPIBase.getPSDepSysAPIType();
            xmlNode.setAttribute(FIELD_PSDEPSYSAPITYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysAPIBase.getPSDepSysVerId() != null) {
            object = pSDepSysAPIBase.getPSDepSysVerId();
            xmlNode.setAttribute(FIELD_PSDEPSYSVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysAPIBase.getPSDepSysVerName() != null) {
            object = pSDepSysAPIBase.getPSDepSysVerName();
            xmlNode.setAttribute(FIELD_PSDEPSYSVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysAPIBase.getPSDevSlnSysAPIId() != null) {
            object = pSDepSysAPIBase.getPSDevSlnSysAPIId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysAPIBase.getPSDevSlnSysAPIName() != null) {
            object = pSDepSysAPIBase.getPSDevSlnSysAPIName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysAPIBase.getPSSaaSSysAPIId() != null) {
            object = pSDepSysAPIBase.getPSSaaSSysAPIId();
            xmlNode.setAttribute(FIELD_PSSAASSYSAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysAPIBase.getPSSaaSSysAPIName() != null) {
            object = pSDepSysAPIBase.getPSSaaSSysAPIName();
            xmlNode.setAttribute(FIELD_PSSAASSYSAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysAPIBase.getUpdateDate() != null) {
            object = pSDepSysAPIBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSysAPIBase.getUpdateMan() != null) {
            object = pSDepSysAPIBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysAPIBase.getUserCat() != null) {
            object = pSDepSysAPIBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysAPIBase.getUserTag() != null) {
            object = pSDepSysAPIBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysAPIBase.getUserTag2() != null) {
            object = pSDepSysAPIBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysAPIBase.getUserTag3() != null) {
            object = pSDepSysAPIBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysAPIBase.getUserTag4() != null) {
            object = pSDepSysAPIBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysAPIBase.getValidFlag() != null) {
            object = pSDepSysAPIBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDepSysAPIBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDepSysAPIBase pSDepSysAPIBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDepSysAPIBase.isCreateDateDirty() && (bl || pSDepSysAPIBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDepSysAPIBase.getCreateDate());
        }
        if (pSDepSysAPIBase.isCreateManDirty() && (bl || pSDepSysAPIBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDepSysAPIBase.getCreateMan());
        }
        if (pSDepSysAPIBase.isMemoDirty() && (bl || pSDepSysAPIBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDepSysAPIBase.getMemo());
        }
        if (pSDepSysAPIBase.isPSDepSysAPIIdDirty() && (bl || pSDepSysAPIBase.getPSDepSysAPIId() != null)) {
            iDataObject.set(FIELD_PSDEPSYSAPIID, (Object)pSDepSysAPIBase.getPSDepSysAPIId());
        }
        if (pSDepSysAPIBase.isPSDepSysAPINameDirty() && (bl || pSDepSysAPIBase.getPSDepSysAPIName() != null)) {
            iDataObject.set(FIELD_PSDEPSYSAPINAME, (Object)pSDepSysAPIBase.getPSDepSysAPIName());
        }
        if (pSDepSysAPIBase.isPSDepSysAPITypeDirty() && (bl || pSDepSysAPIBase.getPSDepSysAPIType() != null)) {
            iDataObject.set(FIELD_PSDEPSYSAPITYPE, (Object)pSDepSysAPIBase.getPSDepSysAPIType());
        }
        if (pSDepSysAPIBase.isPSDepSysVerIdDirty() && (bl || pSDepSysAPIBase.getPSDepSysVerId() != null)) {
            iDataObject.set(FIELD_PSDEPSYSVERID, (Object)pSDepSysAPIBase.getPSDepSysVerId());
        }
        if (pSDepSysAPIBase.isPSDepSysVerNameDirty() && (bl || pSDepSysAPIBase.getPSDepSysVerName() != null)) {
            iDataObject.set(FIELD_PSDEPSYSVERNAME, (Object)pSDepSysAPIBase.getPSDepSysVerName());
        }
        if (pSDepSysAPIBase.isPSDevSlnSysAPIIdDirty() && (bl || pSDepSysAPIBase.getPSDevSlnSysAPIId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSAPIID, (Object)pSDepSysAPIBase.getPSDevSlnSysAPIId());
        }
        if (pSDepSysAPIBase.isPSDevSlnSysAPINameDirty() && (bl || pSDepSysAPIBase.getPSDevSlnSysAPIName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSAPINAME, (Object)pSDepSysAPIBase.getPSDevSlnSysAPIName());
        }
        if (pSDepSysAPIBase.isPSSaaSSysAPIIdDirty() && (bl || pSDepSysAPIBase.getPSSaaSSysAPIId() != null)) {
            iDataObject.set(FIELD_PSSAASSYSAPIID, (Object)pSDepSysAPIBase.getPSSaaSSysAPIId());
        }
        if (pSDepSysAPIBase.isPSSaaSSysAPINameDirty() && (bl || pSDepSysAPIBase.getPSSaaSSysAPIName() != null)) {
            iDataObject.set(FIELD_PSSAASSYSAPINAME, (Object)pSDepSysAPIBase.getPSSaaSSysAPIName());
        }
        if (pSDepSysAPIBase.isUpdateDateDirty() && (bl || pSDepSysAPIBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDepSysAPIBase.getUpdateDate());
        }
        if (pSDepSysAPIBase.isUpdateManDirty() && (bl || pSDepSysAPIBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDepSysAPIBase.getUpdateMan());
        }
        if (pSDepSysAPIBase.isUserCatDirty() && (bl || pSDepSysAPIBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDepSysAPIBase.getUserCat());
        }
        if (pSDepSysAPIBase.isUserTagDirty() && (bl || pSDepSysAPIBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDepSysAPIBase.getUserTag());
        }
        if (pSDepSysAPIBase.isUserTag2Dirty() && (bl || pSDepSysAPIBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDepSysAPIBase.getUserTag2());
        }
        if (pSDepSysAPIBase.isUserTag3Dirty() && (bl || pSDepSysAPIBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDepSysAPIBase.getUserTag3());
        }
        if (pSDepSysAPIBase.isUserTag4Dirty() && (bl || pSDepSysAPIBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDepSysAPIBase.getUserTag4());
        }
        if (pSDepSysAPIBase.isValidFlagDirty() && (bl || pSDepSysAPIBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDepSysAPIBase.getValidFlag());
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
        return PSDepSysAPIBase.remove(this, n);
    }

    private static boolean remove(PSDepSysAPIBase pSDepSysAPIBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDepSysAPIBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDepSysAPIBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDepSysAPIBase.resetMemo();
                return true;
            }
            case 3: {
                pSDepSysAPIBase.resetPSDepSysAPIId();
                return true;
            }
            case 4: {
                pSDepSysAPIBase.resetPSDepSysAPIName();
                return true;
            }
            case 5: {
                pSDepSysAPIBase.resetPSDepSysAPIType();
                return true;
            }
            case 6: {
                pSDepSysAPIBase.resetPSDepSysVerId();
                return true;
            }
            case 7: {
                pSDepSysAPIBase.resetPSDepSysVerName();
                return true;
            }
            case 8: {
                pSDepSysAPIBase.resetPSDevSlnSysAPIId();
                return true;
            }
            case 9: {
                pSDepSysAPIBase.resetPSDevSlnSysAPIName();
                return true;
            }
            case 10: {
                pSDepSysAPIBase.resetPSSaaSSysAPIId();
                return true;
            }
            case 11: {
                pSDepSysAPIBase.resetPSSaaSSysAPIName();
                return true;
            }
            case 12: {
                pSDepSysAPIBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSDepSysAPIBase.resetUpdateMan();
                return true;
            }
            case 14: {
                pSDepSysAPIBase.resetUserCat();
                return true;
            }
            case 15: {
                pSDepSysAPIBase.resetUserTag();
                return true;
            }
            case 16: {
                pSDepSysAPIBase.resetUserTag2();
                return true;
            }
            case 17: {
                pSDepSysAPIBase.resetUserTag3();
                return true;
            }
            case 18: {
                pSDepSysAPIBase.resetUserTag4();
                return true;
            }
            case 19: {
                pSDepSysAPIBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSysVer getPSDepSysVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSysVer();
        }
        if (this.getPSDepSysVerId() == null) {
            return null;
        }
        Integer n = this.objPSDepSysVerLock;
        synchronized (n) {
            if (this.psdepsysver != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSysVerId(), (Object)this.psdepsysver.getPSDepSysVerId()) != 0L) {
                this.psdepsysver = null;
            }
            if (this.psdepsysver == null) {
                PSDepSysVer pSDepSysVer = new PSDepSysVer();
                pSDepSysVer.setPSDepSysVerId(this.getPSDepSysVerId());
                PSDepSysVerService pSDepSysVerService = (PSDepSysVerService)ServiceGlobal.getService(PSDepSysVerService.class, (SessionFactory)this.getSessionFactory());
                pSDepSysVerService.autoGet(pSDepSysVer);
                this.psdepsysver = pSDepSysVer;
            }
            return this.psdepsysver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSysAPI getPSDevSlnSysAPI() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysAPI();
        }
        if (this.getPSDevSlnSysAPIId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysAPILock;
        synchronized (n) {
            if (this.psdevslnsysapi != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysAPIId(), (Object)this.psdevslnsysapi.getPSDevSlnSysAPIId()) != 0L) {
                this.psdevslnsysapi = null;
            }
            if (this.psdevslnsysapi == null) {
                PSDevSlnSysAPI pSDevSlnSysAPI = new PSDevSlnSysAPI();
                pSDevSlnSysAPI.setPSDevSlnSysAPIId(this.getPSDevSlnSysAPIId());
                PSDevSlnSysAPIService pSDevSlnSysAPIService = (PSDevSlnSysAPIService)ServiceGlobal.getService(PSDevSlnSysAPIService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysAPIService.autoGet(pSDevSlnSysAPI);
                this.psdevslnsysapi = pSDevSlnSysAPI;
            }
            return this.psdevslnsysapi;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSaaSSysAPI getPSSaaSSysAPI() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSysAPI();
        }
        if (this.getPSSaaSSysAPIId() == null) {
            return null;
        }
        Integer n = this.objPSSaaSSysAPILock;
        synchronized (n) {
            if (this.pssaassysapi != null && DataTypeHelper.compare((int)25, (Object)this.getPSSaaSSysAPIId(), (Object)this.pssaassysapi.getPSSaaSSysAPIId()) != 0L) {
                this.pssaassysapi = null;
            }
            if (this.pssaassysapi == null) {
                PSSaaSSysAPI pSSaaSSysAPI = new PSSaaSSysAPI();
                pSSaaSSysAPI.setPSSaaSSysAPIId(this.getPSSaaSSysAPIId());
                PSSaaSSysAPIService pSSaaSSysAPIService = (PSSaaSSysAPIService)ServiceGlobal.getService(PSSaaSSysAPIService.class, (SessionFactory)this.getSessionFactory());
                pSSaaSSysAPIService.autoGet(pSSaaSSysAPI);
                this.pssaassysapi = pSSaaSSysAPI;
            }
            return this.pssaassysapi;
        }
    }

    private PSDepSysAPIBase getProxyEntity() {
        return this.proxyPSDepSysAPIBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDepSysAPIBase = null;
        if (iDataObject != null && iDataObject instanceof PSDepSysAPIBase) {
            this.proxyPSDepSysAPIBase = (PSDepSysAPIBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysAPIService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDEPSYSAPIID, 3);
        fieldIndexMap.put(FIELD_PSDEPSYSAPINAME, 4);
        fieldIndexMap.put(FIELD_PSDEPSYSAPITYPE, 5);
        fieldIndexMap.put(FIELD_PSDEPSYSVERID, 6);
        fieldIndexMap.put(FIELD_PSDEPSYSVERNAME, 7);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSAPIID, 8);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSAPINAME, 9);
        fieldIndexMap.put(FIELD_PSSAASSYSAPIID, 10);
        fieldIndexMap.put(FIELD_PSSAASSYSAPINAME, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
        fieldIndexMap.put(FIELD_USERCAT, 14);
        fieldIndexMap.put(FIELD_USERTAG, 15);
        fieldIndexMap.put(FIELD_USERTAG2, 16);
        fieldIndexMap.put(FIELD_USERTAG3, 17);
        fieldIndexMap.put(FIELD_USERTAG4, 18);
        fieldIndexMap.put(FIELD_VALIDFLAG, 19);
    }
}

