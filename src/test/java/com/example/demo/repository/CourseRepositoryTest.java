package com.example.demo.repository;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.JpaApplication;
import com.example.demo.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaApplication.class)
public class CourseRepositoryTest {

	@Autowired
	CourseRepository courseRepo;
	
	@Test
	public void test_findById_existingId() {
		Course course = courseRepo.findById(10001L);
		
		assertThat(course.getId(), is(10001L));
		
		assertThat(course.getName(), is("JPA Course"));
	}

	@Test
	public void test_findById_nonExistingId() {
		Course course = courseRepo.findById(10003L);
		
		assertNull(course);
		
		
	}
	
	@Test
	public void test_deleteById_nonExistingId() {
		
		assertThatThrownBy(() -> courseRepo.deleteById(10003L)).isInstanceOf(Exception.class);
	}
	
	@Test
	@DirtiesContext
	public void test_deleteById_existingId() {
		courseRepo.deleteById(10001L);
		Course course = courseRepo.findById(10003L);		
		assertNull(course);		
	}
	
	@Test
	public void test_save_new() {
		Course courseNew = new Course("Dance Course");
		Course courseSaved = courseRepo.save(courseNew);		
		assertThat(courseSaved.getId(), is(1L));
	}
	
	@Test
	@DirtiesContext
	public void test_save_duplicate() {
		Course courseNew = new Course("Dance Course");
		courseNew.setId(10001L);
		Course courseSaved = courseRepo.save(courseNew);		
		assertThat(courseSaved.getId(), is(10001L));
	}
	
}
