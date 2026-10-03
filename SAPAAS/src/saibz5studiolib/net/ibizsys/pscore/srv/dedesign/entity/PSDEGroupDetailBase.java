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
package net.ibizsys.pscore.srv.dedesign.entity;

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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEGroupDetailBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEGroupDetailBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CODENAME2 = "CODENAME2";
    public static final String FIELD_COLOR = "COLOR";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DATA = "DATA";
    public static final String FIELD_DETAG = "DETAG";
    public static final String FIELD_DETAG2 = "DETAG2";
    public static final String FIELD_DETAILPARAM = "DETAILPARAM";
    public static final String FIELD_DETAILPARAM2 = "DETAILPARAM2";
    public static final String FIELD_DETAILTAG = "DETAILTAG";
    public static final String FIELD_DETAILTAG2 = "DETAILTAG2";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODCOLOR = "MODCOLOR";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEGROUPDETAILID = "PSDEGROUPDETAILID";
    public static final String FIELD_PSDEGROUPDETAILNAME = "PSDEGROUPDETAILNAME";
    public static final String FIELD_PSDEGROUPID = "PSDEGROUPID";
    public static final String FIELD_PSDEGROUPNAME = "PSDEGROUPNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CODENAME2 = 1;
    private static final int INDEX_COLOR = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_DATA = 5;
    private static final int INDEX_DETAG = 6;
    private static final int INDEX_DETAG2 = 7;
    private static final int INDEX_DETAILPARAM = 8;
    private static final int INDEX_DETAILPARAM2 = 9;
    private static final int INDEX_DETAILTAG = 10;
    private static final int INDEX_DETAILTAG2 = 11;
    private static final int INDEX_LOGICNAME = 12;
    private static final int INDEX_MEMO = 13;
    private static final int INDEX_MODCOLOR = 14;
    private static final int INDEX_ORDERVALUE = 15;
    private static final int INDEX_PSDEGROUPDETAILID = 16;
    private static final int INDEX_PSDEGROUPDETAILNAME = 17;
    private static final int INDEX_PSDEGROUPID = 18;
    private static final int INDEX_PSDEGROUPNAME = 19;
    private static final int INDEX_PSDEID = 20;
    private static final int INDEX_PSDENAME = 21;
    private static final int INDEX_PSMODULENAME = 22;
    private static final int INDEX_UPDATEDATE = 23;
    private static final int INDEX_UPDATEMAN = 24;
    private static final int INDEX_USERCAT = 25;
    private static final int INDEX_USERTAG = 26;
    private static final int INDEX_USERTAG2 = 27;
    private static final int INDEX_USERTAG3 = 28;
    private static final int INDEX_USERTAG4 = 29;
    private static final int INDEX_VALIDFLAG = 30;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEGroupDetailBase proxyPSDEGroupDetailBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean codename2DirtyFlag = false;
    private boolean colorDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dataDirtyFlag = false;
    private boolean detagDirtyFlag = false;
    private boolean detag2DirtyFlag = false;
    private boolean detailparamDirtyFlag = false;
    private boolean detailparam2DirtyFlag = false;
    private boolean detailtagDirtyFlag = false;
    private boolean detailtag2DirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modcolorDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdegroupdetailidDirtyFlag = false;
    private boolean psdegroupdetailnameDirtyFlag = false;
    private boolean psdegroupidDirtyFlag = false;
    private boolean psdegroupnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="codename2")
    private String codename2;
    @Column(name="color")
    private String color;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="data")
    private String data;
    @Column(name="detag")
    private String detag;
    @Column(name="detag2")
    private String detag2;
    @Column(name="detailparam")
    private String detailparam;
    @Column(name="detailparam2")
    private String detailparam2;
    @Column(name="detailtag")
    private String detailtag;
    @Column(name="detailtag2")
    private String detailtag2;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="modcolor")
    private String modcolor;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdegroupdetailid")
    private String psdegroupdetailid;
    @Column(name="psdegroupdetailname")
    private String psdegroupdetailname;
    @Column(name="psdegroupid")
    private String psdegroupid;
    @Column(name="psdegroupname")
    private String psdegroupname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psmodulename")
    private String psmodulename;
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
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEGroupLock = new Integer(1);
    private PSDEGroup psdegroup = null;

    public void setCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename = string;
        this.codenameDirtyFlag = true;
    }

    public String getCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName();
        }
        return this.codename;
    }

    public boolean isCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeNameDirty();
        }
        return this.codenameDirtyFlag;
    }

    public void resetCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName();
            return;
        }
        this.codenameDirtyFlag = false;
        this.codename = null;
    }

    public void setCodeName2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename2 = string;
        this.codename2DirtyFlag = true;
    }

    public String getCodeName2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName2();
        }
        return this.codename2;
    }

    public boolean isCodeName2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeName2Dirty();
        }
        return this.codename2DirtyFlag;
    }

    public void resetCodeName2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName2();
            return;
        }
        this.codename2DirtyFlag = false;
        this.codename2 = null;
    }

    public void setColor(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setColor(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.color = string;
        this.colorDirtyFlag = true;
    }

    public String getColor() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getColor();
        }
        return this.color;
    }

    public boolean isColorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isColorDirty();
        }
        return this.colorDirtyFlag;
    }

    public void resetColor() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetColor();
            return;
        }
        this.colorDirtyFlag = false;
        this.color = null;
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

    public void setData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.data = string;
        this.dataDirtyFlag = true;
    }

    public String getData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getData();
        }
        return this.data;
    }

    public boolean isDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataDirty();
        }
        return this.dataDirtyFlag;
    }

    public void resetData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetData();
            return;
        }
        this.dataDirtyFlag = false;
        this.data = null;
    }

    public void setDETag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDETag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.detag = string;
        this.detagDirtyFlag = true;
    }

    public String getDETag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDETag();
        }
        return this.detag;
    }

    public boolean isDETagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDETagDirty();
        }
        return this.detagDirtyFlag;
    }

    public void resetDETag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDETag();
            return;
        }
        this.detagDirtyFlag = false;
        this.detag = null;
    }

    public void setDETag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDETag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.detag2 = string;
        this.detag2DirtyFlag = true;
    }

    public String getDETag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDETag2();
        }
        return this.detag2;
    }

    public boolean isDETag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDETag2Dirty();
        }
        return this.detag2DirtyFlag;
    }

    public void resetDETag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDETag2();
            return;
        }
        this.detag2DirtyFlag = false;
        this.detag2 = null;
    }

    public void setDetailParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDetailParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.detailparam = string;
        this.detailparamDirtyFlag = true;
    }

    public String getDetailParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDetailParam();
        }
        return this.detailparam;
    }

    public boolean isDetailParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDetailParamDirty();
        }
        return this.detailparamDirtyFlag;
    }

    public void resetDetailParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDetailParam();
            return;
        }
        this.detailparamDirtyFlag = false;
        this.detailparam = null;
    }

    public void setDetailParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDetailParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.detailparam2 = string;
        this.detailparam2DirtyFlag = true;
    }

    public String getDetailParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDetailParam2();
        }
        return this.detailparam2;
    }

    public boolean isDetailParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDetailParam2Dirty();
        }
        return this.detailparam2DirtyFlag;
    }

    public void resetDetailParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDetailParam2();
            return;
        }
        this.detailparam2DirtyFlag = false;
        this.detailparam2 = null;
    }

    public void setDetailTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDetailTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.detailtag = string;
        this.detailtagDirtyFlag = true;
    }

    public String getDetailTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDetailTag();
        }
        return this.detailtag;
    }

    public boolean isDetailTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDetailTagDirty();
        }
        return this.detailtagDirtyFlag;
    }

    public void resetDetailTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDetailTag();
            return;
        }
        this.detailtagDirtyFlag = false;
        this.detailtag = null;
    }

    public void setDetailTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDetailTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.detailtag2 = string;
        this.detailtag2DirtyFlag = true;
    }

    public String getDetailTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDetailTag2();
        }
        return this.detailtag2;
    }

    public boolean isDetailTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDetailTag2Dirty();
        }
        return this.detailtag2DirtyFlag;
    }

    public void resetDetailTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDetailTag2();
            return;
        }
        this.detailtag2DirtyFlag = false;
        this.detailtag2 = null;
    }

    public void setLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicname = string;
        this.logicnameDirtyFlag = true;
    }

    public String getLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicName();
        }
        return this.logicname;
    }

    public boolean isLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicNameDirty();
        }
        return this.logicnameDirtyFlag;
    }

    public void resetLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicName();
            return;
        }
        this.logicnameDirtyFlag = false;
        this.logicname = null;
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

    public void setModColor(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModColor(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modcolor = string;
        this.modcolorDirtyFlag = true;
    }

    public String getModColor() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModColor();
        }
        return this.modcolor;
    }

    public boolean isModColorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModColorDirty();
        }
        return this.modcolorDirtyFlag;
    }

    public void resetModColor() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModColor();
            return;
        }
        this.modcolorDirtyFlag = false;
        this.modcolor = null;
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

    public void setPSDEGroupDetailId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGroupDetailId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegroupdetailid = string;
        this.psdegroupdetailidDirtyFlag = true;
    }

    public String getPSDEGroupDetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGroupDetailId();
        }
        return this.psdegroupdetailid;
    }

    public boolean isPSDEGroupDetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGroupDetailIdDirty();
        }
        return this.psdegroupdetailidDirtyFlag;
    }

    public void resetPSDEGroupDetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGroupDetailId();
            return;
        }
        this.psdegroupdetailidDirtyFlag = false;
        this.psdegroupdetailid = null;
    }

    public void setPSDEGroupDetailName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGroupDetailName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegroupdetailname = string;
        this.psdegroupdetailnameDirtyFlag = true;
    }

    public String getPSDEGroupDetailName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGroupDetailName();
        }
        return this.psdegroupdetailname;
    }

    public boolean isPSDEGroupDetailNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGroupDetailNameDirty();
        }
        return this.psdegroupdetailnameDirtyFlag;
    }

    public void resetPSDEGroupDetailName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGroupDetailName();
            return;
        }
        this.psdegroupdetailnameDirtyFlag = false;
        this.psdegroupdetailname = null;
    }

    public void setPSDEGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegroupid = string;
        this.psdegroupidDirtyFlag = true;
    }

    public String getPSDEGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGroupId();
        }
        return this.psdegroupid;
    }

    public boolean isPSDEGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGroupIdDirty();
        }
        return this.psdegroupidDirtyFlag;
    }

    public void resetPSDEGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGroupId();
            return;
        }
        this.psdegroupidDirtyFlag = false;
        this.psdegroupid = null;
    }

    public void setPSDEGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegroupname = string;
        this.psdegroupnameDirtyFlag = true;
    }

    public String getPSDEGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGroupName();
        }
        return this.psdegroupname;
    }

    public boolean isPSDEGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGroupNameDirty();
        }
        return this.psdegroupnameDirtyFlag;
    }

    public void resetPSDEGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGroupName();
            return;
        }
        this.psdegroupnameDirtyFlag = false;
        this.psdegroupname = null;
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

    public void setPSModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodulename = string;
        this.psmodulenameDirtyFlag = true;
    }

    public String getPSModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleName();
        }
        return this.psmodulename;
    }

    public boolean isPSModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleNameDirty();
        }
        return this.psmodulenameDirtyFlag;
    }

    public void resetPSModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleName();
            return;
        }
        this.psmodulenameDirtyFlag = false;
        this.psmodulename = null;
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
        PSDEGroupDetailBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEGroupDetailBase pSDEGroupDetailBase) {
        pSDEGroupDetailBase.resetCodeName();
        pSDEGroupDetailBase.resetCodeName2();
        pSDEGroupDetailBase.resetColor();
        pSDEGroupDetailBase.resetCreateDate();
        pSDEGroupDetailBase.resetCreateMan();
        pSDEGroupDetailBase.resetData();
        pSDEGroupDetailBase.resetDETag();
        pSDEGroupDetailBase.resetDETag2();
        pSDEGroupDetailBase.resetDetailParam();
        pSDEGroupDetailBase.resetDetailParam2();
        pSDEGroupDetailBase.resetDetailTag();
        pSDEGroupDetailBase.resetDetailTag2();
        pSDEGroupDetailBase.resetLogicName();
        pSDEGroupDetailBase.resetMemo();
        pSDEGroupDetailBase.resetModColor();
        pSDEGroupDetailBase.resetOrderValue();
        pSDEGroupDetailBase.resetPSDEGroupDetailId();
        pSDEGroupDetailBase.resetPSDEGroupDetailName();
        pSDEGroupDetailBase.resetPSDEGroupId();
        pSDEGroupDetailBase.resetPSDEGroupName();
        pSDEGroupDetailBase.resetPSDEId();
        pSDEGroupDetailBase.resetPSDEName();
        pSDEGroupDetailBase.resetPSModuleName();
        pSDEGroupDetailBase.resetUpdateDate();
        pSDEGroupDetailBase.resetUpdateMan();
        pSDEGroupDetailBase.resetUserCat();
        pSDEGroupDetailBase.resetUserTag();
        pSDEGroupDetailBase.resetUserTag2();
        pSDEGroupDetailBase.resetUserTag3();
        pSDEGroupDetailBase.resetUserTag4();
        pSDEGroupDetailBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCodeName2Dirty()) {
            hashMap.put(FIELD_CODENAME2, this.getCodeName2());
        }
        if (!bl || this.isColorDirty()) {
            hashMap.put(FIELD_COLOR, this.getColor());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDataDirty()) {
            hashMap.put(FIELD_DATA, this.getData());
        }
        if (!bl || this.isDETagDirty()) {
            hashMap.put(FIELD_DETAG, this.getDETag());
        }
        if (!bl || this.isDETag2Dirty()) {
            hashMap.put(FIELD_DETAG2, this.getDETag2());
        }
        if (!bl || this.isDetailParamDirty()) {
            hashMap.put(FIELD_DETAILPARAM, this.getDetailParam());
        }
        if (!bl || this.isDetailParam2Dirty()) {
            hashMap.put(FIELD_DETAILPARAM2, this.getDetailParam2());
        }
        if (!bl || this.isDetailTagDirty()) {
            hashMap.put(FIELD_DETAILTAG, this.getDetailTag());
        }
        if (!bl || this.isDetailTag2Dirty()) {
            hashMap.put(FIELD_DETAILTAG2, this.getDetailTag2());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isModColorDirty()) {
            hashMap.put(FIELD_MODCOLOR, this.getModColor());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDEGroupDetailIdDirty()) {
            hashMap.put(FIELD_PSDEGROUPDETAILID, this.getPSDEGroupDetailId());
        }
        if (!bl || this.isPSDEGroupDetailNameDirty()) {
            hashMap.put(FIELD_PSDEGROUPDETAILNAME, this.getPSDEGroupDetailName());
        }
        if (!bl || this.isPSDEGroupIdDirty()) {
            hashMap.put(FIELD_PSDEGROUPID, this.getPSDEGroupId());
        }
        if (!bl || this.isPSDEGroupNameDirty()) {
            hashMap.put(FIELD_PSDEGROUPNAME, this.getPSDEGroupName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
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
        return PSDEGroupDetailBase.get(this, n);
    }

    private static Object get(PSDEGroupDetailBase pSDEGroupDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEGroupDetailBase.getCodeName();
            }
            case 1: {
                return pSDEGroupDetailBase.getCodeName2();
            }
            case 2: {
                return pSDEGroupDetailBase.getColor();
            }
            case 3: {
                return pSDEGroupDetailBase.getCreateDate();
            }
            case 4: {
                return pSDEGroupDetailBase.getCreateMan();
            }
            case 5: {
                return pSDEGroupDetailBase.getData();
            }
            case 6: {
                return pSDEGroupDetailBase.getDETag();
            }
            case 7: {
                return pSDEGroupDetailBase.getDETag2();
            }
            case 8: {
                return pSDEGroupDetailBase.getDetailParam();
            }
            case 9: {
                return pSDEGroupDetailBase.getDetailParam2();
            }
            case 10: {
                return pSDEGroupDetailBase.getDetailTag();
            }
            case 11: {
                return pSDEGroupDetailBase.getDetailTag2();
            }
            case 12: {
                return pSDEGroupDetailBase.getLogicName();
            }
            case 13: {
                return pSDEGroupDetailBase.getMemo();
            }
            case 14: {
                return pSDEGroupDetailBase.getModColor();
            }
            case 15: {
                return pSDEGroupDetailBase.getOrderValue();
            }
            case 16: {
                return pSDEGroupDetailBase.getPSDEGroupDetailId();
            }
            case 17: {
                return pSDEGroupDetailBase.getPSDEGroupDetailName();
            }
            case 18: {
                return pSDEGroupDetailBase.getPSDEGroupId();
            }
            case 19: {
                return pSDEGroupDetailBase.getPSDEGroupName();
            }
            case 20: {
                return pSDEGroupDetailBase.getPSDEId();
            }
            case 21: {
                return pSDEGroupDetailBase.getPSDEName();
            }
            case 22: {
                return pSDEGroupDetailBase.getPSModuleName();
            }
            case 23: {
                return pSDEGroupDetailBase.getUpdateDate();
            }
            case 24: {
                return pSDEGroupDetailBase.getUpdateMan();
            }
            case 25: {
                return pSDEGroupDetailBase.getUserCat();
            }
            case 26: {
                return pSDEGroupDetailBase.getUserTag();
            }
            case 27: {
                return pSDEGroupDetailBase.getUserTag2();
            }
            case 28: {
                return pSDEGroupDetailBase.getUserTag3();
            }
            case 29: {
                return pSDEGroupDetailBase.getUserTag4();
            }
            case 30: {
                return pSDEGroupDetailBase.getValidFlag();
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
        PSDEGroupDetailBase.set(this, n, object);
    }

    private static void set(PSDEGroupDetailBase pSDEGroupDetailBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEGroupDetailBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEGroupDetailBase.setCodeName2(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEGroupDetailBase.setColor(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEGroupDetailBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSDEGroupDetailBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEGroupDetailBase.setData(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEGroupDetailBase.setDETag(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEGroupDetailBase.setDETag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEGroupDetailBase.setDetailParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEGroupDetailBase.setDetailParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEGroupDetailBase.setDetailTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEGroupDetailBase.setDetailTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEGroupDetailBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEGroupDetailBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEGroupDetailBase.setModColor(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEGroupDetailBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDEGroupDetailBase.setPSDEGroupDetailId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEGroupDetailBase.setPSDEGroupDetailName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEGroupDetailBase.setPSDEGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEGroupDetailBase.setPSDEGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEGroupDetailBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEGroupDetailBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEGroupDetailBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEGroupDetailBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 24: {
                pSDEGroupDetailBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEGroupDetailBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEGroupDetailBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEGroupDetailBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEGroupDetailBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEGroupDetailBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEGroupDetailBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEGroupDetailBase.isNull(this, n);
    }

    private static boolean isNull(PSDEGroupDetailBase pSDEGroupDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEGroupDetailBase.getCodeName() == null;
            }
            case 1: {
                return pSDEGroupDetailBase.getCodeName2() == null;
            }
            case 2: {
                return pSDEGroupDetailBase.getColor() == null;
            }
            case 3: {
                return pSDEGroupDetailBase.getCreateDate() == null;
            }
            case 4: {
                return pSDEGroupDetailBase.getCreateMan() == null;
            }
            case 5: {
                return pSDEGroupDetailBase.getData() == null;
            }
            case 6: {
                return pSDEGroupDetailBase.getDETag() == null;
            }
            case 7: {
                return pSDEGroupDetailBase.getDETag2() == null;
            }
            case 8: {
                return pSDEGroupDetailBase.getDetailParam() == null;
            }
            case 9: {
                return pSDEGroupDetailBase.getDetailParam2() == null;
            }
            case 10: {
                return pSDEGroupDetailBase.getDetailTag() == null;
            }
            case 11: {
                return pSDEGroupDetailBase.getDetailTag2() == null;
            }
            case 12: {
                return pSDEGroupDetailBase.getLogicName() == null;
            }
            case 13: {
                return pSDEGroupDetailBase.getMemo() == null;
            }
            case 14: {
                return pSDEGroupDetailBase.getModColor() == null;
            }
            case 15: {
                return pSDEGroupDetailBase.getOrderValue() == null;
            }
            case 16: {
                return pSDEGroupDetailBase.getPSDEGroupDetailId() == null;
            }
            case 17: {
                return pSDEGroupDetailBase.getPSDEGroupDetailName() == null;
            }
            case 18: {
                return pSDEGroupDetailBase.getPSDEGroupId() == null;
            }
            case 19: {
                return pSDEGroupDetailBase.getPSDEGroupName() == null;
            }
            case 20: {
                return pSDEGroupDetailBase.getPSDEId() == null;
            }
            case 21: {
                return pSDEGroupDetailBase.getPSDEName() == null;
            }
            case 22: {
                return pSDEGroupDetailBase.getPSModuleName() == null;
            }
            case 23: {
                return pSDEGroupDetailBase.getUpdateDate() == null;
            }
            case 24: {
                return pSDEGroupDetailBase.getUpdateMan() == null;
            }
            case 25: {
                return pSDEGroupDetailBase.getUserCat() == null;
            }
            case 26: {
                return pSDEGroupDetailBase.getUserTag() == null;
            }
            case 27: {
                return pSDEGroupDetailBase.getUserTag2() == null;
            }
            case 28: {
                return pSDEGroupDetailBase.getUserTag3() == null;
            }
            case 29: {
                return pSDEGroupDetailBase.getUserTag4() == null;
            }
            case 30: {
                return pSDEGroupDetailBase.getValidFlag() == null;
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
        return PSDEGroupDetailBase.contains(this, n);
    }

    private static boolean contains(PSDEGroupDetailBase pSDEGroupDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEGroupDetailBase.isCodeNameDirty();
            }
            case 1: {
                return pSDEGroupDetailBase.isCodeName2Dirty();
            }
            case 2: {
                return pSDEGroupDetailBase.isColorDirty();
            }
            case 3: {
                return pSDEGroupDetailBase.isCreateDateDirty();
            }
            case 4: {
                return pSDEGroupDetailBase.isCreateManDirty();
            }
            case 5: {
                return pSDEGroupDetailBase.isDataDirty();
            }
            case 6: {
                return pSDEGroupDetailBase.isDETagDirty();
            }
            case 7: {
                return pSDEGroupDetailBase.isDETag2Dirty();
            }
            case 8: {
                return pSDEGroupDetailBase.isDetailParamDirty();
            }
            case 9: {
                return pSDEGroupDetailBase.isDetailParam2Dirty();
            }
            case 10: {
                return pSDEGroupDetailBase.isDetailTagDirty();
            }
            case 11: {
                return pSDEGroupDetailBase.isDetailTag2Dirty();
            }
            case 12: {
                return pSDEGroupDetailBase.isLogicNameDirty();
            }
            case 13: {
                return pSDEGroupDetailBase.isMemoDirty();
            }
            case 14: {
                return pSDEGroupDetailBase.isModColorDirty();
            }
            case 15: {
                return pSDEGroupDetailBase.isOrderValueDirty();
            }
            case 16: {
                return pSDEGroupDetailBase.isPSDEGroupDetailIdDirty();
            }
            case 17: {
                return pSDEGroupDetailBase.isPSDEGroupDetailNameDirty();
            }
            case 18: {
                return pSDEGroupDetailBase.isPSDEGroupIdDirty();
            }
            case 19: {
                return pSDEGroupDetailBase.isPSDEGroupNameDirty();
            }
            case 20: {
                return pSDEGroupDetailBase.isPSDEIdDirty();
            }
            case 21: {
                return pSDEGroupDetailBase.isPSDENameDirty();
            }
            case 22: {
                return pSDEGroupDetailBase.isPSModuleNameDirty();
            }
            case 23: {
                return pSDEGroupDetailBase.isUpdateDateDirty();
            }
            case 24: {
                return pSDEGroupDetailBase.isUpdateManDirty();
            }
            case 25: {
                return pSDEGroupDetailBase.isUserCatDirty();
            }
            case 26: {
                return pSDEGroupDetailBase.isUserTagDirty();
            }
            case 27: {
                return pSDEGroupDetailBase.isUserTag2Dirty();
            }
            case 28: {
                return pSDEGroupDetailBase.isUserTag3Dirty();
            }
            case 29: {
                return pSDEGroupDetailBase.isUserTag4Dirty();
            }
            case 30: {
                return pSDEGroupDetailBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEGroupDetailBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEGroupDetailBase pSDEGroupDetailBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEGroupDetailBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEGroupDetailBase.getJSONValue((Object)pSDEGroupDetailBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEGroupDetailBase.getCodeName2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename2", (Object)PSDEGroupDetailBase.getJSONValue((Object)pSDEGroupDetailBase.getCodeName2()), (boolean)false);
        }
        if (bl || pSDEGroupDetailBase.getColor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"color", (Object)PSDEGroupDetailBase.getJSONValue((Object)pSDEGroupDetailBase.getColor()), (boolean)false);
        }
        if (bl || pSDEGroupDetailBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEGroupDetailBase.getJSONValue((Object)pSDEGroupDetailBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEGroupDetailBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEGroupDetailBase.getJSONValue((Object)pSDEGroupDetailBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEGroupDetailBase.getData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"data", (Object)PSDEGroupDetailBase.getJSONValue((Object)pSDEGroupDetailBase.getData()), (boolean)false);
        }
        if (bl || pSDEGroupDetailBase.getDETag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detag", (Object)PSDEGroupDetailBase.getJSONValue((Object)pSDEGroupDetailBase.getDETag()), (boolean)false);
        }
        if (bl || pSDEGroupDetailBase.getDETag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detag2", (Object)PSDEGroupDetailBase.getJSONValue((Object)pSDEGroupDetailBase.getDETag2()), (boolean)false);
        }
        if (bl || pSDEGroupDetailBase.getDetailParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detailparam", (Object)PSDEGroupDetailBase.getJSONValue((Object)pSDEGroupDetailBase.getDetailParam()), (boolean)false);
        }
        if (bl || pSDEGroupDetailBase.getDetailParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detailparam2", (Object)PSDEGroupDetailBase.getJSONValue((Object)pSDEGroupDetailBase.getDetailParam2()), (boolean)false);
        }
        if (bl || pSDEGroupDetailBase.getDetailTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detailtag", (Object)PSDEGroupDetailBase.getJSONValue((Object)pSDEGroupDetailBase.getDetailTag()), (boolean)false);
        }
        if (bl || pSDEGroupDetailBase.getDetailTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detailtag2", (Object)PSDEGroupDetailBase.getJSONValue((Object)pSDEGroupDetailBase.getDetailTag2()), (boolean)false);
        }
        if (bl || pSDEGroupDetailBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSDEGroupDetailBase.getJSONValue((Object)pSDEGroupDetailBase.getLogicName()), (boolean)false);
        }
        if (bl || pSDEGroupDetailBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEGroupDetailBase.getJSONValue((Object)pSDEGroupDetailBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEGroupDetailBase.getModColor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modcolor", (Object)PSDEGroupDetailBase.getJSONValue((Object)pSDEGroupDetailBase.getModColor()), (boolean)false);
        }
        if (bl || pSDEGroupDetailBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEGroupDetailBase.getJSONValue((Object)pSDEGroupDetailBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEGroupDetailBase.getPSDEGroupDetailId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegroupdetailid", (Object)PSDEGroupDetailBase.getJSONValue((Object)pSDEGroupDetailBase.getPSDEGroupDetailId()), (boolean)false);
        }
        if (bl || pSDEGroupDetailBase.getPSDEGroupDetailName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegroupdetailname", (Object)PSDEGroupDetailBase.getJSONValue((Object)pSDEGroupDetailBase.getPSDEGroupDetailName()), (boolean)false);
        }
        if (bl || pSDEGroupDetailBase.getPSDEGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegroupid", (Object)PSDEGroupDetailBase.getJSONValue((Object)pSDEGroupDetailBase.getPSDEGroupId()), (boolean)false);
        }
        if (bl || pSDEGroupDetailBase.getPSDEGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegroupname", (Object)PSDEGroupDetailBase.getJSONValue((Object)pSDEGroupDetailBase.getPSDEGroupName()), (boolean)false);
        }
        if (bl || pSDEGroupDetailBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEGroupDetailBase.getJSONValue((Object)pSDEGroupDetailBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEGroupDetailBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEGroupDetailBase.getJSONValue((Object)pSDEGroupDetailBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEGroupDetailBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSDEGroupDetailBase.getJSONValue((Object)pSDEGroupDetailBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSDEGroupDetailBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEGroupDetailBase.getJSONValue((Object)pSDEGroupDetailBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEGroupDetailBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEGroupDetailBase.getJSONValue((Object)pSDEGroupDetailBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEGroupDetailBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEGroupDetailBase.getJSONValue((Object)pSDEGroupDetailBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEGroupDetailBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEGroupDetailBase.getJSONValue((Object)pSDEGroupDetailBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEGroupDetailBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEGroupDetailBase.getJSONValue((Object)pSDEGroupDetailBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEGroupDetailBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEGroupDetailBase.getJSONValue((Object)pSDEGroupDetailBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEGroupDetailBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEGroupDetailBase.getJSONValue((Object)pSDEGroupDetailBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEGroupDetailBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEGroupDetailBase.getJSONValue((Object)pSDEGroupDetailBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEGroupDetailBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEGroupDetailBase pSDEGroupDetailBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEGroupDetailBase.getCodeName() != null) {
            object = pSDEGroupDetailBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEGroupDetailBase.getCodeName2() != null) {
            object = pSDEGroupDetailBase.getCodeName2();
            xmlNode.setAttribute(FIELD_CODENAME2, (String)(object == null ? "" : object));
        }
        if (bl || pSDEGroupDetailBase.getColor() != null) {
            object = pSDEGroupDetailBase.getColor();
            xmlNode.setAttribute(FIELD_COLOR, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupDetailBase.getCreateDate() != null) {
            object = pSDEGroupDetailBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEGroupDetailBase.getCreateMan() != null) {
            object = pSDEGroupDetailBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupDetailBase.getData() != null) {
            object = pSDEGroupDetailBase.getData();
            xmlNode.setAttribute(FIELD_DATA, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupDetailBase.getDETag() != null) {
            object = pSDEGroupDetailBase.getDETag();
            xmlNode.setAttribute(FIELD_DETAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupDetailBase.getDETag2() != null) {
            object = pSDEGroupDetailBase.getDETag2();
            xmlNode.setAttribute(FIELD_DETAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupDetailBase.getDetailParam() != null) {
            object = pSDEGroupDetailBase.getDetailParam();
            xmlNode.setAttribute(FIELD_DETAILPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupDetailBase.getDetailParam2() != null) {
            object = pSDEGroupDetailBase.getDetailParam2();
            xmlNode.setAttribute(FIELD_DETAILPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupDetailBase.getDetailTag() != null) {
            object = pSDEGroupDetailBase.getDetailTag();
            xmlNode.setAttribute(FIELD_DETAILTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupDetailBase.getDetailTag2() != null) {
            object = pSDEGroupDetailBase.getDetailTag2();
            xmlNode.setAttribute(FIELD_DETAILTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupDetailBase.getLogicName() != null) {
            object = pSDEGroupDetailBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupDetailBase.getMemo() != null) {
            object = pSDEGroupDetailBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupDetailBase.getModColor() != null) {
            object = pSDEGroupDetailBase.getModColor();
            xmlNode.setAttribute(FIELD_MODCOLOR, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupDetailBase.getOrderValue() != null) {
            object = pSDEGroupDetailBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGroupDetailBase.getPSDEGroupDetailId() != null) {
            object = pSDEGroupDetailBase.getPSDEGroupDetailId();
            xmlNode.setAttribute(FIELD_PSDEGROUPDETAILID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupDetailBase.getPSDEGroupDetailName() != null) {
            object = pSDEGroupDetailBase.getPSDEGroupDetailName();
            xmlNode.setAttribute(FIELD_PSDEGROUPDETAILNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupDetailBase.getPSDEGroupId() != null) {
            object = pSDEGroupDetailBase.getPSDEGroupId();
            xmlNode.setAttribute(FIELD_PSDEGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupDetailBase.getPSDEGroupName() != null) {
            object = pSDEGroupDetailBase.getPSDEGroupName();
            xmlNode.setAttribute(FIELD_PSDEGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupDetailBase.getPSDEId() != null) {
            object = pSDEGroupDetailBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupDetailBase.getPSDEName() != null) {
            object = pSDEGroupDetailBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupDetailBase.getPSModuleName() != null) {
            object = pSDEGroupDetailBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupDetailBase.getUpdateDate() != null) {
            object = pSDEGroupDetailBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEGroupDetailBase.getUpdateMan() != null) {
            object = pSDEGroupDetailBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupDetailBase.getUserCat() != null) {
            object = pSDEGroupDetailBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupDetailBase.getUserTag() != null) {
            object = pSDEGroupDetailBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupDetailBase.getUserTag2() != null) {
            object = pSDEGroupDetailBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupDetailBase.getUserTag3() != null) {
            object = pSDEGroupDetailBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupDetailBase.getUserTag4() != null) {
            object = pSDEGroupDetailBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEGroupDetailBase.getValidFlag() != null) {
            object = pSDEGroupDetailBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEGroupDetailBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEGroupDetailBase pSDEGroupDetailBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEGroupDetailBase.isCodeNameDirty() && (bl || pSDEGroupDetailBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEGroupDetailBase.getCodeName());
        }
        if (pSDEGroupDetailBase.isCodeName2Dirty() && (bl || pSDEGroupDetailBase.getCodeName2() != null)) {
            iDataObject.set(FIELD_CODENAME2, (Object)pSDEGroupDetailBase.getCodeName2());
        }
        if (pSDEGroupDetailBase.isColorDirty() && (bl || pSDEGroupDetailBase.getColor() != null)) {
            iDataObject.set(FIELD_COLOR, (Object)pSDEGroupDetailBase.getColor());
        }
        if (pSDEGroupDetailBase.isCreateDateDirty() && (bl || pSDEGroupDetailBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEGroupDetailBase.getCreateDate());
        }
        if (pSDEGroupDetailBase.isCreateManDirty() && (bl || pSDEGroupDetailBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEGroupDetailBase.getCreateMan());
        }
        if (pSDEGroupDetailBase.isDataDirty() && (bl || pSDEGroupDetailBase.getData() != null)) {
            iDataObject.set(FIELD_DATA, (Object)pSDEGroupDetailBase.getData());
        }
        if (pSDEGroupDetailBase.isDETagDirty() && (bl || pSDEGroupDetailBase.getDETag() != null)) {
            iDataObject.set(FIELD_DETAG, (Object)pSDEGroupDetailBase.getDETag());
        }
        if (pSDEGroupDetailBase.isDETag2Dirty() && (bl || pSDEGroupDetailBase.getDETag2() != null)) {
            iDataObject.set(FIELD_DETAG2, (Object)pSDEGroupDetailBase.getDETag2());
        }
        if (pSDEGroupDetailBase.isDetailParamDirty() && (bl || pSDEGroupDetailBase.getDetailParam() != null)) {
            iDataObject.set(FIELD_DETAILPARAM, (Object)pSDEGroupDetailBase.getDetailParam());
        }
        if (pSDEGroupDetailBase.isDetailParam2Dirty() && (bl || pSDEGroupDetailBase.getDetailParam2() != null)) {
            iDataObject.set(FIELD_DETAILPARAM2, (Object)pSDEGroupDetailBase.getDetailParam2());
        }
        if (pSDEGroupDetailBase.isDetailTagDirty() && (bl || pSDEGroupDetailBase.getDetailTag() != null)) {
            iDataObject.set(FIELD_DETAILTAG, (Object)pSDEGroupDetailBase.getDetailTag());
        }
        if (pSDEGroupDetailBase.isDetailTag2Dirty() && (bl || pSDEGroupDetailBase.getDetailTag2() != null)) {
            iDataObject.set(FIELD_DETAILTAG2, (Object)pSDEGroupDetailBase.getDetailTag2());
        }
        if (pSDEGroupDetailBase.isLogicNameDirty() && (bl || pSDEGroupDetailBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSDEGroupDetailBase.getLogicName());
        }
        if (pSDEGroupDetailBase.isMemoDirty() && (bl || pSDEGroupDetailBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEGroupDetailBase.getMemo());
        }
        if (pSDEGroupDetailBase.isModColorDirty() && (bl || pSDEGroupDetailBase.getModColor() != null)) {
            iDataObject.set(FIELD_MODCOLOR, (Object)pSDEGroupDetailBase.getModColor());
        }
        if (pSDEGroupDetailBase.isOrderValueDirty() && (bl || pSDEGroupDetailBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEGroupDetailBase.getOrderValue());
        }
        if (pSDEGroupDetailBase.isPSDEGroupDetailIdDirty() && (bl || pSDEGroupDetailBase.getPSDEGroupDetailId() != null)) {
            iDataObject.set(FIELD_PSDEGROUPDETAILID, (Object)pSDEGroupDetailBase.getPSDEGroupDetailId());
        }
        if (pSDEGroupDetailBase.isPSDEGroupDetailNameDirty() && (bl || pSDEGroupDetailBase.getPSDEGroupDetailName() != null)) {
            iDataObject.set(FIELD_PSDEGROUPDETAILNAME, (Object)pSDEGroupDetailBase.getPSDEGroupDetailName());
        }
        if (pSDEGroupDetailBase.isPSDEGroupIdDirty() && (bl || pSDEGroupDetailBase.getPSDEGroupId() != null)) {
            iDataObject.set(FIELD_PSDEGROUPID, (Object)pSDEGroupDetailBase.getPSDEGroupId());
        }
        if (pSDEGroupDetailBase.isPSDEGroupNameDirty() && (bl || pSDEGroupDetailBase.getPSDEGroupName() != null)) {
            iDataObject.set(FIELD_PSDEGROUPNAME, (Object)pSDEGroupDetailBase.getPSDEGroupName());
        }
        if (pSDEGroupDetailBase.isPSDEIdDirty() && (bl || pSDEGroupDetailBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEGroupDetailBase.getPSDEId());
        }
        if (pSDEGroupDetailBase.isPSDENameDirty() && (bl || pSDEGroupDetailBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEGroupDetailBase.getPSDEName());
        }
        if (pSDEGroupDetailBase.isPSModuleNameDirty() && (bl || pSDEGroupDetailBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSDEGroupDetailBase.getPSModuleName());
        }
        if (pSDEGroupDetailBase.isUpdateDateDirty() && (bl || pSDEGroupDetailBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEGroupDetailBase.getUpdateDate());
        }
        if (pSDEGroupDetailBase.isUpdateManDirty() && (bl || pSDEGroupDetailBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEGroupDetailBase.getUpdateMan());
        }
        if (pSDEGroupDetailBase.isUserCatDirty() && (bl || pSDEGroupDetailBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEGroupDetailBase.getUserCat());
        }
        if (pSDEGroupDetailBase.isUserTagDirty() && (bl || pSDEGroupDetailBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEGroupDetailBase.getUserTag());
        }
        if (pSDEGroupDetailBase.isUserTag2Dirty() && (bl || pSDEGroupDetailBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEGroupDetailBase.getUserTag2());
        }
        if (pSDEGroupDetailBase.isUserTag3Dirty() && (bl || pSDEGroupDetailBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEGroupDetailBase.getUserTag3());
        }
        if (pSDEGroupDetailBase.isUserTag4Dirty() && (bl || pSDEGroupDetailBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEGroupDetailBase.getUserTag4());
        }
        if (pSDEGroupDetailBase.isValidFlagDirty() && (bl || pSDEGroupDetailBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEGroupDetailBase.getValidFlag());
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
        return PSDEGroupDetailBase.remove(this, n);
    }

    private static boolean remove(PSDEGroupDetailBase pSDEGroupDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEGroupDetailBase.resetCodeName();
                return true;
            }
            case 1: {
                pSDEGroupDetailBase.resetCodeName2();
                return true;
            }
            case 2: {
                pSDEGroupDetailBase.resetColor();
                return true;
            }
            case 3: {
                pSDEGroupDetailBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSDEGroupDetailBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSDEGroupDetailBase.resetData();
                return true;
            }
            case 6: {
                pSDEGroupDetailBase.resetDETag();
                return true;
            }
            case 7: {
                pSDEGroupDetailBase.resetDETag2();
                return true;
            }
            case 8: {
                pSDEGroupDetailBase.resetDetailParam();
                return true;
            }
            case 9: {
                pSDEGroupDetailBase.resetDetailParam2();
                return true;
            }
            case 10: {
                pSDEGroupDetailBase.resetDetailTag();
                return true;
            }
            case 11: {
                pSDEGroupDetailBase.resetDetailTag2();
                return true;
            }
            case 12: {
                pSDEGroupDetailBase.resetLogicName();
                return true;
            }
            case 13: {
                pSDEGroupDetailBase.resetMemo();
                return true;
            }
            case 14: {
                pSDEGroupDetailBase.resetModColor();
                return true;
            }
            case 15: {
                pSDEGroupDetailBase.resetOrderValue();
                return true;
            }
            case 16: {
                pSDEGroupDetailBase.resetPSDEGroupDetailId();
                return true;
            }
            case 17: {
                pSDEGroupDetailBase.resetPSDEGroupDetailName();
                return true;
            }
            case 18: {
                pSDEGroupDetailBase.resetPSDEGroupId();
                return true;
            }
            case 19: {
                pSDEGroupDetailBase.resetPSDEGroupName();
                return true;
            }
            case 20: {
                pSDEGroupDetailBase.resetPSDEId();
                return true;
            }
            case 21: {
                pSDEGroupDetailBase.resetPSDEName();
                return true;
            }
            case 22: {
                pSDEGroupDetailBase.resetPSModuleName();
                return true;
            }
            case 23: {
                pSDEGroupDetailBase.resetUpdateDate();
                return true;
            }
            case 24: {
                pSDEGroupDetailBase.resetUpdateMan();
                return true;
            }
            case 25: {
                pSDEGroupDetailBase.resetUserCat();
                return true;
            }
            case 26: {
                pSDEGroupDetailBase.resetUserTag();
                return true;
            }
            case 27: {
                pSDEGroupDetailBase.resetUserTag2();
                return true;
            }
            case 28: {
                pSDEGroupDetailBase.resetUserTag3();
                return true;
            }
            case 29: {
                pSDEGroupDetailBase.resetUserTag4();
                return true;
            }
            case 30: {
                pSDEGroupDetailBase.resetValidFlag();
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
                pSDataEntityService.autoGet(pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEGroup getPSDEGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGroup();
        }
        if (this.getPSDEGroupId() == null) {
            return null;
        }
        Integer n = this.objPSDEGroupLock;
        synchronized (n) {
            if (this.psdegroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEGroupId(), (Object)this.psdegroup.getPSDEGroupId()) != 0L) {
                this.psdegroup = null;
            }
            if (this.psdegroup == null) {
                PSDEGroup pSDEGroup = new PSDEGroup();
                pSDEGroup.setPSDEGroupId(this.getPSDEGroupId());
                PSDEGroupService pSDEGroupService = (PSDEGroupService)ServiceGlobal.getService(PSDEGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEGroupService.autoGet(pSDEGroup);
                this.psdegroup = pSDEGroup;
            }
            return this.psdegroup;
        }
    }

    private PSDEGroupDetailBase getProxyEntity() {
        return this.proxyPSDEGroupDetailBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEGroupDetailBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEGroupDetailBase) {
            this.proxyPSDEGroupDetailBase = (PSDEGroupDetailBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEGroupDetailService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CODENAME2, 1);
        fieldIndexMap.put(FIELD_COLOR, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_DATA, 5);
        fieldIndexMap.put(FIELD_DETAG, 6);
        fieldIndexMap.put(FIELD_DETAG2, 7);
        fieldIndexMap.put(FIELD_DETAILPARAM, 8);
        fieldIndexMap.put(FIELD_DETAILPARAM2, 9);
        fieldIndexMap.put(FIELD_DETAILTAG, 10);
        fieldIndexMap.put(FIELD_DETAILTAG2, 11);
        fieldIndexMap.put(FIELD_LOGICNAME, 12);
        fieldIndexMap.put(FIELD_MEMO, 13);
        fieldIndexMap.put(FIELD_MODCOLOR, 14);
        fieldIndexMap.put(FIELD_ORDERVALUE, 15);
        fieldIndexMap.put(FIELD_PSDEGROUPDETAILID, 16);
        fieldIndexMap.put(FIELD_PSDEGROUPDETAILNAME, 17);
        fieldIndexMap.put(FIELD_PSDEGROUPID, 18);
        fieldIndexMap.put(FIELD_PSDEGROUPNAME, 19);
        fieldIndexMap.put(FIELD_PSDEID, 20);
        fieldIndexMap.put(FIELD_PSDENAME, 21);
        fieldIndexMap.put(FIELD_PSMODULENAME, 22);
        fieldIndexMap.put(FIELD_UPDATEDATE, 23);
        fieldIndexMap.put(FIELD_UPDATEMAN, 24);
        fieldIndexMap.put(FIELD_USERCAT, 25);
        fieldIndexMap.put(FIELD_USERTAG, 26);
        fieldIndexMap.put(FIELD_USERTAG2, 27);
        fieldIndexMap.put(FIELD_USERTAG3, 28);
        fieldIndexMap.put(FIELD_USERTAG4, 29);
        fieldIndexMap.put(FIELD_VALIDFLAG, 30);
    }
}

