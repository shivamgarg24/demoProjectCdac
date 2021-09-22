package com.test.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "CourseCordinator")
//@SequenceGenerator(name="id", initialValue=1, allocationSize=1)
@EntityListeners(AuditingEntityListener.class)
public class Cc {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id")
	    private long id;

	    @Column(name = "first_name", nullable = false)
	    private String firstName;

	    @Column(name = "last_name", nullable = false)
	    private String lastName;

	    @Column(name = "pass_word", nullable = false)
	    private String password;

	    @Column(name = "email_address", nullable = false)
	    private String email;

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

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		@Override
		public String toString() {
			return "Cc [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
					+ ", email=" + email + "]";
		}

	    
}
