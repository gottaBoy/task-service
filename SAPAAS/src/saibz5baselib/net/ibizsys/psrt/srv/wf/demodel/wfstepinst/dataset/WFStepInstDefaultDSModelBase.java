/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfstepinst.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="707f76a538be385bf4bf65a2b1125003",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="C9AE1372-E208-4120-B0F0-ABD3B1869845",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class WFStepInstDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public WFStepInstDefaultDSModelBase() {
        super();

        this.initAnnotation(WFStepInstDefaultDSModelBase.class);
    }




}