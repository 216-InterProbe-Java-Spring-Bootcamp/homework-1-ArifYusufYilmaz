package com.firstHomework.patikaFirstApp.customer.generic.service;

import com.firstHomework.patikaFirstApp.customer.dao.CustomerDao;
import com.firstHomework.patikaFirstApp.customer.entitiy.Customer;
import com.firstHomework.patikaFirstApp.customer.generic.entity.BaseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public abstract class BaseEntityService<E extends BaseEntity,D extends JpaRepository<E,Long>> {
    private final D dDao;

    public List<E> findAll(){
        return dDao.findAll();
    }
    public Optional<E> findById(Long id){
        return dDao.findById(id);
    }
    public E save(E entity){
        return dDao.save(entity);
    }
    public void deleteById(Long id){
        dDao.deleteById(id);
    }
    public void delete(E entity){
        dDao.delete(entity);
    }
    public boolean  isExist(Long id){
        return dDao.existsById(id);

    }
}
