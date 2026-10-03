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
package net.ibizsys.pscore.srv.paasmgr.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSStudioPluginBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSStudioPluginBase.class);
    public static final String FIELD_ALLDCFLAG = "ALLDCFLAG";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_KEYWORDS = "KEYWORDS";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PLUGINCAT = "PLUGINCAT";
    public static final String FIELD_PLUGINDATA = "PLUGINDATA";
    public static final String FIELD_PLUGINDATA2 = "PLUGINDATA2";
    public static final String FIELD_PLUGINDESC = "PLUGINDESC";
    public static final String FIELD_PLUGINDESCURL = "PLUGINDESCURL";
    public static final String FIELD_PLUGINICONURL = "PLUGINICONURL";
    public static final String FIELD_PLUGINOBJ = "PLUGINOBJ";
    public static final String FIELD_PLUGINURL = "PLUGINURL";
    public static final String FIELD_PLUGINURL2 = "PLUGINURL2";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSOBJTYPE = "PSOBJTYPE";
    public static final String FIELD_PSOBJTYPENAME = "PSOBJTYPENAME";
    public static final String FIELD_PSSTUDIOPLUGINID = "PSSTUDIOPLUGINID";
    public static final String FIELD_PSSTUDIOPLUGINNAME = "PSSTUDIOPLUGINNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ALLDCFLAG = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_CUSTOMCODE = 3;
    private static final int INDEX_KEYWORDS = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_ORDERVALUE = 6;
    private static final int INDEX_PLUGINCAT = 7;
    private static final int INDEX_PLUGINDATA = 8;
    private static final int INDEX_PLUGINDATA2 = 9;
    private static final int INDEX_PLUGINDESC = 10;
    private static final int INDEX_PLUGINDESCURL = 11;
    private static final int INDEX_PLUGINICONURL = 12;
    private static final int INDEX_PLUGINOBJ = 13;
    private static final int INDEX_PLUGINURL = 14;
    private static final int INDEX_PLUGINURL2 = 15;
    private static final int INDEX_PSDEVCENTERID = 16;
    private static final int INDEX_PSDEVCENTERNAME = 17;
    private static final int INDEX_PSOBJTYPE = 18;
    private static final int INDEX_PSOBJTYPENAME = 19;
    private static final int INDEX_PSSTUDIOPLUGINID = 20;
    private static final int INDEX_PSSTUDIOPLUGINNAME = 21;
    private static final int INDEX_UPDATEDATE = 22;
    private static final int INDEX_UPDATEMAN = 23;
    private static final int INDEX_VALIDFLAG = 24;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSStudioPluginBase proxyPSStudioPluginBase = null;
    private boolean alldcflagDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean keywordsDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean plugincatDirtyFlag = false;
    private boolean plugindataDirtyFlag = false;
    private boolean plugindata2DirtyFlag = false;
    private boolean plugindescDirtyFlag = false;
    private boolean plugindescurlDirtyFlag = false;
    private boolean pluginiconurlDirtyFlag = false;
    private boolean pluginobjDirtyFlag = false;
    private boolean pluginurlDirtyFlag = false;
    private boolean pluginurl2DirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psobjtypeDirtyFlag = false;
    private boolean psobjtypenameDirtyFlag = false;
    private boolean psstudiopluginidDirtyFlag = false;
    private boolean psstudiopluginnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="alldcflag")
    private Integer alldcflag;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcode")
    private String customcode;
    @Column(name="keywords")
    private String keywords;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="plugincat")
    private String plugincat;
    @Column(name="plugindata")
    private String plugindata;
    @Column(name="plugindata2")
    private String plugindata2;
    @Column(name="plugindesc")
    private String plugindesc;
    @Column(name="plugindescurl")
    private String plugindescurl;
    @Column(name="pluginiconurl")
    private String pluginiconurl;
    @Column(name="pluginobj")
    private String pluginobj;
    @Column(name="pluginurl")
    private String pluginurl;
    @Column(name="pluginurl2")
    private String pluginurl2;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psobjtype")
    private String psobjtype;
    @Column(name="psobjtypename")
    private String psobjtypename;
    @Column(name="psstudiopluginid")
    private String psstudiopluginid;
    @Column(name="psstudiopluginname")
    private String psstudiopluginname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;

    public void setAllDCFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAllDCFlag(n);
            return;
        }
        this.alldcflag = n;
        this.alldcflagDirtyFlag = true;
    }

    public Integer getAllDCFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAllDCFlag();
        }
        return this.alldcflag;
    }

    public boolean isAllDCFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAllDCFlagDirty();
        }
        return this.alldcflagDirtyFlag;
    }

    public void resetAllDCFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAllDCFlag();
            return;
        }
        this.alldcflagDirtyFlag = false;
        this.alldcflag = null;
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

    public void setCustomCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customcode = string;
        this.customcodeDirtyFlag = true;
    }

    public String getCustomCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomCode();
        }
        return this.customcode;
    }

    public boolean isCustomCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomCodeDirty();
        }
        return this.customcodeDirtyFlag;
    }

    public void resetCustomCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomCode();
            return;
        }
        this.customcodeDirtyFlag = false;
        this.customcode = null;
    }

    public void setKeywords(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKeywords(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.keywords = string;
        this.keywordsDirtyFlag = true;
    }

    public String getKeywords() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKeywords();
        }
        return this.keywords;
    }

    public boolean isKeywordsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKeywordsDirty();
        }
        return this.keywordsDirtyFlag;
    }

    public void resetKeywords() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKeywords();
            return;
        }
        this.keywordsDirtyFlag = false;
        this.keywords = null;
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

    public void setPluginCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPluginCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.plugincat = string;
        this.plugincatDirtyFlag = true;
    }

    public String getPluginCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPluginCat();
        }
        return this.plugincat;
    }

    public boolean isPluginCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPluginCatDirty();
        }
        return this.plugincatDirtyFlag;
    }

    public void resetPluginCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPluginCat();
            return;
        }
        this.plugincatDirtyFlag = false;
        this.plugincat = null;
    }

    public void setPluginData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPluginData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.plugindata = string;
        this.plugindataDirtyFlag = true;
    }

    public String getPluginData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPluginData();
        }
        return this.plugindata;
    }

    public boolean isPluginDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPluginDataDirty();
        }
        return this.plugindataDirtyFlag;
    }

    public void resetPluginData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPluginData();
            return;
        }
        this.plugindataDirtyFlag = false;
        this.plugindata = null;
    }

    public void setPluginData2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPluginData2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.plugindata2 = string;
        this.plugindata2DirtyFlag = true;
    }

    public String getPluginData2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPluginData2();
        }
        return this.plugindata2;
    }

    public boolean isPluginData2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPluginData2Dirty();
        }
        return this.plugindata2DirtyFlag;
    }

    public void resetPluginData2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPluginData2();
            return;
        }
        this.plugindata2DirtyFlag = false;
        this.plugindata2 = null;
    }

    public void setPluginDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPluginDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.plugindesc = string;
        this.plugindescDirtyFlag = true;
    }

    public String getPluginDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPluginDesc();
        }
        return this.plugindesc;
    }

    public boolean isPluginDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPluginDescDirty();
        }
        return this.plugindescDirtyFlag;
    }

    public void resetPluginDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPluginDesc();
            return;
        }
        this.plugindescDirtyFlag = false;
        this.plugindesc = null;
    }

    public void setPluginDescUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPluginDescUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.plugindescurl = string;
        this.plugindescurlDirtyFlag = true;
    }

    public String getPluginDescUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPluginDescUrl();
        }
        return this.plugindescurl;
    }

    public boolean isPluginDescUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPluginDescUrlDirty();
        }
        return this.plugindescurlDirtyFlag;
    }

    public void resetPluginDescUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPluginDescUrl();
            return;
        }
        this.plugindescurlDirtyFlag = false;
        this.plugindescurl = null;
    }

    public void setPluginIconUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPluginIconUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pluginiconurl = string;
        this.pluginiconurlDirtyFlag = true;
    }

    public String getPluginIconUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPluginIconUrl();
        }
        return this.pluginiconurl;
    }

    public boolean isPluginIconUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPluginIconUrlDirty();
        }
        return this.pluginiconurlDirtyFlag;
    }

    public void resetPluginIconUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPluginIconUrl();
            return;
        }
        this.pluginiconurlDirtyFlag = false;
        this.pluginiconurl = null;
    }

    public void setPluginObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPluginObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pluginobj = string;
        this.pluginobjDirtyFlag = true;
    }

    public String getPluginObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPluginObj();
        }
        return this.pluginobj;
    }

    public boolean isPluginObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPluginObjDirty();
        }
        return this.pluginobjDirtyFlag;
    }

    public void resetPluginObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPluginObj();
            return;
        }
        this.pluginobjDirtyFlag = false;
        this.pluginobj = null;
    }

    public void setPluginUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPluginUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pluginurl = string;
        this.pluginurlDirtyFlag = true;
    }

    public String getPluginUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPluginUrl();
        }
        return this.pluginurl;
    }

    public boolean isPluginUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPluginUrlDirty();
        }
        return this.pluginurlDirtyFlag;
    }

    public void resetPluginUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPluginUrl();
            return;
        }
        this.pluginurlDirtyFlag = false;
        this.pluginurl = null;
    }

    public void setPluginUrl2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPluginUrl2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pluginurl2 = string;
        this.pluginurl2DirtyFlag = true;
    }

    public String getPluginUrl2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPluginUrl2();
        }
        return this.pluginurl2;
    }

    public boolean isPluginUrl2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPluginUrl2Dirty();
        }
        return this.pluginurl2DirtyFlag;
    }

    public void resetPluginUrl2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPluginUrl2();
            return;
        }
        this.pluginurl2DirtyFlag = false;
        this.pluginurl2 = null;
    }

    public void setPSDevCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterid = string;
        this.psdevcenteridDirtyFlag = true;
    }

    public String getPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterId();
        }
        return this.psdevcenterid;
    }

    public boolean isPSDevCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterIdDirty();
        }
        return this.psdevcenteridDirtyFlag;
    }

    public void resetPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterId();
            return;
        }
        this.psdevcenteridDirtyFlag = false;
        this.psdevcenterid = null;
    }

    public void setPSDevCenterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentername = string;
        this.psdevcenternameDirtyFlag = true;
    }

    public String getPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterName();
        }
        return this.psdevcentername;
    }

    public boolean isPSDevCenterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterNameDirty();
        }
        return this.psdevcenternameDirtyFlag;
    }

    public void resetPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterName();
            return;
        }
        this.psdevcenternameDirtyFlag = false;
        this.psdevcentername = null;
    }

    public void setPSObjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjtype = string;
        this.psobjtypeDirtyFlag = true;
    }

    public String getPSObjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjType();
        }
        return this.psobjtype;
    }

    public boolean isPSObjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjTypeDirty();
        }
        return this.psobjtypeDirtyFlag;
    }

    public void resetPSObjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjType();
            return;
        }
        this.psobjtypeDirtyFlag = false;
        this.psobjtype = null;
    }

    public void setPSObjTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjtypename = string;
        this.psobjtypenameDirtyFlag = true;
    }

    public String getPSObjTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjTypeName();
        }
        return this.psobjtypename;
    }

    public boolean isPSObjTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjTypeNameDirty();
        }
        return this.psobjtypenameDirtyFlag;
    }

    public void resetPSObjTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjTypeName();
            return;
        }
        this.psobjtypenameDirtyFlag = false;
        this.psobjtypename = null;
    }

    public void setPSStudioPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSStudioPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psstudiopluginid = string;
        this.psstudiopluginidDirtyFlag = true;
    }

    public String getPSStudioPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSStudioPluginId();
        }
        return this.psstudiopluginid;
    }

    public boolean isPSStudioPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSStudioPluginIdDirty();
        }
        return this.psstudiopluginidDirtyFlag;
    }

    public void resetPSStudioPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSStudioPluginId();
            return;
        }
        this.psstudiopluginidDirtyFlag = false;
        this.psstudiopluginid = null;
    }

    public void setPSStudioPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSStudioPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psstudiopluginname = string;
        this.psstudiopluginnameDirtyFlag = true;
    }

    public String getPSStudioPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSStudioPluginName();
        }
        return this.psstudiopluginname;
    }

    public boolean isPSStudioPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSStudioPluginNameDirty();
        }
        return this.psstudiopluginnameDirtyFlag;
    }

    public void resetPSStudioPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSStudioPluginName();
            return;
        }
        this.psstudiopluginnameDirtyFlag = false;
        this.psstudiopluginname = null;
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

    protected void onReset() {
        PSStudioPluginBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSStudioPluginBase pSStudioPluginBase) {
        pSStudioPluginBase.resetAllDCFlag();
        pSStudioPluginBase.resetCreateDate();
        pSStudioPluginBase.resetCreateMan();
        pSStudioPluginBase.resetCustomCode();
        pSStudioPluginBase.resetKeywords();
        pSStudioPluginBase.resetMemo();
        pSStudioPluginBase.resetOrderValue();
        pSStudioPluginBase.resetPluginCat();
        pSStudioPluginBase.resetPluginData();
        pSStudioPluginBase.resetPluginData2();
        pSStudioPluginBase.resetPluginDesc();
        pSStudioPluginBase.resetPluginDescUrl();
        pSStudioPluginBase.resetPluginIconUrl();
        pSStudioPluginBase.resetPluginObj();
        pSStudioPluginBase.resetPluginUrl();
        pSStudioPluginBase.resetPluginUrl2();
        pSStudioPluginBase.resetPSDevCenterId();
        pSStudioPluginBase.resetPSDevCenterName();
        pSStudioPluginBase.resetPSObjType();
        pSStudioPluginBase.resetPSObjTypeName();
        pSStudioPluginBase.resetPSStudioPluginId();
        pSStudioPluginBase.resetPSStudioPluginName();
        pSStudioPluginBase.resetUpdateDate();
        pSStudioPluginBase.resetUpdateMan();
        pSStudioPluginBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAllDCFlagDirty()) {
            hashMap.put(FIELD_ALLDCFLAG, this.getAllDCFlag());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCustomCodeDirty()) {
            hashMap.put(FIELD_CUSTOMCODE, this.getCustomCode());
        }
        if (!bl || this.isKeywordsDirty()) {
            hashMap.put(FIELD_KEYWORDS, this.getKeywords());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPluginCatDirty()) {
            hashMap.put(FIELD_PLUGINCAT, this.getPluginCat());
        }
        if (!bl || this.isPluginDataDirty()) {
            hashMap.put(FIELD_PLUGINDATA, this.getPluginData());
        }
        if (!bl || this.isPluginData2Dirty()) {
            hashMap.put(FIELD_PLUGINDATA2, this.getPluginData2());
        }
        if (!bl || this.isPluginDescDirty()) {
            hashMap.put(FIELD_PLUGINDESC, this.getPluginDesc());
        }
        if (!bl || this.isPluginDescUrlDirty()) {
            hashMap.put(FIELD_PLUGINDESCURL, this.getPluginDescUrl());
        }
        if (!bl || this.isPluginIconUrlDirty()) {
            hashMap.put(FIELD_PLUGINICONURL, this.getPluginIconUrl());
        }
        if (!bl || this.isPluginObjDirty()) {
            hashMap.put(FIELD_PLUGINOBJ, this.getPluginObj());
        }
        if (!bl || this.isPluginUrlDirty()) {
            hashMap.put(FIELD_PLUGINURL, this.getPluginUrl());
        }
        if (!bl || this.isPluginUrl2Dirty()) {
            hashMap.put(FIELD_PLUGINURL2, this.getPluginUrl2());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSObjTypeDirty()) {
            hashMap.put(FIELD_PSOBJTYPE, this.getPSObjType());
        }
        if (!bl || this.isPSObjTypeNameDirty()) {
            hashMap.put(FIELD_PSOBJTYPENAME, this.getPSObjTypeName());
        }
        if (!bl || this.isPSStudioPluginIdDirty()) {
            hashMap.put(FIELD_PSSTUDIOPLUGINID, this.getPSStudioPluginId());
        }
        if (!bl || this.isPSStudioPluginNameDirty()) {
            hashMap.put(FIELD_PSSTUDIOPLUGINNAME, this.getPSStudioPluginName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
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
        return PSStudioPluginBase.get(this, n);
    }

    private static Object get(PSStudioPluginBase pSStudioPluginBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSStudioPluginBase.getAllDCFlag();
            }
            case 1: {
                return pSStudioPluginBase.getCreateDate();
            }
            case 2: {
                return pSStudioPluginBase.getCreateMan();
            }
            case 3: {
                return pSStudioPluginBase.getCustomCode();
            }
            case 4: {
                return pSStudioPluginBase.getKeywords();
            }
            case 5: {
                return pSStudioPluginBase.getMemo();
            }
            case 6: {
                return pSStudioPluginBase.getOrderValue();
            }
            case 7: {
                return pSStudioPluginBase.getPluginCat();
            }
            case 8: {
                return pSStudioPluginBase.getPluginData();
            }
            case 9: {
                return pSStudioPluginBase.getPluginData2();
            }
            case 10: {
                return pSStudioPluginBase.getPluginDesc();
            }
            case 11: {
                return pSStudioPluginBase.getPluginDescUrl();
            }
            case 12: {
                return pSStudioPluginBase.getPluginIconUrl();
            }
            case 13: {
                return pSStudioPluginBase.getPluginObj();
            }
            case 14: {
                return pSStudioPluginBase.getPluginUrl();
            }
            case 15: {
                return pSStudioPluginBase.getPluginUrl2();
            }
            case 16: {
                return pSStudioPluginBase.getPSDevCenterId();
            }
            case 17: {
                return pSStudioPluginBase.getPSDevCenterName();
            }
            case 18: {
                return pSStudioPluginBase.getPSObjType();
            }
            case 19: {
                return pSStudioPluginBase.getPSObjTypeName();
            }
            case 20: {
                return pSStudioPluginBase.getPSStudioPluginId();
            }
            case 21: {
                return pSStudioPluginBase.getPSStudioPluginName();
            }
            case 22: {
                return pSStudioPluginBase.getUpdateDate();
            }
            case 23: {
                return pSStudioPluginBase.getUpdateMan();
            }
            case 24: {
                return pSStudioPluginBase.getValidFlag();
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
        PSStudioPluginBase.set(this, n, object);
    }

    private static void set(PSStudioPluginBase pSStudioPluginBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSStudioPluginBase.setAllDCFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSStudioPluginBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSStudioPluginBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSStudioPluginBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSStudioPluginBase.setKeywords(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSStudioPluginBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSStudioPluginBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSStudioPluginBase.setPluginCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSStudioPluginBase.setPluginData(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSStudioPluginBase.setPluginData2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSStudioPluginBase.setPluginDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSStudioPluginBase.setPluginDescUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSStudioPluginBase.setPluginIconUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSStudioPluginBase.setPluginObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSStudioPluginBase.setPluginUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSStudioPluginBase.setPluginUrl2(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSStudioPluginBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSStudioPluginBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSStudioPluginBase.setPSObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSStudioPluginBase.setPSObjTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSStudioPluginBase.setPSStudioPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSStudioPluginBase.setPSStudioPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSStudioPluginBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 23: {
                pSStudioPluginBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSStudioPluginBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSStudioPluginBase.isNull(this, n);
    }

    private static boolean isNull(PSStudioPluginBase pSStudioPluginBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSStudioPluginBase.getAllDCFlag() == null;
            }
            case 1: {
                return pSStudioPluginBase.getCreateDate() == null;
            }
            case 2: {
                return pSStudioPluginBase.getCreateMan() == null;
            }
            case 3: {
                return pSStudioPluginBase.getCustomCode() == null;
            }
            case 4: {
                return pSStudioPluginBase.getKeywords() == null;
            }
            case 5: {
                return pSStudioPluginBase.getMemo() == null;
            }
            case 6: {
                return pSStudioPluginBase.getOrderValue() == null;
            }
            case 7: {
                return pSStudioPluginBase.getPluginCat() == null;
            }
            case 8: {
                return pSStudioPluginBase.getPluginData() == null;
            }
            case 9: {
                return pSStudioPluginBase.getPluginData2() == null;
            }
            case 10: {
                return pSStudioPluginBase.getPluginDesc() == null;
            }
            case 11: {
                return pSStudioPluginBase.getPluginDescUrl() == null;
            }
            case 12: {
                return pSStudioPluginBase.getPluginIconUrl() == null;
            }
            case 13: {
                return pSStudioPluginBase.getPluginObj() == null;
            }
            case 14: {
                return pSStudioPluginBase.getPluginUrl() == null;
            }
            case 15: {
                return pSStudioPluginBase.getPluginUrl2() == null;
            }
            case 16: {
                return pSStudioPluginBase.getPSDevCenterId() == null;
            }
            case 17: {
                return pSStudioPluginBase.getPSDevCenterName() == null;
            }
            case 18: {
                return pSStudioPluginBase.getPSObjType() == null;
            }
            case 19: {
                return pSStudioPluginBase.getPSObjTypeName() == null;
            }
            case 20: {
                return pSStudioPluginBase.getPSStudioPluginId() == null;
            }
            case 21: {
                return pSStudioPluginBase.getPSStudioPluginName() == null;
            }
            case 22: {
                return pSStudioPluginBase.getUpdateDate() == null;
            }
            case 23: {
                return pSStudioPluginBase.getUpdateMan() == null;
            }
            case 24: {
                return pSStudioPluginBase.getValidFlag() == null;
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
        return PSStudioPluginBase.contains(this, n);
    }

    private static boolean contains(PSStudioPluginBase pSStudioPluginBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSStudioPluginBase.isAllDCFlagDirty();
            }
            case 1: {
                return pSStudioPluginBase.isCreateDateDirty();
            }
            case 2: {
                return pSStudioPluginBase.isCreateManDirty();
            }
            case 3: {
                return pSStudioPluginBase.isCustomCodeDirty();
            }
            case 4: {
                return pSStudioPluginBase.isKeywordsDirty();
            }
            case 5: {
                return pSStudioPluginBase.isMemoDirty();
            }
            case 6: {
                return pSStudioPluginBase.isOrderValueDirty();
            }
            case 7: {
                return pSStudioPluginBase.isPluginCatDirty();
            }
            case 8: {
                return pSStudioPluginBase.isPluginDataDirty();
            }
            case 9: {
                return pSStudioPluginBase.isPluginData2Dirty();
            }
            case 10: {
                return pSStudioPluginBase.isPluginDescDirty();
            }
            case 11: {
                return pSStudioPluginBase.isPluginDescUrlDirty();
            }
            case 12: {
                return pSStudioPluginBase.isPluginIconUrlDirty();
            }
            case 13: {
                return pSStudioPluginBase.isPluginObjDirty();
            }
            case 14: {
                return pSStudioPluginBase.isPluginUrlDirty();
            }
            case 15: {
                return pSStudioPluginBase.isPluginUrl2Dirty();
            }
            case 16: {
                return pSStudioPluginBase.isPSDevCenterIdDirty();
            }
            case 17: {
                return pSStudioPluginBase.isPSDevCenterNameDirty();
            }
            case 18: {
                return pSStudioPluginBase.isPSObjTypeDirty();
            }
            case 19: {
                return pSStudioPluginBase.isPSObjTypeNameDirty();
            }
            case 20: {
                return pSStudioPluginBase.isPSStudioPluginIdDirty();
            }
            case 21: {
                return pSStudioPluginBase.isPSStudioPluginNameDirty();
            }
            case 22: {
                return pSStudioPluginBase.isUpdateDateDirty();
            }
            case 23: {
                return pSStudioPluginBase.isUpdateManDirty();
            }
            case 24: {
                return pSStudioPluginBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSStudioPluginBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSStudioPluginBase pSStudioPluginBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSStudioPluginBase.getAllDCFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"alldcflag", (Object)PSStudioPluginBase.getJSONValue((Object)pSStudioPluginBase.getAllDCFlag()), (boolean)false);
        }
        if (bl || pSStudioPluginBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSStudioPluginBase.getJSONValue((Object)pSStudioPluginBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSStudioPluginBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSStudioPluginBase.getJSONValue((Object)pSStudioPluginBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSStudioPluginBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSStudioPluginBase.getJSONValue((Object)pSStudioPluginBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSStudioPluginBase.getKeywords() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"keywords", (Object)PSStudioPluginBase.getJSONValue((Object)pSStudioPluginBase.getKeywords()), (boolean)false);
        }
        if (bl || pSStudioPluginBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSStudioPluginBase.getJSONValue((Object)pSStudioPluginBase.getMemo()), (boolean)false);
        }
        if (bl || pSStudioPluginBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSStudioPluginBase.getJSONValue((Object)pSStudioPluginBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSStudioPluginBase.getPluginCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"plugincat", (Object)PSStudioPluginBase.getJSONValue((Object)pSStudioPluginBase.getPluginCat()), (boolean)false);
        }
        if (bl || pSStudioPluginBase.getPluginData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"plugindata", (Object)PSStudioPluginBase.getJSONValue((Object)pSStudioPluginBase.getPluginData()), (boolean)false);
        }
        if (bl || pSStudioPluginBase.getPluginData2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"plugindata2", (Object)PSStudioPluginBase.getJSONValue((Object)pSStudioPluginBase.getPluginData2()), (boolean)false);
        }
        if (bl || pSStudioPluginBase.getPluginDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"plugindesc", (Object)PSStudioPluginBase.getJSONValue((Object)pSStudioPluginBase.getPluginDesc()), (boolean)false);
        }
        if (bl || pSStudioPluginBase.getPluginDescUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"plugindescurl", (Object)PSStudioPluginBase.getJSONValue((Object)pSStudioPluginBase.getPluginDescUrl()), (boolean)false);
        }
        if (bl || pSStudioPluginBase.getPluginIconUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pluginiconurl", (Object)PSStudioPluginBase.getJSONValue((Object)pSStudioPluginBase.getPluginIconUrl()), (boolean)false);
        }
        if (bl || pSStudioPluginBase.getPluginObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pluginobj", (Object)PSStudioPluginBase.getJSONValue((Object)pSStudioPluginBase.getPluginObj()), (boolean)false);
        }
        if (bl || pSStudioPluginBase.getPluginUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pluginurl", (Object)PSStudioPluginBase.getJSONValue((Object)pSStudioPluginBase.getPluginUrl()), (boolean)false);
        }
        if (bl || pSStudioPluginBase.getPluginUrl2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pluginurl2", (Object)PSStudioPluginBase.getJSONValue((Object)pSStudioPluginBase.getPluginUrl2()), (boolean)false);
        }
        if (bl || pSStudioPluginBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSStudioPluginBase.getJSONValue((Object)pSStudioPluginBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSStudioPluginBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSStudioPluginBase.getJSONValue((Object)pSStudioPluginBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSStudioPluginBase.getPSObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjtype", (Object)PSStudioPluginBase.getJSONValue((Object)pSStudioPluginBase.getPSObjType()), (boolean)false);
        }
        if (bl || pSStudioPluginBase.getPSObjTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjtypename", (Object)PSStudioPluginBase.getJSONValue((Object)pSStudioPluginBase.getPSObjTypeName()), (boolean)false);
        }
        if (bl || pSStudioPluginBase.getPSStudioPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psstudiopluginid", (Object)PSStudioPluginBase.getJSONValue((Object)pSStudioPluginBase.getPSStudioPluginId()), (boolean)false);
        }
        if (bl || pSStudioPluginBase.getPSStudioPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psstudiopluginname", (Object)PSStudioPluginBase.getJSONValue((Object)pSStudioPluginBase.getPSStudioPluginName()), (boolean)false);
        }
        if (bl || pSStudioPluginBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSStudioPluginBase.getJSONValue((Object)pSStudioPluginBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSStudioPluginBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSStudioPluginBase.getJSONValue((Object)pSStudioPluginBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSStudioPluginBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSStudioPluginBase.getJSONValue((Object)pSStudioPluginBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSStudioPluginBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSStudioPluginBase pSStudioPluginBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSStudioPluginBase.getAllDCFlag() != null) {
            object = pSStudioPluginBase.getAllDCFlag();
            xmlNode.setAttribute(FIELD_ALLDCFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSStudioPluginBase.getCreateDate() != null) {
            object = pSStudioPluginBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSStudioPluginBase.getCreateMan() != null) {
            object = pSStudioPluginBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginBase.getCustomCode() != null) {
            object = pSStudioPluginBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginBase.getKeywords() != null) {
            object = pSStudioPluginBase.getKeywords();
            xmlNode.setAttribute(FIELD_KEYWORDS, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginBase.getMemo() != null) {
            object = pSStudioPluginBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginBase.getOrderValue() != null) {
            object = pSStudioPluginBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSStudioPluginBase.getPluginCat() != null) {
            object = pSStudioPluginBase.getPluginCat();
            xmlNode.setAttribute(FIELD_PLUGINCAT, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginBase.getPluginData() != null) {
            object = pSStudioPluginBase.getPluginData();
            xmlNode.setAttribute(FIELD_PLUGINDATA, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginBase.getPluginData2() != null) {
            object = pSStudioPluginBase.getPluginData2();
            xmlNode.setAttribute(FIELD_PLUGINDATA2, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginBase.getPluginDesc() != null) {
            object = pSStudioPluginBase.getPluginDesc();
            xmlNode.setAttribute(FIELD_PLUGINDESC, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginBase.getPluginDescUrl() != null) {
            object = pSStudioPluginBase.getPluginDescUrl();
            xmlNode.setAttribute(FIELD_PLUGINDESCURL, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginBase.getPluginIconUrl() != null) {
            object = pSStudioPluginBase.getPluginIconUrl();
            xmlNode.setAttribute(FIELD_PLUGINICONURL, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginBase.getPluginObj() != null) {
            object = pSStudioPluginBase.getPluginObj();
            xmlNode.setAttribute(FIELD_PLUGINOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginBase.getPluginUrl() != null) {
            object = pSStudioPluginBase.getPluginUrl();
            xmlNode.setAttribute(FIELD_PLUGINURL, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginBase.getPluginUrl2() != null) {
            object = pSStudioPluginBase.getPluginUrl2();
            xmlNode.setAttribute(FIELD_PLUGINURL2, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginBase.getPSDevCenterId() != null) {
            object = pSStudioPluginBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginBase.getPSDevCenterName() != null) {
            object = pSStudioPluginBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginBase.getPSObjType() != null) {
            object = pSStudioPluginBase.getPSObjType();
            xmlNode.setAttribute(FIELD_PSOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginBase.getPSObjTypeName() != null) {
            object = pSStudioPluginBase.getPSObjTypeName();
            xmlNode.setAttribute(FIELD_PSOBJTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginBase.getPSStudioPluginId() != null) {
            object = pSStudioPluginBase.getPSStudioPluginId();
            xmlNode.setAttribute(FIELD_PSSTUDIOPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginBase.getPSStudioPluginName() != null) {
            object = pSStudioPluginBase.getPSStudioPluginName();
            xmlNode.setAttribute(FIELD_PSSTUDIOPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginBase.getUpdateDate() != null) {
            object = pSStudioPluginBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSStudioPluginBase.getUpdateMan() != null) {
            object = pSStudioPluginBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSStudioPluginBase.getValidFlag() != null) {
            object = pSStudioPluginBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSStudioPluginBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSStudioPluginBase pSStudioPluginBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSStudioPluginBase.isAllDCFlagDirty() && (bl || pSStudioPluginBase.getAllDCFlag() != null)) {
            iDataObject.set(FIELD_ALLDCFLAG, (Object)pSStudioPluginBase.getAllDCFlag());
        }
        if (pSStudioPluginBase.isCreateDateDirty() && (bl || pSStudioPluginBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSStudioPluginBase.getCreateDate());
        }
        if (pSStudioPluginBase.isCreateManDirty() && (bl || pSStudioPluginBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSStudioPluginBase.getCreateMan());
        }
        if (pSStudioPluginBase.isCustomCodeDirty() && (bl || pSStudioPluginBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSStudioPluginBase.getCustomCode());
        }
        if (pSStudioPluginBase.isKeywordsDirty() && (bl || pSStudioPluginBase.getKeywords() != null)) {
            iDataObject.set(FIELD_KEYWORDS, (Object)pSStudioPluginBase.getKeywords());
        }
        if (pSStudioPluginBase.isMemoDirty() && (bl || pSStudioPluginBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSStudioPluginBase.getMemo());
        }
        if (pSStudioPluginBase.isOrderValueDirty() && (bl || pSStudioPluginBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSStudioPluginBase.getOrderValue());
        }
        if (pSStudioPluginBase.isPluginCatDirty() && (bl || pSStudioPluginBase.getPluginCat() != null)) {
            iDataObject.set(FIELD_PLUGINCAT, (Object)pSStudioPluginBase.getPluginCat());
        }
        if (pSStudioPluginBase.isPluginDataDirty() && (bl || pSStudioPluginBase.getPluginData() != null)) {
            iDataObject.set(FIELD_PLUGINDATA, (Object)pSStudioPluginBase.getPluginData());
        }
        if (pSStudioPluginBase.isPluginData2Dirty() && (bl || pSStudioPluginBase.getPluginData2() != null)) {
            iDataObject.set(FIELD_PLUGINDATA2, (Object)pSStudioPluginBase.getPluginData2());
        }
        if (pSStudioPluginBase.isPluginDescDirty() && (bl || pSStudioPluginBase.getPluginDesc() != null)) {
            iDataObject.set(FIELD_PLUGINDESC, (Object)pSStudioPluginBase.getPluginDesc());
        }
        if (pSStudioPluginBase.isPluginDescUrlDirty() && (bl || pSStudioPluginBase.getPluginDescUrl() != null)) {
            iDataObject.set(FIELD_PLUGINDESCURL, (Object)pSStudioPluginBase.getPluginDescUrl());
        }
        if (pSStudioPluginBase.isPluginIconUrlDirty() && (bl || pSStudioPluginBase.getPluginIconUrl() != null)) {
            iDataObject.set(FIELD_PLUGINICONURL, (Object)pSStudioPluginBase.getPluginIconUrl());
        }
        if (pSStudioPluginBase.isPluginObjDirty() && (bl || pSStudioPluginBase.getPluginObj() != null)) {
            iDataObject.set(FIELD_PLUGINOBJ, (Object)pSStudioPluginBase.getPluginObj());
        }
        if (pSStudioPluginBase.isPluginUrlDirty() && (bl || pSStudioPluginBase.getPluginUrl() != null)) {
            iDataObject.set(FIELD_PLUGINURL, (Object)pSStudioPluginBase.getPluginUrl());
        }
        if (pSStudioPluginBase.isPluginUrl2Dirty() && (bl || pSStudioPluginBase.getPluginUrl2() != null)) {
            iDataObject.set(FIELD_PLUGINURL2, (Object)pSStudioPluginBase.getPluginUrl2());
        }
        if (pSStudioPluginBase.isPSDevCenterIdDirty() && (bl || pSStudioPluginBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSStudioPluginBase.getPSDevCenterId());
        }
        if (pSStudioPluginBase.isPSDevCenterNameDirty() && (bl || pSStudioPluginBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSStudioPluginBase.getPSDevCenterName());
        }
        if (pSStudioPluginBase.isPSObjTypeDirty() && (bl || pSStudioPluginBase.getPSObjType() != null)) {
            iDataObject.set(FIELD_PSOBJTYPE, (Object)pSStudioPluginBase.getPSObjType());
        }
        if (pSStudioPluginBase.isPSObjTypeNameDirty() && (bl || pSStudioPluginBase.getPSObjTypeName() != null)) {
            iDataObject.set(FIELD_PSOBJTYPENAME, (Object)pSStudioPluginBase.getPSObjTypeName());
        }
        if (pSStudioPluginBase.isPSStudioPluginIdDirty() && (bl || pSStudioPluginBase.getPSStudioPluginId() != null)) {
            iDataObject.set(FIELD_PSSTUDIOPLUGINID, (Object)pSStudioPluginBase.getPSStudioPluginId());
        }
        if (pSStudioPluginBase.isPSStudioPluginNameDirty() && (bl || pSStudioPluginBase.getPSStudioPluginName() != null)) {
            iDataObject.set(FIELD_PSSTUDIOPLUGINNAME, (Object)pSStudioPluginBase.getPSStudioPluginName());
        }
        if (pSStudioPluginBase.isUpdateDateDirty() && (bl || pSStudioPluginBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSStudioPluginBase.getUpdateDate());
        }
        if (pSStudioPluginBase.isUpdateManDirty() && (bl || pSStudioPluginBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSStudioPluginBase.getUpdateMan());
        }
        if (pSStudioPluginBase.isValidFlagDirty() && (bl || pSStudioPluginBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSStudioPluginBase.getValidFlag());
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
        return PSStudioPluginBase.remove(this, n);
    }

    private static boolean remove(PSStudioPluginBase pSStudioPluginBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSStudioPluginBase.resetAllDCFlag();
                return true;
            }
            case 1: {
                pSStudioPluginBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSStudioPluginBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSStudioPluginBase.resetCustomCode();
                return true;
            }
            case 4: {
                pSStudioPluginBase.resetKeywords();
                return true;
            }
            case 5: {
                pSStudioPluginBase.resetMemo();
                return true;
            }
            case 6: {
                pSStudioPluginBase.resetOrderValue();
                return true;
            }
            case 7: {
                pSStudioPluginBase.resetPluginCat();
                return true;
            }
            case 8: {
                pSStudioPluginBase.resetPluginData();
                return true;
            }
            case 9: {
                pSStudioPluginBase.resetPluginData2();
                return true;
            }
            case 10: {
                pSStudioPluginBase.resetPluginDesc();
                return true;
            }
            case 11: {
                pSStudioPluginBase.resetPluginDescUrl();
                return true;
            }
            case 12: {
                pSStudioPluginBase.resetPluginIconUrl();
                return true;
            }
            case 13: {
                pSStudioPluginBase.resetPluginObj();
                return true;
            }
            case 14: {
                pSStudioPluginBase.resetPluginUrl();
                return true;
            }
            case 15: {
                pSStudioPluginBase.resetPluginUrl2();
                return true;
            }
            case 16: {
                pSStudioPluginBase.resetPSDevCenterId();
                return true;
            }
            case 17: {
                pSStudioPluginBase.resetPSDevCenterName();
                return true;
            }
            case 18: {
                pSStudioPluginBase.resetPSObjType();
                return true;
            }
            case 19: {
                pSStudioPluginBase.resetPSObjTypeName();
                return true;
            }
            case 20: {
                pSStudioPluginBase.resetPSStudioPluginId();
                return true;
            }
            case 21: {
                pSStudioPluginBase.resetPSStudioPluginName();
                return true;
            }
            case 22: {
                pSStudioPluginBase.resetUpdateDate();
                return true;
            }
            case 23: {
                pSStudioPluginBase.resetUpdateMan();
                return true;
            }
            case 24: {
                pSStudioPluginBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getPSDevCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenter();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterLock;
        synchronized (n) {
            if (this.psdevcenter != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterId(), (Object)this.psdevcenter.getPSDevCenterId()) != 0L) {
                this.psdevcenter = null;
            }
            if (this.psdevcenter == null) {
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(this.getPSDevCenterId());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterService.autoGet(pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    private PSStudioPluginBase getProxyEntity() {
        return this.proxyPSStudioPluginBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSStudioPluginBase = null;
        if (iDataObject != null && iDataObject instanceof PSStudioPluginBase) {
            this.proxyPSStudioPluginBase = (PSStudioPluginBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSStudioPluginService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLDCFLAG, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 3);
        fieldIndexMap.put(FIELD_KEYWORDS, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_ORDERVALUE, 6);
        fieldIndexMap.put(FIELD_PLUGINCAT, 7);
        fieldIndexMap.put(FIELD_PLUGINDATA, 8);
        fieldIndexMap.put(FIELD_PLUGINDATA2, 9);
        fieldIndexMap.put(FIELD_PLUGINDESC, 10);
        fieldIndexMap.put(FIELD_PLUGINDESCURL, 11);
        fieldIndexMap.put(FIELD_PLUGINICONURL, 12);
        fieldIndexMap.put(FIELD_PLUGINOBJ, 13);
        fieldIndexMap.put(FIELD_PLUGINURL, 14);
        fieldIndexMap.put(FIELD_PLUGINURL2, 15);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 16);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 17);
        fieldIndexMap.put(FIELD_PSOBJTYPE, 18);
        fieldIndexMap.put(FIELD_PSOBJTYPENAME, 19);
        fieldIndexMap.put(FIELD_PSSTUDIOPLUGINID, 20);
        fieldIndexMap.put(FIELD_PSSTUDIOPLUGINNAME, 21);
        fieldIndexMap.put(FIELD_UPDATEDATE, 22);
        fieldIndexMap.put(FIELD_UPDATEMAN, 23);
        fieldIndexMap.put(FIELD_VALIDFLAG, 24);
    }
}

