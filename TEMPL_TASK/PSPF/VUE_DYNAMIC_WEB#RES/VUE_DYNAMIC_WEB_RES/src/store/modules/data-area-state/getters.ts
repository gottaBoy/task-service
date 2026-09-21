/**
 * 获取指定数据域状态对象
 * 
 * @param state 
 */
export const getDataAreaState = (state: any) => (tag: string) => {
    if (!tag || !state.stateData) {
        return undefined;
    }
    return state.stateData[tag];
}