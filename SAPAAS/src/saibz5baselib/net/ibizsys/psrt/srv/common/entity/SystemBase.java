/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.entity;


import java.io.Serializable;
import java.util.HashMap;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;

import java.sql.Timestamp;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.paas.service.ServiceGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 实体[System] 数据对象基类
 */
public abstract class SystemBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(SystemBase.class);
    /**
     * 属性[认证请求地址]
     */
    public final static String FIELD_AURLOGINADDR = "AURLOGINADDR";
    /**
     * 属性[认证注销地址]
     */
    public final static String FIELD_AURLOGOUTADDR = "AURLOGOUTADDR";
    /**
     * 属性[图标]
     */
    public final static String FIELD_BIGICON = "BIGICON";
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[集成服务授权码]
     */
    public final static String FIELD_FUNLIC = "FUNLIC";
    /**
     * 属性[厂商备注]
     */
    public final static String FIELD_SERVICE = "SERVICE";
    /**
     * 属性[系统地址]
     */
    public final static String FIELD_SYSTEMADDR = "SYSTEMADDR";
    /**
     * 属性[系统集成功能]
     */
    public final static String FIELD_SYSTEMFUN = "SYSTEMFUN";
    /**
     * 属性[系统标识]
     */
    public final static String FIELD_SYSTEMID = "SYSTEMID";
    /**
     * 属性[系统名称]
     */
    public final static String FIELD_SYSTEMNAME = "SYSTEMNAME";
    /**
     * 属性[系统参数]
     */
    public final static String FIELD_SYSTEMPARAM = "SYSTEMPARAM";
    /**
     * 属性[系统类型]
     */
    public final static String FIELD_SYSTEMTYPE = "SYSTEMTYPE";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";

    private final static int INDEX_AURLOGINADDR = 0;
    private final static int INDEX_AURLOGOUTADDR = 1;
    private final static int INDEX_BIGICON = 2;
    private final static int INDEX_CREATEDATE = 3;
    private final static int INDEX_CREATEMAN = 4;
    private final static int INDEX_FUNLIC = 5;
    private final static int INDEX_SERVICE = 6;
    private final static int INDEX_SYSTEMADDR = 7;
    private final static int INDEX_SYSTEMFUN = 8;
    private final static int INDEX_SYSTEMID = 9;
    private final static int INDEX_SYSTEMNAME = 10;
    private final static int INDEX_SYSTEMPARAM = 11;
    private final static int INDEX_SYSTEMTYPE = 12;
    private final static int INDEX_UPDATEDATE = 13;
    private final static int INDEX_UPDATEMAN = 14;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_AURLOGINADDR, INDEX_AURLOGINADDR);
        fieldIndexMap.put( FIELD_AURLOGOUTADDR, INDEX_AURLOGOUTADDR);
        fieldIndexMap.put( FIELD_BIGICON, INDEX_BIGICON);
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_FUNLIC, INDEX_FUNLIC);
        fieldIndexMap.put( FIELD_SERVICE, INDEX_SERVICE);
        fieldIndexMap.put( FIELD_SYSTEMADDR, INDEX_SYSTEMADDR);
        fieldIndexMap.put( FIELD_SYSTEMFUN, INDEX_SYSTEMFUN);
        fieldIndexMap.put( FIELD_SYSTEMID, INDEX_SYSTEMID);
        fieldIndexMap.put( FIELD_SYSTEMNAME, INDEX_SYSTEMNAME);
        fieldIndexMap.put( FIELD_SYSTEMPARAM, INDEX_SYSTEMPARAM);
        fieldIndexMap.put( FIELD_SYSTEMTYPE, INDEX_SYSTEMTYPE);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
    }

    private SystemBase proxySystemBase = null;
    public SystemBase() {
        super();
    }
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


    /**
     *  设置属性值[认证请求地址]
     *  @param aurloginaddr
     */
    public void setAURLoginAddr(String aurloginaddr) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setAURLoginAddr(aurloginaddr);
            return;
        }
        if(aurloginaddr!=null) {
            aurloginaddr = StringHelper.trimRight(aurloginaddr);
            if(aurloginaddr.length()==0) {
                aurloginaddr = null;
            }
        }
        this.aurloginaddr = aurloginaddr;
        this.aurloginaddrDirtyFlag  = true;
    }

    /**
     *  获取属性值[认证请求地址]
     */
    public String getAURLoginAddr() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getAURLoginAddr();
        }
        return this.aurloginaddr;
    }

    /**
     *  获取属性值[认证请求地址]是否修改
     */
    public boolean isAURLoginAddrDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isAURLoginAddrDirty();
        }
        return this.aurloginaddrDirtyFlag;
    }

    /**
     *  重置属性值[认证请求地址]
     */
    public void resetAURLoginAddr() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetAURLoginAddr();
            return;
        }

        this.aurloginaddrDirtyFlag = false;
        this.aurloginaddr = null;
    }
    /**
     *  设置属性值[认证注销地址]
     *  @param aurlogoutaddr
     */
    public void setAURLogoutAddr(String aurlogoutaddr) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setAURLogoutAddr(aurlogoutaddr);
            return;
        }
        if(aurlogoutaddr!=null) {
            aurlogoutaddr = StringHelper.trimRight(aurlogoutaddr);
            if(aurlogoutaddr.length()==0) {
                aurlogoutaddr = null;
            }
        }
        this.aurlogoutaddr = aurlogoutaddr;
        this.aurlogoutaddrDirtyFlag  = true;
    }

    /**
     *  获取属性值[认证注销地址]
     */
    public String getAURLogoutAddr() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getAURLogoutAddr();
        }
        return this.aurlogoutaddr;
    }

    /**
     *  获取属性值[认证注销地址]是否修改
     */
    public boolean isAURLogoutAddrDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isAURLogoutAddrDirty();
        }
        return this.aurlogoutaddrDirtyFlag;
    }

    /**
     *  重置属性值[认证注销地址]
     */
    public void resetAURLogoutAddr() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetAURLogoutAddr();
            return;
        }

        this.aurlogoutaddrDirtyFlag = false;
        this.aurlogoutaddr = null;
    }
    /**
     *  设置属性值[图标]
     *  @param bigicon
     */
    public void setBigIcon(String bigicon) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setBigIcon(bigicon);
            return;
        }
        if(bigicon!=null) {
            bigicon = StringHelper.trimRight(bigicon);
            if(bigicon.length()==0) {
                bigicon = null;
            }
        }
        this.bigicon = bigicon;
        this.bigiconDirtyFlag  = true;
    }

    /**
     *  获取属性值[图标]
     */
    public String getBigIcon() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getBigIcon();
        }
        return this.bigicon;
    }

    /**
     *  获取属性值[图标]是否修改
     */
    public boolean isBigIconDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isBigIconDirty();
        }
        return this.bigiconDirtyFlag;
    }

    /**
     *  重置属性值[图标]
     */
    public void resetBigIcon() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetBigIcon();
            return;
        }

        this.bigiconDirtyFlag = false;
        this.bigicon = null;
    }
    /**
     *  设置属性值[建立时间]
     *  @param createdate
     */
    public void setCreateDate(Timestamp createdate) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setCreateDate(createdate);
            return;
        }
        this.createdate = createdate;
        this.createdateDirtyFlag  = true;
    }

    /**
     *  获取属性值[建立时间]
     */
    public Timestamp getCreateDate() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getCreateDate();
        }
        return this.createdate;
    }

    /**
     *  获取属性值[建立时间]是否修改
     */
    public boolean isCreateDateDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isCreateDateDirty();
        }
        return this.createdateDirtyFlag;
    }

    /**
     *  重置属性值[建立时间]
     */
    public void resetCreateDate() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetCreateDate();
            return;
        }

        this.createdateDirtyFlag = false;
        this.createdate = null;
    }
    /**
     *  设置属性值[建立人]代码表：net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel
     *  @param createman
     */
    public void setCreateMan(String createman) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setCreateMan(createman);
            return;
        }
        if(createman!=null) {
            createman = StringHelper.trimRight(createman);
            if(createman.length()==0) {
                createman = null;
            }
        }
        this.createman = createman;
        this.createmanDirtyFlag  = true;
    }

    /**
     *  获取属性值[建立人]代码表：net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel
     */
    public String getCreateMan() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getCreateMan();
        }
        return this.createman;
    }

    /**
     *  获取属性值[建立人]是否修改
     */
    public boolean isCreateManDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isCreateManDirty();
        }
        return this.createmanDirtyFlag;
    }

    /**
     *  重置属性值[建立人]
     */
    public void resetCreateMan() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetCreateMan();
            return;
        }

        this.createmanDirtyFlag = false;
        this.createman = null;
    }
    /**
     *  设置属性值[集成服务授权码]
     *  @param funlic
     */
    public void setFunLic(String funlic) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setFunLic(funlic);
            return;
        }
        if(funlic!=null) {
            funlic = StringHelper.trimRight(funlic);
            if(funlic.length()==0) {
                funlic = null;
            }
        }
        this.funlic = funlic;
        this.funlicDirtyFlag  = true;
    }

    /**
     *  获取属性值[集成服务授权码]
     */
    public String getFunLic() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getFunLic();
        }
        return this.funlic;
    }

    /**
     *  获取属性值[集成服务授权码]是否修改
     */
    public boolean isFunLicDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isFunLicDirty();
        }
        return this.funlicDirtyFlag;
    }

    /**
     *  重置属性值[集成服务授权码]
     */
    public void resetFunLic() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetFunLic();
            return;
        }

        this.funlicDirtyFlag = false;
        this.funlic = null;
    }
    /**
     *  设置属性值[厂商备注]
     *  @param service
     */
    public void setService(String service) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setService(service);
            return;
        }
        if(service!=null) {
            service = StringHelper.trimRight(service);
            if(service.length()==0) {
                service = null;
            }
        }
        this.service = service;
        this.serviceDirtyFlag  = true;
    }

    /**
     *  获取属性值[厂商备注]
     */
    public String getService() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getService();
        }
        return this.service;
    }

    /**
     *  获取属性值[厂商备注]是否修改
     */
    public boolean isServiceDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isServiceDirty();
        }
        return this.serviceDirtyFlag;
    }

    /**
     *  重置属性值[厂商备注]
     */
    public void resetService() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetService();
            return;
        }

        this.serviceDirtyFlag = false;
        this.service = null;
    }
    /**
     *  设置属性值[系统地址]
     *  @param systemaddr
     */
    public void setSystemAddr(String systemaddr) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setSystemAddr(systemaddr);
            return;
        }
        if(systemaddr!=null) {
            systemaddr = StringHelper.trimRight(systemaddr);
            if(systemaddr.length()==0) {
                systemaddr = null;
            }
        }
        this.systemaddr = systemaddr;
        this.systemaddrDirtyFlag  = true;
    }

    /**
     *  获取属性值[系统地址]
     */
    public String getSystemAddr() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getSystemAddr();
        }
        return this.systemaddr;
    }

    /**
     *  获取属性值[系统地址]是否修改
     */
    public boolean isSystemAddrDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isSystemAddrDirty();
        }
        return this.systemaddrDirtyFlag;
    }

    /**
     *  重置属性值[系统地址]
     */
    public void resetSystemAddr() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetSystemAddr();
            return;
        }

        this.systemaddrDirtyFlag = false;
        this.systemaddr = null;
    }
    /**
     *  设置属性值[系统集成功能]代码表：net.ibizsys.psrt.srv.codelist.SystemFuncCodeListModel
     *  @param systemfun
     */
    public void setSystemFun(Integer systemfun) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setSystemFun(systemfun);
            return;
        }
        this.systemfun = systemfun;
        this.systemfunDirtyFlag  = true;
    }

    /**
     *  获取属性值[系统集成功能]代码表：net.ibizsys.psrt.srv.codelist.SystemFuncCodeListModel
     */
    public Integer getSystemFun() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getSystemFun();
        }
        return this.systemfun;
    }

    /**
     *  获取属性值[系统集成功能]是否修改
     */
    public boolean isSystemFunDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isSystemFunDirty();
        }
        return this.systemfunDirtyFlag;
    }

    /**
     *  重置属性值[系统集成功能]
     */
    public void resetSystemFun() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetSystemFun();
            return;
        }

        this.systemfunDirtyFlag = false;
        this.systemfun = null;
    }
    /**
     *  设置属性值[系统标识]
     *  @param systemid
     */
    public void setSystemId(String systemid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setSystemId(systemid);
            return;
        }
        if(systemid!=null) {
            systemid = StringHelper.trimRight(systemid);
            if(systemid.length()==0) {
                systemid = null;
            }
        }
        this.systemid = systemid;
        this.systemidDirtyFlag  = true;
    }

    /**
     *  获取属性值[系统标识]
     */
    public String getSystemId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getSystemId();
        }
        return this.systemid;
    }

    /**
     *  获取属性值[系统标识]是否修改
     */
    public boolean isSystemIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isSystemIdDirty();
        }
        return this.systemidDirtyFlag;
    }

    /**
     *  重置属性值[系统标识]
     */
    public void resetSystemId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetSystemId();
            return;
        }

        this.systemidDirtyFlag = false;
        this.systemid = null;
    }
    /**
     *  设置属性值[系统名称]
     *  @param systemname
     */
    public void setSystemName(String systemname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setSystemName(systemname);
            return;
        }
        if(systemname!=null) {
            systemname = StringHelper.trimRight(systemname);
            if(systemname.length()==0) {
                systemname = null;
            }
        }
        this.systemname = systemname;
        this.systemnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[系统名称]
     */
    public String getSystemName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getSystemName();
        }
        return this.systemname;
    }

    /**
     *  获取属性值[系统名称]是否修改
     */
    public boolean isSystemNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isSystemNameDirty();
        }
        return this.systemnameDirtyFlag;
    }

    /**
     *  重置属性值[系统名称]
     */
    public void resetSystemName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetSystemName();
            return;
        }

        this.systemnameDirtyFlag = false;
        this.systemname = null;
    }
    /**
     *  设置属性值[系统参数]
     *  @param systemparam
     */
    public void setSystemParam(String systemparam) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setSystemParam(systemparam);
            return;
        }
        if(systemparam!=null) {
            systemparam = StringHelper.trimRight(systemparam);
            if(systemparam.length()==0) {
                systemparam = null;
            }
        }
        this.systemparam = systemparam;
        this.systemparamDirtyFlag  = true;
    }

    /**
     *  获取属性值[系统参数]
     */
    public String getSystemParam() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getSystemParam();
        }
        return this.systemparam;
    }

    /**
     *  获取属性值[系统参数]是否修改
     */
    public boolean isSystemParamDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isSystemParamDirty();
        }
        return this.systemparamDirtyFlag;
    }

    /**
     *  重置属性值[系统参数]
     */
    public void resetSystemParam() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetSystemParam();
            return;
        }

        this.systemparamDirtyFlag = false;
        this.systemparam = null;
    }
    /**
     *  设置属性值[系统类型]代码表：net.ibizsys.psrt.srv.codelist.SystemTypeCodeListModel
     *  @param systemtype
     */
    public void setSystemType(String systemtype) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setSystemType(systemtype);
            return;
        }
        if(systemtype!=null) {
            systemtype = StringHelper.trimRight(systemtype);
            if(systemtype.length()==0) {
                systemtype = null;
            }
        }
        this.systemtype = systemtype;
        this.systemtypeDirtyFlag  = true;
    }

    /**
     *  获取属性值[系统类型]代码表：net.ibizsys.psrt.srv.codelist.SystemTypeCodeListModel
     */
    public String getSystemType() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getSystemType();
        }
        return this.systemtype;
    }

    /**
     *  获取属性值[系统类型]是否修改
     */
    public boolean isSystemTypeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isSystemTypeDirty();
        }
        return this.systemtypeDirtyFlag;
    }

    /**
     *  重置属性值[系统类型]
     */
    public void resetSystemType() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetSystemType();
            return;
        }

        this.systemtypeDirtyFlag = false;
        this.systemtype = null;
    }
    /**
     *  设置属性值[更新时间]
     *  @param updatedate
     */
    public void setUpdateDate(Timestamp updatedate) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUpdateDate(updatedate);
            return;
        }
        this.updatedate = updatedate;
        this.updatedateDirtyFlag  = true;
    }

    /**
     *  获取属性值[更新时间]
     */
    public Timestamp getUpdateDate() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUpdateDate();
        }
        return this.updatedate;
    }

    /**
     *  获取属性值[更新时间]是否修改
     */
    public boolean isUpdateDateDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUpdateDateDirty();
        }
        return this.updatedateDirtyFlag;
    }

    /**
     *  重置属性值[更新时间]
     */
    public void resetUpdateDate() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUpdateDate();
            return;
        }

        this.updatedateDirtyFlag = false;
        this.updatedate = null;
    }
    /**
     *  设置属性值[更新人]代码表：net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel
     *  @param updateman
     */
    public void setUpdateMan(String updateman) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUpdateMan(updateman);
            return;
        }
        if(updateman!=null) {
            updateman = StringHelper.trimRight(updateman);
            if(updateman.length()==0) {
                updateman = null;
            }
        }
        this.updateman = updateman;
        this.updatemanDirtyFlag  = true;
    }

    /**
     *  获取属性值[更新人]代码表：net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel
     */
    public String getUpdateMan() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUpdateMan();
        }
        return this.updateman;
    }

    /**
     *  获取属性值[更新人]是否修改
     */
    public boolean isUpdateManDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUpdateManDirty();
        }
        return this.updatemanDirtyFlag;
    }

    /**
     *  重置属性值[更新人]
     */
    public void resetUpdateMan() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUpdateMan();
            return;
        }

        this.updatemanDirtyFlag = false;
        this.updateman = null;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        SystemBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
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

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onFillMap(java.util.HashMap, boolean)
     */
    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if(!bDirtyOnly || isAURLoginAddrDirty()) {
            params.put(FIELD_AURLOGINADDR,getAURLoginAddr());
        }
        if(!bDirtyOnly || isAURLogoutAddrDirty()) {
            params.put(FIELD_AURLOGOUTADDR,getAURLogoutAddr());
        }
        if(!bDirtyOnly || isBigIconDirty()) {
            params.put(FIELD_BIGICON,getBigIcon());
        }
        if(!bDirtyOnly || isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE,getCreateDate());
        }
        if(!bDirtyOnly || isCreateManDirty()) {
            params.put(FIELD_CREATEMAN,getCreateMan());
        }
        if(!bDirtyOnly || isFunLicDirty()) {
            params.put(FIELD_FUNLIC,getFunLic());
        }
        if(!bDirtyOnly || isServiceDirty()) {
            params.put(FIELD_SERVICE,getService());
        }
        if(!bDirtyOnly || isSystemAddrDirty()) {
            params.put(FIELD_SYSTEMADDR,getSystemAddr());
        }
        if(!bDirtyOnly || isSystemFunDirty()) {
            params.put(FIELD_SYSTEMFUN,getSystemFun());
        }
        if(!bDirtyOnly || isSystemIdDirty()) {
            params.put(FIELD_SYSTEMID,getSystemId());
        }
        if(!bDirtyOnly || isSystemNameDirty()) {
            params.put(FIELD_SYSTEMNAME,getSystemName());
        }
        if(!bDirtyOnly || isSystemParamDirty()) {
            params.put(FIELD_SYSTEMPARAM,getSystemParam());
        }
        if(!bDirtyOnly || isSystemTypeDirty()) {
            params.put(FIELD_SYSTEMTYPE,getSystemType());
        }
        if(!bDirtyOnly || isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE,getUpdateDate());
        }
        if(!bDirtyOnly || isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN,getUpdateMan());
        }
        super.onFillMap(params, bDirtyOnly);
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#get(java.lang.String)
     */
    @Override
    public Object get(String strParamName) throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().get(strParamName);
        }

        if(StringHelper.isNullOrEmpty(strParamName))
            throw new Exception("没有指定属性");
        Integer index=fieldIndexMap.get(strParamName.toUpperCase());
        if(index==null)
            return super.get(strParamName);

        return  SystemBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(SystemBase et,int index) throws Exception {

        switch(index) {
        case INDEX_AURLOGINADDR:
            return et.getAURLoginAddr();
        case INDEX_AURLOGOUTADDR:
            return et.getAURLogoutAddr();
        case INDEX_BIGICON:
            return et.getBigIcon();
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_FUNLIC:
            return et.getFunLic();
        case INDEX_SERVICE:
            return et.getService();
        case INDEX_SYSTEMADDR:
            return et.getSystemAddr();
        case INDEX_SYSTEMFUN:
            return et.getSystemFun();
        case INDEX_SYSTEMID:
            return et.getSystemId();
        case INDEX_SYSTEMNAME:
            return et.getSystemName();
        case INDEX_SYSTEMPARAM:
            return et.getSystemParam();
        case INDEX_SYSTEMTYPE:
            return et.getSystemType();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
        default:
            throw new Exception("不明属性标识");
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#set(java.lang.String, java.lang.Object)
     */
    @Override
    public void set(String strParamName,Object objValue) throws Exception {
        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().set(strParamName,objValue);
            return;
        }
        if(StringHelper.isNullOrEmpty(strParamName))
            throw new Exception("没有指定属性");

        Integer index=fieldIndexMap.get(strParamName.toUpperCase());
        if(index==null) {
            super.set(strParamName,objValue);
            return;
        }

        SystemBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(SystemBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_AURLOGINADDR:
            et.setAURLoginAddr(DataObject.getStringValue(obj));
            return ;
        case INDEX_AURLOGOUTADDR:
            et.setAURLogoutAddr(DataObject.getStringValue(obj));
            return ;
        case INDEX_BIGICON:
            et.setBigIcon(DataObject.getStringValue(obj));
            return ;
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_FUNLIC:
            et.setFunLic(DataObject.getStringValue(obj));
            return ;
        case INDEX_SERVICE:
            et.setService(DataObject.getStringValue(obj));
            return ;
        case INDEX_SYSTEMADDR:
            et.setSystemAddr(DataObject.getStringValue(obj));
            return ;
        case INDEX_SYSTEMFUN:
            et.setSystemFun(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_SYSTEMID:
            et.setSystemId(DataObject.getStringValue(obj));
            return ;
        case INDEX_SYSTEMNAME:
            et.setSystemName(DataObject.getStringValue(obj));
            return ;
        case INDEX_SYSTEMPARAM:
            et.setSystemParam(DataObject.getStringValue(obj));
            return ;
        case INDEX_SYSTEMTYPE:
            et.setSystemType(DataObject.getStringValue(obj));
            return ;
        case INDEX_UPDATEDATE:
            et.setUpdateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_UPDATEMAN:
            et.setUpdateMan(DataObject.getStringValue(obj));
            return ;
        default:
            throw new Exception("不明属性标识");
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#isNull(java.lang.String)
     */
    @Override
    public boolean isNull(String strParamName) throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isNull(strParamName);
        }
        if(StringHelper.isNullOrEmpty(strParamName))
            throw new Exception("没有指定属性");

        Integer index=fieldIndexMap.get(strParamName.toUpperCase());
        if(index==null)
            return super.isNull(strParamName);

        return  SystemBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(SystemBase et,int index) throws Exception {

        switch(index) {
        case INDEX_AURLOGINADDR:
            return et.getAURLoginAddr()==null;
        case INDEX_AURLOGOUTADDR:
            return et.getAURLogoutAddr()==null;
        case INDEX_BIGICON:
            return et.getBigIcon()==null;
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_FUNLIC:
            return et.getFunLic()==null;
        case INDEX_SERVICE:
            return et.getService()==null;
        case INDEX_SYSTEMADDR:
            return et.getSystemAddr()==null;
        case INDEX_SYSTEMFUN:
            return et.getSystemFun()==null;
        case INDEX_SYSTEMID:
            return et.getSystemId()==null;
        case INDEX_SYSTEMNAME:
            return et.getSystemName()==null;
        case INDEX_SYSTEMPARAM:
            return et.getSystemParam()==null;
        case INDEX_SYSTEMTYPE:
            return et.getSystemType()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
        default:
            throw new Exception("不明属性标识");
        }
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#contains(java.lang.String)
     */
    @Override
    public boolean contains(String strParamName) throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().contains(strParamName);
        }
        if(StringHelper.isNullOrEmpty(strParamName))
            throw new Exception("没有指定属性");
        Integer index=fieldIndexMap.get(strParamName.toUpperCase());
        if(index==null)
            return super.contains(strParamName);
        return  SystemBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(SystemBase et,int index) throws Exception {

        switch(index) {
        case INDEX_AURLOGINADDR:
            return et.isAURLoginAddrDirty();
        case INDEX_AURLOGOUTADDR:
            return et.isAURLogoutAddrDirty();
        case INDEX_BIGICON:
            return et.isBigIconDirty();
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_FUNLIC:
            return et.isFunLicDirty();
        case INDEX_SERVICE:
            return et.isServiceDirty();
        case INDEX_SYSTEMADDR:
            return et.isSystemAddrDirty();
        case INDEX_SYSTEMFUN:
            return et.isSystemFunDirty();
        case INDEX_SYSTEMID:
            return et.isSystemIdDirty();
        case INDEX_SYSTEMNAME:
            return et.isSystemNameDirty();
        case INDEX_SYSTEMPARAM:
            return et.isSystemParamDirty();
        case INDEX_SYSTEMTYPE:
            return et.isSystemTypeDirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
        default:
            throw new Exception("不明属性标识");
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onFillJSONObject(net.sf.json.JSONObject, boolean)
     */
    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        fillJSONObject(this,objJSON,bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    /**
     * 填充当前对象到JSON
     * @param et 当前数据对象
     * @param json JSON对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static  void fillJSONObject(SystemBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getAURLoginAddr()!=null) {
            JSONObjectHelper.put(json,"aurloginaddr",getJSONValue(et.getAURLoginAddr()),false);
        }
        if(bIncEmpty||et.getAURLogoutAddr()!=null) {
            JSONObjectHelper.put(json,"aurlogoutaddr",getJSONValue(et.getAURLogoutAddr()),false);
        }
        if(bIncEmpty||et.getBigIcon()!=null) {
            JSONObjectHelper.put(json,"bigicon",getJSONValue(et.getBigIcon()),false);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getFunLic()!=null) {
            JSONObjectHelper.put(json,"funlic",getJSONValue(et.getFunLic()),false);
        }
        if(bIncEmpty||et.getService()!=null) {
            JSONObjectHelper.put(json,"service",getJSONValue(et.getService()),false);
        }
        if(bIncEmpty||et.getSystemAddr()!=null) {
            JSONObjectHelper.put(json,"systemaddr",getJSONValue(et.getSystemAddr()),false);
        }
        if(bIncEmpty||et.getSystemFun()!=null) {
            JSONObjectHelper.put(json,"systemfun",getJSONValue(et.getSystemFun()),false);
        }
        if(bIncEmpty||et.getSystemId()!=null) {
            JSONObjectHelper.put(json,"systemid",getJSONValue(et.getSystemId()),false);
        }
        if(bIncEmpty||et.getSystemName()!=null) {
            JSONObjectHelper.put(json,"systemname",getJSONValue(et.getSystemName()),false);
        }
        if(bIncEmpty||et.getSystemParam()!=null) {
            JSONObjectHelper.put(json,"systemparam",getJSONValue(et.getSystemParam()),false);
        }
        if(bIncEmpty||et.getSystemType()!=null) {
            JSONObjectHelper.put(json,"systemtype",getJSONValue(et.getSystemType()),false);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            JSONObjectHelper.put(json,"updatedate",getJSONValue(et.getUpdateDate()),false);
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            JSONObjectHelper.put(json,"updateman",getJSONValue(et.getUpdateMan()),false);
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onFillXmlNode(net.ibizsys.paas.xml.XmlNode, boolean)
     */
    @Override
    protected void onFillXmlNode(XmlNode xmlNode,boolean bIncludeEmpty) throws Exception {
        fillXmlNode(this,xmlNode,bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    /**
     * 填充当前对象到Xml节点中
     * @param et 当前数据对象
     * @param node Xml节点
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void fillXmlNode(SystemBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getAURLoginAddr()!=null) {
            Object obj = et.getAURLoginAddr();
            node.setAttribute("AURLOGINADDR",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getAURLogoutAddr()!=null) {
            Object obj = et.getAURLogoutAddr();
            node.setAttribute("AURLOGOUTADDR",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getBigIcon()!=null) {
            Object obj = et.getBigIcon();
            node.setAttribute("BIGICON",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getFunLic()!=null) {
            Object obj = et.getFunLic();
            node.setAttribute("FUNLIC",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getService()!=null) {
            Object obj = et.getService();
            node.setAttribute("SERVICE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getSystemAddr()!=null) {
            Object obj = et.getSystemAddr();
            node.setAttribute("SYSTEMADDR",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getSystemFun()!=null) {
            Object obj = et.getSystemFun();
            node.setAttribute("SYSTEMFUN",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getSystemId()!=null) {
            Object obj = et.getSystemId();
            node.setAttribute("SYSTEMID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getSystemName()!=null) {
            Object obj = et.getSystemName();
            node.setAttribute("SYSTEMNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getSystemParam()!=null) {
            Object obj = et.getSystemParam();
            node.setAttribute("SYSTEMPARAM",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getSystemType()!=null) {
            Object obj = et.getSystemType();
            node.setAttribute("SYSTEMTYPE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            Object obj = et.getUpdateDate();
            node.setAttribute("UPDATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            Object obj = et.getUpdateMan();
            node.setAttribute("UPDATEMAN",(obj==null)?"":(String)obj);
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        SystemBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(SystemBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isAURLoginAddrDirty() && (bIncEmpty||et.getAURLoginAddr()!=null)) {
            dst.set(FIELD_AURLOGINADDR,et.getAURLoginAddr());
        }
        if(et.isAURLogoutAddrDirty() && (bIncEmpty||et.getAURLogoutAddr()!=null)) {
            dst.set(FIELD_AURLOGOUTADDR,et.getAURLogoutAddr());
        }
        if(et.isBigIconDirty() && (bIncEmpty||et.getBigIcon()!=null)) {
            dst.set(FIELD_BIGICON,et.getBigIcon());
        }
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isFunLicDirty() && (bIncEmpty||et.getFunLic()!=null)) {
            dst.set(FIELD_FUNLIC,et.getFunLic());
        }
        if(et.isServiceDirty() && (bIncEmpty||et.getService()!=null)) {
            dst.set(FIELD_SERVICE,et.getService());
        }
        if(et.isSystemAddrDirty() && (bIncEmpty||et.getSystemAddr()!=null)) {
            dst.set(FIELD_SYSTEMADDR,et.getSystemAddr());
        }
        if(et.isSystemFunDirty() && (bIncEmpty||et.getSystemFun()!=null)) {
            dst.set(FIELD_SYSTEMFUN,et.getSystemFun());
        }
        if(et.isSystemIdDirty() && (bIncEmpty||et.getSystemId()!=null)) {
            dst.set(FIELD_SYSTEMID,et.getSystemId());
        }
        if(et.isSystemNameDirty() && (bIncEmpty||et.getSystemName()!=null)) {
            dst.set(FIELD_SYSTEMNAME,et.getSystemName());
        }
        if(et.isSystemParamDirty() && (bIncEmpty||et.getSystemParam()!=null)) {
            dst.set(FIELD_SYSTEMPARAM,et.getSystemParam());
        }
        if(et.isSystemTypeDirty() && (bIncEmpty||et.getSystemType()!=null)) {
            dst.set(FIELD_SYSTEMTYPE,et.getSystemType());
        }
        if(et.isUpdateDateDirty() && (bIncEmpty||et.getUpdateDate()!=null)) {
            dst.set(FIELD_UPDATEDATE,et.getUpdateDate());
        }
        if(et.isUpdateManDirty() && (bIncEmpty||et.getUpdateMan()!=null)) {
            dst.set(FIELD_UPDATEMAN,et.getUpdateMan());
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#remove(java.lang.String)
     */
    @Override
    public boolean remove(String strParamName) throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().remove(strParamName);
        }
        if(StringHelper.isNullOrEmpty(strParamName))
            throw new Exception("没有指定属性");
        Integer index=fieldIndexMap.get(strParamName.toUpperCase());
        if(index==null)
            return super.remove(strParamName);
        return  SystemBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(SystemBase et,int index) throws Exception {
        switch(index) {
        case INDEX_AURLOGINADDR:
            et.resetAURLoginAddr();
            return true;
        case INDEX_AURLOGOUTADDR:
            et.resetAURLogoutAddr();
            return true;
        case INDEX_BIGICON:
            et.resetBigIcon();
            return true;
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_FUNLIC:
            et.resetFunLic();
            return true;
        case INDEX_SERVICE:
            et.resetService();
            return true;
        case INDEX_SYSTEMADDR:
            et.resetSystemAddr();
            return true;
        case INDEX_SYSTEMFUN:
            et.resetSystemFun();
            return true;
        case INDEX_SYSTEMID:
            et.resetSystemId();
            return true;
        case INDEX_SYSTEMNAME:
            et.resetSystemName();
            return true;
        case INDEX_SYSTEMPARAM:
            et.resetSystemParam();
            return true;
        case INDEX_SYSTEMTYPE:
            et.resetSystemType();
            return true;
        case INDEX_UPDATEDATE:
            et.resetUpdateDate();
            return true;
        case INDEX_UPDATEMAN:
            et.resetUpdateMan();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }




    /**
     *  获取代理的数据对象
     */
    private SystemBase getProxyEntity() {
        return this.proxySystemBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxySystemBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof SystemBase) {
            this.proxySystemBase = (SystemBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }


    /**
    * 重写获取行为操作辅助对象
    */
    protected net.ibizsys.paas.entity.IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        net.ibizsys.paas.entity.IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if(!bMust || iEntityActionHelper!=null)
            return iEntityActionHelper;
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.SystemService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}