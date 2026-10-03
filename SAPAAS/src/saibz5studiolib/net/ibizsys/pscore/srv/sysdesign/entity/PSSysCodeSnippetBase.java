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
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.service.PSPFService;
import net.ibizsys.pscore.srv.config.service.PSPFStyleService;
import net.ibizsys.pscore.srv.config.service.PSSFService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCCodeSnippet;
import net.ibizsys.pscore.srv.devcenter.service.PSDCCodeSnippetService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysCodeSnippetBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysCodeSnippetBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CODEREFMODE = "CODEREFMODE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCCODESNIPPETID = "PSDCCODESNIPPETID";
    public static final String FIELD_PSDCCODESNIPPETNAME = "PSDCCODESNIPPETNAME";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFNAME = "PSPFNAME";
    public static final String FIELD_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String FIELD_PSPFSTYLENAME = "PSPFSTYLENAME";
    public static final String FIELD_PSSFID = "PSSFID";
    public static final String FIELD_PSSFNAME = "PSSFNAME";
    public static final String FIELD_PSSFSTYLEID = "PSSFSTYLEID";
    public static final String FIELD_PSSFSTYLENAME = "PSSFSTYLENAME";
    public static final String FIELD_PSSYSCODESNIPPETID = "PSSYSCODESNIPPETID";
    public static final String FIELD_PSSYSCODESNIPPETNAME = "PSSYSCODESNIPPETNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_TEMPLTYPE = "TEMPLTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CODEREFMODE = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSDCCODESNIPPETID = 5;
    private static final int INDEX_PSDCCODESNIPPETNAME = 6;
    private static final int INDEX_PSPFID = 7;
    private static final int INDEX_PSPFNAME = 8;
    private static final int INDEX_PSPFSTYLEID = 9;
    private static final int INDEX_PSPFSTYLENAME = 10;
    private static final int INDEX_PSSFID = 11;
    private static final int INDEX_PSSFNAME = 12;
    private static final int INDEX_PSSFSTYLEID = 13;
    private static final int INDEX_PSSFSTYLENAME = 14;
    private static final int INDEX_PSSYSCODESNIPPETID = 15;
    private static final int INDEX_PSSYSCODESNIPPETNAME = 16;
    private static final int INDEX_PSSYSTEMID = 17;
    private static final int INDEX_PSSYSTEMNAME = 18;
    private static final int INDEX_TEMPLTYPE = 19;
    private static final int INDEX_UPDATEDATE = 20;
    private static final int INDEX_UPDATEMAN = 21;
    private static final int INDEX_USERCAT = 22;
    private static final int INDEX_USERTAG = 23;
    private static final int INDEX_USERTAG2 = 24;
    private static final int INDEX_USERTAG3 = 25;
    private static final int INDEX_USERTAG4 = 26;
    private static final int INDEX_VALIDFLAG = 27;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysCodeSnippetBase proxyPSSysCodeSnippetBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean coderefmodeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdccodesnippetidDirtyFlag = false;
    private boolean psdccodesnippetnameDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfnameDirtyFlag = false;
    private boolean pspfstyleidDirtyFlag = false;
    private boolean pspfstylenameDirtyFlag = false;
    private boolean pssfidDirtyFlag = false;
    private boolean pssfnameDirtyFlag = false;
    private boolean pssfstyleidDirtyFlag = false;
    private boolean pssfstylenameDirtyFlag = false;
    private boolean pssyscodesnippetidDirtyFlag = false;
    private boolean pssyscodesnippetnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean templtypeDirtyFlag = false;
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
    @Column(name="coderefmode")
    private String coderefmode;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdccodesnippetid")
    private String psdccodesnippetid;
    @Column(name="psdccodesnippetname")
    private String psdccodesnippetname;
    @Column(name="pspfid")
    private String pspfid;
    @Column(name="pspfname")
    private String pspfname;
    @Column(name="pspfstyleid")
    private String pspfstyleid;
    @Column(name="pspfstylename")
    private String pspfstylename;
    @Column(name="pssfid")
    private String pssfid;
    @Column(name="pssfname")
    private String pssfname;
    @Column(name="pssfstyleid")
    private String pssfstyleid;
    @Column(name="pssfstylename")
    private String pssfstylename;
    @Column(name="pssyscodesnippetid")
    private String pssyscodesnippetid;
    @Column(name="pssyscodesnippetname")
    private String pssyscodesnippetname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="templtype")
    private String templtype;
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
    private Integer objPSDCCodeSnippetLock = new Integer(1);
    private PSDCCodeSnippet psdccodesnippet = null;
    private Integer objPSPFStyleLock = new Integer(1);
    private PSPFStyle pspfstyle = null;
    private Integer objPSPFLock = new Integer(1);
    private PSPF pspf = null;
    private Integer objPSSFStyleLock = new Integer(1);
    private PSSFStyle pssfstyle = null;
    private Integer objPSSFLock = new Integer(1);
    private PSSF pssf = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

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

    public void setCodeRefMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeRefMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.coderefmode = string;
        this.coderefmodeDirtyFlag = true;
    }

    public String getCodeRefMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeRefMode();
        }
        return this.coderefmode;
    }

    public boolean isCodeRefModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeRefModeDirty();
        }
        return this.coderefmodeDirtyFlag;
    }

    public void resetCodeRefMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeRefMode();
            return;
        }
        this.coderefmodeDirtyFlag = false;
        this.coderefmode = null;
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

    public void setPSDCCodeSnippetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCCodeSnippetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdccodesnippetid = string;
        this.psdccodesnippetidDirtyFlag = true;
    }

    public String getPSDCCodeSnippetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCCodeSnippetId();
        }
        return this.psdccodesnippetid;
    }

    public boolean isPSDCCodeSnippetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCCodeSnippetIdDirty();
        }
        return this.psdccodesnippetidDirtyFlag;
    }

    public void resetPSDCCodeSnippetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCCodeSnippetId();
            return;
        }
        this.psdccodesnippetidDirtyFlag = false;
        this.psdccodesnippetid = null;
    }

    public void setPSDCCodeSnippetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCCodeSnippetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdccodesnippetname = string;
        this.psdccodesnippetnameDirtyFlag = true;
    }

    public String getPSDCCodeSnippetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCCodeSnippetName();
        }
        return this.psdccodesnippetname;
    }

    public boolean isPSDCCodeSnippetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCCodeSnippetNameDirty();
        }
        return this.psdccodesnippetnameDirtyFlag;
    }

    public void resetPSDCCodeSnippetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCCodeSnippetName();
            return;
        }
        this.psdccodesnippetnameDirtyFlag = false;
        this.psdccodesnippetname = null;
    }

    public void setPSPFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfid = string;
        this.pspfidDirtyFlag = true;
    }

    public String getPSPFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFId();
        }
        return this.pspfid;
    }

    public boolean isPSPFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFIdDirty();
        }
        return this.pspfidDirtyFlag;
    }

    public void resetPSPFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFId();
            return;
        }
        this.pspfidDirtyFlag = false;
        this.pspfid = null;
    }

    public void setPSPFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfname = string;
        this.pspfnameDirtyFlag = true;
    }

    public String getPSPFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFName();
        }
        return this.pspfname;
    }

    public boolean isPSPFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFNameDirty();
        }
        return this.pspfnameDirtyFlag;
    }

    public void resetPSPFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFName();
            return;
        }
        this.pspfnameDirtyFlag = false;
        this.pspfname = null;
    }

    public void setPSPFStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfstyleid = string;
        this.pspfstyleidDirtyFlag = true;
    }

    public String getPSPFStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyleId();
        }
        return this.pspfstyleid;
    }

    public boolean isPSPFStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFStyleIdDirty();
        }
        return this.pspfstyleidDirtyFlag;
    }

    public void resetPSPFStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFStyleId();
            return;
        }
        this.pspfstyleidDirtyFlag = false;
        this.pspfstyleid = null;
    }

    public void setPSPFStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfstylename = string;
        this.pspfstylenameDirtyFlag = true;
    }

    public String getPSPFStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyleName();
        }
        return this.pspfstylename;
    }

    public boolean isPSPFStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFStyleNameDirty();
        }
        return this.pspfstylenameDirtyFlag;
    }

    public void resetPSPFStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFStyleName();
            return;
        }
        this.pspfstylenameDirtyFlag = false;
        this.pspfstylename = null;
    }

    public void setPSSFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfid = string;
        this.pssfidDirtyFlag = true;
    }

    public String getPSSFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFId();
        }
        return this.pssfid;
    }

    public boolean isPSSFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFIdDirty();
        }
        return this.pssfidDirtyFlag;
    }

    public void resetPSSFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFId();
            return;
        }
        this.pssfidDirtyFlag = false;
        this.pssfid = null;
    }

    public void setPSSFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfname = string;
        this.pssfnameDirtyFlag = true;
    }

    public String getPSSFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFName();
        }
        return this.pssfname;
    }

    public boolean isPSSFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFNameDirty();
        }
        return this.pssfnameDirtyFlag;
    }

    public void resetPSSFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFName();
            return;
        }
        this.pssfnameDirtyFlag = false;
        this.pssfname = null;
    }

    public void setPSSFStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstyleid = string;
        this.pssfstyleidDirtyFlag = true;
    }

    public String getPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleId();
        }
        return this.pssfstyleid;
    }

    public boolean isPSSFStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleIdDirty();
        }
        return this.pssfstyleidDirtyFlag;
    }

    public void resetPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleId();
            return;
        }
        this.pssfstyleidDirtyFlag = false;
        this.pssfstyleid = null;
    }

    public void setPSSFStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstylename = string;
        this.pssfstylenameDirtyFlag = true;
    }

    public String getPSSFStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleName();
        }
        return this.pssfstylename;
    }

    public boolean isPSSFStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleNameDirty();
        }
        return this.pssfstylenameDirtyFlag;
    }

    public void resetPSSFStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleName();
            return;
        }
        this.pssfstylenameDirtyFlag = false;
        this.pssfstylename = null;
    }

    public void setPSSysCodeSnippetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCodeSnippetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscodesnippetid = string;
        this.pssyscodesnippetidDirtyFlag = true;
    }

    public String getPSSysCodeSnippetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCodeSnippetId();
        }
        return this.pssyscodesnippetid;
    }

    public boolean isPSSysCodeSnippetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCodeSnippetIdDirty();
        }
        return this.pssyscodesnippetidDirtyFlag;
    }

    public void resetPSSysCodeSnippetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCodeSnippetId();
            return;
        }
        this.pssyscodesnippetidDirtyFlag = false;
        this.pssyscodesnippetid = null;
    }

    public void setPSSysCodeSnippetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCodeSnippetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscodesnippetname = string;
        this.pssyscodesnippetnameDirtyFlag = true;
    }

    public String getPSSysCodeSnippetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCodeSnippetName();
        }
        return this.pssyscodesnippetname;
    }

    public boolean isPSSysCodeSnippetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCodeSnippetNameDirty();
        }
        return this.pssyscodesnippetnameDirtyFlag;
    }

    public void resetPSSysCodeSnippetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCodeSnippetName();
            return;
        }
        this.pssyscodesnippetnameDirtyFlag = false;
        this.pssyscodesnippetname = null;
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

    public void setTemplType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templtype = string;
        this.templtypeDirtyFlag = true;
    }

    public String getTemplType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplType();
        }
        return this.templtype;
    }

    public boolean isTemplTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplTypeDirty();
        }
        return this.templtypeDirtyFlag;
    }

    public void resetTemplType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplType();
            return;
        }
        this.templtypeDirtyFlag = false;
        this.templtype = null;
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
        PSSysCodeSnippetBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysCodeSnippetBase pSSysCodeSnippetBase) {
        pSSysCodeSnippetBase.resetCodeName();
        pSSysCodeSnippetBase.resetCodeRefMode();
        pSSysCodeSnippetBase.resetCreateDate();
        pSSysCodeSnippetBase.resetCreateMan();
        pSSysCodeSnippetBase.resetMemo();
        pSSysCodeSnippetBase.resetPSDCCodeSnippetId();
        pSSysCodeSnippetBase.resetPSDCCodeSnippetName();
        pSSysCodeSnippetBase.resetPSPFId();
        pSSysCodeSnippetBase.resetPSPFName();
        pSSysCodeSnippetBase.resetPSPFStyleId();
        pSSysCodeSnippetBase.resetPSPFStyleName();
        pSSysCodeSnippetBase.resetPSSFId();
        pSSysCodeSnippetBase.resetPSSFName();
        pSSysCodeSnippetBase.resetPSSFStyleId();
        pSSysCodeSnippetBase.resetPSSFStyleName();
        pSSysCodeSnippetBase.resetPSSysCodeSnippetId();
        pSSysCodeSnippetBase.resetPSSysCodeSnippetName();
        pSSysCodeSnippetBase.resetPSSystemId();
        pSSysCodeSnippetBase.resetPSSystemName();
        pSSysCodeSnippetBase.resetTemplType();
        pSSysCodeSnippetBase.resetUpdateDate();
        pSSysCodeSnippetBase.resetUpdateMan();
        pSSysCodeSnippetBase.resetUserCat();
        pSSysCodeSnippetBase.resetUserTag();
        pSSysCodeSnippetBase.resetUserTag2();
        pSSysCodeSnippetBase.resetUserTag3();
        pSSysCodeSnippetBase.resetUserTag4();
        pSSysCodeSnippetBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCodeRefModeDirty()) {
            hashMap.put(FIELD_CODEREFMODE, this.getCodeRefMode());
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
        if (!bl || this.isPSDCCodeSnippetIdDirty()) {
            hashMap.put(FIELD_PSDCCODESNIPPETID, this.getPSDCCodeSnippetId());
        }
        if (!bl || this.isPSDCCodeSnippetNameDirty()) {
            hashMap.put(FIELD_PSDCCODESNIPPETNAME, this.getPSDCCodeSnippetName());
        }
        if (!bl || this.isPSPFIdDirty()) {
            hashMap.put(FIELD_PSPFID, this.getPSPFId());
        }
        if (!bl || this.isPSPFNameDirty()) {
            hashMap.put(FIELD_PSPFNAME, this.getPSPFName());
        }
        if (!bl || this.isPSPFStyleIdDirty()) {
            hashMap.put(FIELD_PSPFSTYLEID, this.getPSPFStyleId());
        }
        if (!bl || this.isPSPFStyleNameDirty()) {
            hashMap.put(FIELD_PSPFSTYLENAME, this.getPSPFStyleName());
        }
        if (!bl || this.isPSSFIdDirty()) {
            hashMap.put(FIELD_PSSFID, this.getPSSFId());
        }
        if (!bl || this.isPSSFNameDirty()) {
            hashMap.put(FIELD_PSSFNAME, this.getPSSFName());
        }
        if (!bl || this.isPSSFStyleIdDirty()) {
            hashMap.put(FIELD_PSSFSTYLEID, this.getPSSFStyleId());
        }
        if (!bl || this.isPSSFStyleNameDirty()) {
            hashMap.put(FIELD_PSSFSTYLENAME, this.getPSSFStyleName());
        }
        if (!bl || this.isPSSysCodeSnippetIdDirty()) {
            hashMap.put(FIELD_PSSYSCODESNIPPETID, this.getPSSysCodeSnippetId());
        }
        if (!bl || this.isPSSysCodeSnippetNameDirty()) {
            hashMap.put(FIELD_PSSYSCODESNIPPETNAME, this.getPSSysCodeSnippetName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isTemplTypeDirty()) {
            hashMap.put(FIELD_TEMPLTYPE, this.getTemplType());
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
        return PSSysCodeSnippetBase.get(this, n);
    }

    private static Object get(PSSysCodeSnippetBase pSSysCodeSnippetBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysCodeSnippetBase.getCodeName();
            }
            case 1: {
                return pSSysCodeSnippetBase.getCodeRefMode();
            }
            case 2: {
                return pSSysCodeSnippetBase.getCreateDate();
            }
            case 3: {
                return pSSysCodeSnippetBase.getCreateMan();
            }
            case 4: {
                return pSSysCodeSnippetBase.getMemo();
            }
            case 5: {
                return pSSysCodeSnippetBase.getPSDCCodeSnippetId();
            }
            case 6: {
                return pSSysCodeSnippetBase.getPSDCCodeSnippetName();
            }
            case 7: {
                return pSSysCodeSnippetBase.getPSPFId();
            }
            case 8: {
                return pSSysCodeSnippetBase.getPSPFName();
            }
            case 9: {
                return pSSysCodeSnippetBase.getPSPFStyleId();
            }
            case 10: {
                return pSSysCodeSnippetBase.getPSPFStyleName();
            }
            case 11: {
                return pSSysCodeSnippetBase.getPSSFId();
            }
            case 12: {
                return pSSysCodeSnippetBase.getPSSFName();
            }
            case 13: {
                return pSSysCodeSnippetBase.getPSSFStyleId();
            }
            case 14: {
                return pSSysCodeSnippetBase.getPSSFStyleName();
            }
            case 15: {
                return pSSysCodeSnippetBase.getPSSysCodeSnippetId();
            }
            case 16: {
                return pSSysCodeSnippetBase.getPSSysCodeSnippetName();
            }
            case 17: {
                return pSSysCodeSnippetBase.getPSSystemId();
            }
            case 18: {
                return pSSysCodeSnippetBase.getPSSystemName();
            }
            case 19: {
                return pSSysCodeSnippetBase.getTemplType();
            }
            case 20: {
                return pSSysCodeSnippetBase.getUpdateDate();
            }
            case 21: {
                return pSSysCodeSnippetBase.getUpdateMan();
            }
            case 22: {
                return pSSysCodeSnippetBase.getUserCat();
            }
            case 23: {
                return pSSysCodeSnippetBase.getUserTag();
            }
            case 24: {
                return pSSysCodeSnippetBase.getUserTag2();
            }
            case 25: {
                return pSSysCodeSnippetBase.getUserTag3();
            }
            case 26: {
                return pSSysCodeSnippetBase.getUserTag4();
            }
            case 27: {
                return pSSysCodeSnippetBase.getValidFlag();
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
        PSSysCodeSnippetBase.set(this, n, object);
    }

    private static void set(PSSysCodeSnippetBase pSSysCodeSnippetBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysCodeSnippetBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysCodeSnippetBase.setCodeRefMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysCodeSnippetBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSSysCodeSnippetBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysCodeSnippetBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysCodeSnippetBase.setPSDCCodeSnippetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysCodeSnippetBase.setPSDCCodeSnippetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysCodeSnippetBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysCodeSnippetBase.setPSPFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysCodeSnippetBase.setPSPFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysCodeSnippetBase.setPSPFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysCodeSnippetBase.setPSSFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysCodeSnippetBase.setPSSFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysCodeSnippetBase.setPSSFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysCodeSnippetBase.setPSSFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysCodeSnippetBase.setPSSysCodeSnippetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysCodeSnippetBase.setPSSysCodeSnippetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysCodeSnippetBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysCodeSnippetBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysCodeSnippetBase.setTemplType(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysCodeSnippetBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 21: {
                pSSysCodeSnippetBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysCodeSnippetBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysCodeSnippetBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysCodeSnippetBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysCodeSnippetBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysCodeSnippetBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysCodeSnippetBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysCodeSnippetBase.isNull(this, n);
    }

    private static boolean isNull(PSSysCodeSnippetBase pSSysCodeSnippetBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysCodeSnippetBase.getCodeName() == null;
            }
            case 1: {
                return pSSysCodeSnippetBase.getCodeRefMode() == null;
            }
            case 2: {
                return pSSysCodeSnippetBase.getCreateDate() == null;
            }
            case 3: {
                return pSSysCodeSnippetBase.getCreateMan() == null;
            }
            case 4: {
                return pSSysCodeSnippetBase.getMemo() == null;
            }
            case 5: {
                return pSSysCodeSnippetBase.getPSDCCodeSnippetId() == null;
            }
            case 6: {
                return pSSysCodeSnippetBase.getPSDCCodeSnippetName() == null;
            }
            case 7: {
                return pSSysCodeSnippetBase.getPSPFId() == null;
            }
            case 8: {
                return pSSysCodeSnippetBase.getPSPFName() == null;
            }
            case 9: {
                return pSSysCodeSnippetBase.getPSPFStyleId() == null;
            }
            case 10: {
                return pSSysCodeSnippetBase.getPSPFStyleName() == null;
            }
            case 11: {
                return pSSysCodeSnippetBase.getPSSFId() == null;
            }
            case 12: {
                return pSSysCodeSnippetBase.getPSSFName() == null;
            }
            case 13: {
                return pSSysCodeSnippetBase.getPSSFStyleId() == null;
            }
            case 14: {
                return pSSysCodeSnippetBase.getPSSFStyleName() == null;
            }
            case 15: {
                return pSSysCodeSnippetBase.getPSSysCodeSnippetId() == null;
            }
            case 16: {
                return pSSysCodeSnippetBase.getPSSysCodeSnippetName() == null;
            }
            case 17: {
                return pSSysCodeSnippetBase.getPSSystemId() == null;
            }
            case 18: {
                return pSSysCodeSnippetBase.getPSSystemName() == null;
            }
            case 19: {
                return pSSysCodeSnippetBase.getTemplType() == null;
            }
            case 20: {
                return pSSysCodeSnippetBase.getUpdateDate() == null;
            }
            case 21: {
                return pSSysCodeSnippetBase.getUpdateMan() == null;
            }
            case 22: {
                return pSSysCodeSnippetBase.getUserCat() == null;
            }
            case 23: {
                return pSSysCodeSnippetBase.getUserTag() == null;
            }
            case 24: {
                return pSSysCodeSnippetBase.getUserTag2() == null;
            }
            case 25: {
                return pSSysCodeSnippetBase.getUserTag3() == null;
            }
            case 26: {
                return pSSysCodeSnippetBase.getUserTag4() == null;
            }
            case 27: {
                return pSSysCodeSnippetBase.getValidFlag() == null;
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
        return PSSysCodeSnippetBase.contains(this, n);
    }

    private static boolean contains(PSSysCodeSnippetBase pSSysCodeSnippetBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysCodeSnippetBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysCodeSnippetBase.isCodeRefModeDirty();
            }
            case 2: {
                return pSSysCodeSnippetBase.isCreateDateDirty();
            }
            case 3: {
                return pSSysCodeSnippetBase.isCreateManDirty();
            }
            case 4: {
                return pSSysCodeSnippetBase.isMemoDirty();
            }
            case 5: {
                return pSSysCodeSnippetBase.isPSDCCodeSnippetIdDirty();
            }
            case 6: {
                return pSSysCodeSnippetBase.isPSDCCodeSnippetNameDirty();
            }
            case 7: {
                return pSSysCodeSnippetBase.isPSPFIdDirty();
            }
            case 8: {
                return pSSysCodeSnippetBase.isPSPFNameDirty();
            }
            case 9: {
                return pSSysCodeSnippetBase.isPSPFStyleIdDirty();
            }
            case 10: {
                return pSSysCodeSnippetBase.isPSPFStyleNameDirty();
            }
            case 11: {
                return pSSysCodeSnippetBase.isPSSFIdDirty();
            }
            case 12: {
                return pSSysCodeSnippetBase.isPSSFNameDirty();
            }
            case 13: {
                return pSSysCodeSnippetBase.isPSSFStyleIdDirty();
            }
            case 14: {
                return pSSysCodeSnippetBase.isPSSFStyleNameDirty();
            }
            case 15: {
                return pSSysCodeSnippetBase.isPSSysCodeSnippetIdDirty();
            }
            case 16: {
                return pSSysCodeSnippetBase.isPSSysCodeSnippetNameDirty();
            }
            case 17: {
                return pSSysCodeSnippetBase.isPSSystemIdDirty();
            }
            case 18: {
                return pSSysCodeSnippetBase.isPSSystemNameDirty();
            }
            case 19: {
                return pSSysCodeSnippetBase.isTemplTypeDirty();
            }
            case 20: {
                return pSSysCodeSnippetBase.isUpdateDateDirty();
            }
            case 21: {
                return pSSysCodeSnippetBase.isUpdateManDirty();
            }
            case 22: {
                return pSSysCodeSnippetBase.isUserCatDirty();
            }
            case 23: {
                return pSSysCodeSnippetBase.isUserTagDirty();
            }
            case 24: {
                return pSSysCodeSnippetBase.isUserTag2Dirty();
            }
            case 25: {
                return pSSysCodeSnippetBase.isUserTag3Dirty();
            }
            case 26: {
                return pSSysCodeSnippetBase.isUserTag4Dirty();
            }
            case 27: {
                return pSSysCodeSnippetBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysCodeSnippetBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysCodeSnippetBase pSSysCodeSnippetBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysCodeSnippetBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysCodeSnippetBase.getJSONValue((Object)pSSysCodeSnippetBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysCodeSnippetBase.getCodeRefMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"coderefmode", (Object)PSSysCodeSnippetBase.getJSONValue((Object)pSSysCodeSnippetBase.getCodeRefMode()), (boolean)false);
        }
        if (bl || pSSysCodeSnippetBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysCodeSnippetBase.getJSONValue((Object)pSSysCodeSnippetBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysCodeSnippetBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysCodeSnippetBase.getJSONValue((Object)pSSysCodeSnippetBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysCodeSnippetBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysCodeSnippetBase.getJSONValue((Object)pSSysCodeSnippetBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysCodeSnippetBase.getPSDCCodeSnippetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccodesnippetid", (Object)PSSysCodeSnippetBase.getJSONValue((Object)pSSysCodeSnippetBase.getPSDCCodeSnippetId()), (boolean)false);
        }
        if (bl || pSSysCodeSnippetBase.getPSDCCodeSnippetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccodesnippetname", (Object)PSSysCodeSnippetBase.getJSONValue((Object)pSSysCodeSnippetBase.getPSDCCodeSnippetName()), (boolean)false);
        }
        if (bl || pSSysCodeSnippetBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSSysCodeSnippetBase.getJSONValue((Object)pSSysCodeSnippetBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSSysCodeSnippetBase.getPSPFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfname", (Object)PSSysCodeSnippetBase.getJSONValue((Object)pSSysCodeSnippetBase.getPSPFName()), (boolean)false);
        }
        if (bl || pSSysCodeSnippetBase.getPSPFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstyleid", (Object)PSSysCodeSnippetBase.getJSONValue((Object)pSSysCodeSnippetBase.getPSPFStyleId()), (boolean)false);
        }
        if (bl || pSSysCodeSnippetBase.getPSPFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstylename", (Object)PSSysCodeSnippetBase.getJSONValue((Object)pSSysCodeSnippetBase.getPSPFStyleName()), (boolean)false);
        }
        if (bl || pSSysCodeSnippetBase.getPSSFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfid", (Object)PSSysCodeSnippetBase.getJSONValue((Object)pSSysCodeSnippetBase.getPSSFId()), (boolean)false);
        }
        if (bl || pSSysCodeSnippetBase.getPSSFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfname", (Object)PSSysCodeSnippetBase.getJSONValue((Object)pSSysCodeSnippetBase.getPSSFName()), (boolean)false);
        }
        if (bl || pSSysCodeSnippetBase.getPSSFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstyleid", (Object)PSSysCodeSnippetBase.getJSONValue((Object)pSSysCodeSnippetBase.getPSSFStyleId()), (boolean)false);
        }
        if (bl || pSSysCodeSnippetBase.getPSSFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstylename", (Object)PSSysCodeSnippetBase.getJSONValue((Object)pSSysCodeSnippetBase.getPSSFStyleName()), (boolean)false);
        }
        if (bl || pSSysCodeSnippetBase.getPSSysCodeSnippetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscodesnippetid", (Object)PSSysCodeSnippetBase.getJSONValue((Object)pSSysCodeSnippetBase.getPSSysCodeSnippetId()), (boolean)false);
        }
        if (bl || pSSysCodeSnippetBase.getPSSysCodeSnippetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscodesnippetname", (Object)PSSysCodeSnippetBase.getJSONValue((Object)pSSysCodeSnippetBase.getPSSysCodeSnippetName()), (boolean)false);
        }
        if (bl || pSSysCodeSnippetBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysCodeSnippetBase.getJSONValue((Object)pSSysCodeSnippetBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysCodeSnippetBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysCodeSnippetBase.getJSONValue((Object)pSSysCodeSnippetBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysCodeSnippetBase.getTemplType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templtype", (Object)PSSysCodeSnippetBase.getJSONValue((Object)pSSysCodeSnippetBase.getTemplType()), (boolean)false);
        }
        if (bl || pSSysCodeSnippetBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysCodeSnippetBase.getJSONValue((Object)pSSysCodeSnippetBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysCodeSnippetBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysCodeSnippetBase.getJSONValue((Object)pSSysCodeSnippetBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysCodeSnippetBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysCodeSnippetBase.getJSONValue((Object)pSSysCodeSnippetBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysCodeSnippetBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysCodeSnippetBase.getJSONValue((Object)pSSysCodeSnippetBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysCodeSnippetBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysCodeSnippetBase.getJSONValue((Object)pSSysCodeSnippetBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysCodeSnippetBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysCodeSnippetBase.getJSONValue((Object)pSSysCodeSnippetBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysCodeSnippetBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysCodeSnippetBase.getJSONValue((Object)pSSysCodeSnippetBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysCodeSnippetBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysCodeSnippetBase.getJSONValue((Object)pSSysCodeSnippetBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysCodeSnippetBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysCodeSnippetBase pSSysCodeSnippetBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysCodeSnippetBase.getCodeName() != null) {
            object = pSSysCodeSnippetBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSSysCodeSnippetBase.getCodeRefMode() != null) {
            object = pSSysCodeSnippetBase.getCodeRefMode();
            xmlNode.setAttribute(FIELD_CODEREFMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysCodeSnippetBase.getCreateDate() != null) {
            object = pSSysCodeSnippetBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysCodeSnippetBase.getCreateMan() != null) {
            object = pSSysCodeSnippetBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysCodeSnippetBase.getMemo() != null) {
            object = pSSysCodeSnippetBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysCodeSnippetBase.getPSDCCodeSnippetId() != null) {
            object = pSSysCodeSnippetBase.getPSDCCodeSnippetId();
            xmlNode.setAttribute(FIELD_PSDCCODESNIPPETID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCodeSnippetBase.getPSDCCodeSnippetName() != null) {
            object = pSSysCodeSnippetBase.getPSDCCodeSnippetName();
            xmlNode.setAttribute(FIELD_PSDCCODESNIPPETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCodeSnippetBase.getPSPFId() != null) {
            object = pSSysCodeSnippetBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCodeSnippetBase.getPSPFName() != null) {
            object = pSSysCodeSnippetBase.getPSPFName();
            xmlNode.setAttribute(FIELD_PSPFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCodeSnippetBase.getPSPFStyleId() != null) {
            object = pSSysCodeSnippetBase.getPSPFStyleId();
            xmlNode.setAttribute(FIELD_PSPFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCodeSnippetBase.getPSPFStyleName() != null) {
            object = pSSysCodeSnippetBase.getPSPFStyleName();
            xmlNode.setAttribute(FIELD_PSPFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCodeSnippetBase.getPSSFId() != null) {
            object = pSSysCodeSnippetBase.getPSSFId();
            xmlNode.setAttribute(FIELD_PSSFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCodeSnippetBase.getPSSFName() != null) {
            object = pSSysCodeSnippetBase.getPSSFName();
            xmlNode.setAttribute(FIELD_PSSFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCodeSnippetBase.getPSSFStyleId() != null) {
            object = pSSysCodeSnippetBase.getPSSFStyleId();
            xmlNode.setAttribute(FIELD_PSSFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCodeSnippetBase.getPSSFStyleName() != null) {
            object = pSSysCodeSnippetBase.getPSSFStyleName();
            xmlNode.setAttribute(FIELD_PSSFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCodeSnippetBase.getPSSysCodeSnippetId() != null) {
            object = pSSysCodeSnippetBase.getPSSysCodeSnippetId();
            xmlNode.setAttribute(FIELD_PSSYSCODESNIPPETID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCodeSnippetBase.getPSSysCodeSnippetName() != null) {
            object = pSSysCodeSnippetBase.getPSSysCodeSnippetName();
            xmlNode.setAttribute(FIELD_PSSYSCODESNIPPETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCodeSnippetBase.getPSSystemId() != null) {
            object = pSSysCodeSnippetBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCodeSnippetBase.getPSSystemName() != null) {
            object = pSSysCodeSnippetBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCodeSnippetBase.getTemplType() != null) {
            object = pSSysCodeSnippetBase.getTemplType();
            xmlNode.setAttribute(FIELD_TEMPLTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysCodeSnippetBase.getUpdateDate() != null) {
            object = pSSysCodeSnippetBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysCodeSnippetBase.getUpdateMan() != null) {
            object = pSSysCodeSnippetBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysCodeSnippetBase.getUserCat() != null) {
            object = pSSysCodeSnippetBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysCodeSnippetBase.getUserTag() != null) {
            object = pSSysCodeSnippetBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysCodeSnippetBase.getUserTag2() != null) {
            object = pSSysCodeSnippetBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysCodeSnippetBase.getUserTag3() != null) {
            object = pSSysCodeSnippetBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysCodeSnippetBase.getUserTag4() != null) {
            object = pSSysCodeSnippetBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysCodeSnippetBase.getValidFlag() != null) {
            object = pSSysCodeSnippetBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysCodeSnippetBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysCodeSnippetBase pSSysCodeSnippetBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysCodeSnippetBase.isCodeNameDirty() && (bl || pSSysCodeSnippetBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysCodeSnippetBase.getCodeName());
        }
        if (pSSysCodeSnippetBase.isCodeRefModeDirty() && (bl || pSSysCodeSnippetBase.getCodeRefMode() != null)) {
            iDataObject.set(FIELD_CODEREFMODE, (Object)pSSysCodeSnippetBase.getCodeRefMode());
        }
        if (pSSysCodeSnippetBase.isCreateDateDirty() && (bl || pSSysCodeSnippetBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysCodeSnippetBase.getCreateDate());
        }
        if (pSSysCodeSnippetBase.isCreateManDirty() && (bl || pSSysCodeSnippetBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysCodeSnippetBase.getCreateMan());
        }
        if (pSSysCodeSnippetBase.isMemoDirty() && (bl || pSSysCodeSnippetBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysCodeSnippetBase.getMemo());
        }
        if (pSSysCodeSnippetBase.isPSDCCodeSnippetIdDirty() && (bl || pSSysCodeSnippetBase.getPSDCCodeSnippetId() != null)) {
            iDataObject.set(FIELD_PSDCCODESNIPPETID, (Object)pSSysCodeSnippetBase.getPSDCCodeSnippetId());
        }
        if (pSSysCodeSnippetBase.isPSDCCodeSnippetNameDirty() && (bl || pSSysCodeSnippetBase.getPSDCCodeSnippetName() != null)) {
            iDataObject.set(FIELD_PSDCCODESNIPPETNAME, (Object)pSSysCodeSnippetBase.getPSDCCodeSnippetName());
        }
        if (pSSysCodeSnippetBase.isPSPFIdDirty() && (bl || pSSysCodeSnippetBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSSysCodeSnippetBase.getPSPFId());
        }
        if (pSSysCodeSnippetBase.isPSPFNameDirty() && (bl || pSSysCodeSnippetBase.getPSPFName() != null)) {
            iDataObject.set(FIELD_PSPFNAME, (Object)pSSysCodeSnippetBase.getPSPFName());
        }
        if (pSSysCodeSnippetBase.isPSPFStyleIdDirty() && (bl || pSSysCodeSnippetBase.getPSPFStyleId() != null)) {
            iDataObject.set(FIELD_PSPFSTYLEID, (Object)pSSysCodeSnippetBase.getPSPFStyleId());
        }
        if (pSSysCodeSnippetBase.isPSPFStyleNameDirty() && (bl || pSSysCodeSnippetBase.getPSPFStyleName() != null)) {
            iDataObject.set(FIELD_PSPFSTYLENAME, (Object)pSSysCodeSnippetBase.getPSPFStyleName());
        }
        if (pSSysCodeSnippetBase.isPSSFIdDirty() && (bl || pSSysCodeSnippetBase.getPSSFId() != null)) {
            iDataObject.set(FIELD_PSSFID, (Object)pSSysCodeSnippetBase.getPSSFId());
        }
        if (pSSysCodeSnippetBase.isPSSFNameDirty() && (bl || pSSysCodeSnippetBase.getPSSFName() != null)) {
            iDataObject.set(FIELD_PSSFNAME, (Object)pSSysCodeSnippetBase.getPSSFName());
        }
        if (pSSysCodeSnippetBase.isPSSFStyleIdDirty() && (bl || pSSysCodeSnippetBase.getPSSFStyleId() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEID, (Object)pSSysCodeSnippetBase.getPSSFStyleId());
        }
        if (pSSysCodeSnippetBase.isPSSFStyleNameDirty() && (bl || pSSysCodeSnippetBase.getPSSFStyleName() != null)) {
            iDataObject.set(FIELD_PSSFSTYLENAME, (Object)pSSysCodeSnippetBase.getPSSFStyleName());
        }
        if (pSSysCodeSnippetBase.isPSSysCodeSnippetIdDirty() && (bl || pSSysCodeSnippetBase.getPSSysCodeSnippetId() != null)) {
            iDataObject.set(FIELD_PSSYSCODESNIPPETID, (Object)pSSysCodeSnippetBase.getPSSysCodeSnippetId());
        }
        if (pSSysCodeSnippetBase.isPSSysCodeSnippetNameDirty() && (bl || pSSysCodeSnippetBase.getPSSysCodeSnippetName() != null)) {
            iDataObject.set(FIELD_PSSYSCODESNIPPETNAME, (Object)pSSysCodeSnippetBase.getPSSysCodeSnippetName());
        }
        if (pSSysCodeSnippetBase.isPSSystemIdDirty() && (bl || pSSysCodeSnippetBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysCodeSnippetBase.getPSSystemId());
        }
        if (pSSysCodeSnippetBase.isPSSystemNameDirty() && (bl || pSSysCodeSnippetBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysCodeSnippetBase.getPSSystemName());
        }
        if (pSSysCodeSnippetBase.isTemplTypeDirty() && (bl || pSSysCodeSnippetBase.getTemplType() != null)) {
            iDataObject.set(FIELD_TEMPLTYPE, (Object)pSSysCodeSnippetBase.getTemplType());
        }
        if (pSSysCodeSnippetBase.isUpdateDateDirty() && (bl || pSSysCodeSnippetBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysCodeSnippetBase.getUpdateDate());
        }
        if (pSSysCodeSnippetBase.isUpdateManDirty() && (bl || pSSysCodeSnippetBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysCodeSnippetBase.getUpdateMan());
        }
        if (pSSysCodeSnippetBase.isUserCatDirty() && (bl || pSSysCodeSnippetBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysCodeSnippetBase.getUserCat());
        }
        if (pSSysCodeSnippetBase.isUserTagDirty() && (bl || pSSysCodeSnippetBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysCodeSnippetBase.getUserTag());
        }
        if (pSSysCodeSnippetBase.isUserTag2Dirty() && (bl || pSSysCodeSnippetBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysCodeSnippetBase.getUserTag2());
        }
        if (pSSysCodeSnippetBase.isUserTag3Dirty() && (bl || pSSysCodeSnippetBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysCodeSnippetBase.getUserTag3());
        }
        if (pSSysCodeSnippetBase.isUserTag4Dirty() && (bl || pSSysCodeSnippetBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysCodeSnippetBase.getUserTag4());
        }
        if (pSSysCodeSnippetBase.isValidFlagDirty() && (bl || pSSysCodeSnippetBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysCodeSnippetBase.getValidFlag());
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
        return PSSysCodeSnippetBase.remove(this, n);
    }

    private static boolean remove(PSSysCodeSnippetBase pSSysCodeSnippetBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysCodeSnippetBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysCodeSnippetBase.resetCodeRefMode();
                return true;
            }
            case 2: {
                pSSysCodeSnippetBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSSysCodeSnippetBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSSysCodeSnippetBase.resetMemo();
                return true;
            }
            case 5: {
                pSSysCodeSnippetBase.resetPSDCCodeSnippetId();
                return true;
            }
            case 6: {
                pSSysCodeSnippetBase.resetPSDCCodeSnippetName();
                return true;
            }
            case 7: {
                pSSysCodeSnippetBase.resetPSPFId();
                return true;
            }
            case 8: {
                pSSysCodeSnippetBase.resetPSPFName();
                return true;
            }
            case 9: {
                pSSysCodeSnippetBase.resetPSPFStyleId();
                return true;
            }
            case 10: {
                pSSysCodeSnippetBase.resetPSPFStyleName();
                return true;
            }
            case 11: {
                pSSysCodeSnippetBase.resetPSSFId();
                return true;
            }
            case 12: {
                pSSysCodeSnippetBase.resetPSSFName();
                return true;
            }
            case 13: {
                pSSysCodeSnippetBase.resetPSSFStyleId();
                return true;
            }
            case 14: {
                pSSysCodeSnippetBase.resetPSSFStyleName();
                return true;
            }
            case 15: {
                pSSysCodeSnippetBase.resetPSSysCodeSnippetId();
                return true;
            }
            case 16: {
                pSSysCodeSnippetBase.resetPSSysCodeSnippetName();
                return true;
            }
            case 17: {
                pSSysCodeSnippetBase.resetPSSystemId();
                return true;
            }
            case 18: {
                pSSysCodeSnippetBase.resetPSSystemName();
                return true;
            }
            case 19: {
                pSSysCodeSnippetBase.resetTemplType();
                return true;
            }
            case 20: {
                pSSysCodeSnippetBase.resetUpdateDate();
                return true;
            }
            case 21: {
                pSSysCodeSnippetBase.resetUpdateMan();
                return true;
            }
            case 22: {
                pSSysCodeSnippetBase.resetUserCat();
                return true;
            }
            case 23: {
                pSSysCodeSnippetBase.resetUserTag();
                return true;
            }
            case 24: {
                pSSysCodeSnippetBase.resetUserTag2();
                return true;
            }
            case 25: {
                pSSysCodeSnippetBase.resetUserTag3();
                return true;
            }
            case 26: {
                pSSysCodeSnippetBase.resetUserTag4();
                return true;
            }
            case 27: {
                pSSysCodeSnippetBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCCodeSnippet getPSDCCodeSnippet() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCCodeSnippet();
        }
        if (this.getPSDCCodeSnippetId() == null) {
            return null;
        }
        Integer n = this.objPSDCCodeSnippetLock;
        synchronized (n) {
            if (this.psdccodesnippet != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCCodeSnippetId(), (Object)this.psdccodesnippet.getPSDCCodeSnippetId()) != 0L) {
                this.psdccodesnippet = null;
            }
            if (this.psdccodesnippet == null) {
                PSDCCodeSnippet pSDCCodeSnippet = new PSDCCodeSnippet();
                pSDCCodeSnippet.setPSDCCodeSnippetId(this.getPSDCCodeSnippetId());
                PSDCCodeSnippetService pSDCCodeSnippetService = (PSDCCodeSnippetService)ServiceGlobal.getService(PSDCCodeSnippetService.class, (SessionFactory)this.getSessionFactory());
                pSDCCodeSnippetService.autoGet(pSDCCodeSnippet);
                this.psdccodesnippet = pSDCCodeSnippet;
            }
            return this.psdccodesnippet;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPFStyle getPSPFStyle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyle();
        }
        if (this.getPSPFStyleId() == null) {
            return null;
        }
        Integer n = this.objPSPFStyleLock;
        synchronized (n) {
            if (this.pspfstyle != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFStyleId(), (Object)this.pspfstyle.getPSPFStyleId()) != 0L) {
                this.pspfstyle = null;
            }
            if (this.pspfstyle == null) {
                PSPFStyle pSPFStyle = new PSPFStyle();
                pSPFStyle.setPSPFStyleId(this.getPSPFStyleId());
                PSPFStyleService pSPFStyleService = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)this.getSessionFactory());
                pSPFStyleService.autoGet(pSPFStyle);
                this.pspfstyle = pSPFStyle;
            }
            return this.pspfstyle;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPF getPSPF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPF();
        }
        if (this.getPSPFId() == null) {
            return null;
        }
        Integer n = this.objPSPFLock;
        synchronized (n) {
            if (this.pspf != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFId(), (Object)this.pspf.getPSPFId()) != 0L) {
                this.pspf = null;
            }
            if (this.pspf == null) {
                PSPF pSPF = new PSPF();
                pSPF.setPSPFId(this.getPSPFId());
                PSPFService pSPFService = (PSPFService)ServiceGlobal.getService(PSPFService.class, (SessionFactory)this.getSessionFactory());
                pSPFService.autoGet(pSPF);
                this.pspf = pSPF;
            }
            return this.pspf;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSFStyle getPSSFStyle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyle();
        }
        if (this.getPSSFStyleId() == null) {
            return null;
        }
        Integer n = this.objPSSFStyleLock;
        synchronized (n) {
            if (this.pssfstyle != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFStyleId(), (Object)this.pssfstyle.getPSSFStyleId()) != 0L) {
                this.pssfstyle = null;
            }
            if (this.pssfstyle == null) {
                PSSFStyle pSSFStyle = new PSSFStyle();
                pSSFStyle.setPSSFStyleId(this.getPSSFStyleId());
                PSSFStyleService pSSFStyleService = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)this.getSessionFactory());
                pSSFStyleService.autoGet(pSSFStyle);
                this.pssfstyle = pSSFStyle;
            }
            return this.pssfstyle;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSF getPSSF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSF();
        }
        if (this.getPSSFId() == null) {
            return null;
        }
        Integer n = this.objPSSFLock;
        synchronized (n) {
            if (this.pssf != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFId(), (Object)this.pssf.getPSSFId()) != 0L) {
                this.pssf = null;
            }
            if (this.pssf == null) {
                PSSF pSSF = new PSSF();
                pSSF.setPSSFId(this.getPSSFId());
                PSSFService pSSFService = (PSSFService)ServiceGlobal.getService(PSSFService.class, (SessionFactory)this.getSessionFactory());
                pSSFService.autoGet(pSSF);
                this.pssf = pSSF;
            }
            return this.pssf;
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
                pSSystemService.autoGet(pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    private PSSysCodeSnippetBase getProxyEntity() {
        return this.proxyPSSysCodeSnippetBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysCodeSnippetBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysCodeSnippetBase) {
            this.proxyPSSysCodeSnippetBase = (PSSysCodeSnippetBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCodeSnippetService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CODEREFMODE, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSDCCODESNIPPETID, 5);
        fieldIndexMap.put(FIELD_PSDCCODESNIPPETNAME, 6);
        fieldIndexMap.put(FIELD_PSPFID, 7);
        fieldIndexMap.put(FIELD_PSPFNAME, 8);
        fieldIndexMap.put(FIELD_PSPFSTYLEID, 9);
        fieldIndexMap.put(FIELD_PSPFSTYLENAME, 10);
        fieldIndexMap.put(FIELD_PSSFID, 11);
        fieldIndexMap.put(FIELD_PSSFNAME, 12);
        fieldIndexMap.put(FIELD_PSSFSTYLEID, 13);
        fieldIndexMap.put(FIELD_PSSFSTYLENAME, 14);
        fieldIndexMap.put(FIELD_PSSYSCODESNIPPETID, 15);
        fieldIndexMap.put(FIELD_PSSYSCODESNIPPETNAME, 16);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 17);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 18);
        fieldIndexMap.put(FIELD_TEMPLTYPE, 19);
        fieldIndexMap.put(FIELD_UPDATEDATE, 20);
        fieldIndexMap.put(FIELD_UPDATEMAN, 21);
        fieldIndexMap.put(FIELD_USERCAT, 22);
        fieldIndexMap.put(FIELD_USERTAG, 23);
        fieldIndexMap.put(FIELD_USERTAG2, 24);
        fieldIndexMap.put(FIELD_USERTAG3, 25);
        fieldIndexMap.put(FIELD_USERTAG4, 26);
        fieldIndexMap.put(FIELD_VALIDFLAG, 27);
    }
}

