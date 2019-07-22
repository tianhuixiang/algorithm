package com.tianhuixiang.algorithm.quque;

public interface QQueue<E> {

    /**
    * @Description 判断队列是否为空，为空则返回true，不为空则返回false
    * @author      tianhuixiang
    * @param
    * @return
    * @exception
    * @date        2019/6/4 15:22
    */
    boolean isEmpty();


    /**
    * @Description 入队，从队尾入队
    * @author      tianhuixiang
    * @param
    * @return
    * @exception
    * @date        2019/6/4 15:22
    */
    boolean enQueue(E element);

    /**
    * @Description 出队，从队头出队
    * @author      tianhuixiang
    * @param
    * @return
    * @exception
    * @date        2019/6/4 15:23
    */
    E deQueque();

}
