/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.demodel.entity;

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
import net.ibizsys.psrt.srv.demodel.entity.DataEntity;
import net.ibizsys.psrt.srv.demodel.service.DataEntityService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class QueryModelBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(QueryModelBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEID = "DEID";
    public static final String FIELD_DENAME = "DENAME";
    public static final String FIELD_GROUPMODEL = "GROUPMODEL";
    public static final String FIELD_ISRAWMODE = "ISRAWMODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_QMVERSION = "QMVERSION";
    public static final String FIELD_QUERYCOND = "QUERYCOND";
    public static final String FIELD_QUERYFIELD = "QUERYFIELD";
    public static final String FIELD_QUERYMODEL = "QUERYMODEL";
    public static final String FIELD_QUERYMODELID = "QUERYMODELID";
    public static final String FIELD_QUERYMODELNAME = "QUERYMODELNAME";
    public static final String FIELD_QUERYOBJECT = "QUERYOBJECT";
    public static final String FIELD_QUERYPARAM = "QUERYPARAM";
    public static final String FIELD_QUERYSQL = "QUERYSQL";
    public static final String FIELD_SELECTMODE = "SELECTMODE";
    public static final String FIELD_SELECTORDER = "SELECTORDER";
    public static final String FIELD_SRFSYSPUB = "SRFSYSPUB";
    public static final String FIELD_SRFUSERPUB = "SRFUSERPUB";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DEID = 2;
    private static final int INDEX_DENAME = 3;
    private static final int INDEX_GROUPMODEL = 4;
    private static final int INDEX_ISRAWMODE = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_QMVERSION = 7;
    private static final int INDEX_QUERYCOND = 8;
    private static final int INDEX_QUERYFIELD = 9;
    private static final int INDEX_QUERYMODEL = 10;
    private static final int INDEX_QUERYMODELID = 11;
    private static final int INDEX_QUERYMODELNAME = 12;
    private static final int INDEX_QUERYOBJECT = 13;
    private static final int INDEX_QUERYPARAM = 14;
    private static final int INDEX_QUERYSQL = 15;
    private static final int INDEX_SELECTMODE = 16;
    private static final int INDEX_SELECTORDER = 17;
    private static final int INDEX_SRFSYSPUB = 18;
    private static final int INDEX_SRFUSERPUB = 19;
    private static final int INDEX_UPDATEDATE = 20;
    private static final int INDEX_UPDATEMAN = 21;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private QueryModelBase proxyQueryModelBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean deidDirtyFlag = false;
    private boolean denameDirtyFlag = false;
    private boolean groupmodelDirtyFlag = false;
    private boolean israwmodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean qmversionDirtyFlag = false;
    private boolean querycondDirtyFlag = false;
    private boolean queryfieldDirtyFlag = false;
    private boolean querymodelDirtyFlag = false;
    private boolean querymodelidDirtyFlag = false;
    private boolean querymodelnameDirtyFlag = false;
    private boolean queryobjectDirtyFlag = false;
    private boolean queryparamDirtyFlag = false;
    private boolean querysqlDirtyFlag = false;
    private boolean selectmodeDirtyFlag = false;
    private boolean selectorderDirtyFlag = false;
    private boolean srfsyspubDirtyFlag = false;
    private boolean srfuserpubDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="deid")
    private String deid;
    @Column(name="dename")
    private String dename;
    @Column(name="groupmodel")
    private String groupmodel;
    @Column(name="israwmode")
    private Integer israwmode;
    @Column(name="memo")
    private String memo;
    @Column(name="qmversion")
    private Integer qmversion;
    @Column(name="querycond")
    private String querycond;
    @Column(name="queryfield")
    private String queryfield;
    @Column(name="querymodel")
    private String querymodel;
    @Column(name="querymodelid")
    private String querymodelid;
    @Column(name="querymodelname")
    private String querymodelname;
    @Column(name="queryobject")
    private String queryobject;
    @Column(name="queryparam")
    private String queryparam;
    @Column(name="querysql")
    private String querysql;
    @Column(name="selectmode")
    private String selectmode;
    @Column(name="selectorder")
    private String selectorder;
    @Column(name="srfsyspub")
    private Integer srfsyspub;
    @Column(name="srfuserpub")
    private Integer srfuserpub;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objDELock = new Integer(1);
    private DataEntity de = null;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DEID, 2);
        fieldIndexMap.put(FIELD_DENAME, 3);
        fieldIndexMap.put(FIELD_GROUPMODEL, 4);
        fieldIndexMap.put(FIELD_ISRAWMODE, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_QMVERSION, 7);
        fieldIndexMap.put(FIELD_QUERYCOND, 8);
        fieldIndexMap.put(FIELD_QUERYFIELD, 9);
        fieldIndexMap.put(FIELD_QUERYMODEL, 10);
        fieldIndexMap.put(FIELD_QUERYMODELID, 11);
        fieldIndexMap.put(FIELD_QUERYMODELNAME, 12);
        fieldIndexMap.put(FIELD_QUERYOBJECT, 13);
        fieldIndexMap.put(FIELD_QUERYPARAM, 14);
        fieldIndexMap.put(FIELD_QUERYSQL, 15);
        fieldIndexMap.put(FIELD_SELECTMODE, 16);
        fieldIndexMap.put(FIELD_SELECTORDER, 17);
        fieldIndexMap.put(FIELD_SRFSYSPUB, 18);
        fieldIndexMap.put(FIELD_SRFUSERPUB, 19);
        fieldIndexMap.put(FIELD_UPDATEDATE, 20);
        fieldIndexMap.put(FIELD_UPDATEMAN, 21);
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

    public void setGroupModel(String groupmodel) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupModel(groupmodel);
            return;
        }
        if (groupmodel != null && (groupmodel = StringHelper.trimRight(groupmodel)).length() == 0) {
            groupmodel = null;
        }
        this.groupmodel = groupmodel;
        this.groupmodelDirtyFlag = true;
    }

    public String getGroupModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupModel();
        }
        return this.groupmodel;
    }

    public boolean isGroupModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupModelDirty();
        }
        return this.groupmodelDirtyFlag;
    }

    public void resetGroupModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupModel();
            return;
        }
        this.groupmodelDirtyFlag = false;
        this.groupmodel = null;
    }

    public void setIsRawMode(Integer israwmode) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIsRawMode(israwmode);
            return;
        }
        this.israwmode = israwmode;
        this.israwmodeDirtyFlag = true;
    }

    public Integer getIsRawMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIsRawMode();
        }
        return this.israwmode;
    }

    public boolean isIsRawModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIsRawModeDirty();
        }
        return this.israwmodeDirtyFlag;
    }

    public void resetIsRawMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIsRawMode();
            return;
        }
        this.israwmodeDirtyFlag = false;
        this.israwmode = null;
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

    public void setQMVersion(Integer qmversion) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setQMVersion(qmversion);
            return;
        }
        this.qmversion = qmversion;
        this.qmversionDirtyFlag = true;
    }

    public Integer getQMVersion() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getQMVersion();
        }
        return this.qmversion;
    }

    public boolean isQMVersionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isQMVersionDirty();
        }
        return this.qmversionDirtyFlag;
    }

    public void resetQMVersion() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetQMVersion();
            return;
        }
        this.qmversionDirtyFlag = false;
        this.qmversion = null;
    }

    public void setQueryCond(String querycond) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setQueryCond(querycond);
            return;
        }
        if (querycond != null && (querycond = StringHelper.trimRight(querycond)).length() == 0) {
            querycond = null;
        }
        this.querycond = querycond;
        this.querycondDirtyFlag = true;
    }

    public String getQueryCond() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getQueryCond();
        }
        return this.querycond;
    }

    public boolean isQueryCondDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isQueryCondDirty();
        }
        return this.querycondDirtyFlag;
    }

    public void resetQueryCond() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetQueryCond();
            return;
        }
        this.querycondDirtyFlag = false;
        this.querycond = null;
    }

    public void setQueryField(String queryfield) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setQueryField(queryfield);
            return;
        }
        if (queryfield != null && (queryfield = StringHelper.trimRight(queryfield)).length() == 0) {
            queryfield = null;
        }
        this.queryfield = queryfield;
        this.queryfieldDirtyFlag = true;
    }

    public String getQueryField() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getQueryField();
        }
        return this.queryfield;
    }

    public boolean isQueryFieldDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isQueryFieldDirty();
        }
        return this.queryfieldDirtyFlag;
    }

    public void resetQueryField() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetQueryField();
            return;
        }
        this.queryfieldDirtyFlag = false;
        this.queryfield = null;
    }

    public void setQueryModel(String querymodel) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setQueryModel(querymodel);
            return;
        }
        if (querymodel != null && (querymodel = StringHelper.trimRight(querymodel)).length() == 0) {
            querymodel = null;
        }
        this.querymodel = querymodel;
        this.querymodelDirtyFlag = true;
    }

    public String getQueryModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getQueryModel();
        }
        return this.querymodel;
    }

    public boolean isQueryModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isQueryModelDirty();
        }
        return this.querymodelDirtyFlag;
    }

    public void resetQueryModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetQueryModel();
            return;
        }
        this.querymodelDirtyFlag = false;
        this.querymodel = null;
    }

    public void setQueryModelId(String querymodelid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setQueryModelId(querymodelid);
            return;
        }
        if (querymodelid != null && (querymodelid = StringHelper.trimRight(querymodelid)).length() == 0) {
            querymodelid = null;
        }
        this.querymodelid = querymodelid;
        this.querymodelidDirtyFlag = true;
    }

    public String getQueryModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getQueryModelId();
        }
        return this.querymodelid;
    }

    public boolean isQueryModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isQueryModelIdDirty();
        }
        return this.querymodelidDirtyFlag;
    }

    public void resetQueryModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetQueryModelId();
            return;
        }
        this.querymodelidDirtyFlag = false;
        this.querymodelid = null;
    }

    public void setQueryModelName(String querymodelname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setQueryModelName(querymodelname);
            return;
        }
        if (querymodelname != null && (querymodelname = StringHelper.trimRight(querymodelname)).length() == 0) {
            querymodelname = null;
        }
        this.querymodelname = querymodelname;
        this.querymodelnameDirtyFlag = true;
    }

    public String getQueryModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getQueryModelName();
        }
        return this.querymodelname;
    }

    public boolean isQueryModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isQueryModelNameDirty();
        }
        return this.querymodelnameDirtyFlag;
    }

    public void resetQueryModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetQueryModelName();
            return;
        }
        this.querymodelnameDirtyFlag = false;
        this.querymodelname = null;
    }

    public void setQueryObject(String queryobject) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setQueryObject(queryobject);
            return;
        }
        if (queryobject != null && (queryobject = StringHelper.trimRight(queryobject)).length() == 0) {
            queryobject = null;
        }
        this.queryobject = queryobject;
        this.queryobjectDirtyFlag = true;
    }

    public String getQueryObject() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getQueryObject();
        }
        return this.queryobject;
    }

    public boolean isQueryObjectDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isQueryObjectDirty();
        }
        return this.queryobjectDirtyFlag;
    }

    public void resetQueryObject() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetQueryObject();
            return;
        }
        this.queryobjectDirtyFlag = false;
        this.queryobject = null;
    }

    public void setQueryParam(String queryparam) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setQueryParam(queryparam);
            return;
        }
        if (queryparam != null && (queryparam = StringHelper.trimRight(queryparam)).length() == 0) {
            queryparam = null;
        }
        this.queryparam = queryparam;
        this.queryparamDirtyFlag = true;
    }

    public String getQueryParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getQueryParam();
        }
        return this.queryparam;
    }

    public boolean isQueryParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isQueryParamDirty();
        }
        return this.queryparamDirtyFlag;
    }

    public void resetQueryParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetQueryParam();
            return;
        }
        this.queryparamDirtyFlag = false;
        this.queryparam = null;
    }

    public void setQuerySQL(String querysql) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setQuerySQL(querysql);
            return;
        }
        if (querysql != null && (querysql = StringHelper.trimRight(querysql)).length() == 0) {
            querysql = null;
        }
        this.querysql = querysql;
        this.querysqlDirtyFlag = true;
    }

    public String getQuerySQL() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getQuerySQL();
        }
        return this.querysql;
    }

    public boolean isQuerySQLDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isQuerySQLDirty();
        }
        return this.querysqlDirtyFlag;
    }

    public void resetQuerySQL() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetQuerySQL();
            return;
        }
        this.querysqlDirtyFlag = false;
        this.querysql = null;
    }

    public void setSelectMode(String selectmode) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSelectMode(selectmode);
            return;
        }
        if (selectmode != null && (selectmode = StringHelper.trimRight(selectmode)).length() == 0) {
            selectmode = null;
        }
        this.selectmode = selectmode;
        this.selectmodeDirtyFlag = true;
    }

    public String getSelectMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSelectMode();
        }
        return this.selectmode;
    }

    public boolean isSelectModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSelectModeDirty();
        }
        return this.selectmodeDirtyFlag;
    }

    public void resetSelectMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSelectMode();
            return;
        }
        this.selectmodeDirtyFlag = false;
        this.selectmode = null;
    }

    public void setSelectOrder(String selectorder) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSelectOrder(selectorder);
            return;
        }
        if (selectorder != null && (selectorder = StringHelper.trimRight(selectorder)).length() == 0) {
            selectorder = null;
        }
        this.selectorder = selectorder;
        this.selectorderDirtyFlag = true;
    }

    public String getSelectOrder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSelectOrder();
        }
        return this.selectorder;
    }

    public boolean isSelectOrderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSelectOrderDirty();
        }
        return this.selectorderDirtyFlag;
    }

    public void resetSelectOrder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSelectOrder();
            return;
        }
        this.selectorderDirtyFlag = false;
        this.selectorder = null;
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

    @Override
    protected void onReset() {
        QueryModelBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(QueryModelBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetDEId();
        et.resetDEName();
        et.resetGroupModel();
        et.resetIsRawMode();
        et.resetMemo();
        et.resetQMVersion();
        et.resetQueryCond();
        et.resetQueryField();
        et.resetQueryModel();
        et.resetQueryModelId();
        et.resetQueryModelName();
        et.resetQueryObject();
        et.resetQueryParam();
        et.resetQuerySQL();
        et.resetSelectMode();
        et.resetSelectOrder();
        et.resetSRFSysPub();
        et.resetSRFUserPub();
        et.resetUpdateDate();
        et.resetUpdateMan();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
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
        if (!bDirtyOnly || this.isGroupModelDirty()) {
            params.put(FIELD_GROUPMODEL, this.getGroupModel());
        }
        if (!bDirtyOnly || this.isIsRawModeDirty()) {
            params.put(FIELD_ISRAWMODE, this.getIsRawMode());
        }
        if (!bDirtyOnly || this.isMemoDirty()) {
            params.put(FIELD_MEMO, this.getMemo());
        }
        if (!bDirtyOnly || this.isQMVersionDirty()) {
            params.put(FIELD_QMVERSION, this.getQMVersion());
        }
        if (!bDirtyOnly || this.isQueryCondDirty()) {
            params.put(FIELD_QUERYCOND, this.getQueryCond());
        }
        if (!bDirtyOnly || this.isQueryFieldDirty()) {
            params.put(FIELD_QUERYFIELD, this.getQueryField());
        }
        if (!bDirtyOnly || this.isQueryModelDirty()) {
            params.put(FIELD_QUERYMODEL, this.getQueryModel());
        }
        if (!bDirtyOnly || this.isQueryModelIdDirty()) {
            params.put(FIELD_QUERYMODELID, this.getQueryModelId());
        }
        if (!bDirtyOnly || this.isQueryModelNameDirty()) {
            params.put(FIELD_QUERYMODELNAME, this.getQueryModelName());
        }
        if (!bDirtyOnly || this.isQueryObjectDirty()) {
            params.put(FIELD_QUERYOBJECT, this.getQueryObject());
        }
        if (!bDirtyOnly || this.isQueryParamDirty()) {
            params.put(FIELD_QUERYPARAM, this.getQueryParam());
        }
        if (!bDirtyOnly || this.isQuerySQLDirty()) {
            params.put(FIELD_QUERYSQL, this.getQuerySQL());
        }
        if (!bDirtyOnly || this.isSelectModeDirty()) {
            params.put(FIELD_SELECTMODE, this.getSelectMode());
        }
        if (!bDirtyOnly || this.isSelectOrderDirty()) {
            params.put(FIELD_SELECTORDER, this.getSelectOrder());
        }
        if (!bDirtyOnly || this.isSRFSysPubDirty()) {
            params.put(FIELD_SRFSYSPUB, this.getSRFSysPub());
        }
        if (!bDirtyOnly || this.isSRFUserPubDirty()) {
            params.put(FIELD_SRFUSERPUB, this.getSRFUserPub());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return QueryModelBase.get(this, index);
    }

    private static Object get(QueryModelBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate();
            }
            case 1: {
                return et.getCreateMan();
            }
            case 2: {
                return et.getDEId();
            }
            case 3: {
                return et.getDEName();
            }
            case 4: {
                return et.getGroupModel();
            }
            case 5: {
                return et.getIsRawMode();
            }
            case 6: {
                return et.getMemo();
            }
            case 7: {
                return et.getQMVersion();
            }
            case 8: {
                return et.getQueryCond();
            }
            case 9: {
                return et.getQueryField();
            }
            case 10: {
                return et.getQueryModel();
            }
            case 11: {
                return et.getQueryModelId();
            }
            case 12: {
                return et.getQueryModelName();
            }
            case 13: {
                return et.getQueryObject();
            }
            case 14: {
                return et.getQueryParam();
            }
            case 15: {
                return et.getQuerySQL();
            }
            case 16: {
                return et.getSelectMode();
            }
            case 17: {
                return et.getSelectOrder();
            }
            case 18: {
                return et.getSRFSysPub();
            }
            case 19: {
                return et.getSRFUserPub();
            }
            case 20: {
                return et.getUpdateDate();
            }
            case 21: {
                return et.getUpdateMan();
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
        QueryModelBase.set(this, index, objValue);
    }

    private static void set(QueryModelBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 1: {
                et.setCreateMan(DataObject.getStringValue(obj));
                return;
            }
            case 2: {
                et.setDEId(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setDEName(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setGroupModel(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setIsRawMode(DataObject.getIntegerValue(obj));
                return;
            }
            case 6: {
                et.setMemo(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setQMVersion(DataObject.getIntegerValue(obj));
                return;
            }
            case 8: {
                et.setQueryCond(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setQueryField(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setQueryModel(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setQueryModelId(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setQueryModelName(DataObject.getStringValue(obj));
                return;
            }
            case 13: {
                et.setQueryObject(DataObject.getStringValue(obj));
                return;
            }
            case 14: {
                et.setQueryParam(DataObject.getStringValue(obj));
                return;
            }
            case 15: {
                et.setQuerySQL(DataObject.getStringValue(obj));
                return;
            }
            case 16: {
                et.setSelectMode(DataObject.getStringValue(obj));
                return;
            }
            case 17: {
                et.setSelectOrder(DataObject.getStringValue(obj));
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
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 21: {
                et.setUpdateMan(DataObject.getStringValue(obj));
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
        return QueryModelBase.isNull(this, index);
    }

    private static boolean isNull(QueryModelBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate() == null;
            }
            case 1: {
                return et.getCreateMan() == null;
            }
            case 2: {
                return et.getDEId() == null;
            }
            case 3: {
                return et.getDEName() == null;
            }
            case 4: {
                return et.getGroupModel() == null;
            }
            case 5: {
                return et.getIsRawMode() == null;
            }
            case 6: {
                return et.getMemo() == null;
            }
            case 7: {
                return et.getQMVersion() == null;
            }
            case 8: {
                return et.getQueryCond() == null;
            }
            case 9: {
                return et.getQueryField() == null;
            }
            case 10: {
                return et.getQueryModel() == null;
            }
            case 11: {
                return et.getQueryModelId() == null;
            }
            case 12: {
                return et.getQueryModelName() == null;
            }
            case 13: {
                return et.getQueryObject() == null;
            }
            case 14: {
                return et.getQueryParam() == null;
            }
            case 15: {
                return et.getQuerySQL() == null;
            }
            case 16: {
                return et.getSelectMode() == null;
            }
            case 17: {
                return et.getSelectOrder() == null;
            }
            case 18: {
                return et.getSRFSysPub() == null;
            }
            case 19: {
                return et.getSRFUserPub() == null;
            }
            case 20: {
                return et.getUpdateDate() == null;
            }
            case 21: {
                return et.getUpdateMan() == null;
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
        return QueryModelBase.contains(this, index);
    }

    private static boolean contains(QueryModelBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCreateDateDirty();
            }
            case 1: {
                return et.isCreateManDirty();
            }
            case 2: {
                return et.isDEIdDirty();
            }
            case 3: {
                return et.isDENameDirty();
            }
            case 4: {
                return et.isGroupModelDirty();
            }
            case 5: {
                return et.isIsRawModeDirty();
            }
            case 6: {
                return et.isMemoDirty();
            }
            case 7: {
                return et.isQMVersionDirty();
            }
            case 8: {
                return et.isQueryCondDirty();
            }
            case 9: {
                return et.isQueryFieldDirty();
            }
            case 10: {
                return et.isQueryModelDirty();
            }
            case 11: {
                return et.isQueryModelIdDirty();
            }
            case 12: {
                return et.isQueryModelNameDirty();
            }
            case 13: {
                return et.isQueryObjectDirty();
            }
            case 14: {
                return et.isQueryParamDirty();
            }
            case 15: {
                return et.isQuerySQLDirty();
            }
            case 16: {
                return et.isSelectModeDirty();
            }
            case 17: {
                return et.isSelectOrderDirty();
            }
            case 18: {
                return et.isSRFSysPubDirty();
            }
            case 19: {
                return et.isSRFUserPubDirty();
            }
            case 20: {
                return et.isUpdateDateDirty();
            }
            case 21: {
                return et.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        QueryModelBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(QueryModelBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", QueryModelBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", QueryModelBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getDEId() != null) {
            JSONObjectHelper.put(json, "deid", QueryModelBase.getJSONValue(et.getDEId()), false);
        }
        if (bIncEmpty || et.getDEName() != null) {
            JSONObjectHelper.put(json, "dename", QueryModelBase.getJSONValue(et.getDEName()), false);
        }
        if (bIncEmpty || et.getGroupModel() != null) {
            JSONObjectHelper.put(json, "groupmodel", QueryModelBase.getJSONValue(et.getGroupModel()), false);
        }
        if (bIncEmpty || et.getIsRawMode() != null) {
            JSONObjectHelper.put(json, "israwmode", QueryModelBase.getJSONValue(et.getIsRawMode()), false);
        }
        if (bIncEmpty || et.getMemo() != null) {
            JSONObjectHelper.put(json, "memo", QueryModelBase.getJSONValue(et.getMemo()), false);
        }
        if (bIncEmpty || et.getQMVersion() != null) {
            JSONObjectHelper.put(json, "qmversion", QueryModelBase.getJSONValue(et.getQMVersion()), false);
        }
        if (bIncEmpty || et.getQueryCond() != null) {
            JSONObjectHelper.put(json, "querycond", QueryModelBase.getJSONValue(et.getQueryCond()), false);
        }
        if (bIncEmpty || et.getQueryField() != null) {
            JSONObjectHelper.put(json, "queryfield", QueryModelBase.getJSONValue(et.getQueryField()), false);
        }
        if (bIncEmpty || et.getQueryModel() != null) {
            JSONObjectHelper.put(json, "querymodel", QueryModelBase.getJSONValue(et.getQueryModel()), false);
        }
        if (bIncEmpty || et.getQueryModelId() != null) {
            JSONObjectHelper.put(json, "querymodelid", QueryModelBase.getJSONValue(et.getQueryModelId()), false);
        }
        if (bIncEmpty || et.getQueryModelName() != null) {
            JSONObjectHelper.put(json, "querymodelname", QueryModelBase.getJSONValue(et.getQueryModelName()), false);
        }
        if (bIncEmpty || et.getQueryObject() != null) {
            JSONObjectHelper.put(json, "queryobject", QueryModelBase.getJSONValue(et.getQueryObject()), false);
        }
        if (bIncEmpty || et.getQueryParam() != null) {
            JSONObjectHelper.put(json, "queryparam", QueryModelBase.getJSONValue(et.getQueryParam()), false);
        }
        if (bIncEmpty || et.getQuerySQL() != null) {
            JSONObjectHelper.put(json, "querysql", QueryModelBase.getJSONValue(et.getQuerySQL()), false);
        }
        if (bIncEmpty || et.getSelectMode() != null) {
            JSONObjectHelper.put(json, "selectmode", QueryModelBase.getJSONValue(et.getSelectMode()), false);
        }
        if (bIncEmpty || et.getSelectOrder() != null) {
            JSONObjectHelper.put(json, "selectorder", QueryModelBase.getJSONValue(et.getSelectOrder()), false);
        }
        if (bIncEmpty || et.getSRFSysPub() != null) {
            JSONObjectHelper.put(json, "srfsyspub", QueryModelBase.getJSONValue(et.getSRFSysPub()), false);
        }
        if (bIncEmpty || et.getSRFUserPub() != null) {
            JSONObjectHelper.put(json, "srfuserpub", QueryModelBase.getJSONValue(et.getSRFUserPub()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", QueryModelBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", QueryModelBase.getJSONValue(et.getUpdateMan()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        QueryModelBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(QueryModelBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
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
        if (bIncEmpty || et.getGroupModel() != null) {
            obj = et.getGroupModel();
            node.setAttribute(FIELD_GROUPMODEL, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getIsRawMode() != null) {
            obj = et.getIsRawMode();
            node.setAttribute(FIELD_ISRAWMODE, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getMemo() != null) {
            obj = et.getMemo();
            node.setAttribute(FIELD_MEMO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getQMVersion() != null) {
            obj = et.getQMVersion();
            node.setAttribute(FIELD_QMVERSION, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getQueryCond() != null) {
            obj = et.getQueryCond();
            node.setAttribute(FIELD_QUERYCOND, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getQueryField() != null) {
            obj = et.getQueryField();
            node.setAttribute(FIELD_QUERYFIELD, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getQueryModel() != null) {
            obj = et.getQueryModel();
            node.setAttribute(FIELD_QUERYMODEL, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getQueryModelId() != null) {
            obj = et.getQueryModelId();
            node.setAttribute(FIELD_QUERYMODELID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getQueryModelName() != null) {
            obj = et.getQueryModelName();
            node.setAttribute(FIELD_QUERYMODELNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getQueryObject() != null) {
            obj = et.getQueryObject();
            node.setAttribute(FIELD_QUERYOBJECT, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getQueryParam() != null) {
            obj = et.getQueryParam();
            node.setAttribute(FIELD_QUERYPARAM, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getQuerySQL() != null) {
            obj = et.getQuerySQL();
            node.setAttribute(FIELD_QUERYSQL, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getSelectMode() != null) {
            obj = et.getSelectMode();
            node.setAttribute(FIELD_SELECTMODE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getSelectOrder() != null) {
            obj = et.getSelectOrder();
            node.setAttribute(FIELD_SELECTORDER, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getSRFSysPub() != null) {
            obj = et.getSRFSysPub();
            node.setAttribute(FIELD_SRFSYSPUB, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getSRFUserPub() != null) {
            obj = et.getSRFUserPub();
            node.setAttribute(FIELD_SRFUSERPUB, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        QueryModelBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(QueryModelBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
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
        if (et.isGroupModelDirty() && (bIncEmpty || et.getGroupModel() != null)) {
            dst.set(FIELD_GROUPMODEL, et.getGroupModel());
        }
        if (et.isIsRawModeDirty() && (bIncEmpty || et.getIsRawMode() != null)) {
            dst.set(FIELD_ISRAWMODE, et.getIsRawMode());
        }
        if (et.isMemoDirty() && (bIncEmpty || et.getMemo() != null)) {
            dst.set(FIELD_MEMO, et.getMemo());
        }
        if (et.isQMVersionDirty() && (bIncEmpty || et.getQMVersion() != null)) {
            dst.set(FIELD_QMVERSION, et.getQMVersion());
        }
        if (et.isQueryCondDirty() && (bIncEmpty || et.getQueryCond() != null)) {
            dst.set(FIELD_QUERYCOND, et.getQueryCond());
        }
        if (et.isQueryFieldDirty() && (bIncEmpty || et.getQueryField() != null)) {
            dst.set(FIELD_QUERYFIELD, et.getQueryField());
        }
        if (et.isQueryModelDirty() && (bIncEmpty || et.getQueryModel() != null)) {
            dst.set(FIELD_QUERYMODEL, et.getQueryModel());
        }
        if (et.isQueryModelIdDirty() && (bIncEmpty || et.getQueryModelId() != null)) {
            dst.set(FIELD_QUERYMODELID, et.getQueryModelId());
        }
        if (et.isQueryModelNameDirty() && (bIncEmpty || et.getQueryModelName() != null)) {
            dst.set(FIELD_QUERYMODELNAME, et.getQueryModelName());
        }
        if (et.isQueryObjectDirty() && (bIncEmpty || et.getQueryObject() != null)) {
            dst.set(FIELD_QUERYOBJECT, et.getQueryObject());
        }
        if (et.isQueryParamDirty() && (bIncEmpty || et.getQueryParam() != null)) {
            dst.set(FIELD_QUERYPARAM, et.getQueryParam());
        }
        if (et.isQuerySQLDirty() && (bIncEmpty || et.getQuerySQL() != null)) {
            dst.set(FIELD_QUERYSQL, et.getQuerySQL());
        }
        if (et.isSelectModeDirty() && (bIncEmpty || et.getSelectMode() != null)) {
            dst.set(FIELD_SELECTMODE, et.getSelectMode());
        }
        if (et.isSelectOrderDirty() && (bIncEmpty || et.getSelectOrder() != null)) {
            dst.set(FIELD_SELECTORDER, et.getSelectOrder());
        }
        if (et.isSRFSysPubDirty() && (bIncEmpty || et.getSRFSysPub() != null)) {
            dst.set(FIELD_SRFSYSPUB, et.getSRFSysPub());
        }
        if (et.isSRFUserPubDirty() && (bIncEmpty || et.getSRFUserPub() != null)) {
            dst.set(FIELD_SRFUSERPUB, et.getSRFUserPub());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
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
        return QueryModelBase.remove(this, index);
    }

    private static boolean remove(QueryModelBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetCreateDate();
                return true;
            }
            case 1: {
                et.resetCreateMan();
                return true;
            }
            case 2: {
                et.resetDEId();
                return true;
            }
            case 3: {
                et.resetDEName();
                return true;
            }
            case 4: {
                et.resetGroupModel();
                return true;
            }
            case 5: {
                et.resetIsRawMode();
                return true;
            }
            case 6: {
                et.resetMemo();
                return true;
            }
            case 7: {
                et.resetQMVersion();
                return true;
            }
            case 8: {
                et.resetQueryCond();
                return true;
            }
            case 9: {
                et.resetQueryField();
                return true;
            }
            case 10: {
                et.resetQueryModel();
                return true;
            }
            case 11: {
                et.resetQueryModelId();
                return true;
            }
            case 12: {
                et.resetQueryModelName();
                return true;
            }
            case 13: {
                et.resetQueryObject();
                return true;
            }
            case 14: {
                et.resetQueryParam();
                return true;
            }
            case 15: {
                et.resetQuerySQL();
                return true;
            }
            case 16: {
                et.resetSelectMode();
                return true;
            }
            case 17: {
                et.resetSelectOrder();
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
                et.resetUpdateDate();
                return true;
            }
            case 21: {
                et.resetUpdateMan();
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

    private QueryModelBase getProxyEntity() {
        return this.proxyQueryModelBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyQueryModelBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof QueryModelBase) {
            this.proxyQueryModelBase = (QueryModelBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.demodel.service.QueryModelService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

