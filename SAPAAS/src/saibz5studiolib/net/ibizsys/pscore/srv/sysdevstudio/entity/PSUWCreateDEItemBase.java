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
package net.ibizsys.pscore.srv.sysdevstudio.entity;

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
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWCreateDE;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSUWCreateDEService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSUWCreateDEItemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSUWCreateDEItemBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ITEMPARAM = "ITEMPARAM";
    public static final String FIELD_ITEMPARAM2 = "ITEMPARAM2";
    public static final String FIELD_ITEMPARAM3 = "ITEMPARAM3";
    public static final String FIELD_ITEMPARAM4 = "ITEMPARAM4";
    public static final String FIELD_NEWCODENAME = "NEWCODENAME";
    public static final String FIELD_NEWDELOGICNAME = "NEWDELOGICNAME";
    public static final String FIELD_NEWDENAME = "NEWDENAME";
    public static final String FIELD_NEWDETABLENAME = "NEWDETABLENAME";
    public static final String FIELD_NEWDEVIEWNAME = "NEWDEVIEWNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSUWCREATEDEID = "PSUWCREATEDEID";
    public static final String FIELD_PSUWCREATEDEITEMID = "PSUWCREATEDEITEMID";
    public static final String FIELD_PSUWCREATEDEITEMNAME = "PSUWCREATEDEITEMNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_ITEMPARAM = 3;
    private static final int INDEX_ITEMPARAM2 = 4;
    private static final int INDEX_ITEMPARAM3 = 5;
    private static final int INDEX_ITEMPARAM4 = 6;
    private static final int INDEX_NEWCODENAME = 7;
    private static final int INDEX_NEWDELOGICNAME = 8;
    private static final int INDEX_NEWDENAME = 9;
    private static final int INDEX_NEWDETABLENAME = 10;
    private static final int INDEX_NEWDEVIEWNAME = 11;
    private static final int INDEX_PSDEID = 12;
    private static final int INDEX_PSDENAME = 13;
    private static final int INDEX_PSDYNAINSTID = 14;
    private static final int INDEX_PSUWCREATEDEID = 15;
    private static final int INDEX_PSUWCREATEDEITEMID = 16;
    private static final int INDEX_PSUWCREATEDEITEMNAME = 17;
    private static final int INDEX_UPDATEDATE = 18;
    private static final int INDEX_UPDATEMAN = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSUWCreateDEItemBase proxyPSUWCreateDEItemBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean itemparamDirtyFlag = false;
    private boolean itemparam2DirtyFlag = false;
    private boolean itemparam3DirtyFlag = false;
    private boolean itemparam4DirtyFlag = false;
    private boolean newcodenameDirtyFlag = false;
    private boolean newdelogicnameDirtyFlag = false;
    private boolean newdenameDirtyFlag = false;
    private boolean newdetablenameDirtyFlag = false;
    private boolean newdeviewnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean psuwcreatedeidDirtyFlag = false;
    private boolean psuwcreatedeitemidDirtyFlag = false;
    private boolean psuwcreatedeitemnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="itemparam")
    private String itemparam;
    @Column(name="itemparam2")
    private String itemparam2;
    @Column(name="itemparam3")
    private Integer itemparam3;
    @Column(name="itemparam4")
    private Integer itemparam4;
    @Column(name="newcodename")
    private String newcodename;
    @Column(name="newdelogicname")
    private String newdelogicname;
    @Column(name="newdename")
    private String newdename;
    @Column(name="newdetablename")
    private String newdetablename;
    @Column(name="newdeviewname")
    private String newdeviewname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="psuwcreatedeid")
    private String psuwcreatedeid;
    @Column(name="psuwcreatedeitemid")
    private String psuwcreatedeitemid;
    @Column(name="psuwcreatedeitemname")
    private String psuwcreatedeitemname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSUWCreateDELock = new Integer(1);
    private PSUWCreateDE psuwcreatede = null;

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

    public void setItemParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemparam = string;
        this.itemparamDirtyFlag = true;
    }

    public String getItemParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemParam();
        }
        return this.itemparam;
    }

    public boolean isItemParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemParamDirty();
        }
        return this.itemparamDirtyFlag;
    }

    public void resetItemParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemParam();
            return;
        }
        this.itemparamDirtyFlag = false;
        this.itemparam = null;
    }

    public void setItemParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemparam2 = string;
        this.itemparam2DirtyFlag = true;
    }

    public String getItemParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemParam2();
        }
        return this.itemparam2;
    }

    public boolean isItemParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemParam2Dirty();
        }
        return this.itemparam2DirtyFlag;
    }

    public void resetItemParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemParam2();
            return;
        }
        this.itemparam2DirtyFlag = false;
        this.itemparam2 = null;
    }

    public void setItemParam3(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemParam3(n);
            return;
        }
        this.itemparam3 = n;
        this.itemparam3DirtyFlag = true;
    }

    public Integer getItemParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemParam3();
        }
        return this.itemparam3;
    }

    public boolean isItemParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemParam3Dirty();
        }
        return this.itemparam3DirtyFlag;
    }

    public void resetItemParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemParam3();
            return;
        }
        this.itemparam3DirtyFlag = false;
        this.itemparam3 = null;
    }

    public void setItemParam4(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemParam4(n);
            return;
        }
        this.itemparam4 = n;
        this.itemparam4DirtyFlag = true;
    }

    public Integer getItemParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemParam4();
        }
        return this.itemparam4;
    }

    public boolean isItemParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemParam4Dirty();
        }
        return this.itemparam4DirtyFlag;
    }

    public void resetItemParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemParam4();
            return;
        }
        this.itemparam4DirtyFlag = false;
        this.itemparam4 = null;
    }

    public void setNewCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNewCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.newcodename = string;
        this.newcodenameDirtyFlag = true;
    }

    public String getNewCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNewCodeName();
        }
        return this.newcodename;
    }

    public boolean isNewCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNewCodeNameDirty();
        }
        return this.newcodenameDirtyFlag;
    }

    public void resetNewCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNewCodeName();
            return;
        }
        this.newcodenameDirtyFlag = false;
        this.newcodename = null;
    }

    public void setNewDELogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNewDELogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.newdelogicname = string;
        this.newdelogicnameDirtyFlag = true;
    }

    public String getNewDELogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNewDELogicName();
        }
        return this.newdelogicname;
    }

    public boolean isNewDELogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNewDELogicNameDirty();
        }
        return this.newdelogicnameDirtyFlag;
    }

    public void resetNewDELogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNewDELogicName();
            return;
        }
        this.newdelogicnameDirtyFlag = false;
        this.newdelogicname = null;
    }

    public void setNewDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNewDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.newdename = string;
        this.newdenameDirtyFlag = true;
    }

    public String getNewDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNewDEName();
        }
        return this.newdename;
    }

    public boolean isNewDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNewDENameDirty();
        }
        return this.newdenameDirtyFlag;
    }

    public void resetNewDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNewDEName();
            return;
        }
        this.newdenameDirtyFlag = false;
        this.newdename = null;
    }

    public void setNewDETableName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNewDETableName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.newdetablename = string;
        this.newdetablenameDirtyFlag = true;
    }

    public String getNewDETableName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNewDETableName();
        }
        return this.newdetablename;
    }

    public boolean isNewDETableNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNewDETableNameDirty();
        }
        return this.newdetablenameDirtyFlag;
    }

    public void resetNewDETableName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNewDETableName();
            return;
        }
        this.newdetablenameDirtyFlag = false;
        this.newdetablename = null;
    }

    public void setNewDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNewDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.newdeviewname = string;
        this.newdeviewnameDirtyFlag = true;
    }

    public String getNewDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNewDEViewName();
        }
        return this.newdeviewname;
    }

    public boolean isNewDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNewDEViewNameDirty();
        }
        return this.newdeviewnameDirtyFlag;
    }

    public void resetNewDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNewDEViewName();
            return;
        }
        this.newdeviewnameDirtyFlag = false;
        this.newdeviewname = null;
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

    public void setPSDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstid = string;
        this.psdynainstidDirtyFlag = true;
    }

    public String getPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstId();
        }
        return this.psdynainstid;
    }

    public boolean isPSDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstIdDirty();
        }
        return this.psdynainstidDirtyFlag;
    }

    public void resetPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstId();
            return;
        }
        this.psdynainstidDirtyFlag = false;
        this.psdynainstid = null;
    }

    public void setPSUWCreateDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUWCreateDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuwcreatedeid = string;
        this.psuwcreatedeidDirtyFlag = true;
    }

    public String getPSUWCreateDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUWCreateDEId();
        }
        return this.psuwcreatedeid;
    }

    public boolean isPSUWCreateDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUWCreateDEIdDirty();
        }
        return this.psuwcreatedeidDirtyFlag;
    }

    public void resetPSUWCreateDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUWCreateDEId();
            return;
        }
        this.psuwcreatedeidDirtyFlag = false;
        this.psuwcreatedeid = null;
    }

    public void setPSUWCreateDEItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUWCreateDEItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuwcreatedeitemid = string;
        this.psuwcreatedeitemidDirtyFlag = true;
    }

    public String getPSUWCreateDEItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUWCreateDEItemId();
        }
        return this.psuwcreatedeitemid;
    }

    public boolean isPSUWCreateDEItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUWCreateDEItemIdDirty();
        }
        return this.psuwcreatedeitemidDirtyFlag;
    }

    public void resetPSUWCreateDEItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUWCreateDEItemId();
            return;
        }
        this.psuwcreatedeitemidDirtyFlag = false;
        this.psuwcreatedeitemid = null;
    }

    public void setPSUWCreateDEItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUWCreateDEItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuwcreatedeitemname = string;
        this.psuwcreatedeitemnameDirtyFlag = true;
    }

    public String getPSUWCreateDEItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUWCreateDEItemName();
        }
        return this.psuwcreatedeitemname;
    }

    public boolean isPSUWCreateDEItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUWCreateDEItemNameDirty();
        }
        return this.psuwcreatedeitemnameDirtyFlag;
    }

    public void resetPSUWCreateDEItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUWCreateDEItemName();
            return;
        }
        this.psuwcreatedeitemnameDirtyFlag = false;
        this.psuwcreatedeitemname = null;
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
        PSUWCreateDEItemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSUWCreateDEItemBase pSUWCreateDEItemBase) {
        pSUWCreateDEItemBase.resetCodeName();
        pSUWCreateDEItemBase.resetCreateDate();
        pSUWCreateDEItemBase.resetCreateMan();
        pSUWCreateDEItemBase.resetItemParam();
        pSUWCreateDEItemBase.resetItemParam2();
        pSUWCreateDEItemBase.resetItemParam3();
        pSUWCreateDEItemBase.resetItemParam4();
        pSUWCreateDEItemBase.resetNewCodeName();
        pSUWCreateDEItemBase.resetNewDELogicName();
        pSUWCreateDEItemBase.resetNewDEName();
        pSUWCreateDEItemBase.resetNewDETableName();
        pSUWCreateDEItemBase.resetNewDEViewName();
        pSUWCreateDEItemBase.resetPSDEId();
        pSUWCreateDEItemBase.resetPSDEName();
        pSUWCreateDEItemBase.resetPSDynaInstId();
        pSUWCreateDEItemBase.resetPSUWCreateDEId();
        pSUWCreateDEItemBase.resetPSUWCreateDEItemId();
        pSUWCreateDEItemBase.resetPSUWCreateDEItemName();
        pSUWCreateDEItemBase.resetUpdateDate();
        pSUWCreateDEItemBase.resetUpdateMan();
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
        if (!bl || this.isItemParamDirty()) {
            hashMap.put(FIELD_ITEMPARAM, this.getItemParam());
        }
        if (!bl || this.isItemParam2Dirty()) {
            hashMap.put(FIELD_ITEMPARAM2, this.getItemParam2());
        }
        if (!bl || this.isItemParam3Dirty()) {
            hashMap.put(FIELD_ITEMPARAM3, this.getItemParam3());
        }
        if (!bl || this.isItemParam4Dirty()) {
            hashMap.put(FIELD_ITEMPARAM4, this.getItemParam4());
        }
        if (!bl || this.isNewCodeNameDirty()) {
            hashMap.put(FIELD_NEWCODENAME, this.getNewCodeName());
        }
        if (!bl || this.isNewDELogicNameDirty()) {
            hashMap.put(FIELD_NEWDELOGICNAME, this.getNewDELogicName());
        }
        if (!bl || this.isNewDENameDirty()) {
            hashMap.put(FIELD_NEWDENAME, this.getNewDEName());
        }
        if (!bl || this.isNewDETableNameDirty()) {
            hashMap.put(FIELD_NEWDETABLENAME, this.getNewDETableName());
        }
        if (!bl || this.isNewDEViewNameDirty()) {
            hashMap.put(FIELD_NEWDEVIEWNAME, this.getNewDEViewName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSUWCreateDEIdDirty()) {
            hashMap.put(FIELD_PSUWCREATEDEID, this.getPSUWCreateDEId());
        }
        if (!bl || this.isPSUWCreateDEItemIdDirty()) {
            hashMap.put(FIELD_PSUWCREATEDEITEMID, this.getPSUWCreateDEItemId());
        }
        if (!bl || this.isPSUWCreateDEItemNameDirty()) {
            hashMap.put(FIELD_PSUWCREATEDEITEMNAME, this.getPSUWCreateDEItemName());
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
        return PSUWCreateDEItemBase.get(this, n);
    }

    private static Object get(PSUWCreateDEItemBase pSUWCreateDEItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWCreateDEItemBase.getCodeName();
            }
            case 1: {
                return pSUWCreateDEItemBase.getCreateDate();
            }
            case 2: {
                return pSUWCreateDEItemBase.getCreateMan();
            }
            case 3: {
                return pSUWCreateDEItemBase.getItemParam();
            }
            case 4: {
                return pSUWCreateDEItemBase.getItemParam2();
            }
            case 5: {
                return pSUWCreateDEItemBase.getItemParam3();
            }
            case 6: {
                return pSUWCreateDEItemBase.getItemParam4();
            }
            case 7: {
                return pSUWCreateDEItemBase.getNewCodeName();
            }
            case 8: {
                return pSUWCreateDEItemBase.getNewDELogicName();
            }
            case 9: {
                return pSUWCreateDEItemBase.getNewDEName();
            }
            case 10: {
                return pSUWCreateDEItemBase.getNewDETableName();
            }
            case 11: {
                return pSUWCreateDEItemBase.getNewDEViewName();
            }
            case 12: {
                return pSUWCreateDEItemBase.getPSDEId();
            }
            case 13: {
                return pSUWCreateDEItemBase.getPSDEName();
            }
            case 14: {
                return pSUWCreateDEItemBase.getPSDynaInstId();
            }
            case 15: {
                return pSUWCreateDEItemBase.getPSUWCreateDEId();
            }
            case 16: {
                return pSUWCreateDEItemBase.getPSUWCreateDEItemId();
            }
            case 17: {
                return pSUWCreateDEItemBase.getPSUWCreateDEItemName();
            }
            case 18: {
                return pSUWCreateDEItemBase.getUpdateDate();
            }
            case 19: {
                return pSUWCreateDEItemBase.getUpdateMan();
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
        PSUWCreateDEItemBase.set(this, n, object);
    }

    private static void set(PSUWCreateDEItemBase pSUWCreateDEItemBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSUWCreateDEItemBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSUWCreateDEItemBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSUWCreateDEItemBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSUWCreateDEItemBase.setItemParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSUWCreateDEItemBase.setItemParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSUWCreateDEItemBase.setItemParam3(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSUWCreateDEItemBase.setItemParam4(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSUWCreateDEItemBase.setNewCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSUWCreateDEItemBase.setNewDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSUWCreateDEItemBase.setNewDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSUWCreateDEItemBase.setNewDETableName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSUWCreateDEItemBase.setNewDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSUWCreateDEItemBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSUWCreateDEItemBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSUWCreateDEItemBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSUWCreateDEItemBase.setPSUWCreateDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSUWCreateDEItemBase.setPSUWCreateDEItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSUWCreateDEItemBase.setPSUWCreateDEItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSUWCreateDEItemBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 19: {
                pSUWCreateDEItemBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSUWCreateDEItemBase.isNull(this, n);
    }

    private static boolean isNull(PSUWCreateDEItemBase pSUWCreateDEItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWCreateDEItemBase.getCodeName() == null;
            }
            case 1: {
                return pSUWCreateDEItemBase.getCreateDate() == null;
            }
            case 2: {
                return pSUWCreateDEItemBase.getCreateMan() == null;
            }
            case 3: {
                return pSUWCreateDEItemBase.getItemParam() == null;
            }
            case 4: {
                return pSUWCreateDEItemBase.getItemParam2() == null;
            }
            case 5: {
                return pSUWCreateDEItemBase.getItemParam3() == null;
            }
            case 6: {
                return pSUWCreateDEItemBase.getItemParam4() == null;
            }
            case 7: {
                return pSUWCreateDEItemBase.getNewCodeName() == null;
            }
            case 8: {
                return pSUWCreateDEItemBase.getNewDELogicName() == null;
            }
            case 9: {
                return pSUWCreateDEItemBase.getNewDEName() == null;
            }
            case 10: {
                return pSUWCreateDEItemBase.getNewDETableName() == null;
            }
            case 11: {
                return pSUWCreateDEItemBase.getNewDEViewName() == null;
            }
            case 12: {
                return pSUWCreateDEItemBase.getPSDEId() == null;
            }
            case 13: {
                return pSUWCreateDEItemBase.getPSDEName() == null;
            }
            case 14: {
                return pSUWCreateDEItemBase.getPSDynaInstId() == null;
            }
            case 15: {
                return pSUWCreateDEItemBase.getPSUWCreateDEId() == null;
            }
            case 16: {
                return pSUWCreateDEItemBase.getPSUWCreateDEItemId() == null;
            }
            case 17: {
                return pSUWCreateDEItemBase.getPSUWCreateDEItemName() == null;
            }
            case 18: {
                return pSUWCreateDEItemBase.getUpdateDate() == null;
            }
            case 19: {
                return pSUWCreateDEItemBase.getUpdateMan() == null;
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
        return PSUWCreateDEItemBase.contains(this, n);
    }

    private static boolean contains(PSUWCreateDEItemBase pSUWCreateDEItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWCreateDEItemBase.isCodeNameDirty();
            }
            case 1: {
                return pSUWCreateDEItemBase.isCreateDateDirty();
            }
            case 2: {
                return pSUWCreateDEItemBase.isCreateManDirty();
            }
            case 3: {
                return pSUWCreateDEItemBase.isItemParamDirty();
            }
            case 4: {
                return pSUWCreateDEItemBase.isItemParam2Dirty();
            }
            case 5: {
                return pSUWCreateDEItemBase.isItemParam3Dirty();
            }
            case 6: {
                return pSUWCreateDEItemBase.isItemParam4Dirty();
            }
            case 7: {
                return pSUWCreateDEItemBase.isNewCodeNameDirty();
            }
            case 8: {
                return pSUWCreateDEItemBase.isNewDELogicNameDirty();
            }
            case 9: {
                return pSUWCreateDEItemBase.isNewDENameDirty();
            }
            case 10: {
                return pSUWCreateDEItemBase.isNewDETableNameDirty();
            }
            case 11: {
                return pSUWCreateDEItemBase.isNewDEViewNameDirty();
            }
            case 12: {
                return pSUWCreateDEItemBase.isPSDEIdDirty();
            }
            case 13: {
                return pSUWCreateDEItemBase.isPSDENameDirty();
            }
            case 14: {
                return pSUWCreateDEItemBase.isPSDynaInstIdDirty();
            }
            case 15: {
                return pSUWCreateDEItemBase.isPSUWCreateDEIdDirty();
            }
            case 16: {
                return pSUWCreateDEItemBase.isPSUWCreateDEItemIdDirty();
            }
            case 17: {
                return pSUWCreateDEItemBase.isPSUWCreateDEItemNameDirty();
            }
            case 18: {
                return pSUWCreateDEItemBase.isUpdateDateDirty();
            }
            case 19: {
                return pSUWCreateDEItemBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSUWCreateDEItemBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSUWCreateDEItemBase pSUWCreateDEItemBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSUWCreateDEItemBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSUWCreateDEItemBase.getJSONValue((Object)pSUWCreateDEItemBase.getCodeName()), (boolean)false);
        }
        if (bl || pSUWCreateDEItemBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSUWCreateDEItemBase.getJSONValue((Object)pSUWCreateDEItemBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSUWCreateDEItemBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSUWCreateDEItemBase.getJSONValue((Object)pSUWCreateDEItemBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSUWCreateDEItemBase.getItemParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemparam", (Object)PSUWCreateDEItemBase.getJSONValue((Object)pSUWCreateDEItemBase.getItemParam()), (boolean)false);
        }
        if (bl || pSUWCreateDEItemBase.getItemParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemparam2", (Object)PSUWCreateDEItemBase.getJSONValue((Object)pSUWCreateDEItemBase.getItemParam2()), (boolean)false);
        }
        if (bl || pSUWCreateDEItemBase.getItemParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemparam3", (Object)PSUWCreateDEItemBase.getJSONValue((Object)pSUWCreateDEItemBase.getItemParam3()), (boolean)false);
        }
        if (bl || pSUWCreateDEItemBase.getItemParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemparam4", (Object)PSUWCreateDEItemBase.getJSONValue((Object)pSUWCreateDEItemBase.getItemParam4()), (boolean)false);
        }
        if (bl || pSUWCreateDEItemBase.getNewCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"newcodename", (Object)PSUWCreateDEItemBase.getJSONValue((Object)pSUWCreateDEItemBase.getNewCodeName()), (boolean)false);
        }
        if (bl || pSUWCreateDEItemBase.getNewDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"newdelogicname", (Object)PSUWCreateDEItemBase.getJSONValue((Object)pSUWCreateDEItemBase.getNewDELogicName()), (boolean)false);
        }
        if (bl || pSUWCreateDEItemBase.getNewDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"newdename", (Object)PSUWCreateDEItemBase.getJSONValue((Object)pSUWCreateDEItemBase.getNewDEName()), (boolean)false);
        }
        if (bl || pSUWCreateDEItemBase.getNewDETableName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"newdetablename", (Object)PSUWCreateDEItemBase.getJSONValue((Object)pSUWCreateDEItemBase.getNewDETableName()), (boolean)false);
        }
        if (bl || pSUWCreateDEItemBase.getNewDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"newdeviewname", (Object)PSUWCreateDEItemBase.getJSONValue((Object)pSUWCreateDEItemBase.getNewDEViewName()), (boolean)false);
        }
        if (bl || pSUWCreateDEItemBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSUWCreateDEItemBase.getJSONValue((Object)pSUWCreateDEItemBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSUWCreateDEItemBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSUWCreateDEItemBase.getJSONValue((Object)pSUWCreateDEItemBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSUWCreateDEItemBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSUWCreateDEItemBase.getJSONValue((Object)pSUWCreateDEItemBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSUWCreateDEItemBase.getPSUWCreateDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuwcreatedeid", (Object)PSUWCreateDEItemBase.getJSONValue((Object)pSUWCreateDEItemBase.getPSUWCreateDEId()), (boolean)false);
        }
        if (bl || pSUWCreateDEItemBase.getPSUWCreateDEItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuwcreatedeitemid", (Object)PSUWCreateDEItemBase.getJSONValue((Object)pSUWCreateDEItemBase.getPSUWCreateDEItemId()), (boolean)false);
        }
        if (bl || pSUWCreateDEItemBase.getPSUWCreateDEItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuwcreatedeitemname", (Object)PSUWCreateDEItemBase.getJSONValue((Object)pSUWCreateDEItemBase.getPSUWCreateDEItemName()), (boolean)false);
        }
        if (bl || pSUWCreateDEItemBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSUWCreateDEItemBase.getJSONValue((Object)pSUWCreateDEItemBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSUWCreateDEItemBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSUWCreateDEItemBase.getJSONValue((Object)pSUWCreateDEItemBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSUWCreateDEItemBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSUWCreateDEItemBase pSUWCreateDEItemBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSUWCreateDEItemBase.getCodeName() != null) {
            object = pSUWCreateDEItemBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEItemBase.getCreateDate() != null) {
            object = pSUWCreateDEItemBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUWCreateDEItemBase.getCreateMan() != null) {
            object = pSUWCreateDEItemBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEItemBase.getItemParam() != null) {
            object = pSUWCreateDEItemBase.getItemParam();
            xmlNode.setAttribute(FIELD_ITEMPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEItemBase.getItemParam2() != null) {
            object = pSUWCreateDEItemBase.getItemParam2();
            xmlNode.setAttribute(FIELD_ITEMPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEItemBase.getItemParam3() != null) {
            object = pSUWCreateDEItemBase.getItemParam3();
            xmlNode.setAttribute(FIELD_ITEMPARAM3, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWCreateDEItemBase.getItemParam4() != null) {
            object = pSUWCreateDEItemBase.getItemParam4();
            xmlNode.setAttribute(FIELD_ITEMPARAM4, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWCreateDEItemBase.getNewCodeName() != null) {
            object = pSUWCreateDEItemBase.getNewCodeName();
            xmlNode.setAttribute(FIELD_NEWCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEItemBase.getNewDELogicName() != null) {
            object = pSUWCreateDEItemBase.getNewDELogicName();
            xmlNode.setAttribute(FIELD_NEWDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEItemBase.getNewDEName() != null) {
            object = pSUWCreateDEItemBase.getNewDEName();
            xmlNode.setAttribute(FIELD_NEWDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEItemBase.getNewDETableName() != null) {
            object = pSUWCreateDEItemBase.getNewDETableName();
            xmlNode.setAttribute(FIELD_NEWDETABLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEItemBase.getNewDEViewName() != null) {
            object = pSUWCreateDEItemBase.getNewDEViewName();
            xmlNode.setAttribute(FIELD_NEWDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEItemBase.getPSDEId() != null) {
            object = pSUWCreateDEItemBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEItemBase.getPSDEName() != null) {
            object = pSUWCreateDEItemBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEItemBase.getPSDynaInstId() != null) {
            object = pSUWCreateDEItemBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEItemBase.getPSUWCreateDEId() != null) {
            object = pSUWCreateDEItemBase.getPSUWCreateDEId();
            xmlNode.setAttribute(FIELD_PSUWCREATEDEID, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEItemBase.getPSUWCreateDEItemId() != null) {
            object = pSUWCreateDEItemBase.getPSUWCreateDEItemId();
            xmlNode.setAttribute(FIELD_PSUWCREATEDEITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEItemBase.getPSUWCreateDEItemName() != null) {
            object = pSUWCreateDEItemBase.getPSUWCreateDEItemName();
            xmlNode.setAttribute(FIELD_PSUWCREATEDEITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEItemBase.getUpdateDate() != null) {
            object = pSUWCreateDEItemBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUWCreateDEItemBase.getUpdateMan() != null) {
            object = pSUWCreateDEItemBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSUWCreateDEItemBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSUWCreateDEItemBase pSUWCreateDEItemBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSUWCreateDEItemBase.isCodeNameDirty() && (bl || pSUWCreateDEItemBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSUWCreateDEItemBase.getCodeName());
        }
        if (pSUWCreateDEItemBase.isCreateDateDirty() && (bl || pSUWCreateDEItemBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSUWCreateDEItemBase.getCreateDate());
        }
        if (pSUWCreateDEItemBase.isCreateManDirty() && (bl || pSUWCreateDEItemBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSUWCreateDEItemBase.getCreateMan());
        }
        if (pSUWCreateDEItemBase.isItemParamDirty() && (bl || pSUWCreateDEItemBase.getItemParam() != null)) {
            iDataObject.set(FIELD_ITEMPARAM, (Object)pSUWCreateDEItemBase.getItemParam());
        }
        if (pSUWCreateDEItemBase.isItemParam2Dirty() && (bl || pSUWCreateDEItemBase.getItemParam2() != null)) {
            iDataObject.set(FIELD_ITEMPARAM2, (Object)pSUWCreateDEItemBase.getItemParam2());
        }
        if (pSUWCreateDEItemBase.isItemParam3Dirty() && (bl || pSUWCreateDEItemBase.getItemParam3() != null)) {
            iDataObject.set(FIELD_ITEMPARAM3, (Object)pSUWCreateDEItemBase.getItemParam3());
        }
        if (pSUWCreateDEItemBase.isItemParam4Dirty() && (bl || pSUWCreateDEItemBase.getItemParam4() != null)) {
            iDataObject.set(FIELD_ITEMPARAM4, (Object)pSUWCreateDEItemBase.getItemParam4());
        }
        if (pSUWCreateDEItemBase.isNewCodeNameDirty() && (bl || pSUWCreateDEItemBase.getNewCodeName() != null)) {
            iDataObject.set(FIELD_NEWCODENAME, (Object)pSUWCreateDEItemBase.getNewCodeName());
        }
        if (pSUWCreateDEItemBase.isNewDELogicNameDirty() && (bl || pSUWCreateDEItemBase.getNewDELogicName() != null)) {
            iDataObject.set(FIELD_NEWDELOGICNAME, (Object)pSUWCreateDEItemBase.getNewDELogicName());
        }
        if (pSUWCreateDEItemBase.isNewDENameDirty() && (bl || pSUWCreateDEItemBase.getNewDEName() != null)) {
            iDataObject.set(FIELD_NEWDENAME, (Object)pSUWCreateDEItemBase.getNewDEName());
        }
        if (pSUWCreateDEItemBase.isNewDETableNameDirty() && (bl || pSUWCreateDEItemBase.getNewDETableName() != null)) {
            iDataObject.set(FIELD_NEWDETABLENAME, (Object)pSUWCreateDEItemBase.getNewDETableName());
        }
        if (pSUWCreateDEItemBase.isNewDEViewNameDirty() && (bl || pSUWCreateDEItemBase.getNewDEViewName() != null)) {
            iDataObject.set(FIELD_NEWDEVIEWNAME, (Object)pSUWCreateDEItemBase.getNewDEViewName());
        }
        if (pSUWCreateDEItemBase.isPSDEIdDirty() && (bl || pSUWCreateDEItemBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSUWCreateDEItemBase.getPSDEId());
        }
        if (pSUWCreateDEItemBase.isPSDENameDirty() && (bl || pSUWCreateDEItemBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSUWCreateDEItemBase.getPSDEName());
        }
        if (pSUWCreateDEItemBase.isPSDynaInstIdDirty() && (bl || pSUWCreateDEItemBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSUWCreateDEItemBase.getPSDynaInstId());
        }
        if (pSUWCreateDEItemBase.isPSUWCreateDEIdDirty() && (bl || pSUWCreateDEItemBase.getPSUWCreateDEId() != null)) {
            iDataObject.set(FIELD_PSUWCREATEDEID, (Object)pSUWCreateDEItemBase.getPSUWCreateDEId());
        }
        if (pSUWCreateDEItemBase.isPSUWCreateDEItemIdDirty() && (bl || pSUWCreateDEItemBase.getPSUWCreateDEItemId() != null)) {
            iDataObject.set(FIELD_PSUWCREATEDEITEMID, (Object)pSUWCreateDEItemBase.getPSUWCreateDEItemId());
        }
        if (pSUWCreateDEItemBase.isPSUWCreateDEItemNameDirty() && (bl || pSUWCreateDEItemBase.getPSUWCreateDEItemName() != null)) {
            iDataObject.set(FIELD_PSUWCREATEDEITEMNAME, (Object)pSUWCreateDEItemBase.getPSUWCreateDEItemName());
        }
        if (pSUWCreateDEItemBase.isUpdateDateDirty() && (bl || pSUWCreateDEItemBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSUWCreateDEItemBase.getUpdateDate());
        }
        if (pSUWCreateDEItemBase.isUpdateManDirty() && (bl || pSUWCreateDEItemBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSUWCreateDEItemBase.getUpdateMan());
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
        return PSUWCreateDEItemBase.remove(this, n);
    }

    private static boolean remove(PSUWCreateDEItemBase pSUWCreateDEItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSUWCreateDEItemBase.resetCodeName();
                return true;
            }
            case 1: {
                pSUWCreateDEItemBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSUWCreateDEItemBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSUWCreateDEItemBase.resetItemParam();
                return true;
            }
            case 4: {
                pSUWCreateDEItemBase.resetItemParam2();
                return true;
            }
            case 5: {
                pSUWCreateDEItemBase.resetItemParam3();
                return true;
            }
            case 6: {
                pSUWCreateDEItemBase.resetItemParam4();
                return true;
            }
            case 7: {
                pSUWCreateDEItemBase.resetNewCodeName();
                return true;
            }
            case 8: {
                pSUWCreateDEItemBase.resetNewDELogicName();
                return true;
            }
            case 9: {
                pSUWCreateDEItemBase.resetNewDEName();
                return true;
            }
            case 10: {
                pSUWCreateDEItemBase.resetNewDETableName();
                return true;
            }
            case 11: {
                pSUWCreateDEItemBase.resetNewDEViewName();
                return true;
            }
            case 12: {
                pSUWCreateDEItemBase.resetPSDEId();
                return true;
            }
            case 13: {
                pSUWCreateDEItemBase.resetPSDEName();
                return true;
            }
            case 14: {
                pSUWCreateDEItemBase.resetPSDynaInstId();
                return true;
            }
            case 15: {
                pSUWCreateDEItemBase.resetPSUWCreateDEId();
                return true;
            }
            case 16: {
                pSUWCreateDEItemBase.resetPSUWCreateDEItemId();
                return true;
            }
            case 17: {
                pSUWCreateDEItemBase.resetPSUWCreateDEItemName();
                return true;
            }
            case 18: {
                pSUWCreateDEItemBase.resetUpdateDate();
                return true;
            }
            case 19: {
                pSUWCreateDEItemBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSUWCreateDE getPSUWCreateDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUWCreateDE();
        }
        if (this.getPSUWCreateDEId() == null) {
            return null;
        }
        Integer n = this.objPSUWCreateDELock;
        synchronized (n) {
            if (this.psuwcreatede != null && DataTypeHelper.compare((int)25, (Object)this.getPSUWCreateDEId(), (Object)this.psuwcreatede.getPSUWCreateDEId()) != 0L) {
                this.psuwcreatede = null;
            }
            if (this.psuwcreatede == null) {
                PSUWCreateDE pSUWCreateDE = new PSUWCreateDE();
                pSUWCreateDE.setPSUWCreateDEId(this.getPSUWCreateDEId());
                PSUWCreateDEService pSUWCreateDEService = (PSUWCreateDEService)ServiceGlobal.getService(PSUWCreateDEService.class, (SessionFactory)this.getSessionFactory());
                pSUWCreateDEService.autoGet((IEntity)pSUWCreateDE);
                this.psuwcreatede = pSUWCreateDE;
            }
            return this.psuwcreatede;
        }
    }

    private PSUWCreateDEItemBase getProxyEntity() {
        return this.proxyPSUWCreateDEItemBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSUWCreateDEItemBase = null;
        if (iDataObject != null && iDataObject instanceof PSUWCreateDEItemBase) {
            this.proxyPSUWCreateDEItemBase = (PSUWCreateDEItemBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSUWCreateDEItemService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_ITEMPARAM, 3);
        fieldIndexMap.put(FIELD_ITEMPARAM2, 4);
        fieldIndexMap.put(FIELD_ITEMPARAM3, 5);
        fieldIndexMap.put(FIELD_ITEMPARAM4, 6);
        fieldIndexMap.put(FIELD_NEWCODENAME, 7);
        fieldIndexMap.put(FIELD_NEWDELOGICNAME, 8);
        fieldIndexMap.put(FIELD_NEWDENAME, 9);
        fieldIndexMap.put(FIELD_NEWDETABLENAME, 10);
        fieldIndexMap.put(FIELD_NEWDEVIEWNAME, 11);
        fieldIndexMap.put(FIELD_PSDEID, 12);
        fieldIndexMap.put(FIELD_PSDENAME, 13);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 14);
        fieldIndexMap.put(FIELD_PSUWCREATEDEID, 15);
        fieldIndexMap.put(FIELD_PSUWCREATEDEITEMID, 16);
        fieldIndexMap.put(FIELD_PSUWCREATEDEITEMNAME, 17);
        fieldIndexMap.put(FIELD_UPDATEDATE, 18);
        fieldIndexMap.put(FIELD_UPDATEMAN, 19);
    }
}

