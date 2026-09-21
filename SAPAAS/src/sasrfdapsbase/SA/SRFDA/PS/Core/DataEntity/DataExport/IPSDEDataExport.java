/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDEDataExport
 */
package SA.SRFDA.PS.Core.DataEntity.DataExport;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.DataExport.IPSDEDataExportGroup;
import SA.SRFDA.PS.Core.DataEntity.DataExport.IPSDEDataExportItem;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Data.PSDEDataExport;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.paas.core.IDEDataExport;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6570\u636e\u5bfc\u51fa\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEDataExp", description="\u5b9e\u4f53\u5bfc\u51fa\u4f7f\u7528\u8868\u683c\u6a21\u578b{@link net.ibizsys.centralstudio.dto.PSDEGrid}\u5b9a\u4e49\u5bfc\u51fa\u6a21\u578b")
public interface IPSDEDataExport
extends IPSDataEntityObject,
IDEDataExport {
    public void init(ISRFDAGlobalHelper var1, IPSDataEntity var2, PSDEDataExport var3) throws Exception;

    @Override
    public String getCodeName();

    public Iterator<IPSDEDataExportItem> getPSDEDataExportItems();

    public Iterator<IPSDEDataExportGroup> getPSDEDataExportGroups();

    public IPSDEDataExportGroup getPSDEDataExportGroup(String var1, boolean var2) throws Exception;

    public int getMaxRowCount();

    public boolean isEnableBackend();

    public boolean isEnableFront();

    public int getActionHolder();

    public IPSSysPFPlugin getPSSysPFPlugin();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSXCodeObject getRender();

    public boolean isDefaultMode();

    public int getGroupLevel();

    public int getPOTime();

    public boolean isEnableCustomized();

    public String getExpTag();

    public String getExpTag2();

    public Properties getExpParams();

    public String getContentType();

    public String getFileNameFormat();

    public IPSDEDataSet getPSDEDataSet();
}

