package com.example.servlet_excise.service.Impl;

import com.example.servlet_excise.dao.EmpDao;
import com.example.servlet_excise.dao.Impl.EmpDaoImpl;
import com.example.servlet_excise.entity.Emp;
import com.example.servlet_excise.service.EmpService;
import com.example.servlet_excise.utils.DbUtils;

import java.util.List;

public class EmpServiceImpl implements EmpService {
    @Override
    public List<Emp> showAllEmp() {
        List<Emp> emps=null;
        try {
            DbUtils.begin();
            EmpDao empDao= new EmpDaoImpl();
            emps = empDao.selectAll();
            DbUtils.commit();
        }catch (Exception e){
            DbUtils.rollback();
            e.printStackTrace();
        }
        return emps;
    }

    @Override
    public int removeEmp(int id) {
        int result=0;
        try {
            DbUtils.begin();
            EmpDao empDao = new EmpDaoImpl();
            result = empDao.delete(id);
            DbUtils.commit();
        }catch (Exception e){
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int modify(Emp emp) {
        int result=0;
        try {
            DbUtils.begin();
            EmpDao empDao = new EmpDaoImpl();
            result=empDao.update(emp);
            DbUtils.commit();
        }catch (Exception e){
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Emp showEmp(int id) {
        Emp emp =null;
        try {
            DbUtils.begin();
            EmpDao empDao = new EmpDaoImpl();
            emp = empDao.select(id);
            DbUtils.commit();
        }catch (Exception e){
            DbUtils.rollback();
            e.printStackTrace();
        }
        return emp;
    }
}
