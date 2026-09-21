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
package net.ibizsys.pscore.srv.devcenter.entity;

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

public abstract class PSDCBulletinBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCBulletinBase.class);
    public static final String FIELD_AUTHOR = "AUTHOR";
    public static final String FIELD_BEGINTIME = "BEGINTIME";
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENDTIME = "ENDTIME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCBULLETINID = "PSDCBULLETINID";
    public static final String FIELD_PSDCBULLETINNAME = "PSDCBULLETINNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PUBFLAG = "PUBFLAG";
    public static final String FIELD_PUBTIME = "PUBTIME";
    public static final String FIELD_TARGETTYPE = "TARGETTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_AUTHOR = 0;
    private static final int INDEX_BEGINTIME = 1;
    private static final int INDEX_CONTENT = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_ENDTIME = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_PSDCBULLETINID = 7;
    private static final int INDEX_PSDCBULLETINNAME = 8;
    private static final int INDEX_PSDEVCENTERID = 9;
    private static final int INDEX_PSDEVCENTERNAME = 10;
    private static final int INDEX_PUBFLAG = 11;
    private static final int INDEX_PUBTIME = 12;
    private static final int INDEX_TARGETTYPE = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCBulletinBase proxyPSDCBulletinBase = null;
    private boolean authorDirtyFlag = false;
    private boolean begintimeDirtyFlag = false;
    private boolean contentDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean endtimeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcbulletinidDirtyFlag = false;
    private boolean psdcbulletinnameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean pubflagDirtyFlag = false;
    private boolean pubtimeDirtyFlag = false;
    private boolean targettypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="author")
    private String author;
    @Column(name="begintime")
    private Timestamp begintime;
    @Column(name="content")
    private String content;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="endtime")
    private Timestamp endtime;
    @Column(name="memo")
    private String memo;
    @Column(name="psdcbulletinid")
    private String psdcbulletinid;
    @Column(name="psdcbulletinname")
    private String psdcbulletinname;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="pubflag")
    private Integer pubflag;
    @Column(name="pubtime")
    private Timestamp pubtime;
    @Column(name="targettype")
    private String targettype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;

    public void setAUTHOR(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAUTHOR(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.author = string;
        this.authorDirtyFlag = true;
    }

    public String getAUTHOR() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAUTHOR();
        }
        return this.author;
    }

    public boolean isAUTHORDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAUTHORDirty();
        }
        return this.authorDirtyFlag;
    }

    public void resetAUTHOR() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAUTHOR();
            return;
        }
        this.authorDirtyFlag = false;
        this.author = null;
    }

    public void setBeginTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBeginTime(timestamp);
            return;
        }
        this.begintime = timestamp;
        this.begintimeDirtyFlag = true;
    }

    public Timestamp getBeginTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeginTime();
        }
        return this.begintime;
    }

    public boolean isBeginTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBeginTimeDirty();
        }
        return this.begintimeDirtyFlag;
    }

    public void resetBeginTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBeginTime();
            return;
        }
        this.begintimeDirtyFlag = false;
        this.begintime = null;
    }

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

    public void setEndTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEndTime(timestamp);
            return;
        }
        this.endtime = timestamp;
        this.endtimeDirtyFlag = true;
    }

    public Timestamp getEndTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEndTime();
        }
        return this.endtime;
    }

    public boolean isEndTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEndTimeDirty();
        }
        return this.endtimeDirtyFlag;
    }

    public void resetEndTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEndTime();
            return;
        }
        this.endtimeDirtyFlag = false;
        this.endtime = null;
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

    public void setPSDCBulletinId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCBulletinId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcbulletinid = string;
        this.psdcbulletinidDirtyFlag = true;
    }

    public String getPSDCBulletinId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCBulletinId();
        }
        return this.psdcbulletinid;
    }

    public boolean isPSDCBulletinIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCBulletinIdDirty();
        }
        return this.psdcbulletinidDirtyFlag;
    }

    public void resetPSDCBulletinId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCBulletinId();
            return;
        }
        this.psdcbulletinidDirtyFlag = false;
        this.psdcbulletinid = null;
    }

    public void setPSDCBulletinName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCBulletinName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcbulletinname = string;
        this.psdcbulletinnameDirtyFlag = true;
    }

    public String getPSDCBulletinName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCBulletinName();
        }
        return this.psdcbulletinname;
    }

    public boolean isPSDCBulletinNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCBulletinNameDirty();
        }
        return this.psdcbulletinnameDirtyFlag;
    }

    public void resetPSDCBulletinName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCBulletinName();
            return;
        }
        this.psdcbulletinnameDirtyFlag = false;
        this.psdcbulletinname = null;
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

    public void setPUBFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPUBFlag(n);
            return;
        }
        this.pubflag = n;
        this.pubflagDirtyFlag = true;
    }

    public Integer getPUBFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPUBFlag();
        }
        return this.pubflag;
    }

    public boolean isPUBFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPUBFlagDirty();
        }
        return this.pubflagDirtyFlag;
    }

    public void resetPUBFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPUBFlag();
            return;
        }
        this.pubflagDirtyFlag = false;
        this.pubflag = null;
    }

    public void setPUBTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPUBTime(timestamp);
            return;
        }
        this.pubtime = timestamp;
        this.pubtimeDirtyFlag = true;
    }

    public Timestamp getPUBTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPUBTime();
        }
        return this.pubtime;
    }

    public boolean isPUBTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPUBTimeDirty();
        }
        return this.pubtimeDirtyFlag;
    }

    public void resetPUBTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPUBTime();
            return;
        }
        this.pubtimeDirtyFlag = false;
        this.pubtime = null;
    }

    public void setTargetType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTargetType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.targettype = string;
        this.targettypeDirtyFlag = true;
    }

    public String getTargetType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTargetType();
        }
        return this.targettype;
    }

    public boolean isTargetTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTargetTypeDirty();
        }
        return this.targettypeDirtyFlag;
    }

    public void resetTargetType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTargetType();
            return;
        }
        this.targettypeDirtyFlag = false;
        this.targettype = null;
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
        PSDCBulletinBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCBulletinBase pSDCBulletinBase) {
        pSDCBulletinBase.resetAUTHOR();
        pSDCBulletinBase.resetBeginTime();
        pSDCBulletinBase.resetContent();
        pSDCBulletinBase.resetCreateDate();
        pSDCBulletinBase.resetCreateMan();
        pSDCBulletinBase.resetEndTime();
        pSDCBulletinBase.resetMemo();
        pSDCBulletinBase.resetPSDCBulletinId();
        pSDCBulletinBase.resetPSDCBulletinName();
        pSDCBulletinBase.resetPSDevCenterId();
        pSDCBulletinBase.resetPSDevCenterName();
        pSDCBulletinBase.resetPUBFlag();
        pSDCBulletinBase.resetPUBTime();
        pSDCBulletinBase.resetTargetType();
        pSDCBulletinBase.resetUpdateDate();
        pSDCBulletinBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAUTHORDirty()) {
            hashMap.put(FIELD_AUTHOR, this.getAUTHOR());
        }
        if (!bl || this.isBeginTimeDirty()) {
            hashMap.put(FIELD_BEGINTIME, this.getBeginTime());
        }
        if (!bl || this.isContentDirty()) {
            hashMap.put(FIELD_CONTENT, this.getContent());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEndTimeDirty()) {
            hashMap.put(FIELD_ENDTIME, this.getEndTime());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDCBulletinIdDirty()) {
            hashMap.put(FIELD_PSDCBULLETINID, this.getPSDCBulletinId());
        }
        if (!bl || this.isPSDCBulletinNameDirty()) {
            hashMap.put(FIELD_PSDCBULLETINNAME, this.getPSDCBulletinName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPUBFlagDirty()) {
            hashMap.put(FIELD_PUBFLAG, this.getPUBFlag());
        }
        if (!bl || this.isPUBTimeDirty()) {
            hashMap.put(FIELD_PUBTIME, this.getPUBTime());
        }
        if (!bl || this.isTargetTypeDirty()) {
            hashMap.put(FIELD_TARGETTYPE, this.getTargetType());
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
        return PSDCBulletinBase.get(this, n);
    }

    private static Object get(PSDCBulletinBase pSDCBulletinBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCBulletinBase.getAUTHOR();
            }
            case 1: {
                return pSDCBulletinBase.getBeginTime();
            }
            case 2: {
                return pSDCBulletinBase.getContent();
            }
            case 3: {
                return pSDCBulletinBase.getCreateDate();
            }
            case 4: {
                return pSDCBulletinBase.getCreateMan();
            }
            case 5: {
                return pSDCBulletinBase.getEndTime();
            }
            case 6: {
                return pSDCBulletinBase.getMemo();
            }
            case 7: {
                return pSDCBulletinBase.getPSDCBulletinId();
            }
            case 8: {
                return pSDCBulletinBase.getPSDCBulletinName();
            }
            case 9: {
                return pSDCBulletinBase.getPSDevCenterId();
            }
            case 10: {
                return pSDCBulletinBase.getPSDevCenterName();
            }
            case 11: {
                return pSDCBulletinBase.getPUBFlag();
            }
            case 12: {
                return pSDCBulletinBase.getPUBTime();
            }
            case 13: {
                return pSDCBulletinBase.getTargetType();
            }
            case 14: {
                return pSDCBulletinBase.getUpdateDate();
            }
            case 15: {
                return pSDCBulletinBase.getUpdateMan();
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
        PSDCBulletinBase.set(this, n, object);
    }

    private static void set(PSDCBulletinBase pSDCBulletinBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCBulletinBase.setAUTHOR(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDCBulletinBase.setBeginTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDCBulletinBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCBulletinBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSDCBulletinBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCBulletinBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSDCBulletinBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCBulletinBase.setPSDCBulletinId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCBulletinBase.setPSDCBulletinName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCBulletinBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCBulletinBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCBulletinBase.setPUBFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDCBulletinBase.setPUBTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSDCBulletinBase.setTargetType(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCBulletinBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSDCBulletinBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDCBulletinBase.isNull(this, n);
    }

    private static boolean isNull(PSDCBulletinBase pSDCBulletinBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCBulletinBase.getAUTHOR() == null;
            }
            case 1: {
                return pSDCBulletinBase.getBeginTime() == null;
            }
            case 2: {
                return pSDCBulletinBase.getContent() == null;
            }
            case 3: {
                return pSDCBulletinBase.getCreateDate() == null;
            }
            case 4: {
                return pSDCBulletinBase.getCreateMan() == null;
            }
            case 5: {
                return pSDCBulletinBase.getEndTime() == null;
            }
            case 6: {
                return pSDCBulletinBase.getMemo() == null;
            }
            case 7: {
                return pSDCBulletinBase.getPSDCBulletinId() == null;
            }
            case 8: {
                return pSDCBulletinBase.getPSDCBulletinName() == null;
            }
            case 9: {
                return pSDCBulletinBase.getPSDevCenterId() == null;
            }
            case 10: {
                return pSDCBulletinBase.getPSDevCenterName() == null;
            }
            case 11: {
                return pSDCBulletinBase.getPUBFlag() == null;
            }
            case 12: {
                return pSDCBulletinBase.getPUBTime() == null;
            }
            case 13: {
                return pSDCBulletinBase.getTargetType() == null;
            }
            case 14: {
                return pSDCBulletinBase.getUpdateDate() == null;
            }
            case 15: {
                return pSDCBulletinBase.getUpdateMan() == null;
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
        return PSDCBulletinBase.contains(this, n);
    }

    private static boolean contains(PSDCBulletinBase pSDCBulletinBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCBulletinBase.isAUTHORDirty();
            }
            case 1: {
                return pSDCBulletinBase.isBeginTimeDirty();
            }
            case 2: {
                return pSDCBulletinBase.isContentDirty();
            }
            case 3: {
                return pSDCBulletinBase.isCreateDateDirty();
            }
            case 4: {
                return pSDCBulletinBase.isCreateManDirty();
            }
            case 5: {
                return pSDCBulletinBase.isEndTimeDirty();
            }
            case 6: {
                return pSDCBulletinBase.isMemoDirty();
            }
            case 7: {
                return pSDCBulletinBase.isPSDCBulletinIdDirty();
            }
            case 8: {
                return pSDCBulletinBase.isPSDCBulletinNameDirty();
            }
            case 9: {
                return pSDCBulletinBase.isPSDevCenterIdDirty();
            }
            case 10: {
                return pSDCBulletinBase.isPSDevCenterNameDirty();
            }
            case 11: {
                return pSDCBulletinBase.isPUBFlagDirty();
            }
            case 12: {
                return pSDCBulletinBase.isPUBTimeDirty();
            }
            case 13: {
                return pSDCBulletinBase.isTargetTypeDirty();
            }
            case 14: {
                return pSDCBulletinBase.isUpdateDateDirty();
            }
            case 15: {
                return pSDCBulletinBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCBulletinBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCBulletinBase pSDCBulletinBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCBulletinBase.getAUTHOR() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"author", (Object)PSDCBulletinBase.getJSONValue((Object)pSDCBulletinBase.getAUTHOR()), (boolean)false);
        }
        if (bl || pSDCBulletinBase.getBeginTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begintime", (Object)PSDCBulletinBase.getJSONValue((Object)pSDCBulletinBase.getBeginTime()), (boolean)false);
        }
        if (bl || pSDCBulletinBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSDCBulletinBase.getJSONValue((Object)pSDCBulletinBase.getContent()), (boolean)false);
        }
        if (bl || pSDCBulletinBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCBulletinBase.getJSONValue((Object)pSDCBulletinBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCBulletinBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCBulletinBase.getJSONValue((Object)pSDCBulletinBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCBulletinBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSDCBulletinBase.getJSONValue((Object)pSDCBulletinBase.getEndTime()), (boolean)false);
        }
        if (bl || pSDCBulletinBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCBulletinBase.getJSONValue((Object)pSDCBulletinBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCBulletinBase.getPSDCBulletinId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcbulletinid", (Object)PSDCBulletinBase.getJSONValue((Object)pSDCBulletinBase.getPSDCBulletinId()), (boolean)false);
        }
        if (bl || pSDCBulletinBase.getPSDCBulletinName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcbulletinname", (Object)PSDCBulletinBase.getJSONValue((Object)pSDCBulletinBase.getPSDCBulletinName()), (boolean)false);
        }
        if (bl || pSDCBulletinBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCBulletinBase.getJSONValue((Object)pSDCBulletinBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCBulletinBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCBulletinBase.getJSONValue((Object)pSDCBulletinBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCBulletinBase.getPUBFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubflag", (Object)PSDCBulletinBase.getJSONValue((Object)pSDCBulletinBase.getPUBFlag()), (boolean)false);
        }
        if (bl || pSDCBulletinBase.getPUBTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubtime", (Object)PSDCBulletinBase.getJSONValue((Object)pSDCBulletinBase.getPUBTime()), (boolean)false);
        }
        if (bl || pSDCBulletinBase.getTargetType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"targettype", (Object)PSDCBulletinBase.getJSONValue((Object)pSDCBulletinBase.getTargetType()), (boolean)false);
        }
        if (bl || pSDCBulletinBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCBulletinBase.getJSONValue((Object)pSDCBulletinBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCBulletinBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCBulletinBase.getJSONValue((Object)pSDCBulletinBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCBulletinBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCBulletinBase pSDCBulletinBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCBulletinBase.getAUTHOR() != null) {
            object = pSDCBulletinBase.getAUTHOR();
            xmlNode.setAttribute(FIELD_AUTHOR, object == null ? "" : (String)object);
        }
        if (bl || pSDCBulletinBase.getBeginTime() != null) {
            object = pSDCBulletinBase.getBeginTime();
            xmlNode.setAttribute(FIELD_BEGINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCBulletinBase.getContent() != null) {
            object = pSDCBulletinBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSDCBulletinBase.getCreateDate() != null) {
            object = pSDCBulletinBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCBulletinBase.getCreateMan() != null) {
            object = pSDCBulletinBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCBulletinBase.getEndTime() != null) {
            object = pSDCBulletinBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCBulletinBase.getMemo() != null) {
            object = pSDCBulletinBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCBulletinBase.getPSDCBulletinId() != null) {
            object = pSDCBulletinBase.getPSDCBulletinId();
            xmlNode.setAttribute(FIELD_PSDCBULLETINID, object == null ? "" : (String)object);
        }
        if (bl || pSDCBulletinBase.getPSDCBulletinName() != null) {
            object = pSDCBulletinBase.getPSDCBulletinName();
            xmlNode.setAttribute(FIELD_PSDCBULLETINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCBulletinBase.getPSDevCenterId() != null) {
            object = pSDCBulletinBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCBulletinBase.getPSDevCenterName() != null) {
            object = pSDCBulletinBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCBulletinBase.getPUBFlag() != null) {
            object = pSDCBulletinBase.getPUBFlag();
            xmlNode.setAttribute(FIELD_PUBFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCBulletinBase.getPUBTime() != null) {
            object = pSDCBulletinBase.getPUBTime();
            xmlNode.setAttribute(FIELD_PUBTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCBulletinBase.getTargetType() != null) {
            object = pSDCBulletinBase.getTargetType();
            xmlNode.setAttribute(FIELD_TARGETTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDCBulletinBase.getUpdateDate() != null) {
            object = pSDCBulletinBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCBulletinBase.getUpdateMan() != null) {
            object = pSDCBulletinBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCBulletinBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCBulletinBase pSDCBulletinBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCBulletinBase.isAUTHORDirty() && (bl || pSDCBulletinBase.getAUTHOR() != null)) {
            iDataObject.set(FIELD_AUTHOR, (Object)pSDCBulletinBase.getAUTHOR());
        }
        if (pSDCBulletinBase.isBeginTimeDirty() && (bl || pSDCBulletinBase.getBeginTime() != null)) {
            iDataObject.set(FIELD_BEGINTIME, (Object)pSDCBulletinBase.getBeginTime());
        }
        if (pSDCBulletinBase.isContentDirty() && (bl || pSDCBulletinBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSDCBulletinBase.getContent());
        }
        if (pSDCBulletinBase.isCreateDateDirty() && (bl || pSDCBulletinBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCBulletinBase.getCreateDate());
        }
        if (pSDCBulletinBase.isCreateManDirty() && (bl || pSDCBulletinBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCBulletinBase.getCreateMan());
        }
        if (pSDCBulletinBase.isEndTimeDirty() && (bl || pSDCBulletinBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSDCBulletinBase.getEndTime());
        }
        if (pSDCBulletinBase.isMemoDirty() && (bl || pSDCBulletinBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCBulletinBase.getMemo());
        }
        if (pSDCBulletinBase.isPSDCBulletinIdDirty() && (bl || pSDCBulletinBase.getPSDCBulletinId() != null)) {
            iDataObject.set(FIELD_PSDCBULLETINID, (Object)pSDCBulletinBase.getPSDCBulletinId());
        }
        if (pSDCBulletinBase.isPSDCBulletinNameDirty() && (bl || pSDCBulletinBase.getPSDCBulletinName() != null)) {
            iDataObject.set(FIELD_PSDCBULLETINNAME, (Object)pSDCBulletinBase.getPSDCBulletinName());
        }
        if (pSDCBulletinBase.isPSDevCenterIdDirty() && (bl || pSDCBulletinBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCBulletinBase.getPSDevCenterId());
        }
        if (pSDCBulletinBase.isPSDevCenterNameDirty() && (bl || pSDCBulletinBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCBulletinBase.getPSDevCenterName());
        }
        if (pSDCBulletinBase.isPUBFlagDirty() && (bl || pSDCBulletinBase.getPUBFlag() != null)) {
            iDataObject.set(FIELD_PUBFLAG, (Object)pSDCBulletinBase.getPUBFlag());
        }
        if (pSDCBulletinBase.isPUBTimeDirty() && (bl || pSDCBulletinBase.getPUBTime() != null)) {
            iDataObject.set(FIELD_PUBTIME, (Object)pSDCBulletinBase.getPUBTime());
        }
        if (pSDCBulletinBase.isTargetTypeDirty() && (bl || pSDCBulletinBase.getTargetType() != null)) {
            iDataObject.set(FIELD_TARGETTYPE, (Object)pSDCBulletinBase.getTargetType());
        }
        if (pSDCBulletinBase.isUpdateDateDirty() && (bl || pSDCBulletinBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCBulletinBase.getUpdateDate());
        }
        if (pSDCBulletinBase.isUpdateManDirty() && (bl || pSDCBulletinBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCBulletinBase.getUpdateMan());
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
        return PSDCBulletinBase.remove(this, n);
    }

    private static boolean remove(PSDCBulletinBase pSDCBulletinBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCBulletinBase.resetAUTHOR();
                return true;
            }
            case 1: {
                pSDCBulletinBase.resetBeginTime();
                return true;
            }
            case 2: {
                pSDCBulletinBase.resetContent();
                return true;
            }
            case 3: {
                pSDCBulletinBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSDCBulletinBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSDCBulletinBase.resetEndTime();
                return true;
            }
            case 6: {
                pSDCBulletinBase.resetMemo();
                return true;
            }
            case 7: {
                pSDCBulletinBase.resetPSDCBulletinId();
                return true;
            }
            case 8: {
                pSDCBulletinBase.resetPSDCBulletinName();
                return true;
            }
            case 9: {
                pSDCBulletinBase.resetPSDevCenterId();
                return true;
            }
            case 10: {
                pSDCBulletinBase.resetPSDevCenterName();
                return true;
            }
            case 11: {
                pSDCBulletinBase.resetPUBFlag();
                return true;
            }
            case 12: {
                pSDCBulletinBase.resetPUBTime();
                return true;
            }
            case 13: {
                pSDCBulletinBase.resetTargetType();
                return true;
            }
            case 14: {
                pSDCBulletinBase.resetUpdateDate();
                return true;
            }
            case 15: {
                pSDCBulletinBase.resetUpdateMan();
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
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    private PSDCBulletinBase getProxyEntity() {
        return this.proxyPSDCBulletinBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCBulletinBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCBulletinBase) {
            this.proxyPSDCBulletinBase = (PSDCBulletinBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCBulletinService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AUTHOR, 0);
        fieldIndexMap.put(FIELD_BEGINTIME, 1);
        fieldIndexMap.put(FIELD_CONTENT, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_ENDTIME, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_PSDCBULLETINID, 7);
        fieldIndexMap.put(FIELD_PSDCBULLETINNAME, 8);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 9);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 10);
        fieldIndexMap.put(FIELD_PUBFLAG, 11);
        fieldIndexMap.put(FIELD_PUBTIME, 12);
        fieldIndexMap.put(FIELD_TARGETTYPE, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
    }
}

