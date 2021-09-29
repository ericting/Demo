package com.example.servlet_excise.dao.Impl;

import com.example.servlet_excise.dao.EmpDao;
import com.example.servlet_excise.entity.Emp;
import com.example.servlet_excise.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class EmpDaoImpl implements EmpDao {
    private QueryRunner queryRunner = new QueryRunner();

    @Override
    public List<Emp> selectAll() {
        try {
            List<Emp> emps = queryRunner.query(DbUtils.getConnection(), "select * from emp;", new BeanListHandler<Emp>(Emp.class));
            return emps;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int update(Emp emp) {
        try {
            int result = queryRunner.update(DbUtils.getConnection(), "update emp set name=?,salary=?,age=? where id=?;", emp.getName(), emp.getSalary(), emp.getAge(), emp.getId());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int id) {
        try {
            int result = queryRunner.update(DbUtils.getConnection(),"delete from emp where id=?;", id);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Emp select(int id) {
        try {
            Emp emp =queryRunner.query(DbUtils.getConnection(),"select * from emp where id=?;",new BeanHandler<Emp>(Emp.class),id);
            return emp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
