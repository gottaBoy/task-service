/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.dynasys.entity;

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
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaView;
import net.ibizsys.psrt.srv.dynasys.service.DSDynaViewService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class DSDynaViewInstBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(DSDynaViewInstBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEID = "DEID";
    public static final String FIELD_DEWFID = "DEWFID";
    public static final String FIELD_DSDYNAVIEWID = "DSDYNAVIEWID";
    public static final String FIELD_DSDYNAVIEWINSTID = "DSDYNAVIEWINSTID";
    public static final String FIELD_DSDYNAVIEWINSTNAME = "DSDYNAVIEWINSTNAME";
    public static final String FIELD_DSDYNAVIEWNAME = "DSDYNAVIEWNAME";
    public static final String FIELD_DYNAMODEL = "DYNAMODEL";
    public static final String FIELD_DYNASYSINSTID = "DYNASYSINSTID";
    public static final String FIELD_INSTVER = "INSTVER";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PDVTPARAM = "PDVTPARAM";
    public static final String FIELD_PREDEFINEDVIEWTYPE = "PREDEFINEDVIEWTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VIEWINSTOBJ = "VIEWINSTOBJ";
    public static final String FIELD_VIEWTYPE = "VIEWTYPE";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DEID = 2;
    private static final int INDEX_DEWFID = 3;
    private static final int INDEX_DSDYNAVIEWID = 4;
    private static final int INDEX_DSDYNAVIEWINSTID = 5;
    private static final int INDEX_DSDYNAVIEWINSTNAME = 6;
    private static final int INDEX_DSDYNAVIEWNAME = 7;
    private static final int INDEX_DYNAMODEL = 8;
    private static final int INDEX_DYNASYSINSTID = 9;
    private static final int INDEX_INSTVER = 10;
    private static final int INDEX_MEMO = 11;
    private static final int INDEX_PDVTPARAM = 12;
    private static final int INDEX_PREDEFINEDVIEWTYPE = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final int INDEX_VIEWINSTOBJ = 16;
    private static final int INDEX_VIEWTYPE = 17;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private DSDynaViewInstBase proxyDSDynaViewInstBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean deidDirtyFlag = false;
    private boolean dewfidDirtyFlag = false;
    private boolean dsdynaviewidDirtyFlag = false;
    private boolean dsdynaviewinstidDirtyFlag = false;
    private boolean dsdynaviewinstnameDirtyFlag = false;
    private boolean dsdynaviewnameDirtyFlag = false;
    private boolean dynamodelDirtyFlag = false;
    private boolean dynasysinstidDirtyFlag = false;
    private boolean instverDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pdvtparamDirtyFlag = false;
    private boolean predefinedviewtypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean viewinstobjDirtyFlag = false;
    private boolean viewtypeDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="deid")
    private String deid;
    @Column(name="dewfid")
    private String dewfid;
    @Column(name="dsdynaviewid")
    private String dsdynaviewid;
    @Column(name="dsdynaviewinstid")
    private String dsdynaviewinstid;
    @Column(name="dsdynaviewinstname")
    private String dsdynaviewinstname;
    @Column(name="dsdynaviewname")
    private String dsdynaviewname;
    @Column(name="dynamodel")
    private String dynamodel;
    @Column(name="dynasysinstid")
    private String dynasysinstid;
    @Column(name="instver")
    private Integer instver;
    @Column(name="memo")
    private String memo;
    @Column(name="pdvtparam")
    private String pdvtparam;
    @Column(name="predefinedviewtype")
    private String predefinedviewtype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="viewinstobj")
    private String viewinstobj;
    @Column(name="viewtype")
    private String viewtype;
    private Integer objDSDynaViewLock = new Integer(1);
    private DSDynaView dsdynaview = null;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DEID, 2);
        fieldIndexMap.put(FIELD_DEWFID, 3);
        fieldIndexMap.put(FIELD_DSDYNAVIEWID, 4);
        fieldIndexMap.put(FIELD_DSDYNAVIEWINSTID, 5);
        fieldIndexMap.put(FIELD_DSDYNAVIEWINSTNAME, 6);
        fieldIndexMap.put(FIELD_DSDYNAVIEWNAME, 7);
        fieldIndexMap.put(FIELD_DYNAMODEL, 8);
        fieldIndexMap.put(FIELD_DYNASYSINSTID, 9);
        fieldIndexMap.put(FIELD_INSTVER, 10);
        fieldIndexMap.put(FIELD_MEMO, 11);
        fieldIndexMap.put(FIELD_PDVTPARAM, 12);
        fieldIndexMap.put(FIELD_PREDEFINEDVIEWTYPE, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
        fieldIndexMap.put(FIELD_VIEWINSTOBJ, 16);
        fieldIndexMap.put(FIELD_VIEWTYPE, 17);
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

    public void setDEWFId(String dewfid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEWFId(dewfid);
            return;
        }
        if (dewfid != null && (dewfid = StringHelper.trimRight(dewfid)).length() == 0) {
            dewfid = null;
        }
        this.dewfid = dewfid;
        this.dewfidDirtyFlag = true;
    }

    public String getDEWFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEWFId();
        }
        return this.dewfid;
    }

    public boolean isDEWFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEWFIdDirty();
        }
        return this.dewfidDirtyFlag;
    }

    public void resetDEWFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEWFId();
            return;
        }
        this.dewfidDirtyFlag = false;
        this.dewfid = null;
    }

    public void setDSDynaViewId(String dsdynaviewid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDSDynaViewId(dsdynaviewid);
            return;
        }
        if (dsdynaviewid != null && (dsdynaviewid = StringHelper.trimRight(dsdynaviewid)).length() == 0) {
            dsdynaviewid = null;
        }
        this.dsdynaviewid = dsdynaviewid;
        this.dsdynaviewidDirtyFlag = true;
    }

    public String getDSDynaViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDSDynaViewId();
        }
        return this.dsdynaviewid;
    }

    public boolean isDSDynaViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDSDynaViewIdDirty();
        }
        return this.dsdynaviewidDirtyFlag;
    }

    public void resetDSDynaViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDSDynaViewId();
            return;
        }
        this.dsdynaviewidDirtyFlag = false;
        this.dsdynaviewid = null;
    }

    public void setDSDynaViewInstId(String dsdynaviewinstid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDSDynaViewInstId(dsdynaviewinstid);
            return;
        }
        if (dsdynaviewinstid != null && (dsdynaviewinstid = StringHelper.trimRight(dsdynaviewinstid)).length() == 0) {
            dsdynaviewinstid = null;
        }
        this.dsdynaviewinstid = dsdynaviewinstid;
        this.dsdynaviewinstidDirtyFlag = true;
    }

    public String getDSDynaViewInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDSDynaViewInstId();
        }
        return this.dsdynaviewinstid;
    }

    public boolean isDSDynaViewInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDSDynaViewInstIdDirty();
        }
        return this.dsdynaviewinstidDirtyFlag;
    }

    public void resetDSDynaViewInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDSDynaViewInstId();
            return;
        }
        this.dsdynaviewinstidDirtyFlag = false;
        this.dsdynaviewinstid = null;
    }

    public void setDSDynaViewInstName(String dsdynaviewinstname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDSDynaViewInstName(dsdynaviewinstname);
            return;
        }
        if (dsdynaviewinstname != null && (dsdynaviewinstname = StringHelper.trimRight(dsdynaviewinstname)).length() == 0) {
            dsdynaviewinstname = null;
        }
        this.dsdynaviewinstname = dsdynaviewinstname;
        this.dsdynaviewinstnameDirtyFlag = true;
    }

    public String getDSDynaViewInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDSDynaViewInstName();
        }
        return this.dsdynaviewinstname;
    }

    public boolean isDSDynaViewInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDSDynaViewInstNameDirty();
        }
        return this.dsdynaviewinstnameDirtyFlag;
    }

    public void resetDSDynaViewInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDSDynaViewInstName();
            return;
        }
        this.dsdynaviewinstnameDirtyFlag = false;
        this.dsdynaviewinstname = null;
    }

    public void setDSDynaViewName(String dsdynaviewname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDSDynaViewName(dsdynaviewname);
            return;
        }
        if (dsdynaviewname != null && (dsdynaviewname = StringHelper.trimRight(dsdynaviewname)).length() == 0) {
            dsdynaviewname = null;
        }
        this.dsdynaviewname = dsdynaviewname;
        this.dsdynaviewnameDirtyFlag = true;
    }

    public String getDSDynaViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDSDynaViewName();
        }
        return this.dsdynaviewname;
    }

    public boolean isDSDynaViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDSDynaViewNameDirty();
        }
        return this.dsdynaviewnameDirtyFlag;
    }

    public void resetDSDynaViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDSDynaViewName();
            return;
        }
        this.dsdynaviewnameDirtyFlag = false;
        this.dsdynaviewname = null;
    }

    public void setDynaModel(String dynamodel) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaModel(dynamodel);
            return;
        }
        if (dynamodel != null && (dynamodel = StringHelper.trimRight(dynamodel)).length() == 0) {
            dynamodel = null;
        }
        this.dynamodel = dynamodel;
        this.dynamodelDirtyFlag = true;
    }

    public String getDynaModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaModel();
        }
        return this.dynamodel;
    }

    public boolean isDynaModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaModelDirty();
        }
        return this.dynamodelDirtyFlag;
    }

    public void resetDynaModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaModel();
            return;
        }
        this.dynamodelDirtyFlag = false;
        this.dynamodel = null;
    }

    public void setDynaSysInstId(String dynasysinstid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaSysInstId(dynasysinstid);
            return;
        }
        if (dynasysinstid != null && (dynasysinstid = StringHelper.trimRight(dynasysinstid)).length() == 0) {
            dynasysinstid = null;
        }
        this.dynasysinstid = dynasysinstid;
        this.dynasysinstidDirtyFlag = true;
    }

    public String getDynaSysInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaSysInstId();
        }
        return this.dynasysinstid;
    }

    public boolean isDynaSysInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaSysInstIdDirty();
        }
        return this.dynasysinstidDirtyFlag;
    }

    public void resetDynaSysInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaSysInstId();
            return;
        }
        this.dynasysinstidDirtyFlag = false;
        this.dynasysinstid = null;
    }

    public void setInstVer(Integer instver) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstVer(instver);
            return;
        }
        this.instver = instver;
        this.instverDirtyFlag = true;
    }

    public Integer getInstVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInstVer();
        }
        return this.instver;
    }

    public boolean isInstVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInstVerDirty();
        }
        return this.instverDirtyFlag;
    }

    public void resetInstVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInstVer();
            return;
        }
        this.instverDirtyFlag = false;
        this.instver = null;
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

    public void setPDVTParam(String pdvtparam) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPDVTParam(pdvtparam);
            return;
        }
        if (pdvtparam != null && (pdvtparam = StringHelper.trimRight(pdvtparam)).length() == 0) {
            pdvtparam = null;
        }
        this.pdvtparam = pdvtparam;
        this.pdvtparamDirtyFlag = true;
    }

    public String getPDVTParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPDVTParam();
        }
        return this.pdvtparam;
    }

    public boolean isPDVTParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPDVTParamDirty();
        }
        return this.pdvtparamDirtyFlag;
    }

    public void resetPDVTParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPDVTParam();
            return;
        }
        this.pdvtparamDirtyFlag = false;
        this.pdvtparam = null;
    }

    public void setPredefinedViewType(String predefinedviewtype) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPredefinedViewType(predefinedviewtype);
            return;
        }
        if (predefinedviewtype != null && (predefinedviewtype = StringHelper.trimRight(predefinedviewtype)).length() == 0) {
            predefinedviewtype = null;
        }
        this.predefinedviewtype = predefinedviewtype;
        this.predefinedviewtypeDirtyFlag = true;
    }

    public String getPredefinedViewType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPredefinedViewType();
        }
        return this.predefinedviewtype;
    }

    public boolean isPredefinedViewTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPredefinedViewTypeDirty();
        }
        return this.predefinedviewtypeDirtyFlag;
    }

    public void resetPredefinedViewType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPredefinedViewType();
            return;
        }
        this.predefinedviewtypeDirtyFlag = false;
        this.predefinedviewtype = null;
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

    public void setViewInstObj(String viewinstobj) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewInstObj(viewinstobj);
            return;
        }
        if (viewinstobj != null && (viewinstobj = StringHelper.trimRight(viewinstobj)).length() == 0) {
            viewinstobj = null;
        }
        this.viewinstobj = viewinstobj;
        this.viewinstobjDirtyFlag = true;
    }

    public String getViewInstObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewInstObj();
        }
        return this.viewinstobj;
    }

    public boolean isViewInstObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewInstObjDirty();
        }
        return this.viewinstobjDirtyFlag;
    }

    public void resetViewInstObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewInstObj();
            return;
        }
        this.viewinstobjDirtyFlag = false;
        this.viewinstobj = null;
    }

    public void setViewType(String viewtype) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewType(viewtype);
            return;
        }
        if (viewtype != null && (viewtype = StringHelper.trimRight(viewtype)).length() == 0) {
            viewtype = null;
        }
        this.viewtype = viewtype;
        this.viewtypeDirtyFlag = true;
    }

    public String getViewType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewType();
        }
        return this.viewtype;
    }

    public boolean isViewTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewTypeDirty();
        }
        return this.viewtypeDirtyFlag;
    }

    public void resetViewType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewType();
            return;
        }
        this.viewtypeDirtyFlag = false;
        this.viewtype = null;
    }

    @Override
    protected void onReset() {
        DSDynaViewInstBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(DSDynaViewInstBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetDEId();
        et.resetDEWFId();
        et.resetDSDynaViewId();
        et.resetDSDynaViewInstId();
        et.resetDSDynaViewInstName();
        et.resetDSDynaViewName();
        et.resetDynaModel();
        et.resetDynaSysInstId();
        et.resetInstVer();
        et.resetMemo();
        et.resetPDVTParam();
        et.resetPredefinedViewType();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetViewInstObj();
        et.resetViewType();
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
        if (!bDirtyOnly || this.isDEWFIdDirty()) {
            params.put(FIELD_DEWFID, this.getDEWFId());
        }
        if (!bDirtyOnly || this.isDSDynaViewIdDirty()) {
            params.put(FIELD_DSDYNAVIEWID, this.getDSDynaViewId());
        }
        if (!bDirtyOnly || this.isDSDynaViewInstIdDirty()) {
            params.put(FIELD_DSDYNAVIEWINSTID, this.getDSDynaViewInstId());
        }
        if (!bDirtyOnly || this.isDSDynaViewInstNameDirty()) {
            params.put(FIELD_DSDYNAVIEWINSTNAME, this.getDSDynaViewInstName());
        }
        if (!bDirtyOnly || this.isDSDynaViewNameDirty()) {
            params.put(FIELD_DSDYNAVIEWNAME, this.getDSDynaViewName());
        }
        if (!bDirtyOnly || this.isDynaModelDirty()) {
            params.put(FIELD_DYNAMODEL, this.getDynaModel());
        }
        if (!bDirtyOnly || this.isDynaSysInstIdDirty()) {
            params.put(FIELD_DYNASYSINSTID, this.getDynaSysInstId());
        }
        if (!bDirtyOnly || this.isInstVerDirty()) {
            params.put(FIELD_INSTVER, this.getInstVer());
        }
        if (!bDirtyOnly || this.isMemoDirty()) {
            params.put(FIELD_MEMO, this.getMemo());
        }
        if (!bDirtyOnly || this.isPDVTParamDirty()) {
            params.put(FIELD_PDVTPARAM, this.getPDVTParam());
        }
        if (!bDirtyOnly || this.isPredefinedViewTypeDirty()) {
            params.put(FIELD_PREDEFINEDVIEWTYPE, this.getPredefinedViewType());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isViewInstObjDirty()) {
            params.put(FIELD_VIEWINSTOBJ, this.getViewInstObj());
        }
        if (!bDirtyOnly || this.isViewTypeDirty()) {
            params.put(FIELD_VIEWTYPE, this.getViewType());
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
        return DSDynaViewInstBase.get(this, index);
    }

    private static Object get(DSDynaViewInstBase et, int index) throws Exception {
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
                return et.getDEWFId();
            }
            case 4: {
                return et.getDSDynaViewId();
            }
            case 5: {
                return et.getDSDynaViewInstId();
            }
            case 6: {
                return et.getDSDynaViewInstName();
            }
            case 7: {
                return et.getDSDynaViewName();
            }
            case 8: {
                return et.getDynaModel();
            }
            case 9: {
                return et.getDynaSysInstId();
            }
            case 10: {
                return et.getInstVer();
            }
            case 11: {
                return et.getMemo();
            }
            case 12: {
                return et.getPDVTParam();
            }
            case 13: {
                return et.getPredefinedViewType();
            }
            case 14: {
                return et.getUpdateDate();
            }
            case 15: {
                return et.getUpdateMan();
            }
            case 16: {
                return et.getViewInstObj();
            }
            case 17: {
                return et.getViewType();
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
        DSDynaViewInstBase.set(this, index, objValue);
    }

    private static void set(DSDynaViewInstBase et, int index, Object obj) throws Exception {
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
                et.setDEWFId(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setDSDynaViewId(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setDSDynaViewInstId(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setDSDynaViewInstName(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setDSDynaViewName(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setDynaModel(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setDynaSysInstId(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setInstVer(DataObject.getIntegerValue(obj));
                return;
            }
            case 11: {
                et.setMemo(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setPDVTParam(DataObject.getStringValue(obj));
                return;
            }
            case 13: {
                et.setPredefinedViewType(DataObject.getStringValue(obj));
                return;
            }
            case 14: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 15: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 16: {
                et.setViewInstObj(DataObject.getStringValue(obj));
                return;
            }
            case 17: {
                et.setViewType(DataObject.getStringValue(obj));
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
        return DSDynaViewInstBase.isNull(this, index);
    }

    private static boolean isNull(DSDynaViewInstBase et, int index) throws Exception {
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
                return et.getDEWFId() == null;
            }
            case 4: {
                return et.getDSDynaViewId() == null;
            }
            case 5: {
                return et.getDSDynaViewInstId() == null;
            }
            case 6: {
                return et.getDSDynaViewInstName() == null;
            }
            case 7: {
                return et.getDSDynaViewName() == null;
            }
            case 8: {
                return et.getDynaModel() == null;
            }
            case 9: {
                return et.getDynaSysInstId() == null;
            }
            case 10: {
                return et.getInstVer() == null;
            }
            case 11: {
                return et.getMemo() == null;
            }
            case 12: {
                return et.getPDVTParam() == null;
            }
            case 13: {
                return et.getPredefinedViewType() == null;
            }
            case 14: {
                return et.getUpdateDate() == null;
            }
            case 15: {
                return et.getUpdateMan() == null;
            }
            case 16: {
                return et.getViewInstObj() == null;
            }
            case 17: {
                return et.getViewType() == null;
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
        return DSDynaViewInstBase.contains(this, index);
    }

    private static boolean contains(DSDynaViewInstBase et, int index) throws Exception {
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
                return et.isDEWFIdDirty();
            }
            case 4: {
                return et.isDSDynaViewIdDirty();
            }
            case 5: {
                return et.isDSDynaViewInstIdDirty();
            }
            case 6: {
                return et.isDSDynaViewInstNameDirty();
            }
            case 7: {
                return et.isDSDynaViewNameDirty();
            }
            case 8: {
                return et.isDynaModelDirty();
            }
            case 9: {
                return et.isDynaSysInstIdDirty();
            }
            case 10: {
                return et.isInstVerDirty();
            }
            case 11: {
                return et.isMemoDirty();
            }
            case 12: {
                return et.isPDVTParamDirty();
            }
            case 13: {
                return et.isPredefinedViewTypeDirty();
            }
            case 14: {
                return et.isUpdateDateDirty();
            }
            case 15: {
                return et.isUpdateManDirty();
            }
            case 16: {
                return et.isViewInstObjDirty();
            }
            case 17: {
                return et.isViewTypeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        DSDynaViewInstBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(DSDynaViewInstBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", DSDynaViewInstBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", DSDynaViewInstBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getDEId() != null) {
            JSONObjectHelper.put(json, "deid", DSDynaViewInstBase.getJSONValue(et.getDEId()), false);
        }
        if (bIncEmpty || et.getDEWFId() != null) {
            JSONObjectHelper.put(json, "dewfid", DSDynaViewInstBase.getJSONValue(et.getDEWFId()), false);
        }
        if (bIncEmpty || et.getDSDynaViewId() != null) {
            JSONObjectHelper.put(json, "dsdynaviewid", DSDynaViewInstBase.getJSONValue(et.getDSDynaViewId()), false);
        }
        if (bIncEmpty || et.getDSDynaViewInstId() != null) {
            JSONObjectHelper.put(json, "dsdynaviewinstid", DSDynaViewInstBase.getJSONValue(et.getDSDynaViewInstId()), false);
        }
        if (bIncEmpty || et.getDSDynaViewInstName() != null) {
            JSONObjectHelper.put(json, "dsdynaviewinstname", DSDynaViewInstBase.getJSONValue(et.getDSDynaViewInstName()), false);
        }
        if (bIncEmpty || et.getDSDynaViewName() != null) {
            JSONObjectHelper.put(json, "dsdynaviewname", DSDynaViewInstBase.getJSONValue(et.getDSDynaViewName()), false);
        }
        if (bIncEmpty || et.getDynaModel() != null) {
            JSONObjectHelper.put(json, "dynamodel", DSDynaViewInstBase.getJSONValue(et.getDynaModel()), false);
        }
        if (bIncEmpty || et.getDynaSysInstId() != null) {
            JSONObjectHelper.put(json, "dynasysinstid", DSDynaViewInstBase.getJSONValue(et.getDynaSysInstId()), false);
        }
        if (bIncEmpty || et.getInstVer() != null) {
            JSONObjectHelper.put(json, "instver", DSDynaViewInstBase.getJSONValue(et.getInstVer()), false);
        }
        if (bIncEmpty || et.getMemo() != null) {
            JSONObjectHelper.put(json, "memo", DSDynaViewInstBase.getJSONValue(et.getMemo()), false);
        }
        if (bIncEmpty || et.getPDVTParam() != null) {
            JSONObjectHelper.put(json, "pdvtparam", DSDynaViewInstBase.getJSONValue(et.getPDVTParam()), false);
        }
        if (bIncEmpty || et.getPredefinedViewType() != null) {
            JSONObjectHelper.put(json, "predefinedviewtype", DSDynaViewInstBase.getJSONValue(et.getPredefinedViewType()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", DSDynaViewInstBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", DSDynaViewInstBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getViewInstObj() != null) {
            JSONObjectHelper.put(json, "viewinstobj", DSDynaViewInstBase.getJSONValue(et.getViewInstObj()), false);
        }
        if (bIncEmpty || et.getViewType() != null) {
            JSONObjectHelper.put(json, "viewtype", DSDynaViewInstBase.getJSONValue(et.getViewType()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        DSDynaViewInstBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(DSDynaViewInstBase et, XmlNode node, boolean bIncEmpty) throws Exception {
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
        if (bIncEmpty || et.getDEWFId() != null) {
            obj = et.getDEWFId();
            node.setAttribute(FIELD_DEWFID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDSDynaViewId() != null) {
            obj = et.getDSDynaViewId();
            node.setAttribute(FIELD_DSDYNAVIEWID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDSDynaViewInstId() != null) {
            obj = et.getDSDynaViewInstId();
            node.setAttribute(FIELD_DSDYNAVIEWINSTID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDSDynaViewInstName() != null) {
            obj = et.getDSDynaViewInstName();
            node.setAttribute(FIELD_DSDYNAVIEWINSTNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDSDynaViewName() != null) {
            obj = et.getDSDynaViewName();
            node.setAttribute(FIELD_DSDYNAVIEWNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDynaModel() != null) {
            obj = et.getDynaModel();
            node.setAttribute(FIELD_DYNAMODEL, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDynaSysInstId() != null) {
            obj = et.getDynaSysInstId();
            node.setAttribute(FIELD_DYNASYSINSTID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getInstVer() != null) {
            obj = et.getInstVer();
            node.setAttribute(FIELD_INSTVER, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getMemo() != null) {
            obj = et.getMemo();
            node.setAttribute(FIELD_MEMO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getPDVTParam() != null) {
            obj = et.getPDVTParam();
            node.setAttribute(FIELD_PDVTPARAM, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getPredefinedViewType() != null) {
            obj = et.getPredefinedViewType();
            node.setAttribute(FIELD_PREDEFINEDVIEWTYPE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getViewInstObj() != null) {
            obj = et.getViewInstObj();
            node.setAttribute(FIELD_VIEWINSTOBJ, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getViewType() != null) {
            obj = et.getViewType();
            node.setAttribute(FIELD_VIEWTYPE, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        DSDynaViewInstBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(DSDynaViewInstBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isDEIdDirty() && (bIncEmpty || et.getDEId() != null)) {
            dst.set(FIELD_DEID, et.getDEId());
        }
        if (et.isDEWFIdDirty() && (bIncEmpty || et.getDEWFId() != null)) {
            dst.set(FIELD_DEWFID, et.getDEWFId());
        }
        if (et.isDSDynaViewIdDirty() && (bIncEmpty || et.getDSDynaViewId() != null)) {
            dst.set(FIELD_DSDYNAVIEWID, et.getDSDynaViewId());
        }
        if (et.isDSDynaViewInstIdDirty() && (bIncEmpty || et.getDSDynaViewInstId() != null)) {
            dst.set(FIELD_DSDYNAVIEWINSTID, et.getDSDynaViewInstId());
        }
        if (et.isDSDynaViewInstNameDirty() && (bIncEmpty || et.getDSDynaViewInstName() != null)) {
            dst.set(FIELD_DSDYNAVIEWINSTNAME, et.getDSDynaViewInstName());
        }
        if (et.isDSDynaViewNameDirty() && (bIncEmpty || et.getDSDynaViewName() != null)) {
            dst.set(FIELD_DSDYNAVIEWNAME, et.getDSDynaViewName());
        }
        if (et.isDynaModelDirty() && (bIncEmpty || et.getDynaModel() != null)) {
            dst.set(FIELD_DYNAMODEL, et.getDynaModel());
        }
        if (et.isDynaSysInstIdDirty() && (bIncEmpty || et.getDynaSysInstId() != null)) {
            dst.set(FIELD_DYNASYSINSTID, et.getDynaSysInstId());
        }
        if (et.isInstVerDirty() && (bIncEmpty || et.getInstVer() != null)) {
            dst.set(FIELD_INSTVER, et.getInstVer());
        }
        if (et.isMemoDirty() && (bIncEmpty || et.getMemo() != null)) {
            dst.set(FIELD_MEMO, et.getMemo());
        }
        if (et.isPDVTParamDirty() && (bIncEmpty || et.getPDVTParam() != null)) {
            dst.set(FIELD_PDVTPARAM, et.getPDVTParam());
        }
        if (et.isPredefinedViewTypeDirty() && (bIncEmpty || et.getPredefinedViewType() != null)) {
            dst.set(FIELD_PREDEFINEDVIEWTYPE, et.getPredefinedViewType());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isViewInstObjDirty() && (bIncEmpty || et.getViewInstObj() != null)) {
            dst.set(FIELD_VIEWINSTOBJ, et.getViewInstObj());
        }
        if (et.isViewTypeDirty() && (bIncEmpty || et.getViewType() != null)) {
            dst.set(FIELD_VIEWTYPE, et.getViewType());
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
        return DSDynaViewInstBase.remove(this, index);
    }

    private static boolean remove(DSDynaViewInstBase et, int index) throws Exception {
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
                et.resetDEWFId();
                return true;
            }
            case 4: {
                et.resetDSDynaViewId();
                return true;
            }
            case 5: {
                et.resetDSDynaViewInstId();
                return true;
            }
            case 6: {
                et.resetDSDynaViewInstName();
                return true;
            }
            case 7: {
                et.resetDSDynaViewName();
                return true;
            }
            case 8: {
                et.resetDynaModel();
                return true;
            }
            case 9: {
                et.resetDynaSysInstId();
                return true;
            }
            case 10: {
                et.resetInstVer();
                return true;
            }
            case 11: {
                et.resetMemo();
                return true;
            }
            case 12: {
                et.resetPDVTParam();
                return true;
            }
            case 13: {
                et.resetPredefinedViewType();
                return true;
            }
            case 14: {
                et.resetUpdateDate();
                return true;
            }
            case 15: {
                et.resetUpdateMan();
                return true;
            }
            case 16: {
                et.resetViewInstObj();
                return true;
            }
            case 17: {
                et.resetViewType();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public DSDynaView getDSDynaView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDSDynaView();
        }
        if (this.getDSDynaViewId() == null) {
            return null;
        }
        Integer n = this.objDSDynaViewLock;
        synchronized (n) {
            if (this.dsdynaview != null && DataTypeHelper.compare(25, (Object)this.getDSDynaViewId(), (Object)this.dsdynaview.getDSDynaViewId()) != 0L) {
                this.dsdynaview = null;
            }
            if (this.dsdynaview == null) {
                DSDynaView dsdynaview = new DSDynaView();
                dsdynaview.setDSDynaViewId(this.getDSDynaViewId());
                DSDynaViewService service = (DSDynaViewService)ServiceGlobal.getService(DSDynaViewService.class, this.getSessionFactory());
                service.autoGet(dsdynaview);
                this.dsdynaview = dsdynaview;
            }
            return this.dsdynaview;
        }
    }

    private DSDynaViewInstBase getProxyEntity() {
        return this.proxyDSDynaViewInstBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyDSDynaViewInstBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof DSDynaViewInstBase) {
            this.proxyDSDynaViewInstBase = (DSDynaViewInstBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.dynasys.service.DSDynaViewInstService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

