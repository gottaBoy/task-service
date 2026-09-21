/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.common.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.psrt.srv.common.entity.Org;
import net.ibizsys.psrt.srv.common.entity.OrgSector;
import net.ibizsys.psrt.srv.common.service.OrgSectorService;
import net.ibizsys.psrt.srv.common.service.OrgService;
import net.ibizsys.psrt.srv.demodel.entity.DataEntity;
import net.ibizsys.psrt.srv.demodel.service.DataEntityService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class UserRoleDataBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(UserRoleDataBase.class);
    public static final String FIELD_BCDR = "BCDR";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEID = "DEID";
    public static final String FIELD_DENAME = "DENAME";
    public static final String FIELD_DSTORGID = "DSTORGID";
    public static final String FIELD_DSTORGNAME = "DSTORGNAME";
    public static final String FIELD_DSTORGSECTORID = "DSTORGSECTORID";
    public static final String FIELD_DSTORGSECTORNAME = "DSTORGSECTORNAME";
    public static final String FIELD_DSTSECBC = "DSTSECBC";
    public static final String FIELD_ISALLDATA = "ISALLDATA";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORGDR = "ORGDR";
    public static final String FIELD_RESERVER = "RESERVER";
    public static final String FIELD_RESERVER2 = "RESERVER2";
    public static final String FIELD_RESERVER3 = "RESERVER3";
    public static final String FIELD_RESERVER4 = "RESERVER4";
    public static final String FIELD_SECDR = "SECDR";
    public static final String FIELD_SRFSYSPUB = "SRFSYSPUB";
    public static final String FIELD_SRFUSERPUB = "SRFUSERPUB";
    public static final String FIELD_UDVERSION = "UDVERSION";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERDR = "USERDR";
    public static final String FIELD_USERROLEDATAID = "USERROLEDATAID";
    public static final String FIELD_USERROLEDATANAME = "USERROLEDATANAME";
    private static final int INDEX_BCDR = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DEID = 3;
    private static final int INDEX_DENAME = 4;
    private static final int INDEX_DSTORGID = 5;
    private static final int INDEX_DSTORGNAME = 6;
    private static final int INDEX_DSTORGSECTORID = 7;
    private static final int INDEX_DSTORGSECTORNAME = 8;
    private static final int INDEX_DSTSECBC = 9;
    private static final int INDEX_ISALLDATA = 10;
    private static final int INDEX_MEMO = 11;
    private static final int INDEX_ORGDR = 12;
    private static final int INDEX_RESERVER = 13;
    private static final int INDEX_RESERVER2 = 14;
    private static final int INDEX_RESERVER3 = 15;
    private static final int INDEX_RESERVER4 = 16;
    private static final int INDEX_SECDR = 17;
    private static final int INDEX_SRFSYSPUB = 18;
    private static final int INDEX_SRFUSERPUB = 19;
    private static final int INDEX_UDVERSION = 20;
    private static final int INDEX_UPDATEDATE = 21;
    private static final int INDEX_UPDATEMAN = 22;
    private static final int INDEX_USERDR = 23;
    private static final int INDEX_USERROLEDATAID = 24;
    private static final int INDEX_USERROLEDATANAME = 25;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private UserRoleDataBase proxyUserRoleDataBase = null;
    private boolean bcdrDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean deidDirtyFlag = false;
    private boolean denameDirtyFlag = false;
    private boolean dstorgidDirtyFlag = false;
    private boolean dstorgnameDirtyFlag = false;
    private boolean dstorgsectoridDirtyFlag = false;
    private boolean dstorgsectornameDirtyFlag = false;
    private boolean dstsecbcDirtyFlag = false;
    private boolean isalldataDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean orgdrDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean reserver3DirtyFlag = false;
    private boolean reserver4DirtyFlag = false;
    private boolean secdrDirtyFlag = false;
    private boolean srfsyspubDirtyFlag = false;
    private boolean srfuserpubDirtyFlag = false;
    private boolean udversionDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userdrDirtyFlag = false;
    private boolean userroledataidDirtyFlag = false;
    private boolean userroledatanameDirtyFlag = false;
    @Column(name="bcdr")
    private Integer bcdr;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="deid")
    private String deid;
    @Column(name="dename")
    private String dename;
    @Column(name="dstorgid")
    private String dstorgid;
    @Column(name="dstorgname")
    private String dstorgname;
    @Column(name="dstorgsectorid")
    private String dstorgsectorid;
    @Column(name="dstorgsectorname")
    private String dstorgsectorname;
    @Column(name="dstsecbc")
    private String dstsecbc;
    @Column(name="isalldata")
    private Integer isalldata;
    @Column(name="memo")
    private String memo;
    @Column(name="orgdr")
    private Integer orgdr;
    @Column(name="reserver")
    private String reserver;
    @Column(name="reserver2")
    private String reserver2;
    @Column(name="reserver3")
    private String reserver3;
    @Column(name="reserver4")
    private String reserver4;
    @Column(name="secdr")
    private Integer secdr;
    @Column(name="srfsyspub")
    private Integer srfsyspub;
    @Column(name="srfuserpub")
    private Integer srfuserpub;
    @Column(name="udversion")
    private Integer udversion;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userdr")
    private Integer userdr;
    @Column(name="userroledataid")
    private String userroledataid;
    @Column(name="userroledataname")
    private String userroledataname;
    private Integer objDELock = new Integer(1);
    private DataEntity de = null;
    private Integer objDstOrgSectorLock = new Integer(1);
    private OrgSector dstorgsector = null;
    private Integer objDstOrgLock = new Integer(1);
    private Org dstorg = null;

    static {
        fieldIndexMap.put(FIELD_BCDR, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DEID, 3);
        fieldIndexMap.put(FIELD_DENAME, 4);
        fieldIndexMap.put(FIELD_DSTORGID, 5);
        fieldIndexMap.put(FIELD_DSTORGNAME, 6);
        fieldIndexMap.put(FIELD_DSTORGSECTORID, 7);
        fieldIndexMap.put(FIELD_DSTORGSECTORNAME, 8);
        fieldIndexMap.put(FIELD_DSTSECBC, 9);
        fieldIndexMap.put(FIELD_ISALLDATA, 10);
        fieldIndexMap.put(FIELD_MEMO, 11);
        fieldIndexMap.put(FIELD_ORGDR, 12);
        fieldIndexMap.put(FIELD_RESERVER, 13);
        fieldIndexMap.put(FIELD_RESERVER2, 14);
        fieldIndexMap.put(FIELD_RESERVER3, 15);
        fieldIndexMap.put(FIELD_RESERVER4, 16);
        fieldIndexMap.put(FIELD_SECDR, 17);
        fieldIndexMap.put(FIELD_SRFSYSPUB, 18);
        fieldIndexMap.put(FIELD_SRFUSERPUB, 19);
        fieldIndexMap.put(FIELD_UDVERSION, 20);
        fieldIndexMap.put(FIELD_UPDATEDATE, 21);
        fieldIndexMap.put(FIELD_UPDATEMAN, 22);
        fieldIndexMap.put(FIELD_USERDR, 23);
        fieldIndexMap.put(FIELD_USERROLEDATAID, 24);
        fieldIndexMap.put(FIELD_USERROLEDATANAME, 25);
    }

    public void setBCDR(Integer bcdr) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBCDR(bcdr);
            return;
        }
        this.bcdr = bcdr;
        this.bcdrDirtyFlag = true;
    }

    public Integer getBCDR() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBCDR();
        }
        return this.bcdr;
    }

    public boolean isBCDRDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBCDRDirty();
        }
        return this.bcdrDirtyFlag;
    }

    public void resetBCDR() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBCDR();
            return;
        }
        this.bcdrDirtyFlag = false;
        this.bcdr = null;
    }

    public void setCreateDate(Timestamp createdate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDate(createdate);
            return;
        }
        this.createdate = createdate;
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

    public void setCreateMan(String createman) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateMan(createman);
            return;
        }
        if (createman != null && (createman = StringHelper.trimRight(createman)).length() == 0) {
            createman = null;
        }
        this.createman = createman;
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

    public void setDEId(String deid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEId(deid);
            return;
        }
        if (deid != null && (deid = StringHelper.trimRight(deid)).length() == 0) {
            deid = null;
        }
        this.deid = deid;
        this.deidDirtyFlag = true;
    }

    public String getDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEId();
        }
        return this.deid;
    }

    public boolean isDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEIdDirty();
        }
        return this.deidDirtyFlag;
    }

    public void resetDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEId();
            return;
        }
        this.deidDirtyFlag = false;
        this.deid = null;
    }

    public void setDEName(String dename) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEName(dename);
            return;
        }
        if (dename != null && (dename = StringHelper.trimRight(dename)).length() == 0) {
            dename = null;
        }
        this.dename = dename;
        this.denameDirtyFlag = true;
    }

    public String getDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEName();
        }
        return this.dename;
    }

    public boolean isDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDENameDirty();
        }
        return this.denameDirtyFlag;
    }

    public void resetDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEName();
            return;
        }
        this.denameDirtyFlag = false;
        this.dename = null;
    }

    public void setDstOrgId(String dstorgid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstOrgId(dstorgid);
            return;
        }
        if (dstorgid != null && (dstorgid = StringHelper.trimRight(dstorgid)).length() == 0) {
            dstorgid = null;
        }
        this.dstorgid = dstorgid;
        this.dstorgidDirtyFlag = true;
    }

    public String getDstOrgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstOrgId();
        }
        return this.dstorgid;
    }

    public boolean isDstOrgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstOrgIdDirty();
        }
        return this.dstorgidDirtyFlag;
    }

    public void resetDstOrgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstOrgId();
            return;
        }
        this.dstorgidDirtyFlag = false;
        this.dstorgid = null;
    }

    public void setDstOrgName(String dstorgname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstOrgName(dstorgname);
            return;
        }
        if (dstorgname != null && (dstorgname = StringHelper.trimRight(dstorgname)).length() == 0) {
            dstorgname = null;
        }
        this.dstorgname = dstorgname;
        this.dstorgnameDirtyFlag = true;
    }

    public String getDstOrgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstOrgName();
        }
        return this.dstorgname;
    }

    public boolean isDstOrgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstOrgNameDirty();
        }
        return this.dstorgnameDirtyFlag;
    }

    public void resetDstOrgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstOrgName();
            return;
        }
        this.dstorgnameDirtyFlag = false;
        this.dstorgname = null;
    }

    public void setDstOrgSectorId(String dstorgsectorid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstOrgSectorId(dstorgsectorid);
            return;
        }
        if (dstorgsectorid != null && (dstorgsectorid = StringHelper.trimRight(dstorgsectorid)).length() == 0) {
            dstorgsectorid = null;
        }
        this.dstorgsectorid = dstorgsectorid;
        this.dstorgsectoridDirtyFlag = true;
    }

    public String getDstOrgSectorId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstOrgSectorId();
        }
        return this.dstorgsectorid;
    }

    public boolean isDstOrgSectorIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstOrgSectorIdDirty();
        }
        return this.dstorgsectoridDirtyFlag;
    }

    public void resetDstOrgSectorId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstOrgSectorId();
            return;
        }
        this.dstorgsectoridDirtyFlag = false;
        this.dstorgsectorid = null;
    }

    public void setDstOrgSectorName(String dstorgsectorname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstOrgSectorName(dstorgsectorname);
            return;
        }
        if (dstorgsectorname != null && (dstorgsectorname = StringHelper.trimRight(dstorgsectorname)).length() == 0) {
            dstorgsectorname = null;
        }
        this.dstorgsectorname = dstorgsectorname;
        this.dstorgsectornameDirtyFlag = true;
    }

    public String getDstOrgSectorName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstOrgSectorName();
        }
        return this.dstorgsectorname;
    }

    public boolean isDstOrgSectorNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstOrgSectorNameDirty();
        }
        return this.dstorgsectornameDirtyFlag;
    }

    public void resetDstOrgSectorName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstOrgSectorName();
            return;
        }
        this.dstorgsectornameDirtyFlag = false;
        this.dstorgsectorname = null;
    }

    public void setDstSecBC(String dstsecbc) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstSecBC(dstsecbc);
            return;
        }
        if (dstsecbc != null && (dstsecbc = StringHelper.trimRight(dstsecbc)).length() == 0) {
            dstsecbc = null;
        }
        this.dstsecbc = dstsecbc;
        this.dstsecbcDirtyFlag = true;
    }

    public String getDstSecBC() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstSecBC();
        }
        return this.dstsecbc;
    }

    public boolean isDstSecBCDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstSecBCDirty();
        }
        return this.dstsecbcDirtyFlag;
    }

    public void resetDstSecBC() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstSecBC();
            return;
        }
        this.dstsecbcDirtyFlag = false;
        this.dstsecbc = null;
    }

    public void setIsAllData(Integer isalldata) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIsAllData(isalldata);
            return;
        }
        this.isalldata = isalldata;
        this.isalldataDirtyFlag = true;
    }

    public Integer getIsAllData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIsAllData();
        }
        return this.isalldata;
    }

    public boolean isIsAllDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIsAllDataDirty();
        }
        return this.isalldataDirtyFlag;
    }

    public void resetIsAllData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIsAllData();
            return;
        }
        this.isalldataDirtyFlag = false;
        this.isalldata = null;
    }

    public void setMemo(String memo) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMemo(memo);
            return;
        }
        if (memo != null && (memo = StringHelper.trimRight(memo)).length() == 0) {
            memo = null;
        }
        this.memo = memo;
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

    public void setOrgDR(Integer orgdr) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrgDR(orgdr);
            return;
        }
        this.orgdr = orgdr;
        this.orgdrDirtyFlag = true;
    }

    public Integer getOrgDR() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrgDR();
        }
        return this.orgdr;
    }

    public boolean isOrgDRDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrgDRDirty();
        }
        return this.orgdrDirtyFlag;
    }

    public void resetOrgDR() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrgDR();
            return;
        }
        this.orgdrDirtyFlag = false;
        this.orgdr = null;
    }

    public void setReserver(String reserver) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver(reserver);
            return;
        }
        if (reserver != null && (reserver = StringHelper.trimRight(reserver)).length() == 0) {
            reserver = null;
        }
        this.reserver = reserver;
        this.reserverDirtyFlag = true;
    }

    public String getReserver() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver();
        }
        return this.reserver;
    }

    public boolean isReserverDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserverDirty();
        }
        return this.reserverDirtyFlag;
    }

    public void resetReserver() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver();
            return;
        }
        this.reserverDirtyFlag = false;
        this.reserver = null;
    }

    public void setReserver2(String reserver2) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver2(reserver2);
            return;
        }
        if (reserver2 != null && (reserver2 = StringHelper.trimRight(reserver2)).length() == 0) {
            reserver2 = null;
        }
        this.reserver2 = reserver2;
        this.reserver2DirtyFlag = true;
    }

    public String getReserver2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver2();
        }
        return this.reserver2;
    }

    public boolean isReserver2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver2Dirty();
        }
        return this.reserver2DirtyFlag;
    }

    public void resetReserver2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver2();
            return;
        }
        this.reserver2DirtyFlag = false;
        this.reserver2 = null;
    }

    public void setReserver3(String reserver3) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver3(reserver3);
            return;
        }
        if (reserver3 != null && (reserver3 = StringHelper.trimRight(reserver3)).length() == 0) {
            reserver3 = null;
        }
        this.reserver3 = reserver3;
        this.reserver3DirtyFlag = true;
    }

    public String getReserver3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver3();
        }
        return this.reserver3;
    }

    public boolean isReserver3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver3Dirty();
        }
        return this.reserver3DirtyFlag;
    }

    public void resetReserver3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver3();
            return;
        }
        this.reserver3DirtyFlag = false;
        this.reserver3 = null;
    }

    public void setReserver4(String reserver4) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver4(reserver4);
            return;
        }
        if (reserver4 != null && (reserver4 = StringHelper.trimRight(reserver4)).length() == 0) {
            reserver4 = null;
        }
        this.reserver4 = reserver4;
        this.reserver4DirtyFlag = true;
    }

    public String getReserver4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver4();
        }
        return this.reserver4;
    }

    public boolean isReserver4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver4Dirty();
        }
        return this.reserver4DirtyFlag;
    }

    public void resetReserver4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver4();
            return;
        }
        this.reserver4DirtyFlag = false;
        this.reserver4 = null;
    }

    public void setSecDR(Integer secdr) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSecDR(secdr);
            return;
        }
        this.secdr = secdr;
        this.secdrDirtyFlag = true;
    }

    public Integer getSecDR() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSecDR();
        }
        return this.secdr;
    }

    public boolean isSecDRDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSecDRDirty();
        }
        return this.secdrDirtyFlag;
    }

    public void resetSecDR() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSecDR();
            return;
        }
        this.secdrDirtyFlag = false;
        this.secdr = null;
    }

    public void setSRFSysPub(Integer srfsyspub) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSRFSysPub(srfsyspub);
            return;
        }
        this.srfsyspub = srfsyspub;
        this.srfsyspubDirtyFlag = true;
    }

    public Integer getSRFSysPub() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSRFSysPub();
        }
        return this.srfsyspub;
    }

    public boolean isSRFSysPubDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSRFSysPubDirty();
        }
        return this.srfsyspubDirtyFlag;
    }

    public void resetSRFSysPub() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSRFSysPub();
            return;
        }
        this.srfsyspubDirtyFlag = false;
        this.srfsyspub = null;
    }

    public void setSRFUserPub(Integer srfuserpub) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSRFUserPub(srfuserpub);
            return;
        }
        this.srfuserpub = srfuserpub;
        this.srfuserpubDirtyFlag = true;
    }

    public Integer getSRFUserPub() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSRFUserPub();
        }
        return this.srfuserpub;
    }

    public boolean isSRFUserPubDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSRFUserPubDirty();
        }
        return this.srfuserpubDirtyFlag;
    }

    public void resetSRFUserPub() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSRFUserPub();
            return;
        }
        this.srfuserpubDirtyFlag = false;
        this.srfuserpub = null;
    }

    public void setUDVersion(Integer udversion) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUDVersion(udversion);
            return;
        }
        this.udversion = udversion;
        this.udversionDirtyFlag = true;
    }

    public Integer getUDVersion() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUDVersion();
        }
        return this.udversion;
    }

    public boolean isUDVersionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUDVersionDirty();
        }
        return this.udversionDirtyFlag;
    }

    public void resetUDVersion() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUDVersion();
            return;
        }
        this.udversionDirtyFlag = false;
        this.udversion = null;
    }

    public void setUpdateDate(Timestamp updatedate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDate(updatedate);
            return;
        }
        this.updatedate = updatedate;
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

    public void setUpdateMan(String updateman) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateMan(updateman);
            return;
        }
        if (updateman != null && (updateman = StringHelper.trimRight(updateman)).length() == 0) {
            updateman = null;
        }
        this.updateman = updateman;
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

    public void setUserDR(Integer userdr) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserDR(userdr);
            return;
        }
        this.userdr = userdr;
        this.userdrDirtyFlag = true;
    }

    public Integer getUserDR() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserDR();
        }
        return this.userdr;
    }

    public boolean isUserDRDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDRDirty();
        }
        return this.userdrDirtyFlag;
    }

    public void resetUserDR() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserDR();
            return;
        }
        this.userdrDirtyFlag = false;
        this.userdr = null;
    }

    public void setUserRoleDataId(String userroledataid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserRoleDataId(userroledataid);
            return;
        }
        if (userroledataid != null && (userroledataid = StringHelper.trimRight(userroledataid)).length() == 0) {
            userroledataid = null;
        }
        this.userroledataid = userroledataid;
        this.userroledataidDirtyFlag = true;
    }

    public String getUserRoleDataId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserRoleDataId();
        }
        return this.userroledataid;
    }

    public boolean isUserRoleDataIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserRoleDataIdDirty();
        }
        return this.userroledataidDirtyFlag;
    }

    public void resetUserRoleDataId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserRoleDataId();
            return;
        }
        this.userroledataidDirtyFlag = false;
        this.userroledataid = null;
    }

    public void setUserRoleDataName(String userroledataname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserRoleDataName(userroledataname);
            return;
        }
        if (userroledataname != null && (userroledataname = StringHelper.trimRight(userroledataname)).length() == 0) {
            userroledataname = null;
        }
        this.userroledataname = userroledataname;
        this.userroledatanameDirtyFlag = true;
    }

    public String getUserRoleDataName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserRoleDataName();
        }
        return this.userroledataname;
    }

    public boolean isUserRoleDataNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserRoleDataNameDirty();
        }
        return this.userroledatanameDirtyFlag;
    }

    public void resetUserRoleDataName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserRoleDataName();
            return;
        }
        this.userroledatanameDirtyFlag = false;
        this.userroledataname = null;
    }

    @Override
    protected void onReset() {
        UserRoleDataBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(UserRoleDataBase et) {
        et.resetBCDR();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetDEId();
        et.resetDEName();
        et.resetDstOrgId();
        et.resetDstOrgName();
        et.resetDstOrgSectorId();
        et.resetDstOrgSectorName();
        et.resetDstSecBC();
        et.resetIsAllData();
        et.resetMemo();
        et.resetOrgDR();
        et.resetReserver();
        et.resetReserver2();
        et.resetReserver3();
        et.resetReserver4();
        et.resetSecDR();
        et.resetSRFSysPub();
        et.resetSRFUserPub();
        et.resetUDVersion();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetUserDR();
        et.resetUserRoleDataId();
        et.resetUserRoleDataName();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isBCDRDirty()) {
            params.put(FIELD_BCDR, this.getBCDR());
        }
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isDEIdDirty()) {
            params.put(FIELD_DEID, this.getDEId());
        }
        if (!bDirtyOnly || this.isDENameDirty()) {
            params.put(FIELD_DENAME, this.getDEName());
        }
        if (!bDirtyOnly || this.isDstOrgIdDirty()) {
            params.put(FIELD_DSTORGID, this.getDstOrgId());
        }
        if (!bDirtyOnly || this.isDstOrgNameDirty()) {
            params.put(FIELD_DSTORGNAME, this.getDstOrgName());
        }
        if (!bDirtyOnly || this.isDstOrgSectorIdDirty()) {
            params.put(FIELD_DSTORGSECTORID, this.getDstOrgSectorId());
        }
        if (!bDirtyOnly || this.isDstOrgSectorNameDirty()) {
            params.put(FIELD_DSTORGSECTORNAME, this.getDstOrgSectorName());
        }
        if (!bDirtyOnly || this.isDstSecBCDirty()) {
            params.put(FIELD_DSTSECBC, this.getDstSecBC());
        }
        if (!bDirtyOnly || this.isIsAllDataDirty()) {
            params.put(FIELD_ISALLDATA, this.getIsAllData());
        }
        if (!bDirtyOnly || this.isMemoDirty()) {
            params.put(FIELD_MEMO, this.getMemo());
        }
        if (!bDirtyOnly || this.isOrgDRDirty()) {
            params.put(FIELD_ORGDR, this.getOrgDR());
        }
        if (!bDirtyOnly || this.isReserverDirty()) {
            params.put(FIELD_RESERVER, this.getReserver());
        }
        if (!bDirtyOnly || this.isReserver2Dirty()) {
            params.put(FIELD_RESERVER2, this.getReserver2());
        }
        if (!bDirtyOnly || this.isReserver3Dirty()) {
            params.put(FIELD_RESERVER3, this.getReserver3());
        }
        if (!bDirtyOnly || this.isReserver4Dirty()) {
            params.put(FIELD_RESERVER4, this.getReserver4());
        }
        if (!bDirtyOnly || this.isSecDRDirty()) {
            params.put(FIELD_SECDR, this.getSecDR());
        }
        if (!bDirtyOnly || this.isSRFSysPubDirty()) {
            params.put(FIELD_SRFSYSPUB, this.getSRFSysPub());
        }
        if (!bDirtyOnly || this.isSRFUserPubDirty()) {
            params.put(FIELD_SRFUSERPUB, this.getSRFUserPub());
        }
        if (!bDirtyOnly || this.isUDVersionDirty()) {
            params.put(FIELD_UDVERSION, this.getUDVersion());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isUserDRDirty()) {
            params.put(FIELD_USERDR, this.getUserDR());
        }
        if (!bDirtyOnly || this.isUserRoleDataIdDirty()) {
            params.put(FIELD_USERROLEDATAID, this.getUserRoleDataId());
        }
        if (!bDirtyOnly || this.isUserRoleDataNameDirty()) {
            params.put(FIELD_USERROLEDATANAME, this.getUserRoleDataName());
        }
        super.onFillMap(params, bDirtyOnly);
    }

    @Override
    public Object get(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().get(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.get(strParamName);
        }
        return UserRoleDataBase.get(this, index);
    }

    private static Object get(UserRoleDataBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getBCDR();
            }
            case 1: {
                return et.getCreateDate();
            }
            case 2: {
                return et.getCreateMan();
            }
            case 3: {
                return et.getDEId();
            }
            case 4: {
                return et.getDEName();
            }
            case 5: {
                return et.getDstOrgId();
            }
            case 6: {
                return et.getDstOrgName();
            }
            case 7: {
                return et.getDstOrgSectorId();
            }
            case 8: {
                return et.getDstOrgSectorName();
            }
            case 9: {
                return et.getDstSecBC();
            }
            case 10: {
                return et.getIsAllData();
            }
            case 11: {
                return et.getMemo();
            }
            case 12: {
                return et.getOrgDR();
            }
            case 13: {
                return et.getReserver();
            }
            case 14: {
                return et.getReserver2();
            }
            case 15: {
                return et.getReserver3();
            }
            case 16: {
                return et.getReserver4();
            }
            case 17: {
                return et.getSecDR();
            }
            case 18: {
                return et.getSRFSysPub();
            }
            case 19: {
                return et.getSRFUserPub();
            }
            case 20: {
                return et.getUDVersion();
            }
            case 21: {
                return et.getUpdateDate();
            }
            case 22: {
                return et.getUpdateMan();
            }
            case 23: {
                return et.getUserDR();
            }
            case 24: {
                return et.getUserRoleDataId();
            }
            case 25: {
                return et.getUserRoleDataName();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public void set(String strParamName, Object objValue) throws Exception {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().set(strParamName, objValue);
            return;
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            super.set(strParamName, objValue);
            return;
        }
        UserRoleDataBase.set(this, index, objValue);
    }

    private static void set(UserRoleDataBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setBCDR(DataObject.getIntegerValue(obj));
                return;
            }
            case 1: {
                et.setCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 2: {
                et.setCreateMan(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setDEId(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setDEName(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setDstOrgId(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setDstOrgName(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setDstOrgSectorId(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setDstOrgSectorName(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setDstSecBC(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setIsAllData(DataObject.getIntegerValue(obj));
                return;
            }
            case 11: {
                et.setMemo(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setOrgDR(DataObject.getIntegerValue(obj));
                return;
            }
            case 13: {
                et.setReserver(DataObject.getStringValue(obj));
                return;
            }
            case 14: {
                et.setReserver2(DataObject.getStringValue(obj));
                return;
            }
            case 15: {
                et.setReserver3(DataObject.getStringValue(obj));
                return;
            }
            case 16: {
                et.setReserver4(DataObject.getStringValue(obj));
                return;
            }
            case 17: {
                et.setSecDR(DataObject.getIntegerValue(obj));
                return;
            }
            case 18: {
                et.setSRFSysPub(DataObject.getIntegerValue(obj));
                return;
            }
            case 19: {
                et.setSRFUserPub(DataObject.getIntegerValue(obj));
                return;
            }
            case 20: {
                et.setUDVersion(DataObject.getIntegerValue(obj));
                return;
            }
            case 21: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 22: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 23: {
                et.setUserDR(DataObject.getIntegerValue(obj));
                return;
            }
            case 24: {
                et.setUserRoleDataId(DataObject.getStringValue(obj));
                return;
            }
            case 25: {
                et.setUserRoleDataName(DataObject.getStringValue(obj));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean isNull(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNull(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.isNull(strParamName);
        }
        return UserRoleDataBase.isNull(this, index);
    }

    private static boolean isNull(UserRoleDataBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getBCDR() == null;
            }
            case 1: {
                return et.getCreateDate() == null;
            }
            case 2: {
                return et.getCreateMan() == null;
            }
            case 3: {
                return et.getDEId() == null;
            }
            case 4: {
                return et.getDEName() == null;
            }
            case 5: {
                return et.getDstOrgId() == null;
            }
            case 6: {
                return et.getDstOrgName() == null;
            }
            case 7: {
                return et.getDstOrgSectorId() == null;
            }
            case 8: {
                return et.getDstOrgSectorName() == null;
            }
            case 9: {
                return et.getDstSecBC() == null;
            }
            case 10: {
                return et.getIsAllData() == null;
            }
            case 11: {
                return et.getMemo() == null;
            }
            case 12: {
                return et.getOrgDR() == null;
            }
            case 13: {
                return et.getReserver() == null;
            }
            case 14: {
                return et.getReserver2() == null;
            }
            case 15: {
                return et.getReserver3() == null;
            }
            case 16: {
                return et.getReserver4() == null;
            }
            case 17: {
                return et.getSecDR() == null;
            }
            case 18: {
                return et.getSRFSysPub() == null;
            }
            case 19: {
                return et.getSRFUserPub() == null;
            }
            case 20: {
                return et.getUDVersion() == null;
            }
            case 21: {
                return et.getUpdateDate() == null;
            }
            case 22: {
                return et.getUpdateMan() == null;
            }
            case 23: {
                return et.getUserDR() == null;
            }
            case 24: {
                return et.getUserRoleDataId() == null;
            }
            case 25: {
                return et.getUserRoleDataName() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean contains(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().contains(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.contains(strParamName);
        }
        return UserRoleDataBase.contains(this, index);
    }

    private static boolean contains(UserRoleDataBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isBCDRDirty();
            }
            case 1: {
                return et.isCreateDateDirty();
            }
            case 2: {
                return et.isCreateManDirty();
            }
            case 3: {
                return et.isDEIdDirty();
            }
            case 4: {
                return et.isDENameDirty();
            }
            case 5: {
                return et.isDstOrgIdDirty();
            }
            case 6: {
                return et.isDstOrgNameDirty();
            }
            case 7: {
                return et.isDstOrgSectorIdDirty();
            }
            case 8: {
                return et.isDstOrgSectorNameDirty();
            }
            case 9: {
                return et.isDstSecBCDirty();
            }
            case 10: {
                return et.isIsAllDataDirty();
            }
            case 11: {
                return et.isMemoDirty();
            }
            case 12: {
                return et.isOrgDRDirty();
            }
            case 13: {
                return et.isReserverDirty();
            }
            case 14: {
                return et.isReserver2Dirty();
            }
            case 15: {
                return et.isReserver3Dirty();
            }
            case 16: {
                return et.isReserver4Dirty();
            }
            case 17: {
                return et.isSecDRDirty();
            }
            case 18: {
                return et.isSRFSysPubDirty();
            }
            case 19: {
                return et.isSRFUserPubDirty();
            }
            case 20: {
                return et.isUDVersionDirty();
            }
            case 21: {
                return et.isUpdateDateDirty();
            }
            case 22: {
                return et.isUpdateManDirty();
            }
            case 23: {
                return et.isUserDRDirty();
            }
            case 24: {
                return et.isUserRoleDataIdDirty();
            }
            case 25: {
                return et.isUserRoleDataNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        UserRoleDataBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(UserRoleDataBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getBCDR() != null) {
            JSONObjectHelper.put(json, "bcdr", UserRoleDataBase.getJSONValue(et.getBCDR()), false);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", UserRoleDataBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", UserRoleDataBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getDEId() != null) {
            JSONObjectHelper.put(json, "deid", UserRoleDataBase.getJSONValue(et.getDEId()), false);
        }
        if (bIncEmpty || et.getDEName() != null) {
            JSONObjectHelper.put(json, "dename", UserRoleDataBase.getJSONValue(et.getDEName()), false);
        }
        if (bIncEmpty || et.getDstOrgId() != null) {
            JSONObjectHelper.put(json, "dstorgid", UserRoleDataBase.getJSONValue(et.getDstOrgId()), false);
        }
        if (bIncEmpty || et.getDstOrgName() != null) {
            JSONObjectHelper.put(json, "dstorgname", UserRoleDataBase.getJSONValue(et.getDstOrgName()), false);
        }
        if (bIncEmpty || et.getDstOrgSectorId() != null) {
            JSONObjectHelper.put(json, "dstorgsectorid", UserRoleDataBase.getJSONValue(et.getDstOrgSectorId()), false);
        }
        if (bIncEmpty || et.getDstOrgSectorName() != null) {
            JSONObjectHelper.put(json, "dstorgsectorname", UserRoleDataBase.getJSONValue(et.getDstOrgSectorName()), false);
        }
        if (bIncEmpty || et.getDstSecBC() != null) {
            JSONObjectHelper.put(json, "dstsecbc", UserRoleDataBase.getJSONValue(et.getDstSecBC()), false);
        }
        if (bIncEmpty || et.getIsAllData() != null) {
            JSONObjectHelper.put(json, "isalldata", UserRoleDataBase.getJSONValue(et.getIsAllData()), false);
        }
        if (bIncEmpty || et.getMemo() != null) {
            JSONObjectHelper.put(json, "memo", UserRoleDataBase.getJSONValue(et.getMemo()), false);
        }
        if (bIncEmpty || et.getOrgDR() != null) {
            JSONObjectHelper.put(json, "orgdr", UserRoleDataBase.getJSONValue(et.getOrgDR()), false);
        }
        if (bIncEmpty || et.getReserver() != null) {
            JSONObjectHelper.put(json, "reserver", UserRoleDataBase.getJSONValue(et.getReserver()), false);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            JSONObjectHelper.put(json, "reserver2", UserRoleDataBase.getJSONValue(et.getReserver2()), false);
        }
        if (bIncEmpty || et.getReserver3() != null) {
            JSONObjectHelper.put(json, "reserver3", UserRoleDataBase.getJSONValue(et.getReserver3()), false);
        }
        if (bIncEmpty || et.getReserver4() != null) {
            JSONObjectHelper.put(json, "reserver4", UserRoleDataBase.getJSONValue(et.getReserver4()), false);
        }
        if (bIncEmpty || et.getSecDR() != null) {
            JSONObjectHelper.put(json, "secdr", UserRoleDataBase.getJSONValue(et.getSecDR()), false);
        }
        if (bIncEmpty || et.getSRFSysPub() != null) {
            JSONObjectHelper.put(json, "srfsyspub", UserRoleDataBase.getJSONValue(et.getSRFSysPub()), false);
        }
        if (bIncEmpty || et.getSRFUserPub() != null) {
            JSONObjectHelper.put(json, "srfuserpub", UserRoleDataBase.getJSONValue(et.getSRFUserPub()), false);
        }
        if (bIncEmpty || et.getUDVersion() != null) {
            JSONObjectHelper.put(json, "udversion", UserRoleDataBase.getJSONValue(et.getUDVersion()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", UserRoleDataBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", UserRoleDataBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getUserDR() != null) {
            JSONObjectHelper.put(json, "userdr", UserRoleDataBase.getJSONValue(et.getUserDR()), false);
        }
        if (bIncEmpty || et.getUserRoleDataId() != null) {
            JSONObjectHelper.put(json, "userroledataid", UserRoleDataBase.getJSONValue(et.getUserRoleDataId()), false);
        }
        if (bIncEmpty || et.getUserRoleDataName() != null) {
            JSONObjectHelper.put(json, "userroledataname", UserRoleDataBase.getJSONValue(et.getUserRoleDataName()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        UserRoleDataBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(UserRoleDataBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getBCDR() != null) {
            obj = et.getBCDR();
            node.setAttribute(FIELD_BCDR, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDEId() != null) {
            obj = et.getDEId();
            node.setAttribute(FIELD_DEID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDEName() != null) {
            obj = et.getDEName();
            node.setAttribute(FIELD_DENAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDstOrgId() != null) {
            obj = et.getDstOrgId();
            node.setAttribute(FIELD_DSTORGID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDstOrgName() != null) {
            obj = et.getDstOrgName();
            node.setAttribute(FIELD_DSTORGNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDstOrgSectorId() != null) {
            obj = et.getDstOrgSectorId();
            node.setAttribute(FIELD_DSTORGSECTORID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDstOrgSectorName() != null) {
            obj = et.getDstOrgSectorName();
            node.setAttribute(FIELD_DSTORGSECTORNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDstSecBC() != null) {
            obj = et.getDstSecBC();
            node.setAttribute(FIELD_DSTSECBC, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getIsAllData() != null) {
            obj = et.getIsAllData();
            node.setAttribute(FIELD_ISALLDATA, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getMemo() != null) {
            obj = et.getMemo();
            node.setAttribute(FIELD_MEMO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getOrgDR() != null) {
            obj = et.getOrgDR();
            node.setAttribute(FIELD_ORGDR, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getReserver() != null) {
            obj = et.getReserver();
            node.setAttribute(FIELD_RESERVER, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            obj = et.getReserver2();
            node.setAttribute(FIELD_RESERVER2, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver3() != null) {
            obj = et.getReserver3();
            node.setAttribute(FIELD_RESERVER3, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver4() != null) {
            obj = et.getReserver4();
            node.setAttribute(FIELD_RESERVER4, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getSecDR() != null) {
            obj = et.getSecDR();
            node.setAttribute(FIELD_SECDR, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getSRFSysPub() != null) {
            obj = et.getSRFSysPub();
            node.setAttribute(FIELD_SRFSYSPUB, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getSRFUserPub() != null) {
            obj = et.getSRFUserPub();
            node.setAttribute(FIELD_SRFUSERPUB, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getUDVersion() != null) {
            obj = et.getUDVersion();
            node.setAttribute(FIELD_UDVERSION, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserDR() != null) {
            obj = et.getUserDR();
            node.setAttribute(FIELD_USERDR, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getUserRoleDataId() != null) {
            obj = et.getUserRoleDataId();
            node.setAttribute(FIELD_USERROLEDATAID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserRoleDataName() != null) {
            obj = et.getUserRoleDataName();
            node.setAttribute(FIELD_USERROLEDATANAME, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        UserRoleDataBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(UserRoleDataBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isBCDRDirty() && (bIncEmpty || et.getBCDR() != null)) {
            dst.set(FIELD_BCDR, et.getBCDR());
        }
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isDEIdDirty() && (bIncEmpty || et.getDEId() != null)) {
            dst.set(FIELD_DEID, et.getDEId());
        }
        if (et.isDENameDirty() && (bIncEmpty || et.getDEName() != null)) {
            dst.set(FIELD_DENAME, et.getDEName());
        }
        if (et.isDstOrgIdDirty() && (bIncEmpty || et.getDstOrgId() != null)) {
            dst.set(FIELD_DSTORGID, et.getDstOrgId());
        }
        if (et.isDstOrgNameDirty() && (bIncEmpty || et.getDstOrgName() != null)) {
            dst.set(FIELD_DSTORGNAME, et.getDstOrgName());
        }
        if (et.isDstOrgSectorIdDirty() && (bIncEmpty || et.getDstOrgSectorId() != null)) {
            dst.set(FIELD_DSTORGSECTORID, et.getDstOrgSectorId());
        }
        if (et.isDstOrgSectorNameDirty() && (bIncEmpty || et.getDstOrgSectorName() != null)) {
            dst.set(FIELD_DSTORGSECTORNAME, et.getDstOrgSectorName());
        }
        if (et.isDstSecBCDirty() && (bIncEmpty || et.getDstSecBC() != null)) {
            dst.set(FIELD_DSTSECBC, et.getDstSecBC());
        }
        if (et.isIsAllDataDirty() && (bIncEmpty || et.getIsAllData() != null)) {
            dst.set(FIELD_ISALLDATA, et.getIsAllData());
        }
        if (et.isMemoDirty() && (bIncEmpty || et.getMemo() != null)) {
            dst.set(FIELD_MEMO, et.getMemo());
        }
        if (et.isOrgDRDirty() && (bIncEmpty || et.getOrgDR() != null)) {
            dst.set(FIELD_ORGDR, et.getOrgDR());
        }
        if (et.isReserverDirty() && (bIncEmpty || et.getReserver() != null)) {
            dst.set(FIELD_RESERVER, et.getReserver());
        }
        if (et.isReserver2Dirty() && (bIncEmpty || et.getReserver2() != null)) {
            dst.set(FIELD_RESERVER2, et.getReserver2());
        }
        if (et.isReserver3Dirty() && (bIncEmpty || et.getReserver3() != null)) {
            dst.set(FIELD_RESERVER3, et.getReserver3());
        }
        if (et.isReserver4Dirty() && (bIncEmpty || et.getReserver4() != null)) {
            dst.set(FIELD_RESERVER4, et.getReserver4());
        }
        if (et.isSecDRDirty() && (bIncEmpty || et.getSecDR() != null)) {
            dst.set(FIELD_SECDR, et.getSecDR());
        }
        if (et.isSRFSysPubDirty() && (bIncEmpty || et.getSRFSysPub() != null)) {
            dst.set(FIELD_SRFSYSPUB, et.getSRFSysPub());
        }
        if (et.isSRFUserPubDirty() && (bIncEmpty || et.getSRFUserPub() != null)) {
            dst.set(FIELD_SRFUSERPUB, et.getSRFUserPub());
        }
        if (et.isUDVersionDirty() && (bIncEmpty || et.getUDVersion() != null)) {
            dst.set(FIELD_UDVERSION, et.getUDVersion());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isUserDRDirty() && (bIncEmpty || et.getUserDR() != null)) {
            dst.set(FIELD_USERDR, et.getUserDR());
        }
        if (et.isUserRoleDataIdDirty() && (bIncEmpty || et.getUserRoleDataId() != null)) {
            dst.set(FIELD_USERROLEDATAID, et.getUserRoleDataId());
        }
        if (et.isUserRoleDataNameDirty() && (bIncEmpty || et.getUserRoleDataName() != null)) {
            dst.set(FIELD_USERROLEDATANAME, et.getUserRoleDataName());
        }
    }

    @Override
    public boolean remove(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().remove(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.remove(strParamName);
        }
        return UserRoleDataBase.remove(this, index);
    }

    private static boolean remove(UserRoleDataBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetBCDR();
                return true;
            }
            case 1: {
                et.resetCreateDate();
                return true;
            }
            case 2: {
                et.resetCreateMan();
                return true;
            }
            case 3: {
                et.resetDEId();
                return true;
            }
            case 4: {
                et.resetDEName();
                return true;
            }
            case 5: {
                et.resetDstOrgId();
                return true;
            }
            case 6: {
                et.resetDstOrgName();
                return true;
            }
            case 7: {
                et.resetDstOrgSectorId();
                return true;
            }
            case 8: {
                et.resetDstOrgSectorName();
                return true;
            }
            case 9: {
                et.resetDstSecBC();
                return true;
            }
            case 10: {
                et.resetIsAllData();
                return true;
            }
            case 11: {
                et.resetMemo();
                return true;
            }
            case 12: {
                et.resetOrgDR();
                return true;
            }
            case 13: {
                et.resetReserver();
                return true;
            }
            case 14: {
                et.resetReserver2();
                return true;
            }
            case 15: {
                et.resetReserver3();
                return true;
            }
            case 16: {
                et.resetReserver4();
                return true;
            }
            case 17: {
                et.resetSecDR();
                return true;
            }
            case 18: {
                et.resetSRFSysPub();
                return true;
            }
            case 19: {
                et.resetSRFUserPub();
                return true;
            }
            case 20: {
                et.resetUDVersion();
                return true;
            }
            case 21: {
                et.resetUpdateDate();
                return true;
            }
            case 22: {
                et.resetUpdateMan();
                return true;
            }
            case 23: {
                et.resetUserDR();
                return true;
            }
            case 24: {
                et.resetUserRoleDataId();
                return true;
            }
            case 25: {
                et.resetUserRoleDataName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public DataEntity getDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDE();
        }
        if (this.getDEId() == null) {
            return null;
        }
        Integer n = this.objDELock;
        synchronized (n) {
            if (this.de != null && DataTypeHelper.compare(25, (Object)this.getDEId(), (Object)this.de.getDEId()) != 0L) {
                this.de = null;
            }
            if (this.de == null) {
                DataEntity de = new DataEntity();
                de.setDEId(this.getDEId());
                DataEntityService service = (DataEntityService)ServiceGlobal.getService(DataEntityService.class, this.getSessionFactory());
                service.autoGet(de);
                this.de = de;
            }
            return this.de;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public OrgSector getDstOrgSector() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstOrgSector();
        }
        if (this.getDstOrgSectorId() == null) {
            return null;
        }
        Integer n = this.objDstOrgSectorLock;
        synchronized (n) {
            if (this.dstorgsector != null && DataTypeHelper.compare(25, (Object)this.getDstOrgSectorId(), (Object)this.dstorgsector.getOrgSectorId()) != 0L) {
                this.dstorgsector = null;
            }
            if (this.dstorgsector == null) {
                OrgSector dstorgsector = new OrgSector();
                dstorgsector.setOrgSectorId(this.getDstOrgSectorId());
                OrgSectorService service = (OrgSectorService)ServiceGlobal.getService(OrgSectorService.class, this.getSessionFactory());
                service.autoGet(dstorgsector);
                this.dstorgsector = dstorgsector;
            }
            return this.dstorgsector;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Org getDstOrg() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstOrg();
        }
        if (this.getDstOrgId() == null) {
            return null;
        }
        Integer n = this.objDstOrgLock;
        synchronized (n) {
            if (this.dstorg != null && DataTypeHelper.compare(25, (Object)this.getDstOrgId(), (Object)this.dstorg.getOrgId()) != 0L) {
                this.dstorg = null;
            }
            if (this.dstorg == null) {
                Org dstorg = new Org();
                dstorg.setOrgId(this.getDstOrgId());
                OrgService service = (OrgService)ServiceGlobal.getService(OrgService.class, this.getSessionFactory());
                service.autoGet(dstorg);
                this.dstorg = dstorg;
            }
            return this.dstorg;
        }
    }

    private UserRoleDataBase getProxyEntity() {
        return this.proxyUserRoleDataBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyUserRoleDataBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof UserRoleDataBase) {
            this.proxyUserRoleDataBase = (UserRoleDataBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.UserRoleDataService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

