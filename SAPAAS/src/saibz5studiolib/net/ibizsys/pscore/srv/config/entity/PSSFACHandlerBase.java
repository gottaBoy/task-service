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
package net.ibizsys.pscore.srv.config.entity;

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
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.entity.PSSysACHandler;
import net.ibizsys.pscore.srv.config.service.PSSFService;
import net.ibizsys.pscore.srv.config.service.PSSysACHandlerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFACHandlerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSFACHandlerBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CTRLTYPE = "CTRLTYPE";
    public static final String FIELD_HANDLEROBJ = "HANDLEROBJ";
    public static final String FIELD_HANDLEROBJ2 = "HANDLEROBJ2";
    public static final String FIELD_HANDLEROBJ3 = "HANDLEROBJ3";
    public static final String FIELD_HANDLEROBJ4 = "HANDLEROBJ4";
    public static final String FIELD_JITCTRLOBJ = "JITCTRLOBJ";
    public static final String FIELD_JITCTRLOBJ2 = "JITCTRLOBJ2";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSFACHANDLERID = "PSSFACHANDLERID";
    public static final String FIELD_PSSFACHANDLERNAME = "PSSFACHANDLERNAME";
    public static final String FIELD_PSSFID = "PSSFID";
    public static final String FIELD_PSSFNAME = "PSSFNAME";
    public static final String FIELD_PSSYSACHANDLERID = "PSSYSACHANDLERID";
    public static final String FIELD_PSSYSACHANDLERNAME = "PSSYSACHANDLERNAME";
    public static final String FIELD_TEMPMODE = "TEMPMODE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_CTRLTYPE = 2;
    private static final int INDEX_HANDLEROBJ = 3;
    private static final int INDEX_HANDLEROBJ2 = 4;
    private static final int INDEX_HANDLEROBJ3 = 5;
    private static final int INDEX_HANDLEROBJ4 = 6;
    private static final int INDEX_JITCTRLOBJ = 7;
    private static final int INDEX_JITCTRLOBJ2 = 8;
    private static final int INDEX_MEMO = 9;
    private static final int INDEX_PSSFACHANDLERID = 10;
    private static final int INDEX_PSSFACHANDLERNAME = 11;
    private static final int INDEX_PSSFID = 12;
    private static final int INDEX_PSSFNAME = 13;
    private static final int INDEX_PSSYSACHANDLERID = 14;
    private static final int INDEX_PSSYSACHANDLERNAME = 15;
    private static final int INDEX_TEMPMODE = 16;
    private static final int INDEX_UPDATEDATE = 17;
    private static final int INDEX_UPDATEMAN = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSFACHandlerBase proxyPSSFACHandlerBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ctrltypeDirtyFlag = false;
    private boolean handlerobjDirtyFlag = false;
    private boolean handlerobj2DirtyFlag = false;
    private boolean handlerobj3DirtyFlag = false;
    private boolean handlerobj4DirtyFlag = false;
    private boolean jitctrlobjDirtyFlag = false;
    private boolean jitctrlobj2DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssfachandleridDirtyFlag = false;
    private boolean pssfachandlernameDirtyFlag = false;
    private boolean pssfidDirtyFlag = false;
    private boolean pssfnameDirtyFlag = false;
    private boolean pssysachandleridDirtyFlag = false;
    private boolean pssysachandlernameDirtyFlag = false;
    private boolean tempmodeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="ctrltype")
    private String ctrltype;
    @Column(name="handlerobj")
    private String handlerobj;
    @Column(name="handlerobj2")
    private String handlerobj2;
    @Column(name="handlerobj3")
    private String handlerobj3;
    @Column(name="handlerobj4")
    private String handlerobj4;
    @Column(name="jitctrlobj")
    private String jitctrlobj;
    @Column(name="jitctrlobj2")
    private String jitctrlobj2;
    @Column(name="memo")
    private String memo;
    @Column(name="pssfachandlerid")
    private String pssfachandlerid;
    @Column(name="pssfachandlername")
    private String pssfachandlername;
    @Column(name="pssfid")
    private String pssfid;
    @Column(name="pssfname")
    private String pssfname;
    @Column(name="pssysachandlerid")
    private String pssysachandlerid;
    @Column(name="pssysachandlername")
    private String pssysachandlername;
    @Column(name="tempmode")
    private Integer tempmode;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSSFLock = new Integer(1);
    private PSSF pssf = null;
    private Integer objPssysachandlerLock = new Integer(1);
    private PSSysACHandler pssysachandler = null;

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

    public void setCtrlType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrltype = string;
        this.ctrltypeDirtyFlag = true;
    }

    public String getCtrlType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlType();
        }
        return this.ctrltype;
    }

    public boolean isCtrlTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlTypeDirty();
        }
        return this.ctrltypeDirtyFlag;
    }

    public void resetCtrlType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlType();
            return;
        }
        this.ctrltypeDirtyFlag = false;
        this.ctrltype = null;
    }

    public void setHandlerObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHandlerObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.handlerobj = string;
        this.handlerobjDirtyFlag = true;
    }

    public String getHandlerObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHandlerObj();
        }
        return this.handlerobj;
    }

    public boolean isHandlerObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHandlerObjDirty();
        }
        return this.handlerobjDirtyFlag;
    }

    public void resetHandlerObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHandlerObj();
            return;
        }
        this.handlerobjDirtyFlag = false;
        this.handlerobj = null;
    }

    public void setHandlerObj2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHandlerObj2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.handlerobj2 = string;
        this.handlerobj2DirtyFlag = true;
    }

    public String getHandlerObj2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHandlerObj2();
        }
        return this.handlerobj2;
    }

    public boolean isHandlerObj2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHandlerObj2Dirty();
        }
        return this.handlerobj2DirtyFlag;
    }

    public void resetHandlerObj2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHandlerObj2();
            return;
        }
        this.handlerobj2DirtyFlag = false;
        this.handlerobj2 = null;
    }

    public void setHandlerObj3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHandlerObj3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.handlerobj3 = string;
        this.handlerobj3DirtyFlag = true;
    }

    public String getHandlerObj3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHandlerObj3();
        }
        return this.handlerobj3;
    }

    public boolean isHandlerObj3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHandlerObj3Dirty();
        }
        return this.handlerobj3DirtyFlag;
    }

    public void resetHandlerObj3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHandlerObj3();
            return;
        }
        this.handlerobj3DirtyFlag = false;
        this.handlerobj3 = null;
    }

    public void setHandlerObj4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHandlerObj4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.handlerobj4 = string;
        this.handlerobj4DirtyFlag = true;
    }

    public String getHandlerObj4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHandlerObj4();
        }
        return this.handlerobj4;
    }

    public boolean isHandlerObj4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHandlerObj4Dirty();
        }
        return this.handlerobj4DirtyFlag;
    }

    public void resetHandlerObj4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHandlerObj4();
            return;
        }
        this.handlerobj4DirtyFlag = false;
        this.handlerobj4 = null;
    }

    public void setJITCtrlObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJITCtrlObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.jitctrlobj = string;
        this.jitctrlobjDirtyFlag = true;
    }

    public String getJITCtrlObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJITCtrlObj();
        }
        return this.jitctrlobj;
    }

    public boolean isJITCtrlObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJITCtrlObjDirty();
        }
        return this.jitctrlobjDirtyFlag;
    }

    public void resetJITCtrlObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJITCtrlObj();
            return;
        }
        this.jitctrlobjDirtyFlag = false;
        this.jitctrlobj = null;
    }

    public void setJITCtrlObj2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJITCtrlObj2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.jitctrlobj2 = string;
        this.jitctrlobj2DirtyFlag = true;
    }

    public String getJITCtrlObj2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJITCtrlObj2();
        }
        return this.jitctrlobj2;
    }

    public boolean isJITCtrlObj2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJITCtrlObj2Dirty();
        }
        return this.jitctrlobj2DirtyFlag;
    }

    public void resetJITCtrlObj2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJITCtrlObj2();
            return;
        }
        this.jitctrlobj2DirtyFlag = false;
        this.jitctrlobj2 = null;
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

    public void setPSSFACHandlerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFACHandlerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfachandlerid = string;
        this.pssfachandleridDirtyFlag = true;
    }

    public String getPSSFACHandlerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFACHandlerId();
        }
        return this.pssfachandlerid;
    }

    public boolean isPSSFACHandlerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFACHandlerIdDirty();
        }
        return this.pssfachandleridDirtyFlag;
    }

    public void resetPSSFACHandlerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFACHandlerId();
            return;
        }
        this.pssfachandleridDirtyFlag = false;
        this.pssfachandlerid = null;
    }

    public void setPSSFACHandlerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFACHandlerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfachandlername = string;
        this.pssfachandlernameDirtyFlag = true;
    }

    public String getPSSFACHandlerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFACHandlerName();
        }
        return this.pssfachandlername;
    }

    public boolean isPSSFACHandlerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFACHandlerNameDirty();
        }
        return this.pssfachandlernameDirtyFlag;
    }

    public void resetPSSFACHandlerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFACHandlerName();
            return;
        }
        this.pssfachandlernameDirtyFlag = false;
        this.pssfachandlername = null;
    }

    public void setPSSFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfid = string;
        this.pssfidDirtyFlag = true;
    }

    public String getPSSFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFId();
        }
        return this.pssfid;
    }

    public boolean isPSSFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFIdDirty();
        }
        return this.pssfidDirtyFlag;
    }

    public void resetPSSFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFId();
            return;
        }
        this.pssfidDirtyFlag = false;
        this.pssfid = null;
    }

    public void setPSSFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfname = string;
        this.pssfnameDirtyFlag = true;
    }

    public String getPSSFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFName();
        }
        return this.pssfname;
    }

    public boolean isPSSFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFNameDirty();
        }
        return this.pssfnameDirtyFlag;
    }

    public void resetPSSFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFName();
            return;
        }
        this.pssfnameDirtyFlag = false;
        this.pssfname = null;
    }

    public void setPSSysACHandlerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysACHandlerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysachandlerid = string;
        this.pssysachandleridDirtyFlag = true;
    }

    public String getPSSysACHandlerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysACHandlerId();
        }
        return this.pssysachandlerid;
    }

    public boolean isPSSysACHandlerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysACHandlerIdDirty();
        }
        return this.pssysachandleridDirtyFlag;
    }

    public void resetPSSysACHandlerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysACHandlerId();
            return;
        }
        this.pssysachandleridDirtyFlag = false;
        this.pssysachandlerid = null;
    }

    public void setPSSysACHandlerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysACHandlerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysachandlername = string;
        this.pssysachandlernameDirtyFlag = true;
    }

    public String getPSSysACHandlerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysACHandlerName();
        }
        return this.pssysachandlername;
    }

    public boolean isPSSysACHandlerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysACHandlerNameDirty();
        }
        return this.pssysachandlernameDirtyFlag;
    }

    public void resetPSSysACHandlerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysACHandlerName();
            return;
        }
        this.pssysachandlernameDirtyFlag = false;
        this.pssysachandlername = null;
    }

    public void setTempMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTempMode(n);
            return;
        }
        this.tempmode = n;
        this.tempmodeDirtyFlag = true;
    }

    public Integer getTempMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTempMode();
        }
        return this.tempmode;
    }

    public boolean isTempModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTempModeDirty();
        }
        return this.tempmodeDirtyFlag;
    }

    public void resetTempMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTempMode();
            return;
        }
        this.tempmodeDirtyFlag = false;
        this.tempmode = null;
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

    protected void onReset() {
        PSSFACHandlerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSFACHandlerBase pSSFACHandlerBase) {
        pSSFACHandlerBase.resetCreateDate();
        pSSFACHandlerBase.resetCreateMan();
        pSSFACHandlerBase.resetCtrlType();
        pSSFACHandlerBase.resetHandlerObj();
        pSSFACHandlerBase.resetHandlerObj2();
        pSSFACHandlerBase.resetHandlerObj3();
        pSSFACHandlerBase.resetHandlerObj4();
        pSSFACHandlerBase.resetJITCtrlObj();
        pSSFACHandlerBase.resetJITCtrlObj2();
        pSSFACHandlerBase.resetMemo();
        pSSFACHandlerBase.resetPSSFACHandlerId();
        pSSFACHandlerBase.resetPSSFACHandlerName();
        pSSFACHandlerBase.resetPSSFId();
        pSSFACHandlerBase.resetPSSFName();
        pSSFACHandlerBase.resetPSSysACHandlerId();
        pSSFACHandlerBase.resetPSSysACHandlerName();
        pSSFACHandlerBase.resetTempMode();
        pSSFACHandlerBase.resetUpdateDate();
        pSSFACHandlerBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCtrlTypeDirty()) {
            hashMap.put(FIELD_CTRLTYPE, this.getCtrlType());
        }
        if (!bl || this.isHandlerObjDirty()) {
            hashMap.put(FIELD_HANDLEROBJ, this.getHandlerObj());
        }
        if (!bl || this.isHandlerObj2Dirty()) {
            hashMap.put(FIELD_HANDLEROBJ2, this.getHandlerObj2());
        }
        if (!bl || this.isHandlerObj3Dirty()) {
            hashMap.put(FIELD_HANDLEROBJ3, this.getHandlerObj3());
        }
        if (!bl || this.isHandlerObj4Dirty()) {
            hashMap.put(FIELD_HANDLEROBJ4, this.getHandlerObj4());
        }
        if (!bl || this.isJITCtrlObjDirty()) {
            hashMap.put(FIELD_JITCTRLOBJ, this.getJITCtrlObj());
        }
        if (!bl || this.isJITCtrlObj2Dirty()) {
            hashMap.put(FIELD_JITCTRLOBJ2, this.getJITCtrlObj2());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSSFACHandlerIdDirty()) {
            hashMap.put(FIELD_PSSFACHANDLERID, this.getPSSFACHandlerId());
        }
        if (!bl || this.isPSSFACHandlerNameDirty()) {
            hashMap.put(FIELD_PSSFACHANDLERNAME, this.getPSSFACHandlerName());
        }
        if (!bl || this.isPSSFIdDirty()) {
            hashMap.put(FIELD_PSSFID, this.getPSSFId());
        }
        if (!bl || this.isPSSFNameDirty()) {
            hashMap.put(FIELD_PSSFNAME, this.getPSSFName());
        }
        if (!bl || this.isPSSysACHandlerIdDirty()) {
            hashMap.put(FIELD_PSSYSACHANDLERID, this.getPSSysACHandlerId());
        }
        if (!bl || this.isPSSysACHandlerNameDirty()) {
            hashMap.put(FIELD_PSSYSACHANDLERNAME, this.getPSSysACHandlerName());
        }
        if (!bl || this.isTempModeDirty()) {
            hashMap.put(FIELD_TEMPMODE, this.getTempMode());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSSFACHandlerBase.get(this, n);
    }

    private static Object get(PSSFACHandlerBase pSSFACHandlerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFACHandlerBase.getCreateDate();
            }
            case 1: {
                return pSSFACHandlerBase.getCreateMan();
            }
            case 2: {
                return pSSFACHandlerBase.getCtrlType();
            }
            case 3: {
                return pSSFACHandlerBase.getHandlerObj();
            }
            case 4: {
                return pSSFACHandlerBase.getHandlerObj2();
            }
            case 5: {
                return pSSFACHandlerBase.getHandlerObj3();
            }
            case 6: {
                return pSSFACHandlerBase.getHandlerObj4();
            }
            case 7: {
                return pSSFACHandlerBase.getJITCtrlObj();
            }
            case 8: {
                return pSSFACHandlerBase.getJITCtrlObj2();
            }
            case 9: {
                return pSSFACHandlerBase.getMemo();
            }
            case 10: {
                return pSSFACHandlerBase.getPSSFACHandlerId();
            }
            case 11: {
                return pSSFACHandlerBase.getPSSFACHandlerName();
            }
            case 12: {
                return pSSFACHandlerBase.getPSSFId();
            }
            case 13: {
                return pSSFACHandlerBase.getPSSFName();
            }
            case 14: {
                return pSSFACHandlerBase.getPSSysACHandlerId();
            }
            case 15: {
                return pSSFACHandlerBase.getPSSysACHandlerName();
            }
            case 16: {
                return pSSFACHandlerBase.getTempMode();
            }
            case 17: {
                return pSSFACHandlerBase.getUpdateDate();
            }
            case 18: {
                return pSSFACHandlerBase.getUpdateMan();
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
        PSSFACHandlerBase.set(this, n, object);
    }

    private static void set(PSSFACHandlerBase pSSFACHandlerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSFACHandlerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSFACHandlerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSFACHandlerBase.setCtrlType(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSFACHandlerBase.setHandlerObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSFACHandlerBase.setHandlerObj2(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSFACHandlerBase.setHandlerObj3(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSFACHandlerBase.setHandlerObj4(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSFACHandlerBase.setJITCtrlObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSFACHandlerBase.setJITCtrlObj2(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSFACHandlerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSFACHandlerBase.setPSSFACHandlerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSFACHandlerBase.setPSSFACHandlerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSFACHandlerBase.setPSSFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSFACHandlerBase.setPSSFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSFACHandlerBase.setPSSysACHandlerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSFACHandlerBase.setPSSysACHandlerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSFACHandlerBase.setTempMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSSFACHandlerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 18: {
                pSSFACHandlerBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSFACHandlerBase.isNull(this, n);
    }

    private static boolean isNull(PSSFACHandlerBase pSSFACHandlerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFACHandlerBase.getCreateDate() == null;
            }
            case 1: {
                return pSSFACHandlerBase.getCreateMan() == null;
            }
            case 2: {
                return pSSFACHandlerBase.getCtrlType() == null;
            }
            case 3: {
                return pSSFACHandlerBase.getHandlerObj() == null;
            }
            case 4: {
                return pSSFACHandlerBase.getHandlerObj2() == null;
            }
            case 5: {
                return pSSFACHandlerBase.getHandlerObj3() == null;
            }
            case 6: {
                return pSSFACHandlerBase.getHandlerObj4() == null;
            }
            case 7: {
                return pSSFACHandlerBase.getJITCtrlObj() == null;
            }
            case 8: {
                return pSSFACHandlerBase.getJITCtrlObj2() == null;
            }
            case 9: {
                return pSSFACHandlerBase.getMemo() == null;
            }
            case 10: {
                return pSSFACHandlerBase.getPSSFACHandlerId() == null;
            }
            case 11: {
                return pSSFACHandlerBase.getPSSFACHandlerName() == null;
            }
            case 12: {
                return pSSFACHandlerBase.getPSSFId() == null;
            }
            case 13: {
                return pSSFACHandlerBase.getPSSFName() == null;
            }
            case 14: {
                return pSSFACHandlerBase.getPSSysACHandlerId() == null;
            }
            case 15: {
                return pSSFACHandlerBase.getPSSysACHandlerName() == null;
            }
            case 16: {
                return pSSFACHandlerBase.getTempMode() == null;
            }
            case 17: {
                return pSSFACHandlerBase.getUpdateDate() == null;
            }
            case 18: {
                return pSSFACHandlerBase.getUpdateMan() == null;
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
        return PSSFACHandlerBase.contains(this, n);
    }

    private static boolean contains(PSSFACHandlerBase pSSFACHandlerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFACHandlerBase.isCreateDateDirty();
            }
            case 1: {
                return pSSFACHandlerBase.isCreateManDirty();
            }
            case 2: {
                return pSSFACHandlerBase.isCtrlTypeDirty();
            }
            case 3: {
                return pSSFACHandlerBase.isHandlerObjDirty();
            }
            case 4: {
                return pSSFACHandlerBase.isHandlerObj2Dirty();
            }
            case 5: {
                return pSSFACHandlerBase.isHandlerObj3Dirty();
            }
            case 6: {
                return pSSFACHandlerBase.isHandlerObj4Dirty();
            }
            case 7: {
                return pSSFACHandlerBase.isJITCtrlObjDirty();
            }
            case 8: {
                return pSSFACHandlerBase.isJITCtrlObj2Dirty();
            }
            case 9: {
                return pSSFACHandlerBase.isMemoDirty();
            }
            case 10: {
                return pSSFACHandlerBase.isPSSFACHandlerIdDirty();
            }
            case 11: {
                return pSSFACHandlerBase.isPSSFACHandlerNameDirty();
            }
            case 12: {
                return pSSFACHandlerBase.isPSSFIdDirty();
            }
            case 13: {
                return pSSFACHandlerBase.isPSSFNameDirty();
            }
            case 14: {
                return pSSFACHandlerBase.isPSSysACHandlerIdDirty();
            }
            case 15: {
                return pSSFACHandlerBase.isPSSysACHandlerNameDirty();
            }
            case 16: {
                return pSSFACHandlerBase.isTempModeDirty();
            }
            case 17: {
                return pSSFACHandlerBase.isUpdateDateDirty();
            }
            case 18: {
                return pSSFACHandlerBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSFACHandlerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSFACHandlerBase pSSFACHandlerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSFACHandlerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSFACHandlerBase.getJSONValue((Object)pSSFACHandlerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSFACHandlerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSFACHandlerBase.getJSONValue((Object)pSSFACHandlerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSFACHandlerBase.getCtrlType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrltype", (Object)PSSFACHandlerBase.getJSONValue((Object)pSSFACHandlerBase.getCtrlType()), (boolean)false);
        }
        if (bl || pSSFACHandlerBase.getHandlerObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"handlerobj", (Object)PSSFACHandlerBase.getJSONValue((Object)pSSFACHandlerBase.getHandlerObj()), (boolean)false);
        }
        if (bl || pSSFACHandlerBase.getHandlerObj2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"handlerobj2", (Object)PSSFACHandlerBase.getJSONValue((Object)pSSFACHandlerBase.getHandlerObj2()), (boolean)false);
        }
        if (bl || pSSFACHandlerBase.getHandlerObj3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"handlerobj3", (Object)PSSFACHandlerBase.getJSONValue((Object)pSSFACHandlerBase.getHandlerObj3()), (boolean)false);
        }
        if (bl || pSSFACHandlerBase.getHandlerObj4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"handlerobj4", (Object)PSSFACHandlerBase.getJSONValue((Object)pSSFACHandlerBase.getHandlerObj4()), (boolean)false);
        }
        if (bl || pSSFACHandlerBase.getJITCtrlObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jitctrlobj", (Object)PSSFACHandlerBase.getJSONValue((Object)pSSFACHandlerBase.getJITCtrlObj()), (boolean)false);
        }
        if (bl || pSSFACHandlerBase.getJITCtrlObj2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jitctrlobj2", (Object)PSSFACHandlerBase.getJSONValue((Object)pSSFACHandlerBase.getJITCtrlObj2()), (boolean)false);
        }
        if (bl || pSSFACHandlerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSFACHandlerBase.getJSONValue((Object)pSSFACHandlerBase.getMemo()), (boolean)false);
        }
        if (bl || pSSFACHandlerBase.getPSSFACHandlerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfachandlerid", (Object)PSSFACHandlerBase.getJSONValue((Object)pSSFACHandlerBase.getPSSFACHandlerId()), (boolean)false);
        }
        if (bl || pSSFACHandlerBase.getPSSFACHandlerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfachandlername", (Object)PSSFACHandlerBase.getJSONValue((Object)pSSFACHandlerBase.getPSSFACHandlerName()), (boolean)false);
        }
        if (bl || pSSFACHandlerBase.getPSSFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfid", (Object)PSSFACHandlerBase.getJSONValue((Object)pSSFACHandlerBase.getPSSFId()), (boolean)false);
        }
        if (bl || pSSFACHandlerBase.getPSSFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfname", (Object)PSSFACHandlerBase.getJSONValue((Object)pSSFACHandlerBase.getPSSFName()), (boolean)false);
        }
        if (bl || pSSFACHandlerBase.getPSSysACHandlerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysachandlerid", (Object)PSSFACHandlerBase.getJSONValue((Object)pSSFACHandlerBase.getPSSysACHandlerId()), (boolean)false);
        }
        if (bl || pSSFACHandlerBase.getPSSysACHandlerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysachandlername", (Object)PSSFACHandlerBase.getJSONValue((Object)pSSFACHandlerBase.getPSSysACHandlerName()), (boolean)false);
        }
        if (bl || pSSFACHandlerBase.getTempMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tempmode", (Object)PSSFACHandlerBase.getJSONValue((Object)pSSFACHandlerBase.getTempMode()), (boolean)false);
        }
        if (bl || pSSFACHandlerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSFACHandlerBase.getJSONValue((Object)pSSFACHandlerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSFACHandlerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSFACHandlerBase.getJSONValue((Object)pSSFACHandlerBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSFACHandlerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSFACHandlerBase pSSFACHandlerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSFACHandlerBase.getCreateDate() != null) {
            object = pSSFACHandlerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFACHandlerBase.getCreateMan() != null) {
            object = pSSFACHandlerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFACHandlerBase.getCtrlType() != null) {
            object = pSSFACHandlerBase.getCtrlType();
            xmlNode.setAttribute(FIELD_CTRLTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSFACHandlerBase.getHandlerObj() != null) {
            object = pSSFACHandlerBase.getHandlerObj();
            xmlNode.setAttribute(FIELD_HANDLEROBJ, object == null ? "" : (String)object);
        }
        if (bl || pSSFACHandlerBase.getHandlerObj2() != null) {
            object = pSSFACHandlerBase.getHandlerObj2();
            xmlNode.setAttribute(FIELD_HANDLEROBJ2, object == null ? "" : (String)object);
        }
        if (bl || pSSFACHandlerBase.getHandlerObj3() != null) {
            object = pSSFACHandlerBase.getHandlerObj3();
            xmlNode.setAttribute(FIELD_HANDLEROBJ3, object == null ? "" : (String)object);
        }
        if (bl || pSSFACHandlerBase.getHandlerObj4() != null) {
            object = pSSFACHandlerBase.getHandlerObj4();
            xmlNode.setAttribute(FIELD_HANDLEROBJ4, object == null ? "" : (String)object);
        }
        if (bl || pSSFACHandlerBase.getJITCtrlObj() != null) {
            object = pSSFACHandlerBase.getJITCtrlObj();
            xmlNode.setAttribute(FIELD_JITCTRLOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSSFACHandlerBase.getJITCtrlObj2() != null) {
            object = pSSFACHandlerBase.getJITCtrlObj2();
            xmlNode.setAttribute(FIELD_JITCTRLOBJ2, object == null ? "" : (String)object);
        }
        if (bl || pSSFACHandlerBase.getMemo() != null) {
            object = pSSFACHandlerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSFACHandlerBase.getPSSFACHandlerId() != null) {
            object = pSSFACHandlerBase.getPSSFACHandlerId();
            xmlNode.setAttribute(FIELD_PSSFACHANDLERID, object == null ? "" : (String)object);
        }
        if (bl || pSSFACHandlerBase.getPSSFACHandlerName() != null) {
            object = pSSFACHandlerBase.getPSSFACHandlerName();
            xmlNode.setAttribute(FIELD_PSSFACHANDLERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFACHandlerBase.getPSSFId() != null) {
            object = pSSFACHandlerBase.getPSSFId();
            xmlNode.setAttribute(FIELD_PSSFID, object == null ? "" : (String)object);
        }
        if (bl || pSSFACHandlerBase.getPSSFName() != null) {
            object = pSSFACHandlerBase.getPSSFName();
            xmlNode.setAttribute(FIELD_PSSFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFACHandlerBase.getPSSysACHandlerId() != null) {
            object = pSSFACHandlerBase.getPSSysACHandlerId();
            xmlNode.setAttribute(FIELD_PSSYSACHANDLERID, object == null ? "" : (String)object);
        }
        if (bl || pSSFACHandlerBase.getPSSysACHandlerName() != null) {
            object = pSSFACHandlerBase.getPSSysACHandlerName();
            xmlNode.setAttribute(FIELD_PSSYSACHANDLERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFACHandlerBase.getTempMode() != null) {
            object = pSSFACHandlerBase.getTempMode();
            xmlNode.setAttribute(FIELD_TEMPMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFACHandlerBase.getUpdateDate() != null) {
            object = pSSFACHandlerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFACHandlerBase.getUpdateMan() != null) {
            object = pSSFACHandlerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSFACHandlerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSFACHandlerBase pSSFACHandlerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSFACHandlerBase.isCreateDateDirty() && (bl || pSSFACHandlerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSFACHandlerBase.getCreateDate());
        }
        if (pSSFACHandlerBase.isCreateManDirty() && (bl || pSSFACHandlerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSFACHandlerBase.getCreateMan());
        }
        if (pSSFACHandlerBase.isCtrlTypeDirty() && (bl || pSSFACHandlerBase.getCtrlType() != null)) {
            iDataObject.set(FIELD_CTRLTYPE, (Object)pSSFACHandlerBase.getCtrlType());
        }
        if (pSSFACHandlerBase.isHandlerObjDirty() && (bl || pSSFACHandlerBase.getHandlerObj() != null)) {
            iDataObject.set(FIELD_HANDLEROBJ, (Object)pSSFACHandlerBase.getHandlerObj());
        }
        if (pSSFACHandlerBase.isHandlerObj2Dirty() && (bl || pSSFACHandlerBase.getHandlerObj2() != null)) {
            iDataObject.set(FIELD_HANDLEROBJ2, (Object)pSSFACHandlerBase.getHandlerObj2());
        }
        if (pSSFACHandlerBase.isHandlerObj3Dirty() && (bl || pSSFACHandlerBase.getHandlerObj3() != null)) {
            iDataObject.set(FIELD_HANDLEROBJ3, (Object)pSSFACHandlerBase.getHandlerObj3());
        }
        if (pSSFACHandlerBase.isHandlerObj4Dirty() && (bl || pSSFACHandlerBase.getHandlerObj4() != null)) {
            iDataObject.set(FIELD_HANDLEROBJ4, (Object)pSSFACHandlerBase.getHandlerObj4());
        }
        if (pSSFACHandlerBase.isJITCtrlObjDirty() && (bl || pSSFACHandlerBase.getJITCtrlObj() != null)) {
            iDataObject.set(FIELD_JITCTRLOBJ, (Object)pSSFACHandlerBase.getJITCtrlObj());
        }
        if (pSSFACHandlerBase.isJITCtrlObj2Dirty() && (bl || pSSFACHandlerBase.getJITCtrlObj2() != null)) {
            iDataObject.set(FIELD_JITCTRLOBJ2, (Object)pSSFACHandlerBase.getJITCtrlObj2());
        }
        if (pSSFACHandlerBase.isMemoDirty() && (bl || pSSFACHandlerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSFACHandlerBase.getMemo());
        }
        if (pSSFACHandlerBase.isPSSFACHandlerIdDirty() && (bl || pSSFACHandlerBase.getPSSFACHandlerId() != null)) {
            iDataObject.set(FIELD_PSSFACHANDLERID, (Object)pSSFACHandlerBase.getPSSFACHandlerId());
        }
        if (pSSFACHandlerBase.isPSSFACHandlerNameDirty() && (bl || pSSFACHandlerBase.getPSSFACHandlerName() != null)) {
            iDataObject.set(FIELD_PSSFACHANDLERNAME, (Object)pSSFACHandlerBase.getPSSFACHandlerName());
        }
        if (pSSFACHandlerBase.isPSSFIdDirty() && (bl || pSSFACHandlerBase.getPSSFId() != null)) {
            iDataObject.set(FIELD_PSSFID, (Object)pSSFACHandlerBase.getPSSFId());
        }
        if (pSSFACHandlerBase.isPSSFNameDirty() && (bl || pSSFACHandlerBase.getPSSFName() != null)) {
            iDataObject.set(FIELD_PSSFNAME, (Object)pSSFACHandlerBase.getPSSFName());
        }
        if (pSSFACHandlerBase.isPSSysACHandlerIdDirty() && (bl || pSSFACHandlerBase.getPSSysACHandlerId() != null)) {
            iDataObject.set(FIELD_PSSYSACHANDLERID, (Object)pSSFACHandlerBase.getPSSysACHandlerId());
        }
        if (pSSFACHandlerBase.isPSSysACHandlerNameDirty() && (bl || pSSFACHandlerBase.getPSSysACHandlerName() != null)) {
            iDataObject.set(FIELD_PSSYSACHANDLERNAME, (Object)pSSFACHandlerBase.getPSSysACHandlerName());
        }
        if (pSSFACHandlerBase.isTempModeDirty() && (bl || pSSFACHandlerBase.getTempMode() != null)) {
            iDataObject.set(FIELD_TEMPMODE, (Object)pSSFACHandlerBase.getTempMode());
        }
        if (pSSFACHandlerBase.isUpdateDateDirty() && (bl || pSSFACHandlerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSFACHandlerBase.getUpdateDate());
        }
        if (pSSFACHandlerBase.isUpdateManDirty() && (bl || pSSFACHandlerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSFACHandlerBase.getUpdateMan());
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
        return PSSFACHandlerBase.remove(this, n);
    }

    private static boolean remove(PSSFACHandlerBase pSSFACHandlerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSFACHandlerBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSFACHandlerBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSFACHandlerBase.resetCtrlType();
                return true;
            }
            case 3: {
                pSSFACHandlerBase.resetHandlerObj();
                return true;
            }
            case 4: {
                pSSFACHandlerBase.resetHandlerObj2();
                return true;
            }
            case 5: {
                pSSFACHandlerBase.resetHandlerObj3();
                return true;
            }
            case 6: {
                pSSFACHandlerBase.resetHandlerObj4();
                return true;
            }
            case 7: {
                pSSFACHandlerBase.resetJITCtrlObj();
                return true;
            }
            case 8: {
                pSSFACHandlerBase.resetJITCtrlObj2();
                return true;
            }
            case 9: {
                pSSFACHandlerBase.resetMemo();
                return true;
            }
            case 10: {
                pSSFACHandlerBase.resetPSSFACHandlerId();
                return true;
            }
            case 11: {
                pSSFACHandlerBase.resetPSSFACHandlerName();
                return true;
            }
            case 12: {
                pSSFACHandlerBase.resetPSSFId();
                return true;
            }
            case 13: {
                pSSFACHandlerBase.resetPSSFName();
                return true;
            }
            case 14: {
                pSSFACHandlerBase.resetPSSysACHandlerId();
                return true;
            }
            case 15: {
                pSSFACHandlerBase.resetPSSysACHandlerName();
                return true;
            }
            case 16: {
                pSSFACHandlerBase.resetTempMode();
                return true;
            }
            case 17: {
                pSSFACHandlerBase.resetUpdateDate();
                return true;
            }
            case 18: {
                pSSFACHandlerBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSF getPSSF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSF();
        }
        if (this.getPSSFId() == null) {
            return null;
        }
        Integer n = this.objPSSFLock;
        synchronized (n) {
            if (this.pssf != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFId(), (Object)this.pssf.getPSSFId()) != 0L) {
                this.pssf = null;
            }
            if (this.pssf == null) {
                PSSF pSSF = new PSSF();
                pSSF.setPSSFId(this.getPSSFId());
                PSSFService pSSFService = (PSSFService)ServiceGlobal.getService(PSSFService.class, (SessionFactory)this.getSessionFactory());
                pSSFService.autoGet((IEntity)pSSF);
                this.pssf = pSSF;
            }
            return this.pssf;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysACHandler getPssysachandler() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPssysachandler();
        }
        if (this.getPSSysACHandlerId() == null) {
            return null;
        }
        Integer n = this.objPssysachandlerLock;
        synchronized (n) {
            if (this.pssysachandler != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysACHandlerId(), (Object)this.pssysachandler.getPSSysACHandlerId()) != 0L) {
                this.pssysachandler = null;
            }
            if (this.pssysachandler == null) {
                PSSysACHandler pSSysACHandler = new PSSysACHandler();
                pSSysACHandler.setPSSysACHandlerId(this.getPSSysACHandlerId());
                PSSysACHandlerService pSSysACHandlerService = (PSSysACHandlerService)ServiceGlobal.getService(PSSysACHandlerService.class, (SessionFactory)this.getSessionFactory());
                pSSysACHandlerService.autoGet((IEntity)pSSysACHandler);
                this.pssysachandler = pSSysACHandler;
            }
            return this.pssysachandler;
        }
    }

    private PSSFACHandlerBase getProxyEntity() {
        return this.proxyPSSFACHandlerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSFACHandlerBase = null;
        if (iDataObject != null && iDataObject instanceof PSSFACHandlerBase) {
            this.proxyPSSFACHandlerBase = (PSSFACHandlerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFACHandlerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_CTRLTYPE, 2);
        fieldIndexMap.put(FIELD_HANDLEROBJ, 3);
        fieldIndexMap.put(FIELD_HANDLEROBJ2, 4);
        fieldIndexMap.put(FIELD_HANDLEROBJ3, 5);
        fieldIndexMap.put(FIELD_HANDLEROBJ4, 6);
        fieldIndexMap.put(FIELD_JITCTRLOBJ, 7);
        fieldIndexMap.put(FIELD_JITCTRLOBJ2, 8);
        fieldIndexMap.put(FIELD_MEMO, 9);
        fieldIndexMap.put(FIELD_PSSFACHANDLERID, 10);
        fieldIndexMap.put(FIELD_PSSFACHANDLERNAME, 11);
        fieldIndexMap.put(FIELD_PSSFID, 12);
        fieldIndexMap.put(FIELD_PSSFNAME, 13);
        fieldIndexMap.put(FIELD_PSSYSACHANDLERID, 14);
        fieldIndexMap.put(FIELD_PSSYSACHANDLERNAME, 15);
        fieldIndexMap.put(FIELD_TEMPMODE, 16);
        fieldIndexMap.put(FIELD_UPDATEDATE, 17);
        fieldIndexMap.put(FIELD_UPDATEMAN, 18);
    }
}

