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
package net.ibizsys.pscore.srv.sysdevstudio.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSStudioThemeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSStudioThemeBase.class);
    public static final String FIELD_ALLDCFLAG = "ALLDCFLAG";
    public static final String FIELD_CARDCSSSTYLE = "CARDCSSSTYLE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSSTUDIOTHEMEID = "PSSTUDIOTHEMEID";
    public static final String FIELD_PSSTUDIOTHEMENAME = "PSSTUDIOTHEMENAME";
    public static final String FIELD_THEMECODE = "THEMECODE";
    public static final String FIELD_THEMEDATA = "THEMEDATA";
    public static final String FIELD_THEMEDATA2 = "THEMEDATA2";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ALLDCFLAG = 0;
    private static final int INDEX_CARDCSSSTYLE = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSDEVCENTERID = 5;
    private static final int INDEX_PSDEVCENTERNAME = 6;
    private static final int INDEX_PSSTUDIOTHEMEID = 7;
    private static final int INDEX_PSSTUDIOTHEMENAME = 8;
    private static final int INDEX_THEMECODE = 9;
    private static final int INDEX_THEMEDATA = 10;
    private static final int INDEX_THEMEDATA2 = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final int INDEX_VALIDFLAG = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSStudioThemeBase proxyPSStudioThemeBase = null;
    private boolean alldcflagDirtyFlag = false;
    private boolean cardcssstyleDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psstudiothemeidDirtyFlag = false;
    private boolean psstudiothemenameDirtyFlag = false;
    private boolean themecodeDirtyFlag = false;
    private boolean themedataDirtyFlag = false;
    private boolean themedata2DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="alldcflag")
    private Integer alldcflag;
    @Column(name="cardcssstyle")
    private String cardcssstyle;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psstudiothemeid")
    private String psstudiothemeid;
    @Column(name="psstudiothemename")
    private String psstudiothemename;
    @Column(name="themecode")
    private String themecode;
    @Column(name="themedata")
    private String themedata;
    @Column(name="themedata2")
    private String themedata2;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;

    public void setAllDCFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAllDCFlag(n);
            return;
        }
        this.alldcflag = n;
        this.alldcflagDirtyFlag = true;
    }

    public Integer getAllDCFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAllDCFlag();
        }
        return this.alldcflag;
    }

    public boolean isAllDCFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAllDCFlagDirty();
        }
        return this.alldcflagDirtyFlag;
    }

    public void resetAllDCFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAllDCFlag();
            return;
        }
        this.alldcflagDirtyFlag = false;
        this.alldcflag = null;
    }

    public void setCardCssStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCardCssStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cardcssstyle = string;
        this.cardcssstyleDirtyFlag = true;
    }

    public String getCardCssStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCardCssStyle();
        }
        return this.cardcssstyle;
    }

    public boolean isCardCssStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCardCssStyleDirty();
        }
        return this.cardcssstyleDirtyFlag;
    }

    public void resetCardCssStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCardCssStyle();
            return;
        }
        this.cardcssstyleDirtyFlag = false;
        this.cardcssstyle = null;
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

    public void setPSStudioThemeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSStudioThemeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psstudiothemeid = string;
        this.psstudiothemeidDirtyFlag = true;
    }

    public String getPSStudioThemeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSStudioThemeId();
        }
        return this.psstudiothemeid;
    }

    public boolean isPSStudioThemeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSStudioThemeIdDirty();
        }
        return this.psstudiothemeidDirtyFlag;
    }

    public void resetPSStudioThemeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSStudioThemeId();
            return;
        }
        this.psstudiothemeidDirtyFlag = false;
        this.psstudiothemeid = null;
    }

    public void setPSStudioThemeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSStudioThemeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psstudiothemename = string;
        this.psstudiothemenameDirtyFlag = true;
    }

    public String getPSStudioThemeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSStudioThemeName();
        }
        return this.psstudiothemename;
    }

    public boolean isPSStudioThemeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSStudioThemeNameDirty();
        }
        return this.psstudiothemenameDirtyFlag;
    }

    public void resetPSStudioThemeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSStudioThemeName();
            return;
        }
        this.psstudiothemenameDirtyFlag = false;
        this.psstudiothemename = null;
    }

    public void setThemeCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setThemeCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.themecode = string;
        this.themecodeDirtyFlag = true;
    }

    public String getThemeCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getThemeCode();
        }
        return this.themecode;
    }

    public boolean isThemeCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isThemeCodeDirty();
        }
        return this.themecodeDirtyFlag;
    }

    public void resetThemeCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetThemeCode();
            return;
        }
        this.themecodeDirtyFlag = false;
        this.themecode = null;
    }

    public void setThemeData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setThemeData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.themedata = string;
        this.themedataDirtyFlag = true;
    }

    public String getThemeData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getThemeData();
        }
        return this.themedata;
    }

    public boolean isThemeDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isThemeDataDirty();
        }
        return this.themedataDirtyFlag;
    }

    public void resetThemeData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetThemeData();
            return;
        }
        this.themedataDirtyFlag = false;
        this.themedata = null;
    }

    public void setThemeData2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setThemeData2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.themedata2 = string;
        this.themedata2DirtyFlag = true;
    }

    public String getThemeData2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getThemeData2();
        }
        return this.themedata2;
    }

    public boolean isThemeData2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isThemeData2Dirty();
        }
        return this.themedata2DirtyFlag;
    }

    public void resetThemeData2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetThemeData2();
            return;
        }
        this.themedata2DirtyFlag = false;
        this.themedata2 = null;
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
        PSStudioThemeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSStudioThemeBase pSStudioThemeBase) {
        pSStudioThemeBase.resetAllDCFlag();
        pSStudioThemeBase.resetCardCssStyle();
        pSStudioThemeBase.resetCreateDate();
        pSStudioThemeBase.resetCreateMan();
        pSStudioThemeBase.resetMemo();
        pSStudioThemeBase.resetPSDevCenterId();
        pSStudioThemeBase.resetPSDevCenterName();
        pSStudioThemeBase.resetPSStudioThemeId();
        pSStudioThemeBase.resetPSStudioThemeName();
        pSStudioThemeBase.resetThemeCode();
        pSStudioThemeBase.resetThemeData();
        pSStudioThemeBase.resetThemeData2();
        pSStudioThemeBase.resetUpdateDate();
        pSStudioThemeBase.resetUpdateMan();
        pSStudioThemeBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAllDCFlagDirty()) {
            hashMap.put(FIELD_ALLDCFLAG, this.getAllDCFlag());
        }
        if (!bl || this.isCardCssStyleDirty()) {
            hashMap.put(FIELD_CARDCSSSTYLE, this.getCardCssStyle());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSStudioThemeIdDirty()) {
            hashMap.put(FIELD_PSSTUDIOTHEMEID, this.getPSStudioThemeId());
        }
        if (!bl || this.isPSStudioThemeNameDirty()) {
            hashMap.put(FIELD_PSSTUDIOTHEMENAME, this.getPSStudioThemeName());
        }
        if (!bl || this.isThemeCodeDirty()) {
            hashMap.put(FIELD_THEMECODE, this.getThemeCode());
        }
        if (!bl || this.isThemeDataDirty()) {
            hashMap.put(FIELD_THEMEDATA, this.getThemeData());
        }
        if (!bl || this.isThemeData2Dirty()) {
            hashMap.put(FIELD_THEMEDATA2, this.getThemeData2());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSStudioThemeBase.get(this, n);
    }

    private static Object get(PSStudioThemeBase pSStudioThemeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSStudioThemeBase.getAllDCFlag();
            }
            case 1: {
                return pSStudioThemeBase.getCardCssStyle();
            }
            case 2: {
                return pSStudioThemeBase.getCreateDate();
            }
            case 3: {
                return pSStudioThemeBase.getCreateMan();
            }
            case 4: {
                return pSStudioThemeBase.getMemo();
            }
            case 5: {
                return pSStudioThemeBase.getPSDevCenterId();
            }
            case 6: {
                return pSStudioThemeBase.getPSDevCenterName();
            }
            case 7: {
                return pSStudioThemeBase.getPSStudioThemeId();
            }
            case 8: {
                return pSStudioThemeBase.getPSStudioThemeName();
            }
            case 9: {
                return pSStudioThemeBase.getThemeCode();
            }
            case 10: {
                return pSStudioThemeBase.getThemeData();
            }
            case 11: {
                return pSStudioThemeBase.getThemeData2();
            }
            case 12: {
                return pSStudioThemeBase.getUpdateDate();
            }
            case 13: {
                return pSStudioThemeBase.getUpdateMan();
            }
            case 14: {
                return pSStudioThemeBase.getValidFlag();
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
        PSStudioThemeBase.set(this, n, object);
    }

    private static void set(PSStudioThemeBase pSStudioThemeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSStudioThemeBase.setAllDCFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSStudioThemeBase.setCardCssStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSStudioThemeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSStudioThemeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSStudioThemeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSStudioThemeBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSStudioThemeBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSStudioThemeBase.setPSStudioThemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSStudioThemeBase.setPSStudioThemeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSStudioThemeBase.setThemeCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSStudioThemeBase.setThemeData(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSStudioThemeBase.setThemeData2(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSStudioThemeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSStudioThemeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSStudioThemeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSStudioThemeBase.isNull(this, n);
    }

    private static boolean isNull(PSStudioThemeBase pSStudioThemeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSStudioThemeBase.getAllDCFlag() == null;
            }
            case 1: {
                return pSStudioThemeBase.getCardCssStyle() == null;
            }
            case 2: {
                return pSStudioThemeBase.getCreateDate() == null;
            }
            case 3: {
                return pSStudioThemeBase.getCreateMan() == null;
            }
            case 4: {
                return pSStudioThemeBase.getMemo() == null;
            }
            case 5: {
                return pSStudioThemeBase.getPSDevCenterId() == null;
            }
            case 6: {
                return pSStudioThemeBase.getPSDevCenterName() == null;
            }
            case 7: {
                return pSStudioThemeBase.getPSStudioThemeId() == null;
            }
            case 8: {
                return pSStudioThemeBase.getPSStudioThemeName() == null;
            }
            case 9: {
                return pSStudioThemeBase.getThemeCode() == null;
            }
            case 10: {
                return pSStudioThemeBase.getThemeData() == null;
            }
            case 11: {
                return pSStudioThemeBase.getThemeData2() == null;
            }
            case 12: {
                return pSStudioThemeBase.getUpdateDate() == null;
            }
            case 13: {
                return pSStudioThemeBase.getUpdateMan() == null;
            }
            case 14: {
                return pSStudioThemeBase.getValidFlag() == null;
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
        return PSStudioThemeBase.contains(this, n);
    }

    private static boolean contains(PSStudioThemeBase pSStudioThemeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSStudioThemeBase.isAllDCFlagDirty();
            }
            case 1: {
                return pSStudioThemeBase.isCardCssStyleDirty();
            }
            case 2: {
                return pSStudioThemeBase.isCreateDateDirty();
            }
            case 3: {
                return pSStudioThemeBase.isCreateManDirty();
            }
            case 4: {
                return pSStudioThemeBase.isMemoDirty();
            }
            case 5: {
                return pSStudioThemeBase.isPSDevCenterIdDirty();
            }
            case 6: {
                return pSStudioThemeBase.isPSDevCenterNameDirty();
            }
            case 7: {
                return pSStudioThemeBase.isPSStudioThemeIdDirty();
            }
            case 8: {
                return pSStudioThemeBase.isPSStudioThemeNameDirty();
            }
            case 9: {
                return pSStudioThemeBase.isThemeCodeDirty();
            }
            case 10: {
                return pSStudioThemeBase.isThemeDataDirty();
            }
            case 11: {
                return pSStudioThemeBase.isThemeData2Dirty();
            }
            case 12: {
                return pSStudioThemeBase.isUpdateDateDirty();
            }
            case 13: {
                return pSStudioThemeBase.isUpdateManDirty();
            }
            case 14: {
                return pSStudioThemeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSStudioThemeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSStudioThemeBase pSStudioThemeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSStudioThemeBase.getAllDCFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"alldcflag", (Object)PSStudioThemeBase.getJSONValue((Object)pSStudioThemeBase.getAllDCFlag()), (boolean)false);
        }
        if (bl || pSStudioThemeBase.getCardCssStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cardcssstyle", (Object)PSStudioThemeBase.getJSONValue((Object)pSStudioThemeBase.getCardCssStyle()), (boolean)false);
        }
        if (bl || pSStudioThemeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSStudioThemeBase.getJSONValue((Object)pSStudioThemeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSStudioThemeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSStudioThemeBase.getJSONValue((Object)pSStudioThemeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSStudioThemeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSStudioThemeBase.getJSONValue((Object)pSStudioThemeBase.getMemo()), (boolean)false);
        }
        if (bl || pSStudioThemeBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSStudioThemeBase.getJSONValue((Object)pSStudioThemeBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSStudioThemeBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSStudioThemeBase.getJSONValue((Object)pSStudioThemeBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSStudioThemeBase.getPSStudioThemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psstudiothemeid", (Object)PSStudioThemeBase.getJSONValue((Object)pSStudioThemeBase.getPSStudioThemeId()), (boolean)false);
        }
        if (bl || pSStudioThemeBase.getPSStudioThemeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psstudiothemename", (Object)PSStudioThemeBase.getJSONValue((Object)pSStudioThemeBase.getPSStudioThemeName()), (boolean)false);
        }
        if (bl || pSStudioThemeBase.getThemeCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"themecode", (Object)PSStudioThemeBase.getJSONValue((Object)pSStudioThemeBase.getThemeCode()), (boolean)false);
        }
        if (bl || pSStudioThemeBase.getThemeData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"themedata", (Object)PSStudioThemeBase.getJSONValue((Object)pSStudioThemeBase.getThemeData()), (boolean)false);
        }
        if (bl || pSStudioThemeBase.getThemeData2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"themedata2", (Object)PSStudioThemeBase.getJSONValue((Object)pSStudioThemeBase.getThemeData2()), (boolean)false);
        }
        if (bl || pSStudioThemeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSStudioThemeBase.getJSONValue((Object)pSStudioThemeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSStudioThemeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSStudioThemeBase.getJSONValue((Object)pSStudioThemeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSStudioThemeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSStudioThemeBase.getJSONValue((Object)pSStudioThemeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSStudioThemeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSStudioThemeBase pSStudioThemeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSStudioThemeBase.getAllDCFlag() != null) {
            object = pSStudioThemeBase.getAllDCFlag();
            xmlNode.setAttribute(FIELD_ALLDCFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSStudioThemeBase.getCardCssStyle() != null) {
            object = pSStudioThemeBase.getCardCssStyle();
            xmlNode.setAttribute(FIELD_CARDCSSSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSStudioThemeBase.getCreateDate() != null) {
            object = pSStudioThemeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSStudioThemeBase.getCreateMan() != null) {
            object = pSStudioThemeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSStudioThemeBase.getMemo() != null) {
            object = pSStudioThemeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSStudioThemeBase.getPSDevCenterId() != null) {
            object = pSStudioThemeBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSStudioThemeBase.getPSDevCenterName() != null) {
            object = pSStudioThemeBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSStudioThemeBase.getPSStudioThemeId() != null) {
            object = pSStudioThemeBase.getPSStudioThemeId();
            xmlNode.setAttribute(FIELD_PSSTUDIOTHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSStudioThemeBase.getPSStudioThemeName() != null) {
            object = pSStudioThemeBase.getPSStudioThemeName();
            xmlNode.setAttribute(FIELD_PSSTUDIOTHEMENAME, object == null ? "" : (String)object);
        }
        if (bl || pSStudioThemeBase.getThemeCode() != null) {
            object = pSStudioThemeBase.getThemeCode();
            xmlNode.setAttribute(FIELD_THEMECODE, object == null ? "" : (String)object);
        }
        if (bl || pSStudioThemeBase.getThemeData() != null) {
            object = pSStudioThemeBase.getThemeData();
            xmlNode.setAttribute(FIELD_THEMEDATA, object == null ? "" : (String)object);
        }
        if (bl || pSStudioThemeBase.getThemeData2() != null) {
            object = pSStudioThemeBase.getThemeData2();
            xmlNode.setAttribute(FIELD_THEMEDATA2, object == null ? "" : (String)object);
        }
        if (bl || pSStudioThemeBase.getUpdateDate() != null) {
            object = pSStudioThemeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSStudioThemeBase.getUpdateMan() != null) {
            object = pSStudioThemeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSStudioThemeBase.getValidFlag() != null) {
            object = pSStudioThemeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSStudioThemeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSStudioThemeBase pSStudioThemeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSStudioThemeBase.isAllDCFlagDirty() && (bl || pSStudioThemeBase.getAllDCFlag() != null)) {
            iDataObject.set(FIELD_ALLDCFLAG, (Object)pSStudioThemeBase.getAllDCFlag());
        }
        if (pSStudioThemeBase.isCardCssStyleDirty() && (bl || pSStudioThemeBase.getCardCssStyle() != null)) {
            iDataObject.set(FIELD_CARDCSSSTYLE, (Object)pSStudioThemeBase.getCardCssStyle());
        }
        if (pSStudioThemeBase.isCreateDateDirty() && (bl || pSStudioThemeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSStudioThemeBase.getCreateDate());
        }
        if (pSStudioThemeBase.isCreateManDirty() && (bl || pSStudioThemeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSStudioThemeBase.getCreateMan());
        }
        if (pSStudioThemeBase.isMemoDirty() && (bl || pSStudioThemeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSStudioThemeBase.getMemo());
        }
        if (pSStudioThemeBase.isPSDevCenterIdDirty() && (bl || pSStudioThemeBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSStudioThemeBase.getPSDevCenterId());
        }
        if (pSStudioThemeBase.isPSDevCenterNameDirty() && (bl || pSStudioThemeBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSStudioThemeBase.getPSDevCenterName());
        }
        if (pSStudioThemeBase.isPSStudioThemeIdDirty() && (bl || pSStudioThemeBase.getPSStudioThemeId() != null)) {
            iDataObject.set(FIELD_PSSTUDIOTHEMEID, (Object)pSStudioThemeBase.getPSStudioThemeId());
        }
        if (pSStudioThemeBase.isPSStudioThemeNameDirty() && (bl || pSStudioThemeBase.getPSStudioThemeName() != null)) {
            iDataObject.set(FIELD_PSSTUDIOTHEMENAME, (Object)pSStudioThemeBase.getPSStudioThemeName());
        }
        if (pSStudioThemeBase.isThemeCodeDirty() && (bl || pSStudioThemeBase.getThemeCode() != null)) {
            iDataObject.set(FIELD_THEMECODE, (Object)pSStudioThemeBase.getThemeCode());
        }
        if (pSStudioThemeBase.isThemeDataDirty() && (bl || pSStudioThemeBase.getThemeData() != null)) {
            iDataObject.set(FIELD_THEMEDATA, (Object)pSStudioThemeBase.getThemeData());
        }
        if (pSStudioThemeBase.isThemeData2Dirty() && (bl || pSStudioThemeBase.getThemeData2() != null)) {
            iDataObject.set(FIELD_THEMEDATA2, (Object)pSStudioThemeBase.getThemeData2());
        }
        if (pSStudioThemeBase.isUpdateDateDirty() && (bl || pSStudioThemeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSStudioThemeBase.getUpdateDate());
        }
        if (pSStudioThemeBase.isUpdateManDirty() && (bl || pSStudioThemeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSStudioThemeBase.getUpdateMan());
        }
        if (pSStudioThemeBase.isValidFlagDirty() && (bl || pSStudioThemeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSStudioThemeBase.getValidFlag());
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
        return PSStudioThemeBase.remove(this, n);
    }

    private static boolean remove(PSStudioThemeBase pSStudioThemeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSStudioThemeBase.resetAllDCFlag();
                return true;
            }
            case 1: {
                pSStudioThemeBase.resetCardCssStyle();
                return true;
            }
            case 2: {
                pSStudioThemeBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSStudioThemeBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSStudioThemeBase.resetMemo();
                return true;
            }
            case 5: {
                pSStudioThemeBase.resetPSDevCenterId();
                return true;
            }
            case 6: {
                pSStudioThemeBase.resetPSDevCenterName();
                return true;
            }
            case 7: {
                pSStudioThemeBase.resetPSStudioThemeId();
                return true;
            }
            case 8: {
                pSStudioThemeBase.resetPSStudioThemeName();
                return true;
            }
            case 9: {
                pSStudioThemeBase.resetThemeCode();
                return true;
            }
            case 10: {
                pSStudioThemeBase.resetThemeData();
                return true;
            }
            case 11: {
                pSStudioThemeBase.resetThemeData2();
                return true;
            }
            case 12: {
                pSStudioThemeBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSStudioThemeBase.resetUpdateMan();
                return true;
            }
            case 14: {
                pSStudioThemeBase.resetValidFlag();
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
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    private PSStudioThemeBase getProxyEntity() {
        return this.proxyPSStudioThemeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSStudioThemeBase = null;
        if (iDataObject != null && iDataObject instanceof PSStudioThemeBase) {
            this.proxyPSStudioThemeBase = (PSStudioThemeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSStudioThemeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLDCFLAG, 0);
        fieldIndexMap.put(FIELD_CARDCSSSTYLE, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 5);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 6);
        fieldIndexMap.put(FIELD_PSSTUDIOTHEMEID, 7);
        fieldIndexMap.put(FIELD_PSSTUDIOTHEMENAME, 8);
        fieldIndexMap.put(FIELD_THEMECODE, 9);
        fieldIndexMap.put(FIELD_THEMEDATA, 10);
        fieldIndexMap.put(FIELD_THEMEDATA2, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
        fieldIndexMap.put(FIELD_VALIDFLAG, 14);
    }
}

