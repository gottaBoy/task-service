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

public abstract class MsgAccountBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(MsgAccountBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENABLE = "ENABLE";
    public static final String FIELD_FOLDERMODEL = "FOLDERMODEL";
    public static final String FIELD_ISLIST = "ISLIST";
    public static final String FIELD_MAILADDRESS = "MAILADDRESS";
    public static final String FIELD_MOBILE = "MOBILE";
    public static final String FIELD_MSGACCOUNTID = "MSGACCOUNTID";
    public static final String FIELD_MSGACCOUNTNAME = "MSGACCOUNTNAME";
    public static final String FIELD_MSGADDRESS = "MSGADDRESS";
    public static final String FIELD_MSNEMAIL = "MSNEMAIL";
    public static final String FIELD_RESERVER = "RESERVER";
    public static final String FIELD_RESERVER2 = "RESERVER2";
    public static final String FIELD_RESERVER3 = "RESERVER3";
    public static final String FIELD_RESERVER4 = "RESERVER4";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_WECHARADDR = "WECHARADDR";
    public static final String FIELD_WXADDR = "WXADDR";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ENABLE = 2;
    private static final int INDEX_FOLDERMODEL = 3;
    private static final int INDEX_ISLIST = 4;
    private static final int INDEX_MAILADDRESS = 5;
    private static final int INDEX_MOBILE = 6;
    private static final int INDEX_MSGACCOUNTID = 7;
    private static final int INDEX_MSGACCOUNTNAME = 8;
    private static final int INDEX_MSGADDRESS = 9;
    private static final int INDEX_MSNEMAIL = 10;
    private static final int INDEX_RESERVER = 11;
    private static final int INDEX_RESERVER2 = 12;
    private static final int INDEX_RESERVER3 = 13;
    private static final int INDEX_RESERVER4 = 14;
    private static final int INDEX_UPDATEDATE = 15;
    private static final int INDEX_UPDATEMAN = 16;
    private static final int INDEX_WECHARADDR = 17;
    private static final int INDEX_WXADDR = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private MsgAccountBase proxyMsgAccountBase = null;
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

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ENABLE, 2);
        fieldIndexMap.put(FIELD_FOLDERMODEL, 3);
        fieldIndexMap.put(FIELD_ISLIST, 4);
        fieldIndexMap.put(FIELD_MAILADDRESS, 5);
        fieldIndexMap.put(FIELD_MOBILE, 6);
        fieldIndexMap.put(FIELD_MSGACCOUNTID, 7);
        fieldIndexMap.put(FIELD_MSGACCOUNTNAME, 8);
        fieldIndexMap.put(FIELD_MSGADDRESS, 9);
        fieldIndexMap.put(FIELD_MSNEMAIL, 10);
        fieldIndexMap.put(FIELD_RESERVER, 11);
        fieldIndexMap.put(FIELD_RESERVER2, 12);
        fieldIndexMap.put(FIELD_RESERVER3, 13);
        fieldIndexMap.put(FIELD_RESERVER4, 14);
        fieldIndexMap.put(FIELD_UPDATEDATE, 15);
        fieldIndexMap.put(FIELD_UPDATEMAN, 16);
        fieldIndexMap.put(FIELD_WECHARADDR, 17);
        fieldIndexMap.put(FIELD_WXADDR, 18);
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

    public void setEnable(Integer enable) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnable(enable);
            return;
        }
        this.enable = enable;
        this.enableDirtyFlag = true;
    }

    public Integer getEnable() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnable();
        }
        return this.enable;
    }

    public boolean isEnableDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDirty();
        }
        return this.enableDirtyFlag;
    }

    public void resetEnable() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnable();
            return;
        }
        this.enableDirtyFlag = false;
        this.enable = null;
    }

    public void setFolderModel(String foldermodel) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFolderModel(foldermodel);
            return;
        }
        if (foldermodel != null && (foldermodel = StringHelper.trimRight(foldermodel)).length() == 0) {
            foldermodel = null;
        }
        this.foldermodel = foldermodel;
        this.foldermodelDirtyFlag = true;
    }

    public String getFolderModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFolderModel();
        }
        return this.foldermodel;
    }

    public boolean isFolderModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFolderModelDirty();
        }
        return this.foldermodelDirtyFlag;
    }

    public void resetFolderModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFolderModel();
            return;
        }
        this.foldermodelDirtyFlag = false;
        this.foldermodel = null;
    }

    public void setIsList(Integer islist) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIsList(islist);
            return;
        }
        this.islist = islist;
        this.islistDirtyFlag = true;
    }

    public Integer getIsList() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIsList();
        }
        return this.islist;
    }

    public boolean isIsListDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIsListDirty();
        }
        return this.islistDirtyFlag;
    }

    public void resetIsList() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIsList();
            return;
        }
        this.islistDirtyFlag = false;
        this.islist = null;
    }

    public void setMailAddress(String mailaddress) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMailAddress(mailaddress);
            return;
        }
        if (mailaddress != null && (mailaddress = StringHelper.trimRight(mailaddress)).length() == 0) {
            mailaddress = null;
        }
        this.mailaddress = mailaddress;
        this.mailaddressDirtyFlag = true;
    }

    public String getMailAddress() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMailAddress();
        }
        return this.mailaddress;
    }

    public boolean isMailAddressDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMailAddressDirty();
        }
        return this.mailaddressDirtyFlag;
    }

    public void resetMailAddress() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMailAddress();
            return;
        }
        this.mailaddressDirtyFlag = false;
        this.mailaddress = null;
    }

    public void setMobile(String mobile) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobile(mobile);
            return;
        }
        if (mobile != null && (mobile = StringHelper.trimRight(mobile)).length() == 0) {
            mobile = null;
        }
        this.mobile = mobile;
        this.mobileDirtyFlag = true;
    }

    public String getMobile() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobile();
        }
        return this.mobile;
    }

    public boolean isMobileDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobileDirty();
        }
        return this.mobileDirtyFlag;
    }

    public void resetMobile() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobile();
            return;
        }
        this.mobileDirtyFlag = false;
        this.mobile = null;
    }

    public void setMsgAccountId(String msgaccountid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgAccountId(msgaccountid);
            return;
        }
        if (msgaccountid != null && (msgaccountid = StringHelper.trimRight(msgaccountid)).length() == 0) {
            msgaccountid = null;
        }
        this.msgaccountid = msgaccountid;
        this.msgaccountidDirtyFlag = true;
    }

    public String getMsgAccountId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgAccountId();
        }
        return this.msgaccountid;
    }

    public boolean isMsgAccountIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgAccountIdDirty();
        }
        return this.msgaccountidDirtyFlag;
    }

    public void resetMsgAccountId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgAccountId();
            return;
        }
        this.msgaccountidDirtyFlag = false;
        this.msgaccountid = null;
    }

    public void setMsgAccountName(String msgaccountname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgAccountName(msgaccountname);
            return;
        }
        if (msgaccountname != null && (msgaccountname = StringHelper.trimRight(msgaccountname)).length() == 0) {
            msgaccountname = null;
        }
        this.msgaccountname = msgaccountname;
        this.msgaccountnameDirtyFlag = true;
    }

    public String getMsgAccountName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgAccountName();
        }
        return this.msgaccountname;
    }

    public boolean isMsgAccountNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgAccountNameDirty();
        }
        return this.msgaccountnameDirtyFlag;
    }

    public void resetMsgAccountName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgAccountName();
            return;
        }
        this.msgaccountnameDirtyFlag = false;
        this.msgaccountname = null;
    }

    public void setMsgAddress(String msgaddress) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgAddress(msgaddress);
            return;
        }
        if (msgaddress != null && (msgaddress = StringHelper.trimRight(msgaddress)).length() == 0) {
            msgaddress = null;
        }
        this.msgaddress = msgaddress;
        this.msgaddressDirtyFlag = true;
    }

    public String getMsgAddress() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgAddress();
        }
        return this.msgaddress;
    }

    public boolean isMsgAddressDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgAddressDirty();
        }
        return this.msgaddressDirtyFlag;
    }

    public void resetMsgAddress() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgAddress();
            return;
        }
        this.msgaddressDirtyFlag = false;
        this.msgaddress = null;
    }

    public void setMsnEmail(String msnemail) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsnEmail(msnemail);
            return;
        }
        if (msnemail != null && (msnemail = StringHelper.trimRight(msnemail)).length() == 0) {
            msnemail = null;
        }
        this.msnemail = msnemail;
        this.msnemailDirtyFlag = true;
    }

    public String getMsnEmail() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsnEmail();
        }
        return this.msnemail;
    }

    public boolean isMsnEmailDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsnEmailDirty();
        }
        return this.msnemailDirtyFlag;
    }

    public void resetMsnEmail() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsnEmail();
            return;
        }
        this.msnemailDirtyFlag = false;
        this.msnemail = null;
    }

    public void setReserver(String reserver) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver(reserver);
            return;
        }
        if (reserver != null && (reserver = StringHelper.trimRight(reserver)).length() == 0) {
            reserver = null;
        }
        this.reserver = reserver;
        this.reserverDirtyFlag = true;
    }

    public String getReserver() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver();
        }
        return this.reserver;
    }

    public boolean isReserverDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserverDirty();
        }
        return this.reserverDirtyFlag;
    }

    public void resetReserver() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver();
            return;
        }
        this.reserverDirtyFlag = false;
        this.reserver = null;
    }

    public void setReserver2(String reserver2) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver2(reserver2);
            return;
        }
        if (reserver2 != null && (reserver2 = StringHelper.trimRight(reserver2)).length() == 0) {
            reserver2 = null;
        }
        this.reserver2 = reserver2;
        this.reserver2DirtyFlag = true;
    }

    public String getReserver2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver2();
        }
        return this.reserver2;
    }

    public boolean isReserver2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver2Dirty();
        }
        return this.reserver2DirtyFlag;
    }

    public void resetReserver2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver2();
            return;
        }
        this.reserver2DirtyFlag = false;
        this.reserver2 = null;
    }

    public void setReserver3(String reserver3) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver3(reserver3);
            return;
        }
        if (reserver3 != null && (reserver3 = StringHelper.trimRight(reserver3)).length() == 0) {
            reserver3 = null;
        }
        this.reserver3 = reserver3;
        this.reserver3DirtyFlag = true;
    }

    public String getReserver3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver3();
        }
        return this.reserver3;
    }

    public boolean isReserver3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver3Dirty();
        }
        return this.reserver3DirtyFlag;
    }

    public void resetReserver3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver3();
            return;
        }
        this.reserver3DirtyFlag = false;
        this.reserver3 = null;
    }

    public void setReserver4(String reserver4) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver4(reserver4);
            return;
        }
        if (reserver4 != null && (reserver4 = StringHelper.trimRight(reserver4)).length() == 0) {
            reserver4 = null;
        }
        this.reserver4 = reserver4;
        this.reserver4DirtyFlag = true;
    }

    public String getReserver4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver4();
        }
        return this.reserver4;
    }

    public boolean isReserver4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver4Dirty();
        }
        return this.reserver4DirtyFlag;
    }

    public void resetReserver4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver4();
            return;
        }
        this.reserver4DirtyFlag = false;
        this.reserver4 = null;
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

    public void setWeCharAddr(String wecharaddr) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWeCharAddr(wecharaddr);
            return;
        }
        if (wecharaddr != null && (wecharaddr = StringHelper.trimRight(wecharaddr)).length() == 0) {
            wecharaddr = null;
        }
        this.wecharaddr = wecharaddr;
        this.wecharaddrDirtyFlag = true;
    }

    public String getWeCharAddr() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWeCharAddr();
        }
        return this.wecharaddr;
    }

    public boolean isWeCharAddrDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWeCharAddrDirty();
        }
        return this.wecharaddrDirtyFlag;
    }

    public void resetWeCharAddr() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWeCharAddr();
            return;
        }
        this.wecharaddrDirtyFlag = false;
        this.wecharaddr = null;
    }

    public void setWXAddr(String wxaddr) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWXAddr(wxaddr);
            return;
        }
        if (wxaddr != null && (wxaddr = StringHelper.trimRight(wxaddr)).length() == 0) {
            wxaddr = null;
        }
        this.wxaddr = wxaddr;
        this.wxaddrDirtyFlag = true;
    }

    public String getWXAddr() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWXAddr();
        }
        return this.wxaddr;
    }

    public boolean isWXAddrDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWXAddrDirty();
        }
        return this.wxaddrDirtyFlag;
    }

    public void resetWXAddr() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWXAddr();
            return;
        }
        this.wxaddrDirtyFlag = false;
        this.wxaddr = null;
    }

    @Override
    protected void onReset() {
        MsgAccountBase.resetAll(this);
        super.onReset();
    }

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

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isEnableDirty()) {
            params.put(FIELD_ENABLE, this.getEnable());
        }
        if (!bDirtyOnly || this.isFolderModelDirty()) {
            params.put(FIELD_FOLDERMODEL, this.getFolderModel());
        }
        if (!bDirtyOnly || this.isIsListDirty()) {
            params.put(FIELD_ISLIST, this.getIsList());
        }
        if (!bDirtyOnly || this.isMailAddressDirty()) {
            params.put(FIELD_MAILADDRESS, this.getMailAddress());
        }
        if (!bDirtyOnly || this.isMobileDirty()) {
            params.put(FIELD_MOBILE, this.getMobile());
        }
        if (!bDirtyOnly || this.isMsgAccountIdDirty()) {
            params.put(FIELD_MSGACCOUNTID, this.getMsgAccountId());
        }
        if (!bDirtyOnly || this.isMsgAccountNameDirty()) {
            params.put(FIELD_MSGACCOUNTNAME, this.getMsgAccountName());
        }
        if (!bDirtyOnly || this.isMsgAddressDirty()) {
            params.put(FIELD_MSGADDRESS, this.getMsgAddress());
        }
        if (!bDirtyOnly || this.isMsnEmailDirty()) {
            params.put(FIELD_MSNEMAIL, this.getMsnEmail());
        }
        if (!bDirtyOnly || this.isReserverDirty()) {
            params.put(FIELD_RESERVER, this.getReserver());
        }
        if (!bDirtyOnly || this.isReserver2Dirty()) {
            params.put(FIELD_RESERVER2, this.getReserver2());
        }
        if (!bDirtyOnly || this.isReserver3Dirty()) {
            params.put(FIELD_RESERVER3, this.getReserver3());
        }
        if (!bDirtyOnly || this.isReserver4Dirty()) {
            params.put(FIELD_RESERVER4, this.getReserver4());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isWeCharAddrDirty()) {
            params.put(FIELD_WECHARADDR, this.getWeCharAddr());
        }
        if (!bDirtyOnly || this.isWXAddrDirty()) {
            params.put(FIELD_WXADDR, this.getWXAddr());
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
        return MsgAccountBase.get(this, index);
    }

    private static Object get(MsgAccountBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate();
            }
            case 1: {
                return et.getCreateMan();
            }
            case 2: {
                return et.getEnable();
            }
            case 3: {
                return et.getFolderModel();
            }
            case 4: {
                return et.getIsList();
            }
            case 5: {
                return et.getMailAddress();
            }
            case 6: {
                return et.getMobile();
            }
            case 7: {
                return et.getMsgAccountId();
            }
            case 8: {
                return et.getMsgAccountName();
            }
            case 9: {
                return et.getMsgAddress();
            }
            case 10: {
                return et.getMsnEmail();
            }
            case 11: {
                return et.getReserver();
            }
            case 12: {
                return et.getReserver2();
            }
            case 13: {
                return et.getReserver3();
            }
            case 14: {
                return et.getReserver4();
            }
            case 15: {
                return et.getUpdateDate();
            }
            case 16: {
                return et.getUpdateMan();
            }
            case 17: {
                return et.getWeCharAddr();
            }
            case 18: {
                return et.getWXAddr();
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
        MsgAccountBase.set(this, index, objValue);
    }

    private static void set(MsgAccountBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 1: {
                et.setCreateMan(DataObject.getStringValue(obj));
                return;
            }
            case 2: {
                et.setEnable(DataObject.getIntegerValue(obj));
                return;
            }
            case 3: {
                et.setFolderModel(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setIsList(DataObject.getIntegerValue(obj));
                return;
            }
            case 5: {
                et.setMailAddress(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setMobile(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setMsgAccountId(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setMsgAccountName(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setMsgAddress(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setMsnEmail(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setReserver(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setReserver2(DataObject.getStringValue(obj));
                return;
            }
            case 13: {
                et.setReserver3(DataObject.getStringValue(obj));
                return;
            }
            case 14: {
                et.setReserver4(DataObject.getStringValue(obj));
                return;
            }
            case 15: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 16: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 17: {
                et.setWeCharAddr(DataObject.getStringValue(obj));
                return;
            }
            case 18: {
                et.setWXAddr(DataObject.getStringValue(obj));
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
        return MsgAccountBase.isNull(this, index);
    }

    private static boolean isNull(MsgAccountBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate() == null;
            }
            case 1: {
                return et.getCreateMan() == null;
            }
            case 2: {
                return et.getEnable() == null;
            }
            case 3: {
                return et.getFolderModel() == null;
            }
            case 4: {
                return et.getIsList() == null;
            }
            case 5: {
                return et.getMailAddress() == null;
            }
            case 6: {
                return et.getMobile() == null;
            }
            case 7: {
                return et.getMsgAccountId() == null;
            }
            case 8: {
                return et.getMsgAccountName() == null;
            }
            case 9: {
                return et.getMsgAddress() == null;
            }
            case 10: {
                return et.getMsnEmail() == null;
            }
            case 11: {
                return et.getReserver() == null;
            }
            case 12: {
                return et.getReserver2() == null;
            }
            case 13: {
                return et.getReserver3() == null;
            }
            case 14: {
                return et.getReserver4() == null;
            }
            case 15: {
                return et.getUpdateDate() == null;
            }
            case 16: {
                return et.getUpdateMan() == null;
            }
            case 17: {
                return et.getWeCharAddr() == null;
            }
            case 18: {
                return et.getWXAddr() == null;
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
        return MsgAccountBase.contains(this, index);
    }

    private static boolean contains(MsgAccountBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCreateDateDirty();
            }
            case 1: {
                return et.isCreateManDirty();
            }
            case 2: {
                return et.isEnableDirty();
            }
            case 3: {
                return et.isFolderModelDirty();
            }
            case 4: {
                return et.isIsListDirty();
            }
            case 5: {
                return et.isMailAddressDirty();
            }
            case 6: {
                return et.isMobileDirty();
            }
            case 7: {
                return et.isMsgAccountIdDirty();
            }
            case 8: {
                return et.isMsgAccountNameDirty();
            }
            case 9: {
                return et.isMsgAddressDirty();
            }
            case 10: {
                return et.isMsnEmailDirty();
            }
            case 11: {
                return et.isReserverDirty();
            }
            case 12: {
                return et.isReserver2Dirty();
            }
            case 13: {
                return et.isReserver3Dirty();
            }
            case 14: {
                return et.isReserver4Dirty();
            }
            case 15: {
                return et.isUpdateDateDirty();
            }
            case 16: {
                return et.isUpdateManDirty();
            }
            case 17: {
                return et.isWeCharAddrDirty();
            }
            case 18: {
                return et.isWXAddrDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        MsgAccountBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(MsgAccountBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", MsgAccountBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", MsgAccountBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getEnable() != null) {
            JSONObjectHelper.put(json, "enable", MsgAccountBase.getJSONValue(et.getEnable()), false);
        }
        if (bIncEmpty || et.getFolderModel() != null) {
            JSONObjectHelper.put(json, "foldermodel", MsgAccountBase.getJSONValue(et.getFolderModel()), false);
        }
        if (bIncEmpty || et.getIsList() != null) {
            JSONObjectHelper.put(json, "islist", MsgAccountBase.getJSONValue(et.getIsList()), false);
        }
        if (bIncEmpty || et.getMailAddress() != null) {
            JSONObjectHelper.put(json, "mailaddress", MsgAccountBase.getJSONValue(et.getMailAddress()), false);
        }
        if (bIncEmpty || et.getMobile() != null) {
            JSONObjectHelper.put(json, "mobile", MsgAccountBase.getJSONValue(et.getMobile()), false);
        }
        if (bIncEmpty || et.getMsgAccountId() != null) {
            JSONObjectHelper.put(json, "msgaccountid", MsgAccountBase.getJSONValue(et.getMsgAccountId()), false);
        }
        if (bIncEmpty || et.getMsgAccountName() != null) {
            JSONObjectHelper.put(json, "msgaccountname", MsgAccountBase.getJSONValue(et.getMsgAccountName()), false);
        }
        if (bIncEmpty || et.getMsgAddress() != null) {
            JSONObjectHelper.put(json, "msgaddress", MsgAccountBase.getJSONValue(et.getMsgAddress()), false);
        }
        if (bIncEmpty || et.getMsnEmail() != null) {
            JSONObjectHelper.put(json, "msnemail", MsgAccountBase.getJSONValue(et.getMsnEmail()), false);
        }
        if (bIncEmpty || et.getReserver() != null) {
            JSONObjectHelper.put(json, "reserver", MsgAccountBase.getJSONValue(et.getReserver()), false);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            JSONObjectHelper.put(json, "reserver2", MsgAccountBase.getJSONValue(et.getReserver2()), false);
        }
        if (bIncEmpty || et.getReserver3() != null) {
            JSONObjectHelper.put(json, "reserver3", MsgAccountBase.getJSONValue(et.getReserver3()), false);
        }
        if (bIncEmpty || et.getReserver4() != null) {
            JSONObjectHelper.put(json, "reserver4", MsgAccountBase.getJSONValue(et.getReserver4()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", MsgAccountBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", MsgAccountBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getWeCharAddr() != null) {
            JSONObjectHelper.put(json, "wecharaddr", MsgAccountBase.getJSONValue(et.getWeCharAddr()), false);
        }
        if (bIncEmpty || et.getWXAddr() != null) {
            JSONObjectHelper.put(json, "wxaddr", MsgAccountBase.getJSONValue(et.getWXAddr()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        MsgAccountBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(MsgAccountBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getEnable() != null) {
            obj = et.getEnable();
            node.setAttribute(FIELD_ENABLE, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getFolderModel() != null) {
            obj = et.getFolderModel();
            node.setAttribute(FIELD_FOLDERMODEL, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getIsList() != null) {
            obj = et.getIsList();
            node.setAttribute(FIELD_ISLIST, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getMailAddress() != null) {
            obj = et.getMailAddress();
            node.setAttribute(FIELD_MAILADDRESS, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMobile() != null) {
            obj = et.getMobile();
            node.setAttribute(FIELD_MOBILE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMsgAccountId() != null) {
            obj = et.getMsgAccountId();
            node.setAttribute(FIELD_MSGACCOUNTID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMsgAccountName() != null) {
            obj = et.getMsgAccountName();
            node.setAttribute(FIELD_MSGACCOUNTNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMsgAddress() != null) {
            obj = et.getMsgAddress();
            node.setAttribute(FIELD_MSGADDRESS, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMsnEmail() != null) {
            obj = et.getMsnEmail();
            node.setAttribute(FIELD_MSNEMAIL, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver() != null) {
            obj = et.getReserver();
            node.setAttribute(FIELD_RESERVER, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            obj = et.getReserver2();
            node.setAttribute(FIELD_RESERVER2, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver3() != null) {
            obj = et.getReserver3();
            node.setAttribute(FIELD_RESERVER3, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver4() != null) {
            obj = et.getReserver4();
            node.setAttribute(FIELD_RESERVER4, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWeCharAddr() != null) {
            obj = et.getWeCharAddr();
            node.setAttribute(FIELD_WECHARADDR, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWXAddr() != null) {
            obj = et.getWXAddr();
            node.setAttribute(FIELD_WXADDR, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        MsgAccountBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(MsgAccountBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isEnableDirty() && (bIncEmpty || et.getEnable() != null)) {
            dst.set(FIELD_ENABLE, et.getEnable());
        }
        if (et.isFolderModelDirty() && (bIncEmpty || et.getFolderModel() != null)) {
            dst.set(FIELD_FOLDERMODEL, et.getFolderModel());
        }
        if (et.isIsListDirty() && (bIncEmpty || et.getIsList() != null)) {
            dst.set(FIELD_ISLIST, et.getIsList());
        }
        if (et.isMailAddressDirty() && (bIncEmpty || et.getMailAddress() != null)) {
            dst.set(FIELD_MAILADDRESS, et.getMailAddress());
        }
        if (et.isMobileDirty() && (bIncEmpty || et.getMobile() != null)) {
            dst.set(FIELD_MOBILE, et.getMobile());
        }
        if (et.isMsgAccountIdDirty() && (bIncEmpty || et.getMsgAccountId() != null)) {
            dst.set(FIELD_MSGACCOUNTID, et.getMsgAccountId());
        }
        if (et.isMsgAccountNameDirty() && (bIncEmpty || et.getMsgAccountName() != null)) {
            dst.set(FIELD_MSGACCOUNTNAME, et.getMsgAccountName());
        }
        if (et.isMsgAddressDirty() && (bIncEmpty || et.getMsgAddress() != null)) {
            dst.set(FIELD_MSGADDRESS, et.getMsgAddress());
        }
        if (et.isMsnEmailDirty() && (bIncEmpty || et.getMsnEmail() != null)) {
            dst.set(FIELD_MSNEMAIL, et.getMsnEmail());
        }
        if (et.isReserverDirty() && (bIncEmpty || et.getReserver() != null)) {
            dst.set(FIELD_RESERVER, et.getReserver());
        }
        if (et.isReserver2Dirty() && (bIncEmpty || et.getReserver2() != null)) {
            dst.set(FIELD_RESERVER2, et.getReserver2());
        }
        if (et.isReserver3Dirty() && (bIncEmpty || et.getReserver3() != null)) {
            dst.set(FIELD_RESERVER3, et.getReserver3());
        }
        if (et.isReserver4Dirty() && (bIncEmpty || et.getReserver4() != null)) {
            dst.set(FIELD_RESERVER4, et.getReserver4());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isWeCharAddrDirty() && (bIncEmpty || et.getWeCharAddr() != null)) {
            dst.set(FIELD_WECHARADDR, et.getWeCharAddr());
        }
        if (et.isWXAddrDirty() && (bIncEmpty || et.getWXAddr() != null)) {
            dst.set(FIELD_WXADDR, et.getWXAddr());
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
        return MsgAccountBase.remove(this, index);
    }

    private static boolean remove(MsgAccountBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetCreateDate();
                return true;
            }
            case 1: {
                et.resetCreateMan();
                return true;
            }
            case 2: {
                et.resetEnable();
                return true;
            }
            case 3: {
                et.resetFolderModel();
                return true;
            }
            case 4: {
                et.resetIsList();
                return true;
            }
            case 5: {
                et.resetMailAddress();
                return true;
            }
            case 6: {
                et.resetMobile();
                return true;
            }
            case 7: {
                et.resetMsgAccountId();
                return true;
            }
            case 8: {
                et.resetMsgAccountName();
                return true;
            }
            case 9: {
                et.resetMsgAddress();
                return true;
            }
            case 10: {
                et.resetMsnEmail();
                return true;
            }
            case 11: {
                et.resetReserver();
                return true;
            }
            case 12: {
                et.resetReserver2();
                return true;
            }
            case 13: {
                et.resetReserver3();
                return true;
            }
            case 14: {
                et.resetReserver4();
                return true;
            }
            case 15: {
                et.resetUpdateDate();
                return true;
            }
            case 16: {
                et.resetUpdateMan();
                return true;
            }
            case 17: {
                et.resetWeCharAddr();
                return true;
            }
            case 18: {
                et.resetWXAddr();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private MsgAccountBase getProxyEntity() {
        return this.proxyMsgAccountBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyMsgAccountBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof MsgAccountBase) {
            this.proxyMsgAccountBase = (MsgAccountBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.MsgAccountService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

