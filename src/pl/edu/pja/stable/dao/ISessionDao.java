package pl.edu.pja.stable.dao;

import javax.transaction.Transaction;

/**
 * Created by artur.popek on 2017-06-16.
 */
public interface ISessionDao {

    public Transaction beginTransaction();

    public void close();

}
