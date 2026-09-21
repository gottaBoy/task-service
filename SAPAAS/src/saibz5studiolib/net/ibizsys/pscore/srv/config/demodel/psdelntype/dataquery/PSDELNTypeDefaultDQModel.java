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
package net.ibizsys.pscore.srv.config.demodel.psdelntype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="D691E59F-D76C-4422-B931-E088A2C21F9D", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CODENAME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ICONPATH`, t1.`ITEMOBJ`, t1.`ITEMOBJ2`, t1.`ITEMOBJ3`, t1.`ITEMOBJ4`, t1.`ITEMOBJ5`, t1.`ITEMOBJ6`, t1.`LOGICHOLDER`, t1.`LOGICTYPE`, t1.`MEMO`, t1.`ORDERVALUE`, t1.`PSDELNTYPEID`, t1.`PSDELNTYPENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSDELNTYPE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CODENAME", expression="t1.`CODENAME`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="ICONPATH", expression="t1.`ICONPATH`", showorder=3), @DEDataQueryCodeExp(name="ITEMOBJ", expression="t1.`ITEMOBJ`", showorder=4), @DEDataQueryCodeExp(name="ITEMOBJ2", expression="t1.`ITEMOBJ2`", showorder=5), @DEDataQueryCodeExp(name="ITEMOBJ3", expression="t1.`ITEMOBJ3`", showorder=6), @DEDataQueryCodeExp(name="ITEMOBJ4", expression="t1.`ITEMOBJ4`", showorder=7), @DEDataQueryCodeExp(name="ITEMOBJ5", expression="t1.`ITEMOBJ5`", showorder=8), @DEDataQueryCodeExp(name="ITEMOBJ6", expression="t1.`ITEMOBJ6`", showorder=9), @DEDataQueryCodeExp(name="LOGICHOLDER", expression="t1.`LOGICHOLDER`", showorder=10), @DEDataQueryCodeExp(name="LOGICTYPE", expression="t1.`LOGICTYPE`", showorder=11), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=12), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=13), @DEDataQueryCodeExp(name="PSDELNTYPEID", expression="t1.`PSDELNTYPEID`", showorder=14), @DEDataQueryCodeExp(name="PSDELNTYPENAME", expression="t1.`PSDELNTYPENAME`", showorder=15), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=16), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=17), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=18)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CODENAME, t1.CREATEDATE, t1.CREATEMAN, t1.ICONPATH, t1.ITEMOBJ, t1.ITEMOBJ2, t1.ITEMOBJ3, t1.ITEMOBJ4, t1.ITEMOBJ5, t1.ITEMOBJ6, t1.LOGICHOLDER, t1.LOGICTYPE, t1.MEMO, t1.ORDERVALUE, t1.PSDELNTYPEID, t1.PSDELNTYPENAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSDELNTYPE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CODENAME", expression="t1.CODENAME", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="ICONPATH", expression="t1.ICONPATH", showorder=3), @DEDataQueryCodeExp(name="ITEMOBJ", expression="t1.ITEMOBJ", showorder=4), @DEDataQueryCodeExp(name="ITEMOBJ2", expression="t1.ITEMOBJ2", showorder=5), @DEDataQueryCodeExp(name="ITEMOBJ3", expression="t1.ITEMOBJ3", showorder=6), @DEDataQueryCodeExp(name="ITEMOBJ4", expression="t1.ITEMOBJ4", showorder=7), @DEDataQueryCodeExp(name="ITEMOBJ5", expression="t1.ITEMOBJ5", showorder=8), @DEDataQueryCodeExp(name="ITEMOBJ6", expression="t1.ITEMOBJ6", showorder=9), @DEDataQueryCodeExp(name="LOGICHOLDER", expression="t1.LOGICHOLDER", showorder=10), @DEDataQueryCodeExp(name="LOGICTYPE", expression="t1.LOGICTYPE", showorder=11), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=12), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=13), @DEDataQueryCodeExp(name="PSDELNTYPEID", expression="t1.PSDELNTYPEID", showorder=14), @DEDataQueryCodeExp(name="PSDELNTYPENAME", expression="t1.PSDELNTYPENAME", showorder=15), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=16), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=17), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=18)}, conds={})})
public class PSDELNTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSDELNTypeDefaultDQModel() {
        this.initAnnotation(PSDELNTypeDefaultDQModel.class);
    }
}

