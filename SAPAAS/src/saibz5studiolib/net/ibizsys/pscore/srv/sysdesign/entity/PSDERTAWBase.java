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
import java.util.ArrayList;
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
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDERTAWI;
import net.ibizsys.pscore.srv.sysdesign.service.PSDERTAWIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDERTAWService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDERTAWBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDERTAWBase.class);
    public static final String FIELD_ALLDCFLAG = "ALLDCFLAG";
    public static final String FIELD_AWINPUTMODE = "AWINPUTMODE";
    public static final String FIELD_AWITEMS = "AWITEMS";
    public static final String FIELD_AWPATH = "AWPATH";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_KEYWORDS = "KEYWORDS";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDERTAWID = "PSDERTAWID";
    public static final String FIELD_PSDERTAWNAME = "PSDERTAWNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_SRFFORMMODE = "SRFFORMMODE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_URL = "URL";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ALLDCFLAG = 0;
    private static final int INDEX_AWINPUTMODE = 1;
    private static final int INDEX_AWITEMS = 2;
    private static final int INDEX_AWPATH = 3;
    private static final int INDEX_CREATEDATE = 4;
    private static final int INDEX_CREATEMAN = 5;
    private static final int INDEX_KEYWORDS = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_ORDERVALUE = 8;
    private static final int INDEX_PSDEID = 9;
    private static final int INDEX_PSDENAME = 10;
    private static final int INDEX_PSDERTAWID = 11;
    private static final int INDEX_PSDERTAWNAME = 12;
    private static final int INDEX_PSDEVCENTERID = 13;
    private static final int INDEX_PSDEVCENTERNAME = 14;
    private static final int INDEX_SRFFORMMODE = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final int INDEX_URL = 18;
    private static final int INDEX_USERTAG = 19;
    private static final int INDEX_USERTAG2 = 20;
    private static final int INDEX_VALIDFLAG = 21;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDERTAWBase proxyPSDERTAWBase = null;
    private boolean alldcflagDirtyFlag = false;
    private boolean awinputmodeDirtyFlag = false;
    private boolean awitemsDirtyFlag = false;
    private boolean awpathDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean keywordsDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdertawidDirtyFlag = false;
    private boolean psdertawnameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean srfformmodeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean urlDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="alldcflag")
    private Integer alldcflag;
    @Column(name="awinputmode")
    private Integer awinputmode;
    @Column(name="awitems")
    private String awitems;
    @Column(name="awpath")
    private String awpath;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="keywords")
    private String keywords;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdertawid")
    private String psdertawid;
    @Column(name="psdertawname")
    private String psdertawname;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="srfformmode")
    private String srfformmode;
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
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSDERTAWIsLock = new Integer(1);
    private ArrayList<PSDERTAWI> psdertawis = null;

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

    public void setAWInputMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAWInputMode(n);
            return;
        }
        this.awinputmode = n;
        this.awinputmodeDirtyFlag = true;
    }

    public Integer getAWInputMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWInputMode();
        }
        return this.awinputmode;
    }

    public boolean isAWInputModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAWInputModeDirty();
        }
        return this.awinputmodeDirtyFlag;
    }

    public void resetAWInputMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAWInputMode();
            return;
        }
        this.awinputmodeDirtyFlag = false;
        this.awinputmode = null;
    }

    public void setAWItems(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAWItems(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.awitems = string;
        this.awitemsDirtyFlag = true;
    }

    public String getAWItems() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWItems();
        }
        return this.awitems;
    }

    public boolean isAWItemsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAWItemsDirty();
        }
        return this.awitemsDirtyFlag;
    }

    public void resetAWItems() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAWItems();
            return;
        }
        this.awitemsDirtyFlag = false;
        this.awitems = null;
    }

    public void setAWPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAWPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.awpath = string;
        this.awpathDirtyFlag = true;
    }

    public String getAWPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAWPath();
        }
        return this.awpath;
    }

    public boolean isAWPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAWPathDirty();
        }
        return this.awpathDirtyFlag;
    }

    public void resetAWPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAWPath();
            return;
        }
        this.awpathDirtyFlag = false;
        this.awpath = null;
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

    public void setPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeid = string;
        this.psdeidDirtyFlag = true;
    }

    public String getPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEId();
        }
        return this.psdeid;
    }

    public boolean isPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEIdDirty();
        }
        return this.psdeidDirtyFlag;
    }

    public void resetPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEId();
            return;
        }
        this.psdeidDirtyFlag = false;
        this.psdeid = null;
    }

    public void setPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdename = string;
        this.psdenameDirtyFlag = true;
    }

    public String getPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEName();
        }
        return this.psdename;
    }

    public boolean isPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDENameDirty();
        }
        return this.psdenameDirtyFlag;
    }

    public void resetPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEName();
            return;
        }
        this.psdenameDirtyFlag = false;
        this.psdename = null;
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

    public void setSRFFormMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSRFFormMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srfformmode = string;
        this.srfformmodeDirtyFlag = true;
    }

    public String getSRFFormMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSRFFormMode();
        }
        return this.srfformmode;
    }

    public boolean isSRFFormModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSRFFormModeDirty();
        }
        return this.srfformmodeDirtyFlag;
    }

    public void resetSRFFormMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSRFFormMode();
            return;
        }
        this.srfformmodeDirtyFlag = false;
        this.srfformmode = null;
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

    protected void onReset() {
        PSDERTAWBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDERTAWBase pSDERTAWBase) {
        pSDERTAWBase.resetAllDCFlag();
        pSDERTAWBase.resetAWInputMode();
        pSDERTAWBase.resetAWItems();
        pSDERTAWBase.resetAWPath();
        pSDERTAWBase.resetCreateDate();
        pSDERTAWBase.resetCreateMan();
        pSDERTAWBase.resetKeywords();
        pSDERTAWBase.resetMemo();
        pSDERTAWBase.resetOrderValue();
        pSDERTAWBase.resetPSDEId();
        pSDERTAWBase.resetPSDEName();
        pSDERTAWBase.resetPSDERTAWId();
        pSDERTAWBase.resetPSDERTAWName();
        pSDERTAWBase.resetPSDevCenterId();
        pSDERTAWBase.resetPSDevCenterName();
        pSDERTAWBase.resetSRFFormMode();
        pSDERTAWBase.resetUpdateDate();
        pSDERTAWBase.resetUpdateMan();
        pSDERTAWBase.resetUrl();
        pSDERTAWBase.resetUserTag();
        pSDERTAWBase.resetUserTag2();
        pSDERTAWBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAllDCFlagDirty()) {
            hashMap.put(FIELD_ALLDCFLAG, this.getAllDCFlag());
        }
        if (!bl || this.isAWInputModeDirty()) {
            hashMap.put(FIELD_AWINPUTMODE, this.getAWInputMode());
        }
        if (!bl || this.isAWItemsDirty()) {
            hashMap.put(FIELD_AWITEMS, this.getAWItems());
        }
        if (!bl || this.isAWPathDirty()) {
            hashMap.put(FIELD_AWPATH, this.getAWPath());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
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
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDERTAWIdDirty()) {
            hashMap.put(FIELD_PSDERTAWID, this.getPSDERTAWId());
        }
        if (!bl || this.isPSDERTAWNameDirty()) {
            hashMap.put(FIELD_PSDERTAWNAME, this.getPSDERTAWName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isSRFFormModeDirty()) {
            hashMap.put(FIELD_SRFFORMMODE, this.getSRFFormMode());
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
        return PSDERTAWBase.get(this, n);
    }

    private static Object get(PSDERTAWBase pSDERTAWBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDERTAWBase.getAllDCFlag();
            }
            case 1: {
                return pSDERTAWBase.getAWInputMode();
            }
            case 2: {
                return pSDERTAWBase.getAWItems();
            }
            case 3: {
                return pSDERTAWBase.getAWPath();
            }
            case 4: {
                return pSDERTAWBase.getCreateDate();
            }
            case 5: {
                return pSDERTAWBase.getCreateMan();
            }
            case 6: {
                return pSDERTAWBase.getKeywords();
            }
            case 7: {
                return pSDERTAWBase.getMemo();
            }
            case 8: {
                return pSDERTAWBase.getOrderValue();
            }
            case 9: {
                return pSDERTAWBase.getPSDEId();
            }
            case 10: {
                return pSDERTAWBase.getPSDEName();
            }
            case 11: {
                return pSDERTAWBase.getPSDERTAWId();
            }
            case 12: {
                return pSDERTAWBase.getPSDERTAWName();
            }
            case 13: {
                return pSDERTAWBase.getPSDevCenterId();
            }
            case 14: {
                return pSDERTAWBase.getPSDevCenterName();
            }
            case 15: {
                return pSDERTAWBase.getSRFFormMode();
            }
            case 16: {
                return pSDERTAWBase.getUpdateDate();
            }
            case 17: {
                return pSDERTAWBase.getUpdateMan();
            }
            case 18: {
                return pSDERTAWBase.getUrl();
            }
            case 19: {
                return pSDERTAWBase.getUserTag();
            }
            case 20: {
                return pSDERTAWBase.getUserTag2();
            }
            case 21: {
                return pSDERTAWBase.getValidFlag();
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
        PSDERTAWBase.set(this, n, object);
    }

    private static void set(PSDERTAWBase pSDERTAWBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDERTAWBase.setAllDCFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDERTAWBase.setAWInputMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSDERTAWBase.setAWItems(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDERTAWBase.setAWPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDERTAWBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSDERTAWBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDERTAWBase.setKeywords(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDERTAWBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDERTAWBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDERTAWBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDERTAWBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDERTAWBase.setPSDERTAWId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDERTAWBase.setPSDERTAWName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDERTAWBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDERTAWBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDERTAWBase.setSRFFormMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDERTAWBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSDERTAWBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDERTAWBase.setUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDERTAWBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDERTAWBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDERTAWBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDERTAWBase.isNull(this, n);
    }

    private static boolean isNull(PSDERTAWBase pSDERTAWBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDERTAWBase.getAllDCFlag() == null;
            }
            case 1: {
                return pSDERTAWBase.getAWInputMode() == null;
            }
            case 2: {
                return pSDERTAWBase.getAWItems() == null;
            }
            case 3: {
                return pSDERTAWBase.getAWPath() == null;
            }
            case 4: {
                return pSDERTAWBase.getCreateDate() == null;
            }
            case 5: {
                return pSDERTAWBase.getCreateMan() == null;
            }
            case 6: {
                return pSDERTAWBase.getKeywords() == null;
            }
            case 7: {
                return pSDERTAWBase.getMemo() == null;
            }
            case 8: {
                return pSDERTAWBase.getOrderValue() == null;
            }
            case 9: {
                return pSDERTAWBase.getPSDEId() == null;
            }
            case 10: {
                return pSDERTAWBase.getPSDEName() == null;
            }
            case 11: {
                return pSDERTAWBase.getPSDERTAWId() == null;
            }
            case 12: {
                return pSDERTAWBase.getPSDERTAWName() == null;
            }
            case 13: {
                return pSDERTAWBase.getPSDevCenterId() == null;
            }
            case 14: {
                return pSDERTAWBase.getPSDevCenterName() == null;
            }
            case 15: {
                return pSDERTAWBase.getSRFFormMode() == null;
            }
            case 16: {
                return pSDERTAWBase.getUpdateDate() == null;
            }
            case 17: {
                return pSDERTAWBase.getUpdateMan() == null;
            }
            case 18: {
                return pSDERTAWBase.getUrl() == null;
            }
            case 19: {
                return pSDERTAWBase.getUserTag() == null;
            }
            case 20: {
                return pSDERTAWBase.getUserTag2() == null;
            }
            case 21: {
                return pSDERTAWBase.getValidFlag() == null;
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
        return PSDERTAWBase.contains(this, n);
    }

    private static boolean contains(PSDERTAWBase pSDERTAWBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDERTAWBase.isAllDCFlagDirty();
            }
            case 1: {
                return pSDERTAWBase.isAWInputModeDirty();
            }
            case 2: {
                return pSDERTAWBase.isAWItemsDirty();
            }
            case 3: {
                return pSDERTAWBase.isAWPathDirty();
            }
            case 4: {
                return pSDERTAWBase.isCreateDateDirty();
            }
            case 5: {
                return pSDERTAWBase.isCreateManDirty();
            }
            case 6: {
                return pSDERTAWBase.isKeywordsDirty();
            }
            case 7: {
                return pSDERTAWBase.isMemoDirty();
            }
            case 8: {
                return pSDERTAWBase.isOrderValueDirty();
            }
            case 9: {
                return pSDERTAWBase.isPSDEIdDirty();
            }
            case 10: {
                return pSDERTAWBase.isPSDENameDirty();
            }
            case 11: {
                return pSDERTAWBase.isPSDERTAWIdDirty();
            }
            case 12: {
                return pSDERTAWBase.isPSDERTAWNameDirty();
            }
            case 13: {
                return pSDERTAWBase.isPSDevCenterIdDirty();
            }
            case 14: {
                return pSDERTAWBase.isPSDevCenterNameDirty();
            }
            case 15: {
                return pSDERTAWBase.isSRFFormModeDirty();
            }
            case 16: {
                return pSDERTAWBase.isUpdateDateDirty();
            }
            case 17: {
                return pSDERTAWBase.isUpdateManDirty();
            }
            case 18: {
                return pSDERTAWBase.isUrlDirty();
            }
            case 19: {
                return pSDERTAWBase.isUserTagDirty();
            }
            case 20: {
                return pSDERTAWBase.isUserTag2Dirty();
            }
            case 21: {
                return pSDERTAWBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDERTAWBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDERTAWBase pSDERTAWBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDERTAWBase.getAllDCFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"alldcflag", (Object)PSDERTAWBase.getJSONValue((Object)pSDERTAWBase.getAllDCFlag()), (boolean)false);
        }
        if (bl || pSDERTAWBase.getAWInputMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"awinputmode", (Object)PSDERTAWBase.getJSONValue((Object)pSDERTAWBase.getAWInputMode()), (boolean)false);
        }
        if (bl || pSDERTAWBase.getAWItems() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"awitems", (Object)PSDERTAWBase.getJSONValue((Object)pSDERTAWBase.getAWItems()), (boolean)false);
        }
        if (bl || pSDERTAWBase.getAWPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"awpath", (Object)PSDERTAWBase.getJSONValue((Object)pSDERTAWBase.getAWPath()), (boolean)false);
        }
        if (bl || pSDERTAWBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDERTAWBase.getJSONValue((Object)pSDERTAWBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDERTAWBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDERTAWBase.getJSONValue((Object)pSDERTAWBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDERTAWBase.getKeywords() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"keywords", (Object)PSDERTAWBase.getJSONValue((Object)pSDERTAWBase.getKeywords()), (boolean)false);
        }
        if (bl || pSDERTAWBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDERTAWBase.getJSONValue((Object)pSDERTAWBase.getMemo()), (boolean)false);
        }
        if (bl || pSDERTAWBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDERTAWBase.getJSONValue((Object)pSDERTAWBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDERTAWBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDERTAWBase.getJSONValue((Object)pSDERTAWBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDERTAWBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDERTAWBase.getJSONValue((Object)pSDERTAWBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDERTAWBase.getPSDERTAWId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdertawid", (Object)PSDERTAWBase.getJSONValue((Object)pSDERTAWBase.getPSDERTAWId()), (boolean)false);
        }
        if (bl || pSDERTAWBase.getPSDERTAWName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdertawname", (Object)PSDERTAWBase.getJSONValue((Object)pSDERTAWBase.getPSDERTAWName()), (boolean)false);
        }
        if (bl || pSDERTAWBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDERTAWBase.getJSONValue((Object)pSDERTAWBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDERTAWBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDERTAWBase.getJSONValue((Object)pSDERTAWBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDERTAWBase.getSRFFormMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srfformmode", (Object)PSDERTAWBase.getJSONValue((Object)pSDERTAWBase.getSRFFormMode()), (boolean)false);
        }
        if (bl || pSDERTAWBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDERTAWBase.getJSONValue((Object)pSDERTAWBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDERTAWBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDERTAWBase.getJSONValue((Object)pSDERTAWBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDERTAWBase.getUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"url", (Object)PSDERTAWBase.getJSONValue((Object)pSDERTAWBase.getUrl()), (boolean)false);
        }
        if (bl || pSDERTAWBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDERTAWBase.getJSONValue((Object)pSDERTAWBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDERTAWBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDERTAWBase.getJSONValue((Object)pSDERTAWBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDERTAWBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDERTAWBase.getJSONValue((Object)pSDERTAWBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDERTAWBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDERTAWBase pSDERTAWBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDERTAWBase.getAllDCFlag() != null) {
            object = pSDERTAWBase.getAllDCFlag();
            xmlNode.setAttribute(FIELD_ALLDCFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERTAWBase.getAWInputMode() != null) {
            object = pSDERTAWBase.getAWInputMode();
            xmlNode.setAttribute(FIELD_AWINPUTMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERTAWBase.getAWItems() != null) {
            object = pSDERTAWBase.getAWItems();
            xmlNode.setAttribute(FIELD_AWITEMS, object == null ? "" : (String)object);
        }
        if (bl || pSDERTAWBase.getAWPath() != null) {
            object = pSDERTAWBase.getAWPath();
            xmlNode.setAttribute(FIELD_AWPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDERTAWBase.getCreateDate() != null) {
            object = pSDERTAWBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDERTAWBase.getCreateMan() != null) {
            object = pSDERTAWBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDERTAWBase.getKeywords() != null) {
            object = pSDERTAWBase.getKeywords();
            xmlNode.setAttribute(FIELD_KEYWORDS, object == null ? "" : (String)object);
        }
        if (bl || pSDERTAWBase.getMemo() != null) {
            object = pSDERTAWBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDERTAWBase.getOrderValue() != null) {
            object = pSDERTAWBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERTAWBase.getPSDEId() != null) {
            object = pSDERTAWBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDERTAWBase.getPSDEName() != null) {
            object = pSDERTAWBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERTAWBase.getPSDERTAWId() != null) {
            object = pSDERTAWBase.getPSDERTAWId();
            xmlNode.setAttribute(FIELD_PSDERTAWID, object == null ? "" : (String)object);
        }
        if (bl || pSDERTAWBase.getPSDERTAWName() != null) {
            object = pSDERTAWBase.getPSDERTAWName();
            xmlNode.setAttribute(FIELD_PSDERTAWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERTAWBase.getPSDevCenterId() != null) {
            object = pSDERTAWBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDERTAWBase.getPSDevCenterName() != null) {
            object = pSDERTAWBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERTAWBase.getSRFFormMode() != null) {
            object = pSDERTAWBase.getSRFFormMode();
            xmlNode.setAttribute(FIELD_SRFFORMMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDERTAWBase.getUpdateDate() != null) {
            object = pSDERTAWBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDERTAWBase.getUpdateMan() != null) {
            object = pSDERTAWBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDERTAWBase.getUrl() != null) {
            object = pSDERTAWBase.getUrl();
            xmlNode.setAttribute(FIELD_URL, object == null ? "" : (String)object);
        }
        if (bl || pSDERTAWBase.getUserTag() != null) {
            object = pSDERTAWBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDERTAWBase.getUserTag2() != null) {
            object = pSDERTAWBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDERTAWBase.getValidFlag() != null) {
            object = pSDERTAWBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDERTAWBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDERTAWBase pSDERTAWBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDERTAWBase.isAllDCFlagDirty() && (bl || pSDERTAWBase.getAllDCFlag() != null)) {
            iDataObject.set(FIELD_ALLDCFLAG, (Object)pSDERTAWBase.getAllDCFlag());
        }
        if (pSDERTAWBase.isAWInputModeDirty() && (bl || pSDERTAWBase.getAWInputMode() != null)) {
            iDataObject.set(FIELD_AWINPUTMODE, (Object)pSDERTAWBase.getAWInputMode());
        }
        if (pSDERTAWBase.isAWItemsDirty() && (bl || pSDERTAWBase.getAWItems() != null)) {
            iDataObject.set(FIELD_AWITEMS, (Object)pSDERTAWBase.getAWItems());
        }
        if (pSDERTAWBase.isAWPathDirty() && (bl || pSDERTAWBase.getAWPath() != null)) {
            iDataObject.set(FIELD_AWPATH, (Object)pSDERTAWBase.getAWPath());
        }
        if (pSDERTAWBase.isCreateDateDirty() && (bl || pSDERTAWBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDERTAWBase.getCreateDate());
        }
        if (pSDERTAWBase.isCreateManDirty() && (bl || pSDERTAWBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDERTAWBase.getCreateMan());
        }
        if (pSDERTAWBase.isKeywordsDirty() && (bl || pSDERTAWBase.getKeywords() != null)) {
            iDataObject.set(FIELD_KEYWORDS, (Object)pSDERTAWBase.getKeywords());
        }
        if (pSDERTAWBase.isMemoDirty() && (bl || pSDERTAWBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDERTAWBase.getMemo());
        }
        if (pSDERTAWBase.isOrderValueDirty() && (bl || pSDERTAWBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDERTAWBase.getOrderValue());
        }
        if (pSDERTAWBase.isPSDEIdDirty() && (bl || pSDERTAWBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDERTAWBase.getPSDEId());
        }
        if (pSDERTAWBase.isPSDENameDirty() && (bl || pSDERTAWBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDERTAWBase.getPSDEName());
        }
        if (pSDERTAWBase.isPSDERTAWIdDirty() && (bl || pSDERTAWBase.getPSDERTAWId() != null)) {
            iDataObject.set(FIELD_PSDERTAWID, (Object)pSDERTAWBase.getPSDERTAWId());
        }
        if (pSDERTAWBase.isPSDERTAWNameDirty() && (bl || pSDERTAWBase.getPSDERTAWName() != null)) {
            iDataObject.set(FIELD_PSDERTAWNAME, (Object)pSDERTAWBase.getPSDERTAWName());
        }
        if (pSDERTAWBase.isPSDevCenterIdDirty() && (bl || pSDERTAWBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDERTAWBase.getPSDevCenterId());
        }
        if (pSDERTAWBase.isPSDevCenterNameDirty() && (bl || pSDERTAWBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDERTAWBase.getPSDevCenterName());
        }
        if (pSDERTAWBase.isSRFFormModeDirty() && (bl || pSDERTAWBase.getSRFFormMode() != null)) {
            iDataObject.set(FIELD_SRFFORMMODE, (Object)pSDERTAWBase.getSRFFormMode());
        }
        if (pSDERTAWBase.isUpdateDateDirty() && (bl || pSDERTAWBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDERTAWBase.getUpdateDate());
        }
        if (pSDERTAWBase.isUpdateManDirty() && (bl || pSDERTAWBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDERTAWBase.getUpdateMan());
        }
        if (pSDERTAWBase.isUrlDirty() && (bl || pSDERTAWBase.getUrl() != null)) {
            iDataObject.set(FIELD_URL, (Object)pSDERTAWBase.getUrl());
        }
        if (pSDERTAWBase.isUserTagDirty() && (bl || pSDERTAWBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDERTAWBase.getUserTag());
        }
        if (pSDERTAWBase.isUserTag2Dirty() && (bl || pSDERTAWBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDERTAWBase.getUserTag2());
        }
        if (pSDERTAWBase.isValidFlagDirty() && (bl || pSDERTAWBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDERTAWBase.getValidFlag());
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
        return PSDERTAWBase.remove(this, n);
    }

    private static boolean remove(PSDERTAWBase pSDERTAWBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDERTAWBase.resetAllDCFlag();
                return true;
            }
            case 1: {
                pSDERTAWBase.resetAWInputMode();
                return true;
            }
            case 2: {
                pSDERTAWBase.resetAWItems();
                return true;
            }
            case 3: {
                pSDERTAWBase.resetAWPath();
                return true;
            }
            case 4: {
                pSDERTAWBase.resetCreateDate();
                return true;
            }
            case 5: {
                pSDERTAWBase.resetCreateMan();
                return true;
            }
            case 6: {
                pSDERTAWBase.resetKeywords();
                return true;
            }
            case 7: {
                pSDERTAWBase.resetMemo();
                return true;
            }
            case 8: {
                pSDERTAWBase.resetOrderValue();
                return true;
            }
            case 9: {
                pSDERTAWBase.resetPSDEId();
                return true;
            }
            case 10: {
                pSDERTAWBase.resetPSDEName();
                return true;
            }
            case 11: {
                pSDERTAWBase.resetPSDERTAWId();
                return true;
            }
            case 12: {
                pSDERTAWBase.resetPSDERTAWName();
                return true;
            }
            case 13: {
                pSDERTAWBase.resetPSDevCenterId();
                return true;
            }
            case 14: {
                pSDERTAWBase.resetPSDevCenterName();
                return true;
            }
            case 15: {
                pSDERTAWBase.resetSRFFormMode();
                return true;
            }
            case 16: {
                pSDERTAWBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSDERTAWBase.resetUpdateMan();
                return true;
            }
            case 18: {
                pSDERTAWBase.resetUrl();
                return true;
            }
            case 19: {
                pSDERTAWBase.resetUserTag();
                return true;
            }
            case 20: {
                pSDERTAWBase.resetUserTag2();
                return true;
            }
            case 21: {
                pSDERTAWBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDE();
        }
        if (this.getPSDEId() == null) {
            return null;
        }
        Integer n = this.objPSDELock;
        synchronized (n) {
            if (this.psde != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEId(), (Object)this.psde.getPSDataEntityId()) != 0L) {
                this.psde = null;
            }
            if (this.psde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
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
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDERTAWI> getPSDERTAWIs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERTAWIs();
        }
        if (this.getPSDERTAWId() == null) {
            return null;
        }
        PSDERTAWService pSDERTAWService = (PSDERTAWService)ServiceGlobal.getService(PSDERTAWService.class, (SessionFactory)this.getSessionFactory());
        PSDERTAWIService pSDERTAWIService = (PSDERTAWIService)ServiceGlobal.getService(PSDERTAWIService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDERTAWIsLock;
        synchronized (n) {
            if (this.psdertawis == null) {
                this.psdertawis = pSDERTAWService.isTempData((IEntity)this) ? pSDERTAWIService.selectTempByPSDERTAW(this) : pSDERTAWIService.selectByPSDERTAW(this);
            }
            return this.psdertawis;
        }
    }

    private PSDERTAWBase getProxyEntity() {
        return this.proxyPSDERTAWBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDERTAWBase = null;
        if (iDataObject != null && iDataObject instanceof PSDERTAWBase) {
            this.proxyPSDERTAWBase = (PSDERTAWBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDERTAWService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLDCFLAG, 0);
        fieldIndexMap.put(FIELD_AWINPUTMODE, 1);
        fieldIndexMap.put(FIELD_AWITEMS, 2);
        fieldIndexMap.put(FIELD_AWPATH, 3);
        fieldIndexMap.put(FIELD_CREATEDATE, 4);
        fieldIndexMap.put(FIELD_CREATEMAN, 5);
        fieldIndexMap.put(FIELD_KEYWORDS, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_ORDERVALUE, 8);
        fieldIndexMap.put(FIELD_PSDEID, 9);
        fieldIndexMap.put(FIELD_PSDENAME, 10);
        fieldIndexMap.put(FIELD_PSDERTAWID, 11);
        fieldIndexMap.put(FIELD_PSDERTAWNAME, 12);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 13);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 14);
        fieldIndexMap.put(FIELD_SRFFORMMODE, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
        fieldIndexMap.put(FIELD_URL, 18);
        fieldIndexMap.put(FIELD_USERTAG, 19);
        fieldIndexMap.put(FIELD_USERTAG2, 20);
        fieldIndexMap.put(FIELD_VALIDFLAG, 21);
    }
}

