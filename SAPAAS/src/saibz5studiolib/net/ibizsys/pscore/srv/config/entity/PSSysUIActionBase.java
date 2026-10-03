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
package net.ibizsys.pscore.srv.config.entity;

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
import net.ibizsys.pscore.srv.config.entity.PSImageTempl;
import net.ibizsys.pscore.srv.config.entity.PSSysLanRes;
import net.ibizsys.pscore.srv.config.service.PSImageTemplService;
import net.ibizsys.pscore.srv.config.service.PSSysLanResService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysUIActionBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysUIActionBase.class);
    public static final String FIELD_ACTIONTARGET = "ACTIONTARGET";
    public static final String FIELD_CAPPSSYSLANRESID = "CAPPSSYSLANRESID";
    public static final String FIELD_CAPPSSYSLANRESNAME = "CAPPSSYSLANRESNAME";
    public static final String FIELD_CAPTION = "CAPTION";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEOPPRIV = "DEOPPRIV";
    public static final String FIELD_ITEMOBJ = "ITEMOBJ";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSIMAGETEMPLID = "PSIMAGETEMPLID";
    public static final String FIELD_PSIMAGETEMPLNAME = "PSIMAGETEMPLNAME";
    public static final String FIELD_PSSYSUIACTIONID = "PSSYSUIACTIONID";
    public static final String FIELD_PSSYSUIACTIONNAME = "PSSYSUIACTIONNAME";
    public static final String FIELD_TIPPSSYSLANRESID = "TIPPSSYSLANRESID";
    public static final String FIELD_TIPPSSYSLANRESNAME = "TIPPSSYSLANRESNAME";
    public static final String FIELD_TOGGLEMODE = "TOGGLEMODE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_ACTIONTARGET = 0;
    private static final int INDEX_CAPPSSYSLANRESID = 1;
    private static final int INDEX_CAPPSSYSLANRESNAME = 2;
    private static final int INDEX_CAPTION = 3;
    private static final int INDEX_CODENAME = 4;
    private static final int INDEX_CREATEDATE = 5;
    private static final int INDEX_CREATEMAN = 6;
    private static final int INDEX_DEOPPRIV = 7;
    private static final int INDEX_ITEMOBJ = 8;
    private static final int INDEX_MEMO = 9;
    private static final int INDEX_PSIMAGETEMPLID = 10;
    private static final int INDEX_PSIMAGETEMPLNAME = 11;
    private static final int INDEX_PSSYSUIACTIONID = 12;
    private static final int INDEX_PSSYSUIACTIONNAME = 13;
    private static final int INDEX_TIPPSSYSLANRESID = 14;
    private static final int INDEX_TIPPSSYSLANRESNAME = 15;
    private static final int INDEX_TOGGLEMODE = 16;
    private static final int INDEX_UPDATEDATE = 17;
    private static final int INDEX_UPDATEMAN = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysUIActionBase proxyPSSysUIActionBase = null;
    private boolean actiontargetDirtyFlag = false;
    private boolean cappssyslanresidDirtyFlag = false;
    private boolean cappssyslanresnameDirtyFlag = false;
    private boolean captionDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean deopprivDirtyFlag = false;
    private boolean itemobjDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psimagetemplidDirtyFlag = false;
    private boolean psimagetemplnameDirtyFlag = false;
    private boolean pssysuiactionidDirtyFlag = false;
    private boolean pssysuiactionnameDirtyFlag = false;
    private boolean tippssyslanresidDirtyFlag = false;
    private boolean tippssyslanresnameDirtyFlag = false;
    private boolean togglemodeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="actiontarget")
    private String actiontarget;
    @Column(name="cappssyslanresid")
    private String cappssyslanresid;
    @Column(name="cappssyslanresname")
    private String cappssyslanresname;
    @Column(name="caption")
    private String caption;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="deoppriv")
    private String deoppriv;
    @Column(name="itemobj")
    private String itemobj;
    @Column(name="memo")
    private String memo;
    @Column(name="psimagetemplid")
    private String psimagetemplid;
    @Column(name="psimagetemplname")
    private String psimagetemplname;
    @Column(name="pssysuiactionid")
    private String pssysuiactionid;
    @Column(name="pssysuiactionname")
    private String pssysuiactionname;
    @Column(name="tippssyslanresid")
    private String tippssyslanresid;
    @Column(name="tippssyslanresname")
    private String tippssyslanresname;
    @Column(name="togglemode")
    private Integer togglemode;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSImageTemplLock = new Integer(1);
    private PSImageTempl psimagetempl = null;
    private Integer objCapPSSysLanResLock = new Integer(1);
    private PSSysLanRes cappssyslanres = null;
    private Integer objTipPSSysLanResLock = new Integer(1);
    private PSSysLanRes tippssyslanres = null;

    public void setActionTarget(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionTarget(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actiontarget = string;
        this.actiontargetDirtyFlag = true;
    }

    public String getActionTarget() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionTarget();
        }
        return this.actiontarget;
    }

    public boolean isActionTargetDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionTargetDirty();
        }
        return this.actiontargetDirtyFlag;
    }

    public void resetActionTarget() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionTarget();
            return;
        }
        this.actiontargetDirtyFlag = false;
        this.actiontarget = null;
    }

    public void setCapPSSysLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCapPSSysLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cappssyslanresid = string;
        this.cappssyslanresidDirtyFlag = true;
    }

    public String getCapPSSysLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCapPSSysLanResId();
        }
        return this.cappssyslanresid;
    }

    public boolean isCapPSSysLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCapPSSysLanResIdDirty();
        }
        return this.cappssyslanresidDirtyFlag;
    }

    public void resetCapPSSysLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCapPSSysLanResId();
            return;
        }
        this.cappssyslanresidDirtyFlag = false;
        this.cappssyslanresid = null;
    }

    public void setCapPSSysLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCapPSSysLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cappssyslanresname = string;
        this.cappssyslanresnameDirtyFlag = true;
    }

    public String getCapPSSysLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCapPSSysLanResName();
        }
        return this.cappssyslanresname;
    }

    public boolean isCapPSSysLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCapPSSysLanResNameDirty();
        }
        return this.cappssyslanresnameDirtyFlag;
    }

    public void resetCapPSSysLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCapPSSysLanResName();
            return;
        }
        this.cappssyslanresnameDirtyFlag = false;
        this.cappssyslanresname = null;
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

    public void setDEOPPriv(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEOPPriv(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deoppriv = string;
        this.deopprivDirtyFlag = true;
    }

    public String getDEOPPriv() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEOPPriv();
        }
        return this.deoppriv;
    }

    public boolean isDEOPPrivDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEOPPrivDirty();
        }
        return this.deopprivDirtyFlag;
    }

    public void resetDEOPPriv() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEOPPriv();
            return;
        }
        this.deopprivDirtyFlag = false;
        this.deoppriv = null;
    }

    public void setItemObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemobj = string;
        this.itemobjDirtyFlag = true;
    }

    public String getItemObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemObj();
        }
        return this.itemobj;
    }

    public boolean isItemObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemObjDirty();
        }
        return this.itemobjDirtyFlag;
    }

    public void resetItemObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemObj();
            return;
        }
        this.itemobjDirtyFlag = false;
        this.itemobj = null;
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

    public void setPSImageTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSImageTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psimagetemplid = string;
        this.psimagetemplidDirtyFlag = true;
    }

    public String getPSImageTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSImageTemplId();
        }
        return this.psimagetemplid;
    }

    public boolean isPSImageTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSImageTemplIdDirty();
        }
        return this.psimagetemplidDirtyFlag;
    }

    public void resetPSImageTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSImageTemplId();
            return;
        }
        this.psimagetemplidDirtyFlag = false;
        this.psimagetemplid = null;
    }

    public void setPSImageTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSImageTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psimagetemplname = string;
        this.psimagetemplnameDirtyFlag = true;
    }

    public String getPSImageTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSImageTemplName();
        }
        return this.psimagetemplname;
    }

    public boolean isPSImageTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSImageTemplNameDirty();
        }
        return this.psimagetemplnameDirtyFlag;
    }

    public void resetPSImageTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSImageTemplName();
            return;
        }
        this.psimagetemplnameDirtyFlag = false;
        this.psimagetemplname = null;
    }

    public void setPSSysUIActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUIActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysuiactionid = string;
        this.pssysuiactionidDirtyFlag = true;
    }

    public String getPSSysUIActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUIActionId();
        }
        return this.pssysuiactionid;
    }

    public boolean isPSSysUIActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUIActionIdDirty();
        }
        return this.pssysuiactionidDirtyFlag;
    }

    public void resetPSSysUIActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUIActionId();
            return;
        }
        this.pssysuiactionidDirtyFlag = false;
        this.pssysuiactionid = null;
    }

    public void setPSSysUIActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUIActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysuiactionname = string;
        this.pssysuiactionnameDirtyFlag = true;
    }

    public String getPSSysUIActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUIActionName();
        }
        return this.pssysuiactionname;
    }

    public boolean isPSSysUIActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUIActionNameDirty();
        }
        return this.pssysuiactionnameDirtyFlag;
    }

    public void resetPSSysUIActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUIActionName();
            return;
        }
        this.pssysuiactionnameDirtyFlag = false;
        this.pssysuiactionname = null;
    }

    public void setTipPSSysLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTipPSSysLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tippssyslanresid = string;
        this.tippssyslanresidDirtyFlag = true;
    }

    public String getTipPSSysLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTipPSSysLanResId();
        }
        return this.tippssyslanresid;
    }

    public boolean isTipPSSysLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTipPSSysLanResIdDirty();
        }
        return this.tippssyslanresidDirtyFlag;
    }

    public void resetTipPSSysLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTipPSSysLanResId();
            return;
        }
        this.tippssyslanresidDirtyFlag = false;
        this.tippssyslanresid = null;
    }

    public void setTipPSSysLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTipPSSysLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tippssyslanresname = string;
        this.tippssyslanresnameDirtyFlag = true;
    }

    public String getTipPSSysLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTipPSSysLanResName();
        }
        return this.tippssyslanresname;
    }

    public boolean isTipPSSysLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTipPSSysLanResNameDirty();
        }
        return this.tippssyslanresnameDirtyFlag;
    }

    public void resetTipPSSysLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTipPSSysLanResName();
            return;
        }
        this.tippssyslanresnameDirtyFlag = false;
        this.tippssyslanresname = null;
    }

    public void setToggleMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setToggleMode(n);
            return;
        }
        this.togglemode = n;
        this.togglemodeDirtyFlag = true;
    }

    public Integer getToggleMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getToggleMode();
        }
        return this.togglemode;
    }

    public boolean isToggleModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isToggleModeDirty();
        }
        return this.togglemodeDirtyFlag;
    }

    public void resetToggleMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetToggleMode();
            return;
        }
        this.togglemodeDirtyFlag = false;
        this.togglemode = null;
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

    protected void onReset() {
        PSSysUIActionBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysUIActionBase pSSysUIActionBase) {
        pSSysUIActionBase.resetActionTarget();
        pSSysUIActionBase.resetCapPSSysLanResId();
        pSSysUIActionBase.resetCapPSSysLanResName();
        pSSysUIActionBase.resetCaption();
        pSSysUIActionBase.resetCodeName();
        pSSysUIActionBase.resetCreateDate();
        pSSysUIActionBase.resetCreateMan();
        pSSysUIActionBase.resetDEOPPriv();
        pSSysUIActionBase.resetItemObj();
        pSSysUIActionBase.resetMemo();
        pSSysUIActionBase.resetPSImageTemplId();
        pSSysUIActionBase.resetPSImageTemplName();
        pSSysUIActionBase.resetPSSysUIActionId();
        pSSysUIActionBase.resetPSSysUIActionName();
        pSSysUIActionBase.resetTipPSSysLanResId();
        pSSysUIActionBase.resetTipPSSysLanResName();
        pSSysUIActionBase.resetToggleMode();
        pSSysUIActionBase.resetUpdateDate();
        pSSysUIActionBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isActionTargetDirty()) {
            hashMap.put(FIELD_ACTIONTARGET, this.getActionTarget());
        }
        if (!bl || this.isCapPSSysLanResIdDirty()) {
            hashMap.put(FIELD_CAPPSSYSLANRESID, this.getCapPSSysLanResId());
        }
        if (!bl || this.isCapPSSysLanResNameDirty()) {
            hashMap.put(FIELD_CAPPSSYSLANRESNAME, this.getCapPSSysLanResName());
        }
        if (!bl || this.isCaptionDirty()) {
            hashMap.put(FIELD_CAPTION, this.getCaption());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDEOPPrivDirty()) {
            hashMap.put(FIELD_DEOPPRIV, this.getDEOPPriv());
        }
        if (!bl || this.isItemObjDirty()) {
            hashMap.put(FIELD_ITEMOBJ, this.getItemObj());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSImageTemplIdDirty()) {
            hashMap.put(FIELD_PSIMAGETEMPLID, this.getPSImageTemplId());
        }
        if (!bl || this.isPSImageTemplNameDirty()) {
            hashMap.put(FIELD_PSIMAGETEMPLNAME, this.getPSImageTemplName());
        }
        if (!bl || this.isPSSysUIActionIdDirty()) {
            hashMap.put(FIELD_PSSYSUIACTIONID, this.getPSSysUIActionId());
        }
        if (!bl || this.isPSSysUIActionNameDirty()) {
            hashMap.put(FIELD_PSSYSUIACTIONNAME, this.getPSSysUIActionName());
        }
        if (!bl || this.isTipPSSysLanResIdDirty()) {
            hashMap.put(FIELD_TIPPSSYSLANRESID, this.getTipPSSysLanResId());
        }
        if (!bl || this.isTipPSSysLanResNameDirty()) {
            hashMap.put(FIELD_TIPPSSYSLANRESNAME, this.getTipPSSysLanResName());
        }
        if (!bl || this.isToggleModeDirty()) {
            hashMap.put(FIELD_TOGGLEMODE, this.getToggleMode());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSSysUIActionBase.get(this, n);
    }

    private static Object get(PSSysUIActionBase pSSysUIActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUIActionBase.getActionTarget();
            }
            case 1: {
                return pSSysUIActionBase.getCapPSSysLanResId();
            }
            case 2: {
                return pSSysUIActionBase.getCapPSSysLanResName();
            }
            case 3: {
                return pSSysUIActionBase.getCaption();
            }
            case 4: {
                return pSSysUIActionBase.getCodeName();
            }
            case 5: {
                return pSSysUIActionBase.getCreateDate();
            }
            case 6: {
                return pSSysUIActionBase.getCreateMan();
            }
            case 7: {
                return pSSysUIActionBase.getDEOPPriv();
            }
            case 8: {
                return pSSysUIActionBase.getItemObj();
            }
            case 9: {
                return pSSysUIActionBase.getMemo();
            }
            case 10: {
                return pSSysUIActionBase.getPSImageTemplId();
            }
            case 11: {
                return pSSysUIActionBase.getPSImageTemplName();
            }
            case 12: {
                return pSSysUIActionBase.getPSSysUIActionId();
            }
            case 13: {
                return pSSysUIActionBase.getPSSysUIActionName();
            }
            case 14: {
                return pSSysUIActionBase.getTipPSSysLanResId();
            }
            case 15: {
                return pSSysUIActionBase.getTipPSSysLanResName();
            }
            case 16: {
                return pSSysUIActionBase.getToggleMode();
            }
            case 17: {
                return pSSysUIActionBase.getUpdateDate();
            }
            case 18: {
                return pSSysUIActionBase.getUpdateMan();
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
        PSSysUIActionBase.set(this, n, object);
    }

    private static void set(PSSysUIActionBase pSSysUIActionBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysUIActionBase.setActionTarget(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysUIActionBase.setCapPSSysLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysUIActionBase.setCapPSSysLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysUIActionBase.setCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysUIActionBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysUIActionBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSSysUIActionBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysUIActionBase.setDEOPPriv(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysUIActionBase.setItemObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysUIActionBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysUIActionBase.setPSImageTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysUIActionBase.setPSImageTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysUIActionBase.setPSSysUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysUIActionBase.setPSSysUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysUIActionBase.setTipPSSysLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysUIActionBase.setTipPSSysLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysUIActionBase.setToggleMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSSysUIActionBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 18: {
                pSSysUIActionBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSysUIActionBase.isNull(this, n);
    }

    private static boolean isNull(PSSysUIActionBase pSSysUIActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUIActionBase.getActionTarget() == null;
            }
            case 1: {
                return pSSysUIActionBase.getCapPSSysLanResId() == null;
            }
            case 2: {
                return pSSysUIActionBase.getCapPSSysLanResName() == null;
            }
            case 3: {
                return pSSysUIActionBase.getCaption() == null;
            }
            case 4: {
                return pSSysUIActionBase.getCodeName() == null;
            }
            case 5: {
                return pSSysUIActionBase.getCreateDate() == null;
            }
            case 6: {
                return pSSysUIActionBase.getCreateMan() == null;
            }
            case 7: {
                return pSSysUIActionBase.getDEOPPriv() == null;
            }
            case 8: {
                return pSSysUIActionBase.getItemObj() == null;
            }
            case 9: {
                return pSSysUIActionBase.getMemo() == null;
            }
            case 10: {
                return pSSysUIActionBase.getPSImageTemplId() == null;
            }
            case 11: {
                return pSSysUIActionBase.getPSImageTemplName() == null;
            }
            case 12: {
                return pSSysUIActionBase.getPSSysUIActionId() == null;
            }
            case 13: {
                return pSSysUIActionBase.getPSSysUIActionName() == null;
            }
            case 14: {
                return pSSysUIActionBase.getTipPSSysLanResId() == null;
            }
            case 15: {
                return pSSysUIActionBase.getTipPSSysLanResName() == null;
            }
            case 16: {
                return pSSysUIActionBase.getToggleMode() == null;
            }
            case 17: {
                return pSSysUIActionBase.getUpdateDate() == null;
            }
            case 18: {
                return pSSysUIActionBase.getUpdateMan() == null;
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
        return PSSysUIActionBase.contains(this, n);
    }

    private static boolean contains(PSSysUIActionBase pSSysUIActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUIActionBase.isActionTargetDirty();
            }
            case 1: {
                return pSSysUIActionBase.isCapPSSysLanResIdDirty();
            }
            case 2: {
                return pSSysUIActionBase.isCapPSSysLanResNameDirty();
            }
            case 3: {
                return pSSysUIActionBase.isCaptionDirty();
            }
            case 4: {
                return pSSysUIActionBase.isCodeNameDirty();
            }
            case 5: {
                return pSSysUIActionBase.isCreateDateDirty();
            }
            case 6: {
                return pSSysUIActionBase.isCreateManDirty();
            }
            case 7: {
                return pSSysUIActionBase.isDEOPPrivDirty();
            }
            case 8: {
                return pSSysUIActionBase.isItemObjDirty();
            }
            case 9: {
                return pSSysUIActionBase.isMemoDirty();
            }
            case 10: {
                return pSSysUIActionBase.isPSImageTemplIdDirty();
            }
            case 11: {
                return pSSysUIActionBase.isPSImageTemplNameDirty();
            }
            case 12: {
                return pSSysUIActionBase.isPSSysUIActionIdDirty();
            }
            case 13: {
                return pSSysUIActionBase.isPSSysUIActionNameDirty();
            }
            case 14: {
                return pSSysUIActionBase.isTipPSSysLanResIdDirty();
            }
            case 15: {
                return pSSysUIActionBase.isTipPSSysLanResNameDirty();
            }
            case 16: {
                return pSSysUIActionBase.isToggleModeDirty();
            }
            case 17: {
                return pSSysUIActionBase.isUpdateDateDirty();
            }
            case 18: {
                return pSSysUIActionBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysUIActionBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysUIActionBase pSSysUIActionBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysUIActionBase.getActionTarget() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actiontarget", (Object)PSSysUIActionBase.getJSONValue((Object)pSSysUIActionBase.getActionTarget()), (boolean)false);
        }
        if (bl || pSSysUIActionBase.getCapPSSysLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappssyslanresid", (Object)PSSysUIActionBase.getJSONValue((Object)pSSysUIActionBase.getCapPSSysLanResId()), (boolean)false);
        }
        if (bl || pSSysUIActionBase.getCapPSSysLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappssyslanresname", (Object)PSSysUIActionBase.getJSONValue((Object)pSSysUIActionBase.getCapPSSysLanResName()), (boolean)false);
        }
        if (bl || pSSysUIActionBase.getCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"caption", (Object)PSSysUIActionBase.getJSONValue((Object)pSSysUIActionBase.getCaption()), (boolean)false);
        }
        if (bl || pSSysUIActionBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysUIActionBase.getJSONValue((Object)pSSysUIActionBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysUIActionBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysUIActionBase.getJSONValue((Object)pSSysUIActionBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysUIActionBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysUIActionBase.getJSONValue((Object)pSSysUIActionBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysUIActionBase.getDEOPPriv() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deoppriv", (Object)PSSysUIActionBase.getJSONValue((Object)pSSysUIActionBase.getDEOPPriv()), (boolean)false);
        }
        if (bl || pSSysUIActionBase.getItemObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemobj", (Object)PSSysUIActionBase.getJSONValue((Object)pSSysUIActionBase.getItemObj()), (boolean)false);
        }
        if (bl || pSSysUIActionBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysUIActionBase.getJSONValue((Object)pSSysUIActionBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysUIActionBase.getPSImageTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psimagetemplid", (Object)PSSysUIActionBase.getJSONValue((Object)pSSysUIActionBase.getPSImageTemplId()), (boolean)false);
        }
        if (bl || pSSysUIActionBase.getPSImageTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psimagetemplname", (Object)PSSysUIActionBase.getJSONValue((Object)pSSysUIActionBase.getPSImageTemplName()), (boolean)false);
        }
        if (bl || pSSysUIActionBase.getPSSysUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuiactionid", (Object)PSSysUIActionBase.getJSONValue((Object)pSSysUIActionBase.getPSSysUIActionId()), (boolean)false);
        }
        if (bl || pSSysUIActionBase.getPSSysUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuiactionname", (Object)PSSysUIActionBase.getJSONValue((Object)pSSysUIActionBase.getPSSysUIActionName()), (boolean)false);
        }
        if (bl || pSSysUIActionBase.getTipPSSysLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tippssyslanresid", (Object)PSSysUIActionBase.getJSONValue((Object)pSSysUIActionBase.getTipPSSysLanResId()), (boolean)false);
        }
        if (bl || pSSysUIActionBase.getTipPSSysLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tippssyslanresname", (Object)PSSysUIActionBase.getJSONValue((Object)pSSysUIActionBase.getTipPSSysLanResName()), (boolean)false);
        }
        if (bl || pSSysUIActionBase.getToggleMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"togglemode", (Object)PSSysUIActionBase.getJSONValue((Object)pSSysUIActionBase.getToggleMode()), (boolean)false);
        }
        if (bl || pSSysUIActionBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysUIActionBase.getJSONValue((Object)pSSysUIActionBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysUIActionBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysUIActionBase.getJSONValue((Object)pSSysUIActionBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysUIActionBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysUIActionBase pSSysUIActionBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysUIActionBase.getActionTarget() != null) {
            object = pSSysUIActionBase.getActionTarget();
            xmlNode.setAttribute(FIELD_ACTIONTARGET, (String)(object == null ? "" : object));
        }
        if (bl || pSSysUIActionBase.getCapPSSysLanResId() != null) {
            object = pSSysUIActionBase.getCapPSSysLanResId();
            xmlNode.setAttribute(FIELD_CAPPSSYSLANRESID, (String)(object == null ? "" : object));
        }
        if (bl || pSSysUIActionBase.getCapPSSysLanResName() != null) {
            object = pSSysUIActionBase.getCapPSSysLanResName();
            xmlNode.setAttribute(FIELD_CAPPSSYSLANRESNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSSysUIActionBase.getCaption() != null) {
            object = pSSysUIActionBase.getCaption();
            xmlNode.setAttribute(FIELD_CAPTION, (String)(object == null ? "" : object));
        }
        if (bl || pSSysUIActionBase.getCodeName() != null) {
            object = pSSysUIActionBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUIActionBase.getCreateDate() != null) {
            object = pSSysUIActionBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysUIActionBase.getCreateMan() != null) {
            object = pSSysUIActionBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysUIActionBase.getDEOPPriv() != null) {
            object = pSSysUIActionBase.getDEOPPriv();
            xmlNode.setAttribute(FIELD_DEOPPRIV, object == null ? "" : (String)object);
        }
        if (bl || pSSysUIActionBase.getItemObj() != null) {
            object = pSSysUIActionBase.getItemObj();
            xmlNode.setAttribute(FIELD_ITEMOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSSysUIActionBase.getMemo() != null) {
            object = pSSysUIActionBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysUIActionBase.getPSImageTemplId() != null) {
            object = pSSysUIActionBase.getPSImageTemplId();
            xmlNode.setAttribute(FIELD_PSIMAGETEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUIActionBase.getPSImageTemplName() != null) {
            object = pSSysUIActionBase.getPSImageTemplName();
            xmlNode.setAttribute(FIELD_PSIMAGETEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUIActionBase.getPSSysUIActionId() != null) {
            object = pSSysUIActionBase.getPSSysUIActionId();
            xmlNode.setAttribute(FIELD_PSSYSUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUIActionBase.getPSSysUIActionName() != null) {
            object = pSSysUIActionBase.getPSSysUIActionName();
            xmlNode.setAttribute(FIELD_PSSYSUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUIActionBase.getTipPSSysLanResId() != null) {
            object = pSSysUIActionBase.getTipPSSysLanResId();
            xmlNode.setAttribute(FIELD_TIPPSSYSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUIActionBase.getTipPSSysLanResName() != null) {
            object = pSSysUIActionBase.getTipPSSysLanResName();
            xmlNode.setAttribute(FIELD_TIPPSSYSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUIActionBase.getToggleMode() != null) {
            object = pSSysUIActionBase.getToggleMode();
            xmlNode.setAttribute(FIELD_TOGGLEMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysUIActionBase.getUpdateDate() != null) {
            object = pSSysUIActionBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysUIActionBase.getUpdateMan() != null) {
            object = pSSysUIActionBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysUIActionBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysUIActionBase pSSysUIActionBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysUIActionBase.isActionTargetDirty() && (bl || pSSysUIActionBase.getActionTarget() != null)) {
            iDataObject.set(FIELD_ACTIONTARGET, (Object)pSSysUIActionBase.getActionTarget());
        }
        if (pSSysUIActionBase.isCapPSSysLanResIdDirty() && (bl || pSSysUIActionBase.getCapPSSysLanResId() != null)) {
            iDataObject.set(FIELD_CAPPSSYSLANRESID, (Object)pSSysUIActionBase.getCapPSSysLanResId());
        }
        if (pSSysUIActionBase.isCapPSSysLanResNameDirty() && (bl || pSSysUIActionBase.getCapPSSysLanResName() != null)) {
            iDataObject.set(FIELD_CAPPSSYSLANRESNAME, (Object)pSSysUIActionBase.getCapPSSysLanResName());
        }
        if (pSSysUIActionBase.isCaptionDirty() && (bl || pSSysUIActionBase.getCaption() != null)) {
            iDataObject.set(FIELD_CAPTION, (Object)pSSysUIActionBase.getCaption());
        }
        if (pSSysUIActionBase.isCodeNameDirty() && (bl || pSSysUIActionBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysUIActionBase.getCodeName());
        }
        if (pSSysUIActionBase.isCreateDateDirty() && (bl || pSSysUIActionBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysUIActionBase.getCreateDate());
        }
        if (pSSysUIActionBase.isCreateManDirty() && (bl || pSSysUIActionBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysUIActionBase.getCreateMan());
        }
        if (pSSysUIActionBase.isDEOPPrivDirty() && (bl || pSSysUIActionBase.getDEOPPriv() != null)) {
            iDataObject.set(FIELD_DEOPPRIV, (Object)pSSysUIActionBase.getDEOPPriv());
        }
        if (pSSysUIActionBase.isItemObjDirty() && (bl || pSSysUIActionBase.getItemObj() != null)) {
            iDataObject.set(FIELD_ITEMOBJ, (Object)pSSysUIActionBase.getItemObj());
        }
        if (pSSysUIActionBase.isMemoDirty() && (bl || pSSysUIActionBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysUIActionBase.getMemo());
        }
        if (pSSysUIActionBase.isPSImageTemplIdDirty() && (bl || pSSysUIActionBase.getPSImageTemplId() != null)) {
            iDataObject.set(FIELD_PSIMAGETEMPLID, (Object)pSSysUIActionBase.getPSImageTemplId());
        }
        if (pSSysUIActionBase.isPSImageTemplNameDirty() && (bl || pSSysUIActionBase.getPSImageTemplName() != null)) {
            iDataObject.set(FIELD_PSIMAGETEMPLNAME, (Object)pSSysUIActionBase.getPSImageTemplName());
        }
        if (pSSysUIActionBase.isPSSysUIActionIdDirty() && (bl || pSSysUIActionBase.getPSSysUIActionId() != null)) {
            iDataObject.set(FIELD_PSSYSUIACTIONID, (Object)pSSysUIActionBase.getPSSysUIActionId());
        }
        if (pSSysUIActionBase.isPSSysUIActionNameDirty() && (bl || pSSysUIActionBase.getPSSysUIActionName() != null)) {
            iDataObject.set(FIELD_PSSYSUIACTIONNAME, (Object)pSSysUIActionBase.getPSSysUIActionName());
        }
        if (pSSysUIActionBase.isTipPSSysLanResIdDirty() && (bl || pSSysUIActionBase.getTipPSSysLanResId() != null)) {
            iDataObject.set(FIELD_TIPPSSYSLANRESID, (Object)pSSysUIActionBase.getTipPSSysLanResId());
        }
        if (pSSysUIActionBase.isTipPSSysLanResNameDirty() && (bl || pSSysUIActionBase.getTipPSSysLanResName() != null)) {
            iDataObject.set(FIELD_TIPPSSYSLANRESNAME, (Object)pSSysUIActionBase.getTipPSSysLanResName());
        }
        if (pSSysUIActionBase.isToggleModeDirty() && (bl || pSSysUIActionBase.getToggleMode() != null)) {
            iDataObject.set(FIELD_TOGGLEMODE, (Object)pSSysUIActionBase.getToggleMode());
        }
        if (pSSysUIActionBase.isUpdateDateDirty() && (bl || pSSysUIActionBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysUIActionBase.getUpdateDate());
        }
        if (pSSysUIActionBase.isUpdateManDirty() && (bl || pSSysUIActionBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysUIActionBase.getUpdateMan());
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
        return PSSysUIActionBase.remove(this, n);
    }

    private static boolean remove(PSSysUIActionBase pSSysUIActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysUIActionBase.resetActionTarget();
                return true;
            }
            case 1: {
                pSSysUIActionBase.resetCapPSSysLanResId();
                return true;
            }
            case 2: {
                pSSysUIActionBase.resetCapPSSysLanResName();
                return true;
            }
            case 3: {
                pSSysUIActionBase.resetCaption();
                return true;
            }
            case 4: {
                pSSysUIActionBase.resetCodeName();
                return true;
            }
            case 5: {
                pSSysUIActionBase.resetCreateDate();
                return true;
            }
            case 6: {
                pSSysUIActionBase.resetCreateMan();
                return true;
            }
            case 7: {
                pSSysUIActionBase.resetDEOPPriv();
                return true;
            }
            case 8: {
                pSSysUIActionBase.resetItemObj();
                return true;
            }
            case 9: {
                pSSysUIActionBase.resetMemo();
                return true;
            }
            case 10: {
                pSSysUIActionBase.resetPSImageTemplId();
                return true;
            }
            case 11: {
                pSSysUIActionBase.resetPSImageTemplName();
                return true;
            }
            case 12: {
                pSSysUIActionBase.resetPSSysUIActionId();
                return true;
            }
            case 13: {
                pSSysUIActionBase.resetPSSysUIActionName();
                return true;
            }
            case 14: {
                pSSysUIActionBase.resetTipPSSysLanResId();
                return true;
            }
            case 15: {
                pSSysUIActionBase.resetTipPSSysLanResName();
                return true;
            }
            case 16: {
                pSSysUIActionBase.resetToggleMode();
                return true;
            }
            case 17: {
                pSSysUIActionBase.resetUpdateDate();
                return true;
            }
            case 18: {
                pSSysUIActionBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSImageTempl getPSImageTempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSImageTempl();
        }
        if (this.getPSImageTemplId() == null) {
            return null;
        }
        Integer n = this.objPSImageTemplLock;
        synchronized (n) {
            if (this.psimagetempl != null && DataTypeHelper.compare((int)25, (Object)this.getPSImageTemplId(), (Object)this.psimagetempl.getPSImageTemplId()) != 0L) {
                this.psimagetempl = null;
            }
            if (this.psimagetempl == null) {
                PSImageTempl pSImageTempl = new PSImageTempl();
                pSImageTempl.setPSImageTemplId(this.getPSImageTemplId());
                PSImageTemplService pSImageTemplService = (PSImageTemplService)ServiceGlobal.getService(PSImageTemplService.class, (SessionFactory)this.getSessionFactory());
                pSImageTemplService.autoGet(pSImageTempl);
                this.psimagetempl = pSImageTempl;
            }
            return this.psimagetempl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysLanRes getCapPSSysLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCapPSSysLanRes();
        }
        if (this.getCapPSSysLanResId() == null) {
            return null;
        }
        Integer n = this.objCapPSSysLanResLock;
        synchronized (n) {
            if (this.cappssyslanres != null && DataTypeHelper.compare((int)25, (Object)this.getCapPSSysLanResId(), (Object)this.cappssyslanres.getPSSysLanResId()) != 0L) {
                this.cappssyslanres = null;
            }
            if (this.cappssyslanres == null) {
                PSSysLanRes pSSysLanRes = new PSSysLanRes();
                pSSysLanRes.setPSSysLanResId(this.getCapPSSysLanResId());
                PSSysLanResService pSSysLanResService = (PSSysLanResService)ServiceGlobal.getService(PSSysLanResService.class, (SessionFactory)this.getSessionFactory());
                pSSysLanResService.autoGet(pSSysLanRes);
                this.cappssyslanres = pSSysLanRes;
            }
            return this.cappssyslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysLanRes getTipPSSysLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTipPSSysLanRes();
        }
        if (this.getTipPSSysLanResId() == null) {
            return null;
        }
        Integer n = this.objTipPSSysLanResLock;
        synchronized (n) {
            if (this.tippssyslanres != null && DataTypeHelper.compare((int)25, (Object)this.getTipPSSysLanResId(), (Object)this.tippssyslanres.getPSSysLanResId()) != 0L) {
                this.tippssyslanres = null;
            }
            if (this.tippssyslanres == null) {
                PSSysLanRes pSSysLanRes = new PSSysLanRes();
                pSSysLanRes.setPSSysLanResId(this.getTipPSSysLanResId());
                PSSysLanResService pSSysLanResService = (PSSysLanResService)ServiceGlobal.getService(PSSysLanResService.class, (SessionFactory)this.getSessionFactory());
                pSSysLanResService.autoGet(pSSysLanRes);
                this.tippssyslanres = pSSysLanRes;
            }
            return this.tippssyslanres;
        }
    }

    private PSSysUIActionBase getProxyEntity() {
        return this.proxyPSSysUIActionBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysUIActionBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysUIActionBase) {
            this.proxyPSSysUIActionBase = (PSSysUIActionBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysUIActionService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACTIONTARGET, 0);
        fieldIndexMap.put(FIELD_CAPPSSYSLANRESID, 1);
        fieldIndexMap.put(FIELD_CAPPSSYSLANRESNAME, 2);
        fieldIndexMap.put(FIELD_CAPTION, 3);
        fieldIndexMap.put(FIELD_CODENAME, 4);
        fieldIndexMap.put(FIELD_CREATEDATE, 5);
        fieldIndexMap.put(FIELD_CREATEMAN, 6);
        fieldIndexMap.put(FIELD_DEOPPRIV, 7);
        fieldIndexMap.put(FIELD_ITEMOBJ, 8);
        fieldIndexMap.put(FIELD_MEMO, 9);
        fieldIndexMap.put(FIELD_PSIMAGETEMPLID, 10);
        fieldIndexMap.put(FIELD_PSIMAGETEMPLNAME, 11);
        fieldIndexMap.put(FIELD_PSSYSUIACTIONID, 12);
        fieldIndexMap.put(FIELD_PSSYSUIACTIONNAME, 13);
        fieldIndexMap.put(FIELD_TIPPSSYSLANRESID, 14);
        fieldIndexMap.put(FIELD_TIPPSSYSLANRESNAME, 15);
        fieldIndexMap.put(FIELD_TOGGLEMODE, 16);
        fieldIndexMap.put(FIELD_UPDATEDATE, 17);
        fieldIndexMap.put(FIELD_UPDATEMAN, 18);
    }
}

