package com.epiforum.common.ro;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CategoryRO {

	private Integer				id;

	private String				title;
	
	private String				description;
	
	private List<BoardRO>		boards;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the boards
	 */
	public List<BoardRO> getBoards() {
		return boards;
	}

	/**
	 * @param boards the boards to set
	 */
	public void setBoards(List<BoardRO> boards) {
		this.boards = boards;
	}
}
