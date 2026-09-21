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
import net.ibizsys.pscore.srv.config.entity.PSPFPlugin;
import net.ibizsys.pscore.srv.config.service.PSPFPluginService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSViewStyleBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSViewStyleBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_EXTENDCTRL = "EXTENDCTRL";
    public static final String FIELD_EXTENDVIEW = "EXTENDVIEW";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_NAMEMODE = "NAMEMODE";
    public static final String FIELD_PSDCID = "PSDCID";
    public static final String FIELD_PSDCNAME = "PSDCNAME";
    public static final String FIELD_PSPFPLUGINID = "PSPFPLUGINID";
    public static final String FIELD_PSPFPLUGINNAME = "PSPFPLUGINNAME";
    public static final String FIELD_PSVIEWSTYLEID = "PSVIEWSTYLEID";
    public static final String FIELD_PSVIEWSTYLENAME = "PSVIEWSTYLENAME";
    public static final String FIELD_TYPECODE = "TYPECODE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VIEWPARAMS = "VIEWPARAMS";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_EXTENDCTRL = 2;
    private static final int INDEX_EXTENDVIEW = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_NAMEMODE = 5;
    private static final int INDEX_PSDCID = 6;
    private static final int INDEX_PSDCNAME = 7;
    private static final int INDEX_PSPFPLUGINID = 8;
    private static final int INDEX_PSPFPLUGINNAME = 9;
    private static final int INDEX_PSVIEWSTYLEID = 10;
    private static final int INDEX_PSVIEWSTYLENAME = 11;
    private static final int INDEX_TYPECODE = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final int INDEX_VIEWPARAMS = 15;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSViewStyleBase proxyPSViewStyleBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean extendctrlDirtyFlag = false;
    private boolean extendviewDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean namemodeDirtyFlag = false;
    private boolean psdcidDirtyFlag = false;
    private boolean psdcnameDirtyFlag = false;
    private boolean pspfpluginidDirtyFlag = false;
    private boolean pspfpluginnameDirtyFlag = false;
    private boolean psviewstyleidDirtyFlag = false;
    private boolean psviewstylenameDirtyFlag = false;
    private boolean typecodeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean viewparamsDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="extendctrl")
    private Integer extendctrl;
    @Column(name="extendview")
    private Integer extendview;
    @Column(name="memo")
    private String memo;
    @Column(name="namemode")
    private String namemode;
    @Column(name="psdcid")
    private String psdcid;
    @Column(name="psdcname")
    private String psdcname;
    @Column(name="pspfpluginid")
    private String pspfpluginid;
    @Column(name="pspfpluginname")
    private String pspfpluginname;
    @Column(name="psviewstyleid")
    private String psviewstyleid;
    @Column(name="psviewstylename")
    private String psviewstylename;
    @Column(name="typecode")
    private String typecode;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="viewparams")
    private String viewparams;
    private Integer objPSDCLock = new Integer(1);
    private PSDevCenter psdc = null;
    private Integer objPSPFPluginLock = new Integer(1);
    private PSPFPlugin pspfplugin = null;

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

    public void setExtendCtrl(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExtendCtrl(n);
            return;
        }
        this.extendctrl = n;
        this.extendctrlDirtyFlag = true;
    }

    public Integer getExtendCtrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExtendCtrl();
        }
        return this.extendctrl;
    }

    public boolean isExtendCtrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExtendCtrlDirty();
        }
        return this.extendctrlDirtyFlag;
    }

    public void resetExtendCtrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExtendCtrl();
            return;
        }
        this.extendctrlDirtyFlag = false;
        this.extendctrl = null;
    }

    public void setExtendView(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExtendView(n);
            return;
        }
        this.extendview = n;
        this.extendviewDirtyFlag = true;
    }

    public Integer getExtendView() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExtendView();
        }
        return this.extendview;
    }

    public boolean isExtendViewDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExtendViewDirty();
        }
        return this.extendviewDirtyFlag;
    }

    public void resetExtendView() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExtendView();
            return;
        }
        this.extendviewDirtyFlag = false;
        this.extendview = null;
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

    public void setNameMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNameMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.namemode = string;
        this.namemodeDirtyFlag = true;
    }

    public String getNameMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNameMode();
        }
        return this.namemode;
    }

    public boolean isNameModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNameModeDirty();
        }
        return this.namemodeDirtyFlag;
    }

    public void resetNameMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNameMode();
            return;
        }
        this.namemodeDirtyFlag = false;
        this.namemode = null;
    }

    public void setPSDCId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcid = string;
        this.psdcidDirtyFlag = true;
    }

    public String getPSDCId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCId();
        }
        return this.psdcid;
    }

    public boolean isPSDCIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCIdDirty();
        }
        return this.psdcidDirtyFlag;
    }

    public void resetPSDCId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCId();
            return;
        }
        this.psdcidDirtyFlag = false;
        this.psdcid = null;
    }

    public void setPSDCName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcname = string;
        this.psdcnameDirtyFlag = true;
    }

    public String getPSDCName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCName();
        }
        return this.psdcname;
    }

    public boolean isPSDCNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCNameDirty();
        }
        return this.psdcnameDirtyFlag;
    }

    public void resetPSDCName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCName();
            return;
        }
        this.psdcnameDirtyFlag = false;
        this.psdcname = null;
    }

    public void setPSPFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpluginid = string;
        this.pspfpluginidDirtyFlag = true;
    }

    public String getPSPFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPluginId();
        }
        return this.pspfpluginid;
    }

    public boolean isPSPFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPluginIdDirty();
        }
        return this.pspfpluginidDirtyFlag;
    }

    public void resetPSPFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPluginId();
            return;
        }
        this.pspfpluginidDirtyFlag = false;
        this.pspfpluginid = null;
    }

    public void setPSPFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpluginname = string;
        this.pspfpluginnameDirtyFlag = true;
    }

    public String getPSPFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPluginName();
        }
        return this.pspfpluginname;
    }

    public boolean isPSPFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPluginNameDirty();
        }
        return this.pspfpluginnameDirtyFlag;
    }

    public void resetPSPFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPluginName();
            return;
        }
        this.pspfpluginnameDirtyFlag = false;
        this.pspfpluginname = null;
    }

    public void setPSViewStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewstyleid = string;
        this.psviewstyleidDirtyFlag = true;
    }

    public String getPSViewStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewStyleId();
        }
        return this.psviewstyleid;
    }

    public boolean isPSViewStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewStyleIdDirty();
        }
        return this.psviewstyleidDirtyFlag;
    }

    public void resetPSViewStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewStyleId();
            return;
        }
        this.psviewstyleidDirtyFlag = false;
        this.psviewstyleid = null;
    }

    public void setPSViewStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewstylename = string;
        this.psviewstylenameDirtyFlag = true;
    }

    public String getPSViewStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewStyleName();
        }
        return this.psviewstylename;
    }

    public boolean isPSViewStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewStyleNameDirty();
        }
        return this.psviewstylenameDirtyFlag;
    }

    public void resetPSViewStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewStyleName();
            return;
        }
        this.psviewstylenameDirtyFlag = false;
        this.psviewstylename = null;
    }

    public void setTypeCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typecode = string;
        this.typecodeDirtyFlag = true;
    }

    public String getTypeCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeCode();
        }
        return this.typecode;
    }

    public boolean isTypeCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeCodeDirty();
        }
        return this.typecodeDirtyFlag;
    }

    public void resetTypeCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeCode();
            return;
        }
        this.typecodeDirtyFlag = false;
        this.typecode = null;
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

    public void setViewParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewparams = string;
        this.viewparamsDirtyFlag = true;
    }

    public String getViewParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewParams();
        }
        return this.viewparams;
    }

    public boolean isViewParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewParamsDirty();
        }
        return this.viewparamsDirtyFlag;
    }

    public void resetViewParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewParams();
            return;
        }
        this.viewparamsDirtyFlag = false;
        this.viewparams = null;
    }

    protected void onReset() {
        PSViewStyleBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSViewStyleBase pSViewStyleBase) {
        pSViewStyleBase.resetCreateDate();
        pSViewStyleBase.resetCreateMan();
        pSViewStyleBase.resetExtendCtrl();
        pSViewStyleBase.resetExtendView();
        pSViewStyleBase.resetMemo();
        pSViewStyleBase.resetNameMode();
        pSViewStyleBase.resetPSDCId();
        pSViewStyleBase.resetPSDCName();
        pSViewStyleBase.resetPSPFPluginId();
        pSViewStyleBase.resetPSPFPluginName();
        pSViewStyleBase.resetPSViewStyleId();
        pSViewStyleBase.resetPSViewStyleName();
        pSViewStyleBase.resetTypeCode();
        pSViewStyleBase.resetUpdateDate();
        pSViewStyleBase.resetUpdateMan();
        pSViewStyleBase.resetViewParams();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isExtendCtrlDirty()) {
            hashMap.put(FIELD_EXTENDCTRL, this.getExtendCtrl());
        }
        if (!bl || this.isExtendViewDirty()) {
            hashMap.put(FIELD_EXTENDVIEW, this.getExtendView());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isNameModeDirty()) {
            hashMap.put(FIELD_NAMEMODE, this.getNameMode());
        }
        if (!bl || this.isPSDCIdDirty()) {
            hashMap.put(FIELD_PSDCID, this.getPSDCId());
        }
        if (!bl || this.isPSDCNameDirty()) {
            hashMap.put(FIELD_PSDCNAME, this.getPSDCName());
        }
        if (!bl || this.isPSPFPluginIdDirty()) {
            hashMap.put(FIELD_PSPFPLUGINID, this.getPSPFPluginId());
        }
        if (!bl || this.isPSPFPluginNameDirty()) {
            hashMap.put(FIELD_PSPFPLUGINNAME, this.getPSPFPluginName());
        }
        if (!bl || this.isPSViewStyleIdDirty()) {
            hashMap.put(FIELD_PSVIEWSTYLEID, this.getPSViewStyleId());
        }
        if (!bl || this.isPSViewStyleNameDirty()) {
            hashMap.put(FIELD_PSVIEWSTYLENAME, this.getPSViewStyleName());
        }
        if (!bl || this.isTypeCodeDirty()) {
            hashMap.put(FIELD_TYPECODE, this.getTypeCode());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isViewParamsDirty()) {
            hashMap.put(FIELD_VIEWPARAMS, this.getViewParams());
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
        return PSViewStyleBase.get(this, n);
    }

    private static Object get(PSViewStyleBase pSViewStyleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSViewStyleBase.getCreateDate();
            }
            case 1: {
                return pSViewStyleBase.getCreateMan();
            }
            case 2: {
                return pSViewStyleBase.getExtendCtrl();
            }
            case 3: {
                return pSViewStyleBase.getExtendView();
            }
            case 4: {
                return pSViewStyleBase.getMemo();
            }
            case 5: {
                return pSViewStyleBase.getNameMode();
            }
            case 6: {
                return pSViewStyleBase.getPSDCId();
            }
            case 7: {
                return pSViewStyleBase.getPSDCName();
            }
            case 8: {
                return pSViewStyleBase.getPSPFPluginId();
            }
            case 9: {
                return pSViewStyleBase.getPSPFPluginName();
            }
            case 10: {
                return pSViewStyleBase.getPSViewStyleId();
            }
            case 11: {
                return pSViewStyleBase.getPSViewStyleName();
            }
            case 12: {
                return pSViewStyleBase.getTypeCode();
            }
            case 13: {
                return pSViewStyleBase.getUpdateDate();
            }
            case 14: {
                return pSViewStyleBase.getUpdateMan();
            }
            case 15: {
                return pSViewStyleBase.getViewParams();
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
        PSViewStyleBase.set(this, n, object);
    }

    private static void set(PSViewStyleBase pSViewStyleBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSViewStyleBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSViewStyleBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSViewStyleBase.setExtendCtrl(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSViewStyleBase.setExtendView(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSViewStyleBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSViewStyleBase.setNameMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSViewStyleBase.setPSDCId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSViewStyleBase.setPSDCName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSViewStyleBase.setPSPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSViewStyleBase.setPSPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSViewStyleBase.setPSViewStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSViewStyleBase.setPSViewStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSViewStyleBase.setTypeCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSViewStyleBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSViewStyleBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSViewStyleBase.setViewParams(DataObject.getStringValue((Object)object));
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
        return PSViewStyleBase.isNull(this, n);
    }

    private static boolean isNull(PSViewStyleBase pSViewStyleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSViewStyleBase.getCreateDate() == null;
            }
            case 1: {
                return pSViewStyleBase.getCreateMan() == null;
            }
            case 2: {
                return pSViewStyleBase.getExtendCtrl() == null;
            }
            case 3: {
                return pSViewStyleBase.getExtendView() == null;
            }
            case 4: {
                return pSViewStyleBase.getMemo() == null;
            }
            case 5: {
                return pSViewStyleBase.getNameMode() == null;
            }
            case 6: {
                return pSViewStyleBase.getPSDCId() == null;
            }
            case 7: {
                return pSViewStyleBase.getPSDCName() == null;
            }
            case 8: {
                return pSViewStyleBase.getPSPFPluginId() == null;
            }
            case 9: {
                return pSViewStyleBase.getPSPFPluginName() == null;
            }
            case 10: {
                return pSViewStyleBase.getPSViewStyleId() == null;
            }
            case 11: {
                return pSViewStyleBase.getPSViewStyleName() == null;
            }
            case 12: {
                return pSViewStyleBase.getTypeCode() == null;
            }
            case 13: {
                return pSViewStyleBase.getUpdateDate() == null;
            }
            case 14: {
                return pSViewStyleBase.getUpdateMan() == null;
            }
            case 15: {
                return pSViewStyleBase.getViewParams() == null;
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
        return PSViewStyleBase.contains(this, n);
    }

    private static boolean contains(PSViewStyleBase pSViewStyleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSViewStyleBase.isCreateDateDirty();
            }
            case 1: {
                return pSViewStyleBase.isCreateManDirty();
            }
            case 2: {
                return pSViewStyleBase.isExtendCtrlDirty();
            }
            case 3: {
                return pSViewStyleBase.isExtendViewDirty();
            }
            case 4: {
                return pSViewStyleBase.isMemoDirty();
            }
            case 5: {
                return pSViewStyleBase.isNameModeDirty();
            }
            case 6: {
                return pSViewStyleBase.isPSDCIdDirty();
            }
            case 7: {
                return pSViewStyleBase.isPSDCNameDirty();
            }
            case 8: {
                return pSViewStyleBase.isPSPFPluginIdDirty();
            }
            case 9: {
                return pSViewStyleBase.isPSPFPluginNameDirty();
            }
            case 10: {
                return pSViewStyleBase.isPSViewStyleIdDirty();
            }
            case 11: {
                return pSViewStyleBase.isPSViewStyleNameDirty();
            }
            case 12: {
                return pSViewStyleBase.isTypeCodeDirty();
            }
            case 13: {
                return pSViewStyleBase.isUpdateDateDirty();
            }
            case 14: {
                return pSViewStyleBase.isUpdateManDirty();
            }
            case 15: {
                return pSViewStyleBase.isViewParamsDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSViewStyleBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSViewStyleBase pSViewStyleBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSViewStyleBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSViewStyleBase.getJSONValue((Object)pSViewStyleBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSViewStyleBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSViewStyleBase.getJSONValue((Object)pSViewStyleBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSViewStyleBase.getExtendCtrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extendctrl", (Object)PSViewStyleBase.getJSONValue((Object)pSViewStyleBase.getExtendCtrl()), (boolean)false);
        }
        if (bl || pSViewStyleBase.getExtendView() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extendview", (Object)PSViewStyleBase.getJSONValue((Object)pSViewStyleBase.getExtendView()), (boolean)false);
        }
        if (bl || pSViewStyleBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSViewStyleBase.getJSONValue((Object)pSViewStyleBase.getMemo()), (boolean)false);
        }
        if (bl || pSViewStyleBase.getNameMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"namemode", (Object)PSViewStyleBase.getJSONValue((Object)pSViewStyleBase.getNameMode()), (boolean)false);
        }
        if (bl || pSViewStyleBase.getPSDCId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcid", (Object)PSViewStyleBase.getJSONValue((Object)pSViewStyleBase.getPSDCId()), (boolean)false);
        }
        if (bl || pSViewStyleBase.getPSDCName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcname", (Object)PSViewStyleBase.getJSONValue((Object)pSViewStyleBase.getPSDCName()), (boolean)false);
        }
        if (bl || pSViewStyleBase.getPSPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpluginid", (Object)PSViewStyleBase.getJSONValue((Object)pSViewStyleBase.getPSPFPluginId()), (boolean)false);
        }
        if (bl || pSViewStyleBase.getPSPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpluginname", (Object)PSViewStyleBase.getJSONValue((Object)pSViewStyleBase.getPSPFPluginName()), (boolean)false);
        }
        if (bl || pSViewStyleBase.getPSViewStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewstyleid", (Object)PSViewStyleBase.getJSONValue((Object)pSViewStyleBase.getPSViewStyleId()), (boolean)false);
        }
        if (bl || pSViewStyleBase.getPSViewStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewstylename", (Object)PSViewStyleBase.getJSONValue((Object)pSViewStyleBase.getPSViewStyleName()), (boolean)false);
        }
        if (bl || pSViewStyleBase.getTypeCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typecode", (Object)PSViewStyleBase.getJSONValue((Object)pSViewStyleBase.getTypeCode()), (boolean)false);
        }
        if (bl || pSViewStyleBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSViewStyleBase.getJSONValue((Object)pSViewStyleBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSViewStyleBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSViewStyleBase.getJSONValue((Object)pSViewStyleBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSViewStyleBase.getViewParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparams", (Object)PSViewStyleBase.getJSONValue((Object)pSViewStyleBase.getViewParams()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSViewStyleBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSViewStyleBase pSViewStyleBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSViewStyleBase.getCreateDate() != null) {
            object = pSViewStyleBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSViewStyleBase.getCreateMan() != null) {
            object = pSViewStyleBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSViewStyleBase.getExtendCtrl() != null) {
            object = pSViewStyleBase.getExtendCtrl();
            xmlNode.setAttribute(FIELD_EXTENDCTRL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSViewStyleBase.getExtendView() != null) {
            object = pSViewStyleBase.getExtendView();
            xmlNode.setAttribute(FIELD_EXTENDVIEW, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSViewStyleBase.getMemo() != null) {
            object = pSViewStyleBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSViewStyleBase.getNameMode() != null) {
            object = pSViewStyleBase.getNameMode();
            xmlNode.setAttribute(FIELD_NAMEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSViewStyleBase.getPSDCId() != null) {
            object = pSViewStyleBase.getPSDCId();
            xmlNode.setAttribute(FIELD_PSDCID, object == null ? "" : (String)object);
        }
        if (bl || pSViewStyleBase.getPSDCName() != null) {
            object = pSViewStyleBase.getPSDCName();
            xmlNode.setAttribute(FIELD_PSDCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewStyleBase.getPSPFPluginId() != null) {
            object = pSViewStyleBase.getPSPFPluginId();
            xmlNode.setAttribute(FIELD_PSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSViewStyleBase.getPSPFPluginName() != null) {
            object = pSViewStyleBase.getPSPFPluginName();
            xmlNode.setAttribute(FIELD_PSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewStyleBase.getPSViewStyleId() != null) {
            object = pSViewStyleBase.getPSViewStyleId();
            xmlNode.setAttribute(FIELD_PSVIEWSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSViewStyleBase.getPSViewStyleName() != null) {
            object = pSViewStyleBase.getPSViewStyleName();
            xmlNode.setAttribute(FIELD_PSVIEWSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewStyleBase.getTypeCode() != null) {
            object = pSViewStyleBase.getTypeCode();
            xmlNode.setAttribute(FIELD_TYPECODE, object == null ? "" : (String)object);
        }
        if (bl || pSViewStyleBase.getUpdateDate() != null) {
            object = pSViewStyleBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSViewStyleBase.getUpdateMan() != null) {
            object = pSViewStyleBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSViewStyleBase.getViewParams() != null) {
            object = pSViewStyleBase.getViewParams();
            xmlNode.setAttribute(FIELD_VIEWPARAMS, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSViewStyleBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSViewStyleBase pSViewStyleBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSViewStyleBase.isCreateDateDirty() && (bl || pSViewStyleBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSViewStyleBase.getCreateDate());
        }
        if (pSViewStyleBase.isCreateManDirty() && (bl || pSViewStyleBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSViewStyleBase.getCreateMan());
        }
        if (pSViewStyleBase.isExtendCtrlDirty() && (bl || pSViewStyleBase.getExtendCtrl() != null)) {
            iDataObject.set(FIELD_EXTENDCTRL, (Object)pSViewStyleBase.getExtendCtrl());
        }
        if (pSViewStyleBase.isExtendViewDirty() && (bl || pSViewStyleBase.getExtendView() != null)) {
            iDataObject.set(FIELD_EXTENDVIEW, (Object)pSViewStyleBase.getExtendView());
        }
        if (pSViewStyleBase.isMemoDirty() && (bl || pSViewStyleBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSViewStyleBase.getMemo());
        }
        if (pSViewStyleBase.isNameModeDirty() && (bl || pSViewStyleBase.getNameMode() != null)) {
            iDataObject.set(FIELD_NAMEMODE, (Object)pSViewStyleBase.getNameMode());
        }
        if (pSViewStyleBase.isPSDCIdDirty() && (bl || pSViewStyleBase.getPSDCId() != null)) {
            iDataObject.set(FIELD_PSDCID, (Object)pSViewStyleBase.getPSDCId());
        }
        if (pSViewStyleBase.isPSDCNameDirty() && (bl || pSViewStyleBase.getPSDCName() != null)) {
            iDataObject.set(FIELD_PSDCNAME, (Object)pSViewStyleBase.getPSDCName());
        }
        if (pSViewStyleBase.isPSPFPluginIdDirty() && (bl || pSViewStyleBase.getPSPFPluginId() != null)) {
            iDataObject.set(FIELD_PSPFPLUGINID, (Object)pSViewStyleBase.getPSPFPluginId());
        }
        if (pSViewStyleBase.isPSPFPluginNameDirty() && (bl || pSViewStyleBase.getPSPFPluginName() != null)) {
            iDataObject.set(FIELD_PSPFPLUGINNAME, (Object)pSViewStyleBase.getPSPFPluginName());
        }
        if (pSViewStyleBase.isPSViewStyleIdDirty() && (bl || pSViewStyleBase.getPSViewStyleId() != null)) {
            iDataObject.set(FIELD_PSVIEWSTYLEID, (Object)pSViewStyleBase.getPSViewStyleId());
        }
        if (pSViewStyleBase.isPSViewStyleNameDirty() && (bl || pSViewStyleBase.getPSViewStyleName() != null)) {
            iDataObject.set(FIELD_PSVIEWSTYLENAME, (Object)pSViewStyleBase.getPSViewStyleName());
        }
        if (pSViewStyleBase.isTypeCodeDirty() && (bl || pSViewStyleBase.getTypeCode() != null)) {
            iDataObject.set(FIELD_TYPECODE, (Object)pSViewStyleBase.getTypeCode());
        }
        if (pSViewStyleBase.isUpdateDateDirty() && (bl || pSViewStyleBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSViewStyleBase.getUpdateDate());
        }
        if (pSViewStyleBase.isUpdateManDirty() && (bl || pSViewStyleBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSViewStyleBase.getUpdateMan());
        }
        if (pSViewStyleBase.isViewParamsDirty() && (bl || pSViewStyleBase.getViewParams() != null)) {
            iDataObject.set(FIELD_VIEWPARAMS, (Object)pSViewStyleBase.getViewParams());
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
        return PSViewStyleBase.remove(this, n);
    }

    private static boolean remove(PSViewStyleBase pSViewStyleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSViewStyleBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSViewStyleBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSViewStyleBase.resetExtendCtrl();
                return true;
            }
            case 3: {
                pSViewStyleBase.resetExtendView();
                return true;
            }
            case 4: {
                pSViewStyleBase.resetMemo();
                return true;
            }
            case 5: {
                pSViewStyleBase.resetNameMode();
                return true;
            }
            case 6: {
                pSViewStyleBase.resetPSDCId();
                return true;
            }
            case 7: {
                pSViewStyleBase.resetPSDCName();
                return true;
            }
            case 8: {
                pSViewStyleBase.resetPSPFPluginId();
                return true;
            }
            case 9: {
                pSViewStyleBase.resetPSPFPluginName();
                return true;
            }
            case 10: {
                pSViewStyleBase.resetPSViewStyleId();
                return true;
            }
            case 11: {
                pSViewStyleBase.resetPSViewStyleName();
                return true;
            }
            case 12: {
                pSViewStyleBase.resetTypeCode();
                return true;
            }
            case 13: {
                pSViewStyleBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSViewStyleBase.resetUpdateMan();
                return true;
            }
            case 15: {
                pSViewStyleBase.resetViewParams();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getPSDC() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDC();
        }
        if (this.getPSDCId() == null) {
            return null;
        }
        Integer n = this.objPSDCLock;
        synchronized (n) {
            if (this.psdc != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCId(), (Object)this.psdc.getPSDevCenterId()) != 0L) {
                this.psdc = null;
            }
            if (this.psdc == null) {
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(this.getPSDCId());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.psdc = pSDevCenter;
            }
            return this.psdc;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPFPlugin getPSPFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPlugin();
        }
        if (this.getPSPFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSPFPluginLock;
        synchronized (n) {
            if (this.pspfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFPluginId(), (Object)this.pspfplugin.getPSPFPluginId()) != 0L) {
                this.pspfplugin = null;
            }
            if (this.pspfplugin == null) {
                PSPFPlugin pSPFPlugin = new PSPFPlugin();
                pSPFPlugin.setPSPFPluginId(this.getPSPFPluginId());
                PSPFPluginService pSPFPluginService = (PSPFPluginService)ServiceGlobal.getService(PSPFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSPFPluginService.autoGet((IEntity)pSPFPlugin);
                this.pspfplugin = pSPFPlugin;
            }
            return this.pspfplugin;
        }
    }

    private PSViewStyleBase getProxyEntity() {
        return this.proxyPSViewStyleBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSViewStyleBase = null;
        if (iDataObject != null && iDataObject instanceof PSViewStyleBase) {
            this.proxyPSViewStyleBase = (PSViewStyleBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSViewStyleService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_EXTENDCTRL, 2);
        fieldIndexMap.put(FIELD_EXTENDVIEW, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_NAMEMODE, 5);
        fieldIndexMap.put(FIELD_PSDCID, 6);
        fieldIndexMap.put(FIELD_PSDCNAME, 7);
        fieldIndexMap.put(FIELD_PSPFPLUGINID, 8);
        fieldIndexMap.put(FIELD_PSPFPLUGINNAME, 9);
        fieldIndexMap.put(FIELD_PSVIEWSTYLEID, 10);
        fieldIndexMap.put(FIELD_PSVIEWSTYLENAME, 11);
        fieldIndexMap.put(FIELD_TYPECODE, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
        fieldIndexMap.put(FIELD_VIEWPARAMS, 15);
    }
}

