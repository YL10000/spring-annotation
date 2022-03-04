package com.life.spring.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Title: MathCalculator
 * @Description: 数学计算器
 * @Author: yanglin
 * @Date: 2022年03月04日 16:46
 * @Copyright: 2020 All Rights Reserved.北京西天取经科技有限公司
 */
@Component
public class MathCalculator {

    public int div(int i,int j){
        System.out.println("MathCalculator div...");
        return i/j;
    }
}
