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
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysTitleBarBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysTitleBarBase.class);
    public static final String FIELD_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String FIELD_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String FIELD_CAPTION = "CAPTION";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LEFTPSDETOOLBARID = "LEFTPSDETOOLBARID";
    public static final String FIELD_LEFTPSDETOOLBARNAME = "LEFTPSDETOOLBARNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSSYSTITLEBARID = "PSSYSTITLEBARID";
    public static final String FIELD_PSSYSTITLEBARNAME = "PSSYSTITLEBARNAME";
    public static final String FIELD_RIGHTPSDETOOLBARID = "RIGHTPSDETOOLBARID";
    public static final String FIELD_RIGHTPSDETOOLBARNAME = "RIGHTPSDETOOLBARNAME";
    public static final String FIELD_TITLEBARSTYLE = "TITLEBARSTYLE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CAPPSLANRESID = 0;
    private static final int INDEX_CAPPSLANRESNAME = 1;
    private static final int INDEX_CAPTION = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_LEFTPSDETOOLBARID = 5;
    private static final int INDEX_LEFTPSDETOOLBARNAME = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_PSSYSPFPLUGINID = 8;
    private static final int INDEX_PSSYSPFPLUGINNAME = 9;
    private static final int INDEX_PSSYSTEMID = 10;
    private static final int INDEX_PSSYSTEMNAME = 11;
    private static final int INDEX_PSSYSTITLEBARID = 12;
    private static final int INDEX_PSSYSTITLEBARNAME = 13;
    private static final int INDEX_RIGHTPSDETOOLBARID = 14;
    private static final int INDEX_RIGHTPSDETOOLBARNAME = 15;
    private static final int INDEX_TITLEBARSTYLE = 16;
    private static final int INDEX_UPDATEDATE = 17;
    private static final int INDEX_UPDATEMAN = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysTitleBarBase proxyPSSysTitleBarBase = null;
    private boolean cappslanresidDirtyFlag = false;
    private boolean cappslanresnameDirtyFlag = false;
    private boolean captionDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean leftpsdetoolbaridDirtyFlag = false;
    private boolean leftpsdetoolbarnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pssystitlebaridDirtyFlag = false;
    private boolean pssystitlebarnameDirtyFlag = false;
    private boolean rightpsdetoolbaridDirtyFlag = false;
    private boolean rightpsdetoolbarnameDirtyFlag = false;
    private boolean titlebarstyleDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="cappslanresid")
    private String cappslanresid;
    @Column(name="cappslanresname")
    private String cappslanresname;
    @Column(name="caption")
    private String caption;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="leftpsdetoolbarid")
    private String leftpsdetoolbarid;
    @Column(name="leftpsdetoolbarname")
    private String leftpsdetoolbarname;
    @Column(name="memo")
    private String memo;
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pssystitlebarid")
    private String pssystitlebarid;
    @Column(name="pssystitlebarname")
    private String pssystitlebarname;
    @Column(name="rightpsdetoolbarid")
    private String rightpsdetoolbarid;
    @Column(name="rightpsdetoolbarname")
    private String rightpsdetoolbarname;
    @Column(name="titlebarstyle")
    private String titlebarstyle;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objLeftPSDEToolbarLock = new Integer(1);
    private PSDEToolbar leftpsdetoolbar = null;
    private Integer objRightPSDEToolbarLock = new Integer(1);
    private PSDEToolbar rightpsdetoolbar = null;
    private Integer objCapPSLanResLock = new Integer(1);
    private PSLanguageRes cappslanres = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

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

    public void setLeftPSDEToolbarId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLeftPSDEToolbarId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.leftpsdetoolbarid = string;
        this.leftpsdetoolbaridDirtyFlag = true;
    }

    public String getLeftPSDEToolbarId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLeftPSDEToolbarId();
        }
        return this.leftpsdetoolbarid;
    }

    public boolean isLeftPSDEToolbarIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLeftPSDEToolbarIdDirty();
        }
        return this.leftpsdetoolbaridDirtyFlag;
    }

    public void resetLeftPSDEToolbarId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLeftPSDEToolbarId();
            return;
        }
        this.leftpsdetoolbaridDirtyFlag = false;
        this.leftpsdetoolbarid = null;
    }

    public void setLeftPSDEToolbarName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLeftPSDEToolbarName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.leftpsdetoolbarname = string;
        this.leftpsdetoolbarnameDirtyFlag = true;
    }

    public String getLeftPSDEToolbarName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLeftPSDEToolbarName();
        }
        return this.leftpsdetoolbarname;
    }

    public boolean isLeftPSDEToolbarNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLeftPSDEToolbarNameDirty();
        }
        return this.leftpsdetoolbarnameDirtyFlag;
    }

    public void resetLeftPSDEToolbarName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLeftPSDEToolbarName();
            return;
        }
        this.leftpsdetoolbarnameDirtyFlag = false;
        this.leftpsdetoolbarname = null;
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

    public void setPSSysPFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspfpluginid = string;
        this.pssyspfpluginidDirtyFlag = true;
    }

    public String getPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPluginId();
        }
        return this.pssyspfpluginid;
    }

    public boolean isPSSysPFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPFPluginIdDirty();
        }
        return this.pssyspfpluginidDirtyFlag;
    }

    public void resetPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPFPluginId();
            return;
        }
        this.pssyspfpluginidDirtyFlag = false;
        this.pssyspfpluginid = null;
    }

    public void setPSSysPFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspfpluginname = string;
        this.pssyspfpluginnameDirtyFlag = true;
    }

    public String getPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPluginName();
        }
        return this.pssyspfpluginname;
    }

    public boolean isPSSysPFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPFPluginNameDirty();
        }
        return this.pssyspfpluginnameDirtyFlag;
    }

    public void resetPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPFPluginName();
            return;
        }
        this.pssyspfpluginnameDirtyFlag = false;
        this.pssyspfpluginname = null;
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

    public void setPSSysTitleBarId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTitleBarId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystitlebarid = string;
        this.pssystitlebaridDirtyFlag = true;
    }

    public String getPSSysTitleBarId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTitleBarId();
        }
        return this.pssystitlebarid;
    }

    public boolean isPSSysTitleBarIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTitleBarIdDirty();
        }
        return this.pssystitlebaridDirtyFlag;
    }

    public void resetPSSysTitleBarId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTitleBarId();
            return;
        }
        this.pssystitlebaridDirtyFlag = false;
        this.pssystitlebarid = null;
    }

    public void setPSSysTitleBarName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTitleBarName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystitlebarname = string;
        this.pssystitlebarnameDirtyFlag = true;
    }

    public String getPSSysTitleBarName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTitleBarName();
        }
        return this.pssystitlebarname;
    }

    public boolean isPSSysTitleBarNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTitleBarNameDirty();
        }
        return this.pssystitlebarnameDirtyFlag;
    }

    public void resetPSSysTitleBarName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTitleBarName();
            return;
        }
        this.pssystitlebarnameDirtyFlag = false;
        this.pssystitlebarname = null;
    }

    public void setRightPSDEToolbarId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRightPSDEToolbarId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rightpsdetoolbarid = string;
        this.rightpsdetoolbaridDirtyFlag = true;
    }

    public String getRightPSDEToolbarId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRightPSDEToolbarId();
        }
        return this.rightpsdetoolbarid;
    }

    public boolean isRightPSDEToolbarIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRightPSDEToolbarIdDirty();
        }
        return this.rightpsdetoolbaridDirtyFlag;
    }

    public void resetRightPSDEToolbarId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRightPSDEToolbarId();
            return;
        }
        this.rightpsdetoolbaridDirtyFlag = false;
        this.rightpsdetoolbarid = null;
    }

    public void setRightPSDEToolbarName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRightPSDEToolbarName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rightpsdetoolbarname = string;
        this.rightpsdetoolbarnameDirtyFlag = true;
    }

    public String getRightPSDEToolbarName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRightPSDEToolbarName();
        }
        return this.rightpsdetoolbarname;
    }

    public boolean isRightPSDEToolbarNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRightPSDEToolbarNameDirty();
        }
        return this.rightpsdetoolbarnameDirtyFlag;
    }

    public void resetRightPSDEToolbarName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRightPSDEToolbarName();
            return;
        }
        this.rightpsdetoolbarnameDirtyFlag = false;
        this.rightpsdetoolbarname = null;
    }

    public void setTitleBarStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTitleBarStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.titlebarstyle = string;
        this.titlebarstyleDirtyFlag = true;
    }

    public String getTitleBarStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitleBarStyle();
        }
        return this.titlebarstyle;
    }

    public boolean isTitleBarStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTitleBarStyleDirty();
        }
        return this.titlebarstyleDirtyFlag;
    }

    public void resetTitleBarStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTitleBarStyle();
            return;
        }
        this.titlebarstyleDirtyFlag = false;
        this.titlebarstyle = null;
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
        PSSysTitleBarBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysTitleBarBase pSSysTitleBarBase) {
        pSSysTitleBarBase.resetCapPSLanResId();
        pSSysTitleBarBase.resetCapPSLanResName();
        pSSysTitleBarBase.resetCaption();
        pSSysTitleBarBase.resetCreateDate();
        pSSysTitleBarBase.resetCreateMan();
        pSSysTitleBarBase.resetLeftPSDEToolbarId();
        pSSysTitleBarBase.resetLeftPSDEToolbarName();
        pSSysTitleBarBase.resetMemo();
        pSSysTitleBarBase.resetPSSysPFPluginId();
        pSSysTitleBarBase.resetPSSysPFPluginName();
        pSSysTitleBarBase.resetPSSystemId();
        pSSysTitleBarBase.resetPSSystemName();
        pSSysTitleBarBase.resetPSSysTitleBarId();
        pSSysTitleBarBase.resetPSSysTitleBarName();
        pSSysTitleBarBase.resetRightPSDEToolbarId();
        pSSysTitleBarBase.resetRightPSDEToolbarName();
        pSSysTitleBarBase.resetTitleBarStyle();
        pSSysTitleBarBase.resetUpdateDate();
        pSSysTitleBarBase.resetUpdateMan();
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
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isLeftPSDEToolbarIdDirty()) {
            hashMap.put(FIELD_LEFTPSDETOOLBARID, this.getLeftPSDEToolbarId());
        }
        if (!bl || this.isLeftPSDEToolbarNameDirty()) {
            hashMap.put(FIELD_LEFTPSDETOOLBARNAME, this.getLeftPSDEToolbarName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINID, this.getPSSysPFPluginId());
        }
        if (!bl || this.isPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINNAME, this.getPSSysPFPluginName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isPSSysTitleBarIdDirty()) {
            hashMap.put(FIELD_PSSYSTITLEBARID, this.getPSSysTitleBarId());
        }
        if (!bl || this.isPSSysTitleBarNameDirty()) {
            hashMap.put(FIELD_PSSYSTITLEBARNAME, this.getPSSysTitleBarName());
        }
        if (!bl || this.isRightPSDEToolbarIdDirty()) {
            hashMap.put(FIELD_RIGHTPSDETOOLBARID, this.getRightPSDEToolbarId());
        }
        if (!bl || this.isRightPSDEToolbarNameDirty()) {
            hashMap.put(FIELD_RIGHTPSDETOOLBARNAME, this.getRightPSDEToolbarName());
        }
        if (!bl || this.isTitleBarStyleDirty()) {
            hashMap.put(FIELD_TITLEBARSTYLE, this.getTitleBarStyle());
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
        return PSSysTitleBarBase.get(this, n);
    }

    private static Object get(PSSysTitleBarBase pSSysTitleBarBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysTitleBarBase.getCapPSLanResId();
            }
            case 1: {
                return pSSysTitleBarBase.getCapPSLanResName();
            }
            case 2: {
                return pSSysTitleBarBase.getCaption();
            }
            case 3: {
                return pSSysTitleBarBase.getCreateDate();
            }
            case 4: {
                return pSSysTitleBarBase.getCreateMan();
            }
            case 5: {
                return pSSysTitleBarBase.getLeftPSDEToolbarId();
            }
            case 6: {
                return pSSysTitleBarBase.getLeftPSDEToolbarName();
            }
            case 7: {
                return pSSysTitleBarBase.getMemo();
            }
            case 8: {
                return pSSysTitleBarBase.getPSSysPFPluginId();
            }
            case 9: {
                return pSSysTitleBarBase.getPSSysPFPluginName();
            }
            case 10: {
                return pSSysTitleBarBase.getPSSystemId();
            }
            case 11: {
                return pSSysTitleBarBase.getPSSystemName();
            }
            case 12: {
                return pSSysTitleBarBase.getPSSysTitleBarId();
            }
            case 13: {
                return pSSysTitleBarBase.getPSSysTitleBarName();
            }
            case 14: {
                return pSSysTitleBarBase.getRightPSDEToolbarId();
            }
            case 15: {
                return pSSysTitleBarBase.getRightPSDEToolbarName();
            }
            case 16: {
                return pSSysTitleBarBase.getTitleBarStyle();
            }
            case 17: {
                return pSSysTitleBarBase.getUpdateDate();
            }
            case 18: {
                return pSSysTitleBarBase.getUpdateMan();
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
        PSSysTitleBarBase.set(this, n, object);
    }

    private static void set(PSSysTitleBarBase pSSysTitleBarBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysTitleBarBase.setCapPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysTitleBarBase.setCapPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysTitleBarBase.setCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysTitleBarBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSSysTitleBarBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysTitleBarBase.setLeftPSDEToolbarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysTitleBarBase.setLeftPSDEToolbarName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysTitleBarBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysTitleBarBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysTitleBarBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysTitleBarBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysTitleBarBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysTitleBarBase.setPSSysTitleBarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysTitleBarBase.setPSSysTitleBarName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysTitleBarBase.setRightPSDEToolbarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysTitleBarBase.setRightPSDEToolbarName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysTitleBarBase.setTitleBarStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysTitleBarBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 18: {
                pSSysTitleBarBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSysTitleBarBase.isNull(this, n);
    }

    private static boolean isNull(PSSysTitleBarBase pSSysTitleBarBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysTitleBarBase.getCapPSLanResId() == null;
            }
            case 1: {
                return pSSysTitleBarBase.getCapPSLanResName() == null;
            }
            case 2: {
                return pSSysTitleBarBase.getCaption() == null;
            }
            case 3: {
                return pSSysTitleBarBase.getCreateDate() == null;
            }
            case 4: {
                return pSSysTitleBarBase.getCreateMan() == null;
            }
            case 5: {
                return pSSysTitleBarBase.getLeftPSDEToolbarId() == null;
            }
            case 6: {
                return pSSysTitleBarBase.getLeftPSDEToolbarName() == null;
            }
            case 7: {
                return pSSysTitleBarBase.getMemo() == null;
            }
            case 8: {
                return pSSysTitleBarBase.getPSSysPFPluginId() == null;
            }
            case 9: {
                return pSSysTitleBarBase.getPSSysPFPluginName() == null;
            }
            case 10: {
                return pSSysTitleBarBase.getPSSystemId() == null;
            }
            case 11: {
                return pSSysTitleBarBase.getPSSystemName() == null;
            }
            case 12: {
                return pSSysTitleBarBase.getPSSysTitleBarId() == null;
            }
            case 13: {
                return pSSysTitleBarBase.getPSSysTitleBarName() == null;
            }
            case 14: {
                return pSSysTitleBarBase.getRightPSDEToolbarId() == null;
            }
            case 15: {
                return pSSysTitleBarBase.getRightPSDEToolbarName() == null;
            }
            case 16: {
                return pSSysTitleBarBase.getTitleBarStyle() == null;
            }
            case 17: {
                return pSSysTitleBarBase.getUpdateDate() == null;
            }
            case 18: {
                return pSSysTitleBarBase.getUpdateMan() == null;
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
        return PSSysTitleBarBase.contains(this, n);
    }

    private static boolean contains(PSSysTitleBarBase pSSysTitleBarBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysTitleBarBase.isCapPSLanResIdDirty();
            }
            case 1: {
                return pSSysTitleBarBase.isCapPSLanResNameDirty();
            }
            case 2: {
                return pSSysTitleBarBase.isCaptionDirty();
            }
            case 3: {
                return pSSysTitleBarBase.isCreateDateDirty();
            }
            case 4: {
                return pSSysTitleBarBase.isCreateManDirty();
            }
            case 5: {
                return pSSysTitleBarBase.isLeftPSDEToolbarIdDirty();
            }
            case 6: {
                return pSSysTitleBarBase.isLeftPSDEToolbarNameDirty();
            }
            case 7: {
                return pSSysTitleBarBase.isMemoDirty();
            }
            case 8: {
                return pSSysTitleBarBase.isPSSysPFPluginIdDirty();
            }
            case 9: {
                return pSSysTitleBarBase.isPSSysPFPluginNameDirty();
            }
            case 10: {
                return pSSysTitleBarBase.isPSSystemIdDirty();
            }
            case 11: {
                return pSSysTitleBarBase.isPSSystemNameDirty();
            }
            case 12: {
                return pSSysTitleBarBase.isPSSysTitleBarIdDirty();
            }
            case 13: {
                return pSSysTitleBarBase.isPSSysTitleBarNameDirty();
            }
            case 14: {
                return pSSysTitleBarBase.isRightPSDEToolbarIdDirty();
            }
            case 15: {
                return pSSysTitleBarBase.isRightPSDEToolbarNameDirty();
            }
            case 16: {
                return pSSysTitleBarBase.isTitleBarStyleDirty();
            }
            case 17: {
                return pSSysTitleBarBase.isUpdateDateDirty();
            }
            case 18: {
                return pSSysTitleBarBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysTitleBarBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysTitleBarBase pSSysTitleBarBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysTitleBarBase.getCapPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresid", (Object)PSSysTitleBarBase.getJSONValue((Object)pSSysTitleBarBase.getCapPSLanResId()), (boolean)false);
        }
        if (bl || pSSysTitleBarBase.getCapPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresname", (Object)PSSysTitleBarBase.getJSONValue((Object)pSSysTitleBarBase.getCapPSLanResName()), (boolean)false);
        }
        if (bl || pSSysTitleBarBase.getCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"caption", (Object)PSSysTitleBarBase.getJSONValue((Object)pSSysTitleBarBase.getCaption()), (boolean)false);
        }
        if (bl || pSSysTitleBarBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysTitleBarBase.getJSONValue((Object)pSSysTitleBarBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysTitleBarBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysTitleBarBase.getJSONValue((Object)pSSysTitleBarBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysTitleBarBase.getLeftPSDEToolbarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"leftpsdetoolbarid", (Object)PSSysTitleBarBase.getJSONValue((Object)pSSysTitleBarBase.getLeftPSDEToolbarId()), (boolean)false);
        }
        if (bl || pSSysTitleBarBase.getLeftPSDEToolbarName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"leftpsdetoolbarname", (Object)PSSysTitleBarBase.getJSONValue((Object)pSSysTitleBarBase.getLeftPSDEToolbarName()), (boolean)false);
        }
        if (bl || pSSysTitleBarBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysTitleBarBase.getJSONValue((Object)pSSysTitleBarBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysTitleBarBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSSysTitleBarBase.getJSONValue((Object)pSSysTitleBarBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSSysTitleBarBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSSysTitleBarBase.getJSONValue((Object)pSSysTitleBarBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSSysTitleBarBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysTitleBarBase.getJSONValue((Object)pSSysTitleBarBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysTitleBarBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysTitleBarBase.getJSONValue((Object)pSSysTitleBarBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysTitleBarBase.getPSSysTitleBarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystitlebarid", (Object)PSSysTitleBarBase.getJSONValue((Object)pSSysTitleBarBase.getPSSysTitleBarId()), (boolean)false);
        }
        if (bl || pSSysTitleBarBase.getPSSysTitleBarName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystitlebarname", (Object)PSSysTitleBarBase.getJSONValue((Object)pSSysTitleBarBase.getPSSysTitleBarName()), (boolean)false);
        }
        if (bl || pSSysTitleBarBase.getRightPSDEToolbarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rightpsdetoolbarid", (Object)PSSysTitleBarBase.getJSONValue((Object)pSSysTitleBarBase.getRightPSDEToolbarId()), (boolean)false);
        }
        if (bl || pSSysTitleBarBase.getRightPSDEToolbarName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rightpsdetoolbarname", (Object)PSSysTitleBarBase.getJSONValue((Object)pSSysTitleBarBase.getRightPSDEToolbarName()), (boolean)false);
        }
        if (bl || pSSysTitleBarBase.getTitleBarStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"titlebarstyle", (Object)PSSysTitleBarBase.getJSONValue((Object)pSSysTitleBarBase.getTitleBarStyle()), (boolean)false);
        }
        if (bl || pSSysTitleBarBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysTitleBarBase.getJSONValue((Object)pSSysTitleBarBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysTitleBarBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysTitleBarBase.getJSONValue((Object)pSSysTitleBarBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysTitleBarBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysTitleBarBase pSSysTitleBarBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysTitleBarBase.getCapPSLanResId() != null) {
            object = pSSysTitleBarBase.getCapPSLanResId();
            xmlNode.setAttribute(FIELD_CAPPSLANRESID, (String)(object == null ? "" : object));
        }
        if (bl || pSSysTitleBarBase.getCapPSLanResName() != null) {
            object = pSSysTitleBarBase.getCapPSLanResName();
            xmlNode.setAttribute(FIELD_CAPPSLANRESNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSSysTitleBarBase.getCaption() != null) {
            object = pSSysTitleBarBase.getCaption();
            xmlNode.setAttribute(FIELD_CAPTION, object == null ? "" : (String)object);
        }
        if (bl || pSSysTitleBarBase.getCreateDate() != null) {
            object = pSSysTitleBarBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysTitleBarBase.getCreateMan() != null) {
            object = pSSysTitleBarBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysTitleBarBase.getLeftPSDEToolbarId() != null) {
            object = pSSysTitleBarBase.getLeftPSDEToolbarId();
            xmlNode.setAttribute(FIELD_LEFTPSDETOOLBARID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTitleBarBase.getLeftPSDEToolbarName() != null) {
            object = pSSysTitleBarBase.getLeftPSDEToolbarName();
            xmlNode.setAttribute(FIELD_LEFTPSDETOOLBARNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTitleBarBase.getMemo() != null) {
            object = pSSysTitleBarBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysTitleBarBase.getPSSysPFPluginId() != null) {
            object = pSSysTitleBarBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTitleBarBase.getPSSysPFPluginName() != null) {
            object = pSSysTitleBarBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTitleBarBase.getPSSystemId() != null) {
            object = pSSysTitleBarBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTitleBarBase.getPSSystemName() != null) {
            object = pSSysTitleBarBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTitleBarBase.getPSSysTitleBarId() != null) {
            object = pSSysTitleBarBase.getPSSysTitleBarId();
            xmlNode.setAttribute(FIELD_PSSYSTITLEBARID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTitleBarBase.getPSSysTitleBarName() != null) {
            object = pSSysTitleBarBase.getPSSysTitleBarName();
            xmlNode.setAttribute(FIELD_PSSYSTITLEBARNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTitleBarBase.getRightPSDEToolbarId() != null) {
            object = pSSysTitleBarBase.getRightPSDEToolbarId();
            xmlNode.setAttribute(FIELD_RIGHTPSDETOOLBARID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTitleBarBase.getRightPSDEToolbarName() != null) {
            object = pSSysTitleBarBase.getRightPSDEToolbarName();
            xmlNode.setAttribute(FIELD_RIGHTPSDETOOLBARNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTitleBarBase.getTitleBarStyle() != null) {
            object = pSSysTitleBarBase.getTitleBarStyle();
            xmlNode.setAttribute(FIELD_TITLEBARSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSSysTitleBarBase.getUpdateDate() != null) {
            object = pSSysTitleBarBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysTitleBarBase.getUpdateMan() != null) {
            object = pSSysTitleBarBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysTitleBarBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysTitleBarBase pSSysTitleBarBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysTitleBarBase.isCapPSLanResIdDirty() && (bl || pSSysTitleBarBase.getCapPSLanResId() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESID, (Object)pSSysTitleBarBase.getCapPSLanResId());
        }
        if (pSSysTitleBarBase.isCapPSLanResNameDirty() && (bl || pSSysTitleBarBase.getCapPSLanResName() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESNAME, (Object)pSSysTitleBarBase.getCapPSLanResName());
        }
        if (pSSysTitleBarBase.isCaptionDirty() && (bl || pSSysTitleBarBase.getCaption() != null)) {
            iDataObject.set(FIELD_CAPTION, (Object)pSSysTitleBarBase.getCaption());
        }
        if (pSSysTitleBarBase.isCreateDateDirty() && (bl || pSSysTitleBarBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysTitleBarBase.getCreateDate());
        }
        if (pSSysTitleBarBase.isCreateManDirty() && (bl || pSSysTitleBarBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysTitleBarBase.getCreateMan());
        }
        if (pSSysTitleBarBase.isLeftPSDEToolbarIdDirty() && (bl || pSSysTitleBarBase.getLeftPSDEToolbarId() != null)) {
            iDataObject.set(FIELD_LEFTPSDETOOLBARID, (Object)pSSysTitleBarBase.getLeftPSDEToolbarId());
        }
        if (pSSysTitleBarBase.isLeftPSDEToolbarNameDirty() && (bl || pSSysTitleBarBase.getLeftPSDEToolbarName() != null)) {
            iDataObject.set(FIELD_LEFTPSDETOOLBARNAME, (Object)pSSysTitleBarBase.getLeftPSDEToolbarName());
        }
        if (pSSysTitleBarBase.isMemoDirty() && (bl || pSSysTitleBarBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysTitleBarBase.getMemo());
        }
        if (pSSysTitleBarBase.isPSSysPFPluginIdDirty() && (bl || pSSysTitleBarBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSSysTitleBarBase.getPSSysPFPluginId());
        }
        if (pSSysTitleBarBase.isPSSysPFPluginNameDirty() && (bl || pSSysTitleBarBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSSysTitleBarBase.getPSSysPFPluginName());
        }
        if (pSSysTitleBarBase.isPSSystemIdDirty() && (bl || pSSysTitleBarBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysTitleBarBase.getPSSystemId());
        }
        if (pSSysTitleBarBase.isPSSystemNameDirty() && (bl || pSSysTitleBarBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysTitleBarBase.getPSSystemName());
        }
        if (pSSysTitleBarBase.isPSSysTitleBarIdDirty() && (bl || pSSysTitleBarBase.getPSSysTitleBarId() != null)) {
            iDataObject.set(FIELD_PSSYSTITLEBARID, (Object)pSSysTitleBarBase.getPSSysTitleBarId());
        }
        if (pSSysTitleBarBase.isPSSysTitleBarNameDirty() && (bl || pSSysTitleBarBase.getPSSysTitleBarName() != null)) {
            iDataObject.set(FIELD_PSSYSTITLEBARNAME, (Object)pSSysTitleBarBase.getPSSysTitleBarName());
        }
        if (pSSysTitleBarBase.isRightPSDEToolbarIdDirty() && (bl || pSSysTitleBarBase.getRightPSDEToolbarId() != null)) {
            iDataObject.set(FIELD_RIGHTPSDETOOLBARID, (Object)pSSysTitleBarBase.getRightPSDEToolbarId());
        }
        if (pSSysTitleBarBase.isRightPSDEToolbarNameDirty() && (bl || pSSysTitleBarBase.getRightPSDEToolbarName() != null)) {
            iDataObject.set(FIELD_RIGHTPSDETOOLBARNAME, (Object)pSSysTitleBarBase.getRightPSDEToolbarName());
        }
        if (pSSysTitleBarBase.isTitleBarStyleDirty() && (bl || pSSysTitleBarBase.getTitleBarStyle() != null)) {
            iDataObject.set(FIELD_TITLEBARSTYLE, (Object)pSSysTitleBarBase.getTitleBarStyle());
        }
        if (pSSysTitleBarBase.isUpdateDateDirty() && (bl || pSSysTitleBarBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysTitleBarBase.getUpdateDate());
        }
        if (pSSysTitleBarBase.isUpdateManDirty() && (bl || pSSysTitleBarBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysTitleBarBase.getUpdateMan());
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
        return PSSysTitleBarBase.remove(this, n);
    }

    private static boolean remove(PSSysTitleBarBase pSSysTitleBarBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysTitleBarBase.resetCapPSLanResId();
                return true;
            }
            case 1: {
                pSSysTitleBarBase.resetCapPSLanResName();
                return true;
            }
            case 2: {
                pSSysTitleBarBase.resetCaption();
                return true;
            }
            case 3: {
                pSSysTitleBarBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSSysTitleBarBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSSysTitleBarBase.resetLeftPSDEToolbarId();
                return true;
            }
            case 6: {
                pSSysTitleBarBase.resetLeftPSDEToolbarName();
                return true;
            }
            case 7: {
                pSSysTitleBarBase.resetMemo();
                return true;
            }
            case 8: {
                pSSysTitleBarBase.resetPSSysPFPluginId();
                return true;
            }
            case 9: {
                pSSysTitleBarBase.resetPSSysPFPluginName();
                return true;
            }
            case 10: {
                pSSysTitleBarBase.resetPSSystemId();
                return true;
            }
            case 11: {
                pSSysTitleBarBase.resetPSSystemName();
                return true;
            }
            case 12: {
                pSSysTitleBarBase.resetPSSysTitleBarId();
                return true;
            }
            case 13: {
                pSSysTitleBarBase.resetPSSysTitleBarName();
                return true;
            }
            case 14: {
                pSSysTitleBarBase.resetRightPSDEToolbarId();
                return true;
            }
            case 15: {
                pSSysTitleBarBase.resetRightPSDEToolbarName();
                return true;
            }
            case 16: {
                pSSysTitleBarBase.resetTitleBarStyle();
                return true;
            }
            case 17: {
                pSSysTitleBarBase.resetUpdateDate();
                return true;
            }
            case 18: {
                pSSysTitleBarBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEToolbar getLeftPSDEToolbar() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLeftPSDEToolbar();
        }
        if (this.getLeftPSDEToolbarId() == null) {
            return null;
        }
        Integer n = this.objLeftPSDEToolbarLock;
        synchronized (n) {
            if (this.leftpsdetoolbar != null && DataTypeHelper.compare((int)25, (Object)this.getLeftPSDEToolbarId(), (Object)this.leftpsdetoolbar.getPSDEToolbarId()) != 0L) {
                this.leftpsdetoolbar = null;
            }
            if (this.leftpsdetoolbar == null) {
                PSDEToolbar pSDEToolbar = new PSDEToolbar();
                pSDEToolbar.setPSDEToolbarId(this.getLeftPSDEToolbarId());
                PSDEToolbarService pSDEToolbarService = (PSDEToolbarService)ServiceGlobal.getService(PSDEToolbarService.class, (SessionFactory)this.getSessionFactory());
                pSDEToolbarService.autoGet((IEntity)pSDEToolbar);
                this.leftpsdetoolbar = pSDEToolbar;
            }
            return this.leftpsdetoolbar;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEToolbar getRightPSDEToolbar() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRightPSDEToolbar();
        }
        if (this.getRightPSDEToolbarId() == null) {
            return null;
        }
        Integer n = this.objRightPSDEToolbarLock;
        synchronized (n) {
            if (this.rightpsdetoolbar != null && DataTypeHelper.compare((int)25, (Object)this.getRightPSDEToolbarId(), (Object)this.rightpsdetoolbar.getPSDEToolbarId()) != 0L) {
                this.rightpsdetoolbar = null;
            }
            if (this.rightpsdetoolbar == null) {
                PSDEToolbar pSDEToolbar = new PSDEToolbar();
                pSDEToolbar.setPSDEToolbarId(this.getRightPSDEToolbarId());
                PSDEToolbarService pSDEToolbarService = (PSDEToolbarService)ServiceGlobal.getService(PSDEToolbarService.class, (SessionFactory)this.getSessionFactory());
                pSDEToolbarService.autoGet((IEntity)pSDEToolbar);
                this.rightpsdetoolbar = pSDEToolbar;
            }
            return this.rightpsdetoolbar;
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
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.cappslanres = pSLanguageRes;
            }
            return this.cappslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysPFPlugin getPSSysPFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPlugin();
        }
        if (this.getPSSysPFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysPFPluginLock;
        synchronized (n) {
            if (this.pssyspfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysPFPluginId(), (Object)this.pssyspfplugin.getPSSysPFPluginId()) != 0L) {
                this.pssyspfplugin = null;
            }
            if (this.pssyspfplugin == null) {
                PSSysPFPlugin pSSysPFPlugin = new PSSysPFPlugin();
                pSSysPFPlugin.setPSSysPFPluginId(this.getPSSysPFPluginId());
                PSSysPFPluginService pSSysPFPluginService = (PSSysPFPluginService)ServiceGlobal.getService(PSSysPFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysPFPluginService.autoGet((IEntity)pSSysPFPlugin);
                this.pssyspfplugin = pSSysPFPlugin;
            }
            return this.pssyspfplugin;
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
                pSSystemService.autoGet((IEntity)pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    private PSSysTitleBarBase getProxyEntity() {
        return this.proxyPSSysTitleBarBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysTitleBarBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysTitleBarBase) {
            this.proxyPSSysTitleBarBase = (PSSysTitleBarBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysTitleBarService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CAPPSLANRESID, 0);
        fieldIndexMap.put(FIELD_CAPPSLANRESNAME, 1);
        fieldIndexMap.put(FIELD_CAPTION, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_LEFTPSDETOOLBARID, 5);
        fieldIndexMap.put(FIELD_LEFTPSDETOOLBARNAME, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 8);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 9);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 10);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 11);
        fieldIndexMap.put(FIELD_PSSYSTITLEBARID, 12);
        fieldIndexMap.put(FIELD_PSSYSTITLEBARNAME, 13);
        fieldIndexMap.put(FIELD_RIGHTPSDETOOLBARID, 14);
        fieldIndexMap.put(FIELD_RIGHTPSDETOOLBARNAME, 15);
        fieldIndexMap.put(FIELD_TITLEBARSTYLE, 16);
        fieldIndexMap.put(FIELD_UPDATEDATE, 17);
        fieldIndexMap.put(FIELD_UPDATEMAN, 18);
    }
}

