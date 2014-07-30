package org.sample.se;

import java.util.Date;

import org.sample.se.Util.Pagination;

public class Board extends Pagination {

	private Integer seq;
	private String title;
	private String name;
	private String contents;
	private Date recodeDate;
	private Integer hit;
	private Integer author;
	private Integer boardNum;

	private String searchOption;
	private String searchInput;

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getRecodeDate() {
		return recodeDate;
	}

	public void setRecodeDate(Date recodeDate) {
		this.recodeDate = recodeDate;
	}

	public Integer getHit() {
		return hit;
	}

	public void setHit(Integer hit) {
		this.hit = hit;
	}

	public String getSearchOption() {
		return searchOption;
	}

	public void setSearchOption(String searchOption) {
		this.searchOption = searchOption;
	}

	public String getSearchInput() {
		return searchInput;
	}

	public void setSearchInput(String searchInput) {
		this.searchInput = searchInput;
	}

	public Integer getAuthor() {
		return author;
	}

	public void setAuthor(Integer author) {
		this.author = author;
	}

	public Integer getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(Integer boardNum) {
		this.boardNum = boardNum;
	}

	@Override
	public String toString() {
		return "Board [seq=" + seq + ", title=" + title + ", name=" + name + ", contents=" + contents + ", recodeDate=" + recodeDate + ", hit=" + hit
				+ ", author=" + author + ", boardNum=" + boardNum + ", searchOption=" + searchOption + ", searchInput=" + searchInput + "]";
	}

}
