/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DataGrid.BaseDADataGridActionHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExDGAjaxActionResult
 *  SA.SRFramework.XML.SimpleXMLWriter
 *  mondrian.olap.CacheControl
 *  mondrian.olap.Cube
 *  mondrian.rolap.RolapSchema
 */
package SA.SRFDA.BI.Ctrl.DataGrid;

import SA.SRFDA.BI.Ctrl.Data.BICatalog;
import SA.SRFDA.BI.Ctrl.DefaultBIDataSourcesWriter;
import SA.SRFDA.BI.Ctrl.DefaultBIThemeWriter;
import SA.SRFDA.Ctrl.DataGrid.BaseDADataGridActionHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExDGAjaxActionResult;
import SA.SRFramework.XML.SimpleXMLWriter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import mondrian.olap.CacheControl;
import mondrian.olap.Cube;
import mondrian.rolap.RolapSchema;

public class BICatalogDataGridActionHelper
extends BaseDADataGridActionHelper {
    public static final String ACTION_PUBLISHCONFIG = "PUBLISHCONFIG";
    public static final String ACTION_RESETCUBECACHE = "RESETCUBECACHE";

    protected boolean OnCustomAction(String strAction) {
        if (StringHelper.Compare((String)strAction, (String)ACTION_PUBLISHCONFIG, (boolean)true) == 0) {
            return this.OnPublishConfig();
        }
        if (StringHelper.Compare((String)strAction, (String)ACTION_RESETCUBECACHE, (boolean)true) == 0) {
            return this.OnResetCubeCache();
        }
        return super.OnCustomAction(strAction);
    }

    protected boolean OnResetCubeCache() {
        SRFExDGAjaxActionResult resetCacheResult = new SRFExDGAjaxActionResult();
        resetCacheResult.setReload(false);
        try {
            Iterator schemaIterator = RolapSchema.getRolapSchemas().iterator();
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
            resetCacheResult.setRetCode(0);
            resetCacheResult.AppendJSCode("alert('\u91cd\u7f6e\u5206\u6790\u7acb\u65b9\u4f53\u7f13\u5b58\u6210\u529f!');");
        }
        catch (Exception ex) {
            resetCacheResult.setRetCode(1);
            resetCacheResult.AppendJSCode("alert('\u91cd\u7f6e\u5206\u6790\u7acb\u65b9\u4f53\u7f13\u5b58\u5931\u8d25!');");
        }
        this.getPage().Output(resetCacheResult.ToJSONString());
        return true;
    }

    protected boolean OnPublishConfig() {
        StringBuilder sb;
        String strConfigPath;
        SRFExDGAjaxActionResult publishConfigResult;
        block9: {
            publishConfigResult = new SRFExDGAjaxActionResult();
            publishConfigResult.setReload(true);
            String strKeys = this.getWebContext().GetPostValue("srfdakeys");
            String[] keys = strKeys.split("[,]");
            int i = 0;
            while (i < keys.length) {
                String strKeyValue = keys[i];
                if (!StringHelper.IsNullOrEmpty((String)strKeyValue)) {
                    BICatalog biCatalog = new BICatalog();
                    biCatalog.setBICATALOGID(strKeyValue);
                    CallResult callResult = this.getDEDataCtrl().Get((BaseDataEntity)biCatalog);
                    if (callResult == null || callResult.getRetCode() != 0) {
                        publishConfigResult.From(callResult);
                        publishConfigResult.setErrorInfo(StringHelper.Format((String)"\u66f4\u65b0\u591a\u7ef4\u5206\u6790\u7f16\u76ee[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strKeyValue, (Object)callResult.getErrorInfo()));
                        this.getPage().PageLog((Object)this, 1, publishConfigResult.getErrorInfo());
                        this.getPage().Output(publishConfigResult.ToJSONString());
                        return true;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    SimpleXMLWriter writer = new SimpleXMLWriter(sb2);
                    writer.WriteRaw("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n");
                    DefaultBIThemeWriter defaultBIThemeWriter = new DefaultBIThemeWriter();
                    callResult = defaultBIThemeWriter.Export((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), biCatalog, writer);
                    if (callResult == null || callResult.getRetCode() != 0) {
                        publishConfigResult.From(callResult);
                        publishConfigResult.setErrorInfo(StringHelper.Format((String)"\u66f4\u65b0\u591a\u7ef4\u5206\u6790\u7f16\u76ee[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strKeyValue, (Object)callResult.getErrorInfo()));
                        this.getPage().PageLog((Object)this, 1, publishConfigResult.getErrorInfo());
                        this.getPage().Output(publishConfigResult.ToJSONString());
                        return true;
                    }
                    String strConfigPath2 = StringHelper.Format((String)"/WEB-INF/biconf/%1$s.xml", (Object)biCatalog.getBICATALOGID().toLowerCase());
                    strConfigPath2 = this.getWebContext().getGlobalHelper().getServletContext().getRealPath(strConfigPath2);
                    try {
                        OutputStreamWriter out = new OutputStreamWriter((OutputStream)new FileOutputStream(strConfigPath2), "UTF-8");
                        out.write(sb2.toString());
                        out.flush();
                        out.close();
                    }
                    catch (Exception ex) {
                        publishConfigResult.setRetCode(1);
                        publishConfigResult.setErrorInfo(StringHelper.Format((String)"\u66f4\u65b0\u591a\u7ef4\u5206\u6790\u6570\u636e\u6e90[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strKeyValue, (Object)ex.getMessage()));
                        this.getPage().PageLog((Object)this, 1, publishConfigResult.getErrorInfo());
                        this.getPage().Output(publishConfigResult.ToJSONString());
                        return true;
                    }
                }
                ++i;
            }
            try {
                strConfigPath = StringHelper.Format((String)"/WEB-INF/datasources.xml");
                strConfigPath = this.getWebContext().getGlobalHelper().getServletContext().getRealPath(strConfigPath);
                sb = new StringBuilder();
                SimpleXMLWriter writer = new SimpleXMLWriter(sb);
                writer.WriteRaw("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n");
                DefaultBIDataSourcesWriter defaultBIDataSourceWriter = new DefaultBIDataSourcesWriter();
                CallResult callResult = defaultBIDataSourceWriter.Export((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), writer);
                if (callResult != null && callResult.getRetCode() == 0) break block9;
                publishConfigResult.From(callResult);
                publishConfigResult.setErrorInfo(StringHelper.Format((String)"\u66f4\u65b0\u591a\u7ef4\u5206\u6790\u6570\u636e\u6e90[%1$s]\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                this.getPage().PageLog((Object)this, 1, publishConfigResult.getErrorInfo());
                this.getPage().Output(publishConfigResult.ToJSONString());
                return true;
            }
            catch (Exception ex) {
                publishConfigResult.setRetCode(1);
                publishConfigResult.setErrorInfo(StringHelper.Format((String)"\u66f4\u65b0\u591a\u7ef4\u5206\u6790\u7f16\u76ee[%1$s]\u5931\u8d25\uff0c%1$s", (Object)ex.getMessage()));
                this.getPage().PageLog((Object)this, 1, publishConfigResult.getErrorInfo());
                this.getPage().Output(publishConfigResult.ToJSONString());
                return true;
            }
        }
        try {
            OutputStreamWriter out = new OutputStreamWriter((OutputStream)new FileOutputStream(strConfigPath), "UTF-8");
            out.write(sb.toString());
            out.flush();
            out.close();
        }
        catch (Exception exception) {
            publishConfigResult.setRetCode(1);
            publishConfigResult.setErrorInfo(exception.getMessage());
            this.getPage().Output(publishConfigResult.ToJSONString());
            return true;
        }
        publishConfigResult.setRetCode(0);
        publishConfigResult.AppendJSCode("alert('\u66f4\u65b0\u591a\u7ef4\u5206\u6790\u7f16\u76ee\u6210\u529f!');");
        this.getPage().Output(publishConfigResult.ToJSONString());
        return true;
    }
}

