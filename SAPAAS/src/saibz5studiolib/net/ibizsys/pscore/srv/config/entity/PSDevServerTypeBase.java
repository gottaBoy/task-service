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
package net.ibizsys.pscore.srv.config.entity;

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

public abstract class PSDevServerTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevServerTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ICONPATH = "ICONPATH";
    public static final String FIELD_INSTALLPATH = "INSTALLPATH";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVSERVERTYPEID = "PSDEVSERVERTYPEID";
    public static final String FIELD_PSDEVSERVERTYPENAME = "PSDEVSERVERTYPENAME";
    public static final String FIELD_TYPEHELPER = "TYPEHELPER";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ICONPATH = 2;
    private static final int INDEX_INSTALLPATH = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSDEVSERVERTYPEID = 5;
    private static final int INDEX_PSDEVSERVERTYPENAME = 6;
    private static final int INDEX_TYPEHELPER = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final int INDEX_USERTAG = 10;
    private static final int INDEX_USERTAG2 = 11;
    private static final int INDEX_VALIDFLAG = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevServerTypeBase proxyPSDevServerTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean iconpathDirtyFlag = false;
    private boolean installpathDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevservertypeidDirtyFlag = false;
    private boolean psdevservertypenameDirtyFlag = false;
    private boolean typehelperDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="iconpath")
    private String iconpath;
    @Column(name="installpath")
    private String installpath;
    @Column(name="memo")
    private String memo;
    @Column(name="psdevservertypeid")
    private String psdevservertypeid;
    @Column(name="psdevservertypename")
    private String psdevservertypename;
    @Column(name="typehelper")
    private String typehelper;
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

    public void setIconPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIconPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.iconpath = string;
        this.iconpathDirtyFlag = true;
    }

    public String getIconPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIconPath();
        }
        return this.iconpath;
    }

    public boolean isIconPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIconPathDirty();
        }
        return this.iconpathDirtyFlag;
    }

    public void resetIconPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIconPath();
            return;
        }
        this.iconpathDirtyFlag = false;
        this.iconpath = null;
    }

    public void setInstallPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstallPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.installpath = string;
        this.installpathDirtyFlag = true;
    }

    public String getInstallPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInstallPath();
        }
        return this.installpath;
    }

    public boolean isInstallPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInstallPathDirty();
        }
        return this.installpathDirtyFlag;
    }

    public void resetInstallPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInstallPath();
            return;
        }
        this.installpathDirtyFlag = false;
        this.installpath = null;
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

    public void setPSDevServerTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevServerTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevservertypeid = string;
        this.psdevservertypeidDirtyFlag = true;
    }

    public String getPSDevServerTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevServerTypeId();
        }
        return this.psdevservertypeid;
    }

    public boolean isPSDevServerTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevServerTypeIdDirty();
        }
        return this.psdevservertypeidDirtyFlag;
    }

    public void resetPSDevServerTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevServerTypeId();
            return;
        }
        this.psdevservertypeidDirtyFlag = false;
        this.psdevservertypeid = null;
    }

    public void setPSDevServerTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevServerTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevservertypename = string;
        this.psdevservertypenameDirtyFlag = true;
    }

    public String getPSDevServerTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevServerTypeName();
        }
        return this.psdevservertypename;
    }

    public boolean isPSDevServerTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevServerTypeNameDirty();
        }
        return this.psdevservertypenameDirtyFlag;
    }

    public void resetPSDevServerTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevServerTypeName();
            return;
        }
        this.psdevservertypenameDirtyFlag = false;
        this.psdevservertypename = null;
    }

    public void setTypeHelper(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeHelper(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typehelper = string;
        this.typehelperDirtyFlag = true;
    }

    public String getTypeHelper() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeHelper();
        }
        return this.typehelper;
    }

    public boolean isTypeHelperDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeHelperDirty();
        }
        return this.typehelperDirtyFlag;
    }

    public void resetTypeHelper() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeHelper();
            return;
        }
        this.typehelperDirtyFlag = false;
        this.typehelper = null;
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
        PSDevServerTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevServerTypeBase pSDevServerTypeBase) {
        pSDevServerTypeBase.resetCreateDate();
        pSDevServerTypeBase.resetCreateMan();
        pSDevServerTypeBase.resetIconPath();
        pSDevServerTypeBase.resetInstallPath();
        pSDevServerTypeBase.resetMemo();
        pSDevServerTypeBase.resetPSDevServerTypeId();
        pSDevServerTypeBase.resetPSDevServerTypeName();
        pSDevServerTypeBase.resetTypeHelper();
        pSDevServerTypeBase.resetUpdateDate();
        pSDevServerTypeBase.resetUpdateMan();
        pSDevServerTypeBase.resetUserTag();
        pSDevServerTypeBase.resetUserTag2();
        pSDevServerTypeBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isIconPathDirty()) {
            hashMap.put(FIELD_ICONPATH, this.getIconPath());
        }
        if (!bl || this.isInstallPathDirty()) {
            hashMap.put(FIELD_INSTALLPATH, this.getInstallPath());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDevServerTypeIdDirty()) {
            hashMap.put(FIELD_PSDEVSERVERTYPEID, this.getPSDevServerTypeId());
        }
        if (!bl || this.isPSDevServerTypeNameDirty()) {
            hashMap.put(FIELD_PSDEVSERVERTYPENAME, this.getPSDevServerTypeName());
        }
        if (!bl || this.isTypeHelperDirty()) {
            hashMap.put(FIELD_TYPEHELPER, this.getTypeHelper());
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
        return PSDevServerTypeBase.get(this, n);
    }

    private static Object get(PSDevServerTypeBase pSDevServerTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevServerTypeBase.getCreateDate();
            }
            case 1: {
                return pSDevServerTypeBase.getCreateMan();
            }
            case 2: {
                return pSDevServerTypeBase.getIconPath();
            }
            case 3: {
                return pSDevServerTypeBase.getInstallPath();
            }
            case 4: {
                return pSDevServerTypeBase.getMemo();
            }
            case 5: {
                return pSDevServerTypeBase.getPSDevServerTypeId();
            }
            case 6: {
                return pSDevServerTypeBase.getPSDevServerTypeName();
            }
            case 7: {
                return pSDevServerTypeBase.getTypeHelper();
            }
            case 8: {
                return pSDevServerTypeBase.getUpdateDate();
            }
            case 9: {
                return pSDevServerTypeBase.getUpdateMan();
            }
            case 10: {
                return pSDevServerTypeBase.getUserTag();
            }
            case 11: {
                return pSDevServerTypeBase.getUserTag2();
            }
            case 12: {
                return pSDevServerTypeBase.getValidFlag();
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
        PSDevServerTypeBase.set(this, n, object);
    }

    private static void set(PSDevServerTypeBase pSDevServerTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevServerTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevServerTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevServerTypeBase.setIconPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevServerTypeBase.setInstallPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevServerTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevServerTypeBase.setPSDevServerTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevServerTypeBase.setPSDevServerTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevServerTypeBase.setTypeHelper(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevServerTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSDevServerTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevServerTypeBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevServerTypeBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevServerTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDevServerTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSDevServerTypeBase pSDevServerTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevServerTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevServerTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevServerTypeBase.getIconPath() == null;
            }
            case 3: {
                return pSDevServerTypeBase.getInstallPath() == null;
            }
            case 4: {
                return pSDevServerTypeBase.getMemo() == null;
            }
            case 5: {
                return pSDevServerTypeBase.getPSDevServerTypeId() == null;
            }
            case 6: {
                return pSDevServerTypeBase.getPSDevServerTypeName() == null;
            }
            case 7: {
                return pSDevServerTypeBase.getTypeHelper() == null;
            }
            case 8: {
                return pSDevServerTypeBase.getUpdateDate() == null;
            }
            case 9: {
                return pSDevServerTypeBase.getUpdateMan() == null;
            }
            case 10: {
                return pSDevServerTypeBase.getUserTag() == null;
            }
            case 11: {
                return pSDevServerTypeBase.getUserTag2() == null;
            }
            case 12: {
                return pSDevServerTypeBase.getValidFlag() == null;
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
        return PSDevServerTypeBase.contains(this, n);
    }

    private static boolean contains(PSDevServerTypeBase pSDevServerTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevServerTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevServerTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSDevServerTypeBase.isIconPathDirty();
            }
            case 3: {
                return pSDevServerTypeBase.isInstallPathDirty();
            }
            case 4: {
                return pSDevServerTypeBase.isMemoDirty();
            }
            case 5: {
                return pSDevServerTypeBase.isPSDevServerTypeIdDirty();
            }
            case 6: {
                return pSDevServerTypeBase.isPSDevServerTypeNameDirty();
            }
            case 7: {
                return pSDevServerTypeBase.isTypeHelperDirty();
            }
            case 8: {
                return pSDevServerTypeBase.isUpdateDateDirty();
            }
            case 9: {
                return pSDevServerTypeBase.isUpdateManDirty();
            }
            case 10: {
                return pSDevServerTypeBase.isUserTagDirty();
            }
            case 11: {
                return pSDevServerTypeBase.isUserTag2Dirty();
            }
            case 12: {
                return pSDevServerTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevServerTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevServerTypeBase pSDevServerTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevServerTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevServerTypeBase.getJSONValue((Object)pSDevServerTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevServerTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevServerTypeBase.getJSONValue((Object)pSDevServerTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevServerTypeBase.getIconPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconpath", (Object)PSDevServerTypeBase.getJSONValue((Object)pSDevServerTypeBase.getIconPath()), (boolean)false);
        }
        if (bl || pSDevServerTypeBase.getInstallPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"installpath", (Object)PSDevServerTypeBase.getJSONValue((Object)pSDevServerTypeBase.getInstallPath()), (boolean)false);
        }
        if (bl || pSDevServerTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevServerTypeBase.getJSONValue((Object)pSDevServerTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevServerTypeBase.getPSDevServerTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevservertypeid", (Object)PSDevServerTypeBase.getJSONValue((Object)pSDevServerTypeBase.getPSDevServerTypeId()), (boolean)false);
        }
        if (bl || pSDevServerTypeBase.getPSDevServerTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevservertypename", (Object)PSDevServerTypeBase.getJSONValue((Object)pSDevServerTypeBase.getPSDevServerTypeName()), (boolean)false);
        }
        if (bl || pSDevServerTypeBase.getTypeHelper() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typehelper", (Object)PSDevServerTypeBase.getJSONValue((Object)pSDevServerTypeBase.getTypeHelper()), (boolean)false);
        }
        if (bl || pSDevServerTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevServerTypeBase.getJSONValue((Object)pSDevServerTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevServerTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevServerTypeBase.getJSONValue((Object)pSDevServerTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevServerTypeBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDevServerTypeBase.getJSONValue((Object)pSDevServerTypeBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDevServerTypeBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDevServerTypeBase.getJSONValue((Object)pSDevServerTypeBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDevServerTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDevServerTypeBase.getJSONValue((Object)pSDevServerTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevServerTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevServerTypeBase pSDevServerTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevServerTypeBase.getCreateDate() != null) {
            object = pSDevServerTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevServerTypeBase.getCreateMan() != null) {
            object = pSDevServerTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevServerTypeBase.getIconPath() != null) {
            object = pSDevServerTypeBase.getIconPath();
            xmlNode.setAttribute(FIELD_ICONPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDevServerTypeBase.getInstallPath() != null) {
            object = pSDevServerTypeBase.getInstallPath();
            xmlNode.setAttribute(FIELD_INSTALLPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDevServerTypeBase.getMemo() != null) {
            object = pSDevServerTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevServerTypeBase.getPSDevServerTypeId() != null) {
            object = pSDevServerTypeBase.getPSDevServerTypeId();
            xmlNode.setAttribute(FIELD_PSDEVSERVERTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevServerTypeBase.getPSDevServerTypeName() != null) {
            object = pSDevServerTypeBase.getPSDevServerTypeName();
            xmlNode.setAttribute(FIELD_PSDEVSERVERTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevServerTypeBase.getTypeHelper() != null) {
            object = pSDevServerTypeBase.getTypeHelper();
            xmlNode.setAttribute(FIELD_TYPEHELPER, object == null ? "" : (String)object);
        }
        if (bl || pSDevServerTypeBase.getUpdateDate() != null) {
            object = pSDevServerTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevServerTypeBase.getUpdateMan() != null) {
            object = pSDevServerTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevServerTypeBase.getUserTag() != null) {
            object = pSDevServerTypeBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevServerTypeBase.getUserTag2() != null) {
            object = pSDevServerTypeBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevServerTypeBase.getValidFlag() != null) {
            object = pSDevServerTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevServerTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevServerTypeBase pSDevServerTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevServerTypeBase.isCreateDateDirty() && (bl || pSDevServerTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevServerTypeBase.getCreateDate());
        }
        if (pSDevServerTypeBase.isCreateManDirty() && (bl || pSDevServerTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevServerTypeBase.getCreateMan());
        }
        if (pSDevServerTypeBase.isIconPathDirty() && (bl || pSDevServerTypeBase.getIconPath() != null)) {
            iDataObject.set(FIELD_ICONPATH, (Object)pSDevServerTypeBase.getIconPath());
        }
        if (pSDevServerTypeBase.isInstallPathDirty() && (bl || pSDevServerTypeBase.getInstallPath() != null)) {
            iDataObject.set(FIELD_INSTALLPATH, (Object)pSDevServerTypeBase.getInstallPath());
        }
        if (pSDevServerTypeBase.isMemoDirty() && (bl || pSDevServerTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevServerTypeBase.getMemo());
        }
        if (pSDevServerTypeBase.isPSDevServerTypeIdDirty() && (bl || pSDevServerTypeBase.getPSDevServerTypeId() != null)) {
            iDataObject.set(FIELD_PSDEVSERVERTYPEID, (Object)pSDevServerTypeBase.getPSDevServerTypeId());
        }
        if (pSDevServerTypeBase.isPSDevServerTypeNameDirty() && (bl || pSDevServerTypeBase.getPSDevServerTypeName() != null)) {
            iDataObject.set(FIELD_PSDEVSERVERTYPENAME, (Object)pSDevServerTypeBase.getPSDevServerTypeName());
        }
        if (pSDevServerTypeBase.isTypeHelperDirty() && (bl || pSDevServerTypeBase.getTypeHelper() != null)) {
            iDataObject.set(FIELD_TYPEHELPER, (Object)pSDevServerTypeBase.getTypeHelper());
        }
        if (pSDevServerTypeBase.isUpdateDateDirty() && (bl || pSDevServerTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevServerTypeBase.getUpdateDate());
        }
        if (pSDevServerTypeBase.isUpdateManDirty() && (bl || pSDevServerTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevServerTypeBase.getUpdateMan());
        }
        if (pSDevServerTypeBase.isUserTagDirty() && (bl || pSDevServerTypeBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDevServerTypeBase.getUserTag());
        }
        if (pSDevServerTypeBase.isUserTag2Dirty() && (bl || pSDevServerTypeBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDevServerTypeBase.getUserTag2());
        }
        if (pSDevServerTypeBase.isValidFlagDirty() && (bl || pSDevServerTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDevServerTypeBase.getValidFlag());
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
        return PSDevServerTypeBase.remove(this, n);
    }

    private static boolean remove(PSDevServerTypeBase pSDevServerTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevServerTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevServerTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevServerTypeBase.resetIconPath();
                return true;
            }
            case 3: {
                pSDevServerTypeBase.resetInstallPath();
                return true;
            }
            case 4: {
                pSDevServerTypeBase.resetMemo();
                return true;
            }
            case 5: {
                pSDevServerTypeBase.resetPSDevServerTypeId();
                return true;
            }
            case 6: {
                pSDevServerTypeBase.resetPSDevServerTypeName();
                return true;
            }
            case 7: {
                pSDevServerTypeBase.resetTypeHelper();
                return true;
            }
            case 8: {
                pSDevServerTypeBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSDevServerTypeBase.resetUpdateMan();
                return true;
            }
            case 10: {
                pSDevServerTypeBase.resetUserTag();
                return true;
            }
            case 11: {
                pSDevServerTypeBase.resetUserTag2();
                return true;
            }
            case 12: {
                pSDevServerTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDevServerTypeBase getProxyEntity() {
        return this.proxyPSDevServerTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevServerTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevServerTypeBase) {
            this.proxyPSDevServerTypeBase = (PSDevServerTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDevServerTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ICONPATH, 2);
        fieldIndexMap.put(FIELD_INSTALLPATH, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSDEVSERVERTYPEID, 5);
        fieldIndexMap.put(FIELD_PSDEVSERVERTYPENAME, 6);
        fieldIndexMap.put(FIELD_TYPEHELPER, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
        fieldIndexMap.put(FIELD_USERTAG, 10);
        fieldIndexMap.put(FIELD_USERTAG2, 11);
        fieldIndexMap.put(FIELD_VALIDFLAG, 12);
    }
}

