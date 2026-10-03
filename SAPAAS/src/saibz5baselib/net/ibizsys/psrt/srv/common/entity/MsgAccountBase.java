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
 * 实体[MsgAccount] 数据对象基类
 */
public abstract class MsgAccountBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(MsgAccountBase.class);
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[逻辑有效标志]
     */
    public final static String FIELD_ENABLE = "ENABLE";
    /**
     * 属性[目录模型]
     */
    public final static String FIELD_FOLDERMODEL = "FOLDERMODEL";
    /**
     * 属性[消息账户组]
     */
    public final static String FIELD_ISLIST = "ISLIST";
    /**
     * 属性[邮件地址]
     */
    public final static String FIELD_MAILADDRESS = "MAILADDRESS";
    /**
     * 属性[移动电话]
     */
    public final static String FIELD_MOBILE = "MOBILE";
    /**
     * 属性[消息账户标识]
     */
    public final static String FIELD_MSGACCOUNTID = "MSGACCOUNTID";
    /**
     * 属性[消息账户名称]
     */
    public final static String FIELD_MSGACCOUNTNAME = "MSGACCOUNTNAME";
    /**
     * 属性[地址]
     */
    public final static String FIELD_MSGADDRESS = "MSGADDRESS";
    /**
     * 属性[MSN邮件地址]
     */
    public final static String FIELD_MSNEMAIL = "MSNEMAIL";
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
     * 属性[微信地址]
     */
    public final static String FIELD_WECHARADDR = "WECHARADDR";
    /**
     * 属性[微信地址]
     */
    public final static String FIELD_WXADDR = "WXADDR";

    private final static int INDEX_CREATEDATE = 0;
    private final static int INDEX_CREATEMAN = 1;
    private final static int INDEX_ENABLE = 2;
    private final static int INDEX_FOLDERMODEL = 3;
    private final static int INDEX_ISLIST = 4;
    private final static int INDEX_MAILADDRESS = 5;
    private final static int INDEX_MOBILE = 6;
    private final static int INDEX_MSGACCOUNTID = 7;
    private final static int INDEX_MSGACCOUNTNAME = 8;
    private final static int INDEX_MSGADDRESS = 9;
    private final static int INDEX_MSNEMAIL = 10;
    private final static int INDEX_RESERVER = 11;
    private final static int INDEX_RESERVER2 = 12;
    private final static int INDEX_RESERVER3 = 13;
    private final static int INDEX_RESERVER4 = 14;
    private final static int INDEX_UPDATEDATE = 15;
    private final static int INDEX_UPDATEMAN = 16;
    private final static int INDEX_WECHARADDR = 17;
    private final static int INDEX_WXADDR = 18;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_ENABLE, INDEX_ENABLE);
        fieldIndexMap.put( FIELD_FOLDERMODEL, INDEX_FOLDERMODEL);
        fieldIndexMap.put( FIELD_ISLIST, INDEX_ISLIST);
        fieldIndexMap.put( FIELD_MAILADDRESS, INDEX_MAILADDRESS);
        fieldIndexMap.put( FIELD_MOBILE, INDEX_MOBILE);
        fieldIndexMap.put( FIELD_MSGACCOUNTID, INDEX_MSGACCOUNTID);
        fieldIndexMap.put( FIELD_MSGACCOUNTNAME, INDEX_MSGACCOUNTNAME);
        fieldIndexMap.put( FIELD_MSGADDRESS, INDEX_MSGADDRESS);
        fieldIndexMap.put( FIELD_MSNEMAIL, INDEX_MSNEMAIL);
        fieldIndexMap.put( FIELD_RESERVER, INDEX_RESERVER);
        fieldIndexMap.put( FIELD_RESERVER2, INDEX_RESERVER2);
        fieldIndexMap.put( FIELD_RESERVER3, INDEX_RESERVER3);
        fieldIndexMap.put( FIELD_RESERVER4, INDEX_RESERVER4);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_WECHARADDR, INDEX_WECHARADDR);
        fieldIndexMap.put( FIELD_WXADDR, INDEX_WXADDR);
    }

    private MsgAccountBase proxyMsgAccountBase = null;
    public MsgAccountBase() {
        super();
    }
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean enableDirtyFlag = false;
    private boolean foldermodelDirtyFlag = false;
    private boolean islistDirtyFlag = false;
    private boolean mailaddressDirtyFlag = false;
    private boolean mobileDirtyFlag = false;
    private boolean msgaccountidDirtyFlag = false;
    private boolean msgaccountnameDirtyFlag = false;
    private boolean msgaddressDirtyFlag = false;
    private boolean msnemailDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean reserver3DirtyFlag = false;
    private boolean reserver4DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wecharaddrDirtyFlag = false;
    private boolean wxaddrDirtyFlag = false;

    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="enable")
    private Integer enable;
    @Column(name="foldermodel")
    private String foldermodel;
    @Column(name="islist")
    private Integer islist;
    @Column(name="mailaddress")
    private String mailaddress;
    @Column(name="mobile")
    private String mobile;
    @Column(name="msgaccountid")
    private String msgaccountid;
    @Column(name="msgaccountname")
    private String msgaccountname;
    @Column(name="msgaddress")
    private String msgaddress;
    @Column(name="msnemail")
    private String msnemail;
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
    @Column(name="wecharaddr")
    private String wecharaddr;
    @Column(name="wxaddr")
    private String wxaddr;


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
     *  设置属性值[逻辑有效标志]
     *  @param enable
     */
    public void setEnable(Integer enable) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setEnable(enable);
            return;
        }
        this.enable = enable;
        this.enableDirtyFlag  = true;
    }

    /**
     *  获取属性值[逻辑有效标志]
     */
    public Integer getEnable() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getEnable();
        }
        return this.enable;
    }

    /**
     *  获取属性值[逻辑有效标志]是否修改
     */
    public boolean isEnableDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isEnableDirty();
        }
        return this.enableDirtyFlag;
    }

    /**
     *  重置属性值[逻辑有效标志]
     */
    public void resetEnable() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetEnable();
            return;
        }

        this.enableDirtyFlag = false;
        this.enable = null;
    }
    /**
     *  设置属性值[目录模型]
     *  @param foldermodel
     */
    public void setFolderModel(String foldermodel) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setFolderModel(foldermodel);
            return;
        }
        if(foldermodel!=null) {
            foldermodel = StringHelper.trimRight(foldermodel);
            if(foldermodel.length()==0) {
                foldermodel = null;
            }
        }
        this.foldermodel = foldermodel;
        this.foldermodelDirtyFlag  = true;
    }

    /**
     *  获取属性值[目录模型]
     */
    public String getFolderModel() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getFolderModel();
        }
        return this.foldermodel;
    }

    /**
     *  获取属性值[目录模型]是否修改
     */
    public boolean isFolderModelDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isFolderModelDirty();
        }
        return this.foldermodelDirtyFlag;
    }

    /**
     *  重置属性值[目录模型]
     */
    public void resetFolderModel() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetFolderModel();
            return;
        }

        this.foldermodelDirtyFlag = false;
        this.foldermodel = null;
    }
    /**
     *  设置属性值[消息账户组]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param islist
     */
    public void setIsList(Integer islist) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setIsList(islist);
            return;
        }
        this.islist = islist;
        this.islistDirtyFlag  = true;
    }

    /**
     *  获取属性值[消息账户组]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getIsList() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getIsList();
        }
        return this.islist;
    }

    /**
     *  获取属性值[消息账户组]是否修改
     */
    public boolean isIsListDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isIsListDirty();
        }
        return this.islistDirtyFlag;
    }

    /**
     *  重置属性值[消息账户组]
     */
    public void resetIsList() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetIsList();
            return;
        }

        this.islistDirtyFlag = false;
        this.islist = null;
    }
    /**
     *  设置属性值[邮件地址]
     *  @param mailaddress
     */
    public void setMailAddress(String mailaddress) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setMailAddress(mailaddress);
            return;
        }
        if(mailaddress!=null) {
            mailaddress = StringHelper.trimRight(mailaddress);
            if(mailaddress.length()==0) {
                mailaddress = null;
            }
        }
        this.mailaddress = mailaddress;
        this.mailaddressDirtyFlag  = true;
    }

    /**
     *  获取属性值[邮件地址]
     */
    public String getMailAddress() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMailAddress();
        }
        return this.mailaddress;
    }

    /**
     *  获取属性值[邮件地址]是否修改
     */
    public boolean isMailAddressDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMailAddressDirty();
        }
        return this.mailaddressDirtyFlag;
    }

    /**
     *  重置属性值[邮件地址]
     */
    public void resetMailAddress() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetMailAddress();
            return;
        }

        this.mailaddressDirtyFlag = false;
        this.mailaddress = null;
    }
    /**
     *  设置属性值[移动电话]
     *  @param mobile
     */
    public void setMobile(String mobile) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setMobile(mobile);
            return;
        }
        if(mobile!=null) {
            mobile = StringHelper.trimRight(mobile);
            if(mobile.length()==0) {
                mobile = null;
            }
        }
        this.mobile = mobile;
        this.mobileDirtyFlag  = true;
    }

    /**
     *  获取属性值[移动电话]
     */
    public String getMobile() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMobile();
        }
        return this.mobile;
    }

    /**
     *  获取属性值[移动电话]是否修改
     */
    public boolean isMobileDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMobileDirty();
        }
        return this.mobileDirtyFlag;
    }

    /**
     *  重置属性值[移动电话]
     */
    public void resetMobile() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetMobile();
            return;
        }

        this.mobileDirtyFlag = false;
        this.mobile = null;
    }
    /**
     *  设置属性值[消息账户标识]
     *  @param msgaccountid
     */
    public void setMsgAccountId(String msgaccountid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setMsgAccountId(msgaccountid);
            return;
        }
        if(msgaccountid!=null) {
            msgaccountid = StringHelper.trimRight(msgaccountid);
            if(msgaccountid.length()==0) {
                msgaccountid = null;
            }
        }
        this.msgaccountid = msgaccountid;
        this.msgaccountidDirtyFlag  = true;
    }

    /**
     *  获取属性值[消息账户标识]
     */
    public String getMsgAccountId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMsgAccountId();
        }
        return this.msgaccountid;
    }

    /**
     *  获取属性值[消息账户标识]是否修改
     */
    public boolean isMsgAccountIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMsgAccountIdDirty();
        }
        return this.msgaccountidDirtyFlag;
    }

    /**
     *  重置属性值[消息账户标识]
     */
    public void resetMsgAccountId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetMsgAccountId();
            return;
        }

        this.msgaccountidDirtyFlag = false;
        this.msgaccountid = null;
    }
    /**
     *  设置属性值[消息账户名称]
     *  @param msgaccountname
     */
    public void setMsgAccountName(String msgaccountname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setMsgAccountName(msgaccountname);
            return;
        }
        if(msgaccountname!=null) {
            msgaccountname = StringHelper.trimRight(msgaccountname);
            if(msgaccountname.length()==0) {
                msgaccountname = null;
            }
        }
        this.msgaccountname = msgaccountname;
        this.msgaccountnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[消息账户名称]
     */
    public String getMsgAccountName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMsgAccountName();
        }
        return this.msgaccountname;
    }

    /**
     *  获取属性值[消息账户名称]是否修改
     */
    public boolean isMsgAccountNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMsgAccountNameDirty();
        }
        return this.msgaccountnameDirtyFlag;
    }

    /**
     *  重置属性值[消息账户名称]
     */
    public void resetMsgAccountName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetMsgAccountName();
            return;
        }

        this.msgaccountnameDirtyFlag = false;
        this.msgaccountname = null;
    }
    /**
     *  设置属性值[地址]
     *  @param msgaddress
     */
    public void setMsgAddress(String msgaddress) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setMsgAddress(msgaddress);
            return;
        }
        if(msgaddress!=null) {
            msgaddress = StringHelper.trimRight(msgaddress);
            if(msgaddress.length()==0) {
                msgaddress = null;
            }
        }
        this.msgaddress = msgaddress;
        this.msgaddressDirtyFlag  = true;
    }

    /**
     *  获取属性值[地址]
     */
    public String getMsgAddress() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMsgAddress();
        }
        return this.msgaddress;
    }

    /**
     *  获取属性值[地址]是否修改
     */
    public boolean isMsgAddressDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMsgAddressDirty();
        }
        return this.msgaddressDirtyFlag;
    }

    /**
     *  重置属性值[地址]
     */
    public void resetMsgAddress() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetMsgAddress();
            return;
        }

        this.msgaddressDirtyFlag = false;
        this.msgaddress = null;
    }
    /**
     *  设置属性值[MSN邮件地址]
     *  @param msnemail
     */
    public void setMsnEmail(String msnemail) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setMsnEmail(msnemail);
            return;
        }
        if(msnemail!=null) {
            msnemail = StringHelper.trimRight(msnemail);
            if(msnemail.length()==0) {
                msnemail = null;
            }
        }
        this.msnemail = msnemail;
        this.msnemailDirtyFlag  = true;
    }

    /**
     *  获取属性值[MSN邮件地址]
     */
    public String getMsnEmail() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMsnEmail();
        }
        return this.msnemail;
    }

    /**
     *  获取属性值[MSN邮件地址]是否修改
     */
    public boolean isMsnEmailDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMsnEmailDirty();
        }
        return this.msnemailDirtyFlag;
    }

    /**
     *  重置属性值[MSN邮件地址]
     */
    public void resetMsnEmail() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetMsnEmail();
            return;
        }

        this.msnemailDirtyFlag = false;
        this.msnemail = null;
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
     *  设置属性值[微信地址]
     *  @param wecharaddr
     */
    public void setWeCharAddr(String wecharaddr) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWeCharAddr(wecharaddr);
            return;
        }
        if(wecharaddr!=null) {
            wecharaddr = StringHelper.trimRight(wecharaddr);
            if(wecharaddr.length()==0) {
                wecharaddr = null;
            }
        }
        this.wecharaddr = wecharaddr;
        this.wecharaddrDirtyFlag  = true;
    }

    /**
     *  获取属性值[微信地址]
     */
    public String getWeCharAddr() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWeCharAddr();
        }
        return this.wecharaddr;
    }

    /**
     *  获取属性值[微信地址]是否修改
     */
    public boolean isWeCharAddrDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWeCharAddrDirty();
        }
        return this.wecharaddrDirtyFlag;
    }

    /**
     *  重置属性值[微信地址]
     */
    public void resetWeCharAddr() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWeCharAddr();
            return;
        }

        this.wecharaddrDirtyFlag = false;
        this.wecharaddr = null;
    }
    /**
     *  设置属性值[微信地址]
     *  @param wxaddr
     */
    public void setWXAddr(String wxaddr) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWXAddr(wxaddr);
            return;
        }
        if(wxaddr!=null) {
            wxaddr = StringHelper.trimRight(wxaddr);
            if(wxaddr.length()==0) {
                wxaddr = null;
            }
        }
        this.wxaddr = wxaddr;
        this.wxaddrDirtyFlag  = true;
    }

    /**
     *  获取属性值[微信地址]
     */
    public String getWXAddr() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWXAddr();
        }
        return this.wxaddr;
    }

    /**
     *  获取属性值[微信地址]是否修改
     */
    public boolean isWXAddrDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWXAddrDirty();
        }
        return this.wxaddrDirtyFlag;
    }

    /**
     *  重置属性值[微信地址]
     */
    public void resetWXAddr() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWXAddr();
            return;
        }

        this.wxaddrDirtyFlag = false;
        this.wxaddr = null;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        MsgAccountBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(MsgAccountBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetEnable();
        et.resetFolderModel();
        et.resetIsList();
        et.resetMailAddress();
        et.resetMobile();
        et.resetMsgAccountId();
        et.resetMsgAccountName();
        et.resetMsgAddress();
        et.resetMsnEmail();
        et.resetReserver();
        et.resetReserver2();
        et.resetReserver3();
        et.resetReserver4();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetWeCharAddr();
        et.resetWXAddr();
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
        if(!bDirtyOnly || isEnableDirty()) {
            params.put(FIELD_ENABLE,getEnable());
        }
        if(!bDirtyOnly || isFolderModelDirty()) {
            params.put(FIELD_FOLDERMODEL,getFolderModel());
        }
        if(!bDirtyOnly || isIsListDirty()) {
            params.put(FIELD_ISLIST,getIsList());
        }
        if(!bDirtyOnly || isMailAddressDirty()) {
            params.put(FIELD_MAILADDRESS,getMailAddress());
        }
        if(!bDirtyOnly || isMobileDirty()) {
            params.put(FIELD_MOBILE,getMobile());
        }
        if(!bDirtyOnly || isMsgAccountIdDirty()) {
            params.put(FIELD_MSGACCOUNTID,getMsgAccountId());
        }
        if(!bDirtyOnly || isMsgAccountNameDirty()) {
            params.put(FIELD_MSGACCOUNTNAME,getMsgAccountName());
        }
        if(!bDirtyOnly || isMsgAddressDirty()) {
            params.put(FIELD_MSGADDRESS,getMsgAddress());
        }
        if(!bDirtyOnly || isMsnEmailDirty()) {
            params.put(FIELD_MSNEMAIL,getMsnEmail());
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
        if(!bDirtyOnly || isWeCharAddrDirty()) {
            params.put(FIELD_WECHARADDR,getWeCharAddr());
        }
        if(!bDirtyOnly || isWXAddrDirty()) {
            params.put(FIELD_WXADDR,getWXAddr());
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

        return  MsgAccountBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(MsgAccountBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_ENABLE:
            return et.getEnable();
        case INDEX_FOLDERMODEL:
            return et.getFolderModel();
        case INDEX_ISLIST:
            return et.getIsList();
        case INDEX_MAILADDRESS:
            return et.getMailAddress();
        case INDEX_MOBILE:
            return et.getMobile();
        case INDEX_MSGACCOUNTID:
            return et.getMsgAccountId();
        case INDEX_MSGACCOUNTNAME:
            return et.getMsgAccountName();
        case INDEX_MSGADDRESS:
            return et.getMsgAddress();
        case INDEX_MSNEMAIL:
            return et.getMsnEmail();
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
        case INDEX_WECHARADDR:
            return et.getWeCharAddr();
        case INDEX_WXADDR:
            return et.getWXAddr();
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

        MsgAccountBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(MsgAccountBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_ENABLE:
            et.setEnable(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_FOLDERMODEL:
            et.setFolderModel(DataObject.getStringValue(obj));
            return ;
        case INDEX_ISLIST:
            et.setIsList(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_MAILADDRESS:
            et.setMailAddress(DataObject.getStringValue(obj));
            return ;
        case INDEX_MOBILE:
            et.setMobile(DataObject.getStringValue(obj));
            return ;
        case INDEX_MSGACCOUNTID:
            et.setMsgAccountId(DataObject.getStringValue(obj));
            return ;
        case INDEX_MSGACCOUNTNAME:
            et.setMsgAccountName(DataObject.getStringValue(obj));
            return ;
        case INDEX_MSGADDRESS:
            et.setMsgAddress(DataObject.getStringValue(obj));
            return ;
        case INDEX_MSNEMAIL:
            et.setMsnEmail(DataObject.getStringValue(obj));
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
        case INDEX_WECHARADDR:
            et.setWeCharAddr(DataObject.getStringValue(obj));
            return ;
        case INDEX_WXADDR:
            et.setWXAddr(DataObject.getStringValue(obj));
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

        return  MsgAccountBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(MsgAccountBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_ENABLE:
            return et.getEnable()==null;
        case INDEX_FOLDERMODEL:
            return et.getFolderModel()==null;
        case INDEX_ISLIST:
            return et.getIsList()==null;
        case INDEX_MAILADDRESS:
            return et.getMailAddress()==null;
        case INDEX_MOBILE:
            return et.getMobile()==null;
        case INDEX_MSGACCOUNTID:
            return et.getMsgAccountId()==null;
        case INDEX_MSGACCOUNTNAME:
            return et.getMsgAccountName()==null;
        case INDEX_MSGADDRESS:
            return et.getMsgAddress()==null;
        case INDEX_MSNEMAIL:
            return et.getMsnEmail()==null;
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
        case INDEX_WECHARADDR:
            return et.getWeCharAddr()==null;
        case INDEX_WXADDR:
            return et.getWXAddr()==null;
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
        return  MsgAccountBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(MsgAccountBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_ENABLE:
            return et.isEnableDirty();
        case INDEX_FOLDERMODEL:
            return et.isFolderModelDirty();
        case INDEX_ISLIST:
            return et.isIsListDirty();
        case INDEX_MAILADDRESS:
            return et.isMailAddressDirty();
        case INDEX_MOBILE:
            return et.isMobileDirty();
        case INDEX_MSGACCOUNTID:
            return et.isMsgAccountIdDirty();
        case INDEX_MSGACCOUNTNAME:
            return et.isMsgAccountNameDirty();
        case INDEX_MSGADDRESS:
            return et.isMsgAddressDirty();
        case INDEX_MSNEMAIL:
            return et.isMsnEmailDirty();
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
        case INDEX_WECHARADDR:
            return et.isWeCharAddrDirty();
        case INDEX_WXADDR:
            return et.isWXAddrDirty();
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
    private static  void fillJSONObject(MsgAccountBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getEnable()!=null) {
            JSONObjectHelper.put(json,"enable",getJSONValue(et.getEnable()),false);
        }
        if(bIncEmpty||et.getFolderModel()!=null) {
            JSONObjectHelper.put(json,"foldermodel",getJSONValue(et.getFolderModel()),false);
        }
        if(bIncEmpty||et.getIsList()!=null) {
            JSONObjectHelper.put(json,"islist",getJSONValue(et.getIsList()),false);
        }
        if(bIncEmpty||et.getMailAddress()!=null) {
            JSONObjectHelper.put(json,"mailaddress",getJSONValue(et.getMailAddress()),false);
        }
        if(bIncEmpty||et.getMobile()!=null) {
            JSONObjectHelper.put(json,"mobile",getJSONValue(et.getMobile()),false);
        }
        if(bIncEmpty||et.getMsgAccountId()!=null) {
            JSONObjectHelper.put(json,"msgaccountid",getJSONValue(et.getMsgAccountId()),false);
        }
        if(bIncEmpty||et.getMsgAccountName()!=null) {
            JSONObjectHelper.put(json,"msgaccountname",getJSONValue(et.getMsgAccountName()),false);
        }
        if(bIncEmpty||et.getMsgAddress()!=null) {
            JSONObjectHelper.put(json,"msgaddress",getJSONValue(et.getMsgAddress()),false);
        }
        if(bIncEmpty||et.getMsnEmail()!=null) {
            JSONObjectHelper.put(json,"msnemail",getJSONValue(et.getMsnEmail()),false);
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
        if(bIncEmpty||et.getWeCharAddr()!=null) {
            JSONObjectHelper.put(json,"wecharaddr",getJSONValue(et.getWeCharAddr()),false);
        }
        if(bIncEmpty||et.getWXAddr()!=null) {
            JSONObjectHelper.put(json,"wxaddr",getJSONValue(et.getWXAddr()),false);
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
    private static void fillXmlNode(MsgAccountBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getEnable()!=null) {
            Object obj = et.getEnable();
            node.setAttribute("ENABLE",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getFolderModel()!=null) {
            Object obj = et.getFolderModel();
            node.setAttribute("FOLDERMODEL",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getIsList()!=null) {
            Object obj = et.getIsList();
            node.setAttribute("ISLIST",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getMailAddress()!=null) {
            Object obj = et.getMailAddress();
            node.setAttribute("MAILADDRESS",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getMobile()!=null) {
            Object obj = et.getMobile();
            node.setAttribute("MOBILE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getMsgAccountId()!=null) {
            Object obj = et.getMsgAccountId();
            node.setAttribute("MSGACCOUNTID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getMsgAccountName()!=null) {
            Object obj = et.getMsgAccountName();
            node.setAttribute("MSGACCOUNTNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getMsgAddress()!=null) {
            Object obj = et.getMsgAddress();
            node.setAttribute("MSGADDRESS",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getMsnEmail()!=null) {
            Object obj = et.getMsnEmail();
            node.setAttribute("MSNEMAIL",(obj==null)?"":(String)obj);
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
        if(bIncEmpty||et.getWeCharAddr()!=null) {
            Object obj = et.getWeCharAddr();
            node.setAttribute("WECHARADDR",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWXAddr()!=null) {
            Object obj = et.getWXAddr();
            node.setAttribute("WXADDR",(obj==null)?"":(String)obj);
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        MsgAccountBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(MsgAccountBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isEnableDirty() && (bIncEmpty||et.getEnable()!=null)) {
            dst.set(FIELD_ENABLE,et.getEnable());
        }
        if(et.isFolderModelDirty() && (bIncEmpty||et.getFolderModel()!=null)) {
            dst.set(FIELD_FOLDERMODEL,et.getFolderModel());
        }
        if(et.isIsListDirty() && (bIncEmpty||et.getIsList()!=null)) {
            dst.set(FIELD_ISLIST,et.getIsList());
        }
        if(et.isMailAddressDirty() && (bIncEmpty||et.getMailAddress()!=null)) {
            dst.set(FIELD_MAILADDRESS,et.getMailAddress());
        }
        if(et.isMobileDirty() && (bIncEmpty||et.getMobile()!=null)) {
            dst.set(FIELD_MOBILE,et.getMobile());
        }
        if(et.isMsgAccountIdDirty() && (bIncEmpty||et.getMsgAccountId()!=null)) {
            dst.set(FIELD_MSGACCOUNTID,et.getMsgAccountId());
        }
        if(et.isMsgAccountNameDirty() && (bIncEmpty||et.getMsgAccountName()!=null)) {
            dst.set(FIELD_MSGACCOUNTNAME,et.getMsgAccountName());
        }
        if(et.isMsgAddressDirty() && (bIncEmpty||et.getMsgAddress()!=null)) {
            dst.set(FIELD_MSGADDRESS,et.getMsgAddress());
        }
        if(et.isMsnEmailDirty() && (bIncEmpty||et.getMsnEmail()!=null)) {
            dst.set(FIELD_MSNEMAIL,et.getMsnEmail());
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
        if(et.isWeCharAddrDirty() && (bIncEmpty||et.getWeCharAddr()!=null)) {
            dst.set(FIELD_WECHARADDR,et.getWeCharAddr());
        }
        if(et.isWXAddrDirty() && (bIncEmpty||et.getWXAddr()!=null)) {
            dst.set(FIELD_WXADDR,et.getWXAddr());
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
        return  MsgAccountBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(MsgAccountBase et,int index) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_ENABLE:
            et.resetEnable();
            return true;
        case INDEX_FOLDERMODEL:
            et.resetFolderModel();
            return true;
        case INDEX_ISLIST:
            et.resetIsList();
            return true;
        case INDEX_MAILADDRESS:
            et.resetMailAddress();
            return true;
        case INDEX_MOBILE:
            et.resetMobile();
            return true;
        case INDEX_MSGACCOUNTID:
            et.resetMsgAccountId();
            return true;
        case INDEX_MSGACCOUNTNAME:
            et.resetMsgAccountName();
            return true;
        case INDEX_MSGADDRESS:
            et.resetMsgAddress();
            return true;
        case INDEX_MSNEMAIL:
            et.resetMsnEmail();
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
        case INDEX_WECHARADDR:
            et.resetWeCharAddr();
            return true;
        case INDEX_WXADDR:
            et.resetWXAddr();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }




    /**
     *  获取代理的数据对象
     */
    private MsgAccountBase getProxyEntity() {
        return this.proxyMsgAccountBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyMsgAccountBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof MsgAccountBase) {
            this.proxyMsgAccountBase = (MsgAccountBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.MsgAccountService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}