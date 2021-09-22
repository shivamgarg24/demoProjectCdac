package com.test.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "faculty")
@SequenceGenerator(name="id", initialValue=1, allocationSize=1)
@EntityListeners(AuditingEntityListener.class)
public class Faculty {

	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
	     private long id;

	    @Column(name = "first_name", nullable = false)
	    private String firstName;

	    @Column(name = "last_name", nullable = false)
	    private String lastName;

	    @Column(name = "email_address", nullable = false)
	    private String email;
	    
	    @Column(name = "pass_word", nullable = false)
	    private String password;
	    
	    @Column(name = "salary", nullable = false)
	    private Long salary;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPass() {
			return password;
		}

		public void setPass(String password) {
			this.password = password;
		}

		public Long getSalary() {
			return salary;
		}

		public void setSalary(Long salary) {
			this.salary = salary;
		}

		@Override
		public String toString() {
			return "Faculty [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
					+ ", password=" + password + ", salary=" + salary + "]";
		}

	    
}
