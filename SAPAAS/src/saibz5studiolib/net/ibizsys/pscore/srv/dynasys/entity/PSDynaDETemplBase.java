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
package net.ibizsys.pscore.srv.dynasys.entity;

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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEFormTempl;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEViewTempl;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDEFormTemplService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDEViewTemplService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDynaDETemplBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDynaDETemplBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDYNADETEMPLID = "PSDYNADETEMPLID";
    public static final String FIELD_PSDYNADETEMPLNAME = "PSDYNADETEMPLNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_TEMPLPSDEID = "TEMPLPSDEID";
    public static final String FIELD_TEMPLPSDENAME = "TEMPLPSDENAME";
    public static final String FIELD_TYPEPSDEFID = "TYPEPSDEFID";
    public static final String FIELD_TYPEPSDEFNAME = "TYPEPSDEFNAME";
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
    private static final int INDEX_PSDYNADETEMPLID = 3;
    private static final int INDEX_PSDYNADETEMPLNAME = 4;
    private static final int INDEX_PSSYSTEMID = 5;
    private static final int INDEX_PSSYSTEMNAME = 6;
    private static final int INDEX_TEMPLPSDEID = 7;
    private static final int INDEX_TEMPLPSDENAME = 8;
    private static final int INDEX_TYPEPSDEFID = 9;
    private static final int INDEX_TYPEPSDEFNAME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_USERCAT = 13;
    private static final int INDEX_USERTAG = 14;
    private static final int INDEX_USERTAG2 = 15;
    private static final int INDEX_USERTAG3 = 16;
    private static final int INDEX_USERTAG4 = 17;
    private static final int INDEX_VALIDFLAG = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDynaDETemplBase proxyPSDynaDETemplBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdynadetemplidDirtyFlag = false;
    private boolean psdynadetemplnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean templpsdeidDirtyFlag = false;
    private boolean templpsdenameDirtyFlag = false;
    private boolean typepsdefidDirtyFlag = false;
    private boolean typepsdefnameDirtyFlag = false;
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
    @Column(name="psdynadetemplid")
    private String psdynadetemplid;
    @Column(name="psdynadetemplname")
    private String psdynadetemplname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="templpsdeid")
    private String templpsdeid;
    @Column(name="templpsdename")
    private String templpsdename;
    @Column(name="typepsdefid")
    private String typepsdefid;
    @Column(name="typepsdefname")
    private String typepsdefname;
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
    private Integer objTemplPSDELock = new Integer(1);
    private PSDataEntity templpsde = null;
    private Integer objTypePSDEFLock = new Integer(1);
    private PSDEField typepsdef = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSDynaDEFormTemplsLock = new Integer(1);
    private ArrayList<PSDynaDEFormTempl> psdynadeformtempls = null;
    private Integer objPSDynaDEViewTemplsLock = new Integer(1);
    private ArrayList<PSDynaDEViewTempl> psdynadeviewtempls = null;

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

    public void setPSDynaDETemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaDETemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynadetemplid = string;
        this.psdynadetemplidDirtyFlag = true;
    }

    public String getPSDynaDETemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDETemplId();
        }
        return this.psdynadetemplid;
    }

    public boolean isPSDynaDETemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaDETemplIdDirty();
        }
        return this.psdynadetemplidDirtyFlag;
    }

    public void resetPSDynaDETemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaDETemplId();
            return;
        }
        this.psdynadetemplidDirtyFlag = false;
        this.psdynadetemplid = null;
    }

    public void setPSDynaDETemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaDETemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynadetemplname = string;
        this.psdynadetemplnameDirtyFlag = true;
    }

    public String getPSDynaDETemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDETemplName();
        }
        return this.psdynadetemplname;
    }

    public boolean isPSDynaDETemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaDETemplNameDirty();
        }
        return this.psdynadetemplnameDirtyFlag;
    }

    public void resetPSDynaDETemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaDETemplName();
            return;
        }
        this.psdynadetemplnameDirtyFlag = false;
        this.psdynadetemplname = null;
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

    public void setTemplPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templpsdeid = string;
        this.templpsdeidDirtyFlag = true;
    }

    public String getTemplPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplPSDEId();
        }
        return this.templpsdeid;
    }

    public boolean isTemplPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplPSDEIdDirty();
        }
        return this.templpsdeidDirtyFlag;
    }

    public void resetTemplPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplPSDEId();
            return;
        }
        this.templpsdeidDirtyFlag = false;
        this.templpsdeid = null;
    }

    public void setTemplPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templpsdename = string;
        this.templpsdenameDirtyFlag = true;
    }

    public String getTemplPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplPSDEName();
        }
        return this.templpsdename;
    }

    public boolean isTemplPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplPSDENameDirty();
        }
        return this.templpsdenameDirtyFlag;
    }

    public void resetTemplPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplPSDEName();
            return;
        }
        this.templpsdenameDirtyFlag = false;
        this.templpsdename = null;
    }

    public void setTypePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typepsdefid = string;
        this.typepsdefidDirtyFlag = true;
    }

    public String getTypePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypePSDEFId();
        }
        return this.typepsdefid;
    }

    public boolean isTypePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypePSDEFIdDirty();
        }
        return this.typepsdefidDirtyFlag;
    }

    public void resetTypePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypePSDEFId();
            return;
        }
        this.typepsdefidDirtyFlag = false;
        this.typepsdefid = null;
    }

    public void setTypePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typepsdefname = string;
        this.typepsdefnameDirtyFlag = true;
    }

    public String getTypePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypePSDEFName();
        }
        return this.typepsdefname;
    }

    public boolean isTypePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypePSDEFNameDirty();
        }
        return this.typepsdefnameDirtyFlag;
    }

    public void resetTypePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypePSDEFName();
            return;
        }
        this.typepsdefnameDirtyFlag = false;
        this.typepsdefname = null;
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
        PSDynaDETemplBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDynaDETemplBase pSDynaDETemplBase) {
        pSDynaDETemplBase.resetCreateDate();
        pSDynaDETemplBase.resetCreateMan();
        pSDynaDETemplBase.resetMemo();
        pSDynaDETemplBase.resetPSDynaDETemplId();
        pSDynaDETemplBase.resetPSDynaDETemplName();
        pSDynaDETemplBase.resetPSSystemId();
        pSDynaDETemplBase.resetPSSystemName();
        pSDynaDETemplBase.resetTemplPSDEId();
        pSDynaDETemplBase.resetTemplPSDEName();
        pSDynaDETemplBase.resetTypePSDEFId();
        pSDynaDETemplBase.resetTypePSDEFName();
        pSDynaDETemplBase.resetUpdateDate();
        pSDynaDETemplBase.resetUpdateMan();
        pSDynaDETemplBase.resetUserCat();
        pSDynaDETemplBase.resetUserTag();
        pSDynaDETemplBase.resetUserTag2();
        pSDynaDETemplBase.resetUserTag3();
        pSDynaDETemplBase.resetUserTag4();
        pSDynaDETemplBase.resetValidFlag();
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
        if (!bl || this.isPSDynaDETemplIdDirty()) {
            hashMap.put(FIELD_PSDYNADETEMPLID, this.getPSDynaDETemplId());
        }
        if (!bl || this.isPSDynaDETemplNameDirty()) {
            hashMap.put(FIELD_PSDYNADETEMPLNAME, this.getPSDynaDETemplName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isTemplPSDEIdDirty()) {
            hashMap.put(FIELD_TEMPLPSDEID, this.getTemplPSDEId());
        }
        if (!bl || this.isTemplPSDENameDirty()) {
            hashMap.put(FIELD_TEMPLPSDENAME, this.getTemplPSDEName());
        }
        if (!bl || this.isTypePSDEFIdDirty()) {
            hashMap.put(FIELD_TYPEPSDEFID, this.getTypePSDEFId());
        }
        if (!bl || this.isTypePSDEFNameDirty()) {
            hashMap.put(FIELD_TYPEPSDEFNAME, this.getTypePSDEFName());
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
        return PSDynaDETemplBase.get(this, n);
    }

    private static Object get(PSDynaDETemplBase pSDynaDETemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaDETemplBase.getCreateDate();
            }
            case 1: {
                return pSDynaDETemplBase.getCreateMan();
            }
            case 2: {
                return pSDynaDETemplBase.getMemo();
            }
            case 3: {
                return pSDynaDETemplBase.getPSDynaDETemplId();
            }
            case 4: {
                return pSDynaDETemplBase.getPSDynaDETemplName();
            }
            case 5: {
                return pSDynaDETemplBase.getPSSystemId();
            }
            case 6: {
                return pSDynaDETemplBase.getPSSystemName();
            }
            case 7: {
                return pSDynaDETemplBase.getTemplPSDEId();
            }
            case 8: {
                return pSDynaDETemplBase.getTemplPSDEName();
            }
            case 9: {
                return pSDynaDETemplBase.getTypePSDEFId();
            }
            case 10: {
                return pSDynaDETemplBase.getTypePSDEFName();
            }
            case 11: {
                return pSDynaDETemplBase.getUpdateDate();
            }
            case 12: {
                return pSDynaDETemplBase.getUpdateMan();
            }
            case 13: {
                return pSDynaDETemplBase.getUserCat();
            }
            case 14: {
                return pSDynaDETemplBase.getUserTag();
            }
            case 15: {
                return pSDynaDETemplBase.getUserTag2();
            }
            case 16: {
                return pSDynaDETemplBase.getUserTag3();
            }
            case 17: {
                return pSDynaDETemplBase.getUserTag4();
            }
            case 18: {
                return pSDynaDETemplBase.getValidFlag();
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
        PSDynaDETemplBase.set(this, n, object);
    }

    private static void set(PSDynaDETemplBase pSDynaDETemplBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDynaDETemplBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDynaDETemplBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDynaDETemplBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDynaDETemplBase.setPSDynaDETemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDynaDETemplBase.setPSDynaDETemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDynaDETemplBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDynaDETemplBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDynaDETemplBase.setTemplPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDynaDETemplBase.setTemplPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDynaDETemplBase.setTypePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDynaDETemplBase.setTypePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDynaDETemplBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSDynaDETemplBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDynaDETemplBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDynaDETemplBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDynaDETemplBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDynaDETemplBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDynaDETemplBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDynaDETemplBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDynaDETemplBase.isNull(this, n);
    }

    private static boolean isNull(PSDynaDETemplBase pSDynaDETemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaDETemplBase.getCreateDate() == null;
            }
            case 1: {
                return pSDynaDETemplBase.getCreateMan() == null;
            }
            case 2: {
                return pSDynaDETemplBase.getMemo() == null;
            }
            case 3: {
                return pSDynaDETemplBase.getPSDynaDETemplId() == null;
            }
            case 4: {
                return pSDynaDETemplBase.getPSDynaDETemplName() == null;
            }
            case 5: {
                return pSDynaDETemplBase.getPSSystemId() == null;
            }
            case 6: {
                return pSDynaDETemplBase.getPSSystemName() == null;
            }
            case 7: {
                return pSDynaDETemplBase.getTemplPSDEId() == null;
            }
            case 8: {
                return pSDynaDETemplBase.getTemplPSDEName() == null;
            }
            case 9: {
                return pSDynaDETemplBase.getTypePSDEFId() == null;
            }
            case 10: {
                return pSDynaDETemplBase.getTypePSDEFName() == null;
            }
            case 11: {
                return pSDynaDETemplBase.getUpdateDate() == null;
            }
            case 12: {
                return pSDynaDETemplBase.getUpdateMan() == null;
            }
            case 13: {
                return pSDynaDETemplBase.getUserCat() == null;
            }
            case 14: {
                return pSDynaDETemplBase.getUserTag() == null;
            }
            case 15: {
                return pSDynaDETemplBase.getUserTag2() == null;
            }
            case 16: {
                return pSDynaDETemplBase.getUserTag3() == null;
            }
            case 17: {
                return pSDynaDETemplBase.getUserTag4() == null;
            }
            case 18: {
                return pSDynaDETemplBase.getValidFlag() == null;
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
        return PSDynaDETemplBase.contains(this, n);
    }

    private static boolean contains(PSDynaDETemplBase pSDynaDETemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaDETemplBase.isCreateDateDirty();
            }
            case 1: {
                return pSDynaDETemplBase.isCreateManDirty();
            }
            case 2: {
                return pSDynaDETemplBase.isMemoDirty();
            }
            case 3: {
                return pSDynaDETemplBase.isPSDynaDETemplIdDirty();
            }
            case 4: {
                return pSDynaDETemplBase.isPSDynaDETemplNameDirty();
            }
            case 5: {
                return pSDynaDETemplBase.isPSSystemIdDirty();
            }
            case 6: {
                return pSDynaDETemplBase.isPSSystemNameDirty();
            }
            case 7: {
                return pSDynaDETemplBase.isTemplPSDEIdDirty();
            }
            case 8: {
                return pSDynaDETemplBase.isTemplPSDENameDirty();
            }
            case 9: {
                return pSDynaDETemplBase.isTypePSDEFIdDirty();
            }
            case 10: {
                return pSDynaDETemplBase.isTypePSDEFNameDirty();
            }
            case 11: {
                return pSDynaDETemplBase.isUpdateDateDirty();
            }
            case 12: {
                return pSDynaDETemplBase.isUpdateManDirty();
            }
            case 13: {
                return pSDynaDETemplBase.isUserCatDirty();
            }
            case 14: {
                return pSDynaDETemplBase.isUserTagDirty();
            }
            case 15: {
                return pSDynaDETemplBase.isUserTag2Dirty();
            }
            case 16: {
                return pSDynaDETemplBase.isUserTag3Dirty();
            }
            case 17: {
                return pSDynaDETemplBase.isUserTag4Dirty();
            }
            case 18: {
                return pSDynaDETemplBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDynaDETemplBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDynaDETemplBase pSDynaDETemplBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDynaDETemplBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDynaDETemplBase.getJSONValue((Object)pSDynaDETemplBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDynaDETemplBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDynaDETemplBase.getJSONValue((Object)pSDynaDETemplBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDynaDETemplBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDynaDETemplBase.getJSONValue((Object)pSDynaDETemplBase.getMemo()), (boolean)false);
        }
        if (bl || pSDynaDETemplBase.getPSDynaDETemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynadetemplid", (Object)PSDynaDETemplBase.getJSONValue((Object)pSDynaDETemplBase.getPSDynaDETemplId()), (boolean)false);
        }
        if (bl || pSDynaDETemplBase.getPSDynaDETemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynadetemplname", (Object)PSDynaDETemplBase.getJSONValue((Object)pSDynaDETemplBase.getPSDynaDETemplName()), (boolean)false);
        }
        if (bl || pSDynaDETemplBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSDynaDETemplBase.getJSONValue((Object)pSDynaDETemplBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSDynaDETemplBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSDynaDETemplBase.getJSONValue((Object)pSDynaDETemplBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSDynaDETemplBase.getTemplPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templpsdeid", (Object)PSDynaDETemplBase.getJSONValue((Object)pSDynaDETemplBase.getTemplPSDEId()), (boolean)false);
        }
        if (bl || pSDynaDETemplBase.getTemplPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templpsdename", (Object)PSDynaDETemplBase.getJSONValue((Object)pSDynaDETemplBase.getTemplPSDEName()), (boolean)false);
        }
        if (bl || pSDynaDETemplBase.getTypePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typepsdefid", (Object)PSDynaDETemplBase.getJSONValue((Object)pSDynaDETemplBase.getTypePSDEFId()), (boolean)false);
        }
        if (bl || pSDynaDETemplBase.getTypePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typepsdefname", (Object)PSDynaDETemplBase.getJSONValue((Object)pSDynaDETemplBase.getTypePSDEFName()), (boolean)false);
        }
        if (bl || pSDynaDETemplBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDynaDETemplBase.getJSONValue((Object)pSDynaDETemplBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDynaDETemplBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDynaDETemplBase.getJSONValue((Object)pSDynaDETemplBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDynaDETemplBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDynaDETemplBase.getJSONValue((Object)pSDynaDETemplBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDynaDETemplBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDynaDETemplBase.getJSONValue((Object)pSDynaDETemplBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDynaDETemplBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDynaDETemplBase.getJSONValue((Object)pSDynaDETemplBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDynaDETemplBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDynaDETemplBase.getJSONValue((Object)pSDynaDETemplBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDynaDETemplBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDynaDETemplBase.getJSONValue((Object)pSDynaDETemplBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDynaDETemplBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDynaDETemplBase.getJSONValue((Object)pSDynaDETemplBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDynaDETemplBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDynaDETemplBase pSDynaDETemplBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDynaDETemplBase.getCreateDate() != null) {
            object = pSDynaDETemplBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDynaDETemplBase.getCreateMan() != null) {
            object = pSDynaDETemplBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDETemplBase.getMemo() != null) {
            object = pSDynaDETemplBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDETemplBase.getPSDynaDETemplId() != null) {
            object = pSDynaDETemplBase.getPSDynaDETemplId();
            xmlNode.setAttribute(FIELD_PSDYNADETEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDETemplBase.getPSDynaDETemplName() != null) {
            object = pSDynaDETemplBase.getPSDynaDETemplName();
            xmlNode.setAttribute(FIELD_PSDYNADETEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDETemplBase.getPSSystemId() != null) {
            object = pSDynaDETemplBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDETemplBase.getPSSystemName() != null) {
            object = pSDynaDETemplBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDETemplBase.getTemplPSDEId() != null) {
            object = pSDynaDETemplBase.getTemplPSDEId();
            xmlNode.setAttribute(FIELD_TEMPLPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDETemplBase.getTemplPSDEName() != null) {
            object = pSDynaDETemplBase.getTemplPSDEName();
            xmlNode.setAttribute(FIELD_TEMPLPSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDETemplBase.getTypePSDEFId() != null) {
            object = pSDynaDETemplBase.getTypePSDEFId();
            xmlNode.setAttribute(FIELD_TYPEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDETemplBase.getTypePSDEFName() != null) {
            object = pSDynaDETemplBase.getTypePSDEFName();
            xmlNode.setAttribute(FIELD_TYPEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDETemplBase.getUpdateDate() != null) {
            object = pSDynaDETemplBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDynaDETemplBase.getUpdateMan() != null) {
            object = pSDynaDETemplBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDETemplBase.getUserCat() != null) {
            object = pSDynaDETemplBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDETemplBase.getUserTag() != null) {
            object = pSDynaDETemplBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDETemplBase.getUserTag2() != null) {
            object = pSDynaDETemplBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDETemplBase.getUserTag3() != null) {
            object = pSDynaDETemplBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDETemplBase.getUserTag4() != null) {
            object = pSDynaDETemplBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDETemplBase.getValidFlag() != null) {
            object = pSDynaDETemplBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDynaDETemplBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDynaDETemplBase pSDynaDETemplBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDynaDETemplBase.isCreateDateDirty() && (bl || pSDynaDETemplBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDynaDETemplBase.getCreateDate());
        }
        if (pSDynaDETemplBase.isCreateManDirty() && (bl || pSDynaDETemplBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDynaDETemplBase.getCreateMan());
        }
        if (pSDynaDETemplBase.isMemoDirty() && (bl || pSDynaDETemplBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDynaDETemplBase.getMemo());
        }
        if (pSDynaDETemplBase.isPSDynaDETemplIdDirty() && (bl || pSDynaDETemplBase.getPSDynaDETemplId() != null)) {
            iDataObject.set(FIELD_PSDYNADETEMPLID, (Object)pSDynaDETemplBase.getPSDynaDETemplId());
        }
        if (pSDynaDETemplBase.isPSDynaDETemplNameDirty() && (bl || pSDynaDETemplBase.getPSDynaDETemplName() != null)) {
            iDataObject.set(FIELD_PSDYNADETEMPLNAME, (Object)pSDynaDETemplBase.getPSDynaDETemplName());
        }
        if (pSDynaDETemplBase.isPSSystemIdDirty() && (bl || pSDynaDETemplBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSDynaDETemplBase.getPSSystemId());
        }
        if (pSDynaDETemplBase.isPSSystemNameDirty() && (bl || pSDynaDETemplBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSDynaDETemplBase.getPSSystemName());
        }
        if (pSDynaDETemplBase.isTemplPSDEIdDirty() && (bl || pSDynaDETemplBase.getTemplPSDEId() != null)) {
            iDataObject.set(FIELD_TEMPLPSDEID, (Object)pSDynaDETemplBase.getTemplPSDEId());
        }
        if (pSDynaDETemplBase.isTemplPSDENameDirty() && (bl || pSDynaDETemplBase.getTemplPSDEName() != null)) {
            iDataObject.set(FIELD_TEMPLPSDENAME, (Object)pSDynaDETemplBase.getTemplPSDEName());
        }
        if (pSDynaDETemplBase.isTypePSDEFIdDirty() && (bl || pSDynaDETemplBase.getTypePSDEFId() != null)) {
            iDataObject.set(FIELD_TYPEPSDEFID, (Object)pSDynaDETemplBase.getTypePSDEFId());
        }
        if (pSDynaDETemplBase.isTypePSDEFNameDirty() && (bl || pSDynaDETemplBase.getTypePSDEFName() != null)) {
            iDataObject.set(FIELD_TYPEPSDEFNAME, (Object)pSDynaDETemplBase.getTypePSDEFName());
        }
        if (pSDynaDETemplBase.isUpdateDateDirty() && (bl || pSDynaDETemplBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDynaDETemplBase.getUpdateDate());
        }
        if (pSDynaDETemplBase.isUpdateManDirty() && (bl || pSDynaDETemplBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDynaDETemplBase.getUpdateMan());
        }
        if (pSDynaDETemplBase.isUserCatDirty() && (bl || pSDynaDETemplBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDynaDETemplBase.getUserCat());
        }
        if (pSDynaDETemplBase.isUserTagDirty() && (bl || pSDynaDETemplBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDynaDETemplBase.getUserTag());
        }
        if (pSDynaDETemplBase.isUserTag2Dirty() && (bl || pSDynaDETemplBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDynaDETemplBase.getUserTag2());
        }
        if (pSDynaDETemplBase.isUserTag3Dirty() && (bl || pSDynaDETemplBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDynaDETemplBase.getUserTag3());
        }
        if (pSDynaDETemplBase.isUserTag4Dirty() && (bl || pSDynaDETemplBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDynaDETemplBase.getUserTag4());
        }
        if (pSDynaDETemplBase.isValidFlagDirty() && (bl || pSDynaDETemplBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDynaDETemplBase.getValidFlag());
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
        return PSDynaDETemplBase.remove(this, n);
    }

    private static boolean remove(PSDynaDETemplBase pSDynaDETemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDynaDETemplBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDynaDETemplBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDynaDETemplBase.resetMemo();
                return true;
            }
            case 3: {
                pSDynaDETemplBase.resetPSDynaDETemplId();
                return true;
            }
            case 4: {
                pSDynaDETemplBase.resetPSDynaDETemplName();
                return true;
            }
            case 5: {
                pSDynaDETemplBase.resetPSSystemId();
                return true;
            }
            case 6: {
                pSDynaDETemplBase.resetPSSystemName();
                return true;
            }
            case 7: {
                pSDynaDETemplBase.resetTemplPSDEId();
                return true;
            }
            case 8: {
                pSDynaDETemplBase.resetTemplPSDEName();
                return true;
            }
            case 9: {
                pSDynaDETemplBase.resetTypePSDEFId();
                return true;
            }
            case 10: {
                pSDynaDETemplBase.resetTypePSDEFName();
                return true;
            }
            case 11: {
                pSDynaDETemplBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSDynaDETemplBase.resetUpdateMan();
                return true;
            }
            case 13: {
                pSDynaDETemplBase.resetUserCat();
                return true;
            }
            case 14: {
                pSDynaDETemplBase.resetUserTag();
                return true;
            }
            case 15: {
                pSDynaDETemplBase.resetUserTag2();
                return true;
            }
            case 16: {
                pSDynaDETemplBase.resetUserTag3();
                return true;
            }
            case 17: {
                pSDynaDETemplBase.resetUserTag4();
                return true;
            }
            case 18: {
                pSDynaDETemplBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getTemplPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplPSDE();
        }
        if (this.getTemplPSDEId() == null) {
            return null;
        }
        Integer n = this.objTemplPSDELock;
        synchronized (n) {
            if (this.templpsde != null && DataTypeHelper.compare((int)25, (Object)this.getTemplPSDEId(), (Object)this.templpsde.getPSDataEntityId()) != 0L) {
                this.templpsde = null;
            }
            if (this.templpsde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getTemplPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.templpsde = pSDataEntity;
            }
            return this.templpsde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getTypePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypePSDEF();
        }
        if (this.getTypePSDEFId() == null) {
            return null;
        }
        Integer n = this.objTypePSDEFLock;
        synchronized (n) {
            if (this.typepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getTypePSDEFId(), (Object)this.typepsdef.getPSDEFieldId()) != 0L) {
                this.typepsdef = null;
            }
            if (this.typepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getTypePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.typepsdef = pSDEField;
            }
            return this.typepsdef;
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
    public ArrayList<PSDynaDEFormTempl> getPSDynaDEFormTempls() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDEFormTempls();
        }
        if (this.getPSDynaDETemplId() == null) {
            return null;
        }
        PSDynaDEFormTemplService pSDynaDEFormTemplService = (PSDynaDEFormTemplService)ServiceGlobal.getService(PSDynaDEFormTemplService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDynaDEFormTemplsLock;
        synchronized (n) {
            if (this.psdynadeformtempls == null) {
                this.psdynadeformtempls = pSDynaDEFormTemplService.selectByPSDynaDETempl(this);
            }
            return this.psdynadeformtempls;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDynaDEViewTempl> getPSDynaDEViewTempls() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDEViewTempls();
        }
        if (this.getPSDynaDETemplId() == null) {
            return null;
        }
        PSDynaDEViewTemplService pSDynaDEViewTemplService = (PSDynaDEViewTemplService)ServiceGlobal.getService(PSDynaDEViewTemplService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDynaDEViewTemplsLock;
        synchronized (n) {
            if (this.psdynadeviewtempls == null) {
                this.psdynadeviewtempls = pSDynaDEViewTemplService.selectByPSDynaDETempl(this);
            }
            return this.psdynadeviewtempls;
        }
    }

    private PSDynaDETemplBase getProxyEntity() {
        return this.proxyPSDynaDETemplBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDynaDETemplBase = null;
        if (iDataObject != null && iDataObject instanceof PSDynaDETemplBase) {
            this.proxyPSDynaDETemplBase = (PSDynaDETemplBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaDETemplService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDYNADETEMPLID, 3);
        fieldIndexMap.put(FIELD_PSDYNADETEMPLNAME, 4);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 5);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 6);
        fieldIndexMap.put(FIELD_TEMPLPSDEID, 7);
        fieldIndexMap.put(FIELD_TEMPLPSDENAME, 8);
        fieldIndexMap.put(FIELD_TYPEPSDEFID, 9);
        fieldIndexMap.put(FIELD_TYPEPSDEFNAME, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
        fieldIndexMap.put(FIELD_USERCAT, 13);
        fieldIndexMap.put(FIELD_USERTAG, 14);
        fieldIndexMap.put(FIELD_USERTAG2, 15);
        fieldIndexMap.put(FIELD_USERTAG3, 16);
        fieldIndexMap.put(FIELD_USERTAG4, 17);
        fieldIndexMap.put(FIELD_VALIDFLAG, 18);
    }
}

