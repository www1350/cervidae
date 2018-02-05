package com.absurd.cervidae.utils;

import org.junit.Test;

/**
 * @author wangwenwei
 * @time 2018/2/5
 */
public class Base62UtilsTest {
    @Test
    public void toBase10(){
        System.out.println(Base62Util.toBase10("bM"));
    }

    @Test
    public void toBase62(){
        System.out.println(Base62Util.fromBase10(100L));
    }
}
