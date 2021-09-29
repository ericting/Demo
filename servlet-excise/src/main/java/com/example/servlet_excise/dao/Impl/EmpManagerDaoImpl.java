package com.example.servlet_excise.dao.Impl;

import com.example.servlet_excise.dao.EmpManagerDao;
import com.example.servlet_excise.entity.EmpManager;
import com.example.servlet_excise.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class EmpManagerDaoImpl implements EmpManagerDao {
    private QueryRunner queryRunner=new QueryRunner();
    @Override
    public EmpManager select(String username) {
        try {
            EmpManager empManager=queryRunner.query(DbUtils.getConnection(),"select * from EmpManager where username=?;",new BeanHandler<EmpManager>(EmpManager.class),username);
            return empManager;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
