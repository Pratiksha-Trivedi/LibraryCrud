
package com.myproject.librarySys.repository;


import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.librarySys.Entity.Libraray1;

@Repository
public interface librarayRepository extends JpaRepository<Libraray1, Long> {

	

}
