package org.sample.se;

import java.util.List;

public interface BoardDAO {

	public Board getBoardItem(Board board);

	public List<Board> getBoardList(Board board);

	public void insertBoardItem(Board board);

	public void updateBoardItem(Board board);

	public void deleteBoardItem(Board board);

	public Integer countBoardList(Board board);
}
