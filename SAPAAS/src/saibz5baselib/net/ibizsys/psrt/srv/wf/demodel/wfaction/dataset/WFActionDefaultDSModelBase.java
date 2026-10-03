/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfaction.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="50811730d38a8bd964a31a05331bc214",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="6FA5FC43-842A-4744-89A6-3FFD49A54B9B",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class WFActionDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public WFActionDefaultDSModelBase() {
        super();

        this.initAnnotation(WFActionDefaultDSModelBase.class);
    }




}