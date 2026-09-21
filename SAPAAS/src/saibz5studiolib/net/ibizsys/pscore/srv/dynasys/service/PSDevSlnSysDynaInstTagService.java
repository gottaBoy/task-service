/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.IDataRow
 *  net.ibizsys.paas.db.IDataSet
 *  net.ibizsys.paas.db.IDataTable
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.impl.SimpleDataRowImpl
 *  net.ibizsys.paas.db.impl.SimpleDataSetImpl
 *  net.ibizsys.paas.db.impl.SimpleDataTableImpl
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dynasys.service;

import java.io.File;
import java.util.ArrayList;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataSet;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.impl.SimpleDataRowImpl;
import net.ibizsys.paas.db.impl.SimpleDataSetImpl;
import net.ibizsys.paas.db.impl.SimpleDataTableImpl;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInst;
import net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInstBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInstTag;
import net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstService;
import net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstTagServiceBase;
import net.ibizsys.pscore.srv.util.PSDevCenterSVNHelper;
import net.ibizsys.pscore.srv.util.PSStudioEnvHelper;
import net.ibizsys.pscore.srv.util.gitlab.model.Tag;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDevSlnSysDynaInstTagService
extends PSDevSlnSysDynaInstTagServiceBase {
    private static final Log log = LogFactory.getLog(PSDevSlnSysDynaInstTagService.class);

    @Override
    protected CallResult internalGet(PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag, boolean bl, int n) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory()) && PSDevSlnSysDynaInstTagService.isEnableGitLabPlugin()) {
            String[] stringArray;
            String string = pSDevSlnSysDynaInstTag.getPSDevSlnSysDynaInstTagId();
            if (!StringHelper.isNullOrEmpty((String)string) && (stringArray = string.split("[.]")).length >= 2) {
                pSDevSlnSysDynaInstTag.setPSDevSlnSysDynaInstId(stringArray[0]);
                pSDevSlnSysDynaInstTag.setPSDevSlnSysDynaInstTagName(stringArray[1]);
            }
            if (!StringHelper.isNullOrEmpty((String)(stringArray = pSDevSlnSysDynaInstTag.getPSDevSlnSysDynaInstId()))) {
                PSDevSlnSysDynaInst pSDevSlnSysDynaInst = new PSDevSlnSysDynaInst();
                pSDevSlnSysDynaInst.setPSDevSlnSysDynaInstId((String)stringArray);
                PSDevSlnSysDynaInstService pSDevSlnSysDynaInstService = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                if (!pSDevSlnSysDynaInstService.get((IEntity)pSDevSlnSysDynaInst, true)) {
                    throw new Exception(String.format("\u6307\u5b9a\u52a8\u6001\u5b9e\u4f8b[%1$s]\u65e0\u6548", new Object[]{stringArray}));
                }
                Tag tag = PSDevSlnSysDynaInstTagService.getPSGitLabPlugin().getTagByPSDevSlnSysDynaInstTag(pSDevSlnSysDynaInstTag);
                String string2 = String.format("%1$s.%2$s", stringArray, tag.getName());
                pSDevSlnSysDynaInstTag.setPSDevSlnSysDynaInstTagId(string2);
                pSDevSlnSysDynaInstTag.setPSDevSlnSysDynaInstTagName(tag.getName());
                pSDevSlnSysDynaInstTag.setMemo(tag.getMessage());
                return new CallResult();
            }
        }
        throw new Exception("\u5f53\u524d\u73af\u5883\u4e0d\u652f\u6301\u6b64\u64cd\u4f5c");
    }

    @Override
    protected void internalCreate(PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag) throws Exception {
        String string;
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory()) && PSDevSlnSysDynaInstTagService.isEnableGitLabPlugin() && !StringHelper.isNullOrEmpty((String)(string = pSDevSlnSysDynaInstTag.getPSDevSlnSysDynaInstId()))) {
            PSDevSlnSysDynaInst pSDevSlnSysDynaInst = new PSDevSlnSysDynaInst();
            pSDevSlnSysDynaInst.setPSDevSlnSysDynaInstId(string);
            PSDevSlnSysDynaInstService pSDevSlnSysDynaInstService = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            if (!pSDevSlnSysDynaInstService.get((IEntity)pSDevSlnSysDynaInst, true)) {
                throw new Exception(String.format("\u6307\u5b9a\u52a8\u6001\u5b9e\u4f8b[%1$s]\u65e0\u6548", string));
            }
            Tag tag = PSDevSlnSysDynaInstTagService.getPSGitLabPlugin().createTagByPSDevSlnSysDynaInstTag(pSDevSlnSysDynaInstTag);
            String string2 = String.format("%1$s.%2$s", string, tag.getName());
            pSDevSlnSysDynaInstTag.setPSDevSlnSysDynaInstTagId(string2);
            return;
        }
        throw new Exception("\u5f53\u524d\u73af\u5883\u4e0d\u652f\u6301\u6b64\u64cd\u4f5c");
    }

    @Override
    protected void internalUpdate(PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory()) && PSDevSlnSysDynaInstTagService.isEnableGitLabPlugin()) {
            String[] stringArray;
            String string = pSDevSlnSysDynaInstTag.getPSDevSlnSysDynaInstTagId();
            if (!StringHelper.isNullOrEmpty((String)string) && (stringArray = string.split("[.]")).length >= 2) {
                pSDevSlnSysDynaInstTag.setPSDevSlnSysDynaInstId(stringArray[0]);
                pSDevSlnSysDynaInstTag.setPSDevSlnSysDynaInstTagName(stringArray[1]);
            }
            if (!StringHelper.isNullOrEmpty((String)(stringArray = pSDevSlnSysDynaInstTag.getPSDevSlnSysDynaInstId()))) {
                PSDevSlnSysDynaInst pSDevSlnSysDynaInst = new PSDevSlnSysDynaInst();
                pSDevSlnSysDynaInst.setPSDevSlnSysDynaInstId((String)stringArray);
                PSDevSlnSysDynaInstService pSDevSlnSysDynaInstService = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                if (!pSDevSlnSysDynaInstService.get((IEntity)pSDevSlnSysDynaInst, true)) {
                    throw new Exception(String.format("\u6307\u5b9a\u52a8\u6001\u5b9e\u4f8b[%1$s]\u65e0\u6548", new Object[]{stringArray}));
                }
                Tag tag = PSDevSlnSysDynaInstTagService.getPSGitLabPlugin().updateTagByPSDevSlnSysDynaInstTag(pSDevSlnSysDynaInstTag);
                String string2 = String.format("%1$s.%2$s", stringArray, tag.getName());
                pSDevSlnSysDynaInstTag.setPSDevSlnSysDynaInstTagId(string2);
                return;
            }
        }
        throw new Exception("\u5f53\u524d\u73af\u5883\u4e0d\u652f\u6301\u6b64\u64cd\u4f5c");
    }

    @Override
    protected void internalSysUpdate(PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag) throws Exception {
        throw new Exception("\u5f53\u524d\u73af\u5883\u4e0d\u652f\u6301\u6b64\u64cd\u4f5c");
    }

    @Override
    protected void internalRemove(PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory()) && PSDevSlnSysDynaInstTagService.isEnableGitLabPlugin()) {
            String[] stringArray;
            String string = pSDevSlnSysDynaInstTag.getPSDevSlnSysDynaInstTagId();
            if (!StringHelper.isNullOrEmpty((String)string) && (stringArray = string.split("[.]")).length >= 2) {
                pSDevSlnSysDynaInstTag.setPSDevSlnSysDynaInstId(stringArray[0]);
                pSDevSlnSysDynaInstTag.setPSDevSlnSysDynaInstTagName(stringArray[1]);
            }
            if (!StringHelper.isNullOrEmpty((String)(stringArray = pSDevSlnSysDynaInstTag.getPSDevSlnSysDynaInstId()))) {
                PSDevSlnSysDynaInst pSDevSlnSysDynaInst = new PSDevSlnSysDynaInst();
                pSDevSlnSysDynaInst.setPSDevSlnSysDynaInstId((String)stringArray);
                PSDevSlnSysDynaInstService pSDevSlnSysDynaInstService = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                if (!pSDevSlnSysDynaInstService.get((IEntity)pSDevSlnSysDynaInst, true)) {
                    throw new Exception(String.format("\u6307\u5b9a\u52a8\u6001\u5b9e\u4f8b[%1$s]\u65e0\u6548", new Object[]{stringArray}));
                }
                PSDevSlnSysDynaInstTagService.getPSGitLabPlugin().removeTagByPSDevSlnSysDynaInstTag(pSDevSlnSysDynaInstTag);
                return;
            }
        }
        throw new Exception("\u5f53\u524d\u73af\u5883\u4e0d\u652f\u6301\u6b64\u64cd\u4f5c");
    }

    @Override
    protected ArrayList<PSDevSlnSysDynaInstTag> internalSelect(ISelectCond iSelectCond) throws Exception {
        String string;
        ArrayList<PSDevSlnSysDynaInstTag> arrayList = new ArrayList<PSDevSlnSysDynaInstTag>();
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory()) && PSDevSlnSysDynaInstTagService.isEnableGitLabPlugin() && !StringHelper.isNullOrEmpty((String)(string = DataTypeHelper.getStringValue((Object)iSelectCond.get("psdevslnsysdynainstid"))))) {
            PSDevSlnSysDynaInst pSDevSlnSysDynaInst = new PSDevSlnSysDynaInst();
            pSDevSlnSysDynaInst.setPSDevSlnSysDynaInstId(string);
            PSDevSlnSysDynaInstService pSDevSlnSysDynaInstService = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            if (!pSDevSlnSysDynaInstService.get((IEntity)pSDevSlnSysDynaInst, true)) {
                throw new Exception(String.format("\u6307\u5b9a\u52a8\u6001\u5b9e\u4f8b[%1$s]\u65e0\u6548", string));
            }
            Tag[] tagArray = PSDevSlnSysDynaInstTagService.getPSGitLabPlugin().listTagsByPSDevSlnSysDynaInst(pSDevSlnSysDynaInst);
            if (tagArray != null) {
                for (Tag tag : tagArray) {
                    PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag = new PSDevSlnSysDynaInstTag();
                    String string2 = String.format("%1$s.%2$s", string, tag.getName());
                    pSDevSlnSysDynaInstTag.setPSDevSlnSysDynaInstTagId(string2);
                    pSDevSlnSysDynaInstTag.setPSDevSlnSysDynaInstTagName(tag.getName());
                    pSDevSlnSysDynaInstTag.setMemo(tag.getMessage());
                    arrayList.add(pSDevSlnSysDynaInstTag);
                }
            }
        }
        return arrayList;
    }

    @Override
    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        Object object;
        Object object22;
        Object object3;
        ArrayList<PSDevSlnSysDynaInstTag> arrayList = new ArrayList<PSDevSlnSysDynaInstTag>();
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory()) && PSDevSlnSysDynaInstTagService.isEnableGitLabPlugin()) {
            arrayList = new ArrayList();
            object3 = null;
            if (iDEDataSetFetchContext.getActiveDataObject() != null) {
                object3 = DataTypeHelper.getStringValue((Object)iDEDataSetFetchContext.getActiveDataObject().get("psdevslnsysdynainstid"));
            }
            if (StringHelper.isNullOrEmpty((String)object3) && iDEDataSetFetchContext.getConditionList() != null) {
                for (Object object22 : iDEDataSetFetchContext.getConditionList()) {
                    if (StringHelper.compare((String)"psdevslnsysdynainstid", (String)object22.getDEFName(), (boolean)true) != 0 || StringHelper.compare((String)"EQ", (String)object22.getCondOp(), (boolean)true) != 0) continue;
                    object3 = object22.getCondValue();
                    break;
                }
            }
            if (!StringHelper.isNullOrEmpty((String)object3)) {
                object = new PSDevSlnSysDynaInst();
                ((PSDevSlnSysDynaInstBase)object).setPSDevSlnSysDynaInstId((String)object3);
                object22 = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                if (!object22.get((IEntity)object, true)) {
                    throw new Exception(String.format("\u6307\u5b9a\u52a8\u6001\u5b9e\u4f8b[%1$s]\u65e0\u6548", object3));
                }
                Tag[] tagArray = PSDevSlnSysDynaInstTagService.getPSGitLabPlugin().listTagsByPSDevSlnSysDynaInst((PSDevSlnSysDynaInst)object);
                if (tagArray != null) {
                    for (Tag tag : tagArray) {
                        PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag = new PSDevSlnSysDynaInstTag();
                        String string = String.format("%1$s.%2$s", object3, tag.getName());
                        pSDevSlnSysDynaInstTag.setPSDevSlnSysDynaInstTagId(string);
                        pSDevSlnSysDynaInstTag.setPSDevSlnSysDynaInstTagName(tag.getName());
                        pSDevSlnSysDynaInstTag.setMemo(tag.getMessage());
                        arrayList.add(pSDevSlnSysDynaInstTag);
                    }
                }
            }
        }
        object3 = new DBFetchResult();
        object = new SimpleDataSetImpl();
        object22 = new SimpleDataTableImpl((IDataSet)object);
        object.addDataTable((IDataTable)object22);
        object3.setDataSet((IDataSet)object);
        if (arrayList != null) {
            object3.setTotalRow(arrayList.size());
            int n = arrayList.size();
            if (iDEDataSetFetchContext.getPageSize() > 0 && (n = iDEDataSetFetchContext.getStartRow() + iDEDataSetFetchContext.getPageSize()) > arrayList.size()) {
                n = arrayList.size();
            }
            for (int i = iDEDataSetFetchContext.getStartRow(); i < n; ++i) {
                PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag = (PSDevSlnSysDynaInstTag)arrayList.get(i);
                SimpleDataRowImpl simpleDataRowImpl = new SimpleDataRowImpl();
                pSDevSlnSysDynaInstTag.copyTo((IDataObject)simpleDataRowImpl, false);
                object22.addCachedRow((IDataRow)simpleDataRowImpl);
            }
        }
        return object3;
    }

    @Override
    protected void onRevert(PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory()) && PSDevSlnSysDynaInstTagService.isEnableGitLabPlugin()) {
            String[] stringArray;
            String string = pSDevSlnSysDynaInstTag.getPSDevSlnSysDynaInstTagId();
            if (!StringHelper.isNullOrEmpty((String)string) && (stringArray = string.split("[.]")).length >= 2) {
                pSDevSlnSysDynaInstTag.setPSDevSlnSysDynaInstId(stringArray[0]);
                pSDevSlnSysDynaInstTag.setPSDevSlnSysDynaInstTagName(stringArray[1]);
            }
            if (!StringHelper.isNullOrEmpty((String)(stringArray = pSDevSlnSysDynaInstTag.getPSDevSlnSysDynaInstId()))) {
                PSDevSlnSysDynaInst pSDevSlnSysDynaInst = new PSDevSlnSysDynaInst();
                pSDevSlnSysDynaInst.setPSDevSlnSysDynaInstId((String)stringArray);
                PSDevSlnSysDynaInstService pSDevSlnSysDynaInstService = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                if (!pSDevSlnSysDynaInstService.get((IEntity)pSDevSlnSysDynaInst, true)) {
                    throw new Exception(String.format("\u6307\u5b9a\u52a8\u6001\u5b9e\u4f8b[%1$s]\u65e0\u6548", new Object[]{stringArray}));
                }
                PSDevCenterSVN pSDevCenterSVN = pSDevSlnSysDynaInst.getModelPSDevCenterSVN();
                if (pSDevCenterSVN == null) {
                    throw new Exception("\u52a8\u6001\u5b9e\u4f8b\u6a21\u578b\u4ed3\u5e93\u65e0\u6548");
                }
                String string2 = String.format("%1$s%2$s%3$s%2$sMODEL", PSStudioEnvHelper.getCurrent().getDynaInstFolder(), File.separator, pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId());
                PSDevCenterSVNHelper.getInstance().revert(pSDevCenterSVN, string2, pSDevSlnSysDynaInstTag.getPSDevSlnSysDynaInstTagName());
                return;
            }
        }
        throw new Exception("\u5f53\u524d\u73af\u5883\u4e0d\u652f\u6301\u6b64\u64cd\u4f5c");
    }
}

