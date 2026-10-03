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
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEViewBaseLiteBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEViewBaseLiteBase.class);
    public static final String FIELD_CAPTION = "CAPTION";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PDTPARAMPRE = "PDTPARAMPRE";
    public static final String FIELD_PDVTPARAM = "PDVTPARAM";
    public static final String FIELD_PREDEFINEDVIEWTYPE = "PREDEFINEVIEWTYPE";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String FIELD_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String FIELD_PSDEVIEWBASETYPE = "PSDEVIEWBASETYPE";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_TITLE = "TITLE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CAPTION = 0;
    private static final int INDEX_MEMO = 1;
    private static final int INDEX_PDTPARAMPRE = 2;
    private static final int INDEX_PDVTPARAM = 3;
    private static final int INDEX_PREDEFINEDVIEWTYPE = 4;
    private static final int INDEX_PSDEID = 5;
    private static final int INDEX_PSDEVIEWBASEID = 6;
    private static final int INDEX_PSDEVIEWBASENAME = 7;
    private static final int INDEX_PSDEVIEWBASETYPE = 8;
    private static final int INDEX_PSSYSTEMID = 9;
    private static final int INDEX_TITLE = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEViewBaseLiteBase proxyPSDEViewBaseLiteBase = null;
    private boolean captionDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pdtparampreDirtyFlag = false;
    private boolean pdvtparamDirtyFlag = false;
    private boolean predefinedviewtypeDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdeviewbaseidDirtyFlag = false;
    private boolean psdeviewbasenameDirtyFlag = false;
    private boolean psdeviewbasetypeDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean titleDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="caption")
    private String caption;
    @Column(name="memo")
    private String memo;
    @Column(name="pdtparampre")
    private String pdtparampre;
    @Column(name="pdvtparam")
    private String pdvtparam;
    @Column(name="predefinedviewtype")
    private String predefinedviewtype;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdeviewbaseid")
    private String psdeviewbaseid;
    @Column(name="psdeviewbasename")
    private String psdeviewbasename;
    @Column(name="psdeviewbasetype")
    private String psdeviewbasetype;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="title")
    private String title;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

    public void setCaption(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCaption(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.caption = string;
        this.captionDirtyFlag = true;
    }

    public String getCaption() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCaption();
        }
        return this.caption;
    }

    public boolean isCaptionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCaptionDirty();
        }
        return this.captionDirtyFlag;
    }

    public void resetCaption() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCaption();
            return;
        }
        this.captionDirtyFlag = false;
        this.caption = null;
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

    public void setPDTParamPre(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPDTParamPre(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pdtparampre = string;
        this.pdtparampreDirtyFlag = true;
    }

    public String getPDTParamPre() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPDTParamPre();
        }
        return this.pdtparampre;
    }

    public boolean isPDTParamPreDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPDTParamPreDirty();
        }
        return this.pdtparampreDirtyFlag;
    }

    public void resetPDTParamPre() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPDTParamPre();
            return;
        }
        this.pdtparampreDirtyFlag = false;
        this.pdtparampre = null;
    }

    public void setPDVTParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPDVTParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pdvtparam = string;
        this.pdvtparamDirtyFlag = true;
    }

    public String getPDVTParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPDVTParam();
        }
        return this.pdvtparam;
    }

    public boolean isPDVTParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPDVTParamDirty();
        }
        return this.pdvtparamDirtyFlag;
    }

    public void resetPDVTParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPDVTParam();
            return;
        }
        this.pdvtparamDirtyFlag = false;
        this.pdvtparam = null;
    }

    public void setPredefinedViewType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPredefinedViewType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.predefinedviewtype = string;
        this.predefinedviewtypeDirtyFlag = true;
    }

    public String getPredefinedViewType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPredefinedViewType();
        }
        return this.predefinedviewtype;
    }

    public boolean isPredefinedViewTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPredefinedViewTypeDirty();
        }
        return this.predefinedviewtypeDirtyFlag;
    }

    public void resetPredefinedViewType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPredefinedViewType();
            return;
        }
        this.predefinedviewtypeDirtyFlag = false;
        this.predefinedviewtype = null;
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

    public void setPSDEViewBaseId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBaseId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewbaseid = string;
        this.psdeviewbaseidDirtyFlag = true;
    }

    public String getPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBaseId();
        }
        return this.psdeviewbaseid;
    }

    public boolean isPSDEViewBaseIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBaseIdDirty();
        }
        return this.psdeviewbaseidDirtyFlag;
    }

    public void resetPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBaseId();
            return;
        }
        this.psdeviewbaseidDirtyFlag = false;
        this.psdeviewbaseid = null;
    }

    public void setPSDEViewBaseName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBaseName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewbasename = string;
        this.psdeviewbasenameDirtyFlag = true;
    }

    public String getPSDEViewBaseName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBaseName();
        }
        return this.psdeviewbasename;
    }

    public boolean isPSDEViewBaseNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBaseNameDirty();
        }
        return this.psdeviewbasenameDirtyFlag;
    }

    public void resetPSDEViewBaseName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBaseName();
            return;
        }
        this.psdeviewbasenameDirtyFlag = false;
        this.psdeviewbasename = null;
    }

    public void setPSDEViewBaseType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBaseType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewbasetype = string;
        this.psdeviewbasetypeDirtyFlag = true;
    }

    public String getPSDEViewBaseType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBaseType();
        }
        return this.psdeviewbasetype;
    }

    public boolean isPSDEViewBaseTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBaseTypeDirty();
        }
        return this.psdeviewbasetypeDirtyFlag;
    }

    public void resetPSDEViewBaseType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBaseType();
            return;
        }
        this.psdeviewbasetypeDirtyFlag = false;
        this.psdeviewbasetype = null;
    }

    public void setPSSystemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemid = string;
        this.pssystemidDirtyFlag = true;
    }

    public String getPSSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemId();
        }
        return this.pssystemid;
    }

    public boolean isPSSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemIdDirty();
        }
        return this.pssystemidDirtyFlag;
    }

    public void resetPSSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemId();
            return;
        }
        this.pssystemidDirtyFlag = false;
        this.pssystemid = null;
    }

    public void setTitle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTitle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.title = string;
        this.titleDirtyFlag = true;
    }

    public String getTitle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitle();
        }
        return this.title;
    }

    public boolean isTitleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTitleDirty();
        }
        return this.titleDirtyFlag;
    }

    public void resetTitle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTitle();
            return;
        }
        this.titleDirtyFlag = false;
        this.title = null;
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
        PSDEViewBaseLiteBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEViewBaseLiteBase pSDEViewBaseLiteBase) {
        pSDEViewBaseLiteBase.resetCaption();
        pSDEViewBaseLiteBase.resetMemo();
        pSDEViewBaseLiteBase.resetPDTParamPre();
        pSDEViewBaseLiteBase.resetPDVTParam();
        pSDEViewBaseLiteBase.resetPredefinedViewType();
        pSDEViewBaseLiteBase.resetPSDEId();
        pSDEViewBaseLiteBase.resetPSDEViewBaseId();
        pSDEViewBaseLiteBase.resetPSDEViewBaseName();
        pSDEViewBaseLiteBase.resetPSDEViewBaseType();
        pSDEViewBaseLiteBase.resetPSSystemId();
        pSDEViewBaseLiteBase.resetTitle();
        pSDEViewBaseLiteBase.resetUpdateDate();
        pSDEViewBaseLiteBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCaptionDirty()) {
            hashMap.put(FIELD_CAPTION, this.getCaption());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPDTParamPreDirty()) {
            hashMap.put(FIELD_PDTPARAMPRE, this.getPDTParamPre());
        }
        if (!bl || this.isPDVTParamDirty()) {
            hashMap.put(FIELD_PDVTPARAM, this.getPDVTParam());
        }
        if (!bl || this.isPredefinedViewTypeDirty()) {
            hashMap.put(FIELD_PREDEFINEDVIEWTYPE, this.getPredefinedViewType());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDEViewBaseIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASEID, this.getPSDEViewBaseId());
        }
        if (!bl || this.isPSDEViewBaseNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASENAME, this.getPSDEViewBaseName());
        }
        if (!bl || this.isPSDEViewBaseTypeDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASETYPE, this.getPSDEViewBaseType());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isTitleDirty()) {
            hashMap.put(FIELD_TITLE, this.getTitle());
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
        return PSDEViewBaseLiteBase.get(this, n);
    }

    private static Object get(PSDEViewBaseLiteBase pSDEViewBaseLiteBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEViewBaseLiteBase.getCaption();
            }
            case 1: {
                return pSDEViewBaseLiteBase.getMemo();
            }
            case 2: {
                return pSDEViewBaseLiteBase.getPDTParamPre();
            }
            case 3: {
                return pSDEViewBaseLiteBase.getPDVTParam();
            }
            case 4: {
                return pSDEViewBaseLiteBase.getPredefinedViewType();
            }
            case 5: {
                return pSDEViewBaseLiteBase.getPSDEId();
            }
            case 6: {
                return pSDEViewBaseLiteBase.getPSDEViewBaseId();
            }
            case 7: {
                return pSDEViewBaseLiteBase.getPSDEViewBaseName();
            }
            case 8: {
                return pSDEViewBaseLiteBase.getPSDEViewBaseType();
            }
            case 9: {
                return pSDEViewBaseLiteBase.getPSSystemId();
            }
            case 10: {
                return pSDEViewBaseLiteBase.getTitle();
            }
            case 11: {
                return pSDEViewBaseLiteBase.getUpdateDate();
            }
            case 12: {
                return pSDEViewBaseLiteBase.getUpdateMan();
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
        PSDEViewBaseLiteBase.set(this, n, object);
    }

    private static void set(PSDEViewBaseLiteBase pSDEViewBaseLiteBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEViewBaseLiteBase.setCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEViewBaseLiteBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEViewBaseLiteBase.setPDTParamPre(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEViewBaseLiteBase.setPDVTParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEViewBaseLiteBase.setPredefinedViewType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEViewBaseLiteBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEViewBaseLiteBase.setPSDEViewBaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEViewBaseLiteBase.setPSDEViewBaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEViewBaseLiteBase.setPSDEViewBaseType(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEViewBaseLiteBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEViewBaseLiteBase.setTitle(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEViewBaseLiteBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSDEViewBaseLiteBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDEViewBaseLiteBase.isNull(this, n);
    }

    private static boolean isNull(PSDEViewBaseLiteBase pSDEViewBaseLiteBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEViewBaseLiteBase.getCaption() == null;
            }
            case 1: {
                return pSDEViewBaseLiteBase.getMemo() == null;
            }
            case 2: {
                return pSDEViewBaseLiteBase.getPDTParamPre() == null;
            }
            case 3: {
                return pSDEViewBaseLiteBase.getPDVTParam() == null;
            }
            case 4: {
                return pSDEViewBaseLiteBase.getPredefinedViewType() == null;
            }
            case 5: {
                return pSDEViewBaseLiteBase.getPSDEId() == null;
            }
            case 6: {
                return pSDEViewBaseLiteBase.getPSDEViewBaseId() == null;
            }
            case 7: {
                return pSDEViewBaseLiteBase.getPSDEViewBaseName() == null;
            }
            case 8: {
                return pSDEViewBaseLiteBase.getPSDEViewBaseType() == null;
            }
            case 9: {
                return pSDEViewBaseLiteBase.getPSSystemId() == null;
            }
            case 10: {
                return pSDEViewBaseLiteBase.getTitle() == null;
            }
            case 11: {
                return pSDEViewBaseLiteBase.getUpdateDate() == null;
            }
            case 12: {
                return pSDEViewBaseLiteBase.getUpdateMan() == null;
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
        return PSDEViewBaseLiteBase.contains(this, n);
    }

    private static boolean contains(PSDEViewBaseLiteBase pSDEViewBaseLiteBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEViewBaseLiteBase.isCaptionDirty();
            }
            case 1: {
                return pSDEViewBaseLiteBase.isMemoDirty();
            }
            case 2: {
                return pSDEViewBaseLiteBase.isPDTParamPreDirty();
            }
            case 3: {
                return pSDEViewBaseLiteBase.isPDVTParamDirty();
            }
            case 4: {
                return pSDEViewBaseLiteBase.isPredefinedViewTypeDirty();
            }
            case 5: {
                return pSDEViewBaseLiteBase.isPSDEIdDirty();
            }
            case 6: {
                return pSDEViewBaseLiteBase.isPSDEViewBaseIdDirty();
            }
            case 7: {
                return pSDEViewBaseLiteBase.isPSDEViewBaseNameDirty();
            }
            case 8: {
                return pSDEViewBaseLiteBase.isPSDEViewBaseTypeDirty();
            }
            case 9: {
                return pSDEViewBaseLiteBase.isPSSystemIdDirty();
            }
            case 10: {
                return pSDEViewBaseLiteBase.isTitleDirty();
            }
            case 11: {
                return pSDEViewBaseLiteBase.isUpdateDateDirty();
            }
            case 12: {
                return pSDEViewBaseLiteBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEViewBaseLiteBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEViewBaseLiteBase pSDEViewBaseLiteBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEViewBaseLiteBase.getCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"caption", (Object)PSDEViewBaseLiteBase.getJSONValue((Object)pSDEViewBaseLiteBase.getCaption()), (boolean)false);
        }
        if (bl || pSDEViewBaseLiteBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEViewBaseLiteBase.getJSONValue((Object)pSDEViewBaseLiteBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEViewBaseLiteBase.getPDTParamPre() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pdtparampre", (Object)PSDEViewBaseLiteBase.getJSONValue((Object)pSDEViewBaseLiteBase.getPDTParamPre()), (boolean)false);
        }
        if (bl || pSDEViewBaseLiteBase.getPDVTParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pdvtparam", (Object)PSDEViewBaseLiteBase.getJSONValue((Object)pSDEViewBaseLiteBase.getPDVTParam()), (boolean)false);
        }
        if (bl || pSDEViewBaseLiteBase.getPredefinedViewType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefineviewtype", (Object)PSDEViewBaseLiteBase.getJSONValue((Object)pSDEViewBaseLiteBase.getPredefinedViewType()), (boolean)false);
        }
        if (bl || pSDEViewBaseLiteBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEViewBaseLiteBase.getJSONValue((Object)pSDEViewBaseLiteBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEViewBaseLiteBase.getPSDEViewBaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbaseid", (Object)PSDEViewBaseLiteBase.getJSONValue((Object)pSDEViewBaseLiteBase.getPSDEViewBaseId()), (boolean)false);
        }
        if (bl || pSDEViewBaseLiteBase.getPSDEViewBaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbasename", (Object)PSDEViewBaseLiteBase.getJSONValue((Object)pSDEViewBaseLiteBase.getPSDEViewBaseName()), (boolean)false);
        }
        if (bl || pSDEViewBaseLiteBase.getPSDEViewBaseType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbasetype", (Object)PSDEViewBaseLiteBase.getJSONValue((Object)pSDEViewBaseLiteBase.getPSDEViewBaseType()), (boolean)false);
        }
        if (bl || pSDEViewBaseLiteBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSDEViewBaseLiteBase.getJSONValue((Object)pSDEViewBaseLiteBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSDEViewBaseLiteBase.getTitle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"title", (Object)PSDEViewBaseLiteBase.getJSONValue((Object)pSDEViewBaseLiteBase.getTitle()), (boolean)false);
        }
        if (bl || pSDEViewBaseLiteBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEViewBaseLiteBase.getJSONValue((Object)pSDEViewBaseLiteBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEViewBaseLiteBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEViewBaseLiteBase.getJSONValue((Object)pSDEViewBaseLiteBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEViewBaseLiteBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEViewBaseLiteBase pSDEViewBaseLiteBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEViewBaseLiteBase.getCaption() != null) {
            object = pSDEViewBaseLiteBase.getCaption();
            xmlNode.setAttribute(FIELD_CAPTION, (String)(object == null ? "" : object));
        }
        if (bl || pSDEViewBaseLiteBase.getMemo() != null) {
            object = pSDEViewBaseLiteBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, (String)(object == null ? "" : object));
        }
        if (bl || pSDEViewBaseLiteBase.getPDTParamPre() != null) {
            object = pSDEViewBaseLiteBase.getPDTParamPre();
            xmlNode.setAttribute(FIELD_PDTPARAMPRE, (String)(object == null ? "" : object));
        }
        if (bl || pSDEViewBaseLiteBase.getPDVTParam() != null) {
            object = pSDEViewBaseLiteBase.getPDVTParam();
            xmlNode.setAttribute(FIELD_PDVTPARAM, (String)(object == null ? "" : object));
        }
        if (bl || pSDEViewBaseLiteBase.getPredefinedViewType() != null) {
            object = pSDEViewBaseLiteBase.getPredefinedViewType();
            xmlNode.setAttribute("PREDEFINEDVIEWTYPE", (String)(object == null ? "" : object));
        }
        if (bl || pSDEViewBaseLiteBase.getPSDEId() != null) {
            object = pSDEViewBaseLiteBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, (String)(object == null ? "" : object));
        }
        if (bl || pSDEViewBaseLiteBase.getPSDEViewBaseId() != null) {
            object = pSDEViewBaseLiteBase.getPSDEViewBaseId();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASEID, (String)(object == null ? "" : object));
        }
        if (bl || pSDEViewBaseLiteBase.getPSDEViewBaseName() != null) {
            object = pSDEViewBaseLiteBase.getPSDEViewBaseName();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEViewBaseLiteBase.getPSDEViewBaseType() != null) {
            object = pSDEViewBaseLiteBase.getPSDEViewBaseType();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASETYPE, (String)(object == null ? "" : object));
        }
        if (bl || pSDEViewBaseLiteBase.getPSSystemId() != null) {
            object = pSDEViewBaseLiteBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, (String)(object == null ? "" : object));
        }
        if (bl || pSDEViewBaseLiteBase.getTitle() != null) {
            object = pSDEViewBaseLiteBase.getTitle();
            xmlNode.setAttribute(FIELD_TITLE, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseLiteBase.getUpdateDate() != null) {
            object = pSDEViewBaseLiteBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEViewBaseLiteBase.getUpdateMan() != null) {
            object = pSDEViewBaseLiteBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEViewBaseLiteBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEViewBaseLiteBase pSDEViewBaseLiteBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEViewBaseLiteBase.isCaptionDirty() && (bl || pSDEViewBaseLiteBase.getCaption() != null)) {
            iDataObject.set(FIELD_CAPTION, (Object)pSDEViewBaseLiteBase.getCaption());
        }
        if (pSDEViewBaseLiteBase.isMemoDirty() && (bl || pSDEViewBaseLiteBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEViewBaseLiteBase.getMemo());
        }
        if (pSDEViewBaseLiteBase.isPDTParamPreDirty() && (bl || pSDEViewBaseLiteBase.getPDTParamPre() != null)) {
            iDataObject.set(FIELD_PDTPARAMPRE, (Object)pSDEViewBaseLiteBase.getPDTParamPre());
        }
        if (pSDEViewBaseLiteBase.isPDVTParamDirty() && (bl || pSDEViewBaseLiteBase.getPDVTParam() != null)) {
            iDataObject.set(FIELD_PDVTPARAM, (Object)pSDEViewBaseLiteBase.getPDVTParam());
        }
        if (pSDEViewBaseLiteBase.isPredefinedViewTypeDirty() && (bl || pSDEViewBaseLiteBase.getPredefinedViewType() != null)) {
            iDataObject.set(FIELD_PREDEFINEDVIEWTYPE, (Object)pSDEViewBaseLiteBase.getPredefinedViewType());
        }
        if (pSDEViewBaseLiteBase.isPSDEIdDirty() && (bl || pSDEViewBaseLiteBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEViewBaseLiteBase.getPSDEId());
        }
        if (pSDEViewBaseLiteBase.isPSDEViewBaseIdDirty() && (bl || pSDEViewBaseLiteBase.getPSDEViewBaseId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASEID, (Object)pSDEViewBaseLiteBase.getPSDEViewBaseId());
        }
        if (pSDEViewBaseLiteBase.isPSDEViewBaseNameDirty() && (bl || pSDEViewBaseLiteBase.getPSDEViewBaseName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASENAME, (Object)pSDEViewBaseLiteBase.getPSDEViewBaseName());
        }
        if (pSDEViewBaseLiteBase.isPSDEViewBaseTypeDirty() && (bl || pSDEViewBaseLiteBase.getPSDEViewBaseType() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASETYPE, (Object)pSDEViewBaseLiteBase.getPSDEViewBaseType());
        }
        if (pSDEViewBaseLiteBase.isPSSystemIdDirty() && (bl || pSDEViewBaseLiteBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSDEViewBaseLiteBase.getPSSystemId());
        }
        if (pSDEViewBaseLiteBase.isTitleDirty() && (bl || pSDEViewBaseLiteBase.getTitle() != null)) {
            iDataObject.set(FIELD_TITLE, (Object)pSDEViewBaseLiteBase.getTitle());
        }
        if (pSDEViewBaseLiteBase.isUpdateDateDirty() && (bl || pSDEViewBaseLiteBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEViewBaseLiteBase.getUpdateDate());
        }
        if (pSDEViewBaseLiteBase.isUpdateManDirty() && (bl || pSDEViewBaseLiteBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEViewBaseLiteBase.getUpdateMan());
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
        return PSDEViewBaseLiteBase.remove(this, n);
    }

    private static boolean remove(PSDEViewBaseLiteBase pSDEViewBaseLiteBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEViewBaseLiteBase.resetCaption();
                return true;
            }
            case 1: {
                pSDEViewBaseLiteBase.resetMemo();
                return true;
            }
            case 2: {
                pSDEViewBaseLiteBase.resetPDTParamPre();
                return true;
            }
            case 3: {
                pSDEViewBaseLiteBase.resetPDVTParam();
                return true;
            }
            case 4: {
                pSDEViewBaseLiteBase.resetPredefinedViewType();
                return true;
            }
            case 5: {
                pSDEViewBaseLiteBase.resetPSDEId();
                return true;
            }
            case 6: {
                pSDEViewBaseLiteBase.resetPSDEViewBaseId();
                return true;
            }
            case 7: {
                pSDEViewBaseLiteBase.resetPSDEViewBaseName();
                return true;
            }
            case 8: {
                pSDEViewBaseLiteBase.resetPSDEViewBaseType();
                return true;
            }
            case 9: {
                pSDEViewBaseLiteBase.resetPSSystemId();
                return true;
            }
            case 10: {
                pSDEViewBaseLiteBase.resetTitle();
                return true;
            }
            case 11: {
                pSDEViewBaseLiteBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSDEViewBaseLiteBase.resetUpdateMan();
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
    public PSSystem getPSSystem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystem();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        Integer n = this.objPSSystemLock;
        synchronized (n) {
            if (this.pssystem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemId(), (Object)this.pssystem.getPSSystemId()) != 0L) {
                this.pssystem = null;
            }
            if (this.pssystem == null) {
                PSSystem pSSystem = new PSSystem();
                pSSystem.setPSSystemId(this.getPSSystemId());
                PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
                pSSystemService.autoGet(pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    private PSDEViewBaseLiteBase getProxyEntity() {
        return this.proxyPSDEViewBaseLiteBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEViewBaseLiteBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEViewBaseLiteBase) {
            this.proxyPSDEViewBaseLiteBase = (PSDEViewBaseLiteBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseLiteService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CAPTION, 0);
        fieldIndexMap.put(FIELD_MEMO, 1);
        fieldIndexMap.put(FIELD_PDTPARAMPRE, 2);
        fieldIndexMap.put(FIELD_PDVTPARAM, 3);
        fieldIndexMap.put(FIELD_PREDEFINEDVIEWTYPE, 4);
        fieldIndexMap.put(FIELD_PSDEID, 5);
        fieldIndexMap.put(FIELD_PSDEVIEWBASEID, 6);
        fieldIndexMap.put(FIELD_PSDEVIEWBASENAME, 7);
        fieldIndexMap.put(FIELD_PSDEVIEWBASETYPE, 8);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 9);
        fieldIndexMap.put(FIELD_TITLE, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
    }
}

