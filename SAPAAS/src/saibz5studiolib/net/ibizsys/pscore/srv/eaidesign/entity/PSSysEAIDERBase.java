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
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIDE;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIElementRE;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDEService;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIElementREService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysEAIDERBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysEAIDERBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_EAIDERTAG = "EAIDERTAG";
    public static final String FIELD_EAIDERTAG2 = "EAIDERTAG2";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDERID = "PSDERID";
    public static final String FIELD_PSDERNAME = "PSDERNAME";
    public static final String FIELD_PSSYSEAIDEID = "PSSYSEAIDEID";
    public static final String FIELD_PSSYSEAIDENAME = "PSSYSEAIDENAME";
    public static final String FIELD_PSSYSEAIDERID = "PSSYSEAIDERID";
    public static final String FIELD_PSSYSEAIDERNAME = "PSSYSEAIDERNAME";
    public static final String FIELD_PSSYSEAIELEMENTID = "PSSYSEAIELEMENTID";
    public static final String FIELD_PSSYSEAIELEMENTREID = "PSSYSEAIELEMENTREID";
    public static final String FIELD_PSSYSEAIELEMENTRENAME = "PSSYSEAIELEMENTRENAME";
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
    private static final int INDEX_EAIDERTAG = 3;
    private static final int INDEX_EAIDERTAG2 = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSDEID = 6;
    private static final int INDEX_PSDERID = 7;
    private static final int INDEX_PSDERNAME = 8;
    private static final int INDEX_PSSYSEAIDEID = 9;
    private static final int INDEX_PSSYSEAIDENAME = 10;
    private static final int INDEX_PSSYSEAIDERID = 11;
    private static final int INDEX_PSSYSEAIDERNAME = 12;
    private static final int INDEX_PSSYSEAIELEMENTID = 13;
    private static final int INDEX_PSSYSEAIELEMENTREID = 14;
    private static final int INDEX_PSSYSEAIELEMENTRENAME = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final int INDEX_USERCAT = 18;
    private static final int INDEX_USERTAG = 19;
    private static final int INDEX_USERTAG2 = 20;
    private static final int INDEX_USERTAG3 = 21;
    private static final int INDEX_USERTAG4 = 22;
    private static final int INDEX_VALIDFLAG = 23;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysEAIDERBase proxyPSSysEAIDERBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean eaidertagDirtyFlag = false;
    private boolean eaidertag2DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psderidDirtyFlag = false;
    private boolean psdernameDirtyFlag = false;
    private boolean pssyseaideidDirtyFlag = false;
    private boolean pssyseaidenameDirtyFlag = false;
    private boolean pssyseaideridDirtyFlag = false;
    private boolean pssyseaidernameDirtyFlag = false;
    private boolean pssyseaielementidDirtyFlag = false;
    private boolean pssyseaielementreidDirtyFlag = false;
    private boolean pssyseaielementrenameDirtyFlag = false;
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
    @Column(name="eaidertag")
    private String eaidertag;
    @Column(name="eaidertag2")
    private String eaidertag2;
    @Column(name="memo")
    private String memo;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psderid")
    private String psderid;
    @Column(name="psdername")
    private String psdername;
    @Column(name="pssyseaideid")
    private String pssyseaideid;
    @Column(name="pssyseaidename")
    private String pssyseaidename;
    @Column(name="pssyseaiderid")
    private String pssyseaiderid;
    @Column(name="pssyseaidername")
    private String pssyseaidername;
    @Column(name="pssyseaielementid")
    private String pssyseaielementid;
    @Column(name="pssyseaielementreid")
    private String pssyseaielementreid;
    @Column(name="pssyseaielementrename")
    private String pssyseaielementrename;
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
    private Integer objPSDERLock = new Integer(1);
    private PSDER psder = null;
    private Integer objPSSysEAIDELock = new Integer(1);
    private PSSysEAIDE pssyseaide = null;
    private Integer objPSSysEAIElementRELock = new Integer(1);
    private PSSysEAIElementRE pssyseaielementre = null;

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

    public void setEAIDERTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEAIDERTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.eaidertag = string;
        this.eaidertagDirtyFlag = true;
    }

    public String getEAIDERTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEAIDERTag();
        }
        return this.eaidertag;
    }

    public boolean isEAIDERTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEAIDERTagDirty();
        }
        return this.eaidertagDirtyFlag;
    }

    public void resetEAIDERTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEAIDERTag();
            return;
        }
        this.eaidertagDirtyFlag = false;
        this.eaidertag = null;
    }

    public void setEAIDERTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEAIDERTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.eaidertag2 = string;
        this.eaidertag2DirtyFlag = true;
    }

    public String getEAIDERTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEAIDERTag2();
        }
        return this.eaidertag2;
    }

    public boolean isEAIDERTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEAIDERTag2Dirty();
        }
        return this.eaidertag2DirtyFlag;
    }

    public void resetEAIDERTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEAIDERTag2();
            return;
        }
        this.eaidertag2DirtyFlag = false;
        this.eaidertag2 = null;
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

    public void setPSDERId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psderid = string;
        this.psderidDirtyFlag = true;
    }

    public String getPSDERId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERId();
        }
        return this.psderid;
    }

    public boolean isPSDERIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERIdDirty();
        }
        return this.psderidDirtyFlag;
    }

    public void resetPSDERId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERId();
            return;
        }
        this.psderidDirtyFlag = false;
        this.psderid = null;
    }

    public void setPSDERName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdername = string;
        this.psdernameDirtyFlag = true;
    }

    public String getPSDERName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERName();
        }
        return this.psdername;
    }

    public boolean isPSDERNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERNameDirty();
        }
        return this.psdernameDirtyFlag;
    }

    public void resetPSDERName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERName();
            return;
        }
        this.psdernameDirtyFlag = false;
        this.psdername = null;
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

    public void setPSSysEAIDERId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEAIDERId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseaiderid = string;
        this.pssyseaideridDirtyFlag = true;
    }

    public String getPSSysEAIDERId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIDERId();
        }
        return this.pssyseaiderid;
    }

    public boolean isPSSysEAIDERIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEAIDERIdDirty();
        }
        return this.pssyseaideridDirtyFlag;
    }

    public void resetPSSysEAIDERId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEAIDERId();
            return;
        }
        this.pssyseaideridDirtyFlag = false;
        this.pssyseaiderid = null;
    }

    public void setPSSysEAIDERName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEAIDERName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseaidername = string;
        this.pssyseaidernameDirtyFlag = true;
    }

    public String getPSSysEAIDERName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIDERName();
        }
        return this.pssyseaidername;
    }

    public boolean isPSSysEAIDERNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEAIDERNameDirty();
        }
        return this.pssyseaidernameDirtyFlag;
    }

    public void resetPSSysEAIDERName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEAIDERName();
            return;
        }
        this.pssyseaidernameDirtyFlag = false;
        this.pssyseaidername = null;
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

    public void setPSSysEAIElementREId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEAIElementREId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseaielementreid = string;
        this.pssyseaielementreidDirtyFlag = true;
    }

    public String getPSSysEAIElementREId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIElementREId();
        }
        return this.pssyseaielementreid;
    }

    public boolean isPSSysEAIElementREIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEAIElementREIdDirty();
        }
        return this.pssyseaielementreidDirtyFlag;
    }

    public void resetPSSysEAIElementREId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEAIElementREId();
            return;
        }
        this.pssyseaielementreidDirtyFlag = false;
        this.pssyseaielementreid = null;
    }

    public void setPSSysEAIElementREName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEAIElementREName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseaielementrename = string;
        this.pssyseaielementrenameDirtyFlag = true;
    }

    public String getPSSysEAIElementREName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIElementREName();
        }
        return this.pssyseaielementrename;
    }

    public boolean isPSSysEAIElementRENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEAIElementRENameDirty();
        }
        return this.pssyseaielementrenameDirtyFlag;
    }

    public void resetPSSysEAIElementREName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEAIElementREName();
            return;
        }
        this.pssyseaielementrenameDirtyFlag = false;
        this.pssyseaielementrename = null;
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
        PSSysEAIDERBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysEAIDERBase pSSysEAIDERBase) {
        pSSysEAIDERBase.resetCodeName();
        pSSysEAIDERBase.resetCreateDate();
        pSSysEAIDERBase.resetCreateMan();
        pSSysEAIDERBase.resetEAIDERTag();
        pSSysEAIDERBase.resetEAIDERTag2();
        pSSysEAIDERBase.resetMemo();
        pSSysEAIDERBase.resetPSDEId();
        pSSysEAIDERBase.resetPSDERId();
        pSSysEAIDERBase.resetPSDERName();
        pSSysEAIDERBase.resetPSSysEAIDEId();
        pSSysEAIDERBase.resetPSSysEAIDEName();
        pSSysEAIDERBase.resetPSSysEAIDERId();
        pSSysEAIDERBase.resetPSSysEAIDERName();
        pSSysEAIDERBase.resetPSSysEAIElementId();
        pSSysEAIDERBase.resetPSSysEAIElementREId();
        pSSysEAIDERBase.resetPSSysEAIElementREName();
        pSSysEAIDERBase.resetUpdateDate();
        pSSysEAIDERBase.resetUpdateMan();
        pSSysEAIDERBase.resetUserCat();
        pSSysEAIDERBase.resetUserTag();
        pSSysEAIDERBase.resetUserTag2();
        pSSysEAIDERBase.resetUserTag3();
        pSSysEAIDERBase.resetUserTag4();
        pSSysEAIDERBase.resetValidFlag();
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
        if (!bl || this.isEAIDERTagDirty()) {
            hashMap.put(FIELD_EAIDERTAG, this.getEAIDERTag());
        }
        if (!bl || this.isEAIDERTag2Dirty()) {
            hashMap.put(FIELD_EAIDERTAG2, this.getEAIDERTag2());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDERIdDirty()) {
            hashMap.put(FIELD_PSDERID, this.getPSDERId());
        }
        if (!bl || this.isPSDERNameDirty()) {
            hashMap.put(FIELD_PSDERNAME, this.getPSDERName());
        }
        if (!bl || this.isPSSysEAIDEIdDirty()) {
            hashMap.put(FIELD_PSSYSEAIDEID, this.getPSSysEAIDEId());
        }
        if (!bl || this.isPSSysEAIDENameDirty()) {
            hashMap.put(FIELD_PSSYSEAIDENAME, this.getPSSysEAIDEName());
        }
        if (!bl || this.isPSSysEAIDERIdDirty()) {
            hashMap.put(FIELD_PSSYSEAIDERID, this.getPSSysEAIDERId());
        }
        if (!bl || this.isPSSysEAIDERNameDirty()) {
            hashMap.put(FIELD_PSSYSEAIDERNAME, this.getPSSysEAIDERName());
        }
        if (!bl || this.isPSSysEAIElementIdDirty()) {
            hashMap.put(FIELD_PSSYSEAIELEMENTID, this.getPSSysEAIElementId());
        }
        if (!bl || this.isPSSysEAIElementREIdDirty()) {
            hashMap.put(FIELD_PSSYSEAIELEMENTREID, this.getPSSysEAIElementREId());
        }
        if (!bl || this.isPSSysEAIElementRENameDirty()) {
            hashMap.put(FIELD_PSSYSEAIELEMENTRENAME, this.getPSSysEAIElementREName());
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
        return PSSysEAIDERBase.get(this, n);
    }

    private static Object get(PSSysEAIDERBase pSSysEAIDERBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysEAIDERBase.getCodeName();
            }
            case 1: {
                return pSSysEAIDERBase.getCreateDate();
            }
            case 2: {
                return pSSysEAIDERBase.getCreateMan();
            }
            case 3: {
                return pSSysEAIDERBase.getEAIDERTag();
            }
            case 4: {
                return pSSysEAIDERBase.getEAIDERTag2();
            }
            case 5: {
                return pSSysEAIDERBase.getMemo();
            }
            case 6: {
                return pSSysEAIDERBase.getPSDEId();
            }
            case 7: {
                return pSSysEAIDERBase.getPSDERId();
            }
            case 8: {
                return pSSysEAIDERBase.getPSDERName();
            }
            case 9: {
                return pSSysEAIDERBase.getPSSysEAIDEId();
            }
            case 10: {
                return pSSysEAIDERBase.getPSSysEAIDEName();
            }
            case 11: {
                return pSSysEAIDERBase.getPSSysEAIDERId();
            }
            case 12: {
                return pSSysEAIDERBase.getPSSysEAIDERName();
            }
            case 13: {
                return pSSysEAIDERBase.getPSSysEAIElementId();
            }
            case 14: {
                return pSSysEAIDERBase.getPSSysEAIElementREId();
            }
            case 15: {
                return pSSysEAIDERBase.getPSSysEAIElementREName();
            }
            case 16: {
                return pSSysEAIDERBase.getUpdateDate();
            }
            case 17: {
                return pSSysEAIDERBase.getUpdateMan();
            }
            case 18: {
                return pSSysEAIDERBase.getUserCat();
            }
            case 19: {
                return pSSysEAIDERBase.getUserTag();
            }
            case 20: {
                return pSSysEAIDERBase.getUserTag2();
            }
            case 21: {
                return pSSysEAIDERBase.getUserTag3();
            }
            case 22: {
                return pSSysEAIDERBase.getUserTag4();
            }
            case 23: {
                return pSSysEAIDERBase.getValidFlag();
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
        PSSysEAIDERBase.set(this, n, object);
    }

    private static void set(PSSysEAIDERBase pSSysEAIDERBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysEAIDERBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysEAIDERBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysEAIDERBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysEAIDERBase.setEAIDERTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysEAIDERBase.setEAIDERTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysEAIDERBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysEAIDERBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysEAIDERBase.setPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysEAIDERBase.setPSDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysEAIDERBase.setPSSysEAIDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysEAIDERBase.setPSSysEAIDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysEAIDERBase.setPSSysEAIDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysEAIDERBase.setPSSysEAIDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysEAIDERBase.setPSSysEAIElementId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysEAIDERBase.setPSSysEAIElementREId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysEAIDERBase.setPSSysEAIElementREName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysEAIDERBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSSysEAIDERBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysEAIDERBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysEAIDERBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysEAIDERBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysEAIDERBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysEAIDERBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysEAIDERBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysEAIDERBase.isNull(this, n);
    }

    private static boolean isNull(PSSysEAIDERBase pSSysEAIDERBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysEAIDERBase.getCodeName() == null;
            }
            case 1: {
                return pSSysEAIDERBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysEAIDERBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysEAIDERBase.getEAIDERTag() == null;
            }
            case 4: {
                return pSSysEAIDERBase.getEAIDERTag2() == null;
            }
            case 5: {
                return pSSysEAIDERBase.getMemo() == null;
            }
            case 6: {
                return pSSysEAIDERBase.getPSDEId() == null;
            }
            case 7: {
                return pSSysEAIDERBase.getPSDERId() == null;
            }
            case 8: {
                return pSSysEAIDERBase.getPSDERName() == null;
            }
            case 9: {
                return pSSysEAIDERBase.getPSSysEAIDEId() == null;
            }
            case 10: {
                return pSSysEAIDERBase.getPSSysEAIDEName() == null;
            }
            case 11: {
                return pSSysEAIDERBase.getPSSysEAIDERId() == null;
            }
            case 12: {
                return pSSysEAIDERBase.getPSSysEAIDERName() == null;
            }
            case 13: {
                return pSSysEAIDERBase.getPSSysEAIElementId() == null;
            }
            case 14: {
                return pSSysEAIDERBase.getPSSysEAIElementREId() == null;
            }
            case 15: {
                return pSSysEAIDERBase.getPSSysEAIElementREName() == null;
            }
            case 16: {
                return pSSysEAIDERBase.getUpdateDate() == null;
            }
            case 17: {
                return pSSysEAIDERBase.getUpdateMan() == null;
            }
            case 18: {
                return pSSysEAIDERBase.getUserCat() == null;
            }
            case 19: {
                return pSSysEAIDERBase.getUserTag() == null;
            }
            case 20: {
                return pSSysEAIDERBase.getUserTag2() == null;
            }
            case 21: {
                return pSSysEAIDERBase.getUserTag3() == null;
            }
            case 22: {
                return pSSysEAIDERBase.getUserTag4() == null;
            }
            case 23: {
                return pSSysEAIDERBase.getValidFlag() == null;
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
        return PSSysEAIDERBase.contains(this, n);
    }

    private static boolean contains(PSSysEAIDERBase pSSysEAIDERBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysEAIDERBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysEAIDERBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysEAIDERBase.isCreateManDirty();
            }
            case 3: {
                return pSSysEAIDERBase.isEAIDERTagDirty();
            }
            case 4: {
                return pSSysEAIDERBase.isEAIDERTag2Dirty();
            }
            case 5: {
                return pSSysEAIDERBase.isMemoDirty();
            }
            case 6: {
                return pSSysEAIDERBase.isPSDEIdDirty();
            }
            case 7: {
                return pSSysEAIDERBase.isPSDERIdDirty();
            }
            case 8: {
                return pSSysEAIDERBase.isPSDERNameDirty();
            }
            case 9: {
                return pSSysEAIDERBase.isPSSysEAIDEIdDirty();
            }
            case 10: {
                return pSSysEAIDERBase.isPSSysEAIDENameDirty();
            }
            case 11: {
                return pSSysEAIDERBase.isPSSysEAIDERIdDirty();
            }
            case 12: {
                return pSSysEAIDERBase.isPSSysEAIDERNameDirty();
            }
            case 13: {
                return pSSysEAIDERBase.isPSSysEAIElementIdDirty();
            }
            case 14: {
                return pSSysEAIDERBase.isPSSysEAIElementREIdDirty();
            }
            case 15: {
                return pSSysEAIDERBase.isPSSysEAIElementRENameDirty();
            }
            case 16: {
                return pSSysEAIDERBase.isUpdateDateDirty();
            }
            case 17: {
                return pSSysEAIDERBase.isUpdateManDirty();
            }
            case 18: {
                return pSSysEAIDERBase.isUserCatDirty();
            }
            case 19: {
                return pSSysEAIDERBase.isUserTagDirty();
            }
            case 20: {
                return pSSysEAIDERBase.isUserTag2Dirty();
            }
            case 21: {
                return pSSysEAIDERBase.isUserTag3Dirty();
            }
            case 22: {
                return pSSysEAIDERBase.isUserTag4Dirty();
            }
            case 23: {
                return pSSysEAIDERBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysEAIDERBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysEAIDERBase pSSysEAIDERBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysEAIDERBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysEAIDERBase.getJSONValue((Object)pSSysEAIDERBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysEAIDERBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysEAIDERBase.getJSONValue((Object)pSSysEAIDERBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysEAIDERBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysEAIDERBase.getJSONValue((Object)pSSysEAIDERBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysEAIDERBase.getEAIDERTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eaidertag", (Object)PSSysEAIDERBase.getJSONValue((Object)pSSysEAIDERBase.getEAIDERTag()), (boolean)false);
        }
        if (bl || pSSysEAIDERBase.getEAIDERTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eaidertag2", (Object)PSSysEAIDERBase.getJSONValue((Object)pSSysEAIDERBase.getEAIDERTag2()), (boolean)false);
        }
        if (bl || pSSysEAIDERBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysEAIDERBase.getJSONValue((Object)pSSysEAIDERBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysEAIDERBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysEAIDERBase.getJSONValue((Object)pSSysEAIDERBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysEAIDERBase.getPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psderid", (Object)PSSysEAIDERBase.getJSONValue((Object)pSSysEAIDERBase.getPSDERId()), (boolean)false);
        }
        if (bl || pSSysEAIDERBase.getPSDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdername", (Object)PSSysEAIDERBase.getJSONValue((Object)pSSysEAIDERBase.getPSDERName()), (boolean)false);
        }
        if (bl || pSSysEAIDERBase.getPSSysEAIDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaideid", (Object)PSSysEAIDERBase.getJSONValue((Object)pSSysEAIDERBase.getPSSysEAIDEId()), (boolean)false);
        }
        if (bl || pSSysEAIDERBase.getPSSysEAIDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaidename", (Object)PSSysEAIDERBase.getJSONValue((Object)pSSysEAIDERBase.getPSSysEAIDEName()), (boolean)false);
        }
        if (bl || pSSysEAIDERBase.getPSSysEAIDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaiderid", (Object)PSSysEAIDERBase.getJSONValue((Object)pSSysEAIDERBase.getPSSysEAIDERId()), (boolean)false);
        }
        if (bl || pSSysEAIDERBase.getPSSysEAIDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaidername", (Object)PSSysEAIDERBase.getJSONValue((Object)pSSysEAIDERBase.getPSSysEAIDERName()), (boolean)false);
        }
        if (bl || pSSysEAIDERBase.getPSSysEAIElementId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaielementid", (Object)PSSysEAIDERBase.getJSONValue((Object)pSSysEAIDERBase.getPSSysEAIElementId()), (boolean)false);
        }
        if (bl || pSSysEAIDERBase.getPSSysEAIElementREId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaielementreid", (Object)PSSysEAIDERBase.getJSONValue((Object)pSSysEAIDERBase.getPSSysEAIElementREId()), (boolean)false);
        }
        if (bl || pSSysEAIDERBase.getPSSysEAIElementREName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaielementrename", (Object)PSSysEAIDERBase.getJSONValue((Object)pSSysEAIDERBase.getPSSysEAIElementREName()), (boolean)false);
        }
        if (bl || pSSysEAIDERBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysEAIDERBase.getJSONValue((Object)pSSysEAIDERBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysEAIDERBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysEAIDERBase.getJSONValue((Object)pSSysEAIDERBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysEAIDERBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysEAIDERBase.getJSONValue((Object)pSSysEAIDERBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysEAIDERBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysEAIDERBase.getJSONValue((Object)pSSysEAIDERBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysEAIDERBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysEAIDERBase.getJSONValue((Object)pSSysEAIDERBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysEAIDERBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysEAIDERBase.getJSONValue((Object)pSSysEAIDERBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysEAIDERBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysEAIDERBase.getJSONValue((Object)pSSysEAIDERBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysEAIDERBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysEAIDERBase.getJSONValue((Object)pSSysEAIDERBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysEAIDERBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysEAIDERBase pSSysEAIDERBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysEAIDERBase.getCodeName() != null) {
            object = pSSysEAIDERBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDERBase.getCreateDate() != null) {
            object = pSSysEAIDERBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysEAIDERBase.getCreateMan() != null) {
            object = pSSysEAIDERBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDERBase.getEAIDERTag() != null) {
            object = pSSysEAIDERBase.getEAIDERTag();
            xmlNode.setAttribute(FIELD_EAIDERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDERBase.getEAIDERTag2() != null) {
            object = pSSysEAIDERBase.getEAIDERTag2();
            xmlNode.setAttribute(FIELD_EAIDERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDERBase.getMemo() != null) {
            object = pSSysEAIDERBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDERBase.getPSDEId() != null) {
            object = pSSysEAIDERBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDERBase.getPSDERId() != null) {
            object = pSSysEAIDERBase.getPSDERId();
            xmlNode.setAttribute(FIELD_PSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDERBase.getPSDERName() != null) {
            object = pSSysEAIDERBase.getPSDERName();
            xmlNode.setAttribute(FIELD_PSDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDERBase.getPSSysEAIDEId() != null) {
            object = pSSysEAIDERBase.getPSSysEAIDEId();
            xmlNode.setAttribute(FIELD_PSSYSEAIDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDERBase.getPSSysEAIDEName() != null) {
            object = pSSysEAIDERBase.getPSSysEAIDEName();
            xmlNode.setAttribute(FIELD_PSSYSEAIDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDERBase.getPSSysEAIDERId() != null) {
            object = pSSysEAIDERBase.getPSSysEAIDERId();
            xmlNode.setAttribute(FIELD_PSSYSEAIDERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDERBase.getPSSysEAIDERName() != null) {
            object = pSSysEAIDERBase.getPSSysEAIDERName();
            xmlNode.setAttribute(FIELD_PSSYSEAIDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDERBase.getPSSysEAIElementId() != null) {
            object = pSSysEAIDERBase.getPSSysEAIElementId();
            xmlNode.setAttribute(FIELD_PSSYSEAIELEMENTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDERBase.getPSSysEAIElementREId() != null) {
            object = pSSysEAIDERBase.getPSSysEAIElementREId();
            xmlNode.setAttribute(FIELD_PSSYSEAIELEMENTREID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDERBase.getPSSysEAIElementREName() != null) {
            object = pSSysEAIDERBase.getPSSysEAIElementREName();
            xmlNode.setAttribute(FIELD_PSSYSEAIELEMENTRENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDERBase.getUpdateDate() != null) {
            object = pSSysEAIDERBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysEAIDERBase.getUpdateMan() != null) {
            object = pSSysEAIDERBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDERBase.getUserCat() != null) {
            object = pSSysEAIDERBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDERBase.getUserTag() != null) {
            object = pSSysEAIDERBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDERBase.getUserTag2() != null) {
            object = pSSysEAIDERBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDERBase.getUserTag3() != null) {
            object = pSSysEAIDERBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDERBase.getUserTag4() != null) {
            object = pSSysEAIDERBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDERBase.getValidFlag() != null) {
            object = pSSysEAIDERBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysEAIDERBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysEAIDERBase pSSysEAIDERBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysEAIDERBase.isCodeNameDirty() && (bl || pSSysEAIDERBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysEAIDERBase.getCodeName());
        }
        if (pSSysEAIDERBase.isCreateDateDirty() && (bl || pSSysEAIDERBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysEAIDERBase.getCreateDate());
        }
        if (pSSysEAIDERBase.isCreateManDirty() && (bl || pSSysEAIDERBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysEAIDERBase.getCreateMan());
        }
        if (pSSysEAIDERBase.isEAIDERTagDirty() && (bl || pSSysEAIDERBase.getEAIDERTag() != null)) {
            iDataObject.set(FIELD_EAIDERTAG, (Object)pSSysEAIDERBase.getEAIDERTag());
        }
        if (pSSysEAIDERBase.isEAIDERTag2Dirty() && (bl || pSSysEAIDERBase.getEAIDERTag2() != null)) {
            iDataObject.set(FIELD_EAIDERTAG2, (Object)pSSysEAIDERBase.getEAIDERTag2());
        }
        if (pSSysEAIDERBase.isMemoDirty() && (bl || pSSysEAIDERBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysEAIDERBase.getMemo());
        }
        if (pSSysEAIDERBase.isPSDEIdDirty() && (bl || pSSysEAIDERBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysEAIDERBase.getPSDEId());
        }
        if (pSSysEAIDERBase.isPSDERIdDirty() && (bl || pSSysEAIDERBase.getPSDERId() != null)) {
            iDataObject.set(FIELD_PSDERID, (Object)pSSysEAIDERBase.getPSDERId());
        }
        if (pSSysEAIDERBase.isPSDERNameDirty() && (bl || pSSysEAIDERBase.getPSDERName() != null)) {
            iDataObject.set(FIELD_PSDERNAME, (Object)pSSysEAIDERBase.getPSDERName());
        }
        if (pSSysEAIDERBase.isPSSysEAIDEIdDirty() && (bl || pSSysEAIDERBase.getPSSysEAIDEId() != null)) {
            iDataObject.set(FIELD_PSSYSEAIDEID, (Object)pSSysEAIDERBase.getPSSysEAIDEId());
        }
        if (pSSysEAIDERBase.isPSSysEAIDENameDirty() && (bl || pSSysEAIDERBase.getPSSysEAIDEName() != null)) {
            iDataObject.set(FIELD_PSSYSEAIDENAME, (Object)pSSysEAIDERBase.getPSSysEAIDEName());
        }
        if (pSSysEAIDERBase.isPSSysEAIDERIdDirty() && (bl || pSSysEAIDERBase.getPSSysEAIDERId() != null)) {
            iDataObject.set(FIELD_PSSYSEAIDERID, (Object)pSSysEAIDERBase.getPSSysEAIDERId());
        }
        if (pSSysEAIDERBase.isPSSysEAIDERNameDirty() && (bl || pSSysEAIDERBase.getPSSysEAIDERName() != null)) {
            iDataObject.set(FIELD_PSSYSEAIDERNAME, (Object)pSSysEAIDERBase.getPSSysEAIDERName());
        }
        if (pSSysEAIDERBase.isPSSysEAIElementIdDirty() && (bl || pSSysEAIDERBase.getPSSysEAIElementId() != null)) {
            iDataObject.set(FIELD_PSSYSEAIELEMENTID, (Object)pSSysEAIDERBase.getPSSysEAIElementId());
        }
        if (pSSysEAIDERBase.isPSSysEAIElementREIdDirty() && (bl || pSSysEAIDERBase.getPSSysEAIElementREId() != null)) {
            iDataObject.set(FIELD_PSSYSEAIELEMENTREID, (Object)pSSysEAIDERBase.getPSSysEAIElementREId());
        }
        if (pSSysEAIDERBase.isPSSysEAIElementRENameDirty() && (bl || pSSysEAIDERBase.getPSSysEAIElementREName() != null)) {
            iDataObject.set(FIELD_PSSYSEAIELEMENTRENAME, (Object)pSSysEAIDERBase.getPSSysEAIElementREName());
        }
        if (pSSysEAIDERBase.isUpdateDateDirty() && (bl || pSSysEAIDERBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysEAIDERBase.getUpdateDate());
        }
        if (pSSysEAIDERBase.isUpdateManDirty() && (bl || pSSysEAIDERBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysEAIDERBase.getUpdateMan());
        }
        if (pSSysEAIDERBase.isUserCatDirty() && (bl || pSSysEAIDERBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysEAIDERBase.getUserCat());
        }
        if (pSSysEAIDERBase.isUserTagDirty() && (bl || pSSysEAIDERBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysEAIDERBase.getUserTag());
        }
        if (pSSysEAIDERBase.isUserTag2Dirty() && (bl || pSSysEAIDERBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysEAIDERBase.getUserTag2());
        }
        if (pSSysEAIDERBase.isUserTag3Dirty() && (bl || pSSysEAIDERBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysEAIDERBase.getUserTag3());
        }
        if (pSSysEAIDERBase.isUserTag4Dirty() && (bl || pSSysEAIDERBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysEAIDERBase.getUserTag4());
        }
        if (pSSysEAIDERBase.isValidFlagDirty() && (bl || pSSysEAIDERBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysEAIDERBase.getValidFlag());
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
        return PSSysEAIDERBase.remove(this, n);
    }

    private static boolean remove(PSSysEAIDERBase pSSysEAIDERBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysEAIDERBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysEAIDERBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysEAIDERBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysEAIDERBase.resetEAIDERTag();
                return true;
            }
            case 4: {
                pSSysEAIDERBase.resetEAIDERTag2();
                return true;
            }
            case 5: {
                pSSysEAIDERBase.resetMemo();
                return true;
            }
            case 6: {
                pSSysEAIDERBase.resetPSDEId();
                return true;
            }
            case 7: {
                pSSysEAIDERBase.resetPSDERId();
                return true;
            }
            case 8: {
                pSSysEAIDERBase.resetPSDERName();
                return true;
            }
            case 9: {
                pSSysEAIDERBase.resetPSSysEAIDEId();
                return true;
            }
            case 10: {
                pSSysEAIDERBase.resetPSSysEAIDEName();
                return true;
            }
            case 11: {
                pSSysEAIDERBase.resetPSSysEAIDERId();
                return true;
            }
            case 12: {
                pSSysEAIDERBase.resetPSSysEAIDERName();
                return true;
            }
            case 13: {
                pSSysEAIDERBase.resetPSSysEAIElementId();
                return true;
            }
            case 14: {
                pSSysEAIDERBase.resetPSSysEAIElementREId();
                return true;
            }
            case 15: {
                pSSysEAIDERBase.resetPSSysEAIElementREName();
                return true;
            }
            case 16: {
                pSSysEAIDERBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSSysEAIDERBase.resetUpdateMan();
                return true;
            }
            case 18: {
                pSSysEAIDERBase.resetUserCat();
                return true;
            }
            case 19: {
                pSSysEAIDERBase.resetUserTag();
                return true;
            }
            case 20: {
                pSSysEAIDERBase.resetUserTag2();
                return true;
            }
            case 21: {
                pSSysEAIDERBase.resetUserTag3();
                return true;
            }
            case 22: {
                pSSysEAIDERBase.resetUserTag4();
                return true;
            }
            case 23: {
                pSSysEAIDERBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDER getPSDER() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDER();
        }
        if (this.getPSDERId() == null) {
            return null;
        }
        Integer n = this.objPSDERLock;
        synchronized (n) {
            if (this.psder != null && DataTypeHelper.compare((int)25, (Object)this.getPSDERId(), (Object)this.psder.getPSDERId()) != 0L) {
                this.psder = null;
            }
            if (this.psder == null) {
                PSDER pSDER = new PSDER();
                pSDER.setPSDERId(this.getPSDERId());
                PSDERService pSDERService = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
                pSDERService.autoGet(pSDER);
                this.psder = pSDER;
            }
            return this.psder;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysEAIDE getPSSysEAIDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIDE();
        }
        if (this.getPSSysEAIDEId() == null) {
            return null;
        }
        Integer n = this.objPSSysEAIDELock;
        synchronized (n) {
            if (this.pssyseaide != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysEAIDEId(), (Object)this.pssyseaide.getPSSysEAIDEId()) != 0L) {
                this.pssyseaide = null;
            }
            if (this.pssyseaide == null) {
                PSSysEAIDE pSSysEAIDE = new PSSysEAIDE();
                pSSysEAIDE.setPSSysEAIDEId(this.getPSSysEAIDEId());
                PSSysEAIDEService pSSysEAIDEService = (PSSysEAIDEService)ServiceGlobal.getService(PSSysEAIDEService.class, (SessionFactory)this.getSessionFactory());
                pSSysEAIDEService.autoGet(pSSysEAIDE);
                this.pssyseaide = pSSysEAIDE;
            }
            return this.pssyseaide;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysEAIElementRE getPSSysEAIElementRE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIElementRE();
        }
        if (this.getPSSysEAIElementREId() == null) {
            return null;
        }
        Integer n = this.objPSSysEAIElementRELock;
        synchronized (n) {
            if (this.pssyseaielementre != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysEAIElementREId(), (Object)this.pssyseaielementre.getPSSysEAIElementREId()) != 0L) {
                this.pssyseaielementre = null;
            }
            if (this.pssyseaielementre == null) {
                PSSysEAIElementRE pSSysEAIElementRE = new PSSysEAIElementRE();
                pSSysEAIElementRE.setPSSysEAIElementREId(this.getPSSysEAIElementREId());
                PSSysEAIElementREService pSSysEAIElementREService = (PSSysEAIElementREService)ServiceGlobal.getService(PSSysEAIElementREService.class, (SessionFactory)this.getSessionFactory());
                pSSysEAIElementREService.autoGet(pSSysEAIElementRE);
                this.pssyseaielementre = pSSysEAIElementRE;
            }
            return this.pssyseaielementre;
        }
    }

    private PSSysEAIDERBase getProxyEntity() {
        return this.proxyPSSysEAIDERBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysEAIDERBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysEAIDERBase) {
            this.proxyPSSysEAIDERBase = (PSSysEAIDERBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDERService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_EAIDERTAG, 3);
        fieldIndexMap.put(FIELD_EAIDERTAG2, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSDEID, 6);
        fieldIndexMap.put(FIELD_PSDERID, 7);
        fieldIndexMap.put(FIELD_PSDERNAME, 8);
        fieldIndexMap.put(FIELD_PSSYSEAIDEID, 9);
        fieldIndexMap.put(FIELD_PSSYSEAIDENAME, 10);
        fieldIndexMap.put(FIELD_PSSYSEAIDERID, 11);
        fieldIndexMap.put(FIELD_PSSYSEAIDERNAME, 12);
        fieldIndexMap.put(FIELD_PSSYSEAIELEMENTID, 13);
        fieldIndexMap.put(FIELD_PSSYSEAIELEMENTREID, 14);
        fieldIndexMap.put(FIELD_PSSYSEAIELEMENTRENAME, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
        fieldIndexMap.put(FIELD_USERCAT, 18);
        fieldIndexMap.put(FIELD_USERTAG, 19);
        fieldIndexMap.put(FIELD_USERTAG2, 20);
        fieldIndexMap.put(FIELD_USERTAG3, 21);
        fieldIndexMap.put(FIELD_USERTAG4, 22);
        fieldIndexMap.put(FIELD_VALIDFLAG, 23);
    }
}

