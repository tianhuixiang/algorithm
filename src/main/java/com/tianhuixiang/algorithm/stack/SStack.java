package com.tianhuixiang.algorithm.stack;

public interface SStack<E> {

    /**
    * @Description 判断栈是否为空
    * @author      tianhuixiang
    * @param
    * @return
    * @exception
    * @date        2019/6/3 16:10
    */
    boolean isEmpty();

    /**
    * @Description 入栈
    * @author      tianhuixiang
    * @param
    * @return
    * @exception
    * @date        2019/6/3 16:10
    */
    boolean push(E element);

    /**
    * @Description 出栈
    * @author      tianhuixiang
    * @param
    * @return
    * @exception
    * @date        2019/6/3 16:11
    */
    E pop();

    /**
    * @Description 取栈顶元素，空栈则返回为null
    * @author      tianhuixiang
    * @param
    * @return
    * @exception
    * @date        2019/6/3 16:11
    */
    E get();
}
