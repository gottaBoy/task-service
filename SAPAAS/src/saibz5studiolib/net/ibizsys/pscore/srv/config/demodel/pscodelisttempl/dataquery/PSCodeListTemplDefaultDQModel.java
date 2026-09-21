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
package net.ibizsys.pscore.srv.config.demodel.pscodelisttempl.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="3CC9460B-C67F-41FC-970F-CC8A05EF0B26", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CLPATH`, t1.`CODENAME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`EMPTYTEXT`, t1.`EMPTYTEXTPSSYSLANRESID`, t1.`EMPTYTEXTPSSYSLANRESNAME`, t1.`MEMO`, t1.`NOVALUEEMPTY`, t1.`NUMBERITEM`, t1.`ORMODE`, t1.`PREDEFINEDTYPE`, t1.`PSCODELISTTEMPLID`, t1.`PSCODELISTTEMPLNAME`, t1.`SEPERATOR`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALUESEPERATOR` FROM `T_SRFPSCODELISTTEMPL` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CLMODEL", expression="t1.`CLMODEL`", showorder=-1), @DEDataQueryCodeExp(name="CLPARAM", expression="t1.`CLPARAM`", showorder=-1), @DEDataQueryCodeExp(name="CLPATH", expression="t1.`CLPATH`", showorder=0), @DEDataQueryCodeExp(name="CODENAME", expression="t1.`CODENAME`", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=3), @DEDataQueryCodeExp(name="EMPTYTEXT", expression="t1.`EMPTYTEXT`", showorder=4), @DEDataQueryCodeExp(name="EMPTYTEXTPSSYSLANRESID", expression="t1.`EMPTYTEXTPSSYSLANRESID`", showorder=5), @DEDataQueryCodeExp(name="EMPTYTEXTPSSYSLANRESNAME", expression="t1.`EMPTYTEXTPSSYSLANRESNAME`", showorder=6), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=7), @DEDataQueryCodeExp(name="NOVALUEEMPTY", expression="t1.`NOVALUEEMPTY`", showorder=8), @DEDataQueryCodeExp(name="NUMBERITEM", expression="t1.`NUMBERITEM`", showorder=9), @DEDataQueryCodeExp(name="ORMODE", expression="t1.`ORMODE`", showorder=10), @DEDataQueryCodeExp(name="PREDEFINEDTYPE", expression="t1.`PREDEFINEDTYPE`", showorder=11), @DEDataQueryCodeExp(name="PSCODELISTTEMPLID", expression="t1.`PSCODELISTTEMPLID`", showorder=12), @DEDataQueryCodeExp(name="PSCODELISTTEMPLNAME", expression="t1.`PSCODELISTTEMPLNAME`", showorder=13), @DEDataQueryCodeExp(name="SEPERATOR", expression="t1.`SEPERATOR`", showorder=14), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=15), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=16), @DEDataQueryCodeExp(name="VALUESEPERATOR", expression="t1.`VALUESEPERATOR`", showorder=17)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CLPATH, t1.CODENAME, t1.CREATEDATE, t1.CREATEMAN, t1.EMPTYTEXT, t1.EMPTYTEXTPSSYSLANRESID, t1.EMPTYTEXTPSSYSLANRESNAME, t1.MEMO, t1.NOVALUEEMPTY, t1.NUMBERITEM, t1.ORMODE, t1.PREDEFINEDTYPE, t1.PSCODELISTTEMPLID, t1.PSCODELISTTEMPLNAME, t1.SEPERATOR, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALUESEPERATOR FROM T_SRFPSCODELISTTEMPL t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CLMODEL", expression="t1.CLMODEL", showorder=-1), @DEDataQueryCodeExp(name="CLPARAM", expression="t1.CLPARAM", showorder=-1), @DEDataQueryCodeExp(name="CLPATH", expression="t1.CLPATH", showorder=0), @DEDataQueryCodeExp(name="CODENAME", expression="t1.CODENAME", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=3), @DEDataQueryCodeExp(name="EMPTYTEXT", expression="t1.EMPTYTEXT", showorder=4), @DEDataQueryCodeExp(name="EMPTYTEXTPSSYSLANRESID", expression="t1.EMPTYTEXTPSSYSLANRESID", showorder=5), @DEDataQueryCodeExp(name="EMPTYTEXTPSSYSLANRESNAME", expression="t1.EMPTYTEXTPSSYSLANRESNAME", showorder=6), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=7), @DEDataQueryCodeExp(name="NOVALUEEMPTY", expression="t1.NOVALUEEMPTY", showorder=8), @DEDataQueryCodeExp(name="NUMBERITEM", expression="t1.NUMBERITEM", showorder=9), @DEDataQueryCodeExp(name="ORMODE", expression="t1.ORMODE", showorder=10), @DEDataQueryCodeExp(name="PREDEFINEDTYPE", expression="t1.PREDEFINEDTYPE", showorder=11), @DEDataQueryCodeExp(name="PSCODELISTTEMPLID", expression="t1.PSCODELISTTEMPLID", showorder=12), @DEDataQueryCodeExp(name="PSCODELISTTEMPLNAME", expression="t1.PSCODELISTTEMPLNAME", showorder=13), @DEDataQueryCodeExp(name="SEPERATOR", expression="t1.SEPERATOR", showorder=14), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=15), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=16), @DEDataQueryCodeExp(name="VALUESEPERATOR", expression="t1.VALUESEPERATOR", showorder=17)}, conds={})})
public class PSCodeListTemplDefaultDQModel
extends DEDataQueryModelBase {
    public PSCodeListTemplDefaultDQModel() {
        this.initAnnotation(PSCodeListTemplDefaultDQModel.class);
    }
}

