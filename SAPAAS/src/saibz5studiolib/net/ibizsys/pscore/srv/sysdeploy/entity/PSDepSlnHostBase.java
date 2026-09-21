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
package net.ibizsys.pscore.srv.sysdeploy.entity;

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
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSln;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnHostBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDepSlnHostBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_IPADDR = "IPADDR";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEPSLNHOSTID = "PSDEPSLNHOSTID";
    public static final String FIELD_PSDEPSLNHOSTNAME = "PSDEPSLNHOSTNAME";
    public static final String FIELD_PSDEPSLNID = "PSDEPSLNID";
    public static final String FIELD_PSDEPSLNNAME = "PSDEPSLNNAME";
    public static final String FIELD_PWD = "PWD";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERNAME = "USERNAME";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_IPADDR = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSDEPSLNHOSTID = 4;
    private static final int INDEX_PSDEPSLNHOSTNAME = 5;
    private static final int INDEX_PSDEPSLNID = 6;
    private static final int INDEX_PSDEPSLNNAME = 7;
    private static final int INDEX_PWD = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final int INDEX_USERNAME = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDepSlnHostBase proxyPSDepSlnHostBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ipaddrDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdepslnhostidDirtyFlag = false;
    private boolean psdepslnhostnameDirtyFlag = false;
    private boolean psdepslnidDirtyFlag = false;
    private boolean psdepslnnameDirtyFlag = false;
    private boolean pwdDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usernameDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="ipaddr")
    private String ipaddr;
    @Column(name="memo")
    private String memo;
    @Column(name="psdepslnhostid")
    private String psdepslnhostid;
    @Column(name="psdepslnhostname")
    private String psdepslnhostname;
    @Column(name="psdepslnid")
    private String psdepslnid;
    @Column(name="psdepslnname")
    private String psdepslnname;
    @Column(name="pwd")
    private String pwd;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="username")
    private String username;
    private Integer objPSDepSlnLock = new Integer(1);
    private PSDepSln psdepsln = null;

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

    public void setIPAddr(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIPAddr(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ipaddr = string;
        this.ipaddrDirtyFlag = true;
    }

    public String getIPAddr() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIPAddr();
        }
        return this.ipaddr;
    }

    public boolean isIPAddrDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIPAddrDirty();
        }
        return this.ipaddrDirtyFlag;
    }

    public void resetIPAddr() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIPAddr();
            return;
        }
        this.ipaddrDirtyFlag = false;
        this.ipaddr = null;
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

    public void setPSDepSlnHostId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnHostId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnhostid = string;
        this.psdepslnhostidDirtyFlag = true;
    }

    public String getPSDepSlnHostId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnHostId();
        }
        return this.psdepslnhostid;
    }

    public boolean isPSDepSlnHostIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnHostIdDirty();
        }
        return this.psdepslnhostidDirtyFlag;
    }

    public void resetPSDepSlnHostId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnHostId();
            return;
        }
        this.psdepslnhostidDirtyFlag = false;
        this.psdepslnhostid = null;
    }

    public void setPSDepSlnHostName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnHostName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnhostname = string;
        this.psdepslnhostnameDirtyFlag = true;
    }

    public String getPSDepSlnHostName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnHostName();
        }
        return this.psdepslnhostname;
    }

    public boolean isPSDepSlnHostNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnHostNameDirty();
        }
        return this.psdepslnhostnameDirtyFlag;
    }

    public void resetPSDepSlnHostName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnHostName();
            return;
        }
        this.psdepslnhostnameDirtyFlag = false;
        this.psdepslnhostname = null;
    }

    public void setPSDepSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnid = string;
        this.psdepslnidDirtyFlag = true;
    }

    public String getPSDepSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnId();
        }
        return this.psdepslnid;
    }

    public boolean isPSDepSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnIdDirty();
        }
        return this.psdepslnidDirtyFlag;
    }

    public void resetPSDepSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnId();
            return;
        }
        this.psdepslnidDirtyFlag = false;
        this.psdepslnid = null;
    }

    public void setPSDepSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnname = string;
        this.psdepslnnameDirtyFlag = true;
    }

    public String getPSDepSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnName();
        }
        return this.psdepslnname;
    }

    public boolean isPSDepSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnNameDirty();
        }
        return this.psdepslnnameDirtyFlag;
    }

    public void resetPSDepSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnName();
            return;
        }
        this.psdepslnnameDirtyFlag = false;
        this.psdepslnname = null;
    }

    public void setPwd(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPwd(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pwd = string;
        this.pwdDirtyFlag = true;
    }

    public String getPwd() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPwd();
        }
        return this.pwd;
    }

    public boolean isPwdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPwdDirty();
        }
        return this.pwdDirtyFlag;
    }

    public void resetPwd() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPwd();
            return;
        }
        this.pwdDirtyFlag = false;
        this.pwd = null;
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

    public void setUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.username = string;
        this.usernameDirtyFlag = true;
    }

    public String getUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserName();
        }
        return this.username;
    }

    public boolean isUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserNameDirty();
        }
        return this.usernameDirtyFlag;
    }

    public void resetUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserName();
            return;
        }
        this.usernameDirtyFlag = false;
        this.username = null;
    }

    protected void onReset() {
        PSDepSlnHostBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDepSlnHostBase pSDepSlnHostBase) {
        pSDepSlnHostBase.resetCreateDate();
        pSDepSlnHostBase.resetCreateMan();
        pSDepSlnHostBase.resetIPAddr();
        pSDepSlnHostBase.resetMemo();
        pSDepSlnHostBase.resetPSDepSlnHostId();
        pSDepSlnHostBase.resetPSDepSlnHostName();
        pSDepSlnHostBase.resetPSDepSlnId();
        pSDepSlnHostBase.resetPSDepSlnName();
        pSDepSlnHostBase.resetPwd();
        pSDepSlnHostBase.resetUpdateDate();
        pSDepSlnHostBase.resetUpdateMan();
        pSDepSlnHostBase.resetUserName();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isIPAddrDirty()) {
            hashMap.put(FIELD_IPADDR, this.getIPAddr());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDepSlnHostIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNHOSTID, this.getPSDepSlnHostId());
        }
        if (!bl || this.isPSDepSlnHostNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNHOSTNAME, this.getPSDepSlnHostName());
        }
        if (!bl || this.isPSDepSlnIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNID, this.getPSDepSlnId());
        }
        if (!bl || this.isPSDepSlnNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNNAME, this.getPSDepSlnName());
        }
        if (!bl || this.isPwdDirty()) {
            hashMap.put(FIELD_PWD, this.getPwd());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserNameDirty()) {
            hashMap.put(FIELD_USERNAME, this.getUserName());
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
        return PSDepSlnHostBase.get(this, n);
    }

    private static Object get(PSDepSlnHostBase pSDepSlnHostBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnHostBase.getCreateDate();
            }
            case 1: {
                return pSDepSlnHostBase.getCreateMan();
            }
            case 2: {
                return pSDepSlnHostBase.getIPAddr();
            }
            case 3: {
                return pSDepSlnHostBase.getMemo();
            }
            case 4: {
                return pSDepSlnHostBase.getPSDepSlnHostId();
            }
            case 5: {
                return pSDepSlnHostBase.getPSDepSlnHostName();
            }
            case 6: {
                return pSDepSlnHostBase.getPSDepSlnId();
            }
            case 7: {
                return pSDepSlnHostBase.getPSDepSlnName();
            }
            case 8: {
                return pSDepSlnHostBase.getPwd();
            }
            case 9: {
                return pSDepSlnHostBase.getUpdateDate();
            }
            case 10: {
                return pSDepSlnHostBase.getUpdateMan();
            }
            case 11: {
                return pSDepSlnHostBase.getUserName();
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
        PSDepSlnHostBase.set(this, n, object);
    }

    private static void set(PSDepSlnHostBase pSDepSlnHostBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnHostBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDepSlnHostBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDepSlnHostBase.setIPAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDepSlnHostBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDepSlnHostBase.setPSDepSlnHostId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDepSlnHostBase.setPSDepSlnHostName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDepSlnHostBase.setPSDepSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDepSlnHostBase.setPSDepSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDepSlnHostBase.setPwd(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDepSlnHostBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSDepSlnHostBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDepSlnHostBase.setUserName(DataObject.getStringValue((Object)object));
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
        return PSDepSlnHostBase.isNull(this, n);
    }

    private static boolean isNull(PSDepSlnHostBase pSDepSlnHostBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnHostBase.getCreateDate() == null;
            }
            case 1: {
                return pSDepSlnHostBase.getCreateMan() == null;
            }
            case 2: {
                return pSDepSlnHostBase.getIPAddr() == null;
            }
            case 3: {
                return pSDepSlnHostBase.getMemo() == null;
            }
            case 4: {
                return pSDepSlnHostBase.getPSDepSlnHostId() == null;
            }
            case 5: {
                return pSDepSlnHostBase.getPSDepSlnHostName() == null;
            }
            case 6: {
                return pSDepSlnHostBase.getPSDepSlnId() == null;
            }
            case 7: {
                return pSDepSlnHostBase.getPSDepSlnName() == null;
            }
            case 8: {
                return pSDepSlnHostBase.getPwd() == null;
            }
            case 9: {
                return pSDepSlnHostBase.getUpdateDate() == null;
            }
            case 10: {
                return pSDepSlnHostBase.getUpdateMan() == null;
            }
            case 11: {
                return pSDepSlnHostBase.getUserName() == null;
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
        return PSDepSlnHostBase.contains(this, n);
    }

    private static boolean contains(PSDepSlnHostBase pSDepSlnHostBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnHostBase.isCreateDateDirty();
            }
            case 1: {
                return pSDepSlnHostBase.isCreateManDirty();
            }
            case 2: {
                return pSDepSlnHostBase.isIPAddrDirty();
            }
            case 3: {
                return pSDepSlnHostBase.isMemoDirty();
            }
            case 4: {
                return pSDepSlnHostBase.isPSDepSlnHostIdDirty();
            }
            case 5: {
                return pSDepSlnHostBase.isPSDepSlnHostNameDirty();
            }
            case 6: {
                return pSDepSlnHostBase.isPSDepSlnIdDirty();
            }
            case 7: {
                return pSDepSlnHostBase.isPSDepSlnNameDirty();
            }
            case 8: {
                return pSDepSlnHostBase.isPwdDirty();
            }
            case 9: {
                return pSDepSlnHostBase.isUpdateDateDirty();
            }
            case 10: {
                return pSDepSlnHostBase.isUpdateManDirty();
            }
            case 11: {
                return pSDepSlnHostBase.isUserNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDepSlnHostBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDepSlnHostBase pSDepSlnHostBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDepSlnHostBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDepSlnHostBase.getJSONValue((Object)pSDepSlnHostBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDepSlnHostBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDepSlnHostBase.getJSONValue((Object)pSDepSlnHostBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDepSlnHostBase.getIPAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr", (Object)PSDepSlnHostBase.getJSONValue((Object)pSDepSlnHostBase.getIPAddr()), (boolean)false);
        }
        if (bl || pSDepSlnHostBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDepSlnHostBase.getJSONValue((Object)pSDepSlnHostBase.getMemo()), (boolean)false);
        }
        if (bl || pSDepSlnHostBase.getPSDepSlnHostId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnhostid", (Object)PSDepSlnHostBase.getJSONValue((Object)pSDepSlnHostBase.getPSDepSlnHostId()), (boolean)false);
        }
        if (bl || pSDepSlnHostBase.getPSDepSlnHostName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnhostname", (Object)PSDepSlnHostBase.getJSONValue((Object)pSDepSlnHostBase.getPSDepSlnHostName()), (boolean)false);
        }
        if (bl || pSDepSlnHostBase.getPSDepSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnid", (Object)PSDepSlnHostBase.getJSONValue((Object)pSDepSlnHostBase.getPSDepSlnId()), (boolean)false);
        }
        if (bl || pSDepSlnHostBase.getPSDepSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnname", (Object)PSDepSlnHostBase.getJSONValue((Object)pSDepSlnHostBase.getPSDepSlnName()), (boolean)false);
        }
        if (bl || pSDepSlnHostBase.getPwd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pwd", (Object)PSDepSlnHostBase.getJSONValue((Object)pSDepSlnHostBase.getPwd()), (boolean)false);
        }
        if (bl || pSDepSlnHostBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDepSlnHostBase.getJSONValue((Object)pSDepSlnHostBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDepSlnHostBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDepSlnHostBase.getJSONValue((Object)pSDepSlnHostBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDepSlnHostBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSDepSlnHostBase.getJSONValue((Object)pSDepSlnHostBase.getUserName()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDepSlnHostBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDepSlnHostBase pSDepSlnHostBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDepSlnHostBase.getCreateDate() != null) {
            object = pSDepSlnHostBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnHostBase.getCreateMan() != null) {
            object = pSDepSlnHostBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnHostBase.getIPAddr() != null) {
            object = pSDepSlnHostBase.getIPAddr();
            xmlNode.setAttribute(FIELD_IPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnHostBase.getMemo() != null) {
            object = pSDepSlnHostBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnHostBase.getPSDepSlnHostId() != null) {
            object = pSDepSlnHostBase.getPSDepSlnHostId();
            xmlNode.setAttribute(FIELD_PSDEPSLNHOSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnHostBase.getPSDepSlnHostName() != null) {
            object = pSDepSlnHostBase.getPSDepSlnHostName();
            xmlNode.setAttribute(FIELD_PSDEPSLNHOSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnHostBase.getPSDepSlnId() != null) {
            object = pSDepSlnHostBase.getPSDepSlnId();
            xmlNode.setAttribute(FIELD_PSDEPSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnHostBase.getPSDepSlnName() != null) {
            object = pSDepSlnHostBase.getPSDepSlnName();
            xmlNode.setAttribute(FIELD_PSDEPSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnHostBase.getPwd() != null) {
            object = pSDepSlnHostBase.getPwd();
            xmlNode.setAttribute(FIELD_PWD, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnHostBase.getUpdateDate() != null) {
            object = pSDepSlnHostBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnHostBase.getUpdateMan() != null) {
            object = pSDepSlnHostBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnHostBase.getUserName() != null) {
            object = pSDepSlnHostBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDepSlnHostBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDepSlnHostBase pSDepSlnHostBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDepSlnHostBase.isCreateDateDirty() && (bl || pSDepSlnHostBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDepSlnHostBase.getCreateDate());
        }
        if (pSDepSlnHostBase.isCreateManDirty() && (bl || pSDepSlnHostBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDepSlnHostBase.getCreateMan());
        }
        if (pSDepSlnHostBase.isIPAddrDirty() && (bl || pSDepSlnHostBase.getIPAddr() != null)) {
            iDataObject.set(FIELD_IPADDR, (Object)pSDepSlnHostBase.getIPAddr());
        }
        if (pSDepSlnHostBase.isMemoDirty() && (bl || pSDepSlnHostBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDepSlnHostBase.getMemo());
        }
        if (pSDepSlnHostBase.isPSDepSlnHostIdDirty() && (bl || pSDepSlnHostBase.getPSDepSlnHostId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNHOSTID, (Object)pSDepSlnHostBase.getPSDepSlnHostId());
        }
        if (pSDepSlnHostBase.isPSDepSlnHostNameDirty() && (bl || pSDepSlnHostBase.getPSDepSlnHostName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNHOSTNAME, (Object)pSDepSlnHostBase.getPSDepSlnHostName());
        }
        if (pSDepSlnHostBase.isPSDepSlnIdDirty() && (bl || pSDepSlnHostBase.getPSDepSlnId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNID, (Object)pSDepSlnHostBase.getPSDepSlnId());
        }
        if (pSDepSlnHostBase.isPSDepSlnNameDirty() && (bl || pSDepSlnHostBase.getPSDepSlnName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNNAME, (Object)pSDepSlnHostBase.getPSDepSlnName());
        }
        if (pSDepSlnHostBase.isPwdDirty() && (bl || pSDepSlnHostBase.getPwd() != null)) {
            iDataObject.set(FIELD_PWD, (Object)pSDepSlnHostBase.getPwd());
        }
        if (pSDepSlnHostBase.isUpdateDateDirty() && (bl || pSDepSlnHostBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDepSlnHostBase.getUpdateDate());
        }
        if (pSDepSlnHostBase.isUpdateManDirty() && (bl || pSDepSlnHostBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDepSlnHostBase.getUpdateMan());
        }
        if (pSDepSlnHostBase.isUserNameDirty() && (bl || pSDepSlnHostBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSDepSlnHostBase.getUserName());
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
        return PSDepSlnHostBase.remove(this, n);
    }

    private static boolean remove(PSDepSlnHostBase pSDepSlnHostBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnHostBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDepSlnHostBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDepSlnHostBase.resetIPAddr();
                return true;
            }
            case 3: {
                pSDepSlnHostBase.resetMemo();
                return true;
            }
            case 4: {
                pSDepSlnHostBase.resetPSDepSlnHostId();
                return true;
            }
            case 5: {
                pSDepSlnHostBase.resetPSDepSlnHostName();
                return true;
            }
            case 6: {
                pSDepSlnHostBase.resetPSDepSlnId();
                return true;
            }
            case 7: {
                pSDepSlnHostBase.resetPSDepSlnName();
                return true;
            }
            case 8: {
                pSDepSlnHostBase.resetPwd();
                return true;
            }
            case 9: {
                pSDepSlnHostBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSDepSlnHostBase.resetUpdateMan();
                return true;
            }
            case 11: {
                pSDepSlnHostBase.resetUserName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSln getPSDepSln() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSln();
        }
        if (this.getPSDepSlnId() == null) {
            return null;
        }
        Integer n = this.objPSDepSlnLock;
        synchronized (n) {
            if (this.psdepsln != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSlnId(), (Object)this.psdepsln.getPSDepSlnId()) != 0L) {
                this.psdepsln = null;
            }
            if (this.psdepsln == null) {
                PSDepSln pSDepSln = new PSDepSln();
                pSDepSln.setPSDepSlnId(this.getPSDepSlnId());
                PSDepSlnService pSDepSlnService = (PSDepSlnService)ServiceGlobal.getService(PSDepSlnService.class, (SessionFactory)this.getSessionFactory());
                pSDepSlnService.autoGet((IEntity)pSDepSln);
                this.psdepsln = pSDepSln;
            }
            return this.psdepsln;
        }
    }

    private PSDepSlnHostBase getProxyEntity() {
        return this.proxyPSDepSlnHostBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDepSlnHostBase = null;
        if (iDataObject != null && iDataObject instanceof PSDepSlnHostBase) {
            this.proxyPSDepSlnHostBase = (PSDepSlnHostBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnHostService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_IPADDR, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSDEPSLNHOSTID, 4);
        fieldIndexMap.put(FIELD_PSDEPSLNHOSTNAME, 5);
        fieldIndexMap.put(FIELD_PSDEPSLNID, 6);
        fieldIndexMap.put(FIELD_PSDEPSLNNAME, 7);
        fieldIndexMap.put(FIELD_PWD, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
        fieldIndexMap.put(FIELD_USERNAME, 11);
    }
}

