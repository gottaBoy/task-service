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
package net.ibizsys.pscore.srv.config.demodel.psdellcondtype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="62A52516-1008-424C-85F6-DA5F64836C2D", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ITEMOBJ`, t1.`ITEMOBJ2`, t1.`ITEMOBJ3`, t1.`ITEMOBJ4`, t1.`ITEMOBJ5`, t1.`ITEMOBJ6`, t1.`MEMO`, t1.`PSDELLCONDTYPEID`, t1.`PSDELLCONDTYPENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDELLCONDTYPE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="ITEMOBJ", expression="t1.`ITEMOBJ`", showorder=2), @DEDataQueryCodeExp(name="ITEMOBJ2", expression="t1.`ITEMOBJ2`", showorder=3), @DEDataQueryCodeExp(name="ITEMOBJ3", expression="t1.`ITEMOBJ3`", showorder=4), @DEDataQueryCodeExp(name="ITEMOBJ4", expression="t1.`ITEMOBJ4`", showorder=5), @DEDataQueryCodeExp(name="ITEMOBJ5", expression="t1.`ITEMOBJ5`", showorder=6), @DEDataQueryCodeExp(name="ITEMOBJ6", expression="t1.`ITEMOBJ6`", showorder=7), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=8), @DEDataQueryCodeExp(name="PSDELLCONDTYPEID", expression="t1.`PSDELLCONDTYPEID`", showorder=9), @DEDataQueryCodeExp(name="PSDELLCONDTYPENAME", expression="t1.`PSDELLCONDTYPENAME`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ITEMOBJ, t1.ITEMOBJ2, t1.ITEMOBJ3, t1.ITEMOBJ4, t1.ITEMOBJ5, t1.ITEMOBJ6, t1.MEMO, t1.PSDELLCONDTYPEID, t1.PSDELLCONDTYPENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDELLCONDTYPE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="ITEMOBJ", expression="t1.ITEMOBJ", showorder=2), @DEDataQueryCodeExp(name="ITEMOBJ2", expression="t1.ITEMOBJ2", showorder=3), @DEDataQueryCodeExp(name="ITEMOBJ3", expression="t1.ITEMOBJ3", showorder=4), @DEDataQueryCodeExp(name="ITEMOBJ4", expression="t1.ITEMOBJ4", showorder=5), @DEDataQueryCodeExp(name="ITEMOBJ5", expression="t1.ITEMOBJ5", showorder=6), @DEDataQueryCodeExp(name="ITEMOBJ6", expression="t1.ITEMOBJ6", showorder=7), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=8), @DEDataQueryCodeExp(name="PSDELLCONDTYPEID", expression="t1.PSDELLCONDTYPEID", showorder=9), @DEDataQueryCodeExp(name="PSDELLCONDTYPENAME", expression="t1.PSDELLCONDTYPENAME", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12)}, conds={})})
public class PSDELLCondTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSDELLCondTypeDefaultDQModel() {
        this.initAnnotation(PSDELLCondTypeDefaultDQModel.class);
    }
}

