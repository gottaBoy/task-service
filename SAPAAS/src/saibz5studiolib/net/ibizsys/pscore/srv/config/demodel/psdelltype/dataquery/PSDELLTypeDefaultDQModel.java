/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataQuery
 *  net.ibizsys.paas.core.DEDataQueryCode
 *  net.ibizsys.paas.core.DEDataQueryCodeExp
 *  net.ibizsys.paas.core.DEDataQueryCodes
 *  net.ibizsys.paas.demodel.DEDataQueryModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psdelltype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="B4D27619-7AD4-470F-B1E0-80F86E21D128", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ICONPATH`, t1.`ITEMOBJ`, t1.`ITEMOBJ2`, t1.`ITEMOBJ3`, t1.`ITEMOBJ4`, t1.`ITEMOBJ5`, t1.`ITEMOBJ6`, t1.`MEMO`, t1.`PSDELLTYPEID`, t1.`PSDELLTYPENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDELLTYPE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="ICONPATH", expression="t1.`ICONPATH`", showorder=2), @DEDataQueryCodeExp(name="ITEMOBJ", expression="t1.`ITEMOBJ`", showorder=3), @DEDataQueryCodeExp(name="ITEMOBJ2", expression="t1.`ITEMOBJ2`", showorder=4), @DEDataQueryCodeExp(name="ITEMOBJ3", expression="t1.`ITEMOBJ3`", showorder=5), @DEDataQueryCodeExp(name="ITEMOBJ4", expression="t1.`ITEMOBJ4`", showorder=6), @DEDataQueryCodeExp(name="ITEMOBJ5", expression="t1.`ITEMOBJ5`", showorder=7), @DEDataQueryCodeExp(name="ITEMOBJ6", expression="t1.`ITEMOBJ6`", showorder=8), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=9), @DEDataQueryCodeExp(name="PSDELLTYPEID", expression="t1.`PSDELLTYPEID`", showorder=10), @DEDataQueryCodeExp(name="PSDELLTYPENAME", expression="t1.`PSDELLTYPENAME`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ICONPATH, t1.ITEMOBJ, t1.ITEMOBJ2, t1.ITEMOBJ3, t1.ITEMOBJ4, t1.ITEMOBJ5, t1.ITEMOBJ6, t1.MEMO, t1.PSDELLTYPEID, t1.PSDELLTYPENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDELLTYPE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="ICONPATH", expression="t1.ICONPATH", showorder=2), @DEDataQueryCodeExp(name="ITEMOBJ", expression="t1.ITEMOBJ", showorder=3), @DEDataQueryCodeExp(name="ITEMOBJ2", expression="t1.ITEMOBJ2", showorder=4), @DEDataQueryCodeExp(name="ITEMOBJ3", expression="t1.ITEMOBJ3", showorder=5), @DEDataQueryCodeExp(name="ITEMOBJ4", expression="t1.ITEMOBJ4", showorder=6), @DEDataQueryCodeExp(name="ITEMOBJ5", expression="t1.ITEMOBJ5", showorder=7), @DEDataQueryCodeExp(name="ITEMOBJ6", expression="t1.ITEMOBJ6", showorder=8), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=9), @DEDataQueryCodeExp(name="PSDELLTYPEID", expression="t1.PSDELLTYPEID", showorder=10), @DEDataQueryCodeExp(name="PSDELLTYPENAME", expression="t1.PSDELLTYPENAME", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13)}, conds={})})
public class PSDELLTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSDELLTypeDefaultDQModel() {
        this.initAnnotation(PSDELLTypeDefaultDQModel.class);
    }
}

