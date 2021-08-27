package com.loongrise.dao;

import com.loongrise.entity.ChangeStatus;

public interface ChangeStatusDao {
    //pc端进行am history表增删改时将该值置为1
    int changeStatus();
}
