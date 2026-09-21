/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
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
package net.ibizsys.pscore.srv.appdesign.entity;

import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppPanelViewBase
extends PSAppView {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppPanelViewBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LAYOUTMODE = "LAYOUTMODE";
    public static final String FIELD_NAVBARPSSYSCSSID = "NAVBARPSSYSCSSID";
    public static final String FIELD_NAVBARPSSYSCSSNAME = "NAVBARPSSYSCSSNAME";
    public static final String FIELD_PANELMODEL = "PANELMODEL";
    public static final String FIELD_PANELSTYLE = "PANELSTYLE";
    public static final String FIELD_PANELWIDTH = "PANELWIDTH";
    public static final String FIELD_PSAPPPANELVIEWID = "PSAPPPANELVIEWID";
    public static final String FIELD_PSAPPPANELVIEWNAME = "PSAPPPANELVIEWNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 7;
    private static final int INDEX_CREATEMAN = 8;
    private static final int INDEX_LAYOUTMODE = 12;
    private static final int INDEX_NAVBARPSSYSCSSID = 16;
    private static final int INDEX_NAVBARPSSYSCSSNAME = 17;
    private static final int INDEX_PANELMODEL = 18;
    private static final int INDEX_PANELSTYLE = 19;
    private static final int INDEX_PANELWIDTH = 20;
    private static final int INDEX_PSAPPPANELVIEWID = 28;
    private static final int INDEX_PSAPPPANELVIEWNAME = 29;
    private static final int INDEX_UPDATEDATE = 84;
    private static final int INDEX_UPDATEMAN = 85;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppPanelViewBase proxyPSAppPanelViewBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean layoutmodeDirtyFlag = false;
    private boolean navbarpssyscssidDirtyFlag = false;
    private boolean navbarpssyscssnameDirtyFlag = false;
    private boolean panelmodelDirtyFlag = false;
    private boolean panelstyleDirtyFlag = false;
    private boolean panelwidthDirtyFlag = false;
    private boolean psapppanelviewidDirtyFlag = false;
    private boolean psapppanelviewnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="layoutmode")
    private String layoutmode;
    @Column(name="navbarpssyscssid")
    private String navbarpssyscssid;
    @Column(name="navbarpssyscssname")
    private String navbarpssyscssname;
    @Column(name="panelmodel")
    private String panelmodel;
    @Column(name="panelstyle")
    private String panelstyle;
    @Column(name="panelwidth")
    private Integer panelwidth;
    @Column(name="psapppanelviewid")
    private String psapppanelviewid;
    @Column(name="psapppanelviewname")
    private String psapppanelviewname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objNavBarPSSysCssLock = new Integer(1);
    private PSSysCss navbarpssyscss = null;

    public PSAppPanelViewBase() {
        try {
            this.set("PSAPPVIEWTYPE", "APPPANELVIEW");
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    public void setCreateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDate(timestamp);
            return;
        }
        this.createdate = timestamp;
        this.createdateDirtyFlag = true;
    }

    @Override
    public Timestamp getCreateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateDate();
        }
        return this.createdate;
    }

    @Override
    public boolean isCreateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateDateDirty();
        }
        return this.createdateDirtyFlag;
    }

    @Override
    public void resetCreateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateDate();
            return;
        }
        this.createdateDirtyFlag = false;
        this.createdate = null;
    }

    @Override
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

    @Override
    public String getCreateMan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateMan();
        }
        return this.createman;
    }

    @Override
    public boolean isCreateManDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateManDirty();
        }
        return this.createmanDirtyFlag;
    }

    @Override
    public void resetCreateMan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateMan();
            return;
        }
        this.createmanDirtyFlag = false;
        this.createman = null;
    }

    public void setLayoutMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLayoutMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.layoutmode = string;
        this.layoutmodeDirtyFlag = true;
    }

    public String getLayoutMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLayoutMode();
        }
        return this.layoutmode;
    }

    public boolean isLayoutModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLayoutModeDirty();
        }
        return this.layoutmodeDirtyFlag;
    }

    public void resetLayoutMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLayoutMode();
            return;
        }
        this.layoutmodeDirtyFlag = false;
        this.layoutmode = null;
    }

    public void setNavBarPSSysCssId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNavBarPSSysCssId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.navbarpssyscssid = string;
        this.navbarpssyscssidDirtyFlag = true;
    }

    public String getNavBarPSSysCssId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavBarPSSysCssId();
        }
        return this.navbarpssyscssid;
    }

    public boolean isNavBarPSSysCssIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNavBarPSSysCssIdDirty();
        }
        return this.navbarpssyscssidDirtyFlag;
    }

    public void resetNavBarPSSysCssId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNavBarPSSysCssId();
            return;
        }
        this.navbarpssyscssidDirtyFlag = false;
        this.navbarpssyscssid = null;
    }

    public void setNavBarPSSysCssName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNavBarPSSysCssName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.navbarpssyscssname = string;
        this.navbarpssyscssnameDirtyFlag = true;
    }

    public String getNavBarPSSysCssName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavBarPSSysCssName();
        }
        return this.navbarpssyscssname;
    }

    public boolean isNavBarPSSysCssNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNavBarPSSysCssNameDirty();
        }
        return this.navbarpssyscssnameDirtyFlag;
    }

    public void resetNavBarPSSysCssName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNavBarPSSysCssName();
            return;
        }
        this.navbarpssyscssnameDirtyFlag = false;
        this.navbarpssyscssname = null;
    }

    public void setPanelModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPanelModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.panelmodel = string;
        this.panelmodelDirtyFlag = true;
    }

    public String getPanelModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPanelModel();
        }
        return this.panelmodel;
    }

    public boolean isPanelModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPanelModelDirty();
        }
        return this.panelmodelDirtyFlag;
    }

    public void resetPanelModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPanelModel();
            return;
        }
        this.panelmodelDirtyFlag = false;
        this.panelmodel = null;
    }

    public void setPanelStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPanelStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.panelstyle = string;
        this.panelstyleDirtyFlag = true;
    }

    public String getPanelStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPanelStyle();
        }
        return this.panelstyle;
    }

    public boolean isPanelStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPanelStyleDirty();
        }
        return this.panelstyleDirtyFlag;
    }

    public void resetPanelStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPanelStyle();
            return;
        }
        this.panelstyleDirtyFlag = false;
        this.panelstyle = null;
    }

    public void setPanelWidth(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPanelWidth(n);
            return;
        }
        this.panelwidth = n;
        this.panelwidthDirtyFlag = true;
    }

    public Integer getPanelWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPanelWidth();
        }
        return this.panelwidth;
    }

    public boolean isPanelWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPanelWidthDirty();
        }
        return this.panelwidthDirtyFlag;
    }

    public void resetPanelWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPanelWidth();
            return;
        }
        this.panelwidthDirtyFlag = false;
        this.panelwidth = null;
    }

    public void setPSAppPanelViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppPanelViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapppanelviewid = string;
        this.psapppanelviewidDirtyFlag = true;
        super.setPSAppViewId(string);
    }

    public String getPSAppPanelViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppPanelViewId();
        }
        return this.psapppanelviewid;
    }

    public boolean isPSAppPanelViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppPanelViewIdDirty();
        }
        return this.psapppanelviewidDirtyFlag;
    }

    public void resetPSAppPanelViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppPanelViewId();
            return;
        }
        this.psapppanelviewidDirtyFlag = false;
        this.psapppanelviewid = null;
        super.resetPSAppViewId();
    }

    public void setPSAppPanelViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppPanelViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapppanelviewname = string;
        this.psapppanelviewnameDirtyFlag = true;
        super.setPSAppViewName(string);
    }

    public String getPSAppPanelViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppPanelViewName();
        }
        return this.psapppanelviewname;
    }

    public boolean isPSAppPanelViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppPanelViewNameDirty();
        }
        return this.psapppanelviewnameDirtyFlag;
    }

    public void resetPSAppPanelViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppPanelViewName();
            return;
        }
        this.psapppanelviewnameDirtyFlag = false;
        this.psapppanelviewname = null;
    }

    @Override
    public void setUpdateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDate(timestamp);
            return;
        }
        this.updatedate = timestamp;
        this.updatedateDirtyFlag = true;
    }

    @Override
    public Timestamp getUpdateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateDate();
        }
        return this.updatedate;
    }

    @Override
    public boolean isUpdateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateDateDirty();
        }
        return this.updatedateDirtyFlag;
    }

    @Override
    public void resetUpdateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateDate();
            return;
        }
        this.updatedateDirtyFlag = false;
        this.updatedate = null;
    }

    @Override
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

    @Override
    public String getUpdateMan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateMan();
        }
        return this.updateman;
    }

    @Override
    public boolean isUpdateManDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateManDirty();
        }
        return this.updatemanDirtyFlag;
    }

    @Override
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
        PSAppPanelViewBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppPanelViewBase pSAppPanelViewBase) {
        pSAppPanelViewBase.resetCreateDate();
        pSAppPanelViewBase.resetCreateMan();
        pSAppPanelViewBase.resetLayoutMode();
        pSAppPanelViewBase.resetNavBarPSSysCssId();
        pSAppPanelViewBase.resetNavBarPSSysCssName();
        pSAppPanelViewBase.resetPanelModel();
        pSAppPanelViewBase.resetPanelStyle();
        pSAppPanelViewBase.resetPanelWidth();
        pSAppPanelViewBase.resetPSAppPanelViewId();
        pSAppPanelViewBase.resetPSAppPanelViewName();
        pSAppPanelViewBase.resetUpdateDate();
        pSAppPanelViewBase.resetUpdateMan();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isLayoutModeDirty()) {
            hashMap.put(FIELD_LAYOUTMODE, this.getLayoutMode());
        }
        if (!bl || this.isNavBarPSSysCssIdDirty()) {
            hashMap.put(FIELD_NAVBARPSSYSCSSID, this.getNavBarPSSysCssId());
        }
        if (!bl || this.isNavBarPSSysCssNameDirty()) {
            hashMap.put(FIELD_NAVBARPSSYSCSSNAME, this.getNavBarPSSysCssName());
        }
        if (!bl || this.isPanelModelDirty()) {
            hashMap.put(FIELD_PANELMODEL, this.getPanelModel());
        }
        if (!bl || this.isPanelStyleDirty()) {
            hashMap.put(FIELD_PANELSTYLE, this.getPanelStyle());
        }
        if (!bl || this.isPanelWidthDirty()) {
            hashMap.put(FIELD_PANELWIDTH, this.getPanelWidth());
        }
        if (!bl || this.isPSAppPanelViewIdDirty()) {
            hashMap.put(FIELD_PSAPPPANELVIEWID, this.getPSAppPanelViewId());
        }
        if (!bl || this.isPSAppPanelViewNameDirty()) {
            hashMap.put(FIELD_PSAPPPANELVIEWNAME, this.getPSAppPanelViewName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        super.onFillMap(hashMap, bl);
    }

    @Override
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
        return PSAppPanelViewBase.get(this, n);
    }

    private static Object get(PSAppPanelViewBase pSAppPanelViewBase, int n) throws Exception {
        switch (n) {
            case 7: {
                return pSAppPanelViewBase.getCreateDate();
            }
            case 8: {
                return pSAppPanelViewBase.getCreateMan();
            }
            case 12: {
                return pSAppPanelViewBase.getLayoutMode();
            }
            case 16: {
                return pSAppPanelViewBase.getNavBarPSSysCssId();
            }
            case 17: {
                return pSAppPanelViewBase.getNavBarPSSysCssName();
            }
            case 18: {
                return pSAppPanelViewBase.getPanelModel();
            }
            case 19: {
                return pSAppPanelViewBase.getPanelStyle();
            }
            case 20: {
                return pSAppPanelViewBase.getPanelWidth();
            }
            case 28: {
                return pSAppPanelViewBase.getPSAppPanelViewId();
            }
            case 29: {
                return pSAppPanelViewBase.getPSAppPanelViewName();
            }
            case 84: {
                return pSAppPanelViewBase.getUpdateDate();
            }
            case 85: {
                return pSAppPanelViewBase.getUpdateMan();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
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
        PSAppPanelViewBase.set(this, n, object);
    }

    private static void set(PSAppPanelViewBase pSAppPanelViewBase, int n, Object object) throws Exception {
        switch (n) {
            case 7: {
                pSAppPanelViewBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSAppPanelViewBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSAppPanelViewBase.setLayoutMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSAppPanelViewBase.setNavBarPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSAppPanelViewBase.setNavBarPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSAppPanelViewBase.setPanelModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSAppPanelViewBase.setPanelStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSAppPanelViewBase.setPanelWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 28: {
                pSAppPanelViewBase.setPSAppPanelViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSAppPanelViewBase.setPSAppPanelViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 84: {
                pSAppPanelViewBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 85: {
                pSAppPanelViewBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
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
        return PSAppPanelViewBase.isNull(this, n);
    }

    private static boolean isNull(PSAppPanelViewBase pSAppPanelViewBase, int n) throws Exception {
        switch (n) {
            case 7: {
                return pSAppPanelViewBase.getCreateDate() == null;
            }
            case 8: {
                return pSAppPanelViewBase.getCreateMan() == null;
            }
            case 12: {
                return pSAppPanelViewBase.getLayoutMode() == null;
            }
            case 16: {
                return pSAppPanelViewBase.getNavBarPSSysCssId() == null;
            }
            case 17: {
                return pSAppPanelViewBase.getNavBarPSSysCssName() == null;
            }
            case 18: {
                return pSAppPanelViewBase.getPanelModel() == null;
            }
            case 19: {
                return pSAppPanelViewBase.getPanelStyle() == null;
            }
            case 20: {
                return pSAppPanelViewBase.getPanelWidth() == null;
            }
            case 28: {
                return pSAppPanelViewBase.getPSAppPanelViewId() == null;
            }
            case 29: {
                return pSAppPanelViewBase.getPSAppPanelViewName() == null;
            }
            case 84: {
                return pSAppPanelViewBase.getUpdateDate() == null;
            }
            case 85: {
                return pSAppPanelViewBase.getUpdateMan() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
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
        return PSAppPanelViewBase.contains(this, n);
    }

    private static boolean contains(PSAppPanelViewBase pSAppPanelViewBase, int n) throws Exception {
        switch (n) {
            case 7: {
                return pSAppPanelViewBase.isCreateDateDirty();
            }
            case 8: {
                return pSAppPanelViewBase.isCreateManDirty();
            }
            case 12: {
                return pSAppPanelViewBase.isLayoutModeDirty();
            }
            case 16: {
                return pSAppPanelViewBase.isNavBarPSSysCssIdDirty();
            }
            case 17: {
                return pSAppPanelViewBase.isNavBarPSSysCssNameDirty();
            }
            case 18: {
                return pSAppPanelViewBase.isPanelModelDirty();
            }
            case 19: {
                return pSAppPanelViewBase.isPanelStyleDirty();
            }
            case 20: {
                return pSAppPanelViewBase.isPanelWidthDirty();
            }
            case 28: {
                return pSAppPanelViewBase.isPSAppPanelViewIdDirty();
            }
            case 29: {
                return pSAppPanelViewBase.isPSAppPanelViewNameDirty();
            }
            case 84: {
                return pSAppPanelViewBase.isUpdateDateDirty();
            }
            case 85: {
                return pSAppPanelViewBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppPanelViewBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppPanelViewBase pSAppPanelViewBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppPanelViewBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppPanelViewBase.getJSONValue((Object)pSAppPanelViewBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppPanelViewBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppPanelViewBase.getJSONValue((Object)pSAppPanelViewBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppPanelViewBase.getLayoutMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"layoutmode", (Object)PSAppPanelViewBase.getJSONValue((Object)pSAppPanelViewBase.getLayoutMode()), (boolean)false);
        }
        if (bl || pSAppPanelViewBase.getNavBarPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navbarpssyscssid", (Object)PSAppPanelViewBase.getJSONValue((Object)pSAppPanelViewBase.getNavBarPSSysCssId()), (boolean)false);
        }
        if (bl || pSAppPanelViewBase.getNavBarPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navbarpssyscssname", (Object)PSAppPanelViewBase.getJSONValue((Object)pSAppPanelViewBase.getNavBarPSSysCssName()), (boolean)false);
        }
        if (bl || pSAppPanelViewBase.getPanelModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"panelmodel", (Object)PSAppPanelViewBase.getJSONValue((Object)pSAppPanelViewBase.getPanelModel()), (boolean)false);
        }
        if (bl || pSAppPanelViewBase.getPanelStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"panelstyle", (Object)PSAppPanelViewBase.getJSONValue((Object)pSAppPanelViewBase.getPanelStyle()), (boolean)false);
        }
        if (bl || pSAppPanelViewBase.getPanelWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"panelwidth", (Object)PSAppPanelViewBase.getJSONValue((Object)pSAppPanelViewBase.getPanelWidth()), (boolean)false);
        }
        if (bl || pSAppPanelViewBase.getPSAppPanelViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapppanelviewid", (Object)PSAppPanelViewBase.getJSONValue((Object)pSAppPanelViewBase.getPSAppPanelViewId()), (boolean)false);
        }
        if (bl || pSAppPanelViewBase.getPSAppPanelViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapppanelviewname", (Object)PSAppPanelViewBase.getJSONValue((Object)pSAppPanelViewBase.getPSAppPanelViewName()), (boolean)false);
        }
        if (bl || pSAppPanelViewBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppPanelViewBase.getJSONValue((Object)pSAppPanelViewBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppPanelViewBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppPanelViewBase.getJSONValue((Object)pSAppPanelViewBase.getUpdateMan()), (boolean)false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppPanelViewBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppPanelViewBase pSAppPanelViewBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppPanelViewBase.getCreateDate() != null) {
            object = pSAppPanelViewBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppPanelViewBase.getCreateMan() != null) {
            object = pSAppPanelViewBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppPanelViewBase.getLayoutMode() != null) {
            object = pSAppPanelViewBase.getLayoutMode();
            xmlNode.setAttribute(FIELD_LAYOUTMODE, object == null ? "" : (String)object);
        }
        if (bl || pSAppPanelViewBase.getNavBarPSSysCssId() != null) {
            object = pSAppPanelViewBase.getNavBarPSSysCssId();
            xmlNode.setAttribute(FIELD_NAVBARPSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSAppPanelViewBase.getNavBarPSSysCssName() != null) {
            object = pSAppPanelViewBase.getNavBarPSSysCssName();
            xmlNode.setAttribute(FIELD_NAVBARPSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppPanelViewBase.getPanelModel() != null) {
            object = pSAppPanelViewBase.getPanelModel();
            xmlNode.setAttribute(FIELD_PANELMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSAppPanelViewBase.getPanelStyle() != null) {
            object = pSAppPanelViewBase.getPanelStyle();
            xmlNode.setAttribute(FIELD_PANELSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSAppPanelViewBase.getPanelWidth() != null) {
            object = pSAppPanelViewBase.getPanelWidth();
            xmlNode.setAttribute(FIELD_PANELWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppPanelViewBase.getPSAppPanelViewId() != null) {
            object = pSAppPanelViewBase.getPSAppPanelViewId();
            xmlNode.setAttribute(FIELD_PSAPPPANELVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSAppPanelViewBase.getPSAppPanelViewName() != null) {
            object = pSAppPanelViewBase.getPSAppPanelViewName();
            xmlNode.setAttribute(FIELD_PSAPPPANELVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppPanelViewBase.getUpdateDate() != null) {
            object = pSAppPanelViewBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppPanelViewBase.getUpdateMan() != null) {
            object = pSAppPanelViewBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    @Override
    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppPanelViewBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppPanelViewBase pSAppPanelViewBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppPanelViewBase.isCreateDateDirty() && (bl || pSAppPanelViewBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppPanelViewBase.getCreateDate());
        }
        if (pSAppPanelViewBase.isCreateManDirty() && (bl || pSAppPanelViewBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppPanelViewBase.getCreateMan());
        }
        if (pSAppPanelViewBase.isLayoutModeDirty() && (bl || pSAppPanelViewBase.getLayoutMode() != null)) {
            iDataObject.set(FIELD_LAYOUTMODE, (Object)pSAppPanelViewBase.getLayoutMode());
        }
        if (pSAppPanelViewBase.isNavBarPSSysCssIdDirty() && (bl || pSAppPanelViewBase.getNavBarPSSysCssId() != null)) {
            iDataObject.set(FIELD_NAVBARPSSYSCSSID, (Object)pSAppPanelViewBase.getNavBarPSSysCssId());
        }
        if (pSAppPanelViewBase.isNavBarPSSysCssNameDirty() && (bl || pSAppPanelViewBase.getNavBarPSSysCssName() != null)) {
            iDataObject.set(FIELD_NAVBARPSSYSCSSNAME, (Object)pSAppPanelViewBase.getNavBarPSSysCssName());
        }
        if (pSAppPanelViewBase.isPanelModelDirty() && (bl || pSAppPanelViewBase.getPanelModel() != null)) {
            iDataObject.set(FIELD_PANELMODEL, (Object)pSAppPanelViewBase.getPanelModel());
        }
        if (pSAppPanelViewBase.isPanelStyleDirty() && (bl || pSAppPanelViewBase.getPanelStyle() != null)) {
            iDataObject.set(FIELD_PANELSTYLE, (Object)pSAppPanelViewBase.getPanelStyle());
        }
        if (pSAppPanelViewBase.isPanelWidthDirty() && (bl || pSAppPanelViewBase.getPanelWidth() != null)) {
            iDataObject.set(FIELD_PANELWIDTH, (Object)pSAppPanelViewBase.getPanelWidth());
        }
        if (pSAppPanelViewBase.isPSAppPanelViewIdDirty() && (bl || pSAppPanelViewBase.getPSAppPanelViewId() != null)) {
            iDataObject.set(FIELD_PSAPPPANELVIEWID, (Object)pSAppPanelViewBase.getPSAppPanelViewId());
        }
        if (pSAppPanelViewBase.isPSAppPanelViewNameDirty() && (bl || pSAppPanelViewBase.getPSAppPanelViewName() != null)) {
            iDataObject.set(FIELD_PSAPPPANELVIEWNAME, (Object)pSAppPanelViewBase.getPSAppPanelViewName());
        }
        if (pSAppPanelViewBase.isUpdateDateDirty() && (bl || pSAppPanelViewBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppPanelViewBase.getUpdateDate());
        }
        if (pSAppPanelViewBase.isUpdateManDirty() && (bl || pSAppPanelViewBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppPanelViewBase.getUpdateMan());
        }
    }

    @Override
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
        return PSAppPanelViewBase.remove(this, n);
    }

    private static boolean remove(PSAppPanelViewBase pSAppPanelViewBase, int n) throws Exception {
        switch (n) {
            case 7: {
                pSAppPanelViewBase.resetCreateDate();
                return true;
            }
            case 8: {
                pSAppPanelViewBase.resetCreateMan();
                return true;
            }
            case 12: {
                pSAppPanelViewBase.resetLayoutMode();
                return true;
            }
            case 16: {
                pSAppPanelViewBase.resetNavBarPSSysCssId();
                return true;
            }
            case 17: {
                pSAppPanelViewBase.resetNavBarPSSysCssName();
                return true;
            }
            case 18: {
                pSAppPanelViewBase.resetPanelModel();
                return true;
            }
            case 19: {
                pSAppPanelViewBase.resetPanelStyle();
                return true;
            }
            case 20: {
                pSAppPanelViewBase.resetPanelWidth();
                return true;
            }
            case 28: {
                pSAppPanelViewBase.resetPSAppPanelViewId();
                return true;
            }
            case 29: {
                pSAppPanelViewBase.resetPSAppPanelViewName();
                return true;
            }
            case 84: {
                pSAppPanelViewBase.resetUpdateDate();
                return true;
            }
            case 85: {
                pSAppPanelViewBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysCss getNavBarPSSysCss() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavBarPSSysCss();
        }
        if (this.getNavBarPSSysCssId() == null) {
            return null;
        }
        Integer n = this.objNavBarPSSysCssLock;
        synchronized (n) {
            if (this.navbarpssyscss != null && DataTypeHelper.compare((int)25, (Object)this.getNavBarPSSysCssId(), (Object)this.navbarpssyscss.getPSSysCssId()) != 0L) {
                this.navbarpssyscss = null;
            }
            if (this.navbarpssyscss == null) {
                PSSysCss pSSysCss = new PSSysCss();
                pSSysCss.setPSSysCssId(this.getNavBarPSSysCssId());
                PSSysCssService pSSysCssService = (PSSysCssService)ServiceGlobal.getService(PSSysCssService.class, (SessionFactory)this.getSessionFactory());
                pSSysCssService.autoGet((IEntity)pSSysCss);
                this.navbarpssyscss = pSSysCss;
            }
            return this.navbarpssyscss;
        }
    }

    private PSAppPanelViewBase getProxyEntity() {
        return this.proxyPSAppPanelViewBase;
    }

    @Override
    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppPanelViewBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppPanelViewBase) {
            this.proxyPSAppPanelViewBase = (PSAppPanelViewBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppPanelViewService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 7);
        fieldIndexMap.put(FIELD_CREATEMAN, 8);
        fieldIndexMap.put(FIELD_LAYOUTMODE, 12);
        fieldIndexMap.put(FIELD_NAVBARPSSYSCSSID, 16);
        fieldIndexMap.put(FIELD_NAVBARPSSYSCSSNAME, 17);
        fieldIndexMap.put(FIELD_PANELMODEL, 18);
        fieldIndexMap.put(FIELD_PANELSTYLE, 19);
        fieldIndexMap.put(FIELD_PANELWIDTH, 20);
        fieldIndexMap.put(FIELD_PSAPPPANELVIEWID, 28);
        fieldIndexMap.put(FIELD_PSAPPPANELVIEWNAME, 29);
        fieldIndexMap.put(FIELD_UPDATEDATE, 84);
        fieldIndexMap.put(FIELD_UPDATEMAN, 85);
    }
}

