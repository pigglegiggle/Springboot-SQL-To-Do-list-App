// ไฟล์นี้เป็น service สำหรับการจัดการข้อมูล Todo โดยแยกการทำงานกับฐานข้อมูลออกจาก Controller

package com.example.todolist.service;

// นำเข้าโมเดล Todo และ repository TodoRepository เพื่อใช้งาน
import com.example.todolist.model.Todo;
import com.example.todolist.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// ใช้ @Service เพื่อบอกว่า TodoService เป็นบริการ (service) ที่จะถูกใช้งานใน Spring
// ตัวแปร todoRepository เป็นตัวแทนของ repository ที่ถูก inject เข้ามาโดย Spring (ใช้ constructor injection)
@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // เมธอด getAllTodos() ใช้ todoRepository.findAll() เพื่อดึงรายการทั้งหมดจากฐานข้อมูล
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    // เมธอด saveTodo(Todo todo) ใช้ todoRepository.save(todo) เพื่อบันทึกข้อมูล Todo ใหม่หรืออัปเดตข้อมูลเดิม
    public Todo saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    // เมธอด deleteTodoById(Long id) ใช้ todoRepository.deleteById(id) เพื่อลบรายการที่ตรงกับ id
    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }
}
