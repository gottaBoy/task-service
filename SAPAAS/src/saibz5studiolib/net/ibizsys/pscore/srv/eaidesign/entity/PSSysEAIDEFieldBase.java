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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIDE;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIElementAttr;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIElementRE;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDEService;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIElementAttrService;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIElementREService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysEAIDEFieldBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysEAIDEFieldBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_EAIDEFTAG = "EAIDEFTAG";
    public static final String FIELD_EAIDEFTAG2 = "EAIDEFTAG2";
    public static final String FIELD_MAPTYPE = "MAPTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEFID = "PSDEFID";
    public static final String FIELD_PSDEFNAME = "PSDEFNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSSYSEAIDEFIELDID = "PSSYSEAIDEFIELDID";
    public static final String FIELD_PSSYSEAIDEFIELDNAME = "PSSYSEAIDEFIELDNAME";
    public static final String FIELD_PSSYSEAIDEID = "PSSYSEAIDEID";
    public static final String FIELD_PSSYSEAIDENAME = "PSSYSEAIDENAME";
    public static final String FIELD_PSSYSEAIELEMENTATTRID = "PSSYSEAIELEMENTATTRID";
    public static final String FIELD_PSSYSEAIELEMENTATTRNAME = "PSSYSEAIELEMENTATTRNAME";
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
    private static final int INDEX_EAIDEFTAG = 3;
    private static final int INDEX_EAIDEFTAG2 = 4;
    private static final int INDEX_MAPTYPE = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_PSDEFID = 7;
    private static final int INDEX_PSDEFNAME = 8;
    private static final int INDEX_PSDEID = 9;
    private static final int INDEX_PSSYSEAIDEFIELDID = 10;
    private static final int INDEX_PSSYSEAIDEFIELDNAME = 11;
    private static final int INDEX_PSSYSEAIDEID = 12;
    private static final int INDEX_PSSYSEAIDENAME = 13;
    private static final int INDEX_PSSYSEAIELEMENTATTRID = 14;
    private static final int INDEX_PSSYSEAIELEMENTATTRNAME = 15;
    private static final int INDEX_PSSYSEAIELEMENTID = 16;
    private static final int INDEX_PSSYSEAIELEMENTREID = 17;
    private static final int INDEX_PSSYSEAIELEMENTRENAME = 18;
    private static final int INDEX_UPDATEDATE = 19;
    private static final int INDEX_UPDATEMAN = 20;
    private static final int INDEX_USERCAT = 21;
    private static final int INDEX_USERTAG = 22;
    private static final int INDEX_USERTAG2 = 23;
    private static final int INDEX_USERTAG3 = 24;
    private static final int INDEX_USERTAG4 = 25;
    private static final int INDEX_VALIDFLAG = 26;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysEAIDEFieldBase proxyPSSysEAIDEFieldBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean eaideftagDirtyFlag = false;
    private boolean eaideftag2DirtyFlag = false;
    private boolean maptypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdefidDirtyFlag = false;
    private boolean psdefnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean pssyseaidefieldidDirtyFlag = false;
    private boolean pssyseaidefieldnameDirtyFlag = false;
    private boolean pssyseaideidDirtyFlag = false;
    private boolean pssyseaidenameDirtyFlag = false;
    private boolean pssyseaielementattridDirtyFlag = false;
    private boolean pssyseaielementattrnameDirtyFlag = false;
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
    @Column(name="eaideftag")
    private String eaideftag;
    @Column(name="eaideftag2")
    private String eaideftag2;
    @Column(name="maptype")
    private String maptype;
    @Column(name="memo")
    private String memo;
    @Column(name="psdefid")
    private String psdefid;
    @Column(name="psdefname")
    private String psdefname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="pssyseaidefieldid")
    private String pssyseaidefieldid;
    @Column(name="pssyseaidefieldname")
    private String pssyseaidefieldname;
    @Column(name="pssyseaideid")
    private String pssyseaideid;
    @Column(name="pssyseaidename")
    private String pssyseaidename;
    @Column(name="pssyseaielementattrid")
    private String pssyseaielementattrid;
    @Column(name="pssyseaielementattrname")
    private String pssyseaielementattrname;
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
    private Integer objPSDEFLock = new Integer(1);
    private PSDEField psdef = null;
    private Integer objPSSysEAIDELock = new Integer(1);
    private PSSysEAIDE pssyseaide = null;
    private Integer objPSSysEAIElementAttrLock = new Integer(1);
    private PSSysEAIElementAttr pssyseaielementattr = null;
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

    public void setEAIDEFTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEAIDEFTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.eaideftag = string;
        this.eaideftagDirtyFlag = true;
    }

    public String getEAIDEFTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEAIDEFTag();
        }
        return this.eaideftag;
    }

    public boolean isEAIDEFTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEAIDEFTagDirty();
        }
        return this.eaideftagDirtyFlag;
    }

    public void resetEAIDEFTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEAIDEFTag();
            return;
        }
        this.eaideftagDirtyFlag = false;
        this.eaideftag = null;
    }

    public void setEAIDEFTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEAIDEFTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.eaideftag2 = string;
        this.eaideftag2DirtyFlag = true;
    }

    public String getEAIDEFTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEAIDEFTag2();
        }
        return this.eaideftag2;
    }

    public boolean isEAIDEFTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEAIDEFTag2Dirty();
        }
        return this.eaideftag2DirtyFlag;
    }

    public void resetEAIDEFTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEAIDEFTag2();
            return;
        }
        this.eaideftag2DirtyFlag = false;
        this.eaideftag2 = null;
    }

    public void setMapType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMapType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.maptype = string;
        this.maptypeDirtyFlag = true;
    }

    public String getMapType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMapType();
        }
        return this.maptype;
    }

    public boolean isMapTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMapTypeDirty();
        }
        return this.maptypeDirtyFlag;
    }

    public void resetMapType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMapType();
            return;
        }
        this.maptypeDirtyFlag = false;
        this.maptype = null;
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

    public void setPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefid = string;
        this.psdefidDirtyFlag = true;
    }

    public String getPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFId();
        }
        return this.psdefid;
    }

    public boolean isPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFIdDirty();
        }
        return this.psdefidDirtyFlag;
    }

    public void resetPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFId();
            return;
        }
        this.psdefidDirtyFlag = false;
        this.psdefid = null;
    }

    public void setPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefname = string;
        this.psdefnameDirtyFlag = true;
    }

    public String getPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFName();
        }
        return this.psdefname;
    }

    public boolean isPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFNameDirty();
        }
        return this.psdefnameDirtyFlag;
    }

    public void resetPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFName();
            return;
        }
        this.psdefnameDirtyFlag = false;
        this.psdefname = null;
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

    public void setPSSysEAIDEFieldId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEAIDEFieldId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseaidefieldid = string;
        this.pssyseaidefieldidDirtyFlag = true;
    }

    public String getPSSysEAIDEFieldId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIDEFieldId();
        }
        return this.pssyseaidefieldid;
    }

    public boolean isPSSysEAIDEFieldIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEAIDEFieldIdDirty();
        }
        return this.pssyseaidefieldidDirtyFlag;
    }

    public void resetPSSysEAIDEFieldId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEAIDEFieldId();
            return;
        }
        this.pssyseaidefieldidDirtyFlag = false;
        this.pssyseaidefieldid = null;
    }

    public void setPSSysEAIDEFieldName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEAIDEFieldName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseaidefieldname = string;
        this.pssyseaidefieldnameDirtyFlag = true;
    }

    public String getPSSysEAIDEFieldName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIDEFieldName();
        }
        return this.pssyseaidefieldname;
    }

    public boolean isPSSysEAIDEFieldNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEAIDEFieldNameDirty();
        }
        return this.pssyseaidefieldnameDirtyFlag;
    }

    public void resetPSSysEAIDEFieldName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEAIDEFieldName();
            return;
        }
        this.pssyseaidefieldnameDirtyFlag = false;
        this.pssyseaidefieldname = null;
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

    public void setPSSysEAIElementAttrId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEAIElementAttrId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseaielementattrid = string;
        this.pssyseaielementattridDirtyFlag = true;
    }

    public String getPSSysEAIElementAttrId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIElementAttrId();
        }
        return this.pssyseaielementattrid;
    }

    public boolean isPSSysEAIElementAttrIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEAIElementAttrIdDirty();
        }
        return this.pssyseaielementattridDirtyFlag;
    }

    public void resetPSSysEAIElementAttrId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEAIElementAttrId();
            return;
        }
        this.pssyseaielementattridDirtyFlag = false;
        this.pssyseaielementattrid = null;
    }

    public void setPSSysEAIElementAttrName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEAIElementAttrName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseaielementattrname = string;
        this.pssyseaielementattrnameDirtyFlag = true;
    }

    public String getPSSysEAIElementAttrName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIElementAttrName();
        }
        return this.pssyseaielementattrname;
    }

    public boolean isPSSysEAIElementAttrNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEAIElementAttrNameDirty();
        }
        return this.pssyseaielementattrnameDirtyFlag;
    }

    public void resetPSSysEAIElementAttrName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEAIElementAttrName();
            return;
        }
        this.pssyseaielementattrnameDirtyFlag = false;
        this.pssyseaielementattrname = null;
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
        PSSysEAIDEFieldBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysEAIDEFieldBase pSSysEAIDEFieldBase) {
        pSSysEAIDEFieldBase.resetCodeName();
        pSSysEAIDEFieldBase.resetCreateDate();
        pSSysEAIDEFieldBase.resetCreateMan();
        pSSysEAIDEFieldBase.resetEAIDEFTag();
        pSSysEAIDEFieldBase.resetEAIDEFTag2();
        pSSysEAIDEFieldBase.resetMapType();
        pSSysEAIDEFieldBase.resetMemo();
        pSSysEAIDEFieldBase.resetPSDEFId();
        pSSysEAIDEFieldBase.resetPSDEFName();
        pSSysEAIDEFieldBase.resetPSDEId();
        pSSysEAIDEFieldBase.resetPSSysEAIDEFieldId();
        pSSysEAIDEFieldBase.resetPSSysEAIDEFieldName();
        pSSysEAIDEFieldBase.resetPSSysEAIDEId();
        pSSysEAIDEFieldBase.resetPSSysEAIDEName();
        pSSysEAIDEFieldBase.resetPSSysEAIElementAttrId();
        pSSysEAIDEFieldBase.resetPSSysEAIElementAttrName();
        pSSysEAIDEFieldBase.resetPSSysEAIElementId();
        pSSysEAIDEFieldBase.resetPSSysEAIElementREId();
        pSSysEAIDEFieldBase.resetPSSysEAIElementREName();
        pSSysEAIDEFieldBase.resetUpdateDate();
        pSSysEAIDEFieldBase.resetUpdateMan();
        pSSysEAIDEFieldBase.resetUserCat();
        pSSysEAIDEFieldBase.resetUserTag();
        pSSysEAIDEFieldBase.resetUserTag2();
        pSSysEAIDEFieldBase.resetUserTag3();
        pSSysEAIDEFieldBase.resetUserTag4();
        pSSysEAIDEFieldBase.resetValidFlag();
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
        if (!bl || this.isEAIDEFTagDirty()) {
            hashMap.put(FIELD_EAIDEFTAG, this.getEAIDEFTag());
        }
        if (!bl || this.isEAIDEFTag2Dirty()) {
            hashMap.put(FIELD_EAIDEFTAG2, this.getEAIDEFTag2());
        }
        if (!bl || this.isMapTypeDirty()) {
            hashMap.put(FIELD_MAPTYPE, this.getMapType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEFIdDirty()) {
            hashMap.put(FIELD_PSDEFID, this.getPSDEFId());
        }
        if (!bl || this.isPSDEFNameDirty()) {
            hashMap.put(FIELD_PSDEFNAME, this.getPSDEFName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSSysEAIDEFieldIdDirty()) {
            hashMap.put(FIELD_PSSYSEAIDEFIELDID, this.getPSSysEAIDEFieldId());
        }
        if (!bl || this.isPSSysEAIDEFieldNameDirty()) {
            hashMap.put(FIELD_PSSYSEAIDEFIELDNAME, this.getPSSysEAIDEFieldName());
        }
        if (!bl || this.isPSSysEAIDEIdDirty()) {
            hashMap.put(FIELD_PSSYSEAIDEID, this.getPSSysEAIDEId());
        }
        if (!bl || this.isPSSysEAIDENameDirty()) {
            hashMap.put(FIELD_PSSYSEAIDENAME, this.getPSSysEAIDEName());
        }
        if (!bl || this.isPSSysEAIElementAttrIdDirty()) {
            hashMap.put(FIELD_PSSYSEAIELEMENTATTRID, this.getPSSysEAIElementAttrId());
        }
        if (!bl || this.isPSSysEAIElementAttrNameDirty()) {
            hashMap.put(FIELD_PSSYSEAIELEMENTATTRNAME, this.getPSSysEAIElementAttrName());
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
        return PSSysEAIDEFieldBase.get(this, n);
    }

    private static Object get(PSSysEAIDEFieldBase pSSysEAIDEFieldBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysEAIDEFieldBase.getCodeName();
            }
            case 1: {
                return pSSysEAIDEFieldBase.getCreateDate();
            }
            case 2: {
                return pSSysEAIDEFieldBase.getCreateMan();
            }
            case 3: {
                return pSSysEAIDEFieldBase.getEAIDEFTag();
            }
            case 4: {
                return pSSysEAIDEFieldBase.getEAIDEFTag2();
            }
            case 5: {
                return pSSysEAIDEFieldBase.getMapType();
            }
            case 6: {
                return pSSysEAIDEFieldBase.getMemo();
            }
            case 7: {
                return pSSysEAIDEFieldBase.getPSDEFId();
            }
            case 8: {
                return pSSysEAIDEFieldBase.getPSDEFName();
            }
            case 9: {
                return pSSysEAIDEFieldBase.getPSDEId();
            }
            case 10: {
                return pSSysEAIDEFieldBase.getPSSysEAIDEFieldId();
            }
            case 11: {
                return pSSysEAIDEFieldBase.getPSSysEAIDEFieldName();
            }
            case 12: {
                return pSSysEAIDEFieldBase.getPSSysEAIDEId();
            }
            case 13: {
                return pSSysEAIDEFieldBase.getPSSysEAIDEName();
            }
            case 14: {
                return pSSysEAIDEFieldBase.getPSSysEAIElementAttrId();
            }
            case 15: {
                return pSSysEAIDEFieldBase.getPSSysEAIElementAttrName();
            }
            case 16: {
                return pSSysEAIDEFieldBase.getPSSysEAIElementId();
            }
            case 17: {
                return pSSysEAIDEFieldBase.getPSSysEAIElementREId();
            }
            case 18: {
                return pSSysEAIDEFieldBase.getPSSysEAIElementREName();
            }
            case 19: {
                return pSSysEAIDEFieldBase.getUpdateDate();
            }
            case 20: {
                return pSSysEAIDEFieldBase.getUpdateMan();
            }
            case 21: {
                return pSSysEAIDEFieldBase.getUserCat();
            }
            case 22: {
                return pSSysEAIDEFieldBase.getUserTag();
            }
            case 23: {
                return pSSysEAIDEFieldBase.getUserTag2();
            }
            case 24: {
                return pSSysEAIDEFieldBase.getUserTag3();
            }
            case 25: {
                return pSSysEAIDEFieldBase.getUserTag4();
            }
            case 26: {
                return pSSysEAIDEFieldBase.getValidFlag();
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
        PSSysEAIDEFieldBase.set(this, n, object);
    }

    private static void set(PSSysEAIDEFieldBase pSSysEAIDEFieldBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysEAIDEFieldBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysEAIDEFieldBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysEAIDEFieldBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysEAIDEFieldBase.setEAIDEFTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysEAIDEFieldBase.setEAIDEFTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysEAIDEFieldBase.setMapType(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysEAIDEFieldBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysEAIDEFieldBase.setPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysEAIDEFieldBase.setPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysEAIDEFieldBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysEAIDEFieldBase.setPSSysEAIDEFieldId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysEAIDEFieldBase.setPSSysEAIDEFieldName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysEAIDEFieldBase.setPSSysEAIDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysEAIDEFieldBase.setPSSysEAIDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysEAIDEFieldBase.setPSSysEAIElementAttrId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysEAIDEFieldBase.setPSSysEAIElementAttrName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysEAIDEFieldBase.setPSSysEAIElementId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysEAIDEFieldBase.setPSSysEAIElementREId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysEAIDEFieldBase.setPSSysEAIElementREName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysEAIDEFieldBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSSysEAIDEFieldBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysEAIDEFieldBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysEAIDEFieldBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysEAIDEFieldBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysEAIDEFieldBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysEAIDEFieldBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysEAIDEFieldBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysEAIDEFieldBase.isNull(this, n);
    }

    private static boolean isNull(PSSysEAIDEFieldBase pSSysEAIDEFieldBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysEAIDEFieldBase.getCodeName() == null;
            }
            case 1: {
                return pSSysEAIDEFieldBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysEAIDEFieldBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysEAIDEFieldBase.getEAIDEFTag() == null;
            }
            case 4: {
                return pSSysEAIDEFieldBase.getEAIDEFTag2() == null;
            }
            case 5: {
                return pSSysEAIDEFieldBase.getMapType() == null;
            }
            case 6: {
                return pSSysEAIDEFieldBase.getMemo() == null;
            }
            case 7: {
                return pSSysEAIDEFieldBase.getPSDEFId() == null;
            }
            case 8: {
                return pSSysEAIDEFieldBase.getPSDEFName() == null;
            }
            case 9: {
                return pSSysEAIDEFieldBase.getPSDEId() == null;
            }
            case 10: {
                return pSSysEAIDEFieldBase.getPSSysEAIDEFieldId() == null;
            }
            case 11: {
                return pSSysEAIDEFieldBase.getPSSysEAIDEFieldName() == null;
            }
            case 12: {
                return pSSysEAIDEFieldBase.getPSSysEAIDEId() == null;
            }
            case 13: {
                return pSSysEAIDEFieldBase.getPSSysEAIDEName() == null;
            }
            case 14: {
                return pSSysEAIDEFieldBase.getPSSysEAIElementAttrId() == null;
            }
            case 15: {
                return pSSysEAIDEFieldBase.getPSSysEAIElementAttrName() == null;
            }
            case 16: {
                return pSSysEAIDEFieldBase.getPSSysEAIElementId() == null;
            }
            case 17: {
                return pSSysEAIDEFieldBase.getPSSysEAIElementREId() == null;
            }
            case 18: {
                return pSSysEAIDEFieldBase.getPSSysEAIElementREName() == null;
            }
            case 19: {
                return pSSysEAIDEFieldBase.getUpdateDate() == null;
            }
            case 20: {
                return pSSysEAIDEFieldBase.getUpdateMan() == null;
            }
            case 21: {
                return pSSysEAIDEFieldBase.getUserCat() == null;
            }
            case 22: {
                return pSSysEAIDEFieldBase.getUserTag() == null;
            }
            case 23: {
                return pSSysEAIDEFieldBase.getUserTag2() == null;
            }
            case 24: {
                return pSSysEAIDEFieldBase.getUserTag3() == null;
            }
            case 25: {
                return pSSysEAIDEFieldBase.getUserTag4() == null;
            }
            case 26: {
                return pSSysEAIDEFieldBase.getValidFlag() == null;
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
        return PSSysEAIDEFieldBase.contains(this, n);
    }

    private static boolean contains(PSSysEAIDEFieldBase pSSysEAIDEFieldBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysEAIDEFieldBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysEAIDEFieldBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysEAIDEFieldBase.isCreateManDirty();
            }
            case 3: {
                return pSSysEAIDEFieldBase.isEAIDEFTagDirty();
            }
            case 4: {
                return pSSysEAIDEFieldBase.isEAIDEFTag2Dirty();
            }
            case 5: {
                return pSSysEAIDEFieldBase.isMapTypeDirty();
            }
            case 6: {
                return pSSysEAIDEFieldBase.isMemoDirty();
            }
            case 7: {
                return pSSysEAIDEFieldBase.isPSDEFIdDirty();
            }
            case 8: {
                return pSSysEAIDEFieldBase.isPSDEFNameDirty();
            }
            case 9: {
                return pSSysEAIDEFieldBase.isPSDEIdDirty();
            }
            case 10: {
                return pSSysEAIDEFieldBase.isPSSysEAIDEFieldIdDirty();
            }
            case 11: {
                return pSSysEAIDEFieldBase.isPSSysEAIDEFieldNameDirty();
            }
            case 12: {
                return pSSysEAIDEFieldBase.isPSSysEAIDEIdDirty();
            }
            case 13: {
                return pSSysEAIDEFieldBase.isPSSysEAIDENameDirty();
            }
            case 14: {
                return pSSysEAIDEFieldBase.isPSSysEAIElementAttrIdDirty();
            }
            case 15: {
                return pSSysEAIDEFieldBase.isPSSysEAIElementAttrNameDirty();
            }
            case 16: {
                return pSSysEAIDEFieldBase.isPSSysEAIElementIdDirty();
            }
            case 17: {
                return pSSysEAIDEFieldBase.isPSSysEAIElementREIdDirty();
            }
            case 18: {
                return pSSysEAIDEFieldBase.isPSSysEAIElementRENameDirty();
            }
            case 19: {
                return pSSysEAIDEFieldBase.isUpdateDateDirty();
            }
            case 20: {
                return pSSysEAIDEFieldBase.isUpdateManDirty();
            }
            case 21: {
                return pSSysEAIDEFieldBase.isUserCatDirty();
            }
            case 22: {
                return pSSysEAIDEFieldBase.isUserTagDirty();
            }
            case 23: {
                return pSSysEAIDEFieldBase.isUserTag2Dirty();
            }
            case 24: {
                return pSSysEAIDEFieldBase.isUserTag3Dirty();
            }
            case 25: {
                return pSSysEAIDEFieldBase.isUserTag4Dirty();
            }
            case 26: {
                return pSSysEAIDEFieldBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysEAIDEFieldBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysEAIDEFieldBase pSSysEAIDEFieldBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysEAIDEFieldBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysEAIDEFieldBase.getJSONValue((Object)pSSysEAIDEFieldBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysEAIDEFieldBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysEAIDEFieldBase.getJSONValue((Object)pSSysEAIDEFieldBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysEAIDEFieldBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysEAIDEFieldBase.getJSONValue((Object)pSSysEAIDEFieldBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysEAIDEFieldBase.getEAIDEFTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eaideftag", (Object)PSSysEAIDEFieldBase.getJSONValue((Object)pSSysEAIDEFieldBase.getEAIDEFTag()), (boolean)false);
        }
        if (bl || pSSysEAIDEFieldBase.getEAIDEFTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eaideftag2", (Object)PSSysEAIDEFieldBase.getJSONValue((Object)pSSysEAIDEFieldBase.getEAIDEFTag2()), (boolean)false);
        }
        if (bl || pSSysEAIDEFieldBase.getMapType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maptype", (Object)PSSysEAIDEFieldBase.getJSONValue((Object)pSSysEAIDEFieldBase.getMapType()), (boolean)false);
        }
        if (bl || pSSysEAIDEFieldBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysEAIDEFieldBase.getJSONValue((Object)pSSysEAIDEFieldBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysEAIDEFieldBase.getPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefid", (Object)PSSysEAIDEFieldBase.getJSONValue((Object)pSSysEAIDEFieldBase.getPSDEFId()), (boolean)false);
        }
        if (bl || pSSysEAIDEFieldBase.getPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefname", (Object)PSSysEAIDEFieldBase.getJSONValue((Object)pSSysEAIDEFieldBase.getPSDEFName()), (boolean)false);
        }
        if (bl || pSSysEAIDEFieldBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysEAIDEFieldBase.getJSONValue((Object)pSSysEAIDEFieldBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysEAIDEFieldBase.getPSSysEAIDEFieldId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaidefieldid", (Object)PSSysEAIDEFieldBase.getJSONValue((Object)pSSysEAIDEFieldBase.getPSSysEAIDEFieldId()), (boolean)false);
        }
        if (bl || pSSysEAIDEFieldBase.getPSSysEAIDEFieldName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaidefieldname", (Object)PSSysEAIDEFieldBase.getJSONValue((Object)pSSysEAIDEFieldBase.getPSSysEAIDEFieldName()), (boolean)false);
        }
        if (bl || pSSysEAIDEFieldBase.getPSSysEAIDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaideid", (Object)PSSysEAIDEFieldBase.getJSONValue((Object)pSSysEAIDEFieldBase.getPSSysEAIDEId()), (boolean)false);
        }
        if (bl || pSSysEAIDEFieldBase.getPSSysEAIDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaidename", (Object)PSSysEAIDEFieldBase.getJSONValue((Object)pSSysEAIDEFieldBase.getPSSysEAIDEName()), (boolean)false);
        }
        if (bl || pSSysEAIDEFieldBase.getPSSysEAIElementAttrId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaielementattrid", (Object)PSSysEAIDEFieldBase.getJSONValue((Object)pSSysEAIDEFieldBase.getPSSysEAIElementAttrId()), (boolean)false);
        }
        if (bl || pSSysEAIDEFieldBase.getPSSysEAIElementAttrName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaielementattrname", (Object)PSSysEAIDEFieldBase.getJSONValue((Object)pSSysEAIDEFieldBase.getPSSysEAIElementAttrName()), (boolean)false);
        }
        if (bl || pSSysEAIDEFieldBase.getPSSysEAIElementId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaielementid", (Object)PSSysEAIDEFieldBase.getJSONValue((Object)pSSysEAIDEFieldBase.getPSSysEAIElementId()), (boolean)false);
        }
        if (bl || pSSysEAIDEFieldBase.getPSSysEAIElementREId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaielementreid", (Object)PSSysEAIDEFieldBase.getJSONValue((Object)pSSysEAIDEFieldBase.getPSSysEAIElementREId()), (boolean)false);
        }
        if (bl || pSSysEAIDEFieldBase.getPSSysEAIElementREName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaielementrename", (Object)PSSysEAIDEFieldBase.getJSONValue((Object)pSSysEAIDEFieldBase.getPSSysEAIElementREName()), (boolean)false);
        }
        if (bl || pSSysEAIDEFieldBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysEAIDEFieldBase.getJSONValue((Object)pSSysEAIDEFieldBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysEAIDEFieldBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysEAIDEFieldBase.getJSONValue((Object)pSSysEAIDEFieldBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysEAIDEFieldBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysEAIDEFieldBase.getJSONValue((Object)pSSysEAIDEFieldBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysEAIDEFieldBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysEAIDEFieldBase.getJSONValue((Object)pSSysEAIDEFieldBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysEAIDEFieldBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysEAIDEFieldBase.getJSONValue((Object)pSSysEAIDEFieldBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysEAIDEFieldBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysEAIDEFieldBase.getJSONValue((Object)pSSysEAIDEFieldBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysEAIDEFieldBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysEAIDEFieldBase.getJSONValue((Object)pSSysEAIDEFieldBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysEAIDEFieldBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysEAIDEFieldBase.getJSONValue((Object)pSSysEAIDEFieldBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysEAIDEFieldBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysEAIDEFieldBase pSSysEAIDEFieldBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysEAIDEFieldBase.getCodeName() != null) {
            object = pSSysEAIDEFieldBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEFieldBase.getCreateDate() != null) {
            object = pSSysEAIDEFieldBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysEAIDEFieldBase.getCreateMan() != null) {
            object = pSSysEAIDEFieldBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEFieldBase.getEAIDEFTag() != null) {
            object = pSSysEAIDEFieldBase.getEAIDEFTag();
            xmlNode.setAttribute(FIELD_EAIDEFTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEFieldBase.getEAIDEFTag2() != null) {
            object = pSSysEAIDEFieldBase.getEAIDEFTag2();
            xmlNode.setAttribute(FIELD_EAIDEFTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEFieldBase.getMapType() != null) {
            object = pSSysEAIDEFieldBase.getMapType();
            xmlNode.setAttribute(FIELD_MAPTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEFieldBase.getMemo() != null) {
            object = pSSysEAIDEFieldBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEFieldBase.getPSDEFId() != null) {
            object = pSSysEAIDEFieldBase.getPSDEFId();
            xmlNode.setAttribute(FIELD_PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEFieldBase.getPSDEFName() != null) {
            object = pSSysEAIDEFieldBase.getPSDEFName();
            xmlNode.setAttribute(FIELD_PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEFieldBase.getPSDEId() != null) {
            object = pSSysEAIDEFieldBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEFieldBase.getPSSysEAIDEFieldId() != null) {
            object = pSSysEAIDEFieldBase.getPSSysEAIDEFieldId();
            xmlNode.setAttribute(FIELD_PSSYSEAIDEFIELDID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEFieldBase.getPSSysEAIDEFieldName() != null) {
            object = pSSysEAIDEFieldBase.getPSSysEAIDEFieldName();
            xmlNode.setAttribute(FIELD_PSSYSEAIDEFIELDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEFieldBase.getPSSysEAIDEId() != null) {
            object = pSSysEAIDEFieldBase.getPSSysEAIDEId();
            xmlNode.setAttribute(FIELD_PSSYSEAIDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEFieldBase.getPSSysEAIDEName() != null) {
            object = pSSysEAIDEFieldBase.getPSSysEAIDEName();
            xmlNode.setAttribute(FIELD_PSSYSEAIDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEFieldBase.getPSSysEAIElementAttrId() != null) {
            object = pSSysEAIDEFieldBase.getPSSysEAIElementAttrId();
            xmlNode.setAttribute(FIELD_PSSYSEAIELEMENTATTRID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEFieldBase.getPSSysEAIElementAttrName() != null) {
            object = pSSysEAIDEFieldBase.getPSSysEAIElementAttrName();
            xmlNode.setAttribute(FIELD_PSSYSEAIELEMENTATTRNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEFieldBase.getPSSysEAIElementId() != null) {
            object = pSSysEAIDEFieldBase.getPSSysEAIElementId();
            xmlNode.setAttribute(FIELD_PSSYSEAIELEMENTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEFieldBase.getPSSysEAIElementREId() != null) {
            object = pSSysEAIDEFieldBase.getPSSysEAIElementREId();
            xmlNode.setAttribute(FIELD_PSSYSEAIELEMENTREID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEFieldBase.getPSSysEAIElementREName() != null) {
            object = pSSysEAIDEFieldBase.getPSSysEAIElementREName();
            xmlNode.setAttribute(FIELD_PSSYSEAIELEMENTRENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEFieldBase.getUpdateDate() != null) {
            object = pSSysEAIDEFieldBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysEAIDEFieldBase.getUpdateMan() != null) {
            object = pSSysEAIDEFieldBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEFieldBase.getUserCat() != null) {
            object = pSSysEAIDEFieldBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEFieldBase.getUserTag() != null) {
            object = pSSysEAIDEFieldBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEFieldBase.getUserTag2() != null) {
            object = pSSysEAIDEFieldBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEFieldBase.getUserTag3() != null) {
            object = pSSysEAIDEFieldBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEFieldBase.getUserTag4() != null) {
            object = pSSysEAIDEFieldBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDEFieldBase.getValidFlag() != null) {
            object = pSSysEAIDEFieldBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysEAIDEFieldBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysEAIDEFieldBase pSSysEAIDEFieldBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysEAIDEFieldBase.isCodeNameDirty() && (bl || pSSysEAIDEFieldBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysEAIDEFieldBase.getCodeName());
        }
        if (pSSysEAIDEFieldBase.isCreateDateDirty() && (bl || pSSysEAIDEFieldBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysEAIDEFieldBase.getCreateDate());
        }
        if (pSSysEAIDEFieldBase.isCreateManDirty() && (bl || pSSysEAIDEFieldBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysEAIDEFieldBase.getCreateMan());
        }
        if (pSSysEAIDEFieldBase.isEAIDEFTagDirty() && (bl || pSSysEAIDEFieldBase.getEAIDEFTag() != null)) {
            iDataObject.set(FIELD_EAIDEFTAG, (Object)pSSysEAIDEFieldBase.getEAIDEFTag());
        }
        if (pSSysEAIDEFieldBase.isEAIDEFTag2Dirty() && (bl || pSSysEAIDEFieldBase.getEAIDEFTag2() != null)) {
            iDataObject.set(FIELD_EAIDEFTAG2, (Object)pSSysEAIDEFieldBase.getEAIDEFTag2());
        }
        if (pSSysEAIDEFieldBase.isMapTypeDirty() && (bl || pSSysEAIDEFieldBase.getMapType() != null)) {
            iDataObject.set(FIELD_MAPTYPE, (Object)pSSysEAIDEFieldBase.getMapType());
        }
        if (pSSysEAIDEFieldBase.isMemoDirty() && (bl || pSSysEAIDEFieldBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysEAIDEFieldBase.getMemo());
        }
        if (pSSysEAIDEFieldBase.isPSDEFIdDirty() && (bl || pSSysEAIDEFieldBase.getPSDEFId() != null)) {
            iDataObject.set(FIELD_PSDEFID, (Object)pSSysEAIDEFieldBase.getPSDEFId());
        }
        if (pSSysEAIDEFieldBase.isPSDEFNameDirty() && (bl || pSSysEAIDEFieldBase.getPSDEFName() != null)) {
            iDataObject.set(FIELD_PSDEFNAME, (Object)pSSysEAIDEFieldBase.getPSDEFName());
        }
        if (pSSysEAIDEFieldBase.isPSDEIdDirty() && (bl || pSSysEAIDEFieldBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysEAIDEFieldBase.getPSDEId());
        }
        if (pSSysEAIDEFieldBase.isPSSysEAIDEFieldIdDirty() && (bl || pSSysEAIDEFieldBase.getPSSysEAIDEFieldId() != null)) {
            iDataObject.set(FIELD_PSSYSEAIDEFIELDID, (Object)pSSysEAIDEFieldBase.getPSSysEAIDEFieldId());
        }
        if (pSSysEAIDEFieldBase.isPSSysEAIDEFieldNameDirty() && (bl || pSSysEAIDEFieldBase.getPSSysEAIDEFieldName() != null)) {
            iDataObject.set(FIELD_PSSYSEAIDEFIELDNAME, (Object)pSSysEAIDEFieldBase.getPSSysEAIDEFieldName());
        }
        if (pSSysEAIDEFieldBase.isPSSysEAIDEIdDirty() && (bl || pSSysEAIDEFieldBase.getPSSysEAIDEId() != null)) {
            iDataObject.set(FIELD_PSSYSEAIDEID, (Object)pSSysEAIDEFieldBase.getPSSysEAIDEId());
        }
        if (pSSysEAIDEFieldBase.isPSSysEAIDENameDirty() && (bl || pSSysEAIDEFieldBase.getPSSysEAIDEName() != null)) {
            iDataObject.set(FIELD_PSSYSEAIDENAME, (Object)pSSysEAIDEFieldBase.getPSSysEAIDEName());
        }
        if (pSSysEAIDEFieldBase.isPSSysEAIElementAttrIdDirty() && (bl || pSSysEAIDEFieldBase.getPSSysEAIElementAttrId() != null)) {
            iDataObject.set(FIELD_PSSYSEAIELEMENTATTRID, (Object)pSSysEAIDEFieldBase.getPSSysEAIElementAttrId());
        }
        if (pSSysEAIDEFieldBase.isPSSysEAIElementAttrNameDirty() && (bl || pSSysEAIDEFieldBase.getPSSysEAIElementAttrName() != null)) {
            iDataObject.set(FIELD_PSSYSEAIELEMENTATTRNAME, (Object)pSSysEAIDEFieldBase.getPSSysEAIElementAttrName());
        }
        if (pSSysEAIDEFieldBase.isPSSysEAIElementIdDirty() && (bl || pSSysEAIDEFieldBase.getPSSysEAIElementId() != null)) {
            iDataObject.set(FIELD_PSSYSEAIELEMENTID, (Object)pSSysEAIDEFieldBase.getPSSysEAIElementId());
        }
        if (pSSysEAIDEFieldBase.isPSSysEAIElementREIdDirty() && (bl || pSSysEAIDEFieldBase.getPSSysEAIElementREId() != null)) {
            iDataObject.set(FIELD_PSSYSEAIELEMENTREID, (Object)pSSysEAIDEFieldBase.getPSSysEAIElementREId());
        }
        if (pSSysEAIDEFieldBase.isPSSysEAIElementRENameDirty() && (bl || pSSysEAIDEFieldBase.getPSSysEAIElementREName() != null)) {
            iDataObject.set(FIELD_PSSYSEAIELEMENTRENAME, (Object)pSSysEAIDEFieldBase.getPSSysEAIElementREName());
        }
        if (pSSysEAIDEFieldBase.isUpdateDateDirty() && (bl || pSSysEAIDEFieldBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysEAIDEFieldBase.getUpdateDate());
        }
        if (pSSysEAIDEFieldBase.isUpdateManDirty() && (bl || pSSysEAIDEFieldBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysEAIDEFieldBase.getUpdateMan());
        }
        if (pSSysEAIDEFieldBase.isUserCatDirty() && (bl || pSSysEAIDEFieldBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysEAIDEFieldBase.getUserCat());
        }
        if (pSSysEAIDEFieldBase.isUserTagDirty() && (bl || pSSysEAIDEFieldBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysEAIDEFieldBase.getUserTag());
        }
        if (pSSysEAIDEFieldBase.isUserTag2Dirty() && (bl || pSSysEAIDEFieldBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysEAIDEFieldBase.getUserTag2());
        }
        if (pSSysEAIDEFieldBase.isUserTag3Dirty() && (bl || pSSysEAIDEFieldBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysEAIDEFieldBase.getUserTag3());
        }
        if (pSSysEAIDEFieldBase.isUserTag4Dirty() && (bl || pSSysEAIDEFieldBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysEAIDEFieldBase.getUserTag4());
        }
        if (pSSysEAIDEFieldBase.isValidFlagDirty() && (bl || pSSysEAIDEFieldBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysEAIDEFieldBase.getValidFlag());
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
        return PSSysEAIDEFieldBase.remove(this, n);
    }

    private static boolean remove(PSSysEAIDEFieldBase pSSysEAIDEFieldBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysEAIDEFieldBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysEAIDEFieldBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysEAIDEFieldBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysEAIDEFieldBase.resetEAIDEFTag();
                return true;
            }
            case 4: {
                pSSysEAIDEFieldBase.resetEAIDEFTag2();
                return true;
            }
            case 5: {
                pSSysEAIDEFieldBase.resetMapType();
                return true;
            }
            case 6: {
                pSSysEAIDEFieldBase.resetMemo();
                return true;
            }
            case 7: {
                pSSysEAIDEFieldBase.resetPSDEFId();
                return true;
            }
            case 8: {
                pSSysEAIDEFieldBase.resetPSDEFName();
                return true;
            }
            case 9: {
                pSSysEAIDEFieldBase.resetPSDEId();
                return true;
            }
            case 10: {
                pSSysEAIDEFieldBase.resetPSSysEAIDEFieldId();
                return true;
            }
            case 11: {
                pSSysEAIDEFieldBase.resetPSSysEAIDEFieldName();
                return true;
            }
            case 12: {
                pSSysEAIDEFieldBase.resetPSSysEAIDEId();
                return true;
            }
            case 13: {
                pSSysEAIDEFieldBase.resetPSSysEAIDEName();
                return true;
            }
            case 14: {
                pSSysEAIDEFieldBase.resetPSSysEAIElementAttrId();
                return true;
            }
            case 15: {
                pSSysEAIDEFieldBase.resetPSSysEAIElementAttrName();
                return true;
            }
            case 16: {
                pSSysEAIDEFieldBase.resetPSSysEAIElementId();
                return true;
            }
            case 17: {
                pSSysEAIDEFieldBase.resetPSSysEAIElementREId();
                return true;
            }
            case 18: {
                pSSysEAIDEFieldBase.resetPSSysEAIElementREName();
                return true;
            }
            case 19: {
                pSSysEAIDEFieldBase.resetUpdateDate();
                return true;
            }
            case 20: {
                pSSysEAIDEFieldBase.resetUpdateMan();
                return true;
            }
            case 21: {
                pSSysEAIDEFieldBase.resetUserCat();
                return true;
            }
            case 22: {
                pSSysEAIDEFieldBase.resetUserTag();
                return true;
            }
            case 23: {
                pSSysEAIDEFieldBase.resetUserTag2();
                return true;
            }
            case 24: {
                pSSysEAIDEFieldBase.resetUserTag3();
                return true;
            }
            case 25: {
                pSSysEAIDEFieldBase.resetUserTag4();
                return true;
            }
            case 26: {
                pSSysEAIDEFieldBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEF();
        }
        if (this.getPSDEFId() == null) {
            return null;
        }
        Integer n = this.objPSDEFLock;
        synchronized (n) {
            if (this.psdef != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFId(), (Object)this.psdef.getPSDEFieldId()) != 0L) {
                this.psdef = null;
            }
            if (this.psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.psdef = pSDEField;
            }
            return this.psdef;
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
                pSSysEAIDEService.autoGet((IEntity)pSSysEAIDE);
                this.pssyseaide = pSSysEAIDE;
            }
            return this.pssyseaide;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysEAIElementAttr getPSSysEAIElementAttr() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIElementAttr();
        }
        if (this.getPSSysEAIElementAttrId() == null) {
            return null;
        }
        Integer n = this.objPSSysEAIElementAttrLock;
        synchronized (n) {
            if (this.pssyseaielementattr != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysEAIElementAttrId(), (Object)this.pssyseaielementattr.getPSSysEAIElementAttrId()) != 0L) {
                this.pssyseaielementattr = null;
            }
            if (this.pssyseaielementattr == null) {
                PSSysEAIElementAttr pSSysEAIElementAttr = new PSSysEAIElementAttr();
                pSSysEAIElementAttr.setPSSysEAIElementAttrId(this.getPSSysEAIElementAttrId());
                PSSysEAIElementAttrService pSSysEAIElementAttrService = (PSSysEAIElementAttrService)ServiceGlobal.getService(PSSysEAIElementAttrService.class, (SessionFactory)this.getSessionFactory());
                pSSysEAIElementAttrService.autoGet((IEntity)pSSysEAIElementAttr);
                this.pssyseaielementattr = pSSysEAIElementAttr;
            }
            return this.pssyseaielementattr;
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
                pSSysEAIElementREService.autoGet((IEntity)pSSysEAIElementRE);
                this.pssyseaielementre = pSSysEAIElementRE;
            }
            return this.pssyseaielementre;
        }
    }

    private PSSysEAIDEFieldBase getProxyEntity() {
        return this.proxyPSSysEAIDEFieldBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysEAIDEFieldBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysEAIDEFieldBase) {
            this.proxyPSSysEAIDEFieldBase = (PSSysEAIDEFieldBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDEFieldService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_EAIDEFTAG, 3);
        fieldIndexMap.put(FIELD_EAIDEFTAG2, 4);
        fieldIndexMap.put(FIELD_MAPTYPE, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_PSDEFID, 7);
        fieldIndexMap.put(FIELD_PSDEFNAME, 8);
        fieldIndexMap.put(FIELD_PSDEID, 9);
        fieldIndexMap.put(FIELD_PSSYSEAIDEFIELDID, 10);
        fieldIndexMap.put(FIELD_PSSYSEAIDEFIELDNAME, 11);
        fieldIndexMap.put(FIELD_PSSYSEAIDEID, 12);
        fieldIndexMap.put(FIELD_PSSYSEAIDENAME, 13);
        fieldIndexMap.put(FIELD_PSSYSEAIELEMENTATTRID, 14);
        fieldIndexMap.put(FIELD_PSSYSEAIELEMENTATTRNAME, 15);
        fieldIndexMap.put(FIELD_PSSYSEAIELEMENTID, 16);
        fieldIndexMap.put(FIELD_PSSYSEAIELEMENTREID, 17);
        fieldIndexMap.put(FIELD_PSSYSEAIELEMENTRENAME, 18);
        fieldIndexMap.put(FIELD_UPDATEDATE, 19);
        fieldIndexMap.put(FIELD_UPDATEMAN, 20);
        fieldIndexMap.put(FIELD_USERCAT, 21);
        fieldIndexMap.put(FIELD_USERTAG, 22);
        fieldIndexMap.put(FIELD_USERTAG2, 23);
        fieldIndexMap.put(FIELD_USERTAG3, 24);
        fieldIndexMap.put(FIELD_USERTAG4, 25);
        fieldIndexMap.put(FIELD_VALIDFLAG, 26);
    }
}

