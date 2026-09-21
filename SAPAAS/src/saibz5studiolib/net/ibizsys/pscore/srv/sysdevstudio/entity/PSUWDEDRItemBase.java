/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdevstudio.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSUWDEDRItemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSUWDEDRItemBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DRITEMTYPE = "DRITEMTYPE";
    public static final String FIELD_DRITEMTYPENAME = "DRITEMTYPENAME";
    public static final String FIELD_PSDEDRITEMID = "PSDEDRITEMID";
    public static final String FIELD_PSDEDRITEMNAME = "PSDEDRITEMNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDERID = "PSDERID";
    public static final String FIELD_PSDERNAME = "PSDERNAME";
    public static final String FIELD_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String FIELD_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSUWDEDRITEMID = "PSUWDEDRITEMID";
    public static final String FIELD_PSUWDEDRITEMNAME = "PSUWDEDRITEMNAME";
    public static final String FIELD_SYSPSDERID = "SYSPSDERID";
    public static final String FIELD_SYSPSDERNAME = "SYSPSDERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VIEWPSDEID = "VIEWPSDEID";
    public static final String FIELD_VIEWPSDENAME = "VIEWPSDENAME";
    public static final String FIELD_WIZARDMODE = "WIZARDMODE";
    public static final String FIELD_WIZARDPARAM = "WIZARDPARAM";
    public static final String FIELD_WIZARDPARAM2 = "WIZARDPARAM2";
    public static final String FIELD_WIZARDPARAM3 = "WIZARDPARAM3";
    public static final String FIELD_WIZARDPARAM4 = "WIZARDPARAM4";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DRITEMTYPE = 2;
    private static final int INDEX_DRITEMTYPENAME = 3;
    private static final int INDEX_PSDEDRITEMID = 4;
    private static final int INDEX_PSDEDRITEMNAME = 5;
    private static final int INDEX_PSDEID = 6;
    private static final int INDEX_PSDENAME = 7;
    private static final int INDEX_PSDERID = 8;
    private static final int INDEX_PSDERNAME = 9;
    private static final int INDEX_PSDEVIEWBASEID = 10;
    private static final int INDEX_PSDEVIEWBASENAME = 11;
    private static final int INDEX_PSDYNAINSTID = 12;
    private static final int INDEX_PSUWDEDRITEMID = 13;
    private static final int INDEX_PSUWDEDRITEMNAME = 14;
    private static final int INDEX_SYSPSDERID = 15;
    private static final int INDEX_SYSPSDERNAME = 16;
    private static final int INDEX_UPDATEDATE = 17;
    private static final int INDEX_UPDATEMAN = 18;
    private static final int INDEX_VIEWPSDEID = 19;
    private static final int INDEX_VIEWPSDENAME = 20;
    private static final int INDEX_WIZARDMODE = 21;
    private static final int INDEX_WIZARDPARAM = 22;
    private static final int INDEX_WIZARDPARAM2 = 23;
    private static final int INDEX_WIZARDPARAM3 = 24;
    private static final int INDEX_WIZARDPARAM4 = 25;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSUWDEDRItemBase proxyPSUWDEDRItemBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dritemtypeDirtyFlag = false;
    private boolean dritemtypenameDirtyFlag = false;
    private boolean psdedritemidDirtyFlag = false;
    private boolean psdedritemnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psderidDirtyFlag = false;
    private boolean psdernameDirtyFlag = false;
    private boolean psdeviewbaseidDirtyFlag = false;
    private boolean psdeviewbasenameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean psuwdedritemidDirtyFlag = false;
    private boolean psuwdedritemnameDirtyFlag = false;
    private boolean syspsderidDirtyFlag = false;
    private boolean syspsdernameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean viewpsdeidDirtyFlag = false;
    private boolean viewpsdenameDirtyFlag = false;
    private boolean wizardmodeDirtyFlag = false;
    private boolean wizardparamDirtyFlag = false;
    private boolean wizardparam2DirtyFlag = false;
    private boolean wizardparam3DirtyFlag = false;
    private boolean wizardparam4DirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dritemtype")
    private String dritemtype;
    @Column(name="dritemtypename")
    private String dritemtypename;
    @Column(name="psdedritemid")
    private String psdedritemid;
    @Column(name="psdedritemname")
    private String psdedritemname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psderid")
    private String psderid;
    @Column(name="psdername")
    private String psdername;
    @Column(name="psdeviewbaseid")
    private String psdeviewbaseid;
    @Column(name="psdeviewbasename")
    private String psdeviewbasename;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="psuwdedritemid")
    private String psuwdedritemid;
    @Column(name="psuwdedritemname")
    private String psuwdedritemname;
    @Column(name="syspsderid")
    private String syspsderid;
    @Column(name="syspsdername")
    private String syspsdername;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="viewpsdeid")
    private String viewpsdeid;
    @Column(name="viewpsdename")
    private String viewpsdename;
    @Column(name="wizardmode")
    private String wizardmode;
    @Column(name="wizardparam")
    private String wizardparam;
    @Column(name="wizardparam2")
    private String wizardparam2;
    @Column(name="wizardparam3")
    private Integer wizardparam3;
    @Column(name="wizardparam4")
    private Integer wizardparam4;

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

    public void setDRItemType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDRItemType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dritemtype = string;
        this.dritemtypeDirtyFlag = true;
    }

    public String getDRItemType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDRItemType();
        }
        return this.dritemtype;
    }

    public boolean isDRItemTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDRItemTypeDirty();
        }
        return this.dritemtypeDirtyFlag;
    }

    public void resetDRItemType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDRItemType();
            return;
        }
        this.dritemtypeDirtyFlag = false;
        this.dritemtype = null;
    }

    public void setDRItemTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDRItemTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dritemtypename = string;
        this.dritemtypenameDirtyFlag = true;
    }

    public String getDRItemTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDRItemTypeName();
        }
        return this.dritemtypename;
    }

    public boolean isDRItemTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDRItemTypeNameDirty();
        }
        return this.dritemtypenameDirtyFlag;
    }

    public void resetDRItemTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDRItemTypeName();
            return;
        }
        this.dritemtypenameDirtyFlag = false;
        this.dritemtypename = null;
    }

    public void setPSDEDRItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDRItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedritemid = string;
        this.psdedritemidDirtyFlag = true;
    }

    public String getPSDEDRItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDRItemId();
        }
        return this.psdedritemid;
    }

    public boolean isPSDEDRItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDRItemIdDirty();
        }
        return this.psdedritemidDirtyFlag;
    }

    public void resetPSDEDRItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDRItemId();
            return;
        }
        this.psdedritemidDirtyFlag = false;
        this.psdedritemid = null;
    }

    public void setPSDEDRItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDRItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedritemname = string;
        this.psdedritemnameDirtyFlag = true;
    }

    public String getPSDEDRItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDRItemName();
        }
        return this.psdedritemname;
    }

    public boolean isPSDEDRItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDRItemNameDirty();
        }
        return this.psdedritemnameDirtyFlag;
    }

    public void resetPSDEDRItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDRItemName();
            return;
        }
        this.psdedritemnameDirtyFlag = false;
        this.psdedritemname = null;
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

    public void setPSDEViewBaseId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBaseId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewbaseid = string;
        this.psdeviewbaseidDirtyFlag = true;
    }

    public String getPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBaseId();
        }
        return this.psdeviewbaseid;
    }

    public boolean isPSDEViewBaseIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBaseIdDirty();
        }
        return this.psdeviewbaseidDirtyFlag;
    }

    public void resetPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBaseId();
            return;
        }
        this.psdeviewbaseidDirtyFlag = false;
        this.psdeviewbaseid = null;
    }

    public void setPSDEViewBaseName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBaseName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewbasename = string;
        this.psdeviewbasenameDirtyFlag = true;
    }

    public String getPSDEViewBaseName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBaseName();
        }
        return this.psdeviewbasename;
    }

    public boolean isPSDEViewBaseNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBaseNameDirty();
        }
        return this.psdeviewbasenameDirtyFlag;
    }

    public void resetPSDEViewBaseName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBaseName();
            return;
        }
        this.psdeviewbasenameDirtyFlag = false;
        this.psdeviewbasename = null;
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

    public void setPSUWDEDRItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUWDEDRItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuwdedritemid = string;
        this.psuwdedritemidDirtyFlag = true;
    }

    public String getPSUWDEDRItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUWDEDRItemId();
        }
        return this.psuwdedritemid;
    }

    public boolean isPSUWDEDRItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUWDEDRItemIdDirty();
        }
        return this.psuwdedritemidDirtyFlag;
    }

    public void resetPSUWDEDRItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUWDEDRItemId();
            return;
        }
        this.psuwdedritemidDirtyFlag = false;
        this.psuwdedritemid = null;
    }

    public void setPSUWDEDRItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUWDEDRItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuwdedritemname = string;
        this.psuwdedritemnameDirtyFlag = true;
    }

    public String getPSUWDEDRItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUWDEDRItemName();
        }
        return this.psuwdedritemname;
    }

    public boolean isPSUWDEDRItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUWDEDRItemNameDirty();
        }
        return this.psuwdedritemnameDirtyFlag;
    }

    public void resetPSUWDEDRItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUWDEDRItemName();
            return;
        }
        this.psuwdedritemnameDirtyFlag = false;
        this.psuwdedritemname = null;
    }

    public void setSysPSDERId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysPSDERId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.syspsderid = string;
        this.syspsderidDirtyFlag = true;
    }

    public String getSysPSDERId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysPSDERId();
        }
        return this.syspsderid;
    }

    public boolean isSysPSDERIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysPSDERIdDirty();
        }
        return this.syspsderidDirtyFlag;
    }

    public void resetSysPSDERId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysPSDERId();
            return;
        }
        this.syspsderidDirtyFlag = false;
        this.syspsderid = null;
    }

    public void setSysPSDERName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysPSDERName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.syspsdername = string;
        this.syspsdernameDirtyFlag = true;
    }

    public String getSysPSDERName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysPSDERName();
        }
        return this.syspsdername;
    }

    public boolean isSysPSDERNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysPSDERNameDirty();
        }
        return this.syspsdernameDirtyFlag;
    }

    public void resetSysPSDERName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysPSDERName();
            return;
        }
        this.syspsdernameDirtyFlag = false;
        this.syspsdername = null;
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

    public void setViewPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewpsdeid = string;
        this.viewpsdeidDirtyFlag = true;
    }

    public String getViewPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewPSDEId();
        }
        return this.viewpsdeid;
    }

    public boolean isViewPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewPSDEIdDirty();
        }
        return this.viewpsdeidDirtyFlag;
    }

    public void resetViewPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewPSDEId();
            return;
        }
        this.viewpsdeidDirtyFlag = false;
        this.viewpsdeid = null;
    }

    public void setViewPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewpsdename = string;
        this.viewpsdenameDirtyFlag = true;
    }

    public String getViewPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewPSDEName();
        }
        return this.viewpsdename;
    }

    public boolean isViewPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewPSDENameDirty();
        }
        return this.viewpsdenameDirtyFlag;
    }

    public void resetViewPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewPSDEName();
            return;
        }
        this.viewpsdenameDirtyFlag = false;
        this.viewpsdename = null;
    }

    public void setWizardMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardmode = string;
        this.wizardmodeDirtyFlag = true;
    }

    public String getWizardMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardMode();
        }
        return this.wizardmode;
    }

    public boolean isWizardModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardModeDirty();
        }
        return this.wizardmodeDirtyFlag;
    }

    public void resetWizardMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardMode();
            return;
        }
        this.wizardmodeDirtyFlag = false;
        this.wizardmode = null;
    }

    public void setWizardParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardparam = string;
        this.wizardparamDirtyFlag = true;
    }

    public String getWizardParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam();
        }
        return this.wizardparam;
    }

    public boolean isWizardParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParamDirty();
        }
        return this.wizardparamDirtyFlag;
    }

    public void resetWizardParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam();
            return;
        }
        this.wizardparamDirtyFlag = false;
        this.wizardparam = null;
    }

    public void setWizardParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardparam2 = string;
        this.wizardparam2DirtyFlag = true;
    }

    public String getWizardParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam2();
        }
        return this.wizardparam2;
    }

    public boolean isWizardParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam2Dirty();
        }
        return this.wizardparam2DirtyFlag;
    }

    public void resetWizardParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam2();
            return;
        }
        this.wizardparam2DirtyFlag = false;
        this.wizardparam2 = null;
    }

    public void setWizardParam3(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam3(n);
            return;
        }
        this.wizardparam3 = n;
        this.wizardparam3DirtyFlag = true;
    }

    public Integer getWizardParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam3();
        }
        return this.wizardparam3;
    }

    public boolean isWizardParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam3Dirty();
        }
        return this.wizardparam3DirtyFlag;
    }

    public void resetWizardParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam3();
            return;
        }
        this.wizardparam3DirtyFlag = false;
        this.wizardparam3 = null;
    }

    public void setWizardParam4(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam4(n);
            return;
        }
        this.wizardparam4 = n;
        this.wizardparam4DirtyFlag = true;
    }

    public Integer getWizardParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam4();
        }
        return this.wizardparam4;
    }

    public boolean isWizardParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam4Dirty();
        }
        return this.wizardparam4DirtyFlag;
    }

    public void resetWizardParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam4();
            return;
        }
        this.wizardparam4DirtyFlag = false;
        this.wizardparam4 = null;
    }

    protected void onReset() {
        PSUWDEDRItemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSUWDEDRItemBase pSUWDEDRItemBase) {
        pSUWDEDRItemBase.resetCreateDate();
        pSUWDEDRItemBase.resetCreateMan();
        pSUWDEDRItemBase.resetDRItemType();
        pSUWDEDRItemBase.resetDRItemTypeName();
        pSUWDEDRItemBase.resetPSDEDRItemId();
        pSUWDEDRItemBase.resetPSDEDRItemName();
        pSUWDEDRItemBase.resetPSDEId();
        pSUWDEDRItemBase.resetPSDEName();
        pSUWDEDRItemBase.resetPSDERId();
        pSUWDEDRItemBase.resetPSDERName();
        pSUWDEDRItemBase.resetPSDEViewBaseId();
        pSUWDEDRItemBase.resetPSDEViewBaseName();
        pSUWDEDRItemBase.resetPSDynaInstId();
        pSUWDEDRItemBase.resetPSUWDEDRItemId();
        pSUWDEDRItemBase.resetPSUWDEDRItemName();
        pSUWDEDRItemBase.resetSysPSDERId();
        pSUWDEDRItemBase.resetSysPSDERName();
        pSUWDEDRItemBase.resetUpdateDate();
        pSUWDEDRItemBase.resetUpdateMan();
        pSUWDEDRItemBase.resetViewPSDEId();
        pSUWDEDRItemBase.resetViewPSDEName();
        pSUWDEDRItemBase.resetWizardMode();
        pSUWDEDRItemBase.resetWizardParam();
        pSUWDEDRItemBase.resetWizardParam2();
        pSUWDEDRItemBase.resetWizardParam3();
        pSUWDEDRItemBase.resetWizardParam4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDRItemTypeDirty()) {
            hashMap.put(FIELD_DRITEMTYPE, this.getDRItemType());
        }
        if (!bl || this.isDRItemTypeNameDirty()) {
            hashMap.put(FIELD_DRITEMTYPENAME, this.getDRItemTypeName());
        }
        if (!bl || this.isPSDEDRItemIdDirty()) {
            hashMap.put(FIELD_PSDEDRITEMID, this.getPSDEDRItemId());
        }
        if (!bl || this.isPSDEDRItemNameDirty()) {
            hashMap.put(FIELD_PSDEDRITEMNAME, this.getPSDEDRItemName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDERIdDirty()) {
            hashMap.put(FIELD_PSDERID, this.getPSDERId());
        }
        if (!bl || this.isPSDERNameDirty()) {
            hashMap.put(FIELD_PSDERNAME, this.getPSDERName());
        }
        if (!bl || this.isPSDEViewBaseIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASEID, this.getPSDEViewBaseId());
        }
        if (!bl || this.isPSDEViewBaseNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASENAME, this.getPSDEViewBaseName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSUWDEDRItemIdDirty()) {
            hashMap.put(FIELD_PSUWDEDRITEMID, this.getPSUWDEDRItemId());
        }
        if (!bl || this.isPSUWDEDRItemNameDirty()) {
            hashMap.put(FIELD_PSUWDEDRITEMNAME, this.getPSUWDEDRItemName());
        }
        if (!bl || this.isSysPSDERIdDirty()) {
            hashMap.put(FIELD_SYSPSDERID, this.getSysPSDERId());
        }
        if (!bl || this.isSysPSDERNameDirty()) {
            hashMap.put(FIELD_SYSPSDERNAME, this.getSysPSDERName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isViewPSDEIdDirty()) {
            hashMap.put(FIELD_VIEWPSDEID, this.getViewPSDEId());
        }
        if (!bl || this.isViewPSDENameDirty()) {
            hashMap.put(FIELD_VIEWPSDENAME, this.getViewPSDEName());
        }
        if (!bl || this.isWizardModeDirty()) {
            hashMap.put(FIELD_WIZARDMODE, this.getWizardMode());
        }
        if (!bl || this.isWizardParamDirty()) {
            hashMap.put(FIELD_WIZARDPARAM, this.getWizardParam());
        }
        if (!bl || this.isWizardParam2Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM2, this.getWizardParam2());
        }
        if (!bl || this.isWizardParam3Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM3, this.getWizardParam3());
        }
        if (!bl || this.isWizardParam4Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM4, this.getWizardParam4());
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
        return PSUWDEDRItemBase.get(this, n);
    }

    private static Object get(PSUWDEDRItemBase pSUWDEDRItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWDEDRItemBase.getCreateDate();
            }
            case 1: {
                return pSUWDEDRItemBase.getCreateMan();
            }
            case 2: {
                return pSUWDEDRItemBase.getDRItemType();
            }
            case 3: {
                return pSUWDEDRItemBase.getDRItemTypeName();
            }
            case 4: {
                return pSUWDEDRItemBase.getPSDEDRItemId();
            }
            case 5: {
                return pSUWDEDRItemBase.getPSDEDRItemName();
            }
            case 6: {
                return pSUWDEDRItemBase.getPSDEId();
            }
            case 7: {
                return pSUWDEDRItemBase.getPSDEName();
            }
            case 8: {
                return pSUWDEDRItemBase.getPSDERId();
            }
            case 9: {
                return pSUWDEDRItemBase.getPSDERName();
            }
            case 10: {
                return pSUWDEDRItemBase.getPSDEViewBaseId();
            }
            case 11: {
                return pSUWDEDRItemBase.getPSDEViewBaseName();
            }
            case 12: {
                return pSUWDEDRItemBase.getPSDynaInstId();
            }
            case 13: {
                return pSUWDEDRItemBase.getPSUWDEDRItemId();
            }
            case 14: {
                return pSUWDEDRItemBase.getPSUWDEDRItemName();
            }
            case 15: {
                return pSUWDEDRItemBase.getSysPSDERId();
            }
            case 16: {
                return pSUWDEDRItemBase.getSysPSDERName();
            }
            case 17: {
                return pSUWDEDRItemBase.getUpdateDate();
            }
            case 18: {
                return pSUWDEDRItemBase.getUpdateMan();
            }
            case 19: {
                return pSUWDEDRItemBase.getViewPSDEId();
            }
            case 20: {
                return pSUWDEDRItemBase.getViewPSDEName();
            }
            case 21: {
                return pSUWDEDRItemBase.getWizardMode();
            }
            case 22: {
                return pSUWDEDRItemBase.getWizardParam();
            }
            case 23: {
                return pSUWDEDRItemBase.getWizardParam2();
            }
            case 24: {
                return pSUWDEDRItemBase.getWizardParam3();
            }
            case 25: {
                return pSUWDEDRItemBase.getWizardParam4();
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
        PSUWDEDRItemBase.set(this, n, object);
    }

    private static void set(PSUWDEDRItemBase pSUWDEDRItemBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSUWDEDRItemBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSUWDEDRItemBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSUWDEDRItemBase.setDRItemType(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSUWDEDRItemBase.setDRItemTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSUWDEDRItemBase.setPSDEDRItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSUWDEDRItemBase.setPSDEDRItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSUWDEDRItemBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSUWDEDRItemBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSUWDEDRItemBase.setPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSUWDEDRItemBase.setPSDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSUWDEDRItemBase.setPSDEViewBaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSUWDEDRItemBase.setPSDEViewBaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSUWDEDRItemBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSUWDEDRItemBase.setPSUWDEDRItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSUWDEDRItemBase.setPSUWDEDRItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSUWDEDRItemBase.setSysPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSUWDEDRItemBase.setSysPSDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSUWDEDRItemBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 18: {
                pSUWDEDRItemBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSUWDEDRItemBase.setViewPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSUWDEDRItemBase.setViewPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSUWDEDRItemBase.setWizardMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSUWDEDRItemBase.setWizardParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSUWDEDRItemBase.setWizardParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSUWDEDRItemBase.setWizardParam3(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSUWDEDRItemBase.setWizardParam4(DataObject.getIntegerValue((Object)object));
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
        return PSUWDEDRItemBase.isNull(this, n);
    }

    private static boolean isNull(PSUWDEDRItemBase pSUWDEDRItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWDEDRItemBase.getCreateDate() == null;
            }
            case 1: {
                return pSUWDEDRItemBase.getCreateMan() == null;
            }
            case 2: {
                return pSUWDEDRItemBase.getDRItemType() == null;
            }
            case 3: {
                return pSUWDEDRItemBase.getDRItemTypeName() == null;
            }
            case 4: {
                return pSUWDEDRItemBase.getPSDEDRItemId() == null;
            }
            case 5: {
                return pSUWDEDRItemBase.getPSDEDRItemName() == null;
            }
            case 6: {
                return pSUWDEDRItemBase.getPSDEId() == null;
            }
            case 7: {
                return pSUWDEDRItemBase.getPSDEName() == null;
            }
            case 8: {
                return pSUWDEDRItemBase.getPSDERId() == null;
            }
            case 9: {
                return pSUWDEDRItemBase.getPSDERName() == null;
            }
            case 10: {
                return pSUWDEDRItemBase.getPSDEViewBaseId() == null;
            }
            case 11: {
                return pSUWDEDRItemBase.getPSDEViewBaseName() == null;
            }
            case 12: {
                return pSUWDEDRItemBase.getPSDynaInstId() == null;
            }
            case 13: {
                return pSUWDEDRItemBase.getPSUWDEDRItemId() == null;
            }
            case 14: {
                return pSUWDEDRItemBase.getPSUWDEDRItemName() == null;
            }
            case 15: {
                return pSUWDEDRItemBase.getSysPSDERId() == null;
            }
            case 16: {
                return pSUWDEDRItemBase.getSysPSDERName() == null;
            }
            case 17: {
                return pSUWDEDRItemBase.getUpdateDate() == null;
            }
            case 18: {
                return pSUWDEDRItemBase.getUpdateMan() == null;
            }
            case 19: {
                return pSUWDEDRItemBase.getViewPSDEId() == null;
            }
            case 20: {
                return pSUWDEDRItemBase.getViewPSDEName() == null;
            }
            case 21: {
                return pSUWDEDRItemBase.getWizardMode() == null;
            }
            case 22: {
                return pSUWDEDRItemBase.getWizardParam() == null;
            }
            case 23: {
                return pSUWDEDRItemBase.getWizardParam2() == null;
            }
            case 24: {
                return pSUWDEDRItemBase.getWizardParam3() == null;
            }
            case 25: {
                return pSUWDEDRItemBase.getWizardParam4() == null;
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
        return PSUWDEDRItemBase.contains(this, n);
    }

    private static boolean contains(PSUWDEDRItemBase pSUWDEDRItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWDEDRItemBase.isCreateDateDirty();
            }
            case 1: {
                return pSUWDEDRItemBase.isCreateManDirty();
            }
            case 2: {
                return pSUWDEDRItemBase.isDRItemTypeDirty();
            }
            case 3: {
                return pSUWDEDRItemBase.isDRItemTypeNameDirty();
            }
            case 4: {
                return pSUWDEDRItemBase.isPSDEDRItemIdDirty();
            }
            case 5: {
                return pSUWDEDRItemBase.isPSDEDRItemNameDirty();
            }
            case 6: {
                return pSUWDEDRItemBase.isPSDEIdDirty();
            }
            case 7: {
                return pSUWDEDRItemBase.isPSDENameDirty();
            }
            case 8: {
                return pSUWDEDRItemBase.isPSDERIdDirty();
            }
            case 9: {
                return pSUWDEDRItemBase.isPSDERNameDirty();
            }
            case 10: {
                return pSUWDEDRItemBase.isPSDEViewBaseIdDirty();
            }
            case 11: {
                return pSUWDEDRItemBase.isPSDEViewBaseNameDirty();
            }
            case 12: {
                return pSUWDEDRItemBase.isPSDynaInstIdDirty();
            }
            case 13: {
                return pSUWDEDRItemBase.isPSUWDEDRItemIdDirty();
            }
            case 14: {
                return pSUWDEDRItemBase.isPSUWDEDRItemNameDirty();
            }
            case 15: {
                return pSUWDEDRItemBase.isSysPSDERIdDirty();
            }
            case 16: {
                return pSUWDEDRItemBase.isSysPSDERNameDirty();
            }
            case 17: {
                return pSUWDEDRItemBase.isUpdateDateDirty();
            }
            case 18: {
                return pSUWDEDRItemBase.isUpdateManDirty();
            }
            case 19: {
                return pSUWDEDRItemBase.isViewPSDEIdDirty();
            }
            case 20: {
                return pSUWDEDRItemBase.isViewPSDENameDirty();
            }
            case 21: {
                return pSUWDEDRItemBase.isWizardModeDirty();
            }
            case 22: {
                return pSUWDEDRItemBase.isWizardParamDirty();
            }
            case 23: {
                return pSUWDEDRItemBase.isWizardParam2Dirty();
            }
            case 24: {
                return pSUWDEDRItemBase.isWizardParam3Dirty();
            }
            case 25: {
                return pSUWDEDRItemBase.isWizardParam4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSUWDEDRItemBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSUWDEDRItemBase pSUWDEDRItemBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSUWDEDRItemBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSUWDEDRItemBase.getJSONValue((Object)pSUWDEDRItemBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSUWDEDRItemBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSUWDEDRItemBase.getJSONValue((Object)pSUWDEDRItemBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSUWDEDRItemBase.getDRItemType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dritemtype", (Object)PSUWDEDRItemBase.getJSONValue((Object)pSUWDEDRItemBase.getDRItemType()), (boolean)false);
        }
        if (bl || pSUWDEDRItemBase.getDRItemTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dritemtypename", (Object)PSUWDEDRItemBase.getJSONValue((Object)pSUWDEDRItemBase.getDRItemTypeName()), (boolean)false);
        }
        if (bl || pSUWDEDRItemBase.getPSDEDRItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedritemid", (Object)PSUWDEDRItemBase.getJSONValue((Object)pSUWDEDRItemBase.getPSDEDRItemId()), (boolean)false);
        }
        if (bl || pSUWDEDRItemBase.getPSDEDRItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedritemname", (Object)PSUWDEDRItemBase.getJSONValue((Object)pSUWDEDRItemBase.getPSDEDRItemName()), (boolean)false);
        }
        if (bl || pSUWDEDRItemBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSUWDEDRItemBase.getJSONValue((Object)pSUWDEDRItemBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSUWDEDRItemBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSUWDEDRItemBase.getJSONValue((Object)pSUWDEDRItemBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSUWDEDRItemBase.getPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psderid", (Object)PSUWDEDRItemBase.getJSONValue((Object)pSUWDEDRItemBase.getPSDERId()), (boolean)false);
        }
        if (bl || pSUWDEDRItemBase.getPSDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdername", (Object)PSUWDEDRItemBase.getJSONValue((Object)pSUWDEDRItemBase.getPSDERName()), (boolean)false);
        }
        if (bl || pSUWDEDRItemBase.getPSDEViewBaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbaseid", (Object)PSUWDEDRItemBase.getJSONValue((Object)pSUWDEDRItemBase.getPSDEViewBaseId()), (boolean)false);
        }
        if (bl || pSUWDEDRItemBase.getPSDEViewBaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbasename", (Object)PSUWDEDRItemBase.getJSONValue((Object)pSUWDEDRItemBase.getPSDEViewBaseName()), (boolean)false);
        }
        if (bl || pSUWDEDRItemBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSUWDEDRItemBase.getJSONValue((Object)pSUWDEDRItemBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSUWDEDRItemBase.getPSUWDEDRItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuwdedritemid", (Object)PSUWDEDRItemBase.getJSONValue((Object)pSUWDEDRItemBase.getPSUWDEDRItemId()), (boolean)false);
        }
        if (bl || pSUWDEDRItemBase.getPSUWDEDRItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuwdedritemname", (Object)PSUWDEDRItemBase.getJSONValue((Object)pSUWDEDRItemBase.getPSUWDEDRItemName()), (boolean)false);
        }
        if (bl || pSUWDEDRItemBase.getSysPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syspsderid", (Object)PSUWDEDRItemBase.getJSONValue((Object)pSUWDEDRItemBase.getSysPSDERId()), (boolean)false);
        }
        if (bl || pSUWDEDRItemBase.getSysPSDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syspsdername", (Object)PSUWDEDRItemBase.getJSONValue((Object)pSUWDEDRItemBase.getSysPSDERName()), (boolean)false);
        }
        if (bl || pSUWDEDRItemBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSUWDEDRItemBase.getJSONValue((Object)pSUWDEDRItemBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSUWDEDRItemBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSUWDEDRItemBase.getJSONValue((Object)pSUWDEDRItemBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSUWDEDRItemBase.getViewPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewpsdeid", (Object)PSUWDEDRItemBase.getJSONValue((Object)pSUWDEDRItemBase.getViewPSDEId()), (boolean)false);
        }
        if (bl || pSUWDEDRItemBase.getViewPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewpsdename", (Object)PSUWDEDRItemBase.getJSONValue((Object)pSUWDEDRItemBase.getViewPSDEName()), (boolean)false);
        }
        if (bl || pSUWDEDRItemBase.getWizardMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardmode", (Object)PSUWDEDRItemBase.getJSONValue((Object)pSUWDEDRItemBase.getWizardMode()), (boolean)false);
        }
        if (bl || pSUWDEDRItemBase.getWizardParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam", (Object)PSUWDEDRItemBase.getJSONValue((Object)pSUWDEDRItemBase.getWizardParam()), (boolean)false);
        }
        if (bl || pSUWDEDRItemBase.getWizardParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam2", (Object)PSUWDEDRItemBase.getJSONValue((Object)pSUWDEDRItemBase.getWizardParam2()), (boolean)false);
        }
        if (bl || pSUWDEDRItemBase.getWizardParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam3", (Object)PSUWDEDRItemBase.getJSONValue((Object)pSUWDEDRItemBase.getWizardParam3()), (boolean)false);
        }
        if (bl || pSUWDEDRItemBase.getWizardParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam4", (Object)PSUWDEDRItemBase.getJSONValue((Object)pSUWDEDRItemBase.getWizardParam4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSUWDEDRItemBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSUWDEDRItemBase pSUWDEDRItemBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSUWDEDRItemBase.getCreateDate() != null) {
            object = pSUWDEDRItemBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUWDEDRItemBase.getCreateMan() != null) {
            object = pSUWDEDRItemBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEDRItemBase.getDRItemType() != null) {
            object = pSUWDEDRItemBase.getDRItemType();
            xmlNode.setAttribute(FIELD_DRITEMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEDRItemBase.getDRItemTypeName() != null) {
            object = pSUWDEDRItemBase.getDRItemTypeName();
            xmlNode.setAttribute(FIELD_DRITEMTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEDRItemBase.getPSDEDRItemId() != null) {
            object = pSUWDEDRItemBase.getPSDEDRItemId();
            xmlNode.setAttribute(FIELD_PSDEDRITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEDRItemBase.getPSDEDRItemName() != null) {
            object = pSUWDEDRItemBase.getPSDEDRItemName();
            xmlNode.setAttribute(FIELD_PSDEDRITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEDRItemBase.getPSDEId() != null) {
            object = pSUWDEDRItemBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEDRItemBase.getPSDEName() != null) {
            object = pSUWDEDRItemBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEDRItemBase.getPSDERId() != null) {
            object = pSUWDEDRItemBase.getPSDERId();
            xmlNode.setAttribute(FIELD_PSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEDRItemBase.getPSDERName() != null) {
            object = pSUWDEDRItemBase.getPSDERName();
            xmlNode.setAttribute(FIELD_PSDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEDRItemBase.getPSDEViewBaseId() != null) {
            object = pSUWDEDRItemBase.getPSDEViewBaseId();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASEID, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEDRItemBase.getPSDEViewBaseName() != null) {
            object = pSUWDEDRItemBase.getPSDEViewBaseName();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEDRItemBase.getPSDynaInstId() != null) {
            object = pSUWDEDRItemBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEDRItemBase.getPSUWDEDRItemId() != null) {
            object = pSUWDEDRItemBase.getPSUWDEDRItemId();
            xmlNode.setAttribute(FIELD_PSUWDEDRITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEDRItemBase.getPSUWDEDRItemName() != null) {
            object = pSUWDEDRItemBase.getPSUWDEDRItemName();
            xmlNode.setAttribute(FIELD_PSUWDEDRITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEDRItemBase.getSysPSDERId() != null) {
            object = pSUWDEDRItemBase.getSysPSDERId();
            xmlNode.setAttribute(FIELD_SYSPSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEDRItemBase.getSysPSDERName() != null) {
            object = pSUWDEDRItemBase.getSysPSDERName();
            xmlNode.setAttribute(FIELD_SYSPSDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEDRItemBase.getUpdateDate() != null) {
            object = pSUWDEDRItemBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUWDEDRItemBase.getUpdateMan() != null) {
            object = pSUWDEDRItemBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEDRItemBase.getViewPSDEId() != null) {
            object = pSUWDEDRItemBase.getViewPSDEId();
            xmlNode.setAttribute(FIELD_VIEWPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEDRItemBase.getViewPSDEName() != null) {
            object = pSUWDEDRItemBase.getViewPSDEName();
            xmlNode.setAttribute(FIELD_VIEWPSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEDRItemBase.getWizardMode() != null) {
            object = pSUWDEDRItemBase.getWizardMode();
            xmlNode.setAttribute(FIELD_WIZARDMODE, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEDRItemBase.getWizardParam() != null) {
            object = pSUWDEDRItemBase.getWizardParam();
            xmlNode.setAttribute(FIELD_WIZARDPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEDRItemBase.getWizardParam2() != null) {
            object = pSUWDEDRItemBase.getWizardParam2();
            xmlNode.setAttribute(FIELD_WIZARDPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEDRItemBase.getWizardParam3() != null) {
            object = pSUWDEDRItemBase.getWizardParam3();
            xmlNode.setAttribute(FIELD_WIZARDPARAM3, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWDEDRItemBase.getWizardParam4() != null) {
            object = pSUWDEDRItemBase.getWizardParam4();
            xmlNode.setAttribute(FIELD_WIZARDPARAM4, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSUWDEDRItemBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSUWDEDRItemBase pSUWDEDRItemBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSUWDEDRItemBase.isCreateDateDirty() && (bl || pSUWDEDRItemBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSUWDEDRItemBase.getCreateDate());
        }
        if (pSUWDEDRItemBase.isCreateManDirty() && (bl || pSUWDEDRItemBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSUWDEDRItemBase.getCreateMan());
        }
        if (pSUWDEDRItemBase.isDRItemTypeDirty() && (bl || pSUWDEDRItemBase.getDRItemType() != null)) {
            iDataObject.set(FIELD_DRITEMTYPE, (Object)pSUWDEDRItemBase.getDRItemType());
        }
        if (pSUWDEDRItemBase.isDRItemTypeNameDirty() && (bl || pSUWDEDRItemBase.getDRItemTypeName() != null)) {
            iDataObject.set(FIELD_DRITEMTYPENAME, (Object)pSUWDEDRItemBase.getDRItemTypeName());
        }
        if (pSUWDEDRItemBase.isPSDEDRItemIdDirty() && (bl || pSUWDEDRItemBase.getPSDEDRItemId() != null)) {
            iDataObject.set(FIELD_PSDEDRITEMID, (Object)pSUWDEDRItemBase.getPSDEDRItemId());
        }
        if (pSUWDEDRItemBase.isPSDEDRItemNameDirty() && (bl || pSUWDEDRItemBase.getPSDEDRItemName() != null)) {
            iDataObject.set(FIELD_PSDEDRITEMNAME, (Object)pSUWDEDRItemBase.getPSDEDRItemName());
        }
        if (pSUWDEDRItemBase.isPSDEIdDirty() && (bl || pSUWDEDRItemBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSUWDEDRItemBase.getPSDEId());
        }
        if (pSUWDEDRItemBase.isPSDENameDirty() && (bl || pSUWDEDRItemBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSUWDEDRItemBase.getPSDEName());
        }
        if (pSUWDEDRItemBase.isPSDERIdDirty() && (bl || pSUWDEDRItemBase.getPSDERId() != null)) {
            iDataObject.set(FIELD_PSDERID, (Object)pSUWDEDRItemBase.getPSDERId());
        }
        if (pSUWDEDRItemBase.isPSDERNameDirty() && (bl || pSUWDEDRItemBase.getPSDERName() != null)) {
            iDataObject.set(FIELD_PSDERNAME, (Object)pSUWDEDRItemBase.getPSDERName());
        }
        if (pSUWDEDRItemBase.isPSDEViewBaseIdDirty() && (bl || pSUWDEDRItemBase.getPSDEViewBaseId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASEID, (Object)pSUWDEDRItemBase.getPSDEViewBaseId());
        }
        if (pSUWDEDRItemBase.isPSDEViewBaseNameDirty() && (bl || pSUWDEDRItemBase.getPSDEViewBaseName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASENAME, (Object)pSUWDEDRItemBase.getPSDEViewBaseName());
        }
        if (pSUWDEDRItemBase.isPSDynaInstIdDirty() && (bl || pSUWDEDRItemBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSUWDEDRItemBase.getPSDynaInstId());
        }
        if (pSUWDEDRItemBase.isPSUWDEDRItemIdDirty() && (bl || pSUWDEDRItemBase.getPSUWDEDRItemId() != null)) {
            iDataObject.set(FIELD_PSUWDEDRITEMID, (Object)pSUWDEDRItemBase.getPSUWDEDRItemId());
        }
        if (pSUWDEDRItemBase.isPSUWDEDRItemNameDirty() && (bl || pSUWDEDRItemBase.getPSUWDEDRItemName() != null)) {
            iDataObject.set(FIELD_PSUWDEDRITEMNAME, (Object)pSUWDEDRItemBase.getPSUWDEDRItemName());
        }
        if (pSUWDEDRItemBase.isSysPSDERIdDirty() && (bl || pSUWDEDRItemBase.getSysPSDERId() != null)) {
            iDataObject.set(FIELD_SYSPSDERID, (Object)pSUWDEDRItemBase.getSysPSDERId());
        }
        if (pSUWDEDRItemBase.isSysPSDERNameDirty() && (bl || pSUWDEDRItemBase.getSysPSDERName() != null)) {
            iDataObject.set(FIELD_SYSPSDERNAME, (Object)pSUWDEDRItemBase.getSysPSDERName());
        }
        if (pSUWDEDRItemBase.isUpdateDateDirty() && (bl || pSUWDEDRItemBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSUWDEDRItemBase.getUpdateDate());
        }
        if (pSUWDEDRItemBase.isUpdateManDirty() && (bl || pSUWDEDRItemBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSUWDEDRItemBase.getUpdateMan());
        }
        if (pSUWDEDRItemBase.isViewPSDEIdDirty() && (bl || pSUWDEDRItemBase.getViewPSDEId() != null)) {
            iDataObject.set(FIELD_VIEWPSDEID, (Object)pSUWDEDRItemBase.getViewPSDEId());
        }
        if (pSUWDEDRItemBase.isViewPSDENameDirty() && (bl || pSUWDEDRItemBase.getViewPSDEName() != null)) {
            iDataObject.set(FIELD_VIEWPSDENAME, (Object)pSUWDEDRItemBase.getViewPSDEName());
        }
        if (pSUWDEDRItemBase.isWizardModeDirty() && (bl || pSUWDEDRItemBase.getWizardMode() != null)) {
            iDataObject.set(FIELD_WIZARDMODE, (Object)pSUWDEDRItemBase.getWizardMode());
        }
        if (pSUWDEDRItemBase.isWizardParamDirty() && (bl || pSUWDEDRItemBase.getWizardParam() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM, (Object)pSUWDEDRItemBase.getWizardParam());
        }
        if (pSUWDEDRItemBase.isWizardParam2Dirty() && (bl || pSUWDEDRItemBase.getWizardParam2() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM2, (Object)pSUWDEDRItemBase.getWizardParam2());
        }
        if (pSUWDEDRItemBase.isWizardParam3Dirty() && (bl || pSUWDEDRItemBase.getWizardParam3() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM3, (Object)pSUWDEDRItemBase.getWizardParam3());
        }
        if (pSUWDEDRItemBase.isWizardParam4Dirty() && (bl || pSUWDEDRItemBase.getWizardParam4() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM4, (Object)pSUWDEDRItemBase.getWizardParam4());
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
        return PSUWDEDRItemBase.remove(this, n);
    }

    private static boolean remove(PSUWDEDRItemBase pSUWDEDRItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSUWDEDRItemBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSUWDEDRItemBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSUWDEDRItemBase.resetDRItemType();
                return true;
            }
            case 3: {
                pSUWDEDRItemBase.resetDRItemTypeName();
                return true;
            }
            case 4: {
                pSUWDEDRItemBase.resetPSDEDRItemId();
                return true;
            }
            case 5: {
                pSUWDEDRItemBase.resetPSDEDRItemName();
                return true;
            }
            case 6: {
                pSUWDEDRItemBase.resetPSDEId();
                return true;
            }
            case 7: {
                pSUWDEDRItemBase.resetPSDEName();
                return true;
            }
            case 8: {
                pSUWDEDRItemBase.resetPSDERId();
                return true;
            }
            case 9: {
                pSUWDEDRItemBase.resetPSDERName();
                return true;
            }
            case 10: {
                pSUWDEDRItemBase.resetPSDEViewBaseId();
                return true;
            }
            case 11: {
                pSUWDEDRItemBase.resetPSDEViewBaseName();
                return true;
            }
            case 12: {
                pSUWDEDRItemBase.resetPSDynaInstId();
                return true;
            }
            case 13: {
                pSUWDEDRItemBase.resetPSUWDEDRItemId();
                return true;
            }
            case 14: {
                pSUWDEDRItemBase.resetPSUWDEDRItemName();
                return true;
            }
            case 15: {
                pSUWDEDRItemBase.resetSysPSDERId();
                return true;
            }
            case 16: {
                pSUWDEDRItemBase.resetSysPSDERName();
                return true;
            }
            case 17: {
                pSUWDEDRItemBase.resetUpdateDate();
                return true;
            }
            case 18: {
                pSUWDEDRItemBase.resetUpdateMan();
                return true;
            }
            case 19: {
                pSUWDEDRItemBase.resetViewPSDEId();
                return true;
            }
            case 20: {
                pSUWDEDRItemBase.resetViewPSDEName();
                return true;
            }
            case 21: {
                pSUWDEDRItemBase.resetWizardMode();
                return true;
            }
            case 22: {
                pSUWDEDRItemBase.resetWizardParam();
                return true;
            }
            case 23: {
                pSUWDEDRItemBase.resetWizardParam2();
                return true;
            }
            case 24: {
                pSUWDEDRItemBase.resetWizardParam3();
                return true;
            }
            case 25: {
                pSUWDEDRItemBase.resetWizardParam4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSUWDEDRItemBase getProxyEntity() {
        return this.proxyPSUWDEDRItemBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSUWDEDRItemBase = null;
        if (iDataObject != null && iDataObject instanceof PSUWDEDRItemBase) {
            this.proxyPSUWDEDRItemBase = (PSUWDEDRItemBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSUWDEDRItemService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DRITEMTYPE, 2);
        fieldIndexMap.put(FIELD_DRITEMTYPENAME, 3);
        fieldIndexMap.put(FIELD_PSDEDRITEMID, 4);
        fieldIndexMap.put(FIELD_PSDEDRITEMNAME, 5);
        fieldIndexMap.put(FIELD_PSDEID, 6);
        fieldIndexMap.put(FIELD_PSDENAME, 7);
        fieldIndexMap.put(FIELD_PSDERID, 8);
        fieldIndexMap.put(FIELD_PSDERNAME, 9);
        fieldIndexMap.put(FIELD_PSDEVIEWBASEID, 10);
        fieldIndexMap.put(FIELD_PSDEVIEWBASENAME, 11);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 12);
        fieldIndexMap.put(FIELD_PSUWDEDRITEMID, 13);
        fieldIndexMap.put(FIELD_PSUWDEDRITEMNAME, 14);
        fieldIndexMap.put(FIELD_SYSPSDERID, 15);
        fieldIndexMap.put(FIELD_SYSPSDERNAME, 16);
        fieldIndexMap.put(FIELD_UPDATEDATE, 17);
        fieldIndexMap.put(FIELD_UPDATEMAN, 18);
        fieldIndexMap.put(FIELD_VIEWPSDEID, 19);
        fieldIndexMap.put(FIELD_VIEWPSDENAME, 20);
        fieldIndexMap.put(FIELD_WIZARDMODE, 21);
        fieldIndexMap.put(FIELD_WIZARDPARAM, 22);
        fieldIndexMap.put(FIELD_WIZARDPARAM2, 23);
        fieldIndexMap.put(FIELD_WIZARDPARAM3, 24);
        fieldIndexMap.put(FIELD_WIZARDPARAM4, 25);
    }
}

