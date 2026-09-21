/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDEDataQueryCodeCond
 *  net.ibizsys.paas.core.IDEDataQueryCodeExp
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQMain;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDQAlias;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.paas.core.IDEDataQueryCodeCond;
import net.ibizsys.paas.core.IDEDataQueryCodeExp;

@PSModelIgnoreMeta
public interface IPSDEDQEngine {
    public void init(ISRFDAGlobalHelper var1, IPSDBType var2, IPSDataEntity var3) throws Exception;

    public String getQueryScript();

    public String getQueryScriptTemp();

    public void compile(IPSDEDQMain var1) throws Exception;

    public Iterator<IDEDataQueryCodeExp> getDEDataQueryCodeExps();

    public Iterator<IDEDataQueryCodeCond> getDEDataQueryCodeConds();

    public boolean isEnablePQL();

    public Iterator<String> getPSDEDQAliasNames();

    public PSDEDQAlias getPSDEDQAlias(String var1, boolean var2) throws Exception;
}

