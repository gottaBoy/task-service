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
 * 实体[CodeItem] 数据对象基类
 */
public abstract class CodeItemBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(CodeItemBase.class);
    /**
     * 属性[代码项标识]
     */
    public final static String FIELD_CODEITEMID = "CODEITEMID";
    /**
     * 属性[代码项名称]
     */
    public final static String FIELD_CODEITEMNAME = "CODEITEMNAME";
    /**
     * 属性[代码项值]
     */
    public final static String FIELD_CODEITEMVALUE = "CODEITEMVALUE";
    /**
     * 属性[代码表]
     */
    public final static String FIELD_CODELISTID = "CODELISTID";
    /**
     * 属性[代码表]
     */
    public final static String FIELD_CODELISTNAME = "CODELISTNAME";
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[备注]
     */
    public final static String FIELD_MEMO = "MEMO";
    /**
     * 属性[排序值]
     */
    public final static String FIELD_ORDERVALUE = "ORDERVALUE";
    /**
     * 属性[上级代码项]
     */
    public final static String FIELD_PCODEITEMID = "PCODEITEMID";
    /**
     * 属性[上级代码项]
     */
    public final static String FIELD_PCODEITEMNAME = "PCODEITEMNAME";
    /**
     * 属性[保留字段]
     */
    public final static String FIELD_RESERVER = "RESERVER";
    /**
     * 属性[保留字段2]
     */
    public final static String FIELD_RESERVER2 = "RESERVER2";
    /**
     * 属性[保留字段3]
     */
    public final static String FIELD_RESERVER3 = "RESERVER3";
    /**
     * 属性[保留字段4]
     */
    public final static String FIELD_RESERVER4 = "RESERVER4";
    /**
     * 属性[保留字段5]
     */
    public final static String FIELD_RESERVER5 = "RESERVER5";
    /**
     * 属性[快捷输入]
     */
    public final static String FIELD_SHORTKEY = "SHORTKEY";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";

    private final static int INDEX_CODEITEMID = 0;
    private final static int INDEX_CODEITEMNAME = 1;
    private final static int INDEX_CODEITEMVALUE = 2;
    private final static int INDEX_CODELISTID = 3;
    private final static int INDEX_CODELISTNAME = 4;
    private final static int INDEX_CREATEDATE = 5;
    private final static int INDEX_CREATEMAN = 6;
    private final static int INDEX_MEMO = 7;
    private final static int INDEX_ORDERVALUE = 8;
    private final static int INDEX_PCODEITEMID = 9;
    private final static int INDEX_PCODEITEMNAME = 10;
    private final static int INDEX_RESERVER = 11;
    private final static int INDEX_RESERVER2 = 12;
    private final static int INDEX_RESERVER3 = 13;
    private final static int INDEX_RESERVER4 = 14;
    private final static int INDEX_RESERVER5 = 15;
    private final static int INDEX_SHORTKEY = 16;
    private final static int INDEX_UPDATEDATE = 17;
    private final static int INDEX_UPDATEMAN = 18;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CODEITEMID, INDEX_CODEITEMID);
        fieldIndexMap.put( FIELD_CODEITEMNAME, INDEX_CODEITEMNAME);
        fieldIndexMap.put( FIELD_CODEITEMVALUE, INDEX_CODEITEMVALUE);
        fieldIndexMap.put( FIELD_CODELISTID, INDEX_CODELISTID);
        fieldIndexMap.put( FIELD_CODELISTNAME, INDEX_CODELISTNAME);
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_MEMO, INDEX_MEMO);
        fieldIndexMap.put( FIELD_ORDERVALUE, INDEX_ORDERVALUE);
        fieldIndexMap.put( FIELD_PCODEITEMID, INDEX_PCODEITEMID);
        fieldIndexMap.put( FIELD_PCODEITEMNAME, INDEX_PCODEITEMNAME);
        fieldIndexMap.put( FIELD_RESERVER, INDEX_RESERVER);
        fieldIndexMap.put( FIELD_RESERVER2, INDEX_RESERVER2);
        fieldIndexMap.put( FIELD_RESERVER3, INDEX_RESERVER3);
        fieldIndexMap.put( FIELD_RESERVER4, INDEX_RESERVER4);
        fieldIndexMap.put( FIELD_RESERVER5, INDEX_RESERVER5);
        fieldIndexMap.put( FIELD_SHORTKEY, INDEX_SHORTKEY);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
    }

    private CodeItemBase proxyCodeItemBase = null;
    public CodeItemBase() {
        super();
    }
    private boolean codeitemidDirtyFlag = false;
    private boolean codeitemnameDirtyFlag = false;
    private boolean codeitemvalueDirtyFlag = false;
    private boolean codelistidDirtyFlag = false;
    private boolean codelistnameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean pcodeitemidDirtyFlag = false;
    private boolean pcodeitemnameDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean reserver3DirtyFlag = false;
    private boolean reserver4DirtyFlag = false;
    private boolean reserver5DirtyFlag = false;
    private boolean shortkeyDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;

    @Column(name="codeitemid")
    private String codeitemid;
    @Column(name="codeitemname")
    private String codeitemname;
    @Column(name="codeitemvalue")
    private String codeitemvalue;
    @Column(name="codelistid")
    private String codelistid;
    @Column(name="codelistname")
    private String codelistname;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="pcodeitemid")
    private String pcodeitemid;
    @Column(name="pcodeitemname")
    private String pcodeitemname;
    @Column(name="reserver")
    private String reserver;
    @Column(name="reserver2")
    private String reserver2;
    @Column(name="reserver3")
    private Integer reserver3;
    @Column(name="reserver4")
    private Double reserver4;
    @Column(name="reserver5")
    private Timestamp reserver5;
    @Column(name="shortkey")
    private String shortkey;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;


    /**
     *  设置属性值[代码项标识]
     *  @param codeitemid
     */
    public void setCodeItemId(String codeitemid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setCodeItemId(codeitemid);
            return;
        }
        if(codeitemid!=null) {
            codeitemid = StringHelper.trimRight(codeitemid);
            if(codeitemid.length()==0) {
                codeitemid = null;
            }
        }
        this.codeitemid = codeitemid;
        this.codeitemidDirtyFlag  = true;
    }

    /**
     *  获取属性值[代码项标识]
     */
    public String getCodeItemId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getCodeItemId();
        }
        return this.codeitemid;
    }

    /**
     *  获取属性值[代码项标识]是否修改
     */
    public boolean isCodeItemIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isCodeItemIdDirty();
        }
        return this.codeitemidDirtyFlag;
    }

    /**
     *  重置属性值[代码项标识]
     */
    public void resetCodeItemId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetCodeItemId();
            return;
        }

        this.codeitemidDirtyFlag = false;
        this.codeitemid = null;
    }
    /**
     *  设置属性值[代码项名称]
     *  @param codeitemname
     */
    public void setCodeItemName(String codeitemname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setCodeItemName(codeitemname);
            return;
        }
        if(codeitemname!=null) {
            codeitemname = StringHelper.trimRight(codeitemname);
            if(codeitemname.length()==0) {
                codeitemname = null;
            }
        }
        this.codeitemname = codeitemname;
        this.codeitemnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[代码项名称]
     */
    public String getCodeItemName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getCodeItemName();
        }
        return this.codeitemname;
    }

    /**
     *  获取属性值[代码项名称]是否修改
     */
    public boolean isCodeItemNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isCodeItemNameDirty();
        }
        return this.codeitemnameDirtyFlag;
    }

    /**
     *  重置属性值[代码项名称]
     */
    public void resetCodeItemName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetCodeItemName();
            return;
        }

        this.codeitemnameDirtyFlag = false;
        this.codeitemname = null;
    }
    /**
     *  设置属性值[代码项值]
     *  @param codeitemvalue
     */
    public void setCodeItemValue(String codeitemvalue) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setCodeItemValue(codeitemvalue);
            return;
        }
        if(codeitemvalue!=null) {
            codeitemvalue = StringHelper.trimRight(codeitemvalue);
            if(codeitemvalue.length()==0) {
                codeitemvalue = null;
            }
        }
        this.codeitemvalue = codeitemvalue;
        this.codeitemvalueDirtyFlag  = true;
    }

    /**
     *  获取属性值[代码项值]
     */
    public String getCodeItemValue() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getCodeItemValue();
        }
        return this.codeitemvalue;
    }

    /**
     *  获取属性值[代码项值]是否修改
     */
    public boolean isCodeItemValueDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isCodeItemValueDirty();
        }
        return this.codeitemvalueDirtyFlag;
    }

    /**
     *  重置属性值[代码项值]
     */
    public void resetCodeItemValue() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetCodeItemValue();
            return;
        }

        this.codeitemvalueDirtyFlag = false;
        this.codeitemvalue = null;
    }
    /**
     *  设置属性值[代码表]
     *  @param codelistid
     */
    public void setCodeListId(String codelistid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setCodeListId(codelistid);
            return;
        }
        if(codelistid!=null) {
            codelistid = StringHelper.trimRight(codelistid);
            if(codelistid.length()==0) {
                codelistid = null;
            }
        }
        this.codelistid = codelistid;
        this.codelistidDirtyFlag  = true;
    }

    /**
     *  获取属性值[代码表]
     */
    public String getCodeListId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getCodeListId();
        }
        return this.codelistid;
    }

    /**
     *  获取属性值[代码表]是否修改
     */
    public boolean isCodeListIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isCodeListIdDirty();
        }
        return this.codelistidDirtyFlag;
    }

    /**
     *  重置属性值[代码表]
     */
    public void resetCodeListId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetCodeListId();
            return;
        }

        this.codelistidDirtyFlag = false;
        this.codelistid = null;
    }
    /**
     *  设置属性值[代码表]
     *  @param codelistname
     */
    public void setCodeListName(String codelistname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setCodeListName(codelistname);
            return;
        }
        if(codelistname!=null) {
            codelistname = StringHelper.trimRight(codelistname);
            if(codelistname.length()==0) {
                codelistname = null;
            }
        }
        this.codelistname = codelistname;
        this.codelistnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[代码表]
     */
    public String getCodeListName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getCodeListName();
        }
        return this.codelistname;
    }

    /**
     *  获取属性值[代码表]是否修改
     */
    public boolean isCodeListNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isCodeListNameDirty();
        }
        return this.codelistnameDirtyFlag;
    }

    /**
     *  重置属性值[代码表]
     */
    public void resetCodeListName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetCodeListName();
            return;
        }

        this.codelistnameDirtyFlag = false;
        this.codelistname = null;
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
     *  设置属性值[备注]
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
     *  获取属性值[备注]
     */
    public String getMemo() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMemo();
        }
        return this.memo;
    }

    /**
     *  获取属性值[备注]是否修改
     */
    public boolean isMemoDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMemoDirty();
        }
        return this.memoDirtyFlag;
    }

    /**
     *  重置属性值[备注]
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
     *  设置属性值[排序值]
     *  @param ordervalue
     */
    public void setOrderValue(Integer ordervalue) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setOrderValue(ordervalue);
            return;
        }
        this.ordervalue = ordervalue;
        this.ordervalueDirtyFlag  = true;
    }

    /**
     *  获取属性值[排序值]
     */
    public Integer getOrderValue() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getOrderValue();
        }
        return this.ordervalue;
    }

    /**
     *  获取属性值[排序值]是否修改
     */
    public boolean isOrderValueDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isOrderValueDirty();
        }
        return this.ordervalueDirtyFlag;
    }

    /**
     *  重置属性值[排序值]
     */
    public void resetOrderValue() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetOrderValue();
            return;
        }

        this.ordervalueDirtyFlag = false;
        this.ordervalue = null;
    }
    /**
     *  设置属性值[上级代码项]
     *  @param pcodeitemid
     */
    public void setPCodeItemId(String pcodeitemid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setPCodeItemId(pcodeitemid);
            return;
        }
        if(pcodeitemid!=null) {
            pcodeitemid = StringHelper.trimRight(pcodeitemid);
            if(pcodeitemid.length()==0) {
                pcodeitemid = null;
            }
        }
        this.pcodeitemid = pcodeitemid;
        this.pcodeitemidDirtyFlag  = true;
    }

    /**
     *  获取属性值[上级代码项]
     */
    public String getPCodeItemId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getPCodeItemId();
        }
        return this.pcodeitemid;
    }

    /**
     *  获取属性值[上级代码项]是否修改
     */
    public boolean isPCodeItemIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isPCodeItemIdDirty();
        }
        return this.pcodeitemidDirtyFlag;
    }

    /**
     *  重置属性值[上级代码项]
     */
    public void resetPCodeItemId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetPCodeItemId();
            return;
        }

        this.pcodeitemidDirtyFlag = false;
        this.pcodeitemid = null;
    }
    /**
     *  设置属性值[上级代码项]
     *  @param pcodeitemname
     */
    public void setPCodeItemName(String pcodeitemname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setPCodeItemName(pcodeitemname);
            return;
        }
        if(pcodeitemname!=null) {
            pcodeitemname = StringHelper.trimRight(pcodeitemname);
            if(pcodeitemname.length()==0) {
                pcodeitemname = null;
            }
        }
        this.pcodeitemname = pcodeitemname;
        this.pcodeitemnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[上级代码项]
     */
    public String getPCodeItemName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getPCodeItemName();
        }
        return this.pcodeitemname;
    }

    /**
     *  获取属性值[上级代码项]是否修改
     */
    public boolean isPCodeItemNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isPCodeItemNameDirty();
        }
        return this.pcodeitemnameDirtyFlag;
    }

    /**
     *  重置属性值[上级代码项]
     */
    public void resetPCodeItemName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetPCodeItemName();
            return;
        }

        this.pcodeitemnameDirtyFlag = false;
        this.pcodeitemname = null;
    }
    /**
     *  设置属性值[保留字段]
     *  @param reserver
     */
    public void setReserver(String reserver) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setReserver(reserver);
            return;
        }
        if(reserver!=null) {
            reserver = StringHelper.trimRight(reserver);
            if(reserver.length()==0) {
                reserver = null;
            }
        }
        this.reserver = reserver;
        this.reserverDirtyFlag  = true;
    }

    /**
     *  获取属性值[保留字段]
     */
    public String getReserver() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getReserver();
        }
        return this.reserver;
    }

    /**
     *  获取属性值[保留字段]是否修改
     */
    public boolean isReserverDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isReserverDirty();
        }
        return this.reserverDirtyFlag;
    }

    /**
     *  重置属性值[保留字段]
     */
    public void resetReserver() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetReserver();
            return;
        }

        this.reserverDirtyFlag = false;
        this.reserver = null;
    }
    /**
     *  设置属性值[保留字段2]
     *  @param reserver2
     */
    public void setReserver2(String reserver2) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setReserver2(reserver2);
            return;
        }
        if(reserver2!=null) {
            reserver2 = StringHelper.trimRight(reserver2);
            if(reserver2.length()==0) {
                reserver2 = null;
            }
        }
        this.reserver2 = reserver2;
        this.reserver2DirtyFlag  = true;
    }

    /**
     *  获取属性值[保留字段2]
     */
    public String getReserver2() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getReserver2();
        }
        return this.reserver2;
    }

    /**
     *  获取属性值[保留字段2]是否修改
     */
    public boolean isReserver2Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isReserver2Dirty();
        }
        return this.reserver2DirtyFlag;
    }

    /**
     *  重置属性值[保留字段2]
     */
    public void resetReserver2() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetReserver2();
            return;
        }

        this.reserver2DirtyFlag = false;
        this.reserver2 = null;
    }
    /**
     *  设置属性值[保留字段3]
     *  @param reserver3
     */
    public void setReserver3(Integer reserver3) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setReserver3(reserver3);
            return;
        }
        this.reserver3 = reserver3;
        this.reserver3DirtyFlag  = true;
    }

    /**
     *  获取属性值[保留字段3]
     */
    public Integer getReserver3() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getReserver3();
        }
        return this.reserver3;
    }

    /**
     *  获取属性值[保留字段3]是否修改
     */
    public boolean isReserver3Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isReserver3Dirty();
        }
        return this.reserver3DirtyFlag;
    }

    /**
     *  重置属性值[保留字段3]
     */
    public void resetReserver3() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetReserver3();
            return;
        }

        this.reserver3DirtyFlag = false;
        this.reserver3 = null;
    }
    /**
     *  设置属性值[保留字段4]
     *  @param reserver4
     */
    public void setReserver4(Double reserver4) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setReserver4(reserver4);
            return;
        }
        this.reserver4 = reserver4;
        this.reserver4DirtyFlag  = true;
    }

    /**
     *  获取属性值[保留字段4]
     */
    public Double getReserver4() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getReserver4();
        }
        return this.reserver4;
    }

    /**
     *  获取属性值[保留字段4]是否修改
     */
    public boolean isReserver4Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isReserver4Dirty();
        }
        return this.reserver4DirtyFlag;
    }

    /**
     *  重置属性值[保留字段4]
     */
    public void resetReserver4() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetReserver4();
            return;
        }

        this.reserver4DirtyFlag = false;
        this.reserver4 = null;
    }
    /**
     *  设置属性值[保留字段5]
     *  @param reserver5
     */
    public void setReserver5(Timestamp reserver5) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setReserver5(reserver5);
            return;
        }
        this.reserver5 = reserver5;
        this.reserver5DirtyFlag  = true;
    }

    /**
     *  获取属性值[保留字段5]
     */
    public Timestamp getReserver5() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getReserver5();
        }
        return this.reserver5;
    }

    /**
     *  获取属性值[保留字段5]是否修改
     */
    public boolean isReserver5Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isReserver5Dirty();
        }
        return this.reserver5DirtyFlag;
    }

    /**
     *  重置属性值[保留字段5]
     */
    public void resetReserver5() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetReserver5();
            return;
        }

        this.reserver5DirtyFlag = false;
        this.reserver5 = null;
    }
    /**
     *  设置属性值[快捷输入]
     *  @param shortkey
     */
    public void setShortKey(String shortkey) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setShortKey(shortkey);
            return;
        }
        if(shortkey!=null) {
            shortkey = StringHelper.trimRight(shortkey);
            if(shortkey.length()==0) {
                shortkey = null;
            }
        }
        this.shortkey = shortkey;
        this.shortkeyDirtyFlag  = true;
    }

    /**
     *  获取属性值[快捷输入]
     */
    public String getShortKey() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getShortKey();
        }
        return this.shortkey;
    }

    /**
     *  获取属性值[快捷输入]是否修改
     */
    public boolean isShortKeyDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isShortKeyDirty();
        }
        return this.shortkeyDirtyFlag;
    }

    /**
     *  重置属性值[快捷输入]
     */
    public void resetShortKey() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetShortKey();
            return;
        }

        this.shortkeyDirtyFlag = false;
        this.shortkey = null;
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
        CodeItemBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(CodeItemBase et) {
        et.resetCodeItemId();
        et.resetCodeItemName();
        et.resetCodeItemValue();
        et.resetCodeListId();
        et.resetCodeListName();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetMemo();
        et.resetOrderValue();
        et.resetPCodeItemId();
        et.resetPCodeItemName();
        et.resetReserver();
        et.resetReserver2();
        et.resetReserver3();
        et.resetReserver4();
        et.resetReserver5();
        et.resetShortKey();
        et.resetUpdateDate();
        et.resetUpdateMan();
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onFillMap(java.util.HashMap, boolean)
     */
    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if(!bDirtyOnly || isCodeItemIdDirty()) {
            params.put(FIELD_CODEITEMID,getCodeItemId());
        }
        if(!bDirtyOnly || isCodeItemNameDirty()) {
            params.put(FIELD_CODEITEMNAME,getCodeItemName());
        }
        if(!bDirtyOnly || isCodeItemValueDirty()) {
            params.put(FIELD_CODEITEMVALUE,getCodeItemValue());
        }
        if(!bDirtyOnly || isCodeListIdDirty()) {
            params.put(FIELD_CODELISTID,getCodeListId());
        }
        if(!bDirtyOnly || isCodeListNameDirty()) {
            params.put(FIELD_CODELISTNAME,getCodeListName());
        }
        if(!bDirtyOnly || isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE,getCreateDate());
        }
        if(!bDirtyOnly || isCreateManDirty()) {
            params.put(FIELD_CREATEMAN,getCreateMan());
        }
        if(!bDirtyOnly || isMemoDirty()) {
            params.put(FIELD_MEMO,getMemo());
        }
        if(!bDirtyOnly || isOrderValueDirty()) {
            params.put(FIELD_ORDERVALUE,getOrderValue());
        }
        if(!bDirtyOnly || isPCodeItemIdDirty()) {
            params.put(FIELD_PCODEITEMID,getPCodeItemId());
        }
        if(!bDirtyOnly || isPCodeItemNameDirty()) {
            params.put(FIELD_PCODEITEMNAME,getPCodeItemName());
        }
        if(!bDirtyOnly || isReserverDirty()) {
            params.put(FIELD_RESERVER,getReserver());
        }
        if(!bDirtyOnly || isReserver2Dirty()) {
            params.put(FIELD_RESERVER2,getReserver2());
        }
        if(!bDirtyOnly || isReserver3Dirty()) {
            params.put(FIELD_RESERVER3,getReserver3());
        }
        if(!bDirtyOnly || isReserver4Dirty()) {
            params.put(FIELD_RESERVER4,getReserver4());
        }
        if(!bDirtyOnly || isReserver5Dirty()) {
            params.put(FIELD_RESERVER5,getReserver5());
        }
        if(!bDirtyOnly || isShortKeyDirty()) {
            params.put(FIELD_SHORTKEY,getShortKey());
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

        return  CodeItemBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(CodeItemBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CODEITEMID:
            return et.getCodeItemId();
        case INDEX_CODEITEMNAME:
            return et.getCodeItemName();
        case INDEX_CODEITEMVALUE:
            return et.getCodeItemValue();
        case INDEX_CODELISTID:
            return et.getCodeListId();
        case INDEX_CODELISTNAME:
            return et.getCodeListName();
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_MEMO:
            return et.getMemo();
        case INDEX_ORDERVALUE:
            return et.getOrderValue();
        case INDEX_PCODEITEMID:
            return et.getPCodeItemId();
        case INDEX_PCODEITEMNAME:
            return et.getPCodeItemName();
        case INDEX_RESERVER:
            return et.getReserver();
        case INDEX_RESERVER2:
            return et.getReserver2();
        case INDEX_RESERVER3:
            return et.getReserver3();
        case INDEX_RESERVER4:
            return et.getReserver4();
        case INDEX_RESERVER5:
            return et.getReserver5();
        case INDEX_SHORTKEY:
            return et.getShortKey();
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

        CodeItemBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(CodeItemBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_CODEITEMID:
            et.setCodeItemId(DataObject.getStringValue(obj));
            return ;
        case INDEX_CODEITEMNAME:
            et.setCodeItemName(DataObject.getStringValue(obj));
            return ;
        case INDEX_CODEITEMVALUE:
            et.setCodeItemValue(DataObject.getStringValue(obj));
            return ;
        case INDEX_CODELISTID:
            et.setCodeListId(DataObject.getStringValue(obj));
            return ;
        case INDEX_CODELISTNAME:
            et.setCodeListName(DataObject.getStringValue(obj));
            return ;
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_MEMO:
            et.setMemo(DataObject.getStringValue(obj));
            return ;
        case INDEX_ORDERVALUE:
            et.setOrderValue(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_PCODEITEMID:
            et.setPCodeItemId(DataObject.getStringValue(obj));
            return ;
        case INDEX_PCODEITEMNAME:
            et.setPCodeItemName(DataObject.getStringValue(obj));
            return ;
        case INDEX_RESERVER:
            et.setReserver(DataObject.getStringValue(obj));
            return ;
        case INDEX_RESERVER2:
            et.setReserver2(DataObject.getStringValue(obj));
            return ;
        case INDEX_RESERVER3:
            et.setReserver3(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_RESERVER4:
            et.setReserver4(DataObject.getDoubleValue(obj));
            return ;
        case INDEX_RESERVER5:
            et.setReserver5(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_SHORTKEY:
            et.setShortKey(DataObject.getStringValue(obj));
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

        return  CodeItemBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(CodeItemBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CODEITEMID:
            return et.getCodeItemId()==null;
        case INDEX_CODEITEMNAME:
            return et.getCodeItemName()==null;
        case INDEX_CODEITEMVALUE:
            return et.getCodeItemValue()==null;
        case INDEX_CODELISTID:
            return et.getCodeListId()==null;
        case INDEX_CODELISTNAME:
            return et.getCodeListName()==null;
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_MEMO:
            return et.getMemo()==null;
        case INDEX_ORDERVALUE:
            return et.getOrderValue()==null;
        case INDEX_PCODEITEMID:
            return et.getPCodeItemId()==null;
        case INDEX_PCODEITEMNAME:
            return et.getPCodeItemName()==null;
        case INDEX_RESERVER:
            return et.getReserver()==null;
        case INDEX_RESERVER2:
            return et.getReserver2()==null;
        case INDEX_RESERVER3:
            return et.getReserver3()==null;
        case INDEX_RESERVER4:
            return et.getReserver4()==null;
        case INDEX_RESERVER5:
            return et.getReserver5()==null;
        case INDEX_SHORTKEY:
            return et.getShortKey()==null;
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
        return  CodeItemBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(CodeItemBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CODEITEMID:
            return et.isCodeItemIdDirty();
        case INDEX_CODEITEMNAME:
            return et.isCodeItemNameDirty();
        case INDEX_CODEITEMVALUE:
            return et.isCodeItemValueDirty();
        case INDEX_CODELISTID:
            return et.isCodeListIdDirty();
        case INDEX_CODELISTNAME:
            return et.isCodeListNameDirty();
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_MEMO:
            return et.isMemoDirty();
        case INDEX_ORDERVALUE:
            return et.isOrderValueDirty();
        case INDEX_PCODEITEMID:
            return et.isPCodeItemIdDirty();
        case INDEX_PCODEITEMNAME:
            return et.isPCodeItemNameDirty();
        case INDEX_RESERVER:
            return et.isReserverDirty();
        case INDEX_RESERVER2:
            return et.isReserver2Dirty();
        case INDEX_RESERVER3:
            return et.isReserver3Dirty();
        case INDEX_RESERVER4:
            return et.isReserver4Dirty();
        case INDEX_RESERVER5:
            return et.isReserver5Dirty();
        case INDEX_SHORTKEY:
            return et.isShortKeyDirty();
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
    private static  void fillJSONObject(CodeItemBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCodeItemId()!=null) {
            JSONObjectHelper.put(json,"codeitemid",getJSONValue(et.getCodeItemId()),false);
        }
        if(bIncEmpty||et.getCodeItemName()!=null) {
            JSONObjectHelper.put(json,"codeitemname",getJSONValue(et.getCodeItemName()),false);
        }
        if(bIncEmpty||et.getCodeItemValue()!=null) {
            JSONObjectHelper.put(json,"codeitemvalue",getJSONValue(et.getCodeItemValue()),false);
        }
        if(bIncEmpty||et.getCodeListId()!=null) {
            JSONObjectHelper.put(json,"codelistid",getJSONValue(et.getCodeListId()),false);
        }
        if(bIncEmpty||et.getCodeListName()!=null) {
            JSONObjectHelper.put(json,"codelistname",getJSONValue(et.getCodeListName()),false);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getMemo()!=null) {
            JSONObjectHelper.put(json,"memo",getJSONValue(et.getMemo()),false);
        }
        if(bIncEmpty||et.getOrderValue()!=null) {
            JSONObjectHelper.put(json,"ordervalue",getJSONValue(et.getOrderValue()),false);
        }
        if(bIncEmpty||et.getPCodeItemId()!=null) {
            JSONObjectHelper.put(json,"pcodeitemid",getJSONValue(et.getPCodeItemId()),false);
        }
        if(bIncEmpty||et.getPCodeItemName()!=null) {
            JSONObjectHelper.put(json,"pcodeitemname",getJSONValue(et.getPCodeItemName()),false);
        }
        if(bIncEmpty||et.getReserver()!=null) {
            JSONObjectHelper.put(json,"reserver",getJSONValue(et.getReserver()),false);
        }
        if(bIncEmpty||et.getReserver2()!=null) {
            JSONObjectHelper.put(json,"reserver2",getJSONValue(et.getReserver2()),false);
        }
        if(bIncEmpty||et.getReserver3()!=null) {
            JSONObjectHelper.put(json,"reserver3",getJSONValue(et.getReserver3()),false);
        }
        if(bIncEmpty||et.getReserver4()!=null) {
            JSONObjectHelper.put(json,"reserver4",getJSONValue(et.getReserver4()),false);
        }
        if(bIncEmpty||et.getReserver5()!=null) {
            JSONObjectHelper.put(json,"reserver5",getJSONValue(et.getReserver5()),false);
        }
        if(bIncEmpty||et.getShortKey()!=null) {
            JSONObjectHelper.put(json,"shortkey",getJSONValue(et.getShortKey()),false);
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
    private static void fillXmlNode(CodeItemBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCodeItemId()!=null) {
            Object obj = et.getCodeItemId();
            node.setAttribute("CODEITEMID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getCodeItemName()!=null) {
            Object obj = et.getCodeItemName();
            node.setAttribute("CODEITEMNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getCodeItemValue()!=null) {
            Object obj = et.getCodeItemValue();
            node.setAttribute("CODEITEMVALUE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getCodeListId()!=null) {
            Object obj = et.getCodeListId();
            node.setAttribute("CODELISTID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getCodeListName()!=null) {
            Object obj = et.getCodeListName();
            node.setAttribute("CODELISTNAME",(obj==null)?"":(String)obj);
        }
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
        if(bIncEmpty||et.getOrderValue()!=null) {
            Object obj = et.getOrderValue();
            node.setAttribute("ORDERVALUE",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getPCodeItemId()!=null) {
            Object obj = et.getPCodeItemId();
            node.setAttribute("PCODEITEMID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getPCodeItemName()!=null) {
            Object obj = et.getPCodeItemName();
            node.setAttribute("PCODEITEMNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getReserver()!=null) {
            Object obj = et.getReserver();
            node.setAttribute("RESERVER",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getReserver2()!=null) {
            Object obj = et.getReserver2();
            node.setAttribute("RESERVER2",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getReserver3()!=null) {
            Object obj = et.getReserver3();
            node.setAttribute("RESERVER3",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getReserver4()!=null) {
            Object obj = et.getReserver4();
            node.setAttribute("RESERVER4",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getReserver5()!=null) {
            Object obj = et.getReserver5();
            node.setAttribute("RESERVER5",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getShortKey()!=null) {
            Object obj = et.getShortKey();
            node.setAttribute("SHORTKEY",(obj==null)?"":(String)obj);
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
        CodeItemBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(CodeItemBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isCodeItemIdDirty() && (bIncEmpty||et.getCodeItemId()!=null)) {
            dst.set(FIELD_CODEITEMID,et.getCodeItemId());
        }
        if(et.isCodeItemNameDirty() && (bIncEmpty||et.getCodeItemName()!=null)) {
            dst.set(FIELD_CODEITEMNAME,et.getCodeItemName());
        }
        if(et.isCodeItemValueDirty() && (bIncEmpty||et.getCodeItemValue()!=null)) {
            dst.set(FIELD_CODEITEMVALUE,et.getCodeItemValue());
        }
        if(et.isCodeListIdDirty() && (bIncEmpty||et.getCodeListId()!=null)) {
            dst.set(FIELD_CODELISTID,et.getCodeListId());
        }
        if(et.isCodeListNameDirty() && (bIncEmpty||et.getCodeListName()!=null)) {
            dst.set(FIELD_CODELISTNAME,et.getCodeListName());
        }
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isMemoDirty() && (bIncEmpty||et.getMemo()!=null)) {
            dst.set(FIELD_MEMO,et.getMemo());
        }
        if(et.isOrderValueDirty() && (bIncEmpty||et.getOrderValue()!=null)) {
            dst.set(FIELD_ORDERVALUE,et.getOrderValue());
        }
        if(et.isPCodeItemIdDirty() && (bIncEmpty||et.getPCodeItemId()!=null)) {
            dst.set(FIELD_PCODEITEMID,et.getPCodeItemId());
        }
        if(et.isPCodeItemNameDirty() && (bIncEmpty||et.getPCodeItemName()!=null)) {
            dst.set(FIELD_PCODEITEMNAME,et.getPCodeItemName());
        }
        if(et.isReserverDirty() && (bIncEmpty||et.getReserver()!=null)) {
            dst.set(FIELD_RESERVER,et.getReserver());
        }
        if(et.isReserver2Dirty() && (bIncEmpty||et.getReserver2()!=null)) {
            dst.set(FIELD_RESERVER2,et.getReserver2());
        }
        if(et.isReserver3Dirty() && (bIncEmpty||et.getReserver3()!=null)) {
            dst.set(FIELD_RESERVER3,et.getReserver3());
        }
        if(et.isReserver4Dirty() && (bIncEmpty||et.getReserver4()!=null)) {
            dst.set(FIELD_RESERVER4,et.getReserver4());
        }
        if(et.isReserver5Dirty() && (bIncEmpty||et.getReserver5()!=null)) {
            dst.set(FIELD_RESERVER5,et.getReserver5());
        }
        if(et.isShortKeyDirty() && (bIncEmpty||et.getShortKey()!=null)) {
            dst.set(FIELD_SHORTKEY,et.getShortKey());
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
        return  CodeItemBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(CodeItemBase et,int index) throws Exception {
        switch(index) {
        case INDEX_CODEITEMID:
            et.resetCodeItemId();
            return true;
        case INDEX_CODEITEMNAME:
            et.resetCodeItemName();
            return true;
        case INDEX_CODEITEMVALUE:
            et.resetCodeItemValue();
            return true;
        case INDEX_CODELISTID:
            et.resetCodeListId();
            return true;
        case INDEX_CODELISTNAME:
            et.resetCodeListName();
            return true;
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_MEMO:
            et.resetMemo();
            return true;
        case INDEX_ORDERVALUE:
            et.resetOrderValue();
            return true;
        case INDEX_PCODEITEMID:
            et.resetPCodeItemId();
            return true;
        case INDEX_PCODEITEMNAME:
            et.resetPCodeItemName();
            return true;
        case INDEX_RESERVER:
            et.resetReserver();
            return true;
        case INDEX_RESERVER2:
            et.resetReserver2();
            return true;
        case INDEX_RESERVER3:
            et.resetReserver3();
            return true;
        case INDEX_RESERVER4:
            et.resetReserver4();
            return true;
        case INDEX_RESERVER5:
            et.resetReserver5();
            return true;
        case INDEX_SHORTKEY:
            et.resetShortKey();
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


    private Integer objPCodeItemLock = new Integer(1);
    private net.ibizsys.psrt.srv.common.entity.CodeItem pcodeitem = null;
    /**
    * 获取父数据 代码项
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.common.entity.CodeItem getPCodeItem() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getPCodeItem();
        }

        if(this.getPCodeItemId()==null)
            return null;
        synchronized(this.objPCodeItemLock) {
            if(this.pcodeitem!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getPCodeItemId(),pcodeitem.getCodeItemId())!=0) {
                    this.pcodeitem = null;
                }
            }


            if(this.pcodeitem==null) {
                net.ibizsys.psrt.srv.common.entity.CodeItem pcodeitem = new net.ibizsys.psrt.srv.common.entity.CodeItem();
                pcodeitem.setCodeItemId(this.getPCodeItemId());
                net.ibizsys.psrt.srv.common.service.CodeItemService service = (net.ibizsys.psrt.srv.common.service.CodeItemService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.CodeItemService.class,this.getSessionFactory());
                service.autoGet(pcodeitem);
                this.pcodeitem = pcodeitem;
            }
            return this.pcodeitem;
        }
    }

    private Integer objCodeListLock = new Integer(1);
    private net.ibizsys.psrt.srv.common.entity.CodeList codelist = null;
    /**
    * 获取父数据 代码表
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.common.entity.CodeList getCodeList() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getCodeList();
        }

        if(this.getCodeListId()==null)
            return null;
        synchronized(this.objCodeListLock) {
            if(this.codelist!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getCodeListId(),codelist.getCodeListId())!=0) {
                    this.codelist = null;
                }
            }


            if(this.codelist==null) {
                net.ibizsys.psrt.srv.common.entity.CodeList codelist = new net.ibizsys.psrt.srv.common.entity.CodeList();
                codelist.setCodeListId(this.getCodeListId());
                net.ibizsys.psrt.srv.common.service.CodeListService service = (net.ibizsys.psrt.srv.common.service.CodeListService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.CodeListService.class,this.getSessionFactory());
                service.autoGet(codelist);
                this.codelist = codelist;
            }
            return this.codelist;
        }
    }



    /**
     *  获取代理的数据对象
     */
    private CodeItemBase getProxyEntity() {
        return this.proxyCodeItemBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyCodeItemBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof CodeItemBase) {
            this.proxyCodeItemBase = (CodeItemBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.CodeItemService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}