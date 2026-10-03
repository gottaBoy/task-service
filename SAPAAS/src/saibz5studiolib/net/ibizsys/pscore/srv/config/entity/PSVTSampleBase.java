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
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.entity.PSViewType;
import net.ibizsys.pscore.srv.config.service.PSPFService;
import net.ibizsys.pscore.srv.config.service.PSPFStyleService;
import net.ibizsys.pscore.srv.config.service.PSViewTypeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSVTSampleBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSVTSampleBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEMOURL = "DEMOURL";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFNAME = "PSPFNAME";
    public static final String FIELD_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String FIELD_PSPFSTYLENAME = "PSPFSTYLENAME";
    public static final String FIELD_PSVIEWTYPEID = "PSVIEWTYPEID";
    public static final String FIELD_PSVIEWTYPENAME = "PSVIEWTYPENAME";
    public static final String FIELD_PSVTSAMPLEID = "PSVTSAMPLEID";
    public static final String FIELD_PSVTSAMPLENAME = "PSVTSAMPLENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DEMOURL = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSPFID = 4;
    private static final int INDEX_PSPFNAME = 5;
    private static final int INDEX_PSPFSTYLEID = 6;
    private static final int INDEX_PSPFSTYLENAME = 7;
    private static final int INDEX_PSVIEWTYPEID = 8;
    private static final int INDEX_PSVIEWTYPENAME = 9;
    private static final int INDEX_PSVTSAMPLEID = 10;
    private static final int INDEX_PSVTSAMPLENAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final int INDEX_VALIDFLAG = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSVTSampleBase proxyPSVTSampleBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean demourlDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfnameDirtyFlag = false;
    private boolean pspfstyleidDirtyFlag = false;
    private boolean pspfstylenameDirtyFlag = false;
    private boolean psviewtypeidDirtyFlag = false;
    private boolean psviewtypenameDirtyFlag = false;
    private boolean psvtsampleidDirtyFlag = false;
    private boolean psvtsamplenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="demourl")
    private String demourl;
    @Column(name="memo")
    private String memo;
    @Column(name="pspfid")
    private String pspfid;
    @Column(name="pspfname")
    private String pspfname;
    @Column(name="pspfstyleid")
    private String pspfstyleid;
    @Column(name="pspfstylename")
    private String pspfstylename;
    @Column(name="psviewtypeid")
    private String psviewtypeid;
    @Column(name="psviewtypename")
    private String psviewtypename;
    @Column(name="psvtsampleid")
    private String psvtsampleid;
    @Column(name="psvtsamplename")
    private String psvtsamplename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSPFStyleLock = new Integer(1);
    private PSPFStyle pspfstyle = null;
    private Integer objPSPFLock = new Integer(1);
    private PSPF pspf = null;
    private Integer objPSViewTYpeLock = new Integer(1);
    private PSViewType psviewtype = null;

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

    public void setDemoURL(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDemoURL(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.demourl = string;
        this.demourlDirtyFlag = true;
    }

    public String getDemoURL() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDemoURL();
        }
        return this.demourl;
    }

    public boolean isDemoURLDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDemoURLDirty();
        }
        return this.demourlDirtyFlag;
    }

    public void resetDemoURL() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDemoURL();
            return;
        }
        this.demourlDirtyFlag = false;
        this.demourl = null;
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

    public void setPSPFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfid = string;
        this.pspfidDirtyFlag = true;
    }

    public String getPSPFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFId();
        }
        return this.pspfid;
    }

    public boolean isPSPFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFIdDirty();
        }
        return this.pspfidDirtyFlag;
    }

    public void resetPSPFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFId();
            return;
        }
        this.pspfidDirtyFlag = false;
        this.pspfid = null;
    }

    public void setPSPFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfname = string;
        this.pspfnameDirtyFlag = true;
    }

    public String getPSPFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFName();
        }
        return this.pspfname;
    }

    public boolean isPSPFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFNameDirty();
        }
        return this.pspfnameDirtyFlag;
    }

    public void resetPSPFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFName();
            return;
        }
        this.pspfnameDirtyFlag = false;
        this.pspfname = null;
    }

    public void setPSPFStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfstyleid = string;
        this.pspfstyleidDirtyFlag = true;
    }

    public String getPSPFStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyleId();
        }
        return this.pspfstyleid;
    }

    public boolean isPSPFStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFStyleIdDirty();
        }
        return this.pspfstyleidDirtyFlag;
    }

    public void resetPSPFStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFStyleId();
            return;
        }
        this.pspfstyleidDirtyFlag = false;
        this.pspfstyleid = null;
    }

    public void setPSPFStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfstylename = string;
        this.pspfstylenameDirtyFlag = true;
    }

    public String getPSPFStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyleName();
        }
        return this.pspfstylename;
    }

    public boolean isPSPFStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFStyleNameDirty();
        }
        return this.pspfstylenameDirtyFlag;
    }

    public void resetPSPFStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFStyleName();
            return;
        }
        this.pspfstylenameDirtyFlag = false;
        this.pspfstylename = null;
    }

    public void setPSViewTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewtypeid = string;
        this.psviewtypeidDirtyFlag = true;
    }

    public String getPSViewTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewTypeId();
        }
        return this.psviewtypeid;
    }

    public boolean isPSViewTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewTypeIdDirty();
        }
        return this.psviewtypeidDirtyFlag;
    }

    public void resetPSViewTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewTypeId();
            return;
        }
        this.psviewtypeidDirtyFlag = false;
        this.psviewtypeid = null;
    }

    public void setPSViewTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewtypename = string;
        this.psviewtypenameDirtyFlag = true;
    }

    public String getPSViewTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewTypeName();
        }
        return this.psviewtypename;
    }

    public boolean isPSViewTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewTypeNameDirty();
        }
        return this.psviewtypenameDirtyFlag;
    }

    public void resetPSViewTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewTypeName();
            return;
        }
        this.psviewtypenameDirtyFlag = false;
        this.psviewtypename = null;
    }

    public void setPSVTSampleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSVTSampleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psvtsampleid = string;
        this.psvtsampleidDirtyFlag = true;
    }

    public String getPSVTSampleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSVTSampleId();
        }
        return this.psvtsampleid;
    }

    public boolean isPSVTSampleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSVTSampleIdDirty();
        }
        return this.psvtsampleidDirtyFlag;
    }

    public void resetPSVTSampleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSVTSampleId();
            return;
        }
        this.psvtsampleidDirtyFlag = false;
        this.psvtsampleid = null;
    }

    public void setPSVTSampleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSVTSampleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psvtsamplename = string;
        this.psvtsamplenameDirtyFlag = true;
    }

    public String getPSVTSampleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSVTSampleName();
        }
        return this.psvtsamplename;
    }

    public boolean isPSVTSampleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSVTSampleNameDirty();
        }
        return this.psvtsamplenameDirtyFlag;
    }

    public void resetPSVTSampleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSVTSampleName();
            return;
        }
        this.psvtsamplenameDirtyFlag = false;
        this.psvtsamplename = null;
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
        PSVTSampleBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSVTSampleBase pSVTSampleBase) {
        pSVTSampleBase.resetCreateDate();
        pSVTSampleBase.resetCreateMan();
        pSVTSampleBase.resetDemoURL();
        pSVTSampleBase.resetMemo();
        pSVTSampleBase.resetPSPFId();
        pSVTSampleBase.resetPSPFName();
        pSVTSampleBase.resetPSPFStyleId();
        pSVTSampleBase.resetPSPFStyleName();
        pSVTSampleBase.resetPSViewTypeId();
        pSVTSampleBase.resetPSViewTypeName();
        pSVTSampleBase.resetPSVTSampleId();
        pSVTSampleBase.resetPSVTSampleName();
        pSVTSampleBase.resetUpdateDate();
        pSVTSampleBase.resetUpdateMan();
        pSVTSampleBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDemoURLDirty()) {
            hashMap.put(FIELD_DEMOURL, this.getDemoURL());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSPFIdDirty()) {
            hashMap.put(FIELD_PSPFID, this.getPSPFId());
        }
        if (!bl || this.isPSPFNameDirty()) {
            hashMap.put(FIELD_PSPFNAME, this.getPSPFName());
        }
        if (!bl || this.isPSPFStyleIdDirty()) {
            hashMap.put(FIELD_PSPFSTYLEID, this.getPSPFStyleId());
        }
        if (!bl || this.isPSPFStyleNameDirty()) {
            hashMap.put(FIELD_PSPFSTYLENAME, this.getPSPFStyleName());
        }
        if (!bl || this.isPSViewTypeIdDirty()) {
            hashMap.put(FIELD_PSVIEWTYPEID, this.getPSViewTypeId());
        }
        if (!bl || this.isPSViewTypeNameDirty()) {
            hashMap.put(FIELD_PSVIEWTYPENAME, this.getPSViewTypeName());
        }
        if (!bl || this.isPSVTSampleIdDirty()) {
            hashMap.put(FIELD_PSVTSAMPLEID, this.getPSVTSampleId());
        }
        if (!bl || this.isPSVTSampleNameDirty()) {
            hashMap.put(FIELD_PSVTSAMPLENAME, this.getPSVTSampleName());
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
        return PSVTSampleBase.get(this, n);
    }

    private static Object get(PSVTSampleBase pSVTSampleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSVTSampleBase.getCreateDate();
            }
            case 1: {
                return pSVTSampleBase.getCreateMan();
            }
            case 2: {
                return pSVTSampleBase.getDemoURL();
            }
            case 3: {
                return pSVTSampleBase.getMemo();
            }
            case 4: {
                return pSVTSampleBase.getPSPFId();
            }
            case 5: {
                return pSVTSampleBase.getPSPFName();
            }
            case 6: {
                return pSVTSampleBase.getPSPFStyleId();
            }
            case 7: {
                return pSVTSampleBase.getPSPFStyleName();
            }
            case 8: {
                return pSVTSampleBase.getPSViewTypeId();
            }
            case 9: {
                return pSVTSampleBase.getPSViewTypeName();
            }
            case 10: {
                return pSVTSampleBase.getPSVTSampleId();
            }
            case 11: {
                return pSVTSampleBase.getPSVTSampleName();
            }
            case 12: {
                return pSVTSampleBase.getUpdateDate();
            }
            case 13: {
                return pSVTSampleBase.getUpdateMan();
            }
            case 14: {
                return pSVTSampleBase.getValidFlag();
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
        PSVTSampleBase.set(this, n, object);
    }

    private static void set(PSVTSampleBase pSVTSampleBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSVTSampleBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSVTSampleBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSVTSampleBase.setDemoURL(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSVTSampleBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSVTSampleBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSVTSampleBase.setPSPFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSVTSampleBase.setPSPFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSVTSampleBase.setPSPFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSVTSampleBase.setPSViewTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSVTSampleBase.setPSViewTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSVTSampleBase.setPSVTSampleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSVTSampleBase.setPSVTSampleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSVTSampleBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSVTSampleBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSVTSampleBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSVTSampleBase.isNull(this, n);
    }

    private static boolean isNull(PSVTSampleBase pSVTSampleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSVTSampleBase.getCreateDate() == null;
            }
            case 1: {
                return pSVTSampleBase.getCreateMan() == null;
            }
            case 2: {
                return pSVTSampleBase.getDemoURL() == null;
            }
            case 3: {
                return pSVTSampleBase.getMemo() == null;
            }
            case 4: {
                return pSVTSampleBase.getPSPFId() == null;
            }
            case 5: {
                return pSVTSampleBase.getPSPFName() == null;
            }
            case 6: {
                return pSVTSampleBase.getPSPFStyleId() == null;
            }
            case 7: {
                return pSVTSampleBase.getPSPFStyleName() == null;
            }
            case 8: {
                return pSVTSampleBase.getPSViewTypeId() == null;
            }
            case 9: {
                return pSVTSampleBase.getPSViewTypeName() == null;
            }
            case 10: {
                return pSVTSampleBase.getPSVTSampleId() == null;
            }
            case 11: {
                return pSVTSampleBase.getPSVTSampleName() == null;
            }
            case 12: {
                return pSVTSampleBase.getUpdateDate() == null;
            }
            case 13: {
                return pSVTSampleBase.getUpdateMan() == null;
            }
            case 14: {
                return pSVTSampleBase.getValidFlag() == null;
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
        return PSVTSampleBase.contains(this, n);
    }

    private static boolean contains(PSVTSampleBase pSVTSampleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSVTSampleBase.isCreateDateDirty();
            }
            case 1: {
                return pSVTSampleBase.isCreateManDirty();
            }
            case 2: {
                return pSVTSampleBase.isDemoURLDirty();
            }
            case 3: {
                return pSVTSampleBase.isMemoDirty();
            }
            case 4: {
                return pSVTSampleBase.isPSPFIdDirty();
            }
            case 5: {
                return pSVTSampleBase.isPSPFNameDirty();
            }
            case 6: {
                return pSVTSampleBase.isPSPFStyleIdDirty();
            }
            case 7: {
                return pSVTSampleBase.isPSPFStyleNameDirty();
            }
            case 8: {
                return pSVTSampleBase.isPSViewTypeIdDirty();
            }
            case 9: {
                return pSVTSampleBase.isPSViewTypeNameDirty();
            }
            case 10: {
                return pSVTSampleBase.isPSVTSampleIdDirty();
            }
            case 11: {
                return pSVTSampleBase.isPSVTSampleNameDirty();
            }
            case 12: {
                return pSVTSampleBase.isUpdateDateDirty();
            }
            case 13: {
                return pSVTSampleBase.isUpdateManDirty();
            }
            case 14: {
                return pSVTSampleBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSVTSampleBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSVTSampleBase pSVTSampleBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSVTSampleBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSVTSampleBase.getJSONValue((Object)pSVTSampleBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSVTSampleBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSVTSampleBase.getJSONValue((Object)pSVTSampleBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSVTSampleBase.getDemoURL() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"demourl", (Object)PSVTSampleBase.getJSONValue((Object)pSVTSampleBase.getDemoURL()), (boolean)false);
        }
        if (bl || pSVTSampleBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSVTSampleBase.getJSONValue((Object)pSVTSampleBase.getMemo()), (boolean)false);
        }
        if (bl || pSVTSampleBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSVTSampleBase.getJSONValue((Object)pSVTSampleBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSVTSampleBase.getPSPFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfname", (Object)PSVTSampleBase.getJSONValue((Object)pSVTSampleBase.getPSPFName()), (boolean)false);
        }
        if (bl || pSVTSampleBase.getPSPFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstyleid", (Object)PSVTSampleBase.getJSONValue((Object)pSVTSampleBase.getPSPFStyleId()), (boolean)false);
        }
        if (bl || pSVTSampleBase.getPSPFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstylename", (Object)PSVTSampleBase.getJSONValue((Object)pSVTSampleBase.getPSPFStyleName()), (boolean)false);
        }
        if (bl || pSVTSampleBase.getPSViewTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewtypeid", (Object)PSVTSampleBase.getJSONValue((Object)pSVTSampleBase.getPSViewTypeId()), (boolean)false);
        }
        if (bl || pSVTSampleBase.getPSViewTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewtypename", (Object)PSVTSampleBase.getJSONValue((Object)pSVTSampleBase.getPSViewTypeName()), (boolean)false);
        }
        if (bl || pSVTSampleBase.getPSVTSampleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psvtsampleid", (Object)PSVTSampleBase.getJSONValue((Object)pSVTSampleBase.getPSVTSampleId()), (boolean)false);
        }
        if (bl || pSVTSampleBase.getPSVTSampleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psvtsamplename", (Object)PSVTSampleBase.getJSONValue((Object)pSVTSampleBase.getPSVTSampleName()), (boolean)false);
        }
        if (bl || pSVTSampleBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSVTSampleBase.getJSONValue((Object)pSVTSampleBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSVTSampleBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSVTSampleBase.getJSONValue((Object)pSVTSampleBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSVTSampleBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSVTSampleBase.getJSONValue((Object)pSVTSampleBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSVTSampleBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSVTSampleBase pSVTSampleBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSVTSampleBase.getCreateDate() != null) {
            object = pSVTSampleBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSVTSampleBase.getCreateMan() != null) {
            object = pSVTSampleBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSVTSampleBase.getDemoURL() != null) {
            object = pSVTSampleBase.getDemoURL();
            xmlNode.setAttribute(FIELD_DEMOURL, object == null ? "" : (String)object);
        }
        if (bl || pSVTSampleBase.getMemo() != null) {
            object = pSVTSampleBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSVTSampleBase.getPSPFId() != null) {
            object = pSVTSampleBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSVTSampleBase.getPSPFName() != null) {
            object = pSVTSampleBase.getPSPFName();
            xmlNode.setAttribute(FIELD_PSPFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSVTSampleBase.getPSPFStyleId() != null) {
            object = pSVTSampleBase.getPSPFStyleId();
            xmlNode.setAttribute(FIELD_PSPFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSVTSampleBase.getPSPFStyleName() != null) {
            object = pSVTSampleBase.getPSPFStyleName();
            xmlNode.setAttribute(FIELD_PSPFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSVTSampleBase.getPSViewTypeId() != null) {
            object = pSVTSampleBase.getPSViewTypeId();
            xmlNode.setAttribute(FIELD_PSVIEWTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSVTSampleBase.getPSViewTypeName() != null) {
            object = pSVTSampleBase.getPSViewTypeName();
            xmlNode.setAttribute(FIELD_PSVIEWTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSVTSampleBase.getPSVTSampleId() != null) {
            object = pSVTSampleBase.getPSVTSampleId();
            xmlNode.setAttribute(FIELD_PSVTSAMPLEID, object == null ? "" : (String)object);
        }
        if (bl || pSVTSampleBase.getPSVTSampleName() != null) {
            object = pSVTSampleBase.getPSVTSampleName();
            xmlNode.setAttribute(FIELD_PSVTSAMPLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSVTSampleBase.getUpdateDate() != null) {
            object = pSVTSampleBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSVTSampleBase.getUpdateMan() != null) {
            object = pSVTSampleBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSVTSampleBase.getValidFlag() != null) {
            object = pSVTSampleBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSVTSampleBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSVTSampleBase pSVTSampleBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSVTSampleBase.isCreateDateDirty() && (bl || pSVTSampleBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSVTSampleBase.getCreateDate());
        }
        if (pSVTSampleBase.isCreateManDirty() && (bl || pSVTSampleBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSVTSampleBase.getCreateMan());
        }
        if (pSVTSampleBase.isDemoURLDirty() && (bl || pSVTSampleBase.getDemoURL() != null)) {
            iDataObject.set(FIELD_DEMOURL, (Object)pSVTSampleBase.getDemoURL());
        }
        if (pSVTSampleBase.isMemoDirty() && (bl || pSVTSampleBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSVTSampleBase.getMemo());
        }
        if (pSVTSampleBase.isPSPFIdDirty() && (bl || pSVTSampleBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSVTSampleBase.getPSPFId());
        }
        if (pSVTSampleBase.isPSPFNameDirty() && (bl || pSVTSampleBase.getPSPFName() != null)) {
            iDataObject.set(FIELD_PSPFNAME, (Object)pSVTSampleBase.getPSPFName());
        }
        if (pSVTSampleBase.isPSPFStyleIdDirty() && (bl || pSVTSampleBase.getPSPFStyleId() != null)) {
            iDataObject.set(FIELD_PSPFSTYLEID, (Object)pSVTSampleBase.getPSPFStyleId());
        }
        if (pSVTSampleBase.isPSPFStyleNameDirty() && (bl || pSVTSampleBase.getPSPFStyleName() != null)) {
            iDataObject.set(FIELD_PSPFSTYLENAME, (Object)pSVTSampleBase.getPSPFStyleName());
        }
        if (pSVTSampleBase.isPSViewTypeIdDirty() && (bl || pSVTSampleBase.getPSViewTypeId() != null)) {
            iDataObject.set(FIELD_PSVIEWTYPEID, (Object)pSVTSampleBase.getPSViewTypeId());
        }
        if (pSVTSampleBase.isPSViewTypeNameDirty() && (bl || pSVTSampleBase.getPSViewTypeName() != null)) {
            iDataObject.set(FIELD_PSVIEWTYPENAME, (Object)pSVTSampleBase.getPSViewTypeName());
        }
        if (pSVTSampleBase.isPSVTSampleIdDirty() && (bl || pSVTSampleBase.getPSVTSampleId() != null)) {
            iDataObject.set(FIELD_PSVTSAMPLEID, (Object)pSVTSampleBase.getPSVTSampleId());
        }
        if (pSVTSampleBase.isPSVTSampleNameDirty() && (bl || pSVTSampleBase.getPSVTSampleName() != null)) {
            iDataObject.set(FIELD_PSVTSAMPLENAME, (Object)pSVTSampleBase.getPSVTSampleName());
        }
        if (pSVTSampleBase.isUpdateDateDirty() && (bl || pSVTSampleBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSVTSampleBase.getUpdateDate());
        }
        if (pSVTSampleBase.isUpdateManDirty() && (bl || pSVTSampleBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSVTSampleBase.getUpdateMan());
        }
        if (pSVTSampleBase.isValidFlagDirty() && (bl || pSVTSampleBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSVTSampleBase.getValidFlag());
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
        return PSVTSampleBase.remove(this, n);
    }

    private static boolean remove(PSVTSampleBase pSVTSampleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSVTSampleBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSVTSampleBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSVTSampleBase.resetDemoURL();
                return true;
            }
            case 3: {
                pSVTSampleBase.resetMemo();
                return true;
            }
            case 4: {
                pSVTSampleBase.resetPSPFId();
                return true;
            }
            case 5: {
                pSVTSampleBase.resetPSPFName();
                return true;
            }
            case 6: {
                pSVTSampleBase.resetPSPFStyleId();
                return true;
            }
            case 7: {
                pSVTSampleBase.resetPSPFStyleName();
                return true;
            }
            case 8: {
                pSVTSampleBase.resetPSViewTypeId();
                return true;
            }
            case 9: {
                pSVTSampleBase.resetPSViewTypeName();
                return true;
            }
            case 10: {
                pSVTSampleBase.resetPSVTSampleId();
                return true;
            }
            case 11: {
                pSVTSampleBase.resetPSVTSampleName();
                return true;
            }
            case 12: {
                pSVTSampleBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSVTSampleBase.resetUpdateMan();
                return true;
            }
            case 14: {
                pSVTSampleBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPFStyle getPSPFStyle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyle();
        }
        if (this.getPSPFStyleId() == null) {
            return null;
        }
        Integer n = this.objPSPFStyleLock;
        synchronized (n) {
            if (this.pspfstyle != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFStyleId(), (Object)this.pspfstyle.getPSPFStyleId()) != 0L) {
                this.pspfstyle = null;
            }
            if (this.pspfstyle == null) {
                PSPFStyle pSPFStyle = new PSPFStyle();
                pSPFStyle.setPSPFStyleId(this.getPSPFStyleId());
                PSPFStyleService pSPFStyleService = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)this.getSessionFactory());
                pSPFStyleService.autoGet(pSPFStyle);
                this.pspfstyle = pSPFStyle;
            }
            return this.pspfstyle;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPF getPSPF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPF();
        }
        if (this.getPSPFId() == null) {
            return null;
        }
        Integer n = this.objPSPFLock;
        synchronized (n) {
            if (this.pspf != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFId(), (Object)this.pspf.getPSPFId()) != 0L) {
                this.pspf = null;
            }
            if (this.pspf == null) {
                PSPF pSPF = new PSPF();
                pSPF.setPSPFId(this.getPSPFId());
                PSPFService pSPFService = (PSPFService)ServiceGlobal.getService(PSPFService.class, (SessionFactory)this.getSessionFactory());
                pSPFService.autoGet(pSPF);
                this.pspf = pSPF;
            }
            return this.pspf;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSViewType getPSViewTYpe() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewTYpe();
        }
        if (this.getPSViewTypeId() == null) {
            return null;
        }
        Integer n = this.objPSViewTYpeLock;
        synchronized (n) {
            if (this.psviewtype != null && DataTypeHelper.compare((int)25, (Object)this.getPSViewTypeId(), (Object)this.psviewtype.getPSViewTypeId()) != 0L) {
                this.psviewtype = null;
            }
            if (this.psviewtype == null) {
                PSViewType pSViewType = new PSViewType();
                pSViewType.setPSViewTypeId(this.getPSViewTypeId());
                PSViewTypeService pSViewTypeService = (PSViewTypeService)ServiceGlobal.getService(PSViewTypeService.class, (SessionFactory)this.getSessionFactory());
                pSViewTypeService.autoGet(pSViewType);
                this.psviewtype = pSViewType;
            }
            return this.psviewtype;
        }
    }

    private PSVTSampleBase getProxyEntity() {
        return this.proxyPSVTSampleBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSVTSampleBase = null;
        if (iDataObject != null && iDataObject instanceof PSVTSampleBase) {
            this.proxyPSVTSampleBase = (PSVTSampleBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSVTSampleService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DEMOURL, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSPFID, 4);
        fieldIndexMap.put(FIELD_PSPFNAME, 5);
        fieldIndexMap.put(FIELD_PSPFSTYLEID, 6);
        fieldIndexMap.put(FIELD_PSPFSTYLENAME, 7);
        fieldIndexMap.put(FIELD_PSVIEWTYPEID, 8);
        fieldIndexMap.put(FIELD_PSVIEWTYPENAME, 9);
        fieldIndexMap.put(FIELD_PSVTSAMPLEID, 10);
        fieldIndexMap.put(FIELD_PSVTSAMPLENAME, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
        fieldIndexMap.put(FIELD_VALIDFLAG, 14);
    }
}

