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
import net.ibizsys.pscore.srv.config.entity.PSSAHandler;
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.service.PSSAHandlerService;
import net.ibizsys.pscore.srv.config.service.PSSFService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFSAHandlerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSFSAHandlerBase.class);
    public static final String FIELD_CLIENTHANDLEROBJ = "CLIENTHANDLEROBJ";
    public static final String FIELD_CLIENTHANDLEROBJ2 = "CLIENTHANDLEROBJ2";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_HANDLEROBJ = "HANDLEROBJ";
    public static final String FIELD_HANDLEROBJ2 = "HANDLEROBJ2";
    public static final String FIELD_HANDLEROBJ3 = "HANDLEROBJ3";
    public static final String FIELD_HANDLEROBJ4 = "HANDLEROBJ4";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSAHANDLERID = "PSSAHANDLERID";
    public static final String FIELD_PSSAHANDLERNAME = "PSSAHANDLERNAME";
    public static final String FIELD_PSSFID = "PSSFID";
    public static final String FIELD_PSSFNAME = "PSSFNAME";
    public static final String FIELD_PSSFSAHANDLERID = "PSSFSAHANDLERID";
    public static final String FIELD_PSSFSAHANDLERNAME = "PSSFSAHANDLERNAME";
    public static final String FIELD_SATYPE = "SATYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CLIENTHANDLEROBJ = 0;
    private static final int INDEX_CLIENTHANDLEROBJ2 = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_HANDLEROBJ = 4;
    private static final int INDEX_HANDLEROBJ2 = 5;
    private static final int INDEX_HANDLEROBJ3 = 6;
    private static final int INDEX_HANDLEROBJ4 = 7;
    private static final int INDEX_MEMO = 8;
    private static final int INDEX_PSSAHANDLERID = 9;
    private static final int INDEX_PSSAHANDLERNAME = 10;
    private static final int INDEX_PSSFID = 11;
    private static final int INDEX_PSSFNAME = 12;
    private static final int INDEX_PSSFSAHANDLERID = 13;
    private static final int INDEX_PSSFSAHANDLERNAME = 14;
    private static final int INDEX_SATYPE = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final int INDEX_VALIDFLAG = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSFSAHandlerBase proxyPSSFSAHandlerBase = null;
    private boolean clienthandlerobjDirtyFlag = false;
    private boolean clienthandlerobj2DirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean handlerobjDirtyFlag = false;
    private boolean handlerobj2DirtyFlag = false;
    private boolean handlerobj3DirtyFlag = false;
    private boolean handlerobj4DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssahandleridDirtyFlag = false;
    private boolean pssahandlernameDirtyFlag = false;
    private boolean pssfidDirtyFlag = false;
    private boolean pssfnameDirtyFlag = false;
    private boolean pssfsahandleridDirtyFlag = false;
    private boolean pssfsahandlernameDirtyFlag = false;
    private boolean satypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="clienthandlerobj")
    private String clienthandlerobj;
    @Column(name="clienthandlerobj2")
    private String clienthandlerobj2;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="handlerobj")
    private String handlerobj;
    @Column(name="handlerobj2")
    private String handlerobj2;
    @Column(name="handlerobj3")
    private String handlerobj3;
    @Column(name="handlerobj4")
    private String handlerobj4;
    @Column(name="memo")
    private String memo;
    @Column(name="pssahandlerid")
    private String pssahandlerid;
    @Column(name="pssahandlername")
    private String pssahandlername;
    @Column(name="pssfid")
    private String pssfid;
    @Column(name="pssfname")
    private String pssfname;
    @Column(name="pssfsahandlerid")
    private String pssfsahandlerid;
    @Column(name="pssfsahandlername")
    private String pssfsahandlername;
    @Column(name="satype")
    private String satype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSSAHandlerLock = new Integer(1);
    private PSSAHandler pssahandler = null;
    private Integer objPSSFLock = new Integer(1);
    private PSSF pssf = null;

    public void setClientHandlerObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setClientHandlerObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.clienthandlerobj = string;
        this.clienthandlerobjDirtyFlag = true;
    }

    public String getClientHandlerObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getClientHandlerObj();
        }
        return this.clienthandlerobj;
    }

    public boolean isClientHandlerObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isClientHandlerObjDirty();
        }
        return this.clienthandlerobjDirtyFlag;
    }

    public void resetClientHandlerObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetClientHandlerObj();
            return;
        }
        this.clienthandlerobjDirtyFlag = false;
        this.clienthandlerobj = null;
    }

    public void setClientHandlerObj2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setClientHandlerObj2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.clienthandlerobj2 = string;
        this.clienthandlerobj2DirtyFlag = true;
    }

    public String getClientHandlerObj2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getClientHandlerObj2();
        }
        return this.clienthandlerobj2;
    }

    public boolean isClientHandlerObj2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isClientHandlerObj2Dirty();
        }
        return this.clienthandlerobj2DirtyFlag;
    }

    public void resetClientHandlerObj2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetClientHandlerObj2();
            return;
        }
        this.clienthandlerobj2DirtyFlag = false;
        this.clienthandlerobj2 = null;
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

    public void setPSSAHandlerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSAHandlerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssahandlerid = string;
        this.pssahandleridDirtyFlag = true;
    }

    public String getPSSAHandlerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSAHandlerId();
        }
        return this.pssahandlerid;
    }

    public boolean isPSSAHandlerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSAHandlerIdDirty();
        }
        return this.pssahandleridDirtyFlag;
    }

    public void resetPSSAHandlerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSAHandlerId();
            return;
        }
        this.pssahandleridDirtyFlag = false;
        this.pssahandlerid = null;
    }

    public void setPSSAHandlerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSAHandlerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssahandlername = string;
        this.pssahandlernameDirtyFlag = true;
    }

    public String getPSSAHandlerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSAHandlerName();
        }
        return this.pssahandlername;
    }

    public boolean isPSSAHandlerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSAHandlerNameDirty();
        }
        return this.pssahandlernameDirtyFlag;
    }

    public void resetPSSAHandlerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSAHandlerName();
            return;
        }
        this.pssahandlernameDirtyFlag = false;
        this.pssahandlername = null;
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

    public void setPSSFSAHandlerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFSAHandlerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfsahandlerid = string;
        this.pssfsahandleridDirtyFlag = true;
    }

    public String getPSSFSAHandlerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFSAHandlerId();
        }
        return this.pssfsahandlerid;
    }

    public boolean isPSSFSAHandlerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFSAHandlerIdDirty();
        }
        return this.pssfsahandleridDirtyFlag;
    }

    public void resetPSSFSAHandlerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFSAHandlerId();
            return;
        }
        this.pssfsahandleridDirtyFlag = false;
        this.pssfsahandlerid = null;
    }

    public void setPSSFSAHandlerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFSAHandlerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfsahandlername = string;
        this.pssfsahandlernameDirtyFlag = true;
    }

    public String getPSSFSAHandlerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFSAHandlerName();
        }
        return this.pssfsahandlername;
    }

    public boolean isPSSFSAHandlerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFSAHandlerNameDirty();
        }
        return this.pssfsahandlernameDirtyFlag;
    }

    public void resetPSSFSAHandlerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFSAHandlerName();
            return;
        }
        this.pssfsahandlernameDirtyFlag = false;
        this.pssfsahandlername = null;
    }

    public void setSAType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSAType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.satype = string;
        this.satypeDirtyFlag = true;
    }

    public String getSAType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSAType();
        }
        return this.satype;
    }

    public boolean isSATypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSATypeDirty();
        }
        return this.satypeDirtyFlag;
    }

    public void resetSAType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSAType();
            return;
        }
        this.satypeDirtyFlag = false;
        this.satype = null;
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
        PSSFSAHandlerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSFSAHandlerBase pSSFSAHandlerBase) {
        pSSFSAHandlerBase.resetClientHandlerObj();
        pSSFSAHandlerBase.resetClientHandlerObj2();
        pSSFSAHandlerBase.resetCreateDate();
        pSSFSAHandlerBase.resetCreateMan();
        pSSFSAHandlerBase.resetHandlerObj();
        pSSFSAHandlerBase.resetHandlerObj2();
        pSSFSAHandlerBase.resetHandlerObj3();
        pSSFSAHandlerBase.resetHandlerObj4();
        pSSFSAHandlerBase.resetMemo();
        pSSFSAHandlerBase.resetPSSAHandlerId();
        pSSFSAHandlerBase.resetPSSAHandlerName();
        pSSFSAHandlerBase.resetPSSFId();
        pSSFSAHandlerBase.resetPSSFName();
        pSSFSAHandlerBase.resetPSSFSAHandlerId();
        pSSFSAHandlerBase.resetPSSFSAHandlerName();
        pSSFSAHandlerBase.resetSAType();
        pSSFSAHandlerBase.resetUpdateDate();
        pSSFSAHandlerBase.resetUpdateMan();
        pSSFSAHandlerBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isClientHandlerObjDirty()) {
            hashMap.put(FIELD_CLIENTHANDLEROBJ, this.getClientHandlerObj());
        }
        if (!bl || this.isClientHandlerObj2Dirty()) {
            hashMap.put(FIELD_CLIENTHANDLEROBJ2, this.getClientHandlerObj2());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
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
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSSAHandlerIdDirty()) {
            hashMap.put(FIELD_PSSAHANDLERID, this.getPSSAHandlerId());
        }
        if (!bl || this.isPSSAHandlerNameDirty()) {
            hashMap.put(FIELD_PSSAHANDLERNAME, this.getPSSAHandlerName());
        }
        if (!bl || this.isPSSFIdDirty()) {
            hashMap.put(FIELD_PSSFID, this.getPSSFId());
        }
        if (!bl || this.isPSSFNameDirty()) {
            hashMap.put(FIELD_PSSFNAME, this.getPSSFName());
        }
        if (!bl || this.isPSSFSAHandlerIdDirty()) {
            hashMap.put(FIELD_PSSFSAHANDLERID, this.getPSSFSAHandlerId());
        }
        if (!bl || this.isPSSFSAHandlerNameDirty()) {
            hashMap.put(FIELD_PSSFSAHANDLERNAME, this.getPSSFSAHandlerName());
        }
        if (!bl || this.isSATypeDirty()) {
            hashMap.put(FIELD_SATYPE, this.getSAType());
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
        return PSSFSAHandlerBase.get(this, n);
    }

    private static Object get(PSSFSAHandlerBase pSSFSAHandlerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFSAHandlerBase.getClientHandlerObj();
            }
            case 1: {
                return pSSFSAHandlerBase.getClientHandlerObj2();
            }
            case 2: {
                return pSSFSAHandlerBase.getCreateDate();
            }
            case 3: {
                return pSSFSAHandlerBase.getCreateMan();
            }
            case 4: {
                return pSSFSAHandlerBase.getHandlerObj();
            }
            case 5: {
                return pSSFSAHandlerBase.getHandlerObj2();
            }
            case 6: {
                return pSSFSAHandlerBase.getHandlerObj3();
            }
            case 7: {
                return pSSFSAHandlerBase.getHandlerObj4();
            }
            case 8: {
                return pSSFSAHandlerBase.getMemo();
            }
            case 9: {
                return pSSFSAHandlerBase.getPSSAHandlerId();
            }
            case 10: {
                return pSSFSAHandlerBase.getPSSAHandlerName();
            }
            case 11: {
                return pSSFSAHandlerBase.getPSSFId();
            }
            case 12: {
                return pSSFSAHandlerBase.getPSSFName();
            }
            case 13: {
                return pSSFSAHandlerBase.getPSSFSAHandlerId();
            }
            case 14: {
                return pSSFSAHandlerBase.getPSSFSAHandlerName();
            }
            case 15: {
                return pSSFSAHandlerBase.getSAType();
            }
            case 16: {
                return pSSFSAHandlerBase.getUpdateDate();
            }
            case 17: {
                return pSSFSAHandlerBase.getUpdateMan();
            }
            case 18: {
                return pSSFSAHandlerBase.getValidFlag();
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
        PSSFSAHandlerBase.set(this, n, object);
    }

    private static void set(PSSFSAHandlerBase pSSFSAHandlerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSFSAHandlerBase.setClientHandlerObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSFSAHandlerBase.setClientHandlerObj2(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSFSAHandlerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSSFSAHandlerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSFSAHandlerBase.setHandlerObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSFSAHandlerBase.setHandlerObj2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSFSAHandlerBase.setHandlerObj3(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSFSAHandlerBase.setHandlerObj4(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSFSAHandlerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSFSAHandlerBase.setPSSAHandlerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSFSAHandlerBase.setPSSAHandlerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSFSAHandlerBase.setPSSFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSFSAHandlerBase.setPSSFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSFSAHandlerBase.setPSSFSAHandlerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSFSAHandlerBase.setPSSFSAHandlerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSFSAHandlerBase.setSAType(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSFSAHandlerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSSFSAHandlerBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSFSAHandlerBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSFSAHandlerBase.isNull(this, n);
    }

    private static boolean isNull(PSSFSAHandlerBase pSSFSAHandlerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFSAHandlerBase.getClientHandlerObj() == null;
            }
            case 1: {
                return pSSFSAHandlerBase.getClientHandlerObj2() == null;
            }
            case 2: {
                return pSSFSAHandlerBase.getCreateDate() == null;
            }
            case 3: {
                return pSSFSAHandlerBase.getCreateMan() == null;
            }
            case 4: {
                return pSSFSAHandlerBase.getHandlerObj() == null;
            }
            case 5: {
                return pSSFSAHandlerBase.getHandlerObj2() == null;
            }
            case 6: {
                return pSSFSAHandlerBase.getHandlerObj3() == null;
            }
            case 7: {
                return pSSFSAHandlerBase.getHandlerObj4() == null;
            }
            case 8: {
                return pSSFSAHandlerBase.getMemo() == null;
            }
            case 9: {
                return pSSFSAHandlerBase.getPSSAHandlerId() == null;
            }
            case 10: {
                return pSSFSAHandlerBase.getPSSAHandlerName() == null;
            }
            case 11: {
                return pSSFSAHandlerBase.getPSSFId() == null;
            }
            case 12: {
                return pSSFSAHandlerBase.getPSSFName() == null;
            }
            case 13: {
                return pSSFSAHandlerBase.getPSSFSAHandlerId() == null;
            }
            case 14: {
                return pSSFSAHandlerBase.getPSSFSAHandlerName() == null;
            }
            case 15: {
                return pSSFSAHandlerBase.getSAType() == null;
            }
            case 16: {
                return pSSFSAHandlerBase.getUpdateDate() == null;
            }
            case 17: {
                return pSSFSAHandlerBase.getUpdateMan() == null;
            }
            case 18: {
                return pSSFSAHandlerBase.getValidFlag() == null;
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
        return PSSFSAHandlerBase.contains(this, n);
    }

    private static boolean contains(PSSFSAHandlerBase pSSFSAHandlerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFSAHandlerBase.isClientHandlerObjDirty();
            }
            case 1: {
                return pSSFSAHandlerBase.isClientHandlerObj2Dirty();
            }
            case 2: {
                return pSSFSAHandlerBase.isCreateDateDirty();
            }
            case 3: {
                return pSSFSAHandlerBase.isCreateManDirty();
            }
            case 4: {
                return pSSFSAHandlerBase.isHandlerObjDirty();
            }
            case 5: {
                return pSSFSAHandlerBase.isHandlerObj2Dirty();
            }
            case 6: {
                return pSSFSAHandlerBase.isHandlerObj3Dirty();
            }
            case 7: {
                return pSSFSAHandlerBase.isHandlerObj4Dirty();
            }
            case 8: {
                return pSSFSAHandlerBase.isMemoDirty();
            }
            case 9: {
                return pSSFSAHandlerBase.isPSSAHandlerIdDirty();
            }
            case 10: {
                return pSSFSAHandlerBase.isPSSAHandlerNameDirty();
            }
            case 11: {
                return pSSFSAHandlerBase.isPSSFIdDirty();
            }
            case 12: {
                return pSSFSAHandlerBase.isPSSFNameDirty();
            }
            case 13: {
                return pSSFSAHandlerBase.isPSSFSAHandlerIdDirty();
            }
            case 14: {
                return pSSFSAHandlerBase.isPSSFSAHandlerNameDirty();
            }
            case 15: {
                return pSSFSAHandlerBase.isSATypeDirty();
            }
            case 16: {
                return pSSFSAHandlerBase.isUpdateDateDirty();
            }
            case 17: {
                return pSSFSAHandlerBase.isUpdateManDirty();
            }
            case 18: {
                return pSSFSAHandlerBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSFSAHandlerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSFSAHandlerBase pSSFSAHandlerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSFSAHandlerBase.getClientHandlerObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clienthandlerobj", (Object)PSSFSAHandlerBase.getJSONValue((Object)pSSFSAHandlerBase.getClientHandlerObj()), (boolean)false);
        }
        if (bl || pSSFSAHandlerBase.getClientHandlerObj2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clienthandlerobj2", (Object)PSSFSAHandlerBase.getJSONValue((Object)pSSFSAHandlerBase.getClientHandlerObj2()), (boolean)false);
        }
        if (bl || pSSFSAHandlerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSFSAHandlerBase.getJSONValue((Object)pSSFSAHandlerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSFSAHandlerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSFSAHandlerBase.getJSONValue((Object)pSSFSAHandlerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSFSAHandlerBase.getHandlerObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"handlerobj", (Object)PSSFSAHandlerBase.getJSONValue((Object)pSSFSAHandlerBase.getHandlerObj()), (boolean)false);
        }
        if (bl || pSSFSAHandlerBase.getHandlerObj2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"handlerobj2", (Object)PSSFSAHandlerBase.getJSONValue((Object)pSSFSAHandlerBase.getHandlerObj2()), (boolean)false);
        }
        if (bl || pSSFSAHandlerBase.getHandlerObj3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"handlerobj3", (Object)PSSFSAHandlerBase.getJSONValue((Object)pSSFSAHandlerBase.getHandlerObj3()), (boolean)false);
        }
        if (bl || pSSFSAHandlerBase.getHandlerObj4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"handlerobj4", (Object)PSSFSAHandlerBase.getJSONValue((Object)pSSFSAHandlerBase.getHandlerObj4()), (boolean)false);
        }
        if (bl || pSSFSAHandlerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSFSAHandlerBase.getJSONValue((Object)pSSFSAHandlerBase.getMemo()), (boolean)false);
        }
        if (bl || pSSFSAHandlerBase.getPSSAHandlerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssahandlerid", (Object)PSSFSAHandlerBase.getJSONValue((Object)pSSFSAHandlerBase.getPSSAHandlerId()), (boolean)false);
        }
        if (bl || pSSFSAHandlerBase.getPSSAHandlerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssahandlername", (Object)PSSFSAHandlerBase.getJSONValue((Object)pSSFSAHandlerBase.getPSSAHandlerName()), (boolean)false);
        }
        if (bl || pSSFSAHandlerBase.getPSSFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfid", (Object)PSSFSAHandlerBase.getJSONValue((Object)pSSFSAHandlerBase.getPSSFId()), (boolean)false);
        }
        if (bl || pSSFSAHandlerBase.getPSSFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfname", (Object)PSSFSAHandlerBase.getJSONValue((Object)pSSFSAHandlerBase.getPSSFName()), (boolean)false);
        }
        if (bl || pSSFSAHandlerBase.getPSSFSAHandlerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfsahandlerid", (Object)PSSFSAHandlerBase.getJSONValue((Object)pSSFSAHandlerBase.getPSSFSAHandlerId()), (boolean)false);
        }
        if (bl || pSSFSAHandlerBase.getPSSFSAHandlerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfsahandlername", (Object)PSSFSAHandlerBase.getJSONValue((Object)pSSFSAHandlerBase.getPSSFSAHandlerName()), (boolean)false);
        }
        if (bl || pSSFSAHandlerBase.getSAType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"satype", (Object)PSSFSAHandlerBase.getJSONValue((Object)pSSFSAHandlerBase.getSAType()), (boolean)false);
        }
        if (bl || pSSFSAHandlerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSFSAHandlerBase.getJSONValue((Object)pSSFSAHandlerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSFSAHandlerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSFSAHandlerBase.getJSONValue((Object)pSSFSAHandlerBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSFSAHandlerBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSFSAHandlerBase.getJSONValue((Object)pSSFSAHandlerBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSFSAHandlerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSFSAHandlerBase pSSFSAHandlerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSFSAHandlerBase.getClientHandlerObj() != null) {
            object = pSSFSAHandlerBase.getClientHandlerObj();
            xmlNode.setAttribute(FIELD_CLIENTHANDLEROBJ, (String)(object == null ? "" : object));
        }
        if (bl || pSSFSAHandlerBase.getClientHandlerObj2() != null) {
            object = pSSFSAHandlerBase.getClientHandlerObj2();
            xmlNode.setAttribute(FIELD_CLIENTHANDLEROBJ2, object == null ? "" : (String)object);
        }
        if (bl || pSSFSAHandlerBase.getCreateDate() != null) {
            object = pSSFSAHandlerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFSAHandlerBase.getCreateMan() != null) {
            object = pSSFSAHandlerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFSAHandlerBase.getHandlerObj() != null) {
            object = pSSFSAHandlerBase.getHandlerObj();
            xmlNode.setAttribute(FIELD_HANDLEROBJ, object == null ? "" : (String)object);
        }
        if (bl || pSSFSAHandlerBase.getHandlerObj2() != null) {
            object = pSSFSAHandlerBase.getHandlerObj2();
            xmlNode.setAttribute(FIELD_HANDLEROBJ2, object == null ? "" : (String)object);
        }
        if (bl || pSSFSAHandlerBase.getHandlerObj3() != null) {
            object = pSSFSAHandlerBase.getHandlerObj3();
            xmlNode.setAttribute(FIELD_HANDLEROBJ3, object == null ? "" : (String)object);
        }
        if (bl || pSSFSAHandlerBase.getHandlerObj4() != null) {
            object = pSSFSAHandlerBase.getHandlerObj4();
            xmlNode.setAttribute(FIELD_HANDLEROBJ4, object == null ? "" : (String)object);
        }
        if (bl || pSSFSAHandlerBase.getMemo() != null) {
            object = pSSFSAHandlerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSFSAHandlerBase.getPSSAHandlerId() != null) {
            object = pSSFSAHandlerBase.getPSSAHandlerId();
            xmlNode.setAttribute(FIELD_PSSAHANDLERID, object == null ? "" : (String)object);
        }
        if (bl || pSSFSAHandlerBase.getPSSAHandlerName() != null) {
            object = pSSFSAHandlerBase.getPSSAHandlerName();
            xmlNode.setAttribute(FIELD_PSSAHANDLERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFSAHandlerBase.getPSSFId() != null) {
            object = pSSFSAHandlerBase.getPSSFId();
            xmlNode.setAttribute(FIELD_PSSFID, object == null ? "" : (String)object);
        }
        if (bl || pSSFSAHandlerBase.getPSSFName() != null) {
            object = pSSFSAHandlerBase.getPSSFName();
            xmlNode.setAttribute(FIELD_PSSFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFSAHandlerBase.getPSSFSAHandlerId() != null) {
            object = pSSFSAHandlerBase.getPSSFSAHandlerId();
            xmlNode.setAttribute(FIELD_PSSFSAHANDLERID, object == null ? "" : (String)object);
        }
        if (bl || pSSFSAHandlerBase.getPSSFSAHandlerName() != null) {
            object = pSSFSAHandlerBase.getPSSFSAHandlerName();
            xmlNode.setAttribute(FIELD_PSSFSAHANDLERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFSAHandlerBase.getSAType() != null) {
            object = pSSFSAHandlerBase.getSAType();
            xmlNode.setAttribute(FIELD_SATYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSFSAHandlerBase.getUpdateDate() != null) {
            object = pSSFSAHandlerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFSAHandlerBase.getUpdateMan() != null) {
            object = pSSFSAHandlerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFSAHandlerBase.getValidFlag() != null) {
            object = pSSFSAHandlerBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSFSAHandlerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSFSAHandlerBase pSSFSAHandlerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSFSAHandlerBase.isClientHandlerObjDirty() && (bl || pSSFSAHandlerBase.getClientHandlerObj() != null)) {
            iDataObject.set(FIELD_CLIENTHANDLEROBJ, (Object)pSSFSAHandlerBase.getClientHandlerObj());
        }
        if (pSSFSAHandlerBase.isClientHandlerObj2Dirty() && (bl || pSSFSAHandlerBase.getClientHandlerObj2() != null)) {
            iDataObject.set(FIELD_CLIENTHANDLEROBJ2, (Object)pSSFSAHandlerBase.getClientHandlerObj2());
        }
        if (pSSFSAHandlerBase.isCreateDateDirty() && (bl || pSSFSAHandlerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSFSAHandlerBase.getCreateDate());
        }
        if (pSSFSAHandlerBase.isCreateManDirty() && (bl || pSSFSAHandlerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSFSAHandlerBase.getCreateMan());
        }
        if (pSSFSAHandlerBase.isHandlerObjDirty() && (bl || pSSFSAHandlerBase.getHandlerObj() != null)) {
            iDataObject.set(FIELD_HANDLEROBJ, (Object)pSSFSAHandlerBase.getHandlerObj());
        }
        if (pSSFSAHandlerBase.isHandlerObj2Dirty() && (bl || pSSFSAHandlerBase.getHandlerObj2() != null)) {
            iDataObject.set(FIELD_HANDLEROBJ2, (Object)pSSFSAHandlerBase.getHandlerObj2());
        }
        if (pSSFSAHandlerBase.isHandlerObj3Dirty() && (bl || pSSFSAHandlerBase.getHandlerObj3() != null)) {
            iDataObject.set(FIELD_HANDLEROBJ3, (Object)pSSFSAHandlerBase.getHandlerObj3());
        }
        if (pSSFSAHandlerBase.isHandlerObj4Dirty() && (bl || pSSFSAHandlerBase.getHandlerObj4() != null)) {
            iDataObject.set(FIELD_HANDLEROBJ4, (Object)pSSFSAHandlerBase.getHandlerObj4());
        }
        if (pSSFSAHandlerBase.isMemoDirty() && (bl || pSSFSAHandlerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSFSAHandlerBase.getMemo());
        }
        if (pSSFSAHandlerBase.isPSSAHandlerIdDirty() && (bl || pSSFSAHandlerBase.getPSSAHandlerId() != null)) {
            iDataObject.set(FIELD_PSSAHANDLERID, (Object)pSSFSAHandlerBase.getPSSAHandlerId());
        }
        if (pSSFSAHandlerBase.isPSSAHandlerNameDirty() && (bl || pSSFSAHandlerBase.getPSSAHandlerName() != null)) {
            iDataObject.set(FIELD_PSSAHANDLERNAME, (Object)pSSFSAHandlerBase.getPSSAHandlerName());
        }
        if (pSSFSAHandlerBase.isPSSFIdDirty() && (bl || pSSFSAHandlerBase.getPSSFId() != null)) {
            iDataObject.set(FIELD_PSSFID, (Object)pSSFSAHandlerBase.getPSSFId());
        }
        if (pSSFSAHandlerBase.isPSSFNameDirty() && (bl || pSSFSAHandlerBase.getPSSFName() != null)) {
            iDataObject.set(FIELD_PSSFNAME, (Object)pSSFSAHandlerBase.getPSSFName());
        }
        if (pSSFSAHandlerBase.isPSSFSAHandlerIdDirty() && (bl || pSSFSAHandlerBase.getPSSFSAHandlerId() != null)) {
            iDataObject.set(FIELD_PSSFSAHANDLERID, (Object)pSSFSAHandlerBase.getPSSFSAHandlerId());
        }
        if (pSSFSAHandlerBase.isPSSFSAHandlerNameDirty() && (bl || pSSFSAHandlerBase.getPSSFSAHandlerName() != null)) {
            iDataObject.set(FIELD_PSSFSAHANDLERNAME, (Object)pSSFSAHandlerBase.getPSSFSAHandlerName());
        }
        if (pSSFSAHandlerBase.isSATypeDirty() && (bl || pSSFSAHandlerBase.getSAType() != null)) {
            iDataObject.set(FIELD_SATYPE, (Object)pSSFSAHandlerBase.getSAType());
        }
        if (pSSFSAHandlerBase.isUpdateDateDirty() && (bl || pSSFSAHandlerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSFSAHandlerBase.getUpdateDate());
        }
        if (pSSFSAHandlerBase.isUpdateManDirty() && (bl || pSSFSAHandlerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSFSAHandlerBase.getUpdateMan());
        }
        if (pSSFSAHandlerBase.isValidFlagDirty() && (bl || pSSFSAHandlerBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSFSAHandlerBase.getValidFlag());
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
        return PSSFSAHandlerBase.remove(this, n);
    }

    private static boolean remove(PSSFSAHandlerBase pSSFSAHandlerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSFSAHandlerBase.resetClientHandlerObj();
                return true;
            }
            case 1: {
                pSSFSAHandlerBase.resetClientHandlerObj2();
                return true;
            }
            case 2: {
                pSSFSAHandlerBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSSFSAHandlerBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSSFSAHandlerBase.resetHandlerObj();
                return true;
            }
            case 5: {
                pSSFSAHandlerBase.resetHandlerObj2();
                return true;
            }
            case 6: {
                pSSFSAHandlerBase.resetHandlerObj3();
                return true;
            }
            case 7: {
                pSSFSAHandlerBase.resetHandlerObj4();
                return true;
            }
            case 8: {
                pSSFSAHandlerBase.resetMemo();
                return true;
            }
            case 9: {
                pSSFSAHandlerBase.resetPSSAHandlerId();
                return true;
            }
            case 10: {
                pSSFSAHandlerBase.resetPSSAHandlerName();
                return true;
            }
            case 11: {
                pSSFSAHandlerBase.resetPSSFId();
                return true;
            }
            case 12: {
                pSSFSAHandlerBase.resetPSSFName();
                return true;
            }
            case 13: {
                pSSFSAHandlerBase.resetPSSFSAHandlerId();
                return true;
            }
            case 14: {
                pSSFSAHandlerBase.resetPSSFSAHandlerName();
                return true;
            }
            case 15: {
                pSSFSAHandlerBase.resetSAType();
                return true;
            }
            case 16: {
                pSSFSAHandlerBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSSFSAHandlerBase.resetUpdateMan();
                return true;
            }
            case 18: {
                pSSFSAHandlerBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSAHandler getPSSAHandler() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSAHandler();
        }
        if (this.getPSSAHandlerId() == null) {
            return null;
        }
        Integer n = this.objPSSAHandlerLock;
        synchronized (n) {
            if (this.pssahandler != null && DataTypeHelper.compare((int)25, (Object)this.getPSSAHandlerId(), (Object)this.pssahandler.getPSSAHandlerId()) != 0L) {
                this.pssahandler = null;
            }
            if (this.pssahandler == null) {
                PSSAHandler pSSAHandler = new PSSAHandler();
                pSSAHandler.setPSSAHandlerId(this.getPSSAHandlerId());
                PSSAHandlerService pSSAHandlerService = (PSSAHandlerService)ServiceGlobal.getService(PSSAHandlerService.class, (SessionFactory)this.getSessionFactory());
                pSSAHandlerService.autoGet((IEntity)pSSAHandler);
                this.pssahandler = pSSAHandler;
            }
            return this.pssahandler;
        }
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

    private PSSFSAHandlerBase getProxyEntity() {
        return this.proxyPSSFSAHandlerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSFSAHandlerBase = null;
        if (iDataObject != null && iDataObject instanceof PSSFSAHandlerBase) {
            this.proxyPSSFSAHandlerBase = (PSSFSAHandlerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFSAHandlerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CLIENTHANDLEROBJ, 0);
        fieldIndexMap.put(FIELD_CLIENTHANDLEROBJ2, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_HANDLEROBJ, 4);
        fieldIndexMap.put(FIELD_HANDLEROBJ2, 5);
        fieldIndexMap.put(FIELD_HANDLEROBJ3, 6);
        fieldIndexMap.put(FIELD_HANDLEROBJ4, 7);
        fieldIndexMap.put(FIELD_MEMO, 8);
        fieldIndexMap.put(FIELD_PSSAHANDLERID, 9);
        fieldIndexMap.put(FIELD_PSSAHANDLERNAME, 10);
        fieldIndexMap.put(FIELD_PSSFID, 11);
        fieldIndexMap.put(FIELD_PSSFNAME, 12);
        fieldIndexMap.put(FIELD_PSSFSAHANDLERID, 13);
        fieldIndexMap.put(FIELD_PSSFSAHANDLERNAME, 14);
        fieldIndexMap.put(FIELD_SATYPE, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
        fieldIndexMap.put(FIELD_VALIDFLAG, 18);
    }
}

