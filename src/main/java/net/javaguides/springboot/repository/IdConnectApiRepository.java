package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.entity.IdConnectApi;

@Repository
public interface IdConnectApiRepository extends JpaRepository<IdConnectApi,Long> {

}
