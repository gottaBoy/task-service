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
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevPrdBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevPrdBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ISSUESNPREFIX = "ISSUESNPREFIX";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PRDSN = "PRDSN";
    public static final String FIELD_PRDTAG = "PRDTAG";
    public static final String FIELD_PRDTAG2 = "PRDTAG2";
    public static final String FIELD_PSDEVPRDID = "PSDEVPRDID";
    public static final String FIELD_PSDEVPRDNAME = "PSDEVPRDNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_SPECSNPREFIX = "SPECSNPREFIX";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_ISSUESNPREFIX = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PRDSN = 5;
    private static final int INDEX_PRDTAG = 6;
    private static final int INDEX_PRDTAG2 = 7;
    private static final int INDEX_PSDEVPRDID = 8;
    private static final int INDEX_PSDEVPRDNAME = 9;
    private static final int INDEX_PSDEVSLNID = 10;
    private static final int INDEX_PSDEVSLNNAME = 11;
    private static final int INDEX_SPECSNPREFIX = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final int INDEX_USERCAT = 15;
    private static final int INDEX_USERTAG = 16;
    private static final int INDEX_USERTAG2 = 17;
    private static final int INDEX_USERTAG3 = 18;
    private static final int INDEX_USERTAG4 = 19;
    private static final int INDEX_VALIDFLAG = 20;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevPrdBase proxyPSDevPrdBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean issuesnprefixDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean prdsnDirtyFlag = false;
    private boolean prdtagDirtyFlag = false;
    private boolean prdtag2DirtyFlag = false;
    private boolean psdevprdidDirtyFlag = false;
    private boolean psdevprdnameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean specsnprefixDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="issuesnprefix")
    private String issuesnprefix;
    @Column(name="memo")
    private String memo;
    @Column(name="prdsn")
    private String prdsn;
    @Column(name="prdtag")
    private String prdtag;
    @Column(name="prdtag2")
    private String prdtag2;
    @Column(name="psdevprdid")
    private String psdevprdid;
    @Column(name="psdevprdname")
    private String psdevprdname;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="specsnprefix")
    private String specsnprefix;
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
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;

    public void setCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename = string;
        this.codenameDirtyFlag = true;
    }

    public String getCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName();
        }
        return this.codename;
    }

    public boolean isCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeNameDirty();
        }
        return this.codenameDirtyFlag;
    }

    public void resetCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName();
            return;
        }
        this.codenameDirtyFlag = false;
        this.codename = null;
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

    public void setIssueSNPrefix(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIssueSNPrefix(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.issuesnprefix = string;
        this.issuesnprefixDirtyFlag = true;
    }

    public String getIssueSNPrefix() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIssueSNPrefix();
        }
        return this.issuesnprefix;
    }

    public boolean isIssueSNPrefixDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIssueSNPrefixDirty();
        }
        return this.issuesnprefixDirtyFlag;
    }

    public void resetIssueSNPrefix() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIssueSNPrefix();
            return;
        }
        this.issuesnprefixDirtyFlag = false;
        this.issuesnprefix = null;
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

    public void setPrdSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrdSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.prdsn = string;
        this.prdsnDirtyFlag = true;
    }

    public String getPrdSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrdSN();
        }
        return this.prdsn;
    }

    public boolean isPrdSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrdSNDirty();
        }
        return this.prdsnDirtyFlag;
    }

    public void resetPrdSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrdSN();
            return;
        }
        this.prdsnDirtyFlag = false;
        this.prdsn = null;
    }

    public void setPrdTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrdTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.prdtag = string;
        this.prdtagDirtyFlag = true;
    }

    public String getPrdTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrdTag();
        }
        return this.prdtag;
    }

    public boolean isPrdTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrdTagDirty();
        }
        return this.prdtagDirtyFlag;
    }

    public void resetPrdTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrdTag();
            return;
        }
        this.prdtagDirtyFlag = false;
        this.prdtag = null;
    }

    public void setPrdTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrdTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.prdtag2 = string;
        this.prdtag2DirtyFlag = true;
    }

    public String getPrdTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrdTag2();
        }
        return this.prdtag2;
    }

    public boolean isPrdTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrdTag2Dirty();
        }
        return this.prdtag2DirtyFlag;
    }

    public void resetPrdTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrdTag2();
            return;
        }
        this.prdtag2DirtyFlag = false;
        this.prdtag2 = null;
    }

    public void setPSDevPrdId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdid = string;
        this.psdevprdidDirtyFlag = true;
    }

    public String getPSDevPrdId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdId();
        }
        return this.psdevprdid;
    }

    public boolean isPSDevPrdIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdIdDirty();
        }
        return this.psdevprdidDirtyFlag;
    }

    public void resetPSDevPrdId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdId();
            return;
        }
        this.psdevprdidDirtyFlag = false;
        this.psdevprdid = null;
    }

    public void setPSDevPrdName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdname = string;
        this.psdevprdnameDirtyFlag = true;
    }

    public String getPSDevPrdName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdName();
        }
        return this.psdevprdname;
    }

    public boolean isPSDevPrdNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdNameDirty();
        }
        return this.psdevprdnameDirtyFlag;
    }

    public void resetPSDevPrdName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdName();
            return;
        }
        this.psdevprdnameDirtyFlag = false;
        this.psdevprdname = null;
    }

    public void setPSDevSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnid = string;
        this.psdevslnidDirtyFlag = true;
    }

    public String getPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnId();
        }
        return this.psdevslnid;
    }

    public boolean isPSDevSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnIdDirty();
        }
        return this.psdevslnidDirtyFlag;
    }

    public void resetPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnId();
            return;
        }
        this.psdevslnidDirtyFlag = false;
        this.psdevslnid = null;
    }

    public void setPSDevSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnname = string;
        this.psdevslnnameDirtyFlag = true;
    }

    public String getPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnName();
        }
        return this.psdevslnname;
    }

    public boolean isPSDevSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnNameDirty();
        }
        return this.psdevslnnameDirtyFlag;
    }

    public void resetPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnName();
            return;
        }
        this.psdevslnnameDirtyFlag = false;
        this.psdevslnname = null;
    }

    public void setSpecSNPrefix(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSpecSNPrefix(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.specsnprefix = string;
        this.specsnprefixDirtyFlag = true;
    }

    public String getSpecSNPrefix() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSpecSNPrefix();
        }
        return this.specsnprefix;
    }

    public boolean isSpecSNPrefixDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSpecSNPrefixDirty();
        }
        return this.specsnprefixDirtyFlag;
    }

    public void resetSpecSNPrefix() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSpecSNPrefix();
            return;
        }
        this.specsnprefixDirtyFlag = false;
        this.specsnprefix = null;
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
        PSDevPrdBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevPrdBase pSDevPrdBase) {
        pSDevPrdBase.resetCodeName();
        pSDevPrdBase.resetCreateDate();
        pSDevPrdBase.resetCreateMan();
        pSDevPrdBase.resetIssueSNPrefix();
        pSDevPrdBase.resetMemo();
        pSDevPrdBase.resetPrdSN();
        pSDevPrdBase.resetPrdTag();
        pSDevPrdBase.resetPrdTag2();
        pSDevPrdBase.resetPSDevPrdId();
        pSDevPrdBase.resetPSDevPrdName();
        pSDevPrdBase.resetPSDevSlnId();
        pSDevPrdBase.resetPSDevSlnName();
        pSDevPrdBase.resetSpecSNPrefix();
        pSDevPrdBase.resetUpdateDate();
        pSDevPrdBase.resetUpdateMan();
        pSDevPrdBase.resetUserCat();
        pSDevPrdBase.resetUserTag();
        pSDevPrdBase.resetUserTag2();
        pSDevPrdBase.resetUserTag3();
        pSDevPrdBase.resetUserTag4();
        pSDevPrdBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isIssueSNPrefixDirty()) {
            hashMap.put(FIELD_ISSUESNPREFIX, this.getIssueSNPrefix());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPrdSNDirty()) {
            hashMap.put(FIELD_PRDSN, this.getPrdSN());
        }
        if (!bl || this.isPrdTagDirty()) {
            hashMap.put(FIELD_PRDTAG, this.getPrdTag());
        }
        if (!bl || this.isPrdTag2Dirty()) {
            hashMap.put(FIELD_PRDTAG2, this.getPrdTag2());
        }
        if (!bl || this.isPSDevPrdIdDirty()) {
            hashMap.put(FIELD_PSDEVPRDID, this.getPSDevPrdId());
        }
        if (!bl || this.isPSDevPrdNameDirty()) {
            hashMap.put(FIELD_PSDEVPRDNAME, this.getPSDevPrdName());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNNAME, this.getPSDevSlnName());
        }
        if (!bl || this.isSpecSNPrefixDirty()) {
            hashMap.put(FIELD_SPECSNPREFIX, this.getSpecSNPrefix());
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
        return PSDevPrdBase.get(this, n);
    }

    private static Object get(PSDevPrdBase pSDevPrdBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevPrdBase.getCodeName();
            }
            case 1: {
                return pSDevPrdBase.getCreateDate();
            }
            case 2: {
                return pSDevPrdBase.getCreateMan();
            }
            case 3: {
                return pSDevPrdBase.getIssueSNPrefix();
            }
            case 4: {
                return pSDevPrdBase.getMemo();
            }
            case 5: {
                return pSDevPrdBase.getPrdSN();
            }
            case 6: {
                return pSDevPrdBase.getPrdTag();
            }
            case 7: {
                return pSDevPrdBase.getPrdTag2();
            }
            case 8: {
                return pSDevPrdBase.getPSDevPrdId();
            }
            case 9: {
                return pSDevPrdBase.getPSDevPrdName();
            }
            case 10: {
                return pSDevPrdBase.getPSDevSlnId();
            }
            case 11: {
                return pSDevPrdBase.getPSDevSlnName();
            }
            case 12: {
                return pSDevPrdBase.getSpecSNPrefix();
            }
            case 13: {
                return pSDevPrdBase.getUpdateDate();
            }
            case 14: {
                return pSDevPrdBase.getUpdateMan();
            }
            case 15: {
                return pSDevPrdBase.getUserCat();
            }
            case 16: {
                return pSDevPrdBase.getUserTag();
            }
            case 17: {
                return pSDevPrdBase.getUserTag2();
            }
            case 18: {
                return pSDevPrdBase.getUserTag3();
            }
            case 19: {
                return pSDevPrdBase.getUserTag4();
            }
            case 20: {
                return pSDevPrdBase.getValidFlag();
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
        PSDevPrdBase.set(this, n, object);
    }

    private static void set(PSDevPrdBase pSDevPrdBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevPrdBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDevPrdBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDevPrdBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevPrdBase.setIssueSNPrefix(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevPrdBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevPrdBase.setPrdSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevPrdBase.setPrdTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevPrdBase.setPrdTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevPrdBase.setPSDevPrdId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevPrdBase.setPSDevPrdName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevPrdBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevPrdBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevPrdBase.setSpecSNPrefix(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevPrdBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSDevPrdBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevPrdBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevPrdBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDevPrdBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDevPrdBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDevPrdBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDevPrdBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDevPrdBase.isNull(this, n);
    }

    private static boolean isNull(PSDevPrdBase pSDevPrdBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevPrdBase.getCodeName() == null;
            }
            case 1: {
                return pSDevPrdBase.getCreateDate() == null;
            }
            case 2: {
                return pSDevPrdBase.getCreateMan() == null;
            }
            case 3: {
                return pSDevPrdBase.getIssueSNPrefix() == null;
            }
            case 4: {
                return pSDevPrdBase.getMemo() == null;
            }
            case 5: {
                return pSDevPrdBase.getPrdSN() == null;
            }
            case 6: {
                return pSDevPrdBase.getPrdTag() == null;
            }
            case 7: {
                return pSDevPrdBase.getPrdTag2() == null;
            }
            case 8: {
                return pSDevPrdBase.getPSDevPrdId() == null;
            }
            case 9: {
                return pSDevPrdBase.getPSDevPrdName() == null;
            }
            case 10: {
                return pSDevPrdBase.getPSDevSlnId() == null;
            }
            case 11: {
                return pSDevPrdBase.getPSDevSlnName() == null;
            }
            case 12: {
                return pSDevPrdBase.getSpecSNPrefix() == null;
            }
            case 13: {
                return pSDevPrdBase.getUpdateDate() == null;
            }
            case 14: {
                return pSDevPrdBase.getUpdateMan() == null;
            }
            case 15: {
                return pSDevPrdBase.getUserCat() == null;
            }
            case 16: {
                return pSDevPrdBase.getUserTag() == null;
            }
            case 17: {
                return pSDevPrdBase.getUserTag2() == null;
            }
            case 18: {
                return pSDevPrdBase.getUserTag3() == null;
            }
            case 19: {
                return pSDevPrdBase.getUserTag4() == null;
            }
            case 20: {
                return pSDevPrdBase.getValidFlag() == null;
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
        return PSDevPrdBase.contains(this, n);
    }

    private static boolean contains(PSDevPrdBase pSDevPrdBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevPrdBase.isCodeNameDirty();
            }
            case 1: {
                return pSDevPrdBase.isCreateDateDirty();
            }
            case 2: {
                return pSDevPrdBase.isCreateManDirty();
            }
            case 3: {
                return pSDevPrdBase.isIssueSNPrefixDirty();
            }
            case 4: {
                return pSDevPrdBase.isMemoDirty();
            }
            case 5: {
                return pSDevPrdBase.isPrdSNDirty();
            }
            case 6: {
                return pSDevPrdBase.isPrdTagDirty();
            }
            case 7: {
                return pSDevPrdBase.isPrdTag2Dirty();
            }
            case 8: {
                return pSDevPrdBase.isPSDevPrdIdDirty();
            }
            case 9: {
                return pSDevPrdBase.isPSDevPrdNameDirty();
            }
            case 10: {
                return pSDevPrdBase.isPSDevSlnIdDirty();
            }
            case 11: {
                return pSDevPrdBase.isPSDevSlnNameDirty();
            }
            case 12: {
                return pSDevPrdBase.isSpecSNPrefixDirty();
            }
            case 13: {
                return pSDevPrdBase.isUpdateDateDirty();
            }
            case 14: {
                return pSDevPrdBase.isUpdateManDirty();
            }
            case 15: {
                return pSDevPrdBase.isUserCatDirty();
            }
            case 16: {
                return pSDevPrdBase.isUserTagDirty();
            }
            case 17: {
                return pSDevPrdBase.isUserTag2Dirty();
            }
            case 18: {
                return pSDevPrdBase.isUserTag3Dirty();
            }
            case 19: {
                return pSDevPrdBase.isUserTag4Dirty();
            }
            case 20: {
                return pSDevPrdBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevPrdBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevPrdBase pSDevPrdBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevPrdBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDevPrdBase.getJSONValue((Object)pSDevPrdBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDevPrdBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevPrdBase.getJSONValue((Object)pSDevPrdBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevPrdBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevPrdBase.getJSONValue((Object)pSDevPrdBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevPrdBase.getIssueSNPrefix() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"issuesnprefix", (Object)PSDevPrdBase.getJSONValue((Object)pSDevPrdBase.getIssueSNPrefix()), (boolean)false);
        }
        if (bl || pSDevPrdBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevPrdBase.getJSONValue((Object)pSDevPrdBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevPrdBase.getPrdSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"prdsn", (Object)PSDevPrdBase.getJSONValue((Object)pSDevPrdBase.getPrdSN()), (boolean)false);
        }
        if (bl || pSDevPrdBase.getPrdTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"prdtag", (Object)PSDevPrdBase.getJSONValue((Object)pSDevPrdBase.getPrdTag()), (boolean)false);
        }
        if (bl || pSDevPrdBase.getPrdTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"prdtag2", (Object)PSDevPrdBase.getJSONValue((Object)pSDevPrdBase.getPrdTag2()), (boolean)false);
        }
        if (bl || pSDevPrdBase.getPSDevPrdId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdid", (Object)PSDevPrdBase.getJSONValue((Object)pSDevPrdBase.getPSDevPrdId()), (boolean)false);
        }
        if (bl || pSDevPrdBase.getPSDevPrdName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdname", (Object)PSDevPrdBase.getJSONValue((Object)pSDevPrdBase.getPSDevPrdName()), (boolean)false);
        }
        if (bl || pSDevPrdBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDevPrdBase.getJSONValue((Object)pSDevPrdBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDevPrdBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDevPrdBase.getJSONValue((Object)pSDevPrdBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDevPrdBase.getSpecSNPrefix() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"specsnprefix", (Object)PSDevPrdBase.getJSONValue((Object)pSDevPrdBase.getSpecSNPrefix()), (boolean)false);
        }
        if (bl || pSDevPrdBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevPrdBase.getJSONValue((Object)pSDevPrdBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevPrdBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevPrdBase.getJSONValue((Object)pSDevPrdBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevPrdBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDevPrdBase.getJSONValue((Object)pSDevPrdBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDevPrdBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDevPrdBase.getJSONValue((Object)pSDevPrdBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDevPrdBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDevPrdBase.getJSONValue((Object)pSDevPrdBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDevPrdBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDevPrdBase.getJSONValue((Object)pSDevPrdBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDevPrdBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDevPrdBase.getJSONValue((Object)pSDevPrdBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDevPrdBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDevPrdBase.getJSONValue((Object)pSDevPrdBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevPrdBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevPrdBase pSDevPrdBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevPrdBase.getCodeName() != null) {
            object = pSDevPrdBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdBase.getCreateDate() != null) {
            object = pSDevPrdBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevPrdBase.getCreateMan() != null) {
            object = pSDevPrdBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdBase.getIssueSNPrefix() != null) {
            object = pSDevPrdBase.getIssueSNPrefix();
            xmlNode.setAttribute(FIELD_ISSUESNPREFIX, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdBase.getMemo() != null) {
            object = pSDevPrdBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdBase.getPrdSN() != null) {
            object = pSDevPrdBase.getPrdSN();
            xmlNode.setAttribute(FIELD_PRDSN, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdBase.getPrdTag() != null) {
            object = pSDevPrdBase.getPrdTag();
            xmlNode.setAttribute(FIELD_PRDTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdBase.getPrdTag2() != null) {
            object = pSDevPrdBase.getPrdTag2();
            xmlNode.setAttribute(FIELD_PRDTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdBase.getPSDevPrdId() != null) {
            object = pSDevPrdBase.getPSDevPrdId();
            xmlNode.setAttribute(FIELD_PSDEVPRDID, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdBase.getPSDevPrdName() != null) {
            object = pSDevPrdBase.getPSDevPrdName();
            xmlNode.setAttribute(FIELD_PSDEVPRDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdBase.getPSDevSlnId() != null) {
            object = pSDevPrdBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdBase.getPSDevSlnName() != null) {
            object = pSDevPrdBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdBase.getSpecSNPrefix() != null) {
            object = pSDevPrdBase.getSpecSNPrefix();
            xmlNode.setAttribute(FIELD_SPECSNPREFIX, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdBase.getUpdateDate() != null) {
            object = pSDevPrdBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevPrdBase.getUpdateMan() != null) {
            object = pSDevPrdBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdBase.getUserCat() != null) {
            object = pSDevPrdBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdBase.getUserTag() != null) {
            object = pSDevPrdBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdBase.getUserTag2() != null) {
            object = pSDevPrdBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdBase.getUserTag3() != null) {
            object = pSDevPrdBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdBase.getUserTag4() != null) {
            object = pSDevPrdBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdBase.getValidFlag() != null) {
            object = pSDevPrdBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevPrdBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevPrdBase pSDevPrdBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevPrdBase.isCodeNameDirty() && (bl || pSDevPrdBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDevPrdBase.getCodeName());
        }
        if (pSDevPrdBase.isCreateDateDirty() && (bl || pSDevPrdBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevPrdBase.getCreateDate());
        }
        if (pSDevPrdBase.isCreateManDirty() && (bl || pSDevPrdBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevPrdBase.getCreateMan());
        }
        if (pSDevPrdBase.isIssueSNPrefixDirty() && (bl || pSDevPrdBase.getIssueSNPrefix() != null)) {
            iDataObject.set(FIELD_ISSUESNPREFIX, (Object)pSDevPrdBase.getIssueSNPrefix());
        }
        if (pSDevPrdBase.isMemoDirty() && (bl || pSDevPrdBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevPrdBase.getMemo());
        }
        if (pSDevPrdBase.isPrdSNDirty() && (bl || pSDevPrdBase.getPrdSN() != null)) {
            iDataObject.set(FIELD_PRDSN, (Object)pSDevPrdBase.getPrdSN());
        }
        if (pSDevPrdBase.isPrdTagDirty() && (bl || pSDevPrdBase.getPrdTag() != null)) {
            iDataObject.set(FIELD_PRDTAG, (Object)pSDevPrdBase.getPrdTag());
        }
        if (pSDevPrdBase.isPrdTag2Dirty() && (bl || pSDevPrdBase.getPrdTag2() != null)) {
            iDataObject.set(FIELD_PRDTAG2, (Object)pSDevPrdBase.getPrdTag2());
        }
        if (pSDevPrdBase.isPSDevPrdIdDirty() && (bl || pSDevPrdBase.getPSDevPrdId() != null)) {
            iDataObject.set(FIELD_PSDEVPRDID, (Object)pSDevPrdBase.getPSDevPrdId());
        }
        if (pSDevPrdBase.isPSDevPrdNameDirty() && (bl || pSDevPrdBase.getPSDevPrdName() != null)) {
            iDataObject.set(FIELD_PSDEVPRDNAME, (Object)pSDevPrdBase.getPSDevPrdName());
        }
        if (pSDevPrdBase.isPSDevSlnIdDirty() && (bl || pSDevPrdBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDevPrdBase.getPSDevSlnId());
        }
        if (pSDevPrdBase.isPSDevSlnNameDirty() && (bl || pSDevPrdBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDevPrdBase.getPSDevSlnName());
        }
        if (pSDevPrdBase.isSpecSNPrefixDirty() && (bl || pSDevPrdBase.getSpecSNPrefix() != null)) {
            iDataObject.set(FIELD_SPECSNPREFIX, (Object)pSDevPrdBase.getSpecSNPrefix());
        }
        if (pSDevPrdBase.isUpdateDateDirty() && (bl || pSDevPrdBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevPrdBase.getUpdateDate());
        }
        if (pSDevPrdBase.isUpdateManDirty() && (bl || pSDevPrdBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevPrdBase.getUpdateMan());
        }
        if (pSDevPrdBase.isUserCatDirty() && (bl || pSDevPrdBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDevPrdBase.getUserCat());
        }
        if (pSDevPrdBase.isUserTagDirty() && (bl || pSDevPrdBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDevPrdBase.getUserTag());
        }
        if (pSDevPrdBase.isUserTag2Dirty() && (bl || pSDevPrdBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDevPrdBase.getUserTag2());
        }
        if (pSDevPrdBase.isUserTag3Dirty() && (bl || pSDevPrdBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDevPrdBase.getUserTag3());
        }
        if (pSDevPrdBase.isUserTag4Dirty() && (bl || pSDevPrdBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDevPrdBase.getUserTag4());
        }
        if (pSDevPrdBase.isValidFlagDirty() && (bl || pSDevPrdBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDevPrdBase.getValidFlag());
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
        return PSDevPrdBase.remove(this, n);
    }

    private static boolean remove(PSDevPrdBase pSDevPrdBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevPrdBase.resetCodeName();
                return true;
            }
            case 1: {
                pSDevPrdBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDevPrdBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDevPrdBase.resetIssueSNPrefix();
                return true;
            }
            case 4: {
                pSDevPrdBase.resetMemo();
                return true;
            }
            case 5: {
                pSDevPrdBase.resetPrdSN();
                return true;
            }
            case 6: {
                pSDevPrdBase.resetPrdTag();
                return true;
            }
            case 7: {
                pSDevPrdBase.resetPrdTag2();
                return true;
            }
            case 8: {
                pSDevPrdBase.resetPSDevPrdId();
                return true;
            }
            case 9: {
                pSDevPrdBase.resetPSDevPrdName();
                return true;
            }
            case 10: {
                pSDevPrdBase.resetPSDevSlnId();
                return true;
            }
            case 11: {
                pSDevPrdBase.resetPSDevSlnName();
                return true;
            }
            case 12: {
                pSDevPrdBase.resetSpecSNPrefix();
                return true;
            }
            case 13: {
                pSDevPrdBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSDevPrdBase.resetUpdateMan();
                return true;
            }
            case 15: {
                pSDevPrdBase.resetUserCat();
                return true;
            }
            case 16: {
                pSDevPrdBase.resetUserTag();
                return true;
            }
            case 17: {
                pSDevPrdBase.resetUserTag2();
                return true;
            }
            case 18: {
                pSDevPrdBase.resetUserTag3();
                return true;
            }
            case 19: {
                pSDevPrdBase.resetUserTag4();
                return true;
            }
            case 20: {
                pSDevPrdBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSln getPSDevSln() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSln();
        }
        if (this.getPSDevSlnId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnLock;
        synchronized (n) {
            if (this.psdevsln != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnId(), (Object)this.psdevsln.getPSDevSlnId()) != 0L) {
                this.psdevsln = null;
            }
            if (this.psdevsln == null) {
                PSDevSln pSDevSln = new PSDevSln();
                pSDevSln.setPSDevSlnId(this.getPSDevSlnId());
                PSDevSlnService pSDevSlnService = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnService.autoGet((IEntity)pSDevSln);
                this.psdevsln = pSDevSln;
            }
            return this.psdevsln;
        }
    }

    private PSDevPrdBase getProxyEntity() {
        return this.proxyPSDevPrdBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevPrdBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevPrdBase) {
            this.proxyPSDevPrdBase = (PSDevPrdBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_ISSUESNPREFIX, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PRDSN, 5);
        fieldIndexMap.put(FIELD_PRDTAG, 6);
        fieldIndexMap.put(FIELD_PRDTAG2, 7);
        fieldIndexMap.put(FIELD_PSDEVPRDID, 8);
        fieldIndexMap.put(FIELD_PSDEVPRDNAME, 9);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 10);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 11);
        fieldIndexMap.put(FIELD_SPECSNPREFIX, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
        fieldIndexMap.put(FIELD_USERCAT, 15);
        fieldIndexMap.put(FIELD_USERTAG, 16);
        fieldIndexMap.put(FIELD_USERTAG2, 17);
        fieldIndexMap.put(FIELD_USERTAG3, 18);
        fieldIndexMap.put(FIELD_USERTAG4, 19);
        fieldIndexMap.put(FIELD_VALIDFLAG, 20);
    }
}

