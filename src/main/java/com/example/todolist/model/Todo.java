// ไฟล์นี้เป็นโมเดลที่ใช้ในการสร้าง Todo entity ซึ่งแสดงถึงรายการสิ่งที่ต้องทำ

package com.example.todolist.model;

// นำเข้าไลบรารีที่ใช้สำหรับกำหนด Entity และการกำหนดค่า Id ที่ต้องใช้ใน JPA (Java Persistence API)
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// ใช้ @Entity เพื่อบอกว่า Todo เป็นคลาสที่ใช้สำหรับทำงานกับฐานข้อมูล
@Entity
public class Todo {
    
    @Id // ใช้ @Id เพื่อบอกว่าฟิลด์ id เป็น primary key ของ entity นี้
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ใช้ @GeneratedValue(strategy = GenerationType.IDENTITY) เพื่อให้ค่าของ id ถูกสร้างโดยอัตโนมัติ

    private Long id;
    private String title; // title เก็บชื่อหรือข้อความของสิ่งที่ต้องทำ
    private boolean completed; // completed เก็บสถานะว่าทำงานนี้เสร็จแล้วหรือยัง (ชนิดข้อมูล boolean)

    /*
     * เมธอด getId และ setId ใช้สำหรับการเข้าถึงและตั้งค่าของ id
     * เมธอด getTitle และ setTitle ใช้สำหรับการเข้าถึงและตั้งค่าของ title
     * เมธอด isCompleted และ setCompleted ใช้สำหรับการเข้าถึงและตั้งค่าของ completed
    */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
