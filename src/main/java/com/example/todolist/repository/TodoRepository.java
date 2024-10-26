// ไฟล์นี้สร้าง repository interface สำหรับ Todo entity เพื่อใช้จัดการ CRUD กับฐานข้อมูล

package com.example.todolist.repository;

// นำเข้า Todo model และ JpaRepository ที่มาจาก Spring Data JPA ซึ่งจะทำให้เราไม่ต้องเขียน SQL เอง
import com.example.todolist.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {}

/*
 * ประกาศ TodoRepository เป็น interface ที่สืบทอด (extends) มาจาก JpaRepository
 * JpaRepository<Todo, Long> กำหนดให้ Todo เป็น entity ที่ต้องการจัดการ และ Long เป็นชนิดข้อมูลของ primary key
 */