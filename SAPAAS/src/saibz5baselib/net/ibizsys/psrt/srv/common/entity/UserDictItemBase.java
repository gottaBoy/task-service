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
 * 实体[UserDictItem] 数据对象基类
 */
public abstract class UserDictItemBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(UserDictItemBase.class);
    /**
     * 属性[完整内容]
     */
    public final static String FIELD_CONTENT = "CONTENT";
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[标记常用]
     */
    public final static String FIELD_MARKFLAG = "MARKFLAG";
    /**
     * 属性[备注]
     */
    public final static String FIELD_MEMO = "MEMO";
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
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";
    /**
     * 属性[词条类别]
     */
    public final static String FIELD_USERDICTCATID = "USERDICTCATID";
    /**
     * 属性[词条类别]
     */
    public final static String FIELD_USERDICTCATNAME = "USERDICTCATNAME";
    /**
     * 属性[用户词典]
     */
    public final static String FIELD_USERDICTID = "USERDICTID";
    /**
     * 属性[用户词典词条标识]
     */
    public final static String FIELD_USERDICTITEMID = "USERDICTITEMID";
    /**
     * 属性[词条名称]
     */
    public final static String FIELD_USERDICTITEMNAME = "USERDICTITEMNAME";
    /**
     * 属性[用户词典]
     */
    public final static String FIELD_USERDICTNAME = "USERDICTNAME";

    private final static int INDEX_CONTENT = 0;
    private final static int INDEX_CREATEDATE = 1;
    private final static int INDEX_CREATEMAN = 2;
    private final static int INDEX_MARKFLAG = 3;
    private final static int INDEX_MEMO = 4;
    private final static int INDEX_RESERVER = 5;
    private final static int INDEX_RESERVER2 = 6;
    private final static int INDEX_RESERVER3 = 7;
    private final static int INDEX_RESERVER4 = 8;
    private final static int INDEX_UPDATEDATE = 9;
    private final static int INDEX_UPDATEMAN = 10;
    private final static int INDEX_USERDICTCATID = 11;
    private final static int INDEX_USERDICTCATNAME = 12;
    private final static int INDEX_USERDICTID = 13;
    private final static int INDEX_USERDICTITEMID = 14;
    private final static int INDEX_USERDICTITEMNAME = 15;
    private final static int INDEX_USERDICTNAME = 16;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CONTENT, INDEX_CONTENT);
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_MARKFLAG, INDEX_MARKFLAG);
        fieldIndexMap.put( FIELD_MEMO, INDEX_MEMO);
        fieldIndexMap.put( FIELD_RESERVER, INDEX_RESERVER);
        fieldIndexMap.put( FIELD_RESERVER2, INDEX_RESERVER2);
        fieldIndexMap.put( FIELD_RESERVER3, INDEX_RESERVER3);
        fieldIndexMap.put( FIELD_RESERVER4, INDEX_RESERVER4);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_USERDICTCATID, INDEX_USERDICTCATID);
        fieldIndexMap.put( FIELD_USERDICTCATNAME, INDEX_USERDICTCATNAME);
        fieldIndexMap.put( FIELD_USERDICTID, INDEX_USERDICTID);
        fieldIndexMap.put( FIELD_USERDICTITEMID, INDEX_USERDICTITEMID);
        fieldIndexMap.put( FIELD_USERDICTITEMNAME, INDEX_USERDICTITEMNAME);
        fieldIndexMap.put( FIELD_USERDICTNAME, INDEX_USERDICTNAME);
    }

    private UserDictItemBase proxyUserDictItemBase = null;
    public UserDictItemBase() {
        super();
    }
    private boolean contentDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean markflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean reserver3DirtyFlag = false;
    private boolean reserver4DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userdictcatidDirtyFlag = false;
    private boolean userdictcatnameDirtyFlag = false;
    private boolean userdictidDirtyFlag = false;
    private boolean userdictitemidDirtyFlag = false;
    private boolean userdictitemnameDirtyFlag = false;
    private boolean userdictnameDirtyFlag = false;

    @Column(name="content")
    private String content;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="markflag")
    private Integer markflag;
    @Column(name="memo")
    private String memo;
    @Column(name="reserver")
    private String reserver;
    @Column(name="reserver2")
    private String reserver2;
    @Column(name="reserver3")
    private String reserver3;
    @Column(name="reserver4")
    private String reserver4;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userdictcatid")
    private String userdictcatid;
    @Column(name="userdictcatname")
    private String userdictcatname;
    @Column(name="userdictid")
    private String userdictid;
    @Column(name="userdictitemid")
    private String userdictitemid;
    @Column(name="userdictitemname")
    private String userdictitemname;
    @Column(name="userdictname")
    private String userdictname;


    /**
     *  设置属性值[完整内容]
     *  @param content
     */
    public void setContent(String content) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setContent(content);
            return;
        }
        if(content!=null) {
            content = StringHelper.trimRight(content);
            if(content.length()==0) {
                content = null;
            }
        }
        this.content = content;
        this.contentDirtyFlag  = true;
    }

    /**
     *  获取属性值[完整内容]
     */
    public String getContent() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getContent();
        }
        return this.content;
    }

    /**
     *  获取属性值[完整内容]是否修改
     */
    public boolean isContentDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isContentDirty();
        }
        return this.contentDirtyFlag;
    }

    /**
     *  重置属性值[完整内容]
     */
    public void resetContent() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetContent();
            return;
        }

        this.contentDirtyFlag = false;
        this.content = null;
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
     *  设置属性值[标记常用]
     *  @param markflag
     */
    public void setMarkFlag(Integer markflag) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setMarkFlag(markflag);
            return;
        }
        this.markflag = markflag;
        this.markflagDirtyFlag  = true;
    }

    /**
     *  获取属性值[标记常用]
     */
    public Integer getMarkFlag() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMarkFlag();
        }
        return this.markflag;
    }

    /**
     *  获取属性值[标记常用]是否修改
     */
    public boolean isMarkFlagDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMarkFlagDirty();
        }
        return this.markflagDirtyFlag;
    }

    /**
     *  重置属性值[标记常用]
     */
    public void resetMarkFlag() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetMarkFlag();
            return;
        }

        this.markflagDirtyFlag = false;
        this.markflag = null;
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
    public void setReserver3(String reserver3) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setReserver3(reserver3);
            return;
        }
        if(reserver3!=null) {
            reserver3 = StringHelper.trimRight(reserver3);
            if(reserver3.length()==0) {
                reserver3 = null;
            }
        }
        this.reserver3 = reserver3;
        this.reserver3DirtyFlag  = true;
    }

    /**
     *  获取属性值[保留字段3]
     */
    public String getReserver3() {
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
    public void setReserver4(String reserver4) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setReserver4(reserver4);
            return;
        }
        if(reserver4!=null) {
            reserver4 = StringHelper.trimRight(reserver4);
            if(reserver4.length()==0) {
                reserver4 = null;
            }
        }
        this.reserver4 = reserver4;
        this.reserver4DirtyFlag  = true;
    }

    /**
     *  获取属性值[保留字段4]
     */
    public String getReserver4() {
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
    /**
     *  设置属性值[词条类别]
     *  @param userdictcatid
     */
    public void setUserDictCatId(String userdictcatid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserDictCatId(userdictcatid);
            return;
        }
        if(userdictcatid!=null) {
            userdictcatid = StringHelper.trimRight(userdictcatid);
            if(userdictcatid.length()==0) {
                userdictcatid = null;
            }
        }
        this.userdictcatid = userdictcatid;
        this.userdictcatidDirtyFlag  = true;
    }

    /**
     *  获取属性值[词条类别]
     */
    public String getUserDictCatId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserDictCatId();
        }
        return this.userdictcatid;
    }

    /**
     *  获取属性值[词条类别]是否修改
     */
    public boolean isUserDictCatIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserDictCatIdDirty();
        }
        return this.userdictcatidDirtyFlag;
    }

    /**
     *  重置属性值[词条类别]
     */
    public void resetUserDictCatId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserDictCatId();
            return;
        }

        this.userdictcatidDirtyFlag = false;
        this.userdictcatid = null;
    }
    /**
     *  设置属性值[词条类别]
     *  @param userdictcatname
     */
    public void setUserDictCatName(String userdictcatname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserDictCatName(userdictcatname);
            return;
        }
        if(userdictcatname!=null) {
            userdictcatname = StringHelper.trimRight(userdictcatname);
            if(userdictcatname.length()==0) {
                userdictcatname = null;
            }
        }
        this.userdictcatname = userdictcatname;
        this.userdictcatnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[词条类别]
     */
    public String getUserDictCatName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserDictCatName();
        }
        return this.userdictcatname;
    }

    /**
     *  获取属性值[词条类别]是否修改
     */
    public boolean isUserDictCatNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserDictCatNameDirty();
        }
        return this.userdictcatnameDirtyFlag;
    }

    /**
     *  重置属性值[词条类别]
     */
    public void resetUserDictCatName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserDictCatName();
            return;
        }

        this.userdictcatnameDirtyFlag = false;
        this.userdictcatname = null;
    }
    /**
     *  设置属性值[用户词典]
     *  @param userdictid
     */
    public void setUserDictId(String userdictid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserDictId(userdictid);
            return;
        }
        if(userdictid!=null) {
            userdictid = StringHelper.trimRight(userdictid);
            if(userdictid.length()==0) {
                userdictid = null;
            }
        }
        this.userdictid = userdictid;
        this.userdictidDirtyFlag  = true;
    }

    /**
     *  获取属性值[用户词典]
     */
    public String getUserDictId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserDictId();
        }
        return this.userdictid;
    }

    /**
     *  获取属性值[用户词典]是否修改
     */
    public boolean isUserDictIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserDictIdDirty();
        }
        return this.userdictidDirtyFlag;
    }

    /**
     *  重置属性值[用户词典]
     */
    public void resetUserDictId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserDictId();
            return;
        }

        this.userdictidDirtyFlag = false;
        this.userdictid = null;
    }
    /**
     *  设置属性值[用户词典词条标识]
     *  @param userdictitemid
     */
    public void setUserDictItemId(String userdictitemid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserDictItemId(userdictitemid);
            return;
        }
        if(userdictitemid!=null) {
            userdictitemid = StringHelper.trimRight(userdictitemid);
            if(userdictitemid.length()==0) {
                userdictitemid = null;
            }
        }
        this.userdictitemid = userdictitemid;
        this.userdictitemidDirtyFlag  = true;
    }

    /**
     *  获取属性值[用户词典词条标识]
     */
    public String getUserDictItemId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserDictItemId();
        }
        return this.userdictitemid;
    }

    /**
     *  获取属性值[用户词典词条标识]是否修改
     */
    public boolean isUserDictItemIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserDictItemIdDirty();
        }
        return this.userdictitemidDirtyFlag;
    }

    /**
     *  重置属性值[用户词典词条标识]
     */
    public void resetUserDictItemId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserDictItemId();
            return;
        }

        this.userdictitemidDirtyFlag = false;
        this.userdictitemid = null;
    }
    /**
     *  设置属性值[词条名称]
     *  @param userdictitemname
     */
    public void setUserDictItemName(String userdictitemname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserDictItemName(userdictitemname);
            return;
        }
        if(userdictitemname!=null) {
            userdictitemname = StringHelper.trimRight(userdictitemname);
            if(userdictitemname.length()==0) {
                userdictitemname = null;
            }
        }
        this.userdictitemname = userdictitemname;
        this.userdictitemnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[词条名称]
     */
    public String getUserDictItemName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserDictItemName();
        }
        return this.userdictitemname;
    }

    /**
     *  获取属性值[词条名称]是否修改
     */
    public boolean isUserDictItemNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserDictItemNameDirty();
        }
        return this.userdictitemnameDirtyFlag;
    }

    /**
     *  重置属性值[词条名称]
     */
    public void resetUserDictItemName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserDictItemName();
            return;
        }

        this.userdictitemnameDirtyFlag = false;
        this.userdictitemname = null;
    }
    /**
     *  设置属性值[用户词典]
     *  @param userdictname
     */
    public void setUserDictName(String userdictname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserDictName(userdictname);
            return;
        }
        if(userdictname!=null) {
            userdictname = StringHelper.trimRight(userdictname);
            if(userdictname.length()==0) {
                userdictname = null;
            }
        }
        this.userdictname = userdictname;
        this.userdictnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[用户词典]
     */
    public String getUserDictName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserDictName();
        }
        return this.userdictname;
    }

    /**
     *  获取属性值[用户词典]是否修改
     */
    public boolean isUserDictNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserDictNameDirty();
        }
        return this.userdictnameDirtyFlag;
    }

    /**
     *  重置属性值[用户词典]
     */
    public void resetUserDictName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserDictName();
            return;
        }

        this.userdictnameDirtyFlag = false;
        this.userdictname = null;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        UserDictItemBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(UserDictItemBase et) {
        et.resetContent();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetMarkFlag();
        et.resetMemo();
        et.resetReserver();
        et.resetReserver2();
        et.resetReserver3();
        et.resetReserver4();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetUserDictCatId();
        et.resetUserDictCatName();
        et.resetUserDictId();
        et.resetUserDictItemId();
        et.resetUserDictItemName();
        et.resetUserDictName();
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onFillMap(java.util.HashMap, boolean)
     */
    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if(!bDirtyOnly || isContentDirty()) {
            params.put(FIELD_CONTENT,getContent());
        }
        if(!bDirtyOnly || isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE,getCreateDate());
        }
        if(!bDirtyOnly || isCreateManDirty()) {
            params.put(FIELD_CREATEMAN,getCreateMan());
        }
        if(!bDirtyOnly || isMarkFlagDirty()) {
            params.put(FIELD_MARKFLAG,getMarkFlag());
        }
        if(!bDirtyOnly || isMemoDirty()) {
            params.put(FIELD_MEMO,getMemo());
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
        if(!bDirtyOnly || isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE,getUpdateDate());
        }
        if(!bDirtyOnly || isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN,getUpdateMan());
        }
        if(!bDirtyOnly || isUserDictCatIdDirty()) {
            params.put(FIELD_USERDICTCATID,getUserDictCatId());
        }
        if(!bDirtyOnly || isUserDictCatNameDirty()) {
            params.put(FIELD_USERDICTCATNAME,getUserDictCatName());
        }
        if(!bDirtyOnly || isUserDictIdDirty()) {
            params.put(FIELD_USERDICTID,getUserDictId());
        }
        if(!bDirtyOnly || isUserDictItemIdDirty()) {
            params.put(FIELD_USERDICTITEMID,getUserDictItemId());
        }
        if(!bDirtyOnly || isUserDictItemNameDirty()) {
            params.put(FIELD_USERDICTITEMNAME,getUserDictItemName());
        }
        if(!bDirtyOnly || isUserDictNameDirty()) {
            params.put(FIELD_USERDICTNAME,getUserDictName());
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

        return  UserDictItemBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(UserDictItemBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CONTENT:
            return et.getContent();
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_MARKFLAG:
            return et.getMarkFlag();
        case INDEX_MEMO:
            return et.getMemo();
        case INDEX_RESERVER:
            return et.getReserver();
        case INDEX_RESERVER2:
            return et.getReserver2();
        case INDEX_RESERVER3:
            return et.getReserver3();
        case INDEX_RESERVER4:
            return et.getReserver4();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
        case INDEX_USERDICTCATID:
            return et.getUserDictCatId();
        case INDEX_USERDICTCATNAME:
            return et.getUserDictCatName();
        case INDEX_USERDICTID:
            return et.getUserDictId();
        case INDEX_USERDICTITEMID:
            return et.getUserDictItemId();
        case INDEX_USERDICTITEMNAME:
            return et.getUserDictItemName();
        case INDEX_USERDICTNAME:
            return et.getUserDictName();
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

        UserDictItemBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(UserDictItemBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_CONTENT:
            et.setContent(DataObject.getStringValue(obj));
            return ;
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_MARKFLAG:
            et.setMarkFlag(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_MEMO:
            et.setMemo(DataObject.getStringValue(obj));
            return ;
        case INDEX_RESERVER:
            et.setReserver(DataObject.getStringValue(obj));
            return ;
        case INDEX_RESERVER2:
            et.setReserver2(DataObject.getStringValue(obj));
            return ;
        case INDEX_RESERVER3:
            et.setReserver3(DataObject.getStringValue(obj));
            return ;
        case INDEX_RESERVER4:
            et.setReserver4(DataObject.getStringValue(obj));
            return ;
        case INDEX_UPDATEDATE:
            et.setUpdateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_UPDATEMAN:
            et.setUpdateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERDICTCATID:
            et.setUserDictCatId(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERDICTCATNAME:
            et.setUserDictCatName(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERDICTID:
            et.setUserDictId(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERDICTITEMID:
            et.setUserDictItemId(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERDICTITEMNAME:
            et.setUserDictItemName(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERDICTNAME:
            et.setUserDictName(DataObject.getStringValue(obj));
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

        return  UserDictItemBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(UserDictItemBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CONTENT:
            return et.getContent()==null;
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_MARKFLAG:
            return et.getMarkFlag()==null;
        case INDEX_MEMO:
            return et.getMemo()==null;
        case INDEX_RESERVER:
            return et.getReserver()==null;
        case INDEX_RESERVER2:
            return et.getReserver2()==null;
        case INDEX_RESERVER3:
            return et.getReserver3()==null;
        case INDEX_RESERVER4:
            return et.getReserver4()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
        case INDEX_USERDICTCATID:
            return et.getUserDictCatId()==null;
        case INDEX_USERDICTCATNAME:
            return et.getUserDictCatName()==null;
        case INDEX_USERDICTID:
            return et.getUserDictId()==null;
        case INDEX_USERDICTITEMID:
            return et.getUserDictItemId()==null;
        case INDEX_USERDICTITEMNAME:
            return et.getUserDictItemName()==null;
        case INDEX_USERDICTNAME:
            return et.getUserDictName()==null;
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
        return  UserDictItemBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(UserDictItemBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CONTENT:
            return et.isContentDirty();
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_MARKFLAG:
            return et.isMarkFlagDirty();
        case INDEX_MEMO:
            return et.isMemoDirty();
        case INDEX_RESERVER:
            return et.isReserverDirty();
        case INDEX_RESERVER2:
            return et.isReserver2Dirty();
        case INDEX_RESERVER3:
            return et.isReserver3Dirty();
        case INDEX_RESERVER4:
            return et.isReserver4Dirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
        case INDEX_USERDICTCATID:
            return et.isUserDictCatIdDirty();
        case INDEX_USERDICTCATNAME:
            return et.isUserDictCatNameDirty();
        case INDEX_USERDICTID:
            return et.isUserDictIdDirty();
        case INDEX_USERDICTITEMID:
            return et.isUserDictItemIdDirty();
        case INDEX_USERDICTITEMNAME:
            return et.isUserDictItemNameDirty();
        case INDEX_USERDICTNAME:
            return et.isUserDictNameDirty();
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
    private static  void fillJSONObject(UserDictItemBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getContent()!=null) {
            JSONObjectHelper.put(json,"content",getJSONValue(et.getContent()),false);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getMarkFlag()!=null) {
            JSONObjectHelper.put(json,"markflag",getJSONValue(et.getMarkFlag()),false);
        }
        if(bIncEmpty||et.getMemo()!=null) {
            JSONObjectHelper.put(json,"memo",getJSONValue(et.getMemo()),false);
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
        if(bIncEmpty||et.getUpdateDate()!=null) {
            JSONObjectHelper.put(json,"updatedate",getJSONValue(et.getUpdateDate()),false);
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            JSONObjectHelper.put(json,"updateman",getJSONValue(et.getUpdateMan()),false);
        }
        if(bIncEmpty||et.getUserDictCatId()!=null) {
            JSONObjectHelper.put(json,"userdictcatid",getJSONValue(et.getUserDictCatId()),false);
        }
        if(bIncEmpty||et.getUserDictCatName()!=null) {
            JSONObjectHelper.put(json,"userdictcatname",getJSONValue(et.getUserDictCatName()),false);
        }
        if(bIncEmpty||et.getUserDictId()!=null) {
            JSONObjectHelper.put(json,"userdictid",getJSONValue(et.getUserDictId()),false);
        }
        if(bIncEmpty||et.getUserDictItemId()!=null) {
            JSONObjectHelper.put(json,"userdictitemid",getJSONValue(et.getUserDictItemId()),false);
        }
        if(bIncEmpty||et.getUserDictItemName()!=null) {
            JSONObjectHelper.put(json,"userdictitemname",getJSONValue(et.getUserDictItemName()),false);
        }
        if(bIncEmpty||et.getUserDictName()!=null) {
            JSONObjectHelper.put(json,"userdictname",getJSONValue(et.getUserDictName()),false);
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
    private static void fillXmlNode(UserDictItemBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getContent()!=null) {
            Object obj = et.getContent();
            node.setAttribute("CONTENT",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getMarkFlag()!=null) {
            Object obj = et.getMarkFlag();
            node.setAttribute("MARKFLAG",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getMemo()!=null) {
            Object obj = et.getMemo();
            node.setAttribute("MEMO",(obj==null)?"":(String)obj);
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
            node.setAttribute("RESERVER3",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getReserver4()!=null) {
            Object obj = et.getReserver4();
            node.setAttribute("RESERVER4",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            Object obj = et.getUpdateDate();
            node.setAttribute("UPDATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            Object obj = et.getUpdateMan();
            node.setAttribute("UPDATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserDictCatId()!=null) {
            Object obj = et.getUserDictCatId();
            node.setAttribute("USERDICTCATID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserDictCatName()!=null) {
            Object obj = et.getUserDictCatName();
            node.setAttribute("USERDICTCATNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserDictId()!=null) {
            Object obj = et.getUserDictId();
            node.setAttribute("USERDICTID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserDictItemId()!=null) {
            Object obj = et.getUserDictItemId();
            node.setAttribute("USERDICTITEMID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserDictItemName()!=null) {
            Object obj = et.getUserDictItemName();
            node.setAttribute("USERDICTITEMNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserDictName()!=null) {
            Object obj = et.getUserDictName();
            node.setAttribute("USERDICTNAME",(obj==null)?"":(String)obj);
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        UserDictItemBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(UserDictItemBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isContentDirty() && (bIncEmpty||et.getContent()!=null)) {
            dst.set(FIELD_CONTENT,et.getContent());
        }
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isMarkFlagDirty() && (bIncEmpty||et.getMarkFlag()!=null)) {
            dst.set(FIELD_MARKFLAG,et.getMarkFlag());
        }
        if(et.isMemoDirty() && (bIncEmpty||et.getMemo()!=null)) {
            dst.set(FIELD_MEMO,et.getMemo());
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
        if(et.isUpdateDateDirty() && (bIncEmpty||et.getUpdateDate()!=null)) {
            dst.set(FIELD_UPDATEDATE,et.getUpdateDate());
        }
        if(et.isUpdateManDirty() && (bIncEmpty||et.getUpdateMan()!=null)) {
            dst.set(FIELD_UPDATEMAN,et.getUpdateMan());
        }
        if(et.isUserDictCatIdDirty() && (bIncEmpty||et.getUserDictCatId()!=null)) {
            dst.set(FIELD_USERDICTCATID,et.getUserDictCatId());
        }
        if(et.isUserDictCatNameDirty() && (bIncEmpty||et.getUserDictCatName()!=null)) {
            dst.set(FIELD_USERDICTCATNAME,et.getUserDictCatName());
        }
        if(et.isUserDictIdDirty() && (bIncEmpty||et.getUserDictId()!=null)) {
            dst.set(FIELD_USERDICTID,et.getUserDictId());
        }
        if(et.isUserDictItemIdDirty() && (bIncEmpty||et.getUserDictItemId()!=null)) {
            dst.set(FIELD_USERDICTITEMID,et.getUserDictItemId());
        }
        if(et.isUserDictItemNameDirty() && (bIncEmpty||et.getUserDictItemName()!=null)) {
            dst.set(FIELD_USERDICTITEMNAME,et.getUserDictItemName());
        }
        if(et.isUserDictNameDirty() && (bIncEmpty||et.getUserDictName()!=null)) {
            dst.set(FIELD_USERDICTNAME,et.getUserDictName());
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
        return  UserDictItemBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(UserDictItemBase et,int index) throws Exception {
        switch(index) {
        case INDEX_CONTENT:
            et.resetContent();
            return true;
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_MARKFLAG:
            et.resetMarkFlag();
            return true;
        case INDEX_MEMO:
            et.resetMemo();
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
        case INDEX_UPDATEDATE:
            et.resetUpdateDate();
            return true;
        case INDEX_UPDATEMAN:
            et.resetUpdateMan();
            return true;
        case INDEX_USERDICTCATID:
            et.resetUserDictCatId();
            return true;
        case INDEX_USERDICTCATNAME:
            et.resetUserDictCatName();
            return true;
        case INDEX_USERDICTID:
            et.resetUserDictId();
            return true;
        case INDEX_USERDICTITEMID:
            et.resetUserDictItemId();
            return true;
        case INDEX_USERDICTITEMNAME:
            et.resetUserDictItemName();
            return true;
        case INDEX_USERDICTNAME:
            et.resetUserDictName();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }


    private Integer objUserDictCatLock = new Integer(1);
    private net.ibizsys.psrt.srv.common.entity.UserDictCat userdictcat = null;
    /**
    * 获取父数据 用户词条类别
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.common.entity.UserDictCat getUserDictCat() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserDictCat();
        }

        if(this.getUserDictCatId()==null)
            return null;
        synchronized(this.objUserDictCatLock) {
            if(this.userdictcat!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getUserDictCatId(),userdictcat.getUserDictCatId())!=0) {
                    this.userdictcat = null;
                }
            }


            if(this.userdictcat==null) {
                net.ibizsys.psrt.srv.common.entity.UserDictCat userdictcat = new net.ibizsys.psrt.srv.common.entity.UserDictCat();
                userdictcat.setUserDictCatId(this.getUserDictCatId());
                net.ibizsys.psrt.srv.common.service.UserDictCatService service = (net.ibizsys.psrt.srv.common.service.UserDictCatService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.UserDictCatService.class,this.getSessionFactory());
                service.autoGet(userdictcat);
                this.userdictcat = userdictcat;
            }
            return this.userdictcat;
        }
    }

    private Integer objUserDictLock = new Integer(1);
    private net.ibizsys.psrt.srv.common.entity.UserDict userdict = null;
    /**
    * 获取父数据 用户词典
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.common.entity.UserDict getUserDict() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserDict();
        }

        if(this.getUserDictId()==null)
            return null;
        synchronized(this.objUserDictLock) {
            if(this.userdict!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getUserDictId(),userdict.getUserDictId())!=0) {
                    this.userdict = null;
                }
            }


            if(this.userdict==null) {
                net.ibizsys.psrt.srv.common.entity.UserDict userdict = new net.ibizsys.psrt.srv.common.entity.UserDict();
                userdict.setUserDictId(this.getUserDictId());
                net.ibizsys.psrt.srv.common.service.UserDictService service = (net.ibizsys.psrt.srv.common.service.UserDictService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.UserDictService.class,this.getSessionFactory());
                service.autoGet(userdict);
                this.userdict = userdict;
            }
            return this.userdict;
        }
    }



    /**
     *  获取代理的数据对象
     */
    private UserDictItemBase getProxyEntity() {
        return this.proxyUserDictItemBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyUserDictItemBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof UserDictItemBase) {
            this.proxyUserDictItemBase = (UserDictItemBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.UserDictItemService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}