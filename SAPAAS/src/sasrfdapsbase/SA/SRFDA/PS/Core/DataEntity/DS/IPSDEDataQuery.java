/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDEDataQuery
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCondition;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQEngine;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQJoin;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQMain;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQueryCode;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQueryInput;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQueryReturn;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Service.IPSRESTfulAPI;
import SA.SRFDA.PS.Data.PSDEDataQuery;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.paas.core.IDEDataQuery;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEDataQuery", description="\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\u6a21\u578b\u9664\u4e86\u81ea\u8eab\u903b\u8f91\u8fd8\u5305\u62ec\u4e86\u8f93\u5165{@link #getPSDEDataQueryInput}\u53ca\u8fd4\u56de{@link #getPSDEDataQueryReturn}\u6a21\u578b")
public interface IPSDEDataQuery
extends IPSDataEntityObject,
IDEDataQuery {
    public static final int VIEWLEVEL_DEFGROUP = 100;

    public void init(ISRFDAGlobalHelper var1, IPSDataEntity var2, PSDEDataQuery var3) throws Exception;

    @Override
    public String getCodeName();

    public IPSDEDQMain getPSDEDQMain();

    public boolean isCustomCode();

    public IPSDEDataQueryCode getPSDEDataQueryCode(String var1) throws Exception;

    public IPSDEDataQueryCode getPSDEDataQueryCode(String var1, boolean var2) throws Exception;

    public Iterator<IPSDEDataQueryCode> getAllPSDEDataQueryCodes() throws Exception;

    public IPSDEDQEngine getPSDEDQEngine(String var1) throws Exception;

    public void loadAll() throws Exception;

    public boolean isPrivQuery();

    @Override
    public int getExtendMode();

    public String getLogicName();

    public boolean isPubServiceDefault();

    public IPSRESTfulAPI getPSRESTfulAPI();

    public Iterator<IPSDEDQJoin> getAllPSDEDQJoins();

    public Iterator<IPSDEDQCondition> getAllPSDEDQConditions();

    public boolean isQueryFromView();

    public Iterator<IPSDEDQCondition> getADPSDEDQConditions();

    public IPSDEFGroup getPSDEFGroup();

    public String getDEFGroupType();

    public boolean isDefaultMode();

    public int getViewLevel();

    public IPSDEDataQueryInput getPSDEDataQueryInput();

    public IPSDEDataQueryReturn getPSDEDataQueryReturn();

    public int getOption();

    public boolean isEnablePQL();
}

