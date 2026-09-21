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
import net.ibizsys.psrt.srv.common.entity.UserDict;
import net.ibizsys.psrt.srv.common.entity.UserDictCat;
import net.ibizsys.psrt.srv.common.service.UserDictCatService;
import net.ibizsys.psrt.srv.common.service.UserDictService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class UserDictItemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(UserDictItemBase.class);
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MARKFLAG = "MARKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_RESERVER = "RESERVER";
    public static final String FIELD_RESERVER2 = "RESERVER2";
    public static final String FIELD_RESERVER3 = "RESERVER3";
    public static final String FIELD_RESERVER4 = "RESERVER4";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERDICTCATID = "USERDICTCATID";
    public static final String FIELD_USERDICTCATNAME = "USERDICTCATNAME";
    public static final String FIELD_USERDICTID = "USERDICTID";
    public static final String FIELD_USERDICTITEMID = "USERDICTITEMID";
    public static final String FIELD_USERDICTITEMNAME = "USERDICTITEMNAME";
    public static final String FIELD_USERDICTNAME = "USERDICTNAME";
    private static final int INDEX_CONTENT = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MARKFLAG = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_RESERVER = 5;
    private static final int INDEX_RESERVER2 = 6;
    private static final int INDEX_RESERVER3 = 7;
    private static final int INDEX_RESERVER4 = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final int INDEX_USERDICTCATID = 11;
    private static final int INDEX_USERDICTCATNAME = 12;
    private static final int INDEX_USERDICTID = 13;
    private static final int INDEX_USERDICTITEMID = 14;
    private static final int INDEX_USERDICTITEMNAME = 15;
    private static final int INDEX_USERDICTNAME = 16;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private UserDictItemBase proxyUserDictItemBase = null;
    private boolean contentDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean markflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean reserver3DirtyFlag = false;
    private boolean reserver4DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userdictcatidDirtyFlag = false;
    private boolean userdictcatnameDirtyFlag = false;
    private boolean userdictidDirtyFlag = false;
    private boolean userdictitemidDirtyFlag = false;
    private boolean userdictitemnameDirtyFlag = false;
    private boolean userdictnameDirtyFlag = false;
    @Column(name="content")
    private String content;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="markflag")
    private Integer markflag;
    @Column(name="memo")
    private String memo;
    @Column(name="reserver")
    private String reserver;
    @Column(name="reserver2")
    private String reserver2;
    @Column(name="reserver3")
    private String reserver3;
    @Column(name="reserver4")
    private String reserver4;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userdictcatid")
    private String userdictcatid;
    @Column(name="userdictcatname")
    private String userdictcatname;
    @Column(name="userdictid")
    private String userdictid;
    @Column(name="userdictitemid")
    private String userdictitemid;
    @Column(name="userdictitemname")
    private String userdictitemname;
    @Column(name="userdictname")
    private String userdictname;
    private Integer objUserDictCatLock = new Integer(1);
    private UserDictCat userdictcat = null;
    private Integer objUserDictLock = new Integer(1);
    private UserDict userdict = null;

    static {
        fieldIndexMap.put(FIELD_CONTENT, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MARKFLAG, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_RESERVER, 5);
        fieldIndexMap.put(FIELD_RESERVER2, 6);
        fieldIndexMap.put(FIELD_RESERVER3, 7);
        fieldIndexMap.put(FIELD_RESERVER4, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
        fieldIndexMap.put(FIELD_USERDICTCATID, 11);
        fieldIndexMap.put(FIELD_USERDICTCATNAME, 12);
        fieldIndexMap.put(FIELD_USERDICTID, 13);
        fieldIndexMap.put(FIELD_USERDICTITEMID, 14);
        fieldIndexMap.put(FIELD_USERDICTITEMNAME, 15);
        fieldIndexMap.put(FIELD_USERDICTNAME, 16);
    }

    public void setContent(String content) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContent(content);
            return;
        }
        if (content != null && (content = StringHelper.trimRight(content)).length() == 0) {
            content = null;
        }
        this.content = content;
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

    public void setMarkFlag(Integer markflag) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMarkFlag(markflag);
            return;
        }
        this.markflag = markflag;
        this.markflagDirtyFlag = true;
    }

    public Integer getMarkFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMarkFlag();
        }
        return this.markflag;
    }

    public boolean isMarkFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMarkFlagDirty();
        }
        return this.markflagDirtyFlag;
    }

    public void resetMarkFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMarkFlag();
            return;
        }
        this.markflagDirtyFlag = false;
        this.markflag = null;
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

    public void setReserver3(String reserver3) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver3(reserver3);
            return;
        }
        if (reserver3 != null && (reserver3 = StringHelper.trimRight(reserver3)).length() == 0) {
            reserver3 = null;
        }
        this.reserver3 = reserver3;
        this.reserver3DirtyFlag = true;
    }

    public String getReserver3() {
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

    public void setReserver4(String reserver4) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver4(reserver4);
            return;
        }
        if (reserver4 != null && (reserver4 = StringHelper.trimRight(reserver4)).length() == 0) {
            reserver4 = null;
        }
        this.reserver4 = reserver4;
        this.reserver4DirtyFlag = true;
    }

    public String getReserver4() {
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

    public void setUserDictCatId(String userdictcatid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserDictCatId(userdictcatid);
            return;
        }
        if (userdictcatid != null && (userdictcatid = StringHelper.trimRight(userdictcatid)).length() == 0) {
            userdictcatid = null;
        }
        this.userdictcatid = userdictcatid;
        this.userdictcatidDirtyFlag = true;
    }

    public String getUserDictCatId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserDictCatId();
        }
        return this.userdictcatid;
    }

    public boolean isUserDictCatIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDictCatIdDirty();
        }
        return this.userdictcatidDirtyFlag;
    }

    public void resetUserDictCatId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserDictCatId();
            return;
        }
        this.userdictcatidDirtyFlag = false;
        this.userdictcatid = null;
    }

    public void setUserDictCatName(String userdictcatname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserDictCatName(userdictcatname);
            return;
        }
        if (userdictcatname != null && (userdictcatname = StringHelper.trimRight(userdictcatname)).length() == 0) {
            userdictcatname = null;
        }
        this.userdictcatname = userdictcatname;
        this.userdictcatnameDirtyFlag = true;
    }

    public String getUserDictCatName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserDictCatName();
        }
        return this.userdictcatname;
    }

    public boolean isUserDictCatNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDictCatNameDirty();
        }
        return this.userdictcatnameDirtyFlag;
    }

    public void resetUserDictCatName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserDictCatName();
            return;
        }
        this.userdictcatnameDirtyFlag = false;
        this.userdictcatname = null;
    }

    public void setUserDictId(String userdictid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserDictId(userdictid);
            return;
        }
        if (userdictid != null && (userdictid = StringHelper.trimRight(userdictid)).length() == 0) {
            userdictid = null;
        }
        this.userdictid = userdictid;
        this.userdictidDirtyFlag = true;
    }

    public String getUserDictId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserDictId();
        }
        return this.userdictid;
    }

    public boolean isUserDictIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDictIdDirty();
        }
        return this.userdictidDirtyFlag;
    }

    public void resetUserDictId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserDictId();
            return;
        }
        this.userdictidDirtyFlag = false;
        this.userdictid = null;
    }

    public void setUserDictItemId(String userdictitemid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserDictItemId(userdictitemid);
            return;
        }
        if (userdictitemid != null && (userdictitemid = StringHelper.trimRight(userdictitemid)).length() == 0) {
            userdictitemid = null;
        }
        this.userdictitemid = userdictitemid;
        this.userdictitemidDirtyFlag = true;
    }

    public String getUserDictItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserDictItemId();
        }
        return this.userdictitemid;
    }

    public boolean isUserDictItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDictItemIdDirty();
        }
        return this.userdictitemidDirtyFlag;
    }

    public void resetUserDictItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserDictItemId();
            return;
        }
        this.userdictitemidDirtyFlag = false;
        this.userdictitemid = null;
    }

    public void setUserDictItemName(String userdictitemname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserDictItemName(userdictitemname);
            return;
        }
        if (userdictitemname != null && (userdictitemname = StringHelper.trimRight(userdictitemname)).length() == 0) {
            userdictitemname = null;
        }
        this.userdictitemname = userdictitemname;
        this.userdictitemnameDirtyFlag = true;
    }

    public String getUserDictItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserDictItemName();
        }
        return this.userdictitemname;
    }

    public boolean isUserDictItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDictItemNameDirty();
        }
        return this.userdictitemnameDirtyFlag;
    }

    public void resetUserDictItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserDictItemName();
            return;
        }
        this.userdictitemnameDirtyFlag = false;
        this.userdictitemname = null;
    }

    public void setUserDictName(String userdictname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserDictName(userdictname);
            return;
        }
        if (userdictname != null && (userdictname = StringHelper.trimRight(userdictname)).length() == 0) {
            userdictname = null;
        }
        this.userdictname = userdictname;
        this.userdictnameDirtyFlag = true;
    }

    public String getUserDictName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserDictName();
        }
        return this.userdictname;
    }

    public boolean isUserDictNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDictNameDirty();
        }
        return this.userdictnameDirtyFlag;
    }

    public void resetUserDictName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserDictName();
            return;
        }
        this.userdictnameDirtyFlag = false;
        this.userdictname = null;
    }

    @Override
    protected void onReset() {
        UserDictItemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(UserDictItemBase et) {
        et.resetContent();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetMarkFlag();
        et.resetMemo();
        et.resetReserver();
        et.resetReserver2();
        et.resetReserver3();
        et.resetReserver4();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetUserDictCatId();
        et.resetUserDictCatName();
        et.resetUserDictId();
        et.resetUserDictItemId();
        et.resetUserDictItemName();
        et.resetUserDictName();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isContentDirty()) {
            params.put(FIELD_CONTENT, this.getContent());
        }
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isMarkFlagDirty()) {
            params.put(FIELD_MARKFLAG, this.getMarkFlag());
        }
        if (!bDirtyOnly || this.isMemoDirty()) {
            params.put(FIELD_MEMO, this.getMemo());
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
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isUserDictCatIdDirty()) {
            params.put(FIELD_USERDICTCATID, this.getUserDictCatId());
        }
        if (!bDirtyOnly || this.isUserDictCatNameDirty()) {
            params.put(FIELD_USERDICTCATNAME, this.getUserDictCatName());
        }
        if (!bDirtyOnly || this.isUserDictIdDirty()) {
            params.put(FIELD_USERDICTID, this.getUserDictId());
        }
        if (!bDirtyOnly || this.isUserDictItemIdDirty()) {
            params.put(FIELD_USERDICTITEMID, this.getUserDictItemId());
        }
        if (!bDirtyOnly || this.isUserDictItemNameDirty()) {
            params.put(FIELD_USERDICTITEMNAME, this.getUserDictItemName());
        }
        if (!bDirtyOnly || this.isUserDictNameDirty()) {
            params.put(FIELD_USERDICTNAME, this.getUserDictName());
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
        return UserDictItemBase.get(this, index);
    }

    private static Object get(UserDictItemBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getContent();
            }
            case 1: {
                return et.getCreateDate();
            }
            case 2: {
                return et.getCreateMan();
            }
            case 3: {
                return et.getMarkFlag();
            }
            case 4: {
                return et.getMemo();
            }
            case 5: {
                return et.getReserver();
            }
            case 6: {
                return et.getReserver2();
            }
            case 7: {
                return et.getReserver3();
            }
            case 8: {
                return et.getReserver4();
            }
            case 9: {
                return et.getUpdateDate();
            }
            case 10: {
                return et.getUpdateMan();
            }
            case 11: {
                return et.getUserDictCatId();
            }
            case 12: {
                return et.getUserDictCatName();
            }
            case 13: {
                return et.getUserDictId();
            }
            case 14: {
                return et.getUserDictItemId();
            }
            case 15: {
                return et.getUserDictItemName();
            }
            case 16: {
                return et.getUserDictName();
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
        UserDictItemBase.set(this, index, objValue);
    }

    private static void set(UserDictItemBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setContent(DataObject.getStringValue(obj));
                return;
            }
            case 1: {
                et.setCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 2: {
                et.setCreateMan(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setMarkFlag(DataObject.getIntegerValue(obj));
                return;
            }
            case 4: {
                et.setMemo(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setReserver(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setReserver2(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setReserver3(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setReserver4(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 10: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setUserDictCatId(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setUserDictCatName(DataObject.getStringValue(obj));
                return;
            }
            case 13: {
                et.setUserDictId(DataObject.getStringValue(obj));
                return;
            }
            case 14: {
                et.setUserDictItemId(DataObject.getStringValue(obj));
                return;
            }
            case 15: {
                et.setUserDictItemName(DataObject.getStringValue(obj));
                return;
            }
            case 16: {
                et.setUserDictName(DataObject.getStringValue(obj));
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
        return UserDictItemBase.isNull(this, index);
    }

    private static boolean isNull(UserDictItemBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getContent() == null;
            }
            case 1: {
                return et.getCreateDate() == null;
            }
            case 2: {
                return et.getCreateMan() == null;
            }
            case 3: {
                return et.getMarkFlag() == null;
            }
            case 4: {
                return et.getMemo() == null;
            }
            case 5: {
                return et.getReserver() == null;
            }
            case 6: {
                return et.getReserver2() == null;
            }
            case 7: {
                return et.getReserver3() == null;
            }
            case 8: {
                return et.getReserver4() == null;
            }
            case 9: {
                return et.getUpdateDate() == null;
            }
            case 10: {
                return et.getUpdateMan() == null;
            }
            case 11: {
                return et.getUserDictCatId() == null;
            }
            case 12: {
                return et.getUserDictCatName() == null;
            }
            case 13: {
                return et.getUserDictId() == null;
            }
            case 14: {
                return et.getUserDictItemId() == null;
            }
            case 15: {
                return et.getUserDictItemName() == null;
            }
            case 16: {
                return et.getUserDictName() == null;
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
        return UserDictItemBase.contains(this, index);
    }

    private static boolean contains(UserDictItemBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isContentDirty();
            }
            case 1: {
                return et.isCreateDateDirty();
            }
            case 2: {
                return et.isCreateManDirty();
            }
            case 3: {
                return et.isMarkFlagDirty();
            }
            case 4: {
                return et.isMemoDirty();
            }
            case 5: {
                return et.isReserverDirty();
            }
            case 6: {
                return et.isReserver2Dirty();
            }
            case 7: {
                return et.isReserver3Dirty();
            }
            case 8: {
                return et.isReserver4Dirty();
            }
            case 9: {
                return et.isUpdateDateDirty();
            }
            case 10: {
                return et.isUpdateManDirty();
            }
            case 11: {
                return et.isUserDictCatIdDirty();
            }
            case 12: {
                return et.isUserDictCatNameDirty();
            }
            case 13: {
                return et.isUserDictIdDirty();
            }
            case 14: {
                return et.isUserDictItemIdDirty();
            }
            case 15: {
                return et.isUserDictItemNameDirty();
            }
            case 16: {
                return et.isUserDictNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        UserDictItemBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(UserDictItemBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getContent() != null) {
            JSONObjectHelper.put(json, "content", UserDictItemBase.getJSONValue(et.getContent()), false);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", UserDictItemBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", UserDictItemBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getMarkFlag() != null) {
            JSONObjectHelper.put(json, "markflag", UserDictItemBase.getJSONValue(et.getMarkFlag()), false);
        }
        if (bIncEmpty || et.getMemo() != null) {
            JSONObjectHelper.put(json, "memo", UserDictItemBase.getJSONValue(et.getMemo()), false);
        }
        if (bIncEmpty || et.getReserver() != null) {
            JSONObjectHelper.put(json, "reserver", UserDictItemBase.getJSONValue(et.getReserver()), false);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            JSONObjectHelper.put(json, "reserver2", UserDictItemBase.getJSONValue(et.getReserver2()), false);
        }
        if (bIncEmpty || et.getReserver3() != null) {
            JSONObjectHelper.put(json, "reserver3", UserDictItemBase.getJSONValue(et.getReserver3()), false);
        }
        if (bIncEmpty || et.getReserver4() != null) {
            JSONObjectHelper.put(json, "reserver4", UserDictItemBase.getJSONValue(et.getReserver4()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", UserDictItemBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", UserDictItemBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getUserDictCatId() != null) {
            JSONObjectHelper.put(json, "userdictcatid", UserDictItemBase.getJSONValue(et.getUserDictCatId()), false);
        }
        if (bIncEmpty || et.getUserDictCatName() != null) {
            JSONObjectHelper.put(json, "userdictcatname", UserDictItemBase.getJSONValue(et.getUserDictCatName()), false);
        }
        if (bIncEmpty || et.getUserDictId() != null) {
            JSONObjectHelper.put(json, "userdictid", UserDictItemBase.getJSONValue(et.getUserDictId()), false);
        }
        if (bIncEmpty || et.getUserDictItemId() != null) {
            JSONObjectHelper.put(json, "userdictitemid", UserDictItemBase.getJSONValue(et.getUserDictItemId()), false);
        }
        if (bIncEmpty || et.getUserDictItemName() != null) {
            JSONObjectHelper.put(json, "userdictitemname", UserDictItemBase.getJSONValue(et.getUserDictItemName()), false);
        }
        if (bIncEmpty || et.getUserDictName() != null) {
            JSONObjectHelper.put(json, "userdictname", UserDictItemBase.getJSONValue(et.getUserDictName()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        UserDictItemBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(UserDictItemBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getContent() != null) {
            obj = et.getContent();
            node.setAttribute(FIELD_CONTENT, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMarkFlag() != null) {
            obj = et.getMarkFlag();
            node.setAttribute(FIELD_MARKFLAG, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getMemo() != null) {
            obj = et.getMemo();
            node.setAttribute(FIELD_MEMO, obj == null ? "" : (String)obj);
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
            node.setAttribute(FIELD_RESERVER3, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver4() != null) {
            obj = et.getReserver4();
            node.setAttribute(FIELD_RESERVER4, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserDictCatId() != null) {
            obj = et.getUserDictCatId();
            node.setAttribute(FIELD_USERDICTCATID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserDictCatName() != null) {
            obj = et.getUserDictCatName();
            node.setAttribute(FIELD_USERDICTCATNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserDictId() != null) {
            obj = et.getUserDictId();
            node.setAttribute(FIELD_USERDICTID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserDictItemId() != null) {
            obj = et.getUserDictItemId();
            node.setAttribute(FIELD_USERDICTITEMID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserDictItemName() != null) {
            obj = et.getUserDictItemName();
            node.setAttribute(FIELD_USERDICTITEMNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserDictName() != null) {
            obj = et.getUserDictName();
            node.setAttribute(FIELD_USERDICTNAME, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        UserDictItemBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(UserDictItemBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isContentDirty() && (bIncEmpty || et.getContent() != null)) {
            dst.set(FIELD_CONTENT, et.getContent());
        }
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isMarkFlagDirty() && (bIncEmpty || et.getMarkFlag() != null)) {
            dst.set(FIELD_MARKFLAG, et.getMarkFlag());
        }
        if (et.isMemoDirty() && (bIncEmpty || et.getMemo() != null)) {
            dst.set(FIELD_MEMO, et.getMemo());
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
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isUserDictCatIdDirty() && (bIncEmpty || et.getUserDictCatId() != null)) {
            dst.set(FIELD_USERDICTCATID, et.getUserDictCatId());
        }
        if (et.isUserDictCatNameDirty() && (bIncEmpty || et.getUserDictCatName() != null)) {
            dst.set(FIELD_USERDICTCATNAME, et.getUserDictCatName());
        }
        if (et.isUserDictIdDirty() && (bIncEmpty || et.getUserDictId() != null)) {
            dst.set(FIELD_USERDICTID, et.getUserDictId());
        }
        if (et.isUserDictItemIdDirty() && (bIncEmpty || et.getUserDictItemId() != null)) {
            dst.set(FIELD_USERDICTITEMID, et.getUserDictItemId());
        }
        if (et.isUserDictItemNameDirty() && (bIncEmpty || et.getUserDictItemName() != null)) {
            dst.set(FIELD_USERDICTITEMNAME, et.getUserDictItemName());
        }
        if (et.isUserDictNameDirty() && (bIncEmpty || et.getUserDictName() != null)) {
            dst.set(FIELD_USERDICTNAME, et.getUserDictName());
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
        return UserDictItemBase.remove(this, index);
    }

    private static boolean remove(UserDictItemBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetContent();
                return true;
            }
            case 1: {
                et.resetCreateDate();
                return true;
            }
            case 2: {
                et.resetCreateMan();
                return true;
            }
            case 3: {
                et.resetMarkFlag();
                return true;
            }
            case 4: {
                et.resetMemo();
                return true;
            }
            case 5: {
                et.resetReserver();
                return true;
            }
            case 6: {
                et.resetReserver2();
                return true;
            }
            case 7: {
                et.resetReserver3();
                return true;
            }
            case 8: {
                et.resetReserver4();
                return true;
            }
            case 9: {
                et.resetUpdateDate();
                return true;
            }
            case 10: {
                et.resetUpdateMan();
                return true;
            }
            case 11: {
                et.resetUserDictCatId();
                return true;
            }
            case 12: {
                et.resetUserDictCatName();
                return true;
            }
            case 13: {
                et.resetUserDictId();
                return true;
            }
            case 14: {
                et.resetUserDictItemId();
                return true;
            }
            case 15: {
                et.resetUserDictItemName();
                return true;
            }
            case 16: {
                et.resetUserDictName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public UserDictCat getUserDictCat() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserDictCat();
        }
        if (this.getUserDictCatId() == null) {
            return null;
        }
        Integer n = this.objUserDictCatLock;
        synchronized (n) {
            if (this.userdictcat != null && DataTypeHelper.compare(25, (Object)this.getUserDictCatId(), (Object)this.userdictcat.getUserDictCatId()) != 0L) {
                this.userdictcat = null;
            }
            if (this.userdictcat == null) {
                UserDictCat userdictcat = new UserDictCat();
                userdictcat.setUserDictCatId(this.getUserDictCatId());
                UserDictCatService service = (UserDictCatService)ServiceGlobal.getService(UserDictCatService.class, this.getSessionFactory());
                service.autoGet(userdictcat);
                this.userdictcat = userdictcat;
            }
            return this.userdictcat;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public UserDict getUserDict() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserDict();
        }
        if (this.getUserDictId() == null) {
            return null;
        }
        Integer n = this.objUserDictLock;
        synchronized (n) {
            if (this.userdict != null && DataTypeHelper.compare(25, (Object)this.getUserDictId(), (Object)this.userdict.getUserDictId()) != 0L) {
                this.userdict = null;
            }
            if (this.userdict == null) {
                UserDict userdict = new UserDict();
                userdict.setUserDictId(this.getUserDictId());
                UserDictService service = (UserDictService)ServiceGlobal.getService(UserDictService.class, this.getSessionFactory());
                service.autoGet(userdict);
                this.userdict = userdict;
            }
            return this.userdict;
        }
    }

    private UserDictItemBase getProxyEntity() {
        return this.proxyUserDictItemBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyUserDictItemBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof UserDictItemBase) {
            this.proxyUserDictItemBase = (UserDictItemBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.UserDictItemService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

