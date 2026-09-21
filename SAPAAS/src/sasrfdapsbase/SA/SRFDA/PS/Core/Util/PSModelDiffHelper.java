/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  net.ibizsys.paas.core.IDEField
 *  net.ibizsys.paas.data.DEFieldDiffItem
 *  net.ibizsys.paas.data.IDEFieldDiffItem
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.sysmodel.ICodeListModel
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Util;

import SA.SRFDA.PS.Core.IPSModelDiffActionContext;
import SA.SRFDA.PS.Core.IPSModelDiffable;
import SA.SRFDA.PS.Data.PSDevSysDiffItem;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.data.DEFieldDiffItem;
import net.ibizsys.paas.data.IDEFieldDiffItem;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;

public class PSModelDiffHelper {
    public static int diff(IPSModelDiffActionContext iPSModelDiffActionContext, Iterator srcIterator, Iterator dstIterator) throws Exception {
        IPSModelDiffable iPSModelDiffable;
        Object obj;
        int nCount = 0;
        HashMap<String, IPSModelDiffable> srcPSModelDiffableMap = new HashMap<String, IPSModelDiffable>();
        HashMap<String, IPSModelDiffable> dstPSModelDiffableMap = new HashMap<String, IPSModelDiffable>();
        if (srcIterator != null) {
            while (srcIterator.hasNext()) {
                obj = srcIterator.next();
                if (!(obj instanceof IPSModelDiffable)) continue;
                iPSModelDiffable = (IPSModelDiffable)obj;
                srcPSModelDiffableMap.put(iPSModelDiffable.getId(), iPSModelDiffable);
            }
        }
        if (dstIterator != null) {
            while (dstIterator.hasNext()) {
                obj = dstIterator.next();
                if (!(obj instanceof IPSModelDiffable)) continue;
                iPSModelDiffable = (IPSModelDiffable)obj;
                dstPSModelDiffableMap.put(iPSModelDiffable.getId(), iPSModelDiffable);
            }
        }
        for (IPSModelDiffable srcPSModelDiffable : srcPSModelDiffableMap.values()) {
            IPSModelDiffable dstPSModelDiffable = (IPSModelDiffable)dstPSModelDiffableMap.get(srcPSModelDiffable.getId());
            if (dstPSModelDiffable == null) {
                nCount += PSModelDiffHelper.diff(iPSModelDiffActionContext, srcPSModelDiffable, null);
                continue;
            }
            dstPSModelDiffableMap.remove(srcPSModelDiffable.getId());
            nCount += srcPSModelDiffable.diff(iPSModelDiffActionContext, dstPSModelDiffable);
        }
        for (IPSModelDiffable dstPSModelDiffable : dstPSModelDiffableMap.values()) {
            nCount += PSModelDiffHelper.diff(iPSModelDiffActionContext, null, dstPSModelDiffable);
        }
        return nCount;
    }

    public static int diff(IPSModelDiffActionContext iPSModelDiffActionContext, IPSModelDiffable srcPSModelDiffable, IPSModelDiffable dstPSModelDiffable) throws Exception {
        if (srcPSModelDiffable == null && dstPSModelDiffable == null) {
            return 0;
        }
        if (srcPSModelDiffable == null) {
            PSDevSysDiffItem psDevSysDiffItem = new PSDevSysDiffItem();
            psDevSysDiffItem.setDIFFTYPE("SRCNOTEXISTS");
            iPSModelDiffActionContext.addDiffItem(psDevSysDiffItem, dstPSModelDiffable);
            return 1;
        }
        if (dstPSModelDiffable == null) {
            PSDevSysDiffItem psDevSysDiffItem = new PSDevSysDiffItem();
            psDevSysDiffItem.setDIFFTYPE("DSTNOTEXISTS");
            iPSModelDiffActionContext.addDiffItem(psDevSysDiffItem, srcPSModelDiffable);
            return 1;
        }
        return srcPSModelDiffable.diff(iPSModelDiffActionContext, dstPSModelDiffable);
    }

    public static ArrayList<IDEFieldDiffItem> getDEDataDiffItems(IDataEntityModel iDEModel, BaseDataEntity curData, BaseDataEntity oldData, boolean bOnlyEnableAudit) throws Exception {
        ArrayList<IDEFieldDiffItem> deFieldDiffItemList = new ArrayList<IDEFieldDiffItem>();
        if (curData == null || oldData == null) {
            return deFieldDiffItemList;
        }
        Iterator deFields = iDEModel.getDEFields();
        while (deFields.hasNext()) {
            IDEField iDEField = (IDEField)deFields.next();
            if (!iDEField.isPhisicalDEField() || bOnlyEnableAudit && !iDEField.isEnableAudit() || StringHelper.compare((String)iDEField.getPreDefinedType(), (String)"CREATEDATE", (boolean)true) == 0 || StringHelper.compare((String)iDEField.getPreDefinedType(), (String)"CREATEMAN", (boolean)true) == 0 || StringHelper.compare((String)iDEField.getPreDefinedType(), (String)"CREATEMANNAME", (boolean)true) == 0 || StringHelper.compare((String)iDEField.getPreDefinedType(), (String)"LOGICVALID", (boolean)true) == 0 || StringHelper.compare((String)iDEField.getPreDefinedType(), (String)"UPDATEDATE", (boolean)true) == 0 || StringHelper.compare((String)iDEField.getPreDefinedType(), (String)"UPDATEMAN", (boolean)true) == 0 || StringHelper.compare((String)iDEField.getPreDefinedType(), (String)"UPDATEMANNAME", (boolean)true) == 0 || StringHelper.compare((String)iDEField.getDataType(), (String)"PICKUP", (boolean)true) == 0) continue;
            Object objNewValue = curData.getParamValue(iDEField.getName());
            Object objOldValue = oldData.getParamValue(iDEField.getName());
            if (objNewValue == null && objOldValue == null || objNewValue != null && objOldValue != null && DataTypeHelper.compare((int)iDEField.getStdDataType(), (Object)objNewValue, (Object)objOldValue) == 0L) continue;
            String strNewValueText = "";
            String strOldValueText = "";
            ICodeListModel codeListConfig = null;
            String strCodeListId = iDEField.getCodeListId();
            if (!StringHelper.isNullOrEmpty((String)strCodeListId)) {
                codeListConfig = (ICodeListModel)CodeListGlobal.getCodeList((String)strCodeListId);
                if (objNewValue != null && codeListConfig != null) {
                    strNewValueText = codeListConfig.getCodeListText(objNewValue.toString(), true);
                }
                if (objOldValue != null && codeListConfig != null) {
                    strOldValueText = codeListConfig.getCodeListText(objOldValue.toString(), true);
                }
            } else {
                String strItemFormat = iDEField.getValueFormat();
                if (StringHelper.isNullOrEmpty((String)strItemFormat)) {
                    strItemFormat = "%1$s";
                }
                if (objNewValue != null) {
                    strNewValueText = StringHelper.format((String)strItemFormat, (Object)objNewValue);
                }
                if (objOldValue != null) {
                    strOldValueText = StringHelper.format((String)strItemFormat, (Object)objOldValue);
                }
            }
            DEFieldDiffItem deFieldDiffItem = new DEFieldDiffItem();
            deFieldDiffItem.setDEField(iDEField);
            deFieldDiffItem.setNewText(strNewValueText);
            deFieldDiffItem.setOldText(strOldValueText);
            deFieldDiffItem.setNewValue(objNewValue);
            deFieldDiffItem.setOldValue(objOldValue);
            deFieldDiffItemList.add((IDEFieldDiffItem)deFieldDiffItem);
        }
        return deFieldDiffItemList;
    }
}

