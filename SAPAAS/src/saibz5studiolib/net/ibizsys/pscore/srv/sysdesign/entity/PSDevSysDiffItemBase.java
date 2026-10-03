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
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSysDiffItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSysDiffRep;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSysDiffItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSysDiffRepService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSysDiffItemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSysDiffItemBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DIFFTYPE = "DIFFTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_OBJTYPE = "OBJTYPE";
    public static final String FIELD_PPSDEVSYSDIFFITEMID = "PPSDEVSYSDIFFITEMID";
    public static final String FIELD_PPSDEVSYSDIFFITEMNAME = "PPSDEVSYSDIFFITEMNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDEVSYSDIFFITEMID = "PSDEVSYSDIFFITEMID";
    public static final String FIELD_PSDEVSYSDIFFITEMNAME = "PSDEVSYSDIFFITEMNAME";
    public static final String FIELD_PSDEVSYSDIFFREPID = "PSDEVSYSDIFFREPID";
    public static final String FIELD_PSDEVSYSDIFFREPNAME = "PSDEVSYSDIFFREPNAME";
    public static final String FIELD_PSOBJID = "PSOBJID";
    public static final String FIELD_PSOBJNAME = "PSOBJNAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_SYNCACTION = "SYNCACTION";
    public static final String FIELD_SYNCRESULT = "SYNCRESULT";
    public static final String FIELD_SYNCRESULTINFO = "SYNCRESULTINFO";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DIFFTYPE = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_OBJTYPE = 4;
    private static final int INDEX_PPSDEVSYSDIFFITEMID = 5;
    private static final int INDEX_PPSDEVSYSDIFFITEMNAME = 6;
    private static final int INDEX_PSDEID = 7;
    private static final int INDEX_PSDENAME = 8;
    private static final int INDEX_PSDEVSYSDIFFITEMID = 9;
    private static final int INDEX_PSDEVSYSDIFFITEMNAME = 10;
    private static final int INDEX_PSDEVSYSDIFFREPID = 11;
    private static final int INDEX_PSDEVSYSDIFFREPNAME = 12;
    private static final int INDEX_PSOBJID = 13;
    private static final int INDEX_PSOBJNAME = 14;
    private static final int INDEX_PSSYSAPPID = 15;
    private static final int INDEX_PSSYSAPPNAME = 16;
    private static final int INDEX_SYNCACTION = 17;
    private static final int INDEX_SYNCRESULT = 18;
    private static final int INDEX_SYNCRESULTINFO = 19;
    private static final int INDEX_UPDATEDATE = 20;
    private static final int INDEX_UPDATEMAN = 21;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSysDiffItemBase proxyPSDevSysDiffItemBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean difftypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean objtypeDirtyFlag = false;
    private boolean ppsdevsysdiffitemidDirtyFlag = false;
    private boolean ppsdevsysdiffitemnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdevsysdiffitemidDirtyFlag = false;
    private boolean psdevsysdiffitemnameDirtyFlag = false;
    private boolean psdevsysdiffrepidDirtyFlag = false;
    private boolean psdevsysdiffrepnameDirtyFlag = false;
    private boolean psobjidDirtyFlag = false;
    private boolean psobjnameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean syncactionDirtyFlag = false;
    private boolean syncresultDirtyFlag = false;
    private boolean syncresultinfoDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="difftype")
    private String difftype;
    @Column(name="memo")
    private String memo;
    @Column(name="objtype")
    private String objtype;
    @Column(name="ppsdevsysdiffitemid")
    private String ppsdevsysdiffitemid;
    @Column(name="ppsdevsysdiffitemname")
    private String ppsdevsysdiffitemname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdevsysdiffitemid")
    private String psdevsysdiffitemid;
    @Column(name="psdevsysdiffitemname")
    private String psdevsysdiffitemname;
    @Column(name="psdevsysdiffrepid")
    private String psdevsysdiffrepid;
    @Column(name="psdevsysdiffrepname")
    private String psdevsysdiffrepname;
    @Column(name="psobjid")
    private String psobjid;
    @Column(name="psobjname")
    private String psobjname;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="syncaction")
    private String syncaction;
    @Column(name="syncresult")
    private Integer syncresult;
    @Column(name="syncresultinfo")
    private String syncresultinfo;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPPSDevSysDiffItemLock = new Integer(1);
    private PSDevSysDiffItem ppsdevsysdiffitem = null;
    private Integer objPSDevSysDiffRepLock = new Integer(1);
    private PSDevSysDiffRep psdevsysdiffrep = null;

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

    public void setDiffType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDiffType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.difftype = string;
        this.difftypeDirtyFlag = true;
    }

    public String getDiffType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDiffType();
        }
        return this.difftype;
    }

    public boolean isDiffTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDiffTypeDirty();
        }
        return this.difftypeDirtyFlag;
    }

    public void resetDiffType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDiffType();
            return;
        }
        this.difftypeDirtyFlag = false;
        this.difftype = null;
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

    public void setObjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setObjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.objtype = string;
        this.objtypeDirtyFlag = true;
    }

    public String getObjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getObjType();
        }
        return this.objtype;
    }

    public boolean isObjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isObjTypeDirty();
        }
        return this.objtypeDirtyFlag;
    }

    public void resetObjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetObjType();
            return;
        }
        this.objtypeDirtyFlag = false;
        this.objtype = null;
    }

    public void setPPSDevSysDiffItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDevSysDiffItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdevsysdiffitemid = string;
        this.ppsdevsysdiffitemidDirtyFlag = true;
    }

    public String getPPSDevSysDiffItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDevSysDiffItemId();
        }
        return this.ppsdevsysdiffitemid;
    }

    public boolean isPPSDevSysDiffItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDevSysDiffItemIdDirty();
        }
        return this.ppsdevsysdiffitemidDirtyFlag;
    }

    public void resetPPSDevSysDiffItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDevSysDiffItemId();
            return;
        }
        this.ppsdevsysdiffitemidDirtyFlag = false;
        this.ppsdevsysdiffitemid = null;
    }

    public void setPPSDevSysDiffItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDevSysDiffItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdevsysdiffitemname = string;
        this.ppsdevsysdiffitemnameDirtyFlag = true;
    }

    public String getPPSDevSysDiffItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDevSysDiffItemName();
        }
        return this.ppsdevsysdiffitemname;
    }

    public boolean isPPSDevSysDiffItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDevSysDiffItemNameDirty();
        }
        return this.ppsdevsysdiffitemnameDirtyFlag;
    }

    public void resetPPSDevSysDiffItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDevSysDiffItemName();
            return;
        }
        this.ppsdevsysdiffitemnameDirtyFlag = false;
        this.ppsdevsysdiffitemname = null;
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

    public void setPSDevSysDiffItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSysDiffItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevsysdiffitemid = string;
        this.psdevsysdiffitemidDirtyFlag = true;
    }

    public String getPSDevSysDiffItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSysDiffItemId();
        }
        return this.psdevsysdiffitemid;
    }

    public boolean isPSDevSysDiffItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSysDiffItemIdDirty();
        }
        return this.psdevsysdiffitemidDirtyFlag;
    }

    public void resetPSDevSysDiffItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSysDiffItemId();
            return;
        }
        this.psdevsysdiffitemidDirtyFlag = false;
        this.psdevsysdiffitemid = null;
    }

    public void setPSDevSysDiffItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSysDiffItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevsysdiffitemname = string;
        this.psdevsysdiffitemnameDirtyFlag = true;
    }

    public String getPSDevSysDiffItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSysDiffItemName();
        }
        return this.psdevsysdiffitemname;
    }

    public boolean isPSDevSysDiffItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSysDiffItemNameDirty();
        }
        return this.psdevsysdiffitemnameDirtyFlag;
    }

    public void resetPSDevSysDiffItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSysDiffItemName();
            return;
        }
        this.psdevsysdiffitemnameDirtyFlag = false;
        this.psdevsysdiffitemname = null;
    }

    public void setPSDevSysDiffRepId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSysDiffRepId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevsysdiffrepid = string;
        this.psdevsysdiffrepidDirtyFlag = true;
    }

    public String getPSDevSysDiffRepId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSysDiffRepId();
        }
        return this.psdevsysdiffrepid;
    }

    public boolean isPSDevSysDiffRepIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSysDiffRepIdDirty();
        }
        return this.psdevsysdiffrepidDirtyFlag;
    }

    public void resetPSDevSysDiffRepId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSysDiffRepId();
            return;
        }
        this.psdevsysdiffrepidDirtyFlag = false;
        this.psdevsysdiffrepid = null;
    }

    public void setPSDevSysDiffRepName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSysDiffRepName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevsysdiffrepname = string;
        this.psdevsysdiffrepnameDirtyFlag = true;
    }

    public String getPSDevSysDiffRepName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSysDiffRepName();
        }
        return this.psdevsysdiffrepname;
    }

    public boolean isPSDevSysDiffRepNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSysDiffRepNameDirty();
        }
        return this.psdevsysdiffrepnameDirtyFlag;
    }

    public void resetPSDevSysDiffRepName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSysDiffRepName();
            return;
        }
        this.psdevsysdiffrepnameDirtyFlag = false;
        this.psdevsysdiffrepname = null;
    }

    public void setPSObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjid = string;
        this.psobjidDirtyFlag = true;
    }

    public String getPSObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjId();
        }
        return this.psobjid;
    }

    public boolean isPSObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjIdDirty();
        }
        return this.psobjidDirtyFlag;
    }

    public void resetPSObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjId();
            return;
        }
        this.psobjidDirtyFlag = false;
        this.psobjid = null;
    }

    public void setPSObjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjname = string;
        this.psobjnameDirtyFlag = true;
    }

    public String getPSObjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjName();
        }
        return this.psobjname;
    }

    public boolean isPSObjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjNameDirty();
        }
        return this.psobjnameDirtyFlag;
    }

    public void resetPSObjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjName();
            return;
        }
        this.psobjnameDirtyFlag = false;
        this.psobjname = null;
    }

    public void setPSSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappid = string;
        this.pssysappidDirtyFlag = true;
    }

    public String getPSSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppId();
        }
        return this.pssysappid;
    }

    public boolean isPSSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppIdDirty();
        }
        return this.pssysappidDirtyFlag;
    }

    public void resetPSSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppId();
            return;
        }
        this.pssysappidDirtyFlag = false;
        this.pssysappid = null;
    }

    public void setPSSysAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappname = string;
        this.pssysappnameDirtyFlag = true;
    }

    public String getPSSysAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppName();
        }
        return this.pssysappname;
    }

    public boolean isPSSysAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppNameDirty();
        }
        return this.pssysappnameDirtyFlag;
    }

    public void resetPSSysAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppName();
            return;
        }
        this.pssysappnameDirtyFlag = false;
        this.pssysappname = null;
    }

    public void setSyncAction(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSyncAction(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.syncaction = string;
        this.syncactionDirtyFlag = true;
    }

    public String getSyncAction() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSyncAction();
        }
        return this.syncaction;
    }

    public boolean isSyncActionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSyncActionDirty();
        }
        return this.syncactionDirtyFlag;
    }

    public void resetSyncAction() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSyncAction();
            return;
        }
        this.syncactionDirtyFlag = false;
        this.syncaction = null;
    }

    public void setSyncResult(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSyncResult(n);
            return;
        }
        this.syncresult = n;
        this.syncresultDirtyFlag = true;
    }

    public Integer getSyncResult() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSyncResult();
        }
        return this.syncresult;
    }

    public boolean isSyncResultDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSyncResultDirty();
        }
        return this.syncresultDirtyFlag;
    }

    public void resetSyncResult() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSyncResult();
            return;
        }
        this.syncresultDirtyFlag = false;
        this.syncresult = null;
    }

    public void setSyncResultInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSyncResultInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.syncresultinfo = string;
        this.syncresultinfoDirtyFlag = true;
    }

    public String getSyncResultInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSyncResultInfo();
        }
        return this.syncresultinfo;
    }

    public boolean isSyncResultInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSyncResultInfoDirty();
        }
        return this.syncresultinfoDirtyFlag;
    }

    public void resetSyncResultInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSyncResultInfo();
            return;
        }
        this.syncresultinfoDirtyFlag = false;
        this.syncresultinfo = null;
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
        PSDevSysDiffItemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSysDiffItemBase pSDevSysDiffItemBase) {
        pSDevSysDiffItemBase.resetCreateDate();
        pSDevSysDiffItemBase.resetCreateMan();
        pSDevSysDiffItemBase.resetDiffType();
        pSDevSysDiffItemBase.resetMemo();
        pSDevSysDiffItemBase.resetObjType();
        pSDevSysDiffItemBase.resetPPSDevSysDiffItemId();
        pSDevSysDiffItemBase.resetPPSDevSysDiffItemName();
        pSDevSysDiffItemBase.resetPSDEId();
        pSDevSysDiffItemBase.resetPSDEName();
        pSDevSysDiffItemBase.resetPSDevSysDiffItemId();
        pSDevSysDiffItemBase.resetPSDevSysDiffItemName();
        pSDevSysDiffItemBase.resetPSDevSysDiffRepId();
        pSDevSysDiffItemBase.resetPSDevSysDiffRepName();
        pSDevSysDiffItemBase.resetPSObjId();
        pSDevSysDiffItemBase.resetPSObjName();
        pSDevSysDiffItemBase.resetPSSysAppId();
        pSDevSysDiffItemBase.resetPSSysAppName();
        pSDevSysDiffItemBase.resetSyncAction();
        pSDevSysDiffItemBase.resetSyncResult();
        pSDevSysDiffItemBase.resetSyncResultInfo();
        pSDevSysDiffItemBase.resetUpdateDate();
        pSDevSysDiffItemBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDiffTypeDirty()) {
            hashMap.put(FIELD_DIFFTYPE, this.getDiffType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isObjTypeDirty()) {
            hashMap.put(FIELD_OBJTYPE, this.getObjType());
        }
        if (!bl || this.isPPSDevSysDiffItemIdDirty()) {
            hashMap.put(FIELD_PPSDEVSYSDIFFITEMID, this.getPPSDevSysDiffItemId());
        }
        if (!bl || this.isPPSDevSysDiffItemNameDirty()) {
            hashMap.put(FIELD_PPSDEVSYSDIFFITEMNAME, this.getPPSDevSysDiffItemName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDevSysDiffItemIdDirty()) {
            hashMap.put(FIELD_PSDEVSYSDIFFITEMID, this.getPSDevSysDiffItemId());
        }
        if (!bl || this.isPSDevSysDiffItemNameDirty()) {
            hashMap.put(FIELD_PSDEVSYSDIFFITEMNAME, this.getPSDevSysDiffItemName());
        }
        if (!bl || this.isPSDevSysDiffRepIdDirty()) {
            hashMap.put(FIELD_PSDEVSYSDIFFREPID, this.getPSDevSysDiffRepId());
        }
        if (!bl || this.isPSDevSysDiffRepNameDirty()) {
            hashMap.put(FIELD_PSDEVSYSDIFFREPNAME, this.getPSDevSysDiffRepName());
        }
        if (!bl || this.isPSObjIdDirty()) {
            hashMap.put(FIELD_PSOBJID, this.getPSObjId());
        }
        if (!bl || this.isPSObjNameDirty()) {
            hashMap.put(FIELD_PSOBJNAME, this.getPSObjName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isSyncActionDirty()) {
            hashMap.put(FIELD_SYNCACTION, this.getSyncAction());
        }
        if (!bl || this.isSyncResultDirty()) {
            hashMap.put(FIELD_SYNCRESULT, this.getSyncResult());
        }
        if (!bl || this.isSyncResultInfoDirty()) {
            hashMap.put(FIELD_SYNCRESULTINFO, this.getSyncResultInfo());
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
        return PSDevSysDiffItemBase.get(this, n);
    }

    private static Object get(PSDevSysDiffItemBase pSDevSysDiffItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSysDiffItemBase.getCreateDate();
            }
            case 1: {
                return pSDevSysDiffItemBase.getCreateMan();
            }
            case 2: {
                return pSDevSysDiffItemBase.getDiffType();
            }
            case 3: {
                return pSDevSysDiffItemBase.getMemo();
            }
            case 4: {
                return pSDevSysDiffItemBase.getObjType();
            }
            case 5: {
                return pSDevSysDiffItemBase.getPPSDevSysDiffItemId();
            }
            case 6: {
                return pSDevSysDiffItemBase.getPPSDevSysDiffItemName();
            }
            case 7: {
                return pSDevSysDiffItemBase.getPSDEId();
            }
            case 8: {
                return pSDevSysDiffItemBase.getPSDEName();
            }
            case 9: {
                return pSDevSysDiffItemBase.getPSDevSysDiffItemId();
            }
            case 10: {
                return pSDevSysDiffItemBase.getPSDevSysDiffItemName();
            }
            case 11: {
                return pSDevSysDiffItemBase.getPSDevSysDiffRepId();
            }
            case 12: {
                return pSDevSysDiffItemBase.getPSDevSysDiffRepName();
            }
            case 13: {
                return pSDevSysDiffItemBase.getPSObjId();
            }
            case 14: {
                return pSDevSysDiffItemBase.getPSObjName();
            }
            case 15: {
                return pSDevSysDiffItemBase.getPSSysAppId();
            }
            case 16: {
                return pSDevSysDiffItemBase.getPSSysAppName();
            }
            case 17: {
                return pSDevSysDiffItemBase.getSyncAction();
            }
            case 18: {
                return pSDevSysDiffItemBase.getSyncResult();
            }
            case 19: {
                return pSDevSysDiffItemBase.getSyncResultInfo();
            }
            case 20: {
                return pSDevSysDiffItemBase.getUpdateDate();
            }
            case 21: {
                return pSDevSysDiffItemBase.getUpdateMan();
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
        PSDevSysDiffItemBase.set(this, n, object);
    }

    private static void set(PSDevSysDiffItemBase pSDevSysDiffItemBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSysDiffItemBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevSysDiffItemBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevSysDiffItemBase.setDiffType(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevSysDiffItemBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevSysDiffItemBase.setObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevSysDiffItemBase.setPPSDevSysDiffItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevSysDiffItemBase.setPPSDevSysDiffItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevSysDiffItemBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevSysDiffItemBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevSysDiffItemBase.setPSDevSysDiffItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevSysDiffItemBase.setPSDevSysDiffItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevSysDiffItemBase.setPSDevSysDiffRepId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevSysDiffItemBase.setPSDevSysDiffRepName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevSysDiffItemBase.setPSObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevSysDiffItemBase.setPSObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevSysDiffItemBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevSysDiffItemBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDevSysDiffItemBase.setSyncAction(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDevSysDiffItemBase.setSyncResult(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSDevSysDiffItemBase.setSyncResultInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDevSysDiffItemBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 21: {
                pSDevSysDiffItemBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDevSysDiffItemBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSysDiffItemBase pSDevSysDiffItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSysDiffItemBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevSysDiffItemBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevSysDiffItemBase.getDiffType() == null;
            }
            case 3: {
                return pSDevSysDiffItemBase.getMemo() == null;
            }
            case 4: {
                return pSDevSysDiffItemBase.getObjType() == null;
            }
            case 5: {
                return pSDevSysDiffItemBase.getPPSDevSysDiffItemId() == null;
            }
            case 6: {
                return pSDevSysDiffItemBase.getPPSDevSysDiffItemName() == null;
            }
            case 7: {
                return pSDevSysDiffItemBase.getPSDEId() == null;
            }
            case 8: {
                return pSDevSysDiffItemBase.getPSDEName() == null;
            }
            case 9: {
                return pSDevSysDiffItemBase.getPSDevSysDiffItemId() == null;
            }
            case 10: {
                return pSDevSysDiffItemBase.getPSDevSysDiffItemName() == null;
            }
            case 11: {
                return pSDevSysDiffItemBase.getPSDevSysDiffRepId() == null;
            }
            case 12: {
                return pSDevSysDiffItemBase.getPSDevSysDiffRepName() == null;
            }
            case 13: {
                return pSDevSysDiffItemBase.getPSObjId() == null;
            }
            case 14: {
                return pSDevSysDiffItemBase.getPSObjName() == null;
            }
            case 15: {
                return pSDevSysDiffItemBase.getPSSysAppId() == null;
            }
            case 16: {
                return pSDevSysDiffItemBase.getPSSysAppName() == null;
            }
            case 17: {
                return pSDevSysDiffItemBase.getSyncAction() == null;
            }
            case 18: {
                return pSDevSysDiffItemBase.getSyncResult() == null;
            }
            case 19: {
                return pSDevSysDiffItemBase.getSyncResultInfo() == null;
            }
            case 20: {
                return pSDevSysDiffItemBase.getUpdateDate() == null;
            }
            case 21: {
                return pSDevSysDiffItemBase.getUpdateMan() == null;
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
        return PSDevSysDiffItemBase.contains(this, n);
    }

    private static boolean contains(PSDevSysDiffItemBase pSDevSysDiffItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSysDiffItemBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevSysDiffItemBase.isCreateManDirty();
            }
            case 2: {
                return pSDevSysDiffItemBase.isDiffTypeDirty();
            }
            case 3: {
                return pSDevSysDiffItemBase.isMemoDirty();
            }
            case 4: {
                return pSDevSysDiffItemBase.isObjTypeDirty();
            }
            case 5: {
                return pSDevSysDiffItemBase.isPPSDevSysDiffItemIdDirty();
            }
            case 6: {
                return pSDevSysDiffItemBase.isPPSDevSysDiffItemNameDirty();
            }
            case 7: {
                return pSDevSysDiffItemBase.isPSDEIdDirty();
            }
            case 8: {
                return pSDevSysDiffItemBase.isPSDENameDirty();
            }
            case 9: {
                return pSDevSysDiffItemBase.isPSDevSysDiffItemIdDirty();
            }
            case 10: {
                return pSDevSysDiffItemBase.isPSDevSysDiffItemNameDirty();
            }
            case 11: {
                return pSDevSysDiffItemBase.isPSDevSysDiffRepIdDirty();
            }
            case 12: {
                return pSDevSysDiffItemBase.isPSDevSysDiffRepNameDirty();
            }
            case 13: {
                return pSDevSysDiffItemBase.isPSObjIdDirty();
            }
            case 14: {
                return pSDevSysDiffItemBase.isPSObjNameDirty();
            }
            case 15: {
                return pSDevSysDiffItemBase.isPSSysAppIdDirty();
            }
            case 16: {
                return pSDevSysDiffItemBase.isPSSysAppNameDirty();
            }
            case 17: {
                return pSDevSysDiffItemBase.isSyncActionDirty();
            }
            case 18: {
                return pSDevSysDiffItemBase.isSyncResultDirty();
            }
            case 19: {
                return pSDevSysDiffItemBase.isSyncResultInfoDirty();
            }
            case 20: {
                return pSDevSysDiffItemBase.isUpdateDateDirty();
            }
            case 21: {
                return pSDevSysDiffItemBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSysDiffItemBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSysDiffItemBase pSDevSysDiffItemBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSysDiffItemBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSysDiffItemBase.getJSONValue((Object)pSDevSysDiffItemBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSysDiffItemBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSysDiffItemBase.getJSONValue((Object)pSDevSysDiffItemBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSysDiffItemBase.getDiffType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"difftype", (Object)PSDevSysDiffItemBase.getJSONValue((Object)pSDevSysDiffItemBase.getDiffType()), (boolean)false);
        }
        if (bl || pSDevSysDiffItemBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSysDiffItemBase.getJSONValue((Object)pSDevSysDiffItemBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSysDiffItemBase.getObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"objtype", (Object)PSDevSysDiffItemBase.getJSONValue((Object)pSDevSysDiffItemBase.getObjType()), (boolean)false);
        }
        if (bl || pSDevSysDiffItemBase.getPPSDevSysDiffItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdevsysdiffitemid", (Object)PSDevSysDiffItemBase.getJSONValue((Object)pSDevSysDiffItemBase.getPPSDevSysDiffItemId()), (boolean)false);
        }
        if (bl || pSDevSysDiffItemBase.getPPSDevSysDiffItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdevsysdiffitemname", (Object)PSDevSysDiffItemBase.getJSONValue((Object)pSDevSysDiffItemBase.getPPSDevSysDiffItemName()), (boolean)false);
        }
        if (bl || pSDevSysDiffItemBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDevSysDiffItemBase.getJSONValue((Object)pSDevSysDiffItemBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDevSysDiffItemBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDevSysDiffItemBase.getJSONValue((Object)pSDevSysDiffItemBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDevSysDiffItemBase.getPSDevSysDiffItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevsysdiffitemid", (Object)PSDevSysDiffItemBase.getJSONValue((Object)pSDevSysDiffItemBase.getPSDevSysDiffItemId()), (boolean)false);
        }
        if (bl || pSDevSysDiffItemBase.getPSDevSysDiffItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevsysdiffitemname", (Object)PSDevSysDiffItemBase.getJSONValue((Object)pSDevSysDiffItemBase.getPSDevSysDiffItemName()), (boolean)false);
        }
        if (bl || pSDevSysDiffItemBase.getPSDevSysDiffRepId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevsysdiffrepid", (Object)PSDevSysDiffItemBase.getJSONValue((Object)pSDevSysDiffItemBase.getPSDevSysDiffRepId()), (boolean)false);
        }
        if (bl || pSDevSysDiffItemBase.getPSDevSysDiffRepName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevsysdiffrepname", (Object)PSDevSysDiffItemBase.getJSONValue((Object)pSDevSysDiffItemBase.getPSDevSysDiffRepName()), (boolean)false);
        }
        if (bl || pSDevSysDiffItemBase.getPSObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjid", (Object)PSDevSysDiffItemBase.getJSONValue((Object)pSDevSysDiffItemBase.getPSObjId()), (boolean)false);
        }
        if (bl || pSDevSysDiffItemBase.getPSObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjname", (Object)PSDevSysDiffItemBase.getJSONValue((Object)pSDevSysDiffItemBase.getPSObjName()), (boolean)false);
        }
        if (bl || pSDevSysDiffItemBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSDevSysDiffItemBase.getJSONValue((Object)pSDevSysDiffItemBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSDevSysDiffItemBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSDevSysDiffItemBase.getJSONValue((Object)pSDevSysDiffItemBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSDevSysDiffItemBase.getSyncAction() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncaction", (Object)PSDevSysDiffItemBase.getJSONValue((Object)pSDevSysDiffItemBase.getSyncAction()), (boolean)false);
        }
        if (bl || pSDevSysDiffItemBase.getSyncResult() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncresult", (Object)PSDevSysDiffItemBase.getJSONValue((Object)pSDevSysDiffItemBase.getSyncResult()), (boolean)false);
        }
        if (bl || pSDevSysDiffItemBase.getSyncResultInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncresultinfo", (Object)PSDevSysDiffItemBase.getJSONValue((Object)pSDevSysDiffItemBase.getSyncResultInfo()), (boolean)false);
        }
        if (bl || pSDevSysDiffItemBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSysDiffItemBase.getJSONValue((Object)pSDevSysDiffItemBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSysDiffItemBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSysDiffItemBase.getJSONValue((Object)pSDevSysDiffItemBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSysDiffItemBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSysDiffItemBase pSDevSysDiffItemBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSysDiffItemBase.getCreateDate() != null) {
            object = pSDevSysDiffItemBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSysDiffItemBase.getCreateMan() != null) {
            object = pSDevSysDiffItemBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSysDiffItemBase.getDiffType() != null) {
            object = pSDevSysDiffItemBase.getDiffType();
            xmlNode.setAttribute(FIELD_DIFFTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevSysDiffItemBase.getMemo() != null) {
            object = pSDevSysDiffItemBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSysDiffItemBase.getObjType() != null) {
            object = pSDevSysDiffItemBase.getObjType();
            xmlNode.setAttribute(FIELD_OBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevSysDiffItemBase.getPPSDevSysDiffItemId() != null) {
            object = pSDevSysDiffItemBase.getPPSDevSysDiffItemId();
            xmlNode.setAttribute(FIELD_PPSDEVSYSDIFFITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSysDiffItemBase.getPPSDevSysDiffItemName() != null) {
            object = pSDevSysDiffItemBase.getPPSDevSysDiffItemName();
            xmlNode.setAttribute(FIELD_PPSDEVSYSDIFFITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSysDiffItemBase.getPSDEId() != null) {
            object = pSDevSysDiffItemBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSysDiffItemBase.getPSDEName() != null) {
            object = pSDevSysDiffItemBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSysDiffItemBase.getPSDevSysDiffItemId() != null) {
            object = pSDevSysDiffItemBase.getPSDevSysDiffItemId();
            xmlNode.setAttribute(FIELD_PSDEVSYSDIFFITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSysDiffItemBase.getPSDevSysDiffItemName() != null) {
            object = pSDevSysDiffItemBase.getPSDevSysDiffItemName();
            xmlNode.setAttribute(FIELD_PSDEVSYSDIFFITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSysDiffItemBase.getPSDevSysDiffRepId() != null) {
            object = pSDevSysDiffItemBase.getPSDevSysDiffRepId();
            xmlNode.setAttribute(FIELD_PSDEVSYSDIFFREPID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSysDiffItemBase.getPSDevSysDiffRepName() != null) {
            object = pSDevSysDiffItemBase.getPSDevSysDiffRepName();
            xmlNode.setAttribute(FIELD_PSDEVSYSDIFFREPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSysDiffItemBase.getPSObjId() != null) {
            object = pSDevSysDiffItemBase.getPSObjId();
            xmlNode.setAttribute(FIELD_PSOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSysDiffItemBase.getPSObjName() != null) {
            object = pSDevSysDiffItemBase.getPSObjName();
            xmlNode.setAttribute(FIELD_PSOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSysDiffItemBase.getPSSysAppId() != null) {
            object = pSDevSysDiffItemBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSysDiffItemBase.getPSSysAppName() != null) {
            object = pSDevSysDiffItemBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSysDiffItemBase.getSyncAction() != null) {
            object = pSDevSysDiffItemBase.getSyncAction();
            xmlNode.setAttribute(FIELD_SYNCACTION, object == null ? "" : (String)object);
        }
        if (bl || pSDevSysDiffItemBase.getSyncResult() != null) {
            object = pSDevSysDiffItemBase.getSyncResult();
            xmlNode.setAttribute(FIELD_SYNCRESULT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSysDiffItemBase.getSyncResultInfo() != null) {
            object = pSDevSysDiffItemBase.getSyncResultInfo();
            xmlNode.setAttribute(FIELD_SYNCRESULTINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSysDiffItemBase.getUpdateDate() != null) {
            object = pSDevSysDiffItemBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSysDiffItemBase.getUpdateMan() != null) {
            object = pSDevSysDiffItemBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSysDiffItemBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSysDiffItemBase pSDevSysDiffItemBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSysDiffItemBase.isCreateDateDirty() && (bl || pSDevSysDiffItemBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSysDiffItemBase.getCreateDate());
        }
        if (pSDevSysDiffItemBase.isCreateManDirty() && (bl || pSDevSysDiffItemBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSysDiffItemBase.getCreateMan());
        }
        if (pSDevSysDiffItemBase.isDiffTypeDirty() && (bl || pSDevSysDiffItemBase.getDiffType() != null)) {
            iDataObject.set(FIELD_DIFFTYPE, (Object)pSDevSysDiffItemBase.getDiffType());
        }
        if (pSDevSysDiffItemBase.isMemoDirty() && (bl || pSDevSysDiffItemBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSysDiffItemBase.getMemo());
        }
        if (pSDevSysDiffItemBase.isObjTypeDirty() && (bl || pSDevSysDiffItemBase.getObjType() != null)) {
            iDataObject.set(FIELD_OBJTYPE, (Object)pSDevSysDiffItemBase.getObjType());
        }
        if (pSDevSysDiffItemBase.isPPSDevSysDiffItemIdDirty() && (bl || pSDevSysDiffItemBase.getPPSDevSysDiffItemId() != null)) {
            iDataObject.set(FIELD_PPSDEVSYSDIFFITEMID, (Object)pSDevSysDiffItemBase.getPPSDevSysDiffItemId());
        }
        if (pSDevSysDiffItemBase.isPPSDevSysDiffItemNameDirty() && (bl || pSDevSysDiffItemBase.getPPSDevSysDiffItemName() != null)) {
            iDataObject.set(FIELD_PPSDEVSYSDIFFITEMNAME, (Object)pSDevSysDiffItemBase.getPPSDevSysDiffItemName());
        }
        if (pSDevSysDiffItemBase.isPSDEIdDirty() && (bl || pSDevSysDiffItemBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDevSysDiffItemBase.getPSDEId());
        }
        if (pSDevSysDiffItemBase.isPSDENameDirty() && (bl || pSDevSysDiffItemBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDevSysDiffItemBase.getPSDEName());
        }
        if (pSDevSysDiffItemBase.isPSDevSysDiffItemIdDirty() && (bl || pSDevSysDiffItemBase.getPSDevSysDiffItemId() != null)) {
            iDataObject.set(FIELD_PSDEVSYSDIFFITEMID, (Object)pSDevSysDiffItemBase.getPSDevSysDiffItemId());
        }
        if (pSDevSysDiffItemBase.isPSDevSysDiffItemNameDirty() && (bl || pSDevSysDiffItemBase.getPSDevSysDiffItemName() != null)) {
            iDataObject.set(FIELD_PSDEVSYSDIFFITEMNAME, (Object)pSDevSysDiffItemBase.getPSDevSysDiffItemName());
        }
        if (pSDevSysDiffItemBase.isPSDevSysDiffRepIdDirty() && (bl || pSDevSysDiffItemBase.getPSDevSysDiffRepId() != null)) {
            iDataObject.set(FIELD_PSDEVSYSDIFFREPID, (Object)pSDevSysDiffItemBase.getPSDevSysDiffRepId());
        }
        if (pSDevSysDiffItemBase.isPSDevSysDiffRepNameDirty() && (bl || pSDevSysDiffItemBase.getPSDevSysDiffRepName() != null)) {
            iDataObject.set(FIELD_PSDEVSYSDIFFREPNAME, (Object)pSDevSysDiffItemBase.getPSDevSysDiffRepName());
        }
        if (pSDevSysDiffItemBase.isPSObjIdDirty() && (bl || pSDevSysDiffItemBase.getPSObjId() != null)) {
            iDataObject.set(FIELD_PSOBJID, (Object)pSDevSysDiffItemBase.getPSObjId());
        }
        if (pSDevSysDiffItemBase.isPSObjNameDirty() && (bl || pSDevSysDiffItemBase.getPSObjName() != null)) {
            iDataObject.set(FIELD_PSOBJNAME, (Object)pSDevSysDiffItemBase.getPSObjName());
        }
        if (pSDevSysDiffItemBase.isPSSysAppIdDirty() && (bl || pSDevSysDiffItemBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSDevSysDiffItemBase.getPSSysAppId());
        }
        if (pSDevSysDiffItemBase.isPSSysAppNameDirty() && (bl || pSDevSysDiffItemBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSDevSysDiffItemBase.getPSSysAppName());
        }
        if (pSDevSysDiffItemBase.isSyncActionDirty() && (bl || pSDevSysDiffItemBase.getSyncAction() != null)) {
            iDataObject.set(FIELD_SYNCACTION, (Object)pSDevSysDiffItemBase.getSyncAction());
        }
        if (pSDevSysDiffItemBase.isSyncResultDirty() && (bl || pSDevSysDiffItemBase.getSyncResult() != null)) {
            iDataObject.set(FIELD_SYNCRESULT, (Object)pSDevSysDiffItemBase.getSyncResult());
        }
        if (pSDevSysDiffItemBase.isSyncResultInfoDirty() && (bl || pSDevSysDiffItemBase.getSyncResultInfo() != null)) {
            iDataObject.set(FIELD_SYNCRESULTINFO, (Object)pSDevSysDiffItemBase.getSyncResultInfo());
        }
        if (pSDevSysDiffItemBase.isUpdateDateDirty() && (bl || pSDevSysDiffItemBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSysDiffItemBase.getUpdateDate());
        }
        if (pSDevSysDiffItemBase.isUpdateManDirty() && (bl || pSDevSysDiffItemBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSysDiffItemBase.getUpdateMan());
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
        return PSDevSysDiffItemBase.remove(this, n);
    }

    private static boolean remove(PSDevSysDiffItemBase pSDevSysDiffItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSysDiffItemBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevSysDiffItemBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevSysDiffItemBase.resetDiffType();
                return true;
            }
            case 3: {
                pSDevSysDiffItemBase.resetMemo();
                return true;
            }
            case 4: {
                pSDevSysDiffItemBase.resetObjType();
                return true;
            }
            case 5: {
                pSDevSysDiffItemBase.resetPPSDevSysDiffItemId();
                return true;
            }
            case 6: {
                pSDevSysDiffItemBase.resetPPSDevSysDiffItemName();
                return true;
            }
            case 7: {
                pSDevSysDiffItemBase.resetPSDEId();
                return true;
            }
            case 8: {
                pSDevSysDiffItemBase.resetPSDEName();
                return true;
            }
            case 9: {
                pSDevSysDiffItemBase.resetPSDevSysDiffItemId();
                return true;
            }
            case 10: {
                pSDevSysDiffItemBase.resetPSDevSysDiffItemName();
                return true;
            }
            case 11: {
                pSDevSysDiffItemBase.resetPSDevSysDiffRepId();
                return true;
            }
            case 12: {
                pSDevSysDiffItemBase.resetPSDevSysDiffRepName();
                return true;
            }
            case 13: {
                pSDevSysDiffItemBase.resetPSObjId();
                return true;
            }
            case 14: {
                pSDevSysDiffItemBase.resetPSObjName();
                return true;
            }
            case 15: {
                pSDevSysDiffItemBase.resetPSSysAppId();
                return true;
            }
            case 16: {
                pSDevSysDiffItemBase.resetPSSysAppName();
                return true;
            }
            case 17: {
                pSDevSysDiffItemBase.resetSyncAction();
                return true;
            }
            case 18: {
                pSDevSysDiffItemBase.resetSyncResult();
                return true;
            }
            case 19: {
                pSDevSysDiffItemBase.resetSyncResultInfo();
                return true;
            }
            case 20: {
                pSDevSysDiffItemBase.resetUpdateDate();
                return true;
            }
            case 21: {
                pSDevSysDiffItemBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSysDiffItem getPPSDevSysDiffItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDevSysDiffItem();
        }
        if (this.getPPSDevSysDiffItemId() == null) {
            return null;
        }
        Integer n = this.objPPSDevSysDiffItemLock;
        synchronized (n) {
            if (this.ppsdevsysdiffitem != null && DataTypeHelper.compare((int)25, (Object)this.getPPSDevSysDiffItemId(), (Object)this.ppsdevsysdiffitem.getPSDevSysDiffItemId()) != 0L) {
                this.ppsdevsysdiffitem = null;
            }
            if (this.ppsdevsysdiffitem == null) {
                PSDevSysDiffItem pSDevSysDiffItem = new PSDevSysDiffItem();
                pSDevSysDiffItem.setPSDevSysDiffItemId(this.getPPSDevSysDiffItemId());
                PSDevSysDiffItemService pSDevSysDiffItemService = (PSDevSysDiffItemService)ServiceGlobal.getService(PSDevSysDiffItemService.class, (SessionFactory)this.getSessionFactory());
                pSDevSysDiffItemService.autoGet(pSDevSysDiffItem);
                this.ppsdevsysdiffitem = pSDevSysDiffItem;
            }
            return this.ppsdevsysdiffitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSysDiffRep getPSDevSysDiffRep() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSysDiffRep();
        }
        if (this.getPSDevSysDiffRepId() == null) {
            return null;
        }
        Integer n = this.objPSDevSysDiffRepLock;
        synchronized (n) {
            if (this.psdevsysdiffrep != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSysDiffRepId(), (Object)this.psdevsysdiffrep.getPSDevSysDiffRepId()) != 0L) {
                this.psdevsysdiffrep = null;
            }
            if (this.psdevsysdiffrep == null) {
                PSDevSysDiffRep pSDevSysDiffRep = new PSDevSysDiffRep();
                pSDevSysDiffRep.setPSDevSysDiffRepId(this.getPSDevSysDiffRepId());
                PSDevSysDiffRepService pSDevSysDiffRepService = (PSDevSysDiffRepService)ServiceGlobal.getService(PSDevSysDiffRepService.class, (SessionFactory)this.getSessionFactory());
                pSDevSysDiffRepService.autoGet(pSDevSysDiffRep);
                this.psdevsysdiffrep = pSDevSysDiffRep;
            }
            return this.psdevsysdiffrep;
        }
    }

    private PSDevSysDiffItemBase getProxyEntity() {
        return this.proxyPSDevSysDiffItemBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSysDiffItemBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSysDiffItemBase) {
            this.proxyPSDevSysDiffItemBase = (PSDevSysDiffItemBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSysDiffItemService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DIFFTYPE, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_OBJTYPE, 4);
        fieldIndexMap.put(FIELD_PPSDEVSYSDIFFITEMID, 5);
        fieldIndexMap.put(FIELD_PPSDEVSYSDIFFITEMNAME, 6);
        fieldIndexMap.put(FIELD_PSDEID, 7);
        fieldIndexMap.put(FIELD_PSDENAME, 8);
        fieldIndexMap.put(FIELD_PSDEVSYSDIFFITEMID, 9);
        fieldIndexMap.put(FIELD_PSDEVSYSDIFFITEMNAME, 10);
        fieldIndexMap.put(FIELD_PSDEVSYSDIFFREPID, 11);
        fieldIndexMap.put(FIELD_PSDEVSYSDIFFREPNAME, 12);
        fieldIndexMap.put(FIELD_PSOBJID, 13);
        fieldIndexMap.put(FIELD_PSOBJNAME, 14);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 15);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 16);
        fieldIndexMap.put(FIELD_SYNCACTION, 17);
        fieldIndexMap.put(FIELD_SYNCRESULT, 18);
        fieldIndexMap.put(FIELD_SYNCRESULTINFO, 19);
        fieldIndexMap.put(FIELD_UPDATEDATE, 20);
        fieldIndexMap.put(FIELD_UPDATEMAN, 21);
    }
}

