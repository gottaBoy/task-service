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
package net.ibizsys.pscore.srv.sysdesign.entity;

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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysReqItemDataBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysReqItemDataBase.class);
    public static final String FIELD_AIBUILDSTATE = "AIBUILDSTATE";
    public static final String FIELD_AICHOICES = "AICHOICES";
    public static final String FIELD_AIPROMPT = "AIPROMPT";
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSSYSREQITEMDATAID = "PSSYSREQITEMDATAID";
    public static final String FIELD_PSSYSREQITEMDATANAME = "PSSYSREQITEMDATANAME";
    public static final String FIELD_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String FIELD_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String FIELD_SUBJECT = "SUBJECT";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_AIBUILDSTATE = 0;
    private static final int INDEX_AICHOICES = 1;
    private static final int INDEX_AIPROMPT = 2;
    private static final int INDEX_CONTENT = 3;
    private static final int INDEX_CREATEDATE = 4;
    private static final int INDEX_CREATEMAN = 5;
    private static final int INDEX_ORDERVALUE = 6;
    private static final int INDEX_PSSYSREQITEMDATAID = 7;
    private static final int INDEX_PSSYSREQITEMDATANAME = 8;
    private static final int INDEX_PSSYSREQITEMID = 9;
    private static final int INDEX_PSSYSREQITEMNAME = 10;
    private static final int INDEX_SUBJECT = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final int INDEX_USERCAT = 14;
    private static final int INDEX_USERTAG = 15;
    private static final int INDEX_USERTAG2 = 16;
    private static final int INDEX_USERTAG3 = 17;
    private static final int INDEX_USERTAG4 = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysReqItemDataBase proxyPSSysReqItemDataBase = null;
    private boolean aibuildstateDirtyFlag = false;
    private boolean aichoicesDirtyFlag = false;
    private boolean aipromptDirtyFlag = false;
    private boolean contentDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean pssysreqitemdataidDirtyFlag = false;
    private boolean pssysreqitemdatanameDirtyFlag = false;
    private boolean pssysreqitemidDirtyFlag = false;
    private boolean pssysreqitemnameDirtyFlag = false;
    private boolean subjectDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="aibuildstate")
    private Integer aibuildstate;
    @Column(name="aichoices")
    private String aichoices;
    @Column(name="aiprompt")
    private String aiprompt;
    @Column(name="content")
    private String content;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="pssysreqitemdataid")
    private String pssysreqitemdataid;
    @Column(name="pssysreqitemdataname")
    private String pssysreqitemdataname;
    @Column(name="pssysreqitemid")
    private String pssysreqitemid;
    @Column(name="pssysreqitemname")
    private String pssysreqitemname;
    @Column(name="subject")
    private String subject;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    private Integer objPSSysReqItemLock = new Integer(1);
    private PSSysReqItem pssysreqitem = null;

    public void setAIBuildState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAIBuildState(n);
            return;
        }
        this.aibuildstate = n;
        this.aibuildstateDirtyFlag = true;
    }

    public Integer getAIBuildState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAIBuildState();
        }
        return this.aibuildstate;
    }

    public boolean isAIBuildStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAIBuildStateDirty();
        }
        return this.aibuildstateDirtyFlag;
    }

    public void resetAIBuildState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAIBuildState();
            return;
        }
        this.aibuildstateDirtyFlag = false;
        this.aibuildstate = null;
    }

    public void setAIChoices(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAIChoices(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aichoices = string;
        this.aichoicesDirtyFlag = true;
    }

    public String getAIChoices() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAIChoices();
        }
        return this.aichoices;
    }

    public boolean isAIChoicesDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAIChoicesDirty();
        }
        return this.aichoicesDirtyFlag;
    }

    public void resetAIChoices() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAIChoices();
            return;
        }
        this.aichoicesDirtyFlag = false;
        this.aichoices = null;
    }

    public void setAIPrompt(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAIPrompt(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aiprompt = string;
        this.aipromptDirtyFlag = true;
    }

    public String getAIPrompt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAIPrompt();
        }
        return this.aiprompt;
    }

    public boolean isAIPromptDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAIPromptDirty();
        }
        return this.aipromptDirtyFlag;
    }

    public void resetAIPrompt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAIPrompt();
            return;
        }
        this.aipromptDirtyFlag = false;
        this.aiprompt = null;
    }

    public void setContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.content = string;
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

    public void setOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValue(n);
            return;
        }
        this.ordervalue = n;
        this.ordervalueDirtyFlag = true;
    }

    public Integer getOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValue();
        }
        return this.ordervalue;
    }

    public boolean isOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValueDirty();
        }
        return this.ordervalueDirtyFlag;
    }

    public void resetOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValue();
            return;
        }
        this.ordervalueDirtyFlag = false;
        this.ordervalue = null;
    }

    public void setPSSysReqItemDataId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemDataId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqitemdataid = string;
        this.pssysreqitemdataidDirtyFlag = true;
    }

    public String getPSSysReqItemDataId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemDataId();
        }
        return this.pssysreqitemdataid;
    }

    public boolean isPSSysReqItemDataIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemDataIdDirty();
        }
        return this.pssysreqitemdataidDirtyFlag;
    }

    public void resetPSSysReqItemDataId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemDataId();
            return;
        }
        this.pssysreqitemdataidDirtyFlag = false;
        this.pssysreqitemdataid = null;
    }

    public void setPSSysReqItemDataName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemDataName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqitemdataname = string;
        this.pssysreqitemdatanameDirtyFlag = true;
    }

    public String getPSSysReqItemDataName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemDataName();
        }
        return this.pssysreqitemdataname;
    }

    public boolean isPSSysReqItemDataNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemDataNameDirty();
        }
        return this.pssysreqitemdatanameDirtyFlag;
    }

    public void resetPSSysReqItemDataName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemDataName();
            return;
        }
        this.pssysreqitemdatanameDirtyFlag = false;
        this.pssysreqitemdataname = null;
    }

    public void setPSSysReqItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqitemid = string;
        this.pssysreqitemidDirtyFlag = true;
    }

    public String getPSSysReqItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemId();
        }
        return this.pssysreqitemid;
    }

    public boolean isPSSysReqItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemIdDirty();
        }
        return this.pssysreqitemidDirtyFlag;
    }

    public void resetPSSysReqItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemId();
            return;
        }
        this.pssysreqitemidDirtyFlag = false;
        this.pssysreqitemid = null;
    }

    public void setPSSysReqItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqitemname = string;
        this.pssysreqitemnameDirtyFlag = true;
    }

    public String getPSSysReqItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemName();
        }
        return this.pssysreqitemname;
    }

    public boolean isPSSysReqItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemNameDirty();
        }
        return this.pssysreqitemnameDirtyFlag;
    }

    public void resetPSSysReqItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemName();
            return;
        }
        this.pssysreqitemnameDirtyFlag = false;
        this.pssysreqitemname = null;
    }

    public void setSubject(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubject(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.subject = string;
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

    public void setUserCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usercat = string;
        this.usercatDirtyFlag = true;
    }

    public String getUserCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserCat();
        }
        return this.usercat;
    }

    public boolean isUserCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserCatDirty();
        }
        return this.usercatDirtyFlag;
    }

    public void resetUserCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserCat();
            return;
        }
        this.usercatDirtyFlag = false;
        this.usercat = null;
    }

    public void setUserTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag = string;
        this.usertagDirtyFlag = true;
    }

    public String getUserTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag();
        }
        return this.usertag;
    }

    public boolean isUserTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTagDirty();
        }
        return this.usertagDirtyFlag;
    }

    public void resetUserTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag();
            return;
        }
        this.usertagDirtyFlag = false;
        this.usertag = null;
    }

    public void setUserTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag2 = string;
        this.usertag2DirtyFlag = true;
    }

    public String getUserTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag2();
        }
        return this.usertag2;
    }

    public boolean isUserTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag2Dirty();
        }
        return this.usertag2DirtyFlag;
    }

    public void resetUserTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag2();
            return;
        }
        this.usertag2DirtyFlag = false;
        this.usertag2 = null;
    }

    public void setUserTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag3 = string;
        this.usertag3DirtyFlag = true;
    }

    public String getUserTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag3();
        }
        return this.usertag3;
    }

    public boolean isUserTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag3Dirty();
        }
        return this.usertag3DirtyFlag;
    }

    public void resetUserTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag3();
            return;
        }
        this.usertag3DirtyFlag = false;
        this.usertag3 = null;
    }

    public void setUserTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag4 = string;
        this.usertag4DirtyFlag = true;
    }

    public String getUserTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag4();
        }
        return this.usertag4;
    }

    public boolean isUserTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag4Dirty();
        }
        return this.usertag4DirtyFlag;
    }

    public void resetUserTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag4();
            return;
        }
        this.usertag4DirtyFlag = false;
        this.usertag4 = null;
    }

    protected void onReset() {
        PSSysReqItemDataBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysReqItemDataBase pSSysReqItemDataBase) {
        pSSysReqItemDataBase.resetAIBuildState();
        pSSysReqItemDataBase.resetAIChoices();
        pSSysReqItemDataBase.resetAIPrompt();
        pSSysReqItemDataBase.resetContent();
        pSSysReqItemDataBase.resetCreateDate();
        pSSysReqItemDataBase.resetCreateMan();
        pSSysReqItemDataBase.resetOrderValue();
        pSSysReqItemDataBase.resetPSSysReqItemDataId();
        pSSysReqItemDataBase.resetPSSysReqItemDataName();
        pSSysReqItemDataBase.resetPSSysReqItemId();
        pSSysReqItemDataBase.resetPSSysReqItemName();
        pSSysReqItemDataBase.resetSubject();
        pSSysReqItemDataBase.resetUpdateDate();
        pSSysReqItemDataBase.resetUpdateMan();
        pSSysReqItemDataBase.resetUserCat();
        pSSysReqItemDataBase.resetUserTag();
        pSSysReqItemDataBase.resetUserTag2();
        pSSysReqItemDataBase.resetUserTag3();
        pSSysReqItemDataBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAIBuildStateDirty()) {
            hashMap.put(FIELD_AIBUILDSTATE, this.getAIBuildState());
        }
        if (!bl || this.isAIChoicesDirty()) {
            hashMap.put(FIELD_AICHOICES, this.getAIChoices());
        }
        if (!bl || this.isAIPromptDirty()) {
            hashMap.put(FIELD_AIPROMPT, this.getAIPrompt());
        }
        if (!bl || this.isContentDirty()) {
            hashMap.put(FIELD_CONTENT, this.getContent());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSSysReqItemDataIdDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMDATAID, this.getPSSysReqItemDataId());
        }
        if (!bl || this.isPSSysReqItemDataNameDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMDATANAME, this.getPSSysReqItemDataName());
        }
        if (!bl || this.isPSSysReqItemIdDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMID, this.getPSSysReqItemId());
        }
        if (!bl || this.isPSSysReqItemNameDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMNAME, this.getPSSysReqItemName());
        }
        if (!bl || this.isSubjectDirty()) {
            hashMap.put(FIELD_SUBJECT, this.getSubject());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserCatDirty()) {
            hashMap.put(FIELD_USERCAT, this.getUserCat());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
        }
        if (!bl || this.isUserTag3Dirty()) {
            hashMap.put(FIELD_USERTAG3, this.getUserTag3());
        }
        if (!bl || this.isUserTag4Dirty()) {
            hashMap.put(FIELD_USERTAG4, this.getUserTag4());
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
        return PSSysReqItemDataBase.get(this, n);
    }

    private static Object get(PSSysReqItemDataBase pSSysReqItemDataBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysReqItemDataBase.getAIBuildState();
            }
            case 1: {
                return pSSysReqItemDataBase.getAIChoices();
            }
            case 2: {
                return pSSysReqItemDataBase.getAIPrompt();
            }
            case 3: {
                return pSSysReqItemDataBase.getContent();
            }
            case 4: {
                return pSSysReqItemDataBase.getCreateDate();
            }
            case 5: {
                return pSSysReqItemDataBase.getCreateMan();
            }
            case 6: {
                return pSSysReqItemDataBase.getOrderValue();
            }
            case 7: {
                return pSSysReqItemDataBase.getPSSysReqItemDataId();
            }
            case 8: {
                return pSSysReqItemDataBase.getPSSysReqItemDataName();
            }
            case 9: {
                return pSSysReqItemDataBase.getPSSysReqItemId();
            }
            case 10: {
                return pSSysReqItemDataBase.getPSSysReqItemName();
            }
            case 11: {
                return pSSysReqItemDataBase.getSubject();
            }
            case 12: {
                return pSSysReqItemDataBase.getUpdateDate();
            }
            case 13: {
                return pSSysReqItemDataBase.getUpdateMan();
            }
            case 14: {
                return pSSysReqItemDataBase.getUserCat();
            }
            case 15: {
                return pSSysReqItemDataBase.getUserTag();
            }
            case 16: {
                return pSSysReqItemDataBase.getUserTag2();
            }
            case 17: {
                return pSSysReqItemDataBase.getUserTag3();
            }
            case 18: {
                return pSSysReqItemDataBase.getUserTag4();
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
        PSSysReqItemDataBase.set(this, n, object);
    }

    private static void set(PSSysReqItemDataBase pSSysReqItemDataBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysReqItemDataBase.setAIBuildState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSSysReqItemDataBase.setAIChoices(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysReqItemDataBase.setAIPrompt(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysReqItemDataBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysReqItemDataBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSSysReqItemDataBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysReqItemDataBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSSysReqItemDataBase.setPSSysReqItemDataId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysReqItemDataBase.setPSSysReqItemDataName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysReqItemDataBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysReqItemDataBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysReqItemDataBase.setSubject(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysReqItemDataBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSSysReqItemDataBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysReqItemDataBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysReqItemDataBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysReqItemDataBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysReqItemDataBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysReqItemDataBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysReqItemDataBase.isNull(this, n);
    }

    private static boolean isNull(PSSysReqItemDataBase pSSysReqItemDataBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysReqItemDataBase.getAIBuildState() == null;
            }
            case 1: {
                return pSSysReqItemDataBase.getAIChoices() == null;
            }
            case 2: {
                return pSSysReqItemDataBase.getAIPrompt() == null;
            }
            case 3: {
                return pSSysReqItemDataBase.getContent() == null;
            }
            case 4: {
                return pSSysReqItemDataBase.getCreateDate() == null;
            }
            case 5: {
                return pSSysReqItemDataBase.getCreateMan() == null;
            }
            case 6: {
                return pSSysReqItemDataBase.getOrderValue() == null;
            }
            case 7: {
                return pSSysReqItemDataBase.getPSSysReqItemDataId() == null;
            }
            case 8: {
                return pSSysReqItemDataBase.getPSSysReqItemDataName() == null;
            }
            case 9: {
                return pSSysReqItemDataBase.getPSSysReqItemId() == null;
            }
            case 10: {
                return pSSysReqItemDataBase.getPSSysReqItemName() == null;
            }
            case 11: {
                return pSSysReqItemDataBase.getSubject() == null;
            }
            case 12: {
                return pSSysReqItemDataBase.getUpdateDate() == null;
            }
            case 13: {
                return pSSysReqItemDataBase.getUpdateMan() == null;
            }
            case 14: {
                return pSSysReqItemDataBase.getUserCat() == null;
            }
            case 15: {
                return pSSysReqItemDataBase.getUserTag() == null;
            }
            case 16: {
                return pSSysReqItemDataBase.getUserTag2() == null;
            }
            case 17: {
                return pSSysReqItemDataBase.getUserTag3() == null;
            }
            case 18: {
                return pSSysReqItemDataBase.getUserTag4() == null;
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
        return PSSysReqItemDataBase.contains(this, n);
    }

    private static boolean contains(PSSysReqItemDataBase pSSysReqItemDataBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysReqItemDataBase.isAIBuildStateDirty();
            }
            case 1: {
                return pSSysReqItemDataBase.isAIChoicesDirty();
            }
            case 2: {
                return pSSysReqItemDataBase.isAIPromptDirty();
            }
            case 3: {
                return pSSysReqItemDataBase.isContentDirty();
            }
            case 4: {
                return pSSysReqItemDataBase.isCreateDateDirty();
            }
            case 5: {
                return pSSysReqItemDataBase.isCreateManDirty();
            }
            case 6: {
                return pSSysReqItemDataBase.isOrderValueDirty();
            }
            case 7: {
                return pSSysReqItemDataBase.isPSSysReqItemDataIdDirty();
            }
            case 8: {
                return pSSysReqItemDataBase.isPSSysReqItemDataNameDirty();
            }
            case 9: {
                return pSSysReqItemDataBase.isPSSysReqItemIdDirty();
            }
            case 10: {
                return pSSysReqItemDataBase.isPSSysReqItemNameDirty();
            }
            case 11: {
                return pSSysReqItemDataBase.isSubjectDirty();
            }
            case 12: {
                return pSSysReqItemDataBase.isUpdateDateDirty();
            }
            case 13: {
                return pSSysReqItemDataBase.isUpdateManDirty();
            }
            case 14: {
                return pSSysReqItemDataBase.isUserCatDirty();
            }
            case 15: {
                return pSSysReqItemDataBase.isUserTagDirty();
            }
            case 16: {
                return pSSysReqItemDataBase.isUserTag2Dirty();
            }
            case 17: {
                return pSSysReqItemDataBase.isUserTag3Dirty();
            }
            case 18: {
                return pSSysReqItemDataBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysReqItemDataBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysReqItemDataBase pSSysReqItemDataBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysReqItemDataBase.getAIBuildState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aibuildstate", (Object)PSSysReqItemDataBase.getJSONValue((Object)pSSysReqItemDataBase.getAIBuildState()), (boolean)false);
        }
        if (bl || pSSysReqItemDataBase.getAIChoices() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aichoices", (Object)PSSysReqItemDataBase.getJSONValue((Object)pSSysReqItemDataBase.getAIChoices()), (boolean)false);
        }
        if (bl || pSSysReqItemDataBase.getAIPrompt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aiprompt", (Object)PSSysReqItemDataBase.getJSONValue((Object)pSSysReqItemDataBase.getAIPrompt()), (boolean)false);
        }
        if (bl || pSSysReqItemDataBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSSysReqItemDataBase.getJSONValue((Object)pSSysReqItemDataBase.getContent()), (boolean)false);
        }
        if (bl || pSSysReqItemDataBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysReqItemDataBase.getJSONValue((Object)pSSysReqItemDataBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysReqItemDataBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysReqItemDataBase.getJSONValue((Object)pSSysReqItemDataBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysReqItemDataBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysReqItemDataBase.getJSONValue((Object)pSSysReqItemDataBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysReqItemDataBase.getPSSysReqItemDataId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemdataid", (Object)PSSysReqItemDataBase.getJSONValue((Object)pSSysReqItemDataBase.getPSSysReqItemDataId()), (boolean)false);
        }
        if (bl || pSSysReqItemDataBase.getPSSysReqItemDataName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemdataname", (Object)PSSysReqItemDataBase.getJSONValue((Object)pSSysReqItemDataBase.getPSSysReqItemDataName()), (boolean)false);
        }
        if (bl || pSSysReqItemDataBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSSysReqItemDataBase.getJSONValue((Object)pSSysReqItemDataBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSSysReqItemDataBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSSysReqItemDataBase.getJSONValue((Object)pSSysReqItemDataBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSSysReqItemDataBase.getSubject() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subject", (Object)PSSysReqItemDataBase.getJSONValue((Object)pSSysReqItemDataBase.getSubject()), (boolean)false);
        }
        if (bl || pSSysReqItemDataBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysReqItemDataBase.getJSONValue((Object)pSSysReqItemDataBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysReqItemDataBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysReqItemDataBase.getJSONValue((Object)pSSysReqItemDataBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysReqItemDataBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysReqItemDataBase.getJSONValue((Object)pSSysReqItemDataBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysReqItemDataBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysReqItemDataBase.getJSONValue((Object)pSSysReqItemDataBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysReqItemDataBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysReqItemDataBase.getJSONValue((Object)pSSysReqItemDataBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysReqItemDataBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysReqItemDataBase.getJSONValue((Object)pSSysReqItemDataBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysReqItemDataBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysReqItemDataBase.getJSONValue((Object)pSSysReqItemDataBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysReqItemDataBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysReqItemDataBase pSSysReqItemDataBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysReqItemDataBase.getAIBuildState() != null) {
            object = pSSysReqItemDataBase.getAIBuildState();
            xmlNode.setAttribute(FIELD_AIBUILDSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysReqItemDataBase.getAIChoices() != null) {
            object = pSSysReqItemDataBase.getAIChoices();
            xmlNode.setAttribute(FIELD_AICHOICES, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemDataBase.getAIPrompt() != null) {
            object = pSSysReqItemDataBase.getAIPrompt();
            xmlNode.setAttribute(FIELD_AIPROMPT, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemDataBase.getContent() != null) {
            object = pSSysReqItemDataBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemDataBase.getCreateDate() != null) {
            object = pSSysReqItemDataBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysReqItemDataBase.getCreateMan() != null) {
            object = pSSysReqItemDataBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemDataBase.getOrderValue() != null) {
            object = pSSysReqItemDataBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysReqItemDataBase.getPSSysReqItemDataId() != null) {
            object = pSSysReqItemDataBase.getPSSysReqItemDataId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMDATAID, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemDataBase.getPSSysReqItemDataName() != null) {
            object = pSSysReqItemDataBase.getPSSysReqItemDataName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMDATANAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemDataBase.getPSSysReqItemId() != null) {
            object = pSSysReqItemDataBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemDataBase.getPSSysReqItemName() != null) {
            object = pSSysReqItemDataBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemDataBase.getSubject() != null) {
            object = pSSysReqItemDataBase.getSubject();
            xmlNode.setAttribute(FIELD_SUBJECT, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemDataBase.getUpdateDate() != null) {
            object = pSSysReqItemDataBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysReqItemDataBase.getUpdateMan() != null) {
            object = pSSysReqItemDataBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemDataBase.getUserCat() != null) {
            object = pSSysReqItemDataBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemDataBase.getUserTag() != null) {
            object = pSSysReqItemDataBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemDataBase.getUserTag2() != null) {
            object = pSSysReqItemDataBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemDataBase.getUserTag3() != null) {
            object = pSSysReqItemDataBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemDataBase.getUserTag4() != null) {
            object = pSSysReqItemDataBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysReqItemDataBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysReqItemDataBase pSSysReqItemDataBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysReqItemDataBase.isAIBuildStateDirty() && (bl || pSSysReqItemDataBase.getAIBuildState() != null)) {
            iDataObject.set(FIELD_AIBUILDSTATE, (Object)pSSysReqItemDataBase.getAIBuildState());
        }
        if (pSSysReqItemDataBase.isAIChoicesDirty() && (bl || pSSysReqItemDataBase.getAIChoices() != null)) {
            iDataObject.set(FIELD_AICHOICES, (Object)pSSysReqItemDataBase.getAIChoices());
        }
        if (pSSysReqItemDataBase.isAIPromptDirty() && (bl || pSSysReqItemDataBase.getAIPrompt() != null)) {
            iDataObject.set(FIELD_AIPROMPT, (Object)pSSysReqItemDataBase.getAIPrompt());
        }
        if (pSSysReqItemDataBase.isContentDirty() && (bl || pSSysReqItemDataBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSSysReqItemDataBase.getContent());
        }
        if (pSSysReqItemDataBase.isCreateDateDirty() && (bl || pSSysReqItemDataBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysReqItemDataBase.getCreateDate());
        }
        if (pSSysReqItemDataBase.isCreateManDirty() && (bl || pSSysReqItemDataBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysReqItemDataBase.getCreateMan());
        }
        if (pSSysReqItemDataBase.isOrderValueDirty() && (bl || pSSysReqItemDataBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysReqItemDataBase.getOrderValue());
        }
        if (pSSysReqItemDataBase.isPSSysReqItemDataIdDirty() && (bl || pSSysReqItemDataBase.getPSSysReqItemDataId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMDATAID, (Object)pSSysReqItemDataBase.getPSSysReqItemDataId());
        }
        if (pSSysReqItemDataBase.isPSSysReqItemDataNameDirty() && (bl || pSSysReqItemDataBase.getPSSysReqItemDataName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMDATANAME, (Object)pSSysReqItemDataBase.getPSSysReqItemDataName());
        }
        if (pSSysReqItemDataBase.isPSSysReqItemIdDirty() && (bl || pSSysReqItemDataBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSSysReqItemDataBase.getPSSysReqItemId());
        }
        if (pSSysReqItemDataBase.isPSSysReqItemNameDirty() && (bl || pSSysReqItemDataBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSSysReqItemDataBase.getPSSysReqItemName());
        }
        if (pSSysReqItemDataBase.isSubjectDirty() && (bl || pSSysReqItemDataBase.getSubject() != null)) {
            iDataObject.set(FIELD_SUBJECT, (Object)pSSysReqItemDataBase.getSubject());
        }
        if (pSSysReqItemDataBase.isUpdateDateDirty() && (bl || pSSysReqItemDataBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysReqItemDataBase.getUpdateDate());
        }
        if (pSSysReqItemDataBase.isUpdateManDirty() && (bl || pSSysReqItemDataBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysReqItemDataBase.getUpdateMan());
        }
        if (pSSysReqItemDataBase.isUserCatDirty() && (bl || pSSysReqItemDataBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysReqItemDataBase.getUserCat());
        }
        if (pSSysReqItemDataBase.isUserTagDirty() && (bl || pSSysReqItemDataBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysReqItemDataBase.getUserTag());
        }
        if (pSSysReqItemDataBase.isUserTag2Dirty() && (bl || pSSysReqItemDataBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysReqItemDataBase.getUserTag2());
        }
        if (pSSysReqItemDataBase.isUserTag3Dirty() && (bl || pSSysReqItemDataBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysReqItemDataBase.getUserTag3());
        }
        if (pSSysReqItemDataBase.isUserTag4Dirty() && (bl || pSSysReqItemDataBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysReqItemDataBase.getUserTag4());
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
        return PSSysReqItemDataBase.remove(this, n);
    }

    private static boolean remove(PSSysReqItemDataBase pSSysReqItemDataBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysReqItemDataBase.resetAIBuildState();
                return true;
            }
            case 1: {
                pSSysReqItemDataBase.resetAIChoices();
                return true;
            }
            case 2: {
                pSSysReqItemDataBase.resetAIPrompt();
                return true;
            }
            case 3: {
                pSSysReqItemDataBase.resetContent();
                return true;
            }
            case 4: {
                pSSysReqItemDataBase.resetCreateDate();
                return true;
            }
            case 5: {
                pSSysReqItemDataBase.resetCreateMan();
                return true;
            }
            case 6: {
                pSSysReqItemDataBase.resetOrderValue();
                return true;
            }
            case 7: {
                pSSysReqItemDataBase.resetPSSysReqItemDataId();
                return true;
            }
            case 8: {
                pSSysReqItemDataBase.resetPSSysReqItemDataName();
                return true;
            }
            case 9: {
                pSSysReqItemDataBase.resetPSSysReqItemId();
                return true;
            }
            case 10: {
                pSSysReqItemDataBase.resetPSSysReqItemName();
                return true;
            }
            case 11: {
                pSSysReqItemDataBase.resetSubject();
                return true;
            }
            case 12: {
                pSSysReqItemDataBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSSysReqItemDataBase.resetUpdateMan();
                return true;
            }
            case 14: {
                pSSysReqItemDataBase.resetUserCat();
                return true;
            }
            case 15: {
                pSSysReqItemDataBase.resetUserTag();
                return true;
            }
            case 16: {
                pSSysReqItemDataBase.resetUserTag2();
                return true;
            }
            case 17: {
                pSSysReqItemDataBase.resetUserTag3();
                return true;
            }
            case 18: {
                pSSysReqItemDataBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysReqItem getPSSysReqItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItem();
        }
        if (this.getPSSysReqItemId() == null) {
            return null;
        }
        Integer n = this.objPSSysReqItemLock;
        synchronized (n) {
            if (this.pssysreqitem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysReqItemId(), (Object)this.pssysreqitem.getPSSysReqItemId()) != 0L) {
                this.pssysreqitem = null;
            }
            if (this.pssysreqitem == null) {
                PSSysReqItem pSSysReqItem = new PSSysReqItem();
                pSSysReqItem.setPSSysReqItemId(this.getPSSysReqItemId());
                PSSysReqItemService pSSysReqItemService = (PSSysReqItemService)ServiceGlobal.getService(PSSysReqItemService.class, (SessionFactory)this.getSessionFactory());
                pSSysReqItemService.autoGet((IEntity)pSSysReqItem);
                this.pssysreqitem = pSSysReqItem;
            }
            return this.pssysreqitem;
        }
    }

    private PSSysReqItemDataBase getProxyEntity() {
        return this.proxyPSSysReqItemDataBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysReqItemDataBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysReqItemDataBase) {
            this.proxyPSSysReqItemDataBase = (PSSysReqItemDataBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemDataService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AIBUILDSTATE, 0);
        fieldIndexMap.put(FIELD_AICHOICES, 1);
        fieldIndexMap.put(FIELD_AIPROMPT, 2);
        fieldIndexMap.put(FIELD_CONTENT, 3);
        fieldIndexMap.put(FIELD_CREATEDATE, 4);
        fieldIndexMap.put(FIELD_CREATEMAN, 5);
        fieldIndexMap.put(FIELD_ORDERVALUE, 6);
        fieldIndexMap.put(FIELD_PSSYSREQITEMDATAID, 7);
        fieldIndexMap.put(FIELD_PSSYSREQITEMDATANAME, 8);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 9);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 10);
        fieldIndexMap.put(FIELD_SUBJECT, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
        fieldIndexMap.put(FIELD_USERCAT, 14);
        fieldIndexMap.put(FIELD_USERTAG, 15);
        fieldIndexMap.put(FIELD_USERTAG2, 16);
        fieldIndexMap.put(FIELD_USERTAG3, 17);
        fieldIndexMap.put(FIELD_USERTAG4, 18);
    }
}

