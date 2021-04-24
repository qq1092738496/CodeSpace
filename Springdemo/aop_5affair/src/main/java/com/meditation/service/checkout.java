package com.meditation.service;

import com.meditation.dao.bookdao;
import com.sun.tracing.dtrace.Attributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @description:
 * @author: Andy
 * @time: 2020/7/10 20:22
 */
@Service
public class checkout {


    /**
     * @Transational 方法注解的参数:
     * isolation :事务的隔离级别;
     *      数据库的隔离级别:
     * 由于并发操作带来的数据不一致性
     * 如果没有锁定且多个用户同时访问一个数据库，则当他们的事务同时使用相同的数据时可能会发生问题。由于并发操作带来的数据不一致性包括：丢失数据更新、读“脏”数据（脏读）、不可重复读。
     * @Transactional(isolation = Isolation.READ_UNCOMMITTED)：读取未提交数据(会出现脏读, 不可重复读) 基本不使用。
     * @Transactional(isolation = Isolation.READ_COMMITTED)：读取已提交数据(会出现不可重复读和幻读)
     * 大多数主流数据库的默认事务等级，保证了一个事务不会读到另一个并行事务已修改但未提交的数据，避免了“脏读取”。该级别适用于大多数系统。
     * @Transactional(isolation = Isolation.REPEATABLE_READ)：可重复读(会出现幻读)
     * ，保证了一个事务不会修改已经由另一个事务读取但未提交（回滚）的数据。避免了“脏读取”和“不可重复读取”的情况，但是带来了更多的性能损失。
     * @Transactional(isolation = Isolation.SERIALIZABLE)：最严格的级别，事务串行执行，资源消耗最大；
     * （1）更新丢失
     * 两个事务都同时更新一行数据，一个事务对数据的更新把另一个事务对数据的更新覆盖了。这是因为系统没有执行任何的锁操作，因此并发并没有被隔离开来。
     * （2）脏读
     * 一个事务读取到了另一事务未提交的数据操作结果。这是相当危险的，因为很可能所有的操作都被回滚。
     * （3）不可重复读
     * 不可重复读（Non-repeatable Reads）：一个事务对同一行数据重复读取两次，但是却得到了不同的结果。
     * 包括以下情况：
     * 虚读：事务T1读取某一数据后，事务T2对其做了修改，当事务T1再次读取该数据时得到与前一次不同的值。
     * 幻读：事务在操作过程中进行两次查询，第二次查询的结果包含了第一次查询中未出现的数据或者缺少了第一次查询中出现的数据。这是因为在两次查询过程中有另外一个事务插入数据造成的。
     *
     *
     * propagation :事务的传播行为;
     *
     * 异常分类:
     *      运行时异常(非检查异常):代码运行之中的异常,可以不用处理;
     *                默认回滚;
     *      编译时异常(检查异常):要么try-catch,要么在方法上声明throws;
     *                默认不回滚;
     * 事务的回滚: 默认发生运行时异常都会回滚,发生编译时异常不会回滚;
     * norollbackfor :设置那些异常可以不回滚,包括原来回滚的异常,运行时异常;
     * norollbackforClassName :异常全类名;
     * Transactional(noRollbackFor = {ArithmeticException.class,NullPointerException.class})
     *
     * rollbackfor :指定哪些异常回滚,包括原来不回滚的异常,编译时异常,如果异常被捕捉,那么还是该异常还是不回滚;
     * rollbackforClassName:异常全类名;
     *  @Transactional(noRollbackFor = {ArithmeticException.class,NullPointerException.class},rollbackFor = {FileNotFoundException.class})
     *
     * @readOnly :调整事务只读事务, 事务期间,只查,不增删改,提高事务的执行的速度, 事务管理器会在内部优化,如果目标方法中有增删改则会报错; timeout-int
     * @timeout :超时,事务超出指定时常后,自动终止并回滚;
     */

    @Autowired
    bookdao bookdao;


    public void payments(String userName, String isbn) {
        // 查询书价
        int getprice = bookdao.getprice(isbn);
        // 减去账户余额
        bookdao.updatebalance(userName, getprice);
        // 减少库存
        bookdao.updatestock(isbn);
        System.out.println("结账完成!");
        int i =10/0;
    }


    public void modifybookbalance(String isbn,double price){
        //减少图书的价格
        bookdao.updateBookprice(isbn,price);
        System.out.println("修改完成");

    }
}
