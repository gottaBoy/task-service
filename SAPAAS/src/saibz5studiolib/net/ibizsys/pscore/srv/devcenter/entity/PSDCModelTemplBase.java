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
package net.ibizsys.pscore.srv.devcenter.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMTDEF;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMTDEFService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCModelTemplBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCModelTemplBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFNAMEMAXLENGTH = "DEFNAMEMAXLENGTH";
    public static final String FIELD_DENAMEMAXLENGTH = "DENAMEMAXLENGTH";
    public static final String FIELD_IGNOREDEFAULTFIELDS = "IGNOREDEFAULTFIELDS";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCMODELTEMPLID = "PSDCMODELTEMPLID";
    public static final String FIELD_PSDCMODELTEMPLNAME = "PSDCMODELTEMPLNAME";
    public static final String FIELD_PSDCMTDEFSCNT = "PSDCMTDEFSCNT";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_TABLEPREFIX = "TABLEPREFIX";
    public static final String FIELD_TABLEPREFIXFLAG = "TABLEPREFIXFLAG";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VIEW2PREFIX = "VIEW2PREFIX";
    public static final String FIELD_VIEW3PREFIX = "VIEW3PREFIX";
    public static final String FIELD_VIEW4PREFIX = "VIEW4PREFIX";
    public static final String FIELD_VIEWPREFIX = "VIEWPREFIX";
    public static final String FIELD_VIEWPREFIXFLAG = "VIEWPREFIXFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DEFNAMEMAXLENGTH = 2;
    private static final int INDEX_DENAMEMAXLENGTH = 3;
    private static final int INDEX_IGNOREDEFAULTFIELDS = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSDCMODELTEMPLID = 6;
    private static final int INDEX_PSDCMODELTEMPLNAME = 7;
    private static final int INDEX_PSDCMTDEFSCNT = 8;
    private static final int INDEX_PSDEVCENTERID = 9;
    private static final int INDEX_PSDEVCENTERNAME = 10;
    private static final int INDEX_PSDEVSLNID = 11;
    private static final int INDEX_PSDEVSLNNAME = 12;
    private static final int INDEX_TABLEPREFIX = 13;
    private static final int INDEX_TABLEPREFIXFLAG = 14;
    private static final int INDEX_UPDATEDATE = 15;
    private static final int INDEX_UPDATEMAN = 16;
    private static final int INDEX_VIEW2PREFIX = 17;
    private static final int INDEX_VIEW3PREFIX = 18;
    private static final int INDEX_VIEW4PREFIX = 19;
    private static final int INDEX_VIEWPREFIX = 20;
    private static final int INDEX_VIEWPREFIXFLAG = 21;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCModelTemplBase proxyPSDCModelTemplBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defnamemaxlengthDirtyFlag = false;
    private boolean denamemaxlengthDirtyFlag = false;
    private boolean ignoredefaultfieldsDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcmodeltemplidDirtyFlag = false;
    private boolean psdcmodeltemplnameDirtyFlag = false;
    private boolean psdcmtdefscntDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean tableprefixDirtyFlag = false;
    private boolean tableprefixflagDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean view2prefixDirtyFlag = false;
    private boolean view3prefixDirtyFlag = false;
    private boolean view4prefixDirtyFlag = false;
    private boolean viewprefixDirtyFlag = false;
    private boolean viewprefixflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defnamemaxlength")
    private Integer defnamemaxlength;
    @Column(name="denamemaxlength")
    private Integer denamemaxlength;
    @Column(name="ignoredefaultfields")
    private Integer ignoredefaultfields;
    @Column(name="memo")
    private String memo;
    @Column(name="psdcmodeltemplid")
    private String psdcmodeltemplid;
    @Column(name="psdcmodeltemplname")
    private String psdcmodeltemplname;
    @Column(name="psdcmtdefscnt")
    private Integer psdcmtdefscnt;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="tableprefix")
    private String tableprefix;
    @Column(name="tableprefixflag")
    private Integer tableprefixflag;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="view2prefix")
    private String view2prefix;
    @Column(name="view3prefix")
    private String view3prefix;
    @Column(name="view4prefix")
    private String view4prefix;
    @Column(name="viewprefix")
    private String viewprefix;
    @Column(name="viewprefixflag")
    private Integer viewprefixflag;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;
    private Integer objPSDCMTDEFsLock = new Integer(1);
    private ArrayList<PSDCMTDEF> psdcmtdefs = null;

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

    public void setDEFNameMaxLength(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEFNameMaxLength(n);
            return;
        }
        this.defnamemaxlength = n;
        this.defnamemaxlengthDirtyFlag = true;
    }

    public Integer getDEFNameMaxLength() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEFNameMaxLength();
        }
        return this.defnamemaxlength;
    }

    public boolean isDEFNameMaxLengthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEFNameMaxLengthDirty();
        }
        return this.defnamemaxlengthDirtyFlag;
    }

    public void resetDEFNameMaxLength() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEFNameMaxLength();
            return;
        }
        this.defnamemaxlengthDirtyFlag = false;
        this.defnamemaxlength = null;
    }

    public void setDENameMaxLength(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDENameMaxLength(n);
            return;
        }
        this.denamemaxlength = n;
        this.denamemaxlengthDirtyFlag = true;
    }

    public Integer getDENameMaxLength() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDENameMaxLength();
        }
        return this.denamemaxlength;
    }

    public boolean isDENameMaxLengthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDENameMaxLengthDirty();
        }
        return this.denamemaxlengthDirtyFlag;
    }

    public void resetDENameMaxLength() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDENameMaxLength();
            return;
        }
        this.denamemaxlengthDirtyFlag = false;
        this.denamemaxlength = null;
    }

    public void setIgnoreDefaultFields(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIgnoreDefaultFields(n);
            return;
        }
        this.ignoredefaultfields = n;
        this.ignoredefaultfieldsDirtyFlag = true;
    }

    public Integer getIgnoreDefaultFields() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIgnoreDefaultFields();
        }
        return this.ignoredefaultfields;
    }

    public boolean isIgnoreDefaultFieldsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIgnoreDefaultFieldsDirty();
        }
        return this.ignoredefaultfieldsDirtyFlag;
    }

    public void resetIgnoreDefaultFields() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIgnoreDefaultFields();
            return;
        }
        this.ignoredefaultfieldsDirtyFlag = false;
        this.ignoredefaultfields = null;
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

    public void setPSDCModelTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCModelTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmodeltemplid = string;
        this.psdcmodeltemplidDirtyFlag = true;
    }

    public String getPSDCModelTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCModelTemplId();
        }
        return this.psdcmodeltemplid;
    }

    public boolean isPSDCModelTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCModelTemplIdDirty();
        }
        return this.psdcmodeltemplidDirtyFlag;
    }

    public void resetPSDCModelTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCModelTemplId();
            return;
        }
        this.psdcmodeltemplidDirtyFlag = false;
        this.psdcmodeltemplid = null;
    }

    public void setPSDCModelTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCModelTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmodeltemplname = string;
        this.psdcmodeltemplnameDirtyFlag = true;
    }

    public String getPSDCModelTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCModelTemplName();
        }
        return this.psdcmodeltemplname;
    }

    public boolean isPSDCModelTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCModelTemplNameDirty();
        }
        return this.psdcmodeltemplnameDirtyFlag;
    }

    public void resetPSDCModelTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCModelTemplName();
            return;
        }
        this.psdcmodeltemplnameDirtyFlag = false;
        this.psdcmodeltemplname = null;
    }

    public void setPSDCMTDEFsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCMTDEFsCnt(n);
            return;
        }
        this.psdcmtdefscnt = n;
        this.psdcmtdefscntDirtyFlag = true;
    }

    public Integer getPSDCMTDEFsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMTDEFsCnt();
        }
        return this.psdcmtdefscnt;
    }

    public boolean isPSDCMTDEFsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCMTDEFsCntDirty();
        }
        return this.psdcmtdefscntDirtyFlag;
    }

    public void resetPSDCMTDEFsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCMTDEFsCnt();
            return;
        }
        this.psdcmtdefscntDirtyFlag = false;
        this.psdcmtdefscnt = null;
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

    public void setPSDevSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnid = string;
        this.psdevslnidDirtyFlag = true;
    }

    public String getPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnId();
        }
        return this.psdevslnid;
    }

    public boolean isPSDevSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnIdDirty();
        }
        return this.psdevslnidDirtyFlag;
    }

    public void resetPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnId();
            return;
        }
        this.psdevslnidDirtyFlag = false;
        this.psdevslnid = null;
    }

    public void setPSDevSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnname = string;
        this.psdevslnnameDirtyFlag = true;
    }

    public String getPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnName();
        }
        return this.psdevslnname;
    }

    public boolean isPSDevSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnNameDirty();
        }
        return this.psdevslnnameDirtyFlag;
    }

    public void resetPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnName();
            return;
        }
        this.psdevslnnameDirtyFlag = false;
        this.psdevslnname = null;
    }

    public void setTablePrefix(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTablePrefix(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tableprefix = string;
        this.tableprefixDirtyFlag = true;
    }

    public String getTablePrefix() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTablePrefix();
        }
        return this.tableprefix;
    }

    public boolean isTablePrefixDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTablePrefixDirty();
        }
        return this.tableprefixDirtyFlag;
    }

    public void resetTablePrefix() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTablePrefix();
            return;
        }
        this.tableprefixDirtyFlag = false;
        this.tableprefix = null;
    }

    public void setTablePrefixFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTablePrefixFlag(n);
            return;
        }
        this.tableprefixflag = n;
        this.tableprefixflagDirtyFlag = true;
    }

    public Integer getTablePrefixFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTablePrefixFlag();
        }
        return this.tableprefixflag;
    }

    public boolean isTablePrefixFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTablePrefixFlagDirty();
        }
        return this.tableprefixflagDirtyFlag;
    }

    public void resetTablePrefixFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTablePrefixFlag();
            return;
        }
        this.tableprefixflagDirtyFlag = false;
        this.tableprefixflag = null;
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

    public void setView2Prefix(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setView2Prefix(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.view2prefix = string;
        this.view2prefixDirtyFlag = true;
    }

    public String getView2Prefix() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getView2Prefix();
        }
        return this.view2prefix;
    }

    public boolean isView2PrefixDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isView2PrefixDirty();
        }
        return this.view2prefixDirtyFlag;
    }

    public void resetView2Prefix() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetView2Prefix();
            return;
        }
        this.view2prefixDirtyFlag = false;
        this.view2prefix = null;
    }

    public void setView3Prefix(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setView3Prefix(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.view3prefix = string;
        this.view3prefixDirtyFlag = true;
    }

    public String getView3Prefix() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getView3Prefix();
        }
        return this.view3prefix;
    }

    public boolean isView3PrefixDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isView3PrefixDirty();
        }
        return this.view3prefixDirtyFlag;
    }

    public void resetView3Prefix() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetView3Prefix();
            return;
        }
        this.view3prefixDirtyFlag = false;
        this.view3prefix = null;
    }

    public void setView4Prefix(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setView4Prefix(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.view4prefix = string;
        this.view4prefixDirtyFlag = true;
    }

    public String getView4Prefix() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getView4Prefix();
        }
        return this.view4prefix;
    }

    public boolean isView4PrefixDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isView4PrefixDirty();
        }
        return this.view4prefixDirtyFlag;
    }

    public void resetView4Prefix() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetView4Prefix();
            return;
        }
        this.view4prefixDirtyFlag = false;
        this.view4prefix = null;
    }

    public void setViewPrefix(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewPrefix(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewprefix = string;
        this.viewprefixDirtyFlag = true;
    }

    public String getViewPrefix() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewPrefix();
        }
        return this.viewprefix;
    }

    public boolean isViewPrefixDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewPrefixDirty();
        }
        return this.viewprefixDirtyFlag;
    }

    public void resetViewPrefix() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewPrefix();
            return;
        }
        this.viewprefixDirtyFlag = false;
        this.viewprefix = null;
    }

    public void setViewPrefixFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewPrefixFlag(n);
            return;
        }
        this.viewprefixflag = n;
        this.viewprefixflagDirtyFlag = true;
    }

    public Integer getViewPrefixFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewPrefixFlag();
        }
        return this.viewprefixflag;
    }

    public boolean isViewPrefixFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewPrefixFlagDirty();
        }
        return this.viewprefixflagDirtyFlag;
    }

    public void resetViewPrefixFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewPrefixFlag();
            return;
        }
        this.viewprefixflagDirtyFlag = false;
        this.viewprefixflag = null;
    }

    protected void onReset() {
        PSDCModelTemplBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCModelTemplBase pSDCModelTemplBase) {
        pSDCModelTemplBase.resetCreateDate();
        pSDCModelTemplBase.resetCreateMan();
        pSDCModelTemplBase.resetDEFNameMaxLength();
        pSDCModelTemplBase.resetDENameMaxLength();
        pSDCModelTemplBase.resetIgnoreDefaultFields();
        pSDCModelTemplBase.resetMemo();
        pSDCModelTemplBase.resetPSDCModelTemplId();
        pSDCModelTemplBase.resetPSDCModelTemplName();
        pSDCModelTemplBase.resetPSDCMTDEFsCnt();
        pSDCModelTemplBase.resetPSDevCenterId();
        pSDCModelTemplBase.resetPSDevCenterName();
        pSDCModelTemplBase.resetPSDevSlnId();
        pSDCModelTemplBase.resetPSDevSlnName();
        pSDCModelTemplBase.resetTablePrefix();
        pSDCModelTemplBase.resetTablePrefixFlag();
        pSDCModelTemplBase.resetUpdateDate();
        pSDCModelTemplBase.resetUpdateMan();
        pSDCModelTemplBase.resetView2Prefix();
        pSDCModelTemplBase.resetView3Prefix();
        pSDCModelTemplBase.resetView4Prefix();
        pSDCModelTemplBase.resetViewPrefix();
        pSDCModelTemplBase.resetViewPrefixFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDEFNameMaxLengthDirty()) {
            hashMap.put(FIELD_DEFNAMEMAXLENGTH, this.getDEFNameMaxLength());
        }
        if (!bl || this.isDENameMaxLengthDirty()) {
            hashMap.put(FIELD_DENAMEMAXLENGTH, this.getDENameMaxLength());
        }
        if (!bl || this.isIgnoreDefaultFieldsDirty()) {
            hashMap.put(FIELD_IGNOREDEFAULTFIELDS, this.getIgnoreDefaultFields());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDCModelTemplIdDirty()) {
            hashMap.put(FIELD_PSDCMODELTEMPLID, this.getPSDCModelTemplId());
        }
        if (!bl || this.isPSDCModelTemplNameDirty()) {
            hashMap.put(FIELD_PSDCMODELTEMPLNAME, this.getPSDCModelTemplName());
        }
        if (!bl || this.isPSDCMTDEFsCntDirty()) {
            hashMap.put(FIELD_PSDCMTDEFSCNT, this.getPSDCMTDEFsCnt());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNNAME, this.getPSDevSlnName());
        }
        if (!bl || this.isTablePrefixDirty()) {
            hashMap.put(FIELD_TABLEPREFIX, this.getTablePrefix());
        }
        if (!bl || this.isTablePrefixFlagDirty()) {
            hashMap.put(FIELD_TABLEPREFIXFLAG, this.getTablePrefixFlag());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isView2PrefixDirty()) {
            hashMap.put(FIELD_VIEW2PREFIX, this.getView2Prefix());
        }
        if (!bl || this.isView3PrefixDirty()) {
            hashMap.put(FIELD_VIEW3PREFIX, this.getView3Prefix());
        }
        if (!bl || this.isView4PrefixDirty()) {
            hashMap.put(FIELD_VIEW4PREFIX, this.getView4Prefix());
        }
        if (!bl || this.isViewPrefixDirty()) {
            hashMap.put(FIELD_VIEWPREFIX, this.getViewPrefix());
        }
        if (!bl || this.isViewPrefixFlagDirty()) {
            hashMap.put(FIELD_VIEWPREFIXFLAG, this.getViewPrefixFlag());
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
        return PSDCModelTemplBase.get(this, n);
    }

    private static Object get(PSDCModelTemplBase pSDCModelTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCModelTemplBase.getCreateDate();
            }
            case 1: {
                return pSDCModelTemplBase.getCreateMan();
            }
            case 2: {
                return pSDCModelTemplBase.getDEFNameMaxLength();
            }
            case 3: {
                return pSDCModelTemplBase.getDENameMaxLength();
            }
            case 4: {
                return pSDCModelTemplBase.getIgnoreDefaultFields();
            }
            case 5: {
                return pSDCModelTemplBase.getMemo();
            }
            case 6: {
                return pSDCModelTemplBase.getPSDCModelTemplId();
            }
            case 7: {
                return pSDCModelTemplBase.getPSDCModelTemplName();
            }
            case 8: {
                return pSDCModelTemplBase.getPSDCMTDEFsCnt();
            }
            case 9: {
                return pSDCModelTemplBase.getPSDevCenterId();
            }
            case 10: {
                return pSDCModelTemplBase.getPSDevCenterName();
            }
            case 11: {
                return pSDCModelTemplBase.getPSDevSlnId();
            }
            case 12: {
                return pSDCModelTemplBase.getPSDevSlnName();
            }
            case 13: {
                return pSDCModelTemplBase.getTablePrefix();
            }
            case 14: {
                return pSDCModelTemplBase.getTablePrefixFlag();
            }
            case 15: {
                return pSDCModelTemplBase.getUpdateDate();
            }
            case 16: {
                return pSDCModelTemplBase.getUpdateMan();
            }
            case 17: {
                return pSDCModelTemplBase.getView2Prefix();
            }
            case 18: {
                return pSDCModelTemplBase.getView3Prefix();
            }
            case 19: {
                return pSDCModelTemplBase.getView4Prefix();
            }
            case 20: {
                return pSDCModelTemplBase.getViewPrefix();
            }
            case 21: {
                return pSDCModelTemplBase.getViewPrefixFlag();
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
        PSDCModelTemplBase.set(this, n, object);
    }

    private static void set(PSDCModelTemplBase pSDCModelTemplBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCModelTemplBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCModelTemplBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCModelTemplBase.setDEFNameMaxLength(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDCModelTemplBase.setDENameMaxLength(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDCModelTemplBase.setIgnoreDefaultFields(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDCModelTemplBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCModelTemplBase.setPSDCModelTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCModelTemplBase.setPSDCModelTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCModelTemplBase.setPSDCMTDEFsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDCModelTemplBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCModelTemplBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCModelTemplBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCModelTemplBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCModelTemplBase.setTablePrefix(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCModelTemplBase.setTablePrefixFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSDCModelTemplBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 16: {
                pSDCModelTemplBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDCModelTemplBase.setView2Prefix(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDCModelTemplBase.setView3Prefix(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDCModelTemplBase.setView4Prefix(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDCModelTemplBase.setViewPrefix(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDCModelTemplBase.setViewPrefixFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDCModelTemplBase.isNull(this, n);
    }

    private static boolean isNull(PSDCModelTemplBase pSDCModelTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCModelTemplBase.getCreateDate() == null;
            }
            case 1: {
                return pSDCModelTemplBase.getCreateMan() == null;
            }
            case 2: {
                return pSDCModelTemplBase.getDEFNameMaxLength() == null;
            }
            case 3: {
                return pSDCModelTemplBase.getDENameMaxLength() == null;
            }
            case 4: {
                return pSDCModelTemplBase.getIgnoreDefaultFields() == null;
            }
            case 5: {
                return pSDCModelTemplBase.getMemo() == null;
            }
            case 6: {
                return pSDCModelTemplBase.getPSDCModelTemplId() == null;
            }
            case 7: {
                return pSDCModelTemplBase.getPSDCModelTemplName() == null;
            }
            case 8: {
                return pSDCModelTemplBase.getPSDCMTDEFsCnt() == null;
            }
            case 9: {
                return pSDCModelTemplBase.getPSDevCenterId() == null;
            }
            case 10: {
                return pSDCModelTemplBase.getPSDevCenterName() == null;
            }
            case 11: {
                return pSDCModelTemplBase.getPSDevSlnId() == null;
            }
            case 12: {
                return pSDCModelTemplBase.getPSDevSlnName() == null;
            }
            case 13: {
                return pSDCModelTemplBase.getTablePrefix() == null;
            }
            case 14: {
                return pSDCModelTemplBase.getTablePrefixFlag() == null;
            }
            case 15: {
                return pSDCModelTemplBase.getUpdateDate() == null;
            }
            case 16: {
                return pSDCModelTemplBase.getUpdateMan() == null;
            }
            case 17: {
                return pSDCModelTemplBase.getView2Prefix() == null;
            }
            case 18: {
                return pSDCModelTemplBase.getView3Prefix() == null;
            }
            case 19: {
                return pSDCModelTemplBase.getView4Prefix() == null;
            }
            case 20: {
                return pSDCModelTemplBase.getViewPrefix() == null;
            }
            case 21: {
                return pSDCModelTemplBase.getViewPrefixFlag() == null;
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
        return PSDCModelTemplBase.contains(this, n);
    }

    private static boolean contains(PSDCModelTemplBase pSDCModelTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCModelTemplBase.isCreateDateDirty();
            }
            case 1: {
                return pSDCModelTemplBase.isCreateManDirty();
            }
            case 2: {
                return pSDCModelTemplBase.isDEFNameMaxLengthDirty();
            }
            case 3: {
                return pSDCModelTemplBase.isDENameMaxLengthDirty();
            }
            case 4: {
                return pSDCModelTemplBase.isIgnoreDefaultFieldsDirty();
            }
            case 5: {
                return pSDCModelTemplBase.isMemoDirty();
            }
            case 6: {
                return pSDCModelTemplBase.isPSDCModelTemplIdDirty();
            }
            case 7: {
                return pSDCModelTemplBase.isPSDCModelTemplNameDirty();
            }
            case 8: {
                return pSDCModelTemplBase.isPSDCMTDEFsCntDirty();
            }
            case 9: {
                return pSDCModelTemplBase.isPSDevCenterIdDirty();
            }
            case 10: {
                return pSDCModelTemplBase.isPSDevCenterNameDirty();
            }
            case 11: {
                return pSDCModelTemplBase.isPSDevSlnIdDirty();
            }
            case 12: {
                return pSDCModelTemplBase.isPSDevSlnNameDirty();
            }
            case 13: {
                return pSDCModelTemplBase.isTablePrefixDirty();
            }
            case 14: {
                return pSDCModelTemplBase.isTablePrefixFlagDirty();
            }
            case 15: {
                return pSDCModelTemplBase.isUpdateDateDirty();
            }
            case 16: {
                return pSDCModelTemplBase.isUpdateManDirty();
            }
            case 17: {
                return pSDCModelTemplBase.isView2PrefixDirty();
            }
            case 18: {
                return pSDCModelTemplBase.isView3PrefixDirty();
            }
            case 19: {
                return pSDCModelTemplBase.isView4PrefixDirty();
            }
            case 20: {
                return pSDCModelTemplBase.isViewPrefixDirty();
            }
            case 21: {
                return pSDCModelTemplBase.isViewPrefixFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCModelTemplBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCModelTemplBase pSDCModelTemplBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCModelTemplBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCModelTemplBase.getJSONValue((Object)pSDCModelTemplBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCModelTemplBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCModelTemplBase.getJSONValue((Object)pSDCModelTemplBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCModelTemplBase.getDEFNameMaxLength() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defnamemaxlength", (Object)PSDCModelTemplBase.getJSONValue((Object)pSDCModelTemplBase.getDEFNameMaxLength()), (boolean)false);
        }
        if (bl || pSDCModelTemplBase.getDENameMaxLength() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"denamemaxlength", (Object)PSDCModelTemplBase.getJSONValue((Object)pSDCModelTemplBase.getDENameMaxLength()), (boolean)false);
        }
        if (bl || pSDCModelTemplBase.getIgnoreDefaultFields() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ignoredefaultfields", (Object)PSDCModelTemplBase.getJSONValue((Object)pSDCModelTemplBase.getIgnoreDefaultFields()), (boolean)false);
        }
        if (bl || pSDCModelTemplBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCModelTemplBase.getJSONValue((Object)pSDCModelTemplBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCModelTemplBase.getPSDCModelTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmodeltemplid", (Object)PSDCModelTemplBase.getJSONValue((Object)pSDCModelTemplBase.getPSDCModelTemplId()), (boolean)false);
        }
        if (bl || pSDCModelTemplBase.getPSDCModelTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmodeltemplname", (Object)PSDCModelTemplBase.getJSONValue((Object)pSDCModelTemplBase.getPSDCModelTemplName()), (boolean)false);
        }
        if (bl || pSDCModelTemplBase.getPSDCMTDEFsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmtdefscnt", (Object)PSDCModelTemplBase.getJSONValue((Object)pSDCModelTemplBase.getPSDCMTDEFsCnt()), (boolean)false);
        }
        if (bl || pSDCModelTemplBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCModelTemplBase.getJSONValue((Object)pSDCModelTemplBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCModelTemplBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCModelTemplBase.getJSONValue((Object)pSDCModelTemplBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCModelTemplBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDCModelTemplBase.getJSONValue((Object)pSDCModelTemplBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDCModelTemplBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDCModelTemplBase.getJSONValue((Object)pSDCModelTemplBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDCModelTemplBase.getTablePrefix() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tableprefix", (Object)PSDCModelTemplBase.getJSONValue((Object)pSDCModelTemplBase.getTablePrefix()), (boolean)false);
        }
        if (bl || pSDCModelTemplBase.getTablePrefixFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tableprefixflag", (Object)PSDCModelTemplBase.getJSONValue((Object)pSDCModelTemplBase.getTablePrefixFlag()), (boolean)false);
        }
        if (bl || pSDCModelTemplBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCModelTemplBase.getJSONValue((Object)pSDCModelTemplBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCModelTemplBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCModelTemplBase.getJSONValue((Object)pSDCModelTemplBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCModelTemplBase.getView2Prefix() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"view2prefix", (Object)PSDCModelTemplBase.getJSONValue((Object)pSDCModelTemplBase.getView2Prefix()), (boolean)false);
        }
        if (bl || pSDCModelTemplBase.getView3Prefix() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"view3prefix", (Object)PSDCModelTemplBase.getJSONValue((Object)pSDCModelTemplBase.getView3Prefix()), (boolean)false);
        }
        if (bl || pSDCModelTemplBase.getView4Prefix() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"view4prefix", (Object)PSDCModelTemplBase.getJSONValue((Object)pSDCModelTemplBase.getView4Prefix()), (boolean)false);
        }
        if (bl || pSDCModelTemplBase.getViewPrefix() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewprefix", (Object)PSDCModelTemplBase.getJSONValue((Object)pSDCModelTemplBase.getViewPrefix()), (boolean)false);
        }
        if (bl || pSDCModelTemplBase.getViewPrefixFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewprefixflag", (Object)PSDCModelTemplBase.getJSONValue((Object)pSDCModelTemplBase.getViewPrefixFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCModelTemplBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCModelTemplBase pSDCModelTemplBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCModelTemplBase.getCreateDate() != null) {
            object = pSDCModelTemplBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCModelTemplBase.getCreateMan() != null) {
            object = pSDCModelTemplBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCModelTemplBase.getDEFNameMaxLength() != null) {
            object = pSDCModelTemplBase.getDEFNameMaxLength();
            xmlNode.setAttribute(FIELD_DEFNAMEMAXLENGTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCModelTemplBase.getDENameMaxLength() != null) {
            object = pSDCModelTemplBase.getDENameMaxLength();
            xmlNode.setAttribute(FIELD_DENAMEMAXLENGTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCModelTemplBase.getIgnoreDefaultFields() != null) {
            object = pSDCModelTemplBase.getIgnoreDefaultFields();
            xmlNode.setAttribute(FIELD_IGNOREDEFAULTFIELDS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCModelTemplBase.getMemo() != null) {
            object = pSDCModelTemplBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCModelTemplBase.getPSDCModelTemplId() != null) {
            object = pSDCModelTemplBase.getPSDCModelTemplId();
            xmlNode.setAttribute(FIELD_PSDCMODELTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSDCModelTemplBase.getPSDCModelTemplName() != null) {
            object = pSDCModelTemplBase.getPSDCModelTemplName();
            xmlNode.setAttribute(FIELD_PSDCMODELTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCModelTemplBase.getPSDCMTDEFsCnt() != null) {
            object = pSDCModelTemplBase.getPSDCMTDEFsCnt();
            xmlNode.setAttribute(FIELD_PSDCMTDEFSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCModelTemplBase.getPSDevCenterId() != null) {
            object = pSDCModelTemplBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCModelTemplBase.getPSDevCenterName() != null) {
            object = pSDCModelTemplBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCModelTemplBase.getPSDevSlnId() != null) {
            object = pSDCModelTemplBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDCModelTemplBase.getPSDevSlnName() != null) {
            object = pSDCModelTemplBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCModelTemplBase.getTablePrefix() != null) {
            object = pSDCModelTemplBase.getTablePrefix();
            xmlNode.setAttribute(FIELD_TABLEPREFIX, object == null ? "" : (String)object);
        }
        if (bl || pSDCModelTemplBase.getTablePrefixFlag() != null) {
            object = pSDCModelTemplBase.getTablePrefixFlag();
            xmlNode.setAttribute(FIELD_TABLEPREFIXFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCModelTemplBase.getUpdateDate() != null) {
            object = pSDCModelTemplBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCModelTemplBase.getUpdateMan() != null) {
            object = pSDCModelTemplBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCModelTemplBase.getView2Prefix() != null) {
            object = pSDCModelTemplBase.getView2Prefix();
            xmlNode.setAttribute(FIELD_VIEW2PREFIX, object == null ? "" : (String)object);
        }
        if (bl || pSDCModelTemplBase.getView3Prefix() != null) {
            object = pSDCModelTemplBase.getView3Prefix();
            xmlNode.setAttribute(FIELD_VIEW3PREFIX, object == null ? "" : (String)object);
        }
        if (bl || pSDCModelTemplBase.getView4Prefix() != null) {
            object = pSDCModelTemplBase.getView4Prefix();
            xmlNode.setAttribute(FIELD_VIEW4PREFIX, object == null ? "" : (String)object);
        }
        if (bl || pSDCModelTemplBase.getViewPrefix() != null) {
            object = pSDCModelTemplBase.getViewPrefix();
            xmlNode.setAttribute(FIELD_VIEWPREFIX, object == null ? "" : (String)object);
        }
        if (bl || pSDCModelTemplBase.getViewPrefixFlag() != null) {
            object = pSDCModelTemplBase.getViewPrefixFlag();
            xmlNode.setAttribute(FIELD_VIEWPREFIXFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCModelTemplBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCModelTemplBase pSDCModelTemplBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCModelTemplBase.isCreateDateDirty() && (bl || pSDCModelTemplBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCModelTemplBase.getCreateDate());
        }
        if (pSDCModelTemplBase.isCreateManDirty() && (bl || pSDCModelTemplBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCModelTemplBase.getCreateMan());
        }
        if (pSDCModelTemplBase.isDEFNameMaxLengthDirty() && (bl || pSDCModelTemplBase.getDEFNameMaxLength() != null)) {
            iDataObject.set(FIELD_DEFNAMEMAXLENGTH, (Object)pSDCModelTemplBase.getDEFNameMaxLength());
        }
        if (pSDCModelTemplBase.isDENameMaxLengthDirty() && (bl || pSDCModelTemplBase.getDENameMaxLength() != null)) {
            iDataObject.set(FIELD_DENAMEMAXLENGTH, (Object)pSDCModelTemplBase.getDENameMaxLength());
        }
        if (pSDCModelTemplBase.isIgnoreDefaultFieldsDirty() && (bl || pSDCModelTemplBase.getIgnoreDefaultFields() != null)) {
            iDataObject.set(FIELD_IGNOREDEFAULTFIELDS, (Object)pSDCModelTemplBase.getIgnoreDefaultFields());
        }
        if (pSDCModelTemplBase.isMemoDirty() && (bl || pSDCModelTemplBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCModelTemplBase.getMemo());
        }
        if (pSDCModelTemplBase.isPSDCModelTemplIdDirty() && (bl || pSDCModelTemplBase.getPSDCModelTemplId() != null)) {
            iDataObject.set(FIELD_PSDCMODELTEMPLID, (Object)pSDCModelTemplBase.getPSDCModelTemplId());
        }
        if (pSDCModelTemplBase.isPSDCModelTemplNameDirty() && (bl || pSDCModelTemplBase.getPSDCModelTemplName() != null)) {
            iDataObject.set(FIELD_PSDCMODELTEMPLNAME, (Object)pSDCModelTemplBase.getPSDCModelTemplName());
        }
        if (pSDCModelTemplBase.isPSDCMTDEFsCntDirty() && (bl || pSDCModelTemplBase.getPSDCMTDEFsCnt() != null)) {
            iDataObject.set(FIELD_PSDCMTDEFSCNT, (Object)pSDCModelTemplBase.getPSDCMTDEFsCnt());
        }
        if (pSDCModelTemplBase.isPSDevCenterIdDirty() && (bl || pSDCModelTemplBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCModelTemplBase.getPSDevCenterId());
        }
        if (pSDCModelTemplBase.isPSDevCenterNameDirty() && (bl || pSDCModelTemplBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCModelTemplBase.getPSDevCenterName());
        }
        if (pSDCModelTemplBase.isPSDevSlnIdDirty() && (bl || pSDCModelTemplBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDCModelTemplBase.getPSDevSlnId());
        }
        if (pSDCModelTemplBase.isPSDevSlnNameDirty() && (bl || pSDCModelTemplBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDCModelTemplBase.getPSDevSlnName());
        }
        if (pSDCModelTemplBase.isTablePrefixDirty() && (bl || pSDCModelTemplBase.getTablePrefix() != null)) {
            iDataObject.set(FIELD_TABLEPREFIX, (Object)pSDCModelTemplBase.getTablePrefix());
        }
        if (pSDCModelTemplBase.isTablePrefixFlagDirty() && (bl || pSDCModelTemplBase.getTablePrefixFlag() != null)) {
            iDataObject.set(FIELD_TABLEPREFIXFLAG, (Object)pSDCModelTemplBase.getTablePrefixFlag());
        }
        if (pSDCModelTemplBase.isUpdateDateDirty() && (bl || pSDCModelTemplBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCModelTemplBase.getUpdateDate());
        }
        if (pSDCModelTemplBase.isUpdateManDirty() && (bl || pSDCModelTemplBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCModelTemplBase.getUpdateMan());
        }
        if (pSDCModelTemplBase.isView2PrefixDirty() && (bl || pSDCModelTemplBase.getView2Prefix() != null)) {
            iDataObject.set(FIELD_VIEW2PREFIX, (Object)pSDCModelTemplBase.getView2Prefix());
        }
        if (pSDCModelTemplBase.isView3PrefixDirty() && (bl || pSDCModelTemplBase.getView3Prefix() != null)) {
            iDataObject.set(FIELD_VIEW3PREFIX, (Object)pSDCModelTemplBase.getView3Prefix());
        }
        if (pSDCModelTemplBase.isView4PrefixDirty() && (bl || pSDCModelTemplBase.getView4Prefix() != null)) {
            iDataObject.set(FIELD_VIEW4PREFIX, (Object)pSDCModelTemplBase.getView4Prefix());
        }
        if (pSDCModelTemplBase.isViewPrefixDirty() && (bl || pSDCModelTemplBase.getViewPrefix() != null)) {
            iDataObject.set(FIELD_VIEWPREFIX, (Object)pSDCModelTemplBase.getViewPrefix());
        }
        if (pSDCModelTemplBase.isViewPrefixFlagDirty() && (bl || pSDCModelTemplBase.getViewPrefixFlag() != null)) {
            iDataObject.set(FIELD_VIEWPREFIXFLAG, (Object)pSDCModelTemplBase.getViewPrefixFlag());
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
        return PSDCModelTemplBase.remove(this, n);
    }

    private static boolean remove(PSDCModelTemplBase pSDCModelTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCModelTemplBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDCModelTemplBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDCModelTemplBase.resetDEFNameMaxLength();
                return true;
            }
            case 3: {
                pSDCModelTemplBase.resetDENameMaxLength();
                return true;
            }
            case 4: {
                pSDCModelTemplBase.resetIgnoreDefaultFields();
                return true;
            }
            case 5: {
                pSDCModelTemplBase.resetMemo();
                return true;
            }
            case 6: {
                pSDCModelTemplBase.resetPSDCModelTemplId();
                return true;
            }
            case 7: {
                pSDCModelTemplBase.resetPSDCModelTemplName();
                return true;
            }
            case 8: {
                pSDCModelTemplBase.resetPSDCMTDEFsCnt();
                return true;
            }
            case 9: {
                pSDCModelTemplBase.resetPSDevCenterId();
                return true;
            }
            case 10: {
                pSDCModelTemplBase.resetPSDevCenterName();
                return true;
            }
            case 11: {
                pSDCModelTemplBase.resetPSDevSlnId();
                return true;
            }
            case 12: {
                pSDCModelTemplBase.resetPSDevSlnName();
                return true;
            }
            case 13: {
                pSDCModelTemplBase.resetTablePrefix();
                return true;
            }
            case 14: {
                pSDCModelTemplBase.resetTablePrefixFlag();
                return true;
            }
            case 15: {
                pSDCModelTemplBase.resetUpdateDate();
                return true;
            }
            case 16: {
                pSDCModelTemplBase.resetUpdateMan();
                return true;
            }
            case 17: {
                pSDCModelTemplBase.resetView2Prefix();
                return true;
            }
            case 18: {
                pSDCModelTemplBase.resetView3Prefix();
                return true;
            }
            case 19: {
                pSDCModelTemplBase.resetView4Prefix();
                return true;
            }
            case 20: {
                pSDCModelTemplBase.resetViewPrefix();
                return true;
            }
            case 21: {
                pSDCModelTemplBase.resetViewPrefixFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
                pSDevCenterService.autoGet(pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSln getPSDevSln() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSln();
        }
        if (this.getPSDevSlnId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnLock;
        synchronized (n) {
            if (this.psdevsln != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnId(), (Object)this.psdevsln.getPSDevSlnId()) != 0L) {
                this.psdevsln = null;
            }
            if (this.psdevsln == null) {
                PSDevSln pSDevSln = new PSDevSln();
                pSDevSln.setPSDevSlnId(this.getPSDevSlnId());
                PSDevSlnService pSDevSlnService = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnService.autoGet(pSDevSln);
                this.psdevsln = pSDevSln;
            }
            return this.psdevsln;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDCMTDEF> getPSDCMTDEFs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMTDEFs();
        }
        if (this.getPSDCModelTemplId() == null) {
            return null;
        }
        PSDCMTDEFService pSDCMTDEFService = (PSDCMTDEFService)ServiceGlobal.getService(PSDCMTDEFService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDCMTDEFsLock;
        synchronized (n) {
            if (this.psdcmtdefs == null) {
                this.psdcmtdefs = pSDCMTDEFService.selectByPSDCModelTempl(this);
            }
            return this.psdcmtdefs;
        }
    }

    private PSDCModelTemplBase getProxyEntity() {
        return this.proxyPSDCModelTemplBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCModelTemplBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCModelTemplBase) {
            this.proxyPSDCModelTemplBase = (PSDCModelTemplBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCModelTemplService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DEFNAMEMAXLENGTH, 2);
        fieldIndexMap.put(FIELD_DENAMEMAXLENGTH, 3);
        fieldIndexMap.put(FIELD_IGNOREDEFAULTFIELDS, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSDCMODELTEMPLID, 6);
        fieldIndexMap.put(FIELD_PSDCMODELTEMPLNAME, 7);
        fieldIndexMap.put(FIELD_PSDCMTDEFSCNT, 8);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 9);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 10);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 11);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 12);
        fieldIndexMap.put(FIELD_TABLEPREFIX, 13);
        fieldIndexMap.put(FIELD_TABLEPREFIXFLAG, 14);
        fieldIndexMap.put(FIELD_UPDATEDATE, 15);
        fieldIndexMap.put(FIELD_UPDATEMAN, 16);
        fieldIndexMap.put(FIELD_VIEW2PREFIX, 17);
        fieldIndexMap.put(FIELD_VIEW3PREFIX, 18);
        fieldIndexMap.put(FIELD_VIEW4PREFIX, 19);
        fieldIndexMap.put(FIELD_VIEWPREFIX, 20);
        fieldIndexMap.put(FIELD_VIEWPREFIXFLAG, 21);
    }
}

