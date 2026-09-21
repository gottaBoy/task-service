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

public abstract class PSDSPanelToolBoxBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDSPanelToolBoxBase.class);
    public static final String FIELD_CAT = "CAT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ICONCLS = "ICONCLS";
    public static final String FIELD_INITPARAMS = "INITPARAMS";
    public static final String FIELD_ITEMTYPE = "ITEMTYPE";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDSPANELTOOLBOXID = "PSDSPANELTOOLBOXID";
    public static final String FIELD_PSDSPANELTOOLBOXNAME = "PSDSPANELTOOLBOXNAME";
    public static final String FIELD_TOOLBOXTYPE = "TOOLBOXTYPE";
    public static final String FIELD_TOOLTIP = "TOOLTIP";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CAT = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_ICONCLS = 3;
    private static final int INDEX_INITPARAMS = 4;
    private static final int INDEX_ITEMTYPE = 5;
    private static final int INDEX_ORDERVALUE = 6;
    private static final int INDEX_PSDSPANELTOOLBOXID = 7;
    private static final int INDEX_PSDSPANELTOOLBOXNAME = 8;
    private static final int INDEX_TOOLBOXTYPE = 9;
    private static final int INDEX_TOOLTIP = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_USERTAG = 13;
    private static final int INDEX_USERTAG2 = 14;
    private static final int INDEX_VALIDFLAG = 15;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDSPanelToolBoxBase proxyPSDSPanelToolBoxBase = null;
    private boolean catDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean iconclsDirtyFlag = false;
    private boolean initparamsDirtyFlag = false;
    private boolean itemtypeDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdspaneltoolboxidDirtyFlag = false;
    private boolean psdspaneltoolboxnameDirtyFlag = false;
    private boolean toolboxtypeDirtyFlag = false;
    private boolean tooltipDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="cat")
    private String cat;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="iconcls")
    private String iconcls;
    @Column(name="initparams")
    private String initparams;
    @Column(name="itemtype")
    private String itemtype;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdspaneltoolboxid")
    private String psdspaneltoolboxid;
    @Column(name="psdspaneltoolboxname")
    private String psdspaneltoolboxname;
    @Column(name="toolboxtype")
    private String toolboxtype;
    @Column(name="tooltip")
    private String tooltip;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="validflag")
    private Integer validflag;

    public void setCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cat = string;
        this.catDirtyFlag = true;
    }

    public String getCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCat();
        }
        return this.cat;
    }

    public boolean isCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCatDirty();
        }
        return this.catDirtyFlag;
    }

    public void resetCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCat();
            return;
        }
        this.catDirtyFlag = false;
        this.cat = null;
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

    public void setIconCls(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIconCls(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.iconcls = string;
        this.iconclsDirtyFlag = true;
    }

    public String getIconCls() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIconCls();
        }
        return this.iconcls;
    }

    public boolean isIconClsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIconClsDirty();
        }
        return this.iconclsDirtyFlag;
    }

    public void resetIconCls() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIconCls();
            return;
        }
        this.iconclsDirtyFlag = false;
        this.iconcls = null;
    }

    public void setInitParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInitParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.initparams = string;
        this.initparamsDirtyFlag = true;
    }

    public String getInitParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInitParams();
        }
        return this.initparams;
    }

    public boolean isInitParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInitParamsDirty();
        }
        return this.initparamsDirtyFlag;
    }

    public void resetInitParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInitParams();
            return;
        }
        this.initparamsDirtyFlag = false;
        this.initparams = null;
    }

    public void setItemType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemtype = string;
        this.itemtypeDirtyFlag = true;
    }

    public String getItemType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemType();
        }
        return this.itemtype;
    }

    public boolean isItemTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemTypeDirty();
        }
        return this.itemtypeDirtyFlag;
    }

    public void resetItemType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemType();
            return;
        }
        this.itemtypeDirtyFlag = false;
        this.itemtype = null;
    }

    public void setOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValue(n);
            return;
        }
        this.ordervalue = n;
        this.ordervalueDirtyFlag = true;
    }

    public Integer getOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValue();
        }
        return this.ordervalue;
    }

    public boolean isOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValueDirty();
        }
        return this.ordervalueDirtyFlag;
    }

    public void resetOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValue();
            return;
        }
        this.ordervalueDirtyFlag = false;
        this.ordervalue = null;
    }

    public void setPSDSPanelToolBoxId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDSPanelToolBoxId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdspaneltoolboxid = string;
        this.psdspaneltoolboxidDirtyFlag = true;
    }

    public String getPSDSPanelToolBoxId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDSPanelToolBoxId();
        }
        return this.psdspaneltoolboxid;
    }

    public boolean isPSDSPanelToolBoxIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDSPanelToolBoxIdDirty();
        }
        return this.psdspaneltoolboxidDirtyFlag;
    }

    public void resetPSDSPanelToolBoxId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDSPanelToolBoxId();
            return;
        }
        this.psdspaneltoolboxidDirtyFlag = false;
        this.psdspaneltoolboxid = null;
    }

    public void setPSDSPanelToolBoxName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDSPanelToolBoxName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdspaneltoolboxname = string;
        this.psdspaneltoolboxnameDirtyFlag = true;
    }

    public String getPSDSPanelToolBoxName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDSPanelToolBoxName();
        }
        return this.psdspaneltoolboxname;
    }

    public boolean isPSDSPanelToolBoxNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDSPanelToolBoxNameDirty();
        }
        return this.psdspaneltoolboxnameDirtyFlag;
    }

    public void resetPSDSPanelToolBoxName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDSPanelToolBoxName();
            return;
        }
        this.psdspaneltoolboxnameDirtyFlag = false;
        this.psdspaneltoolboxname = null;
    }

    public void setToolBoxType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setToolBoxType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.toolboxtype = string;
        this.toolboxtypeDirtyFlag = true;
    }

    public String getToolBoxType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getToolBoxType();
        }
        return this.toolboxtype;
    }

    public boolean isToolBoxTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isToolBoxTypeDirty();
        }
        return this.toolboxtypeDirtyFlag;
    }

    public void resetToolBoxType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetToolBoxType();
            return;
        }
        this.toolboxtypeDirtyFlag = false;
        this.toolboxtype = null;
    }

    public void setToolTip(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setToolTip(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tooltip = string;
        this.tooltipDirtyFlag = true;
    }

    public String getToolTip() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getToolTip();
        }
        return this.tooltip;
    }

    public boolean isToolTipDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isToolTipDirty();
        }
        return this.tooltipDirtyFlag;
    }

    public void resetToolTip() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetToolTip();
            return;
        }
        this.tooltipDirtyFlag = false;
        this.tooltip = null;
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

    public void setUserTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag = string;
        this.usertagDirtyFlag = true;
    }

    public String getUserTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag();
        }
        return this.usertag;
    }

    public boolean isUserTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTagDirty();
        }
        return this.usertagDirtyFlag;
    }

    public void resetUserTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag();
            return;
        }
        this.usertagDirtyFlag = false;
        this.usertag = null;
    }

    public void setUserTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag2 = string;
        this.usertag2DirtyFlag = true;
    }

    public String getUserTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag2();
        }
        return this.usertag2;
    }

    public boolean isUserTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag2Dirty();
        }
        return this.usertag2DirtyFlag;
    }

    public void resetUserTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag2();
            return;
        }
        this.usertag2DirtyFlag = false;
        this.usertag2 = null;
    }

    public void setValidFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValidFlag(n);
            return;
        }
        this.validflag = n;
        this.validflagDirtyFlag = true;
    }

    public Integer getValidFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValidFlag();
        }
        return this.validflag;
    }

    public boolean isValidFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValidFlagDirty();
        }
        return this.validflagDirtyFlag;
    }

    public void resetValidFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValidFlag();
            return;
        }
        this.validflagDirtyFlag = false;
        this.validflag = null;
    }

    protected void onReset() {
        PSDSPanelToolBoxBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDSPanelToolBoxBase pSDSPanelToolBoxBase) {
        pSDSPanelToolBoxBase.resetCat();
        pSDSPanelToolBoxBase.resetCreateDate();
        pSDSPanelToolBoxBase.resetCreateMan();
        pSDSPanelToolBoxBase.resetIconCls();
        pSDSPanelToolBoxBase.resetInitParams();
        pSDSPanelToolBoxBase.resetItemType();
        pSDSPanelToolBoxBase.resetOrderValue();
        pSDSPanelToolBoxBase.resetPSDSPanelToolBoxId();
        pSDSPanelToolBoxBase.resetPSDSPanelToolBoxName();
        pSDSPanelToolBoxBase.resetToolBoxType();
        pSDSPanelToolBoxBase.resetToolTip();
        pSDSPanelToolBoxBase.resetUpdateDate();
        pSDSPanelToolBoxBase.resetUpdateMan();
        pSDSPanelToolBoxBase.resetUserTag();
        pSDSPanelToolBoxBase.resetUserTag2();
        pSDSPanelToolBoxBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCatDirty()) {
            hashMap.put(FIELD_CAT, this.getCat());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isIconClsDirty()) {
            hashMap.put(FIELD_ICONCLS, this.getIconCls());
        }
        if (!bl || this.isInitParamsDirty()) {
            hashMap.put(FIELD_INITPARAMS, this.getInitParams());
        }
        if (!bl || this.isItemTypeDirty()) {
            hashMap.put(FIELD_ITEMTYPE, this.getItemType());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDSPanelToolBoxIdDirty()) {
            hashMap.put(FIELD_PSDSPANELTOOLBOXID, this.getPSDSPanelToolBoxId());
        }
        if (!bl || this.isPSDSPanelToolBoxNameDirty()) {
            hashMap.put(FIELD_PSDSPANELTOOLBOXNAME, this.getPSDSPanelToolBoxName());
        }
        if (!bl || this.isToolBoxTypeDirty()) {
            hashMap.put(FIELD_TOOLBOXTYPE, this.getToolBoxType());
        }
        if (!bl || this.isToolTipDirty()) {
            hashMap.put(FIELD_TOOLTIP, this.getToolTip());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
        }
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
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
        return PSDSPanelToolBoxBase.get(this, n);
    }

    private static Object get(PSDSPanelToolBoxBase pSDSPanelToolBoxBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDSPanelToolBoxBase.getCat();
            }
            case 1: {
                return pSDSPanelToolBoxBase.getCreateDate();
            }
            case 2: {
                return pSDSPanelToolBoxBase.getCreateMan();
            }
            case 3: {
                return pSDSPanelToolBoxBase.getIconCls();
            }
            case 4: {
                return pSDSPanelToolBoxBase.getInitParams();
            }
            case 5: {
                return pSDSPanelToolBoxBase.getItemType();
            }
            case 6: {
                return pSDSPanelToolBoxBase.getOrderValue();
            }
            case 7: {
                return pSDSPanelToolBoxBase.getPSDSPanelToolBoxId();
            }
            case 8: {
                return pSDSPanelToolBoxBase.getPSDSPanelToolBoxName();
            }
            case 9: {
                return pSDSPanelToolBoxBase.getToolBoxType();
            }
            case 10: {
                return pSDSPanelToolBoxBase.getToolTip();
            }
            case 11: {
                return pSDSPanelToolBoxBase.getUpdateDate();
            }
            case 12: {
                return pSDSPanelToolBoxBase.getUpdateMan();
            }
            case 13: {
                return pSDSPanelToolBoxBase.getUserTag();
            }
            case 14: {
                return pSDSPanelToolBoxBase.getUserTag2();
            }
            case 15: {
                return pSDSPanelToolBoxBase.getValidFlag();
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
        PSDSPanelToolBoxBase.set(this, n, object);
    }

    private static void set(PSDSPanelToolBoxBase pSDSPanelToolBoxBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDSPanelToolBoxBase.setCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDSPanelToolBoxBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDSPanelToolBoxBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDSPanelToolBoxBase.setIconCls(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDSPanelToolBoxBase.setInitParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDSPanelToolBoxBase.setItemType(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDSPanelToolBoxBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDSPanelToolBoxBase.setPSDSPanelToolBoxId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDSPanelToolBoxBase.setPSDSPanelToolBoxName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDSPanelToolBoxBase.setToolBoxType(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDSPanelToolBoxBase.setToolTip(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDSPanelToolBoxBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSDSPanelToolBoxBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDSPanelToolBoxBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDSPanelToolBoxBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDSPanelToolBoxBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDSPanelToolBoxBase.isNull(this, n);
    }

    private static boolean isNull(PSDSPanelToolBoxBase pSDSPanelToolBoxBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDSPanelToolBoxBase.getCat() == null;
            }
            case 1: {
                return pSDSPanelToolBoxBase.getCreateDate() == null;
            }
            case 2: {
                return pSDSPanelToolBoxBase.getCreateMan() == null;
            }
            case 3: {
                return pSDSPanelToolBoxBase.getIconCls() == null;
            }
            case 4: {
                return pSDSPanelToolBoxBase.getInitParams() == null;
            }
            case 5: {
                return pSDSPanelToolBoxBase.getItemType() == null;
            }
            case 6: {
                return pSDSPanelToolBoxBase.getOrderValue() == null;
            }
            case 7: {
                return pSDSPanelToolBoxBase.getPSDSPanelToolBoxId() == null;
            }
            case 8: {
                return pSDSPanelToolBoxBase.getPSDSPanelToolBoxName() == null;
            }
            case 9: {
                return pSDSPanelToolBoxBase.getToolBoxType() == null;
            }
            case 10: {
                return pSDSPanelToolBoxBase.getToolTip() == null;
            }
            case 11: {
                return pSDSPanelToolBoxBase.getUpdateDate() == null;
            }
            case 12: {
                return pSDSPanelToolBoxBase.getUpdateMan() == null;
            }
            case 13: {
                return pSDSPanelToolBoxBase.getUserTag() == null;
            }
            case 14: {
                return pSDSPanelToolBoxBase.getUserTag2() == null;
            }
            case 15: {
                return pSDSPanelToolBoxBase.getValidFlag() == null;
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
        return PSDSPanelToolBoxBase.contains(this, n);
    }

    private static boolean contains(PSDSPanelToolBoxBase pSDSPanelToolBoxBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDSPanelToolBoxBase.isCatDirty();
            }
            case 1: {
                return pSDSPanelToolBoxBase.isCreateDateDirty();
            }
            case 2: {
                return pSDSPanelToolBoxBase.isCreateManDirty();
            }
            case 3: {
                return pSDSPanelToolBoxBase.isIconClsDirty();
            }
            case 4: {
                return pSDSPanelToolBoxBase.isInitParamsDirty();
            }
            case 5: {
                return pSDSPanelToolBoxBase.isItemTypeDirty();
            }
            case 6: {
                return pSDSPanelToolBoxBase.isOrderValueDirty();
            }
            case 7: {
                return pSDSPanelToolBoxBase.isPSDSPanelToolBoxIdDirty();
            }
            case 8: {
                return pSDSPanelToolBoxBase.isPSDSPanelToolBoxNameDirty();
            }
            case 9: {
                return pSDSPanelToolBoxBase.isToolBoxTypeDirty();
            }
            case 10: {
                return pSDSPanelToolBoxBase.isToolTipDirty();
            }
            case 11: {
                return pSDSPanelToolBoxBase.isUpdateDateDirty();
            }
            case 12: {
                return pSDSPanelToolBoxBase.isUpdateManDirty();
            }
            case 13: {
                return pSDSPanelToolBoxBase.isUserTagDirty();
            }
            case 14: {
                return pSDSPanelToolBoxBase.isUserTag2Dirty();
            }
            case 15: {
                return pSDSPanelToolBoxBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDSPanelToolBoxBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDSPanelToolBoxBase pSDSPanelToolBoxBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDSPanelToolBoxBase.getCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cat", (Object)PSDSPanelToolBoxBase.getJSONValue((Object)pSDSPanelToolBoxBase.getCat()), (boolean)false);
        }
        if (bl || pSDSPanelToolBoxBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDSPanelToolBoxBase.getJSONValue((Object)pSDSPanelToolBoxBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDSPanelToolBoxBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDSPanelToolBoxBase.getJSONValue((Object)pSDSPanelToolBoxBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDSPanelToolBoxBase.getIconCls() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconcls", (Object)PSDSPanelToolBoxBase.getJSONValue((Object)pSDSPanelToolBoxBase.getIconCls()), (boolean)false);
        }
        if (bl || pSDSPanelToolBoxBase.getInitParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"initparams", (Object)PSDSPanelToolBoxBase.getJSONValue((Object)pSDSPanelToolBoxBase.getInitParams()), (boolean)false);
        }
        if (bl || pSDSPanelToolBoxBase.getItemType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemtype", (Object)PSDSPanelToolBoxBase.getJSONValue((Object)pSDSPanelToolBoxBase.getItemType()), (boolean)false);
        }
        if (bl || pSDSPanelToolBoxBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDSPanelToolBoxBase.getJSONValue((Object)pSDSPanelToolBoxBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDSPanelToolBoxBase.getPSDSPanelToolBoxId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdspaneltoolboxid", (Object)PSDSPanelToolBoxBase.getJSONValue((Object)pSDSPanelToolBoxBase.getPSDSPanelToolBoxId()), (boolean)false);
        }
        if (bl || pSDSPanelToolBoxBase.getPSDSPanelToolBoxName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdspaneltoolboxname", (Object)PSDSPanelToolBoxBase.getJSONValue((Object)pSDSPanelToolBoxBase.getPSDSPanelToolBoxName()), (boolean)false);
        }
        if (bl || pSDSPanelToolBoxBase.getToolBoxType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"toolboxtype", (Object)PSDSPanelToolBoxBase.getJSONValue((Object)pSDSPanelToolBoxBase.getToolBoxType()), (boolean)false);
        }
        if (bl || pSDSPanelToolBoxBase.getToolTip() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tooltip", (Object)PSDSPanelToolBoxBase.getJSONValue((Object)pSDSPanelToolBoxBase.getToolTip()), (boolean)false);
        }
        if (bl || pSDSPanelToolBoxBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDSPanelToolBoxBase.getJSONValue((Object)pSDSPanelToolBoxBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDSPanelToolBoxBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDSPanelToolBoxBase.getJSONValue((Object)pSDSPanelToolBoxBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDSPanelToolBoxBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDSPanelToolBoxBase.getJSONValue((Object)pSDSPanelToolBoxBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDSPanelToolBoxBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDSPanelToolBoxBase.getJSONValue((Object)pSDSPanelToolBoxBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDSPanelToolBoxBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDSPanelToolBoxBase.getJSONValue((Object)pSDSPanelToolBoxBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDSPanelToolBoxBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDSPanelToolBoxBase pSDSPanelToolBoxBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDSPanelToolBoxBase.getCat() != null) {
            object = pSDSPanelToolBoxBase.getCat();
            xmlNode.setAttribute(FIELD_CAT, object == null ? "" : (String)object);
        }
        if (bl || pSDSPanelToolBoxBase.getCreateDate() != null) {
            object = pSDSPanelToolBoxBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDSPanelToolBoxBase.getCreateMan() != null) {
            object = pSDSPanelToolBoxBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDSPanelToolBoxBase.getIconCls() != null) {
            object = pSDSPanelToolBoxBase.getIconCls();
            xmlNode.setAttribute(FIELD_ICONCLS, object == null ? "" : (String)object);
        }
        if (bl || pSDSPanelToolBoxBase.getInitParams() != null) {
            object = pSDSPanelToolBoxBase.getInitParams();
            xmlNode.setAttribute(FIELD_INITPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDSPanelToolBoxBase.getItemType() != null) {
            object = pSDSPanelToolBoxBase.getItemType();
            xmlNode.setAttribute(FIELD_ITEMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDSPanelToolBoxBase.getOrderValue() != null) {
            object = pSDSPanelToolBoxBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDSPanelToolBoxBase.getPSDSPanelToolBoxId() != null) {
            object = pSDSPanelToolBoxBase.getPSDSPanelToolBoxId();
            xmlNode.setAttribute(FIELD_PSDSPANELTOOLBOXID, object == null ? "" : (String)object);
        }
        if (bl || pSDSPanelToolBoxBase.getPSDSPanelToolBoxName() != null) {
            object = pSDSPanelToolBoxBase.getPSDSPanelToolBoxName();
            xmlNode.setAttribute(FIELD_PSDSPANELTOOLBOXNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDSPanelToolBoxBase.getToolBoxType() != null) {
            object = pSDSPanelToolBoxBase.getToolBoxType();
            xmlNode.setAttribute(FIELD_TOOLBOXTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDSPanelToolBoxBase.getToolTip() != null) {
            object = pSDSPanelToolBoxBase.getToolTip();
            xmlNode.setAttribute(FIELD_TOOLTIP, object == null ? "" : (String)object);
        }
        if (bl || pSDSPanelToolBoxBase.getUpdateDate() != null) {
            object = pSDSPanelToolBoxBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDSPanelToolBoxBase.getUpdateMan() != null) {
            object = pSDSPanelToolBoxBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDSPanelToolBoxBase.getUserTag() != null) {
            object = pSDSPanelToolBoxBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDSPanelToolBoxBase.getUserTag2() != null) {
            object = pSDSPanelToolBoxBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDSPanelToolBoxBase.getValidFlag() != null) {
            object = pSDSPanelToolBoxBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDSPanelToolBoxBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDSPanelToolBoxBase pSDSPanelToolBoxBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDSPanelToolBoxBase.isCatDirty() && (bl || pSDSPanelToolBoxBase.getCat() != null)) {
            iDataObject.set(FIELD_CAT, (Object)pSDSPanelToolBoxBase.getCat());
        }
        if (pSDSPanelToolBoxBase.isCreateDateDirty() && (bl || pSDSPanelToolBoxBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDSPanelToolBoxBase.getCreateDate());
        }
        if (pSDSPanelToolBoxBase.isCreateManDirty() && (bl || pSDSPanelToolBoxBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDSPanelToolBoxBase.getCreateMan());
        }
        if (pSDSPanelToolBoxBase.isIconClsDirty() && (bl || pSDSPanelToolBoxBase.getIconCls() != null)) {
            iDataObject.set(FIELD_ICONCLS, (Object)pSDSPanelToolBoxBase.getIconCls());
        }
        if (pSDSPanelToolBoxBase.isInitParamsDirty() && (bl || pSDSPanelToolBoxBase.getInitParams() != null)) {
            iDataObject.set(FIELD_INITPARAMS, (Object)pSDSPanelToolBoxBase.getInitParams());
        }
        if (pSDSPanelToolBoxBase.isItemTypeDirty() && (bl || pSDSPanelToolBoxBase.getItemType() != null)) {
            iDataObject.set(FIELD_ITEMTYPE, (Object)pSDSPanelToolBoxBase.getItemType());
        }
        if (pSDSPanelToolBoxBase.isOrderValueDirty() && (bl || pSDSPanelToolBoxBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDSPanelToolBoxBase.getOrderValue());
        }
        if (pSDSPanelToolBoxBase.isPSDSPanelToolBoxIdDirty() && (bl || pSDSPanelToolBoxBase.getPSDSPanelToolBoxId() != null)) {
            iDataObject.set(FIELD_PSDSPANELTOOLBOXID, (Object)pSDSPanelToolBoxBase.getPSDSPanelToolBoxId());
        }
        if (pSDSPanelToolBoxBase.isPSDSPanelToolBoxNameDirty() && (bl || pSDSPanelToolBoxBase.getPSDSPanelToolBoxName() != null)) {
            iDataObject.set(FIELD_PSDSPANELTOOLBOXNAME, (Object)pSDSPanelToolBoxBase.getPSDSPanelToolBoxName());
        }
        if (pSDSPanelToolBoxBase.isToolBoxTypeDirty() && (bl || pSDSPanelToolBoxBase.getToolBoxType() != null)) {
            iDataObject.set(FIELD_TOOLBOXTYPE, (Object)pSDSPanelToolBoxBase.getToolBoxType());
        }
        if (pSDSPanelToolBoxBase.isToolTipDirty() && (bl || pSDSPanelToolBoxBase.getToolTip() != null)) {
            iDataObject.set(FIELD_TOOLTIP, (Object)pSDSPanelToolBoxBase.getToolTip());
        }
        if (pSDSPanelToolBoxBase.isUpdateDateDirty() && (bl || pSDSPanelToolBoxBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDSPanelToolBoxBase.getUpdateDate());
        }
        if (pSDSPanelToolBoxBase.isUpdateManDirty() && (bl || pSDSPanelToolBoxBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDSPanelToolBoxBase.getUpdateMan());
        }
        if (pSDSPanelToolBoxBase.isUserTagDirty() && (bl || pSDSPanelToolBoxBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDSPanelToolBoxBase.getUserTag());
        }
        if (pSDSPanelToolBoxBase.isUserTag2Dirty() && (bl || pSDSPanelToolBoxBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDSPanelToolBoxBase.getUserTag2());
        }
        if (pSDSPanelToolBoxBase.isValidFlagDirty() && (bl || pSDSPanelToolBoxBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDSPanelToolBoxBase.getValidFlag());
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
        return PSDSPanelToolBoxBase.remove(this, n);
    }

    private static boolean remove(PSDSPanelToolBoxBase pSDSPanelToolBoxBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDSPanelToolBoxBase.resetCat();
                return true;
            }
            case 1: {
                pSDSPanelToolBoxBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDSPanelToolBoxBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDSPanelToolBoxBase.resetIconCls();
                return true;
            }
            case 4: {
                pSDSPanelToolBoxBase.resetInitParams();
                return true;
            }
            case 5: {
                pSDSPanelToolBoxBase.resetItemType();
                return true;
            }
            case 6: {
                pSDSPanelToolBoxBase.resetOrderValue();
                return true;
            }
            case 7: {
                pSDSPanelToolBoxBase.resetPSDSPanelToolBoxId();
                return true;
            }
            case 8: {
                pSDSPanelToolBoxBase.resetPSDSPanelToolBoxName();
                return true;
            }
            case 9: {
                pSDSPanelToolBoxBase.resetToolBoxType();
                return true;
            }
            case 10: {
                pSDSPanelToolBoxBase.resetToolTip();
                return true;
            }
            case 11: {
                pSDSPanelToolBoxBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSDSPanelToolBoxBase.resetUpdateMan();
                return true;
            }
            case 13: {
                pSDSPanelToolBoxBase.resetUserTag();
                return true;
            }
            case 14: {
                pSDSPanelToolBoxBase.resetUserTag2();
                return true;
            }
            case 15: {
                pSDSPanelToolBoxBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDSPanelToolBoxBase getProxyEntity() {
        return this.proxyPSDSPanelToolBoxBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDSPanelToolBoxBase = null;
        if (iDataObject != null && iDataObject instanceof PSDSPanelToolBoxBase) {
            this.proxyPSDSPanelToolBoxBase = (PSDSPanelToolBoxBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSDSPanelToolBoxService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CAT, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_ICONCLS, 3);
        fieldIndexMap.put(FIELD_INITPARAMS, 4);
        fieldIndexMap.put(FIELD_ITEMTYPE, 5);
        fieldIndexMap.put(FIELD_ORDERVALUE, 6);
        fieldIndexMap.put(FIELD_PSDSPANELTOOLBOXID, 7);
        fieldIndexMap.put(FIELD_PSDSPANELTOOLBOXNAME, 8);
        fieldIndexMap.put(FIELD_TOOLBOXTYPE, 9);
        fieldIndexMap.put(FIELD_TOOLTIP, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
        fieldIndexMap.put(FIELD_USERTAG, 13);
        fieldIndexMap.put(FIELD_USERTAG2, 14);
        fieldIndexMap.put(FIELD_VALIDFLAG, 15);
    }
}

