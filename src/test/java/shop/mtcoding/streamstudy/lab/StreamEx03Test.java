package shop.mtcoding.streamstudy.lab;

import org.junit.jupiter.api.Test;
import shop.mtcoding.streamstudy.board.Board;
import shop.mtcoding.streamstudy.board.BoardDetailDTO;
import shop.mtcoding.streamstudy.board.BoardListDTO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamEx03Test {

    @Test
    public void ex02() {
        // Builder를 사용하여 board 생성
        Board b1 = Board.builder()
                .id(1)
                .title("제목1")
                .content("내용1")
                .author("ssar")
                .build();

        Board b2 = Board.builder()
                .id(2)
                .title("제목2")
                .content("내용2")
                .author("ssar")
                .build();

        Board b3 = Board.builder()
                .id(3)
                .title("제목3")
                .content("내용3")
                .author("cos")
                .build();

        // 배열에 board를 담는다.
        List<Board> boardList = Arrays.asList(b1, b2, b3);
        // boardList의 모든 값을 DTO로 옮긴다. (깊은 복사)
        List<BoardListDTO> responseDTOs = boardList.stream() // 생성
                .filter(board -> !board.getAuthor().equals("cos")) // 가공(필터링)
                .filter(board -> !board.getContent().contains("1")) // 가공(필터링)
                .map(board -> new BoardListDTO(board)) // 가공(변환)0ㅐ
                // .map(BoardListDTO::new) // 위의 내용과 동일
                .collect(Collectors.toList()); // 수집

        System.out.println(responseDTOs);
    }

    @Test
    public void ex01() {
        // Builder를 사용하여 board 생성
        Board board = Board.builder()
                .id(1)
                .title("제목1")
                .content("내용1")
                .author("ssar")
                .build();

        // DTO에 board 엔티티의 내용을 옮겨담는다(깊은 복사)
        BoardDetailDTO responseDTO = new BoardDetailDTO(board);
        // 복사한 내용을 출력
        System.out.println(responseDTO);
    }
}
