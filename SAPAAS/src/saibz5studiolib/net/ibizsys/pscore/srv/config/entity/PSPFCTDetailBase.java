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
import net.ibizsys.pscore.srv.config.entity.PSPFCtrlTempl;
import net.ibizsys.pscore.srv.config.service.PSPFCtrlTemplService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFCTDetailBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPFCTDetailBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSPFCTDETAILID = "PSPFCTDETAILID";
    public static final String FIELD_PSPFCTDETAILNAME = "PSPFCTDETAILNAME";
    public static final String FIELD_PSPFCTRLTEMPLID = "PSPFCTRLTEMPLID";
    public static final String FIELD_PSPFCTRLTEMPLNAME = "PSPFCTRLTEMPLNAME";
    public static final String FIELD_PUBOBJ = "PUBOBJ";
    public static final String FIELD_TEMPLCODE = "TEMPLCODE";
    public static final String FIELD_TEMPLCODE2 = "TEMPLCODE2";
    public static final String FIELD_TEMPLCODE3 = "TEMPLCODE3";
    public static final String FIELD_TEMPLCODE4 = "TEMPLCODE4";
    public static final String FIELD_TEMPLDESC = "TEMPLDESC";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_LOGICNAME = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSPFCTDETAILID = 4;
    private static final int INDEX_PSPFCTDETAILNAME = 5;
    private static final int INDEX_PSPFCTRLTEMPLID = 6;
    private static final int INDEX_PSPFCTRLTEMPLNAME = 7;
    private static final int INDEX_PUBOBJ = 8;
    private static final int INDEX_TEMPLCODE = 9;
    private static final int INDEX_TEMPLCODE2 = 10;
    private static final int INDEX_TEMPLCODE3 = 11;
    private static final int INDEX_TEMPLCODE4 = 12;
    private static final int INDEX_TEMPLDESC = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final int INDEX_VALIDFLAG = 16;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPFCTDetailBase proxyPSPFCTDetailBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pspfctdetailidDirtyFlag = false;
    private boolean pspfctdetailnameDirtyFlag = false;
    private boolean pspfctrltemplidDirtyFlag = false;
    private boolean pspfctrltemplnameDirtyFlag = false;
    private boolean pubobjDirtyFlag = false;
    private boolean templcodeDirtyFlag = false;
    private boolean templcode2DirtyFlag = false;
    private boolean templcode3DirtyFlag = false;
    private boolean templcode4DirtyFlag = false;
    private boolean templdescDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="pspfctdetailid")
    private String pspfctdetailid;
    @Column(name="pspfctdetailname")
    private String pspfctdetailname;
    @Column(name="pspfctrltemplid")
    private String pspfctrltemplid;
    @Column(name="pspfctrltemplname")
    private String pspfctrltemplname;
    @Column(name="pubobj")
    private String pubobj;
    @Column(name="templcode")
    private String templcode;
    @Column(name="templcode2")
    private String templcode2;
    @Column(name="templcode3")
    private String templcode3;
    @Column(name="templcode4")
    private String templcode4;
    @Column(name="templdesc")
    private String templdesc;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSPFCtrlTempLock = new Integer(1);
    private PSPFCtrlTempl pspfctrltemp = null;

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

    public void setPSPFCTDetailId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFCTDetailId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfctdetailid = string;
        this.pspfctdetailidDirtyFlag = true;
    }

    public String getPSPFCTDetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFCTDetailId();
        }
        return this.pspfctdetailid;
    }

    public boolean isPSPFCTDetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFCTDetailIdDirty();
        }
        return this.pspfctdetailidDirtyFlag;
    }

    public void resetPSPFCTDetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFCTDetailId();
            return;
        }
        this.pspfctdetailidDirtyFlag = false;
        this.pspfctdetailid = null;
    }

    public void setPSPFCTDetailName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFCTDetailName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfctdetailname = string;
        this.pspfctdetailnameDirtyFlag = true;
    }

    public String getPSPFCTDetailName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFCTDetailName();
        }
        return this.pspfctdetailname;
    }

    public boolean isPSPFCTDetailNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFCTDetailNameDirty();
        }
        return this.pspfctdetailnameDirtyFlag;
    }

    public void resetPSPFCTDetailName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFCTDetailName();
            return;
        }
        this.pspfctdetailnameDirtyFlag = false;
        this.pspfctdetailname = null;
    }

    public void setPSPFCtrlTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFCtrlTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfctrltemplid = string;
        this.pspfctrltemplidDirtyFlag = true;
    }

    public String getPSPFCtrlTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFCtrlTemplId();
        }
        return this.pspfctrltemplid;
    }

    public boolean isPSPFCtrlTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFCtrlTemplIdDirty();
        }
        return this.pspfctrltemplidDirtyFlag;
    }

    public void resetPSPFCtrlTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFCtrlTemplId();
            return;
        }
        this.pspfctrltemplidDirtyFlag = false;
        this.pspfctrltemplid = null;
    }

    public void setPSPFCtrlTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFCtrlTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfctrltemplname = string;
        this.pspfctrltemplnameDirtyFlag = true;
    }

    public String getPSPFCtrlTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFCtrlTemplName();
        }
        return this.pspfctrltemplname;
    }

    public boolean isPSPFCtrlTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFCtrlTemplNameDirty();
        }
        return this.pspfctrltemplnameDirtyFlag;
    }

    public void resetPSPFCtrlTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFCtrlTemplName();
            return;
        }
        this.pspfctrltemplnameDirtyFlag = false;
        this.pspfctrltemplname = null;
    }

    public void setPubObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pubobj = string;
        this.pubobjDirtyFlag = true;
    }

    public String getPubObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubObj();
        }
        return this.pubobj;
    }

    public boolean isPubObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubObjDirty();
        }
        return this.pubobjDirtyFlag;
    }

    public void resetPubObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubObj();
            return;
        }
        this.pubobjDirtyFlag = false;
        this.pubobj = null;
    }

    public void setTemplCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templcode = string;
        this.templcodeDirtyFlag = true;
    }

    public String getTemplCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCode();
        }
        return this.templcode;
    }

    public boolean isTemplCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCodeDirty();
        }
        return this.templcodeDirtyFlag;
    }

    public void resetTemplCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCode();
            return;
        }
        this.templcodeDirtyFlag = false;
        this.templcode = null;
    }

    public void setTemplCode2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCode2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templcode2 = string;
        this.templcode2DirtyFlag = true;
    }

    public String getTemplCode2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCode2();
        }
        return this.templcode2;
    }

    public boolean isTemplCode2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCode2Dirty();
        }
        return this.templcode2DirtyFlag;
    }

    public void resetTemplCode2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCode2();
            return;
        }
        this.templcode2DirtyFlag = false;
        this.templcode2 = null;
    }

    public void setTemplCode3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCode3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templcode3 = string;
        this.templcode3DirtyFlag = true;
    }

    public String getTemplCode3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCode3();
        }
        return this.templcode3;
    }

    public boolean isTemplCode3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCode3Dirty();
        }
        return this.templcode3DirtyFlag;
    }

    public void resetTemplCode3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCode3();
            return;
        }
        this.templcode3DirtyFlag = false;
        this.templcode3 = null;
    }

    public void setTemplCode4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCode4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templcode4 = string;
        this.templcode4DirtyFlag = true;
    }

    public String getTemplCode4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCode4();
        }
        return this.templcode4;
    }

    public boolean isTemplCode4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCode4Dirty();
        }
        return this.templcode4DirtyFlag;
    }

    public void resetTemplCode4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCode4();
            return;
        }
        this.templcode4DirtyFlag = false;
        this.templcode4 = null;
    }

    public void setTemplDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templdesc = string;
        this.templdescDirtyFlag = true;
    }

    public String getTemplDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplDesc();
        }
        return this.templdesc;
    }

    public boolean isTemplDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplDescDirty();
        }
        return this.templdescDirtyFlag;
    }

    public void resetTemplDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplDesc();
            return;
        }
        this.templdescDirtyFlag = false;
        this.templdesc = null;
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
        PSPFCTDetailBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPFCTDetailBase pSPFCTDetailBase) {
        pSPFCTDetailBase.resetCreateDate();
        pSPFCTDetailBase.resetCreateMan();
        pSPFCTDetailBase.resetLogicName();
        pSPFCTDetailBase.resetMemo();
        pSPFCTDetailBase.resetPSPFCTDetailId();
        pSPFCTDetailBase.resetPSPFCTDetailName();
        pSPFCTDetailBase.resetPSPFCtrlTemplId();
        pSPFCTDetailBase.resetPSPFCtrlTemplName();
        pSPFCTDetailBase.resetPubObj();
        pSPFCTDetailBase.resetTemplCode();
        pSPFCTDetailBase.resetTemplCode2();
        pSPFCTDetailBase.resetTemplCode3();
        pSPFCTDetailBase.resetTemplCode4();
        pSPFCTDetailBase.resetTemplDesc();
        pSPFCTDetailBase.resetUpdateDate();
        pSPFCTDetailBase.resetUpdateMan();
        pSPFCTDetailBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSPFCTDetailIdDirty()) {
            hashMap.put(FIELD_PSPFCTDETAILID, this.getPSPFCTDetailId());
        }
        if (!bl || this.isPSPFCTDetailNameDirty()) {
            hashMap.put(FIELD_PSPFCTDETAILNAME, this.getPSPFCTDetailName());
        }
        if (!bl || this.isPSPFCtrlTemplIdDirty()) {
            hashMap.put(FIELD_PSPFCTRLTEMPLID, this.getPSPFCtrlTemplId());
        }
        if (!bl || this.isPSPFCtrlTemplNameDirty()) {
            hashMap.put(FIELD_PSPFCTRLTEMPLNAME, this.getPSPFCtrlTemplName());
        }
        if (!bl || this.isPubObjDirty()) {
            hashMap.put(FIELD_PUBOBJ, this.getPubObj());
        }
        if (!bl || this.isTemplCodeDirty()) {
            hashMap.put(FIELD_TEMPLCODE, this.getTemplCode());
        }
        if (!bl || this.isTemplCode2Dirty()) {
            hashMap.put(FIELD_TEMPLCODE2, this.getTemplCode2());
        }
        if (!bl || this.isTemplCode3Dirty()) {
            hashMap.put(FIELD_TEMPLCODE3, this.getTemplCode3());
        }
        if (!bl || this.isTemplCode4Dirty()) {
            hashMap.put(FIELD_TEMPLCODE4, this.getTemplCode4());
        }
        if (!bl || this.isTemplDescDirty()) {
            hashMap.put(FIELD_TEMPLDESC, this.getTemplDesc());
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
        return PSPFCTDetailBase.get(this, n);
    }

    private static Object get(PSPFCTDetailBase pSPFCTDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFCTDetailBase.getCreateDate();
            }
            case 1: {
                return pSPFCTDetailBase.getCreateMan();
            }
            case 2: {
                return pSPFCTDetailBase.getLogicName();
            }
            case 3: {
                return pSPFCTDetailBase.getMemo();
            }
            case 4: {
                return pSPFCTDetailBase.getPSPFCTDetailId();
            }
            case 5: {
                return pSPFCTDetailBase.getPSPFCTDetailName();
            }
            case 6: {
                return pSPFCTDetailBase.getPSPFCtrlTemplId();
            }
            case 7: {
                return pSPFCTDetailBase.getPSPFCtrlTemplName();
            }
            case 8: {
                return pSPFCTDetailBase.getPubObj();
            }
            case 9: {
                return pSPFCTDetailBase.getTemplCode();
            }
            case 10: {
                return pSPFCTDetailBase.getTemplCode2();
            }
            case 11: {
                return pSPFCTDetailBase.getTemplCode3();
            }
            case 12: {
                return pSPFCTDetailBase.getTemplCode4();
            }
            case 13: {
                return pSPFCTDetailBase.getTemplDesc();
            }
            case 14: {
                return pSPFCTDetailBase.getUpdateDate();
            }
            case 15: {
                return pSPFCTDetailBase.getUpdateMan();
            }
            case 16: {
                return pSPFCTDetailBase.getValidFlag();
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
        PSPFCTDetailBase.set(this, n, object);
    }

    private static void set(PSPFCTDetailBase pSPFCTDetailBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPFCTDetailBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSPFCTDetailBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSPFCTDetailBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPFCTDetailBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPFCTDetailBase.setPSPFCTDetailId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPFCTDetailBase.setPSPFCTDetailName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPFCTDetailBase.setPSPFCtrlTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPFCTDetailBase.setPSPFCtrlTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPFCTDetailBase.setPubObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSPFCTDetailBase.setTemplCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSPFCTDetailBase.setTemplCode2(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSPFCTDetailBase.setTemplCode3(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSPFCTDetailBase.setTemplCode4(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSPFCTDetailBase.setTemplDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSPFCTDetailBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSPFCTDetailBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSPFCTDetailBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSPFCTDetailBase.isNull(this, n);
    }

    private static boolean isNull(PSPFCTDetailBase pSPFCTDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFCTDetailBase.getCreateDate() == null;
            }
            case 1: {
                return pSPFCTDetailBase.getCreateMan() == null;
            }
            case 2: {
                return pSPFCTDetailBase.getLogicName() == null;
            }
            case 3: {
                return pSPFCTDetailBase.getMemo() == null;
            }
            case 4: {
                return pSPFCTDetailBase.getPSPFCTDetailId() == null;
            }
            case 5: {
                return pSPFCTDetailBase.getPSPFCTDetailName() == null;
            }
            case 6: {
                return pSPFCTDetailBase.getPSPFCtrlTemplId() == null;
            }
            case 7: {
                return pSPFCTDetailBase.getPSPFCtrlTemplName() == null;
            }
            case 8: {
                return pSPFCTDetailBase.getPubObj() == null;
            }
            case 9: {
                return pSPFCTDetailBase.getTemplCode() == null;
            }
            case 10: {
                return pSPFCTDetailBase.getTemplCode2() == null;
            }
            case 11: {
                return pSPFCTDetailBase.getTemplCode3() == null;
            }
            case 12: {
                return pSPFCTDetailBase.getTemplCode4() == null;
            }
            case 13: {
                return pSPFCTDetailBase.getTemplDesc() == null;
            }
            case 14: {
                return pSPFCTDetailBase.getUpdateDate() == null;
            }
            case 15: {
                return pSPFCTDetailBase.getUpdateMan() == null;
            }
            case 16: {
                return pSPFCTDetailBase.getValidFlag() == null;
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
        return PSPFCTDetailBase.contains(this, n);
    }

    private static boolean contains(PSPFCTDetailBase pSPFCTDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFCTDetailBase.isCreateDateDirty();
            }
            case 1: {
                return pSPFCTDetailBase.isCreateManDirty();
            }
            case 2: {
                return pSPFCTDetailBase.isLogicNameDirty();
            }
            case 3: {
                return pSPFCTDetailBase.isMemoDirty();
            }
            case 4: {
                return pSPFCTDetailBase.isPSPFCTDetailIdDirty();
            }
            case 5: {
                return pSPFCTDetailBase.isPSPFCTDetailNameDirty();
            }
            case 6: {
                return pSPFCTDetailBase.isPSPFCtrlTemplIdDirty();
            }
            case 7: {
                return pSPFCTDetailBase.isPSPFCtrlTemplNameDirty();
            }
            case 8: {
                return pSPFCTDetailBase.isPubObjDirty();
            }
            case 9: {
                return pSPFCTDetailBase.isTemplCodeDirty();
            }
            case 10: {
                return pSPFCTDetailBase.isTemplCode2Dirty();
            }
            case 11: {
                return pSPFCTDetailBase.isTemplCode3Dirty();
            }
            case 12: {
                return pSPFCTDetailBase.isTemplCode4Dirty();
            }
            case 13: {
                return pSPFCTDetailBase.isTemplDescDirty();
            }
            case 14: {
                return pSPFCTDetailBase.isUpdateDateDirty();
            }
            case 15: {
                return pSPFCTDetailBase.isUpdateManDirty();
            }
            case 16: {
                return pSPFCTDetailBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPFCTDetailBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPFCTDetailBase pSPFCTDetailBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPFCTDetailBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPFCTDetailBase.getJSONValue((Object)pSPFCTDetailBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPFCTDetailBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPFCTDetailBase.getJSONValue((Object)pSPFCTDetailBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPFCTDetailBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSPFCTDetailBase.getJSONValue((Object)pSPFCTDetailBase.getLogicName()), (boolean)false);
        }
        if (bl || pSPFCTDetailBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPFCTDetailBase.getJSONValue((Object)pSPFCTDetailBase.getMemo()), (boolean)false);
        }
        if (bl || pSPFCTDetailBase.getPSPFCTDetailId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfctdetailid", (Object)PSPFCTDetailBase.getJSONValue((Object)pSPFCTDetailBase.getPSPFCTDetailId()), (boolean)false);
        }
        if (bl || pSPFCTDetailBase.getPSPFCTDetailName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfctdetailname", (Object)PSPFCTDetailBase.getJSONValue((Object)pSPFCTDetailBase.getPSPFCTDetailName()), (boolean)false);
        }
        if (bl || pSPFCTDetailBase.getPSPFCtrlTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfctrltemplid", (Object)PSPFCTDetailBase.getJSONValue((Object)pSPFCTDetailBase.getPSPFCtrlTemplId()), (boolean)false);
        }
        if (bl || pSPFCTDetailBase.getPSPFCtrlTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfctrltemplname", (Object)PSPFCTDetailBase.getJSONValue((Object)pSPFCTDetailBase.getPSPFCtrlTemplName()), (boolean)false);
        }
        if (bl || pSPFCTDetailBase.getPubObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubobj", (Object)PSPFCTDetailBase.getJSONValue((Object)pSPFCTDetailBase.getPubObj()), (boolean)false);
        }
        if (bl || pSPFCTDetailBase.getTemplCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode", (Object)PSPFCTDetailBase.getJSONValue((Object)pSPFCTDetailBase.getTemplCode()), (boolean)false);
        }
        if (bl || pSPFCTDetailBase.getTemplCode2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode2", (Object)PSPFCTDetailBase.getJSONValue((Object)pSPFCTDetailBase.getTemplCode2()), (boolean)false);
        }
        if (bl || pSPFCTDetailBase.getTemplCode3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode3", (Object)PSPFCTDetailBase.getJSONValue((Object)pSPFCTDetailBase.getTemplCode3()), (boolean)false);
        }
        if (bl || pSPFCTDetailBase.getTemplCode4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode4", (Object)PSPFCTDetailBase.getJSONValue((Object)pSPFCTDetailBase.getTemplCode4()), (boolean)false);
        }
        if (bl || pSPFCTDetailBase.getTemplDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templdesc", (Object)PSPFCTDetailBase.getJSONValue((Object)pSPFCTDetailBase.getTemplDesc()), (boolean)false);
        }
        if (bl || pSPFCTDetailBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPFCTDetailBase.getJSONValue((Object)pSPFCTDetailBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPFCTDetailBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPFCTDetailBase.getJSONValue((Object)pSPFCTDetailBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSPFCTDetailBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSPFCTDetailBase.getJSONValue((Object)pSPFCTDetailBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPFCTDetailBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPFCTDetailBase pSPFCTDetailBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPFCTDetailBase.getCreateDate() != null) {
            object = pSPFCTDetailBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFCTDetailBase.getCreateMan() != null) {
            object = pSPFCTDetailBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFCTDetailBase.getLogicName() != null) {
            object = pSPFCTDetailBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFCTDetailBase.getMemo() != null) {
            object = pSPFCTDetailBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPFCTDetailBase.getPSPFCTDetailId() != null) {
            object = pSPFCTDetailBase.getPSPFCTDetailId();
            xmlNode.setAttribute(FIELD_PSPFCTDETAILID, object == null ? "" : (String)object);
        }
        if (bl || pSPFCTDetailBase.getPSPFCTDetailName() != null) {
            object = pSPFCTDetailBase.getPSPFCTDetailName();
            xmlNode.setAttribute(FIELD_PSPFCTDETAILNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFCTDetailBase.getPSPFCtrlTemplId() != null) {
            object = pSPFCTDetailBase.getPSPFCtrlTemplId();
            xmlNode.setAttribute(FIELD_PSPFCTRLTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSPFCTDetailBase.getPSPFCtrlTemplName() != null) {
            object = pSPFCTDetailBase.getPSPFCtrlTemplName();
            xmlNode.setAttribute(FIELD_PSPFCTRLTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFCTDetailBase.getPubObj() != null) {
            object = pSPFCTDetailBase.getPubObj();
            xmlNode.setAttribute(FIELD_PUBOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSPFCTDetailBase.getTemplCode() != null) {
            object = pSPFCTDetailBase.getTemplCode();
            xmlNode.setAttribute(FIELD_TEMPLCODE, object == null ? "" : (String)object);
        }
        if (bl || pSPFCTDetailBase.getTemplCode2() != null) {
            object = pSPFCTDetailBase.getTemplCode2();
            xmlNode.setAttribute(FIELD_TEMPLCODE2, object == null ? "" : (String)object);
        }
        if (bl || pSPFCTDetailBase.getTemplCode3() != null) {
            object = pSPFCTDetailBase.getTemplCode3();
            xmlNode.setAttribute(FIELD_TEMPLCODE3, object == null ? "" : (String)object);
        }
        if (bl || pSPFCTDetailBase.getTemplCode4() != null) {
            object = pSPFCTDetailBase.getTemplCode4();
            xmlNode.setAttribute(FIELD_TEMPLCODE4, object == null ? "" : (String)object);
        }
        if (bl || pSPFCTDetailBase.getTemplDesc() != null) {
            object = pSPFCTDetailBase.getTemplDesc();
            xmlNode.setAttribute(FIELD_TEMPLDESC, object == null ? "" : (String)object);
        }
        if (bl || pSPFCTDetailBase.getUpdateDate() != null) {
            object = pSPFCTDetailBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFCTDetailBase.getUpdateMan() != null) {
            object = pSPFCTDetailBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFCTDetailBase.getValidFlag() != null) {
            object = pSPFCTDetailBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPFCTDetailBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPFCTDetailBase pSPFCTDetailBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPFCTDetailBase.isCreateDateDirty() && (bl || pSPFCTDetailBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPFCTDetailBase.getCreateDate());
        }
        if (pSPFCTDetailBase.isCreateManDirty() && (bl || pSPFCTDetailBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPFCTDetailBase.getCreateMan());
        }
        if (pSPFCTDetailBase.isLogicNameDirty() && (bl || pSPFCTDetailBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSPFCTDetailBase.getLogicName());
        }
        if (pSPFCTDetailBase.isMemoDirty() && (bl || pSPFCTDetailBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPFCTDetailBase.getMemo());
        }
        if (pSPFCTDetailBase.isPSPFCTDetailIdDirty() && (bl || pSPFCTDetailBase.getPSPFCTDetailId() != null)) {
            iDataObject.set(FIELD_PSPFCTDETAILID, (Object)pSPFCTDetailBase.getPSPFCTDetailId());
        }
        if (pSPFCTDetailBase.isPSPFCTDetailNameDirty() && (bl || pSPFCTDetailBase.getPSPFCTDetailName() != null)) {
            iDataObject.set(FIELD_PSPFCTDETAILNAME, (Object)pSPFCTDetailBase.getPSPFCTDetailName());
        }
        if (pSPFCTDetailBase.isPSPFCtrlTemplIdDirty() && (bl || pSPFCTDetailBase.getPSPFCtrlTemplId() != null)) {
            iDataObject.set(FIELD_PSPFCTRLTEMPLID, (Object)pSPFCTDetailBase.getPSPFCtrlTemplId());
        }
        if (pSPFCTDetailBase.isPSPFCtrlTemplNameDirty() && (bl || pSPFCTDetailBase.getPSPFCtrlTemplName() != null)) {
            iDataObject.set(FIELD_PSPFCTRLTEMPLNAME, (Object)pSPFCTDetailBase.getPSPFCtrlTemplName());
        }
        if (pSPFCTDetailBase.isPubObjDirty() && (bl || pSPFCTDetailBase.getPubObj() != null)) {
            iDataObject.set(FIELD_PUBOBJ, (Object)pSPFCTDetailBase.getPubObj());
        }
        if (pSPFCTDetailBase.isTemplCodeDirty() && (bl || pSPFCTDetailBase.getTemplCode() != null)) {
            iDataObject.set(FIELD_TEMPLCODE, (Object)pSPFCTDetailBase.getTemplCode());
        }
        if (pSPFCTDetailBase.isTemplCode2Dirty() && (bl || pSPFCTDetailBase.getTemplCode2() != null)) {
            iDataObject.set(FIELD_TEMPLCODE2, (Object)pSPFCTDetailBase.getTemplCode2());
        }
        if (pSPFCTDetailBase.isTemplCode3Dirty() && (bl || pSPFCTDetailBase.getTemplCode3() != null)) {
            iDataObject.set(FIELD_TEMPLCODE3, (Object)pSPFCTDetailBase.getTemplCode3());
        }
        if (pSPFCTDetailBase.isTemplCode4Dirty() && (bl || pSPFCTDetailBase.getTemplCode4() != null)) {
            iDataObject.set(FIELD_TEMPLCODE4, (Object)pSPFCTDetailBase.getTemplCode4());
        }
        if (pSPFCTDetailBase.isTemplDescDirty() && (bl || pSPFCTDetailBase.getTemplDesc() != null)) {
            iDataObject.set(FIELD_TEMPLDESC, (Object)pSPFCTDetailBase.getTemplDesc());
        }
        if (pSPFCTDetailBase.isUpdateDateDirty() && (bl || pSPFCTDetailBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPFCTDetailBase.getUpdateDate());
        }
        if (pSPFCTDetailBase.isUpdateManDirty() && (bl || pSPFCTDetailBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPFCTDetailBase.getUpdateMan());
        }
        if (pSPFCTDetailBase.isValidFlagDirty() && (bl || pSPFCTDetailBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSPFCTDetailBase.getValidFlag());
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
        return PSPFCTDetailBase.remove(this, n);
    }

    private static boolean remove(PSPFCTDetailBase pSPFCTDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPFCTDetailBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSPFCTDetailBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSPFCTDetailBase.resetLogicName();
                return true;
            }
            case 3: {
                pSPFCTDetailBase.resetMemo();
                return true;
            }
            case 4: {
                pSPFCTDetailBase.resetPSPFCTDetailId();
                return true;
            }
            case 5: {
                pSPFCTDetailBase.resetPSPFCTDetailName();
                return true;
            }
            case 6: {
                pSPFCTDetailBase.resetPSPFCtrlTemplId();
                return true;
            }
            case 7: {
                pSPFCTDetailBase.resetPSPFCtrlTemplName();
                return true;
            }
            case 8: {
                pSPFCTDetailBase.resetPubObj();
                return true;
            }
            case 9: {
                pSPFCTDetailBase.resetTemplCode();
                return true;
            }
            case 10: {
                pSPFCTDetailBase.resetTemplCode2();
                return true;
            }
            case 11: {
                pSPFCTDetailBase.resetTemplCode3();
                return true;
            }
            case 12: {
                pSPFCTDetailBase.resetTemplCode4();
                return true;
            }
            case 13: {
                pSPFCTDetailBase.resetTemplDesc();
                return true;
            }
            case 14: {
                pSPFCTDetailBase.resetUpdateDate();
                return true;
            }
            case 15: {
                pSPFCTDetailBase.resetUpdateMan();
                return true;
            }
            case 16: {
                pSPFCTDetailBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPFCtrlTempl getPSPFCtrlTemp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFCtrlTemp();
        }
        if (this.getPSPFCtrlTemplId() == null) {
            return null;
        }
        Integer n = this.objPSPFCtrlTempLock;
        synchronized (n) {
            if (this.pspfctrltemp != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFCtrlTemplId(), (Object)this.pspfctrltemp.getPSPFCtrlTemplId()) != 0L) {
                this.pspfctrltemp = null;
            }
            if (this.pspfctrltemp == null) {
                PSPFCtrlTempl pSPFCtrlTempl = new PSPFCtrlTempl();
                pSPFCtrlTempl.setPSPFCtrlTemplId(this.getPSPFCtrlTemplId());
                PSPFCtrlTemplService pSPFCtrlTemplService = (PSPFCtrlTemplService)ServiceGlobal.getService(PSPFCtrlTemplService.class, (SessionFactory)this.getSessionFactory());
                pSPFCtrlTemplService.autoGet(pSPFCtrlTempl);
                this.pspfctrltemp = pSPFCtrlTempl;
            }
            return this.pspfctrltemp;
        }
    }

    private PSPFCTDetailBase getProxyEntity() {
        return this.proxyPSPFCTDetailBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPFCTDetailBase = null;
        if (iDataObject != null && iDataObject instanceof PSPFCTDetailBase) {
            this.proxyPSPFCTDetailBase = (PSPFCTDetailBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFCTDetailService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_LOGICNAME, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSPFCTDETAILID, 4);
        fieldIndexMap.put(FIELD_PSPFCTDETAILNAME, 5);
        fieldIndexMap.put(FIELD_PSPFCTRLTEMPLID, 6);
        fieldIndexMap.put(FIELD_PSPFCTRLTEMPLNAME, 7);
        fieldIndexMap.put(FIELD_PUBOBJ, 8);
        fieldIndexMap.put(FIELD_TEMPLCODE, 9);
        fieldIndexMap.put(FIELD_TEMPLCODE2, 10);
        fieldIndexMap.put(FIELD_TEMPLCODE3, 11);
        fieldIndexMap.put(FIELD_TEMPLCODE4, 12);
        fieldIndexMap.put(FIELD_TEMPLDESC, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
        fieldIndexMap.put(FIELD_VALIDFLAG, 16);
    }
}

