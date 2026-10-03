/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.tssdpolicy.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="0af0cc46519139106341b4cbfe9b89e7",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="39BEF198-DED9-4539-AEFE-8DC349BFF20E",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class TSSDPolicyDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public TSSDPolicyDefaultDSModelBase() {
        super();

        this.initAnnotation(TSSDPolicyDefaultDSModelBase.class);
    }




}