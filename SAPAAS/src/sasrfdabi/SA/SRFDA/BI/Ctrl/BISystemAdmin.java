/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDASystemAdmin
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  mondrian.olap.CacheControl
 *  mondrian.olap.Cube
 *  mondrian.rolap.RolapSchema
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.Data.BIAggTable;
import SA.SRFDA.BI.Ctrl.ISRFDABIAggTableBuilder;
import SA.SRFDA.Ctrl.IDASystemAdmin;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Vector;
import mondrian.olap.CacheControl;
import mondrian.olap.Cube;
import mondrian.rolap.RolapSchema;

public class BISystemAdmin
implements IDASystemAdmin {
    public static final String FUNC_REBUILDAGGPROC = "REBUILDAGGPROC";
    public static final String FUNC_RESETCUBECACHE = "RESETCUBECACHE";
    protected static TreeMap<String, Boolean> funcMap = new TreeMap();
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;

    static {
        funcMap.put(FUNC_REBUILDAGGPROC, false);
        funcMap.put(FUNC_RESETCUBECACHE, false);
    }

    public void Init(ISRFDAGlobalHelper iDAGlobalHelper) {
        this.iDAGlobalHelper = iDAGlobalHelper;
    }

    public boolean isContainsFunc(String strFunc) {
        return funcMap.containsKey(strFunc.toUpperCase());
    }

    public CallResult CallFunc(String strFunc, String strParam) {
        CallResult callResult = new CallResult();
        if (StringHelper.Compare((String)FUNC_REBUILDAGGPROC, (String)strFunc, (boolean)true) == 0) {
            callResult = this.RebuildAggProc(new BaseDataEntity());
            if (callResult.getRetCode() == 0) {
                callResult.setUserObject((Object)"\u91cd\u5efa\u5f53\u524d\u65f6\u95f4\u805a\u5408\u8fc7\u7a0b\u6210\u529f\uff01");
            }
            return callResult;
        }
        if (StringHelper.Compare((String)FUNC_RESETCUBECACHE, (String)strFunc, (boolean)true) == 0) {
            callResult = this.ResetCubeCache(new BaseDataEntity());
            if (callResult.getRetCode() == 0) {
                callResult.setUserObject((Object)"\u91cd\u7f6e\u7acb\u65b9\u4f53\u7f13\u5b58\u6210\u529f\uff01");
            }
            return callResult;
        }
        return callResult;
    }

    protected CallResult ResetCubeCache(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        Iterator schemaIterator = RolapSchema.getRolapSchemas();
        while (schemaIterator.hasNext()) {
            RolapSchema schema = (RolapSchema)schemaIterator.next();
            CacheControl cacheControl = schema.getInternalConnection().getCacheControl(null);
            Cube[] cubeArray = schema.getCubes();
            int n = cubeArray.length;
            int n2 = 0;
            while (n2 < n) {
                Cube cube = cubeArray[n2];
                cacheControl.flush(cacheControl.createMeasuresRegion(cube));
                ++n2;
            }
        }
        return callResult;
    }

    protected CallResult RebuildAggProc(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        IDEDataCtrl iDEDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("BI0010", "SYSTEM", null);
        if (iDEDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8f85\u52a9\u5bf9\u8c61", (Object)"BI0010"));
            return callResult;
        }
        Vector biAggTables = new Vector();
        callResult = iDEDataCtrl.Select("ALLAGGTABLE", dataEntity, biAggTables, BIAggTable.class.getName());
        if (callResult.IsError()) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u67e5\u8be2\u805a\u5408\u8868\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        String strDefaultAggTableBuilder = this.iDAGlobalHelper.getWebExConfig().GetValue("SRFBI", "DEFAULTAGGTABLEBUILDER", "SA.SRFDA.BI.Ctrl.DB2BIAggTableBuilder");
        for (BIAggTable aggTable : biAggTables) {
            Object objAggTableBuilder;
            String strAggTableBuilder = aggTable.getAGGBUILDEROBJECT();
            if (StringHelper.IsNullOrEmpty((String)strAggTableBuilder)) {
                strAggTableBuilder = strDefaultAggTableBuilder;
            }
            if ((objAggTableBuilder = ObjectHelper.Create((String)strAggTableBuilder)) == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u805a\u5408\u8868\u6784\u5efa\u5bf9\u8c61[%1$s]", (Object)strAggTableBuilder));
                return callResult;
            }
            if (!(objAggTableBuilder instanceof ISRFDABIAggTableBuilder)) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u805a\u5408\u8868\u6784\u5efa\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strAggTableBuilder));
                return callResult;
            }
            ISRFDABIAggTableBuilder aggTableBuilder = (ISRFDABIAggTableBuilder)objAggTableBuilder;
            aggTableBuilder.Init(this.iDAGlobalHelper, aggTable);
            callResult = aggTableBuilder.Generate(new Date());
            if (!callResult.IsError()) continue;
            return callResult;
        }
        return callResult;
    }

    public CallResult GetFuncScript(String strFunc) {
        return null;
    }

    public boolean isFuncScript(String strFunc) {
        if (funcMap.containsKey(strFunc = strFunc.toUpperCase())) {
            return funcMap.get(strFunc);
        }
        return false;
    }
}

