/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
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
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDELNTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDELNTypeBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ICONPATH = "ICONPATH";
    public static final String FIELD_ITEMOBJ = "ITEMOBJ";
    public static final String FIELD_ITEMOBJ2 = "ITEMOBJ2";
    public static final String FIELD_ITEMOBJ3 = "ITEMOBJ3";
    public static final String FIELD_ITEMOBJ4 = "ITEMOBJ4";
    public static final String FIELD_ITEMOBJ5 = "ITEMOBJ5";
    public static final String FIELD_ITEMOBJ6 = "ITEMOBJ6";
    public static final String FIELD_LOGICHOLDER = "LOGICHOLDER";
    public static final String FIELD_LOGICTYPE = "LOGICTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDELNTYPEID = "PSDELNTYPEID";
    public static final String FIELD_PSDELNTYPENAME = "PSDELNTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_ICONPATH = 3;
    private static final int INDEX_ITEMOBJ = 4;
    private static final int INDEX_ITEMOBJ2 = 5;
    private static final int INDEX_ITEMOBJ3 = 6;
    private static final int INDEX_ITEMOBJ4 = 7;
    private static final int INDEX_ITEMOBJ5 = 8;
    private static final int INDEX_ITEMOBJ6 = 9;
    private static final int INDEX_LOGICHOLDER = 10;
    private static final int INDEX_LOGICTYPE = 11;
    private static final int INDEX_MEMO = 12;
    private static final int INDEX_ORDERVALUE = 13;
    private static final int INDEX_PSDELNTYPEID = 14;
    private static final int INDEX_PSDELNTYPENAME = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final int INDEX_VALIDFLAG = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDELNTypeBase proxyPSDELNTypeBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean iconpathDirtyFlag = false;
    private boolean itemobjDirtyFlag = false;
    private boolean itemobj2DirtyFlag = false;
    private boolean itemobj3DirtyFlag = false;
    private boolean itemobj4DirtyFlag = false;
    private boolean itemobj5DirtyFlag = false;
    private boolean itemobj6DirtyFlag = false;
    private boolean logicholderDirtyFlag = false;
    private boolean logictypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdelntypeidDirtyFlag = false;
    private boolean psdelntypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="iconpath")
    private String iconpath;
    @Column(name="itemobj")
    private String itemobj;
    @Column(name="itemobj2")
    private String itemobj2;
    @Column(name="itemobj3")
    private String itemobj3;
    @Column(name="itemobj4")
    private String itemobj4;
    @Column(name="itemobj5")
    private String itemobj5;
    @Column(name="itemobj6")
    private String itemobj6;
    @Column(name="logicholder")
    private Integer logicholder;
    @Column(name="logictype")
    private String logictype;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdelntypeid")
    private String psdelntypeid;
    @Column(name="psdelntypename")
    private String psdelntypename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;

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

    public void setIconPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIconPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.iconpath = string;
        this.iconpathDirtyFlag = true;
    }

    public String getIconPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIconPath();
        }
        return this.iconpath;
    }

    public boolean isIconPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIconPathDirty();
        }
        return this.iconpathDirtyFlag;
    }

    public void resetIconPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIconPath();
            return;
        }
        this.iconpathDirtyFlag = false;
        this.iconpath = null;
    }

    public void setItemObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemobj = string;
        this.itemobjDirtyFlag = true;
    }

    public String getItemObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemObj();
        }
        return this.itemobj;
    }

    public boolean isItemObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemObjDirty();
        }
        return this.itemobjDirtyFlag;
    }

    public void resetItemObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemObj();
            return;
        }
        this.itemobjDirtyFlag = false;
        this.itemobj = null;
    }

    public void setItemObj2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemObj2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemobj2 = string;
        this.itemobj2DirtyFlag = true;
    }

    public String getItemObj2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemObj2();
        }
        return this.itemobj2;
    }

    public boolean isItemObj2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemObj2Dirty();
        }
        return this.itemobj2DirtyFlag;
    }

    public void resetItemObj2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemObj2();
            return;
        }
        this.itemobj2DirtyFlag = false;
        this.itemobj2 = null;
    }

    public void setItemObj3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemObj3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemobj3 = string;
        this.itemobj3DirtyFlag = true;
    }

    public String getItemObj3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemObj3();
        }
        return this.itemobj3;
    }

    public boolean isItemObj3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemObj3Dirty();
        }
        return this.itemobj3DirtyFlag;
    }

    public void resetItemObj3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemObj3();
            return;
        }
        this.itemobj3DirtyFlag = false;
        this.itemobj3 = null;
    }

    public void setItemObj4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemObj4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemobj4 = string;
        this.itemobj4DirtyFlag = true;
    }

    public String getItemObj4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemObj4();
        }
        return this.itemobj4;
    }

    public boolean isItemObj4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemObj4Dirty();
        }
        return this.itemobj4DirtyFlag;
    }

    public void resetItemObj4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemObj4();
            return;
        }
        this.itemobj4DirtyFlag = false;
        this.itemobj4 = null;
    }

    public void setItemObj5(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemObj5(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemobj5 = string;
        this.itemobj5DirtyFlag = true;
    }

    public String getItemObj5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemObj5();
        }
        return this.itemobj5;
    }

    public boolean isItemObj5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemObj5Dirty();
        }
        return this.itemobj5DirtyFlag;
    }

    public void resetItemObj5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemObj5();
            return;
        }
        this.itemobj5DirtyFlag = false;
        this.itemobj5 = null;
    }

    public void setItemObj6(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemObj6(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemobj6 = string;
        this.itemobj6DirtyFlag = true;
    }

    public String getItemObj6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemObj6();
        }
        return this.itemobj6;
    }

    public boolean isItemObj6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemObj6Dirty();
        }
        return this.itemobj6DirtyFlag;
    }

    public void resetItemObj6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemObj6();
            return;
        }
        this.itemobj6DirtyFlag = false;
        this.itemobj6 = null;
    }

    public void setLogicHolder(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicHolder(n);
            return;
        }
        this.logicholder = n;
        this.logicholderDirtyFlag = true;
    }

    public Integer getLogicHolder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicHolder();
        }
        return this.logicholder;
    }

    public boolean isLogicHolderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicHolderDirty();
        }
        return this.logicholderDirtyFlag;
    }

    public void resetLogicHolder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicHolder();
            return;
        }
        this.logicholderDirtyFlag = false;
        this.logicholder = null;
    }

    public void setLogicType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logictype = string;
        this.logictypeDirtyFlag = true;
    }

    public String getLogicType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicType();
        }
        return this.logictype;
    }

    public boolean isLogicTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicTypeDirty();
        }
        return this.logictypeDirtyFlag;
    }

    public void resetLogicType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicType();
            return;
        }
        this.logictypeDirtyFlag = false;
        this.logictype = null;
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

    public void setPSDELNTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELNTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelntypeid = string;
        this.psdelntypeidDirtyFlag = true;
    }

    public String getPSDELNTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELNTypeId();
        }
        return this.psdelntypeid;
    }

    public boolean isPSDELNTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELNTypeIdDirty();
        }
        return this.psdelntypeidDirtyFlag;
    }

    public void resetPSDELNTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELNTypeId();
            return;
        }
        this.psdelntypeidDirtyFlag = false;
        this.psdelntypeid = null;
    }

    public void setPSDELNTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELNTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelntypename = string;
        this.psdelntypenameDirtyFlag = true;
    }

    public String getPSDELNTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELNTypeName();
        }
        return this.psdelntypename;
    }

    public boolean isPSDELNTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELNTypeNameDirty();
        }
        return this.psdelntypenameDirtyFlag;
    }

    public void resetPSDELNTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELNTypeName();
            return;
        }
        this.psdelntypenameDirtyFlag = false;
        this.psdelntypename = null;
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
        PSDELNTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDELNTypeBase pSDELNTypeBase) {
        pSDELNTypeBase.resetCodeName();
        pSDELNTypeBase.resetCreateDate();
        pSDELNTypeBase.resetCreateMan();
        pSDELNTypeBase.resetIconPath();
        pSDELNTypeBase.resetItemObj();
        pSDELNTypeBase.resetItemObj2();
        pSDELNTypeBase.resetItemObj3();
        pSDELNTypeBase.resetItemObj4();
        pSDELNTypeBase.resetItemObj5();
        pSDELNTypeBase.resetItemObj6();
        pSDELNTypeBase.resetLogicHolder();
        pSDELNTypeBase.resetLogicType();
        pSDELNTypeBase.resetMemo();
        pSDELNTypeBase.resetOrderValue();
        pSDELNTypeBase.resetPSDELNTypeId();
        pSDELNTypeBase.resetPSDELNTypeName();
        pSDELNTypeBase.resetUpdateDate();
        pSDELNTypeBase.resetUpdateMan();
        pSDELNTypeBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isIconPathDirty()) {
            hashMap.put(FIELD_ICONPATH, this.getIconPath());
        }
        if (!bl || this.isItemObjDirty()) {
            hashMap.put(FIELD_ITEMOBJ, this.getItemObj());
        }
        if (!bl || this.isItemObj2Dirty()) {
            hashMap.put(FIELD_ITEMOBJ2, this.getItemObj2());
        }
        if (!bl || this.isItemObj3Dirty()) {
            hashMap.put(FIELD_ITEMOBJ3, this.getItemObj3());
        }
        if (!bl || this.isItemObj4Dirty()) {
            hashMap.put(FIELD_ITEMOBJ4, this.getItemObj4());
        }
        if (!bl || this.isItemObj5Dirty()) {
            hashMap.put(FIELD_ITEMOBJ5, this.getItemObj5());
        }
        if (!bl || this.isItemObj6Dirty()) {
            hashMap.put(FIELD_ITEMOBJ6, this.getItemObj6());
        }
        if (!bl || this.isLogicHolderDirty()) {
            hashMap.put(FIELD_LOGICHOLDER, this.getLogicHolder());
        }
        if (!bl || this.isLogicTypeDirty()) {
            hashMap.put(FIELD_LOGICTYPE, this.getLogicType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDELNTypeIdDirty()) {
            hashMap.put(FIELD_PSDELNTYPEID, this.getPSDELNTypeId());
        }
        if (!bl || this.isPSDELNTypeNameDirty()) {
            hashMap.put(FIELD_PSDELNTYPENAME, this.getPSDELNTypeName());
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
        return PSDELNTypeBase.get(this, n);
    }

    private static Object get(PSDELNTypeBase pSDELNTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDELNTypeBase.getCodeName();
            }
            case 1: {
                return pSDELNTypeBase.getCreateDate();
            }
            case 2: {
                return pSDELNTypeBase.getCreateMan();
            }
            case 3: {
                return pSDELNTypeBase.getIconPath();
            }
            case 4: {
                return pSDELNTypeBase.getItemObj();
            }
            case 5: {
                return pSDELNTypeBase.getItemObj2();
            }
            case 6: {
                return pSDELNTypeBase.getItemObj3();
            }
            case 7: {
                return pSDELNTypeBase.getItemObj4();
            }
            case 8: {
                return pSDELNTypeBase.getItemObj5();
            }
            case 9: {
                return pSDELNTypeBase.getItemObj6();
            }
            case 10: {
                return pSDELNTypeBase.getLogicHolder();
            }
            case 11: {
                return pSDELNTypeBase.getLogicType();
            }
            case 12: {
                return pSDELNTypeBase.getMemo();
            }
            case 13: {
                return pSDELNTypeBase.getOrderValue();
            }
            case 14: {
                return pSDELNTypeBase.getPSDELNTypeId();
            }
            case 15: {
                return pSDELNTypeBase.getPSDELNTypeName();
            }
            case 16: {
                return pSDELNTypeBase.getUpdateDate();
            }
            case 17: {
                return pSDELNTypeBase.getUpdateMan();
            }
            case 18: {
                return pSDELNTypeBase.getValidFlag();
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
        PSDELNTypeBase.set(this, n, object);
    }

    private static void set(PSDELNTypeBase pSDELNTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDELNTypeBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDELNTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDELNTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDELNTypeBase.setIconPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDELNTypeBase.setItemObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDELNTypeBase.setItemObj2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDELNTypeBase.setItemObj3(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDELNTypeBase.setItemObj4(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDELNTypeBase.setItemObj5(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDELNTypeBase.setItemObj6(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDELNTypeBase.setLogicHolder(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSDELNTypeBase.setLogicType(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDELNTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDELNTypeBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSDELNTypeBase.setPSDELNTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDELNTypeBase.setPSDELNTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDELNTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSDELNTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDELNTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDELNTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSDELNTypeBase pSDELNTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDELNTypeBase.getCodeName() == null;
            }
            case 1: {
                return pSDELNTypeBase.getCreateDate() == null;
            }
            case 2: {
                return pSDELNTypeBase.getCreateMan() == null;
            }
            case 3: {
                return pSDELNTypeBase.getIconPath() == null;
            }
            case 4: {
                return pSDELNTypeBase.getItemObj() == null;
            }
            case 5: {
                return pSDELNTypeBase.getItemObj2() == null;
            }
            case 6: {
                return pSDELNTypeBase.getItemObj3() == null;
            }
            case 7: {
                return pSDELNTypeBase.getItemObj4() == null;
            }
            case 8: {
                return pSDELNTypeBase.getItemObj5() == null;
            }
            case 9: {
                return pSDELNTypeBase.getItemObj6() == null;
            }
            case 10: {
                return pSDELNTypeBase.getLogicHolder() == null;
            }
            case 11: {
                return pSDELNTypeBase.getLogicType() == null;
            }
            case 12: {
                return pSDELNTypeBase.getMemo() == null;
            }
            case 13: {
                return pSDELNTypeBase.getOrderValue() == null;
            }
            case 14: {
                return pSDELNTypeBase.getPSDELNTypeId() == null;
            }
            case 15: {
                return pSDELNTypeBase.getPSDELNTypeName() == null;
            }
            case 16: {
                return pSDELNTypeBase.getUpdateDate() == null;
            }
            case 17: {
                return pSDELNTypeBase.getUpdateMan() == null;
            }
            case 18: {
                return pSDELNTypeBase.getValidFlag() == null;
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
        return PSDELNTypeBase.contains(this, n);
    }

    private static boolean contains(PSDELNTypeBase pSDELNTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDELNTypeBase.isCodeNameDirty();
            }
            case 1: {
                return pSDELNTypeBase.isCreateDateDirty();
            }
            case 2: {
                return pSDELNTypeBase.isCreateManDirty();
            }
            case 3: {
                return pSDELNTypeBase.isIconPathDirty();
            }
            case 4: {
                return pSDELNTypeBase.isItemObjDirty();
            }
            case 5: {
                return pSDELNTypeBase.isItemObj2Dirty();
            }
            case 6: {
                return pSDELNTypeBase.isItemObj3Dirty();
            }
            case 7: {
                return pSDELNTypeBase.isItemObj4Dirty();
            }
            case 8: {
                return pSDELNTypeBase.isItemObj5Dirty();
            }
            case 9: {
                return pSDELNTypeBase.isItemObj6Dirty();
            }
            case 10: {
                return pSDELNTypeBase.isLogicHolderDirty();
            }
            case 11: {
                return pSDELNTypeBase.isLogicTypeDirty();
            }
            case 12: {
                return pSDELNTypeBase.isMemoDirty();
            }
            case 13: {
                return pSDELNTypeBase.isOrderValueDirty();
            }
            case 14: {
                return pSDELNTypeBase.isPSDELNTypeIdDirty();
            }
            case 15: {
                return pSDELNTypeBase.isPSDELNTypeNameDirty();
            }
            case 16: {
                return pSDELNTypeBase.isUpdateDateDirty();
            }
            case 17: {
                return pSDELNTypeBase.isUpdateManDirty();
            }
            case 18: {
                return pSDELNTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDELNTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDELNTypeBase pSDELNTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDELNTypeBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDELNTypeBase.getJSONValue((Object)pSDELNTypeBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDELNTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDELNTypeBase.getJSONValue((Object)pSDELNTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDELNTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDELNTypeBase.getJSONValue((Object)pSDELNTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDELNTypeBase.getIconPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconpath", (Object)PSDELNTypeBase.getJSONValue((Object)pSDELNTypeBase.getIconPath()), (boolean)false);
        }
        if (bl || pSDELNTypeBase.getItemObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemobj", (Object)PSDELNTypeBase.getJSONValue((Object)pSDELNTypeBase.getItemObj()), (boolean)false);
        }
        if (bl || pSDELNTypeBase.getItemObj2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemobj2", (Object)PSDELNTypeBase.getJSONValue((Object)pSDELNTypeBase.getItemObj2()), (boolean)false);
        }
        if (bl || pSDELNTypeBase.getItemObj3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemobj3", (Object)PSDELNTypeBase.getJSONValue((Object)pSDELNTypeBase.getItemObj3()), (boolean)false);
        }
        if (bl || pSDELNTypeBase.getItemObj4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemobj4", (Object)PSDELNTypeBase.getJSONValue((Object)pSDELNTypeBase.getItemObj4()), (boolean)false);
        }
        if (bl || pSDELNTypeBase.getItemObj5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemobj5", (Object)PSDELNTypeBase.getJSONValue((Object)pSDELNTypeBase.getItemObj5()), (boolean)false);
        }
        if (bl || pSDELNTypeBase.getItemObj6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemobj6", (Object)PSDELNTypeBase.getJSONValue((Object)pSDELNTypeBase.getItemObj6()), (boolean)false);
        }
        if (bl || pSDELNTypeBase.getLogicHolder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicholder", (Object)PSDELNTypeBase.getJSONValue((Object)pSDELNTypeBase.getLogicHolder()), (boolean)false);
        }
        if (bl || pSDELNTypeBase.getLogicType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logictype", (Object)PSDELNTypeBase.getJSONValue((Object)pSDELNTypeBase.getLogicType()), (boolean)false);
        }
        if (bl || pSDELNTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDELNTypeBase.getJSONValue((Object)pSDELNTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSDELNTypeBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDELNTypeBase.getJSONValue((Object)pSDELNTypeBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDELNTypeBase.getPSDELNTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelntypeid", (Object)PSDELNTypeBase.getJSONValue((Object)pSDELNTypeBase.getPSDELNTypeId()), (boolean)false);
        }
        if (bl || pSDELNTypeBase.getPSDELNTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelntypename", (Object)PSDELNTypeBase.getJSONValue((Object)pSDELNTypeBase.getPSDELNTypeName()), (boolean)false);
        }
        if (bl || pSDELNTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDELNTypeBase.getJSONValue((Object)pSDELNTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDELNTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDELNTypeBase.getJSONValue((Object)pSDELNTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDELNTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDELNTypeBase.getJSONValue((Object)pSDELNTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDELNTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDELNTypeBase pSDELNTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDELNTypeBase.getCodeName() != null) {
            object = pSDELNTypeBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELNTypeBase.getCreateDate() != null) {
            object = pSDELNTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDELNTypeBase.getCreateMan() != null) {
            object = pSDELNTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDELNTypeBase.getIconPath() != null) {
            object = pSDELNTypeBase.getIconPath();
            xmlNode.setAttribute(FIELD_ICONPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDELNTypeBase.getItemObj() != null) {
            object = pSDELNTypeBase.getItemObj();
            xmlNode.setAttribute(FIELD_ITEMOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDELNTypeBase.getItemObj2() != null) {
            object = pSDELNTypeBase.getItemObj2();
            xmlNode.setAttribute(FIELD_ITEMOBJ2, object == null ? "" : (String)object);
        }
        if (bl || pSDELNTypeBase.getItemObj3() != null) {
            object = pSDELNTypeBase.getItemObj3();
            xmlNode.setAttribute(FIELD_ITEMOBJ3, object == null ? "" : (String)object);
        }
        if (bl || pSDELNTypeBase.getItemObj4() != null) {
            object = pSDELNTypeBase.getItemObj4();
            xmlNode.setAttribute(FIELD_ITEMOBJ4, object == null ? "" : (String)object);
        }
        if (bl || pSDELNTypeBase.getItemObj5() != null) {
            object = pSDELNTypeBase.getItemObj5();
            xmlNode.setAttribute(FIELD_ITEMOBJ5, object == null ? "" : (String)object);
        }
        if (bl || pSDELNTypeBase.getItemObj6() != null) {
            object = pSDELNTypeBase.getItemObj6();
            xmlNode.setAttribute(FIELD_ITEMOBJ6, object == null ? "" : (String)object);
        }
        if (bl || pSDELNTypeBase.getLogicHolder() != null) {
            object = pSDELNTypeBase.getLogicHolder();
            xmlNode.setAttribute(FIELD_LOGICHOLDER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELNTypeBase.getLogicType() != null) {
            object = pSDELNTypeBase.getLogicType();
            xmlNode.setAttribute(FIELD_LOGICTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDELNTypeBase.getMemo() != null) {
            object = pSDELNTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDELNTypeBase.getOrderValue() != null) {
            object = pSDELNTypeBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELNTypeBase.getPSDELNTypeId() != null) {
            object = pSDELNTypeBase.getPSDELNTypeId();
            xmlNode.setAttribute(FIELD_PSDELNTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDELNTypeBase.getPSDELNTypeName() != null) {
            object = pSDELNTypeBase.getPSDELNTypeName();
            xmlNode.setAttribute(FIELD_PSDELNTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELNTypeBase.getUpdateDate() != null) {
            object = pSDELNTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDELNTypeBase.getUpdateMan() != null) {
            object = pSDELNTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDELNTypeBase.getValidFlag() != null) {
            object = pSDELNTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDELNTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDELNTypeBase pSDELNTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDELNTypeBase.isCodeNameDirty() && (bl || pSDELNTypeBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDELNTypeBase.getCodeName());
        }
        if (pSDELNTypeBase.isCreateDateDirty() && (bl || pSDELNTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDELNTypeBase.getCreateDate());
        }
        if (pSDELNTypeBase.isCreateManDirty() && (bl || pSDELNTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDELNTypeBase.getCreateMan());
        }
        if (pSDELNTypeBase.isIconPathDirty() && (bl || pSDELNTypeBase.getIconPath() != null)) {
            iDataObject.set(FIELD_ICONPATH, (Object)pSDELNTypeBase.getIconPath());
        }
        if (pSDELNTypeBase.isItemObjDirty() && (bl || pSDELNTypeBase.getItemObj() != null)) {
            iDataObject.set(FIELD_ITEMOBJ, (Object)pSDELNTypeBase.getItemObj());
        }
        if (pSDELNTypeBase.isItemObj2Dirty() && (bl || pSDELNTypeBase.getItemObj2() != null)) {
            iDataObject.set(FIELD_ITEMOBJ2, (Object)pSDELNTypeBase.getItemObj2());
        }
        if (pSDELNTypeBase.isItemObj3Dirty() && (bl || pSDELNTypeBase.getItemObj3() != null)) {
            iDataObject.set(FIELD_ITEMOBJ3, (Object)pSDELNTypeBase.getItemObj3());
        }
        if (pSDELNTypeBase.isItemObj4Dirty() && (bl || pSDELNTypeBase.getItemObj4() != null)) {
            iDataObject.set(FIELD_ITEMOBJ4, (Object)pSDELNTypeBase.getItemObj4());
        }
        if (pSDELNTypeBase.isItemObj5Dirty() && (bl || pSDELNTypeBase.getItemObj5() != null)) {
            iDataObject.set(FIELD_ITEMOBJ5, (Object)pSDELNTypeBase.getItemObj5());
        }
        if (pSDELNTypeBase.isItemObj6Dirty() && (bl || pSDELNTypeBase.getItemObj6() != null)) {
            iDataObject.set(FIELD_ITEMOBJ6, (Object)pSDELNTypeBase.getItemObj6());
        }
        if (pSDELNTypeBase.isLogicHolderDirty() && (bl || pSDELNTypeBase.getLogicHolder() != null)) {
            iDataObject.set(FIELD_LOGICHOLDER, (Object)pSDELNTypeBase.getLogicHolder());
        }
        if (pSDELNTypeBase.isLogicTypeDirty() && (bl || pSDELNTypeBase.getLogicType() != null)) {
            iDataObject.set(FIELD_LOGICTYPE, (Object)pSDELNTypeBase.getLogicType());
        }
        if (pSDELNTypeBase.isMemoDirty() && (bl || pSDELNTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDELNTypeBase.getMemo());
        }
        if (pSDELNTypeBase.isOrderValueDirty() && (bl || pSDELNTypeBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDELNTypeBase.getOrderValue());
        }
        if (pSDELNTypeBase.isPSDELNTypeIdDirty() && (bl || pSDELNTypeBase.getPSDELNTypeId() != null)) {
            iDataObject.set(FIELD_PSDELNTYPEID, (Object)pSDELNTypeBase.getPSDELNTypeId());
        }
        if (pSDELNTypeBase.isPSDELNTypeNameDirty() && (bl || pSDELNTypeBase.getPSDELNTypeName() != null)) {
            iDataObject.set(FIELD_PSDELNTYPENAME, (Object)pSDELNTypeBase.getPSDELNTypeName());
        }
        if (pSDELNTypeBase.isUpdateDateDirty() && (bl || pSDELNTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDELNTypeBase.getUpdateDate());
        }
        if (pSDELNTypeBase.isUpdateManDirty() && (bl || pSDELNTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDELNTypeBase.getUpdateMan());
        }
        if (pSDELNTypeBase.isValidFlagDirty() && (bl || pSDELNTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDELNTypeBase.getValidFlag());
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
        return PSDELNTypeBase.remove(this, n);
    }

    private static boolean remove(PSDELNTypeBase pSDELNTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDELNTypeBase.resetCodeName();
                return true;
            }
            case 1: {
                pSDELNTypeBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDELNTypeBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDELNTypeBase.resetIconPath();
                return true;
            }
            case 4: {
                pSDELNTypeBase.resetItemObj();
                return true;
            }
            case 5: {
                pSDELNTypeBase.resetItemObj2();
                return true;
            }
            case 6: {
                pSDELNTypeBase.resetItemObj3();
                return true;
            }
            case 7: {
                pSDELNTypeBase.resetItemObj4();
                return true;
            }
            case 8: {
                pSDELNTypeBase.resetItemObj5();
                return true;
            }
            case 9: {
                pSDELNTypeBase.resetItemObj6();
                return true;
            }
            case 10: {
                pSDELNTypeBase.resetLogicHolder();
                return true;
            }
            case 11: {
                pSDELNTypeBase.resetLogicType();
                return true;
            }
            case 12: {
                pSDELNTypeBase.resetMemo();
                return true;
            }
            case 13: {
                pSDELNTypeBase.resetOrderValue();
                return true;
            }
            case 14: {
                pSDELNTypeBase.resetPSDELNTypeId();
                return true;
            }
            case 15: {
                pSDELNTypeBase.resetPSDELNTypeName();
                return true;
            }
            case 16: {
                pSDELNTypeBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSDELNTypeBase.resetUpdateMan();
                return true;
            }
            case 18: {
                pSDELNTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDELNTypeBase getProxyEntity() {
        return this.proxyPSDELNTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDELNTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSDELNTypeBase) {
            this.proxyPSDELNTypeBase = (PSDELNTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDELNTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_ICONPATH, 3);
        fieldIndexMap.put(FIELD_ITEMOBJ, 4);
        fieldIndexMap.put(FIELD_ITEMOBJ2, 5);
        fieldIndexMap.put(FIELD_ITEMOBJ3, 6);
        fieldIndexMap.put(FIELD_ITEMOBJ4, 7);
        fieldIndexMap.put(FIELD_ITEMOBJ5, 8);
        fieldIndexMap.put(FIELD_ITEMOBJ6, 9);
        fieldIndexMap.put(FIELD_LOGICHOLDER, 10);
        fieldIndexMap.put(FIELD_LOGICTYPE, 11);
        fieldIndexMap.put(FIELD_MEMO, 12);
        fieldIndexMap.put(FIELD_ORDERVALUE, 13);
        fieldIndexMap.put(FIELD_PSDELNTYPEID, 14);
        fieldIndexMap.put(FIELD_PSDELNTYPENAME, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
        fieldIndexMap.put(FIELD_VALIDFLAG, 18);
    }
}

