package sba.sms.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Course is a POJO, configured as a persistent class that represents (or maps to) a table
 * name 'course' in the database. A Course object contains fields that represent course
 * information and a mapping of 'cours`es' that indicate an inverse or referencing side
 * of the relationship. Implement Lombok annotations to eliminate boilerplate code.
 */
@NoArgsConstructor
@AllArgsConstructor


@Setter
@Getter
@Entity

public class Course {

    // Getter Setter methods
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "instructor", length = 50, nullable = false)
    private String instructor;

    @ManyToMany(mappedBy = "courses", fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.REMOVE, CascadeType.MERGE, CascadeType.PERSIST})
    private Set<Student> students = new HashSet<>();

    // Required-args constructor
    public Course(String name, String instructor){
        this.name = name;
        this.instructor = instructor;
    }

    // toString method
    @Override
    public String toString(){
        return "Course{" + "id=" + id + ", name=" + name + "\\" + ", instructor=" + instructor + "\\" + "}";
    }


    // hash code method
    @Override
    public int hashCode(){
        return Objects.hash(id, name ,instructor);
    }

    //Helper method
    public boolean hasStudent(Student student){
        return this.students.contains(student);
    }



}

