package com.example.servlet_excise.service;

import com.example.servlet_excise.entity.Emp;

import java.util.List;

public interface EmpService {
    public List<Emp> showAllEmp();
    public int removeEmp(int id);
    public int modify(Emp emp);
    public Emp showEmp(int id);
}
