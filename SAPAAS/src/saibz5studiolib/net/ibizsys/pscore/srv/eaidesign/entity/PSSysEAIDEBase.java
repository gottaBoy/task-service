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
package net.ibizsys.pscore.srv.eaidesign.entity;

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
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIDEField;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIDER;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIElement;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIScheme;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDEFieldService;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDERService;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDEService;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIElementService;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAISchemeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysEAIDEBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysEAIDEBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_EAIDETAG = "EAIDETAG";
    public static final String FIELD_EAIDETAG2 = "EAIDETAG2";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSSYSEAIDEID = "PSSYSEAIDEID";
    public static final String FIELD_PSSYSEAIDENAME = "PSSYSEAIDENAME";
    public static final String FIELD_PSSYSEAIELEMENTID = "PSSYSEAIELEMENTID";
    public static final String FIELD_PSSYSEAIELEMENTNAME = "PSSYSEAIELEMENTNAME";
    public static final String FIELD_PSSYSEAISCHEMEID = "PSSYSEAISCHEMEID";
    public static final String FIELD_PSSYSEAISCHEMENAME = "PSSYSEAISCHEMENAME";
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
    private static final int INDEX_EAIDETAG = 3;
    private static final int INDEX_EAIDETAG2 = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSDEID = 6;
    private static final int INDEX_PSDENAME = 7;
    private static final int INDEX_PSSYSEAIDEID = 8;
    private static final int INDEX_PSSYSEAIDENAME = 9;
    private static final int INDEX_PSSYSEAIELEMENTID = 10;
    private static final int INDEX_PSSYSEAIELEMENTNAME = 11;
    private static final int INDEX_PSSYSEAISCHEMEID = 12;
    private static final int INDEX_PSSYSEAISCHEMENAME = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final int INDEX_USERCAT = 16;
    private static final int INDEX_USERTAG = 17;
    private static final int INDEX_USERTAG2 = 18;
    private static final int INDEX_USERTAG3 = 19;
    private static final int INDEX_USERTAG4 = 20;
    private static final int INDEX_VALIDFLAG = 21;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysEAIDEBase proxyPSSysEAIDEBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean eaidetagDirtyFlag = false;
    private boolean eaidetag2DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean pssyseaideidDirtyFlag = false;
    private boolean pssyseaidenameDirtyFlag = false;
    private boolean pssyseaielementidDirtyFlag = false;
    private boolean pssyseaielementnameDirtyFlag = false;
    private boolean pssyseaischemeidDirtyFlag = false;
    private boolean pssyseaischemenameDirtyFlag = false;
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
    @Column(name="eaidetag")
    private String eaidetag;
    @Column(name="eaidetag2")
    private String eaidetag2;
    @Column(name="memo")
    private String memo;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="pssyseaideid")
    private String pssyseaideid;
    @Column(name="pssyseaidename")
    private String pssyseaidename;
    @Column(name="pssyseaielementid")
    private String pssyseaielementid;
    @Column(name="pssyseaielementname")
    private String pssyseaielementname;
    @Column(name="pssyseaischemeid")
    private String pssyseaischemeid;
    @Column(name="pssyseaischemename")
    private String pssyseaischemename;
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
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSSysEAIElementLock = new Integer(1);
    private PSSysEAIElement pssyseaielement = null;
    private Integer objPSSysEAISchemeLock = new Integer(1);
    private PSSysEAIScheme pssyseaischeme = null;
    private Integer objPSSysEAIDEFieldsLock = new Integer(1);
    private ArrayList<PSSysEAIDEField> pssyseaidefields = null;
    private Integer objPSSysEAIDERsLock = new Integer(1);
    private ArrayList<PSSysEAIDER> pssyseaiders = null;

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

    public void setEAIDETag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEAIDETag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.eaidetag = string;
        this.eaidetagDirtyFlag = true;
    }

    public String getEAIDETag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEAIDETag();
        }
        return this.eaidetag;
    }

    public boolean isEAIDETagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEAIDETagDirty();
        }
        return this.eaidetagDirtyFlag;
    }

    public void resetEAIDETag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEAIDETag();
            return;
        }
        this.eaidetagDirtyFlag = false;
        this.eaidetag = null;
    }

    public void setEAIDETag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEAIDETag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.eaidetag2 = string;
        this.eaidetag2DirtyFlag = true;
    }

    public String getEAIDETag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEAIDETag2();
        }
        return this.eaidetag2;
    }

    public boolean isEAIDETag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEAIDETag2Dirty();
        }
        return this.eaidetag2DirtyFlag;
    }

    public void resetEAIDETag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEAIDETag2();
            return;
        }
        this.eaidetag2DirtyFlag = false;
        this.eaidetag2 = null;
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

    public void setPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeid = string;
        this.psdeidDirtyFlag = true;
    }

    public String getPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEId();
        }
        return this.psdeid;
    }

    public boolean isPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEIdDirty();
        }
        return this.psdeidDirtyFlag;
    }

    public void resetPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEId();
            return;
        }
        this.psdeidDirtyFlag = false;
        this.psdeid = null;
    }

    public void setPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdename = string;
        this.psdenameDirtyFlag = true;
    }

    public String getPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEName();
        }
        return this.psdename;
    }

    public boolean isPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDENameDirty();
        }
        return this.psdenameDirtyFlag;
    }

    public void resetPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEName();
            return;
        }
        this.psdenameDirtyFlag = false;
        this.psdename = null;
    }

    public void setPSSysEAIDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEAIDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseaideid = string;
        this.pssyseaideidDirtyFlag = true;
    }

    public String getPSSysEAIDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIDEId();
        }
        return this.pssyseaideid;
    }

    public boolean isPSSysEAIDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEAIDEIdDirty();
        }
        return this.pssyseaideidDirtyFlag;
    }

    public void resetPSSysEAIDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEAIDEId();
            return;
        }
        this.pssyseaideidDirtyFlag = false;
        this.pssyseaideid = null;
    }

    public void setPSSysEAIDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEAIDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseaidename = string;
        this.pssyseaidenameDirtyFlag = true;
    }

    public String getPSSysEAIDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIDEName();
        }
        return this.pssyseaidename;
    }

    public boolean isPSSysEAIDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEAIDENameDirty();
        }
        return this.pssyseaidenameDirtyFlag;
    }

    public void resetPSSysEAIDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEAIDEName();
            return;
        }
        this.pssyseaidenameDirtyFlag = false;
        this.pssyseaidename = null;
    }

    public void setPSSysEAIElementId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEAIElementId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseaielementid = string;
        this.pssyseaielementidDirtyFlag = true;
    }

    public String getPSSysEAIElementId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIElementId();
        }
        return this.pssyseaielementid;
    }

    public boolean isPSSysEAIElementIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEAIElementIdDirty();
        }
        return this.pssyseaielementidDirtyFlag;
    }

    public void resetPSSysEAIElementId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEAIElementId();
            return;
        }
        this.pssyseaielementidDirtyFlag = false;
        this.pssyseaielementid = null;
    }

    public void setPSSysEAIElementName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEAIElementName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseaielementname = string;
        this.pssyseaielementnameDirtyFlag = true;
    }

    public String getPSSysEAIElementName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIElementName();
        }
        return this.pssyseaielementname;
    }

    public boolean isPSSysEAIElementNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEAIElementNameDirty();
        }
        return this.pssyseaielementnameDirtyFlag;
    }

    public void resetPSSysEAIElementName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEAIElementName();
            return;
        }
        this.pssyseaielementnameDirtyFlag = false;
        this.pssyseaielementname = null;
    }

    public void setPSSysEAISchemeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEAISchemeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseaischemeid = string;
        this.pssyseaischemeidDirtyFlag = true;
    }

    public String getPSSysEAISchemeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAISchemeId();
        }
        return this.pssyseaischemeid;
    }

    public boolean isPSSysEAISchemeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEAISchemeIdDirty();
        }
        return this.pssyseaischemeidDirtyFlag;
    }

    public void resetPSSysEAISchemeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEAISchemeId();
            return;
        }
        this.pssyseaischemeidDirtyFlag = false;
        this.pssyseaischemeid = null;
    }

    public void setPSSysEAISchemeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEAISchemeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseaischemename = string;
        this.pssyseaischemenameDirtyFlag = true;
    }

    public String getPSSysEAISchemeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAISchemeName();
        }
        return this.pssyseaischemename;
    }

    public boolean isPSSysEAISchemeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEAISchemeNameDirty();
        }
        return this.pssyseaischemenameDirtyFlag;
    }

    public void resetPSSysEAISchemeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEAISchemeName();
            return;
        }
        this.pssyseaischemenameDirtyFlag = false;
        this.pssyseaischemename = null;
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
        PSSysEAIDEBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysEAIDEBase pSSysEAIDEBase) {
        pSSysEAIDEBase.resetCodeName();
        pSSysEAIDEBase.resetCreateDate();
        pSSysEAIDEBase.resetCreateMan();
        pSSysEAIDEBase.resetEAIDETag();
        pSSysEAIDEBase.resetEAIDETag2();
        pSSysEAIDEBase.resetMemo();
        pSSysEAIDEBase.resetPSDEId();
        pSSysEAIDEBase.resetPSDEName();
        pSSysEAIDEBase.resetPSSysEAIDEId();
        pSSysEAIDEBase.resetPSSysEAIDEName();
        pSSysEAIDEBase.resetPSSysEAIElementId();
        pSSysEAIDEBase.resetPSSysEAIElementName();
        pSSysEAIDEBase.resetPSSysEAISchemeId();
        pSSysEAIDEBase.resetPSSysEAISchemeName();
        pSSysEAIDEBase.resetUpdateDate();
        pSSysEAIDEBase.resetUpdateMan();
        pSSysEAIDEBase.resetUserCat();
        pSSysEAIDEBase.resetUserTag();
        pSSysEAIDEBase.resetUserTag2();
        pSSysEAIDEBase.resetUserTag3();
        pSSysEAIDEBase.resetUserTag4();
        pSSysEAIDEBase.resetValidFlag();
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
        if (!bl || this.isEAIDETagDirty()) {
            hashMap.put(FIELD_EAIDETAG, this.getEAIDETag());
        }
        if (!bl || this.isEAIDETag2Dirty()) {
            hashMap.put(FIELD_EAIDETAG2, this.getEAIDETag2());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSSysEAIDEIdDirty()) {
            hashMap.put(FIELD_PSSYSEAIDEID, this.getPSSysEAIDEId());
        }
        if (!bl || this.isPSSysEAIDENameDirty()) {
            hashMap.put(FIELD_PSSYSEAIDENAME, this.getPSSysEAIDEName());
        }
        if (!bl || this.isPSSysEAIElementIdDirty()) {
            hashMap.put(FIELD_PSSYSEAIELEMENTID, this.getPSSysEAIElementId());
        }
        if (!bl || this.isPSSysEAIElementNameDirty()) {
            hashMap.put(FIELD_PSSYSEAIELEMENTNAME, this.getPSSysEAIElementName());
        }
        if (!bl || this.isPSSysEAISchemeIdDirty()) {
            hashMap.put(FIELD_PSSYSEAISCHEMEID, this.getPSSysEAISchemeId());
        }
        if (!bl || this.isPSSysEAISchemeNameDirty()) {
            hashMap.put(FIELD_PSSYSEAISCHEMENAME, this.getPSSysEAISchemeName());
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
        return PSSysEAIDEBase.get(this, n);
    }

    private static Object get(PSSysEAIDEBase pSSysEAIDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysEAIDEBase.getCodeName();
            }
            case 1: {
                return pSSysEAIDEBase.getCreateDate();
            }
            case 2: {
                return pSSysEAIDEBase.getCreateMan();
            }
            case 3: {
                return pSSysEAIDEBase.getEAIDETag();
            }
            case 4: {
                return pSSysEAIDEBase.getEAIDETag2();
            }
            case 5: {
                return pSSysEAIDEBase.getMemo();
            }
            case 6: {
                return pSSysEAIDEBase.getPSDEId();
            }
            case 7: {
                return pSSysEAIDEBase.getPSDEName();
            }
            case 8: {
                return pSSysEAIDEBase.getPSSysEAIDEId();
            }
            case 9: {
                return pSSysEAIDEBase.getPSSysEAIDEName();
            }
            case 10: {
                return pSSysEAIDEBase.getPSSysEAIElementId();
            }
            case 11: {
                return pSSysEAIDEBase.getPSSysEAIElementName();
            }
            case 12: {
                return pSSysEAIDEBase.getPSSysEAISchemeId();
            }
            case 13: {
                return pSSysEAIDEBase.getPSSysEAISchemeName();
            }
            case 14: {
                return pSSysEAIDEBase.getUpdateDate();
            }
            case 15: {
                return pSSysEAIDEBase.getUpdateMan();
            }
            case 16: {
                return pSSysEAIDEBase.getUserCat();
            }
            case 17: {
                return pSSysEAIDEBase.getUserTag();
            }
            case 18: {
                return pSSysEAIDEBase.getUserTag2();
            }
            case 19: {
                return pSSysEAIDEBase.getUserTag3();
            }
            case 20: {
                return pSSysEAIDEBase.getUserTag4();
            }
            case 21: {
                return pSSysEAIDEBase.getValidFlag();
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
        PSSysEAIDEBase.set(this, n, object);
    }

    private static void set(PSSysEAIDEBase pSSysEAIDEBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysEAIDEBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysEAIDEBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysEAIDEBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysEAIDEBase.setEAIDETag(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysEAIDEBase.setEAIDETag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysEAIDEBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysEAIDEBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysEAIDEBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysEAIDEBase.setPSSysEAIDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysEAIDEBase.setPSSysEAIDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysEAIDEBase.setPSSysEAIElementId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysEAIDEBase.setPSSysEAIElementName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysEAIDEBase.setPSSysEAISchemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysEAIDEBase.setPSSysEAISchemeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysEAIDEBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSSysEAIDEBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysEAIDEBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysEAIDEBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysEAIDEBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysEAIDEBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysEAIDEBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysEAIDEBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysEAIDEBase.isNull(this, n);
    }

    private static boolean isNull(PSSysEAIDEBase pSSysEAIDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysEAIDEBase.getCodeName() == null;
            }
            case 1: {
                return pSSysEAIDEBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysEAIDEBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysEAIDEBase.getEAIDETag() == null;
            }
            case 4: {
                return pSSysEAIDEBase.getEAIDETag2() == null;
            }
            case 5: {
                return pSSysEAIDEBase.getMemo() == null;
            }
            case 6: {
                return pSSysEAIDEBase.getPSDEId() == null;
            }
            case 7: {
                return pSSysEAIDEBase.getPSDEName() == null;
            }
            case 8: {
                return pSSysEAIDEBase.getPSSysEAIDEId() == null;
            }
            case 9: {
                return pSSysEAIDEBase.getPSSysEAIDEName() == null;
            }
            case 10: {
                return pSSysEAIDEBase.getPSSysEAIElementId() == null;
            }
            case 11: {
                return pSSysEAIDEBase.getPSSysEAIElementName() == null;
            }
            case 12: {
                return pSSysEAIDEBase.getPSSysEAISchemeId() == null;
            }
            case 13: {
                return pSSysEAIDEBase.getPSSysEAISchemeName() == null;
            }
            case 14: {
                return pSSysEAIDEBase.getUpdateDate() == null;
            }
            case 15: {
                return pSSysEAIDEBase.getUpdateMan() == null;
            }
            case 16: {
                return pSSysEAIDEBase.getUserCat() == null;
            }
            case 17: {
                return pSSysEAIDEBase.getUserTag() == null;
            }
            case 18: {
                return pSSysEAIDEBase.getUserTag2() == null;
            }
            case 19: {
                return pSSysEAIDEBase.getUserTag3() == null;
            }
            case 20: {
                return pSSysEAIDEBase.getUserTag4() == null;
            }
            case 21: {
                return pSSysEAIDEBase.getValidFlag() == null;
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
        return PSSysEAIDEBase.contains(this, n);
    }

    private static boolean contains(PSSysEAIDEBase pSSysEAIDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysEAIDEBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysEAIDEBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysEAIDEBase.isCreateManDirty();
            }
            case 3: {
                return pSSysEAIDEBase.isEAIDETagDirty();
            }
            case 4: {
                return pSSysEAIDEBase.isEAIDETag2Dirty();
            }
            case 5: {
                return pSSysEAIDEBase.isMemoDirty();
            }
            case 6: {
                return pSSysEAIDEBase.isPSDEIdDirty();
            }
            case 7: {
                return pSSysEAIDEBase.isPSDENameDirty();
            }
            case 8: {
                return pSSysEAIDEBase.isPSSysEAIDEIdDirty();
            }
            case 9: {
                return pSSysEAIDEBase.isPSSysEAIDENameDirty();
            }
            case 10: {
                return pSSysEAIDEBase.isPSSysEAIElementIdDirty();
            }
            case 11: {
                return pSSysEAIDEBase.isPSSysEAIElementNameDirty();
            }
            case 12: {
                return pSSysEAIDEBase.isPSSysEAISchemeIdDirty();
            }
            case 13: {
                return pSSysEAIDEBase.isPSSysEAISchemeNameDirty();
            }
            case 14: {
                return pSSysEAIDEBase.isUpdateDateDirty();
            }
            case 15: {
                return pSSysEAIDEBase.isUpdateManDirty();
            }
            case 16: {
                return pSSysEAIDEBase.isUserCatDirty();
            }
            case 17: {
                return pSSysEAIDEBase.isUserTagDirty();
            }
            case 18: {
                return pSSysEAIDEBase.isUserTag2Dirty();
            }
            case 19: {
                return pSSysEAIDEBase.isUserTag3Dirty();
            }
            case 20: {
                return pSSysEAIDEBase.isUserTag4Dirty();
            }
            case 21: {
                return pSSysEAIDEBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysEAIDEBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysEAIDEBase pSSysEAIDEBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysEAIDEBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysEAIDEBase.getJSONValue((Object)pSSysEAIDEBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysEAIDEBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysEAIDEBase.getJSONValue((Object)pSSysEAIDEBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysEAIDEBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysEAIDEBase.getJSONValue((Object)pSSysEAIDEBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysEAIDEBase.getEAIDETag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eaidetag", (Object)PSSysEAIDEBase.getJSONValue((Object)pSSysEAIDEBase.getEAIDETag()), (boolean)false);
        }
        if (bl || pSSysEAIDEBase.getEAIDETag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eaidetag2", (Object)PSSysEAIDEBase.getJSONValue((Object)pSSysEAIDEBase.getEAIDETag2()), (boolean)false);
        }
        if (bl || pSSysEAIDEBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysEAIDEBase.getJSONValue((Object)pSSysEAIDEBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysEAIDEBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysEAIDEBase.getJSONValue((Object)pSSysEAIDEBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysEAIDEBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysEAIDEBase.getJSONValue((Object)pSSysEAIDEBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysEAIDEBase.getPSSysEAIDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaideid", (Object)PSSysEAIDEBase.getJSONValue((Object)pSSysEAIDEBase.getPSSysEAIDEId()), (boolean)false);
        }
        if (bl || pSSysEAIDEBase.getPSSysEAIDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaidename", (Object)PSSysEAIDEBase.getJSONValue((Object)pSSysEAIDEBase.getPSSysEAIDEName()), (boolean)false);
        }
        if (bl || pSSysEAIDEBase.getPSSysEAIElementId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaielementid", (Object)PSSysEAIDEBase.getJSONValue((Object)pSSysEAIDEBase.getPSSysEAIElementId()), (boolean)false);
        }
        if (bl || pSSysEAIDEBase.getPSSysEAIElementName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaielementname", (Object)PSSysEAIDEBase.getJSONValue((Object)pSSysEAIDEBase.getPSSysEAIElementName()), (boolean)false);
        }
        if (bl || pSSysEAIDEBase.getPSSysEAISchemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaischemeid", (Object)PSSysEAIDEBase.getJSONValue((Object)pSSysEAIDEBase.getPSSysEAISchemeId()), (boolean)false);
        }
        if (bl || pSSysEAIDEBase.getPSSysEAISchemeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaischemename", (Object)PSSysEAIDEBase.getJSONValue((Object)pSSysEAIDEBase.getPSSysEAISchemeName()), (boolean)false);
        }
        if (bl || pSSysEAIDEBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysEAIDEBase.getJSONValue((Object)pSSysEAIDEBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysEAIDEBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysEAIDEBase.getJSONValue((Object)pSSysEAIDEBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysEAIDEBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysEAIDEBase.getJSONValue((Object)pSSysEAIDEBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysEAIDEBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysEAIDEBase.getJSONValue((Object)pSSysEAIDEBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysEAIDEBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysEAIDEBase.getJSONValue((Object)pSSysEAIDEBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysEAIDEBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysEAIDEBase.getJSONValue((Object)pSSysEAIDEBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysEAIDEBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysEAIDEBase.getJSONValue((Object)pSSysEAIDEBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysEAIDEBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysEAIDEBase.getJSONValue((Object)pSSysEAIDEBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysEAIDEBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysEAIDEBase pSSysEAIDEBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysEAIDEBase.getCodeName() != null) {
            object = pSSysEAIDEBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEBase.getCreateDate() != null) {
            object = pSSysEAIDEBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysEAIDEBase.getCreateMan() != null) {
            object = pSSysEAIDEBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEBase.getEAIDETag() != null) {
            object = pSSysEAIDEBase.getEAIDETag();
            xmlNode.setAttribute(FIELD_EAIDETAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEBase.getEAIDETag2() != null) {
            object = pSSysEAIDEBase.getEAIDETag2();
            xmlNode.setAttribute(FIELD_EAIDETAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEBase.getMemo() != null) {
            object = pSSysEAIDEBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEBase.getPSDEId() != null) {
            object = pSSysEAIDEBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEBase.getPSDEName() != null) {
            object = pSSysEAIDEBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEBase.getPSSysEAIDEId() != null) {
            object = pSSysEAIDEBase.getPSSysEAIDEId();
            xmlNode.setAttribute(FIELD_PSSYSEAIDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEBase.getPSSysEAIDEName() != null) {
            object = pSSysEAIDEBase.getPSSysEAIDEName();
            xmlNode.setAttribute(FIELD_PSSYSEAIDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEBase.getPSSysEAIElementId() != null) {
            object = pSSysEAIDEBase.getPSSysEAIElementId();
            xmlNode.setAttribute(FIELD_PSSYSEAIELEMENTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEBase.getPSSysEAIElementName() != null) {
            object = pSSysEAIDEBase.getPSSysEAIElementName();
            xmlNode.setAttribute(FIELD_PSSYSEAIELEMENTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEBase.getPSSysEAISchemeId() != null) {
            object = pSSysEAIDEBase.getPSSysEAISchemeId();
            xmlNode.setAttribute(FIELD_PSSYSEAISCHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEBase.getPSSysEAISchemeName() != null) {
            object = pSSysEAIDEBase.getPSSysEAISchemeName();
            xmlNode.setAttribute(FIELD_PSSYSEAISCHEMENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEBase.getUpdateDate() != null) {
            object = pSSysEAIDEBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysEAIDEBase.getUpdateMan() != null) {
            object = pSSysEAIDEBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEBase.getUserCat() != null) {
            object = pSSysEAIDEBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEBase.getUserTag() != null) {
            object = pSSysEAIDEBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEBase.getUserTag2() != null) {
            object = pSSysEAIDEBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEBase.getUserTag3() != null) {
            object = pSSysEAIDEBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEBase.getUserTag4() != null) {
            object = pSSysEAIDEBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEBase.getValidFlag() != null) {
            object = pSSysEAIDEBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysEAIDEBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysEAIDEBase pSSysEAIDEBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysEAIDEBase.isCodeNameDirty() && (bl || pSSysEAIDEBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysEAIDEBase.getCodeName());
        }
        if (pSSysEAIDEBase.isCreateDateDirty() && (bl || pSSysEAIDEBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysEAIDEBase.getCreateDate());
        }
        if (pSSysEAIDEBase.isCreateManDirty() && (bl || pSSysEAIDEBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysEAIDEBase.getCreateMan());
        }
        if (pSSysEAIDEBase.isEAIDETagDirty() && (bl || pSSysEAIDEBase.getEAIDETag() != null)) {
            iDataObject.set(FIELD_EAIDETAG, (Object)pSSysEAIDEBase.getEAIDETag());
        }
        if (pSSysEAIDEBase.isEAIDETag2Dirty() && (bl || pSSysEAIDEBase.getEAIDETag2() != null)) {
            iDataObject.set(FIELD_EAIDETAG2, (Object)pSSysEAIDEBase.getEAIDETag2());
        }
        if (pSSysEAIDEBase.isMemoDirty() && (bl || pSSysEAIDEBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysEAIDEBase.getMemo());
        }
        if (pSSysEAIDEBase.isPSDEIdDirty() && (bl || pSSysEAIDEBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysEAIDEBase.getPSDEId());
        }
        if (pSSysEAIDEBase.isPSDENameDirty() && (bl || pSSysEAIDEBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysEAIDEBase.getPSDEName());
        }
        if (pSSysEAIDEBase.isPSSysEAIDEIdDirty() && (bl || pSSysEAIDEBase.getPSSysEAIDEId() != null)) {
            iDataObject.set(FIELD_PSSYSEAIDEID, (Object)pSSysEAIDEBase.getPSSysEAIDEId());
        }
        if (pSSysEAIDEBase.isPSSysEAIDENameDirty() && (bl || pSSysEAIDEBase.getPSSysEAIDEName() != null)) {
            iDataObject.set(FIELD_PSSYSEAIDENAME, (Object)pSSysEAIDEBase.getPSSysEAIDEName());
        }
        if (pSSysEAIDEBase.isPSSysEAIElementIdDirty() && (bl || pSSysEAIDEBase.getPSSysEAIElementId() != null)) {
            iDataObject.set(FIELD_PSSYSEAIELEMENTID, (Object)pSSysEAIDEBase.getPSSysEAIElementId());
        }
        if (pSSysEAIDEBase.isPSSysEAIElementNameDirty() && (bl || pSSysEAIDEBase.getPSSysEAIElementName() != null)) {
            iDataObject.set(FIELD_PSSYSEAIELEMENTNAME, (Object)pSSysEAIDEBase.getPSSysEAIElementName());
        }
        if (pSSysEAIDEBase.isPSSysEAISchemeIdDirty() && (bl || pSSysEAIDEBase.getPSSysEAISchemeId() != null)) {
            iDataObject.set(FIELD_PSSYSEAISCHEMEID, (Object)pSSysEAIDEBase.getPSSysEAISchemeId());
        }
        if (pSSysEAIDEBase.isPSSysEAISchemeNameDirty() && (bl || pSSysEAIDEBase.getPSSysEAISchemeName() != null)) {
            iDataObject.set(FIELD_PSSYSEAISCHEMENAME, (Object)pSSysEAIDEBase.getPSSysEAISchemeName());
        }
        if (pSSysEAIDEBase.isUpdateDateDirty() && (bl || pSSysEAIDEBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysEAIDEBase.getUpdateDate());
        }
        if (pSSysEAIDEBase.isUpdateManDirty() && (bl || pSSysEAIDEBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysEAIDEBase.getUpdateMan());
        }
        if (pSSysEAIDEBase.isUserCatDirty() && (bl || pSSysEAIDEBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysEAIDEBase.getUserCat());
        }
        if (pSSysEAIDEBase.isUserTagDirty() && (bl || pSSysEAIDEBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysEAIDEBase.getUserTag());
        }
        if (pSSysEAIDEBase.isUserTag2Dirty() && (bl || pSSysEAIDEBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysEAIDEBase.getUserTag2());
        }
        if (pSSysEAIDEBase.isUserTag3Dirty() && (bl || pSSysEAIDEBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysEAIDEBase.getUserTag3());
        }
        if (pSSysEAIDEBase.isUserTag4Dirty() && (bl || pSSysEAIDEBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysEAIDEBase.getUserTag4());
        }
        if (pSSysEAIDEBase.isValidFlagDirty() && (bl || pSSysEAIDEBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysEAIDEBase.getValidFlag());
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
        return PSSysEAIDEBase.remove(this, n);
    }

    private static boolean remove(PSSysEAIDEBase pSSysEAIDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysEAIDEBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysEAIDEBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysEAIDEBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysEAIDEBase.resetEAIDETag();
                return true;
            }
            case 4: {
                pSSysEAIDEBase.resetEAIDETag2();
                return true;
            }
            case 5: {
                pSSysEAIDEBase.resetMemo();
                return true;
            }
            case 6: {
                pSSysEAIDEBase.resetPSDEId();
                return true;
            }
            case 7: {
                pSSysEAIDEBase.resetPSDEName();
                return true;
            }
            case 8: {
                pSSysEAIDEBase.resetPSSysEAIDEId();
                return true;
            }
            case 9: {
                pSSysEAIDEBase.resetPSSysEAIDEName();
                return true;
            }
            case 10: {
                pSSysEAIDEBase.resetPSSysEAIElementId();
                return true;
            }
            case 11: {
                pSSysEAIDEBase.resetPSSysEAIElementName();
                return true;
            }
            case 12: {
                pSSysEAIDEBase.resetPSSysEAISchemeId();
                return true;
            }
            case 13: {
                pSSysEAIDEBase.resetPSSysEAISchemeName();
                return true;
            }
            case 14: {
                pSSysEAIDEBase.resetUpdateDate();
                return true;
            }
            case 15: {
                pSSysEAIDEBase.resetUpdateMan();
                return true;
            }
            case 16: {
                pSSysEAIDEBase.resetUserCat();
                return true;
            }
            case 17: {
                pSSysEAIDEBase.resetUserTag();
                return true;
            }
            case 18: {
                pSSysEAIDEBase.resetUserTag2();
                return true;
            }
            case 19: {
                pSSysEAIDEBase.resetUserTag3();
                return true;
            }
            case 20: {
                pSSysEAIDEBase.resetUserTag4();
                return true;
            }
            case 21: {
                pSSysEAIDEBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDE();
        }
        if (this.getPSDEId() == null) {
            return null;
        }
        Integer n = this.objPSDELock;
        synchronized (n) {
            if (this.psde != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEId(), (Object)this.psde.getPSDataEntityId()) != 0L) {
                this.psde = null;
            }
            if (this.psde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysEAIElement getPSSysEAIElement() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIElement();
        }
        if (this.getPSSysEAIElementId() == null) {
            return null;
        }
        Integer n = this.objPSSysEAIElementLock;
        synchronized (n) {
            if (this.pssyseaielement != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysEAIElementId(), (Object)this.pssyseaielement.getPSSysEAIElementId()) != 0L) {
                this.pssyseaielement = null;
            }
            if (this.pssyseaielement == null) {
                PSSysEAIElement pSSysEAIElement = new PSSysEAIElement();
                pSSysEAIElement.setPSSysEAIElementId(this.getPSSysEAIElementId());
                PSSysEAIElementService pSSysEAIElementService = (PSSysEAIElementService)ServiceGlobal.getService(PSSysEAIElementService.class, (SessionFactory)this.getSessionFactory());
                pSSysEAIElementService.autoGet((IEntity)pSSysEAIElement);
                this.pssyseaielement = pSSysEAIElement;
            }
            return this.pssyseaielement;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysEAIScheme getPSSysEAIScheme() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIScheme();
        }
        if (this.getPSSysEAISchemeId() == null) {
            return null;
        }
        Integer n = this.objPSSysEAISchemeLock;
        synchronized (n) {
            if (this.pssyseaischeme != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysEAISchemeId(), (Object)this.pssyseaischeme.getPSSysEAISchemeId()) != 0L) {
                this.pssyseaischeme = null;
            }
            if (this.pssyseaischeme == null) {
                PSSysEAIScheme pSSysEAIScheme = new PSSysEAIScheme();
                pSSysEAIScheme.setPSSysEAISchemeId(this.getPSSysEAISchemeId());
                PSSysEAISchemeService pSSysEAISchemeService = (PSSysEAISchemeService)ServiceGlobal.getService(PSSysEAISchemeService.class, (SessionFactory)this.getSessionFactory());
                pSSysEAISchemeService.autoGet((IEntity)pSSysEAIScheme);
                this.pssyseaischeme = pSSysEAIScheme;
            }
            return this.pssyseaischeme;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysEAIDEField> getPSSysEAIDEFields() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIDEFields();
        }
        if (this.getPSSysEAIDEId() == null) {
            return null;
        }
        PSSysEAIDEService pSSysEAIDEService = (PSSysEAIDEService)ServiceGlobal.getService(PSSysEAIDEService.class, (SessionFactory)this.getSessionFactory());
        PSSysEAIDEFieldService pSSysEAIDEFieldService = (PSSysEAIDEFieldService)ServiceGlobal.getService(PSSysEAIDEFieldService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysEAIDEFieldsLock;
        synchronized (n) {
            if (this.pssyseaidefields == null) {
                this.pssyseaidefields = pSSysEAIDEService.isTempData((IEntity)this) ? pSSysEAIDEFieldService.selectTempByPSSysEAIDE(this) : pSSysEAIDEFieldService.selectByPSSysEAIDE(this);
            }
            return this.pssyseaidefields;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysEAIDER> getPSSysEAIDERs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIDERs();
        }
        if (this.getPSSysEAIDEId() == null) {
            return null;
        }
        PSSysEAIDEService pSSysEAIDEService = (PSSysEAIDEService)ServiceGlobal.getService(PSSysEAIDEService.class, (SessionFactory)this.getSessionFactory());
        PSSysEAIDERService pSSysEAIDERService = (PSSysEAIDERService)ServiceGlobal.getService(PSSysEAIDERService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysEAIDERsLock;
        synchronized (n) {
            if (this.pssyseaiders == null) {
                this.pssyseaiders = pSSysEAIDEService.isTempData((IEntity)this) ? pSSysEAIDERService.selectTempByPSSysEAIDE(this) : pSSysEAIDERService.selectByPSSysEAIDE(this);
            }
            return this.pssyseaiders;
        }
    }

    private PSSysEAIDEBase getProxyEntity() {
        return this.proxyPSSysEAIDEBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysEAIDEBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysEAIDEBase) {
            this.proxyPSSysEAIDEBase = (PSSysEAIDEBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDEService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_EAIDETAG, 3);
        fieldIndexMap.put(FIELD_EAIDETAG2, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSDEID, 6);
        fieldIndexMap.put(FIELD_PSDENAME, 7);
        fieldIndexMap.put(FIELD_PSSYSEAIDEID, 8);
        fieldIndexMap.put(FIELD_PSSYSEAIDENAME, 9);
        fieldIndexMap.put(FIELD_PSSYSEAIELEMENTID, 10);
        fieldIndexMap.put(FIELD_PSSYSEAIELEMENTNAME, 11);
        fieldIndexMap.put(FIELD_PSSYSEAISCHEMEID, 12);
        fieldIndexMap.put(FIELD_PSSYSEAISCHEMENAME, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
        fieldIndexMap.put(FIELD_USERCAT, 16);
        fieldIndexMap.put(FIELD_USERTAG, 17);
        fieldIndexMap.put(FIELD_USERTAG2, 18);
        fieldIndexMap.put(FIELD_USERTAG3, 19);
        fieldIndexMap.put(FIELD_USERTAG4, 20);
        fieldIndexMap.put(FIELD_VALIDFLAG, 21);
    }
}

