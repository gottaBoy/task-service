/**
 * 设置指定数据域状态对象
 * 
 * @param tag 
 * @param { tag, value }: { tag: string,value: any }
 */
 export const setDataAreaState = (state: any, { tag, value }: { tag: string, value: any }) => {
    state.stateData[tag] = value;
}

/**
 * 清除指定数据域状态对象
 * 
 * @param tag 
 */
export const clearDataAreaState = (state: any, tag: string) => {
    if (!state.stateData[tag]) {
        return;
    }
    delete state.stateData[tag];
}