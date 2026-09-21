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
package net.ibizsys.pscore.srv.def.entity;

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

public abstract class PSASTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSASTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ICONPATH = "ICONPATH";
    public static final String FIELD_INSTALLPATH = "INSTALLPATH";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSASTYPEID = "PSASTYPEID";
    public static final String FIELD_PSASTYPENAME = "PSASTYPENAME";
    public static final String FIELD_STARTCMD = "STARTCMD";
    public static final String FIELD_STOPCMD = "STOPCMD";
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
    private static final int INDEX_PSASTYPEID = 5;
    private static final int INDEX_PSASTYPENAME = 6;
    private static final int INDEX_STARTCMD = 7;
    private static final int INDEX_STOPCMD = 8;
    private static final int INDEX_TYPEHELPER = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_USERTAG = 12;
    private static final int INDEX_USERTAG2 = 13;
    private static final int INDEX_VALIDFLAG = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSASTypeBase proxyPSASTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean iconpathDirtyFlag = false;
    private boolean installpathDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psastypeidDirtyFlag = false;
    private boolean psastypenameDirtyFlag = false;
    private boolean startcmdDirtyFlag = false;
    private boolean stopcmdDirtyFlag = false;
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
    @Column(name="psastypeid")
    private String psastypeid;
    @Column(name="psastypename")
    private String psastypename;
    @Column(name="startcmd")
    private String startcmd;
    @Column(name="stopcmd")
    private String stopcmd;
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

    public void setPSASTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSASTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psastypeid = string;
        this.psastypeidDirtyFlag = true;
    }

    public String getPSASTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSASTypeId();
        }
        return this.psastypeid;
    }

    public boolean isPSASTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSASTypeIdDirty();
        }
        return this.psastypeidDirtyFlag;
    }

    public void resetPSASTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSASTypeId();
            return;
        }
        this.psastypeidDirtyFlag = false;
        this.psastypeid = null;
    }

    public void setPSASTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSASTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psastypename = string;
        this.psastypenameDirtyFlag = true;
    }

    public String getPSASTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSASTypeName();
        }
        return this.psastypename;
    }

    public boolean isPSASTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSASTypeNameDirty();
        }
        return this.psastypenameDirtyFlag;
    }

    public void resetPSASTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSASTypeName();
            return;
        }
        this.psastypenameDirtyFlag = false;
        this.psastypename = null;
    }

    public void setStartCmd(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStartCmd(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.startcmd = string;
        this.startcmdDirtyFlag = true;
    }

    public String getStartCmd() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStartCmd();
        }
        return this.startcmd;
    }

    public boolean isStartCmdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStartCmdDirty();
        }
        return this.startcmdDirtyFlag;
    }

    public void resetStartCmd() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStartCmd();
            return;
        }
        this.startcmdDirtyFlag = false;
        this.startcmd = null;
    }

    public void setStopCmd(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStopCmd(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.stopcmd = string;
        this.stopcmdDirtyFlag = true;
    }

    public String getStopCmd() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStopCmd();
        }
        return this.stopcmd;
    }

    public boolean isStopCmdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStopCmdDirty();
        }
        return this.stopcmdDirtyFlag;
    }

    public void resetStopCmd() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStopCmd();
            return;
        }
        this.stopcmdDirtyFlag = false;
        this.stopcmd = null;
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
        PSASTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSASTypeBase pSASTypeBase) {
        pSASTypeBase.resetCreateDate();
        pSASTypeBase.resetCreateMan();
        pSASTypeBase.resetIconPath();
        pSASTypeBase.resetInstallPath();
        pSASTypeBase.resetMemo();
        pSASTypeBase.resetPSASTypeId();
        pSASTypeBase.resetPSASTypeName();
        pSASTypeBase.resetStartCmd();
        pSASTypeBase.resetStopCmd();
        pSASTypeBase.resetTypeHelper();
        pSASTypeBase.resetUpdateDate();
        pSASTypeBase.resetUpdateMan();
        pSASTypeBase.resetUserTag();
        pSASTypeBase.resetUserTag2();
        pSASTypeBase.resetValidFlag();
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
        if (!bl || this.isPSASTypeIdDirty()) {
            hashMap.put(FIELD_PSASTYPEID, this.getPSASTypeId());
        }
        if (!bl || this.isPSASTypeNameDirty()) {
            hashMap.put(FIELD_PSASTYPENAME, this.getPSASTypeName());
        }
        if (!bl || this.isStartCmdDirty()) {
            hashMap.put(FIELD_STARTCMD, this.getStartCmd());
        }
        if (!bl || this.isStopCmdDirty()) {
            hashMap.put(FIELD_STOPCMD, this.getStopCmd());
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
        return PSASTypeBase.get(this, n);
    }

    private static Object get(PSASTypeBase pSASTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSASTypeBase.getCreateDate();
            }
            case 1: {
                return pSASTypeBase.getCreateMan();
            }
            case 2: {
                return pSASTypeBase.getIconPath();
            }
            case 3: {
                return pSASTypeBase.getInstallPath();
            }
            case 4: {
                return pSASTypeBase.getMemo();
            }
            case 5: {
                return pSASTypeBase.getPSASTypeId();
            }
            case 6: {
                return pSASTypeBase.getPSASTypeName();
            }
            case 7: {
                return pSASTypeBase.getStartCmd();
            }
            case 8: {
                return pSASTypeBase.getStopCmd();
            }
            case 9: {
                return pSASTypeBase.getTypeHelper();
            }
            case 10: {
                return pSASTypeBase.getUpdateDate();
            }
            case 11: {
                return pSASTypeBase.getUpdateMan();
            }
            case 12: {
                return pSASTypeBase.getUserTag();
            }
            case 13: {
                return pSASTypeBase.getUserTag2();
            }
            case 14: {
                return pSASTypeBase.getValidFlag();
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
        PSASTypeBase.set(this, n, object);
    }

    private static void set(PSASTypeBase pSASTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSASTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSASTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSASTypeBase.setIconPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSASTypeBase.setInstallPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSASTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSASTypeBase.setPSASTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSASTypeBase.setPSASTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSASTypeBase.setStartCmd(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSASTypeBase.setStopCmd(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSASTypeBase.setTypeHelper(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSASTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSASTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSASTypeBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSASTypeBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSASTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSASTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSASTypeBase pSASTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSASTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSASTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSASTypeBase.getIconPath() == null;
            }
            case 3: {
                return pSASTypeBase.getInstallPath() == null;
            }
            case 4: {
                return pSASTypeBase.getMemo() == null;
            }
            case 5: {
                return pSASTypeBase.getPSASTypeId() == null;
            }
            case 6: {
                return pSASTypeBase.getPSASTypeName() == null;
            }
            case 7: {
                return pSASTypeBase.getStartCmd() == null;
            }
            case 8: {
                return pSASTypeBase.getStopCmd() == null;
            }
            case 9: {
                return pSASTypeBase.getTypeHelper() == null;
            }
            case 10: {
                return pSASTypeBase.getUpdateDate() == null;
            }
            case 11: {
                return pSASTypeBase.getUpdateMan() == null;
            }
            case 12: {
                return pSASTypeBase.getUserTag() == null;
            }
            case 13: {
                return pSASTypeBase.getUserTag2() == null;
            }
            case 14: {
                return pSASTypeBase.getValidFlag() == null;
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
        return PSASTypeBase.contains(this, n);
    }

    private static boolean contains(PSASTypeBase pSASTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSASTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSASTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSASTypeBase.isIconPathDirty();
            }
            case 3: {
                return pSASTypeBase.isInstallPathDirty();
            }
            case 4: {
                return pSASTypeBase.isMemoDirty();
            }
            case 5: {
                return pSASTypeBase.isPSASTypeIdDirty();
            }
            case 6: {
                return pSASTypeBase.isPSASTypeNameDirty();
            }
            case 7: {
                return pSASTypeBase.isStartCmdDirty();
            }
            case 8: {
                return pSASTypeBase.isStopCmdDirty();
            }
            case 9: {
                return pSASTypeBase.isTypeHelperDirty();
            }
            case 10: {
                return pSASTypeBase.isUpdateDateDirty();
            }
            case 11: {
                return pSASTypeBase.isUpdateManDirty();
            }
            case 12: {
                return pSASTypeBase.isUserTagDirty();
            }
            case 13: {
                return pSASTypeBase.isUserTag2Dirty();
            }
            case 14: {
                return pSASTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSASTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSASTypeBase pSASTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSASTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSASTypeBase.getJSONValue((Object)pSASTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSASTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSASTypeBase.getJSONValue((Object)pSASTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSASTypeBase.getIconPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconpath", (Object)PSASTypeBase.getJSONValue((Object)pSASTypeBase.getIconPath()), (boolean)false);
        }
        if (bl || pSASTypeBase.getInstallPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"installpath", (Object)PSASTypeBase.getJSONValue((Object)pSASTypeBase.getInstallPath()), (boolean)false);
        }
        if (bl || pSASTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSASTypeBase.getJSONValue((Object)pSASTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSASTypeBase.getPSASTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psastypeid", (Object)PSASTypeBase.getJSONValue((Object)pSASTypeBase.getPSASTypeId()), (boolean)false);
        }
        if (bl || pSASTypeBase.getPSASTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psastypename", (Object)PSASTypeBase.getJSONValue((Object)pSASTypeBase.getPSASTypeName()), (boolean)false);
        }
        if (bl || pSASTypeBase.getStartCmd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"startcmd", (Object)PSASTypeBase.getJSONValue((Object)pSASTypeBase.getStartCmd()), (boolean)false);
        }
        if (bl || pSASTypeBase.getStopCmd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stopcmd", (Object)PSASTypeBase.getJSONValue((Object)pSASTypeBase.getStopCmd()), (boolean)false);
        }
        if (bl || pSASTypeBase.getTypeHelper() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typehelper", (Object)PSASTypeBase.getJSONValue((Object)pSASTypeBase.getTypeHelper()), (boolean)false);
        }
        if (bl || pSASTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSASTypeBase.getJSONValue((Object)pSASTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSASTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSASTypeBase.getJSONValue((Object)pSASTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSASTypeBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSASTypeBase.getJSONValue((Object)pSASTypeBase.getUserTag()), (boolean)false);
        }
        if (bl || pSASTypeBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSASTypeBase.getJSONValue((Object)pSASTypeBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSASTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSASTypeBase.getJSONValue((Object)pSASTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSASTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSASTypeBase pSASTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSASTypeBase.getCreateDate() != null) {
            object = pSASTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSASTypeBase.getCreateMan() != null) {
            object = pSASTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSASTypeBase.getIconPath() != null) {
            object = pSASTypeBase.getIconPath();
            xmlNode.setAttribute(FIELD_ICONPATH, object == null ? "" : (String)object);
        }
        if (bl || pSASTypeBase.getInstallPath() != null) {
            object = pSASTypeBase.getInstallPath();
            xmlNode.setAttribute(FIELD_INSTALLPATH, object == null ? "" : (String)object);
        }
        if (bl || pSASTypeBase.getMemo() != null) {
            object = pSASTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSASTypeBase.getPSASTypeId() != null) {
            object = pSASTypeBase.getPSASTypeId();
            xmlNode.setAttribute(FIELD_PSASTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSASTypeBase.getPSASTypeName() != null) {
            object = pSASTypeBase.getPSASTypeName();
            xmlNode.setAttribute(FIELD_PSASTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSASTypeBase.getStartCmd() != null) {
            object = pSASTypeBase.getStartCmd();
            xmlNode.setAttribute(FIELD_STARTCMD, object == null ? "" : (String)object);
        }
        if (bl || pSASTypeBase.getStopCmd() != null) {
            object = pSASTypeBase.getStopCmd();
            xmlNode.setAttribute(FIELD_STOPCMD, object == null ? "" : (String)object);
        }
        if (bl || pSASTypeBase.getTypeHelper() != null) {
            object = pSASTypeBase.getTypeHelper();
            xmlNode.setAttribute(FIELD_TYPEHELPER, object == null ? "" : (String)object);
        }
        if (bl || pSASTypeBase.getUpdateDate() != null) {
            object = pSASTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSASTypeBase.getUpdateMan() != null) {
            object = pSASTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSASTypeBase.getUserTag() != null) {
            object = pSASTypeBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSASTypeBase.getUserTag2() != null) {
            object = pSASTypeBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSASTypeBase.getValidFlag() != null) {
            object = pSASTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSASTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSASTypeBase pSASTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSASTypeBase.isCreateDateDirty() && (bl || pSASTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSASTypeBase.getCreateDate());
        }
        if (pSASTypeBase.isCreateManDirty() && (bl || pSASTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSASTypeBase.getCreateMan());
        }
        if (pSASTypeBase.isIconPathDirty() && (bl || pSASTypeBase.getIconPath() != null)) {
            iDataObject.set(FIELD_ICONPATH, (Object)pSASTypeBase.getIconPath());
        }
        if (pSASTypeBase.isInstallPathDirty() && (bl || pSASTypeBase.getInstallPath() != null)) {
            iDataObject.set(FIELD_INSTALLPATH, (Object)pSASTypeBase.getInstallPath());
        }
        if (pSASTypeBase.isMemoDirty() && (bl || pSASTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSASTypeBase.getMemo());
        }
        if (pSASTypeBase.isPSASTypeIdDirty() && (bl || pSASTypeBase.getPSASTypeId() != null)) {
            iDataObject.set(FIELD_PSASTYPEID, (Object)pSASTypeBase.getPSASTypeId());
        }
        if (pSASTypeBase.isPSASTypeNameDirty() && (bl || pSASTypeBase.getPSASTypeName() != null)) {
            iDataObject.set(FIELD_PSASTYPENAME, (Object)pSASTypeBase.getPSASTypeName());
        }
        if (pSASTypeBase.isStartCmdDirty() && (bl || pSASTypeBase.getStartCmd() != null)) {
            iDataObject.set(FIELD_STARTCMD, (Object)pSASTypeBase.getStartCmd());
        }
        if (pSASTypeBase.isStopCmdDirty() && (bl || pSASTypeBase.getStopCmd() != null)) {
            iDataObject.set(FIELD_STOPCMD, (Object)pSASTypeBase.getStopCmd());
        }
        if (pSASTypeBase.isTypeHelperDirty() && (bl || pSASTypeBase.getTypeHelper() != null)) {
            iDataObject.set(FIELD_TYPEHELPER, (Object)pSASTypeBase.getTypeHelper());
        }
        if (pSASTypeBase.isUpdateDateDirty() && (bl || pSASTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSASTypeBase.getUpdateDate());
        }
        if (pSASTypeBase.isUpdateManDirty() && (bl || pSASTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSASTypeBase.getUpdateMan());
        }
        if (pSASTypeBase.isUserTagDirty() && (bl || pSASTypeBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSASTypeBase.getUserTag());
        }
        if (pSASTypeBase.isUserTag2Dirty() && (bl || pSASTypeBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSASTypeBase.getUserTag2());
        }
        if (pSASTypeBase.isValidFlagDirty() && (bl || pSASTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSASTypeBase.getValidFlag());
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
        return PSASTypeBase.remove(this, n);
    }

    private static boolean remove(PSASTypeBase pSASTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSASTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSASTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSASTypeBase.resetIconPath();
                return true;
            }
            case 3: {
                pSASTypeBase.resetInstallPath();
                return true;
            }
            case 4: {
                pSASTypeBase.resetMemo();
                return true;
            }
            case 5: {
                pSASTypeBase.resetPSASTypeId();
                return true;
            }
            case 6: {
                pSASTypeBase.resetPSASTypeName();
                return true;
            }
            case 7: {
                pSASTypeBase.resetStartCmd();
                return true;
            }
            case 8: {
                pSASTypeBase.resetStopCmd();
                return true;
            }
            case 9: {
                pSASTypeBase.resetTypeHelper();
                return true;
            }
            case 10: {
                pSASTypeBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSASTypeBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSASTypeBase.resetUserTag();
                return true;
            }
            case 13: {
                pSASTypeBase.resetUserTag2();
                return true;
            }
            case 14: {
                pSASTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSASTypeBase getProxyEntity() {
        return this.proxyPSASTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSASTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSASTypeBase) {
            this.proxyPSASTypeBase = (PSASTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.def.service.PSASTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ICONPATH, 2);
        fieldIndexMap.put(FIELD_INSTALLPATH, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSASTYPEID, 5);
        fieldIndexMap.put(FIELD_PSASTYPENAME, 6);
        fieldIndexMap.put(FIELD_STARTCMD, 7);
        fieldIndexMap.put(FIELD_STOPCMD, 8);
        fieldIndexMap.put(FIELD_TYPEHELPER, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_USERTAG, 12);
        fieldIndexMap.put(FIELD_USERTAG2, 13);
        fieldIndexMap.put(FIELD_VALIDFLAG, 14);
    }
}

