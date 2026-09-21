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
package net.ibizsys.pscore.srv.dedesign.entity;

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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMap;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTranslator;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTranslatorService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEMapDetailBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEMapDetailBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DSTFIELDNAME = "DSTFIELDNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDEMAPDETAILID = "PSDEMAPDETAILID";
    public static final String FIELD_PSDEMAPDETAILNAME = "PSDEMAPDETAILNAME";
    public static final String FIELD_PSDEMAPID = "PSDEMAPID";
    public static final String FIELD_PSDEMAPNAME = "PSDEMAPNAME";
    public static final String FIELD_PSSYSTRANSLATORID = "PSSYSTRANSLATORID";
    public static final String FIELD_PSSYSTRANSLATORNAME = "PSSYSTRANSLATORNAME";
    public static final String FIELD_SRCPSDEFID = "SRCPSDEFID";
    public static final String FIELD_SRCPSDEFNAME = "SRCPSDEFNAME";
    public static final String FIELD_SRCTYPE = "SRCTYPE";
    public static final String FIELD_SRCVALUE = "SRCVALUE";
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
    private static final int INDEX_DSTFIELDNAME = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSDEID = 4;
    private static final int INDEX_PSDEMAPDETAILID = 5;
    private static final int INDEX_PSDEMAPDETAILNAME = 6;
    private static final int INDEX_PSDEMAPID = 7;
    private static final int INDEX_PSDEMAPNAME = 8;
    private static final int INDEX_PSSYSTRANSLATORID = 9;
    private static final int INDEX_PSSYSTRANSLATORNAME = 10;
    private static final int INDEX_SRCPSDEFID = 11;
    private static final int INDEX_SRCPSDEFNAME = 12;
    private static final int INDEX_SRCTYPE = 13;
    private static final int INDEX_SRCVALUE = 14;
    private static final int INDEX_UPDATEDATE = 15;
    private static final int INDEX_UPDATEMAN = 16;
    private static final int INDEX_USERCAT = 17;
    private static final int INDEX_USERTAG = 18;
    private static final int INDEX_USERTAG2 = 19;
    private static final int INDEX_USERTAG3 = 20;
    private static final int INDEX_USERTAG4 = 21;
    private static final int INDEX_VALIDFLAG = 22;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEMapDetailBase proxyPSDEMapDetailBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dstfieldnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdemapdetailidDirtyFlag = false;
    private boolean psdemapdetailnameDirtyFlag = false;
    private boolean psdemapidDirtyFlag = false;
    private boolean psdemapnameDirtyFlag = false;
    private boolean pssystranslatoridDirtyFlag = false;
    private boolean pssystranslatornameDirtyFlag = false;
    private boolean srcpsdefidDirtyFlag = false;
    private boolean srcpsdefnameDirtyFlag = false;
    private boolean srctypeDirtyFlag = false;
    private boolean srcvalueDirtyFlag = false;
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
    @Column(name="dstfieldname")
    private String dstfieldname;
    @Column(name="memo")
    private String memo;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdemapdetailid")
    private String psdemapdetailid;
    @Column(name="psdemapdetailname")
    private String psdemapdetailname;
    @Column(name="psdemapid")
    private String psdemapid;
    @Column(name="psdemapname")
    private String psdemapname;
    @Column(name="pssystranslatorid")
    private String pssystranslatorid;
    @Column(name="pssystranslatorname")
    private String pssystranslatorname;
    @Column(name="srcpsdefid")
    private String srcpsdefid;
    @Column(name="srcpsdefname")
    private String srcpsdefname;
    @Column(name="srctype")
    private String srctype;
    @Column(name="srcvalue")
    private String srcvalue;
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
    private Integer objSrcPSDEFLock = new Integer(1);
    private PSDEField srcpsdef = null;
    private Integer objPSDEMapLock = new Integer(1);
    private PSDEMap psdemap = null;
    private Integer objPSSysTranslatorLock = new Integer(1);
    private PSSysTranslator pssystranslator = null;

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

    public void setDstFieldName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstFieldName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstfieldname = string;
        this.dstfieldnameDirtyFlag = true;
    }

    public String getDstFieldName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstFieldName();
        }
        return this.dstfieldname;
    }

    public boolean isDstFieldNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstFieldNameDirty();
        }
        return this.dstfieldnameDirtyFlag;
    }

    public void resetDstFieldName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstFieldName();
            return;
        }
        this.dstfieldnameDirtyFlag = false;
        this.dstfieldname = null;
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

    public void setPSDEMapDetailId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMapDetailId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemapdetailid = string;
        this.psdemapdetailidDirtyFlag = true;
    }

    public String getPSDEMapDetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMapDetailId();
        }
        return this.psdemapdetailid;
    }

    public boolean isPSDEMapDetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMapDetailIdDirty();
        }
        return this.psdemapdetailidDirtyFlag;
    }

    public void resetPSDEMapDetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMapDetailId();
            return;
        }
        this.psdemapdetailidDirtyFlag = false;
        this.psdemapdetailid = null;
    }

    public void setPSDEMapDetailName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMapDetailName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemapdetailname = string;
        this.psdemapdetailnameDirtyFlag = true;
    }

    public String getPSDEMapDetailName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMapDetailName();
        }
        return this.psdemapdetailname;
    }

    public boolean isPSDEMapDetailNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMapDetailNameDirty();
        }
        return this.psdemapdetailnameDirtyFlag;
    }

    public void resetPSDEMapDetailName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMapDetailName();
            return;
        }
        this.psdemapdetailnameDirtyFlag = false;
        this.psdemapdetailname = null;
    }

    public void setPSDEMapId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMapId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemapid = string;
        this.psdemapidDirtyFlag = true;
    }

    public String getPSDEMapId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMapId();
        }
        return this.psdemapid;
    }

    public boolean isPSDEMapIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMapIdDirty();
        }
        return this.psdemapidDirtyFlag;
    }

    public void resetPSDEMapId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMapId();
            return;
        }
        this.psdemapidDirtyFlag = false;
        this.psdemapid = null;
    }

    public void setPSDEMapName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMapName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemapname = string;
        this.psdemapnameDirtyFlag = true;
    }

    public String getPSDEMapName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMapName();
        }
        return this.psdemapname;
    }

    public boolean isPSDEMapNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMapNameDirty();
        }
        return this.psdemapnameDirtyFlag;
    }

    public void resetPSDEMapName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMapName();
            return;
        }
        this.psdemapnameDirtyFlag = false;
        this.psdemapname = null;
    }

    public void setPSSysTranslatorId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTranslatorId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystranslatorid = string;
        this.pssystranslatoridDirtyFlag = true;
    }

    public String getPSSysTranslatorId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTranslatorId();
        }
        return this.pssystranslatorid;
    }

    public boolean isPSSysTranslatorIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTranslatorIdDirty();
        }
        return this.pssystranslatoridDirtyFlag;
    }

    public void resetPSSysTranslatorId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTranslatorId();
            return;
        }
        this.pssystranslatoridDirtyFlag = false;
        this.pssystranslatorid = null;
    }

    public void setPSSysTranslatorName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTranslatorName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystranslatorname = string;
        this.pssystranslatornameDirtyFlag = true;
    }

    public String getPSSysTranslatorName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTranslatorName();
        }
        return this.pssystranslatorname;
    }

    public boolean isPSSysTranslatorNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTranslatorNameDirty();
        }
        return this.pssystranslatornameDirtyFlag;
    }

    public void resetPSSysTranslatorName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTranslatorName();
            return;
        }
        this.pssystranslatornameDirtyFlag = false;
        this.pssystranslatorname = null;
    }

    public void setSrcPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcpsdefid = string;
        this.srcpsdefidDirtyFlag = true;
    }

    public String getSrcPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSDEFId();
        }
        return this.srcpsdefid;
    }

    public boolean isSrcPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcPSDEFIdDirty();
        }
        return this.srcpsdefidDirtyFlag;
    }

    public void resetSrcPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcPSDEFId();
            return;
        }
        this.srcpsdefidDirtyFlag = false;
        this.srcpsdefid = null;
    }

    public void setSrcPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcpsdefname = string;
        this.srcpsdefnameDirtyFlag = true;
    }

    public String getSrcPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSDEFName();
        }
        return this.srcpsdefname;
    }

    public boolean isSrcPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcPSDEFNameDirty();
        }
        return this.srcpsdefnameDirtyFlag;
    }

    public void resetSrcPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcPSDEFName();
            return;
        }
        this.srcpsdefnameDirtyFlag = false;
        this.srcpsdefname = null;
    }

    public void setSrcType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srctype = string;
        this.srctypeDirtyFlag = true;
    }

    public String getSrcType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcType();
        }
        return this.srctype;
    }

    public boolean isSrcTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcTypeDirty();
        }
        return this.srctypeDirtyFlag;
    }

    public void resetSrcType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcType();
            return;
        }
        this.srctypeDirtyFlag = false;
        this.srctype = null;
    }

    public void setSrcValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcvalue = string;
        this.srcvalueDirtyFlag = true;
    }

    public String getSrcValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcValue();
        }
        return this.srcvalue;
    }

    public boolean isSrcValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcValueDirty();
        }
        return this.srcvalueDirtyFlag;
    }

    public void resetSrcValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcValue();
            return;
        }
        this.srcvalueDirtyFlag = false;
        this.srcvalue = null;
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
        PSDEMapDetailBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEMapDetailBase pSDEMapDetailBase) {
        pSDEMapDetailBase.resetCreateDate();
        pSDEMapDetailBase.resetCreateMan();
        pSDEMapDetailBase.resetDstFieldName();
        pSDEMapDetailBase.resetMemo();
        pSDEMapDetailBase.resetPSDEId();
        pSDEMapDetailBase.resetPSDEMapDetailId();
        pSDEMapDetailBase.resetPSDEMapDetailName();
        pSDEMapDetailBase.resetPSDEMapId();
        pSDEMapDetailBase.resetPSDEMapName();
        pSDEMapDetailBase.resetPSSysTranslatorId();
        pSDEMapDetailBase.resetPSSysTranslatorName();
        pSDEMapDetailBase.resetSrcPSDEFId();
        pSDEMapDetailBase.resetSrcPSDEFName();
        pSDEMapDetailBase.resetSrcType();
        pSDEMapDetailBase.resetSrcValue();
        pSDEMapDetailBase.resetUpdateDate();
        pSDEMapDetailBase.resetUpdateMan();
        pSDEMapDetailBase.resetUserCat();
        pSDEMapDetailBase.resetUserTag();
        pSDEMapDetailBase.resetUserTag2();
        pSDEMapDetailBase.resetUserTag3();
        pSDEMapDetailBase.resetUserTag4();
        pSDEMapDetailBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDstFieldNameDirty()) {
            hashMap.put(FIELD_DSTFIELDNAME, this.getDstFieldName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDEMapDetailIdDirty()) {
            hashMap.put(FIELD_PSDEMAPDETAILID, this.getPSDEMapDetailId());
        }
        if (!bl || this.isPSDEMapDetailNameDirty()) {
            hashMap.put(FIELD_PSDEMAPDETAILNAME, this.getPSDEMapDetailName());
        }
        if (!bl || this.isPSDEMapIdDirty()) {
            hashMap.put(FIELD_PSDEMAPID, this.getPSDEMapId());
        }
        if (!bl || this.isPSDEMapNameDirty()) {
            hashMap.put(FIELD_PSDEMAPNAME, this.getPSDEMapName());
        }
        if (!bl || this.isPSSysTranslatorIdDirty()) {
            hashMap.put(FIELD_PSSYSTRANSLATORID, this.getPSSysTranslatorId());
        }
        if (!bl || this.isPSSysTranslatorNameDirty()) {
            hashMap.put(FIELD_PSSYSTRANSLATORNAME, this.getPSSysTranslatorName());
        }
        if (!bl || this.isSrcPSDEFIdDirty()) {
            hashMap.put(FIELD_SRCPSDEFID, this.getSrcPSDEFId());
        }
        if (!bl || this.isSrcPSDEFNameDirty()) {
            hashMap.put(FIELD_SRCPSDEFNAME, this.getSrcPSDEFName());
        }
        if (!bl || this.isSrcTypeDirty()) {
            hashMap.put(FIELD_SRCTYPE, this.getSrcType());
        }
        if (!bl || this.isSrcValueDirty()) {
            hashMap.put(FIELD_SRCVALUE, this.getSrcValue());
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
        return PSDEMapDetailBase.get(this, n);
    }

    private static Object get(PSDEMapDetailBase pSDEMapDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEMapDetailBase.getCreateDate();
            }
            case 1: {
                return pSDEMapDetailBase.getCreateMan();
            }
            case 2: {
                return pSDEMapDetailBase.getDstFieldName();
            }
            case 3: {
                return pSDEMapDetailBase.getMemo();
            }
            case 4: {
                return pSDEMapDetailBase.getPSDEId();
            }
            case 5: {
                return pSDEMapDetailBase.getPSDEMapDetailId();
            }
            case 6: {
                return pSDEMapDetailBase.getPSDEMapDetailName();
            }
            case 7: {
                return pSDEMapDetailBase.getPSDEMapId();
            }
            case 8: {
                return pSDEMapDetailBase.getPSDEMapName();
            }
            case 9: {
                return pSDEMapDetailBase.getPSSysTranslatorId();
            }
            case 10: {
                return pSDEMapDetailBase.getPSSysTranslatorName();
            }
            case 11: {
                return pSDEMapDetailBase.getSrcPSDEFId();
            }
            case 12: {
                return pSDEMapDetailBase.getSrcPSDEFName();
            }
            case 13: {
                return pSDEMapDetailBase.getSrcType();
            }
            case 14: {
                return pSDEMapDetailBase.getSrcValue();
            }
            case 15: {
                return pSDEMapDetailBase.getUpdateDate();
            }
            case 16: {
                return pSDEMapDetailBase.getUpdateMan();
            }
            case 17: {
                return pSDEMapDetailBase.getUserCat();
            }
            case 18: {
                return pSDEMapDetailBase.getUserTag();
            }
            case 19: {
                return pSDEMapDetailBase.getUserTag2();
            }
            case 20: {
                return pSDEMapDetailBase.getUserTag3();
            }
            case 21: {
                return pSDEMapDetailBase.getUserTag4();
            }
            case 22: {
                return pSDEMapDetailBase.getValidFlag();
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
        PSDEMapDetailBase.set(this, n, object);
    }

    private static void set(PSDEMapDetailBase pSDEMapDetailBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEMapDetailBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEMapDetailBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEMapDetailBase.setDstFieldName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEMapDetailBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEMapDetailBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEMapDetailBase.setPSDEMapDetailId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEMapDetailBase.setPSDEMapDetailName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEMapDetailBase.setPSDEMapId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEMapDetailBase.setPSDEMapName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEMapDetailBase.setPSSysTranslatorId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEMapDetailBase.setPSSysTranslatorName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEMapDetailBase.setSrcPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEMapDetailBase.setSrcPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEMapDetailBase.setSrcType(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEMapDetailBase.setSrcValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEMapDetailBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 16: {
                pSDEMapDetailBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEMapDetailBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEMapDetailBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEMapDetailBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEMapDetailBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEMapDetailBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEMapDetailBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEMapDetailBase.isNull(this, n);
    }

    private static boolean isNull(PSDEMapDetailBase pSDEMapDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEMapDetailBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEMapDetailBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEMapDetailBase.getDstFieldName() == null;
            }
            case 3: {
                return pSDEMapDetailBase.getMemo() == null;
            }
            case 4: {
                return pSDEMapDetailBase.getPSDEId() == null;
            }
            case 5: {
                return pSDEMapDetailBase.getPSDEMapDetailId() == null;
            }
            case 6: {
                return pSDEMapDetailBase.getPSDEMapDetailName() == null;
            }
            case 7: {
                return pSDEMapDetailBase.getPSDEMapId() == null;
            }
            case 8: {
                return pSDEMapDetailBase.getPSDEMapName() == null;
            }
            case 9: {
                return pSDEMapDetailBase.getPSSysTranslatorId() == null;
            }
            case 10: {
                return pSDEMapDetailBase.getPSSysTranslatorName() == null;
            }
            case 11: {
                return pSDEMapDetailBase.getSrcPSDEFId() == null;
            }
            case 12: {
                return pSDEMapDetailBase.getSrcPSDEFName() == null;
            }
            case 13: {
                return pSDEMapDetailBase.getSrcType() == null;
            }
            case 14: {
                return pSDEMapDetailBase.getSrcValue() == null;
            }
            case 15: {
                return pSDEMapDetailBase.getUpdateDate() == null;
            }
            case 16: {
                return pSDEMapDetailBase.getUpdateMan() == null;
            }
            case 17: {
                return pSDEMapDetailBase.getUserCat() == null;
            }
            case 18: {
                return pSDEMapDetailBase.getUserTag() == null;
            }
            case 19: {
                return pSDEMapDetailBase.getUserTag2() == null;
            }
            case 20: {
                return pSDEMapDetailBase.getUserTag3() == null;
            }
            case 21: {
                return pSDEMapDetailBase.getUserTag4() == null;
            }
            case 22: {
                return pSDEMapDetailBase.getValidFlag() == null;
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
        return PSDEMapDetailBase.contains(this, n);
    }

    private static boolean contains(PSDEMapDetailBase pSDEMapDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEMapDetailBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEMapDetailBase.isCreateManDirty();
            }
            case 2: {
                return pSDEMapDetailBase.isDstFieldNameDirty();
            }
            case 3: {
                return pSDEMapDetailBase.isMemoDirty();
            }
            case 4: {
                return pSDEMapDetailBase.isPSDEIdDirty();
            }
            case 5: {
                return pSDEMapDetailBase.isPSDEMapDetailIdDirty();
            }
            case 6: {
                return pSDEMapDetailBase.isPSDEMapDetailNameDirty();
            }
            case 7: {
                return pSDEMapDetailBase.isPSDEMapIdDirty();
            }
            case 8: {
                return pSDEMapDetailBase.isPSDEMapNameDirty();
            }
            case 9: {
                return pSDEMapDetailBase.isPSSysTranslatorIdDirty();
            }
            case 10: {
                return pSDEMapDetailBase.isPSSysTranslatorNameDirty();
            }
            case 11: {
                return pSDEMapDetailBase.isSrcPSDEFIdDirty();
            }
            case 12: {
                return pSDEMapDetailBase.isSrcPSDEFNameDirty();
            }
            case 13: {
                return pSDEMapDetailBase.isSrcTypeDirty();
            }
            case 14: {
                return pSDEMapDetailBase.isSrcValueDirty();
            }
            case 15: {
                return pSDEMapDetailBase.isUpdateDateDirty();
            }
            case 16: {
                return pSDEMapDetailBase.isUpdateManDirty();
            }
            case 17: {
                return pSDEMapDetailBase.isUserCatDirty();
            }
            case 18: {
                return pSDEMapDetailBase.isUserTagDirty();
            }
            case 19: {
                return pSDEMapDetailBase.isUserTag2Dirty();
            }
            case 20: {
                return pSDEMapDetailBase.isUserTag3Dirty();
            }
            case 21: {
                return pSDEMapDetailBase.isUserTag4Dirty();
            }
            case 22: {
                return pSDEMapDetailBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEMapDetailBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEMapDetailBase pSDEMapDetailBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEMapDetailBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEMapDetailBase.getJSONValue((Object)pSDEMapDetailBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEMapDetailBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEMapDetailBase.getJSONValue((Object)pSDEMapDetailBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEMapDetailBase.getDstFieldName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstfieldname", (Object)PSDEMapDetailBase.getJSONValue((Object)pSDEMapDetailBase.getDstFieldName()), (boolean)false);
        }
        if (bl || pSDEMapDetailBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEMapDetailBase.getJSONValue((Object)pSDEMapDetailBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEMapDetailBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEMapDetailBase.getJSONValue((Object)pSDEMapDetailBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEMapDetailBase.getPSDEMapDetailId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemapdetailid", (Object)PSDEMapDetailBase.getJSONValue((Object)pSDEMapDetailBase.getPSDEMapDetailId()), (boolean)false);
        }
        if (bl || pSDEMapDetailBase.getPSDEMapDetailName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemapdetailname", (Object)PSDEMapDetailBase.getJSONValue((Object)pSDEMapDetailBase.getPSDEMapDetailName()), (boolean)false);
        }
        if (bl || pSDEMapDetailBase.getPSDEMapId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemapid", (Object)PSDEMapDetailBase.getJSONValue((Object)pSDEMapDetailBase.getPSDEMapId()), (boolean)false);
        }
        if (bl || pSDEMapDetailBase.getPSDEMapName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemapname", (Object)PSDEMapDetailBase.getJSONValue((Object)pSDEMapDetailBase.getPSDEMapName()), (boolean)false);
        }
        if (bl || pSDEMapDetailBase.getPSSysTranslatorId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystranslatorid", (Object)PSDEMapDetailBase.getJSONValue((Object)pSDEMapDetailBase.getPSSysTranslatorId()), (boolean)false);
        }
        if (bl || pSDEMapDetailBase.getPSSysTranslatorName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystranslatorname", (Object)PSDEMapDetailBase.getJSONValue((Object)pSDEMapDetailBase.getPSSysTranslatorName()), (boolean)false);
        }
        if (bl || pSDEMapDetailBase.getSrcPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpsdefid", (Object)PSDEMapDetailBase.getJSONValue((Object)pSDEMapDetailBase.getSrcPSDEFId()), (boolean)false);
        }
        if (bl || pSDEMapDetailBase.getSrcPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpsdefname", (Object)PSDEMapDetailBase.getJSONValue((Object)pSDEMapDetailBase.getSrcPSDEFName()), (boolean)false);
        }
        if (bl || pSDEMapDetailBase.getSrcType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srctype", (Object)PSDEMapDetailBase.getJSONValue((Object)pSDEMapDetailBase.getSrcType()), (boolean)false);
        }
        if (bl || pSDEMapDetailBase.getSrcValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcvalue", (Object)PSDEMapDetailBase.getJSONValue((Object)pSDEMapDetailBase.getSrcValue()), (boolean)false);
        }
        if (bl || pSDEMapDetailBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEMapDetailBase.getJSONValue((Object)pSDEMapDetailBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEMapDetailBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEMapDetailBase.getJSONValue((Object)pSDEMapDetailBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEMapDetailBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEMapDetailBase.getJSONValue((Object)pSDEMapDetailBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEMapDetailBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEMapDetailBase.getJSONValue((Object)pSDEMapDetailBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEMapDetailBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEMapDetailBase.getJSONValue((Object)pSDEMapDetailBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEMapDetailBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEMapDetailBase.getJSONValue((Object)pSDEMapDetailBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEMapDetailBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEMapDetailBase.getJSONValue((Object)pSDEMapDetailBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEMapDetailBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEMapDetailBase.getJSONValue((Object)pSDEMapDetailBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEMapDetailBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEMapDetailBase pSDEMapDetailBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEMapDetailBase.getCreateDate() != null) {
            object = pSDEMapDetailBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEMapDetailBase.getCreateMan() != null) {
            object = pSDEMapDetailBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDetailBase.getDstFieldName() != null) {
            object = pSDEMapDetailBase.getDstFieldName();
            xmlNode.setAttribute(FIELD_DSTFIELDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDetailBase.getMemo() != null) {
            object = pSDEMapDetailBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDetailBase.getPSDEId() != null) {
            object = pSDEMapDetailBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDetailBase.getPSDEMapDetailId() != null) {
            object = pSDEMapDetailBase.getPSDEMapDetailId();
            xmlNode.setAttribute(FIELD_PSDEMAPDETAILID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDetailBase.getPSDEMapDetailName() != null) {
            object = pSDEMapDetailBase.getPSDEMapDetailName();
            xmlNode.setAttribute(FIELD_PSDEMAPDETAILNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDetailBase.getPSDEMapId() != null) {
            object = pSDEMapDetailBase.getPSDEMapId();
            xmlNode.setAttribute(FIELD_PSDEMAPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDetailBase.getPSDEMapName() != null) {
            object = pSDEMapDetailBase.getPSDEMapName();
            xmlNode.setAttribute(FIELD_PSDEMAPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDetailBase.getPSSysTranslatorId() != null) {
            object = pSDEMapDetailBase.getPSSysTranslatorId();
            xmlNode.setAttribute(FIELD_PSSYSTRANSLATORID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDetailBase.getPSSysTranslatorName() != null) {
            object = pSDEMapDetailBase.getPSSysTranslatorName();
            xmlNode.setAttribute(FIELD_PSSYSTRANSLATORNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDetailBase.getSrcPSDEFId() != null) {
            object = pSDEMapDetailBase.getSrcPSDEFId();
            xmlNode.setAttribute(FIELD_SRCPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDetailBase.getSrcPSDEFName() != null) {
            object = pSDEMapDetailBase.getSrcPSDEFName();
            xmlNode.setAttribute(FIELD_SRCPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDetailBase.getSrcType() != null) {
            object = pSDEMapDetailBase.getSrcType();
            xmlNode.setAttribute(FIELD_SRCTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDetailBase.getSrcValue() != null) {
            object = pSDEMapDetailBase.getSrcValue();
            xmlNode.setAttribute(FIELD_SRCVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDetailBase.getUpdateDate() != null) {
            object = pSDEMapDetailBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEMapDetailBase.getUpdateMan() != null) {
            object = pSDEMapDetailBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDetailBase.getUserCat() != null) {
            object = pSDEMapDetailBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDetailBase.getUserTag() != null) {
            object = pSDEMapDetailBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDetailBase.getUserTag2() != null) {
            object = pSDEMapDetailBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDetailBase.getUserTag3() != null) {
            object = pSDEMapDetailBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDetailBase.getUserTag4() != null) {
            object = pSDEMapDetailBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDetailBase.getValidFlag() != null) {
            object = pSDEMapDetailBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEMapDetailBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEMapDetailBase pSDEMapDetailBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEMapDetailBase.isCreateDateDirty() && (bl || pSDEMapDetailBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEMapDetailBase.getCreateDate());
        }
        if (pSDEMapDetailBase.isCreateManDirty() && (bl || pSDEMapDetailBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEMapDetailBase.getCreateMan());
        }
        if (pSDEMapDetailBase.isDstFieldNameDirty() && (bl || pSDEMapDetailBase.getDstFieldName() != null)) {
            iDataObject.set(FIELD_DSTFIELDNAME, (Object)pSDEMapDetailBase.getDstFieldName());
        }
        if (pSDEMapDetailBase.isMemoDirty() && (bl || pSDEMapDetailBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEMapDetailBase.getMemo());
        }
        if (pSDEMapDetailBase.isPSDEIdDirty() && (bl || pSDEMapDetailBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEMapDetailBase.getPSDEId());
        }
        if (pSDEMapDetailBase.isPSDEMapDetailIdDirty() && (bl || pSDEMapDetailBase.getPSDEMapDetailId() != null)) {
            iDataObject.set(FIELD_PSDEMAPDETAILID, (Object)pSDEMapDetailBase.getPSDEMapDetailId());
        }
        if (pSDEMapDetailBase.isPSDEMapDetailNameDirty() && (bl || pSDEMapDetailBase.getPSDEMapDetailName() != null)) {
            iDataObject.set(FIELD_PSDEMAPDETAILNAME, (Object)pSDEMapDetailBase.getPSDEMapDetailName());
        }
        if (pSDEMapDetailBase.isPSDEMapIdDirty() && (bl || pSDEMapDetailBase.getPSDEMapId() != null)) {
            iDataObject.set(FIELD_PSDEMAPID, (Object)pSDEMapDetailBase.getPSDEMapId());
        }
        if (pSDEMapDetailBase.isPSDEMapNameDirty() && (bl || pSDEMapDetailBase.getPSDEMapName() != null)) {
            iDataObject.set(FIELD_PSDEMAPNAME, (Object)pSDEMapDetailBase.getPSDEMapName());
        }
        if (pSDEMapDetailBase.isPSSysTranslatorIdDirty() && (bl || pSDEMapDetailBase.getPSSysTranslatorId() != null)) {
            iDataObject.set(FIELD_PSSYSTRANSLATORID, (Object)pSDEMapDetailBase.getPSSysTranslatorId());
        }
        if (pSDEMapDetailBase.isPSSysTranslatorNameDirty() && (bl || pSDEMapDetailBase.getPSSysTranslatorName() != null)) {
            iDataObject.set(FIELD_PSSYSTRANSLATORNAME, (Object)pSDEMapDetailBase.getPSSysTranslatorName());
        }
        if (pSDEMapDetailBase.isSrcPSDEFIdDirty() && (bl || pSDEMapDetailBase.getSrcPSDEFId() != null)) {
            iDataObject.set(FIELD_SRCPSDEFID, (Object)pSDEMapDetailBase.getSrcPSDEFId());
        }
        if (pSDEMapDetailBase.isSrcPSDEFNameDirty() && (bl || pSDEMapDetailBase.getSrcPSDEFName() != null)) {
            iDataObject.set(FIELD_SRCPSDEFNAME, (Object)pSDEMapDetailBase.getSrcPSDEFName());
        }
        if (pSDEMapDetailBase.isSrcTypeDirty() && (bl || pSDEMapDetailBase.getSrcType() != null)) {
            iDataObject.set(FIELD_SRCTYPE, (Object)pSDEMapDetailBase.getSrcType());
        }
        if (pSDEMapDetailBase.isSrcValueDirty() && (bl || pSDEMapDetailBase.getSrcValue() != null)) {
            iDataObject.set(FIELD_SRCVALUE, (Object)pSDEMapDetailBase.getSrcValue());
        }
        if (pSDEMapDetailBase.isUpdateDateDirty() && (bl || pSDEMapDetailBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEMapDetailBase.getUpdateDate());
        }
        if (pSDEMapDetailBase.isUpdateManDirty() && (bl || pSDEMapDetailBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEMapDetailBase.getUpdateMan());
        }
        if (pSDEMapDetailBase.isUserCatDirty() && (bl || pSDEMapDetailBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEMapDetailBase.getUserCat());
        }
        if (pSDEMapDetailBase.isUserTagDirty() && (bl || pSDEMapDetailBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEMapDetailBase.getUserTag());
        }
        if (pSDEMapDetailBase.isUserTag2Dirty() && (bl || pSDEMapDetailBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEMapDetailBase.getUserTag2());
        }
        if (pSDEMapDetailBase.isUserTag3Dirty() && (bl || pSDEMapDetailBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEMapDetailBase.getUserTag3());
        }
        if (pSDEMapDetailBase.isUserTag4Dirty() && (bl || pSDEMapDetailBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEMapDetailBase.getUserTag4());
        }
        if (pSDEMapDetailBase.isValidFlagDirty() && (bl || pSDEMapDetailBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEMapDetailBase.getValidFlag());
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
        return PSDEMapDetailBase.remove(this, n);
    }

    private static boolean remove(PSDEMapDetailBase pSDEMapDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEMapDetailBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEMapDetailBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEMapDetailBase.resetDstFieldName();
                return true;
            }
            case 3: {
                pSDEMapDetailBase.resetMemo();
                return true;
            }
            case 4: {
                pSDEMapDetailBase.resetPSDEId();
                return true;
            }
            case 5: {
                pSDEMapDetailBase.resetPSDEMapDetailId();
                return true;
            }
            case 6: {
                pSDEMapDetailBase.resetPSDEMapDetailName();
                return true;
            }
            case 7: {
                pSDEMapDetailBase.resetPSDEMapId();
                return true;
            }
            case 8: {
                pSDEMapDetailBase.resetPSDEMapName();
                return true;
            }
            case 9: {
                pSDEMapDetailBase.resetPSSysTranslatorId();
                return true;
            }
            case 10: {
                pSDEMapDetailBase.resetPSSysTranslatorName();
                return true;
            }
            case 11: {
                pSDEMapDetailBase.resetSrcPSDEFId();
                return true;
            }
            case 12: {
                pSDEMapDetailBase.resetSrcPSDEFName();
                return true;
            }
            case 13: {
                pSDEMapDetailBase.resetSrcType();
                return true;
            }
            case 14: {
                pSDEMapDetailBase.resetSrcValue();
                return true;
            }
            case 15: {
                pSDEMapDetailBase.resetUpdateDate();
                return true;
            }
            case 16: {
                pSDEMapDetailBase.resetUpdateMan();
                return true;
            }
            case 17: {
                pSDEMapDetailBase.resetUserCat();
                return true;
            }
            case 18: {
                pSDEMapDetailBase.resetUserTag();
                return true;
            }
            case 19: {
                pSDEMapDetailBase.resetUserTag2();
                return true;
            }
            case 20: {
                pSDEMapDetailBase.resetUserTag3();
                return true;
            }
            case 21: {
                pSDEMapDetailBase.resetUserTag4();
                return true;
            }
            case 22: {
                pSDEMapDetailBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getSrcPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSDEF();
        }
        if (this.getSrcPSDEFId() == null) {
            return null;
        }
        Integer n = this.objSrcPSDEFLock;
        synchronized (n) {
            if (this.srcpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getSrcPSDEFId(), (Object)this.srcpsdef.getPSDEFieldId()) != 0L) {
                this.srcpsdef = null;
            }
            if (this.srcpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getSrcPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.srcpsdef = pSDEField;
            }
            return this.srcpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEMap getPSDEMap() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMap();
        }
        if (this.getPSDEMapId() == null) {
            return null;
        }
        Integer n = this.objPSDEMapLock;
        synchronized (n) {
            if (this.psdemap != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEMapId(), (Object)this.psdemap.getPSDEMapId()) != 0L) {
                this.psdemap = null;
            }
            if (this.psdemap == null) {
                PSDEMap pSDEMap = new PSDEMap();
                pSDEMap.setPSDEMapId(this.getPSDEMapId());
                PSDEMapService pSDEMapService = (PSDEMapService)ServiceGlobal.getService(PSDEMapService.class, (SessionFactory)this.getSessionFactory());
                pSDEMapService.autoGet((IEntity)pSDEMap);
                this.psdemap = pSDEMap;
            }
            return this.psdemap;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysTranslator getPSSysTranslator() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTranslator();
        }
        if (this.getPSSysTranslatorId() == null) {
            return null;
        }
        Integer n = this.objPSSysTranslatorLock;
        synchronized (n) {
            if (this.pssystranslator != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysTranslatorId(), (Object)this.pssystranslator.getPSSysTranslatorId()) != 0L) {
                this.pssystranslator = null;
            }
            if (this.pssystranslator == null) {
                PSSysTranslator pSSysTranslator = new PSSysTranslator();
                pSSysTranslator.setPSSysTranslatorId(this.getPSSysTranslatorId());
                PSSysTranslatorService pSSysTranslatorService = (PSSysTranslatorService)ServiceGlobal.getService(PSSysTranslatorService.class, (SessionFactory)this.getSessionFactory());
                pSSysTranslatorService.autoGet((IEntity)pSSysTranslator);
                this.pssystranslator = pSSysTranslator;
            }
            return this.pssystranslator;
        }
    }

    private PSDEMapDetailBase getProxyEntity() {
        return this.proxyPSDEMapDetailBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEMapDetailBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEMapDetailBase) {
            this.proxyPSDEMapDetailBase = (PSDEMapDetailBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEMapDetailService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DSTFIELDNAME, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSDEID, 4);
        fieldIndexMap.put(FIELD_PSDEMAPDETAILID, 5);
        fieldIndexMap.put(FIELD_PSDEMAPDETAILNAME, 6);
        fieldIndexMap.put(FIELD_PSDEMAPID, 7);
        fieldIndexMap.put(FIELD_PSDEMAPNAME, 8);
        fieldIndexMap.put(FIELD_PSSYSTRANSLATORID, 9);
        fieldIndexMap.put(FIELD_PSSYSTRANSLATORNAME, 10);
        fieldIndexMap.put(FIELD_SRCPSDEFID, 11);
        fieldIndexMap.put(FIELD_SRCPSDEFNAME, 12);
        fieldIndexMap.put(FIELD_SRCTYPE, 13);
        fieldIndexMap.put(FIELD_SRCVALUE, 14);
        fieldIndexMap.put(FIELD_UPDATEDATE, 15);
        fieldIndexMap.put(FIELD_UPDATEMAN, 16);
        fieldIndexMap.put(FIELD_USERCAT, 17);
        fieldIndexMap.put(FIELD_USERTAG, 18);
        fieldIndexMap.put(FIELD_USERTAG2, 19);
        fieldIndexMap.put(FIELD_USERTAG3, 20);
        fieldIndexMap.put(FIELD_USERTAG4, 21);
        fieldIndexMap.put(FIELD_VALIDFLAG, 22);
    }
}

