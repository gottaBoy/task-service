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
package net.ibizsys.pscore.srv.devcenter.demodel.psdcproduct.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="A148A75C-82F4-4E9D-A220-C4CFBFB50283", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PRODUCTSN`, t1.`PRODUCTSTATE`, t1.`PSDCPRODUCTID`, t1.`PSDCPRODUCTNAME`, t1.`PSDCPRODUCTTYPE`, t1.`PSDEVCENTERID`, t1.`PSDEVCENTERNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDCPRODUCT` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PRODUCTSN", expression="t1.`PRODUCTSN`", showorder=3), @DEDataQueryCodeExp(name="PRODUCTSTATE", expression="t1.`PRODUCTSTATE`", showorder=4), @DEDataQueryCodeExp(name="PSDCPRODUCTID", expression="t1.`PSDCPRODUCTID`", showorder=5), @DEDataQueryCodeExp(name="PSDCPRODUCTNAME", expression="t1.`PSDCPRODUCTNAME`", showorder=6), @DEDataQueryCodeExp(name="PSDCPRODUCTTYPE", expression="t1.`PSDCPRODUCTTYPE`", showorder=7), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.`PSDEVCENTERID`", showorder=8), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.`PSDEVCENTERNAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PRODUCTSN, t1.PRODUCTSTATE, t1.PSDCPRODUCTID, t1.PSDCPRODUCTNAME, t1.PSDCPRODUCTTYPE, t1.PSDEVCENTERID, t1.PSDEVCENTERNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDCPRODUCT t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PRODUCTSN", expression="t1.PRODUCTSN", showorder=3), @DEDataQueryCodeExp(name="PRODUCTSTATE", expression="t1.PRODUCTSTATE", showorder=4), @DEDataQueryCodeExp(name="PSDCPRODUCTID", expression="t1.PSDCPRODUCTID", showorder=5), @DEDataQueryCodeExp(name="PSDCPRODUCTNAME", expression="t1.PSDCPRODUCTNAME", showorder=6), @DEDataQueryCodeExp(name="PSDCPRODUCTTYPE", expression="t1.PSDCPRODUCTTYPE", showorder=7), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.PSDEVCENTERID", showorder=8), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.PSDEVCENTERNAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11)}, conds={})})
public class PSDCProductDefaultDQModel
extends DEDataQueryModelBase {
    public PSDCProductDefaultDQModel() {
        this.initAnnotation(PSDCProductDefaultDQModel.class);
    }
}

