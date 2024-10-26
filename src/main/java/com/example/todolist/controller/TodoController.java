// ควบคุมการร้องขอจากผู้ใช้และประสานงานกับ Service

package com.example.todolist.controller;

// นำเข้าโมเดล Todo, service TodoService, และไลบรารีที่ใช้สำหรับการทำงานของ Controller
import com.example.todolist.model.Todo;
import com.example.todolist.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// @Controller บอกว่า TodoController เป็นคลาสที่ใช้ในการจัดการคำขอ
// ตัวแปร todoService ถูก inject เพื่อใช้บริการการจัดการข้อมูล
@Controller
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // @GetMapping("/") กำหนดว่าเมื่อผู้ใช้เข้าหน้าหลัก (root URL) จะเรียกใช้เมธอด viewHomePage
    //ใช้ model.addAttribute("todos", todoService.getAllTodos()) เพื่อส่งรายการทั้งหมดไปยังหน้า index.html
    // สร้าง new Todo() สำหรับการเพิ่มข้อมูลใหม่
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("todos", todoService.getAllTodos()); 
        model.addAttribute("todo", new Todo()); 
        return "index";
    }

    // @PostMapping("/addTodo") กำหนด URL สำหรับการส่งข้อมูลรายการใหม่
    // ตรวจสอบว่า title ไม่เป็นค่าว่างและบันทึกข้อมูล
    // return "redirect:/"; รีไดเร็กต์กลับไปยังหน้าหลักหลังบันทึกข้อมูล
    @PostMapping("/addTodo")
    public String addTodo(@ModelAttribute("todo") Todo todo) {
        if (todo.getTitle() != null && !todo.getTitle().isEmpty()) {
            todoService.saveTodo(todo);
        }
        return "redirect:/";
    }

    // @GetMapping("/deleteTodo/{id}") กำหนด URL สำหรับการลบรายการ
    // @PathVariable("id") ใช้ดึงค่า id จาก URL เพื่อทำการลบ
    // return "redirect:/"; รีไดเร็กต์กลับไปยังหน้าหลักหลังลบข้อมูล
    @GetMapping("/deleteTodo/{id}")
    public String deleteTodoById(@PathVariable("id") Long id) {
        todoService.deleteTodoById(id);
        return "redirect:/";
    }
}
