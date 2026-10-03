/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfinstance.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="0211d06b901d7948d2394149b7d0d96e",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="DE8AB080-8956-418E-B7AA-6DD48BEBB703",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class WFInstanceDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public WFInstanceDefaultDSModelBase() {
        super();

        this.initAnnotation(WFInstanceDefaultDSModelBase.class);
    }




}