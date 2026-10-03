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
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPortletBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPortletBase.class);
    public static final String FIELD_BASECLSPARAMS = "BASECLSPARAMS";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PORTLETTYPE = "PORTLETTYPE";
    public static final String FIELD_PSPFPLUGINID = "PSPFPLUGINID";
    public static final String FIELD_PSPFPLUGINNAME = "PSPFPLUGINNAME";
    public static final String FIELD_PSPORTLETID = "PSPORTLETID";
    public static final String FIELD_PSPORTLETNAME = "PSPORTLETNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_BASECLSPARAMS = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PORTLETTYPE = 5;
    private static final int INDEX_PSPFPLUGINID = 6;
    private static final int INDEX_PSPFPLUGINNAME = 7;
    private static final int INDEX_PSPORTLETID = 8;
    private static final int INDEX_PSPORTLETNAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPortletBase proxyPSPortletBase = null;
    private boolean baseclsparamsDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean portlettypeDirtyFlag = false;
    private boolean pspfpluginidDirtyFlag = false;
    private boolean pspfpluginnameDirtyFlag = false;
    private boolean psportletidDirtyFlag = false;
    private boolean psportletnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="baseclsparams")
    private String baseclsparams;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="portlettype")
    private String portlettype;
    @Column(name="pspfpluginid")
    private String pspfpluginid;
    @Column(name="pspfpluginname")
    private String pspfpluginname;
    @Column(name="psportletid")
    private String psportletid;
    @Column(name="psportletname")
    private String psportletname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSPFPluginLock = new Integer(1);
    private PSPFPlugin pspfplugin = null;

    public void setBaseClsParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBaseClsParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.baseclsparams = string;
        this.baseclsparamsDirtyFlag = true;
    }

    public String getBaseClsParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBaseClsParams();
        }
        return this.baseclsparams;
    }

    public boolean isBaseClsParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBaseClsParamsDirty();
        }
        return this.baseclsparamsDirtyFlag;
    }

    public void resetBaseClsParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBaseClsParams();
            return;
        }
        this.baseclsparamsDirtyFlag = false;
        this.baseclsparams = null;
    }

    public void setCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename = string;
        this.codenameDirtyFlag = true;
    }

    public String getCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName();
        }
        return this.codename;
    }

    public boolean isCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeNameDirty();
        }
        return this.codenameDirtyFlag;
    }

    public void resetCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName();
            return;
        }
        this.codenameDirtyFlag = false;
        this.codename = null;
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

    public void setPortletType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPortletType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.portlettype = string;
        this.portlettypeDirtyFlag = true;
    }

    public String getPortletType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPortletType();
        }
        return this.portlettype;
    }

    public boolean isPortletTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPortletTypeDirty();
        }
        return this.portlettypeDirtyFlag;
    }

    public void resetPortletType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPortletType();
            return;
        }
        this.portlettypeDirtyFlag = false;
        this.portlettype = null;
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

    public void setPSPortletId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPortletId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psportletid = string;
        this.psportletidDirtyFlag = true;
    }

    public String getPSPortletId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPortletId();
        }
        return this.psportletid;
    }

    public boolean isPSPortletIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPortletIdDirty();
        }
        return this.psportletidDirtyFlag;
    }

    public void resetPSPortletId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPortletId();
            return;
        }
        this.psportletidDirtyFlag = false;
        this.psportletid = null;
    }

    public void setPSPortletName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPortletName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psportletname = string;
        this.psportletnameDirtyFlag = true;
    }

    public String getPSPortletName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPortletName();
        }
        return this.psportletname;
    }

    public boolean isPSPortletNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPortletNameDirty();
        }
        return this.psportletnameDirtyFlag;
    }

    public void resetPSPortletName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPortletName();
            return;
        }
        this.psportletnameDirtyFlag = false;
        this.psportletname = null;
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

    protected void onReset() {
        PSPortletBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPortletBase pSPortletBase) {
        pSPortletBase.resetBaseClsParams();
        pSPortletBase.resetCodeName();
        pSPortletBase.resetCreateDate();
        pSPortletBase.resetCreateMan();
        pSPortletBase.resetMemo();
        pSPortletBase.resetPortletType();
        pSPortletBase.resetPSPFPluginId();
        pSPortletBase.resetPSPFPluginName();
        pSPortletBase.resetPSPortletId();
        pSPortletBase.resetPSPortletName();
        pSPortletBase.resetUpdateDate();
        pSPortletBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBaseClsParamsDirty()) {
            hashMap.put(FIELD_BASECLSPARAMS, this.getBaseClsParams());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
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
        if (!bl || this.isPortletTypeDirty()) {
            hashMap.put(FIELD_PORTLETTYPE, this.getPortletType());
        }
        if (!bl || this.isPSPFPluginIdDirty()) {
            hashMap.put(FIELD_PSPFPLUGINID, this.getPSPFPluginId());
        }
        if (!bl || this.isPSPFPluginNameDirty()) {
            hashMap.put(FIELD_PSPFPLUGINNAME, this.getPSPFPluginName());
        }
        if (!bl || this.isPSPortletIdDirty()) {
            hashMap.put(FIELD_PSPORTLETID, this.getPSPortletId());
        }
        if (!bl || this.isPSPortletNameDirty()) {
            hashMap.put(FIELD_PSPORTLETNAME, this.getPSPortletName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSPortletBase.get(this, n);
    }

    private static Object get(PSPortletBase pSPortletBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPortletBase.getBaseClsParams();
            }
            case 1: {
                return pSPortletBase.getCodeName();
            }
            case 2: {
                return pSPortletBase.getCreateDate();
            }
            case 3: {
                return pSPortletBase.getCreateMan();
            }
            case 4: {
                return pSPortletBase.getMemo();
            }
            case 5: {
                return pSPortletBase.getPortletType();
            }
            case 6: {
                return pSPortletBase.getPSPFPluginId();
            }
            case 7: {
                return pSPortletBase.getPSPFPluginName();
            }
            case 8: {
                return pSPortletBase.getPSPortletId();
            }
            case 9: {
                return pSPortletBase.getPSPortletName();
            }
            case 10: {
                return pSPortletBase.getUpdateDate();
            }
            case 11: {
                return pSPortletBase.getUpdateMan();
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
        PSPortletBase.set(this, n, object);
    }

    private static void set(PSPortletBase pSPortletBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPortletBase.setBaseClsParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSPortletBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSPortletBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSPortletBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPortletBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPortletBase.setPortletType(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPortletBase.setPSPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPortletBase.setPSPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPortletBase.setPSPortletId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSPortletBase.setPSPortletName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSPortletBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSPortletBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSPortletBase.isNull(this, n);
    }

    private static boolean isNull(PSPortletBase pSPortletBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPortletBase.getBaseClsParams() == null;
            }
            case 1: {
                return pSPortletBase.getCodeName() == null;
            }
            case 2: {
                return pSPortletBase.getCreateDate() == null;
            }
            case 3: {
                return pSPortletBase.getCreateMan() == null;
            }
            case 4: {
                return pSPortletBase.getMemo() == null;
            }
            case 5: {
                return pSPortletBase.getPortletType() == null;
            }
            case 6: {
                return pSPortletBase.getPSPFPluginId() == null;
            }
            case 7: {
                return pSPortletBase.getPSPFPluginName() == null;
            }
            case 8: {
                return pSPortletBase.getPSPortletId() == null;
            }
            case 9: {
                return pSPortletBase.getPSPortletName() == null;
            }
            case 10: {
                return pSPortletBase.getUpdateDate() == null;
            }
            case 11: {
                return pSPortletBase.getUpdateMan() == null;
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
        return PSPortletBase.contains(this, n);
    }

    private static boolean contains(PSPortletBase pSPortletBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPortletBase.isBaseClsParamsDirty();
            }
            case 1: {
                return pSPortletBase.isCodeNameDirty();
            }
            case 2: {
                return pSPortletBase.isCreateDateDirty();
            }
            case 3: {
                return pSPortletBase.isCreateManDirty();
            }
            case 4: {
                return pSPortletBase.isMemoDirty();
            }
            case 5: {
                return pSPortletBase.isPortletTypeDirty();
            }
            case 6: {
                return pSPortletBase.isPSPFPluginIdDirty();
            }
            case 7: {
                return pSPortletBase.isPSPFPluginNameDirty();
            }
            case 8: {
                return pSPortletBase.isPSPortletIdDirty();
            }
            case 9: {
                return pSPortletBase.isPSPortletNameDirty();
            }
            case 10: {
                return pSPortletBase.isUpdateDateDirty();
            }
            case 11: {
                return pSPortletBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPortletBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPortletBase pSPortletBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPortletBase.getBaseClsParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"baseclsparams", (Object)PSPortletBase.getJSONValue((Object)pSPortletBase.getBaseClsParams()), (boolean)false);
        }
        if (bl || pSPortletBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSPortletBase.getJSONValue((Object)pSPortletBase.getCodeName()), (boolean)false);
        }
        if (bl || pSPortletBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPortletBase.getJSONValue((Object)pSPortletBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPortletBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPortletBase.getJSONValue((Object)pSPortletBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPortletBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPortletBase.getJSONValue((Object)pSPortletBase.getMemo()), (boolean)false);
        }
        if (bl || pSPortletBase.getPortletType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"portlettype", (Object)PSPortletBase.getJSONValue((Object)pSPortletBase.getPortletType()), (boolean)false);
        }
        if (bl || pSPortletBase.getPSPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpluginid", (Object)PSPortletBase.getJSONValue((Object)pSPortletBase.getPSPFPluginId()), (boolean)false);
        }
        if (bl || pSPortletBase.getPSPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpluginname", (Object)PSPortletBase.getJSONValue((Object)pSPortletBase.getPSPFPluginName()), (boolean)false);
        }
        if (bl || pSPortletBase.getPSPortletId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psportletid", (Object)PSPortletBase.getJSONValue((Object)pSPortletBase.getPSPortletId()), (boolean)false);
        }
        if (bl || pSPortletBase.getPSPortletName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psportletname", (Object)PSPortletBase.getJSONValue((Object)pSPortletBase.getPSPortletName()), (boolean)false);
        }
        if (bl || pSPortletBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPortletBase.getJSONValue((Object)pSPortletBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPortletBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPortletBase.getJSONValue((Object)pSPortletBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPortletBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPortletBase pSPortletBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPortletBase.getBaseClsParams() != null) {
            object = pSPortletBase.getBaseClsParams();
            xmlNode.setAttribute(FIELD_BASECLSPARAMS, (String)(object == null ? "" : object));
        }
        if (bl || pSPortletBase.getCodeName() != null) {
            object = pSPortletBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPortletBase.getCreateDate() != null) {
            object = pSPortletBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPortletBase.getCreateMan() != null) {
            object = pSPortletBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPortletBase.getMemo() != null) {
            object = pSPortletBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPortletBase.getPortletType() != null) {
            object = pSPortletBase.getPortletType();
            xmlNode.setAttribute(FIELD_PORTLETTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSPortletBase.getPSPFPluginId() != null) {
            object = pSPortletBase.getPSPFPluginId();
            xmlNode.setAttribute(FIELD_PSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSPortletBase.getPSPFPluginName() != null) {
            object = pSPortletBase.getPSPFPluginName();
            xmlNode.setAttribute(FIELD_PSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPortletBase.getPSPortletId() != null) {
            object = pSPortletBase.getPSPortletId();
            xmlNode.setAttribute(FIELD_PSPORTLETID, object == null ? "" : (String)object);
        }
        if (bl || pSPortletBase.getPSPortletName() != null) {
            object = pSPortletBase.getPSPortletName();
            xmlNode.setAttribute(FIELD_PSPORTLETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPortletBase.getUpdateDate() != null) {
            object = pSPortletBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPortletBase.getUpdateMan() != null) {
            object = pSPortletBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPortletBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPortletBase pSPortletBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPortletBase.isBaseClsParamsDirty() && (bl || pSPortletBase.getBaseClsParams() != null)) {
            iDataObject.set(FIELD_BASECLSPARAMS, (Object)pSPortletBase.getBaseClsParams());
        }
        if (pSPortletBase.isCodeNameDirty() && (bl || pSPortletBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSPortletBase.getCodeName());
        }
        if (pSPortletBase.isCreateDateDirty() && (bl || pSPortletBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPortletBase.getCreateDate());
        }
        if (pSPortletBase.isCreateManDirty() && (bl || pSPortletBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPortletBase.getCreateMan());
        }
        if (pSPortletBase.isMemoDirty() && (bl || pSPortletBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPortletBase.getMemo());
        }
        if (pSPortletBase.isPortletTypeDirty() && (bl || pSPortletBase.getPortletType() != null)) {
            iDataObject.set(FIELD_PORTLETTYPE, (Object)pSPortletBase.getPortletType());
        }
        if (pSPortletBase.isPSPFPluginIdDirty() && (bl || pSPortletBase.getPSPFPluginId() != null)) {
            iDataObject.set(FIELD_PSPFPLUGINID, (Object)pSPortletBase.getPSPFPluginId());
        }
        if (pSPortletBase.isPSPFPluginNameDirty() && (bl || pSPortletBase.getPSPFPluginName() != null)) {
            iDataObject.set(FIELD_PSPFPLUGINNAME, (Object)pSPortletBase.getPSPFPluginName());
        }
        if (pSPortletBase.isPSPortletIdDirty() && (bl || pSPortletBase.getPSPortletId() != null)) {
            iDataObject.set(FIELD_PSPORTLETID, (Object)pSPortletBase.getPSPortletId());
        }
        if (pSPortletBase.isPSPortletNameDirty() && (bl || pSPortletBase.getPSPortletName() != null)) {
            iDataObject.set(FIELD_PSPORTLETNAME, (Object)pSPortletBase.getPSPortletName());
        }
        if (pSPortletBase.isUpdateDateDirty() && (bl || pSPortletBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPortletBase.getUpdateDate());
        }
        if (pSPortletBase.isUpdateManDirty() && (bl || pSPortletBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPortletBase.getUpdateMan());
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
        return PSPortletBase.remove(this, n);
    }

    private static boolean remove(PSPortletBase pSPortletBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPortletBase.resetBaseClsParams();
                return true;
            }
            case 1: {
                pSPortletBase.resetCodeName();
                return true;
            }
            case 2: {
                pSPortletBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSPortletBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSPortletBase.resetMemo();
                return true;
            }
            case 5: {
                pSPortletBase.resetPortletType();
                return true;
            }
            case 6: {
                pSPortletBase.resetPSPFPluginId();
                return true;
            }
            case 7: {
                pSPortletBase.resetPSPFPluginName();
                return true;
            }
            case 8: {
                pSPortletBase.resetPSPortletId();
                return true;
            }
            case 9: {
                pSPortletBase.resetPSPortletName();
                return true;
            }
            case 10: {
                pSPortletBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSPortletBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
                pSPFPluginService.autoGet(pSPFPlugin);
                this.pspfplugin = pSPFPlugin;
            }
            return this.pspfplugin;
        }
    }

    private PSPortletBase getProxyEntity() {
        return this.proxyPSPortletBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPortletBase = null;
        if (iDataObject != null && iDataObject instanceof PSPortletBase) {
            this.proxyPSPortletBase = (PSPortletBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPortletService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BASECLSPARAMS, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PORTLETTYPE, 5);
        fieldIndexMap.put(FIELD_PSPFPLUGINID, 6);
        fieldIndexMap.put(FIELD_PSPFPLUGINNAME, 7);
        fieldIndexMap.put(FIELD_PSPORTLETID, 8);
        fieldIndexMap.put(FIELD_PSPORTLETNAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
    }
}

