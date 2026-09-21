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
package net.ibizsys.pscore.srv.appdesign.entity;

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
import net.ibizsys.pscore.srv.config.entity.PSEditorType;
import net.ibizsys.pscore.srv.config.entity.PSPFPubCode;
import net.ibizsys.pscore.srv.config.service.PSEditorTypeService;
import net.ibizsys.pscore.srv.config.service.PSPFPubCodeService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysEditorStyle;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysEditorStyleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppEditorTemplBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppEditorTemplBase.class);
    public static final String FIELD_CONTAINERTYPE = "CONTAINERTYPE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSAPPEDITORTEMPLID = "PSAPPEDITORTEMPLID";
    public static final String FIELD_PSAPPEDITORTEMPLNAME = "PSAPPEDITORTEMPLNAME";
    public static final String FIELD_PSEDITORTYPEID = "PSEDITORTYPEID";
    public static final String FIELD_PSEDITORTYPENAME = "PSEDITORTYPENAME";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFPUBCODEID = "PSPFPUBCODEID";
    public static final String FIELD_PSPFPUBCODENAME = "PSPFPUBCODENAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSSYSEDITORSTYLEID = "PSSYSEDITORSTYLEID";
    public static final String FIELD_PSSYSEDITORSTYLENAME = "PSSYSEDITORSTYLENAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PUBOBJ = "PUBOBJ";
    public static final String FIELD_REQCODE = "REQCODE";
    public static final String FIELD_TEMPLCODE = "TEMPLCODE";
    public static final String FIELD_TEMPLCODE2 = "TEMPLCODE2";
    public static final String FIELD_TEMPLCODE3 = "TEMPLCODE3";
    public static final String FIELD_TEMPLCODE4 = "TEMPLCODE4";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CONTAINERTYPE = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSAPPEDITORTEMPLID = 4;
    private static final int INDEX_PSAPPEDITORTEMPLNAME = 5;
    private static final int INDEX_PSEDITORTYPEID = 6;
    private static final int INDEX_PSEDITORTYPENAME = 7;
    private static final int INDEX_PSPFID = 8;
    private static final int INDEX_PSPFPUBCODEID = 9;
    private static final int INDEX_PSPFPUBCODENAME = 10;
    private static final int INDEX_PSSYSAPPID = 11;
    private static final int INDEX_PSSYSAPPNAME = 12;
    private static final int INDEX_PSSYSEDITORSTYLEID = 13;
    private static final int INDEX_PSSYSEDITORSTYLENAME = 14;
    private static final int INDEX_PSSYSTEMID = 15;
    private static final int INDEX_PUBOBJ = 16;
    private static final int INDEX_REQCODE = 17;
    private static final int INDEX_TEMPLCODE = 18;
    private static final int INDEX_TEMPLCODE2 = 19;
    private static final int INDEX_TEMPLCODE3 = 20;
    private static final int INDEX_TEMPLCODE4 = 21;
    private static final int INDEX_UPDATEDATE = 22;
    private static final int INDEX_UPDATEMAN = 23;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppEditorTemplBase proxyPSAppEditorTemplBase = null;
    private boolean containertypeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psappeditortemplidDirtyFlag = false;
    private boolean psappeditortemplnameDirtyFlag = false;
    private boolean pseditortypeidDirtyFlag = false;
    private boolean pseditortypenameDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfpubcodeidDirtyFlag = false;
    private boolean pspfpubcodenameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pssyseditorstyleidDirtyFlag = false;
    private boolean pssyseditorstylenameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pubobjDirtyFlag = false;
    private boolean reqcodeDirtyFlag = false;
    private boolean templcodeDirtyFlag = false;
    private boolean templcode2DirtyFlag = false;
    private boolean templcode3DirtyFlag = false;
    private boolean templcode4DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="containertype")
    private String containertype;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psappeditortemplid")
    private String psappeditortemplid;
    @Column(name="psappeditortemplname")
    private String psappeditortemplname;
    @Column(name="pseditortypeid")
    private String pseditortypeid;
    @Column(name="pseditortypename")
    private String pseditortypename;
    @Column(name="pspfid")
    private String pspfid;
    @Column(name="pspfpubcodeid")
    private String pspfpubcodeid;
    @Column(name="pspfpubcodename")
    private String pspfpubcodename;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="pssyseditorstyleid")
    private String pssyseditorstyleid;
    @Column(name="pssyseditorstylename")
    private String pssyseditorstylename;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pubobj")
    private String pubobj;
    @Column(name="reqcode")
    private String reqcode;
    @Column(name="templcode")
    private String templcode;
    @Column(name="templcode2")
    private String templcode2;
    @Column(name="templcode3")
    private String templcode3;
    @Column(name="templcode4")
    private String templcode4;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSEditorTypeLock = new Integer(1);
    private PSEditorType pseditortype = null;
    private Integer objPSPFPubCodeLock = new Integer(1);
    private PSPFPubCode pspfpubcode = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSSysEditorStyleLock = new Integer(1);
    private PSSysEditorStyle pssyseditorstyle = null;

    public void setContainerType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContainerType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.containertype = string;
        this.containertypeDirtyFlag = true;
    }

    public String getContainerType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContainerType();
        }
        return this.containertype;
    }

    public boolean isContainerTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContainerTypeDirty();
        }
        return this.containertypeDirtyFlag;
    }

    public void resetContainerType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContainerType();
            return;
        }
        this.containertypeDirtyFlag = false;
        this.containertype = null;
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

    public void setPSAppEditorTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppEditorTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappeditortemplid = string;
        this.psappeditortemplidDirtyFlag = true;
    }

    public String getPSAppEditorTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppEditorTemplId();
        }
        return this.psappeditortemplid;
    }

    public boolean isPSAppEditorTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppEditorTemplIdDirty();
        }
        return this.psappeditortemplidDirtyFlag;
    }

    public void resetPSAppEditorTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppEditorTemplId();
            return;
        }
        this.psappeditortemplidDirtyFlag = false;
        this.psappeditortemplid = null;
    }

    public void setPSAppEditorTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppEditorTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappeditortemplname = string;
        this.psappeditortemplnameDirtyFlag = true;
    }

    public String getPSAppEditorTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppEditorTemplName();
        }
        return this.psappeditortemplname;
    }

    public boolean isPSAppEditorTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppEditorTemplNameDirty();
        }
        return this.psappeditortemplnameDirtyFlag;
    }

    public void resetPSAppEditorTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppEditorTemplName();
            return;
        }
        this.psappeditortemplnameDirtyFlag = false;
        this.psappeditortemplname = null;
    }

    public void setPSEditorTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSEditorTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pseditortypeid = string;
        this.pseditortypeidDirtyFlag = true;
    }

    public String getPSEditorTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSEditorTypeId();
        }
        return this.pseditortypeid;
    }

    public boolean isPSEditorTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSEditorTypeIdDirty();
        }
        return this.pseditortypeidDirtyFlag;
    }

    public void resetPSEditorTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSEditorTypeId();
            return;
        }
        this.pseditortypeidDirtyFlag = false;
        this.pseditortypeid = null;
    }

    public void setPSEditorTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSEditorTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pseditortypename = string;
        this.pseditortypenameDirtyFlag = true;
    }

    public String getPSEditorTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSEditorTypeName();
        }
        return this.pseditortypename;
    }

    public boolean isPSEditorTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSEditorTypeNameDirty();
        }
        return this.pseditortypenameDirtyFlag;
    }

    public void resetPSEditorTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSEditorTypeName();
            return;
        }
        this.pseditortypenameDirtyFlag = false;
        this.pseditortypename = null;
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

    public void setPSPFPubCodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPubCodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpubcodeid = string;
        this.pspfpubcodeidDirtyFlag = true;
    }

    public String getPSPFPubCodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPubCodeId();
        }
        return this.pspfpubcodeid;
    }

    public boolean isPSPFPubCodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPubCodeIdDirty();
        }
        return this.pspfpubcodeidDirtyFlag;
    }

    public void resetPSPFPubCodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPubCodeId();
            return;
        }
        this.pspfpubcodeidDirtyFlag = false;
        this.pspfpubcodeid = null;
    }

    public void setPSPFPubCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPubCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpubcodename = string;
        this.pspfpubcodenameDirtyFlag = true;
    }

    public String getPSPFPubCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPubCodeName();
        }
        return this.pspfpubcodename;
    }

    public boolean isPSPFPubCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPubCodeNameDirty();
        }
        return this.pspfpubcodenameDirtyFlag;
    }

    public void resetPSPFPubCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPubCodeName();
            return;
        }
        this.pspfpubcodenameDirtyFlag = false;
        this.pspfpubcodename = null;
    }

    public void setPSSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappid = string;
        this.pssysappidDirtyFlag = true;
    }

    public String getPSSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppId();
        }
        return this.pssysappid;
    }

    public boolean isPSSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppIdDirty();
        }
        return this.pssysappidDirtyFlag;
    }

    public void resetPSSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppId();
            return;
        }
        this.pssysappidDirtyFlag = false;
        this.pssysappid = null;
    }

    public void setPSSysAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappname = string;
        this.pssysappnameDirtyFlag = true;
    }

    public String getPSSysAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppName();
        }
        return this.pssysappname;
    }

    public boolean isPSSysAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppNameDirty();
        }
        return this.pssysappnameDirtyFlag;
    }

    public void resetPSSysAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppName();
            return;
        }
        this.pssysappnameDirtyFlag = false;
        this.pssysappname = null;
    }

    public void setPSSysEditorStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEditorStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseditorstyleid = string;
        this.pssyseditorstyleidDirtyFlag = true;
    }

    public String getPSSysEditorStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEditorStyleId();
        }
        return this.pssyseditorstyleid;
    }

    public boolean isPSSysEditorStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEditorStyleIdDirty();
        }
        return this.pssyseditorstyleidDirtyFlag;
    }

    public void resetPSSysEditorStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEditorStyleId();
            return;
        }
        this.pssyseditorstyleidDirtyFlag = false;
        this.pssyseditorstyleid = null;
    }

    public void setPSSysEditorStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEditorStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseditorstylename = string;
        this.pssyseditorstylenameDirtyFlag = true;
    }

    public String getPSSysEditorStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEditorStyleName();
        }
        return this.pssyseditorstylename;
    }

    public boolean isPSSysEditorStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEditorStyleNameDirty();
        }
        return this.pssyseditorstylenameDirtyFlag;
    }

    public void resetPSSysEditorStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEditorStyleName();
            return;
        }
        this.pssyseditorstylenameDirtyFlag = false;
        this.pssyseditorstylename = null;
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

    public void setREQCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setREQCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.reqcode = string;
        this.reqcodeDirtyFlag = true;
    }

    public String getREQCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getREQCode();
        }
        return this.reqcode;
    }

    public boolean isREQCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isREQCodeDirty();
        }
        return this.reqcodeDirtyFlag;
    }

    public void resetREQCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetREQCode();
            return;
        }
        this.reqcodeDirtyFlag = false;
        this.reqcode = null;
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
        PSAppEditorTemplBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppEditorTemplBase pSAppEditorTemplBase) {
        pSAppEditorTemplBase.resetContainerType();
        pSAppEditorTemplBase.resetCreateDate();
        pSAppEditorTemplBase.resetCreateMan();
        pSAppEditorTemplBase.resetMemo();
        pSAppEditorTemplBase.resetPSAppEditorTemplId();
        pSAppEditorTemplBase.resetPSAppEditorTemplName();
        pSAppEditorTemplBase.resetPSEditorTypeId();
        pSAppEditorTemplBase.resetPSEditorTypeName();
        pSAppEditorTemplBase.resetPSPFId();
        pSAppEditorTemplBase.resetPSPFPubCodeId();
        pSAppEditorTemplBase.resetPSPFPubCodeName();
        pSAppEditorTemplBase.resetPSSysAppId();
        pSAppEditorTemplBase.resetPSSysAppName();
        pSAppEditorTemplBase.resetPSSysEditorStyleId();
        pSAppEditorTemplBase.resetPSSysEditorStyleName();
        pSAppEditorTemplBase.resetPSSystemId();
        pSAppEditorTemplBase.resetPubObj();
        pSAppEditorTemplBase.resetREQCode();
        pSAppEditorTemplBase.resetTemplCode();
        pSAppEditorTemplBase.resetTemplCode2();
        pSAppEditorTemplBase.resetTemplCode3();
        pSAppEditorTemplBase.resetTemplCode4();
        pSAppEditorTemplBase.resetUpdateDate();
        pSAppEditorTemplBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isContainerTypeDirty()) {
            hashMap.put(FIELD_CONTAINERTYPE, this.getContainerType());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSAppEditorTemplIdDirty()) {
            hashMap.put(FIELD_PSAPPEDITORTEMPLID, this.getPSAppEditorTemplId());
        }
        if (!bl || this.isPSAppEditorTemplNameDirty()) {
            hashMap.put(FIELD_PSAPPEDITORTEMPLNAME, this.getPSAppEditorTemplName());
        }
        if (!bl || this.isPSEditorTypeIdDirty()) {
            hashMap.put(FIELD_PSEDITORTYPEID, this.getPSEditorTypeId());
        }
        if (!bl || this.isPSEditorTypeNameDirty()) {
            hashMap.put(FIELD_PSEDITORTYPENAME, this.getPSEditorTypeName());
        }
        if (!bl || this.isPSPFIdDirty()) {
            hashMap.put(FIELD_PSPFID, this.getPSPFId());
        }
        if (!bl || this.isPSPFPubCodeIdDirty()) {
            hashMap.put(FIELD_PSPFPUBCODEID, this.getPSPFPubCodeId());
        }
        if (!bl || this.isPSPFPubCodeNameDirty()) {
            hashMap.put(FIELD_PSPFPUBCODENAME, this.getPSPFPubCodeName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isPSSysEditorStyleIdDirty()) {
            hashMap.put(FIELD_PSSYSEDITORSTYLEID, this.getPSSysEditorStyleId());
        }
        if (!bl || this.isPSSysEditorStyleNameDirty()) {
            hashMap.put(FIELD_PSSYSEDITORSTYLENAME, this.getPSSysEditorStyleName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPubObjDirty()) {
            hashMap.put(FIELD_PUBOBJ, this.getPubObj());
        }
        if (!bl || this.isREQCodeDirty()) {
            hashMap.put(FIELD_REQCODE, this.getREQCode());
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
        return PSAppEditorTemplBase.get(this, n);
    }

    private static Object get(PSAppEditorTemplBase pSAppEditorTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppEditorTemplBase.getContainerType();
            }
            case 1: {
                return pSAppEditorTemplBase.getCreateDate();
            }
            case 2: {
                return pSAppEditorTemplBase.getCreateMan();
            }
            case 3: {
                return pSAppEditorTemplBase.getMemo();
            }
            case 4: {
                return pSAppEditorTemplBase.getPSAppEditorTemplId();
            }
            case 5: {
                return pSAppEditorTemplBase.getPSAppEditorTemplName();
            }
            case 6: {
                return pSAppEditorTemplBase.getPSEditorTypeId();
            }
            case 7: {
                return pSAppEditorTemplBase.getPSEditorTypeName();
            }
            case 8: {
                return pSAppEditorTemplBase.getPSPFId();
            }
            case 9: {
                return pSAppEditorTemplBase.getPSPFPubCodeId();
            }
            case 10: {
                return pSAppEditorTemplBase.getPSPFPubCodeName();
            }
            case 11: {
                return pSAppEditorTemplBase.getPSSysAppId();
            }
            case 12: {
                return pSAppEditorTemplBase.getPSSysAppName();
            }
            case 13: {
                return pSAppEditorTemplBase.getPSSysEditorStyleId();
            }
            case 14: {
                return pSAppEditorTemplBase.getPSSysEditorStyleName();
            }
            case 15: {
                return pSAppEditorTemplBase.getPSSystemId();
            }
            case 16: {
                return pSAppEditorTemplBase.getPubObj();
            }
            case 17: {
                return pSAppEditorTemplBase.getREQCode();
            }
            case 18: {
                return pSAppEditorTemplBase.getTemplCode();
            }
            case 19: {
                return pSAppEditorTemplBase.getTemplCode2();
            }
            case 20: {
                return pSAppEditorTemplBase.getTemplCode3();
            }
            case 21: {
                return pSAppEditorTemplBase.getTemplCode4();
            }
            case 22: {
                return pSAppEditorTemplBase.getUpdateDate();
            }
            case 23: {
                return pSAppEditorTemplBase.getUpdateMan();
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
        PSAppEditorTemplBase.set(this, n, object);
    }

    private static void set(PSAppEditorTemplBase pSAppEditorTemplBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppEditorTemplBase.setContainerType(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSAppEditorTemplBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSAppEditorTemplBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSAppEditorTemplBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSAppEditorTemplBase.setPSAppEditorTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSAppEditorTemplBase.setPSAppEditorTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSAppEditorTemplBase.setPSEditorTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSAppEditorTemplBase.setPSEditorTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSAppEditorTemplBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSAppEditorTemplBase.setPSPFPubCodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSAppEditorTemplBase.setPSPFPubCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSAppEditorTemplBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSAppEditorTemplBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSAppEditorTemplBase.setPSSysEditorStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSAppEditorTemplBase.setPSSysEditorStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSAppEditorTemplBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSAppEditorTemplBase.setPubObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSAppEditorTemplBase.setREQCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSAppEditorTemplBase.setTemplCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSAppEditorTemplBase.setTemplCode2(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSAppEditorTemplBase.setTemplCode3(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSAppEditorTemplBase.setTemplCode4(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSAppEditorTemplBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 23: {
                pSAppEditorTemplBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSAppEditorTemplBase.isNull(this, n);
    }

    private static boolean isNull(PSAppEditorTemplBase pSAppEditorTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppEditorTemplBase.getContainerType() == null;
            }
            case 1: {
                return pSAppEditorTemplBase.getCreateDate() == null;
            }
            case 2: {
                return pSAppEditorTemplBase.getCreateMan() == null;
            }
            case 3: {
                return pSAppEditorTemplBase.getMemo() == null;
            }
            case 4: {
                return pSAppEditorTemplBase.getPSAppEditorTemplId() == null;
            }
            case 5: {
                return pSAppEditorTemplBase.getPSAppEditorTemplName() == null;
            }
            case 6: {
                return pSAppEditorTemplBase.getPSEditorTypeId() == null;
            }
            case 7: {
                return pSAppEditorTemplBase.getPSEditorTypeName() == null;
            }
            case 8: {
                return pSAppEditorTemplBase.getPSPFId() == null;
            }
            case 9: {
                return pSAppEditorTemplBase.getPSPFPubCodeId() == null;
            }
            case 10: {
                return pSAppEditorTemplBase.getPSPFPubCodeName() == null;
            }
            case 11: {
                return pSAppEditorTemplBase.getPSSysAppId() == null;
            }
            case 12: {
                return pSAppEditorTemplBase.getPSSysAppName() == null;
            }
            case 13: {
                return pSAppEditorTemplBase.getPSSysEditorStyleId() == null;
            }
            case 14: {
                return pSAppEditorTemplBase.getPSSysEditorStyleName() == null;
            }
            case 15: {
                return pSAppEditorTemplBase.getPSSystemId() == null;
            }
            case 16: {
                return pSAppEditorTemplBase.getPubObj() == null;
            }
            case 17: {
                return pSAppEditorTemplBase.getREQCode() == null;
            }
            case 18: {
                return pSAppEditorTemplBase.getTemplCode() == null;
            }
            case 19: {
                return pSAppEditorTemplBase.getTemplCode2() == null;
            }
            case 20: {
                return pSAppEditorTemplBase.getTemplCode3() == null;
            }
            case 21: {
                return pSAppEditorTemplBase.getTemplCode4() == null;
            }
            case 22: {
                return pSAppEditorTemplBase.getUpdateDate() == null;
            }
            case 23: {
                return pSAppEditorTemplBase.getUpdateMan() == null;
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
        return PSAppEditorTemplBase.contains(this, n);
    }

    private static boolean contains(PSAppEditorTemplBase pSAppEditorTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppEditorTemplBase.isContainerTypeDirty();
            }
            case 1: {
                return pSAppEditorTemplBase.isCreateDateDirty();
            }
            case 2: {
                return pSAppEditorTemplBase.isCreateManDirty();
            }
            case 3: {
                return pSAppEditorTemplBase.isMemoDirty();
            }
            case 4: {
                return pSAppEditorTemplBase.isPSAppEditorTemplIdDirty();
            }
            case 5: {
                return pSAppEditorTemplBase.isPSAppEditorTemplNameDirty();
            }
            case 6: {
                return pSAppEditorTemplBase.isPSEditorTypeIdDirty();
            }
            case 7: {
                return pSAppEditorTemplBase.isPSEditorTypeNameDirty();
            }
            case 8: {
                return pSAppEditorTemplBase.isPSPFIdDirty();
            }
            case 9: {
                return pSAppEditorTemplBase.isPSPFPubCodeIdDirty();
            }
            case 10: {
                return pSAppEditorTemplBase.isPSPFPubCodeNameDirty();
            }
            case 11: {
                return pSAppEditorTemplBase.isPSSysAppIdDirty();
            }
            case 12: {
                return pSAppEditorTemplBase.isPSSysAppNameDirty();
            }
            case 13: {
                return pSAppEditorTemplBase.isPSSysEditorStyleIdDirty();
            }
            case 14: {
                return pSAppEditorTemplBase.isPSSysEditorStyleNameDirty();
            }
            case 15: {
                return pSAppEditorTemplBase.isPSSystemIdDirty();
            }
            case 16: {
                return pSAppEditorTemplBase.isPubObjDirty();
            }
            case 17: {
                return pSAppEditorTemplBase.isREQCodeDirty();
            }
            case 18: {
                return pSAppEditorTemplBase.isTemplCodeDirty();
            }
            case 19: {
                return pSAppEditorTemplBase.isTemplCode2Dirty();
            }
            case 20: {
                return pSAppEditorTemplBase.isTemplCode3Dirty();
            }
            case 21: {
                return pSAppEditorTemplBase.isTemplCode4Dirty();
            }
            case 22: {
                return pSAppEditorTemplBase.isUpdateDateDirty();
            }
            case 23: {
                return pSAppEditorTemplBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppEditorTemplBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppEditorTemplBase pSAppEditorTemplBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppEditorTemplBase.getContainerType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"containertype", (Object)PSAppEditorTemplBase.getJSONValue((Object)pSAppEditorTemplBase.getContainerType()), (boolean)false);
        }
        if (bl || pSAppEditorTemplBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppEditorTemplBase.getJSONValue((Object)pSAppEditorTemplBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppEditorTemplBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppEditorTemplBase.getJSONValue((Object)pSAppEditorTemplBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppEditorTemplBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAppEditorTemplBase.getJSONValue((Object)pSAppEditorTemplBase.getMemo()), (boolean)false);
        }
        if (bl || pSAppEditorTemplBase.getPSAppEditorTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappeditortemplid", (Object)PSAppEditorTemplBase.getJSONValue((Object)pSAppEditorTemplBase.getPSAppEditorTemplId()), (boolean)false);
        }
        if (bl || pSAppEditorTemplBase.getPSAppEditorTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappeditortemplname", (Object)PSAppEditorTemplBase.getJSONValue((Object)pSAppEditorTemplBase.getPSAppEditorTemplName()), (boolean)false);
        }
        if (bl || pSAppEditorTemplBase.getPSEditorTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pseditortypeid", (Object)PSAppEditorTemplBase.getJSONValue((Object)pSAppEditorTemplBase.getPSEditorTypeId()), (boolean)false);
        }
        if (bl || pSAppEditorTemplBase.getPSEditorTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pseditortypename", (Object)PSAppEditorTemplBase.getJSONValue((Object)pSAppEditorTemplBase.getPSEditorTypeName()), (boolean)false);
        }
        if (bl || pSAppEditorTemplBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSAppEditorTemplBase.getJSONValue((Object)pSAppEditorTemplBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSAppEditorTemplBase.getPSPFPubCodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpubcodeid", (Object)PSAppEditorTemplBase.getJSONValue((Object)pSAppEditorTemplBase.getPSPFPubCodeId()), (boolean)false);
        }
        if (bl || pSAppEditorTemplBase.getPSPFPubCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpubcodename", (Object)PSAppEditorTemplBase.getJSONValue((Object)pSAppEditorTemplBase.getPSPFPubCodeName()), (boolean)false);
        }
        if (bl || pSAppEditorTemplBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSAppEditorTemplBase.getJSONValue((Object)pSAppEditorTemplBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSAppEditorTemplBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSAppEditorTemplBase.getJSONValue((Object)pSAppEditorTemplBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSAppEditorTemplBase.getPSSysEditorStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseditorstyleid", (Object)PSAppEditorTemplBase.getJSONValue((Object)pSAppEditorTemplBase.getPSSysEditorStyleId()), (boolean)false);
        }
        if (bl || pSAppEditorTemplBase.getPSSysEditorStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseditorstylename", (Object)PSAppEditorTemplBase.getJSONValue((Object)pSAppEditorTemplBase.getPSSysEditorStyleName()), (boolean)false);
        }
        if (bl || pSAppEditorTemplBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSAppEditorTemplBase.getJSONValue((Object)pSAppEditorTemplBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSAppEditorTemplBase.getPubObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubobj", (Object)PSAppEditorTemplBase.getJSONValue((Object)pSAppEditorTemplBase.getPubObj()), (boolean)false);
        }
        if (bl || pSAppEditorTemplBase.getREQCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reqcode", (Object)PSAppEditorTemplBase.getJSONValue((Object)pSAppEditorTemplBase.getREQCode()), (boolean)false);
        }
        if (bl || pSAppEditorTemplBase.getTemplCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode", (Object)PSAppEditorTemplBase.getJSONValue((Object)pSAppEditorTemplBase.getTemplCode()), (boolean)false);
        }
        if (bl || pSAppEditorTemplBase.getTemplCode2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode2", (Object)PSAppEditorTemplBase.getJSONValue((Object)pSAppEditorTemplBase.getTemplCode2()), (boolean)false);
        }
        if (bl || pSAppEditorTemplBase.getTemplCode3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode3", (Object)PSAppEditorTemplBase.getJSONValue((Object)pSAppEditorTemplBase.getTemplCode3()), (boolean)false);
        }
        if (bl || pSAppEditorTemplBase.getTemplCode4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode4", (Object)PSAppEditorTemplBase.getJSONValue((Object)pSAppEditorTemplBase.getTemplCode4()), (boolean)false);
        }
        if (bl || pSAppEditorTemplBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppEditorTemplBase.getJSONValue((Object)pSAppEditorTemplBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppEditorTemplBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppEditorTemplBase.getJSONValue((Object)pSAppEditorTemplBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppEditorTemplBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppEditorTemplBase pSAppEditorTemplBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppEditorTemplBase.getContainerType() != null) {
            object = pSAppEditorTemplBase.getContainerType();
            xmlNode.setAttribute(FIELD_CONTAINERTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSAppEditorTemplBase.getCreateDate() != null) {
            object = pSAppEditorTemplBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppEditorTemplBase.getCreateMan() != null) {
            object = pSAppEditorTemplBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppEditorTemplBase.getMemo() != null) {
            object = pSAppEditorTemplBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAppEditorTemplBase.getPSAppEditorTemplId() != null) {
            object = pSAppEditorTemplBase.getPSAppEditorTemplId();
            xmlNode.setAttribute(FIELD_PSAPPEDITORTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSAppEditorTemplBase.getPSAppEditorTemplName() != null) {
            object = pSAppEditorTemplBase.getPSAppEditorTemplName();
            xmlNode.setAttribute(FIELD_PSAPPEDITORTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppEditorTemplBase.getPSEditorTypeId() != null) {
            object = pSAppEditorTemplBase.getPSEditorTypeId();
            xmlNode.setAttribute(FIELD_PSEDITORTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppEditorTemplBase.getPSEditorTypeName() != null) {
            object = pSAppEditorTemplBase.getPSEditorTypeName();
            xmlNode.setAttribute(FIELD_PSEDITORTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppEditorTemplBase.getPSPFId() != null) {
            object = pSAppEditorTemplBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSAppEditorTemplBase.getPSPFPubCodeId() != null) {
            object = pSAppEditorTemplBase.getPSPFPubCodeId();
            xmlNode.setAttribute(FIELD_PSPFPUBCODEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppEditorTemplBase.getPSPFPubCodeName() != null) {
            object = pSAppEditorTemplBase.getPSPFPubCodeName();
            xmlNode.setAttribute(FIELD_PSPFPUBCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppEditorTemplBase.getPSSysAppId() != null) {
            object = pSAppEditorTemplBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppEditorTemplBase.getPSSysAppName() != null) {
            object = pSAppEditorTemplBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppEditorTemplBase.getPSSysEditorStyleId() != null) {
            object = pSAppEditorTemplBase.getPSSysEditorStyleId();
            xmlNode.setAttribute(FIELD_PSSYSEDITORSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppEditorTemplBase.getPSSysEditorStyleName() != null) {
            object = pSAppEditorTemplBase.getPSSysEditorStyleName();
            xmlNode.setAttribute(FIELD_PSSYSEDITORSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppEditorTemplBase.getPSSystemId() != null) {
            object = pSAppEditorTemplBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSAppEditorTemplBase.getPubObj() != null) {
            object = pSAppEditorTemplBase.getPubObj();
            xmlNode.setAttribute(FIELD_PUBOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSAppEditorTemplBase.getREQCode() != null) {
            object = pSAppEditorTemplBase.getREQCode();
            xmlNode.setAttribute(FIELD_REQCODE, object == null ? "" : (String)object);
        }
        if (bl || pSAppEditorTemplBase.getTemplCode() != null) {
            object = pSAppEditorTemplBase.getTemplCode();
            xmlNode.setAttribute(FIELD_TEMPLCODE, object == null ? "" : (String)object);
        }
        if (bl || pSAppEditorTemplBase.getTemplCode2() != null) {
            object = pSAppEditorTemplBase.getTemplCode2();
            xmlNode.setAttribute(FIELD_TEMPLCODE2, object == null ? "" : (String)object);
        }
        if (bl || pSAppEditorTemplBase.getTemplCode3() != null) {
            object = pSAppEditorTemplBase.getTemplCode3();
            xmlNode.setAttribute(FIELD_TEMPLCODE3, object == null ? "" : (String)object);
        }
        if (bl || pSAppEditorTemplBase.getTemplCode4() != null) {
            object = pSAppEditorTemplBase.getTemplCode4();
            xmlNode.setAttribute(FIELD_TEMPLCODE4, object == null ? "" : (String)object);
        }
        if (bl || pSAppEditorTemplBase.getUpdateDate() != null) {
            object = pSAppEditorTemplBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppEditorTemplBase.getUpdateMan() != null) {
            object = pSAppEditorTemplBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppEditorTemplBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppEditorTemplBase pSAppEditorTemplBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppEditorTemplBase.isContainerTypeDirty() && (bl || pSAppEditorTemplBase.getContainerType() != null)) {
            iDataObject.set(FIELD_CONTAINERTYPE, (Object)pSAppEditorTemplBase.getContainerType());
        }
        if (pSAppEditorTemplBase.isCreateDateDirty() && (bl || pSAppEditorTemplBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppEditorTemplBase.getCreateDate());
        }
        if (pSAppEditorTemplBase.isCreateManDirty() && (bl || pSAppEditorTemplBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppEditorTemplBase.getCreateMan());
        }
        if (pSAppEditorTemplBase.isMemoDirty() && (bl || pSAppEditorTemplBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAppEditorTemplBase.getMemo());
        }
        if (pSAppEditorTemplBase.isPSAppEditorTemplIdDirty() && (bl || pSAppEditorTemplBase.getPSAppEditorTemplId() != null)) {
            iDataObject.set(FIELD_PSAPPEDITORTEMPLID, (Object)pSAppEditorTemplBase.getPSAppEditorTemplId());
        }
        if (pSAppEditorTemplBase.isPSAppEditorTemplNameDirty() && (bl || pSAppEditorTemplBase.getPSAppEditorTemplName() != null)) {
            iDataObject.set(FIELD_PSAPPEDITORTEMPLNAME, (Object)pSAppEditorTemplBase.getPSAppEditorTemplName());
        }
        if (pSAppEditorTemplBase.isPSEditorTypeIdDirty() && (bl || pSAppEditorTemplBase.getPSEditorTypeId() != null)) {
            iDataObject.set(FIELD_PSEDITORTYPEID, (Object)pSAppEditorTemplBase.getPSEditorTypeId());
        }
        if (pSAppEditorTemplBase.isPSEditorTypeNameDirty() && (bl || pSAppEditorTemplBase.getPSEditorTypeName() != null)) {
            iDataObject.set(FIELD_PSEDITORTYPENAME, (Object)pSAppEditorTemplBase.getPSEditorTypeName());
        }
        if (pSAppEditorTemplBase.isPSPFIdDirty() && (bl || pSAppEditorTemplBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSAppEditorTemplBase.getPSPFId());
        }
        if (pSAppEditorTemplBase.isPSPFPubCodeIdDirty() && (bl || pSAppEditorTemplBase.getPSPFPubCodeId() != null)) {
            iDataObject.set(FIELD_PSPFPUBCODEID, (Object)pSAppEditorTemplBase.getPSPFPubCodeId());
        }
        if (pSAppEditorTemplBase.isPSPFPubCodeNameDirty() && (bl || pSAppEditorTemplBase.getPSPFPubCodeName() != null)) {
            iDataObject.set(FIELD_PSPFPUBCODENAME, (Object)pSAppEditorTemplBase.getPSPFPubCodeName());
        }
        if (pSAppEditorTemplBase.isPSSysAppIdDirty() && (bl || pSAppEditorTemplBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSAppEditorTemplBase.getPSSysAppId());
        }
        if (pSAppEditorTemplBase.isPSSysAppNameDirty() && (bl || pSAppEditorTemplBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSAppEditorTemplBase.getPSSysAppName());
        }
        if (pSAppEditorTemplBase.isPSSysEditorStyleIdDirty() && (bl || pSAppEditorTemplBase.getPSSysEditorStyleId() != null)) {
            iDataObject.set(FIELD_PSSYSEDITORSTYLEID, (Object)pSAppEditorTemplBase.getPSSysEditorStyleId());
        }
        if (pSAppEditorTemplBase.isPSSysEditorStyleNameDirty() && (bl || pSAppEditorTemplBase.getPSSysEditorStyleName() != null)) {
            iDataObject.set(FIELD_PSSYSEDITORSTYLENAME, (Object)pSAppEditorTemplBase.getPSSysEditorStyleName());
        }
        if (pSAppEditorTemplBase.isPSSystemIdDirty() && (bl || pSAppEditorTemplBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSAppEditorTemplBase.getPSSystemId());
        }
        if (pSAppEditorTemplBase.isPubObjDirty() && (bl || pSAppEditorTemplBase.getPubObj() != null)) {
            iDataObject.set(FIELD_PUBOBJ, (Object)pSAppEditorTemplBase.getPubObj());
        }
        if (pSAppEditorTemplBase.isREQCodeDirty() && (bl || pSAppEditorTemplBase.getREQCode() != null)) {
            iDataObject.set(FIELD_REQCODE, (Object)pSAppEditorTemplBase.getREQCode());
        }
        if (pSAppEditorTemplBase.isTemplCodeDirty() && (bl || pSAppEditorTemplBase.getTemplCode() != null)) {
            iDataObject.set(FIELD_TEMPLCODE, (Object)pSAppEditorTemplBase.getTemplCode());
        }
        if (pSAppEditorTemplBase.isTemplCode2Dirty() && (bl || pSAppEditorTemplBase.getTemplCode2() != null)) {
            iDataObject.set(FIELD_TEMPLCODE2, (Object)pSAppEditorTemplBase.getTemplCode2());
        }
        if (pSAppEditorTemplBase.isTemplCode3Dirty() && (bl || pSAppEditorTemplBase.getTemplCode3() != null)) {
            iDataObject.set(FIELD_TEMPLCODE3, (Object)pSAppEditorTemplBase.getTemplCode3());
        }
        if (pSAppEditorTemplBase.isTemplCode4Dirty() && (bl || pSAppEditorTemplBase.getTemplCode4() != null)) {
            iDataObject.set(FIELD_TEMPLCODE4, (Object)pSAppEditorTemplBase.getTemplCode4());
        }
        if (pSAppEditorTemplBase.isUpdateDateDirty() && (bl || pSAppEditorTemplBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppEditorTemplBase.getUpdateDate());
        }
        if (pSAppEditorTemplBase.isUpdateManDirty() && (bl || pSAppEditorTemplBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppEditorTemplBase.getUpdateMan());
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
        return PSAppEditorTemplBase.remove(this, n);
    }

    private static boolean remove(PSAppEditorTemplBase pSAppEditorTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppEditorTemplBase.resetContainerType();
                return true;
            }
            case 1: {
                pSAppEditorTemplBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSAppEditorTemplBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSAppEditorTemplBase.resetMemo();
                return true;
            }
            case 4: {
                pSAppEditorTemplBase.resetPSAppEditorTemplId();
                return true;
            }
            case 5: {
                pSAppEditorTemplBase.resetPSAppEditorTemplName();
                return true;
            }
            case 6: {
                pSAppEditorTemplBase.resetPSEditorTypeId();
                return true;
            }
            case 7: {
                pSAppEditorTemplBase.resetPSEditorTypeName();
                return true;
            }
            case 8: {
                pSAppEditorTemplBase.resetPSPFId();
                return true;
            }
            case 9: {
                pSAppEditorTemplBase.resetPSPFPubCodeId();
                return true;
            }
            case 10: {
                pSAppEditorTemplBase.resetPSPFPubCodeName();
                return true;
            }
            case 11: {
                pSAppEditorTemplBase.resetPSSysAppId();
                return true;
            }
            case 12: {
                pSAppEditorTemplBase.resetPSSysAppName();
                return true;
            }
            case 13: {
                pSAppEditorTemplBase.resetPSSysEditorStyleId();
                return true;
            }
            case 14: {
                pSAppEditorTemplBase.resetPSSysEditorStyleName();
                return true;
            }
            case 15: {
                pSAppEditorTemplBase.resetPSSystemId();
                return true;
            }
            case 16: {
                pSAppEditorTemplBase.resetPubObj();
                return true;
            }
            case 17: {
                pSAppEditorTemplBase.resetREQCode();
                return true;
            }
            case 18: {
                pSAppEditorTemplBase.resetTemplCode();
                return true;
            }
            case 19: {
                pSAppEditorTemplBase.resetTemplCode2();
                return true;
            }
            case 20: {
                pSAppEditorTemplBase.resetTemplCode3();
                return true;
            }
            case 21: {
                pSAppEditorTemplBase.resetTemplCode4();
                return true;
            }
            case 22: {
                pSAppEditorTemplBase.resetUpdateDate();
                return true;
            }
            case 23: {
                pSAppEditorTemplBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSEditorType getPSEditorType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSEditorType();
        }
        if (this.getPSEditorTypeId() == null) {
            return null;
        }
        Integer n = this.objPSEditorTypeLock;
        synchronized (n) {
            if (this.pseditortype != null && DataTypeHelper.compare((int)25, (Object)this.getPSEditorTypeId(), (Object)this.pseditortype.getPSEditorTypeId()) != 0L) {
                this.pseditortype = null;
            }
            if (this.pseditortype == null) {
                PSEditorType pSEditorType = new PSEditorType();
                pSEditorType.setPSEditorTypeId(this.getPSEditorTypeId());
                PSEditorTypeService pSEditorTypeService = (PSEditorTypeService)ServiceGlobal.getService(PSEditorTypeService.class, (SessionFactory)this.getSessionFactory());
                pSEditorTypeService.autoGet((IEntity)pSEditorType);
                this.pseditortype = pSEditorType;
            }
            return this.pseditortype;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPFPubCode getPSPFPubCode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPubCode();
        }
        if (this.getPSPFPubCodeId() == null) {
            return null;
        }
        Integer n = this.objPSPFPubCodeLock;
        synchronized (n) {
            if (this.pspfpubcode != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFPubCodeId(), (Object)this.pspfpubcode.getPSPFPubCodeId()) != 0L) {
                this.pspfpubcode = null;
            }
            if (this.pspfpubcode == null) {
                PSPFPubCode pSPFPubCode = new PSPFPubCode();
                pSPFPubCode.setPSPFPubCodeId(this.getPSPFPubCodeId());
                PSPFPubCodeService pSPFPubCodeService = (PSPFPubCodeService)ServiceGlobal.getService(PSPFPubCodeService.class, (SessionFactory)this.getSessionFactory());
                pSPFPubCodeService.autoGet((IEntity)pSPFPubCode);
                this.pspfpubcode = pSPFPubCode;
            }
            return this.pspfpubcode;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysApp getPSSysApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysApp();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        Integer n = this.objPSSysAppLock;
        synchronized (n) {
            if (this.pssysapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysAppId(), (Object)this.pssysapp.getPSSysAppId()) != 0L) {
                this.pssysapp = null;
            }
            if (this.pssysapp == null) {
                PSSysApp pSSysApp = new PSSysApp();
                pSSysApp.setPSSysAppId(this.getPSSysAppId());
                PSSysAppService pSSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
                pSSysAppService.autoGet((IEntity)pSSysApp);
                this.pssysapp = pSSysApp;
            }
            return this.pssysapp;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysEditorStyle getPSSysEditorStyle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEditorStyle();
        }
        if (this.getPSSysEditorStyleId() == null) {
            return null;
        }
        Integer n = this.objPSSysEditorStyleLock;
        synchronized (n) {
            if (this.pssyseditorstyle != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysEditorStyleId(), (Object)this.pssyseditorstyle.getPSSysEditorStyleId()) != 0L) {
                this.pssyseditorstyle = null;
            }
            if (this.pssyseditorstyle == null) {
                PSSysEditorStyle pSSysEditorStyle = new PSSysEditorStyle();
                pSSysEditorStyle.setPSSysEditorStyleId(this.getPSSysEditorStyleId());
                PSSysEditorStyleService pSSysEditorStyleService = (PSSysEditorStyleService)ServiceGlobal.getService(PSSysEditorStyleService.class, (SessionFactory)this.getSessionFactory());
                pSSysEditorStyleService.autoGet((IEntity)pSSysEditorStyle);
                this.pssyseditorstyle = pSSysEditorStyle;
            }
            return this.pssyseditorstyle;
        }
    }

    private PSAppEditorTemplBase getProxyEntity() {
        return this.proxyPSAppEditorTemplBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppEditorTemplBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppEditorTemplBase) {
            this.proxyPSAppEditorTemplBase = (PSAppEditorTemplBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppEditorTemplService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONTAINERTYPE, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSAPPEDITORTEMPLID, 4);
        fieldIndexMap.put(FIELD_PSAPPEDITORTEMPLNAME, 5);
        fieldIndexMap.put(FIELD_PSEDITORTYPEID, 6);
        fieldIndexMap.put(FIELD_PSEDITORTYPENAME, 7);
        fieldIndexMap.put(FIELD_PSPFID, 8);
        fieldIndexMap.put(FIELD_PSPFPUBCODEID, 9);
        fieldIndexMap.put(FIELD_PSPFPUBCODENAME, 10);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 11);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 12);
        fieldIndexMap.put(FIELD_PSSYSEDITORSTYLEID, 13);
        fieldIndexMap.put(FIELD_PSSYSEDITORSTYLENAME, 14);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 15);
        fieldIndexMap.put(FIELD_PUBOBJ, 16);
        fieldIndexMap.put(FIELD_REQCODE, 17);
        fieldIndexMap.put(FIELD_TEMPLCODE, 18);
        fieldIndexMap.put(FIELD_TEMPLCODE2, 19);
        fieldIndexMap.put(FIELD_TEMPLCODE3, 20);
        fieldIndexMap.put(FIELD_TEMPLCODE4, 21);
        fieldIndexMap.put(FIELD_UPDATEDATE, 22);
        fieldIndexMap.put(FIELD_UPDATEMAN, 23);
    }
}

