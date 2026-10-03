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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataImp;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataImpService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTranslator;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTranslatorService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDataImpItemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEDataImpItemBase.class);
    public static final String FIELD_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String FIELD_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String FIELD_CAPTION = "CAPTION";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEDV = "CREATEDV";
    public static final String FIELD_CREATEDVT = "CREATEDVT";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_HIDDENDATAITEM = "HIDDENDATAITEM";
    public static final String FIELD_KEYFLAG = "KEYFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSCODELISTID = "PSCODELISTID";
    public static final String FIELD_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String FIELD_PSDEDATAIMPID = "PSDEDATAIMPID";
    public static final String FIELD_PSDEDATAIMPITEMID = "PSDEDATAIMPITEMID";
    public static final String FIELD_PSDEDATAIMPITEMNAME = "PSDEDATAIMPITEMNAME";
    public static final String FIELD_PSDEDATAIMPNAME = "PSDEDATAIMPNAME";
    public static final String FIELD_PSDEFID = "PSDEFID";
    public static final String FIELD_PSDEFNAME = "PSDEFNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSYSTRANSLATORID = "PSSYSTRANSLATORID";
    public static final String FIELD_PSSYSTRANSLATORNAME = "PSSYSTRANSLATORNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEDV = "UPDATEDV";
    public static final String FIELD_UPDATEDVT = "UPDATEDVT";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CAPPSLANRESID = 0;
    private static final int INDEX_CAPPSLANRESNAME = 1;
    private static final int INDEX_CAPTION = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEDV = 4;
    private static final int INDEX_CREATEDVT = 5;
    private static final int INDEX_CREATEMAN = 6;
    private static final int INDEX_DYNAMODELFLAG = 7;
    private static final int INDEX_HIDDENDATAITEM = 8;
    private static final int INDEX_KEYFLAG = 9;
    private static final int INDEX_MEMO = 10;
    private static final int INDEX_ORDERVALUE = 11;
    private static final int INDEX_PSCODELISTID = 12;
    private static final int INDEX_PSCODELISTNAME = 13;
    private static final int INDEX_PSDEDATAIMPID = 14;
    private static final int INDEX_PSDEDATAIMPITEMID = 15;
    private static final int INDEX_PSDEDATAIMPITEMNAME = 16;
    private static final int INDEX_PSDEDATAIMPNAME = 17;
    private static final int INDEX_PSDEFID = 18;
    private static final int INDEX_PSDEFNAME = 19;
    private static final int INDEX_PSDEID = 20;
    private static final int INDEX_PSDYNAINSTID = 21;
    private static final int INDEX_PSSYSTRANSLATORID = 22;
    private static final int INDEX_PSSYSTRANSLATORNAME = 23;
    private static final int INDEX_UPDATEDATE = 24;
    private static final int INDEX_UPDATEDV = 25;
    private static final int INDEX_UPDATEDVT = 26;
    private static final int INDEX_UPDATEMAN = 27;
    private static final int INDEX_USERCAT = 28;
    private static final int INDEX_USERTAG = 29;
    private static final int INDEX_USERTAG2 = 30;
    private static final int INDEX_USERTAG3 = 31;
    private static final int INDEX_USERTAG4 = 32;
    private static final int INDEX_VALIDFLAG = 33;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEDataImpItemBase proxyPSDEDataImpItemBase = null;
    private boolean cappslanresidDirtyFlag = false;
    private boolean cappslanresnameDirtyFlag = false;
    private boolean captionDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createdvDirtyFlag = false;
    private boolean createdvtDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean hiddendataitemDirtyFlag = false;
    private boolean keyflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean pscodelistidDirtyFlag = false;
    private boolean pscodelistnameDirtyFlag = false;
    private boolean psdedataimpidDirtyFlag = false;
    private boolean psdedataimpitemidDirtyFlag = false;
    private boolean psdedataimpitemnameDirtyFlag = false;
    private boolean psdedataimpnameDirtyFlag = false;
    private boolean psdefidDirtyFlag = false;
    private boolean psdefnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssystranslatoridDirtyFlag = false;
    private boolean pssystranslatornameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatedvDirtyFlag = false;
    private boolean updatedvtDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="cappslanresid")
    private String cappslanresid;
    @Column(name="cappslanresname")
    private String cappslanresname;
    @Column(name="caption")
    private String caption;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createdv")
    private String createdv;
    @Column(name="createdvt")
    private String createdvt;
    @Column(name="createman")
    private String createman;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="hiddendataitem")
    private Integer hiddendataitem;
    @Column(name="keyflag")
    private Integer keyflag;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="pscodelistid")
    private String pscodelistid;
    @Column(name="pscodelistname")
    private String pscodelistname;
    @Column(name="psdedataimpid")
    private String psdedataimpid;
    @Column(name="psdedataimpitemid")
    private String psdedataimpitemid;
    @Column(name="psdedataimpitemname")
    private String psdedataimpitemname;
    @Column(name="psdedataimpname")
    private String psdedataimpname;
    @Column(name="psdefid")
    private String psdefid;
    @Column(name="psdefname")
    private String psdefname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pssystranslatorid")
    private String pssystranslatorid;
    @Column(name="pssystranslatorname")
    private String pssystranslatorname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updatedv")
    private String updatedv;
    @Column(name="updatedvt")
    private String updatedvt;
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
    private Integer objPSCodeListLock = new Integer(1);
    private PSCodeList pscodelist = null;
    private Integer objPSDEDataImpLock = new Integer(1);
    private PSDEDataImp psdedataimp = null;
    private Integer objPSDEFLock = new Integer(1);
    private PSDEField psdef = null;
    private Integer objCapPSLanResLock = new Integer(1);
    private PSLanguageRes cappslanres = null;
    private Integer objPSSysTranslatorLock = new Integer(1);
    private PSSysTranslator pssystranslator = null;

    public void setCapPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCapPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cappslanresid = string;
        this.cappslanresidDirtyFlag = true;
    }

    public String getCapPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCapPSLanResId();
        }
        return this.cappslanresid;
    }

    public boolean isCapPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCapPSLanResIdDirty();
        }
        return this.cappslanresidDirtyFlag;
    }

    public void resetCapPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCapPSLanResId();
            return;
        }
        this.cappslanresidDirtyFlag = false;
        this.cappslanresid = null;
    }

    public void setCapPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCapPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cappslanresname = string;
        this.cappslanresnameDirtyFlag = true;
    }

    public String getCapPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCapPSLanResName();
        }
        return this.cappslanresname;
    }

    public boolean isCapPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCapPSLanResNameDirty();
        }
        return this.cappslanresnameDirtyFlag;
    }

    public void resetCapPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCapPSLanResName();
            return;
        }
        this.cappslanresnameDirtyFlag = false;
        this.cappslanresname = null;
    }

    public void setCaption(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCaption(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.caption = string;
        this.captionDirtyFlag = true;
    }

    public String getCaption() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCaption();
        }
        return this.caption;
    }

    public boolean isCaptionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCaptionDirty();
        }
        return this.captionDirtyFlag;
    }

    public void resetCaption() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCaption();
            return;
        }
        this.captionDirtyFlag = false;
        this.caption = null;
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

    public void setCreateDV(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDV(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createdv = string;
        this.createdvDirtyFlag = true;
    }

    public String getCreateDV() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateDV();
        }
        return this.createdv;
    }

    public boolean isCreateDVDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateDVDirty();
        }
        return this.createdvDirtyFlag;
    }

    public void resetCreateDV() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateDV();
            return;
        }
        this.createdvDirtyFlag = false;
        this.createdv = null;
    }

    public void setCreateDVT(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDVT(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createdvt = string;
        this.createdvtDirtyFlag = true;
    }

    public String getCreateDVT() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateDVT();
        }
        return this.createdvt;
    }

    public boolean isCreateDVTDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateDVTDirty();
        }
        return this.createdvtDirtyFlag;
    }

    public void resetCreateDVT() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateDVT();
            return;
        }
        this.createdvtDirtyFlag = false;
        this.createdvt = null;
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

    public void setDynaModelFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaModelFlag(n);
            return;
        }
        this.dynamodelflag = n;
        this.dynamodelflagDirtyFlag = true;
    }

    public Integer getDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaModelFlag();
        }
        return this.dynamodelflag;
    }

    public boolean isDynaModelFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaModelFlagDirty();
        }
        return this.dynamodelflagDirtyFlag;
    }

    public void resetDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaModelFlag();
            return;
        }
        this.dynamodelflagDirtyFlag = false;
        this.dynamodelflag = null;
    }

    public void setHiddenDataItem(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHiddenDataItem(n);
            return;
        }
        this.hiddendataitem = n;
        this.hiddendataitemDirtyFlag = true;
    }

    public Integer getHiddenDataItem() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHiddenDataItem();
        }
        return this.hiddendataitem;
    }

    public boolean isHiddenDataItemDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHiddenDataItemDirty();
        }
        return this.hiddendataitemDirtyFlag;
    }

    public void resetHiddenDataItem() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHiddenDataItem();
            return;
        }
        this.hiddendataitemDirtyFlag = false;
        this.hiddendataitem = null;
    }

    public void setKeyFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKeyFlag(n);
            return;
        }
        this.keyflag = n;
        this.keyflagDirtyFlag = true;
    }

    public Integer getKeyFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKeyFlag();
        }
        return this.keyflag;
    }

    public boolean isKeyFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKeyFlagDirty();
        }
        return this.keyflagDirtyFlag;
    }

    public void resetKeyFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKeyFlag();
            return;
        }
        this.keyflagDirtyFlag = false;
        this.keyflag = null;
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

    public void setPSCodeListId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeListId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodelistid = string;
        this.pscodelistidDirtyFlag = true;
    }

    public String getPSCodeListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeListId();
        }
        return this.pscodelistid;
    }

    public boolean isPSCodeListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeListIdDirty();
        }
        return this.pscodelistidDirtyFlag;
    }

    public void resetPSCodeListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeListId();
            return;
        }
        this.pscodelistidDirtyFlag = false;
        this.pscodelistid = null;
    }

    public void setPSCodeListName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeListName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodelistname = string;
        this.pscodelistnameDirtyFlag = true;
    }

    public String getPSCodeListName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeListName();
        }
        return this.pscodelistname;
    }

    public boolean isPSCodeListNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeListNameDirty();
        }
        return this.pscodelistnameDirtyFlag;
    }

    public void resetPSCodeListName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeListName();
            return;
        }
        this.pscodelistnameDirtyFlag = false;
        this.pscodelistname = null;
    }

    public void setPSDEDataImpId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataImpId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataimpid = string;
        this.psdedataimpidDirtyFlag = true;
    }

    public String getPSDEDataImpId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataImpId();
        }
        return this.psdedataimpid;
    }

    public boolean isPSDEDataImpIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataImpIdDirty();
        }
        return this.psdedataimpidDirtyFlag;
    }

    public void resetPSDEDataImpId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataImpId();
            return;
        }
        this.psdedataimpidDirtyFlag = false;
        this.psdedataimpid = null;
    }

    public void setPSDEDataImpItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataImpItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataimpitemid = string;
        this.psdedataimpitemidDirtyFlag = true;
    }

    public String getPSDEDataImpItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataImpItemId();
        }
        return this.psdedataimpitemid;
    }

    public boolean isPSDEDataImpItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataImpItemIdDirty();
        }
        return this.psdedataimpitemidDirtyFlag;
    }

    public void resetPSDEDataImpItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataImpItemId();
            return;
        }
        this.psdedataimpitemidDirtyFlag = false;
        this.psdedataimpitemid = null;
    }

    public void setPSDEDataImpItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataImpItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataimpitemname = string;
        this.psdedataimpitemnameDirtyFlag = true;
    }

    public String getPSDEDataImpItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataImpItemName();
        }
        return this.psdedataimpitemname;
    }

    public boolean isPSDEDataImpItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataImpItemNameDirty();
        }
        return this.psdedataimpitemnameDirtyFlag;
    }

    public void resetPSDEDataImpItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataImpItemName();
            return;
        }
        this.psdedataimpitemnameDirtyFlag = false;
        this.psdedataimpitemname = null;
    }

    public void setPSDEDataImpName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataImpName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataimpname = string;
        this.psdedataimpnameDirtyFlag = true;
    }

    public String getPSDEDataImpName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataImpName();
        }
        return this.psdedataimpname;
    }

    public boolean isPSDEDataImpNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataImpNameDirty();
        }
        return this.psdedataimpnameDirtyFlag;
    }

    public void resetPSDEDataImpName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataImpName();
            return;
        }
        this.psdedataimpnameDirtyFlag = false;
        this.psdedataimpname = null;
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

    public void setPSDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstid = string;
        this.psdynainstidDirtyFlag = true;
    }

    public String getPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstId();
        }
        return this.psdynainstid;
    }

    public boolean isPSDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstIdDirty();
        }
        return this.psdynainstidDirtyFlag;
    }

    public void resetPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstId();
            return;
        }
        this.psdynainstidDirtyFlag = false;
        this.psdynainstid = null;
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

    public void setUpdateDV(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDV(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.updatedv = string;
        this.updatedvDirtyFlag = true;
    }

    public String getUpdateDV() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateDV();
        }
        return this.updatedv;
    }

    public boolean isUpdateDVDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateDVDirty();
        }
        return this.updatedvDirtyFlag;
    }

    public void resetUpdateDV() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateDV();
            return;
        }
        this.updatedvDirtyFlag = false;
        this.updatedv = null;
    }

    public void setUpdateDVT(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDVT(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.updatedvt = string;
        this.updatedvtDirtyFlag = true;
    }

    public String getUpdateDVT() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateDVT();
        }
        return this.updatedvt;
    }

    public boolean isUpdateDVTDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateDVTDirty();
        }
        return this.updatedvtDirtyFlag;
    }

    public void resetUpdateDVT() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateDVT();
            return;
        }
        this.updatedvtDirtyFlag = false;
        this.updatedvt = null;
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
        PSDEDataImpItemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEDataImpItemBase pSDEDataImpItemBase) {
        pSDEDataImpItemBase.resetCapPSLanResId();
        pSDEDataImpItemBase.resetCapPSLanResName();
        pSDEDataImpItemBase.resetCaption();
        pSDEDataImpItemBase.resetCreateDate();
        pSDEDataImpItemBase.resetCreateDV();
        pSDEDataImpItemBase.resetCreateDVT();
        pSDEDataImpItemBase.resetCreateMan();
        pSDEDataImpItemBase.resetDynaModelFlag();
        pSDEDataImpItemBase.resetHiddenDataItem();
        pSDEDataImpItemBase.resetKeyFlag();
        pSDEDataImpItemBase.resetMemo();
        pSDEDataImpItemBase.resetOrderValue();
        pSDEDataImpItemBase.resetPSCodeListId();
        pSDEDataImpItemBase.resetPSCodeListName();
        pSDEDataImpItemBase.resetPSDEDataImpId();
        pSDEDataImpItemBase.resetPSDEDataImpItemId();
        pSDEDataImpItemBase.resetPSDEDataImpItemName();
        pSDEDataImpItemBase.resetPSDEDataImpName();
        pSDEDataImpItemBase.resetPSDEFId();
        pSDEDataImpItemBase.resetPSDEFName();
        pSDEDataImpItemBase.resetPSDEId();
        pSDEDataImpItemBase.resetPSDynaInstId();
        pSDEDataImpItemBase.resetPSSysTranslatorId();
        pSDEDataImpItemBase.resetPSSysTranslatorName();
        pSDEDataImpItemBase.resetUpdateDate();
        pSDEDataImpItemBase.resetUpdateDV();
        pSDEDataImpItemBase.resetUpdateDVT();
        pSDEDataImpItemBase.resetUpdateMan();
        pSDEDataImpItemBase.resetUserCat();
        pSDEDataImpItemBase.resetUserTag();
        pSDEDataImpItemBase.resetUserTag2();
        pSDEDataImpItemBase.resetUserTag3();
        pSDEDataImpItemBase.resetUserTag4();
        pSDEDataImpItemBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCapPSLanResIdDirty()) {
            hashMap.put(FIELD_CAPPSLANRESID, this.getCapPSLanResId());
        }
        if (!bl || this.isCapPSLanResNameDirty()) {
            hashMap.put(FIELD_CAPPSLANRESNAME, this.getCapPSLanResName());
        }
        if (!bl || this.isCaptionDirty()) {
            hashMap.put(FIELD_CAPTION, this.getCaption());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateDVDirty()) {
            hashMap.put(FIELD_CREATEDV, this.getCreateDV());
        }
        if (!bl || this.isCreateDVTDirty()) {
            hashMap.put(FIELD_CREATEDVT, this.getCreateDVT());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isHiddenDataItemDirty()) {
            hashMap.put(FIELD_HIDDENDATAITEM, this.getHiddenDataItem());
        }
        if (!bl || this.isKeyFlagDirty()) {
            hashMap.put(FIELD_KEYFLAG, this.getKeyFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSCodeListIdDirty()) {
            hashMap.put(FIELD_PSCODELISTID, this.getPSCodeListId());
        }
        if (!bl || this.isPSCodeListNameDirty()) {
            hashMap.put(FIELD_PSCODELISTNAME, this.getPSCodeListName());
        }
        if (!bl || this.isPSDEDataImpIdDirty()) {
            hashMap.put(FIELD_PSDEDATAIMPID, this.getPSDEDataImpId());
        }
        if (!bl || this.isPSDEDataImpItemIdDirty()) {
            hashMap.put(FIELD_PSDEDATAIMPITEMID, this.getPSDEDataImpItemId());
        }
        if (!bl || this.isPSDEDataImpItemNameDirty()) {
            hashMap.put(FIELD_PSDEDATAIMPITEMNAME, this.getPSDEDataImpItemName());
        }
        if (!bl || this.isPSDEDataImpNameDirty()) {
            hashMap.put(FIELD_PSDEDATAIMPNAME, this.getPSDEDataImpName());
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
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSSysTranslatorIdDirty()) {
            hashMap.put(FIELD_PSSYSTRANSLATORID, this.getPSSysTranslatorId());
        }
        if (!bl || this.isPSSysTranslatorNameDirty()) {
            hashMap.put(FIELD_PSSYSTRANSLATORNAME, this.getPSSysTranslatorName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateDVDirty()) {
            hashMap.put(FIELD_UPDATEDV, this.getUpdateDV());
        }
        if (!bl || this.isUpdateDVTDirty()) {
            hashMap.put(FIELD_UPDATEDVT, this.getUpdateDVT());
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
        return PSDEDataImpItemBase.get(this, n);
    }

    private static Object get(PSDEDataImpItemBase pSDEDataImpItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDataImpItemBase.getCapPSLanResId();
            }
            case 1: {
                return pSDEDataImpItemBase.getCapPSLanResName();
            }
            case 2: {
                return pSDEDataImpItemBase.getCaption();
            }
            case 3: {
                return pSDEDataImpItemBase.getCreateDate();
            }
            case 4: {
                return pSDEDataImpItemBase.getCreateDV();
            }
            case 5: {
                return pSDEDataImpItemBase.getCreateDVT();
            }
            case 6: {
                return pSDEDataImpItemBase.getCreateMan();
            }
            case 7: {
                return pSDEDataImpItemBase.getDynaModelFlag();
            }
            case 8: {
                return pSDEDataImpItemBase.getHiddenDataItem();
            }
            case 9: {
                return pSDEDataImpItemBase.getKeyFlag();
            }
            case 10: {
                return pSDEDataImpItemBase.getMemo();
            }
            case 11: {
                return pSDEDataImpItemBase.getOrderValue();
            }
            case 12: {
                return pSDEDataImpItemBase.getPSCodeListId();
            }
            case 13: {
                return pSDEDataImpItemBase.getPSCodeListName();
            }
            case 14: {
                return pSDEDataImpItemBase.getPSDEDataImpId();
            }
            case 15: {
                return pSDEDataImpItemBase.getPSDEDataImpItemId();
            }
            case 16: {
                return pSDEDataImpItemBase.getPSDEDataImpItemName();
            }
            case 17: {
                return pSDEDataImpItemBase.getPSDEDataImpName();
            }
            case 18: {
                return pSDEDataImpItemBase.getPSDEFId();
            }
            case 19: {
                return pSDEDataImpItemBase.getPSDEFName();
            }
            case 20: {
                return pSDEDataImpItemBase.getPSDEId();
            }
            case 21: {
                return pSDEDataImpItemBase.getPSDynaInstId();
            }
            case 22: {
                return pSDEDataImpItemBase.getPSSysTranslatorId();
            }
            case 23: {
                return pSDEDataImpItemBase.getPSSysTranslatorName();
            }
            case 24: {
                return pSDEDataImpItemBase.getUpdateDate();
            }
            case 25: {
                return pSDEDataImpItemBase.getUpdateDV();
            }
            case 26: {
                return pSDEDataImpItemBase.getUpdateDVT();
            }
            case 27: {
                return pSDEDataImpItemBase.getUpdateMan();
            }
            case 28: {
                return pSDEDataImpItemBase.getUserCat();
            }
            case 29: {
                return pSDEDataImpItemBase.getUserTag();
            }
            case 30: {
                return pSDEDataImpItemBase.getUserTag2();
            }
            case 31: {
                return pSDEDataImpItemBase.getUserTag3();
            }
            case 32: {
                return pSDEDataImpItemBase.getUserTag4();
            }
            case 33: {
                return pSDEDataImpItemBase.getValidFlag();
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
        PSDEDataImpItemBase.set(this, n, object);
    }

    private static void set(PSDEDataImpItemBase pSDEDataImpItemBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEDataImpItemBase.setCapPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEDataImpItemBase.setCapPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEDataImpItemBase.setCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEDataImpItemBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSDEDataImpItemBase.setCreateDV(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEDataImpItemBase.setCreateDVT(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEDataImpItemBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEDataImpItemBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDEDataImpItemBase.setHiddenDataItem(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDEDataImpItemBase.setKeyFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSDEDataImpItemBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEDataImpItemBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDEDataImpItemBase.setPSCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEDataImpItemBase.setPSCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEDataImpItemBase.setPSDEDataImpId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEDataImpItemBase.setPSDEDataImpItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEDataImpItemBase.setPSDEDataImpItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEDataImpItemBase.setPSDEDataImpName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEDataImpItemBase.setPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEDataImpItemBase.setPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEDataImpItemBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEDataImpItemBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEDataImpItemBase.setPSSysTranslatorId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEDataImpItemBase.setPSSysTranslatorName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEDataImpItemBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 25: {
                pSDEDataImpItemBase.setUpdateDV(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEDataImpItemBase.setUpdateDVT(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEDataImpItemBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEDataImpItemBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEDataImpItemBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEDataImpItemBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEDataImpItemBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEDataImpItemBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEDataImpItemBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEDataImpItemBase.isNull(this, n);
    }

    private static boolean isNull(PSDEDataImpItemBase pSDEDataImpItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDataImpItemBase.getCapPSLanResId() == null;
            }
            case 1: {
                return pSDEDataImpItemBase.getCapPSLanResName() == null;
            }
            case 2: {
                return pSDEDataImpItemBase.getCaption() == null;
            }
            case 3: {
                return pSDEDataImpItemBase.getCreateDate() == null;
            }
            case 4: {
                return pSDEDataImpItemBase.getCreateDV() == null;
            }
            case 5: {
                return pSDEDataImpItemBase.getCreateDVT() == null;
            }
            case 6: {
                return pSDEDataImpItemBase.getCreateMan() == null;
            }
            case 7: {
                return pSDEDataImpItemBase.getDynaModelFlag() == null;
            }
            case 8: {
                return pSDEDataImpItemBase.getHiddenDataItem() == null;
            }
            case 9: {
                return pSDEDataImpItemBase.getKeyFlag() == null;
            }
            case 10: {
                return pSDEDataImpItemBase.getMemo() == null;
            }
            case 11: {
                return pSDEDataImpItemBase.getOrderValue() == null;
            }
            case 12: {
                return pSDEDataImpItemBase.getPSCodeListId() == null;
            }
            case 13: {
                return pSDEDataImpItemBase.getPSCodeListName() == null;
            }
            case 14: {
                return pSDEDataImpItemBase.getPSDEDataImpId() == null;
            }
            case 15: {
                return pSDEDataImpItemBase.getPSDEDataImpItemId() == null;
            }
            case 16: {
                return pSDEDataImpItemBase.getPSDEDataImpItemName() == null;
            }
            case 17: {
                return pSDEDataImpItemBase.getPSDEDataImpName() == null;
            }
            case 18: {
                return pSDEDataImpItemBase.getPSDEFId() == null;
            }
            case 19: {
                return pSDEDataImpItemBase.getPSDEFName() == null;
            }
            case 20: {
                return pSDEDataImpItemBase.getPSDEId() == null;
            }
            case 21: {
                return pSDEDataImpItemBase.getPSDynaInstId() == null;
            }
            case 22: {
                return pSDEDataImpItemBase.getPSSysTranslatorId() == null;
            }
            case 23: {
                return pSDEDataImpItemBase.getPSSysTranslatorName() == null;
            }
            case 24: {
                return pSDEDataImpItemBase.getUpdateDate() == null;
            }
            case 25: {
                return pSDEDataImpItemBase.getUpdateDV() == null;
            }
            case 26: {
                return pSDEDataImpItemBase.getUpdateDVT() == null;
            }
            case 27: {
                return pSDEDataImpItemBase.getUpdateMan() == null;
            }
            case 28: {
                return pSDEDataImpItemBase.getUserCat() == null;
            }
            case 29: {
                return pSDEDataImpItemBase.getUserTag() == null;
            }
            case 30: {
                return pSDEDataImpItemBase.getUserTag2() == null;
            }
            case 31: {
                return pSDEDataImpItemBase.getUserTag3() == null;
            }
            case 32: {
                return pSDEDataImpItemBase.getUserTag4() == null;
            }
            case 33: {
                return pSDEDataImpItemBase.getValidFlag() == null;
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
        return PSDEDataImpItemBase.contains(this, n);
    }

    private static boolean contains(PSDEDataImpItemBase pSDEDataImpItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDataImpItemBase.isCapPSLanResIdDirty();
            }
            case 1: {
                return pSDEDataImpItemBase.isCapPSLanResNameDirty();
            }
            case 2: {
                return pSDEDataImpItemBase.isCaptionDirty();
            }
            case 3: {
                return pSDEDataImpItemBase.isCreateDateDirty();
            }
            case 4: {
                return pSDEDataImpItemBase.isCreateDVDirty();
            }
            case 5: {
                return pSDEDataImpItemBase.isCreateDVTDirty();
            }
            case 6: {
                return pSDEDataImpItemBase.isCreateManDirty();
            }
            case 7: {
                return pSDEDataImpItemBase.isDynaModelFlagDirty();
            }
            case 8: {
                return pSDEDataImpItemBase.isHiddenDataItemDirty();
            }
            case 9: {
                return pSDEDataImpItemBase.isKeyFlagDirty();
            }
            case 10: {
                return pSDEDataImpItemBase.isMemoDirty();
            }
            case 11: {
                return pSDEDataImpItemBase.isOrderValueDirty();
            }
            case 12: {
                return pSDEDataImpItemBase.isPSCodeListIdDirty();
            }
            case 13: {
                return pSDEDataImpItemBase.isPSCodeListNameDirty();
            }
            case 14: {
                return pSDEDataImpItemBase.isPSDEDataImpIdDirty();
            }
            case 15: {
                return pSDEDataImpItemBase.isPSDEDataImpItemIdDirty();
            }
            case 16: {
                return pSDEDataImpItemBase.isPSDEDataImpItemNameDirty();
            }
            case 17: {
                return pSDEDataImpItemBase.isPSDEDataImpNameDirty();
            }
            case 18: {
                return pSDEDataImpItemBase.isPSDEFIdDirty();
            }
            case 19: {
                return pSDEDataImpItemBase.isPSDEFNameDirty();
            }
            case 20: {
                return pSDEDataImpItemBase.isPSDEIdDirty();
            }
            case 21: {
                return pSDEDataImpItemBase.isPSDynaInstIdDirty();
            }
            case 22: {
                return pSDEDataImpItemBase.isPSSysTranslatorIdDirty();
            }
            case 23: {
                return pSDEDataImpItemBase.isPSSysTranslatorNameDirty();
            }
            case 24: {
                return pSDEDataImpItemBase.isUpdateDateDirty();
            }
            case 25: {
                return pSDEDataImpItemBase.isUpdateDVDirty();
            }
            case 26: {
                return pSDEDataImpItemBase.isUpdateDVTDirty();
            }
            case 27: {
                return pSDEDataImpItemBase.isUpdateManDirty();
            }
            case 28: {
                return pSDEDataImpItemBase.isUserCatDirty();
            }
            case 29: {
                return pSDEDataImpItemBase.isUserTagDirty();
            }
            case 30: {
                return pSDEDataImpItemBase.isUserTag2Dirty();
            }
            case 31: {
                return pSDEDataImpItemBase.isUserTag3Dirty();
            }
            case 32: {
                return pSDEDataImpItemBase.isUserTag4Dirty();
            }
            case 33: {
                return pSDEDataImpItemBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEDataImpItemBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEDataImpItemBase pSDEDataImpItemBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEDataImpItemBase.getCapPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresid", (Object)PSDEDataImpItemBase.getJSONValue((Object)pSDEDataImpItemBase.getCapPSLanResId()), (boolean)false);
        }
        if (bl || pSDEDataImpItemBase.getCapPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresname", (Object)PSDEDataImpItemBase.getJSONValue((Object)pSDEDataImpItemBase.getCapPSLanResName()), (boolean)false);
        }
        if (bl || pSDEDataImpItemBase.getCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"caption", (Object)PSDEDataImpItemBase.getJSONValue((Object)pSDEDataImpItemBase.getCaption()), (boolean)false);
        }
        if (bl || pSDEDataImpItemBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEDataImpItemBase.getJSONValue((Object)pSDEDataImpItemBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEDataImpItemBase.getCreateDV() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdv", (Object)PSDEDataImpItemBase.getJSONValue((Object)pSDEDataImpItemBase.getCreateDV()), (boolean)false);
        }
        if (bl || pSDEDataImpItemBase.getCreateDVT() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdvt", (Object)PSDEDataImpItemBase.getJSONValue((Object)pSDEDataImpItemBase.getCreateDVT()), (boolean)false);
        }
        if (bl || pSDEDataImpItemBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEDataImpItemBase.getJSONValue((Object)pSDEDataImpItemBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEDataImpItemBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDEDataImpItemBase.getJSONValue((Object)pSDEDataImpItemBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDEDataImpItemBase.getHiddenDataItem() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hiddendataitem", (Object)PSDEDataImpItemBase.getJSONValue((Object)pSDEDataImpItemBase.getHiddenDataItem()), (boolean)false);
        }
        if (bl || pSDEDataImpItemBase.getKeyFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"keyflag", (Object)PSDEDataImpItemBase.getJSONValue((Object)pSDEDataImpItemBase.getKeyFlag()), (boolean)false);
        }
        if (bl || pSDEDataImpItemBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEDataImpItemBase.getJSONValue((Object)pSDEDataImpItemBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEDataImpItemBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEDataImpItemBase.getJSONValue((Object)pSDEDataImpItemBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEDataImpItemBase.getPSCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistid", (Object)PSDEDataImpItemBase.getJSONValue((Object)pSDEDataImpItemBase.getPSCodeListId()), (boolean)false);
        }
        if (bl || pSDEDataImpItemBase.getPSCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistname", (Object)PSDEDataImpItemBase.getJSONValue((Object)pSDEDataImpItemBase.getPSCodeListName()), (boolean)false);
        }
        if (bl || pSDEDataImpItemBase.getPSDEDataImpId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataimpid", (Object)PSDEDataImpItemBase.getJSONValue((Object)pSDEDataImpItemBase.getPSDEDataImpId()), (boolean)false);
        }
        if (bl || pSDEDataImpItemBase.getPSDEDataImpItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataimpitemid", (Object)PSDEDataImpItemBase.getJSONValue((Object)pSDEDataImpItemBase.getPSDEDataImpItemId()), (boolean)false);
        }
        if (bl || pSDEDataImpItemBase.getPSDEDataImpItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataimpitemname", (Object)PSDEDataImpItemBase.getJSONValue((Object)pSDEDataImpItemBase.getPSDEDataImpItemName()), (boolean)false);
        }
        if (bl || pSDEDataImpItemBase.getPSDEDataImpName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataimpname", (Object)PSDEDataImpItemBase.getJSONValue((Object)pSDEDataImpItemBase.getPSDEDataImpName()), (boolean)false);
        }
        if (bl || pSDEDataImpItemBase.getPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefid", (Object)PSDEDataImpItemBase.getJSONValue((Object)pSDEDataImpItemBase.getPSDEFId()), (boolean)false);
        }
        if (bl || pSDEDataImpItemBase.getPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefname", (Object)PSDEDataImpItemBase.getJSONValue((Object)pSDEDataImpItemBase.getPSDEFName()), (boolean)false);
        }
        if (bl || pSDEDataImpItemBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEDataImpItemBase.getJSONValue((Object)pSDEDataImpItemBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEDataImpItemBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDEDataImpItemBase.getJSONValue((Object)pSDEDataImpItemBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDEDataImpItemBase.getPSSysTranslatorId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystranslatorid", (Object)PSDEDataImpItemBase.getJSONValue((Object)pSDEDataImpItemBase.getPSSysTranslatorId()), (boolean)false);
        }
        if (bl || pSDEDataImpItemBase.getPSSysTranslatorName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystranslatorname", (Object)PSDEDataImpItemBase.getJSONValue((Object)pSDEDataImpItemBase.getPSSysTranslatorName()), (boolean)false);
        }
        if (bl || pSDEDataImpItemBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEDataImpItemBase.getJSONValue((Object)pSDEDataImpItemBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEDataImpItemBase.getUpdateDV() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedv", (Object)PSDEDataImpItemBase.getJSONValue((Object)pSDEDataImpItemBase.getUpdateDV()), (boolean)false);
        }
        if (bl || pSDEDataImpItemBase.getUpdateDVT() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedvt", (Object)PSDEDataImpItemBase.getJSONValue((Object)pSDEDataImpItemBase.getUpdateDVT()), (boolean)false);
        }
        if (bl || pSDEDataImpItemBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEDataImpItemBase.getJSONValue((Object)pSDEDataImpItemBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEDataImpItemBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEDataImpItemBase.getJSONValue((Object)pSDEDataImpItemBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEDataImpItemBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEDataImpItemBase.getJSONValue((Object)pSDEDataImpItemBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEDataImpItemBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEDataImpItemBase.getJSONValue((Object)pSDEDataImpItemBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEDataImpItemBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEDataImpItemBase.getJSONValue((Object)pSDEDataImpItemBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEDataImpItemBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEDataImpItemBase.getJSONValue((Object)pSDEDataImpItemBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEDataImpItemBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEDataImpItemBase.getJSONValue((Object)pSDEDataImpItemBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEDataImpItemBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEDataImpItemBase pSDEDataImpItemBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEDataImpItemBase.getCapPSLanResId() != null) {
            object = pSDEDataImpItemBase.getCapPSLanResId();
            xmlNode.setAttribute(FIELD_CAPPSLANRESID, (String)(object == null ? "" : object));
        }
        if (bl || pSDEDataImpItemBase.getCapPSLanResName() != null) {
            object = pSDEDataImpItemBase.getCapPSLanResName();
            xmlNode.setAttribute(FIELD_CAPPSLANRESNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEDataImpItemBase.getCaption() != null) {
            object = pSDEDataImpItemBase.getCaption();
            xmlNode.setAttribute(FIELD_CAPTION, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpItemBase.getCreateDate() != null) {
            object = pSDEDataImpItemBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDataImpItemBase.getCreateDV() != null) {
            object = pSDEDataImpItemBase.getCreateDV();
            xmlNode.setAttribute(FIELD_CREATEDV, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpItemBase.getCreateDVT() != null) {
            object = pSDEDataImpItemBase.getCreateDVT();
            xmlNode.setAttribute(FIELD_CREATEDVT, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpItemBase.getCreateMan() != null) {
            object = pSDEDataImpItemBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpItemBase.getDynaModelFlag() != null) {
            object = pSDEDataImpItemBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataImpItemBase.getHiddenDataItem() != null) {
            object = pSDEDataImpItemBase.getHiddenDataItem();
            xmlNode.setAttribute(FIELD_HIDDENDATAITEM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataImpItemBase.getKeyFlag() != null) {
            object = pSDEDataImpItemBase.getKeyFlag();
            xmlNode.setAttribute(FIELD_KEYFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataImpItemBase.getMemo() != null) {
            object = pSDEDataImpItemBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpItemBase.getOrderValue() != null) {
            object = pSDEDataImpItemBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataImpItemBase.getPSCodeListId() != null) {
            object = pSDEDataImpItemBase.getPSCodeListId();
            xmlNode.setAttribute(FIELD_PSCODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpItemBase.getPSCodeListName() != null) {
            object = pSDEDataImpItemBase.getPSCodeListName();
            xmlNode.setAttribute(FIELD_PSCODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpItemBase.getPSDEDataImpId() != null) {
            object = pSDEDataImpItemBase.getPSDEDataImpId();
            xmlNode.setAttribute(FIELD_PSDEDATAIMPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpItemBase.getPSDEDataImpItemId() != null) {
            object = pSDEDataImpItemBase.getPSDEDataImpItemId();
            xmlNode.setAttribute(FIELD_PSDEDATAIMPITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpItemBase.getPSDEDataImpItemName() != null) {
            object = pSDEDataImpItemBase.getPSDEDataImpItemName();
            xmlNode.setAttribute(FIELD_PSDEDATAIMPITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpItemBase.getPSDEDataImpName() != null) {
            object = pSDEDataImpItemBase.getPSDEDataImpName();
            xmlNode.setAttribute(FIELD_PSDEDATAIMPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpItemBase.getPSDEFId() != null) {
            object = pSDEDataImpItemBase.getPSDEFId();
            xmlNode.setAttribute(FIELD_PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpItemBase.getPSDEFName() != null) {
            object = pSDEDataImpItemBase.getPSDEFName();
            xmlNode.setAttribute(FIELD_PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpItemBase.getPSDEId() != null) {
            object = pSDEDataImpItemBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpItemBase.getPSDynaInstId() != null) {
            object = pSDEDataImpItemBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpItemBase.getPSSysTranslatorId() != null) {
            object = pSDEDataImpItemBase.getPSSysTranslatorId();
            xmlNode.setAttribute(FIELD_PSSYSTRANSLATORID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpItemBase.getPSSysTranslatorName() != null) {
            object = pSDEDataImpItemBase.getPSSysTranslatorName();
            xmlNode.setAttribute(FIELD_PSSYSTRANSLATORNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpItemBase.getUpdateDate() != null) {
            object = pSDEDataImpItemBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDataImpItemBase.getUpdateDV() != null) {
            object = pSDEDataImpItemBase.getUpdateDV();
            xmlNode.setAttribute(FIELD_UPDATEDV, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpItemBase.getUpdateDVT() != null) {
            object = pSDEDataImpItemBase.getUpdateDVT();
            xmlNode.setAttribute(FIELD_UPDATEDVT, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpItemBase.getUpdateMan() != null) {
            object = pSDEDataImpItemBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpItemBase.getUserCat() != null) {
            object = pSDEDataImpItemBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpItemBase.getUserTag() != null) {
            object = pSDEDataImpItemBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpItemBase.getUserTag2() != null) {
            object = pSDEDataImpItemBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpItemBase.getUserTag3() != null) {
            object = pSDEDataImpItemBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpItemBase.getUserTag4() != null) {
            object = pSDEDataImpItemBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataImpItemBase.getValidFlag() != null) {
            object = pSDEDataImpItemBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEDataImpItemBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEDataImpItemBase pSDEDataImpItemBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEDataImpItemBase.isCapPSLanResIdDirty() && (bl || pSDEDataImpItemBase.getCapPSLanResId() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESID, (Object)pSDEDataImpItemBase.getCapPSLanResId());
        }
        if (pSDEDataImpItemBase.isCapPSLanResNameDirty() && (bl || pSDEDataImpItemBase.getCapPSLanResName() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESNAME, (Object)pSDEDataImpItemBase.getCapPSLanResName());
        }
        if (pSDEDataImpItemBase.isCaptionDirty() && (bl || pSDEDataImpItemBase.getCaption() != null)) {
            iDataObject.set(FIELD_CAPTION, (Object)pSDEDataImpItemBase.getCaption());
        }
        if (pSDEDataImpItemBase.isCreateDateDirty() && (bl || pSDEDataImpItemBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEDataImpItemBase.getCreateDate());
        }
        if (pSDEDataImpItemBase.isCreateDVDirty() && (bl || pSDEDataImpItemBase.getCreateDV() != null)) {
            iDataObject.set(FIELD_CREATEDV, (Object)pSDEDataImpItemBase.getCreateDV());
        }
        if (pSDEDataImpItemBase.isCreateDVTDirty() && (bl || pSDEDataImpItemBase.getCreateDVT() != null)) {
            iDataObject.set(FIELD_CREATEDVT, (Object)pSDEDataImpItemBase.getCreateDVT());
        }
        if (pSDEDataImpItemBase.isCreateManDirty() && (bl || pSDEDataImpItemBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEDataImpItemBase.getCreateMan());
        }
        if (pSDEDataImpItemBase.isDynaModelFlagDirty() && (bl || pSDEDataImpItemBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDEDataImpItemBase.getDynaModelFlag());
        }
        if (pSDEDataImpItemBase.isHiddenDataItemDirty() && (bl || pSDEDataImpItemBase.getHiddenDataItem() != null)) {
            iDataObject.set(FIELD_HIDDENDATAITEM, (Object)pSDEDataImpItemBase.getHiddenDataItem());
        }
        if (pSDEDataImpItemBase.isKeyFlagDirty() && (bl || pSDEDataImpItemBase.getKeyFlag() != null)) {
            iDataObject.set(FIELD_KEYFLAG, (Object)pSDEDataImpItemBase.getKeyFlag());
        }
        if (pSDEDataImpItemBase.isMemoDirty() && (bl || pSDEDataImpItemBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEDataImpItemBase.getMemo());
        }
        if (pSDEDataImpItemBase.isOrderValueDirty() && (bl || pSDEDataImpItemBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEDataImpItemBase.getOrderValue());
        }
        if (pSDEDataImpItemBase.isPSCodeListIdDirty() && (bl || pSDEDataImpItemBase.getPSCodeListId() != null)) {
            iDataObject.set(FIELD_PSCODELISTID, (Object)pSDEDataImpItemBase.getPSCodeListId());
        }
        if (pSDEDataImpItemBase.isPSCodeListNameDirty() && (bl || pSDEDataImpItemBase.getPSCodeListName() != null)) {
            iDataObject.set(FIELD_PSCODELISTNAME, (Object)pSDEDataImpItemBase.getPSCodeListName());
        }
        if (pSDEDataImpItemBase.isPSDEDataImpIdDirty() && (bl || pSDEDataImpItemBase.getPSDEDataImpId() != null)) {
            iDataObject.set(FIELD_PSDEDATAIMPID, (Object)pSDEDataImpItemBase.getPSDEDataImpId());
        }
        if (pSDEDataImpItemBase.isPSDEDataImpItemIdDirty() && (bl || pSDEDataImpItemBase.getPSDEDataImpItemId() != null)) {
            iDataObject.set(FIELD_PSDEDATAIMPITEMID, (Object)pSDEDataImpItemBase.getPSDEDataImpItemId());
        }
        if (pSDEDataImpItemBase.isPSDEDataImpItemNameDirty() && (bl || pSDEDataImpItemBase.getPSDEDataImpItemName() != null)) {
            iDataObject.set(FIELD_PSDEDATAIMPITEMNAME, (Object)pSDEDataImpItemBase.getPSDEDataImpItemName());
        }
        if (pSDEDataImpItemBase.isPSDEDataImpNameDirty() && (bl || pSDEDataImpItemBase.getPSDEDataImpName() != null)) {
            iDataObject.set(FIELD_PSDEDATAIMPNAME, (Object)pSDEDataImpItemBase.getPSDEDataImpName());
        }
        if (pSDEDataImpItemBase.isPSDEFIdDirty() && (bl || pSDEDataImpItemBase.getPSDEFId() != null)) {
            iDataObject.set(FIELD_PSDEFID, (Object)pSDEDataImpItemBase.getPSDEFId());
        }
        if (pSDEDataImpItemBase.isPSDEFNameDirty() && (bl || pSDEDataImpItemBase.getPSDEFName() != null)) {
            iDataObject.set(FIELD_PSDEFNAME, (Object)pSDEDataImpItemBase.getPSDEFName());
        }
        if (pSDEDataImpItemBase.isPSDEIdDirty() && (bl || pSDEDataImpItemBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEDataImpItemBase.getPSDEId());
        }
        if (pSDEDataImpItemBase.isPSDynaInstIdDirty() && (bl || pSDEDataImpItemBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDEDataImpItemBase.getPSDynaInstId());
        }
        if (pSDEDataImpItemBase.isPSSysTranslatorIdDirty() && (bl || pSDEDataImpItemBase.getPSSysTranslatorId() != null)) {
            iDataObject.set(FIELD_PSSYSTRANSLATORID, (Object)pSDEDataImpItemBase.getPSSysTranslatorId());
        }
        if (pSDEDataImpItemBase.isPSSysTranslatorNameDirty() && (bl || pSDEDataImpItemBase.getPSSysTranslatorName() != null)) {
            iDataObject.set(FIELD_PSSYSTRANSLATORNAME, (Object)pSDEDataImpItemBase.getPSSysTranslatorName());
        }
        if (pSDEDataImpItemBase.isUpdateDateDirty() && (bl || pSDEDataImpItemBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEDataImpItemBase.getUpdateDate());
        }
        if (pSDEDataImpItemBase.isUpdateDVDirty() && (bl || pSDEDataImpItemBase.getUpdateDV() != null)) {
            iDataObject.set(FIELD_UPDATEDV, (Object)pSDEDataImpItemBase.getUpdateDV());
        }
        if (pSDEDataImpItemBase.isUpdateDVTDirty() && (bl || pSDEDataImpItemBase.getUpdateDVT() != null)) {
            iDataObject.set(FIELD_UPDATEDVT, (Object)pSDEDataImpItemBase.getUpdateDVT());
        }
        if (pSDEDataImpItemBase.isUpdateManDirty() && (bl || pSDEDataImpItemBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEDataImpItemBase.getUpdateMan());
        }
        if (pSDEDataImpItemBase.isUserCatDirty() && (bl || pSDEDataImpItemBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEDataImpItemBase.getUserCat());
        }
        if (pSDEDataImpItemBase.isUserTagDirty() && (bl || pSDEDataImpItemBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEDataImpItemBase.getUserTag());
        }
        if (pSDEDataImpItemBase.isUserTag2Dirty() && (bl || pSDEDataImpItemBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEDataImpItemBase.getUserTag2());
        }
        if (pSDEDataImpItemBase.isUserTag3Dirty() && (bl || pSDEDataImpItemBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEDataImpItemBase.getUserTag3());
        }
        if (pSDEDataImpItemBase.isUserTag4Dirty() && (bl || pSDEDataImpItemBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEDataImpItemBase.getUserTag4());
        }
        if (pSDEDataImpItemBase.isValidFlagDirty() && (bl || pSDEDataImpItemBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEDataImpItemBase.getValidFlag());
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
        return PSDEDataImpItemBase.remove(this, n);
    }

    private static boolean remove(PSDEDataImpItemBase pSDEDataImpItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEDataImpItemBase.resetCapPSLanResId();
                return true;
            }
            case 1: {
                pSDEDataImpItemBase.resetCapPSLanResName();
                return true;
            }
            case 2: {
                pSDEDataImpItemBase.resetCaption();
                return true;
            }
            case 3: {
                pSDEDataImpItemBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSDEDataImpItemBase.resetCreateDV();
                return true;
            }
            case 5: {
                pSDEDataImpItemBase.resetCreateDVT();
                return true;
            }
            case 6: {
                pSDEDataImpItemBase.resetCreateMan();
                return true;
            }
            case 7: {
                pSDEDataImpItemBase.resetDynaModelFlag();
                return true;
            }
            case 8: {
                pSDEDataImpItemBase.resetHiddenDataItem();
                return true;
            }
            case 9: {
                pSDEDataImpItemBase.resetKeyFlag();
                return true;
            }
            case 10: {
                pSDEDataImpItemBase.resetMemo();
                return true;
            }
            case 11: {
                pSDEDataImpItemBase.resetOrderValue();
                return true;
            }
            case 12: {
                pSDEDataImpItemBase.resetPSCodeListId();
                return true;
            }
            case 13: {
                pSDEDataImpItemBase.resetPSCodeListName();
                return true;
            }
            case 14: {
                pSDEDataImpItemBase.resetPSDEDataImpId();
                return true;
            }
            case 15: {
                pSDEDataImpItemBase.resetPSDEDataImpItemId();
                return true;
            }
            case 16: {
                pSDEDataImpItemBase.resetPSDEDataImpItemName();
                return true;
            }
            case 17: {
                pSDEDataImpItemBase.resetPSDEDataImpName();
                return true;
            }
            case 18: {
                pSDEDataImpItemBase.resetPSDEFId();
                return true;
            }
            case 19: {
                pSDEDataImpItemBase.resetPSDEFName();
                return true;
            }
            case 20: {
                pSDEDataImpItemBase.resetPSDEId();
                return true;
            }
            case 21: {
                pSDEDataImpItemBase.resetPSDynaInstId();
                return true;
            }
            case 22: {
                pSDEDataImpItemBase.resetPSSysTranslatorId();
                return true;
            }
            case 23: {
                pSDEDataImpItemBase.resetPSSysTranslatorName();
                return true;
            }
            case 24: {
                pSDEDataImpItemBase.resetUpdateDate();
                return true;
            }
            case 25: {
                pSDEDataImpItemBase.resetUpdateDV();
                return true;
            }
            case 26: {
                pSDEDataImpItemBase.resetUpdateDVT();
                return true;
            }
            case 27: {
                pSDEDataImpItemBase.resetUpdateMan();
                return true;
            }
            case 28: {
                pSDEDataImpItemBase.resetUserCat();
                return true;
            }
            case 29: {
                pSDEDataImpItemBase.resetUserTag();
                return true;
            }
            case 30: {
                pSDEDataImpItemBase.resetUserTag2();
                return true;
            }
            case 31: {
                pSDEDataImpItemBase.resetUserTag3();
                return true;
            }
            case 32: {
                pSDEDataImpItemBase.resetUserTag4();
                return true;
            }
            case 33: {
                pSDEDataImpItemBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCodeList getPSCodeList() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeList();
        }
        if (this.getPSCodeListId() == null) {
            return null;
        }
        Integer n = this.objPSCodeListLock;
        synchronized (n) {
            if (this.pscodelist != null && DataTypeHelper.compare((int)25, (Object)this.getPSCodeListId(), (Object)this.pscodelist.getPSCodeListId()) != 0L) {
                this.pscodelist = null;
            }
            if (this.pscodelist == null) {
                PSCodeList pSCodeList = new PSCodeList();
                pSCodeList.setPSCodeListId(this.getPSCodeListId());
                PSCodeListService pSCodeListService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
                pSCodeListService.autoGet(pSCodeList);
                this.pscodelist = pSCodeList;
            }
            return this.pscodelist;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataImp getPSDEDataImp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataImp();
        }
        if (this.getPSDEDataImpId() == null) {
            return null;
        }
        Integer n = this.objPSDEDataImpLock;
        synchronized (n) {
            if (this.psdedataimp != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDataImpId(), (Object)this.psdedataimp.getPSDEDataImpId()) != 0L) {
                this.psdedataimp = null;
            }
            if (this.psdedataimp == null) {
                PSDEDataImp pSDEDataImp = new PSDEDataImp();
                pSDEDataImp.setPSDEDataImpId(this.getPSDEDataImpId());
                PSDEDataImpService pSDEDataImpService = (PSDEDataImpService)ServiceGlobal.getService(PSDEDataImpService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataImpService.autoGet(pSDEDataImp);
                this.psdedataimp = pSDEDataImp;
            }
            return this.psdedataimp;
        }
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
                pSDEFieldService.autoGet(pSDEField);
                this.psdef = pSDEField;
            }
            return this.psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getCapPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCapPSLanRes();
        }
        if (this.getCapPSLanResId() == null) {
            return null;
        }
        Integer n = this.objCapPSLanResLock;
        synchronized (n) {
            if (this.cappslanres != null && DataTypeHelper.compare((int)25, (Object)this.getCapPSLanResId(), (Object)this.cappslanres.getPSLanguageResId()) != 0L) {
                this.cappslanres = null;
            }
            if (this.cappslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getCapPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet(pSLanguageRes);
                this.cappslanres = pSLanguageRes;
            }
            return this.cappslanres;
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
                pSSysTranslatorService.autoGet(pSSysTranslator);
                this.pssystranslator = pSSysTranslator;
            }
            return this.pssystranslator;
        }
    }

    private PSDEDataImpItemBase getProxyEntity() {
        return this.proxyPSDEDataImpItemBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEDataImpItemBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEDataImpItemBase) {
            this.proxyPSDEDataImpItemBase = (PSDEDataImpItemBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataImpItemService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CAPPSLANRESID, 0);
        fieldIndexMap.put(FIELD_CAPPSLANRESNAME, 1);
        fieldIndexMap.put(FIELD_CAPTION, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEDV, 4);
        fieldIndexMap.put(FIELD_CREATEDVT, 5);
        fieldIndexMap.put(FIELD_CREATEMAN, 6);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 7);
        fieldIndexMap.put(FIELD_HIDDENDATAITEM, 8);
        fieldIndexMap.put(FIELD_KEYFLAG, 9);
        fieldIndexMap.put(FIELD_MEMO, 10);
        fieldIndexMap.put(FIELD_ORDERVALUE, 11);
        fieldIndexMap.put(FIELD_PSCODELISTID, 12);
        fieldIndexMap.put(FIELD_PSCODELISTNAME, 13);
        fieldIndexMap.put(FIELD_PSDEDATAIMPID, 14);
        fieldIndexMap.put(FIELD_PSDEDATAIMPITEMID, 15);
        fieldIndexMap.put(FIELD_PSDEDATAIMPITEMNAME, 16);
        fieldIndexMap.put(FIELD_PSDEDATAIMPNAME, 17);
        fieldIndexMap.put(FIELD_PSDEFID, 18);
        fieldIndexMap.put(FIELD_PSDEFNAME, 19);
        fieldIndexMap.put(FIELD_PSDEID, 20);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 21);
        fieldIndexMap.put(FIELD_PSSYSTRANSLATORID, 22);
        fieldIndexMap.put(FIELD_PSSYSTRANSLATORNAME, 23);
        fieldIndexMap.put(FIELD_UPDATEDATE, 24);
        fieldIndexMap.put(FIELD_UPDATEDV, 25);
        fieldIndexMap.put(FIELD_UPDATEDVT, 26);
        fieldIndexMap.put(FIELD_UPDATEMAN, 27);
        fieldIndexMap.put(FIELD_USERCAT, 28);
        fieldIndexMap.put(FIELD_USERTAG, 29);
        fieldIndexMap.put(FIELD_USERTAG2, 30);
        fieldIndexMap.put(FIELD_USERTAG3, 31);
        fieldIndexMap.put(FIELD_USERTAG4, 32);
        fieldIndexMap.put(FIELD_VALIDFLAG, 33);
    }
}

