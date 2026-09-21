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
import net.ibizsys.pscore.srv.sysdesign.entity.PSDERTAW;
import net.ibizsys.pscore.srv.sysdesign.service.PSDERTAWService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDERTAWIBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDERTAWIBase.class);
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_ITEMLABEL = "ITEMLABEL";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDERTAWID = "PSDERTAWID";
    public static final String FIELD_PSDERTAWIID = "PSDERTAWIID";
    public static final String FIELD_PSDERTAWINAME = "PSDERTAWINAME";
    public static final String FIELD_PSDERTAWNAME = "PSDERTAWNAME";
    public static final String FIELD_REPLACEVALUE = "REPLACEVALUE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_URL = "URL";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VALUE = "VALUE";
    private static final int INDEX_CONTENT = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DEFAULTFLAG = 3;
    private static final int INDEX_ITEMLABEL = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_ORDERVALUE = 6;
    private static final int INDEX_PSDERTAWID = 7;
    private static final int INDEX_PSDERTAWIID = 8;
    private static final int INDEX_PSDERTAWINAME = 9;
    private static final int INDEX_PSDERTAWNAME = 10;
    private static final int INDEX_REPLACEVALUE = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final int INDEX_URL = 14;
    private static final int INDEX_USERTAG = 15;
    private static final int INDEX_USERTAG2 = 16;
    private static final int INDEX_VALIDFLAG = 17;
    private static final int INDEX_VALUE = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDERTAWIBase proxyPSDERTAWIBase = null;
    private boolean contentDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean itemlabelDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdertawidDirtyFlag = false;
    private boolean psdertawiidDirtyFlag = false;
    private boolean psdertawinameDirtyFlag = false;
    private boolean psdertawnameDirtyFlag = false;
    private boolean replacevalueDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean urlDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean valueDirtyFlag = false;
    @Column(name="content")
    private String content;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="itemlabel")
    private String itemlabel;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdertawid")
    private String psdertawid;
    @Column(name="psdertawiid")
    private String psdertawiid;
    @Column(name="psdertawiname")
    private String psdertawiname;
    @Column(name="psdertawname")
    private String psdertawname;
    @Column(name="replacevalue")
    private Integer replacevalue;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="url")
    private String url;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="value")
    private String value;
    private Integer objPSDERTAWLock = new Integer(1);
    private PSDERTAW psdertaw = null;

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

    public void setDefaultFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultFlag(n);
            return;
        }
        this.defaultflag = n;
        this.defaultflagDirtyFlag = true;
    }

    public Integer getDefaultFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultFlag();
        }
        return this.defaultflag;
    }

    public boolean isDefaultFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultFlagDirty();
        }
        return this.defaultflagDirtyFlag;
    }

    public void resetDefaultFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultFlag();
            return;
        }
        this.defaultflagDirtyFlag = false;
        this.defaultflag = null;
    }

    public void setItemLabel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemLabel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemlabel = string;
        this.itemlabelDirtyFlag = true;
    }

    public String getItemLabel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemLabel();
        }
        return this.itemlabel;
    }

    public boolean isItemLabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemLabelDirty();
        }
        return this.itemlabelDirtyFlag;
    }

    public void resetItemLabel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemLabel();
            return;
        }
        this.itemlabelDirtyFlag = false;
        this.itemlabel = null;
    }

    public void setMemo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMemo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.memo = string;
        this.memoDirtyFlag = true;
    }

    public String getMemo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMemo();
        }
        return this.memo;
    }

    public boolean isMemoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMemoDirty();
        }
        return this.memoDirtyFlag;
    }

    public void resetMemo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMemo();
            return;
        }
        this.memoDirtyFlag = false;
        this.memo = null;
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

    public void setPSDERTAWId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERTAWId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdertawid = string;
        this.psdertawidDirtyFlag = true;
    }

    public String getPSDERTAWId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERTAWId();
        }
        return this.psdertawid;
    }

    public boolean isPSDERTAWIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERTAWIdDirty();
        }
        return this.psdertawidDirtyFlag;
    }

    public void resetPSDERTAWId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERTAWId();
            return;
        }
        this.psdertawidDirtyFlag = false;
        this.psdertawid = null;
    }

    public void setPSDERTAWIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERTAWIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdertawiid = string;
        this.psdertawiidDirtyFlag = true;
    }

    public String getPSDERTAWIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERTAWIId();
        }
        return this.psdertawiid;
    }

    public boolean isPSDERTAWIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERTAWIIdDirty();
        }
        return this.psdertawiidDirtyFlag;
    }

    public void resetPSDERTAWIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERTAWIId();
            return;
        }
        this.psdertawiidDirtyFlag = false;
        this.psdertawiid = null;
    }

    public void setPSDERTAWIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERTAWIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdertawiname = string;
        this.psdertawinameDirtyFlag = true;
    }

    public String getPSDERTAWIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERTAWIName();
        }
        return this.psdertawiname;
    }

    public boolean isPSDERTAWINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERTAWINameDirty();
        }
        return this.psdertawinameDirtyFlag;
    }

    public void resetPSDERTAWIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERTAWIName();
            return;
        }
        this.psdertawinameDirtyFlag = false;
        this.psdertawiname = null;
    }

    public void setPSDERTAWName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERTAWName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdertawname = string;
        this.psdertawnameDirtyFlag = true;
    }

    public String getPSDERTAWName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERTAWName();
        }
        return this.psdertawname;
    }

    public boolean isPSDERTAWNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERTAWNameDirty();
        }
        return this.psdertawnameDirtyFlag;
    }

    public void resetPSDERTAWName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERTAWName();
            return;
        }
        this.psdertawnameDirtyFlag = false;
        this.psdertawname = null;
    }

    public void setReplaceValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReplaceValue(n);
            return;
        }
        this.replacevalue = n;
        this.replacevalueDirtyFlag = true;
    }

    public Integer getReplaceValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReplaceValue();
        }
        return this.replacevalue;
    }

    public boolean isReplaceValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReplaceValueDirty();
        }
        return this.replacevalueDirtyFlag;
    }

    public void resetReplaceValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReplaceValue();
            return;
        }
        this.replacevalueDirtyFlag = false;
        this.replacevalue = null;
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

    public void setUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.url = string;
        this.urlDirtyFlag = true;
    }

    public String getUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUrl();
        }
        return this.url;
    }

    public boolean isUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUrlDirty();
        }
        return this.urlDirtyFlag;
    }

    public void resetUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUrl();
            return;
        }
        this.urlDirtyFlag = false;
        this.url = null;
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

    public void setValidFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValidFlag(n);
            return;
        }
        this.validflag = n;
        this.validflagDirtyFlag = true;
    }

    public Integer getValidFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValidFlag();
        }
        return this.validflag;
    }

    public boolean isValidFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValidFlagDirty();
        }
        return this.validflagDirtyFlag;
    }

    public void resetValidFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValidFlag();
            return;
        }
        this.validflagDirtyFlag = false;
        this.validflag = null;
    }

    public void setValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.value = string;
        this.valueDirtyFlag = true;
    }

    public String getValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValue();
        }
        return this.value;
    }

    public boolean isValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValueDirty();
        }
        return this.valueDirtyFlag;
    }

    public void resetValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValue();
            return;
        }
        this.valueDirtyFlag = false;
        this.value = null;
    }

    protected void onReset() {
        PSDERTAWIBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDERTAWIBase pSDERTAWIBase) {
        pSDERTAWIBase.resetContent();
        pSDERTAWIBase.resetCreateDate();
        pSDERTAWIBase.resetCreateMan();
        pSDERTAWIBase.resetDefaultFlag();
        pSDERTAWIBase.resetItemLabel();
        pSDERTAWIBase.resetMemo();
        pSDERTAWIBase.resetOrderValue();
        pSDERTAWIBase.resetPSDERTAWId();
        pSDERTAWIBase.resetPSDERTAWIId();
        pSDERTAWIBase.resetPSDERTAWIName();
        pSDERTAWIBase.resetPSDERTAWName();
        pSDERTAWIBase.resetReplaceValue();
        pSDERTAWIBase.resetUpdateDate();
        pSDERTAWIBase.resetUpdateMan();
        pSDERTAWIBase.resetUrl();
        pSDERTAWIBase.resetUserTag();
        pSDERTAWIBase.resetUserTag2();
        pSDERTAWIBase.resetValidFlag();
        pSDERTAWIBase.resetValue();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isContentDirty()) {
            hashMap.put(FIELD_CONTENT, this.getContent());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
        }
        if (!bl || this.isItemLabelDirty()) {
            hashMap.put(FIELD_ITEMLABEL, this.getItemLabel());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDERTAWIdDirty()) {
            hashMap.put(FIELD_PSDERTAWID, this.getPSDERTAWId());
        }
        if (!bl || this.isPSDERTAWIIdDirty()) {
            hashMap.put(FIELD_PSDERTAWIID, this.getPSDERTAWIId());
        }
        if (!bl || this.isPSDERTAWINameDirty()) {
            hashMap.put(FIELD_PSDERTAWINAME, this.getPSDERTAWIName());
        }
        if (!bl || this.isPSDERTAWNameDirty()) {
            hashMap.put(FIELD_PSDERTAWNAME, this.getPSDERTAWName());
        }
        if (!bl || this.isReplaceValueDirty()) {
            hashMap.put(FIELD_REPLACEVALUE, this.getReplaceValue());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUrlDirty()) {
            hashMap.put(FIELD_URL, this.getUrl());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
        }
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
        }
        if (!bl || this.isValueDirty()) {
            hashMap.put(FIELD_VALUE, this.getValue());
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
        return PSDERTAWIBase.get(this, n);
    }

    private static Object get(PSDERTAWIBase pSDERTAWIBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDERTAWIBase.getContent();
            }
            case 1: {
                return pSDERTAWIBase.getCreateDate();
            }
            case 2: {
                return pSDERTAWIBase.getCreateMan();
            }
            case 3: {
                return pSDERTAWIBase.getDefaultFlag();
            }
            case 4: {
                return pSDERTAWIBase.getItemLabel();
            }
            case 5: {
                return pSDERTAWIBase.getMemo();
            }
            case 6: {
                return pSDERTAWIBase.getOrderValue();
            }
            case 7: {
                return pSDERTAWIBase.getPSDERTAWId();
            }
            case 8: {
                return pSDERTAWIBase.getPSDERTAWIId();
            }
            case 9: {
                return pSDERTAWIBase.getPSDERTAWIName();
            }
            case 10: {
                return pSDERTAWIBase.getPSDERTAWName();
            }
            case 11: {
                return pSDERTAWIBase.getReplaceValue();
            }
            case 12: {
                return pSDERTAWIBase.getUpdateDate();
            }
            case 13: {
                return pSDERTAWIBase.getUpdateMan();
            }
            case 14: {
                return pSDERTAWIBase.getUrl();
            }
            case 15: {
                return pSDERTAWIBase.getUserTag();
            }
            case 16: {
                return pSDERTAWIBase.getUserTag2();
            }
            case 17: {
                return pSDERTAWIBase.getValidFlag();
            }
            case 18: {
                return pSDERTAWIBase.getValue();
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
        PSDERTAWIBase.set(this, n, object);
    }

    private static void set(PSDERTAWIBase pSDERTAWIBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDERTAWIBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDERTAWIBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDERTAWIBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDERTAWIBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDERTAWIBase.setItemLabel(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDERTAWIBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDERTAWIBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDERTAWIBase.setPSDERTAWId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDERTAWIBase.setPSDERTAWIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDERTAWIBase.setPSDERTAWIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDERTAWIBase.setPSDERTAWName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDERTAWIBase.setReplaceValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDERTAWIBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSDERTAWIBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDERTAWIBase.setUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDERTAWIBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDERTAWIBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDERTAWIBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSDERTAWIBase.setValue(DataObject.getStringValue((Object)object));
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
        return PSDERTAWIBase.isNull(this, n);
    }

    private static boolean isNull(PSDERTAWIBase pSDERTAWIBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDERTAWIBase.getContent() == null;
            }
            case 1: {
                return pSDERTAWIBase.getCreateDate() == null;
            }
            case 2: {
                return pSDERTAWIBase.getCreateMan() == null;
            }
            case 3: {
                return pSDERTAWIBase.getDefaultFlag() == null;
            }
            case 4: {
                return pSDERTAWIBase.getItemLabel() == null;
            }
            case 5: {
                return pSDERTAWIBase.getMemo() == null;
            }
            case 6: {
                return pSDERTAWIBase.getOrderValue() == null;
            }
            case 7: {
                return pSDERTAWIBase.getPSDERTAWId() == null;
            }
            case 8: {
                return pSDERTAWIBase.getPSDERTAWIId() == null;
            }
            case 9: {
                return pSDERTAWIBase.getPSDERTAWIName() == null;
            }
            case 10: {
                return pSDERTAWIBase.getPSDERTAWName() == null;
            }
            case 11: {
                return pSDERTAWIBase.getReplaceValue() == null;
            }
            case 12: {
                return pSDERTAWIBase.getUpdateDate() == null;
            }
            case 13: {
                return pSDERTAWIBase.getUpdateMan() == null;
            }
            case 14: {
                return pSDERTAWIBase.getUrl() == null;
            }
            case 15: {
                return pSDERTAWIBase.getUserTag() == null;
            }
            case 16: {
                return pSDERTAWIBase.getUserTag2() == null;
            }
            case 17: {
                return pSDERTAWIBase.getValidFlag() == null;
            }
            case 18: {
                return pSDERTAWIBase.getValue() == null;
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
        return PSDERTAWIBase.contains(this, n);
    }

    private static boolean contains(PSDERTAWIBase pSDERTAWIBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDERTAWIBase.isContentDirty();
            }
            case 1: {
                return pSDERTAWIBase.isCreateDateDirty();
            }
            case 2: {
                return pSDERTAWIBase.isCreateManDirty();
            }
            case 3: {
                return pSDERTAWIBase.isDefaultFlagDirty();
            }
            case 4: {
                return pSDERTAWIBase.isItemLabelDirty();
            }
            case 5: {
                return pSDERTAWIBase.isMemoDirty();
            }
            case 6: {
                return pSDERTAWIBase.isOrderValueDirty();
            }
            case 7: {
                return pSDERTAWIBase.isPSDERTAWIdDirty();
            }
            case 8: {
                return pSDERTAWIBase.isPSDERTAWIIdDirty();
            }
            case 9: {
                return pSDERTAWIBase.isPSDERTAWINameDirty();
            }
            case 10: {
                return pSDERTAWIBase.isPSDERTAWNameDirty();
            }
            case 11: {
                return pSDERTAWIBase.isReplaceValueDirty();
            }
            case 12: {
                return pSDERTAWIBase.isUpdateDateDirty();
            }
            case 13: {
                return pSDERTAWIBase.isUpdateManDirty();
            }
            case 14: {
                return pSDERTAWIBase.isUrlDirty();
            }
            case 15: {
                return pSDERTAWIBase.isUserTagDirty();
            }
            case 16: {
                return pSDERTAWIBase.isUserTag2Dirty();
            }
            case 17: {
                return pSDERTAWIBase.isValidFlagDirty();
            }
            case 18: {
                return pSDERTAWIBase.isValueDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDERTAWIBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDERTAWIBase pSDERTAWIBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDERTAWIBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSDERTAWIBase.getJSONValue((Object)pSDERTAWIBase.getContent()), (boolean)false);
        }
        if (bl || pSDERTAWIBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDERTAWIBase.getJSONValue((Object)pSDERTAWIBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDERTAWIBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDERTAWIBase.getJSONValue((Object)pSDERTAWIBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDERTAWIBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSDERTAWIBase.getJSONValue((Object)pSDERTAWIBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSDERTAWIBase.getItemLabel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemlabel", (Object)PSDERTAWIBase.getJSONValue((Object)pSDERTAWIBase.getItemLabel()), (boolean)false);
        }
        if (bl || pSDERTAWIBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDERTAWIBase.getJSONValue((Object)pSDERTAWIBase.getMemo()), (boolean)false);
        }
        if (bl || pSDERTAWIBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDERTAWIBase.getJSONValue((Object)pSDERTAWIBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDERTAWIBase.getPSDERTAWId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdertawid", (Object)PSDERTAWIBase.getJSONValue((Object)pSDERTAWIBase.getPSDERTAWId()), (boolean)false);
        }
        if (bl || pSDERTAWIBase.getPSDERTAWIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdertawiid", (Object)PSDERTAWIBase.getJSONValue((Object)pSDERTAWIBase.getPSDERTAWIId()), (boolean)false);
        }
        if (bl || pSDERTAWIBase.getPSDERTAWIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdertawiname", (Object)PSDERTAWIBase.getJSONValue((Object)pSDERTAWIBase.getPSDERTAWIName()), (boolean)false);
        }
        if (bl || pSDERTAWIBase.getPSDERTAWName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdertawname", (Object)PSDERTAWIBase.getJSONValue((Object)pSDERTAWIBase.getPSDERTAWName()), (boolean)false);
        }
        if (bl || pSDERTAWIBase.getReplaceValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"replacevalue", (Object)PSDERTAWIBase.getJSONValue((Object)pSDERTAWIBase.getReplaceValue()), (boolean)false);
        }
        if (bl || pSDERTAWIBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDERTAWIBase.getJSONValue((Object)pSDERTAWIBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDERTAWIBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDERTAWIBase.getJSONValue((Object)pSDERTAWIBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDERTAWIBase.getUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"url", (Object)PSDERTAWIBase.getJSONValue((Object)pSDERTAWIBase.getUrl()), (boolean)false);
        }
        if (bl || pSDERTAWIBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDERTAWIBase.getJSONValue((Object)pSDERTAWIBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDERTAWIBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDERTAWIBase.getJSONValue((Object)pSDERTAWIBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDERTAWIBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDERTAWIBase.getJSONValue((Object)pSDERTAWIBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSDERTAWIBase.getValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"value", (Object)PSDERTAWIBase.getJSONValue((Object)pSDERTAWIBase.getValue()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDERTAWIBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDERTAWIBase pSDERTAWIBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDERTAWIBase.getContent() != null) {
            object = pSDERTAWIBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSDERTAWIBase.getCreateDate() != null) {
            object = pSDERTAWIBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDERTAWIBase.getCreateMan() != null) {
            object = pSDERTAWIBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDERTAWIBase.getDefaultFlag() != null) {
            object = pSDERTAWIBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERTAWIBase.getItemLabel() != null) {
            object = pSDERTAWIBase.getItemLabel();
            xmlNode.setAttribute(FIELD_ITEMLABEL, object == null ? "" : (String)object);
        }
        if (bl || pSDERTAWIBase.getMemo() != null) {
            object = pSDERTAWIBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDERTAWIBase.getOrderValue() != null) {
            object = pSDERTAWIBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERTAWIBase.getPSDERTAWId() != null) {
            object = pSDERTAWIBase.getPSDERTAWId();
            xmlNode.setAttribute(FIELD_PSDERTAWID, object == null ? "" : (String)object);
        }
        if (bl || pSDERTAWIBase.getPSDERTAWIId() != null) {
            object = pSDERTAWIBase.getPSDERTAWIId();
            xmlNode.setAttribute(FIELD_PSDERTAWIID, object == null ? "" : (String)object);
        }
        if (bl || pSDERTAWIBase.getPSDERTAWIName() != null) {
            object = pSDERTAWIBase.getPSDERTAWIName();
            xmlNode.setAttribute(FIELD_PSDERTAWINAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERTAWIBase.getPSDERTAWName() != null) {
            object = pSDERTAWIBase.getPSDERTAWName();
            xmlNode.setAttribute(FIELD_PSDERTAWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERTAWIBase.getReplaceValue() != null) {
            object = pSDERTAWIBase.getReplaceValue();
            xmlNode.setAttribute(FIELD_REPLACEVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERTAWIBase.getUpdateDate() != null) {
            object = pSDERTAWIBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDERTAWIBase.getUpdateMan() != null) {
            object = pSDERTAWIBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDERTAWIBase.getUrl() != null) {
            object = pSDERTAWIBase.getUrl();
            xmlNode.setAttribute(FIELD_URL, object == null ? "" : (String)object);
        }
        if (bl || pSDERTAWIBase.getUserTag() != null) {
            object = pSDERTAWIBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDERTAWIBase.getUserTag2() != null) {
            object = pSDERTAWIBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDERTAWIBase.getValidFlag() != null) {
            object = pSDERTAWIBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERTAWIBase.getValue() != null) {
            object = pSDERTAWIBase.getValue();
            xmlNode.setAttribute(FIELD_VALUE, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDERTAWIBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDERTAWIBase pSDERTAWIBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDERTAWIBase.isContentDirty() && (bl || pSDERTAWIBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSDERTAWIBase.getContent());
        }
        if (pSDERTAWIBase.isCreateDateDirty() && (bl || pSDERTAWIBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDERTAWIBase.getCreateDate());
        }
        if (pSDERTAWIBase.isCreateManDirty() && (bl || pSDERTAWIBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDERTAWIBase.getCreateMan());
        }
        if (pSDERTAWIBase.isDefaultFlagDirty() && (bl || pSDERTAWIBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSDERTAWIBase.getDefaultFlag());
        }
        if (pSDERTAWIBase.isItemLabelDirty() && (bl || pSDERTAWIBase.getItemLabel() != null)) {
            iDataObject.set(FIELD_ITEMLABEL, (Object)pSDERTAWIBase.getItemLabel());
        }
        if (pSDERTAWIBase.isMemoDirty() && (bl || pSDERTAWIBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDERTAWIBase.getMemo());
        }
        if (pSDERTAWIBase.isOrderValueDirty() && (bl || pSDERTAWIBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDERTAWIBase.getOrderValue());
        }
        if (pSDERTAWIBase.isPSDERTAWIdDirty() && (bl || pSDERTAWIBase.getPSDERTAWId() != null)) {
            iDataObject.set(FIELD_PSDERTAWID, (Object)pSDERTAWIBase.getPSDERTAWId());
        }
        if (pSDERTAWIBase.isPSDERTAWIIdDirty() && (bl || pSDERTAWIBase.getPSDERTAWIId() != null)) {
            iDataObject.set(FIELD_PSDERTAWIID, (Object)pSDERTAWIBase.getPSDERTAWIId());
        }
        if (pSDERTAWIBase.isPSDERTAWINameDirty() && (bl || pSDERTAWIBase.getPSDERTAWIName() != null)) {
            iDataObject.set(FIELD_PSDERTAWINAME, (Object)pSDERTAWIBase.getPSDERTAWIName());
        }
        if (pSDERTAWIBase.isPSDERTAWNameDirty() && (bl || pSDERTAWIBase.getPSDERTAWName() != null)) {
            iDataObject.set(FIELD_PSDERTAWNAME, (Object)pSDERTAWIBase.getPSDERTAWName());
        }
        if (pSDERTAWIBase.isReplaceValueDirty() && (bl || pSDERTAWIBase.getReplaceValue() != null)) {
            iDataObject.set(FIELD_REPLACEVALUE, (Object)pSDERTAWIBase.getReplaceValue());
        }
        if (pSDERTAWIBase.isUpdateDateDirty() && (bl || pSDERTAWIBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDERTAWIBase.getUpdateDate());
        }
        if (pSDERTAWIBase.isUpdateManDirty() && (bl || pSDERTAWIBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDERTAWIBase.getUpdateMan());
        }
        if (pSDERTAWIBase.isUrlDirty() && (bl || pSDERTAWIBase.getUrl() != null)) {
            iDataObject.set(FIELD_URL, (Object)pSDERTAWIBase.getUrl());
        }
        if (pSDERTAWIBase.isUserTagDirty() && (bl || pSDERTAWIBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDERTAWIBase.getUserTag());
        }
        if (pSDERTAWIBase.isUserTag2Dirty() && (bl || pSDERTAWIBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDERTAWIBase.getUserTag2());
        }
        if (pSDERTAWIBase.isValidFlagDirty() && (bl || pSDERTAWIBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDERTAWIBase.getValidFlag());
        }
        if (pSDERTAWIBase.isValueDirty() && (bl || pSDERTAWIBase.getValue() != null)) {
            iDataObject.set(FIELD_VALUE, (Object)pSDERTAWIBase.getValue());
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
        return PSDERTAWIBase.remove(this, n);
    }

    private static boolean remove(PSDERTAWIBase pSDERTAWIBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDERTAWIBase.resetContent();
                return true;
            }
            case 1: {
                pSDERTAWIBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDERTAWIBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDERTAWIBase.resetDefaultFlag();
                return true;
            }
            case 4: {
                pSDERTAWIBase.resetItemLabel();
                return true;
            }
            case 5: {
                pSDERTAWIBase.resetMemo();
                return true;
            }
            case 6: {
                pSDERTAWIBase.resetOrderValue();
                return true;
            }
            case 7: {
                pSDERTAWIBase.resetPSDERTAWId();
                return true;
            }
            case 8: {
                pSDERTAWIBase.resetPSDERTAWIId();
                return true;
            }
            case 9: {
                pSDERTAWIBase.resetPSDERTAWIName();
                return true;
            }
            case 10: {
                pSDERTAWIBase.resetPSDERTAWName();
                return true;
            }
            case 11: {
                pSDERTAWIBase.resetReplaceValue();
                return true;
            }
            case 12: {
                pSDERTAWIBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSDERTAWIBase.resetUpdateMan();
                return true;
            }
            case 14: {
                pSDERTAWIBase.resetUrl();
                return true;
            }
            case 15: {
                pSDERTAWIBase.resetUserTag();
                return true;
            }
            case 16: {
                pSDERTAWIBase.resetUserTag2();
                return true;
            }
            case 17: {
                pSDERTAWIBase.resetValidFlag();
                return true;
            }
            case 18: {
                pSDERTAWIBase.resetValue();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDERTAW getPSDERTAW() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERTAW();
        }
        if (this.getPSDERTAWId() == null) {
            return null;
        }
        Integer n = this.objPSDERTAWLock;
        synchronized (n) {
            if (this.psdertaw != null && DataTypeHelper.compare((int)25, (Object)this.getPSDERTAWId(), (Object)this.psdertaw.getPSDERTAWId()) != 0L) {
                this.psdertaw = null;
            }
            if (this.psdertaw == null) {
                PSDERTAW pSDERTAW = new PSDERTAW();
                pSDERTAW.setPSDERTAWId(this.getPSDERTAWId());
                PSDERTAWService pSDERTAWService = (PSDERTAWService)ServiceGlobal.getService(PSDERTAWService.class, (SessionFactory)this.getSessionFactory());
                pSDERTAWService.autoGet((IEntity)pSDERTAW);
                this.psdertaw = pSDERTAW;
            }
            return this.psdertaw;
        }
    }

    private PSDERTAWIBase getProxyEntity() {
        return this.proxyPSDERTAWIBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDERTAWIBase = null;
        if (iDataObject != null && iDataObject instanceof PSDERTAWIBase) {
            this.proxyPSDERTAWIBase = (PSDERTAWIBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDERTAWIService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONTENT, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 3);
        fieldIndexMap.put(FIELD_ITEMLABEL, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_ORDERVALUE, 6);
        fieldIndexMap.put(FIELD_PSDERTAWID, 7);
        fieldIndexMap.put(FIELD_PSDERTAWIID, 8);
        fieldIndexMap.put(FIELD_PSDERTAWINAME, 9);
        fieldIndexMap.put(FIELD_PSDERTAWNAME, 10);
        fieldIndexMap.put(FIELD_REPLACEVALUE, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
        fieldIndexMap.put(FIELD_URL, 14);
        fieldIndexMap.put(FIELD_USERTAG, 15);
        fieldIndexMap.put(FIELD_USERTAG2, 16);
        fieldIndexMap.put(FIELD_VALIDFLAG, 17);
        fieldIndexMap.put(FIELD_VALUE, 18);
    }
}

