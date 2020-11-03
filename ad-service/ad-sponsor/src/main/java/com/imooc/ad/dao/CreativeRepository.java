package com.imooc.ad.dao;

import com.imooc.ad.entity.Creative;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName CreativeRepository
 * @description:
 * @author: qsong
 * @create: 2020-11-03 17:27
 * @Version 1.0
 **/
public interface CreativeRepository extends JpaRepository<Creative, Long> {
}
