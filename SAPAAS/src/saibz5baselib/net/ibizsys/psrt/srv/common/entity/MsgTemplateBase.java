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
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.psrt.srv.demodel.entity.DataEntity;
import net.ibizsys.psrt.srv.demodel.service.DataEntityService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class MsgTemplateBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(MsgTemplateBase.class);
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CONTENTTYPE = "CONTENTTYPE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEID = "DEID";
    public static final String FIELD_DENAME = "DENAME";
    public static final String FIELD_ENABLE = "ENABLE";
    public static final String FIELD_IMCONTENT = "IMCONTENT";
    public static final String FIELD_MAILGROUPSEND = "MAILGROUPSEND";
    public static final String FIELD_MSGTEMPLATEID = "MSGTEMPLATEID";
    public static final String FIELD_MSGTEMPLATENAME = "MSGTEMPLATENAME";
    public static final String FIELD_RESERVER = "RESERVER";
    public static final String FIELD_RESERVER2 = "RESERVER2";
    public static final String FIELD_RESERVER3 = "RESERVER3";
    public static final String FIELD_RESERVER4 = "RESERVER4";
    public static final String FIELD_SMSCONTENT = "SMSCONTENT";
    public static final String FIELD_SRFSYSPUB = "SRFSYSPUB";
    public static final String FIELD_SRFUSERPUB = "SRFUSERPUB";
    public static final String FIELD_SUBJECT = "SUBJECT";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_WCCONTENT = "WCCONTENT";
    private static final int INDEX_CONTENT = 0;
    private static final int INDEX_CONTENTTYPE = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_DEID = 4;
    private static final int INDEX_DENAME = 5;
    private static final int INDEX_ENABLE = 6;
    private static final int INDEX_IMCONTENT = 7;
    private static final int INDEX_MAILGROUPSEND = 8;
    private static final int INDEX_MSGTEMPLATEID = 9;
    private static final int INDEX_MSGTEMPLATENAME = 10;
    private static final int INDEX_RESERVER = 11;
    private static final int INDEX_RESERVER2 = 12;
    private static final int INDEX_RESERVER3 = 13;
    private static final int INDEX_RESERVER4 = 14;
    private static final int INDEX_SMSCONTENT = 15;
    private static final int INDEX_SRFSYSPUB = 16;
    private static final int INDEX_SRFUSERPUB = 17;
    private static final int INDEX_SUBJECT = 18;
    private static final int INDEX_UPDATEDATE = 19;
    private static final int INDEX_UPDATEMAN = 20;
    private static final int INDEX_WCCONTENT = 21;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private MsgTemplateBase proxyMsgTemplateBase = null;
    private boolean contentDirtyFlag = false;
    private boolean contenttypeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean deidDirtyFlag = false;
    private boolean denameDirtyFlag = false;
    private boolean enableDirtyFlag = false;
    private boolean imcontentDirtyFlag = false;
    private boolean mailgroupsendDirtyFlag = false;
    private boolean msgtemplateidDirtyFlag = false;
    private boolean msgtemplatenameDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean reserver3DirtyFlag = false;
    private boolean reserver4DirtyFlag = false;
    private boolean smscontentDirtyFlag = false;
    private boolean srfsyspubDirtyFlag = false;
    private boolean srfuserpubDirtyFlag = false;
    private boolean subjectDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wccontentDirtyFlag = false;
    @Column(name="content")
    private String content;
    @Column(name="contenttype")
    private String contenttype;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="deid")
    private String deid;
    @Column(name="dename")
    private String dename;
    @Column(name="enable")
    private Integer enable;
    @Column(name="imcontent")
    private String imcontent;
    @Column(name="mailgroupsend")
    private Integer mailgroupsend;
    @Column(name="msgtemplateid")
    private String msgtemplateid;
    @Column(name="msgtemplatename")
    private String msgtemplatename;
    @Column(name="reserver")
    private String reserver;
    @Column(name="reserver2")
    private String reserver2;
    @Column(name="reserver3")
    private String reserver3;
    @Column(name="reserver4")
    private String reserver4;
    @Column(name="smscontent")
    private String smscontent;
    @Column(name="srfsyspub")
    private Integer srfsyspub;
    @Column(name="srfuserpub")
    private Integer srfuserpub;
    @Column(name="subject")
    private String subject;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="wccontent")
    private String wccontent;
    private Integer objDELock = new Integer(1);
    private DataEntity de = null;

    static {
        fieldIndexMap.put(FIELD_CONTENT, 0);
        fieldIndexMap.put(FIELD_CONTENTTYPE, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_DEID, 4);
        fieldIndexMap.put(FIELD_DENAME, 5);
        fieldIndexMap.put(FIELD_ENABLE, 6);
        fieldIndexMap.put(FIELD_IMCONTENT, 7);
        fieldIndexMap.put(FIELD_MAILGROUPSEND, 8);
        fieldIndexMap.put(FIELD_MSGTEMPLATEID, 9);
        fieldIndexMap.put(FIELD_MSGTEMPLATENAME, 10);
        fieldIndexMap.put(FIELD_RESERVER, 11);
        fieldIndexMap.put(FIELD_RESERVER2, 12);
        fieldIndexMap.put(FIELD_RESERVER3, 13);
        fieldIndexMap.put(FIELD_RESERVER4, 14);
        fieldIndexMap.put(FIELD_SMSCONTENT, 15);
        fieldIndexMap.put(FIELD_SRFSYSPUB, 16);
        fieldIndexMap.put(FIELD_SRFUSERPUB, 17);
        fieldIndexMap.put(FIELD_SUBJECT, 18);
        fieldIndexMap.put(FIELD_UPDATEDATE, 19);
        fieldIndexMap.put(FIELD_UPDATEMAN, 20);
        fieldIndexMap.put(FIELD_WCCONTENT, 21);
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

    public void setDEId(String deid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEId(deid);
            return;
        }
        if (deid != null && (deid = StringHelper.trimRight(deid)).length() == 0) {
            deid = null;
        }
        this.deid = deid;
        this.deidDirtyFlag = true;
    }

    public String getDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEId();
        }
        return this.deid;
    }

    public boolean isDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEIdDirty();
        }
        return this.deidDirtyFlag;
    }

    public void resetDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEId();
            return;
        }
        this.deidDirtyFlag = false;
        this.deid = null;
    }

    public void setDEName(String dename) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEName(dename);
            return;
        }
        if (dename != null && (dename = StringHelper.trimRight(dename)).length() == 0) {
            dename = null;
        }
        this.dename = dename;
        this.denameDirtyFlag = true;
    }

    public String getDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEName();
        }
        return this.dename;
    }

    public boolean isDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDENameDirty();
        }
        return this.denameDirtyFlag;
    }

    public void resetDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEName();
            return;
        }
        this.denameDirtyFlag = false;
        this.dename = null;
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

    public void setIMContent(String imcontent) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIMContent(imcontent);
            return;
        }
        if (imcontent != null && (imcontent = StringHelper.trimRight(imcontent)).length() == 0) {
            imcontent = null;
        }
        this.imcontent = imcontent;
        this.imcontentDirtyFlag = true;
    }

    public String getIMContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIMContent();
        }
        return this.imcontent;
    }

    public boolean isIMContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIMContentDirty();
        }
        return this.imcontentDirtyFlag;
    }

    public void resetIMContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIMContent();
            return;
        }
        this.imcontentDirtyFlag = false;
        this.imcontent = null;
    }

    public void setMailGroupSend(Integer mailgroupsend) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMailGroupSend(mailgroupsend);
            return;
        }
        this.mailgroupsend = mailgroupsend;
        this.mailgroupsendDirtyFlag = true;
    }

    public Integer getMailGroupSend() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMailGroupSend();
        }
        return this.mailgroupsend;
    }

    public boolean isMailGroupSendDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMailGroupSendDirty();
        }
        return this.mailgroupsendDirtyFlag;
    }

    public void resetMailGroupSend() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMailGroupSend();
            return;
        }
        this.mailgroupsendDirtyFlag = false;
        this.mailgroupsend = null;
    }

    public void setMsgTemplateId(String msgtemplateid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgTemplateId(msgtemplateid);
            return;
        }
        if (msgtemplateid != null && (msgtemplateid = StringHelper.trimRight(msgtemplateid)).length() == 0) {
            msgtemplateid = null;
        }
        this.msgtemplateid = msgtemplateid;
        this.msgtemplateidDirtyFlag = true;
    }

    public String getMsgTemplateId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgTemplateId();
        }
        return this.msgtemplateid;
    }

    public boolean isMsgTemplateIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgTemplateIdDirty();
        }
        return this.msgtemplateidDirtyFlag;
    }

    public void resetMsgTemplateId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgTemplateId();
            return;
        }
        this.msgtemplateidDirtyFlag = false;
        this.msgtemplateid = null;
    }

    public void setMsgTemplateName(String msgtemplatename) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgTemplateName(msgtemplatename);
            return;
        }
        if (msgtemplatename != null && (msgtemplatename = StringHelper.trimRight(msgtemplatename)).length() == 0) {
            msgtemplatename = null;
        }
        this.msgtemplatename = msgtemplatename;
        this.msgtemplatenameDirtyFlag = true;
    }

    public String getMsgTemplateName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgTemplateName();
        }
        return this.msgtemplatename;
    }

    public boolean isMsgTemplateNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgTemplateNameDirty();
        }
        return this.msgtemplatenameDirtyFlag;
    }

    public void resetMsgTemplateName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgTemplateName();
            return;
        }
        this.msgtemplatenameDirtyFlag = false;
        this.msgtemplatename = null;
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

    public void setSMSContent(String smscontent) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSMSContent(smscontent);
            return;
        }
        if (smscontent != null && (smscontent = StringHelper.trimRight(smscontent)).length() == 0) {
            smscontent = null;
        }
        this.smscontent = smscontent;
        this.smscontentDirtyFlag = true;
    }

    public String getSMSContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSMSContent();
        }
        return this.smscontent;
    }

    public boolean isSMSContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSMSContentDirty();
        }
        return this.smscontentDirtyFlag;
    }

    public void resetSMSContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSMSContent();
            return;
        }
        this.smscontentDirtyFlag = false;
        this.smscontent = null;
    }

    public void setSRFSysPub(Integer srfsyspub) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSRFSysPub(srfsyspub);
            return;
        }
        this.srfsyspub = srfsyspub;
        this.srfsyspubDirtyFlag = true;
    }

    public Integer getSRFSysPub() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSRFSysPub();
        }
        return this.srfsyspub;
    }

    public boolean isSRFSysPubDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSRFSysPubDirty();
        }
        return this.srfsyspubDirtyFlag;
    }

    public void resetSRFSysPub() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSRFSysPub();
            return;
        }
        this.srfsyspubDirtyFlag = false;
        this.srfsyspub = null;
    }

    public void setSRFUserPub(Integer srfuserpub) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSRFUserPub(srfuserpub);
            return;
        }
        this.srfuserpub = srfuserpub;
        this.srfuserpubDirtyFlag = true;
    }

    public Integer getSRFUserPub() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSRFUserPub();
        }
        return this.srfuserpub;
    }

    public boolean isSRFUserPubDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSRFUserPubDirty();
        }
        return this.srfuserpubDirtyFlag;
    }

    public void resetSRFUserPub() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSRFUserPub();
            return;
        }
        this.srfuserpubDirtyFlag = false;
        this.srfuserpub = null;
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

    public void setWCContent(String wccontent) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWCContent(wccontent);
            return;
        }
        if (wccontent != null && (wccontent = StringHelper.trimRight(wccontent)).length() == 0) {
            wccontent = null;
        }
        this.wccontent = wccontent;
        this.wccontentDirtyFlag = true;
    }

    public String getWCContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWCContent();
        }
        return this.wccontent;
    }

    public boolean isWCContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWCContentDirty();
        }
        return this.wccontentDirtyFlag;
    }

    public void resetWCContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWCContent();
            return;
        }
        this.wccontentDirtyFlag = false;
        this.wccontent = null;
    }

    @Override
    protected void onReset() {
        MsgTemplateBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(MsgTemplateBase et) {
        et.resetContent();
        et.resetContentType();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetDEId();
        et.resetDEName();
        et.resetEnable();
        et.resetIMContent();
        et.resetMailGroupSend();
        et.resetMsgTemplateId();
        et.resetMsgTemplateName();
        et.resetReserver();
        et.resetReserver2();
        et.resetReserver3();
        et.resetReserver4();
        et.resetSMSContent();
        et.resetSRFSysPub();
        et.resetSRFUserPub();
        et.resetSubject();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetWCContent();
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
        if (!bDirtyOnly || this.isDEIdDirty()) {
            params.put(FIELD_DEID, this.getDEId());
        }
        if (!bDirtyOnly || this.isDENameDirty()) {
            params.put(FIELD_DENAME, this.getDEName());
        }
        if (!bDirtyOnly || this.isEnableDirty()) {
            params.put(FIELD_ENABLE, this.getEnable());
        }
        if (!bDirtyOnly || this.isIMContentDirty()) {
            params.put(FIELD_IMCONTENT, this.getIMContent());
        }
        if (!bDirtyOnly || this.isMailGroupSendDirty()) {
            params.put(FIELD_MAILGROUPSEND, this.getMailGroupSend());
        }
        if (!bDirtyOnly || this.isMsgTemplateIdDirty()) {
            params.put(FIELD_MSGTEMPLATEID, this.getMsgTemplateId());
        }
        if (!bDirtyOnly || this.isMsgTemplateNameDirty()) {
            params.put(FIELD_MSGTEMPLATENAME, this.getMsgTemplateName());
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
        if (!bDirtyOnly || this.isSMSContentDirty()) {
            params.put(FIELD_SMSCONTENT, this.getSMSContent());
        }
        if (!bDirtyOnly || this.isSRFSysPubDirty()) {
            params.put(FIELD_SRFSYSPUB, this.getSRFSysPub());
        }
        if (!bDirtyOnly || this.isSRFUserPubDirty()) {
            params.put(FIELD_SRFUSERPUB, this.getSRFUserPub());
        }
        if (!bDirtyOnly || this.isSubjectDirty()) {
            params.put(FIELD_SUBJECT, this.getSubject());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isWCContentDirty()) {
            params.put(FIELD_WCCONTENT, this.getWCContent());
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
        return MsgTemplateBase.get(this, index);
    }

    private static Object get(MsgTemplateBase et, int index) throws Exception {
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
                return et.getDEId();
            }
            case 5: {
                return et.getDEName();
            }
            case 6: {
                return et.getEnable();
            }
            case 7: {
                return et.getIMContent();
            }
            case 8: {
                return et.getMailGroupSend();
            }
            case 9: {
                return et.getMsgTemplateId();
            }
            case 10: {
                return et.getMsgTemplateName();
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
                return et.getSMSContent();
            }
            case 16: {
                return et.getSRFSysPub();
            }
            case 17: {
                return et.getSRFUserPub();
            }
            case 18: {
                return et.getSubject();
            }
            case 19: {
                return et.getUpdateDate();
            }
            case 20: {
                return et.getUpdateMan();
            }
            case 21: {
                return et.getWCContent();
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
        MsgTemplateBase.set(this, index, objValue);
    }

    private static void set(MsgTemplateBase et, int index, Object obj) throws Exception {
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
                et.setDEId(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setDEName(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setEnable(DataObject.getIntegerValue(obj));
                return;
            }
            case 7: {
                et.setIMContent(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setMailGroupSend(DataObject.getIntegerValue(obj));
                return;
            }
            case 9: {
                et.setMsgTemplateId(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setMsgTemplateName(DataObject.getStringValue(obj));
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
                et.setSMSContent(DataObject.getStringValue(obj));
                return;
            }
            case 16: {
                et.setSRFSysPub(DataObject.getIntegerValue(obj));
                return;
            }
            case 17: {
                et.setSRFUserPub(DataObject.getIntegerValue(obj));
                return;
            }
            case 18: {
                et.setSubject(DataObject.getStringValue(obj));
                return;
            }
            case 19: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 20: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 21: {
                et.setWCContent(DataObject.getStringValue(obj));
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
        return MsgTemplateBase.isNull(this, index);
    }

    private static boolean isNull(MsgTemplateBase et, int index) throws Exception {
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
                return et.getDEId() == null;
            }
            case 5: {
                return et.getDEName() == null;
            }
            case 6: {
                return et.getEnable() == null;
            }
            case 7: {
                return et.getIMContent() == null;
            }
            case 8: {
                return et.getMailGroupSend() == null;
            }
            case 9: {
                return et.getMsgTemplateId() == null;
            }
            case 10: {
                return et.getMsgTemplateName() == null;
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
                return et.getSMSContent() == null;
            }
            case 16: {
                return et.getSRFSysPub() == null;
            }
            case 17: {
                return et.getSRFUserPub() == null;
            }
            case 18: {
                return et.getSubject() == null;
            }
            case 19: {
                return et.getUpdateDate() == null;
            }
            case 20: {
                return et.getUpdateMan() == null;
            }
            case 21: {
                return et.getWCContent() == null;
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
        return MsgTemplateBase.contains(this, index);
    }

    private static boolean contains(MsgTemplateBase et, int index) throws Exception {
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
                return et.isDEIdDirty();
            }
            case 5: {
                return et.isDENameDirty();
            }
            case 6: {
                return et.isEnableDirty();
            }
            case 7: {
                return et.isIMContentDirty();
            }
            case 8: {
                return et.isMailGroupSendDirty();
            }
            case 9: {
                return et.isMsgTemplateIdDirty();
            }
            case 10: {
                return et.isMsgTemplateNameDirty();
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
                return et.isSMSContentDirty();
            }
            case 16: {
                return et.isSRFSysPubDirty();
            }
            case 17: {
                return et.isSRFUserPubDirty();
            }
            case 18: {
                return et.isSubjectDirty();
            }
            case 19: {
                return et.isUpdateDateDirty();
            }
            case 20: {
                return et.isUpdateManDirty();
            }
            case 21: {
                return et.isWCContentDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        MsgTemplateBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(MsgTemplateBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getContent() != null) {
            JSONObjectHelper.put(json, "content", MsgTemplateBase.getJSONValue(et.getContent()), false);
        }
        if (bIncEmpty || et.getContentType() != null) {
            JSONObjectHelper.put(json, "contenttype", MsgTemplateBase.getJSONValue(et.getContentType()), false);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", MsgTemplateBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", MsgTemplateBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getDEId() != null) {
            JSONObjectHelper.put(json, "deid", MsgTemplateBase.getJSONValue(et.getDEId()), false);
        }
        if (bIncEmpty || et.getDEName() != null) {
            JSONObjectHelper.put(json, "dename", MsgTemplateBase.getJSONValue(et.getDEName()), false);
        }
        if (bIncEmpty || et.getEnable() != null) {
            JSONObjectHelper.put(json, "enable", MsgTemplateBase.getJSONValue(et.getEnable()), false);
        }
        if (bIncEmpty || et.getIMContent() != null) {
            JSONObjectHelper.put(json, "imcontent", MsgTemplateBase.getJSONValue(et.getIMContent()), false);
        }
        if (bIncEmpty || et.getMailGroupSend() != null) {
            JSONObjectHelper.put(json, "mailgroupsend", MsgTemplateBase.getJSONValue(et.getMailGroupSend()), false);
        }
        if (bIncEmpty || et.getMsgTemplateId() != null) {
            JSONObjectHelper.put(json, "msgtemplateid", MsgTemplateBase.getJSONValue(et.getMsgTemplateId()), false);
        }
        if (bIncEmpty || et.getMsgTemplateName() != null) {
            JSONObjectHelper.put(json, "msgtemplatename", MsgTemplateBase.getJSONValue(et.getMsgTemplateName()), false);
        }
        if (bIncEmpty || et.getReserver() != null) {
            JSONObjectHelper.put(json, "reserver", MsgTemplateBase.getJSONValue(et.getReserver()), false);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            JSONObjectHelper.put(json, "reserver2", MsgTemplateBase.getJSONValue(et.getReserver2()), false);
        }
        if (bIncEmpty || et.getReserver3() != null) {
            JSONObjectHelper.put(json, "reserver3", MsgTemplateBase.getJSONValue(et.getReserver3()), false);
        }
        if (bIncEmpty || et.getReserver4() != null) {
            JSONObjectHelper.put(json, "reserver4", MsgTemplateBase.getJSONValue(et.getReserver4()), false);
        }
        if (bIncEmpty || et.getSMSContent() != null) {
            JSONObjectHelper.put(json, "smscontent", MsgTemplateBase.getJSONValue(et.getSMSContent()), false);
        }
        if (bIncEmpty || et.getSRFSysPub() != null) {
            JSONObjectHelper.put(json, "srfsyspub", MsgTemplateBase.getJSONValue(et.getSRFSysPub()), false);
        }
        if (bIncEmpty || et.getSRFUserPub() != null) {
            JSONObjectHelper.put(json, "srfuserpub", MsgTemplateBase.getJSONValue(et.getSRFUserPub()), false);
        }
        if (bIncEmpty || et.getSubject() != null) {
            JSONObjectHelper.put(json, "subject", MsgTemplateBase.getJSONValue(et.getSubject()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", MsgTemplateBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", MsgTemplateBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getWCContent() != null) {
            JSONObjectHelper.put(json, "wccontent", MsgTemplateBase.getJSONValue(et.getWCContent()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        MsgTemplateBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(MsgTemplateBase et, XmlNode node, boolean bIncEmpty) throws Exception {
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
        if (bIncEmpty || et.getDEId() != null) {
            obj = et.getDEId();
            node.setAttribute(FIELD_DEID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDEName() != null) {
            obj = et.getDEName();
            node.setAttribute(FIELD_DENAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getEnable() != null) {
            obj = et.getEnable();
            node.setAttribute(FIELD_ENABLE, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getIMContent() != null) {
            obj = et.getIMContent();
            node.setAttribute(FIELD_IMCONTENT, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMailGroupSend() != null) {
            obj = et.getMailGroupSend();
            node.setAttribute(FIELD_MAILGROUPSEND, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getMsgTemplateId() != null) {
            obj = et.getMsgTemplateId();
            node.setAttribute(FIELD_MSGTEMPLATEID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMsgTemplateName() != null) {
            obj = et.getMsgTemplateName();
            node.setAttribute(FIELD_MSGTEMPLATENAME, obj == null ? "" : (String)obj);
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
        if (bIncEmpty || et.getSMSContent() != null) {
            obj = et.getSMSContent();
            node.setAttribute(FIELD_SMSCONTENT, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getSRFSysPub() != null) {
            obj = et.getSRFSysPub();
            node.setAttribute(FIELD_SRFSYSPUB, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getSRFUserPub() != null) {
            obj = et.getSRFUserPub();
            node.setAttribute(FIELD_SRFUSERPUB, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getSubject() != null) {
            obj = et.getSubject();
            node.setAttribute(FIELD_SUBJECT, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWCContent() != null) {
            obj = et.getWCContent();
            node.setAttribute(FIELD_WCCONTENT, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        MsgTemplateBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(MsgTemplateBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
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
        if (et.isDEIdDirty() && (bIncEmpty || et.getDEId() != null)) {
            dst.set(FIELD_DEID, et.getDEId());
        }
        if (et.isDENameDirty() && (bIncEmpty || et.getDEName() != null)) {
            dst.set(FIELD_DENAME, et.getDEName());
        }
        if (et.isEnableDirty() && (bIncEmpty || et.getEnable() != null)) {
            dst.set(FIELD_ENABLE, et.getEnable());
        }
        if (et.isIMContentDirty() && (bIncEmpty || et.getIMContent() != null)) {
            dst.set(FIELD_IMCONTENT, et.getIMContent());
        }
        if (et.isMailGroupSendDirty() && (bIncEmpty || et.getMailGroupSend() != null)) {
            dst.set(FIELD_MAILGROUPSEND, et.getMailGroupSend());
        }
        if (et.isMsgTemplateIdDirty() && (bIncEmpty || et.getMsgTemplateId() != null)) {
            dst.set(FIELD_MSGTEMPLATEID, et.getMsgTemplateId());
        }
        if (et.isMsgTemplateNameDirty() && (bIncEmpty || et.getMsgTemplateName() != null)) {
            dst.set(FIELD_MSGTEMPLATENAME, et.getMsgTemplateName());
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
        if (et.isSMSContentDirty() && (bIncEmpty || et.getSMSContent() != null)) {
            dst.set(FIELD_SMSCONTENT, et.getSMSContent());
        }
        if (et.isSRFSysPubDirty() && (bIncEmpty || et.getSRFSysPub() != null)) {
            dst.set(FIELD_SRFSYSPUB, et.getSRFSysPub());
        }
        if (et.isSRFUserPubDirty() && (bIncEmpty || et.getSRFUserPub() != null)) {
            dst.set(FIELD_SRFUSERPUB, et.getSRFUserPub());
        }
        if (et.isSubjectDirty() && (bIncEmpty || et.getSubject() != null)) {
            dst.set(FIELD_SUBJECT, et.getSubject());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isWCContentDirty() && (bIncEmpty || et.getWCContent() != null)) {
            dst.set(FIELD_WCCONTENT, et.getWCContent());
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
        return MsgTemplateBase.remove(this, index);
    }

    private static boolean remove(MsgTemplateBase et, int index) throws Exception {
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
                et.resetDEId();
                return true;
            }
            case 5: {
                et.resetDEName();
                return true;
            }
            case 6: {
                et.resetEnable();
                return true;
            }
            case 7: {
                et.resetIMContent();
                return true;
            }
            case 8: {
                et.resetMailGroupSend();
                return true;
            }
            case 9: {
                et.resetMsgTemplateId();
                return true;
            }
            case 10: {
                et.resetMsgTemplateName();
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
                et.resetSMSContent();
                return true;
            }
            case 16: {
                et.resetSRFSysPub();
                return true;
            }
            case 17: {
                et.resetSRFUserPub();
                return true;
            }
            case 18: {
                et.resetSubject();
                return true;
            }
            case 19: {
                et.resetUpdateDate();
                return true;
            }
            case 20: {
                et.resetUpdateMan();
                return true;
            }
            case 21: {
                et.resetWCContent();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public DataEntity getDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDE();
        }
        if (this.getDEId() == null) {
            return null;
        }
        Integer n = this.objDELock;
        synchronized (n) {
            if (this.de != null && DataTypeHelper.compare(25, (Object)this.getDEId(), (Object)this.de.getDEId()) != 0L) {
                this.de = null;
            }
            if (this.de == null) {
                DataEntity de = new DataEntity();
                de.setDEId(this.getDEId());
                DataEntityService service = (DataEntityService)ServiceGlobal.getService(DataEntityService.class, this.getSessionFactory());
                service.autoGet(de);
                this.de = de;
            }
            return this.de;
        }
    }

    private MsgTemplateBase getProxyEntity() {
        return this.proxyMsgTemplateBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyMsgTemplateBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof MsgTemplateBase) {
            this.proxyMsgTemplateBase = (MsgTemplateBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.MsgTemplateService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

