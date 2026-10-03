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
 * 实体[Registry] 数据对象基类
 */
public abstract class RegistryBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(RegistryBase.class);
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[说明]
     */
    public final static String FIELD_MEMO = "MEMO";
    /**
     * 属性[参数1]
     */
    public final static String FIELD_PARAM1 = "PARAM1";
    /**
     * 属性[参数2]
     */
    public final static String FIELD_PARAM2 = "PARAM2";
    /**
     * 属性[参数3(250)]
     */
    public final static String FIELD_PARAM3 = "PARAM3";
    /**
     * 属性[参数4(250)]
     */
    public final static String FIELD_PARAM4 = "PARAM4";
    /**
     * 属性[参数5(500)]
     */
    public final static String FIELD_PARAM5 = "PARAM5";
    /**
     * 属性[参数6(500)]
     */
    public final static String FIELD_PARAM6 = "PARAM6";
    /**
     * 属性[参数7(500)]
     */
    public final static String FIELD_PARAM7 = "PARAM7";
    /**
     * 属性[参数8(500)]
     */
    public final static String FIELD_PARAM8 = "PARAM8";
    /**
     * 属性[参数9]
     */
    public final static String FIELD_PARAM9 = "PARAM9";
    /**
     * 属性[注册表标识]
     */
    public final static String FIELD_REGISTRYID = "REGISTRYID";
    /**
     * 属性[系统目录]
     */
    public final static String FIELD_REGISTRYNAME = "REGISTRYNAME";
    /**
     * 属性[目录]
     */
    public final static String FIELD_SECTOR = "SECTION";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";

    private final static int INDEX_CREATEDATE = 0;
    private final static int INDEX_CREATEMAN = 1;
    private final static int INDEX_MEMO = 2;
    private final static int INDEX_PARAM1 = 3;
    private final static int INDEX_PARAM2 = 4;
    private final static int INDEX_PARAM3 = 5;
    private final static int INDEX_PARAM4 = 6;
    private final static int INDEX_PARAM5 = 7;
    private final static int INDEX_PARAM6 = 8;
    private final static int INDEX_PARAM7 = 9;
    private final static int INDEX_PARAM8 = 10;
    private final static int INDEX_PARAM9 = 11;
    private final static int INDEX_REGISTRYID = 12;
    private final static int INDEX_REGISTRYNAME = 13;
    private final static int INDEX_SECTOR = 14;
    private final static int INDEX_UPDATEDATE = 15;
    private final static int INDEX_UPDATEMAN = 16;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_MEMO, INDEX_MEMO);
        fieldIndexMap.put( FIELD_PARAM1, INDEX_PARAM1);
        fieldIndexMap.put( FIELD_PARAM2, INDEX_PARAM2);
        fieldIndexMap.put( FIELD_PARAM3, INDEX_PARAM3);
        fieldIndexMap.put( FIELD_PARAM4, INDEX_PARAM4);
        fieldIndexMap.put( FIELD_PARAM5, INDEX_PARAM5);
        fieldIndexMap.put( FIELD_PARAM6, INDEX_PARAM6);
        fieldIndexMap.put( FIELD_PARAM7, INDEX_PARAM7);
        fieldIndexMap.put( FIELD_PARAM8, INDEX_PARAM8);
        fieldIndexMap.put( FIELD_PARAM9, INDEX_PARAM9);
        fieldIndexMap.put( FIELD_REGISTRYID, INDEX_REGISTRYID);
        fieldIndexMap.put( FIELD_REGISTRYNAME, INDEX_REGISTRYNAME);
        fieldIndexMap.put( FIELD_SECTOR, INDEX_SECTOR);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
    }

    private RegistryBase proxyRegistryBase = null;
    public RegistryBase() {
        super();
    }
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean param1DirtyFlag = false;
    private boolean param2DirtyFlag = false;
    private boolean param3DirtyFlag = false;
    private boolean param4DirtyFlag = false;
    private boolean param5DirtyFlag = false;
    private boolean param6DirtyFlag = false;
    private boolean param7DirtyFlag = false;
    private boolean param8DirtyFlag = false;
    private boolean param9DirtyFlag = false;
    private boolean registryidDirtyFlag = false;
    private boolean registrynameDirtyFlag = false;
    private boolean sectorDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;

    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="param1")
    private String param1;
    @Column(name="param2")
    private String param2;
    @Column(name="param3")
    private String param3;
    @Column(name="param4")
    private String param4;
    @Column(name="param5")
    private String param5;
    @Column(name="param6")
    private String param6;
    @Column(name="param7")
    private String param7;
    @Column(name="param8")
    private String param8;
    @Column(name="param9")
    private String param9;
    @Column(name="registryid")
    private String registryid;
    @Column(name="registryname")
    private String registryname;
    @Column(name="sector")
    private String sector;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;


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
     *  设置属性值[说明]
     *  @param memo
     */
    public void setMemo(String memo) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setMemo(memo);
            return;
        }
        if(memo!=null) {
            memo = StringHelper.trimRight(memo);
            if(memo.length()==0) {
                memo = null;
            }
        }
        this.memo = memo;
        this.memoDirtyFlag  = true;
    }

    /**
     *  获取属性值[说明]
     */
    public String getMemo() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMemo();
        }
        return this.memo;
    }

    /**
     *  获取属性值[说明]是否修改
     */
    public boolean isMemoDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMemoDirty();
        }
        return this.memoDirtyFlag;
    }

    /**
     *  重置属性值[说明]
     */
    public void resetMemo() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetMemo();
            return;
        }

        this.memoDirtyFlag = false;
        this.memo = null;
    }
    /**
     *  设置属性值[参数1]
     *  @param param1
     */
    public void setParam1(String param1) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setParam1(param1);
            return;
        }
        if(param1!=null) {
            param1 = StringHelper.trimRight(param1);
            if(param1.length()==0) {
                param1 = null;
            }
        }
        this.param1 = param1;
        this.param1DirtyFlag  = true;
    }

    /**
     *  获取属性值[参数1]
     */
    public String getParam1() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getParam1();
        }
        return this.param1;
    }

    /**
     *  获取属性值[参数1]是否修改
     */
    public boolean isParam1Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isParam1Dirty();
        }
        return this.param1DirtyFlag;
    }

    /**
     *  重置属性值[参数1]
     */
    public void resetParam1() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetParam1();
            return;
        }

        this.param1DirtyFlag = false;
        this.param1 = null;
    }
    /**
     *  设置属性值[参数2]
     *  @param param2
     */
    public void setParam2(String param2) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setParam2(param2);
            return;
        }
        if(param2!=null) {
            param2 = StringHelper.trimRight(param2);
            if(param2.length()==0) {
                param2 = null;
            }
        }
        this.param2 = param2;
        this.param2DirtyFlag  = true;
    }

    /**
     *  获取属性值[参数2]
     */
    public String getParam2() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getParam2();
        }
        return this.param2;
    }

    /**
     *  获取属性值[参数2]是否修改
     */
    public boolean isParam2Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isParam2Dirty();
        }
        return this.param2DirtyFlag;
    }

    /**
     *  重置属性值[参数2]
     */
    public void resetParam2() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetParam2();
            return;
        }

        this.param2DirtyFlag = false;
        this.param2 = null;
    }
    /**
     *  设置属性值[参数3(250)]
     *  @param param3
     */
    public void setParam3(String param3) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setParam3(param3);
            return;
        }
        if(param3!=null) {
            param3 = StringHelper.trimRight(param3);
            if(param3.length()==0) {
                param3 = null;
            }
        }
        this.param3 = param3;
        this.param3DirtyFlag  = true;
    }

    /**
     *  获取属性值[参数3(250)]
     */
    public String getParam3() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getParam3();
        }
        return this.param3;
    }

    /**
     *  获取属性值[参数3(250)]是否修改
     */
    public boolean isParam3Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isParam3Dirty();
        }
        return this.param3DirtyFlag;
    }

    /**
     *  重置属性值[参数3(250)]
     */
    public void resetParam3() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetParam3();
            return;
        }

        this.param3DirtyFlag = false;
        this.param3 = null;
    }
    /**
     *  设置属性值[参数4(250)]
     *  @param param4
     */
    public void setParam4(String param4) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setParam4(param4);
            return;
        }
        if(param4!=null) {
            param4 = StringHelper.trimRight(param4);
            if(param4.length()==0) {
                param4 = null;
            }
        }
        this.param4 = param4;
        this.param4DirtyFlag  = true;
    }

    /**
     *  获取属性值[参数4(250)]
     */
    public String getParam4() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getParam4();
        }
        return this.param4;
    }

    /**
     *  获取属性值[参数4(250)]是否修改
     */
    public boolean isParam4Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isParam4Dirty();
        }
        return this.param4DirtyFlag;
    }

    /**
     *  重置属性值[参数4(250)]
     */
    public void resetParam4() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetParam4();
            return;
        }

        this.param4DirtyFlag = false;
        this.param4 = null;
    }
    /**
     *  设置属性值[参数5(500)]
     *  @param param5
     */
    public void setParam5(String param5) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setParam5(param5);
            return;
        }
        if(param5!=null) {
            param5 = StringHelper.trimRight(param5);
            if(param5.length()==0) {
                param5 = null;
            }
        }
        this.param5 = param5;
        this.param5DirtyFlag  = true;
    }

    /**
     *  获取属性值[参数5(500)]
     */
    public String getParam5() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getParam5();
        }
        return this.param5;
    }

    /**
     *  获取属性值[参数5(500)]是否修改
     */
    public boolean isParam5Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isParam5Dirty();
        }
        return this.param5DirtyFlag;
    }

    /**
     *  重置属性值[参数5(500)]
     */
    public void resetParam5() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetParam5();
            return;
        }

        this.param5DirtyFlag = false;
        this.param5 = null;
    }
    /**
     *  设置属性值[参数6(500)]
     *  @param param6
     */
    public void setParam6(String param6) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setParam6(param6);
            return;
        }
        if(param6!=null) {
            param6 = StringHelper.trimRight(param6);
            if(param6.length()==0) {
                param6 = null;
            }
        }
        this.param6 = param6;
        this.param6DirtyFlag  = true;
    }

    /**
     *  获取属性值[参数6(500)]
     */
    public String getParam6() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getParam6();
        }
        return this.param6;
    }

    /**
     *  获取属性值[参数6(500)]是否修改
     */
    public boolean isParam6Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isParam6Dirty();
        }
        return this.param6DirtyFlag;
    }

    /**
     *  重置属性值[参数6(500)]
     */
    public void resetParam6() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetParam6();
            return;
        }

        this.param6DirtyFlag = false;
        this.param6 = null;
    }
    /**
     *  设置属性值[参数7(500)]
     *  @param param7
     */
    public void setParam7(String param7) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setParam7(param7);
            return;
        }
        if(param7!=null) {
            param7 = StringHelper.trimRight(param7);
            if(param7.length()==0) {
                param7 = null;
            }
        }
        this.param7 = param7;
        this.param7DirtyFlag  = true;
    }

    /**
     *  获取属性值[参数7(500)]
     */
    public String getParam7() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getParam7();
        }
        return this.param7;
    }

    /**
     *  获取属性值[参数7(500)]是否修改
     */
    public boolean isParam7Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isParam7Dirty();
        }
        return this.param7DirtyFlag;
    }

    /**
     *  重置属性值[参数7(500)]
     */
    public void resetParam7() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetParam7();
            return;
        }

        this.param7DirtyFlag = false;
        this.param7 = null;
    }
    /**
     *  设置属性值[参数8(500)]
     *  @param param8
     */
    public void setParam8(String param8) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setParam8(param8);
            return;
        }
        if(param8!=null) {
            param8 = StringHelper.trimRight(param8);
            if(param8.length()==0) {
                param8 = null;
            }
        }
        this.param8 = param8;
        this.param8DirtyFlag  = true;
    }

    /**
     *  获取属性值[参数8(500)]
     */
    public String getParam8() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getParam8();
        }
        return this.param8;
    }

    /**
     *  获取属性值[参数8(500)]是否修改
     */
    public boolean isParam8Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isParam8Dirty();
        }
        return this.param8DirtyFlag;
    }

    /**
     *  重置属性值[参数8(500)]
     */
    public void resetParam8() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetParam8();
            return;
        }

        this.param8DirtyFlag = false;
        this.param8 = null;
    }
    /**
     *  设置属性值[参数9]
     *  @param param9
     */
    public void setParam9(String param9) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setParam9(param9);
            return;
        }
        if(param9!=null) {
            param9 = StringHelper.trimRight(param9);
            if(param9.length()==0) {
                param9 = null;
            }
        }
        this.param9 = param9;
        this.param9DirtyFlag  = true;
    }

    /**
     *  获取属性值[参数9]
     */
    public String getParam9() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getParam9();
        }
        return this.param9;
    }

    /**
     *  获取属性值[参数9]是否修改
     */
    public boolean isParam9Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isParam9Dirty();
        }
        return this.param9DirtyFlag;
    }

    /**
     *  重置属性值[参数9]
     */
    public void resetParam9() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetParam9();
            return;
        }

        this.param9DirtyFlag = false;
        this.param9 = null;
    }
    /**
     *  设置属性值[注册表标识]
     *  @param registryid
     */
    public void setRegistryId(String registryid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setRegistryId(registryid);
            return;
        }
        if(registryid!=null) {
            registryid = StringHelper.trimRight(registryid);
            if(registryid.length()==0) {
                registryid = null;
            }
        }
        this.registryid = registryid;
        this.registryidDirtyFlag  = true;
    }

    /**
     *  获取属性值[注册表标识]
     */
    public String getRegistryId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getRegistryId();
        }
        return this.registryid;
    }

    /**
     *  获取属性值[注册表标识]是否修改
     */
    public boolean isRegistryIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isRegistryIdDirty();
        }
        return this.registryidDirtyFlag;
    }

    /**
     *  重置属性值[注册表标识]
     */
    public void resetRegistryId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetRegistryId();
            return;
        }

        this.registryidDirtyFlag = false;
        this.registryid = null;
    }
    /**
     *  设置属性值[系统目录]
     *  @param registryname
     */
    public void setRegistryName(String registryname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setRegistryName(registryname);
            return;
        }
        if(registryname!=null) {
            registryname = StringHelper.trimRight(registryname);
            if(registryname.length()==0) {
                registryname = null;
            }
        }
        this.registryname = registryname;
        this.registrynameDirtyFlag  = true;
    }

    /**
     *  获取属性值[系统目录]
     */
    public String getRegistryName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getRegistryName();
        }
        return this.registryname;
    }

    /**
     *  获取属性值[系统目录]是否修改
     */
    public boolean isRegistryNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isRegistryNameDirty();
        }
        return this.registrynameDirtyFlag;
    }

    /**
     *  重置属性值[系统目录]
     */
    public void resetRegistryName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetRegistryName();
            return;
        }

        this.registrynameDirtyFlag = false;
        this.registryname = null;
    }
    /**
     *  设置属性值[目录]
     *  @param sector
     */
    public void setSector(String sector) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setSector(sector);
            return;
        }
        if(sector!=null) {
            sector = StringHelper.trimRight(sector);
            if(sector.length()==0) {
                sector = null;
            }
        }
        this.sector = sector;
        this.sectorDirtyFlag  = true;
    }

    /**
     *  获取属性值[目录]
     */
    public String getSector() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getSector();
        }
        return this.sector;
    }

    /**
     *  获取属性值[目录]是否修改
     */
    public boolean isSectorDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isSectorDirty();
        }
        return this.sectorDirtyFlag;
    }

    /**
     *  重置属性值[目录]
     */
    public void resetSector() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetSector();
            return;
        }

        this.sectorDirtyFlag = false;
        this.sector = null;
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
        RegistryBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(RegistryBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetMemo();
        et.resetParam1();
        et.resetParam2();
        et.resetParam3();
        et.resetParam4();
        et.resetParam5();
        et.resetParam6();
        et.resetParam7();
        et.resetParam8();
        et.resetParam9();
        et.resetRegistryId();
        et.resetRegistryName();
        et.resetSector();
        et.resetUpdateDate();
        et.resetUpdateMan();
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onFillMap(java.util.HashMap, boolean)
     */
    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if(!bDirtyOnly || isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE,getCreateDate());
        }
        if(!bDirtyOnly || isCreateManDirty()) {
            params.put(FIELD_CREATEMAN,getCreateMan());
        }
        if(!bDirtyOnly || isMemoDirty()) {
            params.put(FIELD_MEMO,getMemo());
        }
        if(!bDirtyOnly || isParam1Dirty()) {
            params.put(FIELD_PARAM1,getParam1());
        }
        if(!bDirtyOnly || isParam2Dirty()) {
            params.put(FIELD_PARAM2,getParam2());
        }
        if(!bDirtyOnly || isParam3Dirty()) {
            params.put(FIELD_PARAM3,getParam3());
        }
        if(!bDirtyOnly || isParam4Dirty()) {
            params.put(FIELD_PARAM4,getParam4());
        }
        if(!bDirtyOnly || isParam5Dirty()) {
            params.put(FIELD_PARAM5,getParam5());
        }
        if(!bDirtyOnly || isParam6Dirty()) {
            params.put(FIELD_PARAM6,getParam6());
        }
        if(!bDirtyOnly || isParam7Dirty()) {
            params.put(FIELD_PARAM7,getParam7());
        }
        if(!bDirtyOnly || isParam8Dirty()) {
            params.put(FIELD_PARAM8,getParam8());
        }
        if(!bDirtyOnly || isParam9Dirty()) {
            params.put(FIELD_PARAM9,getParam9());
        }
        if(!bDirtyOnly || isRegistryIdDirty()) {
            params.put(FIELD_REGISTRYID,getRegistryId());
        }
        if(!bDirtyOnly || isRegistryNameDirty()) {
            params.put(FIELD_REGISTRYNAME,getRegistryName());
        }
        if(!bDirtyOnly || isSectorDirty()) {
            params.put(FIELD_SECTOR,getSector());
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

        return  RegistryBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(RegistryBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_MEMO:
            return et.getMemo();
        case INDEX_PARAM1:
            return et.getParam1();
        case INDEX_PARAM2:
            return et.getParam2();
        case INDEX_PARAM3:
            return et.getParam3();
        case INDEX_PARAM4:
            return et.getParam4();
        case INDEX_PARAM5:
            return et.getParam5();
        case INDEX_PARAM6:
            return et.getParam6();
        case INDEX_PARAM7:
            return et.getParam7();
        case INDEX_PARAM8:
            return et.getParam8();
        case INDEX_PARAM9:
            return et.getParam9();
        case INDEX_REGISTRYID:
            return et.getRegistryId();
        case INDEX_REGISTRYNAME:
            return et.getRegistryName();
        case INDEX_SECTOR:
            return et.getSector();
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

        RegistryBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(RegistryBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_MEMO:
            et.setMemo(DataObject.getStringValue(obj));
            return ;
        case INDEX_PARAM1:
            et.setParam1(DataObject.getStringValue(obj));
            return ;
        case INDEX_PARAM2:
            et.setParam2(DataObject.getStringValue(obj));
            return ;
        case INDEX_PARAM3:
            et.setParam3(DataObject.getStringValue(obj));
            return ;
        case INDEX_PARAM4:
            et.setParam4(DataObject.getStringValue(obj));
            return ;
        case INDEX_PARAM5:
            et.setParam5(DataObject.getStringValue(obj));
            return ;
        case INDEX_PARAM6:
            et.setParam6(DataObject.getStringValue(obj));
            return ;
        case INDEX_PARAM7:
            et.setParam7(DataObject.getStringValue(obj));
            return ;
        case INDEX_PARAM8:
            et.setParam8(DataObject.getStringValue(obj));
            return ;
        case INDEX_PARAM9:
            et.setParam9(DataObject.getStringValue(obj));
            return ;
        case INDEX_REGISTRYID:
            et.setRegistryId(DataObject.getStringValue(obj));
            return ;
        case INDEX_REGISTRYNAME:
            et.setRegistryName(DataObject.getStringValue(obj));
            return ;
        case INDEX_SECTOR:
            et.setSector(DataObject.getStringValue(obj));
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

        return  RegistryBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(RegistryBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_MEMO:
            return et.getMemo()==null;
        case INDEX_PARAM1:
            return et.getParam1()==null;
        case INDEX_PARAM2:
            return et.getParam2()==null;
        case INDEX_PARAM3:
            return et.getParam3()==null;
        case INDEX_PARAM4:
            return et.getParam4()==null;
        case INDEX_PARAM5:
            return et.getParam5()==null;
        case INDEX_PARAM6:
            return et.getParam6()==null;
        case INDEX_PARAM7:
            return et.getParam7()==null;
        case INDEX_PARAM8:
            return et.getParam8()==null;
        case INDEX_PARAM9:
            return et.getParam9()==null;
        case INDEX_REGISTRYID:
            return et.getRegistryId()==null;
        case INDEX_REGISTRYNAME:
            return et.getRegistryName()==null;
        case INDEX_SECTOR:
            return et.getSector()==null;
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
        return  RegistryBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(RegistryBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_MEMO:
            return et.isMemoDirty();
        case INDEX_PARAM1:
            return et.isParam1Dirty();
        case INDEX_PARAM2:
            return et.isParam2Dirty();
        case INDEX_PARAM3:
            return et.isParam3Dirty();
        case INDEX_PARAM4:
            return et.isParam4Dirty();
        case INDEX_PARAM5:
            return et.isParam5Dirty();
        case INDEX_PARAM6:
            return et.isParam6Dirty();
        case INDEX_PARAM7:
            return et.isParam7Dirty();
        case INDEX_PARAM8:
            return et.isParam8Dirty();
        case INDEX_PARAM9:
            return et.isParam9Dirty();
        case INDEX_REGISTRYID:
            return et.isRegistryIdDirty();
        case INDEX_REGISTRYNAME:
            return et.isRegistryNameDirty();
        case INDEX_SECTOR:
            return et.isSectorDirty();
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
    private static  void fillJSONObject(RegistryBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getMemo()!=null) {
            JSONObjectHelper.put(json,"memo",getJSONValue(et.getMemo()),false);
        }
        if(bIncEmpty||et.getParam1()!=null) {
            JSONObjectHelper.put(json,"param1",getJSONValue(et.getParam1()),false);
        }
        if(bIncEmpty||et.getParam2()!=null) {
            JSONObjectHelper.put(json,"param2",getJSONValue(et.getParam2()),false);
        }
        if(bIncEmpty||et.getParam3()!=null) {
            JSONObjectHelper.put(json,"param3",getJSONValue(et.getParam3()),false);
        }
        if(bIncEmpty||et.getParam4()!=null) {
            JSONObjectHelper.put(json,"param4",getJSONValue(et.getParam4()),false);
        }
        if(bIncEmpty||et.getParam5()!=null) {
            JSONObjectHelper.put(json,"param5",getJSONValue(et.getParam5()),false);
        }
        if(bIncEmpty||et.getParam6()!=null) {
            JSONObjectHelper.put(json,"param6",getJSONValue(et.getParam6()),false);
        }
        if(bIncEmpty||et.getParam7()!=null) {
            JSONObjectHelper.put(json,"param7",getJSONValue(et.getParam7()),false);
        }
        if(bIncEmpty||et.getParam8()!=null) {
            JSONObjectHelper.put(json,"param8",getJSONValue(et.getParam8()),false);
        }
        if(bIncEmpty||et.getParam9()!=null) {
            JSONObjectHelper.put(json,"param9",getJSONValue(et.getParam9()),false);
        }
        if(bIncEmpty||et.getRegistryId()!=null) {
            JSONObjectHelper.put(json,"registryid",getJSONValue(et.getRegistryId()),false);
        }
        if(bIncEmpty||et.getRegistryName()!=null) {
            JSONObjectHelper.put(json,"registryname",getJSONValue(et.getRegistryName()),false);
        }
        if(bIncEmpty||et.getSector()!=null) {
            JSONObjectHelper.put(json,"section",getJSONValue(et.getSector()),false);
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
    private static void fillXmlNode(RegistryBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getMemo()!=null) {
            Object obj = et.getMemo();
            node.setAttribute("MEMO",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getParam1()!=null) {
            Object obj = et.getParam1();
            node.setAttribute("PARAM1",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getParam2()!=null) {
            Object obj = et.getParam2();
            node.setAttribute("PARAM2",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getParam3()!=null) {
            Object obj = et.getParam3();
            node.setAttribute("PARAM3",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getParam4()!=null) {
            Object obj = et.getParam4();
            node.setAttribute("PARAM4",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getParam5()!=null) {
            Object obj = et.getParam5();
            node.setAttribute("PARAM5",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getParam6()!=null) {
            Object obj = et.getParam6();
            node.setAttribute("PARAM6",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getParam7()!=null) {
            Object obj = et.getParam7();
            node.setAttribute("PARAM7",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getParam8()!=null) {
            Object obj = et.getParam8();
            node.setAttribute("PARAM8",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getParam9()!=null) {
            Object obj = et.getParam9();
            node.setAttribute("PARAM9",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getRegistryId()!=null) {
            Object obj = et.getRegistryId();
            node.setAttribute("REGISTRYID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getRegistryName()!=null) {
            Object obj = et.getRegistryName();
            node.setAttribute("REGISTRYNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getSector()!=null) {
            Object obj = et.getSector();
            node.setAttribute("SECTOR",(obj==null)?"":(String)obj);
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
        RegistryBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(RegistryBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isMemoDirty() && (bIncEmpty||et.getMemo()!=null)) {
            dst.set(FIELD_MEMO,et.getMemo());
        }
        if(et.isParam1Dirty() && (bIncEmpty||et.getParam1()!=null)) {
            dst.set(FIELD_PARAM1,et.getParam1());
        }
        if(et.isParam2Dirty() && (bIncEmpty||et.getParam2()!=null)) {
            dst.set(FIELD_PARAM2,et.getParam2());
        }
        if(et.isParam3Dirty() && (bIncEmpty||et.getParam3()!=null)) {
            dst.set(FIELD_PARAM3,et.getParam3());
        }
        if(et.isParam4Dirty() && (bIncEmpty||et.getParam4()!=null)) {
            dst.set(FIELD_PARAM4,et.getParam4());
        }
        if(et.isParam5Dirty() && (bIncEmpty||et.getParam5()!=null)) {
            dst.set(FIELD_PARAM5,et.getParam5());
        }
        if(et.isParam6Dirty() && (bIncEmpty||et.getParam6()!=null)) {
            dst.set(FIELD_PARAM6,et.getParam6());
        }
        if(et.isParam7Dirty() && (bIncEmpty||et.getParam7()!=null)) {
            dst.set(FIELD_PARAM7,et.getParam7());
        }
        if(et.isParam8Dirty() && (bIncEmpty||et.getParam8()!=null)) {
            dst.set(FIELD_PARAM8,et.getParam8());
        }
        if(et.isParam9Dirty() && (bIncEmpty||et.getParam9()!=null)) {
            dst.set(FIELD_PARAM9,et.getParam9());
        }
        if(et.isRegistryIdDirty() && (bIncEmpty||et.getRegistryId()!=null)) {
            dst.set(FIELD_REGISTRYID,et.getRegistryId());
        }
        if(et.isRegistryNameDirty() && (bIncEmpty||et.getRegistryName()!=null)) {
            dst.set(FIELD_REGISTRYNAME,et.getRegistryName());
        }
        if(et.isSectorDirty() && (bIncEmpty||et.getSector()!=null)) {
            dst.set(FIELD_SECTOR,et.getSector());
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
        return  RegistryBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(RegistryBase et,int index) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_MEMO:
            et.resetMemo();
            return true;
        case INDEX_PARAM1:
            et.resetParam1();
            return true;
        case INDEX_PARAM2:
            et.resetParam2();
            return true;
        case INDEX_PARAM3:
            et.resetParam3();
            return true;
        case INDEX_PARAM4:
            et.resetParam4();
            return true;
        case INDEX_PARAM5:
            et.resetParam5();
            return true;
        case INDEX_PARAM6:
            et.resetParam6();
            return true;
        case INDEX_PARAM7:
            et.resetParam7();
            return true;
        case INDEX_PARAM8:
            et.resetParam8();
            return true;
        case INDEX_PARAM9:
            et.resetParam9();
            return true;
        case INDEX_REGISTRYID:
            et.resetRegistryId();
            return true;
        case INDEX_REGISTRYNAME:
            et.resetRegistryName();
            return true;
        case INDEX_SECTOR:
            et.resetSector();
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
    private RegistryBase getProxyEntity() {
        return this.proxyRegistryBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyRegistryBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof RegistryBase) {
            this.proxyRegistryBase = (RegistryBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.RegistryService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}