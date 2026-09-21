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
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class SystemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(SystemBase.class);
    public static final String FIELD_AURLOGINADDR = "AURLOGINADDR";
    public static final String FIELD_AURLOGOUTADDR = "AURLOGOUTADDR";
    public static final String FIELD_BIGICON = "BIGICON";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FUNLIC = "FUNLIC";
    public static final String FIELD_SERVICE = "SERVICE";
    public static final String FIELD_SYSTEMADDR = "SYSTEMADDR";
    public static final String FIELD_SYSTEMFUN = "SYSTEMFUN";
    public static final String FIELD_SYSTEMID = "SYSTEMID";
    public static final String FIELD_SYSTEMNAME = "SYSTEMNAME";
    public static final String FIELD_SYSTEMPARAM = "SYSTEMPARAM";
    public static final String FIELD_SYSTEMTYPE = "SYSTEMTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_AURLOGINADDR = 0;
    private static final int INDEX_AURLOGOUTADDR = 1;
    private static final int INDEX_BIGICON = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_FUNLIC = 5;
    private static final int INDEX_SERVICE = 6;
    private static final int INDEX_SYSTEMADDR = 7;
    private static final int INDEX_SYSTEMFUN = 8;
    private static final int INDEX_SYSTEMID = 9;
    private static final int INDEX_SYSTEMNAME = 10;
    private static final int INDEX_SYSTEMPARAM = 11;
    private static final int INDEX_SYSTEMTYPE = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private SystemBase proxySystemBase = null;
    private boolean aurloginaddrDirtyFlag = false;
    private boolean aurlogoutaddrDirtyFlag = false;
    private boolean bigiconDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean funlicDirtyFlag = false;
    private boolean serviceDirtyFlag = false;
    private boolean systemaddrDirtyFlag = false;
    private boolean systemfunDirtyFlag = false;
    private boolean systemidDirtyFlag = false;
    private boolean systemnameDirtyFlag = false;
    private boolean systemparamDirtyFlag = false;
    private boolean systemtypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="aurloginaddr")
    private String aurloginaddr;
    @Column(name="aurlogoutaddr")
    private String aurlogoutaddr;
    @Column(name="bigicon")
    private String bigicon;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="funlic")
    private String funlic;
    @Column(name="service")
    private String service;
    @Column(name="systemaddr")
    private String systemaddr;
    @Column(name="systemfun")
    private Integer systemfun;
    @Column(name="systemid")
    private String systemid;
    @Column(name="systemname")
    private String systemname;
    @Column(name="systemparam")
    private String systemparam;
    @Column(name="systemtype")
    private String systemtype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

    static {
        fieldIndexMap.put(FIELD_AURLOGINADDR, 0);
        fieldIndexMap.put(FIELD_AURLOGOUTADDR, 1);
        fieldIndexMap.put(FIELD_BIGICON, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_FUNLIC, 5);
        fieldIndexMap.put(FIELD_SERVICE, 6);
        fieldIndexMap.put(FIELD_SYSTEMADDR, 7);
        fieldIndexMap.put(FIELD_SYSTEMFUN, 8);
        fieldIndexMap.put(FIELD_SYSTEMID, 9);
        fieldIndexMap.put(FIELD_SYSTEMNAME, 10);
        fieldIndexMap.put(FIELD_SYSTEMPARAM, 11);
        fieldIndexMap.put(FIELD_SYSTEMTYPE, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
    }

    public void setAURLoginAddr(String aurloginaddr) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAURLoginAddr(aurloginaddr);
            return;
        }
        if (aurloginaddr != null && (aurloginaddr = StringHelper.trimRight(aurloginaddr)).length() == 0) {
            aurloginaddr = null;
        }
        this.aurloginaddr = aurloginaddr;
        this.aurloginaddrDirtyFlag = true;
    }

    public String getAURLoginAddr() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAURLoginAddr();
        }
        return this.aurloginaddr;
    }

    public boolean isAURLoginAddrDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAURLoginAddrDirty();
        }
        return this.aurloginaddrDirtyFlag;
    }

    public void resetAURLoginAddr() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAURLoginAddr();
            return;
        }
        this.aurloginaddrDirtyFlag = false;
        this.aurloginaddr = null;
    }

    public void setAURLogoutAddr(String aurlogoutaddr) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAURLogoutAddr(aurlogoutaddr);
            return;
        }
        if (aurlogoutaddr != null && (aurlogoutaddr = StringHelper.trimRight(aurlogoutaddr)).length() == 0) {
            aurlogoutaddr = null;
        }
        this.aurlogoutaddr = aurlogoutaddr;
        this.aurlogoutaddrDirtyFlag = true;
    }

    public String getAURLogoutAddr() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAURLogoutAddr();
        }
        return this.aurlogoutaddr;
    }

    public boolean isAURLogoutAddrDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAURLogoutAddrDirty();
        }
        return this.aurlogoutaddrDirtyFlag;
    }

    public void resetAURLogoutAddr() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAURLogoutAddr();
            return;
        }
        this.aurlogoutaddrDirtyFlag = false;
        this.aurlogoutaddr = null;
    }

    public void setBigIcon(String bigicon) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBigIcon(bigicon);
            return;
        }
        if (bigicon != null && (bigicon = StringHelper.trimRight(bigicon)).length() == 0) {
            bigicon = null;
        }
        this.bigicon = bigicon;
        this.bigiconDirtyFlag = true;
    }

    public String getBigIcon() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBigIcon();
        }
        return this.bigicon;
    }

    public boolean isBigIconDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBigIconDirty();
        }
        return this.bigiconDirtyFlag;
    }

    public void resetBigIcon() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBigIcon();
            return;
        }
        this.bigiconDirtyFlag = false;
        this.bigicon = null;
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

    public void setFunLic(String funlic) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFunLic(funlic);
            return;
        }
        if (funlic != null && (funlic = StringHelper.trimRight(funlic)).length() == 0) {
            funlic = null;
        }
        this.funlic = funlic;
        this.funlicDirtyFlag = true;
    }

    public String getFunLic() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFunLic();
        }
        return this.funlic;
    }

    public boolean isFunLicDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFunLicDirty();
        }
        return this.funlicDirtyFlag;
    }

    public void resetFunLic() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFunLic();
            return;
        }
        this.funlicDirtyFlag = false;
        this.funlic = null;
    }

    public void setService(String service) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setService(service);
            return;
        }
        if (service != null && (service = StringHelper.trimRight(service)).length() == 0) {
            service = null;
        }
        this.service = service;
        this.serviceDirtyFlag = true;
    }

    public String getService() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getService();
        }
        return this.service;
    }

    public boolean isServiceDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceDirty();
        }
        return this.serviceDirtyFlag;
    }

    public void resetService() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetService();
            return;
        }
        this.serviceDirtyFlag = false;
        this.service = null;
    }

    public void setSystemAddr(String systemaddr) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSystemAddr(systemaddr);
            return;
        }
        if (systemaddr != null && (systemaddr = StringHelper.trimRight(systemaddr)).length() == 0) {
            systemaddr = null;
        }
        this.systemaddr = systemaddr;
        this.systemaddrDirtyFlag = true;
    }

    public String getSystemAddr() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSystemAddr();
        }
        return this.systemaddr;
    }

    public boolean isSystemAddrDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSystemAddrDirty();
        }
        return this.systemaddrDirtyFlag;
    }

    public void resetSystemAddr() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSystemAddr();
            return;
        }
        this.systemaddrDirtyFlag = false;
        this.systemaddr = null;
    }

    public void setSystemFun(Integer systemfun) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSystemFun(systemfun);
            return;
        }
        this.systemfun = systemfun;
        this.systemfunDirtyFlag = true;
    }

    public Integer getSystemFun() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSystemFun();
        }
        return this.systemfun;
    }

    public boolean isSystemFunDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSystemFunDirty();
        }
        return this.systemfunDirtyFlag;
    }

    public void resetSystemFun() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSystemFun();
            return;
        }
        this.systemfunDirtyFlag = false;
        this.systemfun = null;
    }

    public void setSystemId(String systemid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSystemId(systemid);
            return;
        }
        if (systemid != null && (systemid = StringHelper.trimRight(systemid)).length() == 0) {
            systemid = null;
        }
        this.systemid = systemid;
        this.systemidDirtyFlag = true;
    }

    public String getSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSystemId();
        }
        return this.systemid;
    }

    public boolean isSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSystemIdDirty();
        }
        return this.systemidDirtyFlag;
    }

    public void resetSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSystemId();
            return;
        }
        this.systemidDirtyFlag = false;
        this.systemid = null;
    }

    public void setSystemName(String systemname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSystemName(systemname);
            return;
        }
        if (systemname != null && (systemname = StringHelper.trimRight(systemname)).length() == 0) {
            systemname = null;
        }
        this.systemname = systemname;
        this.systemnameDirtyFlag = true;
    }

    public String getSystemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSystemName();
        }
        return this.systemname;
    }

    public boolean isSystemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSystemNameDirty();
        }
        return this.systemnameDirtyFlag;
    }

    public void resetSystemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSystemName();
            return;
        }
        this.systemnameDirtyFlag = false;
        this.systemname = null;
    }

    public void setSystemParam(String systemparam) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSystemParam(systemparam);
            return;
        }
        if (systemparam != null && (systemparam = StringHelper.trimRight(systemparam)).length() == 0) {
            systemparam = null;
        }
        this.systemparam = systemparam;
        this.systemparamDirtyFlag = true;
    }

    public String getSystemParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSystemParam();
        }
        return this.systemparam;
    }

    public boolean isSystemParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSystemParamDirty();
        }
        return this.systemparamDirtyFlag;
    }

    public void resetSystemParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSystemParam();
            return;
        }
        this.systemparamDirtyFlag = false;
        this.systemparam = null;
    }

    public void setSystemType(String systemtype) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSystemType(systemtype);
            return;
        }
        if (systemtype != null && (systemtype = StringHelper.trimRight(systemtype)).length() == 0) {
            systemtype = null;
        }
        this.systemtype = systemtype;
        this.systemtypeDirtyFlag = true;
    }

    public String getSystemType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSystemType();
        }
        return this.systemtype;
    }

    public boolean isSystemTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSystemTypeDirty();
        }
        return this.systemtypeDirtyFlag;
    }

    public void resetSystemType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSystemType();
            return;
        }
        this.systemtypeDirtyFlag = false;
        this.systemtype = null;
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
        SystemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(SystemBase et) {
        et.resetAURLoginAddr();
        et.resetAURLogoutAddr();
        et.resetBigIcon();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetFunLic();
        et.resetService();
        et.resetSystemAddr();
        et.resetSystemFun();
        et.resetSystemId();
        et.resetSystemName();
        et.resetSystemParam();
        et.resetSystemType();
        et.resetUpdateDate();
        et.resetUpdateMan();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isAURLoginAddrDirty()) {
            params.put(FIELD_AURLOGINADDR, this.getAURLoginAddr());
        }
        if (!bDirtyOnly || this.isAURLogoutAddrDirty()) {
            params.put(FIELD_AURLOGOUTADDR, this.getAURLogoutAddr());
        }
        if (!bDirtyOnly || this.isBigIconDirty()) {
            params.put(FIELD_BIGICON, this.getBigIcon());
        }
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isFunLicDirty()) {
            params.put(FIELD_FUNLIC, this.getFunLic());
        }
        if (!bDirtyOnly || this.isServiceDirty()) {
            params.put(FIELD_SERVICE, this.getService());
        }
        if (!bDirtyOnly || this.isSystemAddrDirty()) {
            params.put(FIELD_SYSTEMADDR, this.getSystemAddr());
        }
        if (!bDirtyOnly || this.isSystemFunDirty()) {
            params.put(FIELD_SYSTEMFUN, this.getSystemFun());
        }
        if (!bDirtyOnly || this.isSystemIdDirty()) {
            params.put(FIELD_SYSTEMID, this.getSystemId());
        }
        if (!bDirtyOnly || this.isSystemNameDirty()) {
            params.put(FIELD_SYSTEMNAME, this.getSystemName());
        }
        if (!bDirtyOnly || this.isSystemParamDirty()) {
            params.put(FIELD_SYSTEMPARAM, this.getSystemParam());
        }
        if (!bDirtyOnly || this.isSystemTypeDirty()) {
            params.put(FIELD_SYSTEMTYPE, this.getSystemType());
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
        return SystemBase.get(this, index);
    }

    private static Object get(SystemBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getAURLoginAddr();
            }
            case 1: {
                return et.getAURLogoutAddr();
            }
            case 2: {
                return et.getBigIcon();
            }
            case 3: {
                return et.getCreateDate();
            }
            case 4: {
                return et.getCreateMan();
            }
            case 5: {
                return et.getFunLic();
            }
            case 6: {
                return et.getService();
            }
            case 7: {
                return et.getSystemAddr();
            }
            case 8: {
                return et.getSystemFun();
            }
            case 9: {
                return et.getSystemId();
            }
            case 10: {
                return et.getSystemName();
            }
            case 11: {
                return et.getSystemParam();
            }
            case 12: {
                return et.getSystemType();
            }
            case 13: {
                return et.getUpdateDate();
            }
            case 14: {
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
        SystemBase.set(this, index, objValue);
    }

    private static void set(SystemBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setAURLoginAddr(DataObject.getStringValue(obj));
                return;
            }
            case 1: {
                et.setAURLogoutAddr(DataObject.getStringValue(obj));
                return;
            }
            case 2: {
                et.setBigIcon(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 4: {
                et.setCreateMan(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setFunLic(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setService(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setSystemAddr(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setSystemFun(DataObject.getIntegerValue(obj));
                return;
            }
            case 9: {
                et.setSystemId(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setSystemName(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setSystemParam(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setSystemType(DataObject.getStringValue(obj));
                return;
            }
            case 13: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 14: {
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
        return SystemBase.isNull(this, index);
    }

    private static boolean isNull(SystemBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getAURLoginAddr() == null;
            }
            case 1: {
                return et.getAURLogoutAddr() == null;
            }
            case 2: {
                return et.getBigIcon() == null;
            }
            case 3: {
                return et.getCreateDate() == null;
            }
            case 4: {
                return et.getCreateMan() == null;
            }
            case 5: {
                return et.getFunLic() == null;
            }
            case 6: {
                return et.getService() == null;
            }
            case 7: {
                return et.getSystemAddr() == null;
            }
            case 8: {
                return et.getSystemFun() == null;
            }
            case 9: {
                return et.getSystemId() == null;
            }
            case 10: {
                return et.getSystemName() == null;
            }
            case 11: {
                return et.getSystemParam() == null;
            }
            case 12: {
                return et.getSystemType() == null;
            }
            case 13: {
                return et.getUpdateDate() == null;
            }
            case 14: {
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
        return SystemBase.contains(this, index);
    }

    private static boolean contains(SystemBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isAURLoginAddrDirty();
            }
            case 1: {
                return et.isAURLogoutAddrDirty();
            }
            case 2: {
                return et.isBigIconDirty();
            }
            case 3: {
                return et.isCreateDateDirty();
            }
            case 4: {
                return et.isCreateManDirty();
            }
            case 5: {
                return et.isFunLicDirty();
            }
            case 6: {
                return et.isServiceDirty();
            }
            case 7: {
                return et.isSystemAddrDirty();
            }
            case 8: {
                return et.isSystemFunDirty();
            }
            case 9: {
                return et.isSystemIdDirty();
            }
            case 10: {
                return et.isSystemNameDirty();
            }
            case 11: {
                return et.isSystemParamDirty();
            }
            case 12: {
                return et.isSystemTypeDirty();
            }
            case 13: {
                return et.isUpdateDateDirty();
            }
            case 14: {
                return et.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        SystemBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(SystemBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getAURLoginAddr() != null) {
            JSONObjectHelper.put(json, "aurloginaddr", SystemBase.getJSONValue(et.getAURLoginAddr()), false);
        }
        if (bIncEmpty || et.getAURLogoutAddr() != null) {
            JSONObjectHelper.put(json, "aurlogoutaddr", SystemBase.getJSONValue(et.getAURLogoutAddr()), false);
        }
        if (bIncEmpty || et.getBigIcon() != null) {
            JSONObjectHelper.put(json, "bigicon", SystemBase.getJSONValue(et.getBigIcon()), false);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", SystemBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", SystemBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getFunLic() != null) {
            JSONObjectHelper.put(json, "funlic", SystemBase.getJSONValue(et.getFunLic()), false);
        }
        if (bIncEmpty || et.getService() != null) {
            JSONObjectHelper.put(json, "service", SystemBase.getJSONValue(et.getService()), false);
        }
        if (bIncEmpty || et.getSystemAddr() != null) {
            JSONObjectHelper.put(json, "systemaddr", SystemBase.getJSONValue(et.getSystemAddr()), false);
        }
        if (bIncEmpty || et.getSystemFun() != null) {
            JSONObjectHelper.put(json, "systemfun", SystemBase.getJSONValue(et.getSystemFun()), false);
        }
        if (bIncEmpty || et.getSystemId() != null) {
            JSONObjectHelper.put(json, "systemid", SystemBase.getJSONValue(et.getSystemId()), false);
        }
        if (bIncEmpty || et.getSystemName() != null) {
            JSONObjectHelper.put(json, "systemname", SystemBase.getJSONValue(et.getSystemName()), false);
        }
        if (bIncEmpty || et.getSystemParam() != null) {
            JSONObjectHelper.put(json, "systemparam", SystemBase.getJSONValue(et.getSystemParam()), false);
        }
        if (bIncEmpty || et.getSystemType() != null) {
            JSONObjectHelper.put(json, "systemtype", SystemBase.getJSONValue(et.getSystemType()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", SystemBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", SystemBase.getJSONValue(et.getUpdateMan()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        SystemBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(SystemBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getAURLoginAddr() != null) {
            obj = et.getAURLoginAddr();
            node.setAttribute(FIELD_AURLOGINADDR, (String)(obj == null ? "" : obj));
        }
        if (bIncEmpty || et.getAURLogoutAddr() != null) {
            obj = et.getAURLogoutAddr();
            node.setAttribute(FIELD_AURLOGOUTADDR, (String)(obj == null ? "" : obj));
        }
        if (bIncEmpty || et.getBigIcon() != null) {
            obj = et.getBigIcon();
            node.setAttribute(FIELD_BIGICON, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getFunLic() != null) {
            obj = et.getFunLic();
            node.setAttribute(FIELD_FUNLIC, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getService() != null) {
            obj = et.getService();
            node.setAttribute(FIELD_SERVICE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getSystemAddr() != null) {
            obj = et.getSystemAddr();
            node.setAttribute(FIELD_SYSTEMADDR, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getSystemFun() != null) {
            obj = et.getSystemFun();
            node.setAttribute(FIELD_SYSTEMFUN, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getSystemId() != null) {
            obj = et.getSystemId();
            node.setAttribute(FIELD_SYSTEMID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getSystemName() != null) {
            obj = et.getSystemName();
            node.setAttribute(FIELD_SYSTEMNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getSystemParam() != null) {
            obj = et.getSystemParam();
            node.setAttribute(FIELD_SYSTEMPARAM, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getSystemType() != null) {
            obj = et.getSystemType();
            node.setAttribute(FIELD_SYSTEMTYPE, obj == null ? "" : (String)obj);
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
        SystemBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(SystemBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isAURLoginAddrDirty() && (bIncEmpty || et.getAURLoginAddr() != null)) {
            dst.set(FIELD_AURLOGINADDR, et.getAURLoginAddr());
        }
        if (et.isAURLogoutAddrDirty() && (bIncEmpty || et.getAURLogoutAddr() != null)) {
            dst.set(FIELD_AURLOGOUTADDR, et.getAURLogoutAddr());
        }
        if (et.isBigIconDirty() && (bIncEmpty || et.getBigIcon() != null)) {
            dst.set(FIELD_BIGICON, et.getBigIcon());
        }
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isFunLicDirty() && (bIncEmpty || et.getFunLic() != null)) {
            dst.set(FIELD_FUNLIC, et.getFunLic());
        }
        if (et.isServiceDirty() && (bIncEmpty || et.getService() != null)) {
            dst.set(FIELD_SERVICE, et.getService());
        }
        if (et.isSystemAddrDirty() && (bIncEmpty || et.getSystemAddr() != null)) {
            dst.set(FIELD_SYSTEMADDR, et.getSystemAddr());
        }
        if (et.isSystemFunDirty() && (bIncEmpty || et.getSystemFun() != null)) {
            dst.set(FIELD_SYSTEMFUN, et.getSystemFun());
        }
        if (et.isSystemIdDirty() && (bIncEmpty || et.getSystemId() != null)) {
            dst.set(FIELD_SYSTEMID, et.getSystemId());
        }
        if (et.isSystemNameDirty() && (bIncEmpty || et.getSystemName() != null)) {
            dst.set(FIELD_SYSTEMNAME, et.getSystemName());
        }
        if (et.isSystemParamDirty() && (bIncEmpty || et.getSystemParam() != null)) {
            dst.set(FIELD_SYSTEMPARAM, et.getSystemParam());
        }
        if (et.isSystemTypeDirty() && (bIncEmpty || et.getSystemType() != null)) {
            dst.set(FIELD_SYSTEMTYPE, et.getSystemType());
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
        return SystemBase.remove(this, index);
    }

    private static boolean remove(SystemBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetAURLoginAddr();
                return true;
            }
            case 1: {
                et.resetAURLogoutAddr();
                return true;
            }
            case 2: {
                et.resetBigIcon();
                return true;
            }
            case 3: {
                et.resetCreateDate();
                return true;
            }
            case 4: {
                et.resetCreateMan();
                return true;
            }
            case 5: {
                et.resetFunLic();
                return true;
            }
            case 6: {
                et.resetService();
                return true;
            }
            case 7: {
                et.resetSystemAddr();
                return true;
            }
            case 8: {
                et.resetSystemFun();
                return true;
            }
            case 9: {
                et.resetSystemId();
                return true;
            }
            case 10: {
                et.resetSystemName();
                return true;
            }
            case 11: {
                et.resetSystemParam();
                return true;
            }
            case 12: {
                et.resetSystemType();
                return true;
            }
            case 13: {
                et.resetUpdateDate();
                return true;
            }
            case 14: {
                et.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private SystemBase getProxyEntity() {
        return this.proxySystemBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxySystemBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof SystemBase) {
            this.proxySystemBase = (SystemBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.SystemService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

