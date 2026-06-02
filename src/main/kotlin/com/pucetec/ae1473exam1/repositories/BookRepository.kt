package com.pucetec.ae1473exam1.repositories

import com.pucetec.ae1473exam1.entities.Book
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<Book, Long>