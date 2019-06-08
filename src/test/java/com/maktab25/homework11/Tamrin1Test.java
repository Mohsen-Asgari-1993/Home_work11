package com.maktab25.homework11;

import com.maktab25.homework11.tamrin1.SecondMain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Tamrin1Test {

    @Test
    public void testInitMethod() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Class.forName("com.maktab25.homework11.tamrin1.SecondMain").getDeclaredMethod("initList");
        method.setAccessible(true);
        SecondMain main = new SecondMain();
        List list = (List) method.invoke(main);
        Assertions.assertEquals(99, list.size());
    }

    @Test
    public void testFilterMethod() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        SecondMain main = new SecondMain();
        Method filter = SecondMain.class.getDeclaredMethod("filterByNameAndBreedType", List.class);
        filter.setAccessible(true);
        Method init = SecondMain.class.getDeclaredMethod("initList");
        init.setAccessible(true);
        List list = (List) init.invoke(main);
        List list1 = (List) filter.invoke(main, list);
        Assertions.assertEquals(11, list1.size());


    }
}
