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
import net.ibizsys.psrt.srv.demodel.entity.DataEntity;
import net.ibizsys.psrt.srv.demodel.service.DataEntityService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class UserRoleDEFieldBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(UserRoleDEFieldBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFACTION = "DEFACTION";
    public static final String FIELD_DEID = "DEID";
    public static final String FIELD_DENAME = "DENAME";
    public static final String FIELD_RELATEDDEFIELD = "RELATEDDEFIELD";
    public static final String FIELD_RESERVER = "RESERVER";
    public static final String FIELD_RESERVER2 = "RESERVER2";
    public static final String FIELD_RESERVER3 = "RESERVER3";
    public static final String FIELD_RESERVER4 = "RESERVER4";
    public static final String FIELD_SRFSYSPUB = "SRFSYSPUB";
    public static final String FIELD_SRFUSERPUB = "SRFUSERPUB";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERROLEDEFIELDID = "USERROLEDEFIELDID";
    public static final String FIELD_USERROLEDEFIELDNAME = "USERROLEDEFIELDNAME";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DEFACTION = 2;
    private static final int INDEX_DEID = 3;
    private static final int INDEX_DENAME = 4;
    private static final int INDEX_RELATEDDEFIELD = 5;
    private static final int INDEX_RESERVER = 6;
    private static final int INDEX_RESERVER2 = 7;
    private static final int INDEX_RESERVER3 = 8;
    private static final int INDEX_RESERVER4 = 9;
    private static final int INDEX_SRFSYSPUB = 10;
    private static final int INDEX_SRFUSERPUB = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final int INDEX_USERROLEDEFIELDID = 14;
    private static final int INDEX_USERROLEDEFIELDNAME = 15;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private UserRoleDEFieldBase proxyUserRoleDEFieldBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defactionDirtyFlag = false;
    private boolean deidDirtyFlag = false;
    private boolean denameDirtyFlag = false;
    private boolean relateddefieldDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean reserver3DirtyFlag = false;
    private boolean reserver4DirtyFlag = false;
    private boolean srfsyspubDirtyFlag = false;
    private boolean srfuserpubDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userroledefieldidDirtyFlag = false;
    private boolean userroledefieldnameDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defaction")
    private String defaction;
    @Column(name="deid")
    private String deid;
    @Column(name="dename")
    private String dename;
    @Column(name="relateddefield")
    private String relateddefield;
    @Column(name="reserver")
    private String reserver;
    @Column(name="reserver2")
    private String reserver2;
    @Column(name="reserver3")
    private String reserver3;
    @Column(name="reserver4")
    private String reserver4;
    @Column(name="srfsyspub")
    private Integer srfsyspub;
    @Column(name="srfuserpub")
    private Integer srfuserpub;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userroledefieldid")
    private String userroledefieldid;
    @Column(name="userroledefieldname")
    private String userroledefieldname;
    private Integer objDELock = new Integer(1);
    private DataEntity de = null;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DEFACTION, 2);
        fieldIndexMap.put(FIELD_DEID, 3);
        fieldIndexMap.put(FIELD_DENAME, 4);
        fieldIndexMap.put(FIELD_RELATEDDEFIELD, 5);
        fieldIndexMap.put(FIELD_RESERVER, 6);
        fieldIndexMap.put(FIELD_RESERVER2, 7);
        fieldIndexMap.put(FIELD_RESERVER3, 8);
        fieldIndexMap.put(FIELD_RESERVER4, 9);
        fieldIndexMap.put(FIELD_SRFSYSPUB, 10);
        fieldIndexMap.put(FIELD_SRFUSERPUB, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
        fieldIndexMap.put(FIELD_USERROLEDEFIELDID, 14);
        fieldIndexMap.put(FIELD_USERROLEDEFIELDNAME, 15);
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

    public void setDEFAction(String defaction) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEFAction(defaction);
            return;
        }
        if (defaction != null && (defaction = StringHelper.trimRight(defaction)).length() == 0) {
            defaction = null;
        }
        this.defaction = defaction;
        this.defactionDirtyFlag = true;
    }

    public String getDEFAction() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEFAction();
        }
        return this.defaction;
    }

    public boolean isDEFActionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEFActionDirty();
        }
        return this.defactionDirtyFlag;
    }

    public void resetDEFAction() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEFAction();
            return;
        }
        this.defactionDirtyFlag = false;
        this.defaction = null;
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

    public void setRelatedDEField(String relateddefield) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRelatedDEField(relateddefield);
            return;
        }
        if (relateddefield != null && (relateddefield = StringHelper.trimRight(relateddefield)).length() == 0) {
            relateddefield = null;
        }
        this.relateddefield = relateddefield;
        this.relateddefieldDirtyFlag = true;
    }

    public String getRelatedDEField() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRelatedDEField();
        }
        return this.relateddefield;
    }

    public boolean isRelatedDEFieldDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRelatedDEFieldDirty();
        }
        return this.relateddefieldDirtyFlag;
    }

    public void resetRelatedDEField() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRelatedDEField();
            return;
        }
        this.relateddefieldDirtyFlag = false;
        this.relateddefield = null;
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

    public void setUserRoleDEFieldId(String userroledefieldid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserRoleDEFieldId(userroledefieldid);
            return;
        }
        if (userroledefieldid != null && (userroledefieldid = StringHelper.trimRight(userroledefieldid)).length() == 0) {
            userroledefieldid = null;
        }
        this.userroledefieldid = userroledefieldid;
        this.userroledefieldidDirtyFlag = true;
    }

    public String getUserRoleDEFieldId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserRoleDEFieldId();
        }
        return this.userroledefieldid;
    }

    public boolean isUserRoleDEFieldIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserRoleDEFieldIdDirty();
        }
        return this.userroledefieldidDirtyFlag;
    }

    public void resetUserRoleDEFieldId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserRoleDEFieldId();
            return;
        }
        this.userroledefieldidDirtyFlag = false;
        this.userroledefieldid = null;
    }

    public void setUserRoleDEFieldName(String userroledefieldname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserRoleDEFieldName(userroledefieldname);
            return;
        }
        if (userroledefieldname != null && (userroledefieldname = StringHelper.trimRight(userroledefieldname)).length() == 0) {
            userroledefieldname = null;
        }
        this.userroledefieldname = userroledefieldname;
        this.userroledefieldnameDirtyFlag = true;
    }

    public String getUserRoleDEFieldName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserRoleDEFieldName();
        }
        return this.userroledefieldname;
    }

    public boolean isUserRoleDEFieldNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserRoleDEFieldNameDirty();
        }
        return this.userroledefieldnameDirtyFlag;
    }

    public void resetUserRoleDEFieldName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserRoleDEFieldName();
            return;
        }
        this.userroledefieldnameDirtyFlag = false;
        this.userroledefieldname = null;
    }

    @Override
    protected void onReset() {
        UserRoleDEFieldBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(UserRoleDEFieldBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetDEFAction();
        et.resetDEId();
        et.resetDEName();
        et.resetRelatedDEField();
        et.resetReserver();
        et.resetReserver2();
        et.resetReserver3();
        et.resetReserver4();
        et.resetSRFSysPub();
        et.resetSRFUserPub();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetUserRoleDEFieldId();
        et.resetUserRoleDEFieldName();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isDEFActionDirty()) {
            params.put(FIELD_DEFACTION, this.getDEFAction());
        }
        if (!bDirtyOnly || this.isDEIdDirty()) {
            params.put(FIELD_DEID, this.getDEId());
        }
        if (!bDirtyOnly || this.isDENameDirty()) {
            params.put(FIELD_DENAME, this.getDEName());
        }
        if (!bDirtyOnly || this.isRelatedDEFieldDirty()) {
            params.put(FIELD_RELATEDDEFIELD, this.getRelatedDEField());
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
        if (!bDirtyOnly || this.isUserRoleDEFieldIdDirty()) {
            params.put(FIELD_USERROLEDEFIELDID, this.getUserRoleDEFieldId());
        }
        if (!bDirtyOnly || this.isUserRoleDEFieldNameDirty()) {
            params.put(FIELD_USERROLEDEFIELDNAME, this.getUserRoleDEFieldName());
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
        return UserRoleDEFieldBase.get(this, index);
    }

    private static Object get(UserRoleDEFieldBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate();
            }
            case 1: {
                return et.getCreateMan();
            }
            case 2: {
                return et.getDEFAction();
            }
            case 3: {
                return et.getDEId();
            }
            case 4: {
                return et.getDEName();
            }
            case 5: {
                return et.getRelatedDEField();
            }
            case 6: {
                return et.getReserver();
            }
            case 7: {
                return et.getReserver2();
            }
            case 8: {
                return et.getReserver3();
            }
            case 9: {
                return et.getReserver4();
            }
            case 10: {
                return et.getSRFSysPub();
            }
            case 11: {
                return et.getSRFUserPub();
            }
            case 12: {
                return et.getUpdateDate();
            }
            case 13: {
                return et.getUpdateMan();
            }
            case 14: {
                return et.getUserRoleDEFieldId();
            }
            case 15: {
                return et.getUserRoleDEFieldName();
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
        UserRoleDEFieldBase.set(this, index, objValue);
    }

    private static void set(UserRoleDEFieldBase et, int index, Object obj) throws Exception {
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
                et.setDEFAction(DataObject.getStringValue(obj));
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
                et.setRelatedDEField(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setReserver(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setReserver2(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setReserver3(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setReserver4(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setSRFSysPub(DataObject.getIntegerValue(obj));
                return;
            }
            case 11: {
                et.setSRFUserPub(DataObject.getIntegerValue(obj));
                return;
            }
            case 12: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 13: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 14: {
                et.setUserRoleDEFieldId(DataObject.getStringValue(obj));
                return;
            }
            case 15: {
                et.setUserRoleDEFieldName(DataObject.getStringValue(obj));
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
        return UserRoleDEFieldBase.isNull(this, index);
    }

    private static boolean isNull(UserRoleDEFieldBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate() == null;
            }
            case 1: {
                return et.getCreateMan() == null;
            }
            case 2: {
                return et.getDEFAction() == null;
            }
            case 3: {
                return et.getDEId() == null;
            }
            case 4: {
                return et.getDEName() == null;
            }
            case 5: {
                return et.getRelatedDEField() == null;
            }
            case 6: {
                return et.getReserver() == null;
            }
            case 7: {
                return et.getReserver2() == null;
            }
            case 8: {
                return et.getReserver3() == null;
            }
            case 9: {
                return et.getReserver4() == null;
            }
            case 10: {
                return et.getSRFSysPub() == null;
            }
            case 11: {
                return et.getSRFUserPub() == null;
            }
            case 12: {
                return et.getUpdateDate() == null;
            }
            case 13: {
                return et.getUpdateMan() == null;
            }
            case 14: {
                return et.getUserRoleDEFieldId() == null;
            }
            case 15: {
                return et.getUserRoleDEFieldName() == null;
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
        return UserRoleDEFieldBase.contains(this, index);
    }

    private static boolean contains(UserRoleDEFieldBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCreateDateDirty();
            }
            case 1: {
                return et.isCreateManDirty();
            }
            case 2: {
                return et.isDEFActionDirty();
            }
            case 3: {
                return et.isDEIdDirty();
            }
            case 4: {
                return et.isDENameDirty();
            }
            case 5: {
                return et.isRelatedDEFieldDirty();
            }
            case 6: {
                return et.isReserverDirty();
            }
            case 7: {
                return et.isReserver2Dirty();
            }
            case 8: {
                return et.isReserver3Dirty();
            }
            case 9: {
                return et.isReserver4Dirty();
            }
            case 10: {
                return et.isSRFSysPubDirty();
            }
            case 11: {
                return et.isSRFUserPubDirty();
            }
            case 12: {
                return et.isUpdateDateDirty();
            }
            case 13: {
                return et.isUpdateManDirty();
            }
            case 14: {
                return et.isUserRoleDEFieldIdDirty();
            }
            case 15: {
                return et.isUserRoleDEFieldNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        UserRoleDEFieldBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(UserRoleDEFieldBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", UserRoleDEFieldBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", UserRoleDEFieldBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getDEFAction() != null) {
            JSONObjectHelper.put(json, "defaction", UserRoleDEFieldBase.getJSONValue(et.getDEFAction()), false);
        }
        if (bIncEmpty || et.getDEId() != null) {
            JSONObjectHelper.put(json, "deid", UserRoleDEFieldBase.getJSONValue(et.getDEId()), false);
        }
        if (bIncEmpty || et.getDEName() != null) {
            JSONObjectHelper.put(json, "dename", UserRoleDEFieldBase.getJSONValue(et.getDEName()), false);
        }
        if (bIncEmpty || et.getRelatedDEField() != null) {
            JSONObjectHelper.put(json, "relateddefield", UserRoleDEFieldBase.getJSONValue(et.getRelatedDEField()), false);
        }
        if (bIncEmpty || et.getReserver() != null) {
            JSONObjectHelper.put(json, "reserver", UserRoleDEFieldBase.getJSONValue(et.getReserver()), false);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            JSONObjectHelper.put(json, "reserver2", UserRoleDEFieldBase.getJSONValue(et.getReserver2()), false);
        }
        if (bIncEmpty || et.getReserver3() != null) {
            JSONObjectHelper.put(json, "reserver3", UserRoleDEFieldBase.getJSONValue(et.getReserver3()), false);
        }
        if (bIncEmpty || et.getReserver4() != null) {
            JSONObjectHelper.put(json, "reserver4", UserRoleDEFieldBase.getJSONValue(et.getReserver4()), false);
        }
        if (bIncEmpty || et.getSRFSysPub() != null) {
            JSONObjectHelper.put(json, "srfsyspub", UserRoleDEFieldBase.getJSONValue(et.getSRFSysPub()), false);
        }
        if (bIncEmpty || et.getSRFUserPub() != null) {
            JSONObjectHelper.put(json, "srfuserpub", UserRoleDEFieldBase.getJSONValue(et.getSRFUserPub()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", UserRoleDEFieldBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", UserRoleDEFieldBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getUserRoleDEFieldId() != null) {
            JSONObjectHelper.put(json, "userroledefieldid", UserRoleDEFieldBase.getJSONValue(et.getUserRoleDEFieldId()), false);
        }
        if (bIncEmpty || et.getUserRoleDEFieldName() != null) {
            JSONObjectHelper.put(json, "userroledefieldname", UserRoleDEFieldBase.getJSONValue(et.getUserRoleDEFieldName()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        UserRoleDEFieldBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(UserRoleDEFieldBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDEFAction() != null) {
            obj = et.getDEFAction();
            node.setAttribute(FIELD_DEFACTION, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDEId() != null) {
            obj = et.getDEId();
            node.setAttribute(FIELD_DEID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDEName() != null) {
            obj = et.getDEName();
            node.setAttribute(FIELD_DENAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getRelatedDEField() != null) {
            obj = et.getRelatedDEField();
            node.setAttribute(FIELD_RELATEDDEFIELD, obj == null ? "" : (String)obj);
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
        if (bIncEmpty || et.getUserRoleDEFieldId() != null) {
            obj = et.getUserRoleDEFieldId();
            node.setAttribute(FIELD_USERROLEDEFIELDID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserRoleDEFieldName() != null) {
            obj = et.getUserRoleDEFieldName();
            node.setAttribute(FIELD_USERROLEDEFIELDNAME, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        UserRoleDEFieldBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(UserRoleDEFieldBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isDEFActionDirty() && (bIncEmpty || et.getDEFAction() != null)) {
            dst.set(FIELD_DEFACTION, et.getDEFAction());
        }
        if (et.isDEIdDirty() && (bIncEmpty || et.getDEId() != null)) {
            dst.set(FIELD_DEID, et.getDEId());
        }
        if (et.isDENameDirty() && (bIncEmpty || et.getDEName() != null)) {
            dst.set(FIELD_DENAME, et.getDEName());
        }
        if (et.isRelatedDEFieldDirty() && (bIncEmpty || et.getRelatedDEField() != null)) {
            dst.set(FIELD_RELATEDDEFIELD, et.getRelatedDEField());
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
        if (et.isUserRoleDEFieldIdDirty() && (bIncEmpty || et.getUserRoleDEFieldId() != null)) {
            dst.set(FIELD_USERROLEDEFIELDID, et.getUserRoleDEFieldId());
        }
        if (et.isUserRoleDEFieldNameDirty() && (bIncEmpty || et.getUserRoleDEFieldName() != null)) {
            dst.set(FIELD_USERROLEDEFIELDNAME, et.getUserRoleDEFieldName());
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
        return UserRoleDEFieldBase.remove(this, index);
    }

    private static boolean remove(UserRoleDEFieldBase et, int index) throws Exception {
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
                et.resetDEFAction();
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
                et.resetRelatedDEField();
                return true;
            }
            case 6: {
                et.resetReserver();
                return true;
            }
            case 7: {
                et.resetReserver2();
                return true;
            }
            case 8: {
                et.resetReserver3();
                return true;
            }
            case 9: {
                et.resetReserver4();
                return true;
            }
            case 10: {
                et.resetSRFSysPub();
                return true;
            }
            case 11: {
                et.resetSRFUserPub();
                return true;
            }
            case 12: {
                et.resetUpdateDate();
                return true;
            }
            case 13: {
                et.resetUpdateMan();
                return true;
            }
            case 14: {
                et.resetUserRoleDEFieldId();
                return true;
            }
            case 15: {
                et.resetUserRoleDEFieldName();
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

    private UserRoleDEFieldBase getProxyEntity() {
        return this.proxyUserRoleDEFieldBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyUserRoleDEFieldBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof UserRoleDEFieldBase) {
            this.proxyUserRoleDEFieldBase = (UserRoleDEFieldBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.UserRoleDEFieldService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

