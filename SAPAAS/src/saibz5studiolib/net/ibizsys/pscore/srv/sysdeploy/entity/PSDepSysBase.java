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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSys;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSysBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDepSysBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FROMPSDCID = "FROMPSDCID";
    public static final String FIELD_FROMPSDCNAME = "FROMPSDCNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEPSYSID = "PSDEPSYSID";
    public static final String FIELD_PSDEPSYSNAME = "PSDEPSYSNAME";
    public static final String FIELD_PSDEPSYSTYPE = "PSDEPSYSTYPE";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVCENTERSVNID = "PSDEVCENTERSVNID";
    public static final String FIELD_PSDEVCENTERSVNNAME = "PSDEVCENTERSVNNAME";
    public static final String FIELD_PSSAASSYSID = "PSSAASSYSID";
    public static final String FIELD_PSSAASSYSNAME = "PSSAASSYSNAME";
    public static final String FIELD_ROPSDEVCENTERSVNID = "ROPSDEVCENTERSVNID";
    public static final String FIELD_ROPSDEVCENTERSVNNAME = "ROPSDEVCENTERSVNNAME";
    public static final String FIELD_SYSTAG = "SYSTAG";
    public static final String FIELD_SYSTAG2 = "SYSTAG2";
    public static final String FIELD_SYSTAG3 = "SYSTAG3";
    public static final String FIELD_SYSTAG4 = "SYSTAG4";
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
    private static final int INDEX_FROMPSDCID = 3;
    private static final int INDEX_FROMPSDCNAME = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSDEPSYSID = 6;
    private static final int INDEX_PSDEPSYSNAME = 7;
    private static final int INDEX_PSDEPSYSTYPE = 8;
    private static final int INDEX_PSDEVCENTERID = 9;
    private static final int INDEX_PSDEVCENTERNAME = 10;
    private static final int INDEX_PSDEVCENTERSVNID = 11;
    private static final int INDEX_PSDEVCENTERSVNNAME = 12;
    private static final int INDEX_PSSAASSYSID = 13;
    private static final int INDEX_PSSAASSYSNAME = 14;
    private static final int INDEX_ROPSDEVCENTERSVNID = 15;
    private static final int INDEX_ROPSDEVCENTERSVNNAME = 16;
    private static final int INDEX_SYSTAG = 17;
    private static final int INDEX_SYSTAG2 = 18;
    private static final int INDEX_SYSTAG3 = 19;
    private static final int INDEX_SYSTAG4 = 20;
    private static final int INDEX_UPDATEDATE = 21;
    private static final int INDEX_UPDATEMAN = 22;
    private static final int INDEX_USERCAT = 23;
    private static final int INDEX_USERTAG = 24;
    private static final int INDEX_USERTAG2 = 25;
    private static final int INDEX_USERTAG3 = 26;
    private static final int INDEX_USERTAG4 = 27;
    private static final int INDEX_VALIDFLAG = 28;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDepSysBase proxyPSDepSysBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean frompsdcidDirtyFlag = false;
    private boolean frompsdcnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdepsysidDirtyFlag = false;
    private boolean psdepsysnameDirtyFlag = false;
    private boolean psdepsystypeDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevcentersvnidDirtyFlag = false;
    private boolean psdevcentersvnnameDirtyFlag = false;
    private boolean pssaassysidDirtyFlag = false;
    private boolean pssaassysnameDirtyFlag = false;
    private boolean ropsdevcentersvnidDirtyFlag = false;
    private boolean ropsdevcentersvnnameDirtyFlag = false;
    private boolean systagDirtyFlag = false;
    private boolean systag2DirtyFlag = false;
    private boolean systag3DirtyFlag = false;
    private boolean systag4DirtyFlag = false;
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
    @Column(name="frompsdcid")
    private String frompsdcid;
    @Column(name="frompsdcname")
    private String frompsdcname;
    @Column(name="memo")
    private String memo;
    @Column(name="psdepsysid")
    private String psdepsysid;
    @Column(name="psdepsysname")
    private String psdepsysname;
    @Column(name="psdepsystype")
    private String psdepsystype;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevcentersvnid")
    private String psdevcentersvnid;
    @Column(name="psdevcentersvnname")
    private String psdevcentersvnname;
    @Column(name="pssaassysid")
    private String pssaassysid;
    @Column(name="pssaassysname")
    private String pssaassysname;
    @Column(name="ropsdevcentersvnid")
    private String ropsdevcentersvnid;
    @Column(name="ropsdevcentersvnname")
    private String ropsdevcentersvnname;
    @Column(name="systag")
    private String systag;
    @Column(name="systag2")
    private String systag2;
    @Column(name="systag3")
    private String systag3;
    @Column(name="systag4")
    private String systag4;
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
    private Integer objPSDevCenterSVNLock = new Integer(1);
    private PSDevCenterSVN psdevcentersvn = null;
    private Integer objROPSDevCenterSVNLock = new Integer(1);
    private PSDevCenterSVN ropsdevcentersvn = null;
    private Integer objFromPSDCLock = new Integer(1);
    private PSDevCenter frompsdc = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSSaaSSysLock = new Integer(1);
    private PSSaaSSys pssaassys = null;

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

    public void setFromPSDCId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFromPSDCId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.frompsdcid = string;
        this.frompsdcidDirtyFlag = true;
    }

    public String getFromPSDCId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFromPSDCId();
        }
        return this.frompsdcid;
    }

    public boolean isFromPSDCIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFromPSDCIdDirty();
        }
        return this.frompsdcidDirtyFlag;
    }

    public void resetFromPSDCId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFromPSDCId();
            return;
        }
        this.frompsdcidDirtyFlag = false;
        this.frompsdcid = null;
    }

    public void setFromPSDCName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFromPSDCName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.frompsdcname = string;
        this.frompsdcnameDirtyFlag = true;
    }

    public String getFromPSDCName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFromPSDCName();
        }
        return this.frompsdcname;
    }

    public boolean isFromPSDCNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFromPSDCNameDirty();
        }
        return this.frompsdcnameDirtyFlag;
    }

    public void resetFromPSDCName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFromPSDCName();
            return;
        }
        this.frompsdcnameDirtyFlag = false;
        this.frompsdcname = null;
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

    public void setPSDepSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepsysid = string;
        this.psdepsysidDirtyFlag = true;
    }

    public String getPSDepSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSysId();
        }
        return this.psdepsysid;
    }

    public boolean isPSDepSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSysIdDirty();
        }
        return this.psdepsysidDirtyFlag;
    }

    public void resetPSDepSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSysId();
            return;
        }
        this.psdepsysidDirtyFlag = false;
        this.psdepsysid = null;
    }

    public void setPSDepSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepsysname = string;
        this.psdepsysnameDirtyFlag = true;
    }

    public String getPSDepSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSysName();
        }
        return this.psdepsysname;
    }

    public boolean isPSDepSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSysNameDirty();
        }
        return this.psdepsysnameDirtyFlag;
    }

    public void resetPSDepSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSysName();
            return;
        }
        this.psdepsysnameDirtyFlag = false;
        this.psdepsysname = null;
    }

    public void setPSDepSysType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSysType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepsystype = string;
        this.psdepsystypeDirtyFlag = true;
    }

    public String getPSDepSysType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSysType();
        }
        return this.psdepsystype;
    }

    public boolean isPSDepSysTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSysTypeDirty();
        }
        return this.psdepsystypeDirtyFlag;
    }

    public void resetPSDepSysType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSysType();
            return;
        }
        this.psdepsystypeDirtyFlag = false;
        this.psdepsystype = null;
    }

    public void setPSDevCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterid = string;
        this.psdevcenteridDirtyFlag = true;
    }

    public String getPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterId();
        }
        return this.psdevcenterid;
    }

    public boolean isPSDevCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterIdDirty();
        }
        return this.psdevcenteridDirtyFlag;
    }

    public void resetPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterId();
            return;
        }
        this.psdevcenteridDirtyFlag = false;
        this.psdevcenterid = null;
    }

    public void setPSDevCenterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentername = string;
        this.psdevcenternameDirtyFlag = true;
    }

    public String getPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterName();
        }
        return this.psdevcentername;
    }

    public boolean isPSDevCenterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterNameDirty();
        }
        return this.psdevcenternameDirtyFlag;
    }

    public void resetPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterName();
            return;
        }
        this.psdevcenternameDirtyFlag = false;
        this.psdevcentername = null;
    }

    public void setPSDevCenterSVNId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterSVNId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentersvnid = string;
        this.psdevcentersvnidDirtyFlag = true;
    }

    public String getPSDevCenterSVNId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterSVNId();
        }
        return this.psdevcentersvnid;
    }

    public boolean isPSDevCenterSVNIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterSVNIdDirty();
        }
        return this.psdevcentersvnidDirtyFlag;
    }

    public void resetPSDevCenterSVNId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterSVNId();
            return;
        }
        this.psdevcentersvnidDirtyFlag = false;
        this.psdevcentersvnid = null;
    }

    public void setPSDevCenterSVNName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterSVNName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentersvnname = string;
        this.psdevcentersvnnameDirtyFlag = true;
    }

    public String getPSDevCenterSVNName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterSVNName();
        }
        return this.psdevcentersvnname;
    }

    public boolean isPSDevCenterSVNNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterSVNNameDirty();
        }
        return this.psdevcentersvnnameDirtyFlag;
    }

    public void resetPSDevCenterSVNName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterSVNName();
            return;
        }
        this.psdevcentersvnnameDirtyFlag = false;
        this.psdevcentersvnname = null;
    }

    public void setPSSaaSSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSaaSSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssaassysid = string;
        this.pssaassysidDirtyFlag = true;
    }

    public String getPSSaaSSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSysId();
        }
        return this.pssaassysid;
    }

    public boolean isPSSaaSSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSaaSSysIdDirty();
        }
        return this.pssaassysidDirtyFlag;
    }

    public void resetPSSaaSSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSaaSSysId();
            return;
        }
        this.pssaassysidDirtyFlag = false;
        this.pssaassysid = null;
    }

    public void setPSSaaSSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSaaSSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssaassysname = string;
        this.pssaassysnameDirtyFlag = true;
    }

    public String getPSSaaSSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSysName();
        }
        return this.pssaassysname;
    }

    public boolean isPSSaaSSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSaaSSysNameDirty();
        }
        return this.pssaassysnameDirtyFlag;
    }

    public void resetPSSaaSSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSaaSSysName();
            return;
        }
        this.pssaassysnameDirtyFlag = false;
        this.pssaassysname = null;
    }

    public void setROPSDevCenterSvnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setROPSDevCenterSvnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ropsdevcentersvnid = string;
        this.ropsdevcentersvnidDirtyFlag = true;
    }

    public String getROPSDevCenterSvnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getROPSDevCenterSvnId();
        }
        return this.ropsdevcentersvnid;
    }

    public boolean isROPSDevCenterSvnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isROPSDevCenterSvnIdDirty();
        }
        return this.ropsdevcentersvnidDirtyFlag;
    }

    public void resetROPSDevCenterSvnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetROPSDevCenterSvnId();
            return;
        }
        this.ropsdevcentersvnidDirtyFlag = false;
        this.ropsdevcentersvnid = null;
    }

    public void setROPSDevCenterSvnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setROPSDevCenterSvnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ropsdevcentersvnname = string;
        this.ropsdevcentersvnnameDirtyFlag = true;
    }

    public String getROPSDevCenterSvnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getROPSDevCenterSvnName();
        }
        return this.ropsdevcentersvnname;
    }

    public boolean isROPSDevCenterSvnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isROPSDevCenterSvnNameDirty();
        }
        return this.ropsdevcentersvnnameDirtyFlag;
    }

    public void resetROPSDevCenterSvnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetROPSDevCenterSvnName();
            return;
        }
        this.ropsdevcentersvnnameDirtyFlag = false;
        this.ropsdevcentersvnname = null;
    }

    public void setSysTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.systag = string;
        this.systagDirtyFlag = true;
    }

    public String getSysTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysTag();
        }
        return this.systag;
    }

    public boolean isSysTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysTagDirty();
        }
        return this.systagDirtyFlag;
    }

    public void resetSysTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysTag();
            return;
        }
        this.systagDirtyFlag = false;
        this.systag = null;
    }

    public void setSysTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.systag2 = string;
        this.systag2DirtyFlag = true;
    }

    public String getSysTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysTag2();
        }
        return this.systag2;
    }

    public boolean isSysTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysTag2Dirty();
        }
        return this.systag2DirtyFlag;
    }

    public void resetSysTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysTag2();
            return;
        }
        this.systag2DirtyFlag = false;
        this.systag2 = null;
    }

    public void setSysTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.systag3 = string;
        this.systag3DirtyFlag = true;
    }

    public String getSysTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysTag3();
        }
        return this.systag3;
    }

    public boolean isSysTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysTag3Dirty();
        }
        return this.systag3DirtyFlag;
    }

    public void resetSysTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysTag3();
            return;
        }
        this.systag3DirtyFlag = false;
        this.systag3 = null;
    }

    public void setSysTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.systag4 = string;
        this.systag4DirtyFlag = true;
    }

    public String getSysTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysTag4();
        }
        return this.systag4;
    }

    public boolean isSysTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysTag4Dirty();
        }
        return this.systag4DirtyFlag;
    }

    public void resetSysTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysTag4();
            return;
        }
        this.systag4DirtyFlag = false;
        this.systag4 = null;
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
        PSDepSysBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDepSysBase pSDepSysBase) {
        pSDepSysBase.resetCodeName();
        pSDepSysBase.resetCreateDate();
        pSDepSysBase.resetCreateMan();
        pSDepSysBase.resetFromPSDCId();
        pSDepSysBase.resetFromPSDCName();
        pSDepSysBase.resetMemo();
        pSDepSysBase.resetPSDepSysId();
        pSDepSysBase.resetPSDepSysName();
        pSDepSysBase.resetPSDepSysType();
        pSDepSysBase.resetPSDevCenterId();
        pSDepSysBase.resetPSDevCenterName();
        pSDepSysBase.resetPSDevCenterSVNId();
        pSDepSysBase.resetPSDevCenterSVNName();
        pSDepSysBase.resetPSSaaSSysId();
        pSDepSysBase.resetPSSaaSSysName();
        pSDepSysBase.resetROPSDevCenterSvnId();
        pSDepSysBase.resetROPSDevCenterSvnName();
        pSDepSysBase.resetSysTag();
        pSDepSysBase.resetSysTag2();
        pSDepSysBase.resetSysTag3();
        pSDepSysBase.resetSysTag4();
        pSDepSysBase.resetUpdateDate();
        pSDepSysBase.resetUpdateMan();
        pSDepSysBase.resetUserCat();
        pSDepSysBase.resetUserTag();
        pSDepSysBase.resetUserTag2();
        pSDepSysBase.resetUserTag3();
        pSDepSysBase.resetUserTag4();
        pSDepSysBase.resetValidFlag();
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
        if (!bl || this.isFromPSDCIdDirty()) {
            hashMap.put(FIELD_FROMPSDCID, this.getFromPSDCId());
        }
        if (!bl || this.isFromPSDCNameDirty()) {
            hashMap.put(FIELD_FROMPSDCNAME, this.getFromPSDCName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDepSysIdDirty()) {
            hashMap.put(FIELD_PSDEPSYSID, this.getPSDepSysId());
        }
        if (!bl || this.isPSDepSysNameDirty()) {
            hashMap.put(FIELD_PSDEPSYSNAME, this.getPSDepSysName());
        }
        if (!bl || this.isPSDepSysTypeDirty()) {
            hashMap.put(FIELD_PSDEPSYSTYPE, this.getPSDepSysType());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDevCenterSVNIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERSVNID, this.getPSDevCenterSVNId());
        }
        if (!bl || this.isPSDevCenterSVNNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERSVNNAME, this.getPSDevCenterSVNName());
        }
        if (!bl || this.isPSSaaSSysIdDirty()) {
            hashMap.put(FIELD_PSSAASSYSID, this.getPSSaaSSysId());
        }
        if (!bl || this.isPSSaaSSysNameDirty()) {
            hashMap.put(FIELD_PSSAASSYSNAME, this.getPSSaaSSysName());
        }
        if (!bl || this.isROPSDevCenterSvnIdDirty()) {
            hashMap.put(FIELD_ROPSDEVCENTERSVNID, this.getROPSDevCenterSvnId());
        }
        if (!bl || this.isROPSDevCenterSvnNameDirty()) {
            hashMap.put(FIELD_ROPSDEVCENTERSVNNAME, this.getROPSDevCenterSvnName());
        }
        if (!bl || this.isSysTagDirty()) {
            hashMap.put(FIELD_SYSTAG, this.getSysTag());
        }
        if (!bl || this.isSysTag2Dirty()) {
            hashMap.put(FIELD_SYSTAG2, this.getSysTag2());
        }
        if (!bl || this.isSysTag3Dirty()) {
            hashMap.put(FIELD_SYSTAG3, this.getSysTag3());
        }
        if (!bl || this.isSysTag4Dirty()) {
            hashMap.put(FIELD_SYSTAG4, this.getSysTag4());
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
        return PSDepSysBase.get(this, n);
    }

    private static Object get(PSDepSysBase pSDepSysBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSysBase.getCodeName();
            }
            case 1: {
                return pSDepSysBase.getCreateDate();
            }
            case 2: {
                return pSDepSysBase.getCreateMan();
            }
            case 3: {
                return pSDepSysBase.getFromPSDCId();
            }
            case 4: {
                return pSDepSysBase.getFromPSDCName();
            }
            case 5: {
                return pSDepSysBase.getMemo();
            }
            case 6: {
                return pSDepSysBase.getPSDepSysId();
            }
            case 7: {
                return pSDepSysBase.getPSDepSysName();
            }
            case 8: {
                return pSDepSysBase.getPSDepSysType();
            }
            case 9: {
                return pSDepSysBase.getPSDevCenterId();
            }
            case 10: {
                return pSDepSysBase.getPSDevCenterName();
            }
            case 11: {
                return pSDepSysBase.getPSDevCenterSVNId();
            }
            case 12: {
                return pSDepSysBase.getPSDevCenterSVNName();
            }
            case 13: {
                return pSDepSysBase.getPSSaaSSysId();
            }
            case 14: {
                return pSDepSysBase.getPSSaaSSysName();
            }
            case 15: {
                return pSDepSysBase.getROPSDevCenterSvnId();
            }
            case 16: {
                return pSDepSysBase.getROPSDevCenterSvnName();
            }
            case 17: {
                return pSDepSysBase.getSysTag();
            }
            case 18: {
                return pSDepSysBase.getSysTag2();
            }
            case 19: {
                return pSDepSysBase.getSysTag3();
            }
            case 20: {
                return pSDepSysBase.getSysTag4();
            }
            case 21: {
                return pSDepSysBase.getUpdateDate();
            }
            case 22: {
                return pSDepSysBase.getUpdateMan();
            }
            case 23: {
                return pSDepSysBase.getUserCat();
            }
            case 24: {
                return pSDepSysBase.getUserTag();
            }
            case 25: {
                return pSDepSysBase.getUserTag2();
            }
            case 26: {
                return pSDepSysBase.getUserTag3();
            }
            case 27: {
                return pSDepSysBase.getUserTag4();
            }
            case 28: {
                return pSDepSysBase.getValidFlag();
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
        PSDepSysBase.set(this, n, object);
    }

    private static void set(PSDepSysBase pSDepSysBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDepSysBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDepSysBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDepSysBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDepSysBase.setFromPSDCId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDepSysBase.setFromPSDCName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDepSysBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDepSysBase.setPSDepSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDepSysBase.setPSDepSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDepSysBase.setPSDepSysType(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDepSysBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDepSysBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDepSysBase.setPSDevCenterSVNId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDepSysBase.setPSDevCenterSVNName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDepSysBase.setPSSaaSSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDepSysBase.setPSSaaSSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDepSysBase.setROPSDevCenterSvnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDepSysBase.setROPSDevCenterSvnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDepSysBase.setSysTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDepSysBase.setSysTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDepSysBase.setSysTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDepSysBase.setSysTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDepSysBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 22: {
                pSDepSysBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDepSysBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDepSysBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDepSysBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDepSysBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDepSysBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDepSysBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDepSysBase.isNull(this, n);
    }

    private static boolean isNull(PSDepSysBase pSDepSysBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSysBase.getCodeName() == null;
            }
            case 1: {
                return pSDepSysBase.getCreateDate() == null;
            }
            case 2: {
                return pSDepSysBase.getCreateMan() == null;
            }
            case 3: {
                return pSDepSysBase.getFromPSDCId() == null;
            }
            case 4: {
                return pSDepSysBase.getFromPSDCName() == null;
            }
            case 5: {
                return pSDepSysBase.getMemo() == null;
            }
            case 6: {
                return pSDepSysBase.getPSDepSysId() == null;
            }
            case 7: {
                return pSDepSysBase.getPSDepSysName() == null;
            }
            case 8: {
                return pSDepSysBase.getPSDepSysType() == null;
            }
            case 9: {
                return pSDepSysBase.getPSDevCenterId() == null;
            }
            case 10: {
                return pSDepSysBase.getPSDevCenterName() == null;
            }
            case 11: {
                return pSDepSysBase.getPSDevCenterSVNId() == null;
            }
            case 12: {
                return pSDepSysBase.getPSDevCenterSVNName() == null;
            }
            case 13: {
                return pSDepSysBase.getPSSaaSSysId() == null;
            }
            case 14: {
                return pSDepSysBase.getPSSaaSSysName() == null;
            }
            case 15: {
                return pSDepSysBase.getROPSDevCenterSvnId() == null;
            }
            case 16: {
                return pSDepSysBase.getROPSDevCenterSvnName() == null;
            }
            case 17: {
                return pSDepSysBase.getSysTag() == null;
            }
            case 18: {
                return pSDepSysBase.getSysTag2() == null;
            }
            case 19: {
                return pSDepSysBase.getSysTag3() == null;
            }
            case 20: {
                return pSDepSysBase.getSysTag4() == null;
            }
            case 21: {
                return pSDepSysBase.getUpdateDate() == null;
            }
            case 22: {
                return pSDepSysBase.getUpdateMan() == null;
            }
            case 23: {
                return pSDepSysBase.getUserCat() == null;
            }
            case 24: {
                return pSDepSysBase.getUserTag() == null;
            }
            case 25: {
                return pSDepSysBase.getUserTag2() == null;
            }
            case 26: {
                return pSDepSysBase.getUserTag3() == null;
            }
            case 27: {
                return pSDepSysBase.getUserTag4() == null;
            }
            case 28: {
                return pSDepSysBase.getValidFlag() == null;
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
        return PSDepSysBase.contains(this, n);
    }

    private static boolean contains(PSDepSysBase pSDepSysBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSysBase.isCodeNameDirty();
            }
            case 1: {
                return pSDepSysBase.isCreateDateDirty();
            }
            case 2: {
                return pSDepSysBase.isCreateManDirty();
            }
            case 3: {
                return pSDepSysBase.isFromPSDCIdDirty();
            }
            case 4: {
                return pSDepSysBase.isFromPSDCNameDirty();
            }
            case 5: {
                return pSDepSysBase.isMemoDirty();
            }
            case 6: {
                return pSDepSysBase.isPSDepSysIdDirty();
            }
            case 7: {
                return pSDepSysBase.isPSDepSysNameDirty();
            }
            case 8: {
                return pSDepSysBase.isPSDepSysTypeDirty();
            }
            case 9: {
                return pSDepSysBase.isPSDevCenterIdDirty();
            }
            case 10: {
                return pSDepSysBase.isPSDevCenterNameDirty();
            }
            case 11: {
                return pSDepSysBase.isPSDevCenterSVNIdDirty();
            }
            case 12: {
                return pSDepSysBase.isPSDevCenterSVNNameDirty();
            }
            case 13: {
                return pSDepSysBase.isPSSaaSSysIdDirty();
            }
            case 14: {
                return pSDepSysBase.isPSSaaSSysNameDirty();
            }
            case 15: {
                return pSDepSysBase.isROPSDevCenterSvnIdDirty();
            }
            case 16: {
                return pSDepSysBase.isROPSDevCenterSvnNameDirty();
            }
            case 17: {
                return pSDepSysBase.isSysTagDirty();
            }
            case 18: {
                return pSDepSysBase.isSysTag2Dirty();
            }
            case 19: {
                return pSDepSysBase.isSysTag3Dirty();
            }
            case 20: {
                return pSDepSysBase.isSysTag4Dirty();
            }
            case 21: {
                return pSDepSysBase.isUpdateDateDirty();
            }
            case 22: {
                return pSDepSysBase.isUpdateManDirty();
            }
            case 23: {
                return pSDepSysBase.isUserCatDirty();
            }
            case 24: {
                return pSDepSysBase.isUserTagDirty();
            }
            case 25: {
                return pSDepSysBase.isUserTag2Dirty();
            }
            case 26: {
                return pSDepSysBase.isUserTag3Dirty();
            }
            case 27: {
                return pSDepSysBase.isUserTag4Dirty();
            }
            case 28: {
                return pSDepSysBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDepSysBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDepSysBase pSDepSysBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDepSysBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDepSysBase.getJSONValue((Object)pSDepSysBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDepSysBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDepSysBase.getJSONValue((Object)pSDepSysBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDepSysBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDepSysBase.getJSONValue((Object)pSDepSysBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDepSysBase.getFromPSDCId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"frompsdcid", (Object)PSDepSysBase.getJSONValue((Object)pSDepSysBase.getFromPSDCId()), (boolean)false);
        }
        if (bl || pSDepSysBase.getFromPSDCName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"frompsdcname", (Object)PSDepSysBase.getJSONValue((Object)pSDepSysBase.getFromPSDCName()), (boolean)false);
        }
        if (bl || pSDepSysBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDepSysBase.getJSONValue((Object)pSDepSysBase.getMemo()), (boolean)false);
        }
        if (bl || pSDepSysBase.getPSDepSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepsysid", (Object)PSDepSysBase.getJSONValue((Object)pSDepSysBase.getPSDepSysId()), (boolean)false);
        }
        if (bl || pSDepSysBase.getPSDepSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepsysname", (Object)PSDepSysBase.getJSONValue((Object)pSDepSysBase.getPSDepSysName()), (boolean)false);
        }
        if (bl || pSDepSysBase.getPSDepSysType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepsystype", (Object)PSDepSysBase.getJSONValue((Object)pSDepSysBase.getPSDepSysType()), (boolean)false);
        }
        if (bl || pSDepSysBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDepSysBase.getJSONValue((Object)pSDepSysBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDepSysBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDepSysBase.getJSONValue((Object)pSDepSysBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDepSysBase.getPSDevCenterSVNId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentersvnid", (Object)PSDepSysBase.getJSONValue((Object)pSDepSysBase.getPSDevCenterSVNId()), (boolean)false);
        }
        if (bl || pSDepSysBase.getPSDevCenterSVNName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentersvnname", (Object)PSDepSysBase.getJSONValue((Object)pSDepSysBase.getPSDevCenterSVNName()), (boolean)false);
        }
        if (bl || pSDepSysBase.getPSSaaSSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssaassysid", (Object)PSDepSysBase.getJSONValue((Object)pSDepSysBase.getPSSaaSSysId()), (boolean)false);
        }
        if (bl || pSDepSysBase.getPSSaaSSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssaassysname", (Object)PSDepSysBase.getJSONValue((Object)pSDepSysBase.getPSSaaSSysName()), (boolean)false);
        }
        if (bl || pSDepSysBase.getROPSDevCenterSvnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ropsdevcentersvnid", (Object)PSDepSysBase.getJSONValue((Object)pSDepSysBase.getROPSDevCenterSvnId()), (boolean)false);
        }
        if (bl || pSDepSysBase.getROPSDevCenterSvnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ropsdevcentersvnname", (Object)PSDepSysBase.getJSONValue((Object)pSDepSysBase.getROPSDevCenterSvnName()), (boolean)false);
        }
        if (bl || pSDepSysBase.getSysTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"systag", (Object)PSDepSysBase.getJSONValue((Object)pSDepSysBase.getSysTag()), (boolean)false);
        }
        if (bl || pSDepSysBase.getSysTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"systag2", (Object)PSDepSysBase.getJSONValue((Object)pSDepSysBase.getSysTag2()), (boolean)false);
        }
        if (bl || pSDepSysBase.getSysTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"systag3", (Object)PSDepSysBase.getJSONValue((Object)pSDepSysBase.getSysTag3()), (boolean)false);
        }
        if (bl || pSDepSysBase.getSysTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"systag4", (Object)PSDepSysBase.getJSONValue((Object)pSDepSysBase.getSysTag4()), (boolean)false);
        }
        if (bl || pSDepSysBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDepSysBase.getJSONValue((Object)pSDepSysBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDepSysBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDepSysBase.getJSONValue((Object)pSDepSysBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDepSysBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDepSysBase.getJSONValue((Object)pSDepSysBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDepSysBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDepSysBase.getJSONValue((Object)pSDepSysBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDepSysBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDepSysBase.getJSONValue((Object)pSDepSysBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDepSysBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDepSysBase.getJSONValue((Object)pSDepSysBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDepSysBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDepSysBase.getJSONValue((Object)pSDepSysBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDepSysBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDepSysBase.getJSONValue((Object)pSDepSysBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDepSysBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDepSysBase pSDepSysBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDepSysBase.getCodeName() != null) {
            object = pSDepSysBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysBase.getCreateDate() != null) {
            object = pSDepSysBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSysBase.getCreateMan() != null) {
            object = pSDepSysBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysBase.getFromPSDCId() != null) {
            object = pSDepSysBase.getFromPSDCId();
            xmlNode.setAttribute(FIELD_FROMPSDCID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysBase.getFromPSDCName() != null) {
            object = pSDepSysBase.getFromPSDCName();
            xmlNode.setAttribute(FIELD_FROMPSDCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysBase.getMemo() != null) {
            object = pSDepSysBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysBase.getPSDepSysId() != null) {
            object = pSDepSysBase.getPSDepSysId();
            xmlNode.setAttribute(FIELD_PSDEPSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysBase.getPSDepSysName() != null) {
            object = pSDepSysBase.getPSDepSysName();
            xmlNode.setAttribute(FIELD_PSDEPSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysBase.getPSDepSysType() != null) {
            object = pSDepSysBase.getPSDepSysType();
            xmlNode.setAttribute(FIELD_PSDEPSYSTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysBase.getPSDevCenterId() != null) {
            object = pSDepSysBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysBase.getPSDevCenterName() != null) {
            object = pSDepSysBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysBase.getPSDevCenterSVNId() != null) {
            object = pSDepSysBase.getPSDevCenterSVNId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERSVNID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysBase.getPSDevCenterSVNName() != null) {
            object = pSDepSysBase.getPSDevCenterSVNName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERSVNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysBase.getPSSaaSSysId() != null) {
            object = pSDepSysBase.getPSSaaSSysId();
            xmlNode.setAttribute(FIELD_PSSAASSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysBase.getPSSaaSSysName() != null) {
            object = pSDepSysBase.getPSSaaSSysName();
            xmlNode.setAttribute(FIELD_PSSAASSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysBase.getROPSDevCenterSvnId() != null) {
            object = pSDepSysBase.getROPSDevCenterSvnId();
            xmlNode.setAttribute(FIELD_ROPSDEVCENTERSVNID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysBase.getROPSDevCenterSvnName() != null) {
            object = pSDepSysBase.getROPSDevCenterSvnName();
            xmlNode.setAttribute(FIELD_ROPSDEVCENTERSVNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysBase.getSysTag() != null) {
            object = pSDepSysBase.getSysTag();
            xmlNode.setAttribute(FIELD_SYSTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysBase.getSysTag2() != null) {
            object = pSDepSysBase.getSysTag2();
            xmlNode.setAttribute(FIELD_SYSTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysBase.getSysTag3() != null) {
            object = pSDepSysBase.getSysTag3();
            xmlNode.setAttribute(FIELD_SYSTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysBase.getSysTag4() != null) {
            object = pSDepSysBase.getSysTag4();
            xmlNode.setAttribute(FIELD_SYSTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysBase.getUpdateDate() != null) {
            object = pSDepSysBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSysBase.getUpdateMan() != null) {
            object = pSDepSysBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysBase.getUserCat() != null) {
            object = pSDepSysBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysBase.getUserTag() != null) {
            object = pSDepSysBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysBase.getUserTag2() != null) {
            object = pSDepSysBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysBase.getUserTag3() != null) {
            object = pSDepSysBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysBase.getUserTag4() != null) {
            object = pSDepSysBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysBase.getValidFlag() != null) {
            object = pSDepSysBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDepSysBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDepSysBase pSDepSysBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDepSysBase.isCodeNameDirty() && (bl || pSDepSysBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDepSysBase.getCodeName());
        }
        if (pSDepSysBase.isCreateDateDirty() && (bl || pSDepSysBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDepSysBase.getCreateDate());
        }
        if (pSDepSysBase.isCreateManDirty() && (bl || pSDepSysBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDepSysBase.getCreateMan());
        }
        if (pSDepSysBase.isFromPSDCIdDirty() && (bl || pSDepSysBase.getFromPSDCId() != null)) {
            iDataObject.set(FIELD_FROMPSDCID, (Object)pSDepSysBase.getFromPSDCId());
        }
        if (pSDepSysBase.isFromPSDCNameDirty() && (bl || pSDepSysBase.getFromPSDCName() != null)) {
            iDataObject.set(FIELD_FROMPSDCNAME, (Object)pSDepSysBase.getFromPSDCName());
        }
        if (pSDepSysBase.isMemoDirty() && (bl || pSDepSysBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDepSysBase.getMemo());
        }
        if (pSDepSysBase.isPSDepSysIdDirty() && (bl || pSDepSysBase.getPSDepSysId() != null)) {
            iDataObject.set(FIELD_PSDEPSYSID, (Object)pSDepSysBase.getPSDepSysId());
        }
        if (pSDepSysBase.isPSDepSysNameDirty() && (bl || pSDepSysBase.getPSDepSysName() != null)) {
            iDataObject.set(FIELD_PSDEPSYSNAME, (Object)pSDepSysBase.getPSDepSysName());
        }
        if (pSDepSysBase.isPSDepSysTypeDirty() && (bl || pSDepSysBase.getPSDepSysType() != null)) {
            iDataObject.set(FIELD_PSDEPSYSTYPE, (Object)pSDepSysBase.getPSDepSysType());
        }
        if (pSDepSysBase.isPSDevCenterIdDirty() && (bl || pSDepSysBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDepSysBase.getPSDevCenterId());
        }
        if (pSDepSysBase.isPSDevCenterNameDirty() && (bl || pSDepSysBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDepSysBase.getPSDevCenterName());
        }
        if (pSDepSysBase.isPSDevCenterSVNIdDirty() && (bl || pSDepSysBase.getPSDevCenterSVNId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERSVNID, (Object)pSDepSysBase.getPSDevCenterSVNId());
        }
        if (pSDepSysBase.isPSDevCenterSVNNameDirty() && (bl || pSDepSysBase.getPSDevCenterSVNName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERSVNNAME, (Object)pSDepSysBase.getPSDevCenterSVNName());
        }
        if (pSDepSysBase.isPSSaaSSysIdDirty() && (bl || pSDepSysBase.getPSSaaSSysId() != null)) {
            iDataObject.set(FIELD_PSSAASSYSID, (Object)pSDepSysBase.getPSSaaSSysId());
        }
        if (pSDepSysBase.isPSSaaSSysNameDirty() && (bl || pSDepSysBase.getPSSaaSSysName() != null)) {
            iDataObject.set(FIELD_PSSAASSYSNAME, (Object)pSDepSysBase.getPSSaaSSysName());
        }
        if (pSDepSysBase.isROPSDevCenterSvnIdDirty() && (bl || pSDepSysBase.getROPSDevCenterSvnId() != null)) {
            iDataObject.set(FIELD_ROPSDEVCENTERSVNID, (Object)pSDepSysBase.getROPSDevCenterSvnId());
        }
        if (pSDepSysBase.isROPSDevCenterSvnNameDirty() && (bl || pSDepSysBase.getROPSDevCenterSvnName() != null)) {
            iDataObject.set(FIELD_ROPSDEVCENTERSVNNAME, (Object)pSDepSysBase.getROPSDevCenterSvnName());
        }
        if (pSDepSysBase.isSysTagDirty() && (bl || pSDepSysBase.getSysTag() != null)) {
            iDataObject.set(FIELD_SYSTAG, (Object)pSDepSysBase.getSysTag());
        }
        if (pSDepSysBase.isSysTag2Dirty() && (bl || pSDepSysBase.getSysTag2() != null)) {
            iDataObject.set(FIELD_SYSTAG2, (Object)pSDepSysBase.getSysTag2());
        }
        if (pSDepSysBase.isSysTag3Dirty() && (bl || pSDepSysBase.getSysTag3() != null)) {
            iDataObject.set(FIELD_SYSTAG3, (Object)pSDepSysBase.getSysTag3());
        }
        if (pSDepSysBase.isSysTag4Dirty() && (bl || pSDepSysBase.getSysTag4() != null)) {
            iDataObject.set(FIELD_SYSTAG4, (Object)pSDepSysBase.getSysTag4());
        }
        if (pSDepSysBase.isUpdateDateDirty() && (bl || pSDepSysBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDepSysBase.getUpdateDate());
        }
        if (pSDepSysBase.isUpdateManDirty() && (bl || pSDepSysBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDepSysBase.getUpdateMan());
        }
        if (pSDepSysBase.isUserCatDirty() && (bl || pSDepSysBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDepSysBase.getUserCat());
        }
        if (pSDepSysBase.isUserTagDirty() && (bl || pSDepSysBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDepSysBase.getUserTag());
        }
        if (pSDepSysBase.isUserTag2Dirty() && (bl || pSDepSysBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDepSysBase.getUserTag2());
        }
        if (pSDepSysBase.isUserTag3Dirty() && (bl || pSDepSysBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDepSysBase.getUserTag3());
        }
        if (pSDepSysBase.isUserTag4Dirty() && (bl || pSDepSysBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDepSysBase.getUserTag4());
        }
        if (pSDepSysBase.isValidFlagDirty() && (bl || pSDepSysBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDepSysBase.getValidFlag());
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
        return PSDepSysBase.remove(this, n);
    }

    private static boolean remove(PSDepSysBase pSDepSysBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDepSysBase.resetCodeName();
                return true;
            }
            case 1: {
                pSDepSysBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDepSysBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDepSysBase.resetFromPSDCId();
                return true;
            }
            case 4: {
                pSDepSysBase.resetFromPSDCName();
                return true;
            }
            case 5: {
                pSDepSysBase.resetMemo();
                return true;
            }
            case 6: {
                pSDepSysBase.resetPSDepSysId();
                return true;
            }
            case 7: {
                pSDepSysBase.resetPSDepSysName();
                return true;
            }
            case 8: {
                pSDepSysBase.resetPSDepSysType();
                return true;
            }
            case 9: {
                pSDepSysBase.resetPSDevCenterId();
                return true;
            }
            case 10: {
                pSDepSysBase.resetPSDevCenterName();
                return true;
            }
            case 11: {
                pSDepSysBase.resetPSDevCenterSVNId();
                return true;
            }
            case 12: {
                pSDepSysBase.resetPSDevCenterSVNName();
                return true;
            }
            case 13: {
                pSDepSysBase.resetPSSaaSSysId();
                return true;
            }
            case 14: {
                pSDepSysBase.resetPSSaaSSysName();
                return true;
            }
            case 15: {
                pSDepSysBase.resetROPSDevCenterSvnId();
                return true;
            }
            case 16: {
                pSDepSysBase.resetROPSDevCenterSvnName();
                return true;
            }
            case 17: {
                pSDepSysBase.resetSysTag();
                return true;
            }
            case 18: {
                pSDepSysBase.resetSysTag2();
                return true;
            }
            case 19: {
                pSDepSysBase.resetSysTag3();
                return true;
            }
            case 20: {
                pSDepSysBase.resetSysTag4();
                return true;
            }
            case 21: {
                pSDepSysBase.resetUpdateDate();
                return true;
            }
            case 22: {
                pSDepSysBase.resetUpdateMan();
                return true;
            }
            case 23: {
                pSDepSysBase.resetUserCat();
                return true;
            }
            case 24: {
                pSDepSysBase.resetUserTag();
                return true;
            }
            case 25: {
                pSDepSysBase.resetUserTag2();
                return true;
            }
            case 26: {
                pSDepSysBase.resetUserTag3();
                return true;
            }
            case 27: {
                pSDepSysBase.resetUserTag4();
                return true;
            }
            case 28: {
                pSDepSysBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterSVN getPSDevCenterSVN() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterSVN();
        }
        if (this.getPSDevCenterSVNId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterSVNLock;
        synchronized (n) {
            if (this.psdevcentersvn != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterSVNId(), (Object)this.psdevcentersvn.getPSDevCenterSVNId()) != 0L) {
                this.psdevcentersvn = null;
            }
            if (this.psdevcentersvn == null) {
                PSDevCenterSVN pSDevCenterSVN = new PSDevCenterSVN();
                pSDevCenterSVN.setPSDevCenterSVNId(this.getPSDevCenterSVNId());
                PSDevCenterSVNService pSDevCenterSVNService = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterSVNService.autoGet((IEntity)pSDevCenterSVN);
                this.psdevcentersvn = pSDevCenterSVN;
            }
            return this.psdevcentersvn;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterSVN getROPSDevCenterSVN() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getROPSDevCenterSVN();
        }
        if (this.getROPSDevCenterSvnId() == null) {
            return null;
        }
        Integer n = this.objROPSDevCenterSVNLock;
        synchronized (n) {
            if (this.ropsdevcentersvn != null && DataTypeHelper.compare((int)25, (Object)this.getROPSDevCenterSvnId(), (Object)this.ropsdevcentersvn.getPSDevCenterSVNId()) != 0L) {
                this.ropsdevcentersvn = null;
            }
            if (this.ropsdevcentersvn == null) {
                PSDevCenterSVN pSDevCenterSVN = new PSDevCenterSVN();
                pSDevCenterSVN.setPSDevCenterSVNId(this.getROPSDevCenterSvnId());
                PSDevCenterSVNService pSDevCenterSVNService = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterSVNService.autoGet((IEntity)pSDevCenterSVN);
                this.ropsdevcentersvn = pSDevCenterSVN;
            }
            return this.ropsdevcentersvn;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getFromPSDC() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFromPSDC();
        }
        if (this.getFromPSDCId() == null) {
            return null;
        }
        Integer n = this.objFromPSDCLock;
        synchronized (n) {
            if (this.frompsdc != null && DataTypeHelper.compare((int)25, (Object)this.getFromPSDCId(), (Object)this.frompsdc.getPSDevCenterId()) != 0L) {
                this.frompsdc = null;
            }
            if (this.frompsdc == null) {
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(this.getFromPSDCId());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.frompsdc = pSDevCenter;
            }
            return this.frompsdc;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getPSDevCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenter();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterLock;
        synchronized (n) {
            if (this.psdevcenter != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterId(), (Object)this.psdevcenter.getPSDevCenterId()) != 0L) {
                this.psdevcenter = null;
            }
            if (this.psdevcenter == null) {
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(this.getPSDevCenterId());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSaaSSys getPSSaaSSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSys();
        }
        if (this.getPSSaaSSysId() == null) {
            return null;
        }
        Integer n = this.objPSSaaSSysLock;
        synchronized (n) {
            if (this.pssaassys != null && DataTypeHelper.compare((int)25, (Object)this.getPSSaaSSysId(), (Object)this.pssaassys.getPSSaaSSysId()) != 0L) {
                this.pssaassys = null;
            }
            if (this.pssaassys == null) {
                PSSaaSSys pSSaaSSys = new PSSaaSSys();
                pSSaaSSys.setPSSaaSSysId(this.getPSSaaSSysId());
                PSSaaSSysService pSSaaSSysService = (PSSaaSSysService)ServiceGlobal.getService(PSSaaSSysService.class, (SessionFactory)this.getSessionFactory());
                pSSaaSSysService.autoGet((IEntity)pSSaaSSys);
                this.pssaassys = pSSaaSSys;
            }
            return this.pssaassys;
        }
    }

    private PSDepSysBase getProxyEntity() {
        return this.proxyPSDepSysBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDepSysBase = null;
        if (iDataObject != null && iDataObject instanceof PSDepSysBase) {
            this.proxyPSDepSysBase = (PSDepSysBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_FROMPSDCID, 3);
        fieldIndexMap.put(FIELD_FROMPSDCNAME, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSDEPSYSID, 6);
        fieldIndexMap.put(FIELD_PSDEPSYSNAME, 7);
        fieldIndexMap.put(FIELD_PSDEPSYSTYPE, 8);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 9);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 10);
        fieldIndexMap.put(FIELD_PSDEVCENTERSVNID, 11);
        fieldIndexMap.put(FIELD_PSDEVCENTERSVNNAME, 12);
        fieldIndexMap.put(FIELD_PSSAASSYSID, 13);
        fieldIndexMap.put(FIELD_PSSAASSYSNAME, 14);
        fieldIndexMap.put(FIELD_ROPSDEVCENTERSVNID, 15);
        fieldIndexMap.put(FIELD_ROPSDEVCENTERSVNNAME, 16);
        fieldIndexMap.put(FIELD_SYSTAG, 17);
        fieldIndexMap.put(FIELD_SYSTAG2, 18);
        fieldIndexMap.put(FIELD_SYSTAG3, 19);
        fieldIndexMap.put(FIELD_SYSTAG4, 20);
        fieldIndexMap.put(FIELD_UPDATEDATE, 21);
        fieldIndexMap.put(FIELD_UPDATEMAN, 22);
        fieldIndexMap.put(FIELD_USERCAT, 23);
        fieldIndexMap.put(FIELD_USERTAG, 24);
        fieldIndexMap.put(FIELD_USERTAG2, 25);
        fieldIndexMap.put(FIELD_USERTAG3, 26);
        fieldIndexMap.put(FIELD_USERTAG4, 27);
        fieldIndexMap.put(FIELD_VALIDFLAG, 28);
    }
}

