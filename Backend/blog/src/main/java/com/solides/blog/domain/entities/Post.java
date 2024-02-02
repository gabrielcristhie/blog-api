package com.solides.blog.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Post implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "post_title", length = 100, nullable = false)
	private String postTitle;
	
	@Column(name = "post_content", length=2000)
	private String postContent;

	private String photo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date postCreatedDate;
	
	@ManyToOne
	@JoinColumn
	@NotNull(message = "O usuário deve ser inserido")
	private User user;
	
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	private Set<Comment> comments= new HashSet<>();

	public Post(){
		this.postCreatedDate = new Date();
	}
}
