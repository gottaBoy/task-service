/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.common.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.psrt.srv.common.entity.CodeItem;
import net.ibizsys.psrt.srv.common.entity.CodeList;
import net.ibizsys.psrt.srv.common.service.CodeItemService;
import net.ibizsys.psrt.srv.common.service.CodeListService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class CodeItemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(CodeItemBase.class);
    public static final String FIELD_CODEITEMID = "CODEITEMID";
    public static final String FIELD_CODEITEMNAME = "CODEITEMNAME";
    public static final String FIELD_CODEITEMVALUE = "CODEITEMVALUE";
    public static final String FIELD_CODELISTID = "CODELISTID";
    public static final String FIELD_CODELISTNAME = "CODELISTNAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PCODEITEMID = "PCODEITEMID";
    public static final String FIELD_PCODEITEMNAME = "PCODEITEMNAME";
    public static final String FIELD_RESERVER = "RESERVER";
    public static final String FIELD_RESERVER2 = "RESERVER2";
    public static final String FIELD_RESERVER3 = "RESERVER3";
    public static final String FIELD_RESERVER4 = "RESERVER4";
    public static final String FIELD_RESERVER5 = "RESERVER5";
    public static final String FIELD_SHORTKEY = "SHORTKEY";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CODEITEMID = 0;
    private static final int INDEX_CODEITEMNAME = 1;
    private static final int INDEX_CODEITEMVALUE = 2;
    private static final int INDEX_CODELISTID = 3;
    private static final int INDEX_CODELISTNAME = 4;
    private static final int INDEX_CREATEDATE = 5;
    private static final int INDEX_CREATEMAN = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_ORDERVALUE = 8;
    private static final int INDEX_PCODEITEMID = 9;
    private static final int INDEX_PCODEITEMNAME = 10;
    private static final int INDEX_RESERVER = 11;
    private static final int INDEX_RESERVER2 = 12;
    private static final int INDEX_RESERVER3 = 13;
    private static final int INDEX_RESERVER4 = 14;
    private static final int INDEX_RESERVER5 = 15;
    private static final int INDEX_SHORTKEY = 16;
    private static final int INDEX_UPDATEDATE = 17;
    private static final int INDEX_UPDATEMAN = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private CodeItemBase proxyCodeItemBase = null;
    private boolean codeitemidDirtyFlag = false;
    private boolean codeitemnameDirtyFlag = false;
    private boolean codeitemvalueDirtyFlag = false;
    private boolean codelistidDirtyFlag = false;
    private boolean codelistnameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean pcodeitemidDirtyFlag = false;
    private boolean pcodeitemnameDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean reserver3DirtyFlag = false;
    private boolean reserver4DirtyFlag = false;
    private boolean reserver5DirtyFlag = false;
    private boolean shortkeyDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="codeitemid")
    private String codeitemid;
    @Column(name="codeitemname")
    private String codeitemname;
    @Column(name="codeitemvalue")
    private String codeitemvalue;
    @Column(name="codelistid")
    private String codelistid;
    @Column(name="codelistname")
    private String codelistname;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="pcodeitemid")
    private String pcodeitemid;
    @Column(name="pcodeitemname")
    private String pcodeitemname;
    @Column(name="reserver")
    private String reserver;
    @Column(name="reserver2")
    private String reserver2;
    @Column(name="reserver3")
    private Integer reserver3;
    @Column(name="reserver4")
    private Double reserver4;
    @Column(name="reserver5")
    private Timestamp reserver5;
    @Column(name="shortkey")
    private String shortkey;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPCodeItemLock = new Integer(1);
    private CodeItem pcodeitem = null;
    private Integer objCodeListLock = new Integer(1);
    private CodeList codelist = null;

    static {
        fieldIndexMap.put(FIELD_CODEITEMID, 0);
        fieldIndexMap.put(FIELD_CODEITEMNAME, 1);
        fieldIndexMap.put(FIELD_CODEITEMVALUE, 2);
        fieldIndexMap.put(FIELD_CODELISTID, 3);
        fieldIndexMap.put(FIELD_CODELISTNAME, 4);
        fieldIndexMap.put(FIELD_CREATEDATE, 5);
        fieldIndexMap.put(FIELD_CREATEMAN, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_ORDERVALUE, 8);
        fieldIndexMap.put(FIELD_PCODEITEMID, 9);
        fieldIndexMap.put(FIELD_PCODEITEMNAME, 10);
        fieldIndexMap.put(FIELD_RESERVER, 11);
        fieldIndexMap.put(FIELD_RESERVER2, 12);
        fieldIndexMap.put(FIELD_RESERVER3, 13);
        fieldIndexMap.put(FIELD_RESERVER4, 14);
        fieldIndexMap.put(FIELD_RESERVER5, 15);
        fieldIndexMap.put(FIELD_SHORTKEY, 16);
        fieldIndexMap.put(FIELD_UPDATEDATE, 17);
        fieldIndexMap.put(FIELD_UPDATEMAN, 18);
    }

    public void setCodeItemId(String codeitemid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeItemId(codeitemid);
            return;
        }
        if (codeitemid != null && (codeitemid = StringHelper.trimRight(codeitemid)).length() == 0) {
            codeitemid = null;
        }
        this.codeitemid = codeitemid;
        this.codeitemidDirtyFlag = true;
    }

    public String getCodeItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeItemId();
        }
        return this.codeitemid;
    }

    public boolean isCodeItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeItemIdDirty();
        }
        return this.codeitemidDirtyFlag;
    }

    public void resetCodeItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeItemId();
            return;
        }
        this.codeitemidDirtyFlag = false;
        this.codeitemid = null;
    }

    public void setCodeItemName(String codeitemname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeItemName(codeitemname);
            return;
        }
        if (codeitemname != null && (codeitemname = StringHelper.trimRight(codeitemname)).length() == 0) {
            codeitemname = null;
        }
        this.codeitemname = codeitemname;
        this.codeitemnameDirtyFlag = true;
    }

    public String getCodeItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeItemName();
        }
        return this.codeitemname;
    }

    public boolean isCodeItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeItemNameDirty();
        }
        return this.codeitemnameDirtyFlag;
    }

    public void resetCodeItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeItemName();
            return;
        }
        this.codeitemnameDirtyFlag = false;
        this.codeitemname = null;
    }

    public void setCodeItemValue(String codeitemvalue) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeItemValue(codeitemvalue);
            return;
        }
        if (codeitemvalue != null && (codeitemvalue = StringHelper.trimRight(codeitemvalue)).length() == 0) {
            codeitemvalue = null;
        }
        this.codeitemvalue = codeitemvalue;
        this.codeitemvalueDirtyFlag = true;
    }

    public String getCodeItemValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeItemValue();
        }
        return this.codeitemvalue;
    }

    public boolean isCodeItemValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeItemValueDirty();
        }
        return this.codeitemvalueDirtyFlag;
    }

    public void resetCodeItemValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeItemValue();
            return;
        }
        this.codeitemvalueDirtyFlag = false;
        this.codeitemvalue = null;
    }

    public void setCodeListId(String codelistid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeListId(codelistid);
            return;
        }
        if (codelistid != null && (codelistid = StringHelper.trimRight(codelistid)).length() == 0) {
            codelistid = null;
        }
        this.codelistid = codelistid;
        this.codelistidDirtyFlag = true;
    }

    public String getCodeListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeListId();
        }
        return this.codelistid;
    }

    public boolean isCodeListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeListIdDirty();
        }
        return this.codelistidDirtyFlag;
    }

    public void resetCodeListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeListId();
            return;
        }
        this.codelistidDirtyFlag = false;
        this.codelistid = null;
    }

    public void setCodeListName(String codelistname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeListName(codelistname);
            return;
        }
        if (codelistname != null && (codelistname = StringHelper.trimRight(codelistname)).length() == 0) {
            codelistname = null;
        }
        this.codelistname = codelistname;
        this.codelistnameDirtyFlag = true;
    }

    public String getCodeListName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeListName();
        }
        return this.codelistname;
    }

    public boolean isCodeListNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeListNameDirty();
        }
        return this.codelistnameDirtyFlag;
    }

    public void resetCodeListName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeListName();
            return;
        }
        this.codelistnameDirtyFlag = false;
        this.codelistname = null;
    }

    public void setCreateDate(Timestamp createdate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDate(createdate);
            return;
        }
        this.createdate = createdate;
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

    public void setCreateMan(String createman) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateMan(createman);
            return;
        }
        if (createman != null && (createman = StringHelper.trimRight(createman)).length() == 0) {
            createman = null;
        }
        this.createman = createman;
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

    public void setMemo(String memo) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMemo(memo);
            return;
        }
        if (memo != null && (memo = StringHelper.trimRight(memo)).length() == 0) {
            memo = null;
        }
        this.memo = memo;
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

    public void setOrderValue(Integer ordervalue) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValue(ordervalue);
            return;
        }
        this.ordervalue = ordervalue;
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

    public void setPCodeItemId(String pcodeitemid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPCodeItemId(pcodeitemid);
            return;
        }
        if (pcodeitemid != null && (pcodeitemid = StringHelper.trimRight(pcodeitemid)).length() == 0) {
            pcodeitemid = null;
        }
        this.pcodeitemid = pcodeitemid;
        this.pcodeitemidDirtyFlag = true;
    }

    public String getPCodeItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPCodeItemId();
        }
        return this.pcodeitemid;
    }

    public boolean isPCodeItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPCodeItemIdDirty();
        }
        return this.pcodeitemidDirtyFlag;
    }

    public void resetPCodeItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPCodeItemId();
            return;
        }
        this.pcodeitemidDirtyFlag = false;
        this.pcodeitemid = null;
    }

    public void setPCodeItemName(String pcodeitemname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPCodeItemName(pcodeitemname);
            return;
        }
        if (pcodeitemname != null && (pcodeitemname = StringHelper.trimRight(pcodeitemname)).length() == 0) {
            pcodeitemname = null;
        }
        this.pcodeitemname = pcodeitemname;
        this.pcodeitemnameDirtyFlag = true;
    }

    public String getPCodeItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPCodeItemName();
        }
        return this.pcodeitemname;
    }

    public boolean isPCodeItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPCodeItemNameDirty();
        }
        return this.pcodeitemnameDirtyFlag;
    }

    public void resetPCodeItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPCodeItemName();
            return;
        }
        this.pcodeitemnameDirtyFlag = false;
        this.pcodeitemname = null;
    }

    public void setReserver(String reserver) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver(reserver);
            return;
        }
        if (reserver != null && (reserver = StringHelper.trimRight(reserver)).length() == 0) {
            reserver = null;
        }
        this.reserver = reserver;
        this.reserverDirtyFlag = true;
    }

    public String getReserver() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver();
        }
        return this.reserver;
    }

    public boolean isReserverDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserverDirty();
        }
        return this.reserverDirtyFlag;
    }

    public void resetReserver() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver();
            return;
        }
        this.reserverDirtyFlag = false;
        this.reserver = null;
    }

    public void setReserver2(String reserver2) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver2(reserver2);
            return;
        }
        if (reserver2 != null && (reserver2 = StringHelper.trimRight(reserver2)).length() == 0) {
            reserver2 = null;
        }
        this.reserver2 = reserver2;
        this.reserver2DirtyFlag = true;
    }

    public String getReserver2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver2();
        }
        return this.reserver2;
    }

    public boolean isReserver2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver2Dirty();
        }
        return this.reserver2DirtyFlag;
    }

    public void resetReserver2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver2();
            return;
        }
        this.reserver2DirtyFlag = false;
        this.reserver2 = null;
    }

    public void setReserver3(Integer reserver3) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver3(reserver3);
            return;
        }
        this.reserver3 = reserver3;
        this.reserver3DirtyFlag = true;
    }

    public Integer getReserver3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver3();
        }
        return this.reserver3;
    }

    public boolean isReserver3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver3Dirty();
        }
        return this.reserver3DirtyFlag;
    }

    public void resetReserver3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver3();
            return;
        }
        this.reserver3DirtyFlag = false;
        this.reserver3 = null;
    }

    public void setReserver4(Double reserver4) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver4(reserver4);
            return;
        }
        this.reserver4 = reserver4;
        this.reserver4DirtyFlag = true;
    }

    public Double getReserver4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver4();
        }
        return this.reserver4;
    }

    public boolean isReserver4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver4Dirty();
        }
        return this.reserver4DirtyFlag;
    }

    public void resetReserver4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver4();
            return;
        }
        this.reserver4DirtyFlag = false;
        this.reserver4 = null;
    }

    public void setReserver5(Timestamp reserver5) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver5(reserver5);
            return;
        }
        this.reserver5 = reserver5;
        this.reserver5DirtyFlag = true;
    }

    public Timestamp getReserver5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver5();
        }
        return this.reserver5;
    }

    public boolean isReserver5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver5Dirty();
        }
        return this.reserver5DirtyFlag;
    }

    public void resetReserver5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver5();
            return;
        }
        this.reserver5DirtyFlag = false;
        this.reserver5 = null;
    }

    public void setShortKey(String shortkey) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setShortKey(shortkey);
            return;
        }
        if (shortkey != null && (shortkey = StringHelper.trimRight(shortkey)).length() == 0) {
            shortkey = null;
        }
        this.shortkey = shortkey;
        this.shortkeyDirtyFlag = true;
    }

    public String getShortKey() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShortKey();
        }
        return this.shortkey;
    }

    public boolean isShortKeyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isShortKeyDirty();
        }
        return this.shortkeyDirtyFlag;
    }

    public void resetShortKey() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetShortKey();
            return;
        }
        this.shortkeyDirtyFlag = false;
        this.shortkey = null;
    }

    public void setUpdateDate(Timestamp updatedate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDate(updatedate);
            return;
        }
        this.updatedate = updatedate;
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

    public void setUpdateMan(String updateman) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateMan(updateman);
            return;
        }
        if (updateman != null && (updateman = StringHelper.trimRight(updateman)).length() == 0) {
            updateman = null;
        }
        this.updateman = updateman;
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

    @Override
    protected void onReset() {
        CodeItemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(CodeItemBase et) {
        et.resetCodeItemId();
        et.resetCodeItemName();
        et.resetCodeItemValue();
        et.resetCodeListId();
        et.resetCodeListName();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetMemo();
        et.resetOrderValue();
        et.resetPCodeItemId();
        et.resetPCodeItemName();
        et.resetReserver();
        et.resetReserver2();
        et.resetReserver3();
        et.resetReserver4();
        et.resetReserver5();
        et.resetShortKey();
        et.resetUpdateDate();
        et.resetUpdateMan();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isCodeItemIdDirty()) {
            params.put(FIELD_CODEITEMID, this.getCodeItemId());
        }
        if (!bDirtyOnly || this.isCodeItemNameDirty()) {
            params.put(FIELD_CODEITEMNAME, this.getCodeItemName());
        }
        if (!bDirtyOnly || this.isCodeItemValueDirty()) {
            params.put(FIELD_CODEITEMVALUE, this.getCodeItemValue());
        }
        if (!bDirtyOnly || this.isCodeListIdDirty()) {
            params.put(FIELD_CODELISTID, this.getCodeListId());
        }
        if (!bDirtyOnly || this.isCodeListNameDirty()) {
            params.put(FIELD_CODELISTNAME, this.getCodeListName());
        }
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isMemoDirty()) {
            params.put(FIELD_MEMO, this.getMemo());
        }
        if (!bDirtyOnly || this.isOrderValueDirty()) {
            params.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bDirtyOnly || this.isPCodeItemIdDirty()) {
            params.put(FIELD_PCODEITEMID, this.getPCodeItemId());
        }
        if (!bDirtyOnly || this.isPCodeItemNameDirty()) {
            params.put(FIELD_PCODEITEMNAME, this.getPCodeItemName());
        }
        if (!bDirtyOnly || this.isReserverDirty()) {
            params.put(FIELD_RESERVER, this.getReserver());
        }
        if (!bDirtyOnly || this.isReserver2Dirty()) {
            params.put(FIELD_RESERVER2, this.getReserver2());
        }
        if (!bDirtyOnly || this.isReserver3Dirty()) {
            params.put(FIELD_RESERVER3, this.getReserver3());
        }
        if (!bDirtyOnly || this.isReserver4Dirty()) {
            params.put(FIELD_RESERVER4, this.getReserver4());
        }
        if (!bDirtyOnly || this.isReserver5Dirty()) {
            params.put(FIELD_RESERVER5, this.getReserver5());
        }
        if (!bDirtyOnly || this.isShortKeyDirty()) {
            params.put(FIELD_SHORTKEY, this.getShortKey());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        super.onFillMap(params, bDirtyOnly);
    }

    @Override
    public Object get(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().get(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.get(strParamName);
        }
        return CodeItemBase.get(this, index);
    }

    private static Object get(CodeItemBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCodeItemId();
            }
            case 1: {
                return et.getCodeItemName();
            }
            case 2: {
                return et.getCodeItemValue();
            }
            case 3: {
                return et.getCodeListId();
            }
            case 4: {
                return et.getCodeListName();
            }
            case 5: {
                return et.getCreateDate();
            }
            case 6: {
                return et.getCreateMan();
            }
            case 7: {
                return et.getMemo();
            }
            case 8: {
                return et.getOrderValue();
            }
            case 9: {
                return et.getPCodeItemId();
            }
            case 10: {
                return et.getPCodeItemName();
            }
            case 11: {
                return et.getReserver();
            }
            case 12: {
                return et.getReserver2();
            }
            case 13: {
                return et.getReserver3();
            }
            case 14: {
                return et.getReserver4();
            }
            case 15: {
                return et.getReserver5();
            }
            case 16: {
                return et.getShortKey();
            }
            case 17: {
                return et.getUpdateDate();
            }
            case 18: {
                return et.getUpdateMan();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public void set(String strParamName, Object objValue) throws Exception {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().set(strParamName, objValue);
            return;
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            super.set(strParamName, objValue);
            return;
        }
        CodeItemBase.set(this, index, objValue);
    }

    private static void set(CodeItemBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setCodeItemId(DataObject.getStringValue(obj));
                return;
            }
            case 1: {
                et.setCodeItemName(DataObject.getStringValue(obj));
                return;
            }
            case 2: {
                et.setCodeItemValue(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setCodeListId(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setCodeListName(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 6: {
                et.setCreateMan(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setMemo(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setOrderValue(DataObject.getIntegerValue(obj));
                return;
            }
            case 9: {
                et.setPCodeItemId(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setPCodeItemName(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setReserver(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setReserver2(DataObject.getStringValue(obj));
                return;
            }
            case 13: {
                et.setReserver3(DataObject.getIntegerValue(obj));
                return;
            }
            case 14: {
                et.setReserver4(DataObject.getDoubleValue(obj));
                return;
            }
            case 15: {
                et.setReserver5(DataObject.getTimestampValue(obj));
                return;
            }
            case 16: {
                et.setShortKey(DataObject.getStringValue(obj));
                return;
            }
            case 17: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 18: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean isNull(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNull(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.isNull(strParamName);
        }
        return CodeItemBase.isNull(this, index);
    }

    private static boolean isNull(CodeItemBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCodeItemId() == null;
            }
            case 1: {
                return et.getCodeItemName() == null;
            }
            case 2: {
                return et.getCodeItemValue() == null;
            }
            case 3: {
                return et.getCodeListId() == null;
            }
            case 4: {
                return et.getCodeListName() == null;
            }
            case 5: {
                return et.getCreateDate() == null;
            }
            case 6: {
                return et.getCreateMan() == null;
            }
            case 7: {
                return et.getMemo() == null;
            }
            case 8: {
                return et.getOrderValue() == null;
            }
            case 9: {
                return et.getPCodeItemId() == null;
            }
            case 10: {
                return et.getPCodeItemName() == null;
            }
            case 11: {
                return et.getReserver() == null;
            }
            case 12: {
                return et.getReserver2() == null;
            }
            case 13: {
                return et.getReserver3() == null;
            }
            case 14: {
                return et.getReserver4() == null;
            }
            case 15: {
                return et.getReserver5() == null;
            }
            case 16: {
                return et.getShortKey() == null;
            }
            case 17: {
                return et.getUpdateDate() == null;
            }
            case 18: {
                return et.getUpdateMan() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean contains(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().contains(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.contains(strParamName);
        }
        return CodeItemBase.contains(this, index);
    }

    private static boolean contains(CodeItemBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCodeItemIdDirty();
            }
            case 1: {
                return et.isCodeItemNameDirty();
            }
            case 2: {
                return et.isCodeItemValueDirty();
            }
            case 3: {
                return et.isCodeListIdDirty();
            }
            case 4: {
                return et.isCodeListNameDirty();
            }
            case 5: {
                return et.isCreateDateDirty();
            }
            case 6: {
                return et.isCreateManDirty();
            }
            case 7: {
                return et.isMemoDirty();
            }
            case 8: {
                return et.isOrderValueDirty();
            }
            case 9: {
                return et.isPCodeItemIdDirty();
            }
            case 10: {
                return et.isPCodeItemNameDirty();
            }
            case 11: {
                return et.isReserverDirty();
            }
            case 12: {
                return et.isReserver2Dirty();
            }
            case 13: {
                return et.isReserver3Dirty();
            }
            case 14: {
                return et.isReserver4Dirty();
            }
            case 15: {
                return et.isReserver5Dirty();
            }
            case 16: {
                return et.isShortKeyDirty();
            }
            case 17: {
                return et.isUpdateDateDirty();
            }
            case 18: {
                return et.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        CodeItemBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(CodeItemBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCodeItemId() != null) {
            JSONObjectHelper.put(json, "codeitemid", CodeItemBase.getJSONValue(et.getCodeItemId()), false);
        }
        if (bIncEmpty || et.getCodeItemName() != null) {
            JSONObjectHelper.put(json, "codeitemname", CodeItemBase.getJSONValue(et.getCodeItemName()), false);
        }
        if (bIncEmpty || et.getCodeItemValue() != null) {
            JSONObjectHelper.put(json, "codeitemvalue", CodeItemBase.getJSONValue(et.getCodeItemValue()), false);
        }
        if (bIncEmpty || et.getCodeListId() != null) {
            JSONObjectHelper.put(json, "codelistid", CodeItemBase.getJSONValue(et.getCodeListId()), false);
        }
        if (bIncEmpty || et.getCodeListName() != null) {
            JSONObjectHelper.put(json, "codelistname", CodeItemBase.getJSONValue(et.getCodeListName()), false);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", CodeItemBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", CodeItemBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getMemo() != null) {
            JSONObjectHelper.put(json, "memo", CodeItemBase.getJSONValue(et.getMemo()), false);
        }
        if (bIncEmpty || et.getOrderValue() != null) {
            JSONObjectHelper.put(json, "ordervalue", CodeItemBase.getJSONValue(et.getOrderValue()), false);
        }
        if (bIncEmpty || et.getPCodeItemId() != null) {
            JSONObjectHelper.put(json, "pcodeitemid", CodeItemBase.getJSONValue(et.getPCodeItemId()), false);
        }
        if (bIncEmpty || et.getPCodeItemName() != null) {
            JSONObjectHelper.put(json, "pcodeitemname", CodeItemBase.getJSONValue(et.getPCodeItemName()), false);
        }
        if (bIncEmpty || et.getReserver() != null) {
            JSONObjectHelper.put(json, "reserver", CodeItemBase.getJSONValue(et.getReserver()), false);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            JSONObjectHelper.put(json, "reserver2", CodeItemBase.getJSONValue(et.getReserver2()), false);
        }
        if (bIncEmpty || et.getReserver3() != null) {
            JSONObjectHelper.put(json, "reserver3", CodeItemBase.getJSONValue(et.getReserver3()), false);
        }
        if (bIncEmpty || et.getReserver4() != null) {
            JSONObjectHelper.put(json, "reserver4", CodeItemBase.getJSONValue(et.getReserver4()), false);
        }
        if (bIncEmpty || et.getReserver5() != null) {
            JSONObjectHelper.put(json, "reserver5", CodeItemBase.getJSONValue(et.getReserver5()), false);
        }
        if (bIncEmpty || et.getShortKey() != null) {
            JSONObjectHelper.put(json, "shortkey", CodeItemBase.getJSONValue(et.getShortKey()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", CodeItemBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", CodeItemBase.getJSONValue(et.getUpdateMan()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        CodeItemBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(CodeItemBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCodeItemId() != null) {
            obj = et.getCodeItemId();
            node.setAttribute(FIELD_CODEITEMID, (String)(obj == null ? "" : obj));
        }
        if (bIncEmpty || et.getCodeItemName() != null) {
            obj = et.getCodeItemName();
            node.setAttribute(FIELD_CODEITEMNAME, (String)(obj == null ? "" : obj));
        }
        if (bIncEmpty || et.getCodeItemValue() != null) {
            obj = et.getCodeItemValue();
            node.setAttribute(FIELD_CODEITEMVALUE, (String)(obj == null ? "" : obj));
        }
        if (bIncEmpty || et.getCodeListId() != null) {
            obj = et.getCodeListId();
            node.setAttribute(FIELD_CODELISTID, (String)(obj == null ? "" : obj));
        }
        if (bIncEmpty || et.getCodeListName() != null) {
            obj = et.getCodeListName();
            node.setAttribute(FIELD_CODELISTNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMemo() != null) {
            obj = et.getMemo();
            node.setAttribute(FIELD_MEMO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getOrderValue() != null) {
            obj = et.getOrderValue();
            node.setAttribute(FIELD_ORDERVALUE, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getPCodeItemId() != null) {
            obj = et.getPCodeItemId();
            node.setAttribute(FIELD_PCODEITEMID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getPCodeItemName() != null) {
            obj = et.getPCodeItemName();
            node.setAttribute(FIELD_PCODEITEMNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver() != null) {
            obj = et.getReserver();
            node.setAttribute(FIELD_RESERVER, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            obj = et.getReserver2();
            node.setAttribute(FIELD_RESERVER2, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver3() != null) {
            obj = et.getReserver3();
            node.setAttribute(FIELD_RESERVER3, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getReserver4() != null) {
            obj = et.getReserver4();
            node.setAttribute(FIELD_RESERVER4, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getReserver5() != null) {
            obj = et.getReserver5();
            node.setAttribute(FIELD_RESERVER5, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getShortKey() != null) {
            obj = et.getShortKey();
            node.setAttribute(FIELD_SHORTKEY, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        CodeItemBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(CodeItemBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCodeItemIdDirty() && (bIncEmpty || et.getCodeItemId() != null)) {
            dst.set(FIELD_CODEITEMID, et.getCodeItemId());
        }
        if (et.isCodeItemNameDirty() && (bIncEmpty || et.getCodeItemName() != null)) {
            dst.set(FIELD_CODEITEMNAME, et.getCodeItemName());
        }
        if (et.isCodeItemValueDirty() && (bIncEmpty || et.getCodeItemValue() != null)) {
            dst.set(FIELD_CODEITEMVALUE, et.getCodeItemValue());
        }
        if (et.isCodeListIdDirty() && (bIncEmpty || et.getCodeListId() != null)) {
            dst.set(FIELD_CODELISTID, et.getCodeListId());
        }
        if (et.isCodeListNameDirty() && (bIncEmpty || et.getCodeListName() != null)) {
            dst.set(FIELD_CODELISTNAME, et.getCodeListName());
        }
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isMemoDirty() && (bIncEmpty || et.getMemo() != null)) {
            dst.set(FIELD_MEMO, et.getMemo());
        }
        if (et.isOrderValueDirty() && (bIncEmpty || et.getOrderValue() != null)) {
            dst.set(FIELD_ORDERVALUE, et.getOrderValue());
        }
        if (et.isPCodeItemIdDirty() && (bIncEmpty || et.getPCodeItemId() != null)) {
            dst.set(FIELD_PCODEITEMID, et.getPCodeItemId());
        }
        if (et.isPCodeItemNameDirty() && (bIncEmpty || et.getPCodeItemName() != null)) {
            dst.set(FIELD_PCODEITEMNAME, et.getPCodeItemName());
        }
        if (et.isReserverDirty() && (bIncEmpty || et.getReserver() != null)) {
            dst.set(FIELD_RESERVER, et.getReserver());
        }
        if (et.isReserver2Dirty() && (bIncEmpty || et.getReserver2() != null)) {
            dst.set(FIELD_RESERVER2, et.getReserver2());
        }
        if (et.isReserver3Dirty() && (bIncEmpty || et.getReserver3() != null)) {
            dst.set(FIELD_RESERVER3, et.getReserver3());
        }
        if (et.isReserver4Dirty() && (bIncEmpty || et.getReserver4() != null)) {
            dst.set(FIELD_RESERVER4, et.getReserver4());
        }
        if (et.isReserver5Dirty() && (bIncEmpty || et.getReserver5() != null)) {
            dst.set(FIELD_RESERVER5, et.getReserver5());
        }
        if (et.isShortKeyDirty() && (bIncEmpty || et.getShortKey() != null)) {
            dst.set(FIELD_SHORTKEY, et.getShortKey());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
    }

    @Override
    public boolean remove(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().remove(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.remove(strParamName);
        }
        return CodeItemBase.remove(this, index);
    }

    private static boolean remove(CodeItemBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetCodeItemId();
                return true;
            }
            case 1: {
                et.resetCodeItemName();
                return true;
            }
            case 2: {
                et.resetCodeItemValue();
                return true;
            }
            case 3: {
                et.resetCodeListId();
                return true;
            }
            case 4: {
                et.resetCodeListName();
                return true;
            }
            case 5: {
                et.resetCreateDate();
                return true;
            }
            case 6: {
                et.resetCreateMan();
                return true;
            }
            case 7: {
                et.resetMemo();
                return true;
            }
            case 8: {
                et.resetOrderValue();
                return true;
            }
            case 9: {
                et.resetPCodeItemId();
                return true;
            }
            case 10: {
                et.resetPCodeItemName();
                return true;
            }
            case 11: {
                et.resetReserver();
                return true;
            }
            case 12: {
                et.resetReserver2();
                return true;
            }
            case 13: {
                et.resetReserver3();
                return true;
            }
            case 14: {
                et.resetReserver4();
                return true;
            }
            case 15: {
                et.resetReserver5();
                return true;
            }
            case 16: {
                et.resetShortKey();
                return true;
            }
            case 17: {
                et.resetUpdateDate();
                return true;
            }
            case 18: {
                et.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public CodeItem getPCodeItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPCodeItem();
        }
        if (this.getPCodeItemId() == null) {
            return null;
        }
        Integer n = this.objPCodeItemLock;
        synchronized (n) {
            if (this.pcodeitem != null && DataTypeHelper.compare(25, (Object)this.getPCodeItemId(), (Object)this.pcodeitem.getCodeItemId()) != 0L) {
                this.pcodeitem = null;
            }
            if (this.pcodeitem == null) {
                CodeItem pcodeitem = new CodeItem();
                pcodeitem.setCodeItemId(this.getPCodeItemId());
                CodeItemService service = (CodeItemService)ServiceGlobal.getService(CodeItemService.class, this.getSessionFactory());
                service.autoGet(pcodeitem);
                this.pcodeitem = pcodeitem;
            }
            return this.pcodeitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public CodeList getCodeList() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeList();
        }
        if (this.getCodeListId() == null) {
            return null;
        }
        Integer n = this.objCodeListLock;
        synchronized (n) {
            if (this.codelist != null && DataTypeHelper.compare(25, (Object)this.getCodeListId(), (Object)this.codelist.getCodeListId()) != 0L) {
                this.codelist = null;
            }
            if (this.codelist == null) {
                CodeList codelist = new CodeList();
                codelist.setCodeListId(this.getCodeListId());
                CodeListService service = (CodeListService)ServiceGlobal.getService(CodeListService.class, this.getSessionFactory());
                service.autoGet(codelist);
                this.codelist = codelist;
            }
            return this.codelist;
        }
    }

    private CodeItemBase getProxyEntity() {
        return this.proxyCodeItemBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyCodeItemBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof CodeItemBase) {
            this.proxyCodeItemBase = (CodeItemBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.CodeItemService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

