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
package net.ibizsys.pscore.srv.dynasys.entity;

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
import net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInst;
import net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnSysDynaInstRefBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnSysDynaInstRefBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_INSTMODELPATH = "INSTMODELPATH";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEVSLNSYSDEPINSTID = "PSDEVSLNSYSDEPINSTID";
    public static final String FIELD_PSDEVSLNSYSDYNAINSTID = "PSDEVSLNSYSDYNAINSTID";
    public static final String FIELD_PSDEVSLNSYSDYNAINSTNAME = "PSDEVSLNSYSDYNAINSTNAME";
    public static final String FIELD_PSDEVSLNSYSDYNAINSTREFID = "PSDEVSLNSYSDYNAINSTREFID";
    public static final String FIELD_PSDEVSLNSYSDYNAINSTREFNAME = "PSDEVSLNSYSDYNAINSTREFNAME";
    public static final String FIELD_REFPSDEVSLNSYSDYNAINSTID = "REFPSDEVSLNSYSDYNAINSTID";
    public static final String FIELD_REFPSDEVSLNSYSDYNAINSTNAME = "REFPSDEVSLNSYSDYNAINSTNAME";
    public static final String FIELD_REFTAG = "REFTAG";
    public static final String FIELD_REFTAG2 = "REFTAG2";
    public static final String FIELD_REFTAG3 = "REFTAG3";
    public static final String FIELD_REFTAG4 = "REFTAG4";
    public static final String FIELD_REFTAG5 = "REFTAG5";
    public static final String FIELD_REFTAG6 = "REFTAG6";
    public static final String FIELD_REFTAG7 = "REFTAG7";
    public static final String FIELD_REFTAG8 = "REFTAG8";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_INSTMODELPATH = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_ORDERVALUE = 4;
    private static final int INDEX_PSDEVSLNSYSDEPINSTID = 5;
    private static final int INDEX_PSDEVSLNSYSDYNAINSTID = 6;
    private static final int INDEX_PSDEVSLNSYSDYNAINSTNAME = 7;
    private static final int INDEX_PSDEVSLNSYSDYNAINSTREFID = 8;
    private static final int INDEX_PSDEVSLNSYSDYNAINSTREFNAME = 9;
    private static final int INDEX_REFPSDEVSLNSYSDYNAINSTID = 10;
    private static final int INDEX_REFPSDEVSLNSYSDYNAINSTNAME = 11;
    private static final int INDEX_REFTAG = 12;
    private static final int INDEX_REFTAG2 = 13;
    private static final int INDEX_REFTAG3 = 14;
    private static final int INDEX_REFTAG4 = 15;
    private static final int INDEX_REFTAG5 = 16;
    private static final int INDEX_REFTAG6 = 17;
    private static final int INDEX_REFTAG7 = 18;
    private static final int INDEX_REFTAG8 = 19;
    private static final int INDEX_UPDATEDATE = 20;
    private static final int INDEX_UPDATEMAN = 21;
    private static final int INDEX_VALIDFLAG = 22;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnSysDynaInstRefBase proxyPSDevSlnSysDynaInstRefBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean instmodelpathDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdevslnsysdepinstidDirtyFlag = false;
    private boolean psdevslnsysdynainstidDirtyFlag = false;
    private boolean psdevslnsysdynainstnameDirtyFlag = false;
    private boolean psdevslnsysdynainstrefidDirtyFlag = false;
    private boolean psdevslnsysdynainstrefnameDirtyFlag = false;
    private boolean refpsdevslnsysdynainstidDirtyFlag = false;
    private boolean refpsdevslnsysdynainstnameDirtyFlag = false;
    private boolean reftagDirtyFlag = false;
    private boolean reftag2DirtyFlag = false;
    private boolean reftag3DirtyFlag = false;
    private boolean reftag4DirtyFlag = false;
    private boolean reftag5DirtyFlag = false;
    private boolean reftag6DirtyFlag = false;
    private boolean reftag7DirtyFlag = false;
    private boolean reftag8DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="instmodelpath")
    private String instmodelpath;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdevslnsysdepinstid")
    private String psdevslnsysdepinstid;
    @Column(name="psdevslnsysdynainstid")
    private String psdevslnsysdynainstid;
    @Column(name="psdevslnsysdynainstname")
    private String psdevslnsysdynainstname;
    @Column(name="psdevslnsysdynainstrefid")
    private String psdevslnsysdynainstrefid;
    @Column(name="psdevslnsysdynainstrefname")
    private String psdevslnsysdynainstrefname;
    @Column(name="refpsdevslnsysdynainstid")
    private String refpsdevslnsysdynainstid;
    @Column(name="refpsdevslnsysdynainstname")
    private String refpsdevslnsysdynainstname;
    @Column(name="reftag")
    private String reftag;
    @Column(name="reftag2")
    private String reftag2;
    @Column(name="reftag3")
    private String reftag3;
    @Column(name="reftag4")
    private String reftag4;
    @Column(name="reftag5")
    private String reftag5;
    @Column(name="reftag6")
    private String reftag6;
    @Column(name="reftag7")
    private String reftag7;
    @Column(name="reftag8")
    private String reftag8;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDevSlnSysDynaInstLock = new Integer(1);
    private PSDevSlnSysDynaInst psdevslnsysdynainst = null;
    private Integer objRefPSDevSlnSysDynaInstLock = new Integer(1);
    private PSDevSlnSysDynaInst refpsdevslnsysdynainst = null;

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

    public void setInstModelPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstModelPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.instmodelpath = string;
        this.instmodelpathDirtyFlag = true;
    }

    public String getInstModelPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInstModelPath();
        }
        return this.instmodelpath;
    }

    public boolean isInstModelPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInstModelPathDirty();
        }
        return this.instmodelpathDirtyFlag;
    }

    public void resetInstModelPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInstModelPath();
            return;
        }
        this.instmodelpathDirtyFlag = false;
        this.instmodelpath = null;
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

    public void setPSDevSlnSysDepInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysDepInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysdepinstid = string;
        this.psdevslnsysdepinstidDirtyFlag = true;
    }

    public String getPSDevSlnSysDepInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysDepInstId();
        }
        return this.psdevslnsysdepinstid;
    }

    public boolean isPSDevSlnSysDepInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysDepInstIdDirty();
        }
        return this.psdevslnsysdepinstidDirtyFlag;
    }

    public void resetPSDevSlnSysDepInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysDepInstId();
            return;
        }
        this.psdevslnsysdepinstidDirtyFlag = false;
        this.psdevslnsysdepinstid = null;
    }

    public void setPSDevSlnSysDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysdynainstid = string;
        this.psdevslnsysdynainstidDirtyFlag = true;
    }

    public String getPSDevSlnSysDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysDynaInstId();
        }
        return this.psdevslnsysdynainstid;
    }

    public boolean isPSDevSlnSysDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysDynaInstIdDirty();
        }
        return this.psdevslnsysdynainstidDirtyFlag;
    }

    public void resetPSDevSlnSysDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysDynaInstId();
            return;
        }
        this.psdevslnsysdynainstidDirtyFlag = false;
        this.psdevslnsysdynainstid = null;
    }

    public void setPSDevSlnSysDynaInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysDynaInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysdynainstname = string;
        this.psdevslnsysdynainstnameDirtyFlag = true;
    }

    public String getPSDevSlnSysDynaInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysDynaInstName();
        }
        return this.psdevslnsysdynainstname;
    }

    public boolean isPSDevSlnSysDynaInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysDynaInstNameDirty();
        }
        return this.psdevslnsysdynainstnameDirtyFlag;
    }

    public void resetPSDevSlnSysDynaInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysDynaInstName();
            return;
        }
        this.psdevslnsysdynainstnameDirtyFlag = false;
        this.psdevslnsysdynainstname = null;
    }

    public void setPSDevSlnSysDynaInstRefId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysDynaInstRefId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysdynainstrefid = string;
        this.psdevslnsysdynainstrefidDirtyFlag = true;
    }

    public String getPSDevSlnSysDynaInstRefId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysDynaInstRefId();
        }
        return this.psdevslnsysdynainstrefid;
    }

    public boolean isPSDevSlnSysDynaInstRefIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysDynaInstRefIdDirty();
        }
        return this.psdevslnsysdynainstrefidDirtyFlag;
    }

    public void resetPSDevSlnSysDynaInstRefId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysDynaInstRefId();
            return;
        }
        this.psdevslnsysdynainstrefidDirtyFlag = false;
        this.psdevslnsysdynainstrefid = null;
    }

    public void setPSDevSlnSysDynaInstRefName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysDynaInstRefName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysdynainstrefname = string;
        this.psdevslnsysdynainstrefnameDirtyFlag = true;
    }

    public String getPSDevSlnSysDynaInstRefName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysDynaInstRefName();
        }
        return this.psdevslnsysdynainstrefname;
    }

    public boolean isPSDevSlnSysDynaInstRefNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysDynaInstRefNameDirty();
        }
        return this.psdevslnsysdynainstrefnameDirtyFlag;
    }

    public void resetPSDevSlnSysDynaInstRefName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysDynaInstRefName();
            return;
        }
        this.psdevslnsysdynainstrefnameDirtyFlag = false;
        this.psdevslnsysdynainstrefname = null;
    }

    public void setRefPSDevSlnSysDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDevSlnSysDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdevslnsysdynainstid = string;
        this.refpsdevslnsysdynainstidDirtyFlag = true;
    }

    public String getRefPSDevSlnSysDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDevSlnSysDynaInstId();
        }
        return this.refpsdevslnsysdynainstid;
    }

    public boolean isRefPSDevSlnSysDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDevSlnSysDynaInstIdDirty();
        }
        return this.refpsdevslnsysdynainstidDirtyFlag;
    }

    public void resetRefPSDevSlnSysDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDevSlnSysDynaInstId();
            return;
        }
        this.refpsdevslnsysdynainstidDirtyFlag = false;
        this.refpsdevslnsysdynainstid = null;
    }

    public void setRefPSDevSlnSysDynaInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDevSlnSysDynaInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdevslnsysdynainstname = string;
        this.refpsdevslnsysdynainstnameDirtyFlag = true;
    }

    public String getRefPSDevSlnSysDynaInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDevSlnSysDynaInstName();
        }
        return this.refpsdevslnsysdynainstname;
    }

    public boolean isRefPSDevSlnSysDynaInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDevSlnSysDynaInstNameDirty();
        }
        return this.refpsdevslnsysdynainstnameDirtyFlag;
    }

    public void resetRefPSDevSlnSysDynaInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDevSlnSysDynaInstName();
            return;
        }
        this.refpsdevslnsysdynainstnameDirtyFlag = false;
        this.refpsdevslnsysdynainstname = null;
    }

    public void setRefTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.reftag = string;
        this.reftagDirtyFlag = true;
    }

    public String getRefTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefTag();
        }
        return this.reftag;
    }

    public boolean isRefTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefTagDirty();
        }
        return this.reftagDirtyFlag;
    }

    public void resetRefTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefTag();
            return;
        }
        this.reftagDirtyFlag = false;
        this.reftag = null;
    }

    public void setRefTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.reftag2 = string;
        this.reftag2DirtyFlag = true;
    }

    public String getRefTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefTag2();
        }
        return this.reftag2;
    }

    public boolean isRefTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefTag2Dirty();
        }
        return this.reftag2DirtyFlag;
    }

    public void resetRefTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefTag2();
            return;
        }
        this.reftag2DirtyFlag = false;
        this.reftag2 = null;
    }

    public void setRefTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.reftag3 = string;
        this.reftag3DirtyFlag = true;
    }

    public String getRefTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefTag3();
        }
        return this.reftag3;
    }

    public boolean isRefTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefTag3Dirty();
        }
        return this.reftag3DirtyFlag;
    }

    public void resetRefTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefTag3();
            return;
        }
        this.reftag3DirtyFlag = false;
        this.reftag3 = null;
    }

    public void setRefTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.reftag4 = string;
        this.reftag4DirtyFlag = true;
    }

    public String getRefTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefTag4();
        }
        return this.reftag4;
    }

    public boolean isRefTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefTag4Dirty();
        }
        return this.reftag4DirtyFlag;
    }

    public void resetRefTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefTag4();
            return;
        }
        this.reftag4DirtyFlag = false;
        this.reftag4 = null;
    }

    public void setRefTag5(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefTag5(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.reftag5 = string;
        this.reftag5DirtyFlag = true;
    }

    public String getRefTag5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefTag5();
        }
        return this.reftag5;
    }

    public boolean isRefTag5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefTag5Dirty();
        }
        return this.reftag5DirtyFlag;
    }

    public void resetRefTag5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefTag5();
            return;
        }
        this.reftag5DirtyFlag = false;
        this.reftag5 = null;
    }

    public void setRefTag6(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefTag6(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.reftag6 = string;
        this.reftag6DirtyFlag = true;
    }

    public String getRefTag6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefTag6();
        }
        return this.reftag6;
    }

    public boolean isRefTag6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefTag6Dirty();
        }
        return this.reftag6DirtyFlag;
    }

    public void resetRefTag6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefTag6();
            return;
        }
        this.reftag6DirtyFlag = false;
        this.reftag6 = null;
    }

    public void setRefTag7(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefTag7(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.reftag7 = string;
        this.reftag7DirtyFlag = true;
    }

    public String getRefTag7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefTag7();
        }
        return this.reftag7;
    }

    public boolean isRefTag7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefTag7Dirty();
        }
        return this.reftag7DirtyFlag;
    }

    public void resetRefTag7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefTag7();
            return;
        }
        this.reftag7DirtyFlag = false;
        this.reftag7 = null;
    }

    public void setRefTag8(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefTag8(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.reftag8 = string;
        this.reftag8DirtyFlag = true;
    }

    public String getRefTag8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefTag8();
        }
        return this.reftag8;
    }

    public boolean isRefTag8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefTag8Dirty();
        }
        return this.reftag8DirtyFlag;
    }

    public void resetRefTag8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefTag8();
            return;
        }
        this.reftag8DirtyFlag = false;
        this.reftag8 = null;
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
        PSDevSlnSysDynaInstRefBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnSysDynaInstRefBase pSDevSlnSysDynaInstRefBase) {
        pSDevSlnSysDynaInstRefBase.resetCreateDate();
        pSDevSlnSysDynaInstRefBase.resetCreateMan();
        pSDevSlnSysDynaInstRefBase.resetInstModelPath();
        pSDevSlnSysDynaInstRefBase.resetMemo();
        pSDevSlnSysDynaInstRefBase.resetOrderValue();
        pSDevSlnSysDynaInstRefBase.resetPSDevSlnSysDepInstId();
        pSDevSlnSysDynaInstRefBase.resetPSDevSlnSysDynaInstId();
        pSDevSlnSysDynaInstRefBase.resetPSDevSlnSysDynaInstName();
        pSDevSlnSysDynaInstRefBase.resetPSDevSlnSysDynaInstRefId();
        pSDevSlnSysDynaInstRefBase.resetPSDevSlnSysDynaInstRefName();
        pSDevSlnSysDynaInstRefBase.resetRefPSDevSlnSysDynaInstId();
        pSDevSlnSysDynaInstRefBase.resetRefPSDevSlnSysDynaInstName();
        pSDevSlnSysDynaInstRefBase.resetRefTag();
        pSDevSlnSysDynaInstRefBase.resetRefTag2();
        pSDevSlnSysDynaInstRefBase.resetRefTag3();
        pSDevSlnSysDynaInstRefBase.resetRefTag4();
        pSDevSlnSysDynaInstRefBase.resetRefTag5();
        pSDevSlnSysDynaInstRefBase.resetRefTag6();
        pSDevSlnSysDynaInstRefBase.resetRefTag7();
        pSDevSlnSysDynaInstRefBase.resetRefTag8();
        pSDevSlnSysDynaInstRefBase.resetUpdateDate();
        pSDevSlnSysDynaInstRefBase.resetUpdateMan();
        pSDevSlnSysDynaInstRefBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isInstModelPathDirty()) {
            hashMap.put(FIELD_INSTMODELPATH, this.getInstModelPath());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDevSlnSysDepInstIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSDEPINSTID, this.getPSDevSlnSysDepInstId());
        }
        if (!bl || this.isPSDevSlnSysDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSDYNAINSTID, this.getPSDevSlnSysDynaInstId());
        }
        if (!bl || this.isPSDevSlnSysDynaInstNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSDYNAINSTNAME, this.getPSDevSlnSysDynaInstName());
        }
        if (!bl || this.isPSDevSlnSysDynaInstRefIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSDYNAINSTREFID, this.getPSDevSlnSysDynaInstRefId());
        }
        if (!bl || this.isPSDevSlnSysDynaInstRefNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSDYNAINSTREFNAME, this.getPSDevSlnSysDynaInstRefName());
        }
        if (!bl || this.isRefPSDevSlnSysDynaInstIdDirty()) {
            hashMap.put(FIELD_REFPSDEVSLNSYSDYNAINSTID, this.getRefPSDevSlnSysDynaInstId());
        }
        if (!bl || this.isRefPSDevSlnSysDynaInstNameDirty()) {
            hashMap.put(FIELD_REFPSDEVSLNSYSDYNAINSTNAME, this.getRefPSDevSlnSysDynaInstName());
        }
        if (!bl || this.isRefTagDirty()) {
            hashMap.put(FIELD_REFTAG, this.getRefTag());
        }
        if (!bl || this.isRefTag2Dirty()) {
            hashMap.put(FIELD_REFTAG2, this.getRefTag2());
        }
        if (!bl || this.isRefTag3Dirty()) {
            hashMap.put(FIELD_REFTAG3, this.getRefTag3());
        }
        if (!bl || this.isRefTag4Dirty()) {
            hashMap.put(FIELD_REFTAG4, this.getRefTag4());
        }
        if (!bl || this.isRefTag5Dirty()) {
            hashMap.put(FIELD_REFTAG5, this.getRefTag5());
        }
        if (!bl || this.isRefTag6Dirty()) {
            hashMap.put(FIELD_REFTAG6, this.getRefTag6());
        }
        if (!bl || this.isRefTag7Dirty()) {
            hashMap.put(FIELD_REFTAG7, this.getRefTag7());
        }
        if (!bl || this.isRefTag8Dirty()) {
            hashMap.put(FIELD_REFTAG8, this.getRefTag8());
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
        return PSDevSlnSysDynaInstRefBase.get(this, n);
    }

    private static Object get(PSDevSlnSysDynaInstRefBase pSDevSlnSysDynaInstRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysDynaInstRefBase.getCreateDate();
            }
            case 1: {
                return pSDevSlnSysDynaInstRefBase.getCreateMan();
            }
            case 2: {
                return pSDevSlnSysDynaInstRefBase.getInstModelPath();
            }
            case 3: {
                return pSDevSlnSysDynaInstRefBase.getMemo();
            }
            case 4: {
                return pSDevSlnSysDynaInstRefBase.getOrderValue();
            }
            case 5: {
                return pSDevSlnSysDynaInstRefBase.getPSDevSlnSysDepInstId();
            }
            case 6: {
                return pSDevSlnSysDynaInstRefBase.getPSDevSlnSysDynaInstId();
            }
            case 7: {
                return pSDevSlnSysDynaInstRefBase.getPSDevSlnSysDynaInstName();
            }
            case 8: {
                return pSDevSlnSysDynaInstRefBase.getPSDevSlnSysDynaInstRefId();
            }
            case 9: {
                return pSDevSlnSysDynaInstRefBase.getPSDevSlnSysDynaInstRefName();
            }
            case 10: {
                return pSDevSlnSysDynaInstRefBase.getRefPSDevSlnSysDynaInstId();
            }
            case 11: {
                return pSDevSlnSysDynaInstRefBase.getRefPSDevSlnSysDynaInstName();
            }
            case 12: {
                return pSDevSlnSysDynaInstRefBase.getRefTag();
            }
            case 13: {
                return pSDevSlnSysDynaInstRefBase.getRefTag2();
            }
            case 14: {
                return pSDevSlnSysDynaInstRefBase.getRefTag3();
            }
            case 15: {
                return pSDevSlnSysDynaInstRefBase.getRefTag4();
            }
            case 16: {
                return pSDevSlnSysDynaInstRefBase.getRefTag5();
            }
            case 17: {
                return pSDevSlnSysDynaInstRefBase.getRefTag6();
            }
            case 18: {
                return pSDevSlnSysDynaInstRefBase.getRefTag7();
            }
            case 19: {
                return pSDevSlnSysDynaInstRefBase.getRefTag8();
            }
            case 20: {
                return pSDevSlnSysDynaInstRefBase.getUpdateDate();
            }
            case 21: {
                return pSDevSlnSysDynaInstRefBase.getUpdateMan();
            }
            case 22: {
                return pSDevSlnSysDynaInstRefBase.getValidFlag();
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
        PSDevSlnSysDynaInstRefBase.set(this, n, object);
    }

    private static void set(PSDevSlnSysDynaInstRefBase pSDevSlnSysDynaInstRefBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysDynaInstRefBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnSysDynaInstRefBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnSysDynaInstRefBase.setInstModelPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnSysDynaInstRefBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnSysDynaInstRefBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnSysDynaInstRefBase.setPSDevSlnSysDepInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnSysDynaInstRefBase.setPSDevSlnSysDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnSysDynaInstRefBase.setPSDevSlnSysDynaInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnSysDynaInstRefBase.setPSDevSlnSysDynaInstRefId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnSysDynaInstRefBase.setPSDevSlnSysDynaInstRefName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnSysDynaInstRefBase.setRefPSDevSlnSysDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnSysDynaInstRefBase.setRefPSDevSlnSysDynaInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnSysDynaInstRefBase.setRefTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevSlnSysDynaInstRefBase.setRefTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevSlnSysDynaInstRefBase.setRefTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevSlnSysDynaInstRefBase.setRefTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevSlnSysDynaInstRefBase.setRefTag5(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDevSlnSysDynaInstRefBase.setRefTag6(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDevSlnSysDynaInstRefBase.setRefTag7(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDevSlnSysDynaInstRefBase.setRefTag8(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDevSlnSysDynaInstRefBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 21: {
                pSDevSlnSysDynaInstRefBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDevSlnSysDynaInstRefBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDevSlnSysDynaInstRefBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnSysDynaInstRefBase pSDevSlnSysDynaInstRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysDynaInstRefBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevSlnSysDynaInstRefBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevSlnSysDynaInstRefBase.getInstModelPath() == null;
            }
            case 3: {
                return pSDevSlnSysDynaInstRefBase.getMemo() == null;
            }
            case 4: {
                return pSDevSlnSysDynaInstRefBase.getOrderValue() == null;
            }
            case 5: {
                return pSDevSlnSysDynaInstRefBase.getPSDevSlnSysDepInstId() == null;
            }
            case 6: {
                return pSDevSlnSysDynaInstRefBase.getPSDevSlnSysDynaInstId() == null;
            }
            case 7: {
                return pSDevSlnSysDynaInstRefBase.getPSDevSlnSysDynaInstName() == null;
            }
            case 8: {
                return pSDevSlnSysDynaInstRefBase.getPSDevSlnSysDynaInstRefId() == null;
            }
            case 9: {
                return pSDevSlnSysDynaInstRefBase.getPSDevSlnSysDynaInstRefName() == null;
            }
            case 10: {
                return pSDevSlnSysDynaInstRefBase.getRefPSDevSlnSysDynaInstId() == null;
            }
            case 11: {
                return pSDevSlnSysDynaInstRefBase.getRefPSDevSlnSysDynaInstName() == null;
            }
            case 12: {
                return pSDevSlnSysDynaInstRefBase.getRefTag() == null;
            }
            case 13: {
                return pSDevSlnSysDynaInstRefBase.getRefTag2() == null;
            }
            case 14: {
                return pSDevSlnSysDynaInstRefBase.getRefTag3() == null;
            }
            case 15: {
                return pSDevSlnSysDynaInstRefBase.getRefTag4() == null;
            }
            case 16: {
                return pSDevSlnSysDynaInstRefBase.getRefTag5() == null;
            }
            case 17: {
                return pSDevSlnSysDynaInstRefBase.getRefTag6() == null;
            }
            case 18: {
                return pSDevSlnSysDynaInstRefBase.getRefTag7() == null;
            }
            case 19: {
                return pSDevSlnSysDynaInstRefBase.getRefTag8() == null;
            }
            case 20: {
                return pSDevSlnSysDynaInstRefBase.getUpdateDate() == null;
            }
            case 21: {
                return pSDevSlnSysDynaInstRefBase.getUpdateMan() == null;
            }
            case 22: {
                return pSDevSlnSysDynaInstRefBase.getValidFlag() == null;
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
        return PSDevSlnSysDynaInstRefBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnSysDynaInstRefBase pSDevSlnSysDynaInstRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysDynaInstRefBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevSlnSysDynaInstRefBase.isCreateManDirty();
            }
            case 2: {
                return pSDevSlnSysDynaInstRefBase.isInstModelPathDirty();
            }
            case 3: {
                return pSDevSlnSysDynaInstRefBase.isMemoDirty();
            }
            case 4: {
                return pSDevSlnSysDynaInstRefBase.isOrderValueDirty();
            }
            case 5: {
                return pSDevSlnSysDynaInstRefBase.isPSDevSlnSysDepInstIdDirty();
            }
            case 6: {
                return pSDevSlnSysDynaInstRefBase.isPSDevSlnSysDynaInstIdDirty();
            }
            case 7: {
                return pSDevSlnSysDynaInstRefBase.isPSDevSlnSysDynaInstNameDirty();
            }
            case 8: {
                return pSDevSlnSysDynaInstRefBase.isPSDevSlnSysDynaInstRefIdDirty();
            }
            case 9: {
                return pSDevSlnSysDynaInstRefBase.isPSDevSlnSysDynaInstRefNameDirty();
            }
            case 10: {
                return pSDevSlnSysDynaInstRefBase.isRefPSDevSlnSysDynaInstIdDirty();
            }
            case 11: {
                return pSDevSlnSysDynaInstRefBase.isRefPSDevSlnSysDynaInstNameDirty();
            }
            case 12: {
                return pSDevSlnSysDynaInstRefBase.isRefTagDirty();
            }
            case 13: {
                return pSDevSlnSysDynaInstRefBase.isRefTag2Dirty();
            }
            case 14: {
                return pSDevSlnSysDynaInstRefBase.isRefTag3Dirty();
            }
            case 15: {
                return pSDevSlnSysDynaInstRefBase.isRefTag4Dirty();
            }
            case 16: {
                return pSDevSlnSysDynaInstRefBase.isRefTag5Dirty();
            }
            case 17: {
                return pSDevSlnSysDynaInstRefBase.isRefTag6Dirty();
            }
            case 18: {
                return pSDevSlnSysDynaInstRefBase.isRefTag7Dirty();
            }
            case 19: {
                return pSDevSlnSysDynaInstRefBase.isRefTag8Dirty();
            }
            case 20: {
                return pSDevSlnSysDynaInstRefBase.isUpdateDateDirty();
            }
            case 21: {
                return pSDevSlnSysDynaInstRefBase.isUpdateManDirty();
            }
            case 22: {
                return pSDevSlnSysDynaInstRefBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnSysDynaInstRefBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnSysDynaInstRefBase pSDevSlnSysDynaInstRefBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnSysDynaInstRefBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnSysDynaInstRefBase.getJSONValue((Object)pSDevSlnSysDynaInstRefBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnSysDynaInstRefBase.getJSONValue((Object)pSDevSlnSysDynaInstRefBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getInstModelPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"instmodelpath", (Object)PSDevSlnSysDynaInstRefBase.getJSONValue((Object)pSDevSlnSysDynaInstRefBase.getInstModelPath()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSlnSysDynaInstRefBase.getJSONValue((Object)pSDevSlnSysDynaInstRefBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDevSlnSysDynaInstRefBase.getJSONValue((Object)pSDevSlnSysDynaInstRefBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getPSDevSlnSysDepInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysdepinstid", (Object)PSDevSlnSysDynaInstRefBase.getJSONValue((Object)pSDevSlnSysDynaInstRefBase.getPSDevSlnSysDepInstId()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getPSDevSlnSysDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysdynainstid", (Object)PSDevSlnSysDynaInstRefBase.getJSONValue((Object)pSDevSlnSysDynaInstRefBase.getPSDevSlnSysDynaInstId()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getPSDevSlnSysDynaInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysdynainstname", (Object)PSDevSlnSysDynaInstRefBase.getJSONValue((Object)pSDevSlnSysDynaInstRefBase.getPSDevSlnSysDynaInstName()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getPSDevSlnSysDynaInstRefId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysdynainstrefid", (Object)PSDevSlnSysDynaInstRefBase.getJSONValue((Object)pSDevSlnSysDynaInstRefBase.getPSDevSlnSysDynaInstRefId()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getPSDevSlnSysDynaInstRefName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysdynainstrefname", (Object)PSDevSlnSysDynaInstRefBase.getJSONValue((Object)pSDevSlnSysDynaInstRefBase.getPSDevSlnSysDynaInstRefName()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getRefPSDevSlnSysDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdevslnsysdynainstid", (Object)PSDevSlnSysDynaInstRefBase.getJSONValue((Object)pSDevSlnSysDynaInstRefBase.getRefPSDevSlnSysDynaInstId()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getRefPSDevSlnSysDynaInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdevslnsysdynainstname", (Object)PSDevSlnSysDynaInstRefBase.getJSONValue((Object)pSDevSlnSysDynaInstRefBase.getRefPSDevSlnSysDynaInstName()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getRefTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reftag", (Object)PSDevSlnSysDynaInstRefBase.getJSONValue((Object)pSDevSlnSysDynaInstRefBase.getRefTag()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getRefTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reftag2", (Object)PSDevSlnSysDynaInstRefBase.getJSONValue((Object)pSDevSlnSysDynaInstRefBase.getRefTag2()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getRefTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reftag3", (Object)PSDevSlnSysDynaInstRefBase.getJSONValue((Object)pSDevSlnSysDynaInstRefBase.getRefTag3()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getRefTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reftag4", (Object)PSDevSlnSysDynaInstRefBase.getJSONValue((Object)pSDevSlnSysDynaInstRefBase.getRefTag4()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getRefTag5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reftag5", (Object)PSDevSlnSysDynaInstRefBase.getJSONValue((Object)pSDevSlnSysDynaInstRefBase.getRefTag5()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getRefTag6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reftag6", (Object)PSDevSlnSysDynaInstRefBase.getJSONValue((Object)pSDevSlnSysDynaInstRefBase.getRefTag6()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getRefTag7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reftag7", (Object)PSDevSlnSysDynaInstRefBase.getJSONValue((Object)pSDevSlnSysDynaInstRefBase.getRefTag7()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getRefTag8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reftag8", (Object)PSDevSlnSysDynaInstRefBase.getJSONValue((Object)pSDevSlnSysDynaInstRefBase.getRefTag8()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnSysDynaInstRefBase.getJSONValue((Object)pSDevSlnSysDynaInstRefBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnSysDynaInstRefBase.getJSONValue((Object)pSDevSlnSysDynaInstRefBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDevSlnSysDynaInstRefBase.getJSONValue((Object)pSDevSlnSysDynaInstRefBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnSysDynaInstRefBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnSysDynaInstRefBase pSDevSlnSysDynaInstRefBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnSysDynaInstRefBase.getCreateDate() != null) {
            object = pSDevSlnSysDynaInstRefBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getCreateMan() != null) {
            object = pSDevSlnSysDynaInstRefBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getInstModelPath() != null) {
            object = pSDevSlnSysDynaInstRefBase.getInstModelPath();
            xmlNode.setAttribute(FIELD_INSTMODELPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getMemo() != null) {
            object = pSDevSlnSysDynaInstRefBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getOrderValue() != null) {
            object = pSDevSlnSysDynaInstRefBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getPSDevSlnSysDepInstId() != null) {
            object = pSDevSlnSysDynaInstRefBase.getPSDevSlnSysDepInstId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSDEPINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getPSDevSlnSysDynaInstId() != null) {
            object = pSDevSlnSysDynaInstRefBase.getPSDevSlnSysDynaInstId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getPSDevSlnSysDynaInstName() != null) {
            object = pSDevSlnSysDynaInstRefBase.getPSDevSlnSysDynaInstName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSDYNAINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getPSDevSlnSysDynaInstRefId() != null) {
            object = pSDevSlnSysDynaInstRefBase.getPSDevSlnSysDynaInstRefId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSDYNAINSTREFID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getPSDevSlnSysDynaInstRefName() != null) {
            object = pSDevSlnSysDynaInstRefBase.getPSDevSlnSysDynaInstRefName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSDYNAINSTREFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getRefPSDevSlnSysDynaInstId() != null) {
            object = pSDevSlnSysDynaInstRefBase.getRefPSDevSlnSysDynaInstId();
            xmlNode.setAttribute(FIELD_REFPSDEVSLNSYSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getRefPSDevSlnSysDynaInstName() != null) {
            object = pSDevSlnSysDynaInstRefBase.getRefPSDevSlnSysDynaInstName();
            xmlNode.setAttribute(FIELD_REFPSDEVSLNSYSDYNAINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getRefTag() != null) {
            object = pSDevSlnSysDynaInstRefBase.getRefTag();
            xmlNode.setAttribute(FIELD_REFTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getRefTag2() != null) {
            object = pSDevSlnSysDynaInstRefBase.getRefTag2();
            xmlNode.setAttribute(FIELD_REFTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getRefTag3() != null) {
            object = pSDevSlnSysDynaInstRefBase.getRefTag3();
            xmlNode.setAttribute(FIELD_REFTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getRefTag4() != null) {
            object = pSDevSlnSysDynaInstRefBase.getRefTag4();
            xmlNode.setAttribute(FIELD_REFTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getRefTag5() != null) {
            object = pSDevSlnSysDynaInstRefBase.getRefTag5();
            xmlNode.setAttribute(FIELD_REFTAG5, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getRefTag6() != null) {
            object = pSDevSlnSysDynaInstRefBase.getRefTag6();
            xmlNode.setAttribute(FIELD_REFTAG6, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getRefTag7() != null) {
            object = pSDevSlnSysDynaInstRefBase.getRefTag7();
            xmlNode.setAttribute(FIELD_REFTAG7, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getRefTag8() != null) {
            object = pSDevSlnSysDynaInstRefBase.getRefTag8();
            xmlNode.setAttribute(FIELD_REFTAG8, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getUpdateDate() != null) {
            object = pSDevSlnSysDynaInstRefBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getUpdateMan() != null) {
            object = pSDevSlnSysDynaInstRefBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstRefBase.getValidFlag() != null) {
            object = pSDevSlnSysDynaInstRefBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnSysDynaInstRefBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnSysDynaInstRefBase pSDevSlnSysDynaInstRefBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnSysDynaInstRefBase.isCreateDateDirty() && (bl || pSDevSlnSysDynaInstRefBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnSysDynaInstRefBase.getCreateDate());
        }
        if (pSDevSlnSysDynaInstRefBase.isCreateManDirty() && (bl || pSDevSlnSysDynaInstRefBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnSysDynaInstRefBase.getCreateMan());
        }
        if (pSDevSlnSysDynaInstRefBase.isInstModelPathDirty() && (bl || pSDevSlnSysDynaInstRefBase.getInstModelPath() != null)) {
            iDataObject.set(FIELD_INSTMODELPATH, (Object)pSDevSlnSysDynaInstRefBase.getInstModelPath());
        }
        if (pSDevSlnSysDynaInstRefBase.isMemoDirty() && (bl || pSDevSlnSysDynaInstRefBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSlnSysDynaInstRefBase.getMemo());
        }
        if (pSDevSlnSysDynaInstRefBase.isOrderValueDirty() && (bl || pSDevSlnSysDynaInstRefBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDevSlnSysDynaInstRefBase.getOrderValue());
        }
        if (pSDevSlnSysDynaInstRefBase.isPSDevSlnSysDepInstIdDirty() && (bl || pSDevSlnSysDynaInstRefBase.getPSDevSlnSysDepInstId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSDEPINSTID, (Object)pSDevSlnSysDynaInstRefBase.getPSDevSlnSysDepInstId());
        }
        if (pSDevSlnSysDynaInstRefBase.isPSDevSlnSysDynaInstIdDirty() && (bl || pSDevSlnSysDynaInstRefBase.getPSDevSlnSysDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSDYNAINSTID, (Object)pSDevSlnSysDynaInstRefBase.getPSDevSlnSysDynaInstId());
        }
        if (pSDevSlnSysDynaInstRefBase.isPSDevSlnSysDynaInstNameDirty() && (bl || pSDevSlnSysDynaInstRefBase.getPSDevSlnSysDynaInstName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSDYNAINSTNAME, (Object)pSDevSlnSysDynaInstRefBase.getPSDevSlnSysDynaInstName());
        }
        if (pSDevSlnSysDynaInstRefBase.isPSDevSlnSysDynaInstRefIdDirty() && (bl || pSDevSlnSysDynaInstRefBase.getPSDevSlnSysDynaInstRefId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSDYNAINSTREFID, (Object)pSDevSlnSysDynaInstRefBase.getPSDevSlnSysDynaInstRefId());
        }
        if (pSDevSlnSysDynaInstRefBase.isPSDevSlnSysDynaInstRefNameDirty() && (bl || pSDevSlnSysDynaInstRefBase.getPSDevSlnSysDynaInstRefName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSDYNAINSTREFNAME, (Object)pSDevSlnSysDynaInstRefBase.getPSDevSlnSysDynaInstRefName());
        }
        if (pSDevSlnSysDynaInstRefBase.isRefPSDevSlnSysDynaInstIdDirty() && (bl || pSDevSlnSysDynaInstRefBase.getRefPSDevSlnSysDynaInstId() != null)) {
            iDataObject.set(FIELD_REFPSDEVSLNSYSDYNAINSTID, (Object)pSDevSlnSysDynaInstRefBase.getRefPSDevSlnSysDynaInstId());
        }
        if (pSDevSlnSysDynaInstRefBase.isRefPSDevSlnSysDynaInstNameDirty() && (bl || pSDevSlnSysDynaInstRefBase.getRefPSDevSlnSysDynaInstName() != null)) {
            iDataObject.set(FIELD_REFPSDEVSLNSYSDYNAINSTNAME, (Object)pSDevSlnSysDynaInstRefBase.getRefPSDevSlnSysDynaInstName());
        }
        if (pSDevSlnSysDynaInstRefBase.isRefTagDirty() && (bl || pSDevSlnSysDynaInstRefBase.getRefTag() != null)) {
            iDataObject.set(FIELD_REFTAG, (Object)pSDevSlnSysDynaInstRefBase.getRefTag());
        }
        if (pSDevSlnSysDynaInstRefBase.isRefTag2Dirty() && (bl || pSDevSlnSysDynaInstRefBase.getRefTag2() != null)) {
            iDataObject.set(FIELD_REFTAG2, (Object)pSDevSlnSysDynaInstRefBase.getRefTag2());
        }
        if (pSDevSlnSysDynaInstRefBase.isRefTag3Dirty() && (bl || pSDevSlnSysDynaInstRefBase.getRefTag3() != null)) {
            iDataObject.set(FIELD_REFTAG3, (Object)pSDevSlnSysDynaInstRefBase.getRefTag3());
        }
        if (pSDevSlnSysDynaInstRefBase.isRefTag4Dirty() && (bl || pSDevSlnSysDynaInstRefBase.getRefTag4() != null)) {
            iDataObject.set(FIELD_REFTAG4, (Object)pSDevSlnSysDynaInstRefBase.getRefTag4());
        }
        if (pSDevSlnSysDynaInstRefBase.isRefTag5Dirty() && (bl || pSDevSlnSysDynaInstRefBase.getRefTag5() != null)) {
            iDataObject.set(FIELD_REFTAG5, (Object)pSDevSlnSysDynaInstRefBase.getRefTag5());
        }
        if (pSDevSlnSysDynaInstRefBase.isRefTag6Dirty() && (bl || pSDevSlnSysDynaInstRefBase.getRefTag6() != null)) {
            iDataObject.set(FIELD_REFTAG6, (Object)pSDevSlnSysDynaInstRefBase.getRefTag6());
        }
        if (pSDevSlnSysDynaInstRefBase.isRefTag7Dirty() && (bl || pSDevSlnSysDynaInstRefBase.getRefTag7() != null)) {
            iDataObject.set(FIELD_REFTAG7, (Object)pSDevSlnSysDynaInstRefBase.getRefTag7());
        }
        if (pSDevSlnSysDynaInstRefBase.isRefTag8Dirty() && (bl || pSDevSlnSysDynaInstRefBase.getRefTag8() != null)) {
            iDataObject.set(FIELD_REFTAG8, (Object)pSDevSlnSysDynaInstRefBase.getRefTag8());
        }
        if (pSDevSlnSysDynaInstRefBase.isUpdateDateDirty() && (bl || pSDevSlnSysDynaInstRefBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnSysDynaInstRefBase.getUpdateDate());
        }
        if (pSDevSlnSysDynaInstRefBase.isUpdateManDirty() && (bl || pSDevSlnSysDynaInstRefBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnSysDynaInstRefBase.getUpdateMan());
        }
        if (pSDevSlnSysDynaInstRefBase.isValidFlagDirty() && (bl || pSDevSlnSysDynaInstRefBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDevSlnSysDynaInstRefBase.getValidFlag());
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
        return PSDevSlnSysDynaInstRefBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnSysDynaInstRefBase pSDevSlnSysDynaInstRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysDynaInstRefBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevSlnSysDynaInstRefBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevSlnSysDynaInstRefBase.resetInstModelPath();
                return true;
            }
            case 3: {
                pSDevSlnSysDynaInstRefBase.resetMemo();
                return true;
            }
            case 4: {
                pSDevSlnSysDynaInstRefBase.resetOrderValue();
                return true;
            }
            case 5: {
                pSDevSlnSysDynaInstRefBase.resetPSDevSlnSysDepInstId();
                return true;
            }
            case 6: {
                pSDevSlnSysDynaInstRefBase.resetPSDevSlnSysDynaInstId();
                return true;
            }
            case 7: {
                pSDevSlnSysDynaInstRefBase.resetPSDevSlnSysDynaInstName();
                return true;
            }
            case 8: {
                pSDevSlnSysDynaInstRefBase.resetPSDevSlnSysDynaInstRefId();
                return true;
            }
            case 9: {
                pSDevSlnSysDynaInstRefBase.resetPSDevSlnSysDynaInstRefName();
                return true;
            }
            case 10: {
                pSDevSlnSysDynaInstRefBase.resetRefPSDevSlnSysDynaInstId();
                return true;
            }
            case 11: {
                pSDevSlnSysDynaInstRefBase.resetRefPSDevSlnSysDynaInstName();
                return true;
            }
            case 12: {
                pSDevSlnSysDynaInstRefBase.resetRefTag();
                return true;
            }
            case 13: {
                pSDevSlnSysDynaInstRefBase.resetRefTag2();
                return true;
            }
            case 14: {
                pSDevSlnSysDynaInstRefBase.resetRefTag3();
                return true;
            }
            case 15: {
                pSDevSlnSysDynaInstRefBase.resetRefTag4();
                return true;
            }
            case 16: {
                pSDevSlnSysDynaInstRefBase.resetRefTag5();
                return true;
            }
            case 17: {
                pSDevSlnSysDynaInstRefBase.resetRefTag6();
                return true;
            }
            case 18: {
                pSDevSlnSysDynaInstRefBase.resetRefTag7();
                return true;
            }
            case 19: {
                pSDevSlnSysDynaInstRefBase.resetRefTag8();
                return true;
            }
            case 20: {
                pSDevSlnSysDynaInstRefBase.resetUpdateDate();
                return true;
            }
            case 21: {
                pSDevSlnSysDynaInstRefBase.resetUpdateMan();
                return true;
            }
            case 22: {
                pSDevSlnSysDynaInstRefBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSysDynaInst getPSDevSlnSysDynaInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysDynaInst();
        }
        if (this.getPSDevSlnSysDynaInstId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysDynaInstLock;
        synchronized (n) {
            if (this.psdevslnsysdynainst != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysDynaInstId(), (Object)this.psdevslnsysdynainst.getPSDevSlnSysDynaInstId()) != 0L) {
                this.psdevslnsysdynainst = null;
            }
            if (this.psdevslnsysdynainst == null) {
                PSDevSlnSysDynaInst pSDevSlnSysDynaInst = new PSDevSlnSysDynaInst();
                pSDevSlnSysDynaInst.setPSDevSlnSysDynaInstId(this.getPSDevSlnSysDynaInstId());
                PSDevSlnSysDynaInstService pSDevSlnSysDynaInstService = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysDynaInstService.autoGet(pSDevSlnSysDynaInst);
                this.psdevslnsysdynainst = pSDevSlnSysDynaInst;
            }
            return this.psdevslnsysdynainst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSysDynaInst getRefPSDevSlnSysDynaInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDevSlnSysDynaInst();
        }
        if (this.getRefPSDevSlnSysDynaInstId() == null) {
            return null;
        }
        Integer n = this.objRefPSDevSlnSysDynaInstLock;
        synchronized (n) {
            if (this.refpsdevslnsysdynainst != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSDevSlnSysDynaInstId(), (Object)this.refpsdevslnsysdynainst.getPSDevSlnSysDynaInstId()) != 0L) {
                this.refpsdevslnsysdynainst = null;
            }
            if (this.refpsdevslnsysdynainst == null) {
                PSDevSlnSysDynaInst pSDevSlnSysDynaInst = new PSDevSlnSysDynaInst();
                pSDevSlnSysDynaInst.setPSDevSlnSysDynaInstId(this.getRefPSDevSlnSysDynaInstId());
                PSDevSlnSysDynaInstService pSDevSlnSysDynaInstService = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysDynaInstService.autoGet(pSDevSlnSysDynaInst);
                this.refpsdevslnsysdynainst = pSDevSlnSysDynaInst;
            }
            return this.refpsdevslnsysdynainst;
        }
    }

    private PSDevSlnSysDynaInstRefBase getProxyEntity() {
        return this.proxyPSDevSlnSysDynaInstRefBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnSysDynaInstRefBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnSysDynaInstRefBase) {
            this.proxyPSDevSlnSysDynaInstRefBase = (PSDevSlnSysDynaInstRefBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstRefService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_INSTMODELPATH, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_ORDERVALUE, 4);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSDEPINSTID, 5);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSDYNAINSTID, 6);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSDYNAINSTNAME, 7);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSDYNAINSTREFID, 8);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSDYNAINSTREFNAME, 9);
        fieldIndexMap.put(FIELD_REFPSDEVSLNSYSDYNAINSTID, 10);
        fieldIndexMap.put(FIELD_REFPSDEVSLNSYSDYNAINSTNAME, 11);
        fieldIndexMap.put(FIELD_REFTAG, 12);
        fieldIndexMap.put(FIELD_REFTAG2, 13);
        fieldIndexMap.put(FIELD_REFTAG3, 14);
        fieldIndexMap.put(FIELD_REFTAG4, 15);
        fieldIndexMap.put(FIELD_REFTAG5, 16);
        fieldIndexMap.put(FIELD_REFTAG6, 17);
        fieldIndexMap.put(FIELD_REFTAG7, 18);
        fieldIndexMap.put(FIELD_REFTAG8, 19);
        fieldIndexMap.put(FIELD_UPDATEDATE, 20);
        fieldIndexMap.put(FIELD_UPDATEMAN, 21);
        fieldIndexMap.put(FIELD_VALIDFLAG, 22);
    }
}

