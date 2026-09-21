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
import net.ibizsys.pscore.srv.config.entity.PSCssTempl;
import net.ibizsys.pscore.srv.config.entity.PSImageTempl;
import net.ibizsys.pscore.srv.config.entity.PSSysTBItem;
import net.ibizsys.pscore.srv.config.entity.PSSysToolbar;
import net.ibizsys.pscore.srv.config.entity.PSSysUIAction;
import net.ibizsys.pscore.srv.config.service.PSCssTemplService;
import net.ibizsys.pscore.srv.config.service.PSImageTemplService;
import net.ibizsys.pscore.srv.config.service.PSSysTBItemService;
import net.ibizsys.pscore.srv.config.service.PSSysToolbarService;
import net.ibizsys.pscore.srv.config.service.PSSysUIActionService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysTBItemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysTBItemBase.class);
    public static final String FIELD_CAPTION = "CAPTION";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_HEIGHT = "HEIGHT";
    public static final String FIELD_LEVELTAG = "LEVELTAG";
    public static final String FIELD_LEVELVALUE = "LEVELVALUE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PPSSYSTBITEMID = "PPSSYSTBITEMID";
    public static final String FIELD_PPSSYSTBITEMNAME = "PPSSYSTBITEMNAME";
    public static final String FIELD_PSCSSTEMPLID = "PSCSSTEMPLID";
    public static final String FIELD_PSCSSTEMPLNAME = "PSCSSTEMPLNAME";
    public static final String FIELD_PSIMAGETEMPLID = "PSIMAGETEMPLID";
    public static final String FIELD_PSIMAGETEMPLNAME = "PSIMAGETEMPLNAME";
    public static final String FIELD_PSSYSTBITEMID = "PSSYSTBITEMID";
    public static final String FIELD_PSSYSTBITEMNAME = "PSSYSTBITEMNAME";
    public static final String FIELD_PSSYSTOOLBARID = "PSSYSTOOLBARID";
    public static final String FIELD_PSSYSTOOLBARNAME = "PSSYSTOOLBARNAME";
    public static final String FIELD_PSSYSUIACTIONID = "PSSYSUIACTIONID";
    public static final String FIELD_PSSYSUIACTIONNAME = "PSSYSUIACTIONNAME";
    public static final String FIELD_SHOWMODE = "SHOWMODE";
    public static final String FIELD_TBITEMTYPE = "TBITEMTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_WIDTH = "WIDTH";
    private static final int INDEX_CAPTION = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_HEIGHT = 3;
    private static final int INDEX_LEVELTAG = 4;
    private static final int INDEX_LEVELVALUE = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_ORDERVALUE = 7;
    private static final int INDEX_PPSSYSTBITEMID = 8;
    private static final int INDEX_PPSSYSTBITEMNAME = 9;
    private static final int INDEX_PSCSSTEMPLID = 10;
    private static final int INDEX_PSCSSTEMPLNAME = 11;
    private static final int INDEX_PSIMAGETEMPLID = 12;
    private static final int INDEX_PSIMAGETEMPLNAME = 13;
    private static final int INDEX_PSSYSTBITEMID = 14;
    private static final int INDEX_PSSYSTBITEMNAME = 15;
    private static final int INDEX_PSSYSTOOLBARID = 16;
    private static final int INDEX_PSSYSTOOLBARNAME = 17;
    private static final int INDEX_PSSYSUIACTIONID = 18;
    private static final int INDEX_PSSYSUIACTIONNAME = 19;
    private static final int INDEX_SHOWMODE = 20;
    private static final int INDEX_TBITEMTYPE = 21;
    private static final int INDEX_UPDATEDATE = 22;
    private static final int INDEX_UPDATEMAN = 23;
    private static final int INDEX_WIDTH = 24;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysTBItemBase proxyPSSysTBItemBase = null;
    private boolean captionDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean heightDirtyFlag = false;
    private boolean leveltagDirtyFlag = false;
    private boolean levelvalueDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean ppssystbitemidDirtyFlag = false;
    private boolean ppssystbitemnameDirtyFlag = false;
    private boolean pscsstemplidDirtyFlag = false;
    private boolean pscsstemplnameDirtyFlag = false;
    private boolean psimagetemplidDirtyFlag = false;
    private boolean psimagetemplnameDirtyFlag = false;
    private boolean pssystbitemidDirtyFlag = false;
    private boolean pssystbitemnameDirtyFlag = false;
    private boolean pssystoolbaridDirtyFlag = false;
    private boolean pssystoolbarnameDirtyFlag = false;
    private boolean pssysuiactionidDirtyFlag = false;
    private boolean pssysuiactionnameDirtyFlag = false;
    private boolean showmodeDirtyFlag = false;
    private boolean tbitemtypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean widthDirtyFlag = false;
    @Column(name="caption")
    private String caption;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="height")
    private Double height;
    @Column(name="leveltag")
    private String leveltag;
    @Column(name="levelvalue")
    private Integer levelvalue;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="ppssystbitemid")
    private String ppssystbitemid;
    @Column(name="ppssystbitemname")
    private String ppssystbitemname;
    @Column(name="pscsstemplid")
    private String pscsstemplid;
    @Column(name="pscsstemplname")
    private String pscsstemplname;
    @Column(name="psimagetemplid")
    private String psimagetemplid;
    @Column(name="psimagetemplname")
    private String psimagetemplname;
    @Column(name="pssystbitemid")
    private String pssystbitemid;
    @Column(name="pssystbitemname")
    private String pssystbitemname;
    @Column(name="pssystoolbarid")
    private String pssystoolbarid;
    @Column(name="pssystoolbarname")
    private String pssystoolbarname;
    @Column(name="pssysuiactionid")
    private String pssysuiactionid;
    @Column(name="pssysuiactionname")
    private String pssysuiactionname;
    @Column(name="showmode")
    private String showmode;
    @Column(name="tbitemtype")
    private String tbitemtype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="width")
    private Double width;
    private Integer objPscsstemplLock = new Integer(1);
    private PSCssTempl pscsstempl = null;
    private Integer objPsimagetemplLock = new Integer(1);
    private PSImageTempl psimagetempl = null;
    private Integer objPPSSysTBItemLock = new Integer(1);
    private PSSysTBItem ppssystbitem = null;
    private Integer objPSSysToolbarLock = new Integer(1);
    private PSSysToolbar pssystoolbar = null;
    private Integer objPSSysUIActionLock = new Integer(1);
    private PSSysUIAction pssysuiaction = null;

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

    public void setHeight(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHeight(d);
            return;
        }
        this.height = d;
        this.heightDirtyFlag = true;
    }

    public Double getHeight() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHeight();
        }
        return this.height;
    }

    public boolean isHeightDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHeightDirty();
        }
        return this.heightDirtyFlag;
    }

    public void resetHeight() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHeight();
            return;
        }
        this.heightDirtyFlag = false;
        this.height = null;
    }

    public void setLevelTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLevelTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.leveltag = string;
        this.leveltagDirtyFlag = true;
    }

    public String getLevelTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLevelTag();
        }
        return this.leveltag;
    }

    public boolean isLevelTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLevelTagDirty();
        }
        return this.leveltagDirtyFlag;
    }

    public void resetLevelTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLevelTag();
            return;
        }
        this.leveltagDirtyFlag = false;
        this.leveltag = null;
    }

    public void setLevelValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLevelValue(n);
            return;
        }
        this.levelvalue = n;
        this.levelvalueDirtyFlag = true;
    }

    public Integer getLevelValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLevelValue();
        }
        return this.levelvalue;
    }

    public boolean isLevelValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLevelValueDirty();
        }
        return this.levelvalueDirtyFlag;
    }

    public void resetLevelValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLevelValue();
            return;
        }
        this.levelvalueDirtyFlag = false;
        this.levelvalue = null;
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

    public void setPPSSysTBItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSysTBItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssystbitemid = string;
        this.ppssystbitemidDirtyFlag = true;
    }

    public String getPPSSysTBItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysTBItemId();
        }
        return this.ppssystbitemid;
    }

    public boolean isPPSSysTBItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSysTBItemIdDirty();
        }
        return this.ppssystbitemidDirtyFlag;
    }

    public void resetPPSSysTBItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSysTBItemId();
            return;
        }
        this.ppssystbitemidDirtyFlag = false;
        this.ppssystbitemid = null;
    }

    public void setPPSSysTBItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSysTBItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssystbitemname = string;
        this.ppssystbitemnameDirtyFlag = true;
    }

    public String getPPSSysTBItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysTBItemName();
        }
        return this.ppssystbitemname;
    }

    public boolean isPPSSysTBItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSysTBItemNameDirty();
        }
        return this.ppssystbitemnameDirtyFlag;
    }

    public void resetPPSSysTBItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSysTBItemName();
            return;
        }
        this.ppssystbitemnameDirtyFlag = false;
        this.ppssystbitemname = null;
    }

    public void setPSCssTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCssTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscsstemplid = string;
        this.pscsstemplidDirtyFlag = true;
    }

    public String getPSCssTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCssTemplId();
        }
        return this.pscsstemplid;
    }

    public boolean isPSCssTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCssTemplIdDirty();
        }
        return this.pscsstemplidDirtyFlag;
    }

    public void resetPSCssTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCssTemplId();
            return;
        }
        this.pscsstemplidDirtyFlag = false;
        this.pscsstemplid = null;
    }

    public void setPSCssTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCssTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscsstemplname = string;
        this.pscsstemplnameDirtyFlag = true;
    }

    public String getPSCssTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCssTemplName();
        }
        return this.pscsstemplname;
    }

    public boolean isPSCssTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCssTemplNameDirty();
        }
        return this.pscsstemplnameDirtyFlag;
    }

    public void resetPSCssTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCssTemplName();
            return;
        }
        this.pscsstemplnameDirtyFlag = false;
        this.pscsstemplname = null;
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

    public void setPSSysTBItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTBItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystbitemid = string;
        this.pssystbitemidDirtyFlag = true;
    }

    public String getPSSysTBItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTBItemId();
        }
        return this.pssystbitemid;
    }

    public boolean isPSSysTBItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTBItemIdDirty();
        }
        return this.pssystbitemidDirtyFlag;
    }

    public void resetPSSysTBItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTBItemId();
            return;
        }
        this.pssystbitemidDirtyFlag = false;
        this.pssystbitemid = null;
    }

    public void setPSSysTBItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTBItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystbitemname = string;
        this.pssystbitemnameDirtyFlag = true;
    }

    public String getPSSysTBItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTBItemName();
        }
        return this.pssystbitemname;
    }

    public boolean isPSSysTBItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTBItemNameDirty();
        }
        return this.pssystbitemnameDirtyFlag;
    }

    public void resetPSSysTBItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTBItemName();
            return;
        }
        this.pssystbitemnameDirtyFlag = false;
        this.pssystbitemname = null;
    }

    public void setPSSysToolbarId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysToolbarId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystoolbarid = string;
        this.pssystoolbaridDirtyFlag = true;
    }

    public String getPSSysToolbarId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysToolbarId();
        }
        return this.pssystoolbarid;
    }

    public boolean isPSSysToolbarIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysToolbarIdDirty();
        }
        return this.pssystoolbaridDirtyFlag;
    }

    public void resetPSSysToolbarId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysToolbarId();
            return;
        }
        this.pssystoolbaridDirtyFlag = false;
        this.pssystoolbarid = null;
    }

    public void setPSSysToolbarName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysToolbarName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystoolbarname = string;
        this.pssystoolbarnameDirtyFlag = true;
    }

    public String getPSSysToolbarName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysToolbarName();
        }
        return this.pssystoolbarname;
    }

    public boolean isPSSysToolbarNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysToolbarNameDirty();
        }
        return this.pssystoolbarnameDirtyFlag;
    }

    public void resetPSSysToolbarName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysToolbarName();
            return;
        }
        this.pssystoolbarnameDirtyFlag = false;
        this.pssystoolbarname = null;
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

    public void setShowMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setShowMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.showmode = string;
        this.showmodeDirtyFlag = true;
    }

    public String getShowMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShowMode();
        }
        return this.showmode;
    }

    public boolean isShowModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isShowModeDirty();
        }
        return this.showmodeDirtyFlag;
    }

    public void resetShowMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetShowMode();
            return;
        }
        this.showmodeDirtyFlag = false;
        this.showmode = null;
    }

    public void setTBItemType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTBItemType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tbitemtype = string;
        this.tbitemtypeDirtyFlag = true;
    }

    public String getTBItemType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTBItemType();
        }
        return this.tbitemtype;
    }

    public boolean isTBItemTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTBItemTypeDirty();
        }
        return this.tbitemtypeDirtyFlag;
    }

    public void resetTBItemType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTBItemType();
            return;
        }
        this.tbitemtypeDirtyFlag = false;
        this.tbitemtype = null;
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

    public void setWidth(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWidth(d);
            return;
        }
        this.width = d;
        this.widthDirtyFlag = true;
    }

    public Double getWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWidth();
        }
        return this.width;
    }

    public boolean isWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWidthDirty();
        }
        return this.widthDirtyFlag;
    }

    public void resetWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWidth();
            return;
        }
        this.widthDirtyFlag = false;
        this.width = null;
    }

    protected void onReset() {
        PSSysTBItemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysTBItemBase pSSysTBItemBase) {
        pSSysTBItemBase.resetCaption();
        pSSysTBItemBase.resetCreateDate();
        pSSysTBItemBase.resetCreateMan();
        pSSysTBItemBase.resetHeight();
        pSSysTBItemBase.resetLevelTag();
        pSSysTBItemBase.resetLevelValue();
        pSSysTBItemBase.resetMemo();
        pSSysTBItemBase.resetOrderValue();
        pSSysTBItemBase.resetPPSSysTBItemId();
        pSSysTBItemBase.resetPPSSysTBItemName();
        pSSysTBItemBase.resetPSCssTemplId();
        pSSysTBItemBase.resetPSCssTemplName();
        pSSysTBItemBase.resetPSImageTemplId();
        pSSysTBItemBase.resetPSImageTemplName();
        pSSysTBItemBase.resetPSSysTBItemId();
        pSSysTBItemBase.resetPSSysTBItemName();
        pSSysTBItemBase.resetPSSysToolbarId();
        pSSysTBItemBase.resetPSSysToolbarName();
        pSSysTBItemBase.resetPSSysUIActionId();
        pSSysTBItemBase.resetPSSysUIActionName();
        pSSysTBItemBase.resetShowMode();
        pSSysTBItemBase.resetTBItemType();
        pSSysTBItemBase.resetUpdateDate();
        pSSysTBItemBase.resetUpdateMan();
        pSSysTBItemBase.resetWidth();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCaptionDirty()) {
            hashMap.put(FIELD_CAPTION, this.getCaption());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isHeightDirty()) {
            hashMap.put(FIELD_HEIGHT, this.getHeight());
        }
        if (!bl || this.isLevelTagDirty()) {
            hashMap.put(FIELD_LEVELTAG, this.getLevelTag());
        }
        if (!bl || this.isLevelValueDirty()) {
            hashMap.put(FIELD_LEVELVALUE, this.getLevelValue());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPPSSysTBItemIdDirty()) {
            hashMap.put(FIELD_PPSSYSTBITEMID, this.getPPSSysTBItemId());
        }
        if (!bl || this.isPPSSysTBItemNameDirty()) {
            hashMap.put(FIELD_PPSSYSTBITEMNAME, this.getPPSSysTBItemName());
        }
        if (!bl || this.isPSCssTemplIdDirty()) {
            hashMap.put(FIELD_PSCSSTEMPLID, this.getPSCssTemplId());
        }
        if (!bl || this.isPSCssTemplNameDirty()) {
            hashMap.put(FIELD_PSCSSTEMPLNAME, this.getPSCssTemplName());
        }
        if (!bl || this.isPSImageTemplIdDirty()) {
            hashMap.put(FIELD_PSIMAGETEMPLID, this.getPSImageTemplId());
        }
        if (!bl || this.isPSImageTemplNameDirty()) {
            hashMap.put(FIELD_PSIMAGETEMPLNAME, this.getPSImageTemplName());
        }
        if (!bl || this.isPSSysTBItemIdDirty()) {
            hashMap.put(FIELD_PSSYSTBITEMID, this.getPSSysTBItemId());
        }
        if (!bl || this.isPSSysTBItemNameDirty()) {
            hashMap.put(FIELD_PSSYSTBITEMNAME, this.getPSSysTBItemName());
        }
        if (!bl || this.isPSSysToolbarIdDirty()) {
            hashMap.put(FIELD_PSSYSTOOLBARID, this.getPSSysToolbarId());
        }
        if (!bl || this.isPSSysToolbarNameDirty()) {
            hashMap.put(FIELD_PSSYSTOOLBARNAME, this.getPSSysToolbarName());
        }
        if (!bl || this.isPSSysUIActionIdDirty()) {
            hashMap.put(FIELD_PSSYSUIACTIONID, this.getPSSysUIActionId());
        }
        if (!bl || this.isPSSysUIActionNameDirty()) {
            hashMap.put(FIELD_PSSYSUIACTIONNAME, this.getPSSysUIActionName());
        }
        if (!bl || this.isShowModeDirty()) {
            hashMap.put(FIELD_SHOWMODE, this.getShowMode());
        }
        if (!bl || this.isTBItemTypeDirty()) {
            hashMap.put(FIELD_TBITEMTYPE, this.getTBItemType());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isWidthDirty()) {
            hashMap.put(FIELD_WIDTH, this.getWidth());
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
        return PSSysTBItemBase.get(this, n);
    }

    private static Object get(PSSysTBItemBase pSSysTBItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysTBItemBase.getCaption();
            }
            case 1: {
                return pSSysTBItemBase.getCreateDate();
            }
            case 2: {
                return pSSysTBItemBase.getCreateMan();
            }
            case 3: {
                return pSSysTBItemBase.getHeight();
            }
            case 4: {
                return pSSysTBItemBase.getLevelTag();
            }
            case 5: {
                return pSSysTBItemBase.getLevelValue();
            }
            case 6: {
                return pSSysTBItemBase.getMemo();
            }
            case 7: {
                return pSSysTBItemBase.getOrderValue();
            }
            case 8: {
                return pSSysTBItemBase.getPPSSysTBItemId();
            }
            case 9: {
                return pSSysTBItemBase.getPPSSysTBItemName();
            }
            case 10: {
                return pSSysTBItemBase.getPSCssTemplId();
            }
            case 11: {
                return pSSysTBItemBase.getPSCssTemplName();
            }
            case 12: {
                return pSSysTBItemBase.getPSImageTemplId();
            }
            case 13: {
                return pSSysTBItemBase.getPSImageTemplName();
            }
            case 14: {
                return pSSysTBItemBase.getPSSysTBItemId();
            }
            case 15: {
                return pSSysTBItemBase.getPSSysTBItemName();
            }
            case 16: {
                return pSSysTBItemBase.getPSSysToolbarId();
            }
            case 17: {
                return pSSysTBItemBase.getPSSysToolbarName();
            }
            case 18: {
                return pSSysTBItemBase.getPSSysUIActionId();
            }
            case 19: {
                return pSSysTBItemBase.getPSSysUIActionName();
            }
            case 20: {
                return pSSysTBItemBase.getShowMode();
            }
            case 21: {
                return pSSysTBItemBase.getTBItemType();
            }
            case 22: {
                return pSSysTBItemBase.getUpdateDate();
            }
            case 23: {
                return pSSysTBItemBase.getUpdateMan();
            }
            case 24: {
                return pSSysTBItemBase.getWidth();
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
        PSSysTBItemBase.set(this, n, object);
    }

    private static void set(PSSysTBItemBase pSSysTBItemBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysTBItemBase.setCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysTBItemBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysTBItemBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysTBItemBase.setHeight(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 4: {
                pSSysTBItemBase.setLevelTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysTBItemBase.setLevelValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSSysTBItemBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysTBItemBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSSysTBItemBase.setPPSSysTBItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysTBItemBase.setPPSSysTBItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysTBItemBase.setPSCssTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysTBItemBase.setPSCssTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysTBItemBase.setPSImageTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysTBItemBase.setPSImageTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysTBItemBase.setPSSysTBItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysTBItemBase.setPSSysTBItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysTBItemBase.setPSSysToolbarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysTBItemBase.setPSSysToolbarName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysTBItemBase.setPSSysUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysTBItemBase.setPSSysUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysTBItemBase.setShowMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysTBItemBase.setTBItemType(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysTBItemBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 23: {
                pSSysTBItemBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysTBItemBase.setWidth(DataObject.getDoubleValue((Object)object));
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
        return PSSysTBItemBase.isNull(this, n);
    }

    private static boolean isNull(PSSysTBItemBase pSSysTBItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysTBItemBase.getCaption() == null;
            }
            case 1: {
                return pSSysTBItemBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysTBItemBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysTBItemBase.getHeight() == null;
            }
            case 4: {
                return pSSysTBItemBase.getLevelTag() == null;
            }
            case 5: {
                return pSSysTBItemBase.getLevelValue() == null;
            }
            case 6: {
                return pSSysTBItemBase.getMemo() == null;
            }
            case 7: {
                return pSSysTBItemBase.getOrderValue() == null;
            }
            case 8: {
                return pSSysTBItemBase.getPPSSysTBItemId() == null;
            }
            case 9: {
                return pSSysTBItemBase.getPPSSysTBItemName() == null;
            }
            case 10: {
                return pSSysTBItemBase.getPSCssTemplId() == null;
            }
            case 11: {
                return pSSysTBItemBase.getPSCssTemplName() == null;
            }
            case 12: {
                return pSSysTBItemBase.getPSImageTemplId() == null;
            }
            case 13: {
                return pSSysTBItemBase.getPSImageTemplName() == null;
            }
            case 14: {
                return pSSysTBItemBase.getPSSysTBItemId() == null;
            }
            case 15: {
                return pSSysTBItemBase.getPSSysTBItemName() == null;
            }
            case 16: {
                return pSSysTBItemBase.getPSSysToolbarId() == null;
            }
            case 17: {
                return pSSysTBItemBase.getPSSysToolbarName() == null;
            }
            case 18: {
                return pSSysTBItemBase.getPSSysUIActionId() == null;
            }
            case 19: {
                return pSSysTBItemBase.getPSSysUIActionName() == null;
            }
            case 20: {
                return pSSysTBItemBase.getShowMode() == null;
            }
            case 21: {
                return pSSysTBItemBase.getTBItemType() == null;
            }
            case 22: {
                return pSSysTBItemBase.getUpdateDate() == null;
            }
            case 23: {
                return pSSysTBItemBase.getUpdateMan() == null;
            }
            case 24: {
                return pSSysTBItemBase.getWidth() == null;
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
        return PSSysTBItemBase.contains(this, n);
    }

    private static boolean contains(PSSysTBItemBase pSSysTBItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysTBItemBase.isCaptionDirty();
            }
            case 1: {
                return pSSysTBItemBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysTBItemBase.isCreateManDirty();
            }
            case 3: {
                return pSSysTBItemBase.isHeightDirty();
            }
            case 4: {
                return pSSysTBItemBase.isLevelTagDirty();
            }
            case 5: {
                return pSSysTBItemBase.isLevelValueDirty();
            }
            case 6: {
                return pSSysTBItemBase.isMemoDirty();
            }
            case 7: {
                return pSSysTBItemBase.isOrderValueDirty();
            }
            case 8: {
                return pSSysTBItemBase.isPPSSysTBItemIdDirty();
            }
            case 9: {
                return pSSysTBItemBase.isPPSSysTBItemNameDirty();
            }
            case 10: {
                return pSSysTBItemBase.isPSCssTemplIdDirty();
            }
            case 11: {
                return pSSysTBItemBase.isPSCssTemplNameDirty();
            }
            case 12: {
                return pSSysTBItemBase.isPSImageTemplIdDirty();
            }
            case 13: {
                return pSSysTBItemBase.isPSImageTemplNameDirty();
            }
            case 14: {
                return pSSysTBItemBase.isPSSysTBItemIdDirty();
            }
            case 15: {
                return pSSysTBItemBase.isPSSysTBItemNameDirty();
            }
            case 16: {
                return pSSysTBItemBase.isPSSysToolbarIdDirty();
            }
            case 17: {
                return pSSysTBItemBase.isPSSysToolbarNameDirty();
            }
            case 18: {
                return pSSysTBItemBase.isPSSysUIActionIdDirty();
            }
            case 19: {
                return pSSysTBItemBase.isPSSysUIActionNameDirty();
            }
            case 20: {
                return pSSysTBItemBase.isShowModeDirty();
            }
            case 21: {
                return pSSysTBItemBase.isTBItemTypeDirty();
            }
            case 22: {
                return pSSysTBItemBase.isUpdateDateDirty();
            }
            case 23: {
                return pSSysTBItemBase.isUpdateManDirty();
            }
            case 24: {
                return pSSysTBItemBase.isWidthDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysTBItemBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysTBItemBase pSSysTBItemBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysTBItemBase.getCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"caption", (Object)PSSysTBItemBase.getJSONValue((Object)pSSysTBItemBase.getCaption()), (boolean)false);
        }
        if (bl || pSSysTBItemBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysTBItemBase.getJSONValue((Object)pSSysTBItemBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysTBItemBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysTBItemBase.getJSONValue((Object)pSSysTBItemBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysTBItemBase.getHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"height", (Object)PSSysTBItemBase.getJSONValue((Object)pSSysTBItemBase.getHeight()), (boolean)false);
        }
        if (bl || pSSysTBItemBase.getLevelTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"leveltag", (Object)PSSysTBItemBase.getJSONValue((Object)pSSysTBItemBase.getLevelTag()), (boolean)false);
        }
        if (bl || pSSysTBItemBase.getLevelValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"levelvalue", (Object)PSSysTBItemBase.getJSONValue((Object)pSSysTBItemBase.getLevelValue()), (boolean)false);
        }
        if (bl || pSSysTBItemBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysTBItemBase.getJSONValue((Object)pSSysTBItemBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysTBItemBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysTBItemBase.getJSONValue((Object)pSSysTBItemBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysTBItemBase.getPPSSysTBItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssystbitemid", (Object)PSSysTBItemBase.getJSONValue((Object)pSSysTBItemBase.getPPSSysTBItemId()), (boolean)false);
        }
        if (bl || pSSysTBItemBase.getPPSSysTBItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssystbitemname", (Object)PSSysTBItemBase.getJSONValue((Object)pSSysTBItemBase.getPPSSysTBItemName()), (boolean)false);
        }
        if (bl || pSSysTBItemBase.getPSCssTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscsstemplid", (Object)PSSysTBItemBase.getJSONValue((Object)pSSysTBItemBase.getPSCssTemplId()), (boolean)false);
        }
        if (bl || pSSysTBItemBase.getPSCssTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscsstemplname", (Object)PSSysTBItemBase.getJSONValue((Object)pSSysTBItemBase.getPSCssTemplName()), (boolean)false);
        }
        if (bl || pSSysTBItemBase.getPSImageTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psimagetemplid", (Object)PSSysTBItemBase.getJSONValue((Object)pSSysTBItemBase.getPSImageTemplId()), (boolean)false);
        }
        if (bl || pSSysTBItemBase.getPSImageTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psimagetemplname", (Object)PSSysTBItemBase.getJSONValue((Object)pSSysTBItemBase.getPSImageTemplName()), (boolean)false);
        }
        if (bl || pSSysTBItemBase.getPSSysTBItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystbitemid", (Object)PSSysTBItemBase.getJSONValue((Object)pSSysTBItemBase.getPSSysTBItemId()), (boolean)false);
        }
        if (bl || pSSysTBItemBase.getPSSysTBItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystbitemname", (Object)PSSysTBItemBase.getJSONValue((Object)pSSysTBItemBase.getPSSysTBItemName()), (boolean)false);
        }
        if (bl || pSSysTBItemBase.getPSSysToolbarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystoolbarid", (Object)PSSysTBItemBase.getJSONValue((Object)pSSysTBItemBase.getPSSysToolbarId()), (boolean)false);
        }
        if (bl || pSSysTBItemBase.getPSSysToolbarName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystoolbarname", (Object)PSSysTBItemBase.getJSONValue((Object)pSSysTBItemBase.getPSSysToolbarName()), (boolean)false);
        }
        if (bl || pSSysTBItemBase.getPSSysUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuiactionid", (Object)PSSysTBItemBase.getJSONValue((Object)pSSysTBItemBase.getPSSysUIActionId()), (boolean)false);
        }
        if (bl || pSSysTBItemBase.getPSSysUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuiactionname", (Object)PSSysTBItemBase.getJSONValue((Object)pSSysTBItemBase.getPSSysUIActionName()), (boolean)false);
        }
        if (bl || pSSysTBItemBase.getShowMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"showmode", (Object)PSSysTBItemBase.getJSONValue((Object)pSSysTBItemBase.getShowMode()), (boolean)false);
        }
        if (bl || pSSysTBItemBase.getTBItemType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tbitemtype", (Object)PSSysTBItemBase.getJSONValue((Object)pSSysTBItemBase.getTBItemType()), (boolean)false);
        }
        if (bl || pSSysTBItemBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysTBItemBase.getJSONValue((Object)pSSysTBItemBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysTBItemBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysTBItemBase.getJSONValue((Object)pSSysTBItemBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysTBItemBase.getWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"width", (Object)PSSysTBItemBase.getJSONValue((Object)pSSysTBItemBase.getWidth()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysTBItemBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysTBItemBase pSSysTBItemBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysTBItemBase.getCaption() != null) {
            object = pSSysTBItemBase.getCaption();
            xmlNode.setAttribute(FIELD_CAPTION, object == null ? "" : (String)object);
        }
        if (bl || pSSysTBItemBase.getCreateDate() != null) {
            object = pSSysTBItemBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysTBItemBase.getCreateMan() != null) {
            object = pSSysTBItemBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysTBItemBase.getHeight() != null) {
            object = pSSysTBItemBase.getHeight();
            xmlNode.setAttribute(FIELD_HEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysTBItemBase.getLevelTag() != null) {
            object = pSSysTBItemBase.getLevelTag();
            xmlNode.setAttribute(FIELD_LEVELTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysTBItemBase.getLevelValue() != null) {
            object = pSSysTBItemBase.getLevelValue();
            xmlNode.setAttribute(FIELD_LEVELVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysTBItemBase.getMemo() != null) {
            object = pSSysTBItemBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysTBItemBase.getOrderValue() != null) {
            object = pSSysTBItemBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysTBItemBase.getPPSSysTBItemId() != null) {
            object = pSSysTBItemBase.getPPSSysTBItemId();
            xmlNode.setAttribute(FIELD_PPSSYSTBITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTBItemBase.getPPSSysTBItemName() != null) {
            object = pSSysTBItemBase.getPPSSysTBItemName();
            xmlNode.setAttribute(FIELD_PPSSYSTBITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTBItemBase.getPSCssTemplId() != null) {
            object = pSSysTBItemBase.getPSCssTemplId();
            xmlNode.setAttribute(FIELD_PSCSSTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTBItemBase.getPSCssTemplName() != null) {
            object = pSSysTBItemBase.getPSCssTemplName();
            xmlNode.setAttribute(FIELD_PSCSSTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTBItemBase.getPSImageTemplId() != null) {
            object = pSSysTBItemBase.getPSImageTemplId();
            xmlNode.setAttribute(FIELD_PSIMAGETEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTBItemBase.getPSImageTemplName() != null) {
            object = pSSysTBItemBase.getPSImageTemplName();
            xmlNode.setAttribute(FIELD_PSIMAGETEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTBItemBase.getPSSysTBItemId() != null) {
            object = pSSysTBItemBase.getPSSysTBItemId();
            xmlNode.setAttribute(FIELD_PSSYSTBITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTBItemBase.getPSSysTBItemName() != null) {
            object = pSSysTBItemBase.getPSSysTBItemName();
            xmlNode.setAttribute(FIELD_PSSYSTBITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTBItemBase.getPSSysToolbarId() != null) {
            object = pSSysTBItemBase.getPSSysToolbarId();
            xmlNode.setAttribute(FIELD_PSSYSTOOLBARID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTBItemBase.getPSSysToolbarName() != null) {
            object = pSSysTBItemBase.getPSSysToolbarName();
            xmlNode.setAttribute(FIELD_PSSYSTOOLBARNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTBItemBase.getPSSysUIActionId() != null) {
            object = pSSysTBItemBase.getPSSysUIActionId();
            xmlNode.setAttribute(FIELD_PSSYSUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTBItemBase.getPSSysUIActionName() != null) {
            object = pSSysTBItemBase.getPSSysUIActionName();
            xmlNode.setAttribute(FIELD_PSSYSUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTBItemBase.getShowMode() != null) {
            object = pSSysTBItemBase.getShowMode();
            xmlNode.setAttribute(FIELD_SHOWMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysTBItemBase.getTBItemType() != null) {
            object = pSSysTBItemBase.getTBItemType();
            xmlNode.setAttribute(FIELD_TBITEMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysTBItemBase.getUpdateDate() != null) {
            object = pSSysTBItemBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysTBItemBase.getUpdateMan() != null) {
            object = pSSysTBItemBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysTBItemBase.getWidth() != null) {
            object = pSSysTBItemBase.getWidth();
            xmlNode.setAttribute(FIELD_WIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysTBItemBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysTBItemBase pSSysTBItemBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysTBItemBase.isCaptionDirty() && (bl || pSSysTBItemBase.getCaption() != null)) {
            iDataObject.set(FIELD_CAPTION, (Object)pSSysTBItemBase.getCaption());
        }
        if (pSSysTBItemBase.isCreateDateDirty() && (bl || pSSysTBItemBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysTBItemBase.getCreateDate());
        }
        if (pSSysTBItemBase.isCreateManDirty() && (bl || pSSysTBItemBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysTBItemBase.getCreateMan());
        }
        if (pSSysTBItemBase.isHeightDirty() && (bl || pSSysTBItemBase.getHeight() != null)) {
            iDataObject.set(FIELD_HEIGHT, (Object)pSSysTBItemBase.getHeight());
        }
        if (pSSysTBItemBase.isLevelTagDirty() && (bl || pSSysTBItemBase.getLevelTag() != null)) {
            iDataObject.set(FIELD_LEVELTAG, (Object)pSSysTBItemBase.getLevelTag());
        }
        if (pSSysTBItemBase.isLevelValueDirty() && (bl || pSSysTBItemBase.getLevelValue() != null)) {
            iDataObject.set(FIELD_LEVELVALUE, (Object)pSSysTBItemBase.getLevelValue());
        }
        if (pSSysTBItemBase.isMemoDirty() && (bl || pSSysTBItemBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysTBItemBase.getMemo());
        }
        if (pSSysTBItemBase.isOrderValueDirty() && (bl || pSSysTBItemBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysTBItemBase.getOrderValue());
        }
        if (pSSysTBItemBase.isPPSSysTBItemIdDirty() && (bl || pSSysTBItemBase.getPPSSysTBItemId() != null)) {
            iDataObject.set(FIELD_PPSSYSTBITEMID, (Object)pSSysTBItemBase.getPPSSysTBItemId());
        }
        if (pSSysTBItemBase.isPPSSysTBItemNameDirty() && (bl || pSSysTBItemBase.getPPSSysTBItemName() != null)) {
            iDataObject.set(FIELD_PPSSYSTBITEMNAME, (Object)pSSysTBItemBase.getPPSSysTBItemName());
        }
        if (pSSysTBItemBase.isPSCssTemplIdDirty() && (bl || pSSysTBItemBase.getPSCssTemplId() != null)) {
            iDataObject.set(FIELD_PSCSSTEMPLID, (Object)pSSysTBItemBase.getPSCssTemplId());
        }
        if (pSSysTBItemBase.isPSCssTemplNameDirty() && (bl || pSSysTBItemBase.getPSCssTemplName() != null)) {
            iDataObject.set(FIELD_PSCSSTEMPLNAME, (Object)pSSysTBItemBase.getPSCssTemplName());
        }
        if (pSSysTBItemBase.isPSImageTemplIdDirty() && (bl || pSSysTBItemBase.getPSImageTemplId() != null)) {
            iDataObject.set(FIELD_PSIMAGETEMPLID, (Object)pSSysTBItemBase.getPSImageTemplId());
        }
        if (pSSysTBItemBase.isPSImageTemplNameDirty() && (bl || pSSysTBItemBase.getPSImageTemplName() != null)) {
            iDataObject.set(FIELD_PSIMAGETEMPLNAME, (Object)pSSysTBItemBase.getPSImageTemplName());
        }
        if (pSSysTBItemBase.isPSSysTBItemIdDirty() && (bl || pSSysTBItemBase.getPSSysTBItemId() != null)) {
            iDataObject.set(FIELD_PSSYSTBITEMID, (Object)pSSysTBItemBase.getPSSysTBItemId());
        }
        if (pSSysTBItemBase.isPSSysTBItemNameDirty() && (bl || pSSysTBItemBase.getPSSysTBItemName() != null)) {
            iDataObject.set(FIELD_PSSYSTBITEMNAME, (Object)pSSysTBItemBase.getPSSysTBItemName());
        }
        if (pSSysTBItemBase.isPSSysToolbarIdDirty() && (bl || pSSysTBItemBase.getPSSysToolbarId() != null)) {
            iDataObject.set(FIELD_PSSYSTOOLBARID, (Object)pSSysTBItemBase.getPSSysToolbarId());
        }
        if (pSSysTBItemBase.isPSSysToolbarNameDirty() && (bl || pSSysTBItemBase.getPSSysToolbarName() != null)) {
            iDataObject.set(FIELD_PSSYSTOOLBARNAME, (Object)pSSysTBItemBase.getPSSysToolbarName());
        }
        if (pSSysTBItemBase.isPSSysUIActionIdDirty() && (bl || pSSysTBItemBase.getPSSysUIActionId() != null)) {
            iDataObject.set(FIELD_PSSYSUIACTIONID, (Object)pSSysTBItemBase.getPSSysUIActionId());
        }
        if (pSSysTBItemBase.isPSSysUIActionNameDirty() && (bl || pSSysTBItemBase.getPSSysUIActionName() != null)) {
            iDataObject.set(FIELD_PSSYSUIACTIONNAME, (Object)pSSysTBItemBase.getPSSysUIActionName());
        }
        if (pSSysTBItemBase.isShowModeDirty() && (bl || pSSysTBItemBase.getShowMode() != null)) {
            iDataObject.set(FIELD_SHOWMODE, (Object)pSSysTBItemBase.getShowMode());
        }
        if (pSSysTBItemBase.isTBItemTypeDirty() && (bl || pSSysTBItemBase.getTBItemType() != null)) {
            iDataObject.set(FIELD_TBITEMTYPE, (Object)pSSysTBItemBase.getTBItemType());
        }
        if (pSSysTBItemBase.isUpdateDateDirty() && (bl || pSSysTBItemBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysTBItemBase.getUpdateDate());
        }
        if (pSSysTBItemBase.isUpdateManDirty() && (bl || pSSysTBItemBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysTBItemBase.getUpdateMan());
        }
        if (pSSysTBItemBase.isWidthDirty() && (bl || pSSysTBItemBase.getWidth() != null)) {
            iDataObject.set(FIELD_WIDTH, (Object)pSSysTBItemBase.getWidth());
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
        return PSSysTBItemBase.remove(this, n);
    }

    private static boolean remove(PSSysTBItemBase pSSysTBItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysTBItemBase.resetCaption();
                return true;
            }
            case 1: {
                pSSysTBItemBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysTBItemBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysTBItemBase.resetHeight();
                return true;
            }
            case 4: {
                pSSysTBItemBase.resetLevelTag();
                return true;
            }
            case 5: {
                pSSysTBItemBase.resetLevelValue();
                return true;
            }
            case 6: {
                pSSysTBItemBase.resetMemo();
                return true;
            }
            case 7: {
                pSSysTBItemBase.resetOrderValue();
                return true;
            }
            case 8: {
                pSSysTBItemBase.resetPPSSysTBItemId();
                return true;
            }
            case 9: {
                pSSysTBItemBase.resetPPSSysTBItemName();
                return true;
            }
            case 10: {
                pSSysTBItemBase.resetPSCssTemplId();
                return true;
            }
            case 11: {
                pSSysTBItemBase.resetPSCssTemplName();
                return true;
            }
            case 12: {
                pSSysTBItemBase.resetPSImageTemplId();
                return true;
            }
            case 13: {
                pSSysTBItemBase.resetPSImageTemplName();
                return true;
            }
            case 14: {
                pSSysTBItemBase.resetPSSysTBItemId();
                return true;
            }
            case 15: {
                pSSysTBItemBase.resetPSSysTBItemName();
                return true;
            }
            case 16: {
                pSSysTBItemBase.resetPSSysToolbarId();
                return true;
            }
            case 17: {
                pSSysTBItemBase.resetPSSysToolbarName();
                return true;
            }
            case 18: {
                pSSysTBItemBase.resetPSSysUIActionId();
                return true;
            }
            case 19: {
                pSSysTBItemBase.resetPSSysUIActionName();
                return true;
            }
            case 20: {
                pSSysTBItemBase.resetShowMode();
                return true;
            }
            case 21: {
                pSSysTBItemBase.resetTBItemType();
                return true;
            }
            case 22: {
                pSSysTBItemBase.resetUpdateDate();
                return true;
            }
            case 23: {
                pSSysTBItemBase.resetUpdateMan();
                return true;
            }
            case 24: {
                pSSysTBItemBase.resetWidth();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCssTempl getPscsstempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPscsstempl();
        }
        if (this.getPSCssTemplId() == null) {
            return null;
        }
        Integer n = this.objPscsstemplLock;
        synchronized (n) {
            if (this.pscsstempl != null && DataTypeHelper.compare((int)25, (Object)this.getPSCssTemplId(), (Object)this.pscsstempl.getPSCssTemplId()) != 0L) {
                this.pscsstempl = null;
            }
            if (this.pscsstempl == null) {
                PSCssTempl pSCssTempl = new PSCssTempl();
                pSCssTempl.setPSCssTemplId(this.getPSCssTemplId());
                PSCssTemplService pSCssTemplService = (PSCssTemplService)ServiceGlobal.getService(PSCssTemplService.class, (SessionFactory)this.getSessionFactory());
                pSCssTemplService.autoGet((IEntity)pSCssTempl);
                this.pscsstempl = pSCssTempl;
            }
            return this.pscsstempl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSImageTempl getPsimagetempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPsimagetempl();
        }
        if (this.getPSImageTemplId() == null) {
            return null;
        }
        Integer n = this.objPsimagetemplLock;
        synchronized (n) {
            if (this.psimagetempl != null && DataTypeHelper.compare((int)25, (Object)this.getPSImageTemplId(), (Object)this.psimagetempl.getPSImageTemplId()) != 0L) {
                this.psimagetempl = null;
            }
            if (this.psimagetempl == null) {
                PSImageTempl pSImageTempl = new PSImageTempl();
                pSImageTempl.setPSImageTemplId(this.getPSImageTemplId());
                PSImageTemplService pSImageTemplService = (PSImageTemplService)ServiceGlobal.getService(PSImageTemplService.class, (SessionFactory)this.getSessionFactory());
                pSImageTemplService.autoGet((IEntity)pSImageTempl);
                this.psimagetempl = pSImageTempl;
            }
            return this.psimagetempl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysTBItem getPPSSysTBItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysTBItem();
        }
        if (this.getPPSSysTBItemId() == null) {
            return null;
        }
        Integer n = this.objPPSSysTBItemLock;
        synchronized (n) {
            if (this.ppssystbitem != null && DataTypeHelper.compare((int)25, (Object)this.getPPSSysTBItemId(), (Object)this.ppssystbitem.getPSSysTBItemId()) != 0L) {
                this.ppssystbitem = null;
            }
            if (this.ppssystbitem == null) {
                PSSysTBItem pSSysTBItem = new PSSysTBItem();
                pSSysTBItem.setPSSysTBItemId(this.getPPSSysTBItemId());
                PSSysTBItemService pSSysTBItemService = (PSSysTBItemService)ServiceGlobal.getService(PSSysTBItemService.class, (SessionFactory)this.getSessionFactory());
                pSSysTBItemService.autoGet((IEntity)pSSysTBItem);
                this.ppssystbitem = pSSysTBItem;
            }
            return this.ppssystbitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysToolbar getPSSysToolbar() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysToolbar();
        }
        if (this.getPSSysToolbarId() == null) {
            return null;
        }
        Integer n = this.objPSSysToolbarLock;
        synchronized (n) {
            if (this.pssystoolbar != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysToolbarId(), (Object)this.pssystoolbar.getPSSysToolbarId()) != 0L) {
                this.pssystoolbar = null;
            }
            if (this.pssystoolbar == null) {
                PSSysToolbar pSSysToolbar = new PSSysToolbar();
                pSSysToolbar.setPSSysToolbarId(this.getPSSysToolbarId());
                PSSysToolbarService pSSysToolbarService = (PSSysToolbarService)ServiceGlobal.getService(PSSysToolbarService.class, (SessionFactory)this.getSessionFactory());
                pSSysToolbarService.autoGet((IEntity)pSSysToolbar);
                this.pssystoolbar = pSSysToolbar;
            }
            return this.pssystoolbar;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysUIAction getPSSysUIAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUIAction();
        }
        if (this.getPSSysUIActionId() == null) {
            return null;
        }
        Integer n = this.objPSSysUIActionLock;
        synchronized (n) {
            if (this.pssysuiaction != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysUIActionId(), (Object)this.pssysuiaction.getPSSysUIActionId()) != 0L) {
                this.pssysuiaction = null;
            }
            if (this.pssysuiaction == null) {
                PSSysUIAction pSSysUIAction = new PSSysUIAction();
                pSSysUIAction.setPSSysUIActionId(this.getPSSysUIActionId());
                PSSysUIActionService pSSysUIActionService = (PSSysUIActionService)ServiceGlobal.getService(PSSysUIActionService.class, (SessionFactory)this.getSessionFactory());
                pSSysUIActionService.autoGet((IEntity)pSSysUIAction);
                this.pssysuiaction = pSSysUIAction;
            }
            return this.pssysuiaction;
        }
    }

    private PSSysTBItemBase getProxyEntity() {
        return this.proxyPSSysTBItemBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysTBItemBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysTBItemBase) {
            this.proxyPSSysTBItemBase = (PSSysTBItemBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysTBItemService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CAPTION, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_HEIGHT, 3);
        fieldIndexMap.put(FIELD_LEVELTAG, 4);
        fieldIndexMap.put(FIELD_LEVELVALUE, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_ORDERVALUE, 7);
        fieldIndexMap.put(FIELD_PPSSYSTBITEMID, 8);
        fieldIndexMap.put(FIELD_PPSSYSTBITEMNAME, 9);
        fieldIndexMap.put(FIELD_PSCSSTEMPLID, 10);
        fieldIndexMap.put(FIELD_PSCSSTEMPLNAME, 11);
        fieldIndexMap.put(FIELD_PSIMAGETEMPLID, 12);
        fieldIndexMap.put(FIELD_PSIMAGETEMPLNAME, 13);
        fieldIndexMap.put(FIELD_PSSYSTBITEMID, 14);
        fieldIndexMap.put(FIELD_PSSYSTBITEMNAME, 15);
        fieldIndexMap.put(FIELD_PSSYSTOOLBARID, 16);
        fieldIndexMap.put(FIELD_PSSYSTOOLBARNAME, 17);
        fieldIndexMap.put(FIELD_PSSYSUIACTIONID, 18);
        fieldIndexMap.put(FIELD_PSSYSUIACTIONNAME, 19);
        fieldIndexMap.put(FIELD_SHOWMODE, 20);
        fieldIndexMap.put(FIELD_TBITEMTYPE, 21);
        fieldIndexMap.put(FIELD_UPDATEDATE, 22);
        fieldIndexMap.put(FIELD_UPDATEMAN, 23);
        fieldIndexMap.put(FIELD_WIDTH, 24);
    }
}

