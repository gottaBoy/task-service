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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBTable;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBTableService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDETableBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDETableBase.class);
    public static final String FIELD_COLINHERITMODE = "COLINHERITMODE";
    public static final String FIELD_COLUMNS = "COLUMNS";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDETABLEID = "PSDETABLEID";
    public static final String FIELD_PSDETABLENAME = "PSDETABLENAME";
    public static final String FIELD_PSSYSDBTABLEID = "PSSYSDBTABLEID";
    public static final String FIELD_PSSYSDBTABLENAME = "PSSYSDBTABLENAME";
    public static final String FIELD_TABLETYPE = "TABLETYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_COLINHERITMODE = 0;
    private static final int INDEX_COLUMNS = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_ORDERVALUE = 5;
    private static final int INDEX_PSDEID = 6;
    private static final int INDEX_PSDENAME = 7;
    private static final int INDEX_PSDETABLEID = 8;
    private static final int INDEX_PSDETABLENAME = 9;
    private static final int INDEX_PSSYSDBTABLEID = 10;
    private static final int INDEX_PSSYSDBTABLENAME = 11;
    private static final int INDEX_TABLETYPE = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final int INDEX_USERCAT = 15;
    private static final int INDEX_USERTAG = 16;
    private static final int INDEX_USERTAG2 = 17;
    private static final int INDEX_USERTAG3 = 18;
    private static final int INDEX_USERTAG4 = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDETableBase proxyPSDETableBase = null;
    private boolean colinheritmodeDirtyFlag = false;
    private boolean columnsDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdetableidDirtyFlag = false;
    private boolean psdetablenameDirtyFlag = false;
    private boolean pssysdbtableidDirtyFlag = false;
    private boolean pssysdbtablenameDirtyFlag = false;
    private boolean tabletypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="colinheritmode")
    private Integer colinheritmode;
    @Column(name="columns")
    private String columns;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdetableid")
    private String psdetableid;
    @Column(name="psdetablename")
    private String psdetablename;
    @Column(name="pssysdbtableid")
    private String pssysdbtableid;
    @Column(name="pssysdbtablename")
    private String pssysdbtablename;
    @Column(name="tabletype")
    private String tabletype;
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
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSSysDBTableLock = new Integer(1);
    private PSSysDBTable pssysdbtable = null;

    public void setColInheritMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setColInheritMode(n);
            return;
        }
        this.colinheritmode = n;
        this.colinheritmodeDirtyFlag = true;
    }

    public Integer getColInheritMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getColInheritMode();
        }
        return this.colinheritmode;
    }

    public boolean isColInheritModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isColInheritModeDirty();
        }
        return this.colinheritmodeDirtyFlag;
    }

    public void resetColInheritMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetColInheritMode();
            return;
        }
        this.colinheritmodeDirtyFlag = false;
        this.colinheritmode = null;
    }

    public void setColumns(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setColumns(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.columns = string;
        this.columnsDirtyFlag = true;
    }

    public String getColumns() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getColumns();
        }
        return this.columns;
    }

    public boolean isColumnsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isColumnsDirty();
        }
        return this.columnsDirtyFlag;
    }

    public void resetColumns() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetColumns();
            return;
        }
        this.columnsDirtyFlag = false;
        this.columns = null;
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

    public void setPSDETableId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETableId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetableid = string;
        this.psdetableidDirtyFlag = true;
    }

    public String getPSDETableId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETableId();
        }
        return this.psdetableid;
    }

    public boolean isPSDETableIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETableIdDirty();
        }
        return this.psdetableidDirtyFlag;
    }

    public void resetPSDETableId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETableId();
            return;
        }
        this.psdetableidDirtyFlag = false;
        this.psdetableid = null;
    }

    public void setPSDETableName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETableName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetablename = string;
        this.psdetablenameDirtyFlag = true;
    }

    public String getPSDETableName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETableName();
        }
        return this.psdetablename;
    }

    public boolean isPSDETableNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETableNameDirty();
        }
        return this.psdetablenameDirtyFlag;
    }

    public void resetPSDETableName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETableName();
            return;
        }
        this.psdetablenameDirtyFlag = false;
        this.psdetablename = null;
    }

    public void setPSSysDBTableId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBTableId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbtableid = string;
        this.pssysdbtableidDirtyFlag = true;
    }

    public String getPSSysDBTableId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBTableId();
        }
        return this.pssysdbtableid;
    }

    public boolean isPSSysDBTableIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBTableIdDirty();
        }
        return this.pssysdbtableidDirtyFlag;
    }

    public void resetPSSysDBTableId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBTableId();
            return;
        }
        this.pssysdbtableidDirtyFlag = false;
        this.pssysdbtableid = null;
    }

    public void setPSSysDBTableName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBTableName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbtablename = string;
        this.pssysdbtablenameDirtyFlag = true;
    }

    public String getPSSysDBTableName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBTableName();
        }
        return this.pssysdbtablename;
    }

    public boolean isPSSysDBTableNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBTableNameDirty();
        }
        return this.pssysdbtablenameDirtyFlag;
    }

    public void resetPSSysDBTableName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBTableName();
            return;
        }
        this.pssysdbtablenameDirtyFlag = false;
        this.pssysdbtablename = null;
    }

    public void setTableType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTableType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tabletype = string;
        this.tabletypeDirtyFlag = true;
    }

    public String getTableType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTableType();
        }
        return this.tabletype;
    }

    public boolean isTableTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTableTypeDirty();
        }
        return this.tabletypeDirtyFlag;
    }

    public void resetTableType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTableType();
            return;
        }
        this.tabletypeDirtyFlag = false;
        this.tabletype = null;
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

    protected void onReset() {
        PSDETableBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDETableBase pSDETableBase) {
        pSDETableBase.resetColInheritMode();
        pSDETableBase.resetColumns();
        pSDETableBase.resetCreateDate();
        pSDETableBase.resetCreateMan();
        pSDETableBase.resetMemo();
        pSDETableBase.resetOrderValue();
        pSDETableBase.resetPSDEId();
        pSDETableBase.resetPSDEName();
        pSDETableBase.resetPSDETableId();
        pSDETableBase.resetPSDETableName();
        pSDETableBase.resetPSSysDBTableId();
        pSDETableBase.resetPSSysDBTableName();
        pSDETableBase.resetTableType();
        pSDETableBase.resetUpdateDate();
        pSDETableBase.resetUpdateMan();
        pSDETableBase.resetUserCat();
        pSDETableBase.resetUserTag();
        pSDETableBase.resetUserTag2();
        pSDETableBase.resetUserTag3();
        pSDETableBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isColInheritModeDirty()) {
            hashMap.put(FIELD_COLINHERITMODE, this.getColInheritMode());
        }
        if (!bl || this.isColumnsDirty()) {
            hashMap.put(FIELD_COLUMNS, this.getColumns());
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
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDETableIdDirty()) {
            hashMap.put(FIELD_PSDETABLEID, this.getPSDETableId());
        }
        if (!bl || this.isPSDETableNameDirty()) {
            hashMap.put(FIELD_PSDETABLENAME, this.getPSDETableName());
        }
        if (!bl || this.isPSSysDBTableIdDirty()) {
            hashMap.put(FIELD_PSSYSDBTABLEID, this.getPSSysDBTableId());
        }
        if (!bl || this.isPSSysDBTableNameDirty()) {
            hashMap.put(FIELD_PSSYSDBTABLENAME, this.getPSSysDBTableName());
        }
        if (!bl || this.isTableTypeDirty()) {
            hashMap.put(FIELD_TABLETYPE, this.getTableType());
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
        return PSDETableBase.get(this, n);
    }

    private static Object get(PSDETableBase pSDETableBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDETableBase.getColInheritMode();
            }
            case 1: {
                return pSDETableBase.getColumns();
            }
            case 2: {
                return pSDETableBase.getCreateDate();
            }
            case 3: {
                return pSDETableBase.getCreateMan();
            }
            case 4: {
                return pSDETableBase.getMemo();
            }
            case 5: {
                return pSDETableBase.getOrderValue();
            }
            case 6: {
                return pSDETableBase.getPSDEId();
            }
            case 7: {
                return pSDETableBase.getPSDEName();
            }
            case 8: {
                return pSDETableBase.getPSDETableId();
            }
            case 9: {
                return pSDETableBase.getPSDETableName();
            }
            case 10: {
                return pSDETableBase.getPSSysDBTableId();
            }
            case 11: {
                return pSDETableBase.getPSSysDBTableName();
            }
            case 12: {
                return pSDETableBase.getTableType();
            }
            case 13: {
                return pSDETableBase.getUpdateDate();
            }
            case 14: {
                return pSDETableBase.getUpdateMan();
            }
            case 15: {
                return pSDETableBase.getUserCat();
            }
            case 16: {
                return pSDETableBase.getUserTag();
            }
            case 17: {
                return pSDETableBase.getUserTag2();
            }
            case 18: {
                return pSDETableBase.getUserTag3();
            }
            case 19: {
                return pSDETableBase.getUserTag4();
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
        PSDETableBase.set(this, n, object);
    }

    private static void set(PSDETableBase pSDETableBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDETableBase.setColInheritMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDETableBase.setColumns(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDETableBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDETableBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDETableBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDETableBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDETableBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDETableBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDETableBase.setPSDETableId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDETableBase.setPSDETableName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDETableBase.setPSSysDBTableId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDETableBase.setPSSysDBTableName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDETableBase.setTableType(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDETableBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSDETableBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDETableBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDETableBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDETableBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDETableBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDETableBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDETableBase.isNull(this, n);
    }

    private static boolean isNull(PSDETableBase pSDETableBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDETableBase.getColInheritMode() == null;
            }
            case 1: {
                return pSDETableBase.getColumns() == null;
            }
            case 2: {
                return pSDETableBase.getCreateDate() == null;
            }
            case 3: {
                return pSDETableBase.getCreateMan() == null;
            }
            case 4: {
                return pSDETableBase.getMemo() == null;
            }
            case 5: {
                return pSDETableBase.getOrderValue() == null;
            }
            case 6: {
                return pSDETableBase.getPSDEId() == null;
            }
            case 7: {
                return pSDETableBase.getPSDEName() == null;
            }
            case 8: {
                return pSDETableBase.getPSDETableId() == null;
            }
            case 9: {
                return pSDETableBase.getPSDETableName() == null;
            }
            case 10: {
                return pSDETableBase.getPSSysDBTableId() == null;
            }
            case 11: {
                return pSDETableBase.getPSSysDBTableName() == null;
            }
            case 12: {
                return pSDETableBase.getTableType() == null;
            }
            case 13: {
                return pSDETableBase.getUpdateDate() == null;
            }
            case 14: {
                return pSDETableBase.getUpdateMan() == null;
            }
            case 15: {
                return pSDETableBase.getUserCat() == null;
            }
            case 16: {
                return pSDETableBase.getUserTag() == null;
            }
            case 17: {
                return pSDETableBase.getUserTag2() == null;
            }
            case 18: {
                return pSDETableBase.getUserTag3() == null;
            }
            case 19: {
                return pSDETableBase.getUserTag4() == null;
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
        return PSDETableBase.contains(this, n);
    }

    private static boolean contains(PSDETableBase pSDETableBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDETableBase.isColInheritModeDirty();
            }
            case 1: {
                return pSDETableBase.isColumnsDirty();
            }
            case 2: {
                return pSDETableBase.isCreateDateDirty();
            }
            case 3: {
                return pSDETableBase.isCreateManDirty();
            }
            case 4: {
                return pSDETableBase.isMemoDirty();
            }
            case 5: {
                return pSDETableBase.isOrderValueDirty();
            }
            case 6: {
                return pSDETableBase.isPSDEIdDirty();
            }
            case 7: {
                return pSDETableBase.isPSDENameDirty();
            }
            case 8: {
                return pSDETableBase.isPSDETableIdDirty();
            }
            case 9: {
                return pSDETableBase.isPSDETableNameDirty();
            }
            case 10: {
                return pSDETableBase.isPSSysDBTableIdDirty();
            }
            case 11: {
                return pSDETableBase.isPSSysDBTableNameDirty();
            }
            case 12: {
                return pSDETableBase.isTableTypeDirty();
            }
            case 13: {
                return pSDETableBase.isUpdateDateDirty();
            }
            case 14: {
                return pSDETableBase.isUpdateManDirty();
            }
            case 15: {
                return pSDETableBase.isUserCatDirty();
            }
            case 16: {
                return pSDETableBase.isUserTagDirty();
            }
            case 17: {
                return pSDETableBase.isUserTag2Dirty();
            }
            case 18: {
                return pSDETableBase.isUserTag3Dirty();
            }
            case 19: {
                return pSDETableBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDETableBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDETableBase pSDETableBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDETableBase.getColInheritMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"colinheritmode", (Object)PSDETableBase.getJSONValue((Object)pSDETableBase.getColInheritMode()), (boolean)false);
        }
        if (bl || pSDETableBase.getColumns() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"columns", (Object)PSDETableBase.getJSONValue((Object)pSDETableBase.getColumns()), (boolean)false);
        }
        if (bl || pSDETableBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDETableBase.getJSONValue((Object)pSDETableBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDETableBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDETableBase.getJSONValue((Object)pSDETableBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDETableBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDETableBase.getJSONValue((Object)pSDETableBase.getMemo()), (boolean)false);
        }
        if (bl || pSDETableBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDETableBase.getJSONValue((Object)pSDETableBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDETableBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDETableBase.getJSONValue((Object)pSDETableBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDETableBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDETableBase.getJSONValue((Object)pSDETableBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDETableBase.getPSDETableId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetableid", (Object)PSDETableBase.getJSONValue((Object)pSDETableBase.getPSDETableId()), (boolean)false);
        }
        if (bl || pSDETableBase.getPSDETableName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetablename", (Object)PSDETableBase.getJSONValue((Object)pSDETableBase.getPSDETableName()), (boolean)false);
        }
        if (bl || pSDETableBase.getPSSysDBTableId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbtableid", (Object)PSDETableBase.getJSONValue((Object)pSDETableBase.getPSSysDBTableId()), (boolean)false);
        }
        if (bl || pSDETableBase.getPSSysDBTableName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbtablename", (Object)PSDETableBase.getJSONValue((Object)pSDETableBase.getPSSysDBTableName()), (boolean)false);
        }
        if (bl || pSDETableBase.getTableType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tabletype", (Object)PSDETableBase.getJSONValue((Object)pSDETableBase.getTableType()), (boolean)false);
        }
        if (bl || pSDETableBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDETableBase.getJSONValue((Object)pSDETableBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDETableBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDETableBase.getJSONValue((Object)pSDETableBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDETableBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDETableBase.getJSONValue((Object)pSDETableBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDETableBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDETableBase.getJSONValue((Object)pSDETableBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDETableBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDETableBase.getJSONValue((Object)pSDETableBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDETableBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDETableBase.getJSONValue((Object)pSDETableBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDETableBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDETableBase.getJSONValue((Object)pSDETableBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDETableBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDETableBase pSDETableBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDETableBase.getColInheritMode() != null) {
            object = pSDETableBase.getColInheritMode();
            xmlNode.setAttribute(FIELD_COLINHERITMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETableBase.getColumns() != null) {
            object = pSDETableBase.getColumns();
            xmlNode.setAttribute(FIELD_COLUMNS, object == null ? "" : (String)object);
        }
        if (bl || pSDETableBase.getCreateDate() != null) {
            object = pSDETableBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDETableBase.getCreateMan() != null) {
            object = pSDETableBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDETableBase.getMemo() != null) {
            object = pSDETableBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDETableBase.getOrderValue() != null) {
            object = pSDETableBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETableBase.getPSDEId() != null) {
            object = pSDETableBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDETableBase.getPSDEName() != null) {
            object = pSDETableBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETableBase.getPSDETableId() != null) {
            object = pSDETableBase.getPSDETableId();
            xmlNode.setAttribute(FIELD_PSDETABLEID, object == null ? "" : (String)object);
        }
        if (bl || pSDETableBase.getPSDETableName() != null) {
            object = pSDETableBase.getPSDETableName();
            xmlNode.setAttribute(FIELD_PSDETABLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETableBase.getPSSysDBTableId() != null) {
            object = pSDETableBase.getPSSysDBTableId();
            xmlNode.setAttribute(FIELD_PSSYSDBTABLEID, object == null ? "" : (String)object);
        }
        if (bl || pSDETableBase.getPSSysDBTableName() != null) {
            object = pSDETableBase.getPSSysDBTableName();
            xmlNode.setAttribute(FIELD_PSSYSDBTABLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETableBase.getTableType() != null) {
            object = pSDETableBase.getTableType();
            xmlNode.setAttribute(FIELD_TABLETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDETableBase.getUpdateDate() != null) {
            object = pSDETableBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDETableBase.getUpdateMan() != null) {
            object = pSDETableBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDETableBase.getUserCat() != null) {
            object = pSDETableBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDETableBase.getUserTag() != null) {
            object = pSDETableBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDETableBase.getUserTag2() != null) {
            object = pSDETableBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDETableBase.getUserTag3() != null) {
            object = pSDETableBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDETableBase.getUserTag4() != null) {
            object = pSDETableBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDETableBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDETableBase pSDETableBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDETableBase.isColInheritModeDirty() && (bl || pSDETableBase.getColInheritMode() != null)) {
            iDataObject.set(FIELD_COLINHERITMODE, (Object)pSDETableBase.getColInheritMode());
        }
        if (pSDETableBase.isColumnsDirty() && (bl || pSDETableBase.getColumns() != null)) {
            iDataObject.set(FIELD_COLUMNS, (Object)pSDETableBase.getColumns());
        }
        if (pSDETableBase.isCreateDateDirty() && (bl || pSDETableBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDETableBase.getCreateDate());
        }
        if (pSDETableBase.isCreateManDirty() && (bl || pSDETableBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDETableBase.getCreateMan());
        }
        if (pSDETableBase.isMemoDirty() && (bl || pSDETableBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDETableBase.getMemo());
        }
        if (pSDETableBase.isOrderValueDirty() && (bl || pSDETableBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDETableBase.getOrderValue());
        }
        if (pSDETableBase.isPSDEIdDirty() && (bl || pSDETableBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDETableBase.getPSDEId());
        }
        if (pSDETableBase.isPSDENameDirty() && (bl || pSDETableBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDETableBase.getPSDEName());
        }
        if (pSDETableBase.isPSDETableIdDirty() && (bl || pSDETableBase.getPSDETableId() != null)) {
            iDataObject.set(FIELD_PSDETABLEID, (Object)pSDETableBase.getPSDETableId());
        }
        if (pSDETableBase.isPSDETableNameDirty() && (bl || pSDETableBase.getPSDETableName() != null)) {
            iDataObject.set(FIELD_PSDETABLENAME, (Object)pSDETableBase.getPSDETableName());
        }
        if (pSDETableBase.isPSSysDBTableIdDirty() && (bl || pSDETableBase.getPSSysDBTableId() != null)) {
            iDataObject.set(FIELD_PSSYSDBTABLEID, (Object)pSDETableBase.getPSSysDBTableId());
        }
        if (pSDETableBase.isPSSysDBTableNameDirty() && (bl || pSDETableBase.getPSSysDBTableName() != null)) {
            iDataObject.set(FIELD_PSSYSDBTABLENAME, (Object)pSDETableBase.getPSSysDBTableName());
        }
        if (pSDETableBase.isTableTypeDirty() && (bl || pSDETableBase.getTableType() != null)) {
            iDataObject.set(FIELD_TABLETYPE, (Object)pSDETableBase.getTableType());
        }
        if (pSDETableBase.isUpdateDateDirty() && (bl || pSDETableBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDETableBase.getUpdateDate());
        }
        if (pSDETableBase.isUpdateManDirty() && (bl || pSDETableBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDETableBase.getUpdateMan());
        }
        if (pSDETableBase.isUserCatDirty() && (bl || pSDETableBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDETableBase.getUserCat());
        }
        if (pSDETableBase.isUserTagDirty() && (bl || pSDETableBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDETableBase.getUserTag());
        }
        if (pSDETableBase.isUserTag2Dirty() && (bl || pSDETableBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDETableBase.getUserTag2());
        }
        if (pSDETableBase.isUserTag3Dirty() && (bl || pSDETableBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDETableBase.getUserTag3());
        }
        if (pSDETableBase.isUserTag4Dirty() && (bl || pSDETableBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDETableBase.getUserTag4());
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
        return PSDETableBase.remove(this, n);
    }

    private static boolean remove(PSDETableBase pSDETableBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDETableBase.resetColInheritMode();
                return true;
            }
            case 1: {
                pSDETableBase.resetColumns();
                return true;
            }
            case 2: {
                pSDETableBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDETableBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDETableBase.resetMemo();
                return true;
            }
            case 5: {
                pSDETableBase.resetOrderValue();
                return true;
            }
            case 6: {
                pSDETableBase.resetPSDEId();
                return true;
            }
            case 7: {
                pSDETableBase.resetPSDEName();
                return true;
            }
            case 8: {
                pSDETableBase.resetPSDETableId();
                return true;
            }
            case 9: {
                pSDETableBase.resetPSDETableName();
                return true;
            }
            case 10: {
                pSDETableBase.resetPSSysDBTableId();
                return true;
            }
            case 11: {
                pSDETableBase.resetPSSysDBTableName();
                return true;
            }
            case 12: {
                pSDETableBase.resetTableType();
                return true;
            }
            case 13: {
                pSDETableBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSDETableBase.resetUpdateMan();
                return true;
            }
            case 15: {
                pSDETableBase.resetUserCat();
                return true;
            }
            case 16: {
                pSDETableBase.resetUserTag();
                return true;
            }
            case 17: {
                pSDETableBase.resetUserTag2();
                return true;
            }
            case 18: {
                pSDETableBase.resetUserTag3();
                return true;
            }
            case 19: {
                pSDETableBase.resetUserTag4();
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
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDBTable getPSSysDBTable() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBTable();
        }
        if (this.getPSSysDBTableId() == null) {
            return null;
        }
        Integer n = this.objPSSysDBTableLock;
        synchronized (n) {
            if (this.pssysdbtable != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDBTableId(), (Object)this.pssysdbtable.getPSSysDBTableId()) != 0L) {
                this.pssysdbtable = null;
            }
            if (this.pssysdbtable == null) {
                PSSysDBTable pSSysDBTable = new PSSysDBTable();
                pSSysDBTable.setPSSysDBTableId(this.getPSSysDBTableId());
                PSSysDBTableService pSSysDBTableService = (PSSysDBTableService)ServiceGlobal.getService(PSSysDBTableService.class, (SessionFactory)this.getSessionFactory());
                pSSysDBTableService.autoGet((IEntity)pSSysDBTable);
                this.pssysdbtable = pSSysDBTable;
            }
            return this.pssysdbtable;
        }
    }

    private PSDETableBase getProxyEntity() {
        return this.proxyPSDETableBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDETableBase = null;
        if (iDataObject != null && iDataObject instanceof PSDETableBase) {
            this.proxyPSDETableBase = (PSDETableBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDETableService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_COLINHERITMODE, 0);
        fieldIndexMap.put(FIELD_COLUMNS, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_ORDERVALUE, 5);
        fieldIndexMap.put(FIELD_PSDEID, 6);
        fieldIndexMap.put(FIELD_PSDENAME, 7);
        fieldIndexMap.put(FIELD_PSDETABLEID, 8);
        fieldIndexMap.put(FIELD_PSDETABLENAME, 9);
        fieldIndexMap.put(FIELD_PSSYSDBTABLEID, 10);
        fieldIndexMap.put(FIELD_PSSYSDBTABLENAME, 11);
        fieldIndexMap.put(FIELD_TABLETYPE, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
        fieldIndexMap.put(FIELD_USERCAT, 15);
        fieldIndexMap.put(FIELD_USERTAG, 16);
        fieldIndexMap.put(FIELD_USERTAG2, 17);
        fieldIndexMap.put(FIELD_USERTAG3, 18);
        fieldIndexMap.put(FIELD_USERTAG4, 19);
    }
}

