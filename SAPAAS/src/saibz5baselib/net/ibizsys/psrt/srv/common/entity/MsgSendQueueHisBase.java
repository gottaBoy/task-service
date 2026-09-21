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

public abstract class MsgSendQueueHisBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(MsgSendQueueHisBase.class);
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CONTENTTYPE = "CONTENTTYPE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DSTADDRESSES = "DSTADDRESSES";
    public static final String FIELD_DSTUSERS = "DSTUSERS";
    public static final String FIELD_ERRORINFO = "ERRORINFO";
    public static final String FIELD_FILEAT = "FILEAT";
    public static final String FIELD_FILEAT2 = "FILEAT2";
    public static final String FIELD_FILEAT3 = "FILEAT3";
    public static final String FIELD_FILEAT4 = "FILEAT4";
    public static final String FIELD_IMPORTANCEFLAG = "IMPORTANCEFLAG";
    public static final String FIELD_ISERROR = "ISERROR";
    public static final String FIELD_ISSEND = "ISSEND";
    public static final String FIELD_MSGSENDQUEUEHISID = "MSGSENDQUEUEHISID";
    public static final String FIELD_MSGSENDQUEUEHISNAME = "MSGSENDQUEUEHISNAME";
    public static final String FIELD_MSGTYPE = "MSGTYPE";
    public static final String FIELD_PLANSENDTIME = "PLANSENDTIME";
    public static final String FIELD_PROCESSTIME = "PROCESSTIME";
    public static final String FIELD_SENDTAG = "SENDTAG";
    public static final String FIELD_SUBJECT = "SUBJECT";
    public static final String FIELD_TOTALDSTADDRESSES = "TOTALDSTADDRESSES";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERDATA = "USERDATA";
    public static final String FIELD_USERDATA2 = "USERDATA2";
    public static final String FIELD_USERDATA3 = "USERDATA3";
    public static final String FIELD_USERDATA4 = "USERDATA4";
    private static final int INDEX_CONTENT = 0;
    private static final int INDEX_CONTENTTYPE = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_DSTADDRESSES = 4;
    private static final int INDEX_DSTUSERS = 5;
    private static final int INDEX_ERRORINFO = 6;
    private static final int INDEX_FILEAT = 7;
    private static final int INDEX_FILEAT2 = 8;
    private static final int INDEX_FILEAT3 = 9;
    private static final int INDEX_FILEAT4 = 10;
    private static final int INDEX_IMPORTANCEFLAG = 11;
    private static final int INDEX_ISERROR = 12;
    private static final int INDEX_ISSEND = 13;
    private static final int INDEX_MSGSENDQUEUEHISID = 14;
    private static final int INDEX_MSGSENDQUEUEHISNAME = 15;
    private static final int INDEX_MSGTYPE = 16;
    private static final int INDEX_PLANSENDTIME = 17;
    private static final int INDEX_PROCESSTIME = 18;
    private static final int INDEX_SENDTAG = 19;
    private static final int INDEX_SUBJECT = 20;
    private static final int INDEX_TOTALDSTADDRESSES = 21;
    private static final int INDEX_UPDATEDATE = 22;
    private static final int INDEX_UPDATEMAN = 23;
    private static final int INDEX_USERDATA = 24;
    private static final int INDEX_USERDATA2 = 25;
    private static final int INDEX_USERDATA3 = 26;
    private static final int INDEX_USERDATA4 = 27;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private MsgSendQueueHisBase proxyMsgSendQueueHisBase = null;
    private boolean contentDirtyFlag = false;
    private boolean contenttypeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dstaddressesDirtyFlag = false;
    private boolean dstusersDirtyFlag = false;
    private boolean errorinfoDirtyFlag = false;
    private boolean fileatDirtyFlag = false;
    private boolean fileat2DirtyFlag = false;
    private boolean fileat3DirtyFlag = false;
    private boolean fileat4DirtyFlag = false;
    private boolean importanceflagDirtyFlag = false;
    private boolean iserrorDirtyFlag = false;
    private boolean issendDirtyFlag = false;
    private boolean msgsendqueuehisidDirtyFlag = false;
    private boolean msgsendqueuehisnameDirtyFlag = false;
    private boolean msgtypeDirtyFlag = false;
    private boolean plansendtimeDirtyFlag = false;
    private boolean processtimeDirtyFlag = false;
    private boolean sendtagDirtyFlag = false;
    private boolean subjectDirtyFlag = false;
    private boolean totaldstaddressesDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userdataDirtyFlag = false;
    private boolean userdata2DirtyFlag = false;
    private boolean userdata3DirtyFlag = false;
    private boolean userdata4DirtyFlag = false;
    @Column(name="content")
    private String content;
    @Column(name="contenttype")
    private String contenttype;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dstaddresses")
    private String dstaddresses;
    @Column(name="dstusers")
    private String dstusers;
    @Column(name="errorinfo")
    private String errorinfo;
    @Column(name="fileat")
    private String fileat;
    @Column(name="fileat2")
    private String fileat2;
    @Column(name="fileat3")
    private String fileat3;
    @Column(name="fileat4")
    private String fileat4;
    @Column(name="importanceflag")
    private Integer importanceflag;
    @Column(name="iserror")
    private Integer iserror;
    @Column(name="issend")
    private Integer issend;
    @Column(name="msgsendqueuehisid")
    private String msgsendqueuehisid;
    @Column(name="msgsendqueuehisname")
    private String msgsendqueuehisname;
    @Column(name="msgtype")
    private Integer msgtype;
    @Column(name="plansendtime")
    private Timestamp plansendtime;
    @Column(name="processtime")
    private Timestamp processtime;
    @Column(name="sendtag")
    private String sendtag;
    @Column(name="subject")
    private String subject;
    @Column(name="totaldstaddresses")
    private String totaldstaddresses;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userdata")
    private String userdata;
    @Column(name="userdata2")
    private String userdata2;
    @Column(name="userdata3")
    private String userdata3;
    @Column(name="userdata4")
    private String userdata4;

    static {
        fieldIndexMap.put(FIELD_CONTENT, 0);
        fieldIndexMap.put(FIELD_CONTENTTYPE, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_DSTADDRESSES, 4);
        fieldIndexMap.put(FIELD_DSTUSERS, 5);
        fieldIndexMap.put(FIELD_ERRORINFO, 6);
        fieldIndexMap.put(FIELD_FILEAT, 7);
        fieldIndexMap.put(FIELD_FILEAT2, 8);
        fieldIndexMap.put(FIELD_FILEAT3, 9);
        fieldIndexMap.put(FIELD_FILEAT4, 10);
        fieldIndexMap.put(FIELD_IMPORTANCEFLAG, 11);
        fieldIndexMap.put(FIELD_ISERROR, 12);
        fieldIndexMap.put(FIELD_ISSEND, 13);
        fieldIndexMap.put(FIELD_MSGSENDQUEUEHISID, 14);
        fieldIndexMap.put(FIELD_MSGSENDQUEUEHISNAME, 15);
        fieldIndexMap.put(FIELD_MSGTYPE, 16);
        fieldIndexMap.put(FIELD_PLANSENDTIME, 17);
        fieldIndexMap.put(FIELD_PROCESSTIME, 18);
        fieldIndexMap.put(FIELD_SENDTAG, 19);
        fieldIndexMap.put(FIELD_SUBJECT, 20);
        fieldIndexMap.put(FIELD_TOTALDSTADDRESSES, 21);
        fieldIndexMap.put(FIELD_UPDATEDATE, 22);
        fieldIndexMap.put(FIELD_UPDATEMAN, 23);
        fieldIndexMap.put(FIELD_USERDATA, 24);
        fieldIndexMap.put(FIELD_USERDATA2, 25);
        fieldIndexMap.put(FIELD_USERDATA3, 26);
        fieldIndexMap.put(FIELD_USERDATA4, 27);
    }

    public void setContent(String content) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContent(content);
            return;
        }
        if (content != null && (content = StringHelper.trimRight(content)).length() == 0) {
            content = null;
        }
        this.content = content;
        this.contentDirtyFlag = true;
    }

    public String getContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContent();
        }
        return this.content;
    }

    public boolean isContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentDirty();
        }
        return this.contentDirtyFlag;
    }

    public void resetContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContent();
            return;
        }
        this.contentDirtyFlag = false;
        this.content = null;
    }

    public void setContentType(String contenttype) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContentType(contenttype);
            return;
        }
        if (contenttype != null && (contenttype = StringHelper.trimRight(contenttype)).length() == 0) {
            contenttype = null;
        }
        this.contenttype = contenttype;
        this.contenttypeDirtyFlag = true;
    }

    public String getContentType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentType();
        }
        return this.contenttype;
    }

    public boolean isContentTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentTypeDirty();
        }
        return this.contenttypeDirtyFlag;
    }

    public void resetContentType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContentType();
            return;
        }
        this.contenttypeDirtyFlag = false;
        this.contenttype = null;
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

    public void setDstAddresses(String dstaddresses) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstAddresses(dstaddresses);
            return;
        }
        if (dstaddresses != null && (dstaddresses = StringHelper.trimRight(dstaddresses)).length() == 0) {
            dstaddresses = null;
        }
        this.dstaddresses = dstaddresses;
        this.dstaddressesDirtyFlag = true;
    }

    public String getDstAddresses() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstAddresses();
        }
        return this.dstaddresses;
    }

    public boolean isDstAddressesDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstAddressesDirty();
        }
        return this.dstaddressesDirtyFlag;
    }

    public void resetDstAddresses() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstAddresses();
            return;
        }
        this.dstaddressesDirtyFlag = false;
        this.dstaddresses = null;
    }

    public void setDstUsers(String dstusers) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstUsers(dstusers);
            return;
        }
        if (dstusers != null && (dstusers = StringHelper.trimRight(dstusers)).length() == 0) {
            dstusers = null;
        }
        this.dstusers = dstusers;
        this.dstusersDirtyFlag = true;
    }

    public String getDstUsers() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstUsers();
        }
        return this.dstusers;
    }

    public boolean isDstUsersDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstUsersDirty();
        }
        return this.dstusersDirtyFlag;
    }

    public void resetDstUsers() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstUsers();
            return;
        }
        this.dstusersDirtyFlag = false;
        this.dstusers = null;
    }

    public void setErrorInfo(String errorinfo) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setErrorInfo(errorinfo);
            return;
        }
        if (errorinfo != null && (errorinfo = StringHelper.trimRight(errorinfo)).length() == 0) {
            errorinfo = null;
        }
        this.errorinfo = errorinfo;
        this.errorinfoDirtyFlag = true;
    }

    public String getErrorInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getErrorInfo();
        }
        return this.errorinfo;
    }

    public boolean isErrorInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isErrorInfoDirty();
        }
        return this.errorinfoDirtyFlag;
    }

    public void resetErrorInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetErrorInfo();
            return;
        }
        this.errorinfoDirtyFlag = false;
        this.errorinfo = null;
    }

    public void setFileAT(String fileat) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFileAT(fileat);
            return;
        }
        if (fileat != null && (fileat = StringHelper.trimRight(fileat)).length() == 0) {
            fileat = null;
        }
        this.fileat = fileat;
        this.fileatDirtyFlag = true;
    }

    public String getFileAT() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFileAT();
        }
        return this.fileat;
    }

    public boolean isFileATDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFileATDirty();
        }
        return this.fileatDirtyFlag;
    }

    public void resetFileAT() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFileAT();
            return;
        }
        this.fileatDirtyFlag = false;
        this.fileat = null;
    }

    public void setFileAT2(String fileat2) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFileAT2(fileat2);
            return;
        }
        if (fileat2 != null && (fileat2 = StringHelper.trimRight(fileat2)).length() == 0) {
            fileat2 = null;
        }
        this.fileat2 = fileat2;
        this.fileat2DirtyFlag = true;
    }

    public String getFileAT2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFileAT2();
        }
        return this.fileat2;
    }

    public boolean isFileAT2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFileAT2Dirty();
        }
        return this.fileat2DirtyFlag;
    }

    public void resetFileAT2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFileAT2();
            return;
        }
        this.fileat2DirtyFlag = false;
        this.fileat2 = null;
    }

    public void setFileAT3(String fileat3) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFileAT3(fileat3);
            return;
        }
        if (fileat3 != null && (fileat3 = StringHelper.trimRight(fileat3)).length() == 0) {
            fileat3 = null;
        }
        this.fileat3 = fileat3;
        this.fileat3DirtyFlag = true;
    }

    public String getFileAT3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFileAT3();
        }
        return this.fileat3;
    }

    public boolean isFileAT3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFileAT3Dirty();
        }
        return this.fileat3DirtyFlag;
    }

    public void resetFileAT3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFileAT3();
            return;
        }
        this.fileat3DirtyFlag = false;
        this.fileat3 = null;
    }

    public void setFileAT4(String fileat4) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFileAT4(fileat4);
            return;
        }
        if (fileat4 != null && (fileat4 = StringHelper.trimRight(fileat4)).length() == 0) {
            fileat4 = null;
        }
        this.fileat4 = fileat4;
        this.fileat4DirtyFlag = true;
    }

    public String getFileAT4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFileAT4();
        }
        return this.fileat4;
    }

    public boolean isFileAT4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFileAT4Dirty();
        }
        return this.fileat4DirtyFlag;
    }

    public void resetFileAT4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFileAT4();
            return;
        }
        this.fileat4DirtyFlag = false;
        this.fileat4 = null;
    }

    public void setImportanceFlag(Integer importanceflag) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setImportanceFlag(importanceflag);
            return;
        }
        this.importanceflag = importanceflag;
        this.importanceflagDirtyFlag = true;
    }

    public Integer getImportanceFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getImportanceFlag();
        }
        return this.importanceflag;
    }

    public boolean isImportanceFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isImportanceFlagDirty();
        }
        return this.importanceflagDirtyFlag;
    }

    public void resetImportanceFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetImportanceFlag();
            return;
        }
        this.importanceflagDirtyFlag = false;
        this.importanceflag = null;
    }

    public void setIsError(Integer iserror) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIsError(iserror);
            return;
        }
        this.iserror = iserror;
        this.iserrorDirtyFlag = true;
    }

    public Integer getIsError() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIsError();
        }
        return this.iserror;
    }

    public boolean isIsErrorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIsErrorDirty();
        }
        return this.iserrorDirtyFlag;
    }

    public void resetIsError() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIsError();
            return;
        }
        this.iserrorDirtyFlag = false;
        this.iserror = null;
    }

    public void setIsSend(Integer issend) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIsSend(issend);
            return;
        }
        this.issend = issend;
        this.issendDirtyFlag = true;
    }

    public Integer getIsSend() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIsSend();
        }
        return this.issend;
    }

    public boolean isIsSendDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIsSendDirty();
        }
        return this.issendDirtyFlag;
    }

    public void resetIsSend() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIsSend();
            return;
        }
        this.issendDirtyFlag = false;
        this.issend = null;
    }

    public void setMsgSendQueueHisId(String msgsendqueuehisid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgSendQueueHisId(msgsendqueuehisid);
            return;
        }
        if (msgsendqueuehisid != null && (msgsendqueuehisid = StringHelper.trimRight(msgsendqueuehisid)).length() == 0) {
            msgsendqueuehisid = null;
        }
        this.msgsendqueuehisid = msgsendqueuehisid;
        this.msgsendqueuehisidDirtyFlag = true;
    }

    public String getMsgSendQueueHisId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgSendQueueHisId();
        }
        return this.msgsendqueuehisid;
    }

    public boolean isMsgSendQueueHisIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgSendQueueHisIdDirty();
        }
        return this.msgsendqueuehisidDirtyFlag;
    }

    public void resetMsgSendQueueHisId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgSendQueueHisId();
            return;
        }
        this.msgsendqueuehisidDirtyFlag = false;
        this.msgsendqueuehisid = null;
    }

    public void setMsgSendQueueHisName(String msgsendqueuehisname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgSendQueueHisName(msgsendqueuehisname);
            return;
        }
        if (msgsendqueuehisname != null && (msgsendqueuehisname = StringHelper.trimRight(msgsendqueuehisname)).length() == 0) {
            msgsendqueuehisname = null;
        }
        this.msgsendqueuehisname = msgsendqueuehisname;
        this.msgsendqueuehisnameDirtyFlag = true;
    }

    public String getMsgSendQueueHisName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgSendQueueHisName();
        }
        return this.msgsendqueuehisname;
    }

    public boolean isMsgSendQueueHisNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgSendQueueHisNameDirty();
        }
        return this.msgsendqueuehisnameDirtyFlag;
    }

    public void resetMsgSendQueueHisName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgSendQueueHisName();
            return;
        }
        this.msgsendqueuehisnameDirtyFlag = false;
        this.msgsendqueuehisname = null;
    }

    public void setMsgType(Integer msgtype) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgType(msgtype);
            return;
        }
        this.msgtype = msgtype;
        this.msgtypeDirtyFlag = true;
    }

    public Integer getMsgType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgType();
        }
        return this.msgtype;
    }

    public boolean isMsgTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgTypeDirty();
        }
        return this.msgtypeDirtyFlag;
    }

    public void resetMsgType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgType();
            return;
        }
        this.msgtypeDirtyFlag = false;
        this.msgtype = null;
    }

    public void setPlanSendTime(Timestamp plansendtime) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPlanSendTime(plansendtime);
            return;
        }
        this.plansendtime = plansendtime;
        this.plansendtimeDirtyFlag = true;
    }

    public Timestamp getPlanSendTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPlanSendTime();
        }
        return this.plansendtime;
    }

    public boolean isPlanSendTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPlanSendTimeDirty();
        }
        return this.plansendtimeDirtyFlag;
    }

    public void resetPlanSendTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPlanSendTime();
            return;
        }
        this.plansendtimeDirtyFlag = false;
        this.plansendtime = null;
    }

    public void setProcessTime(Timestamp processtime) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setProcessTime(processtime);
            return;
        }
        this.processtime = processtime;
        this.processtimeDirtyFlag = true;
    }

    public Timestamp getProcessTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getProcessTime();
        }
        return this.processtime;
    }

    public boolean isProcessTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isProcessTimeDirty();
        }
        return this.processtimeDirtyFlag;
    }

    public void resetProcessTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetProcessTime();
            return;
        }
        this.processtimeDirtyFlag = false;
        this.processtime = null;
    }

    public void setSendTag(String sendtag) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSendTag(sendtag);
            return;
        }
        if (sendtag != null && (sendtag = StringHelper.trimRight(sendtag)).length() == 0) {
            sendtag = null;
        }
        this.sendtag = sendtag;
        this.sendtagDirtyFlag = true;
    }

    public String getSendTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSendTag();
        }
        return this.sendtag;
    }

    public boolean isSendTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSendTagDirty();
        }
        return this.sendtagDirtyFlag;
    }

    public void resetSendTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSendTag();
            return;
        }
        this.sendtagDirtyFlag = false;
        this.sendtag = null;
    }

    public void setSubject(String subject) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubject(subject);
            return;
        }
        if (subject != null && (subject = StringHelper.trimRight(subject)).length() == 0) {
            subject = null;
        }
        this.subject = subject;
        this.subjectDirtyFlag = true;
    }

    public String getSubject() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubject();
        }
        return this.subject;
    }

    public boolean isSubjectDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSubjectDirty();
        }
        return this.subjectDirtyFlag;
    }

    public void resetSubject() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSubject();
            return;
        }
        this.subjectDirtyFlag = false;
        this.subject = null;
    }

    public void setTotalDstAddresses(String totaldstaddresses) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTotalDstAddresses(totaldstaddresses);
            return;
        }
        if (totaldstaddresses != null && (totaldstaddresses = StringHelper.trimRight(totaldstaddresses)).length() == 0) {
            totaldstaddresses = null;
        }
        this.totaldstaddresses = totaldstaddresses;
        this.totaldstaddressesDirtyFlag = true;
    }

    public String getTotalDstAddresses() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTotalDstAddresses();
        }
        return this.totaldstaddresses;
    }

    public boolean isTotalDstAddressesDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTotalDstAddressesDirty();
        }
        return this.totaldstaddressesDirtyFlag;
    }

    public void resetTotalDstAddresses() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTotalDstAddresses();
            return;
        }
        this.totaldstaddressesDirtyFlag = false;
        this.totaldstaddresses = null;
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

    public void setUserData(String userdata) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData(userdata);
            return;
        }
        if (userdata != null && (userdata = StringHelper.trimRight(userdata)).length() == 0) {
            userdata = null;
        }
        this.userdata = userdata;
        this.userdataDirtyFlag = true;
    }

    public String getUserData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData();
        }
        return this.userdata;
    }

    public boolean isUserDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDataDirty();
        }
        return this.userdataDirtyFlag;
    }

    public void resetUserData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData();
            return;
        }
        this.userdataDirtyFlag = false;
        this.userdata = null;
    }

    public void setUserData2(String userdata2) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData2(userdata2);
            return;
        }
        if (userdata2 != null && (userdata2 = StringHelper.trimRight(userdata2)).length() == 0) {
            userdata2 = null;
        }
        this.userdata2 = userdata2;
        this.userdata2DirtyFlag = true;
    }

    public String getUserData2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData2();
        }
        return this.userdata2;
    }

    public boolean isUserData2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserData2Dirty();
        }
        return this.userdata2DirtyFlag;
    }

    public void resetUserData2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData2();
            return;
        }
        this.userdata2DirtyFlag = false;
        this.userdata2 = null;
    }

    public void setUserData3(String userdata3) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData3(userdata3);
            return;
        }
        if (userdata3 != null && (userdata3 = StringHelper.trimRight(userdata3)).length() == 0) {
            userdata3 = null;
        }
        this.userdata3 = userdata3;
        this.userdata3DirtyFlag = true;
    }

    public String getUserData3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData3();
        }
        return this.userdata3;
    }

    public boolean isUserData3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserData3Dirty();
        }
        return this.userdata3DirtyFlag;
    }

    public void resetUserData3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData3();
            return;
        }
        this.userdata3DirtyFlag = false;
        this.userdata3 = null;
    }

    public void setUserData4(String userdata4) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData4(userdata4);
            return;
        }
        if (userdata4 != null && (userdata4 = StringHelper.trimRight(userdata4)).length() == 0) {
            userdata4 = null;
        }
        this.userdata4 = userdata4;
        this.userdata4DirtyFlag = true;
    }

    public String getUserData4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData4();
        }
        return this.userdata4;
    }

    public boolean isUserData4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserData4Dirty();
        }
        return this.userdata4DirtyFlag;
    }

    public void resetUserData4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData4();
            return;
        }
        this.userdata4DirtyFlag = false;
        this.userdata4 = null;
    }

    @Override
    protected void onReset() {
        MsgSendQueueHisBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(MsgSendQueueHisBase et) {
        et.resetContent();
        et.resetContentType();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetDstAddresses();
        et.resetDstUsers();
        et.resetErrorInfo();
        et.resetFileAT();
        et.resetFileAT2();
        et.resetFileAT3();
        et.resetFileAT4();
        et.resetImportanceFlag();
        et.resetIsError();
        et.resetIsSend();
        et.resetMsgSendQueueHisId();
        et.resetMsgSendQueueHisName();
        et.resetMsgType();
        et.resetPlanSendTime();
        et.resetProcessTime();
        et.resetSendTag();
        et.resetSubject();
        et.resetTotalDstAddresses();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetUserData();
        et.resetUserData2();
        et.resetUserData3();
        et.resetUserData4();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isContentDirty()) {
            params.put(FIELD_CONTENT, this.getContent());
        }
        if (!bDirtyOnly || this.isContentTypeDirty()) {
            params.put(FIELD_CONTENTTYPE, this.getContentType());
        }
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isDstAddressesDirty()) {
            params.put(FIELD_DSTADDRESSES, this.getDstAddresses());
        }
        if (!bDirtyOnly || this.isDstUsersDirty()) {
            params.put(FIELD_DSTUSERS, this.getDstUsers());
        }
        if (!bDirtyOnly || this.isErrorInfoDirty()) {
            params.put(FIELD_ERRORINFO, this.getErrorInfo());
        }
        if (!bDirtyOnly || this.isFileATDirty()) {
            params.put(FIELD_FILEAT, this.getFileAT());
        }
        if (!bDirtyOnly || this.isFileAT2Dirty()) {
            params.put(FIELD_FILEAT2, this.getFileAT2());
        }
        if (!bDirtyOnly || this.isFileAT3Dirty()) {
            params.put(FIELD_FILEAT3, this.getFileAT3());
        }
        if (!bDirtyOnly || this.isFileAT4Dirty()) {
            params.put(FIELD_FILEAT4, this.getFileAT4());
        }
        if (!bDirtyOnly || this.isImportanceFlagDirty()) {
            params.put(FIELD_IMPORTANCEFLAG, this.getImportanceFlag());
        }
        if (!bDirtyOnly || this.isIsErrorDirty()) {
            params.put(FIELD_ISERROR, this.getIsError());
        }
        if (!bDirtyOnly || this.isIsSendDirty()) {
            params.put(FIELD_ISSEND, this.getIsSend());
        }
        if (!bDirtyOnly || this.isMsgSendQueueHisIdDirty()) {
            params.put(FIELD_MSGSENDQUEUEHISID, this.getMsgSendQueueHisId());
        }
        if (!bDirtyOnly || this.isMsgSendQueueHisNameDirty()) {
            params.put(FIELD_MSGSENDQUEUEHISNAME, this.getMsgSendQueueHisName());
        }
        if (!bDirtyOnly || this.isMsgTypeDirty()) {
            params.put(FIELD_MSGTYPE, this.getMsgType());
        }
        if (!bDirtyOnly || this.isPlanSendTimeDirty()) {
            params.put(FIELD_PLANSENDTIME, this.getPlanSendTime());
        }
        if (!bDirtyOnly || this.isProcessTimeDirty()) {
            params.put(FIELD_PROCESSTIME, this.getProcessTime());
        }
        if (!bDirtyOnly || this.isSendTagDirty()) {
            params.put(FIELD_SENDTAG, this.getSendTag());
        }
        if (!bDirtyOnly || this.isSubjectDirty()) {
            params.put(FIELD_SUBJECT, this.getSubject());
        }
        if (!bDirtyOnly || this.isTotalDstAddressesDirty()) {
            params.put(FIELD_TOTALDSTADDRESSES, this.getTotalDstAddresses());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isUserDataDirty()) {
            params.put(FIELD_USERDATA, this.getUserData());
        }
        if (!bDirtyOnly || this.isUserData2Dirty()) {
            params.put(FIELD_USERDATA2, this.getUserData2());
        }
        if (!bDirtyOnly || this.isUserData3Dirty()) {
            params.put(FIELD_USERDATA3, this.getUserData3());
        }
        if (!bDirtyOnly || this.isUserData4Dirty()) {
            params.put(FIELD_USERDATA4, this.getUserData4());
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
        return MsgSendQueueHisBase.get(this, index);
    }

    private static Object get(MsgSendQueueHisBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getContent();
            }
            case 1: {
                return et.getContentType();
            }
            case 2: {
                return et.getCreateDate();
            }
            case 3: {
                return et.getCreateMan();
            }
            case 4: {
                return et.getDstAddresses();
            }
            case 5: {
                return et.getDstUsers();
            }
            case 6: {
                return et.getErrorInfo();
            }
            case 7: {
                return et.getFileAT();
            }
            case 8: {
                return et.getFileAT2();
            }
            case 9: {
                return et.getFileAT3();
            }
            case 10: {
                return et.getFileAT4();
            }
            case 11: {
                return et.getImportanceFlag();
            }
            case 12: {
                return et.getIsError();
            }
            case 13: {
                return et.getIsSend();
            }
            case 14: {
                return et.getMsgSendQueueHisId();
            }
            case 15: {
                return et.getMsgSendQueueHisName();
            }
            case 16: {
                return et.getMsgType();
            }
            case 17: {
                return et.getPlanSendTime();
            }
            case 18: {
                return et.getProcessTime();
            }
            case 19: {
                return et.getSendTag();
            }
            case 20: {
                return et.getSubject();
            }
            case 21: {
                return et.getTotalDstAddresses();
            }
            case 22: {
                return et.getUpdateDate();
            }
            case 23: {
                return et.getUpdateMan();
            }
            case 24: {
                return et.getUserData();
            }
            case 25: {
                return et.getUserData2();
            }
            case 26: {
                return et.getUserData3();
            }
            case 27: {
                return et.getUserData4();
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
        MsgSendQueueHisBase.set(this, index, objValue);
    }

    private static void set(MsgSendQueueHisBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setContent(DataObject.getStringValue(obj));
                return;
            }
            case 1: {
                et.setContentType(DataObject.getStringValue(obj));
                return;
            }
            case 2: {
                et.setCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 3: {
                et.setCreateMan(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setDstAddresses(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setDstUsers(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setErrorInfo(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setFileAT(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setFileAT2(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setFileAT3(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setFileAT4(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setImportanceFlag(DataObject.getIntegerValue(obj));
                return;
            }
            case 12: {
                et.setIsError(DataObject.getIntegerValue(obj));
                return;
            }
            case 13: {
                et.setIsSend(DataObject.getIntegerValue(obj));
                return;
            }
            case 14: {
                et.setMsgSendQueueHisId(DataObject.getStringValue(obj));
                return;
            }
            case 15: {
                et.setMsgSendQueueHisName(DataObject.getStringValue(obj));
                return;
            }
            case 16: {
                et.setMsgType(DataObject.getIntegerValue(obj));
                return;
            }
            case 17: {
                et.setPlanSendTime(DataObject.getTimestampValue(obj));
                return;
            }
            case 18: {
                et.setProcessTime(DataObject.getTimestampValue(obj));
                return;
            }
            case 19: {
                et.setSendTag(DataObject.getStringValue(obj));
                return;
            }
            case 20: {
                et.setSubject(DataObject.getStringValue(obj));
                return;
            }
            case 21: {
                et.setTotalDstAddresses(DataObject.getStringValue(obj));
                return;
            }
            case 22: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 23: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 24: {
                et.setUserData(DataObject.getStringValue(obj));
                return;
            }
            case 25: {
                et.setUserData2(DataObject.getStringValue(obj));
                return;
            }
            case 26: {
                et.setUserData3(DataObject.getStringValue(obj));
                return;
            }
            case 27: {
                et.setUserData4(DataObject.getStringValue(obj));
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
        return MsgSendQueueHisBase.isNull(this, index);
    }

    private static boolean isNull(MsgSendQueueHisBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getContent() == null;
            }
            case 1: {
                return et.getContentType() == null;
            }
            case 2: {
                return et.getCreateDate() == null;
            }
            case 3: {
                return et.getCreateMan() == null;
            }
            case 4: {
                return et.getDstAddresses() == null;
            }
            case 5: {
                return et.getDstUsers() == null;
            }
            case 6: {
                return et.getErrorInfo() == null;
            }
            case 7: {
                return et.getFileAT() == null;
            }
            case 8: {
                return et.getFileAT2() == null;
            }
            case 9: {
                return et.getFileAT3() == null;
            }
            case 10: {
                return et.getFileAT4() == null;
            }
            case 11: {
                return et.getImportanceFlag() == null;
            }
            case 12: {
                return et.getIsError() == null;
            }
            case 13: {
                return et.getIsSend() == null;
            }
            case 14: {
                return et.getMsgSendQueueHisId() == null;
            }
            case 15: {
                return et.getMsgSendQueueHisName() == null;
            }
            case 16: {
                return et.getMsgType() == null;
            }
            case 17: {
                return et.getPlanSendTime() == null;
            }
            case 18: {
                return et.getProcessTime() == null;
            }
            case 19: {
                return et.getSendTag() == null;
            }
            case 20: {
                return et.getSubject() == null;
            }
            case 21: {
                return et.getTotalDstAddresses() == null;
            }
            case 22: {
                return et.getUpdateDate() == null;
            }
            case 23: {
                return et.getUpdateMan() == null;
            }
            case 24: {
                return et.getUserData() == null;
            }
            case 25: {
                return et.getUserData2() == null;
            }
            case 26: {
                return et.getUserData3() == null;
            }
            case 27: {
                return et.getUserData4() == null;
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
        return MsgSendQueueHisBase.contains(this, index);
    }

    private static boolean contains(MsgSendQueueHisBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isContentDirty();
            }
            case 1: {
                return et.isContentTypeDirty();
            }
            case 2: {
                return et.isCreateDateDirty();
            }
            case 3: {
                return et.isCreateManDirty();
            }
            case 4: {
                return et.isDstAddressesDirty();
            }
            case 5: {
                return et.isDstUsersDirty();
            }
            case 6: {
                return et.isErrorInfoDirty();
            }
            case 7: {
                return et.isFileATDirty();
            }
            case 8: {
                return et.isFileAT2Dirty();
            }
            case 9: {
                return et.isFileAT3Dirty();
            }
            case 10: {
                return et.isFileAT4Dirty();
            }
            case 11: {
                return et.isImportanceFlagDirty();
            }
            case 12: {
                return et.isIsErrorDirty();
            }
            case 13: {
                return et.isIsSendDirty();
            }
            case 14: {
                return et.isMsgSendQueueHisIdDirty();
            }
            case 15: {
                return et.isMsgSendQueueHisNameDirty();
            }
            case 16: {
                return et.isMsgTypeDirty();
            }
            case 17: {
                return et.isPlanSendTimeDirty();
            }
            case 18: {
                return et.isProcessTimeDirty();
            }
            case 19: {
                return et.isSendTagDirty();
            }
            case 20: {
                return et.isSubjectDirty();
            }
            case 21: {
                return et.isTotalDstAddressesDirty();
            }
            case 22: {
                return et.isUpdateDateDirty();
            }
            case 23: {
                return et.isUpdateManDirty();
            }
            case 24: {
                return et.isUserDataDirty();
            }
            case 25: {
                return et.isUserData2Dirty();
            }
            case 26: {
                return et.isUserData3Dirty();
            }
            case 27: {
                return et.isUserData4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        MsgSendQueueHisBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(MsgSendQueueHisBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getContent() != null) {
            JSONObjectHelper.put(json, "content", MsgSendQueueHisBase.getJSONValue(et.getContent()), false);
        }
        if (bIncEmpty || et.getContentType() != null) {
            JSONObjectHelper.put(json, "contenttype", MsgSendQueueHisBase.getJSONValue(et.getContentType()), false);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", MsgSendQueueHisBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", MsgSendQueueHisBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getDstAddresses() != null) {
            JSONObjectHelper.put(json, "dstaddresses", MsgSendQueueHisBase.getJSONValue(et.getDstAddresses()), false);
        }
        if (bIncEmpty || et.getDstUsers() != null) {
            JSONObjectHelper.put(json, "dstusers", MsgSendQueueHisBase.getJSONValue(et.getDstUsers()), false);
        }
        if (bIncEmpty || et.getErrorInfo() != null) {
            JSONObjectHelper.put(json, "errorinfo", MsgSendQueueHisBase.getJSONValue(et.getErrorInfo()), false);
        }
        if (bIncEmpty || et.getFileAT() != null) {
            JSONObjectHelper.put(json, "fileat", MsgSendQueueHisBase.getJSONValue(et.getFileAT()), false);
        }
        if (bIncEmpty || et.getFileAT2() != null) {
            JSONObjectHelper.put(json, "fileat2", MsgSendQueueHisBase.getJSONValue(et.getFileAT2()), false);
        }
        if (bIncEmpty || et.getFileAT3() != null) {
            JSONObjectHelper.put(json, "fileat3", MsgSendQueueHisBase.getJSONValue(et.getFileAT3()), false);
        }
        if (bIncEmpty || et.getFileAT4() != null) {
            JSONObjectHelper.put(json, "fileat4", MsgSendQueueHisBase.getJSONValue(et.getFileAT4()), false);
        }
        if (bIncEmpty || et.getImportanceFlag() != null) {
            JSONObjectHelper.put(json, "importanceflag", MsgSendQueueHisBase.getJSONValue(et.getImportanceFlag()), false);
        }
        if (bIncEmpty || et.getIsError() != null) {
            JSONObjectHelper.put(json, "iserror", MsgSendQueueHisBase.getJSONValue(et.getIsError()), false);
        }
        if (bIncEmpty || et.getIsSend() != null) {
            JSONObjectHelper.put(json, "issend", MsgSendQueueHisBase.getJSONValue(et.getIsSend()), false);
        }
        if (bIncEmpty || et.getMsgSendQueueHisId() != null) {
            JSONObjectHelper.put(json, "msgsendqueuehisid", MsgSendQueueHisBase.getJSONValue(et.getMsgSendQueueHisId()), false);
        }
        if (bIncEmpty || et.getMsgSendQueueHisName() != null) {
            JSONObjectHelper.put(json, "msgsendqueuehisname", MsgSendQueueHisBase.getJSONValue(et.getMsgSendQueueHisName()), false);
        }
        if (bIncEmpty || et.getMsgType() != null) {
            JSONObjectHelper.put(json, "msgtype", MsgSendQueueHisBase.getJSONValue(et.getMsgType()), false);
        }
        if (bIncEmpty || et.getPlanSendTime() != null) {
            JSONObjectHelper.put(json, "plansendtime", MsgSendQueueHisBase.getJSONValue(et.getPlanSendTime()), false);
        }
        if (bIncEmpty || et.getProcessTime() != null) {
            JSONObjectHelper.put(json, "processtime", MsgSendQueueHisBase.getJSONValue(et.getProcessTime()), false);
        }
        if (bIncEmpty || et.getSendTag() != null) {
            JSONObjectHelper.put(json, "sendtag", MsgSendQueueHisBase.getJSONValue(et.getSendTag()), false);
        }
        if (bIncEmpty || et.getSubject() != null) {
            JSONObjectHelper.put(json, "subject", MsgSendQueueHisBase.getJSONValue(et.getSubject()), false);
        }
        if (bIncEmpty || et.getTotalDstAddresses() != null) {
            JSONObjectHelper.put(json, "totaldstaddresses", MsgSendQueueHisBase.getJSONValue(et.getTotalDstAddresses()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", MsgSendQueueHisBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", MsgSendQueueHisBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getUserData() != null) {
            JSONObjectHelper.put(json, "userdata", MsgSendQueueHisBase.getJSONValue(et.getUserData()), false);
        }
        if (bIncEmpty || et.getUserData2() != null) {
            JSONObjectHelper.put(json, "userdata2", MsgSendQueueHisBase.getJSONValue(et.getUserData2()), false);
        }
        if (bIncEmpty || et.getUserData3() != null) {
            JSONObjectHelper.put(json, "userdata3", MsgSendQueueHisBase.getJSONValue(et.getUserData3()), false);
        }
        if (bIncEmpty || et.getUserData4() != null) {
            JSONObjectHelper.put(json, "userdata4", MsgSendQueueHisBase.getJSONValue(et.getUserData4()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        MsgSendQueueHisBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(MsgSendQueueHisBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getContent() != null) {
            obj = et.getContent();
            node.setAttribute(FIELD_CONTENT, (String)(obj == null ? "" : obj));
        }
        if (bIncEmpty || et.getContentType() != null) {
            obj = et.getContentType();
            node.setAttribute(FIELD_CONTENTTYPE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDstAddresses() != null) {
            obj = et.getDstAddresses();
            node.setAttribute(FIELD_DSTADDRESSES, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDstUsers() != null) {
            obj = et.getDstUsers();
            node.setAttribute(FIELD_DSTUSERS, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getErrorInfo() != null) {
            obj = et.getErrorInfo();
            node.setAttribute(FIELD_ERRORINFO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getFileAT() != null) {
            obj = et.getFileAT();
            node.setAttribute(FIELD_FILEAT, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getFileAT2() != null) {
            obj = et.getFileAT2();
            node.setAttribute(FIELD_FILEAT2, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getFileAT3() != null) {
            obj = et.getFileAT3();
            node.setAttribute(FIELD_FILEAT3, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getFileAT4() != null) {
            obj = et.getFileAT4();
            node.setAttribute(FIELD_FILEAT4, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getImportanceFlag() != null) {
            obj = et.getImportanceFlag();
            node.setAttribute(FIELD_IMPORTANCEFLAG, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getIsError() != null) {
            obj = et.getIsError();
            node.setAttribute(FIELD_ISERROR, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getIsSend() != null) {
            obj = et.getIsSend();
            node.setAttribute(FIELD_ISSEND, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getMsgSendQueueHisId() != null) {
            obj = et.getMsgSendQueueHisId();
            node.setAttribute(FIELD_MSGSENDQUEUEHISID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMsgSendQueueHisName() != null) {
            obj = et.getMsgSendQueueHisName();
            node.setAttribute(FIELD_MSGSENDQUEUEHISNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMsgType() != null) {
            obj = et.getMsgType();
            node.setAttribute(FIELD_MSGTYPE, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getPlanSendTime() != null) {
            obj = et.getPlanSendTime();
            node.setAttribute(FIELD_PLANSENDTIME, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getProcessTime() != null) {
            obj = et.getProcessTime();
            node.setAttribute(FIELD_PROCESSTIME, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getSendTag() != null) {
            obj = et.getSendTag();
            node.setAttribute(FIELD_SENDTAG, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getSubject() != null) {
            obj = et.getSubject();
            node.setAttribute(FIELD_SUBJECT, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getTotalDstAddresses() != null) {
            obj = et.getTotalDstAddresses();
            node.setAttribute(FIELD_TOTALDSTADDRESSES, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserData() != null) {
            obj = et.getUserData();
            node.setAttribute(FIELD_USERDATA, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserData2() != null) {
            obj = et.getUserData2();
            node.setAttribute(FIELD_USERDATA2, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserData3() != null) {
            obj = et.getUserData3();
            node.setAttribute(FIELD_USERDATA3, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserData4() != null) {
            obj = et.getUserData4();
            node.setAttribute(FIELD_USERDATA4, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        MsgSendQueueHisBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(MsgSendQueueHisBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isContentDirty() && (bIncEmpty || et.getContent() != null)) {
            dst.set(FIELD_CONTENT, et.getContent());
        }
        if (et.isContentTypeDirty() && (bIncEmpty || et.getContentType() != null)) {
            dst.set(FIELD_CONTENTTYPE, et.getContentType());
        }
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isDstAddressesDirty() && (bIncEmpty || et.getDstAddresses() != null)) {
            dst.set(FIELD_DSTADDRESSES, et.getDstAddresses());
        }
        if (et.isDstUsersDirty() && (bIncEmpty || et.getDstUsers() != null)) {
            dst.set(FIELD_DSTUSERS, et.getDstUsers());
        }
        if (et.isErrorInfoDirty() && (bIncEmpty || et.getErrorInfo() != null)) {
            dst.set(FIELD_ERRORINFO, et.getErrorInfo());
        }
        if (et.isFileATDirty() && (bIncEmpty || et.getFileAT() != null)) {
            dst.set(FIELD_FILEAT, et.getFileAT());
        }
        if (et.isFileAT2Dirty() && (bIncEmpty || et.getFileAT2() != null)) {
            dst.set(FIELD_FILEAT2, et.getFileAT2());
        }
        if (et.isFileAT3Dirty() && (bIncEmpty || et.getFileAT3() != null)) {
            dst.set(FIELD_FILEAT3, et.getFileAT3());
        }
        if (et.isFileAT4Dirty() && (bIncEmpty || et.getFileAT4() != null)) {
            dst.set(FIELD_FILEAT4, et.getFileAT4());
        }
        if (et.isImportanceFlagDirty() && (bIncEmpty || et.getImportanceFlag() != null)) {
            dst.set(FIELD_IMPORTANCEFLAG, et.getImportanceFlag());
        }
        if (et.isIsErrorDirty() && (bIncEmpty || et.getIsError() != null)) {
            dst.set(FIELD_ISERROR, et.getIsError());
        }
        if (et.isIsSendDirty() && (bIncEmpty || et.getIsSend() != null)) {
            dst.set(FIELD_ISSEND, et.getIsSend());
        }
        if (et.isMsgSendQueueHisIdDirty() && (bIncEmpty || et.getMsgSendQueueHisId() != null)) {
            dst.set(FIELD_MSGSENDQUEUEHISID, et.getMsgSendQueueHisId());
        }
        if (et.isMsgSendQueueHisNameDirty() && (bIncEmpty || et.getMsgSendQueueHisName() != null)) {
            dst.set(FIELD_MSGSENDQUEUEHISNAME, et.getMsgSendQueueHisName());
        }
        if (et.isMsgTypeDirty() && (bIncEmpty || et.getMsgType() != null)) {
            dst.set(FIELD_MSGTYPE, et.getMsgType());
        }
        if (et.isPlanSendTimeDirty() && (bIncEmpty || et.getPlanSendTime() != null)) {
            dst.set(FIELD_PLANSENDTIME, et.getPlanSendTime());
        }
        if (et.isProcessTimeDirty() && (bIncEmpty || et.getProcessTime() != null)) {
            dst.set(FIELD_PROCESSTIME, et.getProcessTime());
        }
        if (et.isSendTagDirty() && (bIncEmpty || et.getSendTag() != null)) {
            dst.set(FIELD_SENDTAG, et.getSendTag());
        }
        if (et.isSubjectDirty() && (bIncEmpty || et.getSubject() != null)) {
            dst.set(FIELD_SUBJECT, et.getSubject());
        }
        if (et.isTotalDstAddressesDirty() && (bIncEmpty || et.getTotalDstAddresses() != null)) {
            dst.set(FIELD_TOTALDSTADDRESSES, et.getTotalDstAddresses());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isUserDataDirty() && (bIncEmpty || et.getUserData() != null)) {
            dst.set(FIELD_USERDATA, et.getUserData());
        }
        if (et.isUserData2Dirty() && (bIncEmpty || et.getUserData2() != null)) {
            dst.set(FIELD_USERDATA2, et.getUserData2());
        }
        if (et.isUserData3Dirty() && (bIncEmpty || et.getUserData3() != null)) {
            dst.set(FIELD_USERDATA3, et.getUserData3());
        }
        if (et.isUserData4Dirty() && (bIncEmpty || et.getUserData4() != null)) {
            dst.set(FIELD_USERDATA4, et.getUserData4());
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
        return MsgSendQueueHisBase.remove(this, index);
    }

    private static boolean remove(MsgSendQueueHisBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetContent();
                return true;
            }
            case 1: {
                et.resetContentType();
                return true;
            }
            case 2: {
                et.resetCreateDate();
                return true;
            }
            case 3: {
                et.resetCreateMan();
                return true;
            }
            case 4: {
                et.resetDstAddresses();
                return true;
            }
            case 5: {
                et.resetDstUsers();
                return true;
            }
            case 6: {
                et.resetErrorInfo();
                return true;
            }
            case 7: {
                et.resetFileAT();
                return true;
            }
            case 8: {
                et.resetFileAT2();
                return true;
            }
            case 9: {
                et.resetFileAT3();
                return true;
            }
            case 10: {
                et.resetFileAT4();
                return true;
            }
            case 11: {
                et.resetImportanceFlag();
                return true;
            }
            case 12: {
                et.resetIsError();
                return true;
            }
            case 13: {
                et.resetIsSend();
                return true;
            }
            case 14: {
                et.resetMsgSendQueueHisId();
                return true;
            }
            case 15: {
                et.resetMsgSendQueueHisName();
                return true;
            }
            case 16: {
                et.resetMsgType();
                return true;
            }
            case 17: {
                et.resetPlanSendTime();
                return true;
            }
            case 18: {
                et.resetProcessTime();
                return true;
            }
            case 19: {
                et.resetSendTag();
                return true;
            }
            case 20: {
                et.resetSubject();
                return true;
            }
            case 21: {
                et.resetTotalDstAddresses();
                return true;
            }
            case 22: {
                et.resetUpdateDate();
                return true;
            }
            case 23: {
                et.resetUpdateMan();
                return true;
            }
            case 24: {
                et.resetUserData();
                return true;
            }
            case 25: {
                et.resetUserData2();
                return true;
            }
            case 26: {
                et.resetUserData3();
                return true;
            }
            case 27: {
                et.resetUserData4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private MsgSendQueueHisBase getProxyEntity() {
        return this.proxyMsgSendQueueHisBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyMsgSendQueueHisBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof MsgSendQueueHisBase) {
            this.proxyMsgSendQueueHisBase = (MsgSendQueueHisBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.MsgSendQueueHisService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

