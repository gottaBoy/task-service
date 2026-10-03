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
import net.ibizsys.pscore.srv.config.entity.PSDBType;
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.service.PSDBTypeService;
import net.ibizsys.pscore.srv.config.service.PSPFService;
import net.ibizsys.pscore.srv.config.service.PSPFStyleService;
import net.ibizsys.pscore.srv.config.service.PSSFService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCAbilityBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCAbilityBase.class);
    public static final String FIELD_ABILITYCAT = "ABILITYCAT";
    public static final String FIELD_BEGINTIME = "BEGINTIME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENDTIME = "ENDTIME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDBTYPEID = "PSDBTYPEID";
    public static final String FIELD_PSDBTYPENAME = "PSDBTYPENAME";
    public static final String FIELD_PSDCABILITYID = "PSDCABILITYID";
    public static final String FIELD_PSDCABILITYNAME = "PSDCABILITYNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFNAME = "PSPFNAME";
    public static final String FIELD_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String FIELD_PSPFSTYLENAME = "PSPFSTYLENAME";
    public static final String FIELD_PSSFID = "PSSFID";
    public static final String FIELD_PSSFNAME = "PSSFNAME";
    public static final String FIELD_PSSFSTYLEID = "PSSFSTYLEID";
    public static final String FIELD_PSSFSTYLENAME = "PSSFSTYLENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_ABILITYCAT = 0;
    private static final int INDEX_BEGINTIME = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_ENDTIME = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSDBTYPEID = 6;
    private static final int INDEX_PSDBTYPENAME = 7;
    private static final int INDEX_PSDCABILITYID = 8;
    private static final int INDEX_PSDCABILITYNAME = 9;
    private static final int INDEX_PSDEVCENTERID = 10;
    private static final int INDEX_PSDEVCENTERNAME = 11;
    private static final int INDEX_PSPFID = 12;
    private static final int INDEX_PSPFNAME = 13;
    private static final int INDEX_PSPFSTYLEID = 14;
    private static final int INDEX_PSPFSTYLENAME = 15;
    private static final int INDEX_PSSFID = 16;
    private static final int INDEX_PSSFNAME = 17;
    private static final int INDEX_PSSFSTYLEID = 18;
    private static final int INDEX_PSSFSTYLENAME = 19;
    private static final int INDEX_UPDATEDATE = 20;
    private static final int INDEX_UPDATEMAN = 21;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCAbilityBase proxyPSDCAbilityBase = null;
    private boolean abilitycatDirtyFlag = false;
    private boolean begintimeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean endtimeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdbtypeidDirtyFlag = false;
    private boolean psdbtypenameDirtyFlag = false;
    private boolean psdcabilityidDirtyFlag = false;
    private boolean psdcabilitynameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfnameDirtyFlag = false;
    private boolean pspfstyleidDirtyFlag = false;
    private boolean pspfstylenameDirtyFlag = false;
    private boolean pssfidDirtyFlag = false;
    private boolean pssfnameDirtyFlag = false;
    private boolean pssfstyleidDirtyFlag = false;
    private boolean pssfstylenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="abilitycat")
    private String abilitycat;
    @Column(name="begintime")
    private Timestamp begintime;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="endtime")
    private Timestamp endtime;
    @Column(name="memo")
    private String memo;
    @Column(name="psdbtypeid")
    private String psdbtypeid;
    @Column(name="psdbtypename")
    private String psdbtypename;
    @Column(name="psdcabilityid")
    private String psdcabilityid;
    @Column(name="psdcabilityname")
    private String psdcabilityname;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="pspfid")
    private String pspfid;
    @Column(name="pspfname")
    private String pspfname;
    @Column(name="pspfstyleid")
    private String pspfstyleid;
    @Column(name="pspfstylename")
    private String pspfstylename;
    @Column(name="pssfid")
    private String pssfid;
    @Column(name="pssfname")
    private String pssfname;
    @Column(name="pssfstyleid")
    private String pssfstyleid;
    @Column(name="pssfstylename")
    private String pssfstylename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDBTypeLock = new Integer(1);
    private PSDBType psdbtype = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSPSStyleLock = new Integer(1);
    private PSPFStyle pspsstyle = null;
    private Integer objPSPFLock = new Integer(1);
    private PSPF pspf = null;
    private Integer objPSSFStyleLock = new Integer(1);
    private PSSFStyle pssfstyle = null;
    private Integer objPSSFLock = new Integer(1);
    private PSSF pssf = null;

    public void setAbilityCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAbilityCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.abilitycat = string;
        this.abilitycatDirtyFlag = true;
    }

    public String getAbilityCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAbilityCat();
        }
        return this.abilitycat;
    }

    public boolean isAbilityCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAbilityCatDirty();
        }
        return this.abilitycatDirtyFlag;
    }

    public void resetAbilityCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAbilityCat();
            return;
        }
        this.abilitycatDirtyFlag = false;
        this.abilitycat = null;
    }

    public void setBeginTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBeginTime(timestamp);
            return;
        }
        this.begintime = timestamp;
        this.begintimeDirtyFlag = true;
    }

    public Timestamp getBeginTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeginTime();
        }
        return this.begintime;
    }

    public boolean isBeginTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBeginTimeDirty();
        }
        return this.begintimeDirtyFlag;
    }

    public void resetBeginTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBeginTime();
            return;
        }
        this.begintimeDirtyFlag = false;
        this.begintime = null;
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

    public void setEndTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEndTime(timestamp);
            return;
        }
        this.endtime = timestamp;
        this.endtimeDirtyFlag = true;
    }

    public Timestamp getEndTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEndTime();
        }
        return this.endtime;
    }

    public boolean isEndTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEndTimeDirty();
        }
        return this.endtimeDirtyFlag;
    }

    public void resetEndTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEndTime();
            return;
        }
        this.endtimeDirtyFlag = false;
        this.endtime = null;
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

    public void setPSDBTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbtypeid = string;
        this.psdbtypeidDirtyFlag = true;
    }

    public String getPSDBTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBTypeId();
        }
        return this.psdbtypeid;
    }

    public boolean isPSDBTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBTypeIdDirty();
        }
        return this.psdbtypeidDirtyFlag;
    }

    public void resetPSDBTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBTypeId();
            return;
        }
        this.psdbtypeidDirtyFlag = false;
        this.psdbtypeid = null;
    }

    public void setPSDBTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbtypename = string;
        this.psdbtypenameDirtyFlag = true;
    }

    public String getPSDBTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBTypeName();
        }
        return this.psdbtypename;
    }

    public boolean isPSDBTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBTypeNameDirty();
        }
        return this.psdbtypenameDirtyFlag;
    }

    public void resetPSDBTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBTypeName();
            return;
        }
        this.psdbtypenameDirtyFlag = false;
        this.psdbtypename = null;
    }

    public void setPSDCAbilityId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCAbilityId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcabilityid = string;
        this.psdcabilityidDirtyFlag = true;
    }

    public String getPSDCAbilityId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCAbilityId();
        }
        return this.psdcabilityid;
    }

    public boolean isPSDCAbilityIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCAbilityIdDirty();
        }
        return this.psdcabilityidDirtyFlag;
    }

    public void resetPSDCAbilityId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCAbilityId();
            return;
        }
        this.psdcabilityidDirtyFlag = false;
        this.psdcabilityid = null;
    }

    public void setPSDCAbilityName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCAbilityName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcabilityname = string;
        this.psdcabilitynameDirtyFlag = true;
    }

    public String getPSDCAbilityName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCAbilityName();
        }
        return this.psdcabilityname;
    }

    public boolean isPSDCAbilityNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCAbilityNameDirty();
        }
        return this.psdcabilitynameDirtyFlag;
    }

    public void resetPSDCAbilityName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCAbilityName();
            return;
        }
        this.psdcabilitynameDirtyFlag = false;
        this.psdcabilityname = null;
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

    public void setPSPFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfid = string;
        this.pspfidDirtyFlag = true;
    }

    public String getPSPFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFId();
        }
        return this.pspfid;
    }

    public boolean isPSPFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFIdDirty();
        }
        return this.pspfidDirtyFlag;
    }

    public void resetPSPFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFId();
            return;
        }
        this.pspfidDirtyFlag = false;
        this.pspfid = null;
    }

    public void setPSPFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfname = string;
        this.pspfnameDirtyFlag = true;
    }

    public String getPSPFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFName();
        }
        return this.pspfname;
    }

    public boolean isPSPFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFNameDirty();
        }
        return this.pspfnameDirtyFlag;
    }

    public void resetPSPFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFName();
            return;
        }
        this.pspfnameDirtyFlag = false;
        this.pspfname = null;
    }

    public void setPSPFStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfstyleid = string;
        this.pspfstyleidDirtyFlag = true;
    }

    public String getPSPFStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyleId();
        }
        return this.pspfstyleid;
    }

    public boolean isPSPFStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFStyleIdDirty();
        }
        return this.pspfstyleidDirtyFlag;
    }

    public void resetPSPFStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFStyleId();
            return;
        }
        this.pspfstyleidDirtyFlag = false;
        this.pspfstyleid = null;
    }

    public void setPSPFStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfstylename = string;
        this.pspfstylenameDirtyFlag = true;
    }

    public String getPSPFStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyleName();
        }
        return this.pspfstylename;
    }

    public boolean isPSPFStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFStyleNameDirty();
        }
        return this.pspfstylenameDirtyFlag;
    }

    public void resetPSPFStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFStyleName();
            return;
        }
        this.pspfstylenameDirtyFlag = false;
        this.pspfstylename = null;
    }

    public void setPSSFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfid = string;
        this.pssfidDirtyFlag = true;
    }

    public String getPSSFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFId();
        }
        return this.pssfid;
    }

    public boolean isPSSFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFIdDirty();
        }
        return this.pssfidDirtyFlag;
    }

    public void resetPSSFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFId();
            return;
        }
        this.pssfidDirtyFlag = false;
        this.pssfid = null;
    }

    public void setPSSFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfname = string;
        this.pssfnameDirtyFlag = true;
    }

    public String getPSSFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFName();
        }
        return this.pssfname;
    }

    public boolean isPSSFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFNameDirty();
        }
        return this.pssfnameDirtyFlag;
    }

    public void resetPSSFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFName();
            return;
        }
        this.pssfnameDirtyFlag = false;
        this.pssfname = null;
    }

    public void setPSSFStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstyleid = string;
        this.pssfstyleidDirtyFlag = true;
    }

    public String getPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleId();
        }
        return this.pssfstyleid;
    }

    public boolean isPSSFStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleIdDirty();
        }
        return this.pssfstyleidDirtyFlag;
    }

    public void resetPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleId();
            return;
        }
        this.pssfstyleidDirtyFlag = false;
        this.pssfstyleid = null;
    }

    public void setPSSFStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstylename = string;
        this.pssfstylenameDirtyFlag = true;
    }

    public String getPSSFStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleName();
        }
        return this.pssfstylename;
    }

    public boolean isPSSFStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleNameDirty();
        }
        return this.pssfstylenameDirtyFlag;
    }

    public void resetPSSFStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleName();
            return;
        }
        this.pssfstylenameDirtyFlag = false;
        this.pssfstylename = null;
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
        PSDCAbilityBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCAbilityBase pSDCAbilityBase) {
        pSDCAbilityBase.resetAbilityCat();
        pSDCAbilityBase.resetBeginTime();
        pSDCAbilityBase.resetCreateDate();
        pSDCAbilityBase.resetCreateMan();
        pSDCAbilityBase.resetEndTime();
        pSDCAbilityBase.resetMemo();
        pSDCAbilityBase.resetPSDBTypeId();
        pSDCAbilityBase.resetPSDBTypeName();
        pSDCAbilityBase.resetPSDCAbilityId();
        pSDCAbilityBase.resetPSDCAbilityName();
        pSDCAbilityBase.resetPSDevCenterId();
        pSDCAbilityBase.resetPSDevCenterName();
        pSDCAbilityBase.resetPSPFId();
        pSDCAbilityBase.resetPSPFName();
        pSDCAbilityBase.resetPSPFStyleId();
        pSDCAbilityBase.resetPSPFStyleName();
        pSDCAbilityBase.resetPSSFId();
        pSDCAbilityBase.resetPSSFName();
        pSDCAbilityBase.resetPSSFStyleId();
        pSDCAbilityBase.resetPSSFStyleName();
        pSDCAbilityBase.resetUpdateDate();
        pSDCAbilityBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAbilityCatDirty()) {
            hashMap.put(FIELD_ABILITYCAT, this.getAbilityCat());
        }
        if (!bl || this.isBeginTimeDirty()) {
            hashMap.put(FIELD_BEGINTIME, this.getBeginTime());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEndTimeDirty()) {
            hashMap.put(FIELD_ENDTIME, this.getEndTime());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDBTypeIdDirty()) {
            hashMap.put(FIELD_PSDBTYPEID, this.getPSDBTypeId());
        }
        if (!bl || this.isPSDBTypeNameDirty()) {
            hashMap.put(FIELD_PSDBTYPENAME, this.getPSDBTypeName());
        }
        if (!bl || this.isPSDCAbilityIdDirty()) {
            hashMap.put(FIELD_PSDCABILITYID, this.getPSDCAbilityId());
        }
        if (!bl || this.isPSDCAbilityNameDirty()) {
            hashMap.put(FIELD_PSDCABILITYNAME, this.getPSDCAbilityName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSPFIdDirty()) {
            hashMap.put(FIELD_PSPFID, this.getPSPFId());
        }
        if (!bl || this.isPSPFNameDirty()) {
            hashMap.put(FIELD_PSPFNAME, this.getPSPFName());
        }
        if (!bl || this.isPSPFStyleIdDirty()) {
            hashMap.put(FIELD_PSPFSTYLEID, this.getPSPFStyleId());
        }
        if (!bl || this.isPSPFStyleNameDirty()) {
            hashMap.put(FIELD_PSPFSTYLENAME, this.getPSPFStyleName());
        }
        if (!bl || this.isPSSFIdDirty()) {
            hashMap.put(FIELD_PSSFID, this.getPSSFId());
        }
        if (!bl || this.isPSSFNameDirty()) {
            hashMap.put(FIELD_PSSFNAME, this.getPSSFName());
        }
        if (!bl || this.isPSSFStyleIdDirty()) {
            hashMap.put(FIELD_PSSFSTYLEID, this.getPSSFStyleId());
        }
        if (!bl || this.isPSSFStyleNameDirty()) {
            hashMap.put(FIELD_PSSFSTYLENAME, this.getPSSFStyleName());
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
        return PSDCAbilityBase.get(this, n);
    }

    private static Object get(PSDCAbilityBase pSDCAbilityBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCAbilityBase.getAbilityCat();
            }
            case 1: {
                return pSDCAbilityBase.getBeginTime();
            }
            case 2: {
                return pSDCAbilityBase.getCreateDate();
            }
            case 3: {
                return pSDCAbilityBase.getCreateMan();
            }
            case 4: {
                return pSDCAbilityBase.getEndTime();
            }
            case 5: {
                return pSDCAbilityBase.getMemo();
            }
            case 6: {
                return pSDCAbilityBase.getPSDBTypeId();
            }
            case 7: {
                return pSDCAbilityBase.getPSDBTypeName();
            }
            case 8: {
                return pSDCAbilityBase.getPSDCAbilityId();
            }
            case 9: {
                return pSDCAbilityBase.getPSDCAbilityName();
            }
            case 10: {
                return pSDCAbilityBase.getPSDevCenterId();
            }
            case 11: {
                return pSDCAbilityBase.getPSDevCenterName();
            }
            case 12: {
                return pSDCAbilityBase.getPSPFId();
            }
            case 13: {
                return pSDCAbilityBase.getPSPFName();
            }
            case 14: {
                return pSDCAbilityBase.getPSPFStyleId();
            }
            case 15: {
                return pSDCAbilityBase.getPSPFStyleName();
            }
            case 16: {
                return pSDCAbilityBase.getPSSFId();
            }
            case 17: {
                return pSDCAbilityBase.getPSSFName();
            }
            case 18: {
                return pSDCAbilityBase.getPSSFStyleId();
            }
            case 19: {
                return pSDCAbilityBase.getPSSFStyleName();
            }
            case 20: {
                return pSDCAbilityBase.getUpdateDate();
            }
            case 21: {
                return pSDCAbilityBase.getUpdateMan();
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
        PSDCAbilityBase.set(this, n, object);
    }

    private static void set(PSDCAbilityBase pSDCAbilityBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCAbilityBase.setAbilityCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDCAbilityBase.setBeginTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDCAbilityBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDCAbilityBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCAbilityBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSDCAbilityBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCAbilityBase.setPSDBTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCAbilityBase.setPSDBTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCAbilityBase.setPSDCAbilityId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCAbilityBase.setPSDCAbilityName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCAbilityBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCAbilityBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCAbilityBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCAbilityBase.setPSPFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCAbilityBase.setPSPFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDCAbilityBase.setPSPFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDCAbilityBase.setPSSFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDCAbilityBase.setPSSFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDCAbilityBase.setPSSFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDCAbilityBase.setPSSFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDCAbilityBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 21: {
                pSDCAbilityBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDCAbilityBase.isNull(this, n);
    }

    private static boolean isNull(PSDCAbilityBase pSDCAbilityBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCAbilityBase.getAbilityCat() == null;
            }
            case 1: {
                return pSDCAbilityBase.getBeginTime() == null;
            }
            case 2: {
                return pSDCAbilityBase.getCreateDate() == null;
            }
            case 3: {
                return pSDCAbilityBase.getCreateMan() == null;
            }
            case 4: {
                return pSDCAbilityBase.getEndTime() == null;
            }
            case 5: {
                return pSDCAbilityBase.getMemo() == null;
            }
            case 6: {
                return pSDCAbilityBase.getPSDBTypeId() == null;
            }
            case 7: {
                return pSDCAbilityBase.getPSDBTypeName() == null;
            }
            case 8: {
                return pSDCAbilityBase.getPSDCAbilityId() == null;
            }
            case 9: {
                return pSDCAbilityBase.getPSDCAbilityName() == null;
            }
            case 10: {
                return pSDCAbilityBase.getPSDevCenterId() == null;
            }
            case 11: {
                return pSDCAbilityBase.getPSDevCenterName() == null;
            }
            case 12: {
                return pSDCAbilityBase.getPSPFId() == null;
            }
            case 13: {
                return pSDCAbilityBase.getPSPFName() == null;
            }
            case 14: {
                return pSDCAbilityBase.getPSPFStyleId() == null;
            }
            case 15: {
                return pSDCAbilityBase.getPSPFStyleName() == null;
            }
            case 16: {
                return pSDCAbilityBase.getPSSFId() == null;
            }
            case 17: {
                return pSDCAbilityBase.getPSSFName() == null;
            }
            case 18: {
                return pSDCAbilityBase.getPSSFStyleId() == null;
            }
            case 19: {
                return pSDCAbilityBase.getPSSFStyleName() == null;
            }
            case 20: {
                return pSDCAbilityBase.getUpdateDate() == null;
            }
            case 21: {
                return pSDCAbilityBase.getUpdateMan() == null;
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
        return PSDCAbilityBase.contains(this, n);
    }

    private static boolean contains(PSDCAbilityBase pSDCAbilityBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCAbilityBase.isAbilityCatDirty();
            }
            case 1: {
                return pSDCAbilityBase.isBeginTimeDirty();
            }
            case 2: {
                return pSDCAbilityBase.isCreateDateDirty();
            }
            case 3: {
                return pSDCAbilityBase.isCreateManDirty();
            }
            case 4: {
                return pSDCAbilityBase.isEndTimeDirty();
            }
            case 5: {
                return pSDCAbilityBase.isMemoDirty();
            }
            case 6: {
                return pSDCAbilityBase.isPSDBTypeIdDirty();
            }
            case 7: {
                return pSDCAbilityBase.isPSDBTypeNameDirty();
            }
            case 8: {
                return pSDCAbilityBase.isPSDCAbilityIdDirty();
            }
            case 9: {
                return pSDCAbilityBase.isPSDCAbilityNameDirty();
            }
            case 10: {
                return pSDCAbilityBase.isPSDevCenterIdDirty();
            }
            case 11: {
                return pSDCAbilityBase.isPSDevCenterNameDirty();
            }
            case 12: {
                return pSDCAbilityBase.isPSPFIdDirty();
            }
            case 13: {
                return pSDCAbilityBase.isPSPFNameDirty();
            }
            case 14: {
                return pSDCAbilityBase.isPSPFStyleIdDirty();
            }
            case 15: {
                return pSDCAbilityBase.isPSPFStyleNameDirty();
            }
            case 16: {
                return pSDCAbilityBase.isPSSFIdDirty();
            }
            case 17: {
                return pSDCAbilityBase.isPSSFNameDirty();
            }
            case 18: {
                return pSDCAbilityBase.isPSSFStyleIdDirty();
            }
            case 19: {
                return pSDCAbilityBase.isPSSFStyleNameDirty();
            }
            case 20: {
                return pSDCAbilityBase.isUpdateDateDirty();
            }
            case 21: {
                return pSDCAbilityBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCAbilityBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCAbilityBase pSDCAbilityBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCAbilityBase.getAbilityCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"abilitycat", (Object)PSDCAbilityBase.getJSONValue((Object)pSDCAbilityBase.getAbilityCat()), (boolean)false);
        }
        if (bl || pSDCAbilityBase.getBeginTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begintime", (Object)PSDCAbilityBase.getJSONValue((Object)pSDCAbilityBase.getBeginTime()), (boolean)false);
        }
        if (bl || pSDCAbilityBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCAbilityBase.getJSONValue((Object)pSDCAbilityBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCAbilityBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCAbilityBase.getJSONValue((Object)pSDCAbilityBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCAbilityBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSDCAbilityBase.getJSONValue((Object)pSDCAbilityBase.getEndTime()), (boolean)false);
        }
        if (bl || pSDCAbilityBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCAbilityBase.getJSONValue((Object)pSDCAbilityBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCAbilityBase.getPSDBTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbtypeid", (Object)PSDCAbilityBase.getJSONValue((Object)pSDCAbilityBase.getPSDBTypeId()), (boolean)false);
        }
        if (bl || pSDCAbilityBase.getPSDBTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbtypename", (Object)PSDCAbilityBase.getJSONValue((Object)pSDCAbilityBase.getPSDBTypeName()), (boolean)false);
        }
        if (bl || pSDCAbilityBase.getPSDCAbilityId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcabilityid", (Object)PSDCAbilityBase.getJSONValue((Object)pSDCAbilityBase.getPSDCAbilityId()), (boolean)false);
        }
        if (bl || pSDCAbilityBase.getPSDCAbilityName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcabilityname", (Object)PSDCAbilityBase.getJSONValue((Object)pSDCAbilityBase.getPSDCAbilityName()), (boolean)false);
        }
        if (bl || pSDCAbilityBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCAbilityBase.getJSONValue((Object)pSDCAbilityBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCAbilityBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCAbilityBase.getJSONValue((Object)pSDCAbilityBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCAbilityBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSDCAbilityBase.getJSONValue((Object)pSDCAbilityBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSDCAbilityBase.getPSPFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfname", (Object)PSDCAbilityBase.getJSONValue((Object)pSDCAbilityBase.getPSPFName()), (boolean)false);
        }
        if (bl || pSDCAbilityBase.getPSPFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstyleid", (Object)PSDCAbilityBase.getJSONValue((Object)pSDCAbilityBase.getPSPFStyleId()), (boolean)false);
        }
        if (bl || pSDCAbilityBase.getPSPFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstylename", (Object)PSDCAbilityBase.getJSONValue((Object)pSDCAbilityBase.getPSPFStyleName()), (boolean)false);
        }
        if (bl || pSDCAbilityBase.getPSSFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfid", (Object)PSDCAbilityBase.getJSONValue((Object)pSDCAbilityBase.getPSSFId()), (boolean)false);
        }
        if (bl || pSDCAbilityBase.getPSSFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfname", (Object)PSDCAbilityBase.getJSONValue((Object)pSDCAbilityBase.getPSSFName()), (boolean)false);
        }
        if (bl || pSDCAbilityBase.getPSSFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstyleid", (Object)PSDCAbilityBase.getJSONValue((Object)pSDCAbilityBase.getPSSFStyleId()), (boolean)false);
        }
        if (bl || pSDCAbilityBase.getPSSFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstylename", (Object)PSDCAbilityBase.getJSONValue((Object)pSDCAbilityBase.getPSSFStyleName()), (boolean)false);
        }
        if (bl || pSDCAbilityBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCAbilityBase.getJSONValue((Object)pSDCAbilityBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCAbilityBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCAbilityBase.getJSONValue((Object)pSDCAbilityBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCAbilityBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCAbilityBase pSDCAbilityBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCAbilityBase.getAbilityCat() != null) {
            object = pSDCAbilityBase.getAbilityCat();
            xmlNode.setAttribute(FIELD_ABILITYCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDCAbilityBase.getBeginTime() != null) {
            object = pSDCAbilityBase.getBeginTime();
            xmlNode.setAttribute(FIELD_BEGINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCAbilityBase.getCreateDate() != null) {
            object = pSDCAbilityBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCAbilityBase.getCreateMan() != null) {
            object = pSDCAbilityBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCAbilityBase.getEndTime() != null) {
            object = pSDCAbilityBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCAbilityBase.getMemo() != null) {
            object = pSDCAbilityBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCAbilityBase.getPSDBTypeId() != null) {
            object = pSDCAbilityBase.getPSDBTypeId();
            xmlNode.setAttribute(FIELD_PSDBTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDCAbilityBase.getPSDBTypeName() != null) {
            object = pSDCAbilityBase.getPSDBTypeName();
            xmlNode.setAttribute(FIELD_PSDBTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCAbilityBase.getPSDCAbilityId() != null) {
            object = pSDCAbilityBase.getPSDCAbilityId();
            xmlNode.setAttribute(FIELD_PSDCABILITYID, object == null ? "" : (String)object);
        }
        if (bl || pSDCAbilityBase.getPSDCAbilityName() != null) {
            object = pSDCAbilityBase.getPSDCAbilityName();
            xmlNode.setAttribute(FIELD_PSDCABILITYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCAbilityBase.getPSDevCenterId() != null) {
            object = pSDCAbilityBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCAbilityBase.getPSDevCenterName() != null) {
            object = pSDCAbilityBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCAbilityBase.getPSPFId() != null) {
            object = pSDCAbilityBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSDCAbilityBase.getPSPFName() != null) {
            object = pSDCAbilityBase.getPSPFName();
            xmlNode.setAttribute(FIELD_PSPFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCAbilityBase.getPSPFStyleId() != null) {
            object = pSDCAbilityBase.getPSPFStyleId();
            xmlNode.setAttribute(FIELD_PSPFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSDCAbilityBase.getPSPFStyleName() != null) {
            object = pSDCAbilityBase.getPSPFStyleName();
            xmlNode.setAttribute(FIELD_PSPFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCAbilityBase.getPSSFId() != null) {
            object = pSDCAbilityBase.getPSSFId();
            xmlNode.setAttribute(FIELD_PSSFID, object == null ? "" : (String)object);
        }
        if (bl || pSDCAbilityBase.getPSSFName() != null) {
            object = pSDCAbilityBase.getPSSFName();
            xmlNode.setAttribute(FIELD_PSSFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCAbilityBase.getPSSFStyleId() != null) {
            object = pSDCAbilityBase.getPSSFStyleId();
            xmlNode.setAttribute(FIELD_PSSFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSDCAbilityBase.getPSSFStyleName() != null) {
            object = pSDCAbilityBase.getPSSFStyleName();
            xmlNode.setAttribute(FIELD_PSSFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCAbilityBase.getUpdateDate() != null) {
            object = pSDCAbilityBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCAbilityBase.getUpdateMan() != null) {
            object = pSDCAbilityBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCAbilityBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCAbilityBase pSDCAbilityBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCAbilityBase.isAbilityCatDirty() && (bl || pSDCAbilityBase.getAbilityCat() != null)) {
            iDataObject.set(FIELD_ABILITYCAT, (Object)pSDCAbilityBase.getAbilityCat());
        }
        if (pSDCAbilityBase.isBeginTimeDirty() && (bl || pSDCAbilityBase.getBeginTime() != null)) {
            iDataObject.set(FIELD_BEGINTIME, (Object)pSDCAbilityBase.getBeginTime());
        }
        if (pSDCAbilityBase.isCreateDateDirty() && (bl || pSDCAbilityBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCAbilityBase.getCreateDate());
        }
        if (pSDCAbilityBase.isCreateManDirty() && (bl || pSDCAbilityBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCAbilityBase.getCreateMan());
        }
        if (pSDCAbilityBase.isEndTimeDirty() && (bl || pSDCAbilityBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSDCAbilityBase.getEndTime());
        }
        if (pSDCAbilityBase.isMemoDirty() && (bl || pSDCAbilityBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCAbilityBase.getMemo());
        }
        if (pSDCAbilityBase.isPSDBTypeIdDirty() && (bl || pSDCAbilityBase.getPSDBTypeId() != null)) {
            iDataObject.set(FIELD_PSDBTYPEID, (Object)pSDCAbilityBase.getPSDBTypeId());
        }
        if (pSDCAbilityBase.isPSDBTypeNameDirty() && (bl || pSDCAbilityBase.getPSDBTypeName() != null)) {
            iDataObject.set(FIELD_PSDBTYPENAME, (Object)pSDCAbilityBase.getPSDBTypeName());
        }
        if (pSDCAbilityBase.isPSDCAbilityIdDirty() && (bl || pSDCAbilityBase.getPSDCAbilityId() != null)) {
            iDataObject.set(FIELD_PSDCABILITYID, (Object)pSDCAbilityBase.getPSDCAbilityId());
        }
        if (pSDCAbilityBase.isPSDCAbilityNameDirty() && (bl || pSDCAbilityBase.getPSDCAbilityName() != null)) {
            iDataObject.set(FIELD_PSDCABILITYNAME, (Object)pSDCAbilityBase.getPSDCAbilityName());
        }
        if (pSDCAbilityBase.isPSDevCenterIdDirty() && (bl || pSDCAbilityBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCAbilityBase.getPSDevCenterId());
        }
        if (pSDCAbilityBase.isPSDevCenterNameDirty() && (bl || pSDCAbilityBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCAbilityBase.getPSDevCenterName());
        }
        if (pSDCAbilityBase.isPSPFIdDirty() && (bl || pSDCAbilityBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSDCAbilityBase.getPSPFId());
        }
        if (pSDCAbilityBase.isPSPFNameDirty() && (bl || pSDCAbilityBase.getPSPFName() != null)) {
            iDataObject.set(FIELD_PSPFNAME, (Object)pSDCAbilityBase.getPSPFName());
        }
        if (pSDCAbilityBase.isPSPFStyleIdDirty() && (bl || pSDCAbilityBase.getPSPFStyleId() != null)) {
            iDataObject.set(FIELD_PSPFSTYLEID, (Object)pSDCAbilityBase.getPSPFStyleId());
        }
        if (pSDCAbilityBase.isPSPFStyleNameDirty() && (bl || pSDCAbilityBase.getPSPFStyleName() != null)) {
            iDataObject.set(FIELD_PSPFSTYLENAME, (Object)pSDCAbilityBase.getPSPFStyleName());
        }
        if (pSDCAbilityBase.isPSSFIdDirty() && (bl || pSDCAbilityBase.getPSSFId() != null)) {
            iDataObject.set(FIELD_PSSFID, (Object)pSDCAbilityBase.getPSSFId());
        }
        if (pSDCAbilityBase.isPSSFNameDirty() && (bl || pSDCAbilityBase.getPSSFName() != null)) {
            iDataObject.set(FIELD_PSSFNAME, (Object)pSDCAbilityBase.getPSSFName());
        }
        if (pSDCAbilityBase.isPSSFStyleIdDirty() && (bl || pSDCAbilityBase.getPSSFStyleId() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEID, (Object)pSDCAbilityBase.getPSSFStyleId());
        }
        if (pSDCAbilityBase.isPSSFStyleNameDirty() && (bl || pSDCAbilityBase.getPSSFStyleName() != null)) {
            iDataObject.set(FIELD_PSSFSTYLENAME, (Object)pSDCAbilityBase.getPSSFStyleName());
        }
        if (pSDCAbilityBase.isUpdateDateDirty() && (bl || pSDCAbilityBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCAbilityBase.getUpdateDate());
        }
        if (pSDCAbilityBase.isUpdateManDirty() && (bl || pSDCAbilityBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCAbilityBase.getUpdateMan());
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
        return PSDCAbilityBase.remove(this, n);
    }

    private static boolean remove(PSDCAbilityBase pSDCAbilityBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCAbilityBase.resetAbilityCat();
                return true;
            }
            case 1: {
                pSDCAbilityBase.resetBeginTime();
                return true;
            }
            case 2: {
                pSDCAbilityBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDCAbilityBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDCAbilityBase.resetEndTime();
                return true;
            }
            case 5: {
                pSDCAbilityBase.resetMemo();
                return true;
            }
            case 6: {
                pSDCAbilityBase.resetPSDBTypeId();
                return true;
            }
            case 7: {
                pSDCAbilityBase.resetPSDBTypeName();
                return true;
            }
            case 8: {
                pSDCAbilityBase.resetPSDCAbilityId();
                return true;
            }
            case 9: {
                pSDCAbilityBase.resetPSDCAbilityName();
                return true;
            }
            case 10: {
                pSDCAbilityBase.resetPSDevCenterId();
                return true;
            }
            case 11: {
                pSDCAbilityBase.resetPSDevCenterName();
                return true;
            }
            case 12: {
                pSDCAbilityBase.resetPSPFId();
                return true;
            }
            case 13: {
                pSDCAbilityBase.resetPSPFName();
                return true;
            }
            case 14: {
                pSDCAbilityBase.resetPSPFStyleId();
                return true;
            }
            case 15: {
                pSDCAbilityBase.resetPSPFStyleName();
                return true;
            }
            case 16: {
                pSDCAbilityBase.resetPSSFId();
                return true;
            }
            case 17: {
                pSDCAbilityBase.resetPSSFName();
                return true;
            }
            case 18: {
                pSDCAbilityBase.resetPSSFStyleId();
                return true;
            }
            case 19: {
                pSDCAbilityBase.resetPSSFStyleName();
                return true;
            }
            case 20: {
                pSDCAbilityBase.resetUpdateDate();
                return true;
            }
            case 21: {
                pSDCAbilityBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDBType getPSDBType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBType();
        }
        if (this.getPSDBTypeId() == null) {
            return null;
        }
        Integer n = this.objPSDBTypeLock;
        synchronized (n) {
            if (this.psdbtype != null && DataTypeHelper.compare((int)25, (Object)this.getPSDBTypeId(), (Object)this.psdbtype.getPSDBTypeId()) != 0L) {
                this.psdbtype = null;
            }
            if (this.psdbtype == null) {
                PSDBType pSDBType = new PSDBType();
                pSDBType.setPSDBTypeId(this.getPSDBTypeId());
                PSDBTypeService pSDBTypeService = (PSDBTypeService)ServiceGlobal.getService(PSDBTypeService.class, (SessionFactory)this.getSessionFactory());
                pSDBTypeService.autoGet(pSDBType);
                this.psdbtype = pSDBType;
            }
            return this.psdbtype;
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
                pSDevCenterService.autoGet(pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPFStyle getPSPSStyle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPSStyle();
        }
        if (this.getPSPFStyleId() == null) {
            return null;
        }
        Integer n = this.objPSPSStyleLock;
        synchronized (n) {
            if (this.pspsstyle != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFStyleId(), (Object)this.pspsstyle.getPSPFStyleId()) != 0L) {
                this.pspsstyle = null;
            }
            if (this.pspsstyle == null) {
                PSPFStyle pSPFStyle = new PSPFStyle();
                pSPFStyle.setPSPFStyleId(this.getPSPFStyleId());
                PSPFStyleService pSPFStyleService = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)this.getSessionFactory());
                pSPFStyleService.autoGet(pSPFStyle);
                this.pspsstyle = pSPFStyle;
            }
            return this.pspsstyle;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPF getPSPF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPF();
        }
        if (this.getPSPFId() == null) {
            return null;
        }
        Integer n = this.objPSPFLock;
        synchronized (n) {
            if (this.pspf != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFId(), (Object)this.pspf.getPSPFId()) != 0L) {
                this.pspf = null;
            }
            if (this.pspf == null) {
                PSPF pSPF = new PSPF();
                pSPF.setPSPFId(this.getPSPFId());
                PSPFService pSPFService = (PSPFService)ServiceGlobal.getService(PSPFService.class, (SessionFactory)this.getSessionFactory());
                pSPFService.autoGet(pSPF);
                this.pspf = pSPF;
            }
            return this.pspf;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSFStyle getPSSFStyle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyle();
        }
        if (this.getPSSFStyleId() == null) {
            return null;
        }
        Integer n = this.objPSSFStyleLock;
        synchronized (n) {
            if (this.pssfstyle != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFStyleId(), (Object)this.pssfstyle.getPSSFStyleId()) != 0L) {
                this.pssfstyle = null;
            }
            if (this.pssfstyle == null) {
                PSSFStyle pSSFStyle = new PSSFStyle();
                pSSFStyle.setPSSFStyleId(this.getPSSFStyleId());
                PSSFStyleService pSSFStyleService = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)this.getSessionFactory());
                pSSFStyleService.autoGet(pSSFStyle);
                this.pssfstyle = pSSFStyle;
            }
            return this.pssfstyle;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSF getPSSF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSF();
        }
        if (this.getPSSFId() == null) {
            return null;
        }
        Integer n = this.objPSSFLock;
        synchronized (n) {
            if (this.pssf != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFId(), (Object)this.pssf.getPSSFId()) != 0L) {
                this.pssf = null;
            }
            if (this.pssf == null) {
                PSSF pSSF = new PSSF();
                pSSF.setPSSFId(this.getPSSFId());
                PSSFService pSSFService = (PSSFService)ServiceGlobal.getService(PSSFService.class, (SessionFactory)this.getSessionFactory());
                pSSFService.autoGet(pSSF);
                this.pssf = pSSF;
            }
            return this.pssf;
        }
    }

    private PSDCAbilityBase getProxyEntity() {
        return this.proxyPSDCAbilityBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCAbilityBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCAbilityBase) {
            this.proxyPSDCAbilityBase = (PSDCAbilityBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCAbilityService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ABILITYCAT, 0);
        fieldIndexMap.put(FIELD_BEGINTIME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_ENDTIME, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSDBTYPEID, 6);
        fieldIndexMap.put(FIELD_PSDBTYPENAME, 7);
        fieldIndexMap.put(FIELD_PSDCABILITYID, 8);
        fieldIndexMap.put(FIELD_PSDCABILITYNAME, 9);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 10);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 11);
        fieldIndexMap.put(FIELD_PSPFID, 12);
        fieldIndexMap.put(FIELD_PSPFNAME, 13);
        fieldIndexMap.put(FIELD_PSPFSTYLEID, 14);
        fieldIndexMap.put(FIELD_PSPFSTYLENAME, 15);
        fieldIndexMap.put(FIELD_PSSFID, 16);
        fieldIndexMap.put(FIELD_PSSFNAME, 17);
        fieldIndexMap.put(FIELD_PSSFSTYLEID, 18);
        fieldIndexMap.put(FIELD_PSSFSTYLENAME, 19);
        fieldIndexMap.put(FIELD_UPDATEDATE, 20);
        fieldIndexMap.put(FIELD_UPDATEMAN, 21);
    }
}

